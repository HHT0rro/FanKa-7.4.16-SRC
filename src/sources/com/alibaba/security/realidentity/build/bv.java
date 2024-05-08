package com.alibaba.security.realidentity.build;

import android.content.Context;
import com.alibaba.security.realidentity.oss.ClientException;
import com.alibaba.security.realidentity.oss.ServiceException;
import java.io.IOException;

/* compiled from: OSSClient.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bv implements bu {

    /* renamed from: a, reason: collision with root package name */
    private bu f3216a;

    private bv(Context context, String str, cj cjVar) {
        this(context, str, cjVar, null);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<fi> a(fh fhVar, bx<fh, fi> bxVar) {
        return this.f3216a.a(fhVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<gl> b(gk gkVar, bx<gk, gl> bxVar) {
        return this.f3216a.b(gkVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final void c(gk gkVar) throws IOException {
        this.f3216a.c(gkVar);
    }

    public bv(Context context, String str, cj cjVar, bt btVar) {
        this.f3216a = new bw(context, str, cjVar, btVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final fi a(fh fhVar) throws ClientException, ServiceException {
        return this.f3216a.a(fhVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final gl b(gk gkVar) throws ClientException, ServiceException {
        return this.f3216a.b(gkVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<dz> a(dy dyVar, bx<dy, dz> bxVar) {
        return this.f3216a.a(dyVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final boolean b(String str, String str2) throws ClientException, ServiceException {
        return this.f3216a.b(str, str2);
    }

    private bv(Context context, cj cjVar, bt btVar) {
        this.f3216a = new bw(context, cjVar, btVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dz a(dy dyVar) throws ClientException, ServiceException {
        return this.f3216a.a(dyVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<ef> a(ee eeVar, bx<ee, ef> bxVar) {
        return this.f3216a.a(eeVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final ef a(ee eeVar) throws ClientException, ServiceException {
        return this.f3216a.a(eeVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<eo> a(en enVar, bx<en, eo> bxVar) {
        return this.f3216a.a(enVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final eo a(en enVar) throws ClientException, ServiceException {
        return this.f3216a.a(enVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<em> a(el elVar, bx<el, em> bxVar) {
        return this.f3216a.a(elVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final em a(el elVar) throws ClientException, ServiceException {
        return this.f3216a.a(elVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<gc> a(gb gbVar, bx<gb, gc> bxVar) {
        return this.f3216a.a(gbVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final gc a(gb gbVar) throws ClientException, ServiceException {
        return this.f3216a.a(gbVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final eu a(et etVar) throws ClientException, ServiceException {
        return this.f3216a.a(etVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<eu> a(et etVar, bx<et, eu> bxVar) {
        return this.f3216a.a(etVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final ed a(ec ecVar) throws ClientException, ServiceException {
        return this.f3216a.a(ecVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<ed> a(ec ecVar, bx<ec, ed> bxVar) {
        return this.f3216a.a(ecVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final ga a(fz fzVar) throws ClientException, ServiceException {
        return this.f3216a.a(fzVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<ga> a(fz fzVar, bx<fz, ga> bxVar) {
        return this.f3216a.a(fzVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final es a(er erVar) throws ClientException, ServiceException {
        return this.f3216a.a(erVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<es> a(er erVar, bx<er, es> bxVar) {
        return this.f3216a.a(erVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final fy a(fx fxVar) throws ClientException, ServiceException {
        return this.f3216a.a(fxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<fy> a(fx fxVar, bx<fx, fy> bxVar) {
        return this.f3216a.a(fxVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final eq a(ep epVar) throws ClientException, ServiceException {
        return this.f3216a.a(epVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<eq> a(ep epVar, bx<ep, eq> bxVar) {
        return this.f3216a.a(epVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final eb a(ea eaVar) throws ClientException, ServiceException {
        return this.f3216a.a(eaVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<eb> a(ea eaVar, bx<ea, eb> bxVar) {
        return this.f3216a.a(eaVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<ge> a(gd gdVar, bx<gd, ge> bxVar) {
        return this.f3216a.a(gdVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final ge a(gd gdVar) throws ClientException, ServiceException {
        return this.f3216a.a(gdVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<ey> a(ex exVar, bx<ex, ey> bxVar) {
        return this.f3216a.a(exVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final ey a(ex exVar) throws ClientException, ServiceException {
        return this.f3216a.a(exVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<ew> a(ev evVar, bx<ev, ew> bxVar) {
        return this.f3216a.a(evVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final ew a(ev evVar) throws ClientException, ServiceException {
        return this.f3216a.a(evVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<ej> a(ei eiVar, bx<ei, ej> bxVar) {
        return this.f3216a.a(eiVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final ej a(ei eiVar) throws ClientException, ServiceException {
        return this.f3216a.a(eiVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<eh> a(eg egVar, bx<eg, eh> bxVar) {
        return this.f3216a.a(egVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final eh a(eg egVar) throws ClientException, ServiceException {
        return this.f3216a.a(egVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<ds> a(dr drVar, bx<dr, ds> bxVar) {
        return this.f3216a.a(drVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final ds a(dr drVar) throws ClientException, ServiceException {
        return this.f3216a.a(drVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<fc> a(fb fbVar, bx<fb, fc> bxVar) {
        return this.f3216a.a(fbVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final fc a(fb fbVar) throws ClientException, ServiceException {
        return this.f3216a.a(fbVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<dx> a(dw dwVar, bx<dw, dx> bxVar) {
        return this.f3216a.a(dwVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dx a(dw dwVar) throws ClientException, ServiceException {
        return this.f3216a.a(dwVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<fm> a(fl flVar, bx<fl, fm> bxVar) {
        return this.f3216a.a(flVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final fm a(fl flVar) throws ClientException, ServiceException {
        return this.f3216a.a(flVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<fg> a(ff ffVar, bx<ff, fg> bxVar) {
        return this.f3216a.a(ffVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final fg a(ff ffVar) throws ClientException, ServiceException {
        return this.f3216a.a(ffVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<gp> a(go goVar, bx<go, gp> bxVar) {
        return this.f3216a.a(goVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final gp a(go goVar) throws ClientException, ServiceException {
        return this.f3216a.a(goVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<dv> a(du duVar, bx<du, dv> bxVar) {
        return this.f3216a.a(duVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dv a(du duVar) throws ClientException, ServiceException {
        return this.f3216a.a(duVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<dq> a(dp dpVar, bx<dp, dq> bxVar) {
        return this.f3216a.a(dpVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dq a(dp dpVar) throws ClientException, ServiceException {
        return this.f3216a.a(dpVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<fo> a(fn fnVar, bx<fn, fo> bxVar) {
        return this.f3216a.a(fnVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final fo a(fn fnVar) throws ClientException, ServiceException {
        return this.f3216a.a(fnVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<fk> a(fj fjVar, bx<fj, fk> bxVar) {
        return this.f3216a.a(fjVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final fk a(fj fjVar) throws ClientException, ServiceException {
        return this.f3216a.a(fjVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final void a(cj cjVar) {
        this.f3216a.a(cjVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<dv> a(fq fqVar, bx<fq, dv> bxVar) {
        return this.f3216a.a(fqVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dv a(fq fqVar) throws ClientException, ServiceException {
        return this.f3216a.a(fqVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<gl> a(gk gkVar, bx<gk, gl> bxVar) {
        return this.f3216a.a(gkVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final gl a(gk gkVar) throws ClientException, ServiceException {
        return this.f3216a.a(gkVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final String a(ek ekVar) throws ClientException {
        return this.f3216a.a(ekVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final String a(String str, String str2, long j10) throws ClientException {
        return this.f3216a.a(str, str2, j10);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final String a(String str, String str2) {
        return this.f3216a.a(str, str2);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<gn> a(gm gmVar, bx<gm, gn> bxVar) {
        return this.f3216a.a(gmVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final gn a(gm gmVar) throws ClientException, ServiceException {
        return this.f3216a.a(gmVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<fe> a(fd fdVar, bx<fd, fe> bxVar) {
        return this.f3216a.a(fdVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final fe a(fd fdVar) throws ClientException, ServiceException {
        return this.f3216a.a(fdVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final gg a(gf gfVar) throws ClientException, ServiceException {
        return this.f3216a.a(gfVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<gg> a(gf gfVar, bx<gf, gg> bxVar) {
        return this.f3216a.a(gfVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final fa a(ez ezVar) throws ClientException, ServiceException {
        return this.f3216a.a(ezVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<fa> a(ez ezVar, bx<ez, fa> bxVar) {
        return this.f3216a.a(ezVar, bxVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final gj a(gi giVar) throws ClientException, ServiceException {
        return this.f3216a.a(giVar);
    }

    @Override // com.alibaba.security.realidentity.build.bu
    public final dg<gj> a(gi giVar, bx<gi, gj> bxVar) {
        return this.f3216a.a(giVar, bxVar);
    }
}
