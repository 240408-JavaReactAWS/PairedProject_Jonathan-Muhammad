# Project Name

## Description

This project is a simple API built with Spring Boot for creating and managing items. It allows users to store items and track them as needed. The API supports various user functionalities such as creating, viewing, updating, and deleting items, as well as managing customer accounts with different roles (USER and ADMIN).

## Endpoints

### Customer

#### GET /customer

- **HTTP Method:** GET
- **Endpoint:** /customer
- **Request Body:** JSON, customer class
- **Possible Responses:**
  - **200 OK:** Customer exists with correct username and password.
  - **401 Unauthorized:** Incorrect username or password.
  - **404 Not Found:** User does not exist.

#### PUT /customer

- **HTTP Method:** PUT
- **Endpoint:** /customer
- **Request Body:** JSON, customer class
- **Possible Responses:**
  - **200 OK:** Customer exists with correct username and password, values are updated.
  - **401 Unauthorized:** Incorrect username or password.
  - **404 Not Found:** User does not exist.

#### DELETE /customer

- **HTTP Method:** DELETE
- **Endpoint:** /customer
- **Request Body:** JSON, customer class
- **Possible Responses:**
  - **200 OK:** Customer exists with correct username and password, values are deleted.
  - **401 Unauthorized:** Incorrect username or password.
  - **404 Not Found:** User does not exist.

#### POST /customer

- **HTTP Method:** POST
- **Endpoint:** /customer
- **Request Body:** JSON, customer class
- **Possible Responses:**
  - **409 Conflict:** Customer exists.
  - **200 OK:** Customer doesn't exist, character is created, returns customer class as JSON.

### Items

#### POST /items

- **HTTP Method:** POST
- **Endpoint:** /items
- **Request Body:** JSON, Item class
- **Possible Responses:**
  - **200 OK:** Item added successfully.
  - **406 Not Acceptable:** Unsuccessful.

#### GET /items

- **HTTP Method:** GET
- **Endpoint:** /items
- **Request Body:** N/A
- **Possible Responses:**
  - **200 OK:** List all items.

#### GET /items/{id}

- **HTTP Method:** GET
- **Endpoint:** /items/{id}
- **Request Body:** N/A
- **Possible Responses:**
  - **200 OK:** Item with that ID exists.
  - **404 Not Found:** Item doesn't exist.

#### PUT /items

- **HTTP Method:** PUT
- **Endpoint:** /items
- **Request Body:** JSON, Item class
- **Possible Responses:**
  - **200 OK:** Item found and updated.
  - **404 Not Found:** Item not found.

#### DELETE /items/{id}

- **HTTP Method:** DELETE
- **Endpoint:** /items/{id}
- **Request Body:** N/A
- **Possible Responses:**
  - **200 OK:** Item found and deleted.
  - **404 Not Found:** Item not found.

### Orders

#### POST /orders

- **HTTP Method:** POST
- **Endpoint:** /orders
- **Request Body:** JSON, Order class
- **Possible Responses:**
  - **200 OK:** Order placed successfully.
  - **409 Conflict:** Not enough items available.
  - **404 Not Found:** Item not found.

#### GET /orders

- **HTTP Method:** GET
- **Endpoint:** /orders
- **Request Body:** JSON, Customer class
- **Possible Responses:**
  - **200 OK:** Logged-in check, admin or user role check, returns orders.
  - **404 Not Found:** No orders found.

