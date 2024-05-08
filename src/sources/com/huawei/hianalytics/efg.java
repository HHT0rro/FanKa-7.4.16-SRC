package com.huawei.hianalytics;

import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.framework.config.DeviceAttributeCollector;
import com.huawei.hianalytics.log.LogTag;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class efg implements DeviceAttributeCollector {
    public static final String ikl = LogTag.get(DeviceAttributeCollector.class, new Class[0]);
    public String klm;
    public String lmn;

    public efg(String str, String str2) {
        this.lmn = str;
        this.klm = str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0237 A[Catch: JSONException -> 0x0297, TryCatch #0 {JSONException -> 0x0297, blocks: (B:17:0x01df, B:19:0x0201, B:21:0x020d, B:22:0x0211, B:26:0x0228, B:28:0x022d, B:30:0x0237, B:31:0x023b, B:35:0x0250, B:37:0x0255, B:39:0x025f, B:40:0x0263, B:43:0x0276, B:45:0x027b, B:47:0x0286, B:49:0x028f, B:53:0x026a, B:55:0x0274, B:57:0x0242, B:59:0x024c, B:61:0x0218, B:63:0x0224), top: B:16:0x01df }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x025f A[Catch: JSONException -> 0x0297, TryCatch #0 {JSONException -> 0x0297, blocks: (B:17:0x01df, B:19:0x0201, B:21:0x020d, B:22:0x0211, B:26:0x0228, B:28:0x022d, B:30:0x0237, B:31:0x023b, B:35:0x0250, B:37:0x0255, B:39:0x025f, B:40:0x0263, B:43:0x0276, B:45:0x027b, B:47:0x0286, B:49:0x028f, B:53:0x026a, B:55:0x0274, B:57:0x0242, B:59:0x024c, B:61:0x0218, B:63:0x0224), top: B:16:0x01df }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0269 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x026a A[Catch: JSONException -> 0x0297, TryCatch #0 {JSONException -> 0x0297, blocks: (B:17:0x01df, B:19:0x0201, B:21:0x020d, B:22:0x0211, B:26:0x0228, B:28:0x022d, B:30:0x0237, B:31:0x023b, B:35:0x0250, B:37:0x0255, B:39:0x025f, B:40:0x0263, B:43:0x0276, B:45:0x027b, B:47:0x0286, B:49:0x028f, B:53:0x026a, B:55:0x0274, B:57:0x0242, B:59:0x024c, B:61:0x0218, B:63:0x0224), top: B:16:0x01df }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x023a  */
    @Override // com.huawei.hianalytics.framework.config.DeviceAttributeCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject doCollector(org.json.JSONObject r11) {
        /*
            Method dump skipped, instructions count: 682
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.efg.doCollector(org.json.JSONObject):org.json.JSONObject");
    }

    public final JSONObject lmn() {
        w lmn = d.lmn(this.lmn, this.klm);
        String str = lmn != null ? lmn.f28850d : "";
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str);
            } catch (JSONException e2) {
                String str2 = ikl;
                StringBuilder b4 = e9.a.b("EventsGlobalProperties toJsonObj(): JSON Exception has happen,e:");
                b4.append(e2.getMessage());
                b4.append("，TAG: %s,TYPE: %s");
                HiLog.e(str2, b4.toString(), this.lmn, this.klm);
                return new JSONObject();
            }
        }
        return new JSONObject();
    }
}
