package io.github.kimmking.gateway.outbound.netty4;

import io.github.kimmking.gateway.filter.HttpResponseFilter;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.util.CharsetUtil;

public class HttpClientHandler extends ChannelInboundHandlerAdapter {

    private final HttpResponseFilter filter;

    HttpClientHandler(HttpResponseFilter filter) {
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

            System.out.print(content.content().toString(CharsetUtil.UTF_8));
            System.out.flush();

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
