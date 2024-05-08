package com.huawei.hianalytics.process.impl;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.b0;
import com.huawei.hianalytics.bcd;
import com.huawei.hianalytics.c;
import com.huawei.hianalytics.cde;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.e0;
import com.huawei.hianalytics.fgh;
import com.huawei.hianalytics.framework.HAFrameworkInstance;
import com.huawei.hianalytics.framework.config.ICallback;
import com.huawei.hianalytics.framework.constant.FrameworkConstant;
import com.huawei.hianalytics.framework.session.SessionHandler;
import com.huawei.hianalytics.g;
import com.huawei.hianalytics.g0;
import com.huawei.hianalytics.i0;
import com.huawei.hianalytics.j0;
import com.huawei.hianalytics.l0;
import com.huawei.hianalytics.log.LogTag;
import com.huawei.hianalytics.m;
import com.huawei.hianalytics.o;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.w;
import com.huawei.hianalytics.z;
import com.inno.innosdk.pb.InnoMain;
import e9.a;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HAImpl implements HiAnalyticsInstance {
    public static final String TAG = LogTag.get(HiAnalyticsInstance.class, new Class[0]);
    public HAFrameworkInstance frameworkInstance;
    public z instData;
    public long onResumeTime;
    public String strTAG;

    public HAImpl(String str) {
        this.strTAG = str;
        this.instData = new z(str);
        try {
            this.frameworkInstance = new HAFrameworkInstance.Builder().setStorageHandler(g.lmn(c.klm().lmn().lmn())).setStoragePolicy(new bcd(this.strTAG)).setCollectorConfig(new fgh(this.strTAG)).setMandatoryParameters(new cde()).build(this.strTAG);
        } catch (IllegalArgumentException e2) {
            String str2 = TAG;
            StringBuilder b4 = a.b("init HAImpl create frameworkInstance failed  IllegalArgumentException e : ");
            b4.append(e2.getMessage());
            HiLog.e(str2, b4.toString());
            this.frameworkInstance = null;
        } catch (Exception e10) {
            String str3 = TAG;
            StringBuilder b10 = a.b("init HAImpl create frameworkInstance failed  Exception e : ");
            b10.append(e10.getMessage());
            HiLog.e(str3, b10.toString());
            this.frameworkInstance = null;
        }
    }

    private String changeType(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? "allType" : FrameworkConstant.DataType.STRING_DIFFPRIVACY : FrameworkConstant.DataType.STRING_PREINS : FrameworkConstant.DataType.STRING_MAINT : FrameworkConstant.DataType.STRING_OPER;
    }

    private w getConfigByType(int i10) {
        if (i10 == 0) {
            return this.instData.klm;
        }
        if (i10 == 1) {
            return this.instData.lmn;
        }
        if (i10 == 2) {
            return this.instData.ijk;
        }
        if (i10 != 3) {
            return null;
        }
        return this.instData.ikl;
    }

    private void postEvent(String str, LinkedHashMap<String, String> linkedHashMap, String str2, String str3) {
        this.frameworkInstance.onEvent(FrameworkConstant.DataType.STRING_OPER, str2, e0.lmn(str, "OnPause".equals(str3) ? System.currentTimeMillis() - this.onResumeTime : 0L, linkedHashMap, str3), new b0());
    }

    private void setInstanceUUID(String str) {
        z zVar = this.instData;
        w wVar = zVar.klm;
        if (wVar != null) {
            wVar.lmn = str;
        }
        w wVar2 = zVar.lmn;
        if (wVar2 != null) {
            wVar2.lmn = str;
        }
        w wVar3 = zVar.ikl;
        if (wVar3 != null) {
            wVar3.lmn = str;
        }
        w wVar4 = zVar.ijk;
        if (wVar4 != null) {
            wVar4.lmn = str;
        }
    }

    private boolean verifyURL(int i10) {
        if (i10 == 2) {
            if ("_default_config_tag".equals(this.strTAG)) {
                return true;
            }
            HiLog.w(TAG, "verifyURL(): type: preins. Only default config can report Pre-install data.");
            return false;
        }
        w configByType = getConfigByType(i10);
        if (configByType != null && !TextUtils.isEmpty(configByType.hij)) {
            return true;
        }
        HiLog.sw(TAG, "verifyURL(): URL check failed.TAG: %s,TYPE: %d", this.strTAG, Integer.valueOf(i10));
        return false;
    }

    public void autoEvent(String str, String str2, JSONObject jSONObject, ICallback iCallback) {
        getFrameworkInstance().onEvent(str, str2, jSONObject, iCallback);
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void clearData() {
        String str = TAG;
        StringBuilder b4 = a.b("HiAnalyticsInstance.clearData is execute.TAG: ");
        b4.append(this.strTAG);
        HiLog.i(str, b4.toString());
        this.frameworkInstance.clearCacheDataByTag();
    }

    public HAFrameworkInstance getFrameworkInstance() {
        return this.frameworkInstance;
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public String getUUID(int i10) {
        m lmn = m.lmn();
        String str = this.strTAG;
        String changeType = changeType(i10);
        Objects.requireNonNull(lmn);
        return o.lmn(str, changeType);
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void newInstanceUUID() {
        String str = TAG;
        StringBuilder b4 = a.b("HiAnalyticsInstance.newInstanceUUID is executed.TAG: ");
        b4.append(this.strTAG);
        HiLog.i(str, b4.toString());
        String lmn = j0.lmn("global_v2", this.strTAG, "");
        if (!TextUtils.isEmpty(lmn)) {
            if (lmn.length() > 32) {
                String d10 = ua.a.d("HiAnalytics_Sdk_Uuid_Sp_Key", lmn);
                if (!TextUtils.isEmpty(d10)) {
                    j0.klm("global_v2", this.strTAG, d10);
                    lmn = d10;
                }
            }
        } else {
            lmn = UUID.randomUUID().toString().replace("-", "");
            j0.klm("global_v2", this.strTAG, lmn);
        }
        setInstanceUUID(lmn);
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onBackground(long j10) {
        String str = TAG;
        StringBuilder b4 = a.b("HiAnalyticsInstance.onBackground() is executed.TAG : ");
        b4.append(this.strTAG);
        HiLog.i(str, b4.toString());
        w wVar = this.instData.klm;
        if (wVar != null) {
            if (wVar.ikl) {
                this.frameworkInstance.onBackground(j10);
                return;
            } else {
                HiLog.sw(str, "No Session switch is set.");
                return;
            }
        }
        HiLog.sw(str, "No operConf");
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onEvent(Context context, String str, String str2) {
        String str3 = TAG;
        StringBuilder b4 = a.b("onEvent(context), TAG : ");
        b4.append(this.strTAG);
        b4.append(", eventId: ");
        b4.append(str);
        HiLog.si(str3, b4.toString());
        if (!l0.ijk.lmn()) {
            a.e(a.b("userManager.isUserUnlocked() == false.TAG : "), this.strTAG, str3);
            return;
        }
        if (context == null) {
            a.e(a.b("context is null in on event.TAG : "), this.strTAG, str3);
            return;
        }
        if (!i0.lmn(str) && verifyURL(0)) {
            if (!i0.lmn("value", str2, 65536)) {
                a.e(a.b("onEvent() parameter VALUE is overlong, content will be cleared.TAG: "), this.strTAG, str3);
                str2 = "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("_constants", str2);
                this.frameworkInstance.onEvent(FrameworkConstant.DataType.STRING_OPER, str, jSONObject, new b0());
                return;
            } catch (JSONException unused) {
                String str4 = TAG;
                StringBuilder b10 = a.b("onEvent():JSON structure Exception! TAG : ");
                b10.append(this.strTAG);
                HiLog.e(str4, b10.toString());
                return;
            }
        }
        a.e(a.b("onEvent() parameters check fail. Nothing will be recorded.TAG: "), this.strTAG, str3);
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onForeground(long j10) {
        String str = TAG;
        StringBuilder b4 = a.b("HiAnalyticsInstance.onForeground() is executed。TAG : ");
        b4.append(this.strTAG);
        HiLog.i(str, b4.toString());
        w wVar = this.instData.klm;
        if (wVar != null) {
            if (wVar.ikl) {
                this.frameworkInstance.onForeground(j10);
                return;
            } else {
                HiLog.sw(str, "No Session switch is set.");
                return;
            }
        }
        HiLog.sw(str, "No operConf");
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onPause(Context context) {
        String str = TAG;
        StringBuilder b4 = a.b("onPause(context). TAG: ");
        b4.append(this.strTAG);
        HiLog.i(str, b4.toString());
        if (!l0.ijk.lmn()) {
            a.e(a.b("userManager.isUserUnlocked() == false.TAG: "), this.strTAG, str);
            return;
        }
        if (context == null) {
            a.e(a.b("context is null in onPause! Nothing will be recorded.TAG: "), this.strTAG, str);
        } else if (!verifyURL(0)) {
            a.e(a.b("onPause() URL check fail. Nothing will be recorded.TAG: "), this.strTAG, str);
        } else {
            postEvent(context.getClass().getCanonicalName(), null, "$AppOnPause", "OnPause");
            this.onResumeTime = 0L;
        }
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onReport(int i10) {
        String str = TAG;
        StringBuilder b4 = a.b("onReport(type). TAG:");
        b4.append(this.strTAG);
        b4.append(", TYPE:");
        b4.append(i10);
        HiLog.i(str, b4.toString());
        if (l0.ijk.lmn()) {
            this.frameworkInstance.onReport(changeType(i10), new b0());
        } else {
            HiLog.sw(str, "userManager.isUserUnlocked() == false.TAG: %s,TYPE: %d", this.strTAG, Integer.valueOf(i10));
        }
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onResume(Context context) {
        String str = TAG;
        StringBuilder b4 = a.b("onResume(context). TAG: ");
        b4.append(this.strTAG);
        HiLog.i(str, b4.toString());
        if (!l0.ijk.lmn()) {
            a.e(a.b("userManager.isUserUnlocked() == false.TAG: "), this.strTAG, str);
            return;
        }
        if (context == null) {
            a.e(a.b("context is null in onResume! Nothing will be recorded.TAG: "), this.strTAG, str);
        } else if (!verifyURL(0)) {
            a.e(a.b("onResume() URL check fail. Nothing will be recorded.TAG: "), this.strTAG, str);
        } else {
            this.onResumeTime = System.currentTimeMillis();
            postEvent(context.getClass().getCanonicalName(), null, "$AppOnResume", "OnResume");
        }
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onStreamEvent(int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        JSONObject lmn;
        String str2 = TAG;
        StringBuilder b4 = a.b("onStreamEvent(). TAG:");
        b4.append(this.strTAG);
        b4.append(", TYPE:");
        b4.append(i10);
        b4.append(", eventId:");
        b4.append(str);
        HiLog.si(str2, b4.toString());
        if (!l0.ijk.lmn()) {
            HiLog.sw(str2, "userManager.isUserUnlocked() == false.TAG: %s,TYPE: %d", this.strTAG, Integer.valueOf(i10));
            return;
        }
        if (i0.lmn(str) || !verifyURL(i10)) {
            HiLog.sw(str2, "onEventIM() parameters check fail. Nothing will be recorded.TAG: %s,TYPE: %d", this.strTAG, Integer.valueOf(i10));
            return;
        }
        if (!i0.klm(linkedHashMap)) {
            HiLog.sw(str2, "onEventIM() parameter mapValue will be cleared.TAG: %s,TYPE: %d", this.strTAG, Integer.valueOf(i10));
            linkedHashMap = null;
        }
        if (linkedHashMap == null) {
            lmn = new JSONObject();
        } else {
            lmn = g0.lmn(linkedHashMap);
        }
        this.frameworkInstance.onStreamEvent(changeType(i10), str, lmn, new b0());
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void refresh(int i10, HiAnalyticsConfig hiAnalyticsConfig) {
        HiAnalyticsConfig hiAnalyticsConfig2;
        if (hiAnalyticsConfig == null) {
            HiLog.si(TAG, "HiAnalyticsInstance.refresh(). Parameter config is null.TAG : %s , TYPE : %d", this.strTAG, Integer.valueOf(i10));
            hiAnalyticsConfig2 = null;
        } else {
            hiAnalyticsConfig2 = new HiAnalyticsConfig(hiAnalyticsConfig);
        }
        String str = TAG;
        HiLog.i(str, "HiAnalyticsInstance.refresh() is executed.TAG : %s , TYPE : %d", this.strTAG, Integer.valueOf(i10));
        if (i10 == 0) {
            setOperConf(hiAnalyticsConfig2);
            SessionHandler.getInstance().initSessionParameter(this.strTAG);
        } else {
            if (i10 == 1) {
                setMaintConf(hiAnalyticsConfig2);
                return;
            }
            if (i10 == 2) {
                setPreInstallConf(hiAnalyticsConfig2);
            } else if (i10 != 3) {
                a.e(a.b("refresh(): HiAnalyticsType can only be OPERATION ,MAINTAIN or DIFF_PRIVACY.TAG: "), this.strTAG, str);
            } else {
                setDiffConf(hiAnalyticsConfig2);
            }
        }
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void setAccountBrandId(String str) {
        if (!i0.lmn("accountBrandId", str, 256)) {
            str = "";
        }
        c.klm().lmn(this.strTAG).efg = str;
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void setAppBrandId(String str) {
        if (!i0.lmn("appBrandId", str, 256)) {
            str = "";
        }
        c.klm().lmn(this.strTAG).ghi = str;
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void setAppid(String str) {
        c.klm().lmn(this.strTAG).hij = i0.lmn("appID", str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", "");
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void setCommonProp(int i10, Map<String, String> map) {
        String str = TAG;
        HiLog.i(str, "HiAnalyticsInstance.setHiAnalyticsCommonProp() is executed.TAG : %s , TYPE : %d", this.strTAG, Integer.valueOf(i10));
        if (!i0.klm(map)) {
            HiLog.sw(str, "setHiAnalyticsCommonProp() parameter mapValue will be cleared.TAG : %s , TYPE : %d", this.strTAG, Integer.valueOf(i10));
            return;
        }
        JSONObject jSONObject = new JSONObject(map);
        w configByType = getConfigByType(i10);
        if (configByType == null) {
            HiLog.sw(str, "setHiAnalyticsCommonProp(): No related config found.TAG : %s , TYPE : %d", this.strTAG, Integer.valueOf(i10));
        } else {
            configByType.f28850d = String.valueOf(jSONObject);
        }
    }

    public void setDiffConf(HiAnalyticsConfig hiAnalyticsConfig) {
        String str = TAG;
        StringBuilder b4 = a.b("HiAnalyticsInstance.setDiffConf() is executed.TAG : ");
        b4.append(this.strTAG);
        HiLog.i(str, b4.toString());
        if (hiAnalyticsConfig == null) {
            StringBuilder b10 = a.b("HiAnalyticsInstance.setDiffConf(): config for diffPrivacy is null!.TAG: ");
            b10.append(this.strTAG);
            HiLog.w(str, b10.toString());
            this.instData.ikl = null;
            return;
        }
        this.instData.ikl = hiAnalyticsConfig.lmn;
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void setHandsetManufacturer(String str) {
        if (!i0.lmn("handsetManufacturer", str, 256)) {
            str = "";
        }
        c.klm().lmn(this.strTAG).def = str;
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void setHansetBrandId(String str) {
        if (!i0.lmn("hansetBrandId", str, 256)) {
            str = "";
        }
        c.klm().lmn(this.strTAG).fgh = str;
    }

    public void setMaintConf(HiAnalyticsConfig hiAnalyticsConfig) {
        String str = TAG;
        StringBuilder b4 = a.b("HiAnalyticsInstance.setMaintConf() is executed.TAG : ");
        b4.append(this.strTAG);
        HiLog.i(str, b4.toString());
        if (hiAnalyticsConfig == null) {
            HiLog.w(str, "HiAnalyticsInstance.setMaintConf(): config for maint is null!");
            this.instData.lmn = null;
        } else {
            this.instData.lmn = hiAnalyticsConfig.lmn;
        }
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void setOAID(int i10, String str) {
        String str2 = TAG;
        HiLog.i(str2, "HiAnalyticsInstance.setStrOAID() is executed.TAG : %s , TYPE : %d", this.strTAG, Integer.valueOf(i10));
        w configByType = getConfigByType(i10);
        if (configByType == null) {
            HiLog.sw(str2, "setOAID(): No related config found.TAG : %s , TYPE : %d", this.strTAG, Integer.valueOf(i10));
            return;
        }
        if (!i0.lmn(InnoMain.INNO_KEY_OAID, str, 4096)) {
            str = "";
        }
        configByType.ghi = str;
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void setOAIDTrackingFlag(int i10, boolean z10) {
        String str = TAG;
        HiLog.i(str, "HiAnalyticsInstance.setOAIDTrackingFlag() is executed.TAG : %s , TYPE : %d", this.strTAG, Integer.valueOf(i10));
        w configByType = getConfigByType(i10);
        if (configByType == null) {
            HiLog.sw(str, "setOAIDTrackingFlag(): No related config found.TAG : %s , TYPE : %d", this.strTAG, Integer.valueOf(i10));
        } else {
            configByType.fgh = z10 ? "true" : "false";
        }
    }

    public void setOperConf(HiAnalyticsConfig hiAnalyticsConfig) {
        String str = TAG;
        StringBuilder b4 = a.b("HiAnalyticsInstance.setOperConf() is executed.TAG: ");
        b4.append(this.strTAG);
        HiLog.i(str, b4.toString());
        if (hiAnalyticsConfig == null) {
            this.instData.klm = null;
            StringBuilder b10 = a.b("HiAnalyticsInstance.setOperConf(): config for oper is null!.TAG: ");
            b10.append(this.strTAG);
            HiLog.w(str, b10.toString());
            return;
        }
        this.instData.klm = hiAnalyticsConfig.lmn;
    }

    public void setPreInstallConf(HiAnalyticsConfig hiAnalyticsConfig) {
        String str = TAG;
        StringBuilder b4 = a.b("HiAnalyticsInstance.setPreInstallConf() is executed.TAG: ");
        b4.append(this.strTAG);
        HiLog.i(str, b4.toString());
        if (hiAnalyticsConfig == null) {
            StringBuilder b10 = a.b("HiAnalyticsInstance.setPreInstallConf(): config for PRE-INSTALL is null!.TAG: ");
            b10.append(this.strTAG);
            HiLog.w(str, b10.toString());
            this.instData.ijk = null;
            return;
        }
        this.instData.ijk = hiAnalyticsConfig.lmn;
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void setUpid(int i10, String str) {
        String str2 = TAG;
        HiLog.i(str2, "HiAnalyticsInstance.setUpid() is executed.TAG : %s , TYPE : %d", this.strTAG, Integer.valueOf(i10));
        w configByType = getConfigByType(i10);
        if (configByType == null) {
            HiLog.sw(str2, "setUpid(): No related config found.TAG : %s , TYPE : %d", this.strTAG, Integer.valueOf(i10));
            return;
        }
        if (!i0.lmn("upid", str, 4096)) {
            str = "";
        }
        configByType.efg = str;
    }

    public void autoEvent(String str, String str2, JSONObject jSONObject) {
        getFrameworkInstance().onEvent(str, str2, jSONObject, null);
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onReport(Context context, int i10) {
        String str = TAG;
        StringBuilder b4 = a.b("onReport(context,type). TAG:");
        b4.append(this.strTAG);
        b4.append(", TYPE:");
        b4.append(i10);
        HiLog.i(str, b4.toString());
        if (!l0.ijk.lmn()) {
            HiLog.sw(str, "userManager.isUserUnlocked() == false.TAG: %s,TYPE: %d", this.strTAG, Integer.valueOf(i10));
        } else if (context == null) {
            HiLog.sw(str, "context is null in onreport!.TAG: %s,TYPE: %d", this.strTAG, Integer.valueOf(i10));
        } else {
            this.frameworkInstance.onReport(changeType(i10), new b0());
        }
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onPause(Context context, LinkedHashMap<String, String> linkedHashMap) {
        String str = TAG;
        StringBuilder b4 = a.b("onPause(context,map). TAG: ");
        b4.append(this.strTAG);
        HiLog.i(str, b4.toString());
        if (!l0.ijk.lmn()) {
            a.e(a.b("userManager.isUserUnlocked() == false.TAG: "), this.strTAG, str);
            return;
        }
        if (context == null) {
            a.e(a.b("context is null in onPause! Nothing will be recorded..TAG: "), this.strTAG, str);
            return;
        }
        if (!verifyURL(0)) {
            a.e(a.b("onPause() URL check fail. Nothing will be recorded.TAG: "), this.strTAG, str);
            return;
        }
        if (!i0.klm(linkedHashMap)) {
            a.e(a.b("onPause() parameter mapValue will be cleared.TAG: "), this.strTAG, str);
            linkedHashMap = null;
        }
        postEvent(context.getClass().getCanonicalName(), linkedHashMap, "$AppOnPause", "OnPause");
        this.onResumeTime = 0L;
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onResume(Context context, LinkedHashMap<String, String> linkedHashMap) {
        if (context == null) {
            a.e(a.b("onResume's mContext is null.TAG: "), this.strTAG, TAG);
            return;
        }
        String str = TAG;
        StringBuilder b4 = a.b("onResume(context,map). TAG: ");
        b4.append(this.strTAG);
        HiLog.i(str, b4.toString());
        if (!l0.ijk.lmn()) {
            a.e(a.b("userManager.isUserUnlocked() == false.TAG: "), this.strTAG, str);
            return;
        }
        if (!verifyURL(0)) {
            a.e(a.b("onResume() URL check fail. Nothing will be recorded.TAG: "), this.strTAG, str);
            return;
        }
        if (!i0.klm(linkedHashMap)) {
            a.e(a.b("onResume() parameter mapValue will be cleared.TAG: "), this.strTAG, str);
            linkedHashMap = null;
        }
        this.onResumeTime = System.currentTimeMillis();
        postEvent(context.getClass().getCanonicalName(), linkedHashMap, "$AppOnResume", "OnResume");
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onStreamEvent(int i10, String str, LinkedHashMap<String, String> linkedHashMap, LinkedHashMap<String, String> linkedHashMap2, LinkedHashMap<String, String> linkedHashMap3) {
        JSONObject lmn;
        JSONObject lmn2;
        JSONObject lmn3;
        String str2 = TAG;
        StringBuilder b4 = a.b("onStreamEvent() Ex. TAG:");
        b4.append(this.strTAG);
        b4.append(", TYPE:");
        b4.append(i10);
        b4.append(", eventId:");
        b4.append(str);
        HiLog.si(str2, b4.toString());
        if (!l0.ijk.lmn()) {
            HiLog.sw(str2, "userManager.isUserUnlocked() == false.TAG: %s,TYPE: %d", this.strTAG, Integer.valueOf(i10));
            return;
        }
        if (!i0.lmn(str) && verifyURL(i10)) {
            LinkedHashMap<String, String> lmn4 = i0.lmn(linkedHashMap2);
            LinkedHashMap<String, String> lmn5 = i0.lmn(linkedHashMap3);
            if (!i0.klm(linkedHashMap)) {
                HiLog.sw(str2, "onStreamEvent() parameter mapValue will be cleared.TAG: %s,TYPE: %d", this.strTAG, Integer.valueOf(i10));
                linkedHashMap = null;
            }
            if (linkedHashMap == null) {
                lmn = new JSONObject();
            } else {
                lmn = g0.lmn(linkedHashMap);
            }
            JSONObject jSONObject = lmn;
            if (lmn4 == null) {
                lmn2 = new JSONObject();
            } else {
                lmn2 = g0.lmn(lmn4);
            }
            JSONObject jSONObject2 = lmn2;
            if (lmn5 == null) {
                lmn3 = new JSONObject();
            } else {
                lmn3 = g0.lmn(lmn5);
            }
            this.frameworkInstance.onStreamEvent(changeType(i10), str, jSONObject, jSONObject2, lmn3, new b0());
            return;
        }
        HiLog.sw(str2, "onStreamEvent() parameters check fail. Nothing will be recorded.TAG: %s,TYPE: %d", this.strTAG, Integer.valueOf(i10));
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onEvent(int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        JSONObject lmn;
        String str2 = TAG;
        StringBuilder b4 = a.b("onEvent. TAG:");
        b4.append(this.strTAG);
        b4.append(", TYPE:");
        b4.append(i10);
        b4.append(", eventId:");
        b4.append(str);
        HiLog.si(str2, b4.toString());
        if (!l0.ijk.lmn()) {
            HiLog.sw(str2, "userManager.isUserUnlocked() == false.TAG: %s,TYPE: %d", this.strTAG, Integer.valueOf(i10));
            return;
        }
        if (i0.lmn(str) || !verifyURL(i10)) {
            HiLog.sw(str2, "onEvent() parameters check fail. Nothing will be recorded.TAG: %s,TYPE: %d", this.strTAG, Integer.valueOf(i10));
            return;
        }
        if (!i0.klm(linkedHashMap)) {
            HiLog.sw(str2, "onEvent() parameter mapValue will be cleared.TAG: %s,TYPE: %d", this.strTAG, Integer.valueOf(i10));
            linkedHashMap = null;
        }
        if (linkedHashMap == null) {
            lmn = new JSONObject();
        } else {
            lmn = g0.lmn(linkedHashMap);
        }
        this.frameworkInstance.onEvent(changeType(i10), str, lmn, new b0());
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onPause(String str, LinkedHashMap<String, String> linkedHashMap) {
        String str2 = TAG;
        StringBuilder b4 = a.b("onPause(viewName,map) is execute.TAG: ");
        b4.append(this.strTAG);
        HiLog.i(str2, b4.toString());
        if (!l0.ijk.lmn()) {
            a.e(a.b("userManager.isUserUnlocked() == false.TAG: "), this.strTAG, str2);
            return;
        }
        if (!verifyURL(0)) {
            a.e(a.b("onPause() URL check fail. Nothing will be recorded.TAG: "), this.strTAG, str2);
            return;
        }
        if (!TextUtils.isEmpty(str) && i0.lmn("viewName", str, "[a-zA-Z_][a-zA-Z0-9. _-]{0,255}")) {
            if (!i0.klm(linkedHashMap)) {
                a.e(a.b("onPause() parameter mapValue will be cleared.TAG: "), this.strTAG, str2);
                linkedHashMap = null;
            }
            postEvent(str, linkedHashMap, "$AppOnPause", "OnPause");
            this.onResumeTime = 0L;
            return;
        }
        a.e(a.b("onPause() parameter viewName verify failed. Nothing will be recorded.TAG: "), this.strTAG, str2);
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onResume(String str, LinkedHashMap<String, String> linkedHashMap) {
        String str2 = TAG;
        StringBuilder b4 = a.b("onResume(viewName,map). TAG: ");
        b4.append(this.strTAG);
        HiLog.i(str2, b4.toString());
        if (!l0.ijk.lmn()) {
            a.e(a.b("userManager.isUserUnlocked() == false.TAG: "), this.strTAG, str2);
            return;
        }
        if (!verifyURL(0)) {
            a.e(a.b("onResume() URL check fail. Nothing will be recorded.TAG: "), this.strTAG, str2);
            return;
        }
        if (!TextUtils.isEmpty(str) && i0.lmn("viewName", str, "[a-zA-Z_][a-zA-Z0-9. _-]{0,255}")) {
            if (!i0.klm(linkedHashMap)) {
                a.e(a.b("onResume() parameter mapValue will be cleared.TAG: "), this.strTAG, str2);
                linkedHashMap = null;
            }
            this.onResumeTime = System.currentTimeMillis();
            postEvent(str, linkedHashMap, "$AppOnResume", "OnResume");
            return;
        }
        a.e(a.b("onResume() parameter viewName verify failed. Nothing will be recorded.TAG: "), this.strTAG, str2);
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onEvent(String str, LinkedHashMap<String, String> linkedHashMap) {
        JSONObject lmn;
        String str2 = TAG;
        StringBuilder b4 = a.b("onEvent. TAG:");
        b4.append(this.strTAG);
        b4.append(", eventId:");
        b4.append(str);
        HiLog.si(str2, b4.toString());
        if (!l0.ijk.lmn()) {
            a.e(a.b("userManager.isUserUnlocked() == false.TAG: "), this.strTAG, str2);
            return;
        }
        if (!i0.lmn(str) && verifyURL(0)) {
            if (!i0.klm(linkedHashMap)) {
                a.e(a.b("onEvent() parameter mapValue will be cleared.TAG: "), this.strTAG, str2);
                linkedHashMap = null;
            }
            if (linkedHashMap == null) {
                lmn = new JSONObject();
            } else {
                lmn = g0.lmn(linkedHashMap);
            }
            this.frameworkInstance.onEvent(FrameworkConstant.DataType.STRING_OPER, str, lmn, new b0());
            return;
        }
        a.e(a.b("onEvent() parameters check fail. Nothing will be recorded.TAG: "), this.strTAG, str2);
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstance
    public void onEvent(int i10, String str, LinkedHashMap<String, String> linkedHashMap, LinkedHashMap<String, String> linkedHashMap2, LinkedHashMap<String, String> linkedHashMap3) {
        JSONObject lmn;
        JSONObject lmn2;
        JSONObject lmn3;
        String str2 = TAG;
        StringBuilder b4 = a.b("onEvent Ex. TAG:");
        b4.append(this.strTAG);
        b4.append(", TYPE:");
        b4.append(i10);
        b4.append(", eventId:");
        b4.append(str);
        HiLog.si(str2, b4.toString());
        if (!l0.ijk.lmn()) {
            HiLog.sw(str2, "userManager.isUserUnlocked() == false.TAG: %s,TYPE: %d", this.strTAG, Integer.valueOf(i10));
            return;
        }
        if (i0.lmn(str) || !verifyURL(i10)) {
            HiLog.sw(str2, "onEvent() parameters check fail. Nothing will be recorded.TAG: %s,TYPE: %d", this.strTAG, Integer.valueOf(i10));
            return;
        }
        LinkedHashMap<String, String> lmn4 = i0.lmn(linkedHashMap2);
        LinkedHashMap<String, String> lmn5 = i0.lmn(linkedHashMap3);
        if (!i0.klm(linkedHashMap)) {
            HiLog.sw(str2, "onEvent() parameter mapValue will be cleared.TAG: %s,TYPE: %d", this.strTAG, Integer.valueOf(i10));
            linkedHashMap = null;
        }
        if (linkedHashMap == null) {
            lmn = new JSONObject();
        } else {
            lmn = g0.lmn(linkedHashMap);
        }
        JSONObject jSONObject = lmn;
        if (lmn4 == null) {
            lmn2 = new JSONObject();
        } else {
            lmn2 = g0.lmn(lmn4);
        }
        JSONObject jSONObject2 = lmn2;
        if (lmn5 == null) {
            lmn3 = new JSONObject();
        } else {
            lmn3 = g0.lmn(lmn5);
        }
        this.frameworkInstance.onEvent(changeType(i10), str, jSONObject, jSONObject2, lmn3, new b0());
    }
}
