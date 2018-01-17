#!/bin/sh
docker build -t de.zorcic/articlemanagement .
docker rm -f articlemanagement || true && docker run -d -p 8080:8080 -p 4848:4848 --name articlemanagement de.zorcic/articlemanagement
