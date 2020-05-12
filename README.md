# webtest_tcp

```shell
./gradlew clean bootRun
./gradlew clean bootRun -Pprofile=dev
./gradle clean test
```

## Run mariadb in docker
```shell
docker run --name test-db -p 3308:3306 -e MYSQL_ROOT_PASSWORD=p@ssw0rd -d mariadb 
docker exec -it test-db mysql -u root -p
password: <type your p@ssw0rd>
SQL> create database test;
```"# wabtest01" 
