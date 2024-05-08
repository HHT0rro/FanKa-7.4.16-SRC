package com.google.common.base;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* compiled from: Joiner.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f25965a;

    /* compiled from: Joiner.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends i {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f25966b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i iVar, String str) {
            super(iVar, null);
            this.f25966b = str;
        }

        @Override // com.google.common.base.i
        public CharSequence i(Object obj) {
            return obj == null ? this.f25966b : i.this.i(obj);
        }

        @Override // com.google.common.base.i
        public i j(String str) {
            throw new UnsupportedOperationException("already specified useForNull");
        }
    }

    public /* synthetic */ i(i iVar, a aVar) {
        this(iVar);
    }

    public static i g(char c4) {
        return new i(String.valueOf(c4));
    }

    public static i h(String str) {
        return new i(str);
    }

    public <A extends Appendable> A a(A a10, Iterator<? extends Object> it) throws IOException {
        o.r(a10);
        if (it.hasNext()) {
            a10.append(i(it.next()));
            while (it.hasNext()) {
                a10.append(this.f25965a);
                a10.append(i(it.next()));
            }
        }
        return a10;
    }

    public final StringBuilder b(StringBuilder sb2, Iterable<? extends Object> iterable) {
        return c(sb2, iterable.iterator2());
    }

    public final StringBuilder c(StringBuilder sb2, Iterator<? extends Object> it) {
        try {
            a(sb2, it);
            return sb2;
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public final String d(Iterable<? extends Object> iterable) {
        return e(iterable.iterator2());
    }

    public final String e(Iterator<? extends Object> it) {
        return c(new StringBuilder(), it).toString();
    }

    public final String f(Object[] objArr) {
        return d(Arrays.asList(objArr));
    }

    public CharSequence i(Object obj) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public i j(String str) {
        o.r(str);
        return new a(this, str);
    }

    public i(String str) {
        this.f25965a = (String) o.r(str);
    }

    public i(i iVar) {
        this.f25965a = iVar.f25965a;
    }
}
