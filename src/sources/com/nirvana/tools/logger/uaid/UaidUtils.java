package com.nirvana.tools.logger.uaid;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.quickcard.cardmanager.util.CardUriUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class UaidUtils {
    public static final SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("yyyyMMddhhmmssSSS");

    public static String composeCmccGetTokenParams(String str, String str2) throws JSONException {
        String str3;
        String format = TIMESTAMP_FORMAT.format(new Date());
        String uuid = UUID.randomUUID().toString();
        String uuid2 = UUID.randomUUID().toString();
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append("3");
            stringBuffer.append(uuid2);
            stringBuffer.append(format);
            stringBuffer.append(uuid);
            stringBuffer.append("1.0");
            stringBuffer.append(str2);
            str3 = stringBuffer.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", "1.0");
        jSONObject.put("timestamp", format);
        jSONObject.put("appId", str);
        jSONObject.put("businessType", "3");
        jSONObject.put("traceid", uuid);
        jSONObject.put(RemoteMessageConst.MSGID, uuid2);
        jSONObject.put(CardUriUtils.PARAM_SIGN, str3);
        return jSONObject.toString();
    }

    public static String composeCuccAuthAddrParams(String str) {
        return "appid=" + str;
    }

    public static String composeCuccAuthCodeParams(String str, String str2) {
        return "appid=" + str + "&private_ip=" + str2;
    }
}
