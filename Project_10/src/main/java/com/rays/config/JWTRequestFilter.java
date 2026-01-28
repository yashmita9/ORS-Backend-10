package com.rays.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.filter.OncePerRequestFilter;

import com.rays.service.JWTUserDetailsService;

@Component
public class JWTRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private JWTUserDetailsService jwtUserDetailsService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        final String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {

            String jwtToken = authorizationHeader.substring(7);

            try {
                if (!jwtUtil.validateToken(jwtToken)) {
                    throw new Exception("Invalid JWT token");
                }

                String username = jwtUtil.extractUsername(jwtToken);

                if (username != null &&
                    SecurityContextHolder.getContext().getAuthentication() == null) {

                    UserDetails userDetails =
                            jwtUserDetailsService.loadUserByUsername(username);

                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(
                                    userDetails, null, userDetails.getAuthorities());

                    authenticationToken.setDetails(
                            new WebAuthenticationDetailsSource()
                                    .buildDetails(request));

                    SecurityContextHolder.getContext()
                            .setAuthentication(authenticationToken);
                }

            } catch (CannotCreateTransactionException ex) {

                // ✅ DB DOWN CASE → 503
                response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
                response.getWriter()
                        .write("Database service is currently unavailable");
                return;

            } catch (Exception ex) {

                // ✅ TOKEN INVALID / EXPIRED → 401
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter()
                        .write("Token invalid or expired");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
