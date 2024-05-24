#! /bin/bash

docker compose \
--env-file ./config/.env \
--env-file ./config/.env.local \
--env-file ./config/.env.dev \
-f docker-compose.yml \
-f docker-compose.dev.yml \
-p ecom-microservices-demo down