package com.cupidapp.live.base.activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKBaseWatcher.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public List<g> f11771a = new ArrayList();

    public final void a(@Nullable g gVar) {
        this.f11771a.add(gVar);
    }

    public final boolean b() {
        Iterator<g> iterator2 = this.f11771a.iterator2();
        boolean z10 = false;
        while (iterator2.hasNext()) {
            g next = iterator2.next();
            if (next != null && next.a()) {
                z10 = true;
            }
        }
        return z10;
    }

    public final void c() {
        this.f11771a.clear();
    }
}
