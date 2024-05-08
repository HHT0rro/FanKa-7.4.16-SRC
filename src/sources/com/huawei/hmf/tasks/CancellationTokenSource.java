package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.c;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CancellationTokenSource {
    private c impl = new c();

    public void cancel() {
        c cVar = this.impl;
        if (cVar.f28864c) {
            return;
        }
        synchronized (cVar.f28863b) {
            cVar.f28864c = true;
            Iterator<Runnable> iterator2 = cVar.f28862a.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().run();
            }
        }
    }

    public CancellationToken getToken() {
        return this.impl;
    }
}
