create table IF NOT EXISTS publisher (
	id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

create table IF NOT EXISTS book (
	id SERIAL PRIMARY KEY,
    pages INTEGER,
    release_year SMALLINT,
    publisher_id BIGINT UNSIGNED,
    isbn VARCHAR(20) UNIQUE,
    title VARCHAR(255),
    price DECIMAL(5, 2),
    FOREIGN KEY (publisher_id) REFERENCES publisher(id)
);

create table IF NOT EXISTS author (
	id SERIAL PRIMARY KEY,
    first_name VARCHAR(64),
    last_name VARCHAR(64)
);

create table IF NOT EXISTS book_category (
	id SERIAL PRIMARY KEY,
	name VARCHAR(255)
);

create table IF NOT EXISTS book_author (
	book_id BIGINT UNSIGNED,
    author_id BIGINT UNSIGNED,
    PRIMARY KEY (book_id, author_id),
    FOREIGN KEY (book_id) REFERENCES book(id)
		ON DELETE cascade
        ON UPDATE cascade,
    FOREIGN KEY (author_id) REFERENCES author(id)
		ON DELETE cascade
        ON UPDATE cascade
);

create table IF NOT EXISTS book_book_category (
	book_id BIGINT UNSIGNED,
    book_category_id BIGINT UNSIGNED,
    PRIMARY KEY (book_id, book_category_id),
    FOREIGN KEY (book_id) REFERENCES book(id),
    FOREIGN KEY (book_category_id) REFERENCES book_category(id)
);
