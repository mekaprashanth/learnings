package com.prash.java.sample.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EndpointOverrideHandler implements InvocationHandler {

    private final Subscription subscription; // Original subscription object
    private final EndpointProvider proxiedEndpointProvider;

    public EndpointOverrideHandler(Subscription subscription, EndpointProvider proxiedEndpointProvider) {
        this.subscription = subscription;
        this.proxiedEndpointProvider = proxiedEndpointProvider;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(proxy instanceof Subscription) {
            if (method.getName().equals("getEndpointProvider")) {
                return proxiedEndpointProvider;
            } else {
                return method.invoke(subscription, args);
            }
        } else {
            if (method.getName().equals("getEndpoint")) {
                String originalEndpoint = proxiedEndpointProvider.getEndpoint();
                return "modified_" + originalEndpoint;
            } else {
                return method.invoke(proxiedEndpointProvider, args);
            }
        }

    }
}
