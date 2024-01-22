Create the network for the Springboot application to connect with the Docker Postgres Database.

> List all docker networks
```
docker network ls
```

> Create the network that would be chared by the application and the Database
```
docker network create onax-postgres-docker-network
```

> Delete the Network
```
docker network rm onax-postgres-docker-network
```
> List all docker volumes
```
docker volume list
```
> Remove a docker volumes
```
docker volume rm <nameOfVolume>
```

> Run the PostgresDb in the network: <strong style='font-style:italic;color:green;'>onax-postgres-docker-network</strong>
```
docker run --name postgrestwo --network onax-postgres-docker-network -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgrespwd -d postgres
```

> Also, ensure to run the dockerized application container in the same network:
```
docker run -d --name students-app-local --network onax-postgres-docker-network -p 8080:8080 onadebi/students-app-demo
```
