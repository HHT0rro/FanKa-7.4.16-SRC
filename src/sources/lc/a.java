package lc;

import android.content.Context;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f51692b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ NetworkStatusReceiver f51693c;

    public a(NetworkStatusReceiver networkStatusReceiver, Context context) {
        this.f51693c = networkStatusReceiver;
        this.f51692b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f51693c.a(this.f51692b);
    }
}
