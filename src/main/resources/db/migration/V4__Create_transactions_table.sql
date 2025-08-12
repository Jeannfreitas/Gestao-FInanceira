CREATE TABLE transactions
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(100)               NOT NULL,
    amount      DECIMAL(15, 2)             NOT NULL,
    date        DATE                       NOT NULL,
    type        ENUM ('INCOME', 'EXPENSE') NOT NULL,
    category_id BIGINT                     NOT NULL,
    user_id     BIGINT                     NOT NULL,
    account_id  BIGINT                     NOT NULL,
    created_at  DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES categories (id),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (account_id) REFERENCES accounts (id) ON DELETE CASCADE,
    INDEX       idx_transactions_user_date (user_id, date)
) ENGINE=InnoDB;