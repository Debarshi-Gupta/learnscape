# learnscape



https://github.com/Debarshi-Gupta/learnscape/assets/85623275/457a195c-39ba-4155-b206-bdd29ce83706


Learnscape
Learnscape is a dynamic web application designed to revolutionize school management by providing seamless user and admin login systems. Built with Spring Boot and Thymeleaf, Learnscape offers a range of features to enhance the educational experience for young students.

Project Description
Learnscape is a comprehensive school management system that includes functionalities for user registration, user login, admin login, and various sections like Home, About Us, Contact, Courses, and Login. This project is designed to help schools manage their operations more efficiently and provide a better user experience for students and administrators.

Getting Started
Step 1: Clone the Repository
First, clone the repository to your local machine using the following command:

bash
Copy code
git clone https://github.com/yourusername/Learnscape.git
cd Learnscape
Step 2: Install Maven
Ensure you have Maven installed. You can download Maven from the official website and follow the installation instructions for your operating system.

To verify Maven installation, run:

bash
Copy code
mvn -version
Step 3: Build the Project
Navigate to the root directory of the project and run the following command to build the project:

bash
Copy code
mvn clean install
Step 4: Set Up the Database
Create a MySQL Database:
Open your MySQL client and create a new database named learnscape:

sql
Copy code
CREATE DATABASE learnscape;
Update Database Credentials:
Open the src/main/resources/application.properties file and update the database credentials to match your MySQL configuration:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/learnscape
spring.datasource.username=your_username
spring.datasource.password=your_password
Step 5: Run Database Migrations
Run the following command to apply database migrations using Flyway (assuming you have Flyway configured):

bash
Copy code
mvn flyway:migrate
Step 6: Run the Application
Start the Spring Boot application by running:

bash
Copy code
mvn spring-boot:run
Step 7: Access the Application
Open your web browser and navigate to:

arduino
Copy code
http://localhost:8080
You should now see the Learnscape application running, with the options to register, log in, and navigate through the various sections.







