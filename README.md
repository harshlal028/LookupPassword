# LookupPassword
A sample web project using Spring Framework

# Build Instruction
- mvn clean install

# Deploy instructions
- add password file to environment variable ```PASSWORD_FILE```, defaults to /etc/passwd
- add group file to environment variable ```GROUP_FILE``` defaults to /etc/groups
- Once the project is successfully build, the war file will be found inside target directory
- Deploy this war file on a Apache Tomcat server and then call the APIs via POSTMAN or other service

# Requirements
- JDK 1.8 or higher
- Apache Tomcat 9.x
- Apache Maven 3.6.x

# API format
- /users
- /users/query[?name=<nq>][&uid=<uq>][&gid=<gq>][&comment=<cq>][&home=<hq>][&shell=<sq>]
- /users/<uid>
- /users/<uid>/groups
- /groups
- /groups/query[?name=<nq>][&gid=<gq>][&member=<mq1>[&member=<mq2>][&member=<mq3>]]
- /groups/<gid>

# API examples
- http://localhost:8080/LookupPassword/users
- http://localhost:8080/LookupPassword/users/1
- http://localhost:8080/LookupPassword/users/query?name=root&uid=0
- http://localhost:8080/LookupPassword/users/1/groups
- http://localhost:8080/LookupPassword/groups
- http://localhost:8080/LookupPassword/groups/502
- http://localhost:8080/LookupPassword/groups/query?member=bob&member=shelley
