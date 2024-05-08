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
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class Request {
    public static final SimpleDateFormat POP_REQUEST_DATE_FORMAT;
    public static final SimpleDateFormat REQUEST_DATE_FORMAT = new SimpleDateFormat(TimeUtils.STARD_FROMAT);

    @SerializationName("Action")
    private String Action;
    private String accessKeySecret;
    private String baseUrl;
    public String requestMethod;
    private String sign;
    public String method = null;

    @SerializationName("Timestamp")
    private String timestamp = POP_REQUEST_DATE_FORMAT.format(new Date());
    public boolean isSign = true;

    @SerializationName("SignatureMethod")
    private String signatureMethod = "HMAC-SHA1";

    @SerializationName("SignatureNonce")
    private String SignatureNonce = UUID.randomUUID().toString();

    @SerializationName("SignatureVersion")
    private String SignatureVersion = "1.0";

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        POP_REQUEST_DATE_FORMAT = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("O"));
    }

    public String buildPopRequestParamas() {
        List<Field> allDeclaredFields = ParamsUtils.getAllDeclaredFields(getClass());
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        TreeMap treeMap = new TreeMap();
        for (Field field : allDeclaredFields) {
            SerializationName serializationName = (SerializationName) field.getAnnotation(SerializationName.class);
            if (serializationName != null) {
                String value = serializationName.value();
                field.setAccessible(true);
                try {
                    Object obj = field.get(this);
                    if (obj != null) {
                        treeMap.put(value, obj);
                    }
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                }
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            sb3.append("&");
            sb3.append(ParamsUtils.specialUrlEncode((String) entry.getKey()));
            sb3.append("=");
            sb3.append(ParamsUtils.specialUrlEncode(entry.getValue() == null ? "" : entry.getValue().toString()));
        }
        sb2.append("POST");
        sb2.append("&");
        sb2.append(ParamsUtils.specialUrlEncode("/"));
        sb2.append("&");
        sb2.append(ParamsUtils.specialUrlEncode(sb3.toString().substring(1)));
        if (!isSign()) {
            return sb3.toString();
        }
        return ((Object) sb3) + "&Signature=" + ParamsUtils.specialUrlEncode(ParamsUtils.sign(sb2, this.accessKeySecret + "&"));
    }

    public String buildTopRequestParamas() throws IOException {
        String value;
        List<Field> allDeclaredFields = ParamsUtils.getAllDeclaredFields(getClass());
        StringBuilder sb2 = new StringBuilder();
        TreeMap treeMap = new TreeMap();
        for (Field field : allDeclaredFields) {
            SerializationName serializationName = (SerializationName) field.getAnnotation(SerializationName.class);
            if (serializationName != null && cg.f3335y != (value = serializationName.value()) && (isSign() || (value.toLowerCase().indexOf(CardUriUtils.PARAM_SIGN) <= -1 && "accessKeySecret" != value))) {
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
        if (!this.isSign) {
            return sb2.toString();
        }
        return ((Object) sb2) + "&sign=" + ParamsUtils.specialUrlEncode(ParamsUtils.signTopRequest(treeMap, this.accessKeySecret, this.signatureMethod));
    }

    public String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    public String getAction() {
        return this.Action;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getMethod() {
        return this.method;
    }

    public String getRequestMethod() {
        return this.requestMethod;
    }

    public String getSign() {
        return this.sign;
    }

    public boolean isSign() {
        return this.isSign;
    }

    public void setAccessKeySecret(String str) {
        this.accessKeySecret = str;
    }

    public void setAction(String str) {
        this.Action = str;
    }

    public void setBaseUrl(String str) {
        this.baseUrl = str;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setRequestMethod(String str) {
        this.requestMethod = str;
    }

    public void setSign(boolean z10) {
        this.isSign = z10;
    }
}
