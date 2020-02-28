jar:
	@ mvn clean package

run:
	@ java -cp . hello.Hello

docker:
	@ docker build -t hello .

docker-run:
	@ docker run -ti hello
 