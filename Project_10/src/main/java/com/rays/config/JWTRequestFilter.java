@Override
protected void doFilterInternal(HttpServletRequest request,
                                HttpServletResponse response,
                                FilterChain filterChain)
        throws ServletException, IOException {

    final String authorizationHeader = request.getHeader("Authorization");
    System.out.println("JWT Token ======>>>>> " + authorizationHeader);

    if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {

        String jwtToken = authorizationHeader.substring(7);

        try {
            // ✅ Only token validation (NO DB)
            if (!jwtUtil.validateToken(jwtToken)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Invalid or expired token");
                return;
            }

            String username = jwtUtil.extractUsername(jwtToken);

            if (username != null &&
                SecurityContextHolder.getContext().getAuthentication() == null) {

                // ❗ DB call happens here
                UserDetails userDetails =
                        jwtUserDetailsService.loadUserByUsername(username);

                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());

                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext()
                        .setAuthentication(authToken);
            }

        } catch (CannotCreateTransactionException ex) {

            response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
            response.getWriter()
                    .write("Database service is currently unavailable");
            return;

        } catch (Exception ex) {

            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter()
                    .write("Token invalid or expired");
            return;
        }
    }

    filterChain.doFilter(request, response);
}
