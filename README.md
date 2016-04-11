# AppDynamics-docker-db2

<b>DB2 Docker images</b>

<b>Building the container images:</b>

To build DB2 container import the DB2 images from the location “https://drive.google.com/drive/u/0/folders/0B531weScYzNNYlZHZmZVR2RDcG8” and run below steps

1. Download the images to the local directory
2. Import from a local file:
$ docker import – appdynamics_db2.tgz

<b>.Running a Container:</b>

Run the below command to start the container
docker run -it -p 50000:50000 -e DB2INST1_PASSWORD=Dreams707 -e LICENSE=accept  <CONTAINER_ID>

<b>NOTE</b>: After pulling the DB2 docker image it is not showing Repository and Tag name as of now in local system( I am working on that to resolve ) so instead of running by repository name as shown below, run with container ID of the db2 image and it is working. 

docker run -it -p 50000:50000 -e DB2INST1_PASSWORD=Dreams707 -e LICENSE=accept appdynamics/db2:latest bash

<b>Perform CRUD operations through CLI :</b>

1. Switch to the default db2 instance user db2inst1 to start DB2 instance: Run su – db2inst1
2. Then Run db2start
3. Create a sample database using db2 create db  command, which may take several minutes.
4. Now run across DB2 DDL or DML queries

<b>Perform CRUD operations through Servlet :</b>

1. Open the code in any editor say Eclipse
2. Run the code as JAVA Application 
