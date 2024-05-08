package com.cupidapp.live.base.view.zoom;

import java.util.LinkedList;
import java.util.Queue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ObjectsPool.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class d<T> {

    /* renamed from: a, reason: collision with root package name */
    public final int f13004a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Queue<T> f13005b = new LinkedList();

    public d(int i10) {
        this.f13004a = i10;
    }

    public final void a(@Nullable T t2) {
        if (t2 == null || this.f13005b.size() >= this.f13004a) {
            return;
        }
        this.f13005b.offer(t2);
    }

    public abstract T b();

    public abstract T c(T t2);

    public final T d() {
        if (this.f13005b.size() == 0) {
            return b();
        }
        return c(this.f13005b.poll());
    }
}
