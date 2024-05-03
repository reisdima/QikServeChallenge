For the proposed challenge, it was requested to develop an application to consume the API given from wiremock.
The data refers to items from a grocery store, and my application consumes it and simulate what would be the starter of an ecommerce.

The application implements the functionality to add items to an order, like a "shopping cart". Each item may have a set of promotions, and one of the requirements was to apply a promotion whenever it was possible. The way it was implemented, the promotions don't accumulate, only the one that gives the most discount is applied. 

As shown in the diagram (/documents/QikServeDiagram.png), the initial idea was to use a database to persist the orders, as well as having some way to identify an user and retrieve an unfinished order.

It was developed using Java 17 and Spring Boot. 

The project is organized as a simple REST API, using cache for the data retrieved from the wiremock API. The structure of the project consists in two layers, since there is no database. The first layer is the controller, which handles all requests. The other one is the service layer, responsible for all logic.

Once there are multiple types of promotion, and different ways to apply them, it was opted to implement the Strategy design pattern, allowing to add new types of promotions.




## Improvement points

* Configure caching to update it after some time
* Create User class to identify owner
* Use a database to persist all orders
* Add unit tests
* Add logging
* Create OpenAPI doc