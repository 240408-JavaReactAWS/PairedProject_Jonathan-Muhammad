# Project Name

## Description
This project is a simple API built with Spring Boot for creating and managing items. It allows users to store items and track them as needed. The API supports various user functionalities such as creating, viewing, updating, and deleting items, as well as managing customer accounts with different roles (USER and ADMIN).

## User Stories
- As a user, I can create a new Item.
- As a user, I can view all Items.
- As a user, I can view a singular Item by its ID (Hint: Use Path Params to select an Item by its ID).
- As a user, I can update an Item (change the name or other properties).
- As a user, I can delete an Item by its ID (Hint: Use Path Params to select an Item by its ID).
- As a user, I can create an account to hold my Items.
- As a user, I can log in to my account (which is stored in the database).
- As a user, I can view the Items associated with my account.
- Giving accounts roles (USER and ADMIN) so Admins can view everyone's Items while a User can only view their own.
- Using JUnit to test Service Layer methods (70% coverage at least would be optimal).

## Models
### Customer
- username
- password
- customerId
- role

### Item
- itemId
- itemName
- itemPrice
- itemDescription
- itemStock

### Order
- orderId
- customerId
- itemId
- itemQuantity

## Endpoints
### Customer
- **GET** `/customer`
    - Takes JSON, customer class.
    - Return OK status if the customer exists with the correct username and password.
    - Return unauthorized if incorrect username or password.
    - Return Not Found if the user does not exist.

- **GET** `/customer/{id}`
    - Takes the parameter.
    - Return OK status if the customer exists with the correct username and password.
    - Return unauthorized if incorrect username or password.
    - Return Not Found if the user does not exist.

- **PUT** `/customer`
    - Takes JSON, customer class.
    - Return OK status if the customer exists with the correct username and password and values are updated.
    - Return unauthorized if incorrect username or password.
    - Return Not Found if the user does not exist.

- **DELETE** `/customer`
    - Takes JSON, customer class.
    - Return OK status if the customer exists with the correct username and password and values are deleted.
    - Return unauthorized if incorrect username or password.
    - Return Not Found if the user does not exist.

- **POST** `/customer`
    - Takes JSON, customer class.
    - Conflict if customer exists.
    - OK if customer doesn't exist and the character is created, also returns the customer class as JSON.

### Items
- **POST** `/items`
    - Takes Item as JSON.
    - Return OK if successful.
    - Return Not Acceptable if unsuccessful.

- **GET** `/items`
    - Returns List all Items with OK status.

- **GET** `/items/{id}`
    - Returns item with that ID if exists with OK.
    - Return Not Found if doesn't exist.

- **PUT** `/items`
    - Takes JSON items in the body.
    - OK if found and updated.
    - Not Found if not found.

- **DELETE** `/items/{id}`
    - Returns OK if found and deleted.
    - Return Not Found if not found.

### Orders
- **POST** `/orders`
    - Takes JSON in the form of an order model.
    - Checks if enough items.
        - Yes: Reduce from item stock and return OK.
        - No: Return Conflict.
    - Not Acceptable otherwise.

- **GET** `/orders`
    - Takes Customer Class as JSON.
    - Does a log-in check.
        - If incorrect, return Not Authorized.
        - If correct, check if role is ADMIN.
            - Yes: Return all orders.
            - No: Return that customer's orders.

## Tests
All tests are located in the test folder to ensure proper functionality and coverage of the service layer methods.
