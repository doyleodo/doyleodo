BEGIN TRANSACTION;

DROP TABLE IF EXISTS users CASCADE;
DROP SEQUENCE IF EXISTS seq_user_id CASCADE;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);



INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('doyle','$2a$10$Z8rmoLK4SHX3q4/jkEqgqeZP3uTLsLsP/uZUsYkXzMC7AlIu5rtVC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('brandon','$2a$10$Z8rmoLK4SHX3q4/jkEqgqeZP3uTLsLsP/uZUsYkXzMC7AlIu5rtVC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('ingrid','$2a$10$Z8rmoLK4SHX3q4/jkEqgqeZP3uTLsLsP/uZUsYkXzMC7AlIu5rtVC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('ben','$2a$10$Z8rmoLK4SHX3q4/jkEqgqeZP3uTLsLsP/uZUsYkXzMC7AlIu5rtVC','ROLE_USER');



COMMIT TRANSACTION;


BEGIN TRANSACTION;

DROP TABLE IF EXISTS plant CASCADE;
CREATE TABLE plant (
        plant_id serial NOT NULL,
        plant_name varchar(100) NOT NULL,
        description varchar(1000) NOT NULL,
        plants_per_sq_foot int NOT NULL,
        sun_requirements varchar(100) NOT NULL,
        region varchar(100) NOT NULL,
        seedling_cost decimal NOT NULL,
        CONSTRAINT PK_plant_id PRIMARY KEY (plant_id)     

);
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('None', 'Dirty Dirt', '4', 'None', 'All', '0.00');
        

       

INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Bok Choy', 'Leafy grren vegetable in the cabbage family, great for cooking', '9', '3-5 hours', 'Asia', '2.50');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Broccoli', 'Cruciferous vegetable with many health benefits and cooking uses', '1', 'Partial Shade', 'Southwestern United States', '2.75');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Cabbage', 'Leafy green, red, purple or white crop in the broccoli family', '1', 'Minimum of 6 hours', 'Europe', '5.00');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Carrot', 'Delicious, orange root vegetable, great for cooking or eating raw', '16', 'Minimum of 6 hours', 'Africa', '3.00');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Cauliflower', 'Crucerferous vegetable with versitle cooking properties', '1', 'Minimum of 6 hours', 'Asia', '7.75');
        
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Corn', 'Sweet yellow grain, great for cooking', '4', 'Minimum of 6 hours', 'United States', '6.25');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Collards', 'Deep leafy grren member of the cabbage family', '1', '4-5 hours', 'Mediterranean', '2.95');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Cucumber', 'Refreshing vine fruit, great for salads', '2', 'Minimum of 8 hours', 'India', '3.75');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Eggplant', 'Herbaceous perennial, related to the tomato, great for cooking', '1', 'Minimum of 6 hours', 'India', '7.50');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Garlic', 'Herbaceous, pungent, flowering bulb, often used in cooking, keeps the vampires away!', '9', 'Minimum of 8 hours', 'Middle Asia', '3.25');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Green Onions', 'Also known as scallions, often used for cooking', '16', '6-7 hours', 'Asia', '1.75');

INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Lettuce (head)', 'Perfect for salads!', '2', '10-12 hours', 'Egypt', '4.95');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Onion', 'Pungent biennial, great for cooking', '9', '13-16 hours', 'Central Asia', '2.50');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Zucchini', 'Dark green summer squash, great for cooking', '1', '6-8 hours', 'Central America', '8.00');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Turnips', 'Hardy biennia plant in the mustard family', '9', 'Minimum of 6 hours', 'Europe', '5.50');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Tomato', 'Acidic nightshade, often used for cooking', '1', 'Minimum of 8 hours', 'Central America', '6.00');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Spinach', 'Iron-rich leafy grren, Popeye would be proud!', '9', 'Minimum of 6 hours', 'Southwestern Asia', '3.50');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Squash', 'Great for fall dishes', '1', '6 hours', 'Mexico', '2.95');
       
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Radishes', 'Bitter root vegetable, great for salads and garnishes', '16', 'Minimum of 6 hours', 'Mediterranean', '2.75');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Potato', 'Versitile, starchy root vegetable', '4', 'Minimum of 6 hours', 'Peru', '3.50');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Bell Pepper', 'Perfect for salads and stir-fry dishes', '1', '6-8 hours', 'South America', '6.25');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Peas', 'Classic garden veggie, great for novice gardeners', '9', '6-8 hours', 'Mediterranean', '4.00');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Green Seeds', 'Those who eat the fruit of this seed gains ultimate knowledge.  Has a slightly nutty flavor', '1', '14 weeks', 'Detroit and Philadelphia', '15000.00');

COMMIT TRANSACTION;





BEGIN TRANSACTION;

DROP TABLE IF EXISTS plot CASCADE;
CREATE TABLE plot (
       plot_id serial NOT NULL,
        garden_id int NOT NULL,
        plot_number int NOT NULL,
        plant_id int,
        CONSTRAINT PK_plot_id PRIMARY KEY (plot_id)
);
COMMIT TRANSACTION;

BEGIN TRANSACTION;

DROP TABLE IF EXISTS garden CASCADE;
CREATE TABLE garden (
        user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL, 
        garden_id serial NOT NULL,
        length int NOT NULL,
        width int NOT NULL,
        garden_name varchar(100) NOT NULL,
        CONSTRAINT PK_garden_id PRIMARY KEY (garden_id)


);
COMMIT TRANSACTION;

BEGIN TRANSACTION;
DROP TABLE IF EXISTS garden_supplies;
CREATE TABLE garden_supplies (
        garden_id int,
        supply_id int,
        supply_qty int,
        CONSTRAINT PK_garden_supply_id PRIMARY KEY (garden_id, supply_id)
);
COMMIT TRANSACTION;

BEGIN TRANSACTION;
DROP TABLE IF EXISTS supplies CASCADE; 
CREATE TABLE supplies (
        supply_id int NOT NULL,
        supply_name varchar(100) NOT NULL,
        supply_cost decimal NOT NULL,
        CONSTRAINT PK_supplies PRIMARY KEY (supply_id)
);

INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('1', '2 cu ft. Bagged Brown Mulch', '4.50');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('2', '2 cu ft. Bagged Red Mulch', '4.50');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('3', '2 cu ft. Bagged Black Mulch', '4.50');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('4', '2 cu ft. Bagged Cypress Mulch Blend', '4.50');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('5', '2 cu ft. Bagged Pine Bark Nuggets', '4.50');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('6', '16-Tine Rake', '20.00');

INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('8', 'Hand Trowel', '9.00');

INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('10', 'Bypass Pruner', '10.75');


INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('13', '48 in. Round Point Shovel', '26.00');

INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('15', 'Firm Grip Grain Pigskin Gloves', '12.25');

INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('17', 'Rose Embroidered mid-length Gloves', '14.75');

INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('19', 'Plastic Wheelbarrow', '80.00');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('20', '4-tined basic green cultivator', '18.75');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('21', '4- tined green hand rake', '9.50');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('22', 'Dig it! Watering can', '45.00');

INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('24', 'Dig It! Tomato Cage', '20.00');






BEGIN TRANSACTION;

DROP TABLE IF EXISTS user_data CASCADE;
CREATE TABLE user_data(
        user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL, 
		first_name varchar(100) NOT NULL,
		last_name varchar(100) NOT NULL,
        email varchar(100) NOT NULL,
        region varchar(100),
        city varchar(100),
        state varchar(100),
		zip varchar(20),
CONSTRAINT PK_user_data PRIMARY KEY (user_id)        

);

INSERT INTO user_data (user_id, first_name, last_name, email, region, city, state, zip) VALUES ('1', 'user', 'x', 'userx@gardenmail.com', '6b', 'Detroit', 'Michigan', '48202');
INSERT INTO user_data (user_id, first_name, last_name, email, region, city, state, zip) VALUES ('2', 'admin', 'x', 'adminx@gardenmail.com', '6b', 'Detroit', 'Michigan', '48202');
INSERT INTO user_data (user_id, first_name, last_name, email, region, city, state, zip) VALUES ('3', 'Doyle', 'ODonnell', 'doyleodo@gardenmail.com', '5b', 'Brighton', 'Michigan', '48114');
INSERT INTO user_data (user_id, first_name, last_name, email, region, city, state, zip) VALUES ('4', 'Brandon', 'Grumbling', 'brandon@gardenmail.com', '7b', 'Philadelphia', 'Michigan', '19125');
INSERT INTO user_data (user_id, first_name, last_name, email, region, city, state, zip) VALUES ('5', 'Ingrid', 'OConnor', 'ingrid@gardenmail.com', '6b', 'Detroit', 'Michigan', '48202');
INSERT INTO user_data (user_id, first_name, last_name, email, region, city, state, zip) VALUES ('6', 'Ben', 'Offer', 'ben@gardenmail.com', '6a', 'Ferndale', 'Michigan', '48220');

COMMIT TRANSACTION;



BEGIN TRANSACTION;

DROP TABLE IF EXISTS hardiness CASCADE;
CREATE TABLE hardiness (
	zone_name varchar(10),
	avg_last_frost_month varchar(10),
	avg_last_frost_day int,
	avg_first_frost_month varchar(10),
	avg_first_frost_day int,
	avg_growing_days int,
        CONSTRAINT PK_zone_name PRIMARY KEY (zone_name)
);

INSERT INTO hardiness (zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('3a', 'May', '15', 'September', '15', '123');
INSERT INTO hardiness (zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('3b', 'May', '15', 'September', '15', '123');
INSERT INTO hardiness (zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('4a', 'May', '15', 'October', '1', '139');
INSERT INTO hardiness (zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('4b', 'May', '15', 'October', '1', '139');
INSERT INTO hardiness (zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('5a', 'May', '1', 'October', '15', '168');
INSERT INTO hardiness (zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('5b', 'May', '1', 'October', '15', '168');
INSERT INTO hardiness (zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('6a', 'Apr', '15', 'October', '15', '183');
INSERT INTO hardiness (zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('6b', 'Apr', '15', 'October', '15', '183');
INSERT INTO hardiness (zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('7a', 'Apr', '1', 'October', '31', '213');
INSERT INTO hardiness (zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('7b', 'Apr', '1', 'October', '31', '213');
INSERT INTO hardiness (zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('8a', 'March', '15', 'November', '15', '245');
INSERT INTO hardiness (zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('8b', 'March', '15', 'November', '15', '245');
INSERT INTO hardiness (zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('9a', 'February', '15', 'November', '30', '290');
INSERT INTO hardiness (zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('9b', 'February', '15', 'November', '30', '290');
INSERT INTO hardiness (zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('10a', 'January', '1', 'December', '31', '290');
INSERT INTO hardiness (zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('10b', 'January', '1', 'December', '31', '290');
INSERT INTO hardiness (zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('11a', 'January', '1', 'December', '31', '290');
INSERT INTO hardiness (zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('11b', 'January', '1', 'December', '31', '290');


COMMIT TRANSACTION;




DROP TABLE IF EXISTS plant_hardiness;
CREATE TABLE plant_hardiness (
    zone_name varchar(10),
	plant_id int,
        
        CONSTRAINT PK_plant_hardiness PRIMARY KEY (zone_name, plant_id)
);


INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('3a', '18');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('3a', '19');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('3a', '17');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('3a', '6');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('3a', '14');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('3b', '18');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('3b', '19');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('3b', '17');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('3b', '6');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('3b', '14');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('4a', '18');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('4a', '19');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('4a', '17');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('4a', '6');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('4a', '14');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('4b', '18');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('4b', '19');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('4b', '17');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('4b', '6');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('4b', '14');

INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('5a', '17');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('5a', '18');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('5a', '7');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('5a', '15');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('5a', '16');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('5b', '17');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('5b', '18');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('5b', '7');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('5b', '15');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('5b', '16');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('6a', '17');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('6a', '18');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('6a', '7');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('6a', '15');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('6a', '16');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('6b', '17');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('6b', '18');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('6b', '7');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('6b', '15');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('6b', '16');

INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('7a', '11');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('7a', '12');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('7a', '9');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('7a', '4');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('7a', '7');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('7b', '11');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('7b', '12');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('7b', '9');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('7b', '4');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('7b', '7');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('8a', '11');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('8a', '12');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('8a', '9');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('8a', '4');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('8a', '7');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('8b', '11');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('8b', '12');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('8b', '9');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('8b', '4');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('8b', '7');

INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('9a', '11');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('9a', '22');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('9a', '8');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('9a', '23');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('9a', '10');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('9b', '11');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('9b', '22');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('9b', '8');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('9b', '23');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('9b', '10');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('10a', '11');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('10a', '22');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('10a', '8');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('10a', '23');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('10a', '10');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('10b', '11');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('10b', '22');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('10b', '8');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('10b', '23');
INSERT INTO plant_hardiness (zone_name, plant_id) VALUES ('10b', '10');


COMMIT TRANSACTION;



ALTER TABLE plot ADD FOREIGN KEY (garden_id) REFERENCES garden(garden_id);

ALTER TABLE garden_supplies ADD FOREIGN KEY (garden_id) REFERENCES garden(garden_id);
ALTER TABLE garden_supplies ADD FOREIGN KEY (supply_id) REFERENCES supplies(supply_id);
ALTER TABLE user_data ADD FOREIGN KEY (user_id) REFERENCES users(user_id);
ALTER TABLE garden ADD FOREIGN KEY (user_id) REFERENCES user_data(user_id);
ALTER TABLE plant_hardiness ADD FOREIGN KEY (zone_name) REFERENCES hardiness(zone_name);
ALTER TABLE plant_hardiness ADD FOREIGN KEY (plant_id) REFERENCES plant(plant_id);
ALTER TABLE plot ADD FOREIGN KEY (plant_id) REFERENCES plant(plant_id);
COMMIT TRANSACTION;