CREATE DATABASE NissanAssetDB;

use NissanAssetDB;

SELECT * FROM tbl_user_type;

Insert Into tbl_user_type(ut_name) VALUES	('Admin'),
											('Purchase Manager');

SELECT * FROM tbl_login;

INSERT INTO tbl_login(username, password, ut_id) VALUES	('ram@gmail.com', 'ram@123', 2),
														('rohit@gmail.com', 'rohit@123', 2),
														('sri@gmail.com', 'sri@123', 1),
														('raj@gmail.com', 'raj@123', 2);

SELECT * FROM tbl_user_registration;

drop table tbl_login
drop table tbl_user_registration
drop table tbl_user_type
drop table tbl_asset_type;
drop table tbl_asset_definition;

SELECT * FROM tbl_asset_type;