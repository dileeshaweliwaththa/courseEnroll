# COURSE ENROLLMENT MANAGEMENT SYSTEM
## Using Spring Boot 

Main target of this system is to Enroll the Undergraduates to their Course Units and Assign Lecturers to Respective Courses. 
MySQL Auto Generated Database is Used with the name of "enroll".

![image](https://user-images.githubusercontent.com/64683688/153193013-20ec68cd-d936-44c1-a9f2-a8db004f1e55.png)

## Dpendencies Used
- [x] ThymeLeaf
- [x] Spring Boot DevTools
- [x] Lombok 
- [x] MySQL Driver 
- [x] Spring Data JPA
- [x] Spring Web
- [x] Maven WebJars Dependencies For Bootstrap 5 and Jquery

Basic CRUD Operations are Done in the Frontend
CREATE | READ | UPDATE | DELETE

## Relationship Among Entities

![image](https://user-images.githubusercontent.com/64683688/153192767-e6bb6068-b5ca-4ca8-b62d-e5771cc14dab.png)

### Many to Many Relationship is Built for Courses and Undergraduates
  - 1 Undergraduate can follow Many courses
  - 1 Course unit Have Many Undergraduates
  So that Many courses Have Many Undergraduates

### One to Many Relationship is Built for Courses and Lecturers
  - 1 lecturer can conduct Many Courses
  - One Course have only 1 Lecturer

### One to One Relationship is Built For Under Graduates and Their Unique Personal details 

# In Screen Snaps

## Database
![image](https://user-images.githubusercontent.com/64683688/153201305-1bbe5b96-84f5-44a6-8c40-558f4bc0ea7d.png)

## Dashboard
![image](https://user-images.githubusercontent.com/64683688/153196819-cc24c487-6e70-4d55-b374-e738f2497318.png)

## Undergraduates Snaps
![image](https://user-images.githubusercontent.com/64683688/153194342-dec9d753-f2f4-4eb7-8bd2-9778edd17c74.png)

![image](https://user-images.githubusercontent.com/64683688/153194598-5a85a6ff-552f-412a-89d2-a8b6830ce013.png)

## Lectures Snaps
![image](https://user-images.githubusercontent.com/64683688/153195690-34401fdc-ffcd-423c-af1a-a13507303033.png)

![image](https://user-images.githubusercontent.com/64683688/153195459-9a3170d6-0fc5-4b83-952e-ddd8b40a031b.png)

## Courses Snaps
![image](https://user-images.githubusercontent.com/64683688/153196184-706b2fc4-d3b0-4cc8-970b-ffc397593a46.png)

![image](https://user-images.githubusercontent.com/64683688/153196302-b2420d99-c1d8-491f-93d4-0edbdc30e92e.png)


## Q & A
### What is Add attribute?
Its purpose is to add an attribute to the models defined in the controller class, So that it can be identified globally. 



