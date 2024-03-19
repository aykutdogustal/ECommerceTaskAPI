package com.demov2.apisablon.dto.request;

public record ProductRequest(

        String productName,
        String productDesc,
        String productPrice,
        long categoriesId,
        int productStock

) {
}
