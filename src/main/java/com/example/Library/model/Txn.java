package com.example.Library.model;

import com.example.Library.enums.TxnStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
public class Txn extends TimeStamps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String txnId;

    private String lastUpdatedOn;

    private String lastAddedOn;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    private Book book;

    @Enumerated
    private TxnStatus txnStatus;

    private Double settlementAmount; // depending upon when u are returning the book

    private Date issuedDate;

    private Date submittedDate;

}