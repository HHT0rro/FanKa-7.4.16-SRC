package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class b2 {
    public static int a(Context context, int i10) {
        int a10 = y5.a(context);
        if (-1 == a10) {
            return -1;
        }
        return (i10 * (a10 == 0 ? 13 : 11)) / 10;
    }

    public static int b(hq hqVar) {
        return h4.a(hqVar.a());
    }

    public static int c(jb jbVar, hq hqVar) {
        int a10;
        switch (c2.f47150a[hqVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return h4.a(hqVar.a());
            case 11:
                a10 = h4.a(hqVar.a());
                if (jbVar != null) {
                    try {
                        if (jbVar instanceof ih) {
                            String str = ((ih) jbVar).f414d;
                            if (!TextUtils.isEmpty(str) && h4.b(h4.d(str)) != -1) {
                                a10 = h4.b(h4.d(str));
                                break;
                            }
                        } else if (jbVar instanceof ip) {
                            String str2 = ((ip) jbVar).f473d;
                            if (!TextUtils.isEmpty(str2)) {
                                if (h4.b(h4.d(str2)) != -1) {
                                    a10 = h4.b(h4.d(str2));
                                }
                                if (ia.UploadTinyData.equals(h4.d(str2))) {
                                    return -1;
                                }
                            }
                        }
                    } catch (Exception unused) {
                        fc.c.n("PERF_ERROR : parse Notification type error");
                        return a10;
                    }
                }
                break;
            case 12:
                a10 = h4.a(hqVar.a());
                if (jbVar != null) {
                    try {
                        if (jbVar instanceof il) {
                            String a11 = ((il) jbVar).a();
                            if (!TextUtils.isEmpty(a11) && fk.a(a11) != -1) {
                                a10 = fk.a(a11);
                                break;
                            }
                        } else if (jbVar instanceof ik) {
                            String a12 = ((ik) jbVar).a();
                            if (!TextUtils.isEmpty(a12) && fk.a(a12) != -1) {
                                return fk.a(a12);
                            }
                        }
                    } catch (Exception unused2) {
                        fc.c.n("PERF_ERROR : parse Command type error");
                        break;
                    }
                }
                break;
            default:
                return -1;
        }
        return a10;
    }

    public static void d(String str, Context context, int i10, int i11) {
        if (i10 <= 0 || i11 <= 0) {
            return;
        }
        int a10 = a(context, i11);
        if (i10 != h4.b(ia.UploadTinyData)) {
            i4.a(context.getApplicationContext()).c(str, i10, 1L, a10);
        }
    }

    public static void e(String str, Context context, im imVar, int i10) {
        hq a10;
        if (context == null || imVar == null || (a10 = imVar.a()) == null) {
            return;
        }
        int b4 = b(a10);
        if (i10 <= 0) {
            byte[] c4 = o6.c(imVar);
            i10 = c4 != null ? c4.length : 0;
        }
        d(str, context, b4, i10);
    }

    public static void f(String str, Context context, jb jbVar, hq hqVar, int i10) {
        d(str, context, c(jbVar, hqVar), i10);
    }

    public static void g(String str, Context context, byte[] bArr) {
        if (context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        im imVar = new im();
        try {
            o6.b(imVar, bArr);
            e(str, context, imVar, bArr.length);
        } catch (jg unused) {
            fc.c.i("fail to convert bytes to container");
        }
    }
}
