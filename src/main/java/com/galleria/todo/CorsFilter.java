package com.galleria.todo;

import spark.Filter;
import spark.Request;
import spark.Response;

public class CorsFilter implements Filter {
	private static final String headerAllowHeaders = "Access-Control-Allow-Headers";
	private static final String headerAllowOrigin = "Access-Control-Allow-Origin";
	private static final String headerRequestMethod = "Access-Control-Request-Method";
	private static final String headerAllowMethods = "Access-Control-Allow-Methods";
	private static final String wildcard = "*";
	private static final String method = "GET,POST,DELETE,PUT,PATCH,OPTIONS";

	public CorsFilter() {
	}

	@Override
	public void handle(Request request, Response response) throws Exception {
		response.header(headerAllowOrigin, wildcard);
		response.header(headerRequestMethod, method);
		response.header(headerAllowHeaders, wildcard);
		response.header(headerAllowMethods, method);
	}
	
}
