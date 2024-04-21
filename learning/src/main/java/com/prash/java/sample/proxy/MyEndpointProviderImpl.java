package com.prash.java.sample.proxy;

public class MyEndpointProviderImpl implements EndpointProvider{

    private String endpoint;

    public MyEndpointProviderImpl(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public String getEndpoint() {
        return endpoint;
    }
}
