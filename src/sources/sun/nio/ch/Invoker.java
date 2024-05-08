package sun.nio.ch;

import java.nio.channels.AsynchronousChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.ShutdownChannelGroupException;
import java.security.AccessController;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import sun.security.action.GetIntegerAction;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class Invoker {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int maxHandlerInvokeCount = ((Integer) AccessController.doPrivileged(new GetIntegerAction("sun.nio.ch.maxCompletionHandlersOnStack", 16))).intValue();
    private static final ThreadLocal<GroupAndInvokeCount> myGroupAndInvokeCount = new ThreadLocal<GroupAndInvokeCount>() { // from class: sun.nio.ch.Invoker.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public GroupAndInvokeCount initialValue() {
            return null;
        }
    };

    private Invoker() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class GroupAndInvokeCount {
        private final AsynchronousChannelGroupImpl group;
        private int handlerInvokeCount;

        GroupAndInvokeCount(AsynchronousChannelGroupImpl group) {
            this.group = group;
        }

        AsynchronousChannelGroupImpl group() {
            return this.group;
        }

        int invokeCount() {
            return this.handlerInvokeCount;
        }

        void setInvokeCount(int value) {
            this.handlerInvokeCount = value;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void resetInvokeCount() {
            this.handlerInvokeCount = 0;
        }

        void incrementInvokeCount() {
            this.handlerInvokeCount++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void bindToGroup(AsynchronousChannelGroupImpl group) {
        myGroupAndInvokeCount.set(new GroupAndInvokeCount(group));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GroupAndInvokeCount getGroupAndInvokeCount() {
        return myGroupAndInvokeCount.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isBoundToAnyGroup() {
        return myGroupAndInvokeCount.get() != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean mayInvokeDirect(GroupAndInvokeCount myGroupAndInvokeCount2, AsynchronousChannelGroupImpl group) {
        if (myGroupAndInvokeCount2 != null && myGroupAndInvokeCount2.group() == group && myGroupAndInvokeCount2.invokeCount() < maxHandlerInvokeCount) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <V, A> void invokeUnchecked(CompletionHandler<V, ? super A> handler, A a10, V value, Throwable exc) {
        if (exc == null) {
            handler.completed(value, a10);
        } else {
            handler.failed(exc, a10);
        }
        Thread.interrupted();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V, A> void invokeDirect(GroupAndInvokeCount myGroupAndInvokeCount2, CompletionHandler<V, ? super A> handler, A attachment, V result, Throwable exc) {
        myGroupAndInvokeCount2.incrementInvokeCount();
        invokeUnchecked(handler, attachment, result, exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V, A> void invoke(AsynchronousChannel channel, CompletionHandler<V, ? super A> handler, A attachment, V result, Throwable exc) {
        boolean invokeDirect = false;
        boolean identityOkay = false;
        GroupAndInvokeCount thisGroupAndInvokeCount = myGroupAndInvokeCount.get();
        if (thisGroupAndInvokeCount != null) {
            if (thisGroupAndInvokeCount.group() == ((Groupable) channel).group()) {
                identityOkay = true;
            }
            if (identityOkay && thisGroupAndInvokeCount.invokeCount() < maxHandlerInvokeCount) {
                invokeDirect = true;
            }
        }
        if (invokeDirect) {
            invokeDirect(thisGroupAndInvokeCount, handler, attachment, result, exc);
            return;
        }
        try {
            invokeIndirectly(channel, handler, attachment, result, exc);
        } catch (RejectedExecutionException e2) {
            if (identityOkay) {
                invokeDirect(thisGroupAndInvokeCount, handler, attachment, result, exc);
                return;
            }
            throw new ShutdownChannelGroupException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V, A> void invokeIndirectly(AsynchronousChannel channel, final CompletionHandler<V, ? super A> handler, final A attachment, final V result, final Throwable exc) {
        try {
            ((Groupable) channel).group().executeOnPooledThread(new Runnable() { // from class: sun.nio.ch.Invoker.2
                @Override // java.lang.Runnable
                public void run() {
                    GroupAndInvokeCount thisGroupAndInvokeCount = (GroupAndInvokeCount) Invoker.myGroupAndInvokeCount.get();
                    if (thisGroupAndInvokeCount != null) {
                        thisGroupAndInvokeCount.setInvokeCount(1);
                    }
                    Invoker.invokeUnchecked(CompletionHandler.this, attachment, result, exc);
                }
            });
        } catch (RejectedExecutionException e2) {
            throw new ShutdownChannelGroupException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V, A> void invokeIndirectly(final CompletionHandler<V, ? super A> handler, final A attachment, final V value, final Throwable exc, Executor executor) {
        try {
            executor.execute(new Runnable() { // from class: sun.nio.ch.Invoker.3
                @Override // java.lang.Runnable
                public void run() {
                    Invoker.invokeUnchecked(CompletionHandler.this, attachment, value, exc);
                }
            });
        } catch (RejectedExecutionException e2) {
            throw new ShutdownChannelGroupException();
        }
    }

    static void invokeOnThreadInThreadPool(Groupable channel, Runnable task) {
        boolean invokeDirect;
        GroupAndInvokeCount thisGroupAndInvokeCount = myGroupAndInvokeCount.get();
        AsynchronousChannelGroupImpl targetGroup = channel.group();
        if (thisGroupAndInvokeCount == null) {
            invokeDirect = false;
        } else {
            invokeDirect = thisGroupAndInvokeCount.group == targetGroup;
        }
        try {
            if (invokeDirect) {
                task.run();
            } else {
                targetGroup.executeOnPooledThread(task);
            }
        } catch (RejectedExecutionException e2) {
            throw new ShutdownChannelGroupException();
        }
    }

    static <V, A> void invokeUnchecked(PendingFuture<V, A> future) {
        CompletionHandler<V, ? super A> handler = future.handler();
        if (handler != null) {
            invokeUnchecked(handler, future.attachment(), future.value(), future.exception());
        }
    }

    static <V, A> void invoke(PendingFuture<V, A> future) {
        CompletionHandler<V, ? super A> handler = future.handler();
        if (handler != null) {
            invoke(future.channel(), handler, future.attachment(), future.value(), future.exception());
        }
    }

    static <V, A> void invokeIndirectly(PendingFuture<V, A> future) {
        CompletionHandler<V, ? super A> handler = future.handler();
        if (handler != null) {
            invokeIndirectly(future.channel(), handler, future.attachment(), future.value(), future.exception());
        }
    }
}
