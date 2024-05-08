package io.grpc.internal;

import com.google.common.base.o;
import io.grpc.ConnectivityState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ConnectivityStateManager {
    private ArrayList<Listener> listeners = new ArrayList<>();
    private volatile ConnectivityState state = ConnectivityState.IDLE;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Listener {
        public final Runnable callback;
        public final Executor executor;

        public Listener(Runnable runnable, Executor executor) {
            this.callback = runnable;
            this.executor = executor;
        }

        public void runInExecutor() {
            this.executor.execute(this.callback);
        }
    }

    public ConnectivityState getState() {
        ConnectivityState connectivityState = this.state;
        if (connectivityState != null) {
            return connectivityState;
        }
        throw new UnsupportedOperationException("Channel state API is not implemented");
    }

    public void gotoState(ConnectivityState connectivityState) {
        o.s(connectivityState, "newState");
        if (this.state == connectivityState || this.state == ConnectivityState.SHUTDOWN) {
            return;
        }
        this.state = connectivityState;
        if (this.listeners.isEmpty()) {
            return;
        }
        ArrayList<Listener> arrayList = this.listeners;
        this.listeners = new ArrayList<>();
        Iterator<Listener> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().runInExecutor();
        }
    }

    public void notifyWhenStateChanged(Runnable runnable, Executor executor, ConnectivityState connectivityState) {
        o.s(runnable, "callback");
        o.s(executor, "executor");
        o.s(connectivityState, "source");
        Listener listener = new Listener(runnable, executor);
        if (this.state != connectivityState) {
            listener.runInExecutor();
        } else {
            this.listeners.add(listener);
        }
    }
}
