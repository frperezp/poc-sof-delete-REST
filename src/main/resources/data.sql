INSERT INTO product(id, fromInstant, name, toInstant) VALUES (1, {ts '2019-09-17 18:47:52.69'}, 'iPhone X', {ts '2021-09-13 18:47:52.69'});
INSERT INTO product(id, fromInstant, name, toInstant) VALUES (2, {ts '2019-09-17 18:47:52.69'}, 'iPhone X Plus', {ts '2021-01-13 18:47:52.69'});
INSERT INTO product(id, fromInstant, name, toInstant) VALUES (3, {ts '2019-09-17 18:47:52.69'}, 'iPhone XS', {ts '2021-01-11 18:47:52.69'});
INSERT INTO product(id, fromInstant, name, toInstant) VALUES (4, {ts '2019-09-17 18:47:52.69'}, 'iPhone XR PRO', {ts '2021-09-17 18:47:52.69'});
INSERT INTO product(id, fromInstant, name, toInstant) VALUES (5, {ts '2019-09-17 18:47:52.69'}, 'iPhone 12', {ts '2021-09-17 18:47:52.69'});

INSERT INTO productflag(id, name, state) values (1, 'iPhone X', 'ACTIVE');
INSERT INTO productflag(id, name, state) values (2, 'iPhone X Plus', 'ACTIVE');
INSERT INTO productflag(id, name, state) values (3, 'iPhone XS', 'ACTIVE');
INSERT INTO productflag(id, name, state) values (4, 'iPhone XR PRO', 'DELETED');
INSERT INTO productflag(id, name, state) values (5, 'iPhone 12', 'ACTIVE');