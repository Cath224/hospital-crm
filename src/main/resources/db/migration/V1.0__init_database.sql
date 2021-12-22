create schema if not exists hospital_crm;

create table if not exists hospital_crm.branch
(
    id   uuid default gen_random_uuid() not null
        constraint branch_pk
            primary key,
    name text
);


create unique index if not exists branch_name_uindex
    on hospital_crm.branch (name);

create table if not exists hospital_crm.office
(
    id     uuid default gen_random_uuid() not null
        constraint office_pk
            primary key,
    name   text,
    number integer                        not null
);


create unique index if not exists office_number_uindex
    on hospital_crm.office (number);

drop type if exists hospital_crm.sex cascade;
create type hospital_crm.sex as enum ('M', 'F');

create table if not exists hospital_crm.person
(
    first_name text,
    last_name  text,
    birthday   date not null,
    phone text,
    sex   hospital_crm.sex not null default 'M'
);


create table if not exists hospital_crm.doctor
(
    id         uuid default gen_random_uuid() not null
        constraint doctor_pk
            primary key,
    first_name text                           not null,
    last_name  text                           not null,
    office_id  uuid                           not null
        constraint doctor_office_id_fk
            references hospital_crm.office
            on update cascade on delete set null
)
    inherits (hospital_crm.person);

create index if not exists doctor_office_id_index
    on hospital_crm.doctor (office_id);

create table if not exists hospital_crm.doctor_experience
(
    doctor_id             uuid not null
        constraint doctor_experience_doctor_id_fk
            references hospital_crm.doctor on delete cascade,
    branch_id             uuid not null
        constraint doctor_experience_branch_id_fk
            references hospital_crm.branch on delete cascade,
    start_practicing_date date not null,
    constraint doctor_experience_pk
        primary key (doctor_id, branch_id)
);



create table if not exists hospital_crm.patient
(
    id uuid not null
        constraint patient_pk
            primary key
)
    inherits (hospital_crm.person);


create table if not exists hospital_crm.patient_visit
(
    doctor_id        uuid                     not null references doctor(id) on delete cascade,
    patient_id       uuid                     not null references patient(id) on delete cascade,
    actual_timestamp timestamp with time zone not null,
    id               uuid                     not null
        constraint patient_visit_pk
            primary key,
    planed_timestamp timestamp with time zone not null
);


create index if not exists patient_visit_doctor_id
    on hospital_crm.patient_visit (doctor_id desc);

create index if not exists patient_visit_patient_id
    on hospital_crm.patient_visit (patient_id desc);

create index if not exists patient_visit_planed_timestamp_index
    on hospital_crm.patient_visit (planed_timestamp desc);

create table if not exists hospital_crm.medication
(
    id                uuid              not null
        constraint medication_pk
            primary key,
    branch_id         uuid              not null
        constraint medication_branch_id_fk
            references hospital_crm.branch
            on update cascade on delete set null,
    name              text              not null,
    description       text,
    serial_number     text              not null,
    indications       text,
    contraindications text,
    number            integer default 0 not null
);

create index if not exists medication_branch_id_index
    on hospital_crm.medication (branch_id);

create unique index if not exists medication_name_uindex
    on hospital_crm.medication (name);

create unique index if not exists medication_serial_number_uindex
    on hospital_crm.medication (serial_number);

create table if not exists hospital_crm.diagnosis
(
    id               uuid not null
        constraint diagnosis_pk
            primary key,
    description      text not null,
    patient_visit_id uuid not null
        constraint diagnosis_patient_visit_id_fk
            references hospital_crm.patient_visit
            on update cascade on delete cascade
);


create index if not exists diagnosis_patient_visit_id_index
    on hospital_crm.diagnosis (patient_visit_id);

create table if not exists hospital_crm.diagnosis_medicine
(
    diagnosis_id uuid              not null
        constraint diagnosis_medicine_diagnosis_id_fk
            references hospital_crm.diagnosis
            on update cascade on delete cascade,
    medicine_id  uuid              not null
        constraint diagnosis_medicine_medication_id_fk
            references hospital_crm.medication
            on update cascade on delete cascade,
    number       integer default 0 not null,
    description  text,
    constraint diagnosis_medicine_pk
        primary key (diagnosis_id, medicine_id)
);
