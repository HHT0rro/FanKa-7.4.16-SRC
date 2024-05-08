package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.j;
import com.google.common.collect.MapMakerInternalMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class MapMaker {

    /* renamed from: a, reason: collision with root package name */
    public boolean f26381a;

    /* renamed from: b, reason: collision with root package name */
    public int f26382b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f26383c = -1;

    /* renamed from: d, reason: collision with root package name */
    public MapMakerInternalMap.Strength f26384d;

    /* renamed from: e, reason: collision with root package name */
    public MapMakerInternalMap.Strength f26385e;

    /* renamed from: f, reason: collision with root package name */
    public Equivalence<Object> f26386f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum Dummy {
        VALUE
    }

    public MapMaker a(int i10) {
        int i11 = this.f26383c;
        com.google.common.base.o.z(i11 == -1, "concurrency level was already set to %s", i11);
        com.google.common.base.o.d(i10 > 0);
        this.f26383c = i10;
        return this;
    }

    public int b() {
        int i10 = this.f26383c;
        if (i10 == -1) {
            return 4;
        }
        return i10;
    }

    public int c() {
        int i10 = this.f26382b;
        if (i10 == -1) {
            return 16;
        }
        return i10;
    }

    public Equivalence<Object> d() {
        return (Equivalence) com.google.common.base.j.a(this.f26386f, e().defaultEquivalence());
    }

    public MapMakerInternalMap.Strength e() {
        return (MapMakerInternalMap.Strength) com.google.common.base.j.a(this.f26384d, MapMakerInternalMap.Strength.STRONG);
    }

    public MapMakerInternalMap.Strength f() {
        return (MapMakerInternalMap.Strength) com.google.common.base.j.a(this.f26385e, MapMakerInternalMap.Strength.STRONG);
    }

    public MapMaker g(int i10) {
        int i11 = this.f26382b;
        com.google.common.base.o.z(i11 == -1, "initial capacity was already set to %s", i11);
        com.google.common.base.o.d(i10 >= 0);
        this.f26382b = i10;
        return this;
    }

    public MapMaker h(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.f26386f;
        com.google.common.base.o.B(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
        this.f26386f = (Equivalence) com.google.common.base.o.r(equivalence);
        this.f26381a = true;
        return this;
    }

    public <K, V> ConcurrentMap<K, V> i() {
        if (!this.f26381a) {
            return new ConcurrentHashMap(c(), 0.75f, b());
        }
        return MapMakerInternalMap.create(this);
    }

    public MapMaker j(MapMakerInternalMap.Strength strength) {
        MapMakerInternalMap.Strength strength2 = this.f26384d;
        com.google.common.base.o.B(strength2 == null, "Key strength was already set to %s", strength2);
        this.f26384d = (MapMakerInternalMap.Strength) com.google.common.base.o.r(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f26381a = true;
        }
        return this;
    }

    public MapMaker k(MapMakerInternalMap.Strength strength) {
        MapMakerInternalMap.Strength strength2 = this.f26385e;
        com.google.common.base.o.B(strength2 == null, "Value strength was already set to %s", strength2);
        this.f26385e = (MapMakerInternalMap.Strength) com.google.common.base.o.r(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f26381a = true;
        }
        return this;
    }

    public MapMaker l() {
        return j(MapMakerInternalMap.Strength.WEAK);
    }

    public String toString() {
        j.b c4 = com.google.common.base.j.c(this);
        int i10 = this.f26382b;
        if (i10 != -1) {
            c4.b("initialCapacity", i10);
        }
        int i11 = this.f26383c;
        if (i11 != -1) {
            c4.b("concurrencyLevel", i11);
        }
        MapMakerInternalMap.Strength strength = this.f26384d;
        if (strength != null) {
            c4.d("keyStrength", com.google.common.base.a.e(strength.toString()));
        }
        MapMakerInternalMap.Strength strength2 = this.f26385e;
        if (strength2 != null) {
            c4.d("valueStrength", com.google.common.base.a.e(strength2.toString()));
        }
        if (this.f26386f != null) {
            c4.k("keyEquivalence");
        }
        return c4.toString();
    }
}
