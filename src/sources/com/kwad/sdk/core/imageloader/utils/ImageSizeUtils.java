package com.kwad.sdk.core.imageloader.utils;

import android.opengl.GLES10;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.assist.ViewScaleType;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ImageSizeUtils {
    private static final int DEFAULT_MAX_BITMAP_DIMENSION = 2048;
    private static ImageSize maxBitmapSize;

    /* renamed from: com.kwad.sdk.core.imageloader.utils.ImageSizeUtils$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType;

        static {
            int[] iArr = new int[ViewScaleType.values().length];
            $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType = iArr;
            try {
                iArr[ViewScaleType.FIT_INSIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType[ViewScaleType.CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int max = Math.max(iArr[0], 2048);
        maxBitmapSize = new ImageSize(max, max);
    }

    private ImageSizeUtils() {
    }

    public static int computeImageSampleSize(ImageSize imageSize, ImageSize imageSize2, ViewScaleType viewScaleType, boolean z10) {
        int max;
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        int width2 = imageSize2.getWidth();
        int height2 = imageSize2.getHeight();
        int i10 = AnonymousClass1.$SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType[viewScaleType.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                max = 1;
            } else if (z10) {
                int i11 = width / 2;
                int i12 = height / 2;
                max = 1;
                while (i11 / max > width2 && i12 / max > height2) {
                    max *= 2;
                }
            } else {
                max = Math.min(width / width2, height / height2);
            }
        } else if (z10) {
            int i13 = width / 2;
            int i14 = height / 2;
            max = 1;
            while (true) {
                if (i13 / max <= width2 && i14 / max <= height2) {
                    break;
                }
                max *= 2;
            }
        } else {
            max = Math.max(width / width2, height / height2);
        }
        return considerMaxTextureSize(width, height, max > 0 ? max : 1, z10);
    }

    public static float computeImageScale(ImageSize imageSize, ImageSize imageSize2, ViewScaleType viewScaleType, boolean z10) {
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        int width2 = imageSize2.getWidth();
        int height2 = imageSize2.getHeight();
        float f10 = width;
        float f11 = f10 / width2;
        float f12 = height;
        float f13 = f12 / height2;
        if ((viewScaleType != ViewScaleType.FIT_INSIDE || f11 < f13) && (viewScaleType != ViewScaleType.CROP || f11 >= f13)) {
            width2 = (int) (f10 / f13);
        } else {
            height2 = (int) (f12 / f11);
        }
        if ((z10 || width2 >= width || height2 >= height) && (!z10 || width2 == width || height2 == height)) {
            return 1.0f;
        }
        return width2 / f10;
    }

    public static int computeMinImageSampleSize(ImageSize imageSize) {
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        return Math.max((int) Math.ceil(width / maxBitmapSize.getWidth()), (int) Math.ceil(height / maxBitmapSize.getHeight()));
    }

    private static int considerMaxTextureSize(int i10, int i11, int i12, boolean z10) {
        int width = maxBitmapSize.getWidth();
        int height = maxBitmapSize.getHeight();
        while (true) {
            if (i10 / i12 <= width && i11 / i12 <= height) {
                return i12;
            }
            i12 = z10 ? i12 * 2 : i12 + 1;
        }
    }

    public static ImageSize defineTargetSizeForView(ImageAware imageAware, ImageSize imageSize) {
        int width = imageAware.getWidth();
        if (width <= 0) {
            width = imageSize.getWidth();
        }
        int height = imageAware.getHeight();
        if (height <= 0) {
            height = imageSize.getHeight();
        }
        return new ImageSize(width, height);
    }
}
