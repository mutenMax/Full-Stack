Instructions to setup creditcard-app 

Prerequisite: 
Maven v3.x
Node v10.x
Angular 8.0.6



Clone the project
git@github.com:mutenMax/Full-Stack.git

Basic Setup

Install Node.js (preferably v10.16.0)
Confirm node version
`node -v`

Install Angular CLI
`npm install -g @angular/cli`

Check the install
ng -v

Change directory to an Angular project folder
`cd creditcard-app/creditcard-client`
`npm install` [You may need to run "npm install" to install any packages and/or its dependencies.]

Run
`ng serve`

This will start an Angular project on http://localhost:4200


Spring Boot 
Open another terminal and then change to a spring boot application folder.  
`cd creditcard-app/creditcard-service` 

Then run 
`mvn spring-boot:run`

This will start the service.

Open the browser and go to : http://localhost:4200


