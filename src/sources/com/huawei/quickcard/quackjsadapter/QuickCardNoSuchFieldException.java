package com.huawei.quickcard.quackjsadapter;

import androidx.annotation.NonNull;
import com.huawei.quickcard.base.annotation.DoNotShrink;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QuickCardNoSuchFieldException extends NoSuchFieldException {
    @Override // java.lang.Throwable
    @NonNull
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
