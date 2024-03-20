
### Reference Design

Here is my design for the database, system, and sequence diagram 

* [System Design](https://drive.google.com/file/d/1NheNrmGQPcrw6gfUEp0728cGv-5r_Ly4/view?usp=sharing)

###	Outline the security solution that you intend to use
* a.	Update webserver to use CA certificate to change HTTP -> HTTPS
* b.	Encrypt user password before saving to DB
* c.	Encrypt important configurations and mark them with the prefix {cipher}
* d.	If we host on cloud providers
    * i.	Move the instances that host this app to private subnet. Create an API gateway to route requests to load balancers in public subnets which then route to instances in private subnets
    * ii.	Add a rate limiter (throttle limit) in the gateway to avoid DDOS
* e.	Enforce users’ roles with spring security, i.e. matching patterns for each ROLE of users ("/admin/**").hasRole("ADMIN")
###	Outline the API endpoints that will be developed as part of the solution.
* a.	For users
  * Create new user: POST /api/v1/coffeeshop/user/create
  * Login user: POST /api/v1/coffeeshop/user/login
  * Update user: PUT /api/v1/coffeeshop/user/update
  * Delete user: DELETE /api/v1/coffeeshop/user/delete
  * User detail: GET /api/v1/coffeeshop/user/{user-id}
  * Place order: POST /api/v1/coffeeshop/user/shop/{shop-id}/orders
  * Cancel order: PATCH /api/v1/coffeeshop/user/shop/{shop-id}/orders/{order-id}
* b.	For admins only
  * Create new shop: POST /api/v1/coffeeshop/admin/shop/create
  * Update shop: PUT /api/v1/coffeeshop/admin/shop/update
  * Delete shop: DELETE /api/v1/coffeeshop/admin/shop/delete
* c.	For shop operators:
  * View queues of a shop: GET /api/v1/coffeeshop/operator/shop/{shop-id}/queues
  * Queue detail: GET /api/v1/coffeeshop/operator/shop/{shop-id}/queues/{queue-id}
  * View orders: GET /api/v1/coffeeshop/operator/shop/{shop-id}/orders
  * Update orders: PATCH /api/v1/coffeeshop/operator/shop/{shop-id}/orders/{order-id}
###	 Outline how you will test the solution in the absence of the apps / front-end
* a.	Use java unit tests for those APIs
* b.	Writing integration tests

### Deployment

* Run with docker compose with postgres DB included

`docker-compose up`

* Prerequisite for running gradlew and coffeeshop image individually: 
  * set JAVA_HOME to 21
  * change application.properties postgres to your database (if not run with docker-compose)

* Run with CoffeeShop image:

`./gradlew bootBuildImage` (this will build an image coffeeshop immediately)

* Gradle build to rebuild executable jar file

`./gradlew build`

* Rebuild image

`docker build -t testdockercoffee .`

### Testing
#### With Postman
* Connect the app to postgres with customized database then run
`curl --location --request PATCH 'http://localhost:8080/api/v1/coffeeshop/operator/update-order' \
  --header 'Content-Type: application/json' \
  --data '{
  "orderState": "PROCESSING",
  "id" : 1
  }'`
#### With unit tests
I wrote one unit test for service and one integration test in OperatorServiceTest
`./gradlew test`
