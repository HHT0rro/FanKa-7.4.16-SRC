package com.amap.api.col.p0003l;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BinaryRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class hx extends fp {

    /* renamed from: a, reason: collision with root package name */
    public Context f6315a;

    /* renamed from: b, reason: collision with root package name */
    public fu f6316b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f6317c;

    public hx(Context context, fu fuVar) {
        if (context != null) {
            this.f6315a = context.getApplicationContext();
        }
        this.f6316b = fuVar;
        setBinary(true);
    }

    public static byte[] a(byte[] bArr) {
        return fv.a(bArr.length);
    }

    private static byte[] i() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(fv.a("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                gv.a(th, "bre", "gbh");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th2) {
                    gv.a(th2, "bre", "gbh");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    gv.a(th3, "bre", "gbh");
                }
            }
        }
    }

    private byte[] j() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            if (f()) {
                Context context = this.f6315a;
                boolean h10 = h();
                fu fuVar = this.f6316b;
                byte[] a10 = fl.a(context, h10, fuVar != null && "navi".equals(fuVar.a()));
                byteArrayOutputStream.write(a(a10));
                byteArrayOutputStream.write(a10);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] a11 = fv.a(e());
            if (a11 != null && a11.length > 0) {
                byteArrayOutputStream.write(a(a11));
                byteArrayOutputStream.write(a11);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] a12 = fv.a(g());
            if (a12 != null && a12.length > 0) {
                byteArrayOutputStream.write(a(a12));
                byteArrayOutputStream.write(a12);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                gv.a(th, "bre", "gpd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    gv.a(th2, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    gv.a(th3, "bre", "gred");
                }
            }
        }
    }

    private byte[] k() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] c4 = c();
            if (c4 != null && c4.length != 0) {
                byteArrayOutputStream.write(new byte[]{1});
                byteArrayOutputStream.write(a(c4));
                byteArrayOutputStream.write(c4);
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                gv.a(th, "bre", "grrd");
            }
            return byteArray;
        } catch (Throwable th2) {
            try {
                gv.a(th2, "bre", "grrd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    gv.a(th3, "bre", "grrd");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    gv.a(th4, "bre", "grrd");
                }
            }
        }
    }

    private byte[] l() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] d10 = d();
            if (d10 != null && d10.length != 0) {
                byteArrayOutputStream.write(new byte[]{1});
                byte[] a10 = fl.a(d10);
                byteArrayOutputStream.write(a(a10));
                byteArrayOutputStream.write(a10);
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                gv.a(th, "bre", "gred");
            }
            return byteArray;
        } catch (Throwable th2) {
            try {
                gv.a(th2, "bre", "gred");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    gv.a(th3, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    gv.a(th4, "bre", "gred");
                }
            }
        }
    }

    public abstract byte[] c();

    public abstract byte[] d();

    public String e() {
        return "2.1";
    }

    public boolean f() {
        return true;
    }

    public String g() {
        return String.format("platform=Android&sdkversion=%s&product=%s", this.f6316b.c(), this.f6316b.a());
    }

    @Override // com.amap.api.col.p0003l.id
    public final byte[] getEntityBytes() {
        byte[] bArr = this.f6317c;
        if (bArr != null) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(i());
            byteArrayOutputStream.write(j());
            byteArrayOutputStream.write(k());
            byteArrayOutputStream.write(l());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.f6317c = byteArray;
            return byteArray;
        } catch (Throwable th) {
            try {
                gv.a(th, "bre", "geb");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th2) {
                    gv.a(th2, "bre", "geb");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    gv.a(th3, "bre", "geb");
                }
            }
        }
    }

    @Override // com.amap.api.col.p0003l.id
    public Map<String, String> getParams() {
        String f10 = fj.f(this.f6315a);
        String a10 = fl.a();
        String a11 = fl.a(this.f6315a, a10, "key=".concat(String.valueOf(f10)));
        HashMap hashMap = new HashMap();
        hashMap.put("ts", a10);
        hashMap.put("key", f10);
        hashMap.put("scode", a11);
        return hashMap;
    }

    public boolean h() {
        return false;
    }
}
