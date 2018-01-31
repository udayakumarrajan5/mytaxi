/**
 * CREATE Script for init of DB
 */

-- Create 3 OFFLINE drivers

insert into driver (id, date_created, deleted, online_status, password, username, gear_type) values (1, now(), false, 'OFFLINE',
'driver01pw', 'driver01','manual');

insert into driver (id, date_created, deleted, online_status, password, username, gear_type) values (2, now(), false, 'OFFLINE',
'driver02pw', 'driver02','manual');

insert into driver (id, date_created, deleted, online_status, password, username, gear_type) values (3, now(), false, 'OFFLINE',
'driver03pw', 'driver03','auto');


-- Create 3 ONLINE drivers

insert into driver (id, date_created, deleted, online_status, password, username, gear_type) values (4, now(), false, 'ONLINE',
'driver04pw', 'driver04','auto');

insert into driver (id, date_created, deleted, online_status, password, username, gear_type) values (5, now(), false, 'ONLINE',
'driver05pw', 'driver05','manual');

insert into driver (id, date_created, deleted, online_status, password, username, gear_type) values (6, now(), false, 'ONLINE',
'driver06pw', 'driver06', 'manual');

-- Create 1 OFFLINE driver with coordinate(longitude=9.5&latitude=55.954)

insert into driver (id, coordinate, date_coordinate_updated, date_created, deleted, online_status, password, username, gear_type)
values
 (7,
 'aced0005737200226f72672e737072696e676672616d65776f726b2e646174612e67656f2e506f696e7431b9e90ef11a4006020002440001784400017978704023000000000000404bfa1cac083127', now(), now(), false, 'OFFLINE',
'driver07pw', 'driver07', 'auto');

-- Create 1 ONLINE driver with coordinate(longitude=9.5&latitude=55.954)

insert into driver (id, coordinate, date_coordinate_updated, date_created, deleted, online_status, password, username, gear_type)
values
 (8,
 'aced0005737200226f72672e737072696e676672616d65776f726b2e646174612e67656f2e506f696e7431b9e90ef11a4006020002440001784400017978704023000000000000404bfa1cac083127', now(), now(), false, 'ONLINE',
'driver08pw', 'driver08', 'auto');


insert into car (id, license_plate, date_created, seat_count,convertible,rating,engine_type,color,style,manufacturer,model, gear_type)
values
(1, 'RAKL8136',now(),4,0,5,'petrol','black','Sedan', 'Audi','A7', 'auto');

insert into car (id, license_plate, date_created, seat_count,convertible,rating,engine_type,color,style,manufacturer,model, gear_type)
values
(2, 'RQKL8136',now(),4,0,5,'petrol','Red','Sedan', 'Mercedes-Benz','C-Class','auto');

insert into car (id, license_plate, date_created, seat_count,convertible,rating,engine_type,color,style,manufacturer,model,gear_type)
values
(4, 'KLKRA9136',now(),4,0,5,'petrol','black','Hatch', 'Porsche','Trubo', 'manual');

insert into car (id, license_plate, date_created, seat_count,convertible,rating,engine_type,color,style,manufacturer,model,gear_type)
values
(5, 'XYAB0087',now(),4,0,5,'petrol','black','Sedan', 'Audi','A7', 'manual');


