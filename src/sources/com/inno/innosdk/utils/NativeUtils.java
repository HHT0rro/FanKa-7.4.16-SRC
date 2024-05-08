package com.inno.innosdk.utils;

import android.content.Context;
import android.util.Base64;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class NativeUtils {

    /* renamed from: a, reason: collision with root package name */
    public static String f35552a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f35553b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f35554c = true;

    static {
        try {
            if (com.inno.innosdk.a.c.k() == null) {
                System.loadLibrary("Inno");
                f35554c = true;
            } else {
                pc.b.a(com.inno.innosdk.a.c.k(), "Inno");
            }
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            f35554c = false;
        }
    }

    public static byte[] a(String str, int i10) {
        try {
            if (!f35554c) {
                return new byte[0];
            }
            if (i10 == 98) {
                return encode(str, com.inno.innosdk.b.a.q(), i10);
            }
            if (str.length() > 5000) {
                try {
                    String str2 = com.inno.innosdk.a.c.k().getFilesDir().getAbsolutePath() + "/inno_java";
                    com.inno.innosdk.utils.t.a.a(str2, str);
                    str = str2;
                } catch (Throwable th) {
                    com.inno.innosdk.utils.u.a.a(th);
                }
            }
            return encode(str, com.inno.innosdk.b.a.q(), i10);
        } catch (Throwable th2) {
            throw new IOException(th2);
        }
    }

    public static native byte[] a2dJni(byte[] bArr);

    public static String b() {
        String str;
        String str2 = "";
        try {
            Context k10 = com.inno.innosdk.a.c.k();
            if (k10 != null) {
                str = AppInfomation.a(k10) + AppInfomation.k(k10);
            } else {
                str = "";
            }
            if (f35554c) {
                if (str.length() > 20) {
                    str2 = getuuid(q.a(), q.b(str));
                } else {
                    str2 = getuuid(q.a(), "");
                }
            }
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
        return !com.inno.innosdk.utils.t.a.b(str2) ? f.a() : str2;
    }

    public static String c(String str) {
        return !f35554c ? "" : getacid2uuid(Base64.decode(str, 8));
    }

    public static native int checkcuid(String str);

    public static native byte[] d2aJni(byte[] bArr);

    public static native byte[] encode(String str, String str2, int i10);

    public static native byte[] genShortId(String str);

    public static native String getacid2uuid(byte[] bArr);

    public static native String getluid(String str);

    public static native byte[] getrid(long j10, String str, String str2, long j11, String str3);

    public static native String getuuid(String str, String str2);

    public static native int inittable();

    public static native String sign(byte[] bArr, String str, String str2);

    public static int c() {
        try {
            if (f35554c) {
                return inittable();
            }
            return -1;
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0058 A[Catch: all -> 0x0245, TRY_ENTER, TryCatch #1 {all -> 0x0245, blocks: (B:3:0x0002, B:6:0x000c, B:22:0x0050, B:25:0x0058, B:27:0x0060, B:31:0x006c, B:33:0x0072, B:35:0x007a, B:37:0x0082, B:39:0x008a, B:41:0x0092, B:43:0x009a, B:45:0x00a2, B:47:0x00aa, B:51:0x00b7, B:52:0x0104, B:54:0x010a, B:55:0x0121, B:57:0x0125, B:59:0x012d, B:60:0x021d, B:62:0x0221, B:64:0x0227, B:67:0x0234, B:69:0x0238, B:74:0x00d3, B:76:0x00ec, B:80:0x0204, B:83:0x004a), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010a A[Catch: all -> 0x0245, TryCatch #1 {all -> 0x0245, blocks: (B:3:0x0002, B:6:0x000c, B:22:0x0050, B:25:0x0058, B:27:0x0060, B:31:0x006c, B:33:0x0072, B:35:0x007a, B:37:0x0082, B:39:0x008a, B:41:0x0092, B:43:0x009a, B:45:0x00a2, B:47:0x00aa, B:51:0x00b7, B:52:0x0104, B:54:0x010a, B:55:0x0121, B:57:0x0125, B:59:0x012d, B:60:0x021d, B:62:0x0221, B:64:0x0227, B:67:0x0234, B:69:0x0238, B:74:0x00d3, B:76:0x00ec, B:80:0x0204, B:83:0x004a), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0221 A[Catch: all -> 0x0245, TryCatch #1 {all -> 0x0245, blocks: (B:3:0x0002, B:6:0x000c, B:22:0x0050, B:25:0x0058, B:27:0x0060, B:31:0x006c, B:33:0x0072, B:35:0x007a, B:37:0x0082, B:39:0x008a, B:41:0x0092, B:43:0x009a, B:45:0x00a2, B:47:0x00aa, B:51:0x00b7, B:52:0x0104, B:54:0x010a, B:55:0x0121, B:57:0x0125, B:59:0x012d, B:60:0x021d, B:62:0x0221, B:64:0x0227, B:67:0x0234, B:69:0x0238, B:74:0x00d3, B:76:0x00ec, B:80:0x0204, B:83:0x004a), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0238 A[Catch: all -> 0x0245, TRY_LEAVE, TryCatch #1 {all -> 0x0245, blocks: (B:3:0x0002, B:6:0x000c, B:22:0x0050, B:25:0x0058, B:27:0x0060, B:31:0x006c, B:33:0x0072, B:35:0x007a, B:37:0x0082, B:39:0x008a, B:41:0x0092, B:43:0x009a, B:45:0x00a2, B:47:0x00aa, B:51:0x00b7, B:52:0x0104, B:54:0x010a, B:55:0x0121, B:57:0x0125, B:59:0x012d, B:60:0x021d, B:62:0x0221, B:64:0x0227, B:67:0x0234, B:69:0x0238, B:74:0x00d3, B:76:0x00ec, B:80:0x0204, B:83:0x004a), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d3 A[Catch: all -> 0x0245, TryCatch #1 {all -> 0x0245, blocks: (B:3:0x0002, B:6:0x000c, B:22:0x0050, B:25:0x0058, B:27:0x0060, B:31:0x006c, B:33:0x0072, B:35:0x007a, B:37:0x0082, B:39:0x008a, B:41:0x0092, B:43:0x009a, B:45:0x00a2, B:47:0x00aa, B:51:0x00b7, B:52:0x0104, B:54:0x010a, B:55:0x0121, B:57:0x0125, B:59:0x012d, B:60:0x021d, B:62:0x0221, B:64:0x0227, B:67:0x0234, B:69:0x0238, B:74:0x00d3, B:76:0x00ec, B:80:0x0204, B:83:0x004a), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0204 A[Catch: all -> 0x0245, TryCatch #1 {all -> 0x0245, blocks: (B:3:0x0002, B:6:0x000c, B:22:0x0050, B:25:0x0058, B:27:0x0060, B:31:0x006c, B:33:0x0072, B:35:0x007a, B:37:0x0082, B:39:0x008a, B:41:0x0092, B:43:0x009a, B:45:0x00a2, B:47:0x00aa, B:51:0x00b7, B:52:0x0104, B:54:0x010a, B:55:0x0121, B:57:0x0125, B:59:0x012d, B:60:0x021d, B:62:0x0221, B:64:0x0227, B:67:0x0234, B:69:0x0238, B:74:0x00d3, B:76:0x00ec, B:80:0x0204, B:83:0x004a), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a() {
        /*
            Method dump skipped, instructions count: 594
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inno.innosdk.utils.NativeUtils.a():java.lang.String");
    }

    public static byte[] b(byte[] bArr) {
        try {
            if (f35554c) {
                return d2aJni(bArr);
            }
            return null;
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return null;
        }
    }

    public static byte[] b(String str) {
        try {
            if (f35554c) {
                return genShortId(str);
            }
            return null;
        } catch (Exception e2) {
            com.inno.innosdk.utils.u.a.a((Throwable) e2);
            return null;
        }
    }

    public static String a(Context context) {
        try {
            if (f35554c) {
                return getluid(AppInfomation.a(context) + "$$$" + AppInfomation.k(context));
            }
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
        return f.a();
    }

    public static String a(byte[] bArr, String str, String str2) {
        try {
            return f35554c ? sign(bArr, str, str2) : "";
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return "";
        }
    }

    public static byte[] a(long j10, String str, String str2, long j11, String str3) {
        try {
            if (f35554c) {
                return getrid(j10, str, str2, j11, str3);
            }
            return null;
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return null;
        }
    }

    public static byte[] a(byte[] bArr) {
        try {
            if (f35554c) {
                return a2dJni(bArr);
            }
            return null;
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return null;
        }
    }

    public static int a(String str) {
        try {
            if (f35554c) {
                return checkcuid(str);
            }
            return -1;
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return -1;
        }
    }
}
