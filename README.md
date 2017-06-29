
# JDBC_DAO and MySQL database application

The application describes work with JDBC and MySQL database. The application divided on 3 layers: entity, dao and service.

## Database structure


## Create tables SQL script

CREATE TABLE "ADDRESS"
(
  "ID" bigint NOT NULL,
  "COUNTRY" character varying(255) NOT NULL,
  "CITY" character varying(255) NOT NULL,
  "STREET" character varying(255) NOT NULL,
  "POST_CODE" character varying(10) NOT NULL,
  CONSTRAINT "ID" PRIMARY KEY ("ID")
)

CREATE TABLE "EMPLOYEE"
(
  "ID" bigint NOT NULL,
  "FIRST_NAME" character varying(255) NOT NULL,
  "LAST_NAME" character varying(255) NOT NULL,
  "BIRTHDAY" date NOT NULL,
  "ADDRESS_ID" bigint NOT NULL,
  CONSTRAINT "EMPLOYEE_pkey" PRIMARY KEY ("ID"),
  CONSTRAINT "EMPLOYEE_ID_fkey" FOREIGN KEY ("ID")
)

CREATE TABLE "PROJECT"
(
  "ID" bigint NOT NULL,
  "TITLE" character varying(255) NOT NULL,
  CONSTRAINT "PROJECT_pkey" PRIMARY KEY ("ID")
)

CREATE TABLE "EMPL_PROJ"
(
  "EMPLOYEE_ID" bigint NOT NULL,
  "PROJECT_ID" bigint NOT NULL,
  CONSTRAINT "EMPL_PROJ_EMPLOYEE_ID_fkey" FOREIGN KEY ("EMPLOYEE_ID")
      REFERENCES "EMPLOYEE" ("ID"),
  CONSTRAINT "EMPL_PROJ_PROJECT_ID_fkey" FOREIGN KEY ("PROJECT_ID")
      REFERENCES "PROJECT" ("ID")
)
