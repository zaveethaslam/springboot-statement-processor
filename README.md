This repository is a demonstration of how spring boot works with angular UI. This consist of two parts, one for backend connectivity and another for frontend. 
The service is deployed in Heroku for demonstration purposes. 

>UI - https://rbuistatement.herokuapp.com/  [repository: angular_statement_process]

>Backend - https://rbbstatement.herokuapp.com/ [repository : springboot-statement-processor]

Note: This is deployed only for demonstration purposes. Hit the URL for the first time and wait for 30 seconds to bring up the service. Also, check for https://rbbstatement.herokuapp.com/actuator/health to verify whether service is up or not. 


The backend service is designed to receive a JSON data to validate the monthly deliveries of customer statement records and validates the below,
1. All transaction references should be unique 
2. The end balance needs to be validated ( Start Balance  Mutation +AD0- End Balance


How the application works +ACEAIQAh-

1. Open https://rbuistatement.herokuapp.com/. It lands you in the homepage, where you will be preset of values for testing 6 scenarions. 
	- Data for normal scneario, where you get SUCCESSFUL in the response
	- Data for Duplicate Records, Unbalance Data, Bad Request and Internal Service Errors. 
	- The data will be loaded on the screen upon clicking individual buttons. 

![HomePage](/readme-documentation/0.PNG)

2. Click Generate Data for Successful Button on the screen and the data will be loaded on the screen. Now, click Process entries button. 
![HomePage](/readme-documentation/1.1.PNG)

3. After clicking Process entries, data will be loaded in the response area. 
![HomePage](/readme-documentation/1.2.PNG)

4. Click Generate for Generate Data for Duplicate Records, response data with DUPLICATE_REFERENCE will be populated in the reponse area. 
![HomePage](/readme-documentation/2.1.PNG)

5. Click Generate for Generate Data for UnBalanced Records, response data with INCORRECT_END_BALANCE will be populated in the reponse area. 
![HomePage](/readme-documentation/3.1.PNG)

6. Click Generate for Generate Data for Duplicated and UnBalanced Records, response data with DUPLICATE_REFERENCE_INCORRECT_END_BALANCE will be populated in the reponse area. 
![HomePage](/readme-documentation/4.1.PNG)

7. Click Generate for Generate Data for Bad Records, response data with BAD_REQUEST will be populated in the reponse area. 
![HomePage](/readme-documentation/5.1.PNG)

8. Click Generate for Generate Data for Internal Server Error, response data with INTERNAL_SERVER_ERROR will be populated in the reponse area. 
![HomePage](/readme-documentation/6.1.PNG)
