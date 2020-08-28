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

DROP TABLE IF EXISTS animal CASCADE;
CREATE TABLE animal (
		animal_id serial NOT NULL,
        animal_name varchar(20) NOT NULL,
		description varchar(100) NOT NULL,
        sound varchar(20) NOT NULL,
        region int NOT NULL,
        CONSTRAINT PK_animal_id PRIMARY KEY (animal_id)
);

INSERT INTO animal (animal_name, description, sound, region) VALUES ('Horse', 'A Horse', 'Neigh', 1);
INSERT INTO animal (animal_name, description, sound, region) VALUES ('Cow', 'A Cow', 'Moo', 1);
INSERT INTO animal (animal_name, description, sound, region) VALUES ('Tiger', 'A Tiger', 'Roar', 2);
INSERT INTO animal (animal_name, description, sound, region) VALUES ('Elephant', 'An Elephant', 'Brphphph', 2);
INSERT INTO animal (animal_name, description, sound, region) VALUES ('Whale', 'A Whale', 'Hrrooo', 3);
INSERT INTO animal (animal_name, description, sound, region) VALUES ('Dolphin', 'A Dolphin', 'Ekikikiki', 3);
INSERT INTO animal (animal_name, description, sound, region) VALUES ('Whale', 'A Whale', 'Hrrooo', 3);
INSERT INTO animal (animal_name, description, sound, region) VALUES ('Xenomorph', 'A dangerous Alien. Run!', 'HISSKUKA', 4);
INSERT INTO animal (animal_name, description, sound, region) VALUES ('Alf', 'An funny alien from planet Melmac', 'HAH!', 4);

COMMIT TRANSACTION;


BEGIN TRANSACTION;

DROP TABLE IF EXISTS vehicle CASCADE;
CREATE TABLE vehicle (
		vehicle_id serial NOT NULL,
        vehicle_name varchar(20) NOT NULL,
		description varchar(100) NOT NULL,
        sound varchar(20) NOT NULL,
        region int NOT NULL,
        CONSTRAINT PK_vehicle_id PRIMARY KEY (vehicle_id)
);

INSERT INTO vehicle (vehicle_name, description, sound, region) VALUES ('Train', 'An old train', 'Chugga', 2);
INSERT INTO vehicle (vehicle_name, description, sound, region) VALUES ('Sumbarine', 'A yellow submarine', 'Ping', 3);
INSERT INTO vehicle (vehicle_name, description, sound, region) VALUES ('Rocketship', 'A rocketship', 'FWOOOOSH', 4);

COMMIT TRANSACTION;

BEGIN TRANSACTION;

ALTER TABLE users ADD FOREIGN KEY (current_region) REFERENCES region(region_id);
ALTER TABLE animal ADD FOREIGN KEY (region) REFERENCES region(region_id);
ALTER TABLE vehicle ADD FOREIGN KEY (region) REFERENCES region(region_id);

COMMIT TRANSACTION;