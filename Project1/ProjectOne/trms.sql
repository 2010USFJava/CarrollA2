CREATE TABLE employee (
id serial,
first_name varchar(20),
last_name varchar(20),
title varchar (30),
username varchar(18),
password varchar(18)
);

CREATE TABLE request (
id serial,
employee_id integer,
event_date varchar(10),
event_time varchar(7),
event_location varchar(20),
event_type varchar(30),
event_description text,
cost NUMERIC,
status varchar(10)
);

CREATE TABLE document (
id serial,
request_id integer,
doc_url text
);