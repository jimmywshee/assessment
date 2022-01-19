# Getting Started

### Start MSSQL docker (Optional if MSSQL installed)

1. Prerequisite: Machine must install docker, refer to [Get Docker](https://docs.docker.com/get-docker/)

2. To start MSSQL docker, run following command in terminal window to download image and start MSSQL:

`docker run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=password@123" -p 1433:1433 -d mcr.microsoft.com/mssql/server:2019-CU14-ubuntu-20.04`

3. If your machine installed with MSSQL, you can execute DB Script on TESTDB.sql to create database and table.

### How to start spring boot application
To run the application, run following command in terminal window:

`./gradlew bootRun`

### Postman collection 
1. Prerequisite: Machine required to install postman, refer to [Download Postman](https://www.postman.com/downloads/)

2. To access postman collection, please get `assessment.postman_collection.json` to import in Postman application run `4` request inside.

### Notes
1. Logs is stored in `apilogs` folder.
2. Configuration of database & 3rd party stored in `config.properties`.