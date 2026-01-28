try {
    if (!jwtUtil.validateToken(jwtToken)) {
        throw new Exception("Invalid JWT token");
    }

    String username = jwtUtil.extractUsername(jwtToken);

    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

        UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());

        authenticationToken.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

} catch (CannotCreateTransactionException ex) {

    response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE); // 503
    response.getWriter().write("Database service is currently unavailable");
    return;

} catch (Exception ex) {

    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401
    response.getWriter().write("Token invalid or expired");
    return;
}
