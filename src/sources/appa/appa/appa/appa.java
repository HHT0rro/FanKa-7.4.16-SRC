package appa.appa.appa;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import appa.appa.appf.appd;
import com.wangmai.appsdkdex.WMAdSdk;
import com.wangmai.appsdkdex.WMDexAdHelper;
import com.wangmai.common.bean.MaterialInformationBean;
import com.wangmai.common.utils.AesUtil;
import com.wangmai.common.utils.ConstantInfo;
import com.wangmai.common.utils.GZIPUtils;
import com.wangmai.common.utils.GsonUtils;
import com.wangmai.okhttp.OkHttp;
import com.wangmai.okhttp.callback.ByteCallback;
import com.wangmai.okhttp.model.Response;
import com.wangmai.okhttp.request.PostRequest;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: AbstractBaseProcesser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public abstract class appa {
    protected static final int RANDOM_INTERVAL_MAX = 10000;
    private static final String TAG = "appa";
    int adCacheTime;
    protected Context applicationContext;
    String crid;
    int dspPrice;
    long expireTime;
    List<String> inValidCrids;
    int mediaBidPrice;
    int thirdSlotIdKey;
    List<String> trackEventTypes;
    long trackMaxDuration;
    String trackUrl;
    String winReportUrl;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: AbstractBaseProcesser.java */
    /* renamed from: appa.appa.appa.appa$appa, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class C0018appa extends ByteCallback {
        C0018appa(appa appaVar) {
        }

        @Override // com.wangmai.okhttp.callback.AbsCallback, com.wangmai.okhttp.callback.Callback
        public void onError(Response<byte[]> response) {
            appd.appe(appa.TAG, "物料信息上报响应失败:" + response.code() + "," + response.getException().toString());
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<byte[]> response) {
            try {
                appd.appa(appa.TAG, "【物料信息上报——>onSuccess】:url=" + WMAdSdk.baseTrackUrl + "/sdk/trackadm.api", "bytes=" + GZIPUtils.unZipStringToByte(AesUtil.decryptToByte(response.body(), ConstantInfo.getAppToken())));
            } catch (Throwable th) {
                appd.appe(appa.TAG, "物料信息上报响应错误:" + th);
            }
        }
    }

    public appa(Context context) {
        this.applicationContext = context;
    }

    public int getAdCacheTime() {
        return this.adCacheTime;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Application getApplication() {
        return WMDexAdHelper.getApplication();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getApplicationContext() {
        Context context = this.applicationContext;
        return context != null ? context : WMDexAdHelper.getTopActivity().get().getApplicationContext();
    }

    public String getCrid() {
        return this.crid;
    }

    public int getDspPrice() {
        return this.dspPrice;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public List<String> getInValidCrids() {
        return this.inValidCrids;
    }

    public int getMediaBidPrice() {
        return this.mediaBidPrice;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WeakReference<Activity> getTaskTopActivity() {
        if (WMDexAdHelper.getTopActivity() != null) {
            return WMDexAdHelper.getTopActivity();
        }
        return null;
    }

    public int getThirdSlotIdKey() {
        return this.thirdSlotIdKey;
    }

    public List<String> getTrackEventTypes() {
        return this.trackEventTypes;
    }

    public long getTrackMaxDuration() {
        return this.trackMaxDuration;
    }

    public String getTrackUrl() {
        return this.trackUrl;
    }

    public String getWinReportUrl() {
        return this.winReportUrl;
    }

    public abstract void onDestroy();

    public abstract void sendLossNotification(String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void sendMaterialInformation(MaterialInformationBean materialInformationBean) {
        try {
            String json = GsonUtils.getInstance().toJson(materialInformationBean);
            byte[] encryptByt = AesUtil.encryptByt(GZIPUtils.compress(json, "utf-8"), ConstantInfo.getAppToken());
            appd.appa(TAG, "【物料信息上报——>request】:url=" + WMAdSdk.baseApiUrl + "/sdk/trackadm.api", "bean=" + json);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(WMAdSdk.baseTrackUrl);
            sb2.append("/sdk/trackadm.api");
            ((PostRequest) OkHttp.post(sb2.toString()).headers("Content-Type", "application/json")).upBytes(encryptByt).execute(new C0018appa(this));
        } catch (Throwable th) {
            appd.appe(TAG, "物料信息上报失败:" + th);
        }
    }

    public abstract void sendWinNotification(String str, String str2);

    public void setAdCacheTime(int i10) {
        this.adCacheTime = i10;
    }

    public void setCrid(String str) {
        this.crid = str;
    }

    public void setDspPrice(int i10) {
        this.dspPrice = i10;
    }

    public void setExpireTime(long j10) {
        this.expireTime = j10;
    }

    public void setInValidCrids(List<String> list) {
        this.inValidCrids = list;
    }

    public void setMediaBidPrice(int i10) {
        this.mediaBidPrice = i10;
    }

    public void setThirdSlotIdKey(int i10) {
        this.thirdSlotIdKey = i10;
    }

    public void setTrackEventTypes(List<String> list) {
        this.trackEventTypes = list;
    }

    public void setTrackInfo(String str, List<String> list, long j10) {
        this.trackUrl = str;
        this.trackEventTypes = list;
        this.trackMaxDuration = j10;
    }

    public void setTrackMaxDuration(long j10) {
        this.trackMaxDuration = j10;
    }

    public void setTrackUrl(String str) {
        this.trackUrl = str;
    }

    public void setWinReportUrl(String str) {
        this.winReportUrl = str;
    }
}
