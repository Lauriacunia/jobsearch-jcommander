package com.letscodemom.api;

import feign.Feign;
import feign.gson.GsonDecoder;

public interface APIFunctions {
    /**
     * Build an API client for the given class and URL.
     *
     * @param clazz The class of the API client.
     * @param url   The URL of the API.
     * @param <T>   The type of the API client.
     * @return An API client for the given class and URL.
     */
    static <T> T buildAPI(Class<T> clazz, String url) {
        return Feign.builder()
                .decoder(new GsonDecoder())
                .target(clazz, url);
    }

}
