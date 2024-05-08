package com.google.mlkit.common.sdkinternal;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import java.util.concurrent.Executor;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final e8.a<? extends Executor> f27044a;

    public d(@RecentlyNonNull e8.a<? extends Executor> aVar) {
        this.f27044a = aVar;
    }

    @RecentlyNonNull
    public Executor a(@Nullable Executor executor) {
        return executor != null ? executor : this.f27044a.get();
    }
}
