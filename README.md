# springboot_tuto_api_database_postgresql

eclipse with springboot initializer

java project, maven

dependencies:
Spring web  
Spring Data Jpa
PostgreSQL Driver
Lombok


source: https://www.youtube.com/watch?v=vpf4LB54rVw

## application.properties
//connect to db  

spring.datasource.url=jdbc:postgresql://localhost:5432/spring  
spring.datasource.username=postgres 
spring.datasource.password=root  

//auto create tables  

spring.jpa.hibernate.ddl-auto=update  

## create employee:
/api/employees

POST  
json in body:  
{      
    "fname": "John2",  
    "lname": "Doe2",  
    "email": "email2" !unique!  
}  


