package com.cupidapp.live.base.activity;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKBaseWatcher.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final List<b> f11770a = new ArrayList();

    public final void a(@NotNull b observer) {
        s.i(observer, "observer");
        this.f11770a.add(observer);
    }

    public final void b(int i10, int i11, @Nullable Intent intent) {
        Iterator<b> iterator2 = this.f11770a.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onActivityResult(i10, i11, intent);
        }
    }

    public final void c() {
        this.f11770a.clear();
    }
}
