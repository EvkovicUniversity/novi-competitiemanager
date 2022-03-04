create table INFORMATION_SCHEMA.SESSIONS
(
    ID                   INTEGER,
    USER_NAME            VARCHAR,
    SERVER               VARCHAR,
    CLIENT_ADDR          VARCHAR,
    CLIENT_INFO          VARCHAR,
    SESSION_START        TIMESTAMP(9, 0),
    ISOLATION_LEVEL      VARCHAR,
    STATEMENT            VARCHAR,
    STATEMENT_START      TIMESTAMP(9, 0),
    CONTAINS_UNCOMMITTED BOOLEAN,
    STATE                VARCHAR,
    BLOCKER_ID           INTEGER
);

