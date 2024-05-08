package com.kwad.sdk.pngencrypt;

import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public enum FilterType {
    FILTER_NONE(0),
    FILTER_SUB(1),
    FILTER_UP(2),
    FILTER_AVERAGE(3),
    FILTER_PAETH(4),
    FILTER_DEFAULT(-1),
    FILTER_AGGRESSIVE(-2),
    FILTER_VERYAGGRESSIVE(-4),
    FILTER_ADAPTIVE_FULL(-4),
    FILTER_ADAPTIVE_MEDIUM(-3),
    FILTER_ADAPTIVE_FAST(-2),
    FILTER_SUPER_ADAPTIVE(-10),
    FILTER_PRESERVE(-40),
    FILTER_CYCLIC(-50),
    FILTER_UNKNOWN(-100);

    private static HashMap<Integer, FilterType> byVal = new HashMap<>();
    public final int val;

    static {
        for (FilterType filterType : values()) {
            byVal.put(Integer.valueOf(filterType.val), filterType);
        }
    }

    FilterType(int i10) {
        this.val = i10;
    }

    public static FilterType[] getAllStandard() {
        return new FilterType[]{FILTER_NONE, FILTER_SUB, FILTER_UP, FILTER_AVERAGE, FILTER_PAETH};
    }

    public static FilterType[] getAllStandardExceptNone() {
        return new FilterType[]{FILTER_SUB, FILTER_UP, FILTER_AVERAGE, FILTER_PAETH};
    }

    public static FilterType[] getAllStandardForFirstRow() {
        return new FilterType[]{FILTER_SUB, FILTER_NONE};
    }

    public static FilterType[] getAllStandardNoneLast() {
        return new FilterType[]{FILTER_SUB, FILTER_UP, FILTER_AVERAGE, FILTER_PAETH, FILTER_NONE};
    }

    public static FilterType getByVal(int i10) {
        return byVal.get(Integer.valueOf(i10));
    }

    public static boolean isAdaptive(FilterType filterType) {
        int i10 = filterType.val;
        return i10 <= -2 && i10 >= -4;
    }

    public static boolean isValidStandard(int i10) {
        return i10 >= 0 && i10 <= 4;
    }

    public static boolean isValidStandard(FilterType filterType) {
        return filterType != null && isValidStandard(filterType.val);
    }
}
