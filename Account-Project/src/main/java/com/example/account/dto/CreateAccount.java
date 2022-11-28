package com.example.account.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CreateAccount {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {       // 요청
        @NotNull
        @Min(1)
        private Long userId;

        @NotNull
        @Min(0)
        private Long initialBalance;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long userId;
        private String accountNumber;               // 계좌번호
        private LocalDateTime registeredAt;         // 계좌등록일시

        public static Response from(AccountDto accountdto) {
            return Response.builder()
                    .userId(accountdto.getUserId())
                    .accountNumber(accountdto.getAccountNumber())
                    .registeredAt(accountdto.getRegisteredAt())
                    .build();
        }
    }
}
