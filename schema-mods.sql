USE coursedatabase;

#
# Relationship Guide:
#   - Parent   <--- Child (owns foreign key to Parent).
#
# One-to-One Relations:
#   - Thread   <--- RootMessage
#
# One-to-Many Relations:
#   - Thread   <--- Message
#   - Customer <--- Message
#   - Customer <--- RootMessage
#   - Customer <--- Thread
#
#

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS thread;
DROP TABLE IF EXISTS message;
DROP TABLE IF EXISTS rootMessage;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE customer (
    customerId  VARCHAR(20)     NOT NULL,
    fullName    VARCHAR(50)     NOT NULL,
    password    VARCHAR(50)     NOT NULL,
    PRIMARY KEY(customerId)
);

CREATE TABLE thread (
    threadId    INT             NOT NULL AUTO_INCREMENT,
    customerId  VARCHAR(20)     NOT NULL,
    lastActive  TIMESTAMP       NOT NULL,
    latitude    DOUBLE          NOT NULL,
    longitude   DOUBLE          NOT NULL,
    PRIMARY KEY(threadId),
    FOREIGN KEY(customerId) REFERENCES customer(customerId)
);

CREATE TABLE message (
    messageId   INT             NOT NULL AUTO_INCREMENT,
    threadId    INT             NOT NULL,
    customerId  VARCHAR(20)     NOT NULL,
    body        VARCHAR(255)    NOT NULL,
    PRIMARY KEY(messageId),
    FOREIGN KEY(threadId) REFERENCES thread(threadId),
    FOREIGN KEY(customerId) REFERENCES customer(customerId)
);

CREATE TABLE rootMessage (
    messageId   INT             NOT NULL AUTO_INCREMENT,
    threadId    INT             NOT NULL,
    customerId  VARCHAR(20)     NOT NULL,
    body        VARCHAR(255)    NOT NULL,
    title       VARCHAR(50)     NOT NULL,
    type        VARCHAR(20)     NOT NULL,
    imageUrl    VARCHAR(255)    NOT NULL,
    PRIMARY KEY(messageId),
    FOREIGN KEY(threadId) REFERENCES thread(threadId),
    FOREIGN KEY(customerId) REFERENCES customer(customerId)
);

DESCRIBE customer;
DESCRIBE thread;
DESCRIBE message;
DESCRIBE rootMessage;