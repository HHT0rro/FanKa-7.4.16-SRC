package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.build.dv;
import com.alibaba.security.realidentity.build.fq;
import com.alibaba.security.realidentity.oss.ClientException;
import com.alibaba.security.realidentity.oss.ServiceException;
import com.alibaba.security.realidentity.oss.TaskCancelException;
import com.alibaba.security.realidentity.oss.model.OSSRequest;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: BaseMultipartUploadTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class da<Request extends fq, Result extends dv> implements Callable<Result> {

    /* renamed from: a, reason: collision with root package name */
    public final int f3393a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3394b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3395c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3396d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3397e;

    /* renamed from: f, reason: collision with root package name */
    public ThreadPoolExecutor f3398f;

    /* renamed from: g, reason: collision with root package name */
    public List<fv> f3399g;

    /* renamed from: h, reason: collision with root package name */
    public Object f3400h;

    /* renamed from: i, reason: collision with root package name */
    public de f3401i;

    /* renamed from: j, reason: collision with root package name */
    public gr f3402j;

    /* renamed from: k, reason: collision with root package name */
    public Exception f3403k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3404l;

    /* renamed from: m, reason: collision with root package name */
    public File f3405m;

    /* renamed from: n, reason: collision with root package name */
    public String f3406n;

    /* renamed from: o, reason: collision with root package name */
    public long f3407o;

    /* renamed from: p, reason: collision with root package name */
    public int f3408p;

    /* renamed from: q, reason: collision with root package name */
    public int f3409q;

    /* renamed from: r, reason: collision with root package name */
    public long f3410r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f3411s;

    /* renamed from: t, reason: collision with root package name */
    public Request f3412t;

    /* renamed from: u, reason: collision with root package name */
    public bx<Request, Result> f3413u;

    /* renamed from: v, reason: collision with root package name */
    public by<Request> f3414v;

    /* renamed from: w, reason: collision with root package name */
    public int[] f3415w;

    /* renamed from: x, reason: collision with root package name */
    public String f3416x;

    /* renamed from: y, reason: collision with root package name */
    public long f3417y;

    public da(de deVar, Request request, bx<Request, Result> bxVar, gr grVar) {
        int availableProcessors = Runtime.getRuntime().availableProcessors() * 2;
        this.f3393a = availableProcessors;
        int i10 = availableProcessors < 5 ? availableProcessors : 5;
        this.f3394b = i10;
        this.f3395c = availableProcessors;
        this.f3396d = 3000;
        this.f3397e = 5000;
        this.f3398f = new ThreadPoolExecutor(i10, availableProcessors, com.huawei.openalliance.ad.ipc.c.Code, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(5000), new ThreadFactory() { // from class: com.alibaba.security.realidentity.build.da.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "oss-android-multipart-thread");
            }
        });
        this.f3399g = new ArrayList();
        this.f3400h = new Object();
        this.f3410r = 0L;
        this.f3411s = false;
        this.f3415w = new int[2];
        this.f3401i = deVar;
        this.f3412t = request;
        this.f3414v = request.e();
        this.f3413u = bxVar;
        this.f3402j = grVar;
        this.f3411s = request.f4050l == OSSRequest.CRC64Config.YES;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public Result call() throws Exception {
        ClientException clientException;
        try {
            this.f3416x = this.f3412t.c();
            this.f3410r = 0L;
            File file = new File(this.f3416x);
            this.f3405m = file;
            long length = file.length();
            this.f3407o = length;
            if (length != 0) {
                int[] iArr = this.f3415w;
                long f10 = this.f3412t.f();
                cd.b("[checkPartSize] - mFileLength : " + this.f3407o);
                cd.b("[checkPartSize] - partSize : ".concat(String.valueOf(f10)));
                long j10 = this.f3407o;
                int i10 = (int) (j10 / f10);
                if (j10 % f10 != 0) {
                    i10++;
                }
                if (i10 == 1) {
                    f10 = j10;
                } else if (i10 > 5000) {
                    f10 = j10 / 5000;
                    i10 = 5000;
                }
                int i11 = (int) f10;
                iArr[0] = i11;
                iArr[1] = i10;
                this.f3412t.a(i11);
                cd.b("[checkPartSize] - partNumber : ".concat(String.valueOf(i10)));
                cd.b("[checkPartSize] - partSize : " + i11);
                long j11 = this.f3407o % f10;
                if (j11 != 0) {
                    f10 = j11;
                }
                this.f3417y = f10;
                long f11 = this.f3412t.f();
                int i12 = this.f3415w[1];
                cd.b("[checkInitData] - partNumber : ".concat(String.valueOf(i12)));
                cd.b("[checkInitData] - partSize : ".concat(String.valueOf(f11)));
                if (i12 > 1 && f11 < cb.f3266l) {
                    throw new ClientException("Part size must be greater than or equal to 100KB!");
                }
                b();
                Result c4 = c();
                bx<Request, Result> bxVar = this.f3413u;
                if (bxVar != null) {
                    bxVar.a(this.f3412t, c4);
                }
                return c4;
            }
            throw new ClientException("file length must not be 0");
        } catch (ServiceException e2) {
            bx<Request, Result> bxVar2 = this.f3413u;
            if (bxVar2 != null) {
                bxVar2.a(this.f3412t, null, e2);
            }
            throw e2;
        } catch (Exception e10) {
            if (e10 instanceof ClientException) {
                clientException = (ClientException) e10;
            } else {
                clientException = new ClientException(e10.toString(), e10);
            }
            bx<Request, Result> bxVar3 = this.f3413u;
            if (bxVar3 != null) {
                bxVar3.a(this.f3412t, clientException, null);
            }
            throw clientException;
        }
    }

    private void l() throws ClientException {
        this.f3416x = this.f3412t.c();
        this.f3410r = 0L;
        File file = new File(this.f3416x);
        this.f3405m = file;
        long length = file.length();
        this.f3407o = length;
        if (length != 0) {
            int[] iArr = this.f3415w;
            long f10 = this.f3412t.f();
            cd.b("[checkPartSize] - mFileLength : " + this.f3407o);
            cd.b("[checkPartSize] - partSize : ".concat(String.valueOf(f10)));
            long j10 = this.f3407o;
            int i10 = (int) (j10 / f10);
            if (j10 % f10 != 0) {
                i10++;
            }
            if (i10 == 1) {
                f10 = j10;
            } else if (i10 > 5000) {
                f10 = j10 / 5000;
                i10 = 5000;
            }
            int i11 = (int) f10;
            iArr[0] = i11;
            iArr[1] = i10;
            this.f3412t.a(i11);
            cd.b("[checkPartSize] - partNumber : ".concat(String.valueOf(i10)));
            cd.b("[checkPartSize] - partSize : " + i11);
            long j11 = this.f3407o % f10;
            if (j11 != 0) {
                f10 = j11;
            }
            this.f3417y = f10;
            long f11 = this.f3412t.f();
            int i12 = this.f3415w[1];
            cd.b("[checkInitData] - partNumber : ".concat(String.valueOf(i12)));
            cd.b("[checkInitData] - partSize : ".concat(String.valueOf(f11)));
            if (i12 > 1 && f11 < cb.f3266l) {
                throw new ClientException("Part size must be greater than or equal to 100KB!");
            }
            return;
        }
        throw new ClientException("file length must not be 0");
    }

    public abstract void a();

    public void a(int i10, int i11, int i12) {
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                if (this.f3402j.f3758c.f3754a) {
                    this.f3398f.getQueue().clear();
                    return;
                }
                synchronized (this.f3400h) {
                    this.f3409q++;
                }
                e();
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(this.f3405m, com.kuaishou.weapon.p0.t.f36226k);
                try {
                    go goVar = new go(this.f3412t.a(), this.f3412t.b(), this.f3406n, i10 + 1);
                    long f10 = i10 * this.f3412t.f();
                    byte[] bArr = new byte[i11];
                    randomAccessFile2.seek(f10);
                    randomAccessFile2.readFully(bArr, 0, i11);
                    goVar.f3750e = bArr;
                    goVar.f3752g = cp.a(cp.b(bArr));
                    goVar.f4050l = this.f3412t.f4050l;
                    gp a10 = this.f3401i.a(goVar);
                    synchronized (this.f3400h) {
                        fv fvVar = new fv(goVar.f3749d, a10.f3753a);
                        long j10 = i11;
                        fvVar.f3705c = j10;
                        if (this.f3411s) {
                            fvVar.f3706d = a10.a().longValue();
                        }
                        this.f3399g.add(fvVar);
                        this.f3410r += j10;
                        f();
                        if (this.f3402j.f3758c.f3754a) {
                            if (this.f3399g.size() == this.f3409q - this.f3408p) {
                                TaskCancelException taskCancelException = new TaskCancelException("multipart cancel");
                                throw new ClientException(taskCancelException.getMessage(), taskCancelException, Boolean.TRUE);
                            }
                        } else {
                            if (this.f3399g.size() == i12 - this.f3408p) {
                                j();
                            }
                            a(this.f3410r, this.f3407o);
                        }
                    }
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e2) {
                        cd.a(e2);
                    }
                } catch (Exception e10) {
                    e = e10;
                    randomAccessFile = randomAccessFile2;
                    a(e);
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e11) {
                            cd.a(e11);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e12) {
                            cd.a(e12);
                        }
                    }
                    throw th;
                }
            } catch (Exception e13) {
                e = e13;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public abstract void a(Exception exc);

    public abstract void b() throws IOException, ClientException, ServiceException;

    public abstract Result c() throws IOException, ServiceException, ClientException, InterruptedException;

    public final void d() throws ClientException {
        if (this.f3402j.f3758c.f3754a) {
            TaskCancelException taskCancelException = new TaskCancelException("multipart cancel");
            throw new ClientException(taskCancelException.getMessage(), taskCancelException, Boolean.TRUE);
        }
    }

    public void e() throws Exception {
    }

    public void f() throws Exception {
    }

    public final dv g() throws ClientException, ServiceException {
        dv dvVar;
        if (this.f3399g.size() > 0) {
            Collections.sort(this.f3399g, new Comparator<fv>() { // from class: com.alibaba.security.realidentity.build.da.2
                private static int a(fv fvVar, fv fvVar2) {
                    int i10 = fvVar.f3703a;
                    int i11 = fvVar2.f3703a;
                    if (i10 < i11) {
                        return -1;
                    }
                    return i10 > i11 ? 1 : 0;
                }

                @Override // java.util.Comparator
                public final /* bridge */ /* synthetic */ int compare(fv fvVar, fv fvVar2) {
                    int i10 = fvVar.f3703a;
                    int i11 = fvVar2.f3703a;
                    if (i10 < i11) {
                        return -1;
                    }
                    return i10 > i11 ? 1 : 0;
                }
            });
            du duVar = new du(this.f3412t.a(), this.f3412t.b(), this.f3406n, this.f3399g);
            duVar.f3516g = this.f3412t.d();
            if (this.f3412t.g() != null) {
                duVar.f3514e = this.f3412t.g();
            }
            if (this.f3412t.h() != null) {
                duVar.f3515f = this.f3412t.h();
            }
            duVar.f4050l = this.f3412t.f4050l;
            dvVar = this.f3401i.a(duVar);
        } else {
            dvVar = null;
        }
        this.f3410r = 0L;
        return dvVar;
    }

    public final void h() {
        ThreadPoolExecutor threadPoolExecutor = this.f3398f;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.getQueue().clear();
            this.f3398f.shutdown();
        }
    }

    public void i() throws IOException, ServiceException, ClientException {
        if (this.f3403k != null) {
            h();
            Exception exc = this.f3403k;
            if (!(exc instanceof IOException)) {
                if (!(exc instanceof ServiceException)) {
                    if (exc instanceof ClientException) {
                        throw ((ClientException) exc);
                    }
                    throw new ClientException(this.f3403k.getMessage(), this.f3403k);
                }
                throw ((ServiceException) exc);
            }
            throw ((IOException) exc);
        }
    }

    public final void j() {
        this.f3400h.notify();
        this.f3408p = 0;
    }

    public final boolean a(int i10) {
        return this.f3399g.size() != i10;
    }

    private void a(int[] iArr) {
        long f10 = this.f3412t.f();
        cd.b("[checkPartSize] - mFileLength : " + this.f3407o);
        cd.b("[checkPartSize] - partSize : ".concat(String.valueOf(f10)));
        long j10 = this.f3407o;
        int i10 = (int) (j10 / f10);
        if (j10 % f10 != 0) {
            i10++;
        }
        if (i10 == 1) {
            f10 = j10;
        } else if (i10 > 5000) {
            f10 = j10 / 5000;
            i10 = 5000;
        }
        int i11 = (int) f10;
        iArr[0] = i11;
        iArr[1] = i10;
        this.f3412t.a(i11);
        cd.b("[checkPartSize] - partNumber : ".concat(String.valueOf(i10)));
        cd.b("[checkPartSize] - partSize : " + i11);
        long j11 = this.f3407o % f10;
        if (j11 != 0) {
            f10 = j11;
        }
        this.f3417y = f10;
    }

    public final void a(long j10, long j11) {
        by<Request> byVar = this.f3414v;
        if (byVar != null) {
            byVar.a(j10, j11);
        }
    }
}
