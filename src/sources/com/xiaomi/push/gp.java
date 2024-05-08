package com.xiaomi.push;

import android.os.Bundle;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class gp extends k5 {

    /* renamed from: o, reason: collision with root package name */
    public b f47333o;

    /* renamed from: p, reason: collision with root package name */
    public String f47334p;

    /* renamed from: q, reason: collision with root package name */
    public int f47335q;

    /* renamed from: r, reason: collision with root package name */
    public a f47336r;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum b {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        error,
        probe
    }

    public gp(Bundle bundle) {
        super(bundle);
        this.f47333o = b.available;
        this.f47334p = null;
        this.f47335q = Integer.MIN_VALUE;
        this.f47336r = null;
        if (bundle.containsKey("ext_pres_type")) {
            this.f47333o = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.f47334p = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.f47335q = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f47336r = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public gp(b bVar) {
        this.f47333o = b.available;
        this.f47334p = null;
        this.f47335q = Integer.MIN_VALUE;
        this.f47336r = null;
        A(bVar);
    }

    public void A(b bVar) {
        Objects.requireNonNull(bVar, "Type cannot be null");
        this.f47333o = bVar;
    }

    public void B(String str) {
        this.f47334p = str;
    }

    @Override // com.xiaomi.push.k5
    public Bundle a() {
        Bundle a10 = super.a();
        b bVar = this.f47333o;
        if (bVar != null) {
            a10.putString("ext_pres_type", bVar.toString());
        }
        String str = this.f47334p;
        if (str != null) {
            a10.putString("ext_pres_status", str);
        }
        int i10 = this.f47335q;
        if (i10 != Integer.MIN_VALUE) {
            a10.putInt("ext_pres_prio", i10);
        }
        a aVar = this.f47336r;
        if (aVar != null && aVar != a.available) {
            a10.putString("ext_pres_mode", aVar.toString());
        }
        return a10;
    }

    @Override // com.xiaomi.push.k5
    public String f() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<presence");
        if (w() != null) {
            sb2.append(" xmlns=\"");
            sb2.append(w());
            sb2.append("\"");
        }
        if (l() != null) {
            sb2.append(" id=\"");
            sb2.append(l());
            sb2.append("\"");
        }
        if (o() != null) {
            sb2.append(" to=\"");
            sb2.append(u5.b(o()));
            sb2.append("\"");
        }
        if (q() != null) {
            sb2.append(" from=\"");
            sb2.append(u5.b(q()));
            sb2.append("\"");
        }
        if (m() != null) {
            sb2.append(" chid=\"");
            sb2.append(u5.b(m()));
            sb2.append("\"");
        }
        if (this.f47333o != null) {
            sb2.append(" type=\"");
            sb2.append((Object) this.f47333o);
            sb2.append("\"");
        }
        sb2.append(">");
        if (this.f47334p != null) {
            sb2.append("<status>");
            sb2.append(u5.b(this.f47334p));
            sb2.append("</status>");
        }
        if (this.f47335q != Integer.MIN_VALUE) {
            sb2.append("<priority>");
            sb2.append(this.f47335q);
            sb2.append("</priority>");
        }
        a aVar = this.f47336r;
        if (aVar != null && aVar != a.available) {
            sb2.append("<show>");
            sb2.append((Object) this.f47336r);
            sb2.append("</show>");
        }
        sb2.append(u());
        n5 d10 = d();
        if (d10 != null) {
            sb2.append(d10.b());
        }
        sb2.append("</presence>");
        return sb2.toString();
    }

    public void y(int i10) {
        if (i10 >= -128 && i10 <= 128) {
            this.f47335q = i10;
            return;
        }
        throw new IllegalArgumentException("Priority value " + i10 + " is not valid. Valid range is -128 through 128.");
    }

    public void z(a aVar) {
        this.f47336r = aVar;
    }
}
