package netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @Auther: liuyao
 * @Date: 2018/11/26 19:23
 * @Description:
 */
@ChannelHandler.Sharable
public  class  EchoClientHandler  extends SimpleChannelInboundHandler<ByteBuf> {
    @Override
    public  void  channelActive(ChannelHandlerContext ctx)  {
        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty  rocks!",
                CharsetUtil.UTF_8)); //#2
        System.out.println("Client  发送数据：Netty  rocks!");
    }
    @Override
    public   void   channelRead0(ChannelHandlerContext   ctx,
                                 ByteBuf  in)  {
        System.out.println("Client  received:  "  +  ByteBufUtil
                .hexDump(in.readBytes(in.readableBytes()))); //#3
    }
    @Override
    public  void  exceptionCaught(ChannelHandlerContext  ctx,  Throwable  cause)  {      //#4
        cause.printStackTrace();
        ctx.close();
    }
}
//#1 
