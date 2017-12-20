# running-information-service

# running-information-service

Back end of a microservice, supporting CRUD of running information analysis.

REST API:
Create running information using JSON input
- Search running information by username
- Search running information by runningId
- Return all running information and ordered by healthWarningLevel from HIGH to
LOW. This API needs to support pagination, each page returns two running
information.
- Delete running information by runningId


To launch the application:
* For mac/win user, start `docker-quickstart terminal`
  * For mac users, run `docker-machine restart default` then `eval $(docker-machine env default)`
* cd to `/running-information-service`. Run `docker-compose up` to start the docker container for mysql.
* in the same directory run `mvn clean install` to compile the maven project;
* cd to subdirectory `/target` and run `java -jar *.jar` to start a tomcat server (port 8080) accessible through http request.





* Dec 20 2017 -- updated the REST API; http-request results no longer use pagination.