package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.z;

/* compiled from: SQLiteEventStore.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class y implements z.b {

    /* renamed from: a, reason: collision with root package name */
    public final z f19478a;

    /* renamed from: b, reason: collision with root package name */
    public final TransportContext f19479b;

    public y(z zVar, TransportContext transportContext) {
        this.f19478a = zVar;
        this.f19479b = transportContext;
    }

    public static z.b a(z zVar, TransportContext transportContext) {
        return new y(zVar, transportContext);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.z.b
    public Object apply(Object obj) {
        return z.z(this.f19478a, this.f19479b, (SQLiteDatabase) obj);
    }
}
