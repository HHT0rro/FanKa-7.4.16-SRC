package com.huawei.flexiblelayout.log;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class LogcatNode implements LogNode {
    @Override // com.huawei.flexiblelayout.log.LogNode
    public void println(int i10, String str, String str2, Throwable th) {
        if (th == null) {
            android.util.Log.println(i10, str, str2);
            return;
        }
        android.util.Log.println(i10, str, str2 + '\n' + android.util.Log.getStackTraceString(th));
    }
}
