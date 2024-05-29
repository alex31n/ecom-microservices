#!/bin/sh

docker compose \
--env-file ./config/env/.env \
--env-file ./config/env/.env.local \
--env-file ./config/env/.env.dev \
-f docker-compose.yml \
-f docker-compose.dev.yml \
-p ecom-microservices-demo up -d