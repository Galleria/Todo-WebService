#Todo WebService is created via spark java framework and uses swagger for api document. 
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
- plain text
___

###How to Compile Todo WebService
- via maven

###How to Run Todo WebService
- java -jar xxxxx.jar

___

###WIP (work in progress)
- design architecture
- create api
- add unit testing
- plugin swagger 
- compile and packing process

___

###API 
|       Detail       |          Service           |
|--------------------|----------------------------|
| get all todo list  |   /todos                   |
| get todo by id     |   /todos/:id               |
| create todo task   |   /todo/create             |
| edit todo task     |   /todo/:id/edit           |
| update todo task   |   /todo/:id/status/:status |
| delete todo task   |   /todo/:id/delete         |

###Todo Model
- id
- subject
- content
- status (pending/done)
