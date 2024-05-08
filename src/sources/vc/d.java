package vc;

import java.util.HashMap;
import java.util.Map;

/* compiled from: RequestOptions.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public String f54078a;

    /* renamed from: b, reason: collision with root package name */
    public int f54079b;

    /* renamed from: c, reason: collision with root package name */
    public int f54080c;

    /* renamed from: d, reason: collision with root package name */
    public int f54081d;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, String> f54082e;

    /* compiled from: RequestOptions.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f54083a;

        /* renamed from: b, reason: collision with root package name */
        public int f54084b = 3;

        /* renamed from: c, reason: collision with root package name */
        public int f54085c;

        /* renamed from: d, reason: collision with root package name */
        public int f54086d;

        /* renamed from: e, reason: collision with root package name */
        public Map<String, String> f54087e;

        public a(String str) {
            this.f54083a = str;
        }

        public a b(int i10) {
            this.f54084b = i10;
            return this;
        }

        public a c(String str, String str2) {
            if (this.f54087e == null) {
                this.f54087e = new HashMap(16);
            }
            this.f54087e.put(str, str2);
            return this;
        }

        public d d() {
            return new d(this);
        }

        public a f(int i10) {
            this.f54086d = i10;
            return this;
        }

        public a h(int i10) {
            this.f54085c = i10;
            return this;
        }
    }

    public d(a aVar) {
        this.f54078a = aVar.f54083a;
        this.f54079b = aVar.f54084b;
        this.f54080c = aVar.f54085c;
        this.f54081d = aVar.f54086d;
        this.f54082e = aVar.f54087e;
    }

    public String a() {
        return this.f54078a;
    }

    public int b() {
        return this.f54079b;
    }
}
