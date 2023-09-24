<h1><b> Token Generator:</b></h1>

This service used to generate token for the given digits. 
1. This generator create the token randomly for the given digits
2. Input digits should consists of 0-9 digits
3. Generated token should contain the given digits

  API : http://localhost:8082/token/generate
  
  Method : POST
  
<b>  Request Body : </b>
  
    {
      "inputDigit": "2,8,7"
    }

<h3><b>Input Validation :</b></h3>
i) It allows only single digit with comma seperator

  Ex) 
   
  http://localhost:8082/token/generate
   
 <b> Request Body: </b>
    
      {
        "inputDigit": "2,8,78"
      }

 <b>  Response: </b>
   
      {
        "status": 500,
        "errorMessage": "Please enter single digit 0-9 to generate token"
      }
  HTTP Response Status Code 500

<h3><b>Test Case Scenario:</b></h3>

<b>a) Success Case: </b>
   
http://localhost:8082/token/generate

<b>Request Body:</b>
    
      {
        "inputDigit": "6,8,0"
      }

<b>Response:</b>

      {
        "token": "8806-6806-0880-6860",
        "message": "Token Generated"
      }
      
  Http Response Status Code : 201
  
  <b> Token number should contain only the given digit 6,8,0 </b>

<b>  b) Failure Case:</b>
  
  http://localhost:8082/token/generate

  Request Body:
    
    {
      "inputDigit": "6,8,70"
    }

Response:    
     
     {
        "status": 500,
        "errorMessage": "Please enter single digit 0-9 to generate token"
      }
      
Http Response Status Code : 500
    
<b> Input digit contains 2 digit </b>

<h3><b>Service Details:</b></h3>
<b>
Application Name -> Generator
  
Server Port -> 8082

Service URL -> http://localhost:8082

Swagger URL -> http://localhost:8082/swagger-ui/index.html

</b>
<h3><b>Build Details:</b></h3>
<b>
Build Command --> mvn clean install

Run Command --> java -jar generator-0.0.1-SNAPSHOT.jar
</b>


