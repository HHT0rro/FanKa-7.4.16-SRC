package com.alicom.tools.networking;

import com.alibaba.security.realidentity.build.cg;
import com.alimm.tanx.core.web.cache.utils.TimeUtils;
import com.huawei.quickcard.cardmanager.util.CardUriUtils;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TopRequest extends RequestMode {
    public static final SimpleDateFormat REQUEST_DATE_FORMAT = new SimpleDateFormat(TimeUtils.STARD_FROMAT);

    @SerializationName("accessKeySecret")
    private String accessKeySecret;

    @SerializationName(cg.f3335y)
    private String sign;

    @SerializationName("method")
    public String method = null;

    @SerializationName("timestamp")
    private String timestamp = REQUEST_DATE_FORMAT.format(new Date());

    @SerializationName("sign_method")
    public String sign_method = "hmac";

    @Override // com.alicom.tools.networking.RequestMode
    public String buildSignByAnnotation() throws IOException {
        String value;
        List<Field> allDeclaredFields = ParamsUtils.getAllDeclaredFields(getClass());
        StringBuilder sb2 = new StringBuilder();
        TreeMap treeMap = new TreeMap();
        for (Field field : allDeclaredFields) {
            SerializationName serializationName = (SerializationName) field.getAnnotation(SerializationName.class);
            if (serializationName != null && cg.f3335y != (value = serializationName.value())) {
                field.setAccessible(true);
                try {
                    Object obj = field.get(this);
                    if (obj != null) {
                        treeMap.put(value, obj.toString());
                    }
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                }
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            sb2.append("&");
            sb2.append(ParamsUtils.specialUrlEncode((String) entry.getKey()));
            sb2.append("=");
            sb2.append(ParamsUtils.specialUrlEncode(entry.getValue() == null ? "" : (String) entry.getValue()));
        }
        if (!isSign()) {
            return sb2.toString();
        }
        return ((Object) sb2) + "&sign=" + ParamsUtils.specialUrlEncode(ParamsUtils.signTopRequest(treeMap, this.accessKeySecret, this.sign_method));
    }

    @Override // com.alicom.tools.networking.RequestMode
    public String buildSignByListFields() throws IOException {
        String value;
        List<Field> allDeclaredFields = ParamsUtils.getAllDeclaredFields(getClass());
        this.fileds.add(CardUriUtils.PARAM_SIGN);
        this.fileds.add("method");
        this.fileds.add("timestamp");
        this.fileds.add("sign_method");
        StringBuilder sb2 = new StringBuilder();
        TreeMap treeMap = new TreeMap();
        for (Field field : allDeclaredFields) {
            SerializationName serializationName = (SerializationName) field.getAnnotation(SerializationName.class);
            if (serializationName != null && cg.f3335y != (value = serializationName.value()) && this.fileds.contains(value)) {
                field.setAccessible(true);
                try {
                    Object obj = field.get(this);
                    if (obj != null) {
                        treeMap.put(value, obj.toString());
                    }
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                }
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            sb2.append("&");
            sb2.append(ParamsUtils.specialUrlEncode((String) entry.getKey()));
            sb2.append("=");
            sb2.append(ParamsUtils.specialUrlEncode(entry.getValue() == null ? "" : (String) entry.getValue()));
        }
        if (!isSign()) {
            return sb2.toString();
        }
        return ((Object) sb2) + "&sign=" + ParamsUtils.specialUrlEncode(ParamsUtils.signTopRequest(treeMap, this.accessKeySecret, this.sign_method));
    }

    public String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    public String getMethod() {
        return this.method;
    }

    public String getSign() {
        return this.sign;
    }

    public String getSign_method() {
        return this.sign_method;
    }

    public void setAccessKeySecret(String str) {
        this.accessKeySecret = str;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setSign_method(String str) {
        this.sign_method = str;
    }
}
