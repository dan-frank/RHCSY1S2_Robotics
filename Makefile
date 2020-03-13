transfer:
	@echo "scp connect to ev3..."
	@scp -c aes256-cbc -oKexAlgorithms=+diffie-hellman-group1-sha1 ./../TestMain.jar root@10.0.1.1:/home/lejos/programs/