package java.nio.channels;

import java.io.IOException;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.nio.channels.spi.AsynchronousChannelProvider;
import java.util.concurrent.Future;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AsynchronousServerSocketChannel implements AsynchronousChannel, NetworkChannel {
    private final AsynchronousChannelProvider provider;

    public abstract Future<AsynchronousSocketChannel> accept();

    public abstract <A> void accept(A a10, CompletionHandler<AsynchronousSocketChannel, ? super A> completionHandler);

    public abstract AsynchronousServerSocketChannel bind(SocketAddress socketAddress, int i10) throws IOException;

    @Override // java.nio.channels.NetworkChannel
    public abstract SocketAddress getLocalAddress() throws IOException;

    @Override // java.nio.channels.NetworkChannel
    public abstract <T> AsynchronousServerSocketChannel setOption(SocketOption<T> socketOption, T t2) throws IOException;

    @Override // java.nio.channels.NetworkChannel
    public /* bridge */ /* synthetic */ NetworkChannel setOption(SocketOption socketOption, Object obj) throws IOException {
        return setOption((SocketOption<SocketOption>) socketOption, (SocketOption) obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AsynchronousServerSocketChannel(AsynchronousChannelProvider provider) {
        this.provider = provider;
    }

    public final AsynchronousChannelProvider provider() {
        return this.provider;
    }

    public static AsynchronousServerSocketChannel open(AsynchronousChannelGroup group) throws IOException {
        AsynchronousChannelProvider provider = group == null ? AsynchronousChannelProvider.provider() : group.provider();
        return provider.openAsynchronousServerSocketChannel(group);
    }

    public static AsynchronousServerSocketChannel open() throws IOException {
        return open(null);
    }

    @Override // java.nio.channels.NetworkChannel
    public final AsynchronousServerSocketChannel bind(SocketAddress local) throws IOException {
        return bind(local, 0);
    }
}
