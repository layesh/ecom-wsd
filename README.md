# ecom-wsd
Ecommerce Website for WSD

### Start the application
Install Docker if already not installed. Then run the following command in the terminal to start the application:
```shell
gradlew bootRun 
```

### Running the test cases
Run the following command to execute test cases:
```shell
gradlew test 
```

### Exposed API endpoints
1. Return the wish list of a customer:

   http://localhost:8080/rest-api/customer/:id/wishlist

2. Return the total sale amount of the current day:

   http://localhost:8080/rest-api/order-detail/total-sale-amount-today