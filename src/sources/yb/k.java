package yb;

import androidx.annotation.Nullable;

/* compiled from: DatabaseTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final j f54762a;

    /* renamed from: b, reason: collision with root package name */
    public final Runnable f54763b;

    public k(j jVar, Runnable runnable) {
        this.f54762a = jVar;
        this.f54763b = runnable;
    }

    public Integer a() {
        j jVar = this.f54762a;
        if (jVar != null) {
            return Integer.valueOf(jVar.a());
        }
        return null;
    }

    public boolean b() {
        j jVar = this.f54762a;
        return jVar != null && jVar.b();
    }
}
