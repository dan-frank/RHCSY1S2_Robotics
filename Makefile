compile:
	@echo "Complining code..."
	jar cvf ./../TestMain.jar ./TestMain.java ./BehaviourOne.java ./BehaviourTwo.java ./FriendOne.java
	@echo "Pushing to rube..."
	@scp -c aes256-cbc -oKexAlgorithms=+diffie-hellman-group1-sha1 ./../TestMain.jar root@10.0.1.1:/home/lejos/programs/push