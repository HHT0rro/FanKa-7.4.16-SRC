package com.wangmai.ad.dex.allmodules.appe;

import android.content.Context;
import appa.appa.appf.appd;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.wangmai.ad.dex.allmodules.utils.appf;
import com.wangmai.common.bean.SdkTrackEventBean;
import com.wangmai.common.utils.AesUtil;
import com.wangmai.common.utils.ConstantInfo;
import com.wangmai.common.utils.GZIPUtils;
import com.wangmai.common.utils.GsonUtils;
import com.wangmai.common.utils.SDKTrackUtils;
import com.wangmai.okhttp.OkHttp;
import com.wangmai.okhttp.callback.ByteCallback;
import com.wangmai.okhttp.model.Response;
import com.wangmai.okhttp.request.PostRequest;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: ReportHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appb {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ReportHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appa extends ByteCallback {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ String f46777appa;
        final /* synthetic */ String appb;

        appa(String str, String str2) {
            this.f46777appa = str;
            this.appb = str2;
        }

        @Override // com.wangmai.okhttp.callback.AbsCallback, com.wangmai.okhttp.callback.Callback
        public void onError(Response<byte[]> response) {
            appd.appe("ReportHelper", "thridMediaRequest onError:" + response.code() + "," + response.getException().toString());
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<byte[]> response) {
            try {
                appd.appa(this.f46777appa, "【thridMediaRequest——>onSuccess】:url=" + this.appb, "bytes=" + GZIPUtils.unZipStringToByte(AesUtil.decryptToByte(response.body(), ConstantInfo.getAppToken())));
            } catch (Throwable th) {
                appd.appe("ReportHelper", "thridMediaRequest exception1:" + th.toString());
            }
        }
    }

    public static void appa(Context context, String str, String str2, int i10, int i11, String str3) {
        try {
            SdkTrackEventBean sdkTrackEventBean = new SdkTrackEventBean();
            sdkTrackEventBean.setRequest_id(str);
            sdkTrackEventBean.setMedia_slot_id(str2);
            if (!ConstantInfo.sdkInitTrackCompleted) {
                appd.appe("ReportHelper", "SDK初始化打点");
                ConstantInfo.sdkInitTrackCompleted = true;
                sdkTrackEventBean.addEvent(new SdkTrackEventBean.EventBean(SdkTrackEventBean.TrackEventEnum.AdInit, ConstantInfo.sdkInitTime, ConstantInfo.sdkInitCostTime + ""));
            }
            sdkTrackEventBean.addEvent(new SdkTrackEventBean.EventBean(SdkTrackEventBean.TrackEventEnum.AdBidReq, (String) null));
            SDKTrackUtils.getInstance().addSdkTrackReportBean(context, str, sdkTrackEventBean, "媒体侧发起广告请求(AdBidReq)");
            appa(context, str, str2, "", "", 0, i10, i11, str3, 0L, 0L, "", 0, 0, 0, ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, appf.appo, "WM媒体总请求数上报");
        } catch (Throwable th) {
            appd.appe("ReportHelper", "startReport exception:" + th.toString());
        }
    }

    public static void appb(Context context, String str, String str2, String str3, String str4, int i10, int i11, int i12, String str5, long j10, long j11, int i13, int i14, int i15, double d10, double d11) {
        try {
            appa(context, str, str2, str3, str4, i10, i11, i12, str5, j10, j11, "", i13, i14, i15, d10, d11, appf.appx, "WM媒体竞价成功上报");
        } catch (Throwable th) {
            appd.appe("ReportHelper", "reportMediaBidSuccessNotification exception:" + th.toString());
        }
    }

    public static void appa(Context context, String str, String str2, String str3, String str4, int i10, int i11, int i12, String str5) {
        try {
            appa(context, str, str2, str3, str4, i10, i11, i12, str5, 0L, 0L, "", 0, 0, 0, ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, appf.appr, "WM需求方请求数上报");
        } catch (Throwable th) {
            appd.appe("ReportHelper", "startThridReport exception:" + th.toString());
        }
    }

    public static void appa(Context context, String str, String str2, String str3, String str4, int i10, int i11, int i12, String str5, long j10, long j11, int i13, double d10, double d11) {
        try {
            appa(context, str, str2, str3, str4, i10, i11, i12, str5, j10, j11, "", i13, 0, i13, d10, d11, appf.apps, "WM需求方请求成功上报");
        } catch (Throwable th) {
            appd.appe("ReportHelper", "onAdReadyReport exception:" + th.toString());
        }
    }

    public static void appa(Context context, String str, String str2, String str3, String str4, int i10, int i11, int i12, String str5, long j10, long j11, String str6) {
        try {
            appa(context, str, str2, str3, str4, i10, i11, i12, str5, j10, j11, str6, 0, 0, 0, ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, appf.appu, "WM需求方请求失败上报");
        } catch (Throwable th) {
            appd.appe("ReportHelper", "onAdFailedReport exception:" + th.toString());
        }
    }

    public static void appa(Context context, String str, String str2, String str3, String str4, int i10, int i11, int i12, String str5, long j10, long j11, int i13, int i14, int i15, double d10, double d11) {
        try {
            appa(context, str, str2, str3, str4, i10, i11, i12, str5, j10, j11, "", i13, i14, i15, d10, d11, appf.appv, "WM展现上报");
        } catch (Throwable th) {
            appd.appe("ReportHelper", "onAdExposureReport exception:" + th.toString());
        }
    }

    public static void appa(Context context, String str, String str2, String str3, String str4, int i10, int i11, int i12, String str5, long j10, long j11) {
        try {
            appa(context, str, str2, str3, str4, i10, i11, i12, str5, j10, j11, "", 0, 0, 0, ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, appf.appw, "WM点击上报");
        } catch (Throwable th) {
            appd.appe("ReportHelper", "onAdClickReport exception:" + th.toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void appa(Context context, String str, String str2, String str3, String str4, int i10, int i11, int i12, String str5, long j10, long j11, String str6, int i13, int i14, int i15, double d10, double d11, String str7, String str8) {
        try {
            String json = GsonUtils.getInstance().toJson(appf.appa(context, str, str2, str3, str4, i10, i11, i12, str5, j10, j11, str6, i13, i14, i15, d10, d11));
            byte[] encryptByt = AesUtil.encryptByt(GZIPUtils.compress(json, "utf-8"), ConstantInfo.getAppToken());
            appd.appa(str8, "【thridMediaRequest——>request】:url=" + str7, "bean=" + json);
            ((PostRequest) OkHttp.post(str7).headers("Content-Type", "application/json")).upBytes(encryptByt).execute(new appa(str8, str7));
        } catch (Throwable th) {
            appd.appe("ReportHelper", "thridMediaRequest exception2:" + th.toString());
        }
    }
}
