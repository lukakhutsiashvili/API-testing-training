# **API Testing with Rest Assured**
## **Project Overview**
This project automates API testing using **Rest Assured** and **TestNG**, validating **status codes, response headers, response bodies, and CRUD operations** for `https://jsonplaceholder.typicode.com/users`.  

---

## **Running All Tests**
To run all tests using **TestNG**, follow these steps:
1. Open **`src/test/resources/testng.xml`**.
2. **Right-click `testng.xml` → Click 'Run'** to execute all test cases.

---

## **✅ Implemented Tests**
### **1️⃣ Status Code Validation**
- **Test:** `verifyHttpStatusCode`
- **Request:** `GET /users`
- **Validation:** Status **200 OK**  

### **2️⃣ Response Header Validation**
- **Test:** `verifyContentTypeHeaderExists` → Ensures `Content-Type` header exists.  
- **Test:** `verifyContentTypeHeaderValue` → Validates `Content-Type = application/json; charset=utf-8`.  

### **3️⃣ Response Body Validation**
- **Test:** `verifyResponseBodyContainsTenUsers`
- **Validation:** Response contains **10 users**.  

### **4️⃣ CRUD Operations**
| Action          | HTTP Method | Endpoint   | Validation                      |
|----------------|------------|-----------|--------------------------------|
| **Create User** | `POST`      | `/users`  | Status **201**, user details  |
| **Get User**    | `GET`       | `/users/1` | Status **200**, ID matches    |
| **Update User** | `PUT`       | `/users/1` | Status **200**, name updated  |
| **Delete User** | `DELETE`    | `/users/1` | Status **200**                 |

---

### **🚀 Key Features**
✔ **Automates API testing with Rest Assured**  
✔ **Validates HTTP status codes, headers, and response bodies**  
✔ **Tests CRUD operations using POJO (`User.java`)**  
✔ **Runs tests in parallel with TestNG**  
✔ **Uses Jackson for JSON serialization**  
✔ **Follows clean code principles for maintainability**  
