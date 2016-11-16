#Todo WebService 
It's created via spark java framework and uses swagger for api document. 

see api document on swagger 
___

###Software Architure 
- java 1.8
- maven

___

###Software libraries and framework
- spark
- swagger
- gson
- junit
- mockito

___

###Standard format 
- json
- plain dssad

___

###How to Compile Todo WebService
- go to repository path
- mvn clean install
* please make sure about maven and java jdk setup.

###How to Run Todo WebService
- default port 8083
- java -jar todo-service-0.0.1-jar-with-dependencies.jar

___

###WIP (work in progress)
- ~~design architecture~~
- create todo api (wip)
- add unit testing (wip)
- plugin swagger 
- ~~compile and packing process~~

___

###API 
|       Detail            |          Service           |
|-------------------------|----------------------------|
| get all todo list       |   /todos                   |
| get todo by id          |   /todos/:id               |
| get todo list by status |   /todos/:status           |
| create todo task        |   /todo/create             |
| edit todo task          |   /todo/:id/edit           |
| update todo task        |   /todo/:id/status/:status |
| delete todo task        |   /todo/:id/delete         |

###Todo Model
- id
- subject
- content
- status (pending/done)
