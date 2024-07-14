//package com.prash.java.sample.proxy;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Proxy;
//
//public class ProxyFactory {
//
//    public static <T>  T createProxy(T endpointProvider, InvocationHandler handler) {
//        ClassLoader classLoader = endpointProvider.getClass().getClassLoader();
//        Class<?>[] interfaces =
//        return (T) Proxy.newProxyInstance(classLoader, interfaces, handler);
//    }
//
//    public static Subscription createProxy(Subscription subscription, EndpointProvider proxiedEndpointProvider) {
//        ClassLoader classLoader = subscription.getClass().getClassLoader();
//        Class<?>[] interfaces = {Subscription.class};
//        InvocationHandler handler = ((proxy, method, args) -> {
//            if (method.getName().equals("getEndpointProvider")) {
//                return proxiedEndpointProvider;
//            } else {
//                return method.invoke(subscription, args);
//            }
//        });
//        return (Subscription) Proxy.newProxyInstance(classLoader, interfaces, handler);
//    }
//}
