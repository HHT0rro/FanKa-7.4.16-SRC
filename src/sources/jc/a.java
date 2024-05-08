package jc;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import fc.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a extends SQLiteOpenHelper {

    /* renamed from: b, reason: collision with root package name */
    public static int f50557b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f50558c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f50559d = {"package_name", "TEXT", "message_ts", " LONG DEFAULT 0 ", "bytes", " LONG DEFAULT 0 ", "network_type", " INT DEFAULT -1 ", "rcv", " INT DEFAULT -1 ", "imsi", "TEXT"};

    public a(Context context) {
        super(context, "traffic.db", (SQLiteDatabase.CursorFactory) null, f50557b);
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb2 = new StringBuilder("CREATE TABLE traffic(_id INTEGER  PRIMARY KEY ,");
        int i10 = 0;
        while (true) {
            String[] strArr = f50559d;
            if (i10 >= strArr.length - 1) {
                sb2.append(");");
                sQLiteDatabase.execSQL(sb2.toString());
                return;
            }
            if (i10 != 0) {
                sb2.append(",");
            }
            sb2.append(strArr[i10]);
            sb2.append(" ");
            sb2.append(strArr[i10 + 1]);
            i10 += 2;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (f50558c) {
            try {
                a(sQLiteDatabase);
            } catch (SQLException e2) {
                c.k(e2);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }
}
