package com.alimm.tanx.core.request;

import android.app.Application;
import android.graphics.Point;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.SdkConstant;
import com.alimm.tanx.core.TanxCoreManager;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.bean.AdInfo;
import com.alimm.tanx.core.net.NetWorkManager;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.AdNetWorkCallBack;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.request.AdRequestBean;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.utils.AndroidUtils;
import com.alimm.tanx.core.utils.DeviceIdGetUtil;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NetWorkUtil;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.SysUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AdRequest implements NotConfused {
    public static final String TAG = "AdRequest";
    public static AdRequestBean adRequestBean;
    public static long localTime;
    public static long sTime;

    public static AdRequestBean buildRequestBean(AdRequestBean adRequestBean2, TanxAdSlot tanxAdSlot) {
        Application appContext = TanxCoreManager.getInstance().getAppContext();
        if (adRequestBean2 == null) {
            adRequestBean2 = new AdRequestBean();
        }
        if (adRequestBean2.app == null) {
            AdRequestBean.AdAppBean adAppBean = new AdRequestBean.AdAppBean();
            adRequestBean2.app = adAppBean;
            adAppBean.package_name = AndroidUtils.getPackageName(appContext);
            adRequestBean2.app.app_name = AndroidUtils.getAppName(appContext);
            AdRequestBean.AdAppBean adAppBean2 = adRequestBean2.app;
            adAppBean2.app_version = AndroidUtils.getAppVersion(appContext, adAppBean2.package_name);
            adRequestBean2.app.sdk_version = SdkConstant.getSdkVersion();
        }
        adRequestBean2.imp = new ArrayList();
        int max = Math.max(tanxAdSlot.getAdCount(), 1);
        if (tanxAdSlot.getAdCount() > 10) {
            max = 10;
        }
        for (int i10 = 0; i10 < max; i10++) {
            AdRequestBean.AdImpBean adImpBean = new AdRequestBean.AdImpBean();
            adImpBean.pid = tanxAdSlot.getPid();
            adImpBean.native_template_id = tanxAdSlot.getNativeTemplateId();
            adImpBean.slot_num = 1;
            adImpBean.f4184id = String.valueOf(i10);
            adRequestBean2.imp.add(adImpBean);
        }
        if (adRequestBean2.device == null) {
            AdRequestBean.AdDeviceBean adDeviceBean = new AdRequestBean.AdDeviceBean();
            adRequestBean2.device = adDeviceBean;
            adDeviceBean.user_agent = AndroidUtils.getUserAgent();
            adDeviceBean.android_id = AndroidUtils.getAndroidId();
            adDeviceBean.device_type = 0;
            adDeviceBean.brand = AndroidUtils.getBrand();
            adDeviceBean.model = AndroidUtils.getModel();
            adDeviceBean.os = "Android";
            adDeviceBean.osv = AndroidUtils.getSystemVersion();
            adDeviceBean.network = NetWorkUtil.getNetworkType(appContext).getKey();
            adRequestBean2.device.operator = NetWorkUtil.getOperatorType(appContext);
            Point screenSize = AndroidUtils.getScreenSize(appContext);
            adDeviceBean.width = screenSize.x;
            adDeviceBean.height = screenSize.y;
            adDeviceBean.pixel_ratio = AndroidUtils.getDisplayDpi(appContext);
        }
        adRequestBean2.device.installed_app = SysUtils.getInstallStatus();
        adRequestBean2.device.imei = TanxCoreSdk.getConfig().getImei();
        adRequestBean2.device.oaid = TanxCoreSdk.getConfig().getOaid();
        adRequestBean2.device.clientId = TanxCoreSdk.getConfig().getClientId();
        adRequestBean2.device.widevineId = TanxCoreSdk.getConfig().getWidevineId();
        adRequestBean2.device.pseudoId = TanxCoreSdk.getConfig().getPseudoId();
        adRequestBean2.device.guid = TanxCoreSdk.getConfig().getGuid();
        adRequestBean2.device.orientation = AndroidUtils.getScreenOrientation(appContext);
        if (adRequestBean2.user == null) {
            adRequestBean2.user = new AdRequestBean.AdUserBean();
        }
        adRequestBean2.user.user_tag = TanxCoreSdk.getConfig().getUserTag();
        adRequestBean2.user.media_uid = tanxAdSlot.getMediaUid();
        adRequestBean2.ext = tanxAdSlot.getExt();
        adRequestBean2.https_required = true;
        adRequestBean2.version = 1;
        adRequestBean2.f4183id = tanxAdSlot.getReqId();
        adRequestBean2.render_type = tanxAdSlot.isExpressRender() ? 1 : 2;
        return adRequestBean2;
    }

    public static boolean checkDeviceNumber(AdRequestBean adRequestBean2) {
        return (TextUtils.isEmpty(adRequestBean2.device.imei) && TextUtils.isEmpty(adRequestBean2.device.oaid)) ? false : true;
    }

    public static void request(final TanxAdSlot tanxAdSlot, final String str, final NetWorkCallBack<AdInfo> netWorkCallBack) {
        if (TextUtils.isEmpty(tanxAdSlot.getPid())) {
            UtErrorCode utErrorCode = UtErrorCode.PID_NULL;
            netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
        }
        sTime = System.currentTimeMillis();
        DeviceIdGetUtil.getInstance(TanxCoreSdk.getApplication()).netGetImei();
        RequestBean build = new RequestBean().setUrl(C.getAdUrl()).build();
        build.setOverrideError(true);
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json; charset=utf-8");
        build.setHeads(hashMap);
        AdRequestBean buildRequestBean = buildRequestBean(adRequestBean, tanxAdSlot);
        adRequestBean = buildRequestBean;
        if (!checkDeviceNumber(buildRequestBean)) {
            UtErrorCode utErrorCode2 = UtErrorCode.APP_DEVICE_NUMBER_NULL;
            netWorkCallBack.error(utErrorCode2.getIntCode(), "", utErrorCode2.getMsg());
            return;
        }
        final String jSONString = JSON.toJSONString(adRequestBean);
        LogUtils.d(TAG, jSONString);
        build.setJson(jSONString);
        localTime = System.currentTimeMillis() - sTime;
        LogUtils.d("splashTimeConsuming", "local->" + localTime);
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        NetWorkManager.getInstance().sendHttpPost(build, AdInfo.class, new AdNetWorkCallBack<AdInfo>() { // from class: com.alimm.tanx.core.request.AdRequest.1
            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            public void error(int i10, String str2, String str3) {
                NetWorkCallBack netWorkCallBack2 = NetWorkCallBack.this;
                if (netWorkCallBack2 != null) {
                    netWorkCallBack2.error(i10, str2, str3);
                    TanxCommonUt.sendAdRqFail(str, tanxAdSlot.getPid(), AdRequest.adRequestBean.f4183id, SystemClock.elapsedRealtime() - elapsedRealtime, i10, str3, jSONString);
                }
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
            public void succ(AdInfo adInfo) {
                AdRequest.suc(adInfo, "", jSONString, elapsedRealtime, tanxAdSlot, str, NetWorkCallBack.this);
            }

            @Override // com.alimm.tanx.core.net.callback.AdNetWorkCallBack
            /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
            public void succ(AdInfo adInfo, String str2) {
                AdRequest.suc(adInfo, str2, jSONString, elapsedRealtime, tanxAdSlot, str, NetWorkCallBack.this);
            }
        });
    }

    public static void suc(AdInfo adInfo, String str, String str2, long j10, TanxAdSlot tanxAdSlot, String str3, NetWorkCallBack<AdInfo> netWorkCallBack) {
        String msg;
        if (netWorkCallBack != null) {
            if (adInfo != null) {
                if (adInfo.getStatus() == 0) {
                    adInfo.setDecrypt(str);
                    netWorkCallBack.succ(tanxc_do.tanxc_do(adInfo));
                    TanxCommonUt.sendAdRqSuc(str3, tanxAdSlot, adInfo.getRequestId(), SystemClock.elapsedRealtime() - j10, adInfo.getAdCount(), adInfo);
                    return;
                }
                int status = adInfo.getStatus();
                if (status == 1) {
                    msg = UtErrorCode.SERVER_RETURN_1.getMsg();
                } else {
                    msg = UtErrorCode.SERVER_RETURN_ERROR.getMsg();
                }
                String str4 = msg;
                netWorkCallBack.error(status, adInfo.getRequestId(), str4);
                TanxCommonUt.sendAdRqFail(str3, tanxAdSlot.getPid(), adRequestBean.f4183id, SystemClock.elapsedRealtime() - j10, status, str4, str2);
                return;
            }
            UtErrorCode utErrorCode = UtErrorCode.DATA_PARSE_ERROR;
            netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
            TanxCommonUt.sendAdRqFail(str3, tanxAdSlot.getPid(), adRequestBean.f4183id, SystemClock.elapsedRealtime() - j10, utErrorCode.getIntCode(), utErrorCode.getMsg(), str2);
        }
    }
}
