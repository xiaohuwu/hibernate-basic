alter table Order drop foreign key FKjpfhrh4fnaxm0muuq3oaq0glr
drop table if exists customer
drop table if exists Order
create table customer (id integer not null auto_increment, address varchar(255), name varchar(255), primary key (id))
create table Order (id integer not null auto_increment, money double precision, receiverInfo varchar(255), customer_id integer, primary key (id))
alter table Order add constraint FKjpfhrh4fnaxm0muuq3oaq0glr foreign key (customer_id) references customer (id)
alter table Order drop foreign key FKjpfhrh4fnaxm0muuq3oaq0glr
drop table if exists customer
drop table if exists Order
create table customer (id integer not null auto_increment, address varchar(255), name varchar(255), primary key (id))
create table Order (id integer not null auto_increment, money double precision, receiverInfo varchar(255), customer_id integer, primary key (id))
alter table Order add constraint FKjpfhrh4fnaxm0muuq3oaq0glr foreign key (customer_id) references customer (id)
