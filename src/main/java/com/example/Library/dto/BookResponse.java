package com.example.Library.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BookResponse {
    private String bookNo;
    private String bookName;
    private Double securityAmount;

}