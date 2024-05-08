package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.ht;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* compiled from: Utils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class in {
    public static void a(Context context, ig igVar, String str, int i10, int i11, String str2) {
        igVar.f6450a = gw.c(context, str);
        igVar.f6453d = i10;
        igVar.f6451b = i11;
        igVar.f6452c = str2;
    }

    public static ig a(WeakReference<ig> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new ig());
        }
        return weakReference.get();
    }

    public static byte[] a(ht htVar, String str) {
        ht.b bVar;
        byte[] bArr = new byte[0];
        AutoCloseable autoCloseable = null;
        try {
            bVar = htVar.a(str);
            if (bVar == null) {
                if (bVar != null) {
                    try {
                        bVar.close();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                return bArr;
            }
            try {
                InputStream a10 = bVar.a();
                if (a10 == null) {
                    if (a10 != null) {
                        try {
                            a10.close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                    try {
                        bVar.close();
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                    return bArr;
                }
                bArr = new byte[a10.available()];
                a10.read(bArr);
                try {
                    a10.close();
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
                try {
                    bVar.close();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                return bArr;
            } catch (Throwable th6) {
                th = th6;
                try {
                    gy.b(th, "sui", "rdS");
                    if (0 != 0) {
                        try {
                            autoCloseable.close();
                        } catch (Throwable th7) {
                            th7.printStackTrace();
                        }
                    }
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (Throwable th8) {
                            th8.printStackTrace();
                        }
                    }
                    return bArr;
                } finally {
                }
            }
        } catch (Throwable th9) {
            th = th9;
            bVar = null;
        }
    }

    public static String a() {
        return fv.a(System.currentTimeMillis());
    }

    public static String a(Context context, fu fuVar) {
        StringBuilder sb2 = new StringBuilder();
        try {
            String e2 = fm.e();
            sb2.append("\"sim\":\"");
            sb2.append(e2);
            sb2.append("\",\"sdkversion\":\"");
            sb2.append(fuVar.c());
            sb2.append("\",\"product\":\"");
            sb2.append(fuVar.a());
            sb2.append("\",\"ed\":\"");
            sb2.append(fuVar.d());
            sb2.append("\",\"nt\":\"");
            sb2.append(fm.c(context));
            sb2.append("\",\"np\":\"");
            sb2.append(fm.b(context));
            sb2.append("\",\"mnc\":\"");
            sb2.append(fm.d());
            sb2.append("\",\"ant\":\"");
            sb2.append(fm.d(context));
            sb2.append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb2.toString();
    }

    public static String a(String str, String str2, int i10, String str3, String str4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(",\"timestamp\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i10);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    public static String a(String str, String str2, String str3, String str4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(",\"timestamp\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(1);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }
}
