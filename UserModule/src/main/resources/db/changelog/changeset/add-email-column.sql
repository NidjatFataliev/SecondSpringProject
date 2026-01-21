-- liquibase formatted SQL
-- changeset Nidjat:add-email-column
ALTER TABLE testpersons ADD COLUMN email VARCHAR (255);