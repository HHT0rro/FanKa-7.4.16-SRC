package com.amap.api.col.s;

import android.text.TextUtils;
import com.alibaba.security.biometrics.activity.BaseBioNavigatorActivity;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.hms.common.internal.RequestManager;
import com.jd.ad.sdk.dl.model.JADSlot;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CoreUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class n {
    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static void b(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errcode")) {
                a(jSONObject.getInt("errcode"), jSONObject.getString("errmsg"));
                return;
            }
            if (jSONObject.has("status")) {
                String string = jSONObject.getString("status");
                if (string.equals("1")) {
                    return;
                }
                if (string.equals("0") && !jSONObject.has("infocode")) {
                    throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
                }
                int i10 = jSONObject.getInt("infocode");
                if (string.equals("0")) {
                    a(i10, jSONObject.getString("info"));
                }
            }
        } catch (JSONException e2) {
            a(e2, "CoreUtil", "paseAuthFailurJson");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static void c(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errcode")) {
                a(jSONObject.getInt("errcode"), jSONObject.getString("errmsg"));
                return;
            }
            if (jSONObject.has("status")) {
                if (jSONObject.optInt("status") == 0) {
                    if (jSONObject.has("infocode")) {
                        a(jSONObject.getInt("infocode"), jSONObject.getString("info"));
                    } else {
                        throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
                    }
                }
                int optInt = jSONObject.optInt("code");
                if (optInt == 0) {
                    return;
                }
                String optString = jSONObject.optString("message");
                throw new AMapException(optString, 2, optString, Integer.parseInt("1".concat(String.valueOf(optInt))));
            }
        } catch (JSONException e2) {
            a(e2, "CoreUtil", "paseAuthFailurJson");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static Date d(String str) {
        if (str == null || str.trim().equals("")) {
            return null;
        }
        try {
            return new SimpleDateFormat("HHmm").parse(str);
        } catch (ParseException e2) {
            a(e2, "CoreUtil", "parseString2Time");
            return null;
        }
    }

    public static Date e(String str) {
        if (str == null || str.trim().equals("")) {
            return null;
        }
        try {
            return new SimpleDateFormat("HH:mm").parse(str);
        } catch (ParseException e2) {
            a(e2, "CoreUtil", "parseTime");
            return null;
        }
    }

    private static void a(int i10, String str) throws AMapException, JSONException {
        if (i10 != 0) {
            if (i10 == 22000) {
                throw new AMapException(AMapException.AMAP_SERVICE_TABLEID_NOT_EXIST, 2, str);
            }
            if (i10 == 32200) {
                throw new AMapException(AMapException.AMAP_NEARBY_INVALID_USERID, 2, str);
            }
            if (i10 != 32201) {
                switch (i10) {
                    case 10000:
                        return;
                    case 10001:
                        throw new AMapException(AMapException.AMAP_INVALID_USER_KEY, 2, str);
                    case 10002:
                        throw new AMapException(AMapException.AMAP_SERVICE_NOT_AVAILBALE, 2, str);
                    case 10003:
                        throw new AMapException(AMapException.AMAP_DAILY_QUERY_OVER_LIMIT, 2, str);
                    case 10004:
                        throw new AMapException(AMapException.AMAP_ACCESS_TOO_FREQUENT, 2, str);
                    case 10005:
                        throw new AMapException(AMapException.AMAP_INVALID_USER_IP, 2, str);
                    case JADSlot.MediaSpecSetType.MEDIA_SPEC_SET_TYPE_FEED2_1_SINGLE /* 10006 */:
                        throw new AMapException(AMapException.AMAP_INVALID_USER_DOMAIN, 2, str);
                    case 10007:
                        throw new AMapException("用户签名未通过", 2, str);
                    case 10008:
                        throw new AMapException(AMapException.AMAP_INVALID_USER_SCODE, 2, str);
                    case BaseBioNavigatorActivity.f2177j /* 10009 */:
                        throw new AMapException(AMapException.AMAP_USERKEY_PLAT_NOMATCH, 2, str);
                    case BaseBioNavigatorActivity.f2178k /* 10010 */:
                        throw new AMapException(AMapException.AMAP_IP_QUERY_OVER_LIMIT, 2, str);
                    case RequestManager.NOTIFY_CONNECT_SUCCESS /* 10011 */:
                        throw new AMapException(AMapException.AMAP_NOT_SUPPORT_HTTPS, 2, str);
                    case 10012:
                        throw new AMapException(AMapException.AMAP_INSUFFICIENT_PRIVILEGES, 2, str);
                    case 10013:
                        throw new AMapException(AMapException.AMAP_USER_KEY_RECYCLED, 2, str);
                    default:
                        switch (i10) {
                            case 20000:
                                throw new AMapException(AMapException.AMAP_SERVICE_INVALID_PARAMS, 2, str);
                            case 20001:
                                throw new AMapException(AMapException.AMAP_SERVICE_MISSING_REQUIRED_PARAMS, 2, str);
                            case 20002:
                                throw new AMapException(AMapException.AMAP_SERVICE_ILLEGAL_REQUEST, 2, str);
                            case 20003:
                                throw new AMapException(AMapException.AMAP_SERVICE_UNKNOWN_ERROR, 2, str);
                            default:
                                switch (i10) {
                                    case 20800:
                                        throw new AMapException(AMapException.AMAP_ROUTE_OUT_OF_SERVICE, 2, str);
                                    case 20801:
                                        throw new AMapException(AMapException.AMAP_ROUTE_NO_ROADS_NEARBY, 2, str);
                                    case 20802:
                                        throw new AMapException(AMapException.AMAP_ROUTE_FAIL, 2, str);
                                    case 20803:
                                        throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE, 2, str);
                                    default:
                                        switch (i10) {
                                            case 30000:
                                                throw new AMapException(AMapException.AMAP_ENGINE_RESPONSE_ERROR, 2, str);
                                            case 30001:
                                                throw new AMapException(AMapException.AMAP_ENGINE_RESPONSE_DATA_ERROR, 2, str);
                                            case 30002:
                                                throw new AMapException(AMapException.AMAP_ENGINE_CONNECT_TIMEOUT, 2, str);
                                            case 30003:
                                                throw new AMapException(AMapException.AMAP_ENGINE_RETURN_TIMEOUT, 2, str);
                                            default:
                                                switch (i10) {
                                                    case 32000:
                                                        throw new AMapException(AMapException.AMAP_ENGINE_TABLEID_NOT_EXIST, 2, str);
                                                    case 32001:
                                                        throw new AMapException(AMapException.AMAP_ID_NOT_EXIST, 2, str);
                                                    case 32002:
                                                        throw new AMapException(AMapException.AMAP_SERVICE_MAINTENANCE, 2, str);
                                                    default:
                                                        if (!TextUtils.isEmpty(str) && i10 > 0) {
                                                            throw new AMapException(str, 2, str, i10);
                                                        }
                                                        throw new AMapException(str, 2, str);
                                                }
                                        }
                                }
                        }
                }
            }
            throw new AMapException(AMapException.AMAP_NEARBY_KEY_NOT_BIND, 2, str);
        }
    }

    public static double b(List<LatLonPoint> list) {
        double d10 = ShadowDrawableWrapper.COS_45;
        if (list == null || list.size() < 3) {
            return ShadowDrawableWrapper.COS_45;
        }
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            LatLonPoint latLonPoint = list.get(i10);
            i10++;
            LatLonPoint latLonPoint2 = list.get(i10 % size);
            double longitude = latLonPoint.getLongitude() * 111319.49079327357d * Math.cos(latLonPoint.getLatitude() * 0.017453292519943295d);
            double latitude = latLonPoint.getLatitude() * 111319.49079327357d;
            d10 += (longitude * (latLonPoint2.getLatitude() * 111319.49079327357d)) - (((latLonPoint2.getLongitude() * 111319.49079327357d) * Math.cos(latLonPoint2.getLatitude() * 0.017453292519943295d)) * latitude);
        }
        return Math.abs(d10 / 2.0d);
    }

    public static double a(double d10) {
        return Double.parseDouble(new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US)).format(d10));
    }

    public static String a(LatLonPoint latLonPoint) {
        if (latLonPoint == null) {
            return "";
        }
        return a(latLonPoint.getLongitude()) + "," + a(latLonPoint.getLatitude());
    }

    public static String a(Date date) {
        return date != null ? new SimpleDateFormat("HH:mm").format(date) : "";
    }

    public static String a(List<LatLonPoint> list) {
        return a(list, ";");
    }

    public static String a(List<LatLonPoint> list, String str) {
        if (list == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < list.size(); i10++) {
            LatLonPoint latLonPoint = list.get(i10);
            if (latLonPoint != null) {
                double a10 = a(latLonPoint.getLongitude());
                double a11 = a(latLonPoint.getLatitude());
                stringBuffer.append(a10);
                stringBuffer.append(",");
                stringBuffer.append(a11);
                stringBuffer.append(str);
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }

    public static void a(Throwable th, String str, String str2) {
        try {
            df c4 = df.c();
            if (c4 != null) {
                c4.b(th, str, str2);
            }
            th.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static float a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        if (latLonPoint == null || latLonPoint2 == null) {
            return 0.0f;
        }
        try {
            double longitude = latLonPoint.getLongitude();
            double d10 = longitude * 0.01745329251994329d;
            double latitude = latLonPoint.getLatitude() * 0.01745329251994329d;
            double longitude2 = latLonPoint2.getLongitude() * 0.01745329251994329d;
            double latitude2 = latLonPoint2.getLatitude() * 0.01745329251994329d;
            double sin = Math.sin(d10);
            double sin2 = Math.sin(latitude);
            double cos = Math.cos(d10);
            double cos2 = Math.cos(latitude);
            double sin3 = Math.sin(longitude2);
            double sin4 = Math.sin(latitude2);
            double cos3 = Math.cos(longitude2);
            double cos4 = Math.cos(latitude2);
            double[] dArr = {cos * cos2, cos2 * sin, sin2};
            double[] dArr2 = {cos3 * cos4, cos4 * sin3, sin4};
            return (float) (Math.asin(Math.sqrt((((dArr[0] - dArr2[0]) * (dArr[0] - dArr2[0])) + ((dArr[1] - dArr2[1]) * (dArr[1] - dArr2[1]))) + ((dArr[2] - dArr2[2]) * (dArr[2] - dArr2[2]))) / 2.0d) * 1.27420015798544E7d);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public static String a(int i10) {
        StringBuilder sb2 = new StringBuilder();
        if ((i10 & 1) != 0) {
            sb2.append("cost,");
        }
        if ((i10 & 2) != 0) {
            sb2.append("tmcs,");
        }
        if ((i10 & 4) != 0) {
            sb2.append("navi,");
        }
        if ((i10 & 8) != 0) {
            sb2.append("cities,");
        }
        if ((i10 & 16) != 0) {
            sb2.append("polyline,");
        }
        if ((i10 & 32) != 0) {
            sb2.append("elec_consume_info,");
        }
        if ((i10 & 64) != 0) {
            sb2.append("charge_station_info,");
        }
        sb2.replace(sb2.length() - 1, sb2.length(), "");
        return sb2.toString();
    }
}
