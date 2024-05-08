package a7;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import androidx.annotation.RecentlyNonNull;
import b7.c;
import com.google.android.gms.common.internal.c0;
import com.google.android.gms.common.internal.h;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f714b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static volatile a f715c;

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<ServiceConnection, ServiceConnection> f716a = new ConcurrentHashMap<>();

    @RecentlyNonNull
    public static a a() {
        if (f715c == null) {
            synchronized (f714b) {
                if (f715c == null) {
                    f715c = new a();
                }
            }
        }
        return (a) h.h(f715c);
    }

    public static boolean e(ServiceConnection serviceConnection) {
        return !(serviceConnection instanceof c0);
    }

    public void b(@RecentlyNonNull Context context, @RecentlyNonNull ServiceConnection serviceConnection) {
        if (e(serviceConnection) && this.f716a.containsKey(serviceConnection)) {
            try {
                try {
                    context.unbindService(this.f716a.get(serviceConnection));
                } catch (IllegalArgumentException | IllegalStateException unused) {
                }
            } finally {
                this.f716a.remove(serviceConnection);
            }
        } else {
            try {
                context.unbindService(serviceConnection);
            } catch (IllegalArgumentException | IllegalStateException unused2) {
            }
        }
    }

    @RecentlyNonNull
    public final boolean c(@RecentlyNonNull Context context, @RecentlyNonNull String str, @RecentlyNonNull Intent intent, @RecentlyNonNull ServiceConnection serviceConnection, @RecentlyNonNull int i10) {
        return d(context, str, intent, serviceConnection, i10, true);
    }

    public final boolean d(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i10, boolean z10) {
        ComponentName component = intent.getComponent();
        if (component == null ? false : c.a(context, component.getPackageName())) {
            return false;
        }
        if (e(serviceConnection)) {
            ServiceConnection putIfAbsent = this.f716a.putIfAbsent(serviceConnection, serviceConnection);
            if (putIfAbsent != null && serviceConnection != putIfAbsent) {
                String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction());
            }
            try {
                boolean bindService = context.bindService(intent, serviceConnection, i10);
                return !bindService ? bindService : bindService;
            } finally {
                this.f716a.remove(serviceConnection, serviceConnection);
            }
        }
        return context.bindService(intent, serviceConnection, i10);
    }
}
