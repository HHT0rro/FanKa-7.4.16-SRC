package com.wangmai.ad.dex.allmodules.utils;

import android.content.Context;
import android.view.ViewGroup;
import com.wangmai.ad.dex.allmodules.bean.ApiBean;
import com.wangmai.ad.dex.allmodules.bean.ProgressTrackingBean;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: AdReportRewordUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appb {

    /* renamed from: appa, reason: collision with root package name */
    private List<String> f46822appa;
    private List<String> appb;
    private ApiBean.WxadBean appc;

    public appb(ViewGroup viewGroup, Context context, int i10, int i11, boolean z10, List<ProgressTrackingBean> list, ApiBean.WxadBean wxadBean) {
        this.appc = wxadBean;
        appf.appf = 0;
        appf.appg = 0;
        appf.apph = 0;
        appf.appi = 0;
        appf.appj = 0;
        ApiBean.WxadBean wxadBean2 = this.appc;
        if (wxadBean2 != null) {
            wxadBean2.getDownload_track_urls();
            this.appc.getDownloaded_track_urls();
            this.appc.getWin_notice_url();
            this.appc.getInteraction_type();
            this.appc.getLanding_page_url();
            this.appc.getDeep_link();
            this.f46822appa = this.appc.getClick_url();
            this.appc.getInstalled_track_urls();
            this.appb = this.appc.getDp_try_track_urls();
            this.appc.getApp_package();
            this.appc.getDp_app_uninstalled_urls();
            this.appc.getDp_app_installed_urls();
            this.appc.getDp_success_track_urls();
            this.appc.getDp_failed_track_urls();
        }
    }

    public void appa(int i10, float f10, float f11, float f12, float f13) {
        appa.appa.appf.appd.appa("AdReportRewordUtils", "激励视频点击上报");
        appf.appa(this.f46822appa, this.appb, i10, f10, f11, f12, f13);
    }
}
