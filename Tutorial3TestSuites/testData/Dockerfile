FROM java:8

RUN apt-get update
RUN apt-get install -y maven

#WORKDIR /usr/src/tut1
#ADD pom.xml /usr/src/tut1/pom.xml
#RUN ["mvn", "dependency:resolve"]
#RUN ["mvn", "verify"]

#COPY src /usr/src/tut1/src
#RUN ["mvn", "package"]
#CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar"]

COPY . /usr/src/tut1
WORKDIR /usr/src/tut1

RUN mvn verify -Dtest=AllTests --fail-never 
ENTRYPOINT mvn test -Dtest=AllTests --fail-never 