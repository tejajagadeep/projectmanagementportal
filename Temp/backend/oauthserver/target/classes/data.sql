
   insert into role(role_id,role_name) values (2,'admin');
   insert into role(role_id,role_name) values (1,'user');
   insert into role(role_id,role_name) values (3,'Manager');
   
   insert into permission(permission_id,permission_name) values(1,'read_user');
   insert into permission(permission_id,permission_name) values(2,'create_user');
   insert into permission(permission_id,permission_name) values(3,'update_user');
   insert into permission(permission_id,permission_name) values(4,'delete_user');
   insert into permission(permission_id,permission_name) values(5,'read_users');
   insert into permission(permission_id,permission_name) values(6,'read_utility');
   insert into permission(permission_id,permission_name) values(7,'create_utility');
   insert into permission(permission_id,permission_name) values(8,'update_utility');
   
   


INSERT INTO USER (user_id,user_name,name,email_address,contact_number, user_type, dob,password,role_role_id) VALUES (
   1, 'Samual','Samual','smaual@gmail.com',7894561230,'member','1999-08-09','{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm',2);

INSERT INTO USER (user_id,user_name,name,email_address, contact_number, user_type, dob,password ,role_role_id) VALUES (
   2, 'Harish','Harish','harish@gmail.com', 7894561231, 'admin','187-08-29','{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm',1); 
   
INSERT INTO USER (user_id,user_name,name,email_address, contact_number, user_type, dob, password,role_role_id) VALUES (
   3, 'Sudha','Sudha Santha Kumar','sudha@gmail.com',7894561232, 'admin', '1965-04-14','{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm',3); 
   

   
   
   
   insert into role_permission (role_id,permission_id) values (1,1);
   insert into role_permission (role_id,permission_id) values (1,2);
   insert into role_permission (role_id,permission_id) values (1,3);
   insert into role_permission (role_id,permission_id) values (1,4);
   insert into role_permission (role_id,permission_id) values (1,5);
   insert into role_permission (role_id,permission_id) values (2,1);
   insert into role_permission (role_id,permission_id) values (2,2);
   insert into role_permission (role_id,permission_id) values (2,3);
   insert into role_permission (role_id,permission_id) values (2,4);
   insert into role_permission (role_id,permission_id) values (2,5);
   insert into role_permission (role_id,permission_id) values (2,6);
   insert into role_permission (role_id,permission_id) values (2,7);
   insert into role_permission (role_id,permission_id) values (2,8);
   insert into role_permission (role_id,permission_id) values (3,1);
   insert into role_permission (role_id,permission_id) values (3,2);
   insert into role_permission (role_id,permission_id) values (3,3);
   insert into role_permission (role_id,permission_id) values (3,4);
   insert into role_permission (role_id,permission_id) values (3,5);
   insert into role_permission (role_id,permission_id) values (3,6);
   insert into role_permission (role_id,permission_id) values (3,7);
--   insert into role_permission (role_id,permission_id) values ();
--   insert into role_permission (role_id,permission_id) values ();
   
   
   
   
INSERT INTO oauth_client_details (
	id,
	client_id, 
	client_secret, 
	scope, 
	authorized_grant_types,
	web_server_redirect_uri, 
	authorities, 
	access_token_validity,
	refresh_token_validity,resource_ids, additional_information, autoapprove
	 )
VALUES
	(
	1,
	'User', 
	'{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm', 
	'foo,read,write',
	'password,authorization_code,refresh_token,client_credentials', 
	'http://localhost:8082/login,http://localhost:8083/login,http://localhost:8084/login', 
	'ROLE_CLIENT', 
	36000, 
	36000,
	'user-resource,utility-resource',null,'true'
	);
	

	   
   
INSERT INTO oauth_client_details (
	id,
	client_id, 
	client_secret, 
	scope, 
	authorized_grant_types,
	web_server_redirect_uri, 
	authorities, 
	access_token_validity,
	refresh_token_validity,resource_ids, additional_information, autoapprove
	 )
VALUES
	(
	2,
	'Util', 
	'{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm', 
	'foo,read,write',
	'password,authorization_code,refresh_token,client_credentials', 
	'http://localhost:8082/login,http://localhost:8083/login,http://localhost:8084/login', 
	'ROLE_CLIENT', 
	36000, 
	36000,
	'user-resource,utility-resource',null,'true'
	);
	
	
INSERT INTO oauth_client_details (
	id,
	client_id, 
	client_secret, 
	scope, 
	authorized_grant_types,
	web_server_redirect_uri, 
	authorities, 
	access_token_validity,
	refresh_token_validity,resource_ids, additional_information, autoapprove
	 )
VALUES
	(
	3,
	'Utility', 
	'{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm', 
	'foo,read,write',
	'password,authorization_code,refresh_token,client_credentials', 
	'http://localhost:8082/login,http://localhost:8083/login,http://localhost:8084/login', 
	'ROLE_CLIENT', 
	36000, 
	36000,
	'user-resource,utility-resource',null,'false'
	);
	
		
INSERT INTO oauth_client_details (
	id,
	client_id, 
	client_secret, 
	scope, 
	authorized_grant_types,
	web_server_redirect_uri, 
	authorities, 
	access_token_validity,
	refresh_token_validity,resource_ids, additional_information, autoapprove
	 )
VALUES
	(
	4,
	'oauthclient1', 
	'{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm', 
	'foo,read,write',
	'password,authorization_code,refresh_token,client_credentials', 
	'http://localhost:8082/login,http://localhost:8083/login,http://localhost:8084/forwardLogin,http://localhost:8084/welcome', 
	'ROLE_CLIENT', 
	36000, 
	36000,
	'user-resource,utility-resource',null,'false'
	);
	
		
INSERT INTO oauth_client_details (
	id,
	client_id, 
	client_secret, 
	scope, 
	authorized_grant_types,
	web_server_redirect_uri, 
	authorities, 
	access_token_validity,
	refresh_token_validity,resource_ids, additional_information, autoapprove
	 )
VALUES
	(
	5,
	'mvcclient', 
	'{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm', 
	'foo,read,write',
	'password,authorization_code,refresh_token,client_credentials', 
	'http://localhost:8082/login,http://localhost:8083/login,http://localhost:8084/login', 
	'ROLE_CLIENT', 
	36000, 
	36000,
	'user-resource,utility-resource',null,'false'
	);
	