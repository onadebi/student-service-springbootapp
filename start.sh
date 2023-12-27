printf "\n*************RUNNING SHELL SCRIPT*************\n"
# RUN chmod +x start.sh && ./start.sh

printf "\n>>STOP CONTAINER: students-app-local\n"
docker container stop students-app-local

printf "\n>>DESTROY CONTAINER: students-app-local\n"
docker container rm students-app-local

docker build -t onadebi/students-app-demo .


printf "\n*************CREATING CONTAINER*************\n"
# Path: start.sh
docker run -d --name students-app-local --network onax-postgres-docker-network -p 8080:8080 onadebi/students-app-demo

# Start the container
docker start students-app-local


printf "\n*************END OF SHELL RUN**************\n"