# Spring Boot Rest Api
 - Save a new transaction item
 - Get statistics about saved transaction items for the last 60 seconds
 
# Run with
 Run: `spring-boot-rest-api > mvn spring-boot:run`


# Saving transaction item

Method : HTTP.POST 
URL : http://localhost:8080/transactions

Request Input Test Data :

{
	"amount":1.3,
	"timestamp":1528041355161
}

Response : 

HTTP response code 201 if success
HTTP response code 204 if failure

# Getting statistics 

Method : HTTP.GET
URL : http://localhost:8080/statistics

Request Input Test Data :  No input required for this endPoint to execute just make a request

Response : Returns Json object with sum, avg, max, min, count fields.

{
    "sum": 1.3,
    "avg": 1.3,
    "max": 1.3,
    "min": 1.3,
    "count": 1
}
 
