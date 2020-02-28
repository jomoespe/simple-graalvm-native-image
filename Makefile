jar:
	@ mvn clean verify

docker: jar
	@ docker build -t hello .
