# Distributed-Systems-SS24

# Todo Application

## Getting Started

To make it easy for you to get started with Docker and set up the project, follow the steps below.

## Add your files

1. [Create](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#create-a-file) or [upload](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#upload-a-file) your files.
2. [Add files using the command line](https://docs.gitlab.com/ee/gitlab-basics/add-file.html#add-a-file-using-the-command-line) or push an existing Git repository with the following command:

git clone https://github.com/steiit00/Distributed-Systems-SS24.git
cd Distributed-Systems-SS24

## Set Up the Project

### Before starting the project you have to run Maven package to create the jar file. The jar file is to big to upload to GitHub and is needed to create the image for todo-service.

Make sure you have the following installed on your machine:

- Docker: [Install Docker](https://docs.docker.com/get-docker/)
- Docker Compose: [Install Docker Compose](https://docs.docker.com/compose/install/)

### Running the Project

Clone the repository:

git clone https://github.com/steiit00/Distributed-Systems-SS24.git
cd Distributed-Systems-SS24-main

Build and start the Docker containers

docker-compose up --build

### Stopping the Project

docker-compose down

### Project Structure

backend/ - Spring Boot application
frontend/ - React application
database/ - MySQL database

## Endpoints

GET /todos
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
