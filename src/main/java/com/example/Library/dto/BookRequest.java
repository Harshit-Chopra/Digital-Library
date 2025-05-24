package com.example.Library.dto;

import com.example.Library.enums.BookType;
import com.example.Library.model.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookRequest {

    @NotBlank(message = "book title must not be blank")
    private String bookTitle;
    @Positive(message = "positive values are expected")
    private Double securityAmount;
    @NotBlank(message = "book no must not be blank")
    private String bookNo;
    @NotNull(message = "book type must not be null")
    private BookType bookType;
    @NotBlank(message = "author name must not be blank")
    private String authorName;
    @NotBlank(message = "author email must not be blank")
    private String authorEmail;

    public Book toBook() {
        return Book.builder().
                title(this.bookTitle).
                securityAmount(this.securityAmount).
                bookNo(this.bookNo).
                type(this.bookType).
                build();
    }
}