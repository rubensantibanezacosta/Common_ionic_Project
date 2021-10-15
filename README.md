# ​COMMON IONIC SPRING MYSQL PROJECT

This is a early simulation of a E-shop, using Ionic with Angular for Frontend, and Spring Boot and MySQL for Backend.

## ​REQUIREMENTS

### ​UBUNTU or WINDOWS

- Node.js

- NPM

- Maven (Remember that on Windows you have to configure your path variable &quot;MAVEN\_HOME&quot;)

- MySQL or MariaDB

- JDK 11.

## ​ **TO INITIALIZE**

1. Clone repository.

2. Import import.sql file from path backend/ to MySQL. `backend/import.sql`


3. Create file `aplication.properties` using `aplication.properties.model.txt` schema.

4. Place there your MySQL credentials.

Backend runs at port 8080, And Frontend runs default at port 8100.

With Administrator privilleges:

### ​ LINUX

- On root path execute `npm update`

- On root path execute `npm i`

- Then execute `npm run update-launch` to install packages and launch the project.

- Or execute `npm start` if packages are installed. It takes aproximetly 1 minute.

- It takes aproximetly 1 minute.

### ​ WINDOWS

- On root path execute `npm run w:install` to install packages.

- Or execute `npm run w:launch` if packages are installed to launch the project.

- It takes aproximetly 1 minute.

8. You can login with credentials:

email: `ruben@ruben.com`

password: `1234`

## ​_Be FUN!!_

## ​POSTMAN requests in CommonProyect to backend

### ​GET

users

http://localhost:8080/users/

### ​POST

users

http://localhost:8080/users/

Bodyraw (json)

json

{

&quot;email&quot;: &quot;test2@test.com&quot;,

&quot;name&quot;: &quot;test2&quot;,

&quot;password&quot;: &quot;1234&quot;,

&quot;access&quot;: &quot;user&quot;

}

### ​GET

user for email

http://localhost:8080/users/ruben@ruben.com

### ​PUT

user by email

http://localhost:8080/users/test@test.com

Bodyraw (json)

json

{

&quot;email&quot;: &quot;test@test.com&quot;,

&quot;name&quot;: &quot;test-modified&quot;,

&quot;password&quot;: &quot;&quot;,

&quot;access&quot;: &quot;user&quot;

}

### ​GET

employees

http://localhost:8080/employees/

### ​GET

employee for id

http://localhost:8080/employees/2

### ​POST

employee

http://localhost:8080/employees

Bodyraw (json)

json

{

&quot;employee\_id&quot;: 0,

&quot;imageurl&quot;: &quot;https://images.pexels.com/photos/2726111/pexels-photo-2726111.jpeg?auto=compress&amp;cs=tinysrgb&amp;dpr=1&amp;w=500&quot;,

&quot;name&quot;: &quot;Andrea Martín&quot;,

&quot;job&quot;: &quot;Directora de Proyectos&quot;

}

### ​PUT

employee by id

http://localhost:8080/employees/4

Bodyraw (json)

json

{

&quot;employee\_id&quot;: 4,

&quot;imageurl&quot;: &quot;https://images.pexels.com/photos/2726111/pexels-photo-2726111.jpeg?auto=compress&amp;cs=tinysrgb&amp;dpr=1&amp;w=500&quot;,

&quot;name&quot;: &quot;Andrea Martínez&quot;,

&quot;job&quot;: &quot;Directora de Proyectos&quot;

}

### ​GET

products

http://localhost:8080/products/

### ​GET

products by id

http://localhost:8080/products/1

### ​POST

product

http://localhost:8080/products

Bodyraw (json)

json

{

&quot;imageurl&quot;: &quot;https://images.pexels.com/photos/248412/pexels-photo-248412.jpeg?cs=srgb&amp;dl=pexels-pixabay-248412.jpg&amp;fm=jpg&quot;,

&quot;name&quot;: &quot;Leche Natural&quot;,

&quot;description&quot;: &quot;Leche natural directa de la vaca&quot;,

&quot;price&quot;: 3.5

}

### ​DEL

user

http://localhost:8080/users/test@test.com

### ​

### ​DEL

product by id

http://localhost:8080/products/2

### ​DEL

employee

http://localhost:8080/employees/2
