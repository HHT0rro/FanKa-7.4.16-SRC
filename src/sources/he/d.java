package he;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.EventBusException;

/* compiled from: HandlerPoster.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class d extends Handler implements i {

    /* renamed from: b, reason: collision with root package name */
    public final h f49621b;

    /* renamed from: c, reason: collision with root package name */
    public final int f49622c;

    /* renamed from: d, reason: collision with root package name */
    public final EventBus f49623d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f49624e;

    public d(EventBus eventBus, Looper looper, int i10) {
        super(looper);
        this.f49623d = eventBus;
        this.f49622c = i10;
        this.f49621b = new h();
    }

    @Override // he.i
    public void a(m mVar, Object obj) {
        g a10 = g.a(mVar, obj);
        synchronized (this) {
            this.f49621b.a(a10);
            if (!this.f49624e) {
                this.f49624e = true;
                if (!sendMessage(obtainMessage())) {
                    throw new EventBusException("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                g b4 = this.f49621b.b();
                if (b4 == null) {
                    synchronized (this) {
                        b4 = this.f49621b.b();
                        if (b4 == null) {
                            return;
                        }
                    }
                }
                this.f49623d.g(b4);
            } while (SystemClock.uptimeMillis() - uptimeMillis < this.f49622c);
            if (sendMessage(obtainMessage())) {
                this.f49624e = true;
                return;
            }
            throw new EventBusException("Could not send handler message");
        } finally {
            this.f49624e = false;
        }
    }
}
