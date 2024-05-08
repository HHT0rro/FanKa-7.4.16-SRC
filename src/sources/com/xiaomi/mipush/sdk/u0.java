package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class u0 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f47080b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f47081c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f47082d;

    public u0(String str, Context context, d dVar) {
        this.f47080b = str;
        this.f47081c = context;
        this.f47082d = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        if (TextUtils.isEmpty(this.f47080b)) {
            return;
        }
        String[] split = this.f47080b.split("~");
        int length = split.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                str = "";
                break;
            }
            String str2 = split[i10];
            if (!TextUtils.isEmpty(str2) && str2.startsWith("token:")) {
                str = str2.substring(str2.indexOf(com.huawei.openalliance.ad.constant.u.bD) + 1);
                break;
            }
            i10++;
        }
        if (TextUtils.isEmpty(str)) {
            fc.c.i("ASSEMBLE_PUSH : receive incorrect token");
            return;
        }
        fc.c.i("ASSEMBLE_PUSH : receive correct token");
        t0.j(this.f47081c, this.f47082d, str);
        t0.d(this.f47081c);
    }
}
