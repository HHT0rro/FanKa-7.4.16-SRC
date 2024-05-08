package com.amap.api.col.p0003l;

import com.alibaba.security.biometrics.activity.BaseBioNavigatorActivity;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.amap.api.services.core.AMapException;
import com.huawei.hms.common.internal.RequestManager;
import com.jd.ad.sdk.dl.model.JADSlot;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CoreUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class fd {

    /* renamed from: a, reason: collision with root package name */
    private static String[] f5704a = {"com.amap.api.trace", "com.amap.api.trace.core"};

    public static void a(String str) throws fa {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errcode")) {
                a(jSONObject.getInt("errcode"), jSONObject.getString("errmsg"));
                return;
            }
            if (jSONObject.has("status") && jSONObject.has("infocode")) {
                String string = jSONObject.getString("status");
                int i10 = jSONObject.getInt("infocode");
                if ("1".equals(string)) {
                    return;
                }
                String string2 = jSONObject.getString("info");
                if ("0".equals(string)) {
                    a(i10, string2);
                }
            }
        } catch (JSONException unused) {
            throw new fa("协议解析错误 - ProtocolException");
        }
    }

    private static void a(int i10, String str) throws fa {
        if (i10 != 0) {
            switch (i10) {
                case 10000:
                    return;
                case 10001:
                    throw new fa(AMapException.AMAP_INVALID_USER_KEY);
                case 10002:
                    throw new fa(AMapException.AMAP_SERVICE_NOT_AVAILBALE);
                case 10003:
                    throw new fa(AMapException.AMAP_DAILY_QUERY_OVER_LIMIT);
                case 10004:
                    throw new fa(AMapException.AMAP_ACCESS_TOO_FREQUENT);
                case 10005:
                    throw new fa(AMapException.AMAP_INVALID_USER_IP);
                case JADSlot.MediaSpecSetType.MEDIA_SPEC_SET_TYPE_FEED2_1_SINGLE /* 10006 */:
                    throw new fa(AMapException.AMAP_INVALID_USER_DOMAIN);
                case 10007:
                    throw new fa("用户签名未通过");
                case 10008:
                    throw new fa(AMapException.AMAP_INVALID_USER_SCODE);
                case BaseBioNavigatorActivity.f2177j /* 10009 */:
                    throw new fa(AMapException.AMAP_USERKEY_PLAT_NOMATCH);
                case BaseBioNavigatorActivity.f2178k /* 10010 */:
                    throw new fa(AMapException.AMAP_IP_QUERY_OVER_LIMIT);
                case RequestManager.NOTIFY_CONNECT_SUCCESS /* 10011 */:
                    throw new fa(AMapException.AMAP_NOT_SUPPORT_HTTPS);
                case 10012:
                    throw new fa(AMapException.AMAP_INSUFFICIENT_PRIVILEGES);
                case 10013:
                    throw new fa(AMapException.AMAP_USER_KEY_RECYCLED);
                default:
                    switch (i10) {
                        case 20000:
                            throw new fa(AMapException.AMAP_SERVICE_INVALID_PARAMS);
                        case 20001:
                            throw new fa(AMapException.AMAP_SERVICE_MISSING_REQUIRED_PARAMS);
                        case 20002:
                            throw new fa(AMapException.AMAP_SERVICE_ILLEGAL_REQUEST);
                        case 20003:
                            throw new fa(AMapException.AMAP_SERVICE_UNKNOWN_ERROR);
                        default:
                            switch (i10) {
                                case 30000:
                                    throw new fa(AMapException.AMAP_ENGINE_RESPONSE_ERROR);
                                case 30001:
                                    throw new fa(AMapException.AMAP_ENGINE_RESPONSE_DATA_ERROR);
                                case 30002:
                                    throw new fa(AMapException.AMAP_ENGINE_CONNECT_TIMEOUT);
                                case 30003:
                                    throw new fa(AMapException.AMAP_ENGINE_RETURN_TIMEOUT);
                                default:
                                    throw new fa(str);
                            }
                    }
            }
        }
    }

    public static int a(List<LatLng> list) {
        int i10 = 0;
        if (list == null || list.size() == 0) {
            return 0;
        }
        int i11 = 0;
        while (i10 < list.size() - 1) {
            LatLng latLng = list.get(i10);
            i10++;
            LatLng latLng2 = list.get(i10);
            if (latLng == null || latLng2 == null) {
                break;
            }
            i11 = (int) (i11 + AMapUtils.calculateLineDistance(latLng, latLng2));
        }
        return i11;
    }
}
