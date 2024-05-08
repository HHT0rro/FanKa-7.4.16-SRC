package com.nostra13.universalimageloader.core.assist;

import android.widget.ImageView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public enum ViewScaleType {
    FIT_INSIDE,
    CROP;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f37742a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f37742a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37742a[ImageView.ScaleType.FIT_XY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37742a[ImageView.ScaleType.FIT_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37742a[ImageView.ScaleType.FIT_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f37742a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f37742a[ImageView.ScaleType.MATRIX.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f37742a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f37742a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static ViewScaleType fromImageView(ImageView imageView) {
        int i10 = a.f37742a[imageView.getScaleType().ordinal()];
        if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 4 && i10 != 5) {
            return CROP;
        }
        return FIT_INSIDE;
    }
}
