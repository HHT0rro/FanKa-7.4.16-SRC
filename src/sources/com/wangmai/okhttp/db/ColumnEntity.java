package com.wangmai.okhttp.db;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ColumnEntity {
    public String columnName;
    public String columnType;
    public String[] compositePrimaryKey;
    public boolean isAutoincrement;
    public boolean isNotNull;
    public boolean isPrimary;

    public ColumnEntity(String... strArr) {
        this.compositePrimaryKey = strArr;
    }

    public ColumnEntity(String str, String str2) {
        this(str, str2, false, false, false);
    }

    public ColumnEntity(String str, String str2, boolean z10, boolean z11) {
        this(str, str2, z10, z11, false);
    }

    public ColumnEntity(String str, String str2, boolean z10, boolean z11, boolean z12) {
        this.columnName = str;
        this.columnType = str2;
        this.isPrimary = z10;
        this.isNotNull = z11;
        this.isAutoincrement = z12;
    }
}
