# Spring Kafka

A sample project setup for kafka using spring kafka (**used java12**)

### To run
`./gradlew clean bootRun`

### For producing a message
You can `POST` a message to `/send` endpoint

`curl -X POST http://localhost:9009/send -H "Content-Type: application/json" --data "{\"message\": \"this is the json body from outside World\"}"`
