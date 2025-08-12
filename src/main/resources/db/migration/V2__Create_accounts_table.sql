CREATE TABLE accounts
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(100) NOT NULL,
    balance    DECIMAL(15, 2) DEFAULT 0.00,
    user_id    BIGINT       NOT NULL,
    created_at DATETIME       DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
) ENGINE=InnoDB;