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
import org.springframework.web.filter.OncePerRequestFilter;

import com.rays.service.JWTUserDetailsService;

@Component
public class JWTRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private JWTUserDetailsService jwtUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String authorizationHeader = request.getHeader("Authorization");

		System.out.println("JWT Token ======>>>>> " + authorizationHeader);

		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {

			String jwtToken = authorizationHeader.substring(7);

			try {
				if (!jwtUtil.validateToken(jwtToken)) {
					throw new Exception("Invalid JWT token");
				}

				String username = jwtUtil.extractUsername(jwtToken);

				if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

					UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);

					UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());

					authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				}
			} catch (Exception e) {

			    // DB related exceptions → return 503 directly
			    if (e instanceof org.springframework.transaction.CannotCreateTransactionException
			            || e instanceof org.springframework.dao.DataAccessResourceFailureException
			            || e instanceof org.hibernate.exception.JDBCConnectionException) {

			        response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
			        response.setContentType("application/json");

			        response.getWriter().write(
			            "{\"success\":false,\"message\":[\"Database service is currently unavailable. Please try again later.\"]}"
			        );
			        return;   // stop filter chain
			    }

			    // JWT related errors → 401
			    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			    response.setContentType("application/json");

			    response.getWriter().write(
			        "{\"success\":false,\"message\":[\"Token is invalid or expired. Please login again.\"]}"
			    );
			    return;
			}


		}
		filterChain.doFilter(request, response);
	}
}
