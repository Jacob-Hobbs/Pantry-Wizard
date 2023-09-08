# 🧙🏽 Pantry Wizard 🧙🏽
Check it out live here: 

## Description

_Pantry Wizard_ is a culinary companion like no other, revolutionizing the way chefs and home cooks approach meal planning. With its intuitive and user-friendly interface, users can effortlessly add locally sourced ingredients to their virtual pantry. This inventory becomes the cornerstone for crafting exquisite recipes that celebrate the richness of locally grown produce. The application offers a secure login interface with customizable credentials, ensuring that your culinary creations are for your eyes only. But _Pantry Wizard_ is not just about convenience; it's about precision. The platform meticulously tracks caloric and pricing information for both ingredients and recipes, empowering chefs to create menus that cater to dietary needs and budget constraints. 

Behind the scenes, the application relies on a robust technology stack, including Java, Spring Boot, Hibernate, JPA, HTML, CSS, Maven, Bootstrap, and a hosted MySQL Database. _Pantry Wizard_ is hosted seamlessly on AWS Elastic Beanstalk, ensuring a harmonious and responsive experience for users as they embark on journey that involves unlocking the potential of local ingredients in the most innovative way possible.

## Architecture

_Pantry Wizard_ is a sophisticated culinary application that operates on the principles of Spring MVC (Model-View-Controller), making it a robust CRUD (Create, Read, Update, Delete) application. Let's delve into how _Pantry Wizard_ utilizes Spring MVC to provide a seamless user experience while managing essential operations:

### Model-View-Controller Architecture
Spring MVC is a web application framework that follows the MVC architectural pattern. Pantry Wizard effectively implements this pattern:
* **Model**: In Pantry Wizard, the model represents the data structure of the application's entities (User, Ingredient, and Recipe). The application relies on Hibernate and JPA for ORM (Object-Relational Mapping) to interact with the AWS hosted MySQL database. These technologies ensure that data is efficiently stored and retrieved.
* **View**: The view layer is responsible for rendering the user interface. Pantry Wizard employs HTML, CSS, and Bootstrap to create a visually appealing and user-friendly interface. Users can seamlessly interact with their pantry ingredients and recipes.
* **Controller**: Controllers act as intermediaries between the model and view. Pantry Wizard utilizes Spring Boot's controller classes to handle HTTP requests and direct them to the appropriate services. These controllers are responsible for CRUD operations, ensuring that users can create, read, update, and delete their pantry ingredients and recipes effortlessly.

## Getting Started

### Dependencies

* Describe any prerequisites, libraries, OS version, etc., needed before installing program.
* ex. Windows 10

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

Any advise for common problems or issues.
```
command to run if program contains helper info
```

## Authors

Contributors names and contact info

ex. Dominique Pizzie  
ex. [@DomPizzie](https://twitter.com/dompizzie)

## Version History

* 0.2
    * Various bug fixes and optimizations
    * See [commit change]() or See [release history]()
* 0.1
    * Initial Release

## License

This project is licensed under the [NAME HERE] License - see the LICENSE.md file for details

## Acknowledgments

Inspiration, code snippets, etc.
* [awesome-readme](https://github.com/matiassingers/awesome-readme)
* [PurpleBooth](https://gist.github.com/PurpleBooth/109311bb0361f32d87a2)
* [dbader](https://github.com/dbader/readme-template)
* [zenorocha](https://gist.github.com/zenorocha/4526327)
