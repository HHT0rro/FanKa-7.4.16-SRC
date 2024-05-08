package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.z;

/* compiled from: SQLiteEventStore.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class o implements z.d {

    /* renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f19466a;

    public o(SQLiteDatabase sQLiteDatabase) {
        this.f19466a = sQLiteDatabase;
    }

    public static z.d b(SQLiteDatabase sQLiteDatabase) {
        return new o(sQLiteDatabase);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.z.d
    public Object a() {
        return z.r(this.f19466a);
    }
}
