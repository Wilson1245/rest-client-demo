package com.rest.restclientdemo.dto;

import lombok.Data;

@Data
public class StoreResponse {

    private Long id;

    private String name;

    private String address;

    private String phone;

    private String email;
}
