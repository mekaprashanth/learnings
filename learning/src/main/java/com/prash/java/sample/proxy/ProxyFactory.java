package com.prash.java.sample.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    public static EndpointProvider createProxy(EndpointProvider proxiedEndpointProvider) {
        ClassLoader classLoader = proxiedEndpointProvider.getClass().getClassLoader();
        Class<?>[] interfaces = {EndpointProvider.class};
        InvocationHandler handler = new EndpointOverrideHandler(null, proxiedEndpointProvider);
        return (EndpointProvider) Proxy.newProxyInstance(classLoader, interfaces, handler);
    }

    public static Subscription createProxy(Subscription subscription, EndpointProvider proxiedEndpointProvider) {
        ClassLoader classLoader = subscription.getClass().getClassLoader();
        Class<?>[] interfaces = {Subscription.class};
        InvocationHandler handler = new EndpointOverrideHandler(subscription, proxiedEndpointProvider);
        return (Subscription) Proxy.newProxyInstance(classLoader, interfaces, handler);
    }
}
