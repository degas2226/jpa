
DROP TABLE IF EXISTS PAA_USERS;
CREATE TABLE PAA_USERS (
  racf_id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  career VARCHAR(250) DEFAULT NULL
);

DROP TABLE IF EXISTS PAA_PERMISSIONS;
CREATE TABLE PAA_PERMISSIONS (
  permission_id INT AUTO_INCREMENT  PRIMARY KEY,
  perm_desc VARCHAR(250) NOT NULL,
  created_ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DROP TABLE IF EXISTS PAA_PERMISSIONS_USER;
CREATE TABLE PAA_PERMISSIONS_USER (
  racf_id int not null,
  permission_id int NOT NULL,
  update_tms TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_racf_id int default null, 
  primary key (racf_id,permission_id), 
  foreign key (racf_id) references PAA_USERS(racf_id),
  foreign key (permission_id) references PAA_PERMISSIONS(permission_id)
);

insert into PAA_USERS(racf_id,first_name,last_name,career) values (1,'test','user1','IT');
insert into PAA_USERS(racf_id,first_name,last_name,career) values (2,'test','user2','IT');
insert into PAA_USERS(racf_id,first_name,last_name,career) values (3,'test','user3','IT');

insert into PAA_PERMISSIONS(permission_id,perm_desc) values ( 1,'Create Tab' );
insert into PAA_PERMISSIONS(permission_id,perm_desc) values ( 2,'Update Tab' );
insert into PAA_PERMISSIONS(permission_id,perm_desc) values ( 3,'Delete Tab' );
insert into PAA_PERMISSIONS(permission_id,perm_desc) values ( 4,'Create Sch' );
insert into PAA_PERMISSIONS(permission_id,perm_desc) values ( 5,'Update Sch' );

insert into PAA_PERMISSIONS_USER (racf_id, permission_id) VALUES ( 1,1 );
insert into PAA_PERMISSIONS_USER (racf_id, permission_id) VALUES ( 1,2 );
insert into PAA_PERMISSIONS_USER (racf_id, permission_id) VALUES ( 1,3 );

insert into PAA_PERMISSIONS_USER (racf_id, permission_id) VALUES ( 2,4 );
insert into PAA_PERMISSIONS_USER (racf_id, permission_id) VALUES ( 2,5 );