package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.z;
import java.util.Map;

/* compiled from: SQLiteEventStore.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class n implements z.b {

    /* renamed from: a, reason: collision with root package name */
    public final Map f19465a;

    public n(Map map) {
        this.f19465a = map;
    }

    public static z.b a(Map map) {
        return new n(map);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.z.b
    public Object apply(Object obj) {
        return z.E(this.f19465a, (Cursor) obj);
    }
}
