package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import java.util.List;

/* compiled from: BatchedLogRequest.java */
@AutoValue
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class i {
    @NonNull
    public static i a(@NonNull List<j> list) {
        return new d(list);
    }

    @NonNull
    public static a8.a b() {
        return new c8.d().g(b.f19313a).h(true).f();
    }

    @NonNull
    public abstract List<j> c();
}
