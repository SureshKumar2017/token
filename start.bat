@echo off

call mvn install -f validator\pom.xml
start "Token Validator" java -jar validator\target\validator-0.0.1-SNAPSHOT.jar

call mvn install -f generator\pom.xml
start "Token Generator" java -jar generator\target\generator-0.0.1-SNAPSHOT.jar

cd frontend\

call npm install
call npm run build 
call npm install -g serve

start serve -s build -l 8080

explorer "http://localhost:8080"

Exit /b