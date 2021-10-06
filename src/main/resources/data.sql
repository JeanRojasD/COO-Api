INSERT INTO users(id, username, password, email, enabled) VALUES (1, 'admin@email.com', '$2a$10$7INevadxq6pXgoHMsArb6u82RA6ef6LHibJb79LWWQe/Rma8zBw32', 'admin@email.com', true);
INSERT INTO users(id, username, password, email, enabled) VALUES (2, 'user@email.com', '$2a$10$bJk5prDUL0fWuhFxM68Ae.ABOC/QpLBOeqU24oZvrf0C2yPsVFRVS', 'user@email.com', true);

INSERT INTO user_roles(user_id, role) VALUES(1, 'ADMIN');
INSERT INTO user_roles(user_id, role) VALUES(2, 'USER');
