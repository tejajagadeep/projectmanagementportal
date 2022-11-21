
insert into User_Emp(user_name, name, email_address, contact_no, date_of_birth, role, password)
 values('rajini', 'Rajini', 'rajini@gmail.com', 8794561231, '1968-08-01', 'Admin', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm');
insert into User_Emp( user_name, name, email_address, contact_no, date_of_birth, role, password)
 values('vinay', 'Vinay', 'vinay@gmail.com', 8794561232, '1987-12-19', 'Admin', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm');
insert into User_Emp(user_name, name, email_address, contact_no, date_of_birth, role, password)
 values('ramesh', 'Ramesh', 'ramesh@gmail.com', 8794561233, '1997-10-19', 'Admin', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm');
insert into User_Emp( user_name, name, email_address, contact_no, date_of_birth, role, password)
 values('harish', 'Harish', 'harish@gmail.com', 8794561234, '1981-12-19', 'Admin', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm');
insert into User_Emp(user_name, name, email_address, contact_no, date_of_birth, role, password)
 values('krishna', 'Hari Krishna', 'harikrishna@gmail.com', 8794561236, '1987-01-19', 'Admin', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm');
insert into User_Emp(user_name, name, email_address, contact_no, date_of_birth, role, password)
 values('ramraju', 'Ram', 'ram@gmail.com', 8794561239, '1977-06-19', 'Admin', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm');
insert into User_Emp(user_name, name, email_address, contact_no, date_of_birth, role, password)
 values('venkat', 'Venkat', 'venkat@gmail.com', 8794561230, '1978-07-27', 'Member', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm');
insert into User_Emp(user_name, name, email_address, contact_no, date_of_birth, role, password)
 values('rajesh', 'Rajesh', 'rajesh@gmail.com', 8794561235, '1987-05-19', 'Member', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm');
insert into User_Emp(user_name, name, email_address, contact_no, date_of_birth, role, password)
 values('ramani', 'Roja Ramani', 'ramani@gmail.com', 8894561236, '1987-06-09', 'Member', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm');
insert into User_Emp(user_name, name, email_address, contact_no, date_of_birth, role, password)
 values('poorna', 'Poorna Teja', 'poorna@gmail.com', 8794561237, '1957-06-10', 'Member', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm');
insert into User_Emp(user_name, name, email_address, contact_no, date_of_birth, role, password)
 values('subbaiah', 'Venkata Subbaiah', 'subbaiah@gmail.com', 8794561238, '1987-02-19', 'Member', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm');
insert into User_Emp(user_name, name, email_address, contact_no, date_of_birth, role, password)
 values('rajan', 'Rajan', 'rajan@gmail.com', 8794561269, '1985-09-29', 'Member', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm');

insert into User_Emp(user_name, name, email_address, contact_no, date_of_birth, role, password)
 values('dhoni', 'M S Dhoni', 'dhoni@gmail.com', 8794561241, '1987-06-19', 'Admin', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm');



insert into project(project_id, project_description, project_start_date, project_end_date, project_manager_email_id, project_manager_name, project_name, remarks, status, tech_lead_email_id, tech_lead_name, team_name, team_size, tech_stack,user_name, project_owner) 
values('Mercury', 'This is a project in an introductory Biology class. Student teams are tasked with creating a scientific proposal and a poster illustrating their proposal for genetically modifying an organism to benefit society.', '2022-07-27', '2022-09-27', 'vinay@gmail.com', 'Vinay', 'Mercury', 'pending', 'Completed', 'ram@gmail.com', 'Ram', 'Nova', '3', 'Stack Chui','vinay', 'vinay');

insert into story(story_id, assignee, assignment_date, assignee_email_id, project_id, remarks, status, story_description, story_title, target_date, project_id_name)
 values('Merua', 'Rajan', '2022-07-27', 'rajan@gmail.com', 'Mercury', 'pending', 'In-Progress', 'As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.', 'Merua', '2022-09-27', 'Mercury');


insert into project(project_id, project_description, project_start_date, project_end_date, project_manager_email_id, project_manager_name, project_name, remarks, status, tech_lead_email_id, tech_lead_name, team_name, team_size, tech_stack,user_name, project_owner) 
values('Burera', 'Only reading or hearing these two words together sparks up a feeling to want to try what this amazing and mysterious dish could be. Well, it is exactly as it sounds, only it tastes much better.', '2021-06-18', '2022-11-09', 'rajesh@gmail.com', 'Rajesh', 'Burera', 'pending', 'To-Do', 'ram@gmail.com', 'Ram', 'Team2', '5', 'stack1','vinay','vinay');

insert into story(story_id, assignee, assignment_date, assignee_email_id, project_id, remarks, status, story_description, story_title, target_date, project_id_name)
 values('Viruera', 'Hari Krishna', '2022-06-18', 'harikrishna@gmail.com', 'Burera', 'testing at 40%', 'Ready-For-Test', 'Only reading or hearing these two words together sparks up a feeling to want to try what this amazing and mysterious dish could be. ', 'Viruera', '2021-10-29', 'Burera');
insert into story(story_id, assignee, assignment_date, assignee_email_id, project_id, remarks, status, story_description, story_title, target_date, project_id_name)
 values('Miruera', 'Hari Krishna', '2022-06-18', 'harikrishna@gmail.com', 'Burera', 'testing at 40%', 'Ready-For-Test', 'Do you think Domino’s would stop their innovative ideas with one unique dish? They have given you several more – and that too in the delightful burger pizza!', 'Miruera', '2021-10-29', 'Burera');
insert into story(story_id, assignee, assignment_date, assignee_email_id, project_id, remarks, status, story_description, story_title, target_date, project_id_name)
 values('Kiruera', 'Hari Krishna', '2022-06-18', 'harikrishna@gmail.com', 'Burera', 'testing at 40%', 'Ready-For-Test', 'With such a wonderful combination, almost anything could be paired, isn’t it? To your burger pizza order, add some amazing dishes to effectively complete your order in its true sense. ', 'Kiruera', '2021-10-29', 'Burera');
insert into story(story_id, assignee, assignment_date, assignee_email_id, project_id, remarks, status, story_description, story_title, target_date, project_id_name)
 values('Siruera', 'Hari Krishna', '2022-06-18', 'harikrishna@gmail.com', 'Burera', 'testing at 40%', 'Ready-For-Test', 'The delicious fusion of a pizza and burger is served at all our outlets by the name burger pizza. It is available in vegetarian and non-vegetarian options and is a must-try for everyone. ', 'Siruera', '2021-10-29', 'Burera');
insert into story(story_id, assignee, assignment_date, assignee_email_id, project_id, remarks, status, story_description, story_title, target_date, project_id_name)
 values('Uiruera', 'Hari Krishna', '2022-06-18', 'harikrishna@gmail.com', 'Burera', 'testing at 40%', 'Ready-For-Test', 'You can choose to top up your order with different side dishes and beverages. Just as the combination of burger and pizza, this would be a combination of sweet and savory. ', 'Uiruera', '2021-10-29', 'Burera');


insert into project(project_id, project_description, project_start_date, project_end_date, project_manager_email_id, project_manager_name, project_name, remarks, status, tech_lead_email_id, tech_lead_name, team_name, team_size, tech_stack,user_name, project_owner) 
values('Rekia', 'Personally, I try to follow the rule of 4C when I need to write a description for my future project, or when I’m in charge of leading the team who are supposed to do this job.', '2022-07-27', '2022-10-29', 'rajini@gmail.com', 'Rajini', 'Rekia', 'pending', 'Ready-For-Test', 'ram@gmail.com', 'Ram', 'Team3', '3', 'stack1','rajini','rajini');

insert into story(story_id, assignee, assignment_date, assignee_email_id, project_id, remarks, status, story_description, story_title, target_date, project_id_name)
 values('RekiaA', 'Rajan', '2022-07-27', 'rajan@gmail.com', 'Rekia', 'green', 'Completed', 'Clear means your document uses simple, generally accepted and unambiguous words and sentences to describe the key point.', 'RekiaA', '2022-09-07', 'Rekia');
insert into story(story_id, assignee, assignment_date, assignee_email_id, project_id, remarks, status, story_description, story_title, target_date, project_id_name)
 values('RekiaB', 'Rajan', '2022-07-27', 'rajan@gmail.com', 'Rekia', 'green', 'To-Do', 'Concise means the project description actually “describes the project”, with no reference to other projects or not related information.', 'RekiaB', '2022-09-07', 'Rekia');
insert into story(story_id, assignee, assignment_date, assignee_email_id, project_id, remarks, status, story_description, story_title, target_date, project_id_name)
 values('RekiaC', 'Rajan', '2022-07-27', 'rajan@gmail.com', 'Rekia', 'green', 'Ready-For-Test', 'Credible means in your project description document you refer to up-to-date and relevant information only. You should never use data that is not related to the matter or does not support the idea of your project.', 'RekiaC', '2022-09-07', 'Rekia');


insert into project(project_id, project_description, project_start_date, project_end_date, project_manager_email_id, project_manager_name, project_name, remarks, status, tech_lead_email_id, tech_lead_name, team_name, team_size, tech_stack,user_name, project_owner) 
values('Oculus', 'The word Oculus is often associated with an eye-like design, which makes it a great choice for a VR reality company.', '2021-09-27', '2022-11-29', 'rajini@gmail.com', 'Rajini', 'Oculus', 'pending', 'In-Progress', 'harish@gmail.com', 'Harish', 'Ireka', '7', 'Ireka','rajini','rajini');

insert into story(story_id, assignee, assignment_date, assignee_email_id, project_id, remarks, status, story_description, story_title, target_date, project_id_name)
 values('Houzz', 'Rajini', '2021-10-27', 'rajini@gmail.com', 'Oculus', 'green', 'Completed', 'The project was initially formed as a way to elevate the lack of online resources available for those wishing to renovate their houses and now is a billion-dollar company.', 'Houzz', '2022-01-07', 'Oculus');


insert into project(project_id, project_description, project_start_date, project_end_date, project_manager_email_id, project_manager_name, project_name, remarks, status, tech_lead_email_id, tech_lead_name, team_name, team_size, tech_stack,user_name, project_owner) 
values('Orlock', 'Taking into account the typical elements of the document structure, you must complete the following steps to write a project description template.', '2022-07-27', '2022-09-27', 'vinay@gmail.com', 'Vinay', 'Orlock', 'pending', 'Completed', 'vinay@gmail.com', 'Vinay', 'Pega', '3', 'stack1','vinay', 'vinay');

insert into story(story_id, assignee, assignment_date, assignee_email_id, project_id, remarks, status, story_description, story_title, target_date, project_id_name)
 values('Mega', 'Vinay', '2022-07-27', 'vinay@gmail.com', 'Orlock', 'green', 'Completed', 'Summarize. Summarizing the project means explaining the aims, outcomes, significance and benefits. You must use 3-5 sentences (or less) for writing the summary. ', 'Mega', '2022-09-07', 'Orlock');
insert into story(story_id, assignee, assignment_date, assignee_email_id, project_id, remarks, status, story_description, story_title, target_date, project_id_name)
 values('Cega', 'Vinay', '2022-07-27', 'vinay@gmail.com', 'Orlock', 'green', 'Completed', ' Defining the project means explaining what purpose to reach and what need to address. Under the purpose you write about the main intent for project startup.', 'Cega', '2022-09-07', 'Orlock');

insert into project(project_id, project_description, project_start_date, project_end_date, project_manager_email_id, project_manager_name, project_name, remarks, status, tech_lead_email_id, tech_lead_name, team_name, team_size, tech_stack,user_name, project_owner) 
values('Cricket', 'This article is about the sport. For the insect, see Cricket (insect). For other uses, see Cricket (disambiguation).', '2022-07-27', '2022-10-29', 'dhoni@gmail.com', 'M S Dhoni', 'cricket', 'pending', 'Ready-For-Test', 'dhoni@gmail.com', 'M S Dhoni', 'Pune', '1', 'stack ','dhoni','dhoni');

