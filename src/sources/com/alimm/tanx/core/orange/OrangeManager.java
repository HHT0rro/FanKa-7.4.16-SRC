package com.alimm.tanx.core.orange;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.net.NetWorkManager;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.orange.bean.ExposureConfigBean;
import com.alimm.tanx.core.orange.bean.OrangeBean;
import com.alimm.tanx.core.request.C;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.AssetsUtil;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.SharedPreferencesHelper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class OrangeManager implements NotConfused {
    public static final String FEED_VIDEO_MAX_SIZE = "feedVideoMaxSize";
    public static final String TAG = "OrangeManager";
    public static volatile OrangeManager instance;
    public volatile OrangeBean orangeBean;
    public OrangeInitListener orangeInitListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void callBack() {
        OrangeInitListener orangeInitListener = this.orangeInitListener;
        if (orangeInitListener != null) {
            orangeInitListener.initFinish(this.orangeBean);
        }
    }

    private void checkAndCreateDefaultOrange() {
        try {
            if (this.orangeBean == null) {
                String fromAssets = getFromAssets("orange.json");
                if (TextUtils.isEmpty(fromAssets)) {
                    return;
                }
                this.orangeBean = (OrangeBean) JSON.parseObject(fromAssets, OrangeBean.class);
                LogUtils.d(TAG, "本地初始orange配置->" + fromAssets);
            }
        } catch (Exception e2) {
            LogUtils.e(TAG, e2);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), TAG, LogUtils.getStackTraceMessage(e2), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkOrangeVersion2Write(OrangeBean orangeBean) {
        if (orangeBean != null && (this.orangeBean == null || this.orangeBean.version < orangeBean.version)) {
            writeOrange(orangeBean);
            this.orangeBean = orangeBean;
        }
        callBack();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int defaultFeedInteractionParam(String str) {
        char c4;
        str.hashCode();
        switch (str.hashCode()) {
            case -1059030137:
                if (str.equals("directionSlideDistance")) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            case 103203022:
                if (str.equals("slideDirection")) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            case 1348276389:
                if (str.equals("allSlideDistance")) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        switch (c4) {
            case 0:
                return 55;
            case 1:
                return 1;
            case 2:
                return 120;
            default:
                return -1;
        }
    }

    public static OrangeManager getInstance() {
        if (instance == null) {
            synchronized (OrangeManager.class) {
                if (instance == null) {
                    instance = new OrangeManager();
                }
            }
        }
        return instance;
    }

    private void readLocalOrange() {
        try {
            SharedPreferencesHelper sharedPreferencesHelper = SharedPreferencesHelper.getInstance();
            SharedPreferencesHelper.getInstance();
            String string = sharedPreferencesHelper.getString(SharedPreferencesHelper.KEY_ORANGE);
            if (!TextUtils.isEmpty(string)) {
                this.orangeBean = (OrangeBean) JSON.parseObject(string, OrangeBean.class);
                LogUtils.d(TAG, "Orange本地版本为->" + this.orangeBean.version);
                LogUtils.d(TAG, "本地orange配置->" + JSON.toJSONString(this.orangeBean));
            }
        } catch (Exception e2) {
            LogUtils.e(TAG, e2);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), TAG, LogUtils.getStackTraceMessage(e2), "");
        }
        checkAndCreateDefaultOrange();
    }

    private void request() {
        RequestBean build = new RequestBean().setUrl(C.getOrangeUrl()).build();
        build.setOverrideError(true);
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json; charset=utf-8");
        build.setHeads(hashMap);
        NetWorkManager.getInstance().sendHttpGet(build, OrangeBean.class, new NetWorkCallBack<OrangeBean>() { // from class: com.alimm.tanx.core.orange.OrangeManager.1
            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            public void error(int i10, String str, String str2) {
                LogUtils.e(OrangeManager.TAG, "orange配置拉取失败-> code:" + i10 + " reqId:" + str + "  error->" + str2);
                OrangeManager.this.callBack();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("orange配置拉取失败-> code:");
                sb2.append(i10);
                sb2.append("  error->");
                sb2.append(str2);
                TanxBaseUt.utError(i10, OrangeManager.TAG, sb2.toString(), "");
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
            public void succ(OrangeBean orangeBean) {
                OrangeManager.this.checkOrangeVersion2Write(orangeBean);
                LogUtils.d(OrangeManager.TAG, "Orange服务器版本为->" + orangeBean.version);
            }
        });
    }

    private void writeOrange(OrangeBean orangeBean) {
        try {
            LogUtils.d(TAG, "覆盖本地orange配置->" + JSON.toJSONString(orangeBean));
            SharedPreferencesHelper sharedPreferencesHelper = SharedPreferencesHelper.getInstance();
            SharedPreferencesHelper.getInstance();
            sharedPreferencesHelper.putString(SharedPreferencesHelper.KEY_ORANGE, JSON.toJSONString(orangeBean));
        } catch (Exception e2) {
            LogUtils.e(TAG, e2);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), TAG, LogUtils.getStackTraceMessage(e2), "");
        }
    }

    public boolean getAdSwitch(String str) {
        if (this.orangeBean == null || this.orangeBean.adSwitch == null || this.orangeBean.adSwitch.get(str) == null || str == null) {
            return true;
        }
        return this.orangeBean.adSwitch.get(str).booleanValue();
    }

    public boolean getAllAppImageSwitch() {
        if (this.orangeBean == null || this.orangeBean.imageSwitch == null || this.orangeBean.imageSwitch.get("AllApp") == null) {
            return false;
        }
        return this.orangeBean.imageSwitch.get("AllApp").booleanValue();
    }

    public boolean getCommonSwitch(String str) {
        if (this.orangeBean == null || this.orangeBean.commonSwitch == null || this.orangeBean.commonSwitch.get(str) == null) {
            return false;
        }
        return "true".equalsIgnoreCase(this.orangeBean.commonSwitch.get(str));
    }

    public ExposureConfigBean getExposureConfigBean(int i10) {
        try {
            if (this.orangeBean != null && this.orangeBean.exposureConfig != null && this.orangeBean.exposureConfig.size() > 0 && TanxCoreSdk.getConfig() != null && !TextUtils.isEmpty(TanxCoreSdk.getConfig().getAppKey())) {
                ExposureConfigBean exposureConfigBean = null;
                for (int i11 = 0; i11 < this.orangeBean.exposureConfig.size(); i11++) {
                    if (this.orangeBean.exposureConfig.get(i11).key.equals(TanxCoreSdk.getConfig().getAppKey()) && this.orangeBean.exposureConfig.get(i11).adType == i10) {
                        return this.orangeBean.exposureConfig.get(i11);
                    }
                    if (this.orangeBean.exposureConfig.get(i11).key.equals("default") && this.orangeBean.exposureConfig.get(i11).adType == i10 && exposureConfigBean == null) {
                        exposureConfigBean = this.orangeBean.exposureConfig.get(i11);
                    }
                }
                return exposureConfigBean;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public String getFeedInteractionGifUrlParam(String str) {
        if (this.orangeBean == null || this.orangeBean.feedInteractionParam == null) {
            return "https://img.alicdn.com/imgextra/i3/O1CN01yaPRML1GyyqsOZP7R_!!6000000000692-1-tps-1200-432.gif";
        }
        String str2 = this.orangeBean.feedInteractionParam.get(str);
        return TextUtils.isEmpty(str2) ? "https://img.alicdn.com/imgextra/i3/O1CN01yaPRML1GyyqsOZP7R_!!6000000000692-1-tps-1200-432.gif" : str2;
    }

    public int getFeedInteractionParam2Integer(String str) {
        try {
            if (this.orangeBean != null && this.orangeBean.feedInteractionParam != null) {
                String str2 = this.orangeBean.feedInteractionParam.get(str);
                if (TextUtils.isEmpty(str2)) {
                    return defaultFeedInteractionParam(str);
                }
                return Integer.parseInt(str2);
            }
            return defaultFeedInteractionParam(str);
        } catch (Exception unused) {
            return -1;
        }
    }

    public String getFromAssets(String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(AssetsUtil.getApplicationAssets(TanxCoreSdk.getApplication()).open(str)));
            String str2 = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return str2;
                }
                str2 = str2 + readLine;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public boolean getImageSwitch(String str) {
        if (this.orangeBean == null || this.orangeBean.imageSwitch == null || this.orangeBean.imageSwitch.get(str) == null) {
            return false;
        }
        return this.orangeBean.imageSwitch.get(str).booleanValue();
    }

    public HashMap<String, Boolean> getInstallSwitch() {
        if (this.orangeBean != null && this.orangeBean.installStatusSwitch != null) {
            return this.orangeBean.installStatusSwitch;
        }
        return new HashMap<>();
    }

    public OrangeBean getOrangeBean() {
        return this.orangeBean;
    }

    public long getThreshold(String str) {
        if (this.orangeBean == null || this.orangeBean.threshold == null || this.orangeBean.threshold.get(str) == null) {
            return -1L;
        }
        return this.orangeBean.threshold.get(str).longValue();
    }

    public int getUtUploadMaxCount() {
        if (this.orangeBean == null || this.orangeBean.ut == null) {
            return -1;
        }
        return this.orangeBean.ut.uploadMaxCount;
    }

    public boolean getWebSuffixWhiteSwitch(String str) {
        if (this.orangeBean != null && this.orangeBean.webSuffixWhiteList != null) {
            if (this.orangeBean.webSuffixWhiteList.get(str) == null) {
                return false;
            }
            return this.orangeBean.webSuffixWhiteList.get(str).booleanValue();
        }
        String[] strArr = {"com", "cn", "htm", "html", "php", "tf"};
        for (int i10 = 0; i10 < 6; i10++) {
            if (strArr[i10].equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void init() {
        init(null);
    }

    public void init(OrangeInitListener orangeInitListener) {
        this.orangeInitListener = orangeInitListener;
        readLocalOrange();
        request();
    }
}
