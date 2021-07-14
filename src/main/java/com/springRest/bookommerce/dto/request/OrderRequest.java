package com.springRest.bookommerce.dto.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderRequest {
    private String userName;
    private String bookName;
    private Double bookPrice;
}
