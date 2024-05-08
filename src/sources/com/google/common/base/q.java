package com.google.common.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: Splitter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.common.base.b f25978a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f25979b;

    /* renamed from: c, reason: collision with root package name */
    public final d f25980c;

    /* renamed from: d, reason: collision with root package name */
    public final int f25981d;

    /* compiled from: Splitter.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.google.common.base.b f25982a;

        /* compiled from: Splitter.java */
        /* renamed from: com.google.common.base.q$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class C0225a extends c {
            public C0225a(q qVar, CharSequence charSequence) {
                super(qVar, charSequence);
            }

            @Override // com.google.common.base.q.c
            public int e(int i10) {
                return i10 + 1;
            }

            @Override // com.google.common.base.q.c
            public int f(int i10) {
                return a.this.f25982a.e(this.f25986d, i10);
            }
        }

        public a(com.google.common.base.b bVar) {
            this.f25982a = bVar;
        }

        @Override // com.google.common.base.q.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c a(q qVar, CharSequence charSequence) {
            return new C0225a(qVar, charSequence);
        }
    }

    /* compiled from: Splitter.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b implements Iterable<String> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CharSequence f25984b;

        public b(CharSequence charSequence) {
            this.f25984b = charSequence;
        }

        @Override // java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<String> iterator2() {
            return q.this.i(this.f25984b);
        }

        public String toString() {
            i h10 = i.h(", ");
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            StringBuilder b4 = h10.b(sb2, this);
            b4.append(']');
            return b4.toString();
        }
    }

    /* compiled from: Splitter.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class c extends AbstractIterator<String> {

        /* renamed from: d, reason: collision with root package name */
        public final CharSequence f25986d;

        /* renamed from: e, reason: collision with root package name */
        public final com.google.common.base.b f25987e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f25988f;

        /* renamed from: g, reason: collision with root package name */
        public int f25989g = 0;

        /* renamed from: h, reason: collision with root package name */
        public int f25990h;

        public c(q qVar, CharSequence charSequence) {
            this.f25987e = qVar.f25978a;
            this.f25988f = qVar.f25979b;
            this.f25990h = qVar.f25981d;
            this.f25986d = charSequence;
        }

        @Override // com.google.common.base.AbstractIterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a() {
            int f10;
            int i10 = this.f25989g;
            while (true) {
                int i11 = this.f25989g;
                if (i11 != -1) {
                    f10 = f(i11);
                    if (f10 == -1) {
                        f10 = this.f25986d.length();
                        this.f25989g = -1;
                    } else {
                        this.f25989g = e(f10);
                    }
                    int i12 = this.f25989g;
                    if (i12 == i10) {
                        int i13 = i12 + 1;
                        this.f25989g = i13;
                        if (i13 > this.f25986d.length()) {
                            this.f25989g = -1;
                        }
                    } else {
                        while (i10 < f10 && this.f25987e.g(this.f25986d.charAt(i10))) {
                            i10++;
                        }
                        while (f10 > i10 && this.f25987e.g(this.f25986d.charAt(f10 - 1))) {
                            f10--;
                        }
                        if (!this.f25988f || i10 != f10) {
                            break;
                        }
                        i10 = this.f25989g;
                    }
                } else {
                    return b();
                }
            }
            int i14 = this.f25990h;
            if (i14 == 1) {
                f10 = this.f25986d.length();
                this.f25989g = -1;
                while (f10 > i10 && this.f25987e.g(this.f25986d.charAt(f10 - 1))) {
                    f10--;
                }
            } else {
                this.f25990h = i14 - 1;
            }
            return this.f25986d.subSequence(i10, f10).toString();
        }

        public abstract int e(int i10);

        public abstract int f(int i10);
    }

    /* compiled from: Splitter.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface d {
        Iterator<String> a(q qVar, CharSequence charSequence);
    }

    public q(d dVar) {
        this(dVar, false, com.google.common.base.b.i(), Integer.MAX_VALUE);
    }

    public static q e(char c4) {
        return f(com.google.common.base.b.f(c4));
    }

    public static q f(com.google.common.base.b bVar) {
        o.r(bVar);
        return new q(new a(bVar));
    }

    public Iterable<String> g(CharSequence charSequence) {
        o.r(charSequence);
        return new b(charSequence);
    }

    public List<String> h(CharSequence charSequence) {
        o.r(charSequence);
        Iterator<String> i10 = i(charSequence);
        ArrayList arrayList = new ArrayList();
        while (i10.hasNext()) {
            arrayList.add(i10.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final Iterator<String> i(CharSequence charSequence) {
        return this.f25980c.a(this, charSequence);
    }

    public q j() {
        return k(com.google.common.base.b.k());
    }

    public q k(com.google.common.base.b bVar) {
        o.r(bVar);
        return new q(this.f25980c, this.f25979b, bVar, this.f25981d);
    }

    public q(d dVar, boolean z10, com.google.common.base.b bVar, int i10) {
        this.f25980c = dVar;
        this.f25979b = z10;
        this.f25978a = bVar;
        this.f25981d = i10;
    }
}
