package com.huawei.hianalytics.framework.datahandler;

import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.CommonHeaderEx;
import com.huawei.hianalytics.core.storage.IStorageHandler;
import com.huawei.hianalytics.framework.config.IMandatoryParameters;
import com.huawei.hianalytics.framework.constant.FrameworkConstant;
import com.huawei.hianalytics.framework.data.ConfigManager;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class d extends c {
    public d(String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, long j10) {
        super(str, str2, str3, jSONObject, j10);
        String a10 = a(jSONObject2, jSONObject3, str, str2);
        this.f28810k = a10;
        if (!TextUtils.isEmpty(a10)) {
            IMandatoryParameters parameters = ConfigManager.getInstance().getParameters();
            if (parameters == null || parameters.checkDebugModeEnabled()) {
                return;
            }
            this.f28809j = a(this.f28810k);
            return;
        }
        HiLog.sw("RecordTaskEx", "common and header Ex is empty，TAG: %s,TYPE: %s", str, str2);
    }

    public static String a(JSONObject jSONObject, JSONObject jSONObject2, String str, String str2) {
        if (jSONObject == null && jSONObject2 == null) {
            HiLog.sw("RecordTaskEx", "evtHeaderEx and evtCommonEx is null，TAG: %s,TYPE: %s", str, str2);
            return "";
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(FrameworkConstant.EX_HEADER_CONSTANT, jSONObject);
        jSONObject3.put(FrameworkConstant.EX_COMMON, jSONObject2);
        if (jSONObject3.length() == 0) {
            HiLog.sw("RecordTaskEx", "evtHeaderEx/evtCommonEx is empty，TAG: %s,TYPE: %s", str, str2);
            return "";
        }
        return jSONObject3.toString();
    }

    @Override // com.huawei.hianalytics.framework.datahandler.c, java.lang.Runnable
    public void run() {
        if (!TextUtils.isEmpty(this.f28809j)) {
            CommonHeaderEx commonHeaderEx = new CommonHeaderEx(this.f28809j, this.f28810k);
            IStorageHandler c4 = com.huawei.hianalytics.framework.b.c(this.f28800a);
            if (c4 != null) {
                c4.insert(commonHeaderEx);
            }
        }
        super.run();
    }

    public static String a(String str) {
        return ta.b.b(str);
    }
}
