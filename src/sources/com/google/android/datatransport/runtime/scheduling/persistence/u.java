package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.z;

/* compiled from: SQLiteEventStore.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class u implements z.b {

    /* renamed from: a, reason: collision with root package name */
    public final z f19472a;

    /* renamed from: b, reason: collision with root package name */
    public final TransportContext f19473b;

    /* renamed from: c, reason: collision with root package name */
    public final EventInternal f19474c;

    public u(z zVar, TransportContext transportContext, EventInternal eventInternal) {
        this.f19472a = zVar;
        this.f19473b = transportContext;
        this.f19474c = eventInternal;
    }

    public static z.b a(z zVar, TransportContext transportContext, EventInternal eventInternal) {
        return new u(zVar, transportContext, eventInternal);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.z.b
    public Object apply(Object obj) {
        return z.F(this.f19472a, this.f19473b, this.f19474c, (SQLiteDatabase) obj);
    }
}
