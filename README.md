This repository is a demonstration of how spring boot works with angular UI. This consist of two parts, one for backend connectivity and another for frontend. 
The service is deployed in Heroku for demonstration purposes. 

+ACM-UI - https://rbuistatement.herokuapp.com/

+ACM-Backend - https://rbbstatement.herokuapp.com/ 

Note: This is deployed only for demonstration purposes. Hit the URL for the first time and wait for 30 seconds to bring up the service. 


The backend service is designed to receive a JSON data to validate the monthly deliveries of customer statement records and validates the below,
1. All transaction references should be unique 
2. The end balance needs to be validated ( Start Balance  Mutation +AD0- End Balance


How the application works +ACEAIQAh-

1. Open https://rbuistatement.herokuapp.com/. It lands you in the homepage, where you will be preset of values for testing 6 scenarions. 
	- Data for normal scneario, where you get SUCCESSFUL in the response
	- Data for Duplicate Records, Unbalance Data, Bad Request and Internal Service Errors. 
	- These data will be loaded on the screen upon clicking individual buttons. 



2. Click Generate Data for Successful Button on the screen and the data will be loaded on the screen. Now, click Process entries button. 


3. After clicking Process entries, data will be loaded in the response area. 
