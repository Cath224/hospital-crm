
alter table hospital_crm.patient_visit
add column if not exists branch_id uuid not null references hospital_crm.branch(id) on delete cascade;

create index if not exists person_phone_number on hospital_crm.person using btree (phone);

alter table hospital_crm.doctor_experience
    add column if not exists number_of_patients bigint not null default 0;

drop function if exists doctor_experience_number_of_patients_function cascade;

create function doctor_experience_number_of_patients_function() RETURNS trigger
    language plpgsql
as
$$
BEGIN
    execute format('update hospital_crm.doctor_experience set number_of_patients = number_of_patients + 1 WHERE doctor_id = ''%s'' and branch_id = ''%s''', new.doctor_id, new.branch_id);
    return new;
END
$$;


drop trigger if exists doctor_experience_number_of_patients_trigger on hospital_crm.patient_visit;

create trigger doctor_experience_number_of_patients_trigger
    after insert
    on hospital_crm.patient_visit
    for each row
execute function doctor_experience_number_of_patients_function();