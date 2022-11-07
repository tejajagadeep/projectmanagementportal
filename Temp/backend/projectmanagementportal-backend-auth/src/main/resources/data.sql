   insert into role(role_id,role_name) values (2,'admin');
   insert into role(role_id,role_name) values (1,'member');
   insert into role(role_id,role_name) values (3,'Manager');
   
   insert into permission(permission_id,permission_name) values(1,'read_user');
   insert into permission(permission_id,permission_name) values(2,'create_user');
   insert into permission(permission_id,permission_name) values(3,'update_user');
   insert into permission(permission_id,permission_name) values(4,'delete_user');
   insert into permission(permission_id,permission_name) values(5,'read_users');
   insert into permission(permission_id,permission_name) values(6,'read_utility');
   insert into permission(permission_id,permission_name) values(7,'create_utility');
   insert into permission(permission_id,permission_name) values(8,'update_utility');
   
insert into user(user_id, user_name, name, email_address, contact_no, date_of_birth, role_role_id, password) values(1, 'venkat', 'Venkat', 'venkat@gamil.com', 7894561230, '1978-07-27', 2, '{bcrypt}$2a$12$NRgdzCG670pUS0HHWkgdn.p508B6m7eJbq6VXrbSqyJqBawpvRUdS');
insert into user(user_id, user_name, name, email_address, contact_no, date_of_birth, role_role_id, password) values(2, 'rajini', 'Rajini', 'rajini@gamil.com', 7894561231, '1968-08-01', 1, '{bcrypt}$2a$12$Vm3K7pSAkbLYRmRRF7ErqOve7IAOHSFM3hk.qGzhKvnVUqzsxmzku');
insert into user(user_id, user_name, name, email_address, contact_no, date_of_birth, role_role_id, password) values(3, 'vinay', 'Vinay', 'vinay@gamil.com', 7894561232, '1987-12-19', 2, '{bcrypt}$2a$12$415XPdv36qbOxah7eQkILe9vh9jnnuLbG7/ni0UNWgeLUKsML8jBq');

   
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
	'{bcrypt}$2y$12$s/vsquzVWfiEf/CmWPrHn.8U0febzYnF6pmvhPljJU4MVWwXgdiF.', 
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
	'{bcrypt}$2y$12$s/vsquzVWfiEf/CmWPrHn.8U0febzYnF6pmvhPljJU4MVWwXgdiF.', 
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
	'{bcrypt}$2y$12$s/vsquzVWfiEf/CmWPrHn.8U0febzYnF6pmvhPljJU4MVWwXgdiF.', 
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
	'{bcrypt}$2y$12$s/vsquzVWfiEf/CmWPrHn.8U0febzYnF6pmvhPljJU4MVWwXgdiF.', 
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
	'{bcrypt}$2y$12$s/vsquzVWfiEf/CmWPrHn.8U0febzYnF6pmvhPljJU4MVWwXgdiF.', 
	'foo,read,write',
	'password,authorization_code,refresh_token,client_credentials', 
	'http://localhost:8082/login,http://localhost:8083/login,http://localhost:8084/login', 
	'ROLE_CLIENT', 
	36000, 
	36000,
	'user-resource,utility-resource',null,'false'
	);