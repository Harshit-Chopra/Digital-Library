package com.example.Library.model;

import com.example.Library.enums.BookType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
public class Book extends TimeStamps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String title;

    @Column(unique = true,length = 20)
    private String bookNo;

    @Enumerated
    private BookType type;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Author author;

    @Column(nullable = false)
    private Double securityAmount;

    @ManyToOne
    @JoinColumn
    private User user;

    @OneToMany(mappedBy = "book")
    private List<Txn> txnList;


}
