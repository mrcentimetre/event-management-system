# Event Management System

A Java Servlet-based web application for managing events with user authentication, event creation, updating, and deletion capabilities.

## Project Overview

This is a full-stack event management system built using Java Servlets, JSP, and MySQL. The application allows users to register, login, create events, view event details, update events, and delete events.

## Technology Stack

- **Backend**: Java Servlets (Servlet API 3.1)
- **Frontend**: JSP (JavaServer Pages), HTML, CSS
- **Database**: MySQL 5.1.48
- **Server**: Apache Tomcat 8.x/9.x
- **IDE**: Eclipse (Dynamic Web Project)
- **Build Tool**: Eclipse Java Builder
- **Libraries**:
  - JSTL 1.2 (JavaServer Pages Standard Tag Library)
  - MySQL Connector/J 5.1.48
  - JUnit 4.13

## Features

- User Authentication (Login/Registration)
- Event Creation with details:
  - Event Name
  - Event Type
  - Description
  - Date & Time
  - Location
  - Event Planner
- Event Management:
  - View Events
  - Update Event Details
  - Delete Events
- Database-driven data persistence

## Project Structure

```
CustomerDemo/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── customer/
│       │           ├── Customerinsert.java       # Event insertion servlet
│       │           ├── LoginServlet.java         # User authentication servlet
│       │           ├── UpdateCustomerServlet.java # Event update servlet
│       │           ├── DeleteCustomerServlet.java # Event deletion servlet
│       │           ├── CustomerDBUtil.java       # Database utility methods
│       │           ├── DBConnect.java            # Database connection handler
│       │           └── customize.java            # Event model class
│       └── webapp/
│           ├── WEB-INF/
│           │   ├── web.xml                       # Servlet deployment descriptor
│           │   └── lib/                          # JAR dependencies
│           ├── userLogin.jsp                     # Login page
│           ├── eventRegistration.jsp             # Event creation form
│           ├── eventView.jsp                     # Event details view
│           ├── eventUpdate.jsp                   # Event update form
│           ├── eventDelete.jsp                   # Event deletion confirmation
│           ├── eventSuccess.jsp                  # Success message page
│           └── eventUnsuccess.jsp                # Error message page
├── .classpath                                    # Eclipse classpath config
├── .project                                      # Eclipse project config
└── .settings/                                    # Eclipse settings
```

## Servlet Mappings

| Servlet | URL Pattern | Description |
|---------|-------------|-------------|
| LoginServlet | `/log` | User authentication |
| Customerinsert | `/insert` | Event creation |
| UpdateCustomerServlet | `/update` | Event modification |
| DeleteCustomerServlet | `/delete` | Event deletion |

## Prerequisites

1. **Java Development Kit (JDK)** 8 or higher
   - Download from [Oracle](https://www.oracle.com/java/technologies/downloads/) or use OpenJDK

2. **Apache Tomcat** 8.x or 9.x
   - Download from [Apache Tomcat](https://tomcat.apache.org/download-90.cgi)

3. **MySQL Server** 5.x or higher
   - Download from [MySQL](https://dev.mysql.com/downloads/mysql/)

4. **Eclipse IDE** (Optional but recommended)
   - Eclipse IDE for Enterprise Java and Web Developers
   - Download from [Eclipse](https://www.eclipse.org/downloads/)

## Database Setup

### 1. Create Database

```sql
CREATE DATABASE event;
USE event;
```

### 2. Create Table

```sql
CREATE TABLE customize (
    eventid INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(100),
    description TEXT,
    date VARCHAR(50),
    time VARCHAR(50),
    location VARCHAR(255),
    planner VARCHAR(255),
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
);
```

### 3. Configure Database Connection

Edit `CustomerDemo/src/main/java/com/customer/DBConnect.java`:

```java
private static String url = "jdbc:mysql://localhost:3306/event";
private static String userName = "root";
private static String password = "YOUR_PASSWORD";  // Change this to your MySQL password
```

**IMPORTANT**: Update the password to match your MySQL root password.

## Installation & Setup

### Method 1: Using Eclipse (Recommended)

1. **Import Project**
   - Open Eclipse
   - File → Import → Existing Projects into Workspace
   - Select the `CustomerDemo` folder
   - Click Finish

2. **Configure Tomcat Server**
   - Window → Preferences → Server → Runtime Environments
   - Click "Add" → Apache Tomcat v9.0
   - Browse to your Tomcat installation directory
   - Click Finish

3. **Run the Application**
   - Right-click on the project → Run As → Run on Server
   - Select configured Tomcat server
   - Click Finish

4. **Access the Application**
   - Open browser: `http://localhost:8080/CustomerDemo/userLogin.jsp`

### Method 2: Manual Deployment with Tomcat

1. **Build the WAR file**
   ```bash
   cd CustomerDemo
   jar -cvf CustomerDemo.war -C src/main/webapp/ .
   ```

2. **Copy WAR to Tomcat**
   ```bash
   cp CustomerDemo.war $TOMCAT_HOME/webapps/
   ```

3. **Start Tomcat**
   ```bash
   # On Linux/Mac
   $TOMCAT_HOME/bin/startup.sh

   # On Windows
   %TOMCAT_HOME%\bin\startup.bat
   ```

4. **Access the Application**
   - Open browser: `http://localhost:8080/CustomerDemo/userLogin.jsp`

### Method 3: Using Command Line (with existing build)

```bash
# Navigate to Tomcat bin directory
cd $TOMCAT_HOME/bin

# Copy the project to webapps
cp -r /path/to/CustomerDemo $TOMCAT_HOME/webapps/

# Start Tomcat
./startup.sh  # Linux/Mac
startup.bat   # Windows

# View logs
tail -f ../logs/catalina.out  # Linux/Mac
```

## Usage

### 1. Create an Event
- Navigate to `eventRegistration.jsp`
- Fill in event details (name, type, description, date, time, location, planner)
- Provide username and password for authentication
- Submit the form

### 2. Login
- Navigate to `userLogin.jsp`
- Enter your username and password
- Login to view your events

### 3. View Events
- After login, you'll be redirected to view your events
- Event details are displayed from the database

### 4. Update Event
- Click on update button next to an event
- Modify event details
- Submit to save changes

### 5. Delete Event
- Click on delete button next to an event
- Confirm deletion
- Event will be removed from database

## Configuration

### Port Configuration
Default Tomcat port is 8080. To change:
1. Edit `$TOMCAT_HOME/conf/server.xml`
2. Find `<Connector port="8080" ...>`
3. Change port number
4. Restart Tomcat

### Database Configuration
All database settings are in `DBConnect.java`:
- Host: `localhost`
- Port: `3306`
- Database: `event`
- Username: `root`
- Password: Update as needed

## Troubleshooting

### Database Connection Issues
- Verify MySQL is running: `sudo systemctl status mysql` (Linux) or check Services (Windows)
- Check credentials in `DBConnect.java`
- Verify database and table exist
- Ensure MySQL Connector JAR is in `WEB-INF/lib/`

### Tomcat Server Issues
- Check if port 8080 is already in use
- View Tomcat logs: `$TOMCAT_HOME/logs/catalina.out`
- Ensure JAVA_HOME is set correctly

### 404 Errors
- Verify the context path is correct: `/CustomerDemo/`
- Check servlet mappings in `web.xml`
- Ensure JSP files are in `webapp/` directory

### Compilation Errors
- Verify all JAR files are in `WEB-INF/lib/`
- Check Java version compatibility
- Clean and rebuild project in Eclipse

## Security Considerations

**WARNING**: This project is for educational purposes. Before deploying to production:

1. **SQL Injection**: The current code is vulnerable to SQL injection. Use PreparedStatement instead of Statement
2. **Password Storage**: Passwords are stored in plain text. Implement password hashing (BCrypt, PBKDF2)
3. **Session Management**: Implement proper session handling and timeout
4. **Input Validation**: Add server-side validation for all inputs
5. **HTTPS**: Use HTTPS in production environments
6. **Error Handling**: Avoid exposing sensitive error details to users

## Future Enhancements

- [ ] Implement password encryption
- [ ] Add user registration functionality
- [ ] Implement role-based access control
- [ ] Add search and filter functionality for events
- [ ] Export events to CSV/PDF
- [ ] Email notifications for events
- [ ] Event categories and tags
- [ ] Calendar view integration
- [ ] REST API endpoints
- [ ] Migrate to Spring Boot framework

## License

This project is for educational purposes.

## Contact

For questions or issues, please refer to the project documentation or contact the development team.

---

**Last Updated**: October 2025