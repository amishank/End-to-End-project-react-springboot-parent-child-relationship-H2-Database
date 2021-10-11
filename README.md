# End-to-End-project-react-springboot-parent-child-relationship-H2-Database


## Steps to run this project:

 1. Clone the project "git clone https://github.com/amishank/End-to-End-project-react-springboot-parent-child-relationship-H2-Database.git" .
 2. After cloning, two projects is downloaded i.e. 1) backend 2) frontend.
 3. First, start the backend service. Go to the backend project path and run this command in the cmd prompt "mvn spring-boot:run" and check if the backend service is up with port 8089.
 4. Then start the frontend service with project path till src by running these two commands in the cmd prompt: 1. "npm install" 2. "npm start". 
 5. Waiting for a few seconds will take time to open the home page.
 6. The first home page provides the details of the transaction service with a server-side paginated value of 2, and it also provides the sum of the total paid amount, i.e., the summation of the paid amount from Installment service with transaction id.
 7. Then click on Total Amount value in the UI table, it will be redirected to the Installment service and provides the details of the paid amount with a transaction Id which is mapped with Transaction Service.  
 
 
## Steps to test backend service :
 
 1. Go to the project path & run the command in the cmd prompt "mvn spring-boot:run"
 2. Spring boot application starts on port "8090".
 3. For start the H2 Database. Please click "http://8090/console" in the windows browser.
 4. For checking the list of records for Transaction details, use URL "http://localhost:8090/transaction" in Postman or windows browser.
 5. For the Pagination with sorted order by id, hit the URL "http://localhost:8090/transaction?page=0&size=2&sort=id,desc" in Postman or  windows browser.
 6. For getting the details of the Installment for any particular id, use the URL "http://localhost:8090/transaction/3/installment" in Postman or a windows browser. By default, it is coming in a sorted order as Descending by id.
 
 