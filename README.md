# Deploying Microservice App With Docker 
## What is Docker?
ocker is a container platform that allows developers to package applications and their dependencies into units called “containers.” 
Each container is a virtualized, isolated instance of an application that includes everything necessary for it to run independently. 
These containers are lightweight, portable and can run consistently in any environment that supports Docker, 
such as on-premises systems, cloud servers or container clusters.
### About The App
This app contains 5 microservices :
- Billing Service
- Config Service
- Customer Service
- Inventory Service
- Order Service
- Gateway Service
## Docker Compose
Docker Compose is a tool that helps you define and share multi-container applications.
With Compose, you can create a YAML file to define the services and with a single command,
you can spin everything up or tear it all down.
### About the App
<img width="960" alt="dockerp1" src="https://github.com/aymanehed/Deploying-Microservice-app-with-Docker/assets/93987581/c246d059-1391-44f3-9a2a-f76ebf3bd636">
<img width="960" alt="dockerp2" src="https://github.com/aymanehed/Deploying-Microservice-app-with-Docker/assets/93987581/9a94de65-0c79-4aae-a2aa-65eb7ed57516">

## Consul 
Consul is a distributed, highly-available, and multi-datacenter aware tool for service discovery,
configuration, and orchestration. Consul enables rapid deployment, configuration,
and maintenance of service-oriented architectures at massive scale.
### About the App
<img width="918" alt="consul" src="https://github.com/aymanehed/Deploying-Microservice-app-with-Docker/assets/93987581/672e5fdf-17e9-4983-b371-a202e42cca12">

## vault 
Vault is a tool for securely accessing secrets.A secret is anything that you 
want to tightly control access to, such as API keys, passwords, certificates,
and more. Vault provides a unified interface to any secret, while providing 
tight access control and recording a detailed audit log.
### About the App
<img width="941" alt="vault" src="https://github.com/aymanehed/Deploying-Microservice-app-with-Docker/assets/93987581/e4b0cdff-d80a-4d5d-8ed1-d4f99d8077a3">

## Services
### Config Service
<img width="576" alt="config" src="https://github.com/aymanehed/Deploying-Microservice-app-with-Docker/assets/93987581/b8bbe666-e2c6-443a-b9f9-3ea7039fc271">

### Customer Services
<img width="960" alt="customers" src="https://github.com/aymanehed/Deploying-Microservice-app-with-Docker/assets/93987581/7c50dabc-3819-49a9-acf2-2e3509235fc5">

### Inventory Service
<img width="809" alt="inventory" src="https://github.com/aymanehed/Deploying-Microservice-app-with-Docker/assets/93987581/9ae10d19-c4c7-46c2-b908-9f75c3c255f3">

### Order Service 
<img width="818" alt="orders" src="https://github.com/aymanehed/Deploying-Microservice-app-with-Docker/assets/93987581/450e04b5-eb66-458f-bea9-a8ec15ef0c49">
