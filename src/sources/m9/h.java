package m9;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.base.util.CommonUtils;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.common.support.global.HomeCountryUtils;
import com.huawei.appgallery.agd.core.api.AdSlot;
import com.huawei.appgallery.agd.core.api.AgdAdApi;
import com.huawei.appgallery.agd.core.api.AgdAdConfig;
import com.huawei.appgallery.agd.core.api.RequestConfig;
import com.huawei.appgallery.agd.core.impl.AgdAdManager;
import com.huawei.appgallery.agd.core.impl.device.OaidUtil;
import com.huawei.appgallery.agd.core.impl.report.MaintBi;
import com.huawei.appgallery.agd.core.impl.report.MaintData;
import com.huawei.appgallery.agd.core.impl.report.MaintKey;
import com.huawei.appgallery.agd.core.impl.store.carddata.CardDataResponseBean;
import com.huawei.appgallery.agd.core.impl.store.carddatav2.request.AdSlotInfo;
import com.huawei.appgallery.agd.core.impl.store.carddatav2.request.CardDataV2RequestBean;
import com.huawei.appgallery.agd.core.impl.store.carddatav2.request.DeviceInfo;
import com.huawei.appgallery.agd.core.impl.store.carddatav2.request.ExtInfo;
import com.huawei.appgallery.agd.core.impl.store.carddatav2.request.MediaInfo;
import com.huawei.appgallery.agd.core.impl.store.carddatav2.request.NetworkInfo;
import com.huawei.appgallery.agd.core.impl.store.carddatav2.request.ViewSizeInfo;
import com.huawei.appgallery.agd.core.internalapi.IQueryCardData;
import com.huawei.appgallery.agd.serverreq.BuildConfig;
import com.huawei.appgallery.agd.serverreq.ServerAgent;
import com.huawei.appgallery.agd.serverreq.bean.ResponseBean;
import com.huawei.appgallery.agd.serverreq.listener.IServerCallbackEx;
import com.huawei.appgallery.agd.serverreq.store.SignSession;
import com.huawei.appgallery.agd.serverreq.utils.device.DeviceUtil;
import com.huawei.appgallery.agd.serverreq.utils.network.NetworkUtil;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class h {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a implements IServerCallbackEx {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IQueryCardData.Callback f51962a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CardDataV2RequestBean f51963b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AdSlot f51964c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f51965d;

        public a(IQueryCardData.Callback callback, CardDataV2RequestBean cardDataV2RequestBean, AdSlot adSlot, long j10) {
            this.f51962a = callback;
            this.f51963b = cardDataV2RequestBean;
            this.f51964c = adSlot;
            this.f51965d = j10;
        }

        @Override // com.huawei.appgallery.agd.serverreq.listener.IServerCallbackEx
        public void onFail(int i10, String str) {
            n9.a.f52175d.e("CardDataV2Manager", "queryCardDataV2 failed, errorCode:" + i10 + ", errorMsg:" + str);
            this.f51962a.onFail(2004, "queryCardDataV2 fail with code: " + i10 + ", msg: " + str);
            MaintBi.report(new MaintData.Builder(MaintKey.EVENT_MEDIA_REQUEST_AD).setRequestId(this.f51963b.getRequestId()).setErrorCode((long) i10).setMsg(str).setSlotId(this.f51964c.getSlotId()).setTotalTime(System.currentTimeMillis() - this.f51965d).build());
        }

        @Override // com.huawei.appgallery.agd.serverreq.listener.IServerCallbackEx
        public void onResponse(ResponseBean responseBean) {
            n9.a.f52175d.i("CardDataV2Manager", "queryCardDataV2 success, code:" + responseBean.getResponseCode());
            this.f51962a.onSuccess((CardDataResponseBean) responseBean);
            MaintBi.report(new MaintData.Builder(MaintKey.EVENT_MEDIA_REQUEST_AD).setRequestId(this.f51963b.getRequestId()).setResponseCode((long) responseBean.getResponseCode()).setErrorCode((long) responseBean.getRtnCode_()).setMsg(responseBean.getRtnDesc()).setSlotId(this.f51964c.getSlotId()).setTotalTime(System.currentTimeMillis() - this.f51965d).build());
        }
    }

    public static String a(@NonNull JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        return optJSONObject == null ? "" : optJSONObject.toString();
    }

    public static void b(Context context, CardDataV2RequestBean cardDataV2RequestBean) {
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setEncDeviceId(o9.a.a(context));
        deviceInfo.setDeviceIdType(9);
        deviceInfo.setOaid(OaidUtil.getOAID());
        deviceInfo.setServiceCountry(HomeCountryUtils.getHomeCountry());
        deviceInfo.setSign(SignSession.getInstance().getSign());
        deviceInfo.setOSV(DeviceUtil.getOSVersion());
        cardDataV2RequestBean.setDeviceInfo(deviceInfo);
    }

    public static void c(AdSlot adSlot, int i10, CardDataV2RequestBean cardDataV2RequestBean) {
        AdSlotInfo adSlotInfo = new AdSlotInfo();
        adSlotInfo.setSlotId(adSlot.getSlotId());
        if (i10 != 2 && i10 != 1 && i10 != 6 && i10 != 4 && i10 != 5) {
            adSlotInfo.setAdCount(Integer.valueOf(adSlot.getAdCount()));
        } else {
            adSlotInfo.setAdCount(1);
        }
        List<String> adIdList = AgdAdManager.getAdIdList(adSlot.getSlotId());
        n9.a aVar = n9.a.f52175d;
        aVar.i("CardDataV2Manager", "exposure adIdList is : " + ((Object) adIdList));
        adSlotInfo.setLastItemIds(adIdList);
        adSlotInfo.setViewSizeInfo(new ViewSizeInfo(Integer.valueOf(adSlot.getAcceptedSizeWidth()), Integer.valueOf(adSlot.getAcceptedSizeHeight())));
        JSONObject mediaExtra = adSlot.getMediaExtra();
        if (mediaExtra != null) {
            adSlotInfo.setContextIntent(a(mediaExtra, "contextIntent"));
        } else {
            aVar.w("CardDataV2Manager", "setAdSlotInfo mediaExtraObj null");
        }
        cardDataV2RequestBean.setAdSlotInfo(adSlotInfo);
    }

    public static void d(@NonNull AdSlot adSlot, int i10, @NonNull IQueryCardData.Callback callback) {
        if (TextUtils.isEmpty(adSlot.getSlotId())) {
            n9.a.f52175d.e("CardDataV2Manager", "queryCardDataV2 failed, slotId is empty!");
            callback.onFail(2002, "queryCardDataV2 failed, slotId is empty!");
            return;
        }
        Context context = ApplicationWrapper.getInstance().getContext();
        if (context == null) {
            n9.a.f52175d.e("CardDataV2Manager", "queryCardDataV2 failed, context is null!");
            callback.onFail(2010, "queryCardDataV2 failed, context is null!");
            return;
        }
        if (!NetworkUtil.hasActiveNetwork(context)) {
            n9.a.f52175d.e("CardDataV2Manager", "queryCardDataV2 failed, network unavailable!");
            callback.onFail(2003, "queryCardDataV2 failed, network unavailable!");
            MaintBi.report(new MaintData.Builder(MaintKey.EVENT_MEDIA_REQUEST_AD).setErrorCode(2003L).setMsg("queryCardDataV2 failed, network unavailable!").setSlotId(adSlot.getSlotId()).build());
            return;
        }
        n9.a.f52175d.d("CardDataV2Manager", adSlot.toString());
        long currentTimeMillis = System.currentTimeMillis();
        CardDataV2RequestBean cardDataV2RequestBean = new CardDataV2RequestBean();
        k(cardDataV2RequestBean);
        f(cardDataV2RequestBean);
        c(adSlot, i10, cardDataV2RequestBean);
        b(context, cardDataV2RequestBean);
        j(context, cardDataV2RequestBean);
        g(context, cardDataV2RequestBean);
        e(adSlot, cardDataV2RequestBean);
        h(adSlot, cardDataV2RequestBean);
        i(cardDataV2RequestBean);
        ServerAgent.invokeServerEx(cardDataV2RequestBean, new a(callback, cardDataV2RequestBean, adSlot, currentTimeMillis));
    }

    public static void e(AdSlot adSlot, CardDataV2RequestBean cardDataV2RequestBean) {
        ExtInfo extInfo = new ExtInfo();
        extInfo.setAgdProSdkVer(String.valueOf(BuildConfig.VERSION_CODE));
        extInfo.setServiceType(String.valueOf(62));
        extInfo.setChannelId(adSlot.getChannelId());
        extInfo.setReferrer(adSlot.getReferrer());
        cardDataV2RequestBean.setExtInfo(extInfo);
    }

    public static void f(CardDataV2RequestBean cardDataV2RequestBean) {
        cardDataV2RequestBean.setApiVersion("2");
    }

    public static void g(Context context, CardDataV2RequestBean cardDataV2RequestBean) {
        MediaInfo mediaInfo = new MediaInfo();
        mediaInfo.setMediaPkgName(context.getPackageName());
        try {
            mediaInfo.setMediaVersion(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName);
        } catch (PackageManager.NameNotFoundException unused) {
            n9.a.f52175d.e("CardDataV2Manager", "setMediaInfo failed!exception:NameNotFoundException");
        } catch (RuntimeException unused2) {
            n9.a.f52175d.e("CardDataV2Manager", "setMediaInfo exception");
        }
        mediaInfo.setMediaPkgSign(CommonUtils.getCallerAppSigns(context.getPackageName(), context));
        AgdAdConfig config = AgdAdManager.getConfig();
        if (p9.a.a(context.getPackageName()) && !TextUtils.isEmpty(config.getMediaPkgName())) {
            mediaInfo.setMediaPkgName(config.getMediaPkgName());
            mediaInfo.setMediaPkgSign(config.getMediaPkgSign());
        }
        cardDataV2RequestBean.setMediaInfo(mediaInfo);
    }

    public static void h(AdSlot adSlot, CardDataV2RequestBean cardDataV2RequestBean) {
        JSONObject mediaExtra = adSlot.getMediaExtra();
        if (mediaExtra != null) {
            cardDataV2RequestBean.setPersonalizeInfo(mediaExtra.optJSONObject(RequestConfig.PersonalizeConstant.KEY_PERSONALIZE));
        } else {
            n9.a.f52175d.w("CardDataV2Manager", "setMediaExtra extraObj null");
        }
    }

    public static void i(CardDataV2RequestBean cardDataV2RequestBean) {
        cardDataV2RequestBean.setChildProtection(AgdAdApi.getRequestConfig().getTagForChildProtection());
    }

    public static void j(Context context, CardDataV2RequestBean cardDataV2RequestBean) {
        NetworkInfo networkInfo = new NetworkInfo();
        networkInfo.setConnectType(Integer.valueOf(NetworkUtil.getNetworkType(context)));
        networkInfo.setCarrier(0);
        networkInfo.setPlmn("");
        cardDataV2RequestBean.setNetworkInfo(networkInfo);
    }

    public static void k(CardDataV2RequestBean cardDataV2RequestBean) {
        cardDataV2RequestBean.setRequestId(UUID.randomUUID().toString().replaceAll("-", ""));
    }
}
