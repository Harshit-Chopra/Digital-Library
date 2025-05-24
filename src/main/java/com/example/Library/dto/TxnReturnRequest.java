package com.example.Library.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TxnReturnRequest {
    @NotBlank
    private String bookNo;
    @NotBlank
    private String txnId;
    @NotBlank
    private String userEmail; // but we should not this from user
}

// gpay
// whom u want to send the money: reeiver mob no
// sender mobile no?
// gpay  done validation on your mob no and knows that which mob no is going to make a txn ?

// security
