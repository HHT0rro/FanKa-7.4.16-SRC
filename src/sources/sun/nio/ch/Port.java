package sun.nio.ch;

import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.Channel;
import java.nio.channels.ShutdownChannelGroupException;
import java.nio.channels.spi.AsynchronousChannelProvider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
abstract class Port extends AsynchronousChannelGroupImpl {
    protected final Map<Integer, PollableChannel> fdToChannel;
    protected final ReadWriteLock fdToChannelLock;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface PollableChannel extends Closeable {
        void onEvent(int i10, boolean z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void startPoll(int i10, int i11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Port(AsynchronousChannelProvider provider, ThreadPool pool) {
        super(provider, pool);
        this.fdToChannelLock = new ReentrantReadWriteLock();
        this.fdToChannel = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void register(int fd2, PollableChannel ch) {
        this.fdToChannelLock.writeLock().lock();
        try {
            if (isShutdown()) {
                throw new ShutdownChannelGroupException();
            }
            this.fdToChannel.put(Integer.valueOf(fd2), ch);
        } finally {
            this.fdToChannelLock.writeLock().unlock();
        }
    }

    protected void preUnregister(int fd2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void unregister(int fd2) {
        boolean checkForShutdown = false;
        preUnregister(fd2);
        this.fdToChannelLock.writeLock().lock();
        try {
            this.fdToChannel.remove(Integer.valueOf(fd2));
            if (this.fdToChannel.isEmpty()) {
                checkForShutdown = true;
            }
            if (checkForShutdown && isShutdown()) {
                try {
                    shutdownNow();
                } catch (IOException e2) {
                }
            }
        } finally {
            this.fdToChannelLock.writeLock().unlock();
        }
    }

    @Override // sun.nio.ch.AsynchronousChannelGroupImpl
    final boolean isEmpty() {
        this.fdToChannelLock.writeLock().lock();
        try {
            return this.fdToChannel.isEmpty();
        } finally {
            this.fdToChannelLock.writeLock().unlock();
        }
    }

    @Override // sun.nio.ch.AsynchronousChannelGroupImpl
    final Object attachForeignChannel(final Channel channel, FileDescriptor fd2) {
        int fdVal = IOUtil.fdVal(fd2);
        register(fdVal, new PollableChannel() { // from class: sun.nio.ch.Port.1
            @Override // sun.nio.ch.Port.PollableChannel
            public void onEvent(int events, boolean mayInvokeDirect) {
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                channel.close();
            }
        });
        return Integer.valueOf(fdVal);
    }

    @Override // sun.nio.ch.AsynchronousChannelGroupImpl
    final void detachForeignChannel(Object key) {
        unregister(((Integer) key).intValue());
    }

    @Override // sun.nio.ch.AsynchronousChannelGroupImpl
    final void closeAllChannels() {
        int count;
        PollableChannel[] channels = new PollableChannel[128];
        do {
            this.fdToChannelLock.writeLock().lock();
            count = 0;
            try {
                Iterator<Integer> iterator2 = this.fdToChannel.h().iterator2();
                while (true) {
                    if (!iterator2.hasNext()) {
                        break;
                    }
                    Integer fd2 = iterator2.next();
                    int count2 = count + 1;
                    try {
                        channels[count] = this.fdToChannel.get(fd2);
                        if (count2 >= 128) {
                            count = count2;
                            break;
                        }
                        count = count2;
                    } catch (Throwable th) {
                        th = th;
                        this.fdToChannelLock.writeLock().unlock();
                        throw th;
                    }
                }
                this.fdToChannelLock.writeLock().unlock();
                for (int i10 = 0; i10 < count; i10++) {
                    try {
                        channels[i10].close();
                    } catch (IOException e2) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } while (count > 0);
    }
}
