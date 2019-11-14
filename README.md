# jv-spring-boot-docker


**1. Create a jar**

    mvn clean package

**2. Build the image**

    docker build -t <YOUR_DOCKER_HUB_ID/YOUR_IMAGE_NAME> .

**3. Run it locally and check the result on [localhost](http://localhost:8081/)**

    docker run -p 8081:8081 <YOUR_DOCKER_HUB_ID/YOUR_IMAGE_NAME>

**4. Push the image to the [docker hub](https://hub.docker.com/)**

    docker push <YOUR_DOCKER_HUB_ID/YOUR_IMAGE_NAME>
