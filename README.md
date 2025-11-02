Healthcare Insurance Backend

A complete Spring Boot backend application for healthcare insurance management.

-> Features
- ✅ User Authentication (Register/Login)
- ✅ Patient Management & CRUD Operations
- ✅ Document Verification System
- ✅ Insurance Applications (Emergency & Planned)
- ✅ Policy Management & Status Tracking
  
-> Technology Stack
 
- **Java 17** with **Spring Boot 3.2.0**
- **Spring Data JPA** for database operations
- **H2 Database** (can be configured for MySQL)
- **Maven** for dependency management
- **REST API** architecture

  API Endpoints

-> Authentication

- 'POST /api/auth/register' - User registration
- 'POST /api/auth/login' - User login

-> Patient Management

- 'GET /api/patients' - Get all patients
- 'POST /api/patients' - Create new patient
- 'GET /api/patients/{id}' - Get patient by ID
- 'PUT /api/patients/{id}/documents' - Update document info
-> Insurance Management
  
- 'POST /api/insurance/emergency' - Apply for emergency insurance
- 'POST /api/insurance/planned' - Apply for planned insurance
- 'GET /api/insurance/policies' - Get all policies
- 'GET /api/insurance/status/{policyNumber}' - Check policy status

-> Setup & Installation

1. Clone the repository
2. Configure database in: 'application.properties'
3. Run: 'mvn spring-boot:run'
4. Access API at: 'http://localhost:8080'

Deployment
The application is configured to run as a systemd service on Linux servers.
