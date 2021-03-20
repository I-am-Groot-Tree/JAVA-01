package io.kimmking.rpcfx.filter;

import io.netty.handler.codec.http.DefaultHttpResponse;

public class HeaderHttpResponseFilter implements HttpResponseFilter {
    @Override
    public void filter(DefaultHttpResponse response) {
        response.headers().set("kk", "java-1-nio");
    }
}
