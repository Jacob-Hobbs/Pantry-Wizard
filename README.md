# 🧙🏽 Pantry Wizard 🧙🏽
Check it out **live** here: [Pantry Wizard Login Portal](https://bit.ly/pantry-wizard)

Username: _admin_ 

Password: _password_

_...or make your own!_

## Description

<img src="https://github.com/Jacob-Hobbs/Pantry-Wizard/blob/master/src/main/resources/static/overview.gif">

_Pantry Wizard_ is a culinary companion like no other, revolutionizing the way chefs and home cooks approach meal planning. With its intuitive and user-friendly interface, users can effortlessly add locally sourced ingredients to their virtual pantry. This inventory becomes the cornerstone for crafting exquisite recipes that celebrate the richness of locally grown produce. The application offers a secure login interface with customizable credentials, ensuring that your culinary creations are for your eyes only. But _Pantry Wizard_ is not just about convenience; it's about precision. The platform meticulously tracks caloric and pricing information for both ingredients and recipes, empowering chefs to create menus that cater to dietary needs and budget constraints. 

Behind the scenes, the application relies on a robust technology stack, including Java, Spring Boot, Hibernate, JPA, HTML, CSS, Maven, Bootstrap, and a hosted MySQL Database. _Pantry Wizard_ is hosted seamlessly on AWS Elastic Beanstalk, ensuring a harmonious and responsive experience for users as they embark on journey that involves unlocking the potential of local ingredients in the most innovative way possible.

## Architecture

_Pantry Wizard_ is a sophisticated culinary application that operates on the principles of Spring MVC (Model-View-Controller), making it a robust CRUD (Create, Read, Update, Delete) application. Let's delve into how _Pantry Wizard_ utilizes Spring MVC to provide a seamless user experience while managing essential operations:

### Model-View-Controller Architecture
Spring MVC is a web application framework that follows the MVC architectural pattern. Pantry Wizard effectively implements this pattern:
* **Model**: In _Pantry Wizard_, the model represents the data structure of the application's entities (User, Ingredient, and Recipe). The application relies on Hibernate and JPA for ORM (Object-Relational Mapping) to interact with the AWS hosted MySQL database. These technologies ensure that data is efficiently stored and retrieved.
* **View**: The view layer is responsible for rendering the user interface. _Pantry Wizard_ employs HTML, CSS, and Bootstrap to create a visually appealing and user-friendly interface. Users can seamlessly interact with their pantry ingredients and recipes.
* **Controller**: Controllers act as intermediaries between the model and view. _Pantry Wizard_ utilizes Spring Boot's controller classes to handle HTTP requests and direct them to the appropriate services. These controllers are responsible for CRUD operations, ensuring that users can create, read, update, and delete their pantry ingredients and recipes effortlessly.

### Ingredient-Recipe CRUD Operations
* **Create**: Users can add new ingredients to their pantry and use these ingredients to create new recipes.
  <img src="https://github.com/Jacob-Hobbs/Pantry-Wizard/blob/master/src/main/resources/static/addIngredient.gif">
* **Read**: Through the application's intuitive interface, users can view their pantry inventory, browse recipes, and access detailed information about each ingredient or recipe through clickable Bootstrap cards.
* **Update**: When users need to modify an ingredient or recipe, _Pantry Wizard_ allows them to make updates easily. The application ensures data consistency and accuracy by employing Spring MVC's mechanisms for form submissions and data validation.
* **Delete**: Removing ingredients or recipes from the pantry is a straightforward process. Spring MVC handles the request to remove the selected items from the database, ensuring that data integrity is maintained.

## Getting Started

### Dependencies

* Web Browser (works well in Google Chrome)
* Java JDK 17.0.8 [(Download)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
* Spring Boot Starter Data JPA
* Spring Boot Starter Thymeleaf
* Spring Boot Starter Web
* Spring Boot Devtools
* MySQL Connector J
* Spring Boot Starter Test
* Spring Boot Maven Plugin

### Installing

* How/where to download your program
* Any modifications needed to be made to files/folders

### Executing program

* How to run the program
* Step-by-step bullets
```
code blocks for commands
```

## Help

Common Issues:
* In this current release, when recipes are added or updated, the first form within the "Add Ingredient" selectors must have an ingredient category selection before the recipe submission will be approved. In future updates this will be changed. 

## Authors

Author can be contacted via the following link:

[Jacob Hobbs](https://www.linkedin.com/in/jacobrayhobbs/)

## Version History

* 0.2
    * Various bug fixes and optimizations
    * See [commit change]() or See [release history]()
* 0.1
    * Initial Release

## Acknowledgments

* [Bootstrap Docs](https://getbootstrap.com/docs/5.0/getting-started/introduction/)
* [Spring Initializr](https://start.spring.io/)

