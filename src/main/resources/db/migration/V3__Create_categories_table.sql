CREATE TABLE categories
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(50)                NOT NULL,
    type       ENUM ('INCOME', 'EXPENSE') NOT NULL,
    user_id    BIGINT                     NULL, -- NULL for system default categories
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
) ENGINE=InnoDB;