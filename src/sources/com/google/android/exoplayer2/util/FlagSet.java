package com.google.android.exoplayer2.util;

import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FlagSet {

    /* renamed from: a, reason: collision with root package name */
    public final SparseBooleanArray f22911a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final SparseBooleanArray f22912a = new SparseBooleanArray();

        /* renamed from: b, reason: collision with root package name */
        public boolean f22913b;

        public b a(int i10) {
            com.google.android.exoplayer2.util.a.g(!this.f22913b);
            this.f22912a.append(i10, true);
            return this;
        }

        public b b(FlagSet flagSet) {
            for (int i10 = 0; i10 < flagSet.d(); i10++) {
                a(flagSet.c(i10));
            }
            return this;
        }

        public b c(int... iArr) {
            for (int i10 : iArr) {
                a(i10);
            }
            return this;
        }

        public b d(int i10, boolean z10) {
            return z10 ? a(i10) : this;
        }

        public FlagSet e() {
            com.google.android.exoplayer2.util.a.g(!this.f22913b);
            this.f22913b = true;
            return new FlagSet(this.f22912a);
        }
    }

    public boolean a(int i10) {
        return this.f22911a.get(i10);
    }

    public boolean b(int... iArr) {
        for (int i10 : iArr) {
            if (a(i10)) {
                return true;
            }
        }
        return false;
    }

    public int c(int i10) {
        com.google.android.exoplayer2.util.a.c(i10, 0, d());
        return this.f22911a.keyAt(i10);
    }

    public int d() {
        return this.f22911a.size();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlagSet)) {
            return false;
        }
        FlagSet flagSet = (FlagSet) obj;
        if (j0.f22990a < 24) {
            if (d() != flagSet.d()) {
                return false;
            }
            for (int i10 = 0; i10 < d(); i10++) {
                if (c(i10) != flagSet.c(i10)) {
                    return false;
                }
            }
            return true;
        }
        return this.f22911a.equals(flagSet.f22911a);
    }

    public int hashCode() {
        if (j0.f22990a < 24) {
            int d10 = d();
            for (int i10 = 0; i10 < d(); i10++) {
                d10 = (d10 * 31) + c(i10);
            }
            return d10;
        }
        return this.f22911a.hashCode();
    }

    public FlagSet(SparseBooleanArray sparseBooleanArray) {
        this.f22911a = sparseBooleanArray;
    }
}
