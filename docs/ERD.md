```mermaid

erDiagram
    USER {
        Long id PK
        String name
        String email
        String password
        LocalDateTime created_at
        LocalDateTime updated_at
    }

    QUEUE {
        Long id PK
        Long user_id FK
        String token
        LocalDateTime issued_at
        LocalDateTime expired_at
    }

    SEAT {
        Long id PK
        String seat_number
        LocalDateTime available_date
        Boolean is_available
    }

    RESERVATION {
        Long id PK
        Long user_id FK
        Long seat_id FK
        LocalDateTime reservation_date
        Boolean is_confirmed
    }

    PAYMENT {
        Long id PK
        Long user_id FK
        Long reservation_id FK
        BigDecimal amount
        String status
        LocalDateTime payment_date
    }

    WALLET {
        Long id PK
        Long user_id FK
        BigDecimal balance
        LocalDateTime updated_at
    }

    USER ||--o{ QUEUE : "has"
    USER ||--o{ RESERVATION : "has"
    USER ||--o{ PAYMENT : "has"
    USER ||--o{ WALLET : "has"
    RESERVATION }o--|| SEAT : "reserves"
    PAYMENT }o--|| RESERVATION : "pays for"
