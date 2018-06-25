This application built using Spring Boot (webb scoket connection) , MongoDB , ActiveMQ , Maven
WebScoketService.java is RestController
/confirm-order is the API path
When API receives the request , writing the POST request object to order-details-queue.
And order-details-queue has a listener logic in Listener.java , where we're calling backend API and based on the response writing to a topic or storing into Mongo DB.
