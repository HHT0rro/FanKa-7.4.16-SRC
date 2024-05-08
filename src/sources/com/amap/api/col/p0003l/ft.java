package com.amap.api.col.p0003l;

import android.content.Context;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;

/* compiled from: ProxyUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ft {
    public static Proxy a(Context context) {
        try {
            return a(context, new URI("http://restsdk.amap.com"));
        } catch (Throwable th) {
            gy.b(th, "pu", "gp");
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0074, code lost:
    
        if (r10 == (-1)) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ab, code lost:
    
        r18 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a8, code lost:
    
        r18 = 80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00a6, code lost:
    
        if (r10 == (-1)) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0119, code lost:
    
        if (r12 == (-1)) goto L88;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x015c A[Catch: all -> 0x0158, TRY_LEAVE, TryCatch #10 {all -> 0x0158, blocks: (B:20:0x014d, B:12:0x015c), top: B:19:0x014d }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x014d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ef A[Catch: all -> 0x0171, TryCatch #8 {all -> 0x0171, blocks: (B:102:0x00ca, B:68:0x00e4, B:70:0x00ef, B:72:0x0103, B:74:0x0109, B:78:0x0115, B:89:0x011e, B:91:0x0124, B:93:0x012a, B:97:0x0136), top: B:4:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0142 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x013e  */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.content.ContentResolver, android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.Proxy b(android.content.Context r19) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.ft.b(android.content.Context):java.net.Proxy");
    }

    private static boolean c(Context context) {
        return fm.j(context) == 0;
    }

    private static String a(String str) {
        return fv.c(str);
    }

    private static String a() {
        String str;
        try {
            str = android.net.Proxy.getDefaultHost();
        } catch (Throwable th) {
            gy.b(th, "pu", "gdh");
            str = null;
        }
        return str == null ? "null" : str;
    }

    private static Proxy a(Context context, URI uri) {
        Proxy proxy;
        if (c(context)) {
            try {
                List<Proxy> select = ProxySelector.getDefault().select(uri);
                if (select == null || select.isEmpty() || (proxy = select.get(0)) == null) {
                    return null;
                }
                if (proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                return proxy;
            } catch (Throwable th) {
                gy.b(th, "pu", "gpsc");
            }
        }
        return null;
    }

    private static int b() {
        try {
            return android.net.Proxy.getDefaultPort();
        } catch (Throwable th) {
            gy.b(th, "pu", "gdp");
            return -1;
        }
    }
}
