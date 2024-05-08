package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class k0 implements ServiceConnection {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h0 f47027b;

    public k0(h0 h0Var) {
        this.f47027b = h0Var;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        List<Message> list;
        List list2;
        Messenger messenger;
        synchronized (this.f47027b) {
            this.f47027b.f47012d = new Messenger(iBinder);
            this.f47027b.f47015g = false;
            list = this.f47027b.f47014f;
            for (Message message : list) {
                try {
                    messenger = this.f47027b.f47012d;
                    messenger.send(message);
                } catch (RemoteException e2) {
                    fc.c.k(e2);
                }
            }
            list2 = this.f47027b.f47014f;
            list2.clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f47027b.f47012d = null;
        this.f47027b.f47015g = false;
    }
}
