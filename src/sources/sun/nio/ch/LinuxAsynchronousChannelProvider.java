package sun.nio.ch;

import java.io.IOException;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.IllegalChannelGroupException;
import java.nio.channels.spi.AsynchronousChannelProvider;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class LinuxAsynchronousChannelProvider extends AsynchronousChannelProvider {
    private static volatile EPollPort defaultPort;

    private EPollPort defaultEventPort() throws IOException {
        if (defaultPort == null) {
            synchronized (LinuxAsynchronousChannelProvider.class) {
                if (defaultPort == null) {
                    defaultPort = new EPollPort(this, ThreadPool.getDefault()).start();
                }
            }
        }
        return defaultPort;
    }

    @Override // java.nio.channels.spi.AsynchronousChannelProvider
    public AsynchronousChannelGroup openAsynchronousChannelGroup(int nThreads, ThreadFactory factory) throws IOException {
        return new EPollPort(this, ThreadPool.create(nThreads, factory)).start();
    }

    @Override // java.nio.channels.spi.AsynchronousChannelProvider
    public AsynchronousChannelGroup openAsynchronousChannelGroup(ExecutorService executor, int initialSize) throws IOException {
        return new EPollPort(this, ThreadPool.wrap(executor, initialSize)).start();
    }

    private Port toPort(AsynchronousChannelGroup group) throws IOException {
        if (group == null) {
            return defaultEventPort();
        }
        if (!(group instanceof EPollPort)) {
            throw new IllegalChannelGroupException();
        }
        return (Port) group;
    }

    @Override // java.nio.channels.spi.AsynchronousChannelProvider
    public AsynchronousServerSocketChannel openAsynchronousServerSocketChannel(AsynchronousChannelGroup group) throws IOException {
        return new UnixAsynchronousServerSocketChannelImpl(toPort(group));
    }

    @Override // java.nio.channels.spi.AsynchronousChannelProvider
    public AsynchronousSocketChannel openAsynchronousSocketChannel(AsynchronousChannelGroup group) throws IOException {
        return new UnixAsynchronousSocketChannelImpl(toPort(group));
    }
}
