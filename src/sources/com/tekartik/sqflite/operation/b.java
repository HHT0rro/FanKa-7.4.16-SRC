package com.tekartik.sqflite.operation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import yb.d0;

/* compiled from: BaseReadOperation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class b implements c {
    @Override // com.tekartik.sqflite.operation.c
    public d0 c() {
        return new d0(i(), j());
    }

    @Override // com.tekartik.sqflite.operation.c
    public boolean d() {
        return b("transactionId") && getTransactionId() == null;
    }

    @Override // com.tekartik.sqflite.operation.c
    public Boolean e() {
        return g("inTransaction");
    }

    @Override // com.tekartik.sqflite.operation.c
    public boolean f() {
        return Boolean.TRUE.equals(a("noResult"));
    }

    public final Boolean g(String str) {
        Object a10 = a(str);
        if (a10 instanceof Boolean) {
            return (Boolean) a10;
        }
        return null;
    }

    @Override // com.tekartik.sqflite.operation.c
    @Nullable
    public Integer getTransactionId() {
        return (Integer) a("transactionId");
    }

    public boolean h() {
        return Boolean.TRUE.equals(a("continueOnError"));
    }

    public final String i() {
        return (String) a("sql");
    }

    public final List<Object> j() {
        return (List) a("arguments");
    }

    @NonNull
    public String toString() {
        return "" + getMethod() + " " + i() + " " + ((Object) j());
    }
}
