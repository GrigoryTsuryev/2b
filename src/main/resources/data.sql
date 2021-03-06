DELETE from reports;
DELETE from tasks;
Delete from employees;
Delete from managers;
insert into managers (manager_id, first_name, last_name) values (1, 'Manager1', 'Manager1');
insert into managers (manager_id, first_name, last_name) values (2, 'Manager2', 'Manager2');
insert into managers (manager_id, first_name, last_name) values (3, 'Manager3', 'Manager3');

insert into employees (employee_id, first_name, last_name, manager_id) values (4, 'Employee1', 'Employee1', 1);
insert into employees (employee_id, first_name, last_name, manager_id) values (5, 'Employee2', 'Employee2', 1);
insert into employees (employee_id, first_name, last_name, manager_id) values (6, 'Employee3', 'Employee3', 1);
insert into employees (employee_id, first_name, last_name, manager_id) values (7, 'Employee4', 'Employee4', 2);
insert into employees (employee_id, first_name, last_name, manager_id) values (8, 'Employee5', 'Employee5', 2);
insert into employees (employee_id, first_name, last_name, manager_id) values (9, 'Employee6', 'Employee6', 2);
insert into employees (employee_id, first_name, last_name, manager_id) values (10, 'Employee7', 'Employee7', 3);
insert into employees (employee_id, first_name, last_name, manager_id) values (11, 'Employee8', 'Employee8', 3);
insert into employees (employee_id, first_name, last_name, manager_id) values (12, 'Employee9', 'Employee9', 3);

insert into reports (report_id, date, text, employee_id) values (13, '2012-12-12', 'text1', 4);
insert into reports (report_id, date, text, employee_id) values (14, '2012-12-12', 'text2', 4);
insert into reports (report_id, date, text, employee_id) values (15, '2012-12-12', 'text3', 4);
insert into reports (report_id, date, text, employee_id) values (16, '2012-12-12', 'text4', 5);
insert into reports (report_id, date, text, employee_id) values (17, '2012-12-12', 'text5', 5);
insert into reports (report_id, date, text, employee_id) values (18, '2012-12-12', 'text6', 5);
insert into reports (report_id, date, text, employee_id) values (19, '2012-12-12', 'text7', 6);
insert into reports (report_id, date, text, employee_id) values (20, '2012-12-12', 'text8', 6);
insert into reports (report_id, date, text, employee_id) values (21, '2012-12-12', 'text9', 6);
insert into reports (report_id, date, text, employee_id) values (22, '2012-12-12', 'text10', 7);
insert into reports (report_id, date, text, employee_id) values (23, '2012-12-12', 'text11', 7);
insert into reports (report_id, date, text, employee_id) values (24, '2012-12-12', 'text12', 7);
insert into reports (report_id, date, text, employee_id) values (25, '2012-12-12', 'text13', 8);
insert into reports (report_id, date, text, employee_id) values (26, '2012-12-12', 'text14', 8);
insert into reports (report_id, date, text, employee_id) values (27, '2012-12-12', 'text15', 8);
insert into reports (report_id, date, text, employee_id) values (28, '2012-12-12', 'text16', 9);
insert into reports (report_id, date, text, employee_id) values (29, '2012-12-12', 'text17', 9);
insert into reports (report_id, date, text, employee_id) values (30, '2012-12-12', 'text18', 9);
insert into reports (report_id, date, text, employee_id) values (31, '2012-12-12', 'text19', 10);
insert into reports (report_id, date, text, employee_id) values (32, '2012-12-12', 'text20', 10);
insert into reports (report_id, date, text, employee_id) values (33, '2012-12-12', 'text21', 10);
insert into reports (report_id, date, text, employee_id) values (34, '2012-12-12', 'text22', 11);
insert into reports (report_id, date, text, employee_id) values (35, '2012-12-12', 'text23', 11);
insert into reports (report_id, date, text, employee_id) values (36, '2012-12-12', 'text24', 11);
insert into reports (report_id, date, text, employee_id) values (37, '2012-12-12', 'text25', 12);
insert into reports (report_id, date, text, employee_id) values (38, '2012-12-12', 'text26', 12);
insert into reports (report_id, date, text, employee_id) values (39, '2012-12-12', 'text27', 12);

insert into tasks (task_id, assign_date, due_date, text, employee_id) values (40, '2012-09-09', '2012-12-12','text28', 4);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (41, '2012-09-09', '2012-12-12','text28', 4);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (42, '2012-09-09', '2012-12-12','text28', 4);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (43, '2012-09-09', '2012-12-12','text28', 4);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (44, '2012-09-09', '2012-12-12','text28', 4);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (45, '2012-09-09', '2012-12-12','text28', 5);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (46, '2012-09-09', '2012-12-12','text28', 5);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (47, '2012-09-09', '2012-12-12','text28', 5);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (48, '2012-09-09', '2012-12-12','text28', 5);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (49, '2012-09-09', '2012-12-12','text28', 5);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (50, '2012-09-09', '2012-12-12','text28', 6);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (51, '2012-09-09', '2012-12-12','text28', 6);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (52, '2012-09-09', '2012-12-12','text28', 6);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (53, '2012-09-09', '2012-12-12','text28', 6);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (54, '2012-09-09', '2012-12-12','text28', 6);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (55, '2012-09-09', '2012-12-12','text28', 7);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (56, '2012-09-09', '2012-12-12','text28', 7);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (57, '2012-09-09', '2012-12-12','text28', 7);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (58, '2012-09-09', '2012-12-12','text28', 7);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (59, '2012-09-09', '2012-12-12','text28', 8);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (60, '2012-09-09', '2012-12-12','text28', 8);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (61, '2012-09-09', '2012-12-12','text28', 8);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (62, '2012-09-09', '2012-12-12','text28', 8);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (63, '2012-09-09', '2012-12-12','text28', 8);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (64, '2012-09-09', '2012-12-12','text28', 9);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (65, '2012-09-09', '2012-12-12','text28', 9);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (66, '2012-09-09', '2012-12-12','text28', 9);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (67, '2012-09-09', '2012-12-12','text28', 9);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (68, '2012-09-09', '2012-12-12','text28', 10);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (69, '2012-09-09', '2012-12-12','text28', 10);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (70, '2012-09-09', '2012-12-12','text28', 10);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (71, '2012-09-09', '2012-12-12','text28', 10);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (72, '2012-09-09', '2012-12-12','text28', 11);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (73, '2012-09-09', '2012-12-12','text28', 11);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (74, '2012-09-09', '2012-12-12','text28', 11);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (75, '2012-09-09', '2012-12-12','text28', 11);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (76, '2012-09-09', '2012-12-12','text28', 11);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (77, '2012-09-09', '2012-12-12','text28', 12);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (78, '2012-09-09', '2012-12-12','text28', 12);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (79, '2012-09-09', '2012-12-12','text28', 12);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (80, '2012-09-09', '2012-12-12','text28', 12);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (81, '2012-09-09', '2012-12-12','text28', 12);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (82, '2012-09-09', '2012-12-12','text28', 12);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (83, '2012-09-09', '2012-12-12','text28', 4);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (84, '2012-09-09', '2012-12-12','text28', 4);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (85, '2012-09-09', '2012-12-12','text28', 4);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (86, '2012-09-09', '2012-12-12','text28', 4);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (87, '2012-09-09', '2012-12-12','text28', 4);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (88, '2012-09-09', '2012-12-12','text28', 4);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (89, '2012-09-09', '2012-12-12','text28', 4);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (90, '2012-09-09', '2012-12-12','text28', 4);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (91, '2012-09-09', '2012-12-12','text28', 4);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (92, '2012-09-09', '2012-12-12','text28', 8);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (93, '2012-09-09', '2012-12-12','text28', 8);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (94, '2012-09-09', '2012-12-12','text28', 8);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (95, '2012-09-09', '2012-12-12','text28', 8);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (96, '2012-09-09', '2012-12-12','text28', 8);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (97, '2012-09-09', '2012-12-12','text28', 8);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (98, '2012-09-09', '2012-12-12','text28', 8);
insert into tasks (task_id, assign_date, due_date, text, employee_id) values (99, '2012-09-09', '2012-12-12','text28', 8);
