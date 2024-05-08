package com.cupidapp.live.base.recyclerview;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKViewHolderConfig.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public Function1<Object, p> f12072a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function1<Object, p> f12073b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, Function1<Object, p>> f12074c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, Function3<Object, Boolean, Integer, p>> f12075d = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, Function2<Object, Integer, p>> f12076e = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, Function1<Object, p>> f12077f = new LinkedHashMap();

    @Nullable
    public final Function1<Object, p> a() {
        return this.f12072a;
    }

    @Nullable
    public final Function1<Object, p> b() {
        return this.f12073b;
    }

    @NotNull
    public final Map<Integer, Function3<Object, Boolean, Integer, p>> c() {
        return this.f12075d;
    }

    @NotNull
    public final Map<Integer, Function1<Object, p>> d() {
        return this.f12074c;
    }

    @NotNull
    public final Map<Integer, Function2<Object, Integer, p>> e() {
        return this.f12076e;
    }

    @NotNull
    public final Map<Integer, Function1<Object, p>> f() {
        return this.f12077f;
    }

    public final void g(@Nullable Function1<Object, p> function1) {
        this.f12072a = function1;
    }

    public final void h(@Nullable Function1<Object, p> function1) {
        this.f12073b = function1;
    }

    public final void i(@NotNull Map<Integer, Function3<Object, Boolean, Integer, p>> map) {
        s.i(map, "<set-?>");
        this.f12075d = map;
    }

    public final void j(@NotNull Map<Integer, Function1<Object, p>> map) {
        s.i(map, "<set-?>");
        this.f12074c = map;
    }

    public final void k(@NotNull Map<Integer, Function2<Object, Integer, p>> map) {
        s.i(map, "<set-?>");
        this.f12076e = map;
    }

    public final void l(@NotNull Map<Integer, Function1<Object, p>> map) {
        s.i(map, "<set-?>");
        this.f12077f = map;
    }
}
