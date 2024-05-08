package com.tekartik.sqflite.operation;

import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface OperationResult {
    void error(String str, String str2, Object obj);

    void success(@Nullable Object obj);
}
