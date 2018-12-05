package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @Auther: liuyao
 * @Date: 2018/11/26 18:52
 * @Description:
 */
public  class EchoServer {
    private  final int port;
    public EchoServer(int port)  {
        this.port =  port;
    }
    public void start()  throws  Exception  {
        EventLoopGroup group   =   new NioEventLoopGroup();
        try  {
            ServerBootstrap b  =  new  ServerBootstrap();     //#1
            b.group(group) //#2
                    .channel(NioServerSocketChannel.class)    //#2
                    .localAddress(new InetSocketAddress(port)) //#2
                    .childHandler(new  ChannelInitializer<SocketChannel>()  { //#3
                        @Override
                        public void initChannel(SocketChannel  ch)
                                throws  Exception  {
                            ch.pipeline().addLast(
                                    new EchoServerHandler()); //#4
                        }
                    });
            ChannelFuture f  =  b.bind().sync(); //#5
             System.out.println(EchoServer.class.getName()  + //#6
                    "started  and  listen  on  " +  f.channel().localAddress());//#7
            f.channel().closeFuture().sync(); //#8
        }  finally  { //#9
            group.shutdownGracefully().sync(); //#10
        }
    }

    public   static void main(String[]   args)   throws   Exception   {
        if  (args.length !=1)  {
            System.err.println(
                    "11111111111111"+  EchoServer.class.getSimpleName()  + "11111111111111");
        }
        int  port  =  8080;
        new EchoServer(port).start();
    }
}
