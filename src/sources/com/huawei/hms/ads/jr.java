package com.huawei.hms.ads;

import java.util.concurrent.Callable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class jr extends kc {
    public jr(fr frVar, mb mbVar) {
        super(frVar, mbVar);
    }

    @Override // com.huawei.hms.ads.kc
    public void V() {
        long longValue = ((Long) com.huawei.openalliance.ad.utils.aw.Code(new Callable<Long>() { // from class: com.huawei.hms.ads.jr.1
            @Override // java.util.concurrent.Callable
            /* renamed from: Code, reason: merged with bridge method [inline-methods] */
            public Long call() {
                return Long.valueOf(jr.this.Code.b());
            }
        }, 300L)).longValue();
        int intValue = ((Integer) com.huawei.openalliance.ad.utils.aw.Code(new Callable<Integer>() { // from class: com.huawei.hms.ads.jr.2
            @Override // java.util.concurrent.Callable
            /* renamed from: Code, reason: merged with bridge method [inline-methods] */
            public Integer call() {
                return Integer.valueOf(jr.this.Code.a());
            }
        }, 2000)).intValue();
        V(longValue);
        Code(intValue);
    }
}
