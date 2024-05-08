package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.f0;

/* compiled from: SchemaManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class d0 implements f0.a {

    /* renamed from: a, reason: collision with root package name */
    public static final d0 f19439a = new d0();

    public static f0.a b() {
        return f19439a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.f0.a
    public void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }
}
