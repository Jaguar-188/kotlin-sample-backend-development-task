# kotlin-sample-backend-development-task
## Dank - Backend Developer Assignment 

### Question
Your task is to create a RESTful API that allows users to manage their education history. Users should be able to add, delete, and update their education records. You need to implement the following APIs:

### Create a new education record:
* Endpoint: POST /api/education
* Request body: Education JSON object
* Response: The created education record with a generated ID
		
### Retrieve all education records for a user:
* Endpoint: GET /api/educations/{userId}
* Response: An array of Education JSON objects representing the user's education history
		
### Retrieve a specific education record by ID:
* Endpoint: GET /api/education/{id}
* Response: Education JSON object representing the specified education record
		
### Update an education record:
* Endpoint: PUT /api/education/{id}
* Request body: Updated Education JSON object
* Response: The updated education record
		
### Delete an education record:
* Endpoint: DELETE /api/education/{id}
* Response: A success message indicating the education record has been deleted

### Retrieve all unique users for a given institution ID, sorted by their “Name/Email”:
* Endpoint: GET /api/education/users
* Parameters: * institutionId (string) - ID of the institution
	      * sortBy (string, optional) - Field to sort the results (e.g., "name", "email")
	      * sortDirection (string, optional) - Sorting direction ("asc" for ascending, "desc" for descending)
	      * page (integer, optional) - Page number for pagination
	      * pageSize (integer, optional) - Number of results per page
* Response: An array of User JSON objects representing the unique users associated with the given institution ID, sorted and paginated 

### Extend the point 6 to include the sorting based on users connections. 
* I.e. users in the response list connected to the api calling user should show in the top. Assume the necessary services for pulling the user's connection are there. 
		
### Bonus: 
* Think about how we can extend point 7 to use the users degree of connectivity in the sorting as well. For example, direct connection comes on top, followed by 2nd degree connection, and so on and so forth.

## Example Data Model:
	
data class UserEducationHistory (
   val publicId: String,
   val userId: String,
   val institutionId: String,
   val institutionName: String,
   val degree: String,
   var name: String
   var email: String
   var mobileNumber: String
)


## Technical requirements 
Api should be implemented in Kotlin, SpringBoot, and MongoDB.
You can use spring initializers to create an app from scratch.
You can also include the swagger page for better testing of apis.
Please make your code available via github or gitlab and share a public link with us when you have completed the assignment.

## Evaluation Criteria 
Code quality.
Implementation according to requirements.
Expertise in using Kotlin, MongoDb.
Expertise in creating reusable code.

## Tips 
The goal of this task is to provide a discussion context for the subsequent technical interview and is not meant to be time consuming. Although it is intended for all levels of Backend Developers, we expect more attention to detail the more experienced you are. The time to complete this project will depend on your expertise, but based on our own employees executing this task, we estimate that it should not take more than 5-8 hours depending on your proficiency. We understand and honor that you have a life outside work so we recommend that you do not exceed the above mentioned limit. Do not invest your time into implementing additional business requirements that are not listed and please leave the application design unchanged. You can use the template starter code which contains the structure of the codebase and some sample code for reference. 

## Useful links:
* [Spring Initializer](https://start.spring.io)
* [Introduction to Spring Data MongoDB](https://www.baeldung.com/spring-data-mongodb-tutorial)
* [Connection to Mongo DB](https://www.mongodb.com/docs/404/)

