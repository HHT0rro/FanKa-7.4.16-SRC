package com.android.internal.listeners;

import android.os.RemoteException;
import android.util.ArrayMap;
import com.android.internal.listeners.ListenerTransport;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class ListenerTransportManager<TTransport extends ListenerTransport<?>> {
    private final Map<Object, WeakReference<TTransport>> mRegistrations;

    protected abstract void registerTransport(TTransport ttransport) throws RemoteException;

    protected abstract void unregisterTransport(TTransport ttransport) throws RemoteException;

    protected ListenerTransportManager(boolean allowServerSideTransportRemoval) {
        if (allowServerSideTransportRemoval) {
            this.mRegistrations = new WeakHashMap();
        } else {
            this.mRegistrations = new ArrayMap();
        }
    }

    public final void addListener(Object key, TTransport transport) {
        TTransport oldTransport;
        try {
            synchronized (this.mRegistrations) {
                WeakReference<TTransport> oldTransportRef = this.mRegistrations.get(key);
                if (oldTransportRef != null) {
                    oldTransport = oldTransportRef.get();
                } else {
                    oldTransport = null;
                }
                if (oldTransport == null) {
                    registerTransport(transport);
                } else {
                    registerTransport(transport, oldTransport);
                    oldTransport.unregister();
                }
                this.mRegistrations.put(key, new WeakReference<>(transport));
            }
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    public final void removeListener(Object key) {
        TTransport transport;
        try {
            synchronized (this.mRegistrations) {
                WeakReference<TTransport> transportRef = this.mRegistrations.remove(key);
                if (transportRef != null && (transport = transportRef.get()) != null) {
                    transport.unregister();
                    unregisterTransport(transport);
                }
            }
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    protected void registerTransport(TTransport transport, TTransport oldTransport) throws RemoteException {
        registerTransport(transport);
        try {
            unregisterTransport(oldTransport);
        } catch (RemoteException e2) {
            try {
                unregisterTransport(transport);
            } catch (RemoteException suppressed) {
                e2.addSuppressed(suppressed);
            }
            throw e2;
        }
    }
}
