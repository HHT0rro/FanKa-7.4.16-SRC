package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import java.util.List;
import java.util.Objects;

/* compiled from: AutoValue_BatchedLogRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d extends i {

    /* renamed from: a, reason: collision with root package name */
    public final List<j> f19344a;

    public d(List<j> list) {
        Objects.requireNonNull(list, "Null logRequests");
        this.f19344a = list;
    }

    @Override // com.google.android.datatransport.cct.internal.i
    @NonNull
    public List<j> c() {
        return this.f19344a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            return this.f19344a.equals(((i) obj).c());
        }
        return false;
    }

    public int hashCode() {
        return this.f19344a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + ((Object) this.f19344a) + com.alipay.sdk.util.i.f4738d;
    }
}
