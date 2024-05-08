package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a0 implements ServiceConnection, c0 {

    /* renamed from: b, reason: collision with root package name */
    public final Map<ServiceConnection, ServiceConnection> f23632b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public int f23633c = 2;

    /* renamed from: d, reason: collision with root package name */
    public boolean f23634d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public IBinder f23635e;

    /* renamed from: f, reason: collision with root package name */
    public final d.a f23636f;

    /* renamed from: g, reason: collision with root package name */
    public ComponentName f23637g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ y f23638h;

    public a0(y yVar, d.a aVar) {
        this.f23638h = yVar;
        this.f23636f = aVar;
    }

    public final void a(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f23632b.put(serviceConnection, serviceConnection2);
    }

    public final void b(ServiceConnection serviceConnection, String str) {
        this.f23632b.remove(serviceConnection);
    }

    public final void c(String str) {
        a7.a aVar;
        Context context;
        Context context2;
        a7.a aVar2;
        Context context3;
        Handler handler;
        Handler handler2;
        long j10;
        this.f23633c = 3;
        aVar = this.f23638h.f23697g;
        context = this.f23638h.f23695e;
        d.a aVar3 = this.f23636f;
        context2 = this.f23638h.f23695e;
        boolean c4 = aVar.c(context, str, aVar3.a(context2), this, this.f23636f.e());
        this.f23634d = c4;
        if (c4) {
            handler = this.f23638h.f23696f;
            Message obtainMessage = handler.obtainMessage(1, this.f23636f);
            handler2 = this.f23638h.f23696f;
            j10 = this.f23638h.f23699i;
            handler2.sendMessageDelayed(obtainMessage, j10);
            return;
        }
        this.f23633c = 2;
        try {
            aVar2 = this.f23638h.f23697g;
            context3 = this.f23638h.f23695e;
            aVar2.b(context3, this);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final boolean d() {
        return this.f23634d;
    }

    public final boolean e(ServiceConnection serviceConnection) {
        return this.f23632b.containsKey(serviceConnection);
    }

    public final int f() {
        return this.f23633c;
    }

    public final void g(String str) {
        Handler handler;
        a7.a aVar;
        Context context;
        handler = this.f23638h.f23696f;
        handler.removeMessages(1, this.f23636f);
        aVar = this.f23638h.f23697g;
        context = this.f23638h.f23695e;
        aVar.b(context, this);
        this.f23634d = false;
        this.f23633c = 2;
    }

    public final boolean h() {
        return this.f23632b.isEmpty();
    }

    @Nullable
    public final IBinder i() {
        return this.f23635e;
    }

    public final ComponentName j() {
        return this.f23637g;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f23638h.f23694d;
        synchronized (hashMap) {
            handler = this.f23638h.f23696f;
            handler.removeMessages(1, this.f23636f);
            this.f23635e = iBinder;
            this.f23637g = componentName;
            Iterator<ServiceConnection> iterator2 = this.f23632b.values().iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().onServiceConnected(componentName, iBinder);
            }
            this.f23633c = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f23638h.f23694d;
        synchronized (hashMap) {
            handler = this.f23638h.f23696f;
            handler.removeMessages(1, this.f23636f);
            this.f23635e = null;
            this.f23637g = componentName;
            Iterator<ServiceConnection> iterator2 = this.f23632b.values().iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().onServiceDisconnected(componentName);
            }
            this.f23633c = 2;
        }
    }
}
