## WELCOME

### Initialzing Docker Image

Follow the steps to run the docker image

- open terminal
  Verify Docker is installed:

```console
    docker version
```

Download the docker image from docker cloud repositiry:

    docker pull epraneeth/fetch-spring-api:latest

Run the image to start the application:

    docker run -p 8080:8080 epraneeth/fetch-spring-api:latest
