drop type if exists hospital_crm.sex;
create type hospital_crm.sex as enum ('M', 'F');

alter table hospital_crm.person
    add column phone text,
    add column sex   hospital_crm.sex not null default 'M';

create index person_phone_number on hospital_crm.person using btree (phone);


alter table hospital_crm.doctor_experience
    add column number_of_patients bigint not null default 0;

drop function if exists doctor_experience_number_of_patients_function;

create function doctor_experience_number_of_patients_function() RETURNS trigger
    language plpgsql
as
$$
declare
    name           text        := (select (first_name || '_' || doctor.last_name)
                                   from hospital_crm.doctor
                                   where id = new.doctor_id);
    sequence_name  varchar(32) := MD5('id_' || replace(new.id::varchar, '-', '_') || '_name_' ||
                                      name);
    next_val_query text        := 'nextval("doctor_experience_number_of_patients_seq_"' || sequence_name || ')';
BEGIN
    execute format('create sequence if not exists doctor_experience_number_of_patients_seq_%s', sequence_name);
    execute format('update doctor_experience set number_of_patients' || next_val_query);
    return new;
END
$$;

drop function if exists doctor_experience_number_of_patients_remove_function;

create function doctor_experience_number_of_patients_remove_function() RETURNS trigger
    language plpgsql
as
$$
declare
    name          text        := (select (first_name || '_' || doctor.last_name)
                                  from hospital_crm.doctor
                                  where id = new.doctor_id);
    sequence_name varchar(32) := MD5('id_' || replace(new.doctor_id::varchar, '-', '_') || '_name_' ||
                                     name);
BEGIN
    execute format('drop sequence if exists doctor_experience_number_of_patients_seq_%s', sequence_name);
    return new;
END
$$;

drop trigger if exists doctor_experience_number_of_patients_trigger on hospital_crm.patient_visit;

create trigger doctor_experience_number_of_patients_trigger
    after insert
    on hospital_crm.patient_visit
execute procedure doctor_experience_number_of_patients_function();

drop trigger if exists doctor_experience_number_of_patients__doctor_remove_trigger on hospital_crm.patient_visit;

create trigger doctor_experience_number_of_patients__doctor_remove_trigger
    after delete
    on hospital_crm.doctor_experience
execute procedure doctor_experience_number_of_patients_remove_function();