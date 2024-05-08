package com.bytedance.android.live.saas.middleware.alog;

import android.content.Intent;
import android.os.Bundle;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface ILogProtocol {
    void bundle(int i10, String str, Bundle bundle);

    void changeLevel(int i10);

    void d(String str, String str2);

    void destroy();

    void e(String str, String str2);

    void e(String str, String str2, Throwable th);

    void e(String str, Throwable th);

    void flush();

    void forceLogSharding();

    void header(int i10, String str, String str2);

    void i(String str, String str2);

    void intent(int i10, String str, Intent intent);

    void json(int i10, String str, String str2);

    void release();

    void stacktrace(int i10, String str, StackTraceElement[] stackTraceElementArr);

    void thread(int i10, String str, Thread thread);

    void throwable(int i10, String str, String str2, Throwable th);

    void throwable(int i10, String str, Throwable th);

    void v(String str, String str2);

    void w(String str, String str2);

    void w(String str, String str2, Throwable th);

    void w(String str, Throwable th);
}
