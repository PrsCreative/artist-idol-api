
## Prepare before start api
* Mysql Server/Tools connect (phpMyadmin etc.)
* jdk 1.8
* IDE for open maven project

## Import Database
* create database schema name "artist" please following config in "src/resources/application.properties"
* Import database script from db-script/artist.sql

## Open project tools
* Can Use eclipse, Spring tools suite, IntelliJ IDEA etc
* Import with maven project
* Start application with Spring boot all

## Test call api with Postman
* Import postman collection from "postman/Artist.postman_collection.json"
* app start port: 8080
* require basic authentication
  * username: idol
  * password: password

