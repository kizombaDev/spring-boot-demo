package org.kizombadev.spring.demo.configuration;

public class RequestIdStore {
    private static final ThreadLocal<String> CONTEXT = new ThreadLocal<>();

    public static void setRequestId(String requestId) {
        CONTEXT.set(requestId);
    }

    public static String getRequestId() {
        return CONTEXT.get();
    }

    public static void clear() {
        CONTEXT.remove();
    }
}
