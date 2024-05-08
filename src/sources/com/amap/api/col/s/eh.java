package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.col.s.dq;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* compiled from: Utils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class eh {
    public static void a(Context context, eb ebVar, String str, int i10, int i11, String str2) {
        ebVar.f7872a = dd.c(context, str);
        ebVar.f7875d = i10;
        ebVar.f7873b = i11;
        ebVar.f7874c = str2;
    }

    public static eb a(WeakReference<eb> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new eb());
        }
        return weakReference.get();
    }

    public static byte[] a(dq dqVar, String str) {
        dq.b bVar;
        byte[] bArr = new byte[0];
        AutoCloseable autoCloseable = null;
        try {
            bVar = dqVar.a(str);
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
                    df.c(th, "sui", "rdS");
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
        return ci.a(System.currentTimeMillis());
    }

    public static String a(Context context, ch chVar) {
        StringBuilder sb2 = new StringBuilder();
        try {
            String e2 = ca.e();
            sb2.append("\"sim\":\"");
            sb2.append(e2);
            sb2.append("\",\"sdkversion\":\"");
            sb2.append(chVar.d());
            sb2.append("\",\"product\":\"");
            sb2.append(chVar.b());
            sb2.append("\",\"ed\":\"");
            sb2.append(chVar.e());
            sb2.append("\",\"nt\":\"");
            sb2.append(ca.c(context));
            sb2.append("\",\"np\":\"");
            sb2.append(ca.b(context));
            sb2.append("\",\"mnc\":\"");
            sb2.append(ca.d());
            sb2.append("\",\"ant\":\"");
            sb2.append(ca.d(context));
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
}
