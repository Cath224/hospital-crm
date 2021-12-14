alter table hospital_crm.patient_visit alter column id set default gen_random_uuid();
alter table hospital_crm.patient alter column id set default gen_random_uuid();
alter table hospital_crm.diagnosis alter column id set default gen_random_uuid();
alter table hospital_crm.medication alter column id set default gen_random_uuid();