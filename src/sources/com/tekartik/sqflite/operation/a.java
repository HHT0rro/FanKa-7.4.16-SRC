package com.tekartik.sqflite.operation;

/* compiled from: BaseOperation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class a extends b {
    @Override // com.tekartik.sqflite.operation.OperationResult
    public void error(String str, String str2, Object obj) {
        k().error(str, str2, obj);
    }

    public abstract OperationResult k();

    @Override // com.tekartik.sqflite.operation.OperationResult
    public void success(Object obj) {
        k().success(obj);
    }
}
