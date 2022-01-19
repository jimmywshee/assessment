# Getting Started

### How to start spring boot application
To run the application, run following command in terminal window:

`./gradlew bootRun`

### Start MSSQL docker 

1. Prerequisite: Machine must install docker, refer to [Get Docker](https://docs.docker.com/get-docker/)

2. To start MSSQL docker, run following command in terminal window to download image and start MSSQL:

`docker run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=password@123" -p 1433:1433 -d mcr.microsoft.com/mssql/server:2019-CU14-ubuntu-20.04`

3. If your machine installed with MSSQL, you can execute DB Script on TESTDB.sql to create database and table.