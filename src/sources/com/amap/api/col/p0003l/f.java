package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import com.autonavi.aps.amapapi.utils.b;
import com.autonavi.aps.amapapi.utils.j;

/* compiled from: ApsServiceCore.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public e f5694a;

    /* renamed from: b, reason: collision with root package name */
    public Context f5695b;

    /* renamed from: c, reason: collision with root package name */
    public Messenger f5696c = null;

    public f(Context context) {
        this.f5694a = null;
        this.f5695b = null;
        this.f5695b = context.getApplicationContext();
        this.f5694a = new e(this.f5695b);
    }

    public final IBinder a(Intent intent) {
        this.f5694a.b(intent);
        this.f5694a.a(intent);
        Messenger messenger = new Messenger(this.f5694a.b());
        this.f5696c = messenger;
        return messenger.getBinder();
    }

    public final int b() {
        e eVar = this.f5694a;
        return (eVar == null || eVar.f5417n.isSelfStartServiceEnable()) ? 0 : 2;
    }

    public final void c() {
        try {
            e eVar = this.f5694a;
            if (eVar != null) {
                eVar.b().sendEmptyMessage(11);
            }
        } catch (Throwable th) {
            b.a(th, "ApsServiceCore", "onDestroy");
        }
    }

    public final void a() {
        try {
            e.f();
            this.f5694a.f5413j = j.b();
            this.f5694a.f5414k = j.a();
            this.f5694a.a();
        } catch (Throwable th) {
            b.a(th, "ApsServiceCore", "onCreate");
        }
    }
}
