package org.greenrobot.greendao.database;

import android.content.Context;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;
import org.greenrobot.greendao.database.DatabaseOpenHelper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
class SqlCipherEncryptedHelper extends SQLiteOpenHelper implements DatabaseOpenHelper.EncryptedHelper {
    private final DatabaseOpenHelper delegate;

    public SqlCipherEncryptedHelper(DatabaseOpenHelper databaseOpenHelper, Context context, String str, int i10, boolean z10) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i10);
        this.delegate = databaseOpenHelper;
        if (z10) {
            SQLiteDatabase.loadLibs(context);
        }
    }

    private Database wrap(SQLiteDatabase sQLiteDatabase) {
        return new EncryptedDatabase(sQLiteDatabase);
    }

    @Override // org.greenrobot.greendao.database.DatabaseOpenHelper.EncryptedHelper
    public Database getEncryptedReadableDb(String str) {
        return wrap(getReadableDatabase(str));
    }

    @Override // org.greenrobot.greendao.database.DatabaseOpenHelper.EncryptedHelper
    public Database getEncryptedWritableDb(String str) {
        return wrap(getWritableDatabase(str));
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.delegate.onCreate(wrap(sQLiteDatabase));
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        this.delegate.onOpen(wrap(sQLiteDatabase));
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        this.delegate.onUpgrade(wrap(sQLiteDatabase), i10, i11);
    }

    @Override // org.greenrobot.greendao.database.DatabaseOpenHelper.EncryptedHelper
    public Database getEncryptedReadableDb(char[] cArr) {
        return wrap(getReadableDatabase(cArr));
    }

    @Override // org.greenrobot.greendao.database.DatabaseOpenHelper.EncryptedHelper
    public Database getEncryptedWritableDb(char[] cArr) {
        return wrap(getWritableDatabase(cArr));
    }
}
