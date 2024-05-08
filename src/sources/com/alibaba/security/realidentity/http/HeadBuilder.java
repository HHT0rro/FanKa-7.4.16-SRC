package com.alibaba.security.realidentity.http;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.utils.BytesUtils;
import com.alibaba.security.common.utils.Md5Utils;
import com.alibaba.security.realidentity.RPEnv;
import com.alibaba.security.realidentity.build.gw;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.SimpleTimeZone;
import java.util.UUID;
import org.apache.commons.lang3.time.TimeZones;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class HeadBuilder {
    private static final String AUTH_COLON = ":";
    private static final String AUTH_SEP = "\n";
    private static final String KEY_HEADER_ACCEPT = "Accept";
    private static final String KEY_HEADER_AUTH = "Authorization";
    private static final String KEY_HEADER_CONTENT_MD5 = "Content-MD5";
    private static final String KEY_HEADER_CONTENT_TYPE = "Content-Type";
    private static final String KEY_HEADER_DATE = "Date";
    private static final String KEY_HEADER_HOST = "Host";
    private static final String KEY_HEADER_HOST_VALUE = "cro-dualstack.cn-hangzhou.aliyuncs.com";
    private static final String KEY_HEADER_NETWORK_V6 = "productNetwork";
    private static final String KEY_HEADER_PRE_HOST_VALUE = "pre-verify-cloud.alibaba-inc.com";
    private static final String KEY_HEADER_SIGN_METHOD = "x-acs-signature-method";
    private static final String KEY_HEADER_SIGN_NONCE = "x-acs-signature-nonce";
    private static final String KEY_HEADER_SIGN_VERSION = "x-acs-signature-version";
    private static final String KEY_HEADER_VERSION = "x-acs-version";
    private static final Map<String, String> ROA_HEADER_DEFAULT_MAP;
    public static final int RPSDK_ERR_CODE_SG_SECEXCEPTION = 7002;
    public static final int RPSDK_ERR_CODE_SUCCESS = 0;
    private static final String TAG = "HeadBuilder";
    private static final String VALUE_CONTENT_TYPE = "application/json; charset=utf-8";
    private static final Object VALUE_NETWORK_V6;
    private RPEnv mRPEnv = RPEnv.ONLINE;
    private gw mSecurityManager;

    static {
        HashMap hashMap = new HashMap();
        ROA_HEADER_DEFAULT_MAP = hashMap;
        VALUE_NETWORK_V6 = "dualstack";
        hashMap.put(KEY_HEADER_VERSION, "2021-06-11");
        hashMap.put("Accept", "application/json");
        hashMap.put(KEY_HEADER_SIGN_VERSION, "1.0");
        hashMap.put(KEY_HEADER_SIGN_METHOD, "HMAC-SHA1");
    }

    private void buildRoaCommonHeaders(Map<String, Object> map, String str) {
        for (Map.Entry<String, String> entry : ROA_HEADER_DEFAULT_MAP.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!map.containsKey(key)) {
                map.put(key, value);
            }
        }
        if (!map.containsKey("Content-Type") && str != null && str.length() != 0) {
            map.put("Content-Type", VALUE_CONTENT_TYPE);
        }
        if (!map.containsKey("Content-Type") && str != null && str.length() != 0) {
            map.put("Content-MD5", Md5Utils.md5Base64(str));
        }
        if (!map.containsKey("Date")) {
            map.put("Date", toGMTString(new Date()));
        }
        if (map.containsKey(KEY_HEADER_SIGN_NONCE)) {
            return;
        }
        map.put(KEY_HEADER_SIGN_NONCE, UUID.randomUUID().toString());
    }

    private boolean isDailyOrPreEnv() {
        RPEnv rPEnv = this.mRPEnv;
        return rPEnv == RPEnv.DAILY || rPEnv == RPEnv.PRE;
    }

    private static String toGMTString(Date date) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z", Locale.UK);
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, TimeZones.GMT_ID));
            return simpleDateFormat.format(date);
        } catch (Exception e2) {
            RPLogging.e(TAG, e2);
            return "";
        }
    }

    public Map<String, Object> buildHeaders(Context context, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        if (isDailyOrPreEnv()) {
            hashMap.put("x-acs-parent-id", "1488541403094533");
            hashMap.put("x-acs-caller-type", "sub");
            hashMap.put("x-acs-caller-uid", "267184644444836829");
        } else {
            hashMap.put("Host", isDailyOrPreEnv() ? KEY_HEADER_PRE_HOST_VALUE : KEY_HEADER_HOST_VALUE);
            hashMap.put(KEY_HEADER_NETWORK_V6, VALUE_NETWORK_V6);
        }
        buildRoaCommonHeaders(hashMap, str3);
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        AuthHeader authHeader = getAuthHeader(str, str2, hashMap);
        if (authHeader.getCode() != 0) {
            return null;
        }
        hashMap.put("Authorization", "acs " + authHeader.getAppkey() + ":" + Base64.encodeToString(BytesUtils.hex2bytes(authHeader.getSignature()), 2));
        return hashMap;
    }

    public AuthHeader getAuthHeader(String str, String str2, Map<String, Object> map) {
        AuthHeader authHeader = new AuthHeader();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append("\n");
        sb2.append(map.get("Accept"));
        sb2.append("\n");
        if (map.containsKey("Content-MD5")) {
            sb2.append(map.get("Content-MD5"));
        }
        sb2.append("\n");
        if (map.containsKey("Content-Type")) {
            sb2.append(map.get("Content-Type"));
        }
        sb2.append("\n");
        sb2.append(map.get("Date"));
        sb2.append("\n");
        sb2.append("x-acs-signature-method:");
        sb2.append(map.get(KEY_HEADER_SIGN_METHOD));
        sb2.append("\n");
        sb2.append("x-acs-signature-nonce:");
        sb2.append(map.get(KEY_HEADER_SIGN_NONCE));
        sb2.append("\n");
        sb2.append("x-acs-signature-version:");
        sb2.append(map.get(KEY_HEADER_SIGN_VERSION));
        sb2.append("\n");
        sb2.append("x-acs-version:");
        sb2.append(map.get(KEY_HEADER_VERSION));
        sb2.append("\n");
        sb2.append(str);
        gw gwVar = this.mSecurityManager;
        if (gwVar == null) {
            authHeader.setCode(7002);
            return authHeader;
        }
        String d10 = gwVar.d();
        if (TextUtils.isEmpty(d10)) {
            authHeader.setCode(7002);
            return authHeader;
        }
        String a10 = this.mSecurityManager.a(sb2.toString());
        if (TextUtils.isEmpty(a10)) {
            authHeader.setCode(7002);
            return authHeader;
        }
        authHeader.setAppkey(d10);
        authHeader.setSignature(a10);
        authHeader.setCode(0);
        return authHeader;
    }

    public void init(gw gwVar, RPEnv rPEnv) {
        this.mSecurityManager = gwVar;
        setCurEnv(rPEnv);
    }

    public void setCurEnv(RPEnv rPEnv) {
        this.mRPEnv = rPEnv;
    }
}
