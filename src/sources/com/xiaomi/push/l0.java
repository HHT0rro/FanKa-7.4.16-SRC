package com.xiaomi.push;

import java.util.LinkedList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class l0 {

    /* renamed from: a, reason: collision with root package name */
    public LinkedList<a> f47931a = new LinkedList<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a {

        /* renamed from: d, reason: collision with root package name */
        public static final l0 f47932d = new l0();

        /* renamed from: a, reason: collision with root package name */
        public int f47933a;

        /* renamed from: b, reason: collision with root package name */
        public String f47934b;

        /* renamed from: c, reason: collision with root package name */
        public Object f47935c;

        public a(int i10, Object obj) {
            this.f47933a = i10;
            this.f47935c = obj;
        }
    }

    public static l0 b() {
        return a.f47932d;
    }

    public synchronized int a() {
        return this.f47931a.size();
    }

    public synchronized LinkedList<a> c() {
        LinkedList<a> linkedList;
        linkedList = this.f47931a;
        this.f47931a = new LinkedList<>();
        return linkedList;
    }

    public final void d() {
        if (this.f47931a.size() > 100) {
            this.f47931a.removeFirst();
        }
    }

    public synchronized void e(Object obj) {
        this.f47931a.add(new a(0, obj));
        d();
    }
}
