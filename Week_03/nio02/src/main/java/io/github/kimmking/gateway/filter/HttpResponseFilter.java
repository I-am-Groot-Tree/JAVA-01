package io.github.kimmking.gateway.filter;

import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;

public interface HttpResponseFilter {

    void filter(DefaultHttpResponse response);

}
