package org.greenrobot.greendao.database;

import net.sqlcipher.database.SQLiteStatement;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class EncryptedDatabaseStatement implements DatabaseStatement {
    private final SQLiteStatement delegate;

    public EncryptedDatabaseStatement(SQLiteStatement sQLiteStatement) {
        this.delegate = sQLiteStatement;
    }

    @Override // org.greenrobot.greendao.database.DatabaseStatement
    public void bindBlob(int i10, byte[] bArr) {
        this.delegate.bindBlob(i10, bArr);
    }

    @Override // org.greenrobot.greendao.database.DatabaseStatement
    public void bindDouble(int i10, double d10) {
        this.delegate.bindDouble(i10, d10);
    }

    @Override // org.greenrobot.greendao.database.DatabaseStatement
    public void bindLong(int i10, long j10) {
        this.delegate.bindLong(i10, j10);
    }

    @Override // org.greenrobot.greendao.database.DatabaseStatement
    public void bindNull(int i10) {
        this.delegate.bindNull(i10);
    }

    @Override // org.greenrobot.greendao.database.DatabaseStatement
    public void bindString(int i10, String str) {
        this.delegate.bindString(i10, str);
    }

    @Override // org.greenrobot.greendao.database.DatabaseStatement
    public void clearBindings() {
        this.delegate.clearBindings();
    }

    @Override // org.greenrobot.greendao.database.DatabaseStatement
    public void close() {
        this.delegate.close();
    }

    @Override // org.greenrobot.greendao.database.DatabaseStatement
    public void execute() {
        this.delegate.execute();
    }

    @Override // org.greenrobot.greendao.database.DatabaseStatement
    public long executeInsert() {
        return this.delegate.executeInsert();
    }

    @Override // org.greenrobot.greendao.database.DatabaseStatement
    public Object getRawStatement() {
        return this.delegate;
    }

    @Override // org.greenrobot.greendao.database.DatabaseStatement
    public long simpleQueryForLong() {
        return this.delegate.simpleQueryForLong();
    }
}
