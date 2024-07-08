```mermaid

erDiagram
    USER {
        Long id PK
        String name
        Long point
    }

    QUEUE {
        Long queue_id PK
        Long user_id FK
        String token
        Enum status
        LocalDateTime issued_at
        LocalDateTime expired_at
    }

    SEAT {
        Long seat_id PK
        Long concert_schedule_id FK
        Long seat_number
        Long price
        LocalDateTime reserved_at
        Boolean is_available
    }
    
    CONCERT {
        Long concert_id PK
        String name
    }
    
    CONCERT_SCHEDULE {
        Long concert_schedule_id PK
        Long concert_id FK
        Long seat_number
        Long remaining_seat_number
        
    }

    RESERVATION {
        Long reservation_id PK
        Long user_id FK
        Long seat_id FK
        LocalDateTime reservation_date
        Boolean is_confirmed
    }

    PAYMENT {
        Long payment_id PK
        Long reservation_id FK
        String status
        Enum card_type
        LocalDateTime payment_date
        LocalDateTime reservation_date
    }
    
    POINT_HISTORY {
        Long point_history_id PK
        Long user_id FK
        BigDecimal balance
        LocalDateTime updated_at
    }

    USER ||--o{ QUEUE : "has"
    USER ||--o{ RESERVATION : "has"
    USER ||--o{ POINT_HISTORY : "has"
    RESERVATION }o--|| SEAT : "reserves"
    PAYMENT }o--|| RESERVATION : "pays for"
    CONCERT ||--o{ CONCERT_SCHEDULE : "has"
    CONCERT_SCHEDULE ||--o{ SEAT : "has"
