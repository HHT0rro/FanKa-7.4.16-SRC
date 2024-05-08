package com.huawei.quickcard.rating.utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class RatingAttr {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface Attributes {
        public static final String INDICATOR = "indicator";
        public static final String NUM_STARS = "numstars";
        public static final String RATING = "rating";
        public static final String STEP_SIZE = "stepsize";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface Event {
        public static final String CHANGE = "change";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface Style {
        public static final String STAR_BACKGROUND = "starBackground";
        public static final String STAR_FOREGROUND = "starForeground";
        public static final String STAR_SECONDARY = "starSecondary";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface Value {
        public static final boolean DEFAULT_INDICATOR = false;
        public static final int DEFAULT_MAX = 100;
        public static final int DEFAULT_NUM_STAR = 5;
        public static final int DEFAULT_RATING = 0;
        public static final float DEFAULT_STEP_SIZE = 0.5f;
    }
}
