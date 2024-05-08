package com.alibaba.security.realidentity.build;

import android.os.Environment;
import com.alibaba.security.realidentity.oss.ClientException;
import com.alibaba.security.realidentity.oss.ServiceException;
import com.alibaba.security.realidentity.oss.common.utils.OSSUtils;
import com.alibaba.security.realidentity.oss.model.OSSRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: ExtensionRequestOperation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class dc {

    /* renamed from: b, reason: collision with root package name */
    private static ExecutorService f3425b = Executors.newFixedThreadPool(5, new ThreadFactory() { // from class: com.alibaba.security.realidentity.build.dc.1
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "oss-android-extensionapi-thread");
        }
    });

    /* renamed from: a, reason: collision with root package name */
    public de f3426a;

    public dc(de deVar) {
        this.f3426a = deVar;
    }

    public final boolean a(String str, String str2) throws ClientException, ServiceException {
        try {
            this.f3426a.a(new fb(str, str2), (bx<fb, fc>) null).b();
            return true;
        } catch (ServiceException e2) {
            if (e2.getStatusCode() == 404) {
                return false;
            }
            throw e2;
        }
    }

    public final dg<gl> b(gk gkVar, bx<gk, gl> bxVar) {
        a((OSSRequest) gkVar);
        de deVar = this.f3426a;
        gr grVar = new gr(deVar.f3434a, gkVar, deVar.f3435b);
        return dg.a(f3425b.submit(new Cdo(gkVar, bxVar, grVar, this.f3426a)), grVar);
    }

    private void a(gk gkVar) throws IOException {
        a((OSSRequest) gkVar);
        String c4 = gkVar.c();
        if (OSSUtils.a(gkVar.f3740m)) {
            return;
        }
        String c10 = cp.c((cp.d(cp.a(c4)) + gkVar.a() + gkVar.b() + String.valueOf(gkVar.f())).getBytes());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(gkVar.f3740m);
        sb2.append("/");
        sb2.append(c10);
        File file = new File(sb2.toString());
        if (file.exists()) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            cd.b("[initUploadId] - Found record file, uploadid: ".concat(String.valueOf(readLine)));
            if (gkVar.f4050l == OSSRequest.CRC64Config.YES) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(Environment.getExternalStorageDirectory().getPath());
                String str = File.separator;
                sb3.append(str);
                sb3.append(cb.f3268n);
                sb3.append(str);
                sb3.append(readLine);
                File file2 = new File(sb3.toString());
                if (file2.exists()) {
                    file2.delete();
                }
            }
            this.f3426a.a(new dp(gkVar.a(), gkVar.b(), readLine), (bx<dp, dq>) null);
        }
        file.delete();
    }

    public final dg<gl> a(gk gkVar, bx<gk, gl> bxVar) {
        a((OSSRequest) gkVar);
        de deVar = this.f3426a;
        gr grVar = new gr(deVar.f3434a, gkVar, deVar.f3435b);
        return dg.a(f3425b.submit(new dn(gkVar, bxVar, grVar, this.f3426a)), grVar);
    }

    public final dg<dv> a(fq fqVar, bx<fq, dv> bxVar) {
        a(fqVar);
        de deVar = this.f3426a;
        gr grVar = new gr(deVar.f3434a, fqVar, deVar.f3435b);
        return dg.a(f3425b.submit(new df(this.f3426a, fqVar, bxVar, grVar)), grVar);
    }

    public final void a(OSSRequest oSSRequest) {
        Enum r02 = oSSRequest.f4050l;
        if (r02 == OSSRequest.CRC64Config.NULL) {
            r02 = this.f3426a.f3437d.f3215k ? OSSRequest.CRC64Config.YES : OSSRequest.CRC64Config.NO;
        }
        oSSRequest.f4050l = r02;
    }
}
