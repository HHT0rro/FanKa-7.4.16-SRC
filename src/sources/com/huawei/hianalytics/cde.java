package com.huawei.hianalytics;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.transport.ITransportHandler;
import com.huawei.hianalytics.core.transport.net.HttpTransportHandler;
import com.huawei.hianalytics.core.transport.net.Response;
import com.huawei.hianalytics.framework.config.CipherType;
import com.huawei.hianalytics.framework.config.IMandatoryParameters;
import com.huawei.hianalytics.framework.constant.FrameworkConstant;
import com.huawei.hianalytics.framework.data.ConfigManager;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hianalytics.util.DeviceUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class cde implements IMandatoryParameters {
    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public boolean checkDebugModeEnabled() {
        return DeviceUtil.checkDebugModeEnabled(d.lmn());
    }

    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public List<String> getAllTags() {
        return HiAnalyticsManager.getAllTags();
    }

    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public String getAppVer() {
        return c.klm().lmn.def;
    }

    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public String getCaCertificatePath() {
        return "";
    }

    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public CipherType getCipherType() {
        return CipherType.AESGCM;
    }

    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public Context getContext() {
        return d.lmn();
    }

    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public String getDebugModeUrl() {
        return DeviceUtil.getDebugModeUrl();
    }

    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public String getLoadWorkKey() {
        return q.lmn().klm();
    }

    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public String getModel() {
        return Build.MODEL;
    }

    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public String[] getPreInstallURL() {
        return (String[]) c.klm().lmn.f28749f.clone();
    }

    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public String getProcessName() {
        return h0.lmn(d.lmn());
    }

    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public ITransportHandler.Protocols getProtocols() {
        if (Build.VERSION.SDK_INT >= 29) {
            return ITransportHandler.Protocols.TLS1_3;
        }
        return ITransportHandler.Protocols.TLS1_2;
    }

    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public String getRsaPublicKeyFromNetWork(String str, String str2) {
        String str3;
        Response response;
        String str4 = c.klm().lmn.f28756m;
        if (TextUtils.isEmpty(str4)) {
            str4 = j0.lmn("Privacy_MY", "public_key_version", "");
            c.klm().lmn.f28756m = str4;
        }
        if (FrameworkConstant.DataType.STRING_MAINT.equals(str2)) {
            str3 = c.klm().lmn.f28753j;
            if (TextUtils.isEmpty(str3)) {
                str3 = ua.a.d("HiAnalytics_Sdk_Public_Sp_Key", j0.lmn("Privacy_MY", "public_key_maint", ""));
                c.klm().lmn.f28753j = str3;
            }
        } else {
            str3 = c.klm().lmn.f28752i;
            if (TextUtils.isEmpty(str3)) {
                str3 = ua.a.d("HiAnalytics_Sdk_Public_Sp_Key", j0.lmn("Privacy_MY", "public_key_oper", ""));
                c.klm().lmn.f28752i = str3;
            }
        }
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && !f0.lmn()) {
            return str3;
        }
        w lmn = d.lmn(str, str2);
        String[] strArr = {FrameworkConstant.HttpUrls.GET_PUB_KEY_URL.replace(FrameworkConstant.URL_PALCEHOLDER, lmn != null ? lmn.hij : "")};
        HttpTransportHandler httpTransportHandler = new HttpTransportHandler();
        httpTransportHandler.setUrls(strArr);
        z lmn2 = c.klm().lmn(str);
        String str5 = lmn2 != null ? lmn2.hij : "";
        if (TextUtils.isEmpty(str5)) {
            e eVar = c.klm().lmn;
            if (TextUtils.isEmpty(eVar.fgh)) {
                str5 = eVar.ghi;
            } else {
                str5 = eVar.fgh;
            }
        }
        HashMap hashMap = new HashMap();
        w lmn3 = d.lmn(str, str2);
        Map<String, String> map = lmn3 != null ? lmn3.f28847a : null;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if ("x-hasdk-pkg".equals(entry.getKey()) && "com.huawei.hms.analytics".equals(entry.getValue())) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        hashMap.put("App-Id", str5);
        httpTransportHandler.setHttpHeaders(hashMap);
        httpTransportHandler.setReportData(new byte[0]);
        IMandatoryParameters parameters = ConfigManager.getInstance().getParameters();
        httpTransportHandler.setSSLConfig(parameters.getContext(), parameters.getProtocols(), parameters.getCaCertificatePath(), parameters.isHighCipher());
        try {
            response = httpTransportHandler.executePublicKey();
        } catch (Exception e2) {
            StringBuilder b4 = e9.a.b("get pubKey response Exception :");
            b4.append(e2.getMessage());
            HiLog.sw("GetPublicKey", b4.toString());
            response = null;
        }
        if (response != null) {
            if (response.getHttpCode() == 200) {
                if (!TextUtils.isEmpty(response.getContent())) {
                    try {
                        JSONObject jSONObject = new JSONObject(response.getContent());
                        String optString = jSONObject.optString("publicKey");
                        String optString2 = jSONObject.optString("publicKeyOM");
                        String optString3 = jSONObject.optString("pubkey_version");
                        String str6 = System.currentTimeMillis() + "";
                        String optString4 = jSONObject.optString("timeInterval");
                        j0.klm("Privacy_MY", "public_key_oper", ua.a.g("HiAnalytics_Sdk_Public_Sp_Key", optString));
                        j0.klm("Privacy_MY", "public_key_maint", ua.a.g("HiAnalytics_Sdk_Public_Sp_Key", optString2));
                        j0.klm("Privacy_MY", "public_key_time_interval", optString4);
                        j0.klm("Privacy_MY", "public_key_time_last", str6);
                        j0.klm("Privacy_MY", "public_key_version", optString3);
                        c.klm().lmn.f28752i = optString;
                        c.klm().lmn.f28753j = optString2;
                        c.klm().lmn.f28756m = optString3;
                        c.klm().lmn.f28755l = str6;
                        c.klm().lmn.f28754k = optString4;
                        if (FrameworkConstant.DataType.STRING_MAINT.equals(str2)) {
                            f0.lmn = optString2;
                        } else {
                            f0.lmn = optString;
                        }
                        HiLog.si("GetPublicKey", "get pubKey success");
                    } catch (JSONException e10) {
                        StringBuilder b10 = e9.a.b("get pubKey parse json JSONException :");
                        b10.append(e10.getMessage());
                        HiLog.sw("GetPublicKey", b10.toString());
                    }
                }
            } else {
                StringBuilder b11 = e9.a.b("get pubKey fail HttpCode :");
                b11.append(response.getHttpCode());
                HiLog.sw("GetPublicKey", b11.toString());
            }
        } else {
            HiLog.sw("GetPublicKey", "get pubKey response is null");
        }
        return f0.lmn;
    }

    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public boolean isFlashKey() {
        long lmn = j0.lmn("analytics_key", "flashKeyTime", -1L);
        if (lmn == -1) {
            lmn = j0.lmn("Privacy_MY", "flashKeyTime", -1L);
        } else {
            j0.lmn(d.lmn(), "analytics_key");
        }
        return System.currentTimeMillis() - lmn > 1296000000;
    }

    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public boolean isGCMParameterSpec() {
        return true;
    }

    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public boolean isHighCipher() {
        return true;
    }

    @Override // com.huawei.hianalytics.framework.config.IMandatoryParameters
    public void refreshKey(String str, int i10) {
        q lmn = q.lmn();
        Objects.requireNonNull(lmn);
        if (TextUtils.isEmpty(str) || i10 != 1) {
            return;
        }
        lmn.klm(lmn.lmn(str));
    }
}
