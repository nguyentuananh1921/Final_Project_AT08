# Final_Project_AT08
## OverView
This project aims to automate the testing process for the website https://hrm.anhtester.com/ using automated tests.It includes various functionalities including managing **clients**, **projects**, **tasks**, updating **project status**, **attaching files** and generating logs, reports, video recordings and screenshots for failed cases using **Allure** or **Extent** frameworks. Additionally, it supports parallel execution for efficient testing and uses configuration parameters from properties files and test data from Excel files.
## Features
### Manage Clients
- Add clients: Ensure that users can add new clients to the system.
-  Edit clients: Verify that editing client information works correctly.
-  Delete clients: Ensure that the client can be removed from the system.
### Authentication Testing
- Test login functionality for newly created client accounts.

  - Check invalid username.
  - Check invalid password.
  - Check successful login.
### Manage Projects
- Add projects: Make sure users can create new projects.
- Edit projects: Check the project's ability to update information.
- Delete projects: Verify that the project can be deleted from the system.
  - Edit Projects status: Make sure that the project status is edited properly.
  - Add Task: Make sure the task is added to the project

- Add Task for Projects
  - Delete Task
  - Status

- Update status for Projects
  - File Attachment
  - Add attachments to projects.
### Manage Tasks
- Add task: Test the ability to add new tasks to the system.
- Edit task: Ensure that editing of the current task is done correctly.
- Delete tasks: Confirm that the task can be deleted successfully.
### Logging and Reporting
- Generate logs, reports, and screenshots for failed test cases.
  - Utilizes Allure or Extent frameworks.
### Parallel Execution
- Execute tests in parallel for optimal efficiency.
  - Configuration Parameters
  - Manage configuration parameters via properties files.
### Test Data
- Utilize test data from Excel files.
  - Data is organized into sheets and files for ease of access.
## Getting Started
1. Clone the repository.
2. Set up dependencies as specified in the documentation.
3. Configure properties files with appropriate parameters.
4. Prepare test data in Excel files.
5. Run tests using your preferred testing framework.
## Dependencies
- Selenium Java (org.seleniumhq.selenium:selenium-java:4.25.0)
- TestNG (org.testng:testng:7.4.0)
- Apache POI (org.apache.poi:poi:5.2.5)
- Apache POI OOXML (org.apache.poi:poi-ooxml:5.3.0)
- Commons IO (commons-io:commons-io:2.17.0)
- Log4j Core (org.apache.logging.log4j:log4j-core:2.24.1)
- Log4j API (org.apache.logging.log4j:log4j-api:2.24.1)
- SLF4J API (org.slf4j:slf4j-api:2.0.16)
- SLF4J Simple (org.slf4j:slf4j-simple:2.0.16)
- Monte Screen Recorder (com.github.stephenc.monte:monte-screen-recorder:0.7.7.0)
- Extent Reports (com.aventstack:extentreports:5.1.2)
- Allure TestNG (io.qameta.allure:allure-testng:2.29.0)
- Allure Attachments (io.qameta.allure:allure-attachments:2.29.0)
- AspectJ Weaver (org.aspectj:aspectjweaver:1.9.22.1)
- Lombok (org.projectlombok:lombok:1.18.34)
- datafaker(net.datafaker:datafaker: 2.4.0)
License
- Apache License
## Authors
- Nguyen Tuan Anh
