package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class n5 {

    /* renamed from: a, reason: collision with root package name */
    public int f47997a;

    /* renamed from: b, reason: collision with root package name */
    public String f47998b;

    /* renamed from: c, reason: collision with root package name */
    public String f47999c;

    /* renamed from: d, reason: collision with root package name */
    public String f48000d;

    /* renamed from: e, reason: collision with root package name */
    public String f48001e;

    /* renamed from: f, reason: collision with root package name */
    public List<h5> f48002f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a {

        /* renamed from: b, reason: collision with root package name */
        public static final a f48003b = new a("internal-server-error");

        /* renamed from: c, reason: collision with root package name */
        public static final a f48004c = new a("forbidden");

        /* renamed from: d, reason: collision with root package name */
        public static final a f48005d = new a("bad-request");

        /* renamed from: e, reason: collision with root package name */
        public static final a f48006e = new a("conflict");

        /* renamed from: f, reason: collision with root package name */
        public static final a f48007f = new a("feature-not-implemented");

        /* renamed from: g, reason: collision with root package name */
        public static final a f48008g = new a("gone");

        /* renamed from: h, reason: collision with root package name */
        public static final a f48009h = new a("item-not-found");

        /* renamed from: i, reason: collision with root package name */
        public static final a f48010i = new a("jid-malformed");

        /* renamed from: j, reason: collision with root package name */
        public static final a f48011j = new a("not-acceptable");

        /* renamed from: k, reason: collision with root package name */
        public static final a f48012k = new a("not-allowed");

        /* renamed from: l, reason: collision with root package name */
        public static final a f48013l = new a("not-authorized");

        /* renamed from: m, reason: collision with root package name */
        public static final a f48014m = new a("payment-required");

        /* renamed from: n, reason: collision with root package name */
        public static final a f48015n = new a("recipient-unavailable");

        /* renamed from: o, reason: collision with root package name */
        public static final a f48016o = new a("redirect");

        /* renamed from: p, reason: collision with root package name */
        public static final a f48017p = new a("registration-required");

        /* renamed from: q, reason: collision with root package name */
        public static final a f48018q = new a("remote-server-error");

        /* renamed from: r, reason: collision with root package name */
        public static final a f48019r = new a("remote-server-not-found");

        /* renamed from: s, reason: collision with root package name */
        public static final a f48020s = new a("remote-server-timeout");

        /* renamed from: t, reason: collision with root package name */
        public static final a f48021t = new a("resource-constraint");

        /* renamed from: u, reason: collision with root package name */
        public static final a f48022u = new a("service-unavailable");

        /* renamed from: v, reason: collision with root package name */
        public static final a f48023v = new a("subscription-required");

        /* renamed from: w, reason: collision with root package name */
        public static final a f48024w = new a("undefined-condition");

        /* renamed from: x, reason: collision with root package name */
        public static final a f48025x = new a("unexpected-request");

        /* renamed from: y, reason: collision with root package name */
        public static final a f48026y = new a("request-timeout");

        /* renamed from: a, reason: collision with root package name */
        public String f48027a;

        public a(String str) {
            this.f48027a = str;
        }

        public String toString() {
            return this.f48027a;
        }
    }

    public n5(int i10, String str, String str2, String str3, String str4, List<h5> list) {
        this.f47997a = i10;
        this.f47998b = str;
        this.f48000d = str2;
        this.f47999c = str3;
        this.f48001e = str4;
        this.f48002f = list;
    }

    public n5(Bundle bundle) {
        this.f48002f = null;
        this.f47997a = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.f47998b = bundle.getString("ext_err_type");
        }
        this.f47999c = bundle.getString("ext_err_cond");
        this.f48000d = bundle.getString("ext_err_reason");
        this.f48001e = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f48002f = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                h5 c4 = h5.c((Bundle) parcelable);
                if (c4 != null) {
                    this.f48002f.add(c4);
                }
            }
        }
    }

    public n5(a aVar) {
        this.f48002f = null;
        d(aVar);
        this.f48001e = null;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        String str = this.f47998b;
        if (str != null) {
            bundle.putString("ext_err_type", str);
        }
        bundle.putInt("ext_err_code", this.f47997a);
        String str2 = this.f48000d;
        if (str2 != null) {
            bundle.putString("ext_err_reason", str2);
        }
        String str3 = this.f47999c;
        if (str3 != null) {
            bundle.putString("ext_err_cond", str3);
        }
        String str4 = this.f48001e;
        if (str4 != null) {
            bundle.putString("ext_err_msg", str4);
        }
        List<h5> list = this.f48002f;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i10 = 0;
            Iterator<h5> iterator2 = this.f48002f.iterator2();
            while (iterator2.hasNext()) {
                Bundle a10 = iterator2.next().a();
                if (a10 != null) {
                    bundleArr[i10] = a10;
                    i10++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public String b() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<error code=\"");
        sb2.append(this.f47997a);
        sb2.append("\"");
        if (this.f47998b != null) {
            sb2.append(" type=\"");
            sb2.append(this.f47998b);
            sb2.append("\"");
        }
        if (this.f48000d != null) {
            sb2.append(" reason=\"");
            sb2.append(this.f48000d);
            sb2.append("\"");
        }
        sb2.append(">");
        if (this.f47999c != null) {
            sb2.append("<");
            sb2.append(this.f47999c);
            sb2.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.f48001e != null) {
            sb2.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            sb2.append(this.f48001e);
            sb2.append("</text>");
        }
        Iterator<h5> iterator2 = c().iterator2();
        while (iterator2.hasNext()) {
            sb2.append(iterator2.next().d());
        }
        sb2.append("</error>");
        return sb2.toString();
    }

    public synchronized List<h5> c() {
        List<h5> list = this.f48002f;
        if (list == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(list);
    }

    public final void d(a aVar) {
        this.f47999c = aVar.f48027a;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        String str = this.f47999c;
        if (str != null) {
            sb2.append(str);
        }
        sb2.append("(");
        sb2.append(this.f47997a);
        sb2.append(")");
        if (this.f48001e != null) {
            sb2.append(" ");
            sb2.append(this.f48001e);
        }
        return sb2.toString();
    }
}
