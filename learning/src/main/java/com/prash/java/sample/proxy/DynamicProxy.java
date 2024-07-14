//package com.prash.java.sample.proxy;
//
//import java.lang.reflect.InvocationHandler;
//
//public class DynamicProxy {
//
//    public static void main(String[] args) {
//        // Create a sample Subscription object
//        Subscription originalSubscription = new MySubscriptionImpl(123L, new MyEndpointProviderImpl("original_endpoint"));
//
//        EndpointProvider endpointProvider = originalSubscription.getEndpointProvider();
//        InvocationHandler handler = ((proxy, method, _args) -> {
//            if (method.getName().equals("getEndpoint")) {
//                String originalEndpoint = endpointProvider.getEndpoint();
//                return "modified_" + originalEndpoint;
//            } else {
//                return method.invoke(endpointProvider, args);
//            }
//        });
//// Create a proxy object with overridden getEndpoint
//        EndpointProvider proxyEndpointProvider = ProxyFactory.createProxy(endpointProvider, handler);
//        Subscription proxySubscription = ProxyFactory.createProxy(originalSubscription, proxyEndpointProvider);
//
//// Call methods on the proxy
//        long id = proxySubscription.getId(); // Returns original id
//        String endpoint = proxySubscription.getEndpointProvider().getEndpoint(); // Returns "modified_original_endpoint"
//
//        System.out.println("ID: " + id);
//        System.out.println("Endpoint: " + endpoint);
//    }
//}
