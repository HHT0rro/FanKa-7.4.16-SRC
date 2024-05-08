package com.amap.api.maps.model;

import android.graphics.Color;
import com.amap.api.maps.AMapException;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class Gradient {
    private static final int DEFAULT_COLOR_MAP_SIZE = 1000;
    private boolean isAvailable;
    private int mColorMapSize;
    private int[] mColors;
    private float[] mStartPoints;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f8204a;

        /* renamed from: b, reason: collision with root package name */
        private final int f8205b;

        /* renamed from: c, reason: collision with root package name */
        private final float f8206c;

        public /* synthetic */ a(int i10, int i11, float f10, byte b4) {
            this(i10, i11, f10);
        }

        private a(int i10, int i11, float f10) {
            this.f8204a = i10;
            this.f8205b = i11;
            this.f8206c = f10;
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, (byte) 0);
    }

    private HashMap<Integer, a> a() {
        HashMap<Integer, a> hashMap = new HashMap<>(32);
        byte b4 = 0;
        if (this.mStartPoints[0] != 0.0f) {
            hashMap.put(0, new a(Color.argb(0, Color.red(this.mColors[0]), Color.green(this.mColors[0]), Color.blue(this.mColors[0])), this.mColors[0], this.mColorMapSize * this.mStartPoints[0], b4));
        }
        for (int i10 = 1; i10 < this.mColors.length; i10++) {
            int i11 = i10 - 1;
            Integer valueOf = Integer.valueOf((int) (this.mColorMapSize * this.mStartPoints[i11]));
            int[] iArr = this.mColors;
            int i12 = iArr[i11];
            int i13 = iArr[i10];
            float f10 = this.mColorMapSize;
            float[] fArr = this.mStartPoints;
            hashMap.put(valueOf, new a(i12, i13, f10 * (fArr[i10] - fArr[i11]), b4));
        }
        float[] fArr2 = this.mStartPoints;
        if (fArr2[fArr2.length - 1] != 1.0f) {
            int length = fArr2.length - 1;
            Integer valueOf2 = Integer.valueOf((int) (this.mColorMapSize * fArr2[length]));
            int[] iArr2 = this.mColors;
            hashMap.put(valueOf2, new a(iArr2[length], iArr2[length], this.mColorMapSize * (1.0f - this.mStartPoints[length]), b4));
        }
        return hashMap;
    }

    public int[] generateColorMap(double d10) {
        HashMap<Integer, a> a10 = a();
        int[] iArr = new int[this.mColorMapSize];
        a aVar = a10.get(0);
        int i10 = 0;
        for (int i11 = 0; i11 < this.mColorMapSize; i11++) {
            if (a10.containsKey(Integer.valueOf(i11))) {
                aVar = a10.get(Integer.valueOf(i11));
                i10 = i11;
            }
            iArr[i11] = a(aVar.f8204a, aVar.f8205b, (i11 - i10) / aVar.f8206c);
        }
        if (d10 != 1.0d) {
            for (int i12 = 0; i12 < this.mColorMapSize; i12++) {
                int i13 = iArr[i12];
                iArr[i12] = Color.argb((int) (Color.alpha(i13) * d10), Color.red(i13), Color.green(i13), Color.blue(i13));
            }
        }
        return iArr;
    }

    public int[] getColors() {
        return this.mColors;
    }

    public float[] getStartPoints() {
        return this.mStartPoints;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    private Gradient(int[] iArr, float[] fArr, byte b4) {
        this.isAvailable = true;
        try {
            if (iArr != null && fArr != null) {
                if (iArr.length == fArr.length) {
                    if (iArr.length != 0) {
                        for (int i10 = 1; i10 < fArr.length; i10++) {
                            if (fArr[i10] < fArr[i10 - 1]) {
                                throw new AMapException("startPoints should be in increasing order");
                            }
                        }
                        this.mColorMapSize = 1000;
                        int[] iArr2 = new int[iArr.length];
                        this.mColors = iArr2;
                        this.mStartPoints = new float[fArr.length];
                        System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, iArr.length);
                        System.arraycopy((Object) fArr, 0, (Object) this.mStartPoints, 0, fArr.length);
                        this.isAvailable = true;
                        return;
                    }
                    throw new AMapException("No colors have been defined");
                }
                throw new AMapException("colors and startPoints should be same length");
            }
            throw new AMapException("colors and startPoints should not be null");
        } catch (AMapException e2) {
            this.isAvailable = false;
            e2.getErrorMessage();
            e2.printStackTrace();
        }
    }

    private static int a(int i10, int i11, float f10) {
        int alpha = (int) (((Color.alpha(i11) - Color.alpha(i10)) * f10) + Color.alpha(i10));
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i10), Color.green(i10), Color.blue(i10), fArr);
        float[] fArr2 = new float[3];
        Color.RGBToHSV(Color.red(i11), Color.green(i11), Color.blue(i11), fArr2);
        if (fArr[0] - fArr2[0] > 180.0f) {
            fArr2[0] = fArr2[0] + 360.0f;
        } else if (fArr2[0] - fArr[0] > 180.0f) {
            fArr[0] = fArr[0] + 360.0f;
        }
        float[] fArr3 = new float[3];
        for (int i12 = 0; i12 < 3; i12++) {
            fArr3[i12] = ((fArr2[i12] - fArr[i12]) * f10) + fArr[i12];
        }
        return Color.HSVToColor(alpha, fArr3);
    }
}
