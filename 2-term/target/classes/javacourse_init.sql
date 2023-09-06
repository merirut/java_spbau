CREATE TABLE student (
    id integer not null primary key,
    first_name text not null,
    last_name text not null,
    age integer not null
);

INSERT INTO student(id, first_name, last_name, age) VALUES
 (1, 'Савелий', 'Петров', 18),
 (2, 'Мария', 'Игнатьева', 23);

/*
 Добавьте данные в таблицу student. Например:
 INSERT INTO student(id, first_name, last_name, age) VALUES
 (1, 'Савелий', 'Петров', 18),
 (2, 'Мария', 'Игнатьева', 23);
*/
