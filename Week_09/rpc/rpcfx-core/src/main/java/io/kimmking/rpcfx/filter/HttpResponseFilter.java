package io.kimmking.rpcfx.filter;

import io.netty.handler.codec.http.DefaultHttpResponse;

public interface HttpResponseFilter {

    void filter(DefaultHttpResponse response);

}
