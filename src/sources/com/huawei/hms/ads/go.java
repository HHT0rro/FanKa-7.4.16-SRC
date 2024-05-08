package com.huawei.hms.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class go extends gj {
    private static final String I = "HiAdLog";
    private static final int V = 60;
    private final Executor B = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.huawei.openalliance.ad.utils.g("FileLog"));
    private final gq Z;

    public go(gq gqVar) {
        this.Z = gqVar;
    }

    @Override // com.huawei.hms.ads.gq
    public gq Code(final String str, final String str2) {
        this.B.execute(new Runnable() { // from class: com.huawei.hms.ads.go.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    go.this.Z.Code(str, str2);
                } catch (Throwable th) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("init err: ");
                    sb2.append(th.getClass().getSimpleName());
                }
            }
        });
        gq gqVar = this.Code;
        if (gqVar != null) {
            gqVar.Code(str, str2);
        }
        return this;
    }

    @Override // com.huawei.hms.ads.gq
    public void Code(final gs gsVar, final int i10, final String str) {
        this.B.execute(new Runnable() { // from class: com.huawei.hms.ads.go.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    go.this.Z.Code(gsVar, i10, str);
                } catch (Throwable th) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("log err: ");
                    sb2.append(th.getClass().getSimpleName());
                }
            }
        });
        gq gqVar = this.Code;
        if (gqVar != null) {
            gqVar.Code(gsVar, i10, str);
        }
    }
}
