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

/* compiled from: SequenceUploadTask.java */
/* renamed from: com.alibaba.security.realidentity.build.do, reason: invalid class name */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class Cdo extends da<gk, gl> {
    private List<Integer> A;
    private long B;
    private cw C;
    private File D;

    /* renamed from: z, reason: collision with root package name */
    private File f3485z;

    public Cdo(gk gkVar, bx<gk, gl> bxVar, gr grVar, de deVar) {
        super(deVar, gkVar, bxVar, grVar);
        this.A = new ArrayList();
        this.C = cw.a(this.f3402j.f3759d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.alibaba.security.realidentity.build.da
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public gl c() throws IOException, ClientException, ServiceException, InterruptedException {
        long j10 = this.f3410r;
        d();
        int[] iArr = this.f3415w;
        int i10 = iArr[0];
        int i11 = iArr[1];
        if (this.f3399g.size() > 0 && this.A.size() > 0) {
            long j11 = this.f3410r;
            if (j11 > this.f3407o) {
                throw new ClientException("The uploading file is inconsistent with before");
            }
            if (this.B == i10) {
                if (!TextUtils.isEmpty(this.C.a(this.f3406n))) {
                    j11 = Long.valueOf(this.C.a(this.f3406n)).longValue();
                }
                by<Request> byVar = this.f3414v;
                if (byVar != 0) {
                    byVar.a(j11, this.f3407o);
                }
                this.C.b(this.f3406n);
            } else {
                throw new ClientException("The part size setting is inconsistent with before");
            }
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (this.A.size() == 0 || !this.A.contains(Integer.valueOf(i12 + 1))) {
                if (i12 == i11 - 1) {
                    i10 = (int) (this.f3407o - j10);
                }
                cd.b("upload part readByte : ".concat(String.valueOf(i10)));
                j10 += i10;
                a(i12, i10, i11);
                if (this.f3403k != null) {
                    break;
                }
            }
        }
        i();
        dv g3 = g();
        gl glVar = g3 != null ? new gl(g3) : null;
        File file = this.f3485z;
        if (file != null) {
            file.delete();
        }
        File file2 = this.D;
        if (file2 != null) {
            file2.delete();
        }
        return glVar;
    }

    /* JADX WARN: Not initialized variable reg: 0, insn: 0x0121: MOVE (r9 I:??[OBJECT, ARRAY]) = (r0 I:??[OBJECT, ARRAY]), block:B:62:0x0121 */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.alibaba.security.realidentity.build.da
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(int r7, int r8, int r9) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.realidentity.build.Cdo.a(int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0147 A[Catch: ClientException -> 0x01a0, ServiceException -> 0x01a2, TryCatch #5 {ClientException -> 0x01a0, ServiceException -> 0x01a2, blocks: (B:28:0x0134, B:29:0x0141, B:31:0x0147, B:33:0x015c, B:35:0x0162, B:37:0x016e, B:38:0x0180, B:40:0x0199), top: B:27:0x0134 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ed  */
    @Override // com.alibaba.security.realidentity.build.da
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b() throws java.io.IOException, com.alibaba.security.realidentity.oss.ClientException, com.alibaba.security.realidentity.oss.ServiceException {
        /*
            Method dump skipped, instructions count: 575
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.realidentity.build.Cdo.b():void");
    }

    @Override // com.alibaba.security.realidentity.build.da
    public final void f() throws Exception {
        if (!this.f3402j.f3758c.f3754a || this.C.c(this.f3406n)) {
            return;
        }
        this.C.a(this.f3406n, String.valueOf(this.f3410r));
        a(this.f3410r, this.f3407o);
    }

    @Override // com.alibaba.security.realidentity.build.da
    public final void i() throws IOException, ServiceException, ClientException {
        if (this.f3402j.f3758c.f3754a) {
            if (((gk) this.f3412t).f3739j.booleanValue()) {
                a();
                File file = this.f3485z;
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
                            this.D = file2;
                            if (!file2.exists()) {
                                this.D.createNewFile();
                            }
                            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(this.D));
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
    public final void a() {
        if (this.f3406n != null) {
            this.f3401i.a(new dp(((gk) this.f3412t).a(), ((gk) this.f3412t).b(), this.f3406n), (bx<dp, dq>) null).c();
        }
    }

    @Override // com.alibaba.security.realidentity.build.da
    public final void a(Exception exc) {
        if (this.f3403k == null || !exc.getMessage().equals(this.f3403k.getMessage())) {
            this.f3403k = exc;
        }
        cd.a(exc);
        if (!this.f3402j.f3758c.f3754a || this.f3404l) {
            return;
        }
        this.f3404l = true;
    }
}
