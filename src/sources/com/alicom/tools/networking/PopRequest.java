package com.alicom.tools.networking;

import com.alipay.sdk.packet.e;
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
public class PopRequest extends RequestMode {
    public static final SimpleDateFormat POP_REQUEST_DATE_FORMAT;

    @SerializationName("Action")
    private String Action;
    private String accessKeySecret;

    @SerializationName("Timestamp")
    private String timestamp = POP_REQUEST_DATE_FORMAT.format(new Date());

    @SerializationName("SignatureMethod")
    private String signatureMethod = "HMAC-SHA1";

    @SerializationName("SignatureNonce")
    private String SignatureNonce = UUID.randomUUID().toString();

    @SerializationName("SignatureVersion")
    private String SignatureVersion = "1.0";

    @SerializationName(e.f4633e)
    private String Version = "2017-05-25";

    @SerializationName("Format")
    private String Format = "JSON";

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        POP_REQUEST_DATE_FORMAT = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("O"));
    }

    @Override // com.alicom.tools.networking.RequestMode
    public String buildSignByAnnotation() throws IOException {
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

    @Override // com.alicom.tools.networking.RequestMode
    public String buildSignByListFields() throws IOException {
        List<Field> allDeclaredFields = ParamsUtils.getAllDeclaredFields(getClass());
        this.fileds.add("Action");
        this.fileds.add("Timestamp");
        this.fileds.add("SignatureMethod");
        this.fileds.add("SignatureNonce");
        this.fileds.add(e.f4633e);
        this.fileds.add("Format");
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        TreeMap treeMap = new TreeMap();
        for (Field field : allDeclaredFields) {
            SerializationName serializationName = (SerializationName) field.getAnnotation(SerializationName.class);
            if (serializationName != null) {
                String value = serializationName.value();
                if (this.fileds.contains(value)) {
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

    public String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    public String getAction() {
        return this.Action;
    }

    public void setAccessKeySecret(String str) {
        this.accessKeySecret = str;
    }

    public void setAction(String str) {
        this.Action = str;
    }
}
