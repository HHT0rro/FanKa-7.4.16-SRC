package com.amap.api.maps.utils;

import android.util.Pair;
import com.amap.api.col.p0003l.dx;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class SpatialRelationUtil {
    public static final int A_CIRCLE_DEGREE = 360;
    public static final int A_HALF_CIRCLE_DEGREE = 180;
    public static final int MIN_OFFSET_DEGREE = 50;
    public static final int MIN_POLYLINE_POINT_SIZE = 2;

    public static Pair<Integer, LatLng> calShortestDistancePoint(List<LatLng> list, LatLng latLng, float f10, double d10) {
        if (list != null && latLng != null) {
            try {
                if (list.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    int i10 = 0;
                    for (LatLng latLng2 : list) {
                        arrayList.add(DPoint.obtain(latLng2.latitude, latLng2.longitude));
                        if (latLng2.equals(latLng)) {
                            return new Pair<>(Integer.valueOf(i10), latLng);
                        }
                        i10++;
                    }
                    Pair<Integer, DPoint> calShortestDistancePoint = calShortestDistancePoint(arrayList, DPoint.obtain(latLng.latitude, latLng.longitude), f10);
                    if (calShortestDistancePoint != null) {
                        DPoint dPoint = (DPoint) calShortestDistancePoint.second;
                        if (AMapUtils.calculateLineDistance(new LatLng(dPoint.f9303x, dPoint.f9304y), latLng) < d10) {
                            Object obj = calShortestDistancePoint.first;
                            Object obj2 = calShortestDistancePoint.second;
                            return new Pair<>(obj, new LatLng(((DPoint) obj2).f9303x, ((DPoint) obj2).f9304y));
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    private static boolean checkRotateIsMatch(DPoint dPoint, DPoint dPoint2, float f10) {
        if (f10 == -1.0f) {
            return true;
        }
        if (dPoint != null && dPoint2 != null) {
            float abs = Math.abs((dx.a(dPoint, dPoint2) + 360.0f) - f10) % 360.0f;
            if (abs > 180.0f) {
                abs = 360.0f - abs;
            }
            if (abs < 50.0f) {
                return true;
            }
        }
        return false;
    }

    private static Pair<Double, DPoint> pointToSegDist(double d10, double d11, double d12, double d13, double d14, double d15) {
        double d16 = d14 - d12;
        double d17 = d10 - d12;
        double d18 = d15 - d13;
        double d19 = d11 - d13;
        double d20 = (d16 * d17) + (d18 * d19);
        if (d20 <= ShadowDrawableWrapper.COS_45) {
            return new Pair<>(Double.valueOf(Math.sqrt((d17 * d17) + (d19 * d19))), new DPoint(d12, d13));
        }
        double d21 = (d16 * d16) + (d18 * d18);
        if (d20 >= d21) {
            double d22 = d10 - d14;
            double d23 = d11 - d15;
            return new Pair<>(Double.valueOf(Math.sqrt((d22 * d22) + (d23 * d23))), new DPoint(d14, d15));
        }
        double d24 = d20 / d21;
        double d25 = d12 + (d16 * d24);
        double d26 = d13 + (d18 * d24);
        double d27 = d10 - d25;
        double d28 = d26 - d11;
        return new Pair<>(Double.valueOf(Math.sqrt((d27 * d27) + (d28 * d28))), new DPoint(d25, d26));
    }

    public static Pair<Integer, LatLng> calShortestDistancePoint(List<LatLng> list, LatLng latLng) {
        if (list != null && latLng != null) {
            try {
                if (list.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    int i10 = 0;
                    for (LatLng latLng2 : list) {
                        arrayList.add(DPoint.obtain(latLng2.latitude, latLng2.longitude));
                        if (latLng2.equals(latLng)) {
                            return new Pair<>(Integer.valueOf(i10), latLng);
                        }
                        i10++;
                    }
                    Pair<Integer, DPoint> calShortestDistancePoint = calShortestDistancePoint(arrayList, DPoint.obtain(latLng.latitude, latLng.longitude));
                    if (calShortestDistancePoint != null) {
                        Object obj = calShortestDistancePoint.first;
                        Object obj2 = calShortestDistancePoint.second;
                        return new Pair<>(obj, new LatLng(((DPoint) obj2).f9303x, ((DPoint) obj2).f9304y));
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static Pair<Integer, DPoint> calShortestDistancePoint(List<DPoint> list, DPoint dPoint) {
        return calShortestDistancePoint(list, dPoint, -1.0f);
    }

    public static Pair<Integer, DPoint> calShortestDistancePoint(List<DPoint> list, DPoint dPoint, float f10) {
        double d10;
        int i10;
        int i11;
        double doubleValue;
        Pair<Integer, DPoint> pair;
        List<DPoint> list2 = list;
        DPoint dPoint2 = dPoint;
        Pair<Integer, DPoint> pair2 = null;
        if (list2 != null && dPoint2 != null && list.size() != 0) {
            if (list.size() >= 2) {
                DPoint dPoint3 = list2.get(0);
                double d11 = ShadowDrawableWrapper.COS_45;
                int size = list.size();
                int i12 = 1;
                int i13 = 1;
                while (true) {
                    int i14 = size - 1;
                    if (i13 > i14) {
                        break;
                    }
                    DPoint dPoint4 = list2.get(i13);
                    if (i13 == i14 && dPoint4.equals(dPoint2)) {
                        return new Pair<>(Integer.valueOf(i13), dPoint2);
                    }
                    if (!checkRotateIsMatch(dPoint3, dPoint4, f10)) {
                        d10 = d11;
                        i10 = size;
                        i11 = i13;
                    } else {
                        if (dPoint3.equals(dPoint2)) {
                            return new Pair<>(Integer.valueOf(i13 - i12), dPoint2);
                        }
                        i11 = i13;
                        d10 = d11;
                        i10 = size;
                        Pair<Double, DPoint> pointToSegDist = pointToSegDist(dPoint2.f9303x, dPoint2.f9304y, dPoint3.f9303x, dPoint3.f9304y, dPoint4.f9303x, dPoint4.f9304y);
                        if (pair2 == null) {
                            doubleValue = ((Double) pointToSegDist.first).doubleValue();
                            pair = new Pair<>(Integer.valueOf(i11 - 1), pointToSegDist.second);
                        } else if (d10 > ((Double) pointToSegDist.first).doubleValue()) {
                            doubleValue = ((Double) pointToSegDist.first).doubleValue();
                            pair = new Pair<>(Integer.valueOf(i11 - 1), pointToSegDist.second);
                        }
                        d11 = doubleValue;
                        pair2 = pair;
                        i13 = i11 + 1;
                        list2 = list;
                        dPoint2 = dPoint;
                        dPoint3 = dPoint4;
                        size = i10;
                        i12 = 1;
                    }
                    d11 = d10;
                    i13 = i11 + 1;
                    list2 = list;
                    dPoint2 = dPoint;
                    dPoint3 = dPoint4;
                    size = i10;
                    i12 = 1;
                }
            } else {
                return null;
            }
        }
        return pair2;
    }
}
