##COMMON IONIC SPRING MYSQL PROJECT

This is a early simulation of a E-shop.

##REQUIREMENTS
Node.js,
Maven,
Mysql,
Java jdk 11.

##To initialize proyect:

1. Clone repository.

2. Import import.sql from path backend/ file to MySQL.

3. Create file aplication.properties using aplication.properties.model.txt schema.

4. Place there your MySql credentials.

With Administrator privilleges:

5. On root path execute npm i,

6. Then execute npm run update-launch to install packages and launch the project.

7. Or execute npm start if packages are installed.

8. It takes aproximetly 1 minute.

9. You can login with credentials:

    email: ruben@ruben.com

    password: 1234

Be FUN!!



##POSTMAN requests in CommonProyect to backend

#GET

users
http://localhost:8080/users/

#POST

users
http://localhost:8080/users/

Bodyraw (json)
json
{
  "email": "test2@test.com",
  "name": "test2",
  "password": "1234",
  "access": "user"
}
#GET

user for email
http://localhost:8080/users/ruben@ruben.com

#PUT

user by email
http://localhost:8080/users/test@test.com

Bodyraw (json)
json
{
  "email": "test@test.com",
  "name": "test-modified",
  "password": "",
  "access": "user"
}
#GET

employees
http://localhost:8080/employees/


#GET

employee for id
http://localhost:8080/employees/2


#POST

employee
http://localhost:8080/employees

Bodyraw (json)
json
{
  "employee_id": 0,
  "imageurl": "https://images.pexels.com/photos/2726111/pexels-photo-2726111.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
  "name": "Andrea Martín",
  "job": "Directora de Proyectos"
}

#PUT

employee by id
http://localhost:8080/employees/4

Bodyraw (json)
json
{
  "employee_id": 4,
  "imageurl": "https://images.pexels.com/photos/2726111/pexels-photo-2726111.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
  "name": "Andrea Martínez",
  "job": "Directora de Proyectos"
}

#GET

products
http://localhost:8080/products/

#GET

products by id
http://localhost:8080/products/1

#POST

product
http://localhost:8080/products

Bodyraw (json)
json
{
  "imageurl": "https://images.pexels.com/photos/248412/pexels-photo-248412.jpeg?cs=srgb&dl=pexels-pixabay-248412.jpg&fm=jpg",
  "name": "Leche Natural",
  "description": "Leche natural directa de la vaca",
  "price": 3.5
}

#DEL

user
http://localhost:8080/users/test@test.com

#DEL

product by id
http://localhost:8080/products/2

#DEL

employee
http://localhost:8080/employees/2
