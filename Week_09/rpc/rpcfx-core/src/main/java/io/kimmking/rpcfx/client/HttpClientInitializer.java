package io.kimmking.rpcfx.client;


import io.kimmking.rpcfx.api.RpcfxResponse;
import io.kimmking.rpcfx.filter.HttpResponseFilter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpContentDecompressor;
import io.netty.handler.ssl.SslContext;

public class HttpClientInitializer extends ChannelInitializer<SocketChannel> {

    private final SslContext sslCtx;
    private final HttpResponseFilter filter;
    private RpcfxResponse response;

    HttpClientInitializer(SslContext sslCtx, HttpResponseFilter filter, RpcfxResponse response) {
        this.sslCtx = sslCtx;
        this.filter = filter;
        this.response = response;
    }

    @Override
    public void initChannel(SocketChannel ch) {
        ChannelPipeline p = ch.pipeline();

        // Enable HTTPS if necessary.
        if (sslCtx != null) {
            p.addLast(sslCtx.newHandler(ch.alloc()));
        }

        p.addLast(new HttpClientCodec());

        // Remove the following line if you don't want automatic content decompression.
        p.addLast(new HttpContentDecompressor());

        // Uncomment the following line if you don't want to handle HttpContents.
        //p.addLast(new HttpObjectAggregator(1048576));

        p.addLast(new HttpClientHandler(response, filter));
    }
}
