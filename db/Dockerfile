FROM postgres:16.4-bookworm
COPY init-db.sh /docker-entrypoint-initdb.d/init-db.sh
RUN sed -i -e 's/\r$//' /docker-entrypoint-initdb.d/init-db.sh
