package sun.nio.ch;

import java.io.IOException;
import java.nio.channels.spi.AsynchronousChannelProvider;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import sun.nio.ch.Invoker;
import sun.nio.ch.Port;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class EPollPort extends Port {
    private static final int ENOENT = 2;
    private static final int MAX_EPOLL_EVENTS = 512;
    private final Event EXECUTE_TASK_OR_SHUTDOWN;
    private final Event NEED_TO_POLL;
    private final long address;
    private boolean closed;
    private final int epfd;
    private final ArrayBlockingQueue<Event> queue;
    private final int[] sp;
    private final AtomicInteger wakeupCount;

    private static native void close0(int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void drain1(int i10) throws IOException;

    private static native void interrupt(int i10) throws IOException;

    private static native void socketpair(int[] iArr) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Event {
        final Port.PollableChannel channel;
        final int events;

        Event(Port.PollableChannel channel, int events) {
            this.channel = channel;
            this.events = events;
        }

        Port.PollableChannel channel() {
            return this.channel;
        }

        int events() {
            return this.events;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EPollPort(AsynchronousChannelProvider provider, ThreadPool pool) throws IOException {
        super(provider, pool);
        this.wakeupCount = new AtomicInteger();
        Event event = new Event(null, 0);
        this.NEED_TO_POLL = event;
        this.EXECUTE_TASK_OR_SHUTDOWN = new Event(null, 0);
        int epollCreate = EPoll.epollCreate();
        this.epfd = epollCreate;
        int[] sv = new int[2];
        try {
            socketpair(sv);
            EPoll.epollCtl(epollCreate, 1, sv[0], Net.POLLIN);
            this.sp = sv;
            this.address = EPoll.allocatePollArray(512);
            ArrayBlockingQueue<Event> arrayBlockingQueue = new ArrayBlockingQueue<>(512);
            this.queue = arrayBlockingQueue;
            arrayBlockingQueue.offer(event);
        } catch (IOException x10) {
            close0(this.epfd);
            throw x10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EPollPort start() {
        startThreads(new EventHandlerTask());
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void implClose() {
        synchronized (this) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            EPoll.freePollArray(this.address);
            close0(this.sp[0]);
            close0(this.sp[1]);
            close0(this.epfd);
        }
    }

    private void wakeup() {
        if (this.wakeupCount.incrementAndGet() == 1) {
            try {
                interrupt(this.sp[1]);
            } catch (IOException x10) {
                throw new AssertionError(x10);
            }
        }
    }

    @Override // sun.nio.ch.AsynchronousChannelGroupImpl
    void executeOnHandlerTask(Runnable task) {
        synchronized (this) {
            if (this.closed) {
                throw new RejectedExecutionException();
            }
            offerTask(task);
            wakeup();
        }
    }

    @Override // sun.nio.ch.AsynchronousChannelGroupImpl
    void shutdownHandlerTasks() {
        int nThreads = threadCount();
        if (nThreads == 0) {
            implClose();
            return;
        }
        while (true) {
            int nThreads2 = nThreads - 1;
            if (nThreads > 0) {
                wakeup();
                nThreads = nThreads2;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // sun.nio.ch.Port
    public void startPoll(int fd2, int events) {
        int err = EPoll.epollCtl(this.epfd, 3, fd2, events | 1073741824);
        if (err == 2) {
            err = EPoll.epollCtl(this.epfd, 1, fd2, 1073741824 | events);
        }
        if (err != 0) {
            throw new AssertionError();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class EventHandlerTask implements Runnable {
        private EventHandlerTask() {
        }

        private Event poll() throws IOException {
            while (true) {
                try {
                    int n10 = EPoll.epollWait(EPollPort.this.epfd, EPollPort.this.address, 512);
                    EPollPort.this.fdToChannelLock.readLock().lock();
                    while (true) {
                        int n11 = n10 - 1;
                        if (n10 > 0) {
                            try {
                                long eventAddress = EPoll.getEvent(EPollPort.this.address, n11);
                                int fd2 = EPoll.getDescriptor(eventAddress);
                                if (fd2 == EPollPort.this.sp[0]) {
                                    if (EPollPort.this.wakeupCount.decrementAndGet() == 0) {
                                        EPollPort.drain1(EPollPort.this.sp[0]);
                                    }
                                    if (n11 <= 0) {
                                        return EPollPort.this.EXECUTE_TASK_OR_SHUTDOWN;
                                    }
                                    EPollPort.this.queue.offer(EPollPort.this.EXECUTE_TASK_OR_SHUTDOWN);
                                } else {
                                    Port.PollableChannel channel = EPollPort.this.fdToChannel.get(Integer.valueOf(fd2));
                                    if (channel != null) {
                                        int events = EPoll.getEvents(eventAddress);
                                        Event ev = new Event(channel, events);
                                        if (n11 <= 0) {
                                            return ev;
                                        }
                                        EPollPort.this.queue.offer(ev);
                                    } else {
                                        continue;
                                    }
                                }
                                n10 = n11;
                            } finally {
                                EPollPort.this.fdToChannelLock.readLock().unlock();
                            }
                        }
                    }
                } finally {
                    EPollPort.this.queue.offer(EPollPort.this.NEED_TO_POLL);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int remaining;
            boolean isShutdown;
            Invoker.GroupAndInvokeCount myGroupAndInvokeCount = Invoker.getGroupAndInvokeCount();
            boolean isPooledThread = myGroupAndInvokeCount != null;
            boolean replaceMe = false;
            while (true) {
                if (isPooledThread) {
                    try {
                        myGroupAndInvokeCount.resetInvokeCount();
                    } finally {
                        remaining = EPollPort.this.threadExit(this, replaceMe);
                        if (remaining == 0 && EPollPort.this.isShutdown()) {
                            EPollPort.this.implClose();
                        }
                    }
                }
                replaceMe = false;
                try {
                    Event ev = (Event) EPollPort.this.queue.take();
                    if (ev == EPollPort.this.NEED_TO_POLL) {
                        try {
                            ev = poll();
                        } catch (IOException x10) {
                            x10.printStackTrace();
                            int remaining2 = EPollPort.this.threadExit(this, false);
                            if (remaining2 != 0 || !EPollPort.this.isShutdown()) {
                                return;
                            }
                            EPollPort.this.implClose();
                            return;
                        }
                    }
                    if (ev == EPollPort.this.EXECUTE_TASK_OR_SHUTDOWN) {
                        Runnable task = EPollPort.this.pollTask();
                        if (task != null) {
                            replaceMe = true;
                            task.run();
                        } else {
                            if (remaining == 0) {
                                if (isShutdown) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                            return;
                        }
                    } else {
                        try {
                            try {
                                ev.channel().onEvent(ev.events(), isPooledThread);
                            } catch (RuntimeException x11) {
                                throw x11;
                            }
                        } catch (Error x12) {
                            throw x12;
                        }
                    }
                } catch (InterruptedException e2) {
                }
            }
        }
    }
}
