INSERT INTO public.tab_user ("name", "password", username) VALUES('admin', '$2a$10$YjofB3oDOOEXwa3FynQlz.DpmKA6rTVWi0cZNAfZqlE4Bn9LEi6xy', 'admin');
INSERT INTO public.tab_user ("name", "password", username) VALUES('user', '$2a$10$.Fi188vmXRAthlxznFwjO.X/cQ3smCeeqaVMgBrYcyO.Zm2LvH7PK', 'user');

INSERT INTO public.tab_user_roles (user_id, role_id) VALUES(1, 'ROLE_MANAGERS');
INSERT INTO public.tab_user_roles (user_id, role_id) VALUES(2, 'ROLE_USERS');