#!/bin/sh

if [ "$DATABASE" = "mysql" ]
then
    echo "Waiting for MySQL..."

    while ! nc -z mysqldb 3306; do
      sleep 0.1
    done

    echo "MySQL started"
fi

exec "$@"