insert into hospital_crm.office (name, number) VALUES ('Main Hospital Office', 200) ON CONFLICT DO NOTHING;
insert into hospital_crm.office (name, number) VALUES ('Gastroenterology Office', 100) ON CONFLICT DO NOTHING;
insert into hospital_crm.office (name, number) VALUES ('Cardiology Office', 101) ON CONFLICT DO NOTHING;
insert into hospital_crm.office (name, number) VALUES ('Neuralgia Office', 102) ON CONFLICT DO NOTHING;
insert into hospital_crm.office (name, number) VALUES ('Dentistry Office', 103) ON CONFLICT DO NOTHING;

insert into hospital_crm.branch (name) VALUES ('Gastroenterology') ON CONFLICT DO NOTHING;
insert into hospital_crm.branch (name) VALUES ('Cardiology') ON CONFLICT DO NOTHING;
insert into hospital_crm.branch (name) VALUES ('Neuralgia') ON CONFLICT DO NOTHING;
insert into hospital_crm.branch (name) VALUES ('Dentistry') ON CONFLICT DO NOTHING;