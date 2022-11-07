insert into User_Emp(user_id,user_name, name, email_address, contact_no, date_of_birth, role, password)
 values(1,'venkat', 'Venkat', 'venkat@gamil.com', 7894561230, '1978-07-27', 'Member', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm');
insert into User_Emp(user_id,user_name, name, email_address, contact_no, date_of_birth, role, password)
 values(2,'rajini', 'Rajini', 'rajini@gamil.com', 7894561231, '1968-08-01', 'Admin', 'Rajini@123');
insert into User_Emp(user_id, user_name, name, email_address, contact_no, date_of_birth, role, password)
 values(3,'vinay', 'Vinay', 'vinay@gamil.com', 7894561232, '1987-12-19', 'Admin', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm');


insert into Role(user_id, user_name, password, role) values(1, 'venkat', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm', 'Member');
insert into Role(user_id, user_name, password, role) values(2, 'rajini', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm', 'Admin');
insert into Role(user_id, user_name, password, role) values(3, 'vinay', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm', 'Admin');


insert into project(project_id, project_description, project_start_date, project_end_date, project_manager_email_id, project_manager_name, project_name, remarks, status, tech_lead_email_id, tech_lead_name, team_name, team_size, tech_stack) 
values('project1', 'As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.', '2022-07-27', '2022-09-27', 'vinay@gamil.com', 'Vinay', 'project1', 'pending', 'Completed', 'ram@gmail.com', 'Ram', 'Team1', '3', 'stack1');
insert into project(project_id, project_description, project_start_date, project_end_date, project_manager_email_id, project_manager_name, project_name, remarks, status, tech_lead_email_id, tech_lead_name, team_name, team_size, tech_stack) 
values('project2', 'TAs Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.', '2022-06-18', '2022-10-29', 'vinay@gamil.com', 'Vinay', 'project2', 'pending', 'To-Do', 'ram@gmail.com', 'Ram', 'Team2', '3', 'stack1');
insert into project(project_id, project_description, project_start_date, project_end_date, project_manager_email_id, project_manager_name, project_name, remarks, status, tech_lead_email_id, tech_lead_name, team_name, team_size, tech_stack) 
values('project3', 'As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.', '2022-07-27', '2022-10-29', 'rajini@gamil.com', 'Rajini', 'project3', 'pending', 'Ready-For-Test', 'ram@gmail.com', 'Ram', 'Team3', '3', 'stack1');


insert into story(story_id, assignee, assignment_date, assignee_email_id, project_id, remarks, status, story_description, story_title, target_date) values('story1', 'Rajan', '2022-07-27', 'rajan@gmail.com', 'project1', 'pending', 'In-Progress', 'As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.', 'Story1', '2022-09-27');
insert into story(story_id, assignee, assignment_date, assignee_email_id, project_id, remarks, status, story_description, story_title, target_date) values('story2', 'Hari Krishna', '2022-06-18', 'harikrishna@gmail.com', 'project2', 'Ready-For-Test', 'hold', 'As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.', 'Story2', '2022-10-29');
insert into story(story_id, assignee, assignment_date, assignee_email_id, project_id, remarks, status, story_description, story_title, target_date) values('story3', 'Rajan', '2022-07-27', 'rajan@gmail.com', 'project3', 'green', 'Completed', 'As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.', 'Story3', '2022-09-07');
insert into story(story_id, assignee, assignment_date, assignee_email_id, project_id, remarks, status, story_description, story_title, target_date) values('story4', 'Rajan', '2022-07-27', 'rajan@gmail.com', 'project3', 'green', 'To-Do', 'As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.', 'Story3', '2022-09-07');
insert into story(story_id, assignee, assignment_date, assignee_email_id, project_id, remarks, status, story_description, story_title, target_date) values('story5', 'Rajan', '2022-07-27', 'rajan@gmail.com', 'project3', 'green', 'Ready-For-Test', 'As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.', 'Story3', '2022-09-07');

