# Distributed-Systems-SS24

# Todo Application

## Getting Started

To make it easy for you to get started with Docker and set up the project, follow the steps below.

## get your files

git clone https://github.com/steiit00/Distributed-Systems-SS24.git

cd ../Distributed-Systems-SS24-main

## Set Up the Project

Make sure you have the following installed on your machine:

- Docker: [Install Docker](https://docs.docker.com/get-docker/)
- Docker Compose: [Install Docker Compose](https://docs.docker.com/compose/install/)

### Running the Project

Clone the repository:

git clone https://github.com/steiit00/Distributed-Systems-SS24.git
cd Distributed-Systems-SS24-main

Build and start the Docker containers

docker-compose up --build

or in the background
docker-compose up --build -d

If the containers do not work properly after the initial build and startup, you can restart all the containers with:
docker-compose restart

Once the project is built, you can access the todo list application in your browser at http://localhost:3000/. 

The application prioritizes tasks and sorts them by priority. 

Tasks that are marked as important will be displayed in red, while other tasks will be shown in yellow or green depending on their urgency.

### Stopping the Project

docker-compose down

### Project Structure

backend/ - Spring Boot application

frontend/ - React application

database/ - MySQL database

## Endpoints

GET /todos/

POST /todos/

DELETE /todos/

## Configuration

The Docker Compose file (docker-compose.yml) contains the configuration for the backend, frontend, and database containers. 

## Error Handling

If an error occurs during any operation, the server will respond with a 500 (Internal Server Error) status code along with an error message.

## Kubernetes
Ensure kubectl and minikube or kind are installed.

Run:

minikube start

kubectl apply -f sample/otel-in-action/deployment.yaml

Forward Port for Codespaces:

kubectl port-forward service/todoui-flask 5000:5000

kubectl port-forward service/todoui-thymeleaf 8090:8090

Now you can observe the deployments:

kubectl get deployments

See Service Ports and IPs:

kubectl get services

# Support

For support, please contact steiit00@hs-esslingen.de or mameit06@hs-esslingen.de .

### Authors and Acknowledgments

This project was developed by Stefan Eisele and Matthias Maier.
