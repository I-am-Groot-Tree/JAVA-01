package io.github.kimmking.gateway.inbound;

import io.github.kimmking.gateway.filter.HeaderHttpRequestFilter;
import io.github.kimmking.gateway.filter.HttpRequestFilter;
import io.github.kimmking.gateway.outbound.netty4.NettyHttpClient;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class HttpInboundHandler extends ChannelInboundHandlerAdapter {

    private final List<String> proxyServer;
    private NettyHttpClient client;
    private HttpRequestFilter filter = new HeaderHttpRequestFilter();
    
    HttpInboundHandler(List<String> proxyServer) {
        this.proxyServer = proxyServer;
        this.client = new NettyHttpClient(this.proxyServer);
    }
    
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            FullHttpRequest fullRequest = (FullHttpRequest) msg;
            //Netty Client处理请求
//            handler.handle(fullRequest, ctx, filter);
            client.handle(fullRequest, ctx, filter);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

}
