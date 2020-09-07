BEGIN TRANSACTION;

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (
	user_id serial NOT NULL,
	username varchar(50) NOT NULL,
	current_region int NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

INSERT INTO users (username,current_region) VALUES ('doyle','1');

COMMIT TRANSACTION;


BEGIN TRANSACTION;

DROP TABLE IF EXISTS region CASCADE;
CREATE TABLE region (
        region_id serial NOT NULL,
        region_name varchar(20) NOT NULL,
        description varchar(100) NOT NULL,
        CONSTRAINT PK_region_id PRIMARY KEY (region_id)     
);

INSERT INTO region (region_name, description) VALUES ('Farm', 'Old McDonalds Farm');
INSERT INTO region (region_name, description) VALUES ('Jungle', 'The Jungle');
INSERT INTO region (region_name, description) VALUES ('Ocean', 'The Ocean');
INSERT INTO region (region_name, description) VALUES ('Moon', 'The Moon');

COMMIT TRANSACTION;


BEGIN TRANSACTION;

DROP TABLE IF EXISTS singable CASCADE;
CREATE TABLE singable (
	id serial NOT NULL,
        singable_name varchar(20) NOT NULL,
	description varchar(100) NOT NULL,
	is_vehicle boolean NOT NULL,
        sound varchar(20) NOT NULL,
        region int NOT NULL,
        CONSTRAINT PK_singable_id PRIMARY KEY (id)
);

INSERT INTO singable (singable_name, description, is_vehicle, sound, region) VALUES ('Horse', 'A Horse', 'false', 'Neigh', 1);
INSERT INTO singable (singable_name, description, is_vehicle, sound, region) VALUES ('Cow', 'A Cow', 'false', 'Moo', 1);
INSERT INTO singable (singable_name, description, is_vehicle, sound, region) VALUES ('Tiger', 'A Tiger', 'false', 'Roar', 2);
INSERT INTO singable (singable_name, description, is_vehicle, sound, region) VALUES ('Elephant', 'An Elephant', 'false', 'Brphphph', 2);
INSERT INTO singable (singable_name, description, is_vehicle, sound, region) VALUES ('Whale', 'A Whale', 'false', 'Hrrooo', 3);
INSERT INTO singable (singable_name, description, is_vehicle, sound, region) VALUES ('Dolphin', 'A Dolphin', 'false', 'Ekikikiki', 3);
INSERT INTO singable (singable_name, description, is_vehicle, sound, region) VALUES ('Whale', 'A Whale', 'false', 'Hrrooo', 3);
INSERT INTO singable (singable_name, description, is_vehicle, sound, region) VALUES ('Xenomorph', 'A dangerous Alien. Run!', 'false', 'HISSKUKA', 4);
INSERT INTO singable (singable_name, description, is_vehicle, sound, region) VALUES ('Alf', 'An funny alien from planet Melmac', 'false', 'HAH!', 4);
INSERT INTO singable (singable_name, description, is_vehicle, sound, region) VALUES ('Jeep', 'An offroad Jeep, perfect for traversing the Jungle', 'true', 'Beep', 2);
INSERT INTO singable (singable_name, description, is_vehicle, sound, region) VALUES ('Sumbarine', 'A yellow submarine. Lets go diving underwater', 'true', 'Ping', 3);
INSERT INTO singable (singable_name, description, is_vehicle, sound, region) VALUES ('Rocketship', 'Cruise the stars. Go to the moon', 'true', 'FWOOOOSH', 4);

COMMIT TRANSACTION;


BEGIN TRANSACTION;

ALTER TABLE users ADD FOREIGN KEY (current_region) REFERENCES region(region_id);
ALTER TABLE singable ADD FOREIGN KEY (region) REFERENCES region(region_id);

COMMIT TRANSACTION;