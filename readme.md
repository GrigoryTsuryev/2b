# Java Sample Code for the Interview project
[![Travis CI Status](https://travis-ci.org/AuthorizeNet/sample-code-java.svg?branch=master)](https://travis-ci.org/AuthorizeNet/sample-code-java)

This repository contains working code samples which demonstrate Java, Spring, Hibernate, Junit.

* The app allows to create manager, employee, assign manager to employee.
* To a manager assign a task to employee and find all tasks that were assigned to his employees, and find overloaded employees
* To an employee create a report and find all his reports.

For testing purposes data is loading on the start of application. It has 3 managers, 9 employees, amount of tasks and reports.

## Using the Sample Code

You can also run each sample directly from the command line.

## Running the Samples From the Command Line
* Clone this repository:
```
    $ git clone https://github.com/GrigoryTsuryev/2b.git
```
* Run "mvn package" in the root directory to create an app.

## Following RESTs are applied

1. Create Manager
POST
http://localhost:8080/managers/save 
```json
{
    "firstName": "firstName",
    "lastName": "lastName"
} 
```

2. To Create Employee
POST
http://localhost:8080/employees/save 
```json
{
    "firstName": "firstName",
    "lastName": "lastName"
}
```
3. Assign Employee to Manager
POST
http://localhost:8080/employees/relationship/assign?managerId=1&employeeId=4

4. Create Report
POST
http://localhost:8080/employees/4/report 
```json
{
    "text": "text111111111111111111111111",
    "date": "2020-12-12"
}
```

5. Get Reports of All Employees Assigned to a Manager
GET
http://localhost:8080/managers/1/reports

6. To Create Task
POST
http://localhost:8080/managers/1/employees/4/tasks 
```json
{
    "text": "text11111111111111111",
    "dueDate": "2022-12-12",
    "assignDate": "2021-12-12"
}
```

7. Check All Tasks by the Employee
GET
http://localhost:8080/employees/4/tasks 
8. Get Overloaded Employees
GET
http://localhost:8080/employees/overloaded



