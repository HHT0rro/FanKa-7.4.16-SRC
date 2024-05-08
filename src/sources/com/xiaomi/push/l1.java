package com.xiaomi.push;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.xiaomi.push.k1;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class l1 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f47936b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k1.a f47937c;

    public l1(k1.a aVar, Context context) {
        this.f47937c = aVar;
        this.f47936b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.f47937c.a();
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.beginTransaction();
                    this.f47937c.e(this.f47936b, sQLiteDatabase);
                    sQLiteDatabase.setTransactionSuccessful();
                }
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e2) {
                        e = e2;
                        fc.c.k(e);
                        this.f47937c.d(this.f47936b);
                    }
                }
                j1 j1Var = this.f47937c.f47881c;
                if (j1Var != null) {
                    j1Var.close();
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e10) {
                        fc.c.k(e10);
                        this.f47937c.d(this.f47936b);
                        throw th;
                    }
                }
                j1 j1Var2 = this.f47937c.f47881c;
                if (j1Var2 != null) {
                    j1Var2.close();
                }
                this.f47937c.d(this.f47936b);
                throw th;
            }
        } catch (Exception e11) {
            fc.c.k(e11);
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e12) {
                    e = e12;
                    fc.c.k(e);
                    this.f47937c.d(this.f47936b);
                }
            }
            j1 j1Var3 = this.f47937c.f47881c;
            if (j1Var3 != null) {
                j1Var3.close();
            }
        }
        this.f47937c.d(this.f47936b);
    }
}
