# ToDoApp

Supports 5 functionalities:
## POST /todos -> Creates the task in DB with task string as well as the completion status of the task
## GET /todos -> Gets all the tasks created in DB
## GET /todos/{id} -> Get the task in DB with the given task id, if not present throws 404 Not Found Exception
## PUT /todos/{id}/done -> Get the task in DB with the given task id, if not present throws 404 Not Found Exception and changes the status of done to true
## DELETE /todos/{id}/done -> Get the task in DB with the given task id, if not present throws 404 Not Found Exception and changes the status of done to true

## The tasks get saved in H2 DB and to check the tasks in DB, queries can be run from h2 console
