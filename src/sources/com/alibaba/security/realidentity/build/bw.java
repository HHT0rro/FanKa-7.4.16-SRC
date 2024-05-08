package com.alibaba.security.realidentity.build;

import android.content.Context;
import android.os.Environment;
import com.alibaba.security.realidentity.oss.ClientException;
import com.alibaba.security.realidentity.oss.ServiceException;
import com.alibaba.security.realidentity.oss.common.utils.OSSUtils;
import com.alibaba.security.realidentity.oss.model.OSSRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OSSImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bw implements bu {

    /* renamed from: a, reason: collision with root package name */
    private URI f3217a;

    /* renamed from: b, reason: collision with root package name */
    private cj f3218b;

    /* renamed from: c, reason: collision with root package name */
    private de f3219c;

    /* renamed from: d, reason: collision with root package name */
    private dc f3220d;

    /* renamed from: e, reason: collision with root package name */
    private bt f3221e;

    public bw(Context context, String str, cj cjVar, bt btVar) {
        ce.a(context.getApplicationContext(), btVar);
        try {
            String trim = str.trim();
            URI uri = new URI(trim.startsWith("http") ? trim : "http://".concat(trim));
            this.f3217a = uri;
            if (cjVar != null) {
                Boolean bool = Boolean.FALSE;
                try {
                    bool = Boolean.valueOf(OSSUtils.d(uri.getHost()));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (this.f3217a.getScheme().equals("https") && bool.booleanValue()) {
                    throw new IllegalArgumentException("endpoint should not be format with https://ip.");
                }
                this.f3218b = cjVar;
                this.f3221e = btVar == null ? new bt() : btVar;
                this.f3219c = new de(context.getApplicationContext(), this.f3217a, cjVar, this.f3221e);
                this.f3220d = new dc(this.f3219c);
                return;
            }
            throw new IllegalArgumentException("CredentialProvider can't be null.");
        } catch (URISyntaxException unused) {
            throw new IllegalArgumentException("Endpoint must be a string like 'http://oss-cn-****.aliyuncs.com',or your cname like 'http://image.cnamedomain.com'!");
        }
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<fi> a(fh fhVar, bx<fh, fi> bxVar) {
        return this.f3219c.a(fhVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<gl> b(gk gkVar, bx<gk, gl> bxVar) {
        return this.f3220d.b(gkVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final void c(gk gkVar) throws IOException {
        dc dcVar = this.f3220d;
        dcVar.a((OSSRequest) gkVar);
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
            dcVar.f3426a.a(new dp(gkVar.a(), gkVar.b(), readLine), (bx<dp, dq>) null);
        }
        file.delete();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final fi a(fh fhVar) throws ClientException, ServiceException {
        return this.f3219c.a(fhVar, (bx<fh, fi>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final gl b(gk gkVar) throws ClientException, ServiceException {
        return this.f3220d.b(gkVar, null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<dz> a(dy dyVar, bx<dy, dz> bxVar) {
        return this.f3219c.a(dyVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final boolean b(String str, String str2) throws ClientException, ServiceException {
        return this.f3220d.a(str, str2);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dz a(dy dyVar) throws ClientException, ServiceException {
        return this.f3219c.a(dyVar, (bx<dy, dz>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<ef> a(ee eeVar, bx<ee, ef> bxVar) {
        return this.f3219c.a(eeVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final ef a(ee eeVar) throws ClientException, ServiceException {
        return this.f3219c.a(eeVar, (bx<ee, ef>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<eo> a(en enVar, bx<en, eo> bxVar) {
        return this.f3219c.a(enVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final eo a(en enVar) throws ClientException, ServiceException {
        return this.f3219c.a(enVar, (bx<en, eo>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<em> a(el elVar, bx<el, em> bxVar) {
        return this.f3219c.a(elVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final em a(el elVar) throws ClientException, ServiceException {
        return this.f3219c.a(elVar, (bx<el, em>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<gc> a(gb gbVar, bx<gb, gc> bxVar) {
        return this.f3219c.a(gbVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final gc a(gb gbVar) throws ClientException, ServiceException {
        return this.f3219c.a(gbVar, (bx<gb, gc>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final eu a(et etVar) throws ClientException, ServiceException {
        return this.f3219c.a(etVar, (bx<et, eu>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<eu> a(et etVar, bx<et, eu> bxVar) {
        return this.f3219c.a(etVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final ed a(ec ecVar) throws ClientException, ServiceException {
        return this.f3219c.a(ecVar, (bx<ec, ed>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<ed> a(ec ecVar, bx<ec, ed> bxVar) {
        return this.f3219c.a(ecVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final ga a(fz fzVar) throws ClientException, ServiceException {
        return this.f3219c.a(fzVar, (bx<fz, ga>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<ga> a(fz fzVar, bx<fz, ga> bxVar) {
        return this.f3219c.a(fzVar, bxVar);
    }

    public bw(Context context, cj cjVar, bt btVar) {
        this.f3218b = cjVar;
        this.f3221e = btVar == null ? new bt() : btVar;
        this.f3219c = new de(context.getApplicationContext(), cjVar, this.f3221e);
        this.f3220d = new dc(this.f3219c);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final es a(er erVar) throws ClientException, ServiceException {
        return this.f3219c.a(erVar, (bx<er, es>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<es> a(er erVar, bx<er, es> bxVar) {
        return this.f3219c.a(erVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final fy a(fx fxVar) throws ClientException, ServiceException {
        return this.f3219c.a(fxVar, (bx<fx, fy>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<fy> a(fx fxVar, bx<fx, fy> bxVar) {
        return this.f3219c.a(fxVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final eq a(ep epVar) throws ClientException, ServiceException {
        return this.f3219c.a(epVar, (bx<ep, eq>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<eq> a(ep epVar, bx<ep, eq> bxVar) {
        return this.f3219c.a(epVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final eb a(ea eaVar) throws ClientException, ServiceException {
        return this.f3219c.a(eaVar, (bx<ea, eb>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<eb> a(ea eaVar, bx<ea, eb> bxVar) {
        return this.f3219c.a(eaVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<ge> a(gd gdVar, bx<gd, ge> bxVar) {
        return this.f3219c.a(gdVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final ge a(gd gdVar) throws ClientException, ServiceException {
        ge b4 = this.f3219c.a(gdVar, (bx<gd, ge>) null).b();
        de.a(gdVar, b4);
        return b4;
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<ey> a(ex exVar, bx<ex, ey> bxVar) {
        return this.f3219c.a(exVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final ey a(ex exVar) throws ClientException, ServiceException {
        return this.f3219c.a(exVar, (bx<ex, ey>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<ew> a(ev evVar, bx<ev, ew> bxVar) {
        return this.f3219c.a(evVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final ew a(ev evVar) throws ClientException, ServiceException {
        return this.f3219c.a(evVar, (bx<ev, ew>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<ej> a(ei eiVar, bx<ei, ej> bxVar) {
        return this.f3219c.a(eiVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final ej a(ei eiVar) throws ClientException, ServiceException {
        return this.f3219c.a(eiVar, (bx<ei, ej>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<eh> a(eg egVar, bx<eg, eh> bxVar) {
        return this.f3219c.a(egVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final eh a(eg egVar) throws ClientException, ServiceException {
        return this.f3219c.a(egVar, (bx<eg, eh>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<ds> a(dr drVar, bx<dr, ds> bxVar) {
        return this.f3219c.a(drVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final ds a(dr drVar) throws ClientException, ServiceException {
        ds b4 = this.f3219c.a(drVar, (bx<dr, ds>) null).b();
        boolean z10 = drVar.f4050l == OSSRequest.CRC64Config.YES;
        Long l10 = drVar.f3496h;
        if (l10 != null && z10) {
            b4.a(Long.valueOf(cq.a(l10.longValue(), b4.a().longValue(), b4.f3497a - drVar.f3495g)));
        }
        de.a(drVar, b4);
        return b4;
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<fc> a(fb fbVar, bx<fb, fc> bxVar) {
        return this.f3219c.a(fbVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final fc a(fb fbVar) throws ClientException, ServiceException {
        return this.f3219c.a(fbVar, (bx<fb, fc>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<dx> a(dw dwVar, bx<dw, dx> bxVar) {
        return this.f3219c.a(dwVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dx a(dw dwVar) throws ClientException, ServiceException {
        return this.f3219c.a(dwVar, (bx<dw, dx>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<fm> a(fl flVar, bx<fl, fm> bxVar) {
        return this.f3219c.a(flVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final fm a(fl flVar) throws ClientException, ServiceException {
        return this.f3219c.a(flVar, (bx<fl, fm>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<fg> a(ff ffVar, bx<ff, fg> bxVar) {
        return this.f3219c.a(ffVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final fg a(ff ffVar) throws ClientException, ServiceException {
        return this.f3219c.a(ffVar, (bx<ff, fg>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<gp> a(go goVar, bx<go, gp> bxVar) {
        return this.f3219c.a(goVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final gp a(go goVar) throws ClientException, ServiceException {
        return this.f3219c.a(goVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<dv> a(du duVar, bx<du, dv> bxVar) {
        return this.f3219c.a(duVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dv a(du duVar) throws ClientException, ServiceException {
        return this.f3219c.a(duVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<dq> a(dp dpVar, bx<dp, dq> bxVar) {
        return this.f3219c.a(dpVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dq a(dp dpVar) throws ClientException, ServiceException {
        return this.f3219c.a(dpVar, (bx<dp, dq>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<fo> a(fn fnVar, bx<fn, fo> bxVar) {
        return this.f3219c.a(fnVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final fo a(fn fnVar) throws ClientException, ServiceException {
        return this.f3219c.a(fnVar, (bx<fn, fo>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<fk> a(fj fjVar, bx<fj, fk> bxVar) {
        return this.f3219c.a(fjVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final fk a(fj fjVar) throws ClientException, ServiceException {
        return this.f3219c.a(fjVar, (bx<fj, fk>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final void a(cj cjVar) {
        this.f3218b = cjVar;
        this.f3219c.f3436c = cjVar;
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<dv> a(fq fqVar, bx<fq, dv> bxVar) {
        return this.f3220d.a(fqVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dv a(fq fqVar) throws ClientException, ServiceException {
        return this.f3220d.a(fqVar, (bx<fq, dv>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<gl> a(gk gkVar, bx<gk, gl> bxVar) {
        return this.f3220d.a(gkVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final gl a(gk gkVar) throws ClientException, ServiceException {
        return this.f3220d.a(gkVar, (bx<gk, gl>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final String a(ek ekVar) throws ClientException {
        return new di(this.f3217a, this.f3218b, this.f3221e).a(ekVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final String a(String str, String str2, long j10) throws ClientException {
        di diVar = new di(this.f3217a, this.f3218b, this.f3221e);
        ek ekVar = new ek(str, str2);
        ekVar.f3556e = j10;
        return diVar.a(ekVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final String a(String str, String str2) {
        di diVar = new di(this.f3217a, this.f3218b, this.f3221e);
        String host = diVar.f3461a.getHost();
        if (!OSSUtils.c(host) || OSSUtils.a(host, (List<String>) Collections.unmodifiableList(diVar.f3462b.f3210f))) {
            host = str + "." + host;
        }
        return diVar.f3461a.getScheme() + "://" + host + "/" + ct.a(str2, "utf-8");
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<gn> a(gm gmVar, bx<gm, gn> bxVar) {
        return this.f3219c.a(gmVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final gn a(gm gmVar) throws ClientException, ServiceException {
        return this.f3219c.a(gmVar, (bx<gm, gn>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<fe> a(fd fdVar, bx<fd, fe> bxVar) {
        return this.f3219c.a(fdVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final fe a(fd fdVar) throws ClientException, ServiceException {
        return this.f3219c.a(fdVar, (bx<fd, fe>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final gg a(gf gfVar) throws ClientException, ServiceException {
        return this.f3219c.a(gfVar, (bx<gf, gg>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<gg> a(gf gfVar, bx<gf, gg> bxVar) {
        return this.f3219c.a(gfVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final fa a(ez ezVar) throws ClientException, ServiceException {
        return this.f3219c.a(ezVar, (bx<ez, fa>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<fa> a(ez ezVar, bx<ez, fa> bxVar) {
        return this.f3219c.a(ezVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final gj a(gi giVar) throws ClientException, ServiceException {
        return this.f3219c.a(giVar, (bx<gi, gj>) null).b();
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<gj> a(gi giVar, bx<gi, gj> bxVar) {
        return this.f3219c.a(giVar, bxVar);
    }
}
