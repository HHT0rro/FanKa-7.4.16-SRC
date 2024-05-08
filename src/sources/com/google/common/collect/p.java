package com.google.common.collect;

import com.google.common.primitives.Booleans;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.util.Comparator;

/* compiled from: ComparisonChain.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final p f26607a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final p f26608b = new b(-1);

    /* renamed from: c, reason: collision with root package name */
    public static final p f26609c = new b(1);

    /* compiled from: ComparisonChain.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends p {
        public a() {
            super(null);
        }

        @Override // com.google.common.collect.p
        public p d(int i10, int i11) {
            return l(Ints.d(i10, i11));
        }

        @Override // com.google.common.collect.p
        public p e(long j10, long j11) {
            return l(Longs.c(j10, j11));
        }

        @Override // com.google.common.collect.p
        public p f(Comparable<?> comparable, Comparable<?> comparable2) {
            return l(comparable.compareTo(comparable2));
        }

        @Override // com.google.common.collect.p
        public <T> p g(T t2, T t10, Comparator<T> comparator) {
            return l(comparator.compare(t2, t10));
        }

        @Override // com.google.common.collect.p
        public p h(boolean z10, boolean z11) {
            return l(Booleans.c(z10, z11));
        }

        @Override // com.google.common.collect.p
        public p i(boolean z10, boolean z11) {
            return l(Booleans.c(z11, z10));
        }

        @Override // com.google.common.collect.p
        public int j() {
            return 0;
        }

        public p l(int i10) {
            return i10 < 0 ? p.f26608b : i10 > 0 ? p.f26609c : p.f26607a;
        }
    }

    /* compiled from: ComparisonChain.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class b extends p {

        /* renamed from: d, reason: collision with root package name */
        public final int f26610d;

        public b(int i10) {
            super(null);
            this.f26610d = i10;
        }

        @Override // com.google.common.collect.p
        public p d(int i10, int i11) {
            return this;
        }

        @Override // com.google.common.collect.p
        public p e(long j10, long j11) {
            return this;
        }

        @Override // com.google.common.collect.p
        public p f(Comparable<?> comparable, Comparable<?> comparable2) {
            return this;
        }

        @Override // com.google.common.collect.p
        public <T> p g(T t2, T t10, Comparator<T> comparator) {
            return this;
        }

        @Override // com.google.common.collect.p
        public p h(boolean z10, boolean z11) {
            return this;
        }

        @Override // com.google.common.collect.p
        public p i(boolean z10, boolean z11) {
            return this;
        }

        @Override // com.google.common.collect.p
        public int j() {
            return this.f26610d;
        }
    }

    public /* synthetic */ p(a aVar) {
        this();
    }

    public static p k() {
        return f26607a;
    }

    public abstract p d(int i10, int i11);

    public abstract p e(long j10, long j11);

    public abstract p f(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract <T> p g(T t2, T t10, Comparator<T> comparator);

    public abstract p h(boolean z10, boolean z11);

    public abstract p i(boolean z10, boolean z11);

    public abstract int j();

    public p() {
    }
}
