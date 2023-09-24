<h1><b> Token Generator and Validation </b></h1>

This UI  used to generate token and validate it aganist with Luuh algorithm.

1. User choose any digit(0,9) shown in the multiselect option.
   
2. When user click on the generate button, the randomly generated token will display next to the <b>Generate</b> button.

   Success notification will populate on the right side.
   
4. When user click on the validate button, the generated token will get validated using Luul algorithm and the response will display next to <b>Validate</b> button.

   Success notification will populate on the right side.
   
6. When click on Reset button all values will get reset to empty.

<h2><b> Client Validation:</b></h2>

a) If backend service is down or not avaliable then the system throw <b> ' Network Error ' </b>

b) When user click <b>Generate</b> button without choosing digit from multioption the system populate <b> 'Please choose digit to generate token'</b>  error message
   
c) If user click <b>Validate</b> button without generate the token the system populate <b> 'Please generate the token before validate'</b> error message 

d) If user select one digit and click <b>Generate</b> button then the system populate <b> 'Please enter a minimum of 2 digit to generate token'</b> error message

   
</b>
<h3><b>Build Details:</b></h3>
<b>

NodeJS should get installed.

Build Command --> npm install

Run Command --> npm start

UI url --> http://localhost:3000/

</b>


<b>
    
    Node Version - 18.12.1   
</b>
