# backbase-api
[![Coverage Status](https://coveralls.io/repos/github/renamsavio/backbase-api/badge.svg?branch=master)](https://coveralls.io/github/renamsavio/backbase-api?branch=master)

- This is a Spring Camel project using Maven.
- It contains a REST API that provides a single resource that lists all ATM's of a given Dutch city.

- You will be able to use it by requesting the following URL (GET method):

    http://localhost:8080/backbase-api/rest/find-atm?city=[city] 
    e.g.: http://localhost:8080/backbase-api/rest/find-atm?city=Leiderdorp
    
- The security of the API was done by using Spring Security. The type of authentication is Basic. The user of the API needs to use the following credentials passing them in the header of the request to be able to access it.

 User: backbase
 Password: baseback
 
 - The API was implemented using Camel REST DSL (camel-servlet).
 
 The code is hosted in this public Github repository:
 
 https://github.com/renamsavio/backbase-api
 
 The code coverage is using Cobertura and Coveralls plugins to run the tests and generate the reports.
 
 Important note: There is an issue in the JSON data format coming from the external web service(https://www.ing.nl/api/locator/atms/), therefore I manipulate it in order to be able to unmarshal it.