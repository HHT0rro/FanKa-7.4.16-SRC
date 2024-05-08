package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ji;
import com.xiaomi.push.js;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class o6 {
    public static short a(Context context, im imVar) {
        return (short) (g.c(context, imVar.f456b, false).a() + 0 + (m.b(context) ? 4 : 0) + (m.a(context) ? 8 : 0));
    }

    public static <T extends jb<T, ?>> void b(T t2, byte[] bArr) {
        if (bArr == null) {
            throw new jg("the message byte is empty.");
        }
        new s6(new js.a(true, true, bArr.length)).a(t2, bArr);
    }

    public static <T extends jb<T, ?>> byte[] c(T t2) {
        if (t2 == null) {
            return null;
        }
        try {
            return new t6(new ji.a()).a(t2);
        } catch (jg e2) {
            fc.c.j("convertThriftObjectToBytes catch TException.", e2);
            return null;
        }
    }
}
