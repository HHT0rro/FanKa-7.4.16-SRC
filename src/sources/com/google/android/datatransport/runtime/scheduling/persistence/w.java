package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.z;

/* compiled from: SQLiteEventStore.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class w implements z.b {

    /* renamed from: a, reason: collision with root package name */
    public final String f19476a;

    public w(String str) {
        this.f19476a = str;
    }

    public static z.b a(String str) {
        return new w(str);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.z.b
    public Object apply(Object obj) {
        return z.H(this.f19476a, (SQLiteDatabase) obj);
    }
}
