package com.tencent.cloud.huiyansdkface.facelight.b;

import android.util.Log;
import com.tencent.cloud.huiyansdkface.a.d.a;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static a.c f40595a = new a.c() { // from class: com.tencent.cloud.huiyansdkface.facelight.b.a.1
        @Override // com.tencent.cloud.huiyansdkface.a.d.a.c
        public void a(String str, Throwable th, String str2, Object... objArr) {
            WLogger.v(str, String.format(str2, objArr));
            WLogger.v(str, Log.getStackTraceString(th));
        }

        @Override // com.tencent.cloud.huiyansdkface.a.d.a.c
        public void b(String str, Throwable th, String str2, Object... objArr) {
            WLogger.d(str, String.format(str2, objArr));
            WLogger.d(str, Log.getStackTraceString(th));
        }

        @Override // com.tencent.cloud.huiyansdkface.a.d.a.c
        public void c(String str, Throwable th, String str2, Object... objArr) {
            WLogger.i(str, String.format(str2, objArr));
            WLogger.i(str, Log.getStackTraceString(th));
        }

        @Override // com.tencent.cloud.huiyansdkface.a.d.a.c
        public void d(String str, Throwable th, String str2, Object... objArr) {
            WLogger.w(str, String.format(str2, objArr));
            WLogger.w(str, Log.getStackTraceString(th));
        }

        @Override // com.tencent.cloud.huiyansdkface.a.d.a.c
        public void e(String str, Throwable th, String str2, Object... objArr) {
            WLogger.e(str, String.format(str2, objArr));
            WLogger.e(str, Log.getStackTraceString(th));
        }
    };
}
