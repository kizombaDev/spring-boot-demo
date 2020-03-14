package org.kizombadev.spring.demo.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(1)
@Slf4j
public class XRequestIdFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {

        if (RequestIdStore.getRequestId() == null) {
            log.info("The requestIdStore is empty");
        } else {
            log.error("The requestIdStore contains the id {} from an old request ", RequestIdStore.getRequestId());
        }

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestId = request.getHeader("X-Request-Id");
        try {
            RequestIdStore.setRequestId(requestId);
            log.info("The requestIdStore has the id {}", RequestIdStore.getRequestId());
            chain.doFilter(servletRequest, servletResponse);
        } finally {
            // Otherwise when a previously used container thread is used, it will have the old tenant id set and
            // if for some reason this filter is skipped, tenantStore will hold an unreliable value
            RequestIdStore.clear();
            log.info("The requestIdStore is cleared");
        }
    }

}
