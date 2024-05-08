package java.nio.channels;

import java.io.IOException;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.nio.ByteBuffer;
import java.nio.channels.spi.AsynchronousChannelProvider;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AsynchronousSocketChannel implements AsynchronousByteChannel, NetworkChannel {
    private final AsynchronousChannelProvider provider;

    @Override // java.nio.channels.NetworkChannel
    public abstract AsynchronousSocketChannel bind(SocketAddress socketAddress) throws IOException;

    public abstract Future<Void> connect(SocketAddress socketAddress);

    public abstract <A> void connect(SocketAddress socketAddress, A a10, CompletionHandler<Void, ? super A> completionHandler);

    @Override // java.nio.channels.NetworkChannel
    public abstract SocketAddress getLocalAddress() throws IOException;

    public abstract SocketAddress getRemoteAddress() throws IOException;

    @Override // java.nio.channels.AsynchronousByteChannel
    public abstract Future<Integer> read(ByteBuffer byteBuffer);

    public abstract <A> void read(ByteBuffer byteBuffer, long j10, TimeUnit timeUnit, A a10, CompletionHandler<Integer, ? super A> completionHandler);

    public abstract <A> void read(ByteBuffer[] byteBufferArr, int i10, int i11, long j10, TimeUnit timeUnit, A a10, CompletionHandler<Long, ? super A> completionHandler);

    @Override // java.nio.channels.NetworkChannel
    public abstract <T> AsynchronousSocketChannel setOption(SocketOption<T> socketOption, T t2) throws IOException;

    public abstract AsynchronousSocketChannel shutdownInput() throws IOException;

    public abstract AsynchronousSocketChannel shutdownOutput() throws IOException;

    @Override // java.nio.channels.AsynchronousByteChannel
    public abstract Future<Integer> write(ByteBuffer byteBuffer);

    public abstract <A> void write(ByteBuffer byteBuffer, long j10, TimeUnit timeUnit, A a10, CompletionHandler<Integer, ? super A> completionHandler);

    public abstract <A> void write(ByteBuffer[] byteBufferArr, int i10, int i11, long j10, TimeUnit timeUnit, A a10, CompletionHandler<Long, ? super A> completionHandler);

    @Override // java.nio.channels.NetworkChannel
    public /* bridge */ /* synthetic */ NetworkChannel setOption(SocketOption socketOption, Object obj) throws IOException {
        return setOption((SocketOption<SocketOption>) socketOption, (SocketOption) obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AsynchronousSocketChannel(AsynchronousChannelProvider provider) {
        this.provider = provider;
    }

    public final AsynchronousChannelProvider provider() {
        return this.provider;
    }

    public static AsynchronousSocketChannel open(AsynchronousChannelGroup group) throws IOException {
        AsynchronousChannelProvider provider = group == null ? AsynchronousChannelProvider.provider() : group.provider();
        return provider.openAsynchronousSocketChannel(group);
    }

    public static AsynchronousSocketChannel open() throws IOException {
        return open(null);
    }

    @Override // java.nio.channels.AsynchronousByteChannel
    public final <A> void read(ByteBuffer dst, A attachment, CompletionHandler<Integer, ? super A> handler) {
        read(dst, 0L, TimeUnit.MILLISECONDS, attachment, handler);
    }

    @Override // java.nio.channels.AsynchronousByteChannel
    public final <A> void write(ByteBuffer src, A attachment, CompletionHandler<Integer, ? super A> handler) {
        write(src, 0L, TimeUnit.MILLISECONDS, attachment, handler);
    }
}
