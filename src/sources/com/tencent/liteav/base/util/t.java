package com.tencent.liteav.base.util;

import android.text.TextUtils;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class t<T> {

    /* renamed from: a, reason: collision with root package name */
    private T f42919a;

    /* renamed from: b, reason: collision with root package name */
    private Callable<T> f42920b;

    public t(Callable<T> callable) {
        this.f42920b = callable;
    }

    public final void a(T t2) {
        synchronized (this) {
            this.f42919a = t2;
        }
    }

    public final T a() {
        T t2 = this.f42919a;
        if (t2 instanceof String) {
            if (!TextUtils.isEmpty((CharSequence) t2)) {
                return this.f42919a;
            }
        } else if (t2 != null) {
            return t2;
        }
        synchronized (this) {
            T t10 = this.f42919a;
            if (t10 instanceof String) {
                if (!TextUtils.isEmpty((CharSequence) t10)) {
                    return this.f42919a;
                }
            } else if (t10 != null) {
                return t10;
            }
            try {
                this.f42919a = this.f42920b.call();
            } catch (Exception e2) {
                e2.printStackTrace();
                LiteavLog.e("Stash", "Get value failed. msg:" + e2.getMessage());
            }
            return this.f42919a;
        }
    }
}
