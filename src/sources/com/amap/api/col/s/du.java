package com.amap.api.col.s;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BinaryRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class du extends cd {

    /* renamed from: a, reason: collision with root package name */
    public Context f7747a;

    /* renamed from: b, reason: collision with root package name */
    public ch f7748b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f7749c;

    public du(Context context, ch chVar) {
        if (context != null) {
            this.f7747a = context.getApplicationContext();
        }
        this.f7748b = chVar;
        q();
    }

    private byte[] A() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            Context context = this.f7747a;
            ch chVar = this.f7748b;
            byte[] a10 = bz.a(context, chVar != null && "navi".equals(chVar.b()));
            byteArrayOutputStream.write(a(a10));
            byteArrayOutputStream.write(a10);
            byte[] a11 = ci.a(e());
            if (a11 != null && a11.length > 0) {
                byteArrayOutputStream.write(a(a11));
                byteArrayOutputStream.write(a11);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] a12 = ci.a(j());
            if (a12 != null && a12.length > 0) {
                byteArrayOutputStream.write(a(a12));
                byteArrayOutputStream.write(a12);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                dc.a(th, "bre", "gpd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    dc.a(th2, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    dc.a(th3, "bre", "gred");
                }
            }
        }
    }

    private static byte[] B() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{0});
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                dc.a(th, "bre", "grrd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    dc.a(th2, "bre", "grrd");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    dc.a(th3, "bre", "grrd");
                }
            }
        }
    }

    private byte[] C() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] c4 = c();
            if (c4 != null && c4.length != 0) {
                byteArrayOutputStream.write(new byte[]{1});
                byte[] a10 = bz.a(c4);
                byteArrayOutputStream.write(a(a10));
                byteArrayOutputStream.write(a10);
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                dc.a(th, "bre", "gred");
            }
            return byteArray;
        } catch (Throwable th2) {
            try {
                dc.a(th2, "bre", "gred");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    dc.a(th3, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    dc.a(th4, "bre", "gred");
                }
            }
        }
    }

    private static byte[] a(byte[] bArr) {
        return ci.a(bArr.length);
    }

    private static byte[] z() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(ci.a("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                dc.a(th, "bre", "gbh");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th2) {
                    dc.a(th2, "bre", "gbh");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    dc.a(th3, "bre", "gbh");
                }
            }
        }
    }

    public abstract byte[] c();

    public String e() {
        return "2.1";
    }

    @Override // com.amap.api.col.s.dz
    public final Map<String, String> f() {
        String f10 = bw.f(this.f7747a);
        String a10 = bz.a();
        String a11 = bz.a(this.f7747a, a10, "key=".concat(String.valueOf(f10)));
        HashMap hashMap = new HashMap();
        hashMap.put("ts", a10);
        hashMap.put("key", f10);
        hashMap.put("scode", a11);
        return hashMap;
    }

    @Override // com.amap.api.col.s.dz
    public final byte[] h() {
        byte[] bArr = this.f7749c;
        if (bArr != null) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(z());
            byteArrayOutputStream.write(A());
            byteArrayOutputStream.write(B());
            byteArrayOutputStream.write(C());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.f7749c = byteArray;
            return byteArray;
        } catch (Throwable th) {
            try {
                dc.a(th, "bre", "geb");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th2) {
                    dc.a(th2, "bre", "geb");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    dc.a(th3, "bre", "geb");
                }
            }
        }
    }

    public final String j() {
        return String.format("platform=Android&sdkversion=%s&product=%s", this.f7748b.d(), this.f7748b.b());
    }
}
