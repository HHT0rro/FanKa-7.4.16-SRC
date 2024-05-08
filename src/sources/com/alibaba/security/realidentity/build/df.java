package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.oss.ClientException;
import com.alibaba.security.realidentity.oss.ServiceException;
import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: MultipartUploadTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class df extends da<fq, dv> {
    public df(de deVar, fq fqVar, bx<fq, dv> bxVar, gr grVar) {
        super(deVar, fqVar, bxVar, grVar);
    }

    @Override // com.alibaba.security.realidentity.build.da
    public final void a() {
        if (this.f3406n != null) {
            this.f3401i.a(new dp(this.f3412t.a(), this.f3412t.b(), this.f3406n), (bx<dp, dq>) null).c();
        }
    }

    @Override // com.alibaba.security.realidentity.build.da
    public final void b() throws ClientException, ServiceException {
        String str = this.f3401i.a(new ff(this.f3412t.a(), this.f3412t.b(), this.f3412t.d()), (bx<ff, fg>) null).b().f3604c;
        this.f3406n = str;
        this.f3412t.a(str);
    }

    @Override // com.alibaba.security.realidentity.build.da
    public final dv c() throws IOException, ServiceException, ClientException, InterruptedException {
        d();
        int[] iArr = this.f3415w;
        int i10 = iArr[0];
        final int i11 = iArr[1];
        final int i12 = i10;
        int i13 = 0;
        for (final int i14 = 0; i14 < i11; i14++) {
            i();
            ThreadPoolExecutor threadPoolExecutor = this.f3398f;
            if (threadPoolExecutor != null) {
                if (i14 == i11 - 1) {
                    i12 = (int) (this.f3407o - i13);
                }
                i13 += i12;
                threadPoolExecutor.execute(new Runnable() { // from class: com.alibaba.security.realidentity.build.df.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        df.this.a(i14, i12, i11);
                    }
                });
            }
        }
        if (a(i11)) {
            synchronized (this.f3400h) {
                this.f3400h.wait();
            }
        }
        if (this.f3403k != null) {
            a();
        }
        i();
        dv g3 = g();
        h();
        return g3;
    }

    @Override // com.alibaba.security.realidentity.build.da
    public final void e() throws Exception {
        i();
    }

    @Override // com.alibaba.security.realidentity.build.da
    public final void a(Exception exc) {
        synchronized (this.f3400h) {
            this.f3408p++;
            if (this.f3403k == null) {
                this.f3403k = exc;
                this.f3400h.notify();
            }
        }
    }
}
