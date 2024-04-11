package com.rest.restclientdemo.controller;

import com.rest.restclientdemo.dto.StoreRequest;
import com.rest.restclientdemo.dto.StoreResponse;
import com.rest.restclientdemo.service.StoreRestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class RestClientController {

    private final StoreRestService service;

    @GetMapping
    public List<StoreResponse> getAllStores() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public StoreResponse getStoreById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public String insertStore(@RequestBody StoreRequest request) {
        return service.insert(request);
    }

    @PutMapping(value = "/{id}")
    public String updateStore(@PathVariable Long id, @RequestBody StoreRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteStore(@PathVariable Long id) {
        return service.delete(id);
    }
}
