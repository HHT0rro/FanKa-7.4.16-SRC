package org.greenrobot.greendao.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import org.greenrobot.greendao.DaoException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class DatabaseOpenHelper extends SQLiteOpenHelper {
    private final Context context;
    private EncryptedHelper encryptedHelper;
    private boolean loadSQLCipherNativeLibs;
    private final String name;
    private final int version;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface EncryptedHelper {
        Database getEncryptedReadableDb(String str);

        Database getEncryptedReadableDb(char[] cArr);

        Database getEncryptedWritableDb(String str);

        Database getEncryptedWritableDb(char[] cArr);
    }

    public DatabaseOpenHelper(Context context, String str, int i10) {
        this(context, str, null, i10);
    }

    private EncryptedHelper checkEncryptedHelper() {
        if (this.encryptedHelper == null) {
            try {
                Class.forName("net.sqlcipher.database.SQLiteOpenHelper");
                try {
                    this.encryptedHelper = (EncryptedHelper) Class.forName("org.greenrobot.greendao.database.SqlCipherEncryptedHelper").getConstructor(DatabaseOpenHelper.class, Context.class, String.class, Integer.TYPE, Boolean.TYPE).newInstance(this, this.context, this.name, Integer.valueOf(this.version), Boolean.valueOf(this.loadSQLCipherNativeLibs));
                } catch (Exception e2) {
                    throw new DaoException(e2);
                }
            } catch (ClassNotFoundException unused) {
                throw new DaoException("Using an encrypted database requires SQLCipher, make sure to add it to dependencies: https://greenrobot.org/greendao/documentation/database-encryption/");
            }
        }
        return this.encryptedHelper;
    }

    public Database getEncryptedReadableDb(String str) {
        return checkEncryptedHelper().getEncryptedReadableDb(str);
    }

    public Database getEncryptedWritableDb(String str) {
        return checkEncryptedHelper().getEncryptedWritableDb(str);
    }

    public Database getReadableDb() {
        return wrap(getReadableDatabase());
    }

    public Database getWritableDb() {
        return wrap(getWritableDatabase());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        onCreate(wrap(sQLiteDatabase));
    }

    public void onCreate(Database database) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        onOpen(wrap(sQLiteDatabase));
    }

    public void onOpen(Database database) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        onUpgrade(wrap(sQLiteDatabase), i10, i11);
    }

    public void onUpgrade(Database database, int i10, int i11) {
    }

    public void setLoadSQLCipherNativeLibs(boolean z10) {
        this.loadSQLCipherNativeLibs = z10;
    }

    public Database wrap(SQLiteDatabase sQLiteDatabase) {
        return new StandardDatabase(sQLiteDatabase);
    }

    public DatabaseOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i10) {
        super(context, str, cursorFactory, i10);
        this.loadSQLCipherNativeLibs = true;
        this.context = context;
        this.name = str;
        this.version = i10;
    }

    public Database getEncryptedReadableDb(char[] cArr) {
        return checkEncryptedHelper().getEncryptedReadableDb(cArr);
    }

    public Database getEncryptedWritableDb(char[] cArr) {
        return checkEncryptedHelper().getEncryptedWritableDb(cArr);
    }

    public DatabaseOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i10, DatabaseErrorHandler databaseErrorHandler) {
        super(context, str, cursorFactory, i10, databaseErrorHandler);
        this.loadSQLCipherNativeLibs = true;
        this.context = context;
        this.name = str;
        this.version = i10;
    }
}
