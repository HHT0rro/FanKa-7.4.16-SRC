package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.push.n;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class f3 extends n.a {

    /* renamed from: b, reason: collision with root package name */
    public Context f47238b;

    /* renamed from: c, reason: collision with root package name */
    public SharedPreferences f47239c;

    /* renamed from: d, reason: collision with root package name */
    public kc.j f47240d;

    public f3(Context context) {
        this.f47238b = context;
        this.f47239c = context.getSharedPreferences("mipush_extra", 0);
        this.f47240d = kc.j.d(context);
    }

    @Override // com.xiaomi.push.n.a
    public int a() {
        return 1;
    }

    public final List<hy> b(File file) {
        RandomAccessFile randomAccessFile;
        FileInputStream fileInputStream;
        l2 a10 = m2.b().a();
        String a11 = a10 == null ? "" : a10.a();
        FileLock fileLock = null;
        if (TextUtils.isEmpty(a11)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        synchronized (r2.f48127a) {
            try {
                File file2 = new File(this.f47238b.getExternalFilesDir(null), "push_cdata.lock");
                s7.g(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    FileLock lock = randomAccessFile.getChannel().lock();
                    try {
                        fileInputStream = new FileInputStream(file);
                        while (fileInputStream.read(bArr) == 4) {
                            try {
                                int a12 = f.a(bArr);
                                byte[] bArr2 = new byte[a12];
                                if (fileInputStream.read(bArr2) != a12) {
                                    break;
                                }
                                byte[] c4 = q2.c(a11, bArr2);
                                if (c4 != null && c4.length != 0) {
                                    hy hyVar = new hy();
                                    o6.b(hyVar, c4);
                                    arrayList.add(hyVar);
                                    d(hyVar);
                                }
                            } catch (Exception unused) {
                                fileLock = lock;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused2) {
                                    }
                                }
                                s7.b(fileInputStream);
                                s7.b(randomAccessFile);
                                return arrayList;
                            } catch (Throwable th) {
                                th = th;
                                fileLock = lock;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused3) {
                                    }
                                }
                                s7.b(fileInputStream);
                                s7.b(randomAccessFile);
                                throw th;
                            }
                        }
                        if (lock != null && lock.isValid()) {
                            try {
                                lock.release();
                            } catch (IOException unused4) {
                            }
                        }
                        s7.b(fileInputStream);
                    } catch (Exception unused5) {
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = null;
                    }
                } catch (Exception unused6) {
                    fileInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                }
            } catch (Exception unused7) {
                randomAccessFile = null;
                fileInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                randomAccessFile = null;
                fileInputStream = null;
            }
            s7.b(randomAccessFile);
        }
        return arrayList;
    }

    public final void c() {
        SharedPreferences.Editor edit = this.f47239c.edit();
        edit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    public final void d(hy hyVar) {
        if (hyVar.f320a != hs.AppInstallList || hyVar.f321a.startsWith("same_")) {
            return;
        }
        SharedPreferences.Editor edit = this.f47239c.edit();
        edit.putLong("dc_job_result_time_4", hyVar.f319a);
        edit.putString("dc_job_result_4", p0.b(hyVar.f321a));
        edit.commit();
    }

    public final boolean e() {
        if (j0.r(this.f47238b)) {
            return false;
        }
        if (!j0.t(this.f47238b) || g()) {
            return (j0.u(this.f47238b) && !f()) || j0.v(this.f47238b);
        }
        return true;
    }

    public final boolean f() {
        if (!this.f47240d.i(hv.Upload3GSwitch.a(), true)) {
            return false;
        }
        return Math.abs((System.currentTimeMillis() / 1000) - this.f47239c.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(RemoteMessageConst.DEFAULT_TTL, this.f47240d.a(hv.Upload3GFrequency.a(), 432000)));
    }

    public final boolean g() {
        if (!this.f47240d.i(hv.Upload4GSwitch.a(), true)) {
            return false;
        }
        return Math.abs((System.currentTimeMillis() / 1000) - this.f47239c.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(RemoteMessageConst.DEFAULT_TTL, this.f47240d.a(hv.Upload4GFrequency.a(), 259200)));
    }

    @Override // java.lang.Runnable
    public void run() {
        File file = new File(this.f47238b.getExternalFilesDir(null), "push_cdata.data");
        if (!j0.q(this.f47238b)) {
            if (file.length() > 1863680) {
                file.delete();
                return;
            }
            return;
        }
        if (!e() && file.exists()) {
            List<hy> b4 = b(file);
            if (!h.a(b4)) {
                int size = b4.size();
                if (size > 4000) {
                    b4 = b4.subList(size - 4000, size);
                }
                ij ijVar = new ij();
                ijVar.a(b4);
                byte[] h10 = s7.h(o6.c(ijVar));
                ip ipVar = new ip("-1", false);
                ipVar.c(ia.DataCollection.f329a);
                ipVar.a(h10);
                l2 a10 = m2.b().a();
                if (a10 != null) {
                    a10.a(ipVar, hq.Notification, null);
                }
                c();
            }
            file.delete();
        }
    }
}
