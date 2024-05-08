package com.huawei.appgallery.agd.serverreq.store;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.common.support.global.HomeCountryUtils;
import com.huawei.appgallery.agd.common.support.storage.BaseSharedPreference;
import com.huawei.appgallery.agd.serverreq.ServerReqLog;
import com.huawei.appgallery.agd.serverreq.store.bean.SignInfoBean;
import com.huawei.appgallery.agd.serverreq.store.bean.SignRecordBean;
import com.huawei.appgallery.agd.serverreq.utils.device.TelphoneInformationManager;
import com.huawei.appgallery.agd.serverreq.utils.os.HwDeviceIdEx;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class SignSession extends BaseSharedPreference {

    /* renamed from: c, reason: collision with root package name */
    public static volatile SignSession f27533c;

    /* renamed from: a, reason: collision with root package name */
    public ISignProvider f27534a;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, SignInfoBean> f27535b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface ISignProvider {
        String getSign();
    }

    public SignSession() {
        super(ApplicationWrapper.getInstance().getContext());
        this.f27535b = null;
    }

    public static synchronized SignSession getInstance() {
        SignSession signSession;
        synchronized (SignSession.class) {
            if (f27533c == null) {
                f27533c = new SignSession();
            }
            signSession = f27533c;
        }
        return signSession;
    }

    @Nullable
    public final JSONObject a() {
        String d10 = d();
        if (TextUtils.isEmpty(d10)) {
            return null;
        }
        try {
            return new JSONObject(d10);
        } catch (JSONException unused) {
            ServerReqLog.LOG.e("SignSession", "getSignInfo json error");
            this.sp.edit().remove("appstore.client.sign.param").apply();
            return null;
        }
    }

    public final void b(SignRecordBean signRecordBean) {
        if (signRecordBean == null) {
            return;
        }
        try {
            putString("appstore.client.sign.param", new JSONObject(signRecordBean.toJson()).toString());
            this.sp.edit().apply();
        } catch (Exception e2) {
            ServerReqLog.LOG.e("SignSession", "saveSignRecord error!!" + ((Object) e2));
        }
    }

    public final SignRecordBean c() {
        SignRecordBean signRecordBean = new SignRecordBean();
        JSONObject a10 = a();
        if (a10 == null) {
            return null;
        }
        try {
            signRecordBean.fromJson(a10);
            return signRecordBean;
        } catch (JSONException unused) {
            ServerReqLog.LOG.w("SignSession", "SignRecord data convert failed JSONException");
            return null;
        }
    }

    public final String d() {
        try {
            return getString("appstore.client.sign.param", null);
        } catch (Exception e2) {
            ServerReqLog.LOG.e("SignSession", "getString error!!key:appstore.client.sign.param", e2);
            this.sp.edit().remove("appstore.client.sign.param").apply();
            return null;
        }
    }

    public String getAGSign() {
        ISignProvider iSignProvider = this.f27534a;
        return iSignProvider != null ? iSignProvider.getSign() : "";
    }

    public String getSign() {
        ServerReqLog serverReqLog;
        String str;
        ISignProvider iSignProvider = this.f27534a;
        if (iSignProvider != null) {
            String sign = iSignProvider.getSign();
            if (!TextUtils.isEmpty(sign)) {
                ServerReqLog.LOG.i("SignSession", "return from sign provider");
                return sign;
            }
        }
        Map<String, SignInfoBean> map = this.f27535b;
        if (map == null) {
            SignRecordBean c4 = c();
            if (c4 == null || c4.getItems() == null || c4.getItems().isEmpty()) {
                serverReqLog = ServerReqLog.LOG;
                str = "SignRecord items is null";
                serverReqLog.d("SignSession", str);
                return null;
            }
            map = c4.getItems();
        }
        String homeCountry = HomeCountryUtils.getHomeCountry();
        String deviceUniqueId = HwDeviceIdEx.getInstance().getDeviceUniqueId();
        SignInfoBean signInfoBean = map.get(homeCountry);
        if (signInfoBean == null) {
            serverReqLog = ServerReqLog.LOG;
            str = "current country SignRecord item is null";
        } else {
            if (!TextUtils.isEmpty(signInfoBean.getDeviceId()) && !TextUtils.isEmpty(signInfoBean.getDeviceLanguage()) && !TextUtils.isEmpty(signInfoBean.getSign()) && signInfoBean.getDeviceId().equals(deviceUniqueId) && signInfoBean.getDeviceLanguage().equals(TelphoneInformationManager.getTelephoneLanguage()) && signInfoBean.getTimestamp() >= System.currentTimeMillis() - 259200000) {
                return signInfoBean.getSign();
            }
            serverReqLog = ServerReqLog.LOG;
            str = "current country SignRecord item is exist, but invalid";
        }
        serverReqLog.d("SignSession", str);
        return null;
    }

    public void setSign(String str, String str2, String str3, String str4) {
        SignInfoBean build = new SignInfoBean.Builder().deviceId(str3).deviceLanguage(str4).timestamp(System.currentTimeMillis()).sign(str).build();
        Map<String, SignInfoBean> concurrentHashMap = new ConcurrentHashMap<>();
        if (c() != null && c().getItems() != null) {
            concurrentHashMap = c().getItems();
        }
        concurrentHashMap.put(str2, build);
        this.f27535b = concurrentHashMap;
        SignRecordBean signRecordBean = new SignRecordBean();
        signRecordBean.setItems(concurrentHashMap);
        b(signRecordBean);
    }

    public void setSignProvider(ISignProvider iSignProvider) {
        this.f27534a = iSignProvider;
    }
}
