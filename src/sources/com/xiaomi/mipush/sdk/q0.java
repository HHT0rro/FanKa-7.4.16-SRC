package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hv;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class q0 implements a {

    /* renamed from: e, reason: collision with root package name */
    public static volatile q0 f47069e;

    /* renamed from: a, reason: collision with root package name */
    public Context f47070a;

    /* renamed from: b, reason: collision with root package name */
    public o f47071b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f47072c = false;

    /* renamed from: d, reason: collision with root package name */
    public Map<d, a> f47073d = new HashMap();

    public q0(Context context) {
        this.f47070a = context.getApplicationContext();
    }

    public static q0 e(Context context) {
        if (f47069e == null) {
            synchronized (q0.class) {
                if (f47069e == null) {
                    f47069e = new q0(context);
                }
            }
        }
        return f47069e;
    }

    @Override // com.xiaomi.mipush.sdk.a
    public void a() {
        fc.c.i("ASSEMBLE_PUSH : assemble push unregister");
        for (a aVar : this.f47073d.values()) {
            if (aVar != null) {
                aVar.a();
            }
        }
        this.f47073d.clear();
    }

    @Override // com.xiaomi.mipush.sdk.a
    public void b() {
        fc.c.i("ASSEMBLE_PUSH : assemble push register");
        if (this.f47073d.size() <= 0) {
            f();
        }
        if (this.f47073d.size() > 0) {
            for (a aVar : this.f47073d.values()) {
                if (aVar != null) {
                    aVar.b();
                }
            }
            t0.d(this.f47070a);
        }
    }

    public a d(d dVar) {
        return this.f47073d.get(dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f() {
        /*
            Method dump skipped, instructions count: 500
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.q0.f():void");
    }

    public void g(o oVar) {
        this.f47071b = oVar;
        this.f47072c = kc.j.d(this.f47070a).i(hv.AggregatePushSwitch.a(), true);
        if (this.f47071b.d() || this.f47071b.b() || this.f47071b.a()) {
            kc.j.d(this.f47070a).h(new r0(this, 101, "assemblePush"));
        }
    }

    public void h(d dVar) {
        this.f47073d.remove(dVar);
    }

    public void i(d dVar, a aVar) {
        if (aVar != null) {
            if (this.f47073d.containsKey(dVar)) {
                this.f47073d.remove(dVar);
            }
            this.f47073d.put(dVar, aVar);
        }
    }

    public boolean j(d dVar) {
        return this.f47073d.containsKey(dVar);
    }

    public boolean m(d dVar) {
        int i10 = s0.f47078a[dVar.ordinal()];
        boolean z10 = false;
        if (i10 == 1) {
            o oVar = this.f47071b;
            if (oVar != null) {
                return oVar.d();
            }
            return false;
        }
        if (i10 == 2) {
            o oVar2 = this.f47071b;
            if (oVar2 != null) {
                return oVar2.b();
            }
            return false;
        }
        if (i10 == 3) {
            o oVar3 = this.f47071b;
            if (oVar3 != null) {
                z10 = oVar3.a();
            }
        } else if (i10 != 4) {
            return false;
        }
        o oVar4 = this.f47071b;
        return oVar4 != null ? oVar4.c() : z10;
    }
}
