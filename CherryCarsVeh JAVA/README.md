## CherryCars Vehicle Management Application ##
### Overview ###
CherryCars is a Java console application developed as a university software-development project. It models a vehicle-rental business and lets a user interact with a small sample fleet through a text-based menu.
### Features ###
- Lists the vehicles in the sample fleet.
- Searches for vehicles by make.
- Supports renting and returning a vehicle using its registration number.
- Calculates rental costs based on a vehicle and rental duration.
- Displays current and previous rentals for the customer represented in the application.
- Includes vehicle types such as electric cars, non-electric cars and motorbikes.
### Technical concepts demonstrated ###
- Java and object-oriented programming: classes, objects, methods and inheritance.
- Collections: uses ArrayList to store and retrieve vehicle records.
- Conditional logic and loops: menu-driven interaction and handling user choices.
- Basic database connectivity work: the source includes a DatabaseHelper class using JDBC and MySQL Connector/J.
### Project structure ###
- src/main/ — application and vehicle-related classes.
- src/test/ — JUnit test classes.
- lib/ — project dependencies, including MySQL Connector/J and JUnit.
- bin/ — compiled output files included in the project workspace.
### Running the application ###
1. Install a compatible Java Development Kit (JDK).
2. Open the CherryCarsVeh folder in Visual Studio Code with the Java extensions installed, or open it in another Java IDE.
3. Build the project and run main.App.
4. Use the numbered menu options in the terminal and enter -1 to exit.
The application starts with sample vehicles created in code. The DatabaseHelper class contains a local MySQL configuration (vehicledb); database-backed use requires a matching database and schema to be configured. Do not assume the database is automatically set up by running the console application.
### Scope and limitations ###
This is an educational project rather than a production rental system. It uses sample data and a single example customer. Database configuration is local-development configuration and should be adapted before use on another machine. The project is presented as coursework demonstrating programming concepts, not as a deployed commercial application.