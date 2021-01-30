package io.github.kimmking.gateway.filter;

import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;

public class HeaderHttpResponseFilter implements HttpResponseFilter {
    @Override
    public void filter(DefaultHttpResponse response) {
        response.headers().set("kk", "java-1-nio");
    }
}
