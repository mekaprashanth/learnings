package com.prash.java.sample.proxy;

public class MySubscriptionImpl implements Subscription{

    private long id;
    private EndpointProvider endpointProvider;

    public MySubscriptionImpl(long id, EndpointProvider endpointProvider) {
        this.id = id;
        this.endpointProvider = endpointProvider;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public EndpointProvider getEndpointProvider() {
        return endpointProvider;
    }
}
