package com.rest.restclientdemo.dto;

import lombok.Data;

@Data
public class StoreRequest {

    private String name;

    private String address;

    private String phone;

    private String email;
}
