package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.z;
import java.util.List;

/* compiled from: SQLiteEventStore.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class l implements z.b {

    /* renamed from: a, reason: collision with root package name */
    public final z f19461a;

    /* renamed from: b, reason: collision with root package name */
    public final List f19462b;

    /* renamed from: c, reason: collision with root package name */
    public final TransportContext f19463c;

    public l(z zVar, List list, TransportContext transportContext) {
        this.f19461a = zVar;
        this.f19462b = list;
        this.f19463c = transportContext;
    }

    public static z.b a(z zVar, List list, TransportContext transportContext) {
        return new l(zVar, list, transportContext);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.z.b
    public Object apply(Object obj) {
        return z.D(this.f19461a, this.f19462b, this.f19463c, (Cursor) obj);
    }
}
