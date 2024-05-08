package com.xiaomi.push;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class d3 extends a3 {
    public d3(Context context, int i10) {
        super(context, i10);
    }

    @Override // com.xiaomi.push.n.a
    public int a() {
        return 23;
    }

    @Override // com.xiaomi.push.a3
    public hs b() {
        return hs.Storage;
    }

    @Override // com.xiaomi.push.a3
    public String c() {
        return "ram:" + n6.o() + ",rom:" + n6.u() + "|ramOriginal:" + n6.y() + ",romOriginal:" + n6.B();
    }
}
