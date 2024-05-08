package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.z;

/* compiled from: SQLiteEventStore.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class q implements z.d {

    /* renamed from: a, reason: collision with root package name */
    public final f0 f19468a;

    public q(f0 f0Var) {
        this.f19468a = f0Var;
    }

    public static z.d b(f0 f0Var) {
        return new q(f0Var);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.z.d
    public Object a() {
        return this.f19468a.getWritableDatabase();
    }
}
