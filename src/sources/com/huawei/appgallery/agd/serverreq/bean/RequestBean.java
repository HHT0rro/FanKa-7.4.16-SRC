package com.huawei.appgallery.agd.serverreq.bean;

import androidx.annotation.Nullable;
import com.huawei.appgallery.agd.common.utils.ServerAddrConfig;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.huawei.appgallery.agd.serverreq.ServerReqLog;
import com.huawei.appgallery.agd.serverreq.json.JsonBean;
import com.huawei.appgallery.agd.serverreq.json.ReflectAPI;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;
import com.huawei.secure.android.common.util.SafeString;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class RequestBean extends JsonBean {
    public static final String END_FLAG = "_";
    private static final String TAG = "RequestBean";
    private String cacheID;
    private String host;
    private String method_;
    private String storeApi;
    private String url;
    public String targetServer = ServerAddrConfig.SERVER_STORE;
    private String ver_ = "1.1";
    private int requestType = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface RequestDataType {
        public static final int REQUEST_NETWORK = 0;
        public static final int REQUEST_NETWORK_ORIGINAL_DATA = 1;
    }

    public static String genBody(RequestBean requestBean, boolean z10) throws IllegalArgumentException {
        return requestBean.genBody(z10);
    }

    public static String getCacheID(RequestBean requestBean) {
        return requestBean.getCacheID();
    }

    public static String getMethod_(RequestBean requestBean) {
        return requestBean.getMethod_();
    }

    private Map<String, Field> getParam() {
        int i10;
        HashMap hashMap = new HashMap();
        Field[] declaredFields = ReflectAPI.getDeclaredFields(getClass());
        int length = declaredFields.length;
        while (i10 < length) {
            Field field = declaredFields[i10];
            String name = field.getName();
            if (name.endsWith("_")) {
                name = SafeString.substring(name, 0, name.length() - 1);
            } else {
                i10 = field.isAnnotationPresent(NetworkTransmission.class) ? 0 : i10 + 1;
            }
            hashMap.put(name, field);
        }
        return hashMap;
    }

    public static String getReqUrl(RequestBean requestBean) {
        return requestBean.getReqUrl();
    }

    public static int getRequestType(RequestBean requestBean) {
        return requestBean.getRequestType();
    }

    @Nullable
    private String toFilterJson(Field field, JsonBean jsonBean, StringBuilder sb2) {
        if (JsonBean.isFieldPrivacy(field)) {
            return StringUtils.SENSITIVE_CODE;
        }
        try {
            jsonBean.toFilterJson(sb2);
            return sb2.toString();
        } catch (IllegalAccessException unused) {
            ServerReqLog.LOG.e(TAG, "toFilterJson failed:" + field.getName());
            return null;
        }
    }

    @Nullable
    private String toNormalJson(Field field, JsonBean jsonBean, StringBuilder sb2) {
        try {
            jsonBean.toJson(sb2);
            return sb2.toString();
        } catch (IllegalAccessException unused) {
            ServerReqLog.LOG.e(TAG, "toJson failed:" + field.getName());
            return null;
        }
    }

    public String genBody(boolean z10) throws IllegalArgumentException {
        if (!z10) {
            onSetValue();
        }
        return genFormBody(z10);
    }

    public String genFormBody(boolean z10) throws IllegalArgumentException {
        Map<String, Field> param = getParam();
        int size = param.size();
        String[] strArr = new String[size];
        param.keySet().toArray(strArr);
        Arrays.sort(strArr);
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < size; i10++) {
            String value = getValue(param.get(strArr[i10]), z10);
            if (value != null) {
                String encode2utf8 = StringUtils.encode2utf8(value);
                sb2.append(strArr[i10]);
                sb2.append("=");
                sb2.append(encode2utf8);
                sb2.append("&");
            }
        }
        int length = sb2.length();
        if (length > 0) {
            int i11 = length - 1;
            if (sb2.charAt(i11) == '&') {
                sb2.deleteCharAt(i11);
            }
        }
        return sb2.toString();
    }

    public String getCacheID() {
        return this.cacheID;
    }

    public String getHost() {
        return this.host;
    }

    public String getMethod_() {
        return this.method_;
    }

    public String getReqUrl() {
        if (ServerAddrConfig.SERVER_STORE.equals(this.targetServer)) {
            return this.url;
        }
        return this.url + this.storeApi;
    }

    public int getRequestType() {
        return this.requestType;
    }

    public String getUrl() {
        return this.url;
    }

    public String getValue(Field field, boolean z10) {
        Object obj;
        boolean isAccessible = field.isAccessible();
        try {
            try {
                field.setAccessible(true);
                obj = field.get(this);
            } catch (IllegalAccessException unused) {
                ServerReqLog.LOG.e(TAG, "IllegalAccessException:" + field.getName());
                obj = null;
            }
            if (obj != null && (obj instanceof JsonBean)) {
                StringBuilder sb2 = new StringBuilder();
                JsonBean jsonBean = (JsonBean) obj;
                return z10 ? toFilterJson(field, jsonBean, sb2) : toNormalJson(field, jsonBean, sb2);
            }
            if (obj == null) {
                return null;
            }
            if (z10 && JsonBean.isFieldPrivacy(field)) {
                obj = StringUtils.SENSITIVE_CODE;
            }
            return String.valueOf(obj);
        } finally {
            field.setAccessible(isAccessible);
        }
    }

    public void onSetValue() {
    }

    public void setCacheID(String str) {
        this.cacheID = str;
    }

    public void setMethod_(String str) {
        this.method_ = str;
    }

    public void setRequestType(int i10) {
        this.requestType = i10;
    }

    public void setStoreApi(String str) {
        this.storeApi = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVer(String str) {
        this.ver_ = str;
    }
}
