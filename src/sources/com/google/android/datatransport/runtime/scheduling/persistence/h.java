package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.z;

/* compiled from: SQLiteEventStore.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class h implements z.b {

    /* renamed from: a, reason: collision with root package name */
    public final long f19455a;

    /* renamed from: b, reason: collision with root package name */
    public final TransportContext f19456b;

    public h(long j10, TransportContext transportContext) {
        this.f19455a = j10;
        this.f19456b = transportContext;
    }

    public static z.b a(long j10, TransportContext transportContext) {
        return new h(j10, transportContext);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.z.b
    public Object apply(Object obj) {
        return z.I(this.f19455a, this.f19456b, (SQLiteDatabase) obj);
    }
}
