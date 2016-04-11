# AppDynamics-docker-db2

DB2 Docker images

Building the container images:

To build DB2 container import the DB2 images from the location “https://drive.google.com/drive/u/0/folders/0B531weScYzNNYlZHZmZVR2RDcG8” and run below steps

1. Download the images to the local directory
2. Import from a local file:
$ docker import – appdynamics_db2.tgz

Running a Container:

Run the below command to start the container
docker run -it -p 50000:50000 -e DB2INST1_PASSWORD=Dreams707 -e LICENSE=accept appdynamics/db2:latest bash

Perform CRUD operations through CLI :

1. Switch to the default db2 instance user db2inst1 to start DB2 instance: Run su – db2inst1
2. Then Run db2start
3. Create a sample database using db2 create db  command, which may take several minutes.
4. Now run across DB2 DDL or DML queries
