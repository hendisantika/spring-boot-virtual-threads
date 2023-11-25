# For local de-containerized testing

```shell
k6 run ./js/<test-name>.js -e USERS=20 -e PORT=8082
```

# For container test run with:

```shell
cd k6-testing
docker-compose run --rm k6 run /k6-scripts/load-test.js -e THREAD=virtual -e USERS=20
docker-compose run --rm k6 run /k6-scripts/load-test.js -e THREAD=standard -e USERS=20
```

Before each test you should run the following script to make every load test independent of the previous executions.

```sql
DELETE
FROM books b
WHERE b.book_id <> 1;
DELETE
FROM orders;
```

Datas will be available on the grafana dashboard reachable
at: http://localhost:3000/d/k6/k6-load-testing-results?orgId=1&refresh=5s
