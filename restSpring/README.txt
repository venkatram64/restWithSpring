

step 1: run parent maven (at restWithSpring pom file)
	mvn clean install
	
step 2: deploy web app by going to restSpring
	mvn tomcat7:deploy
	
step 3: no need to run springJdbcTemplate, reason parent maven build includes the running the application