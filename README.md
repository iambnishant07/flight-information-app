# flight-information-app
Project Description

The Flight Information Application is a Java-based GUI application that allows users to manage flight data. The application enables users to input flight details, display them in a table, sort flights by flight number, and export the data to a CSV file. It utilizes the Model-View-Controller (MVC) design pattern with a Flight class to represent the flight data, a FlightTest class to handle data management, and a Form1 class to provide the graphical user interface (GUI) for user interaction.
________________________________________
Installation Instructions
1.	Clone the repository:
git clone https://github.com/iambnishant07/flight-information-app.git 
2.	Navigate to the project directory:
cd flight-information-app
3.	Ensure that you have Java Development Kit (JDK) installed: This project requires Java 8 or higher. You can download the JDK from Oracle's official site.
4.	Compile the project: If you're using a command line, navigate to the project folder and run:
javac Form1.java Flight.java FlightTest.java
5.	Run the application: After compiling the project, you can run it using:
java Form1
________________________________________
Usage Instructions
1.	Start the Application: Once the application is launched, the main window will appear with input fields and buttons for adding, sorting, and exporting flight data.
2.	Add Flight Data:
o	Enter the flight information in the text field in comma-separated format (e.g., AirlineName, FlightNumber, Origin, Destination, Airfare, DepartureTime, ArrivalTime, FlightDuration).
o	Click the "Add Flight" button to add the flight to the list.
3.	View Flight Information: Click the "Show Flight Info" button to view all the added flights in a tabular format.
4.	Sort Flights: Click the "Sort Flights" button to sort the flights by their flight number in ascending order.
5.	Export to CSV: Click the "Export to CSV" button to export the flight information to a flights.csv file in the project directory.
________________________________________
Technologies and Tools Used
•	Java 8+: Programming language used for building the application.
•	Swing: GUI framework used to design the application interface.
•	JTable: For displaying flight data in a table.
•	FileWriter: Used for exporting the flight data to a CSV file.
•	Maven/Gradle (Optional): For dependency management if required (not used in this basic version, but could be added for future enhancements).
________________________________________
UML Diagram
You can view the UML diagram for this project by following this link:
Link to UML Diagram
________________________________________
Credits
•	Java Swing Documentation: For information on using the Swing framework to build GUI applications.
•	UML Tools: The UML diagram was generated using Draw.io for diagramming.
•	CSV Export Logic: Implemented using FileWriter class from Java.

