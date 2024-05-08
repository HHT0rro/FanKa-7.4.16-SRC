package org.greenrobot.greendao.database;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface DatabaseStatement {
    void bindBlob(int i10, byte[] bArr);

    void bindDouble(int i10, double d10);

    void bindLong(int i10, long j10);

    void bindNull(int i10);

    void bindString(int i10, String str);

    void clearBindings();

    void close();

    void execute();

    long executeInsert();

    Object getRawStatement();

    long simpleQueryForLong();
}
