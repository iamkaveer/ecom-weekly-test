# ecom-weekly-test
# Spring Project Ecommerce API
### This project is a Spring-based API for an ecommerce platform. The API uses an H2 database and provides endpoints for creating users, products, addresses, and orders.

### User Model
#### The User model has the following attributes:
1. Id: integer
2. name: string
3. email: string
4. password: string
5. phoneNumber: string

### Product Model
#### The Product model has the following attributes:
1. id: integer
2. name: string
4. price: integer
5. description: string
6. category: string
7. brand: string

### Address Model
#### The Address model has the following attributes:
1. id: integer
2. name: string
3. landmark: string
4. phoneNumber: string
5. zipcode: string
6. state: string
7. UserID : foreign key mapping

### Order Model
#### The Order model has the following attributes:
1. id: integer
2. userID: integer (foreign key mapping)
3. productID: integer (foreign key mapping)
4. addressID: integer (foreign key mapping)
5. productQuantity: integer

### Steps
To use this API, follow these steps:
1. Create users using the /users endpoint.
2. Create products using the /products endpoint.
3. Create addresses using the /addresses endpoint.
4. Place an order using the /orders endpoint and providing the userId, productId, and addressId in the request body.
5. Get an order by id using the /orders/{id} endpoint.
6. Get a user by id using the /users/{id} endpoint.
7. Get all products using the /products endpoint.
8. You can filter products by category by using the category query parameter.
9. Delete a product by id using the /products/{id} endpoint.

### Technologies Used
#### This project was built using the following technologies:
  1. Spring Boot
  2. Java
  3. MySQL


