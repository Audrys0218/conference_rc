
INSERT INTO demo (id, data) VALUES (1, 'Hello, world!');
INSERT INTO demo (id, data) VALUES (2, 'Hello, world again!');
INSERT INTO demo (id, data) VALUES (3, 'Hello, world for the third time!');

-- INSERT INTO conference (id, name, startDate, endDate) VALUES (1, 'NFQ Akademijos atidarymas. Įvadas į šiuolaikinio programuotojo darbą', '2013-09-30 17:00:00', '2013-09-30 18:00:00');
-- INSERT INTO conference (id, name, startDate, endDate) VALUES (2, 'Projekto valdymas ir Agile', '2013-10-02 17:00:00', '2013-10-02 18:00:00');
-- INSERT INTO conference (id, name, startDate, endDate) VALUES (3, 'J2EE programavimui naudojami įrankiai', '2013-10-07 17:00:00', '2013-10-07 18:00:00');
-- INSERT INTO conference (id, name, startDate, endDate) VALUES (4, 'Web puslapių vartotojo sąsajos kūrimas (1-a dalis)', '2013-10-09 17:00:00', '2013-10-09 18:00:00');
-- INSERT INTO conference (id, name, startDate, endDate) VALUES (5, 'Web puslapių vartotojo sąsajos kūrimas (2-a dalis)', '2013-11-27 17:00:00', '2013-11-27 17:00:00');

INSERT INTO Categories (id, category_title) VALUES (1, 'Informacines technologijos');
INSERT INTO Categories (id, category_title) VALUES (2, 'Marketingas');
INSERT INTO Categories (id, category_title) VALUES (3, 'Mokymai');

INSERT INTO conference (id, name, startDate, endDate, description, city, street, category_id, creator_id) VALUES (1, 'Conference A', '2013-09-30 17:00:00', '2013-09-30 18:00:00', 'Simple description', 'Kaunas', 'Vytauto', 1, 1);
INSERT INTO conference (id, name, startDate, endDate, description, city, street, category_id, creator_id) VALUES (2, 'Conference B', '2013-10-01 17:00:00', '2013-10-02 18:00:00', 'Simple description', 'Kaunas', 'Vytauto', 2, 1);
INSERT INTO conference (id, name, startDate, endDate, description, city, street, category_id, creator_id) VALUES (3, 'Conference C', '2013-10-20 00:00:00', '2013-10-30 00:00:00', 'Simple description', 'Kaunas', 'Vytauto', 3, 1);


INSERT INTO Users (id, name, surname, username, password, email) VALUES (1, 'AudriusA', 'ADanielevicius', 'AAudrys0218', 'AApassword', 'AAudrys0218@gmail.com');
INSERT INTO Users (id, name, surname, username, password, email) VALUES (2, 'AudriusB', 'BDanielevicius', 'BAudrys0218', 'BApassword', 'BAudrys0218@gmail.com');
INSERT INTO Users (id, name, surname, username, password, email) VALUES (3, 'AudriusC', 'CDanielevicius', 'CAudrys0218', 'CApassword', 'CAudrys0218@gmail.com');
INSERT INTO Users (id, name, surname, username, password, email) VALUES (4, 'AudriusC', 'CDanielevicius', 'sa', 'sa', 'CAudrys0218@gmail.com');

INSERT INTO user_roles (USER_ROLE_ID, USER_ID,AUTHORITY)
VALUES (1, 1, 'ROLE_USER');
INSERT INTO user_roles (USER_ROLE_ID, USER_ID,AUTHORITY)
VALUES (2, 2, 'ROLE_USER');
INSERT INTO user_roles (USER_ROLE_ID, USER_ID,AUTHORITY)
VALUES (3, 3, 'ROLE_USER');
INSERT INTO user_roles (USER_ROLE_ID, USER_ID,AUTHORITY)
VALUES (4, 4, 'ROLE_USER');

INSERT INTO Participants (id, participant_id, conference_id) VALUES (1, 1, 1);
INSERT INTO Participants (id, participant_id, conference_id) VALUES (2, 2, 2);
INSERT INTO Participants (id, participant_id, conference_id) VALUES (3, 3, 3);
INSERT INTO Participants (id, participant_id, conference_id) VALUES (4, 1, 3);

COMMIT;