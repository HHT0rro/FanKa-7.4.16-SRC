package com.xiaomi.push;

import android.os.Bundle;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class i5 extends k5 {

    /* renamed from: o, reason: collision with root package name */
    public a f47523o;

    /* renamed from: p, reason: collision with root package name */
    public final Map<String, String> f47524p;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a {

        /* renamed from: b, reason: collision with root package name */
        public static final a f47525b = new a(MonitorConstants.CONNECT_TYPE_GET);

        /* renamed from: c, reason: collision with root package name */
        public static final a f47526c = new a("set");

        /* renamed from: d, reason: collision with root package name */
        public static final a f47527d = new a("result");

        /* renamed from: e, reason: collision with root package name */
        public static final a f47528e = new a("error");

        /* renamed from: f, reason: collision with root package name */
        public static final a f47529f = new a("command");

        /* renamed from: a, reason: collision with root package name */
        public String f47530a;

        public a(String str) {
            this.f47530a = str;
        }

        public static a a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            a aVar = f47525b;
            if (aVar.toString().equals(lowerCase)) {
                return aVar;
            }
            a aVar2 = f47526c;
            if (aVar2.toString().equals(lowerCase)) {
                return aVar2;
            }
            a aVar3 = f47528e;
            if (aVar3.toString().equals(lowerCase)) {
                return aVar3;
            }
            a aVar4 = f47527d;
            if (aVar4.toString().equals(lowerCase)) {
                return aVar4;
            }
            a aVar5 = f47529f;
            if (aVar5.toString().equals(lowerCase)) {
                return aVar5;
            }
            return null;
        }

        public String toString() {
            return this.f47530a;
        }
    }

    public i5() {
        this.f47523o = a.f47525b;
        this.f47524p = new HashMap();
    }

    public i5(Bundle bundle) {
        super(bundle);
        this.f47523o = a.f47525b;
        this.f47524p = new HashMap();
        if (bundle.containsKey("ext_iq_type")) {
            this.f47523o = a.a(bundle.getString("ext_iq_type"));
        }
    }

    public synchronized void A(Map<String, String> map) {
        this.f47524p.putAll(map);
    }

    public String B() {
        return null;
    }

    @Override // com.xiaomi.push.k5
    public Bundle a() {
        Bundle a10 = super.a();
        a aVar = this.f47523o;
        if (aVar != null) {
            a10.putString("ext_iq_type", aVar.toString());
        }
        return a10;
    }

    @Override // com.xiaomi.push.k5
    public String f() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<iq ");
        if (l() != null) {
            sb2.append("id=\"" + l() + "\" ");
        }
        if (o() != null) {
            sb2.append("to=\"");
            sb2.append(u5.b(o()));
            sb2.append("\" ");
        }
        if (q() != null) {
            sb2.append("from=\"");
            sb2.append(u5.b(q()));
            sb2.append("\" ");
        }
        if (m() != null) {
            sb2.append("chid=\"");
            sb2.append(u5.b(m()));
            sb2.append("\" ");
        }
        for (Map.Entry<String, String> entry : this.f47524p.entrySet()) {
            sb2.append(u5.b(entry.getKey()));
            sb2.append("=\"");
            sb2.append(u5.b(entry.getValue()));
            sb2.append("\" ");
        }
        if (this.f47523o == null) {
            str = "type=\"get\">";
        } else {
            sb2.append("type=\"");
            sb2.append((Object) y());
            str = "\">";
        }
        sb2.append(str);
        String B = B();
        if (B != null) {
            sb2.append(B);
        }
        sb2.append(u());
        n5 d10 = d();
        if (d10 != null) {
            sb2.append(d10.b());
        }
        sb2.append("</iq>");
        return sb2.toString();
    }

    public a y() {
        return this.f47523o;
    }

    public void z(a aVar) {
        if (aVar == null) {
            aVar = a.f47525b;
        }
        this.f47523o = aVar;
    }
}
