package com.rest.restclientdemo.service;

import com.rest.restclientdemo.dto.StoreRequest;
import com.rest.restclientdemo.dto.StoreResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreRestService {

    private final RestClient restClient;

    public StoreRestService() {
        restClient = RestClient.builder().baseUrl("http://localhost:8080/store").build();
    }

    public List<StoreResponse> findAll() {
        return restClient.get().uri("").retrieve()
                .body(new ParameterizedTypeReference<List<StoreResponse>>() {
                });
    }

    public StoreResponse findById(Long id) {
        return restClient.get().uri("/{id}", id)
                .retrieve().body(StoreResponse.class);
    }

    public String insert(StoreRequest request) {
        return restClient.post().uri("")
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(String.class);
    }

    public String update(Long id, StoreRequest request) {
        return restClient.put().uri("/updateB/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(String.class);
    }

    public String delete(Long id) {
        return restClient.delete().uri("/{id}", id)
                .retrieve().body(String.class);
    }

}
