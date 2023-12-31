## Initialzing Docker Image

- Follow the steps to run the docker image and start spring boot application :

1. open terminal and verify if Docker is installed on the machine:

```console
    docker version
```

2. Download the docker image from docker cloud repositiry:

```console
    docker pull epraneeth/fetch-spring-api:latest
```

3. Run the image to start the application:

```console
    docker run -p 8080:8080 epraneeth/fetch-spring-api:latest
```

The Spring boot application will start on **http://localhost:8080**

### Api End Points

**ENDPOINT : Test**<br><br>
POST http://localhost:8080/receipts/test
<br><br><br>
**ENDPOINT : Process Receipts**<br><br>
Send a JSON body to calculate the points and it will return a json containing id
<br>
POST http://localhost:8080/receipts/process
<br><br><br>
**ENDPOINT : GET POINTS**<br><br>
Send id as a parameter and it will return object specifing the points awarded
<br>
GET http://localhost:8080/receipts/{id}/points
<br>
