package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.z;

/* compiled from: SQLiteEventStore.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class x implements z.b {

    /* renamed from: a, reason: collision with root package name */
    public static final x f19477a = new x();

    public static z.b a() {
        return f19477a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.z.b
    public Object apply(Object obj) {
        return z.x((Cursor) obj);
    }
}
