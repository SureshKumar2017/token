<h1><b> Token Validator:</b></h1>

This service used to validate the given token number.

1. This validator uses Lunh algorithm to check the token is valid or not: https://en.wikipedia.org/wiki/Luhn_algorithm
2. Input token should be in 16 digit format XXXX-XXXX-XXXX-XXXX e.g 2249-4472-0279-9420

API :
http://localhost:8081/token/validate/{token}

Http Method : GET

<h3><b>Input Validation :</b></h3>

i) It allows only digit if not it return 500 status code with invalid token format message
Ex)  http://localhost:8081/token/validate/5546-8329-1703-908d

    {
      "status": 500,
      "errorMessage": "Invalid token format. Please validate the token format"
    }

<h3><b>Test Case Scenario:</b></h3>

If client validation success, the service validate the input token using Lunh algorithm and return the proper response as follows
  
a) Success Case: 
    http://localhost:8081/token/validate/9963-4081-5724-6381
    
    {
      "status": "Success",
      "message": "Token is VALID"
    }
  
  <b> Token number 9963-4081-5724-6381 is valid as per LnnhAlgothim </b>

  b) Failure Case:
     http://localhost:8081/token/validate/5546-8329-1703-9087
     
    {
    "status": "Fail",
    "message": "Token is INVALID"
    }
  
   <b> Token number 5546-8329-1703-9087 is invalid as per LnnhAlgothim </b>

<h3><b>Service Details:</b></h3>
<b>
Application Name -> Validator
  
Server Port -> 8081

Service URL -> http://localhost:8081

Swagger URL -> http://localhost:8081/swagger-ui/index.html

</b>
<h3><b>Build Details:</b></h3>
<b>
Build Command --> mvn clean install

Run Command --> java -jar validator-0.0.1-SNAPSHOT.jar
</b>


