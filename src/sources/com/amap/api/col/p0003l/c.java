package com.amap.api.col.p0003l;

import android.os.Bundle;
import android.view.textclassifier.TextClassifier;
import com.amap.api.fence.DistrictItem;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.PoiItem;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.utils.j;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.flexiblelayout.css.adapter.value.integrate.align.CSSAlignValue;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: GeoFenceSearchResultParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static long f5189a;

    public static int a(String str, List<GeoFence> list, Bundle bundle) {
        JSONArray optJSONArray;
        int i10;
        try {
            JSONObject jSONObject = new JSONObject(str);
            char c4 = 0;
            int optInt = jSONObject.optInt("status", 0);
            int optInt2 = jSONObject.optInt("infocode", 0);
            if (optInt == 1 && (optJSONArray = jSONObject.optJSONArray("pois")) != null) {
                int i11 = 0;
                while (i11 < optJSONArray.length()) {
                    GeoFence geoFence = new GeoFence();
                    PoiItem poiItem = new PoiItem();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i11);
                    poiItem.setPoiId(jSONObject2.optString("id"));
                    poiItem.setPoiName(jSONObject2.optString("name"));
                    poiItem.setPoiType(jSONObject2.optString("type"));
                    poiItem.setTypeCode(jSONObject2.optString("typecode"));
                    poiItem.setAddress(jSONObject2.optString(TextClassifier.TYPE_ADDRESS));
                    String optString = jSONObject2.optString("location");
                    if (optString != null) {
                        String[] split = optString.split(",");
                        poiItem.setLongitude(Double.parseDouble(split[c4]));
                        poiItem.setLatitude(Double.parseDouble(split[1]));
                        List<List<DPoint>> arrayList = new ArrayList<>();
                        ArrayList arrayList2 = new ArrayList();
                        i10 = optInt2;
                        DPoint dPoint = new DPoint(poiItem.getLatitude(), poiItem.getLongitude());
                        arrayList2.add(dPoint);
                        arrayList.add(arrayList2);
                        geoFence.setPointList(arrayList);
                        geoFence.setCenter(dPoint);
                    } else {
                        i10 = optInt2;
                    }
                    poiItem.setTel(jSONObject2.optString("tel"));
                    poiItem.setProvince(jSONObject2.optString("pname"));
                    poiItem.setCity(jSONObject2.optString("cityname"));
                    poiItem.setAdname(jSONObject2.optString("adname"));
                    geoFence.setPoiItem(poiItem);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(a());
                    geoFence.setFenceId(sb2.toString());
                    if (bundle != null) {
                        geoFence.setCustomId(bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID));
                        geoFence.setPendingIntentAction(bundle.getString("pendingIntentAction"));
                        geoFence.setType(2);
                        geoFence.setRadius(bundle.getFloat("fenceRadius"));
                        geoFence.setExpiration(bundle.getLong("expiration"));
                        geoFence.setActivatesAction(bundle.getInt("activatesAction", 1));
                    }
                    if (list != null) {
                        list.add(geoFence);
                    }
                    i11++;
                    optInt2 = i10;
                    c4 = 0;
                }
            }
            return optInt2;
        } catch (Throwable unused) {
            return 5;
        }
    }

    public static int b(String str, List<GeoFence> list, Bundle bundle) {
        return a(str, list, bundle);
    }

    public final int c(String str, List<GeoFence> list, Bundle bundle) {
        JSONArray optJSONArray;
        ArrayList arrayList;
        String str2;
        int i10;
        String str3;
        String str4;
        float f10;
        long j10;
        long j11;
        int i11;
        String str5;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("status", 0);
            int optInt2 = jSONObject.optInt("infocode", 0);
            String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
            String string2 = bundle.getString("pendingIntentAction");
            float f11 = bundle.getFloat("fenceRadius");
            long j12 = bundle.getLong("expiration");
            int i12 = bundle.getInt("activatesAction", 1);
            if (optInt == 1 && (optJSONArray = jSONObject.optJSONArray("districts")) != null) {
                int i13 = 0;
                while (i13 < optJSONArray.length()) {
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    GeoFence geoFence = new GeoFence();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i13);
                    String optString = jSONObject2.optString("citycode");
                    String optString2 = jSONObject2.optString("adcode");
                    String optString3 = jSONObject2.optString("name");
                    JSONArray jSONArray = optJSONArray;
                    String string3 = jSONObject2.getString(CSSAlignValue.AlignKey.CENTER);
                    int i14 = optInt2;
                    DPoint dPoint = new DPoint();
                    int i15 = i13;
                    String str6 = ",";
                    if (string3 != null) {
                        String[] split = string3.split(",");
                        arrayList = arrayList2;
                        str2 = optString3;
                        dPoint.setLatitude(Double.parseDouble(split[1]));
                        dPoint.setLongitude(Double.parseDouble(split[0]));
                        geoFence.setCenter(dPoint);
                    } else {
                        arrayList = arrayList2;
                        str2 = optString3;
                    }
                    geoFence.setCustomId(string);
                    geoFence.setPendingIntentAction(string2);
                    geoFence.setType(3);
                    geoFence.setRadius(f11);
                    geoFence.setExpiration(j12);
                    geoFence.setActivatesAction(i12);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(a());
                    geoFence.setFenceId(sb2.toString());
                    String optString4 = jSONObject2.optString("polyline");
                    if (optString4 != null) {
                        String[] split2 = optString4.split("\\|");
                        int length = split2.length;
                        i10 = i12;
                        float f12 = Float.MAX_VALUE;
                        int i16 = 0;
                        float f13 = Float.MIN_VALUE;
                        while (i16 < length) {
                            String str7 = string;
                            String str8 = split2[i16];
                            String[] strArr = split2;
                            DistrictItem districtItem = new DistrictItem();
                            String str9 = string2;
                            List<DPoint> arrayList4 = new ArrayList<>();
                            districtItem.setCitycode(optString);
                            districtItem.setAdcode(optString2);
                            String str10 = optString2;
                            String str11 = str2;
                            districtItem.setDistrictName(str11);
                            str2 = str11;
                            String[] split3 = str8.split(";");
                            float f14 = f11;
                            int i17 = 0;
                            while (i17 < split3.length) {
                                String[] split4 = split3[i17].split(str6);
                                String str12 = str6;
                                String[] strArr2 = split3;
                                if (split4.length > 1) {
                                    String str13 = split4[1];
                                    String str14 = split4[0];
                                    j11 = j12;
                                    double parseDouble = Double.parseDouble(str13);
                                    i11 = length;
                                    str5 = optString;
                                    arrayList4.add(new DPoint(parseDouble, Double.parseDouble(str14)));
                                } else {
                                    j11 = j12;
                                    i11 = length;
                                    str5 = optString;
                                }
                                i17++;
                                optString = str5;
                                str6 = str12;
                                split3 = strArr2;
                                j12 = j11;
                                length = i11;
                            }
                            String str15 = str6;
                            long j13 = j12;
                            int i18 = length;
                            String str16 = optString;
                            if (arrayList4.size() > 100.0f) {
                                try {
                                    arrayList4 = a(arrayList4, 100.0f);
                                } catch (Throwable unused) {
                                    return 5;
                                }
                            }
                            arrayList3.add(arrayList4);
                            districtItem.setPolyline(arrayList4);
                            ArrayList arrayList5 = arrayList;
                            arrayList5.add(districtItem);
                            f13 = Math.max(f13, a.b(dPoint, arrayList4));
                            f12 = Math.min(f12, a.a(dPoint, arrayList4));
                            i16++;
                            optString = str16;
                            arrayList = arrayList5;
                            string = str7;
                            split2 = strArr;
                            string2 = str9;
                            optString2 = str10;
                            f11 = f14;
                            str6 = str15;
                            j12 = j13;
                            length = i18;
                        }
                        str3 = string;
                        str4 = string2;
                        f10 = f11;
                        j10 = j12;
                        geoFence.setMaxDis2Center(f13);
                        geoFence.setMinDis2Center(f12);
                        geoFence.setDistrictItemList(arrayList);
                        geoFence.setPointList(arrayList3);
                        list.add(geoFence);
                    } else {
                        i10 = i12;
                        str3 = string;
                        str4 = string2;
                        f10 = f11;
                        j10 = j12;
                    }
                    i13 = i15 + 1;
                    optJSONArray = jSONArray;
                    optInt2 = i14;
                    i12 = i10;
                    string = str3;
                    string2 = str4;
                    f11 = f10;
                    j12 = j10;
                }
            }
            return optInt2;
        } catch (Throwable unused2) {
        }
    }

    public static synchronized long a() {
        long j10;
        synchronized (c.class) {
            long b4 = j.b();
            long j11 = f5189a;
            if (b4 > j11) {
                f5189a = b4;
            } else {
                f5189a = j11 + 1;
            }
            j10 = f5189a;
        }
        return j10;
    }

    private List<DPoint> a(List<DPoint> list, float f10) {
        if (list == null) {
            return null;
        }
        if (list.size() <= 2) {
            return list;
        }
        double d10 = ShadowDrawableWrapper.COS_45;
        ArrayList arrayList = new ArrayList();
        DPoint dPoint = list.get(0);
        DPoint dPoint2 = list.get(list.size() - 1);
        int i10 = 0;
        for (int i11 = 1; i11 < list.size() - 1; i11++) {
            double a10 = a(list.get(i11), dPoint, dPoint2);
            if (a10 > d10) {
                i10 = i11;
                d10 = a10;
            }
        }
        if (d10 < f10) {
            arrayList.add(dPoint);
            arrayList.add(dPoint2);
            return arrayList;
        }
        List<DPoint> a11 = a(list.subList(0, i10 + 1), f10);
        List<DPoint> a12 = a(list.subList(i10, list.size()), f10);
        arrayList.addAll(a11);
        arrayList.remove(arrayList.size() - 1);
        arrayList.addAll(a12);
        return arrayList;
    }

    private static double a(DPoint dPoint, DPoint dPoint2, DPoint dPoint3) {
        double longitude;
        double latitude;
        double longitude2 = dPoint.getLongitude() - dPoint2.getLongitude();
        double latitude2 = dPoint.getLatitude() - dPoint2.getLatitude();
        double longitude3 = dPoint3.getLongitude() - dPoint2.getLongitude();
        double latitude3 = dPoint3.getLatitude() - dPoint2.getLatitude();
        double d10 = ((longitude2 * longitude3) + (latitude2 * latitude3)) / ((longitude3 * longitude3) + (latitude3 * latitude3));
        boolean z10 = dPoint2.getLongitude() == dPoint3.getLongitude() && dPoint2.getLatitude() == dPoint3.getLatitude();
        if (d10 < ShadowDrawableWrapper.COS_45 || z10) {
            longitude = dPoint2.getLongitude();
            latitude = dPoint2.getLatitude();
        } else if (d10 > 1.0d) {
            longitude = dPoint3.getLongitude();
            latitude = dPoint3.getLatitude();
        } else {
            double longitude4 = dPoint2.getLongitude() + (longitude3 * d10);
            latitude = dPoint2.getLatitude() + (d10 * latitude3);
            longitude = longitude4;
        }
        return j.a(new DPoint(dPoint.getLatitude(), dPoint.getLongitude()), new DPoint(latitude, longitude));
    }
}
