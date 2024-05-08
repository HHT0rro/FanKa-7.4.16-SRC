package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.huawei.flexiblelayout.u0;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ShareUrlSearchHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class au extends e<String, String> {

    /* renamed from: g, reason: collision with root package name */
    private String f7133g;

    public au(Context context, String str) {
        super(context, str);
        this.f7133g = str;
    }

    private static String b(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String a10 = v.a(jSONObject, "code");
            String a11 = v.a(jSONObject, "message");
            if ("1".equals(a10)) {
                return v.a(jSONObject, "transfer_url");
            }
            if (!"0".equals(a10)) {
                if (!"2".equals(a10)) {
                    if (!"3".equals(a10)) {
                        if (!"4".equals(a10)) {
                            if ("5".equals(a10)) {
                                throw new AMapException(AMapException.AMAP_SHARE_LICENSE_IS_EXPIRED, 0, a11);
                            }
                            return null;
                        }
                        throw new AMapException("用户签名未通过", 0, a11);
                    }
                    throw new AMapException(AMapException.AMAP_SERVICE_INVALID_PARAMS, 0, a11);
                }
                throw new AMapException(AMapException.AMAP_SHARE_FAILURE, 0, a11);
            }
            throw new AMapException(AMapException.AMAP_SERVICE_UNKNOWN_ERROR, 0, a11);
        } catch (JSONException e2) {
            n.a(e2, "ShareUrlSearchHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.s.e
    public final /* synthetic */ String a(String str) throws AMapException {
        return b(str);
    }

    @Override // com.amap.api.col.s.e
    public final String a_() {
        return null;
    }

    @Override // com.amap.api.col.s.e, com.amap.api.col.s.dz
    public final Map<String, String> f() {
        byte[] bArr;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("channel=open_api&flag=1");
        sb2.append("&address=" + URLEncoder.encode(this.f7133g));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("open_api1");
        stringBuffer.append(this.f7133g);
        stringBuffer.append("@8UbJH6N2szojnTHONAWzB6K7N1kaj7Y0iUMarxac");
        String a10 = ce.a(stringBuffer.toString());
        sb2.append("&sign=");
        sb2.append(a10.toUpperCase(Locale.US));
        sb2.append("&output=json");
        try {
            bArr = be.a(sb2.toString().getBytes("utf-8"), "Yaynpa84IKOfasFx".getBytes("utf-8"));
        } catch (UnsupportedEncodingException e2) {
            n.a(e2, "ShareUrlSearchHandler", "getParams");
            bArr = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ent", "2");
        hashMap.put(u0.f28637e, cb.b(bArr));
        hashMap.put("keyt", "openapi");
        return hashMap;
    }

    @Override // com.amap.api.col.s.dz
    public final String b() {
        return m.g();
    }
}
