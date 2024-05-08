package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.z;

/* compiled from: SQLiteEventStore.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class i implements z.b {

    /* renamed from: a, reason: collision with root package name */
    public final z f19457a;

    /* renamed from: b, reason: collision with root package name */
    public final TransportContext f19458b;

    public i(z zVar, TransportContext transportContext) {
        this.f19457a = zVar;
        this.f19458b = transportContext;
    }

    public static z.b a(z zVar, TransportContext transportContext) {
        return new i(zVar, transportContext);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.z.b
    public Object apply(Object obj) {
        return z.C(this.f19457a, this.f19458b, (SQLiteDatabase) obj);
    }
}
