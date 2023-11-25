do
$$
BEGIN
FOR counter IN 1..10000 loop
	raise notice 'counter: %', counter;
INSERT INTO "library".books (title, author, isbn, "year")
VALUES ('Medium Publication', 'Me', 11111111, counter);
END loop;
END; $$
