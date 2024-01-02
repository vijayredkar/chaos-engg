# chaos-engg
chaos engg with Springboot and ChaosMonkey

![Scenario-Diagram](https://github.com/vijayredkar/chaos-engg/assets/25388646/3f586abd-882c-4c20-9ddd-ca7dcce23da8)


# Demo flow cmds
start client
        cd C:\Vijay\Java\projects\chaos-monkey\screening-client
mvn clean install
java -jar target/screening-client.jar

start service  - w/o chaos  
cd C:\Vijay\Java\projects\chaos-monkey\screening-svc
mvn clean install
java -jar target/screening-svc-chaos-mky.jar

start service  - w/ chaos  
cd C:\Vijay\Java\projects\chaos-monkey\screening-svc
mvn clean install
java -jar target/screening-svc-chaos-mky.jar --spring.profiles.active=chaos-monkey

# Test cURLs
curl -X GET http://localhost:8081/loan/v1/screen-1

# chaos injections
#watchers
chaos.monkey.watcher.controller=false
chaos.monkey.watcher.restController=false
chaos.monkey.watcher.service=true
chaos.monkey.watcher.repository=false
chaos.monkey.watcher.component=false

#assaults
chaos.monkey.assaults.latencyActive=true
chaos.monkey.assaults.latencyRangeStart=3000
chaos.monkey.assaults.latencyRangeEnd=15000

chaos.monkey.assaults.exceptionsActive=false
chaos.monkey.assaults.killApplicationActive=false

3. Local Kafka setup
    - download and install - https://www.tutorialspoint.com/apache_kafka/apache_kafka_installation_steps.htm
    - Zookeeper start cmd  - <Kafka_install_dir>\bin\windows\zookeeper-server-start.bat <Kafka_install_dir>\config\zookeeper.properties
    - Kafka-server start cmd - <Kafka_install_dir>\bin\windows\kafka-server-start.bat <Kafka_install_dir>\config\server.properties
4. Launch microservices
   - git clone in to your 
     - <project_dir> - https://github.com/vijayredkar/event-driven-platform-with-saga.git



