package com.amap.api.col.p0003l;

import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;

/* compiled from: StyleItemAdaptor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class cy {

    /* renamed from: a, reason: collision with root package name */
    public static final int[][] f5281a = {new int[]{0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, new int[]{12}, new int[]{1}, new int[]{13}, new int[]{14}, new int[]{15, 16}, new int[]{17, 18, 19, 20, 21, 26, 27, 28}, new int[]{22, 23}, new int[]{24, 25}, new int[]{39, 40, 41}, new int[]{29, 30, 31}, new int[]{32, 33, 34, 35, 36, 37, 38}};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f5282b = {"land", "water", "green", "building", "highway", "arterial", "local", "railway", "subway", "boundary", "poilabel", "districtlable"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[][] f5283c = {new String[]{"land", "edu", "public", "traffic", "scenicSpot", "culture", "health", "sports", "business", "parkingLot", "subway"}, new String[]{"water"}, new String[]{"green"}, new String[]{"buildings"}, new String[]{"highWay"}, new String[]{"ringRoad", "nationalRoad"}, new String[]{"provincialRoad", "secondaryRoad", "levelThreeRoad", "levelFourRoad", "roadsBeingBuilt", "overPass", "underPass", "other"}, new String[]{"railway", "highSpeedRailway"}, new String[]{"subwayline", "subwayBeingBuilt"}, new String[]{"China", "foreign", "provincial"}, new String[]{"guideBoards", "pois", "aois"}, new String[]{"continent", "country", DistrictSearchQuery.KEYWORDS_PROVINCE, DistrictSearchQuery.KEYWORDS_CITY, DistrictSearchQuery.KEYWORDS_DISTRICT, "town", "village"}};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f5284d = {"regions", "water", "regions", "buildings", "roads", "roads", "roads", "roads", "roads", "borders", "labels", "labels"};

    public static String[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i10 = -1;
        int i11 = 0;
        while (true) {
            String[] strArr = f5282b;
            if (i11 >= strArr.length) {
                break;
            }
            if (strArr[i11].equals(str)) {
                i10 = i11;
                break;
            }
            i11++;
        }
        if (i10 >= 0) {
            return f5283c[i10];
        }
        return null;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i10 = -1;
        int i11 = 0;
        while (true) {
            String[] strArr = f5282b;
            if (i11 >= strArr.length) {
                break;
            }
            if (strArr[i11].equals(str)) {
                i10 = i11;
                break;
            }
            i11++;
        }
        if (i10 >= 0) {
            return f5284d[i10];
        }
        return null;
    }
}
