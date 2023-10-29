## WELCOME

### Initialzing Docker Image

Follow the steps to run the docker image

- open terminal
  Verify Docker is installed:

```console
    docker version
```

Download the docker image from docker cloud repositiry:

```console
    docker pull epraneeth/fetch-spring-api:latest
```

Run the image to start the application:

```console
    docker run -p 8080:8080 epraneeth/fetch-spring-api:latest
```

The Spring boot application will start on **http://localhost:8080**

## Api End Points

**Test**
POST http://localhost:8080/receipts/test

**Process Receipts**
Send a JSON body to calculate the points and it will return a json containing id

POST http://localhost:8080/receipts/process

**GET POINTS**
Send id as a parameter and it will return object specifing the points awarded

GET http://localhost:8080/receipts/{id}/points
