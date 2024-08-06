# Running the Frontend and Backend Applications

## Running the Backend (Spring Boot Application)

### Prerequisites:
- **Java Development Kit (JDK)**: Ensure JDK 11 or higher is installed.
- **Maven**: Make sure Apache Maven is installed and available in your PATH.
- **MySQL Database**: Ensure MySQL is installed and running, and you have a database created for the application.

### Steps:

1. **Clone the Repository**:
    - Clone your backend application repository from your version control system.

2. **Configure Database Connection**:
    - Open `application.properties` or `application.yml` and configure the database connection settings:
      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/taskmngdb?useSSL=false
      spring.datasource.username=your-username
      spring.datasource.password=your-password
      spring.jpa.hibernate.ddl-auto=update
      ```

3. **Build the Application**:
    - Navigate to the root directory of your backend application in the terminal.
    - Run the following command to build the application:
      ```bash
      mvn clean install
      ```

4. **Run the Application**:
    - Start the Spring Boot application by running:
      ```bash
      mvn spring-boot:run
      ```
    - Alternatively, you can run the JAR file directly:
      ```bash
      java -jar target/your-app-name.jar
      ```
    - Ensure the application is running on `http://localhost:8080`.

## Running the Frontend (AngularJS Application)

### Prerequisites:
- **Visual Studio Code (VS Code)**: Ensure VS Code is installed.
- **Live Server Extension**: Install the Live Server extension from the VS Code marketplace.

### Steps:

1. **Open the Project in VS Code**:
    - Open your AngularJS project directory in VS Code.

2. **Install the Live Server Extension**:
    - If you haven’t installed the Live Server extension yet, go to the Extensions view in VS Code (click on the square icon in the sidebar) and search for "Live Server".
    - Install the extension by Ritwick Dey.

3. **Start Live Server**:
    - Open your `index.html` file in VS Code.
    - Right-click anywhere in the file and select "Open with Live Server".
    - This will start a local server and open your application in a web browser.

4. **Verify the Application**:
    - The Live Server will typically serve your application on `http://127.0.0.1:5500` or another port depending on your setup.
    - Verify that the frontend is properly interacting with the backend (e.g., displaying tasks, adding tasks, etc.).

### Additional Tips:

- **Browser Sync**: Live Server automatically reloads the page whenever you make changes to your files, making development smoother.
- **Cross-Origin Requests**: Ensure your backend (Spring Boot) is configured to allow requests from the frontend URL served by Live Server.