package com.alibaba.security.realidentity.build;

import android.text.TextUtils;
import com.alibaba.security.realidentity.oss.ClientException;
import com.alibaba.security.realidentity.oss.ServiceException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: ResumableUploadTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class dn extends da<gk, gl> {
    private List<Integer> A;
    private cw B;
    private File C;

    /* renamed from: z, reason: collision with root package name */
    private File f3480z;

    public dn(gk gkVar, bx<gk, gl> bxVar, gr grVar, de deVar) {
        super(deVar, gkVar, bxVar, grVar);
        this.A = new ArrayList();
        this.B = cw.a(this.f3402j.f3759d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.alibaba.security.realidentity.build.da
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public gl c() throws IOException, ClientException, ServiceException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor;
        long j10 = this.f3410r;
        d();
        int[] iArr = this.f3415w;
        final int i10 = iArr[0];
        final int i11 = iArr[1];
        if (this.f3399g.size() > 0 && this.A.size() > 0) {
            long j11 = this.f3410r;
            if (j11 <= this.f3407o) {
                if (!TextUtils.isEmpty(this.B.a(this.f3406n))) {
                    j11 = Long.valueOf(this.B.a(this.f3406n)).longValue();
                }
                by<Request> byVar = this.f3414v;
                if (byVar != 0) {
                    byVar.a(j11, this.f3407o);
                }
                this.B.b(this.f3406n);
            } else {
                throw new ClientException("The uploading file is inconsistent with before");
            }
        }
        this.f3409q = this.f3399g.size();
        for (final int i12 = 0; i12 < i11; i12++) {
            if ((this.A.size() == 0 || !this.A.contains(Integer.valueOf(i12 + 1))) && (threadPoolExecutor = this.f3398f) != null) {
                if (i12 == i11 - 1) {
                    i10 = (int) (this.f3407o - j10);
                }
                j10 += i10;
                threadPoolExecutor.execute(new Runnable() { // from class: com.alibaba.security.realidentity.build.dn.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        dn.this.a(i12, i10, i11);
                    }
                });
            }
        }
        if (a(i11)) {
            synchronized (this.f3400h) {
                this.f3400h.wait();
            }
        }
        i();
        dv g3 = g();
        gl glVar = g3 != null ? new gl(g3) : null;
        File file = this.f3480z;
        if (file != null) {
            file.delete();
        }
        File file2 = this.C;
        if (file2 != null) {
            file2.delete();
        }
        h();
        return glVar;
    }

    @Override // com.alibaba.security.realidentity.build.da
    public final void a() {
        if (this.f3406n != null) {
            this.f3401i.a(new dp(((gk) this.f3412t).a(), ((gk) this.f3412t).b(), this.f3406n), (bx<dp, dq>) null).c();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0176 A[Catch: ServiceException -> 0x028b, ClientException -> 0x028f, TRY_LEAVE, TryCatch #1 {ClientException -> 0x028f, blocks: (B:28:0x015c, B:30:0x0166, B:31:0x0170, B:33:0x0176, B:35:0x018b, B:37:0x0191, B:39:0x019d, B:40:0x01af, B:47:0x01f6, B:51:0x0234, B:55:0x023c, B:56:0x025d, B:58:0x025e, B:61:0x0203, B:62:0x0224), top: B:27:0x015c }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02a6 A[LOOP:0: B:23:0x0137->B:70:0x02a6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02ad A[EDGE_INSN: B:71:0x02ad->B:96:0x02ad BREAK  A[LOOP:0: B:23:0x0137->B:70:0x02a6], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02ac A[SYNTHETIC] */
    @Override // com.alibaba.security.realidentity.build.da
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b() throws java.io.IOException, com.alibaba.security.realidentity.oss.ClientException, com.alibaba.security.realidentity.oss.ServiceException {
        /*
            Method dump skipped, instructions count: 821
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.realidentity.build.dn.b():void");
    }

    @Override // com.alibaba.security.realidentity.build.da
    public final void f() throws Exception {
        if (!this.f3402j.f3758c.f3754a || this.B.c(this.f3406n)) {
            return;
        }
        this.B.a(this.f3406n, String.valueOf(this.f3410r));
        a(this.f3410r, this.f3407o);
    }

    @Override // com.alibaba.security.realidentity.build.da
    public final void i() throws IOException, ServiceException, ClientException {
        if (this.f3402j.f3758c.f3754a) {
            if (((gk) this.f3412t).f3739j.booleanValue()) {
                a();
                File file = this.f3480z;
                if (file != null) {
                    file.delete();
                }
            } else {
                List<fv> list = this.f3399g;
                if (list != null && list.size() > 0 && this.f3411s && ((gk) this.f3412t).f3740m != null) {
                    HashMap hashMap = new HashMap();
                    for (fv fvVar : this.f3399g) {
                        hashMap.put(Integer.valueOf(fvVar.f3703a), Long.valueOf(fvVar.f3706d));
                    }
                    ObjectOutputStream objectOutputStream = null;
                    try {
                        try {
                            File file2 = new File(((gk) this.f3412t).f3740m + File.separator + this.f3406n);
                            this.C = file2;
                            if (!file2.exists()) {
                                this.C.createNewFile();
                            }
                            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(this.C));
                            try {
                                objectOutputStream2.writeObject(hashMap);
                                objectOutputStream2.close();
                            } catch (IOException e2) {
                                e = e2;
                                objectOutputStream = objectOutputStream2;
                                cd.a(e);
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                super.i();
                            } catch (Throwable th) {
                                th = th;
                                objectOutputStream = objectOutputStream2;
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (IOException e10) {
                        e = e10;
                    }
                }
            }
        }
        super.i();
    }

    @Override // com.alibaba.security.realidentity.build.da
    public final void a(Exception exc) {
        synchronized (this.f3400h) {
            this.f3408p++;
            this.f3403k = exc;
            cd.a(exc);
            if (this.f3402j.f3758c.f3754a && !this.f3404l) {
                this.f3404l = true;
                this.f3400h.notify();
            }
            if (this.f3399g.size() == this.f3409q - this.f3408p) {
                j();
            }
        }
    }
}
