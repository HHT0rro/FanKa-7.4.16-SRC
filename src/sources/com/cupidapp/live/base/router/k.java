package com.cupidapp.live.base.router;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKRouter.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final Map<String, Class<? extends h>> f12168a = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Map<String, h> f12169b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Map<String, h> f12170c = new LinkedHashMap();

    @Nullable
    public final h a(@Nullable String str) {
        h hVar = this.f12169b.get(str);
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = this.f12170c.get(str);
        if (hVar2 != null) {
            return hVar2;
        }
        Class<? extends h> cls = this.f12168a.get(str);
        if (cls != null) {
            return cls.newInstance();
        }
        return null;
    }

    public final void b(@NotNull Lifecycle lifecycle, @Nullable com.cupidapp.live.base.activity.h hVar) {
        s.i(lifecycle, "lifecycle");
        for (Map.Entry<String, Class<? extends h>> entry : this.f12168a.entrySet()) {
            h newInstance = entry.getValue().newInstance();
            if (newInstance instanceof LifecycleObserver) {
                this.f12169b.put(entry.getKey(), newInstance);
                lifecycle.addObserver((LifecycleObserver) newInstance);
            }
            if (newInstance instanceof com.cupidapp.live.base.activity.b) {
                this.f12170c.put(entry.getKey(), newInstance);
                if (hVar != null) {
                    hVar.a((com.cupidapp.live.base.activity.b) newInstance);
                }
            }
        }
    }

    public final void c(@NotNull Map<String, Class<? extends h>> names) {
        s.i(names, "names");
        this.f12168a.putAll(names);
    }
}
