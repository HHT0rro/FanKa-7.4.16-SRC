package com.vivo.push.util;

import android.content.Context;
import java.util.HashMap;

/* compiled from: SystemCache.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class af implements e {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, Integer> f46396a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap<String, Long> f46397b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static final HashMap<String, String> f46398c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private static af f46399d;

    /* renamed from: e, reason: collision with root package name */
    private Context f46400e;

    /* renamed from: f, reason: collision with root package name */
    private e f46401f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f46402g;

    private af(Context context) {
        this.f46402g = false;
        this.f46400e = context;
        this.f46402g = a(context);
        u.d("SystemCache", "init status is " + this.f46402g + ";  curCache is " + ((Object) this.f46401f));
    }

    public static synchronized af b(Context context) {
        af afVar;
        synchronized (af.class) {
            if (f46399d == null) {
                f46399d = new af(context.getApplicationContext());
            }
            afVar = f46399d;
        }
        return afVar;
    }

    public final void a() {
        ae aeVar = new ae();
        if (aeVar.a(this.f46400e)) {
            aeVar.a();
            u.d("SystemCache", "sp cache is cleared");
        }
    }

    @Override // com.vivo.push.util.e
    public final void b(String str, String str2) {
        e eVar;
        f46398c.put(str, str2);
        if (!this.f46402g || (eVar = this.f46401f) == null) {
            return;
        }
        eVar.b(str, str2);
    }

    @Override // com.vivo.push.util.e
    public final boolean a(Context context) {
        ac acVar = new ac();
        this.f46401f = acVar;
        boolean a10 = acVar.a(context);
        if (!a10) {
            ae aeVar = new ae();
            this.f46401f = aeVar;
            a10 = aeVar.a(context);
        }
        if (!a10) {
            this.f46401f = null;
        }
        return a10;
    }

    @Override // com.vivo.push.util.e
    public final String a(String str, String str2) {
        e eVar;
        String str3 = f46398c.get(str);
        return (str3 != null || (eVar = this.f46401f) == null) ? str3 : eVar.a(str, str2);
    }
}
