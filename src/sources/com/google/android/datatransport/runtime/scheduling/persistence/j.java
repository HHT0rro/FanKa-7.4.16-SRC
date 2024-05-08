package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.z;

/* compiled from: SQLiteEventStore.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class j implements z.b {

    /* renamed from: a, reason: collision with root package name */
    public static final j f19459a = new j();

    public static z.b a() {
        return f19459a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.z.b
    public Object apply(Object obj) {
        return z.B((SQLiteDatabase) obj);
    }
}
