package com.inno.innosdk.utils;

import android.os.Handler;

/* compiled from: HttpUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public static Handler f35604a = new Handler(com.inno.innosdk.a.c.k().getMainLooper());

    /* compiled from: HttpUtils.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f35605a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f35606b;

        public a(c cVar, String str) {
            this.f35605a = cVar;
            this.f35606b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = this.f35605a;
            if (cVar != null) {
                cVar.a(this.f35606b);
            }
        }
    }

    /* compiled from: HttpUtils.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f35607a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f35608b;

        public b(c cVar, String str) {
            this.f35607a = cVar;
            this.f35608b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = this.f35607a;
            if (cVar != null) {
                cVar.b(this.f35608b);
            }
        }
    }

    /* compiled from: HttpUtils.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface c {
        void a(String str);

        void b(String str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0132, code lost:
    
        if (r7 != 0) goto L82;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0123 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v14, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r8v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r8v16, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v31, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r8v33, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v36 */
    /* JADX WARN: Type inference failed for: r8v37 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r7, byte[] r8, byte[] r9, java.util.Map<java.lang.String, java.lang.String> r10, com.inno.innosdk.utils.i.c r11) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inno.innosdk.utils.i.a(java.lang.String, byte[], byte[], java.util.Map, com.inno.innosdk.utils.i$c):java.lang.String");
    }

    public static void b(String str, c cVar) {
        f35604a.post(new a(cVar, str));
    }

    public static void a(String str, c cVar) {
        f35604a.post(new b(cVar, str));
    }
}
