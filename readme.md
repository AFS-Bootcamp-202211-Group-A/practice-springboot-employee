## Employees

GET /employees | Get all employees

GET /employees/1 | Get employee id = 1

GET /employees?gender=male | Get male employee
{
"id": 5,
"name": "Lily",
"age": 20,
"gender": "Female",
"salary": 8000
}

POST /employees | add an employee


PUT /employees | update an employee

DELETE /employees | delete an employee

GET /employees?page=1&pageSize=5 | page query, page equals 1, page size equal 5

## Company

GET       /companies    #obtain company list

GET       /companies/1  #obtain a certain specific company

GET       /companies/1/employees  # obtain list of all employee under a certain
specific company

GET       /companies?page=1&pageSize=5  #Page query, if page equals 1, pageSize equals 5, it will return the data in company list from index 0 to index 4.

POST      /companies    #add a company

PUT       /companies/1  #update a company name

DELETE    /companies/1  # delete a company