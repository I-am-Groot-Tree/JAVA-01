package io.kimmking.rpcfx.client;

import com.alibaba.fastjson.JSON;
import io.kimmking.rpcfx.api.RpcfxResponse;
import io.kimmking.rpcfx.filter.HttpResponseFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.util.CharsetUtil;

public class HttpClientHandler extends ChannelInboundHandlerAdapter {

    private RpcfxResponse response;
    private final HttpResponseFilter filter;

    HttpClientHandler(RpcfxResponse response,HttpResponseFilter filter) {
        this.response = response;
        this.filter = filter;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof DefaultHttpResponse) {
            DefaultHttpResponse response = (DefaultHttpResponse) msg;
            //过滤器
            filter.filter(response);

            HttpHeaders headers = response.headers();

            System.out.println("headers:" + System.getProperty("line.separator") + headers.toString());
        }
        if (msg instanceof HttpContent) {
            HttpContent content = (HttpContent) msg;

            String result = content.content().toString(CharsetUtil.UTF_8);
            response = JSON.parseObject(result,RpcfxResponse.class);

            if (content instanceof LastHttpContent) {
                ctx.close();
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
