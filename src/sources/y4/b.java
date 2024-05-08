package y4;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.exoplayer2.util.m;

/* compiled from: ExoDatabaseProvider.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b extends SQLiteOpenHelper implements a {
    public b(Context context) {
        super(context.getApplicationContext(), "exoplayer_internal.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static void a(SQLiteDatabase sQLiteDatabase) {
        Cursor query = sQLiteDatabase.query("sqlite_master", new String[]{"type", "name"}, null, null, null, null, null);
        while (query.moveToNext()) {
            try {
                String string = query.getString(0);
                String string2 = query.getString(1);
                if (!"sqlite_sequence".equals(string2)) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 16 + String.valueOf(string2).length());
                    sb2.append("DROP ");
                    sb2.append(string);
                    sb2.append(" IF EXISTS ");
                    sb2.append(string2);
                    String sb3 = sb2.toString();
                    try {
                        sQLiteDatabase.execSQL(sb3);
                    } catch (SQLException e2) {
                        String valueOf = String.valueOf(sb3);
                        m.d("ExoDatabaseProvider", valueOf.length() != 0 ? "Error executing ".concat(valueOf) : new String("Error executing "), e2);
                    }
                }
            } catch (Throwable th) {
                if (query != null) {
                    try {
                        query.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        query.close();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }
}
