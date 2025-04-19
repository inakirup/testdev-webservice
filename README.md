# Insurance Policy Web Service - React & Spring Boot Integration

This project consists of a Spring Boot backend that provides policy information via a REST API and an React frontend that allows users to search for policies by insured name.

## Project Structure

### Backend (Spring Boot)
- Java models that match the request/response structure
- REST controller for handling API requests
- Service layer for business logic

### Frontend (React)
- Components for policy search and displaying results
- Service for API communication

### Backend Setup
   ```
   testdev-webservice\springboot-backend\src\main\java\com\example\testdev
   ├── TestdevApplication.java
   ├── controller/
   │   └── PolicyController.java
   ├── model/
   │   ├── HeaderDataRequest.java
   │   ├── HeaderDataResponse.java
   │   ├── Policy.java
   │   ├── PolicyResponse.java
   │   ├── PolicyRequest.java
   │   ├── RequestRecord.java
   │   ├── ResponseRecord.java
   │   └── ResponseStatus.java
   └── service/
       └── PolicyService.java
   ```

**Configure application.properties**:
   ```properties
   server.port=8080
   ```

**Build and run the Spring Boot application**:
   ```bash
   ./mvnw spring-boot:run
   ```

### Frontend Setup
   ```
   testdev-webservice\react-frontend\src
   ├── App.css
   ├── App.js
   ├── index.css
   ├── index.js
   ├── components/
   │   ├── PolicyComponent.css
   │   └── PolicyComponent.jsx
   └── services/
       └── PolicyService.js
   ```

## Testing

1. Access the React application at `http://localhost:3000`
2. Enter "นายA1" as the insured name to see a successful policy response
3. Enter any other name to see an error response

![interface](interface.png)

## API Documentation

### Retrieve Policy Information

**Endpoint**: POST /api/policy/retrieve

**Request Body**:
```json
{
  "headerData": {
    "messageId": "string",
    "sendDateTime": "string"
  },
  "requestRecord": {
    "insureName": "string"
  }
}
```

**Response Body**:
```json
{
  "headerData": {
    "messageId": "string",
    "sendDateTime": "string",
    "responseDateTime": "string"
  },
  "responseRecord": {
    "policy": [
      {
        "policyNo": "string",
        "status": "string",
        "agentID": "string"
      }
    ],
    "policyNo": "string",
    "policyType": "string",
    "status": "string",
    "agentID": "string"
  },
  "responseStatus": {
    "status": "string",
    "errorCode": "string",
    "errorMessage": "string"
  }
}
```
