package com.springRest.bookommerce.dto.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookRequest {
    private String bookName;
    private String authorName;
    private Double bookPrice;
}
