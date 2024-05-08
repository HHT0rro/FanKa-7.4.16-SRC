package kc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class w implements ServiceConnection {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f50867b;

    public w(u uVar) {
        this.f50867b = uVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        List<Message> list;
        List list2;
        Messenger messenger;
        synchronized (this.f50867b) {
            this.f50867b.f50865f = new Messenger(iBinder);
            this.f50867b.f50864e = false;
            list = this.f50867b.f50863d;
            for (Message message : list) {
                try {
                    messenger = this.f50867b.f50865f;
                    messenger.send(message);
                } catch (RemoteException e2) {
                    fc.c.k(e2);
                }
            }
            list2 = this.f50867b.f50863d;
            list2.clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f50867b.f50865f = null;
        this.f50867b.f50864e = false;
    }
}
