# courseEnroll
## COURSE ENROLLMENT MANAGEMENT SYSTEM Using Spring Boot 

Main target of this system is to Enroll the Undergraduates to their Course Units and Assign Lecturers to Respective Courses. 
MySQL Auto Generated Database is Used with the name of "enroll".

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

### Many to Many Relationship is Built for Courses and Undergraduates
  - 1 Undergraduate can follow Many courses
  - 1 Course unit Have Many Undergraduates
  So that Many courses Have Many Undergraduates

### One to Many Relationship is Built for Courses and Lecturers
  - 1 lecturer can conduct Many Courses
  - One Course have only 1 Lecturer

### One to One Relationship is Built For Under Graduates and Their Unique Personal details 


## Q & A
### What is Add attribute?
Its purpose is to add an attribute to the models defined in the controller class, So that it can be identified globally. 



