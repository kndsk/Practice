package netty;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Auther: liuyao
 * @Date: 2018/11/26 19:00
 * @Description:
 */
@ChannelHandler.Sharable
public   class   EchoServerHandler   extends
        ChannelInboundHandlerAdapter {
    @Override
    public   void   channelRead(ChannelHandlerContext ctx, Object   msg)   {
        System.out.println("Server  received:  "  +  msg);
        ctx.write(msg); //#2
        System.out.println("Server  响应数据:  "  +  msg);
    }
    @Override
    public  void  channelReadComplete(ChannelHandlerContext  ctx)  {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
                .addListener(ChannelFutureListener.CLOSE); //#3
    }
    @Override
    public  void  exceptionCaught(ChannelHandlerContext  ctx,
                                  Throwable  cause)  {
        cause.printStackTrace(); //#4
        ctx.close(); //#5
    }
}