package com.cupidapp.live.startup.splashad;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.cupidapp.live.base.utils.j;
import com.huawei.hms.ads.ExSplashService;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExSplashServiceManager.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final C0173a f18536e = new C0173a(null);

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public Context f18537a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public ServiceConnection f18538b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public ExSplashService f18539c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f18540d;

    /* compiled from: ExSplashServiceManager.kt */
    @d
    /* renamed from: com.cupidapp.live.startup.splashad.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0173a {
        public C0173a() {
        }

        public /* synthetic */ C0173a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ExSplashServiceManager.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class b implements ServiceConnection {

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final Context f18541b;

        public b(@Nullable Context context) {
            this.f18541b = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(@NotNull ComponentName name, @NotNull IBinder service) {
            s.i(name, "name");
            s.i(service, "service");
            j.a aVar = j.f12332a;
            aVar.f("ExSplashConnection", "onServiceConnected");
            a.this.f18539c = ExSplashService.Stub.asInterface(service);
            if (a.this.f18539c != null) {
                try {
                    try {
                        ExSplashService exSplashService = a.this.f18539c;
                        s.f(exSplashService);
                        exSplashService.enableUserInfo(a.this.f18540d);
                        aVar.f("ExSplashConnection", "enableUserInfo done");
                    } catch (RemoteException unused) {
                        j.f12332a.f("ExSplashConnection", "enableUserInfo error");
                    }
                } finally {
                    Context context = this.f18541b;
                    s.f(context);
                    context.unbindService(this);
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(@NotNull ComponentName name) {
            s.i(name, "name");
            j.f12332a.f("ExSplashConnection", "onServiceDisconnected");
        }
    }

    public a(@Nullable Context context) {
        this.f18537a = context;
    }

    public final boolean d() {
        j.a aVar = j.f12332a;
        aVar.f("ExSplashServiceManager", "bindService");
        this.f18538b = new b(this.f18537a);
        Intent intent = new Intent("com.huawei.hms.ads.EXSPLASH_SERVICE");
        intent.setPackage("com.huawei.hwid");
        Context context = this.f18537a;
        s.f(context);
        ServiceConnection serviceConnection = this.f18538b;
        s.f(serviceConnection);
        boolean bindService = context.bindService(intent, serviceConnection, 1);
        aVar.f("ExSplashServiceManager", "bindService result: " + bindService);
        return bindService;
    }

    public final void e(boolean z10) {
        this.f18540d = z10;
        d();
    }
}
