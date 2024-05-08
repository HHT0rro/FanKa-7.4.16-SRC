package com.huawei.flexiblelayout.common;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class Lazy<T> {

    /* renamed from: a, reason: collision with root package name */
    private volatile T f27922a = null;

    public abstract T create();

    public final T get() {
        if (this.f27922a == null) {
            synchronized (this) {
                if (this.f27922a == null) {
                    this.f27922a = create();
                }
            }
        }
        return this.f27922a;
    }
}
