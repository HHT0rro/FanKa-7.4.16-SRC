package com.tencent.cloud.huiyansdkface.facelight.c.c;

import android.content.Context;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final b f40650a = new b() { // from class: com.tencent.cloud.huiyansdkface.facelight.c.c.c.1
        @Override // com.tencent.cloud.huiyansdkface.facelight.c.c.b
        public void a() {
            WLogger.d("WbCrashReportProviders", "close empty crash report");
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.c.c.b
        public void a(Context context) {
            WLogger.d("WbCrashReportProviders", "init empty crash report");
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.c.c.b
        public void a(String str) {
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.c.c.b
        public void a(String str, String str2) {
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.c.c.b
        public void b(String str, String str2) {
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private static boolean f40651b = true;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static com.tencent.cloud.huiyansdkface.facelight.c.c.a f40652a = new com.tencent.cloud.huiyansdkface.facelight.c.c.a();

        public static com.tencent.cloud.huiyansdkface.facelight.c.c.a a() {
            return f40652a;
        }
    }

    public static b a() {
        return f40651b ? a.a() : f40650a;
    }
}
