# data-mysql

create database

```text
gcloud sql databases create datamysql --instance=mysql-rds
```

application.properties

```text
spring.cloud.appId=spring-380702
spring.cloud.gcp.sql.database-name=datamysql
spring.cloud.gcp.sql.instance-connection-name=spring-380702:us-east4:mysql-rds
```

deploy

```text
mvn clean package appengine:deploy -P cloud-gcp
```

tail logs

```cli
gcloud app logs tail -s default
```
