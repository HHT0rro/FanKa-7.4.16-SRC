package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class bn {

    /* renamed from: a, reason: collision with root package name */
    private Context f35861a;

    public bn(Context context) {
        this.f35861a = context;
    }

    public static String b(String str) {
        try {
            String str2 = new String(c.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes(), 2));
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            if (str2.length() < 16) {
                int length = str2.length();
                StringBuilder sb2 = new StringBuilder(str2);
                for (int i10 = 0; i10 < 16 - length; i10++) {
                    sb2.append("0");
                }
                str2 = sb2.toString();
            } else if (str2.length() > 16) {
                str2 = str2.substring(0, 16);
            }
            return new String(d.b(i.a(b.b(str2.substring(0, 16), str2.substring(0, 16), c.a(str.getBytes(), 2)), str2.substring(0, 16))));
        } catch (Throwable unused) {
            return null;
        }
    }

    public String a(String str, String str2) {
        try {
            return c(str, new String(c.a(str2.getBytes(), 2)));
        } catch (Exception unused) {
            return null;
        }
    }

    public String c(String str) {
        try {
            return c(str, new String(c.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes(), 2)));
        } catch (Exception unused) {
            return null;
        }
    }

    public String a(String str) {
        try {
            return b(str, new String(c.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes(), 2)));
        } catch (Exception unused) {
            return null;
        }
    }

    public String c(String str, String str2) {
        byte[] bArr;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (str2.length() < 16) {
            int length = str2.length();
            StringBuilder sb2 = new StringBuilder(str2);
            for (int i10 = 0; i10 < 16 - length; i10++) {
                sb2.append("0");
            }
            str2 = sb2.toString();
        } else if (str2.length() > 16) {
            str2 = str2.substring(0, 16);
        }
        byte[] a10 = d.a(str.getBytes());
        if (Engine.loadSuccess) {
            bArr = Engine.getInstance(this.f35861a).ac(Engine.getInstance(this.f35861a).ar(a10, str2.getBytes()), str2.substring(0, 16).getBytes());
        } else {
            try {
                bArr = b.a(str2.substring(0, 16), str2.substring(0, 16), i.b(a10, str2));
            } catch (Throwable unused) {
                bArr = null;
            }
        }
        if (bArr != null && bArr.length > 0) {
            return c.b(bArr, 2);
        }
        return null;
    }

    public String b(String str, String str2) {
        byte[] a10;
        try {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            if (str2.length() < 16) {
                int length = str2.length();
                StringBuilder sb2 = new StringBuilder(str2);
                for (int i10 = 0; i10 < 16 - length; i10++) {
                    sb2.append("0");
                }
                str2 = sb2.toString();
            } else if (str2.length() > 16) {
                str2 = str2.substring(0, 16);
            }
            byte[] a11 = c.a(str.getBytes(), 2);
            if (Engine.loadSuccess) {
                a10 = Engine.getInstance(this.f35861a).dr(Engine.getInstance(this.f35861a).dc(a11, str2.substring(0, 16).getBytes()), str2.getBytes());
            } else {
                a10 = i.a(b.b(str2.substring(0, 16), str2.substring(0, 16), a11), str2.substring(0, 16));
            }
            return new String(d.b(a10));
        } catch (Exception unused) {
            return null;
        }
    }
}
