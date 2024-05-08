package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hq;
import com.xiaomi.push.ig;
import com.xiaomi.push.ih;
import com.xiaomi.push.il;
import com.xiaomi.push.im;
import com.xiaomi.push.ip;
import com.xiaomi.push.ir;
import com.xiaomi.push.is;
import com.xiaomi.push.it;
import com.xiaomi.push.iv;
import com.xiaomi.push.ix;
import com.xiaomi.push.iz;
import com.xiaomi.push.jb;
import com.xiaomi.push.o6;
import com.xiaomi.push.w5;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a0 {
    public static <T extends jb<T, ?>> im a(Context context, T t2, hq hqVar) {
        return b(context, t2, hqVar, !hqVar.equals(hq.Registration), context.getPackageName(), o0.c(context).d());
    }

    public static <T extends jb<T, ?>> im b(Context context, T t2, hq hqVar, boolean z10, String str, String str2) {
        String str3;
        byte[] c4 = o6.c(t2);
        if (c4 != null) {
            im imVar = new im();
            if (z10) {
                String t10 = o0.c(context).t();
                if (TextUtils.isEmpty(t10)) {
                    str3 = "regSecret is empty, return null";
                } else {
                    try {
                        c4 = w5.c(com.xiaomi.push.m0.b(t10), c4);
                    } catch (Exception unused) {
                        fc.c.n("encryption error. ");
                    }
                }
            }
            Cif cif = new Cif();
            cif.f377a = 5L;
            cif.f378a = "fakeid";
            imVar.a(cif);
            imVar.a(ByteBuffer.wrap(c4));
            imVar.a(hqVar);
            imVar.b(true);
            imVar.b(str);
            imVar.a(z10);
            imVar.a(str2);
            return imVar;
        }
        str3 = "invoke convertThriftObjectToBytes method, return null.";
        fc.c.i(str3);
        return null;
    }

    public static jb c(Context context, im imVar) {
        byte[] m3008a;
        if (imVar.m3010b()) {
            try {
                m3008a = w5.b(com.xiaomi.push.m0.b(o0.c(context).t()), imVar.m3008a());
            } catch (Exception e2) {
                throw new t("the aes decrypt failed.", e2);
            }
        } else {
            m3008a = imVar.m3008a();
        }
        jb d10 = d(imVar.a(), imVar.f457b);
        if (d10 != null) {
            o6.b(d10, m3008a);
        }
        return d10;
    }

    public static jb d(hq hqVar, boolean z10) {
        switch (b0.f46969a[hqVar.ordinal()]) {
            case 1:
                return new ir();
            case 2:
                return new ix();
            case 3:
                return new iv();
            case 4:
                return new iz();
            case 5:
                return new it();
            case 6:
                return new ig();
            case 7:
                return new il();
            case 8:
                return new is();
            case 9:
                if (z10) {
                    return new ip();
                }
                ih ihVar = new ih();
                ihVar.a(true);
                return ihVar;
            case 10:
                return new il();
            default:
                return null;
        }
    }
}
