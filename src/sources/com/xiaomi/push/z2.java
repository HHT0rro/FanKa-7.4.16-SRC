package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class z2 extends a3 {

    /* renamed from: d, reason: collision with root package name */
    public static String f48538d = "";

    /* renamed from: e, reason: collision with root package name */
    public static String f48539e = "";

    public z2(Context context, int i10) {
        super(context, i10);
    }

    @Override // com.xiaomi.push.n.a
    public int a() {
        return 12;
    }

    @Override // com.xiaomi.push.a3
    public hs b() {
        return hs.BroadcastAction;
    }

    @Override // com.xiaomi.push.a3
    public String c() {
        String str;
        if (TextUtils.isEmpty(f48538d)) {
            str = "";
        } else {
            str = "" + k(r2.f48128b, f48538d);
            f48538d = "";
        }
        if (TextUtils.isEmpty(f48539e)) {
            return str;
        }
        String str2 = str + k(r2.f48129c, f48539e);
        f48539e = "";
        return str2;
    }

    public final String k(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        String[] split = str2.split(",");
        if (split.length <= 10) {
            return str2;
        }
        int length = split.length;
        while (true) {
            length--;
            if (length < split.length - 10) {
                return str;
            }
            str = str + split[length];
        }
    }
}
