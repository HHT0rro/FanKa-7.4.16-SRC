package com.wangmai.ad.dex.allmodules.utils;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import com.wangmai.ad.dex.allmodules.bean.ApiBean;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: AdReportUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appc {

    /* renamed from: appa, reason: collision with root package name */
    private int f46823appa;
    private int appb;
    private int appc;
    private boolean appd;
    private ApiBean appe;
    private appa appf;
    private Context appg;
    public float apph;
    public float appi;
    public float appj;
    public float appk;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: AdReportUtils.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public interface appa {
        void appa();
    }

    public appc(ViewGroup viewGroup, Context context, int i10, int i11, int i12, int i13, ApiBean apiBean) {
        this(viewGroup, context, i10, i11, false, i12, i13, apiBean);
    }

    public void appa() {
        try {
            appa.appa.appf.appd.appa("AdReportUtils", "adUploading");
            this.appc = 0;
            appf.appa(this.appe.getRespObj().getWxad().getWin_notice_url(), this.appc, this.appd);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("AdReportUtils", "adUploading error:" + th);
        }
    }

    public void appb() {
        this.appe = null;
        this.appf = null;
    }

    public appc(ViewGroup viewGroup, Context context, int i10, int i11, boolean z10, int i12, int i13, ApiBean apiBean) {
        this.f46823appa = 1;
        this.appb = 0;
        this.appc = 2;
        this.apph = -999.0f;
        this.appi = -999.0f;
        this.appj = -999.0f;
        this.appk = -999.0f;
        this.appg = context;
        this.appe = apiBean;
        this.appd = z10;
        this.f46823appa = i12;
        this.appb = i13;
    }

    public void appa(String str, boolean z10, int i10, float f10, float f11, float f12, float f13) {
        try {
            appa.appa.appf.appd.appa("AdReportUtils", "AdReportUtil doClick:", Thread.currentThread().getName(), Integer.valueOf(i10));
            this.apph = f10;
            this.appi = f11;
            this.appj = f12;
            this.appk = f13;
            if (this.appf != null && (!z10 || this.appc != 1)) {
                try {
                    this.appf.appa();
                } catch (Throwable th) {
                    appa.appa.appf.appd.appe("AdReportUtils", "AdReportUtil media onAdClick error:" + ((Object) th));
                    appf.appa(this.appg, "", "AdReportUtil media onAdClick error：" + Log.getStackTraceString(th));
                }
            }
            appa(str, z10, i10);
        } catch (Throwable th2) {
            appa.appa.appf.appd.appe("AdReportUtils", "AdReportUtil doClick error:" + ((Object) th2));
            appf.appa(this.appg, "", "AdReportUtil doClick error：" + Log.getStackTraceString(th2));
        }
    }

    private void appa(String str, boolean z10, int i10) {
        try {
            try {
                appf.appa(this.appe.getRespObj().getWxad().getClick_url(), this.appe.getRespObj().getWxad().getDp_try_track_urls(), i10, this.apph, this.appi, this.appj, this.appk);
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("AdReportUtils", "AdReportUtil clickUpEventReport error:" + ((Object) th));
                appf.appa(this.appg, "", "AdReportUtil clickUpEventReport error:" + Log.getStackTraceString(th));
            }
            appa(str, z10, this.appe.getRespObj().getWxad().getDeep_link(), this.appe.getRespObj().getWxad().getLanding_page_url());
        } catch (Throwable th2) {
            appa.appa.appf.appd.appe("AdReportUtils", "AdReportUtil openLinkAddress error:" + ((Object) th2));
            appf.appa(this.appg, "", "AdReportUtil openLinkAddress error:" + Log.getStackTraceString(th2));
        }
    }

    private void appa(String str, boolean z10, String str2, String str3) {
        try {
            appf.appa(str, z10, str2, str3, this.appg, this.apph, this.appi, this.appj, this.appk, this.appe, this.f46823appa, this.appb);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("AdReportUtils", "AdReportUtil clickLoadPage error:" + ((Object) th));
            appf.appa(this.appg, "", "AdReportUtil clickLoadPage error:" + Log.getStackTraceString(th));
        }
    }

    public void appa(appa appaVar) {
        this.appf = appaVar;
    }
}
