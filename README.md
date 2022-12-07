GET     /employees              #get employee list
GET     /employees/1            #get employee with id 1
GET     /employees?gender=male  #get all male employees

POST      /employees                    # add an employee

                                        response status 201 created

PUT       /employees/1                  # update an employee age and salary

DELETE    /employees/1                  # delete an employee

                                        response status 204 no content

GET       /employees?page=1&pageSize=5  # Page query, page equals 1, pageSize equals 5


