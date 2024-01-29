#!/bin/bash

projects=("./config-server" "./naming-server" "./api-gateway" "./register" "./anime" "./animeList" "./tag")

pids=()

run_jar_background() {
	cd "$1"
	./mvnw spring-boot:run &
	pids+=($!)
	cd ..
}

trap 'kill ${pids[@]}' EXIT

for p in "${projects[@]}"; do
	echo "Running $p in the background..."
	run_jar_background "$p"
	sleep 5
done

read -r -d '' _ </dev/tty
