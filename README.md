```mermaid
sequenceDiagram
    participant User
    participant QueueService
    participant SeatService
    participant ReservationService
    participant WalletService
    participant PaymentService

    User->>+QueueService: 발급 API 호출 (토큰 발급)
    alt 토큰 존재하고 살아있음
        QueueService->>QueueService: 기존 토큰 폐기 및 재발급
    else
        QueueService->>QueueService: 새 토큰 발급
    end
    QueueService-->>-User: 토큰 반환

    User->>+QueueService: 대기 정보 조회 API 호출
    alt 대기열에 없는 토큰
        QueueService-->>User: Error response
    else
        QueueService-->>User: 대기 정보 반환
    end
    QueueService-->>-User: 완료

    User->>+SeatService: 예약 가능한 날짜 조~~~~회 API 호출
    SeatService-->>-User: 예약 가능한 날짜 목록 반환

    User->>+SeatService: 특정 날짜의 예약 가능한 좌석 조회 API 호출
    SeatService-->>-User: 예약 가능한 좌석 목록 반환

    User->>+ReservationService: 좌석 선택 요청 API 호출
    alt 좌석 선택 실패
        ReservationService-->>User: 다른 좌석 선택 요청
        User->>ReservationService: 다른 좌석 선택 시도
    else
        ReservationService-->>-User: 좌석 선택 성공, 결제 단계로 진행
    end

    User->>+PaymentService: 결제 API 호출
    alt 잔액 부족
        PaymentService-->>User: 결제 실패 (잔액 부족)
        User->>+WalletService: 잔액 충전 API 호출
        WalletService-->>-User: 충전된 잔액 정보 반환
        User->>PaymentService: 결제 재시도
    else 좌석 선택 시간 만료
        PaymentService-->>User: 결제 실패 (시간 만료)
        User->>ReservationService: 다른 좌석 선택 시도
    else 결제 성공
        PaymentService-->>-User: 결제 내역 정보 반환, 좌석 소유권 변경, 대기열 제거
        PaymentService->>+QueueService: 사용자 대기열에서 제거
        QueueService-->>-PaymentService: 대기열 제거 완료
    end

    User->>+WalletService: 잔액 조회 API 호출
    WalletService-->>-User: 잔액 정보 반환

    User->>+WalletService: 잔액 충전 API 호출
    WalletService-->>-User: 충전된 잔액 정보 반환
