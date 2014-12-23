create table if not exists person (
  id varchar(36) PRIMARY key not NULL,
  first_name varchar(100) not null,
  last_name varchar(100) not null
)