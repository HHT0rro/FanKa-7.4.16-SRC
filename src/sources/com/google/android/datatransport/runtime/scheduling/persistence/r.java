package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.z;

/* compiled from: SQLiteEventStore.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class r implements z.b {

    /* renamed from: a, reason: collision with root package name */
    public static final r f19469a = new r();

    public static z.b a() {
        return f19469a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.z.b
    public Object apply(Object obj) {
        return z.A((Cursor) obj);
    }
}