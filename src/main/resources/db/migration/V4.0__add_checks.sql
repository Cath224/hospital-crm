alter table hospital_crm.diagnosis_medicine add check ( number >= 0 );
alter table hospital_crm.doctor_experience add check ( number_of_patients >= 0 );
alter table hospital_crm.medication add check ( number >= 0 );
alter table hospital_crm.office add check ( number >= 0 );
