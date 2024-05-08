package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.Color;
import androidx.collection.LongSparseArray;
import com.amap.api.col.p0003l.dg;
import com.amap.api.maps.AMapException;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class HeatmapTileProvider implements TileProvider {
    public static final Gradient DEFAULT_GRADIENT;
    private static final int[] DEFAULT_GRADIENT_COLORS;
    private static final float[] DEFAULT_GRADIENT_START_POINTS;
    private static final int DEFAULT_MAX_ZOOM = 11;
    private static final int DEFAULT_MIN_ZOOM = 5;
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;
    private static final int MAX_RADIUS = 200;
    private static final int MAX_ZOOM_LEVEL = 21;
    private static final int MIN_RADIUS = 10;
    private static final int SCREEN_SIZE = 1280;
    private static final int TILE_DIM = 256;
    private dg mBounds;
    private int[] mColorMap;
    private Collection<WeightedLatLng> mData;
    private Gradient mGradient;
    private double[] mKernel;
    private double[] mMaxIntensity;
    private double mOpacity;
    private int mRadius;
    private a mTree;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class Builder {
        private Collection<WeightedLatLng> data;
        private int radius = 12;
        private Gradient gradient = HeatmapTileProvider.DEFAULT_GRADIENT;
        private double opacity = 0.6d;

        public HeatmapTileProvider build() {
            Collection<WeightedLatLng> collection = this.data;
            if (collection != null && collection.size() != 0) {
                try {
                    return new HeatmapTileProvider(this, (byte) 0);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
            try {
                throw new AMapException("No input points.");
            } catch (AMapException e2) {
                e2.getErrorMessage();
                e2.printStackTrace();
                return null;
            }
        }

        public Builder data(Collection<LatLng> collection) {
            return weightedData(HeatmapTileProvider.c(collection));
        }

        public Builder gradient(Gradient gradient) {
            this.gradient = gradient;
            return this;
        }

        public Builder radius(int i10) {
            this.radius = Math.max(10, Math.min(i10, 200));
            return this;
        }

        public Builder transparency(double d10) {
            this.opacity = Math.max(ShadowDrawableWrapper.COS_45, Math.min(d10, 1.0d));
            return this;
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            this.data = collection;
            return this;
        }
    }

    static {
        int[] iArr = {Color.rgb(102, 225, 0), Color.rgb(255, 0, 0)};
        DEFAULT_GRADIENT_COLORS = iArr;
        float[] fArr = {0.2f, 1.0f};
        DEFAULT_GRADIENT_START_POINTS = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
    }

    public /* synthetic */ HeatmapTileProvider(Builder builder, byte b4) {
        this(builder);
    }

    private void b(Collection<WeightedLatLng> collection) {
        try {
            ArrayList arrayList = new ArrayList();
            for (WeightedLatLng weightedLatLng : collection) {
                double d10 = weightedLatLng.latLng.latitude;
                if (d10 < 85.0d && d10 > -85.0d) {
                    arrayList.add(weightedLatLng);
                }
            }
            this.mData = arrayList;
            dg d11 = d(arrayList);
            this.mBounds = d11;
            this.mTree = new a(d11);
            Iterator<WeightedLatLng> iterator2 = this.mData.iterator2();
            while (iterator2.hasNext()) {
                this.mTree.a(iterator2.next());
            }
            this.mMaxIntensity = a(this.mRadius);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Collection<WeightedLatLng> c(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<LatLng> iterator2 = collection.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(new WeightedLatLng(iterator2.next()));
        }
        return arrayList;
    }

    private static dg d(Collection<WeightedLatLng> collection) {
        Iterator<WeightedLatLng> iterator2 = collection.iterator2();
        WeightedLatLng next = iterator2.next();
        double d10 = next.getPoint().f9303x;
        double d11 = next.getPoint().f9303x;
        double d12 = d10;
        double d13 = d11;
        double d14 = next.getPoint().f9304y;
        double d15 = next.getPoint().f9304y;
        while (iterator2.hasNext()) {
            WeightedLatLng next2 = iterator2.next();
            double d16 = next2.getPoint().f9303x;
            double d17 = next2.getPoint().f9304y;
            if (d16 < d12) {
                d12 = d16;
            }
            if (d16 > d13) {
                d13 = d16;
            }
            if (d17 < d14) {
                d14 = d17;
            }
            if (d17 > d15) {
                d15 = d17;
            }
        }
        return new dg(d12, d13, d14, d15);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00ab  */
    @Override // com.amap.api.maps.model.TileProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.amap.api.maps.model.Tile getTile(int r37, int r38, int r39) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.model.HeatmapTileProvider.getTile(int, int, int):com.amap.api.maps.model.Tile");
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileHeight() {
        return 256;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileWidth() {
        return 256;
    }

    private HeatmapTileProvider(Builder builder) {
        this.mData = builder.data;
        this.mRadius = builder.radius;
        Gradient gradient = builder.gradient;
        this.mGradient = gradient;
        if (gradient == null || !gradient.isAvailable()) {
            this.mGradient = DEFAULT_GRADIENT;
        }
        this.mOpacity = builder.opacity;
        int i10 = this.mRadius;
        this.mKernel = a(i10, i10 / 3.0d);
        a(this.mGradient);
        b(this.mData);
    }

    private void a(Gradient gradient) {
        this.mGradient = gradient;
        this.mColorMap = gradient.generateColorMap(this.mOpacity);
    }

    private double[] a(int i10) {
        int i11;
        double[] dArr = new double[21];
        int i12 = 5;
        while (true) {
            if (i12 >= 11) {
                break;
            }
            dArr[i12] = a(this.mData, this.mBounds, i10, (int) (Math.pow(2.0d, i12) * 1280.0d));
            if (i12 == 5) {
                for (int i13 = 0; i13 < i12; i13++) {
                    dArr[i13] = dArr[i12];
                }
            }
            i12++;
        }
        for (i11 = 11; i11 < 21; i11++) {
            dArr[i11] = dArr[10];
        }
        return dArr;
    }

    private static Tile a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return Tile.obtain(256, 256, byteArrayOutputStream.toByteArray());
    }

    private static double[] a(int i10, double d10) {
        double[] dArr = new double[(i10 * 2) + 1];
        for (int i11 = -i10; i11 <= i10; i11++) {
            dArr[i11 + i10] = Math.exp(((-i11) * i11) / ((2.0d * d10) * d10));
        }
        return dArr;
    }

    private static double[][] a(double[][] dArr, double[] dArr2) {
        int floor = (int) Math.floor(dArr2.length / 2.0d);
        int length = dArr.length;
        int i10 = length - (floor * 2);
        int i11 = 1;
        int i12 = (floor + i10) - 1;
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) double.class, length, length);
        int i13 = 0;
        while (true) {
            double d10 = ShadowDrawableWrapper.COS_45;
            if (i13 >= length) {
                break;
            }
            int i14 = 0;
            while (i14 < length) {
                double d11 = dArr[i13][i14];
                if (d11 != d10) {
                    int i15 = i13 + floor;
                    if (i12 < i15) {
                        i15 = i12;
                    }
                    int i16 = i15 + 1;
                    int i17 = i13 - floor;
                    for (int i18 = floor > i17 ? floor : i17; i18 < i16; i18++) {
                        double[] dArr4 = dArr3[i18];
                        dArr4[i14] = dArr4[i14] + (dArr2[i18 - i17] * d11);
                    }
                }
                i14++;
                d10 = ShadowDrawableWrapper.COS_45;
            }
            i13++;
        }
        double[][] dArr5 = (double[][]) Array.newInstance((Class<?>) double.class, i10, i10);
        int i19 = floor;
        while (i19 < i12 + 1) {
            int i20 = 0;
            while (i20 < length) {
                double d12 = dArr3[i19][i20];
                if (d12 != ShadowDrawableWrapper.COS_45) {
                    int i21 = i20 + floor;
                    if (i12 < i21) {
                        i21 = i12;
                    }
                    int i22 = i21 + i11;
                    int i23 = i20 - floor;
                    for (int i24 = floor > i23 ? floor : i23; i24 < i22; i24++) {
                        double[] dArr6 = dArr5[i19 - floor];
                        int i25 = i24 - floor;
                        dArr6[i25] = dArr6[i25] + (dArr2[i24 - i23] * d12);
                    }
                }
                i20++;
                i11 = 1;
            }
            i19++;
            i11 = 1;
        }
        return dArr5;
    }

    private static Bitmap a(double[][] dArr, int[] iArr, double d10) {
        int i10 = iArr[iArr.length - 1];
        double length = (iArr.length - 1) / d10;
        int length2 = dArr.length;
        int[] iArr2 = new int[length2 * length2];
        for (int i11 = 0; i11 < length2; i11++) {
            for (int i12 = 0; i12 < length2; i12++) {
                double d11 = dArr[i12][i11];
                int i13 = (i11 * length2) + i12;
                int i14 = (int) (d11 * length);
                if (d11 != ShadowDrawableWrapper.COS_45) {
                    if (i14 < iArr.length) {
                        iArr2[i13] = iArr[i14];
                    } else {
                        iArr2[i13] = i10;
                    }
                } else {
                    iArr2[i13] = 0;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(length2, length2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr2, 0, length2, 0, 0, length2, length2);
        return createBitmap;
    }

    private static double a(Collection<WeightedLatLng> collection, dg dgVar, int i10, int i11) {
        double d10 = dgVar.f5338a;
        double d11 = dgVar.f5340c;
        double d12 = dgVar.f5339b;
        double d13 = d11 - d10;
        double d14 = dgVar.f5341d - d12;
        if (d13 <= d14) {
            d13 = d14;
        }
        double d15 = ((int) ((i11 / (i10 * 2)) + 0.5d)) / d13;
        LongSparseArray longSparseArray = new LongSparseArray();
        double d16 = ShadowDrawableWrapper.COS_45;
        for (WeightedLatLng weightedLatLng : collection) {
            double d17 = weightedLatLng.getPoint().f9303x;
            int i12 = (int) ((weightedLatLng.getPoint().f9304y - d12) * d15);
            long j10 = (int) ((d17 - d10) * d15);
            LongSparseArray longSparseArray2 = (LongSparseArray) longSparseArray.get(j10);
            if (longSparseArray2 == null) {
                longSparseArray2 = new LongSparseArray();
                longSparseArray.put(j10, longSparseArray2);
            }
            long j11 = i12;
            Double d18 = (Double) longSparseArray2.get(j11);
            if (d18 == null) {
                d18 = Double.valueOf(ShadowDrawableWrapper.COS_45);
            }
            LongSparseArray longSparseArray3 = longSparseArray;
            double d19 = d10;
            Double valueOf = Double.valueOf(d18.doubleValue() + weightedLatLng.intensity);
            longSparseArray2.put(j11, valueOf);
            if (valueOf.doubleValue() > d16) {
                d16 = valueOf.doubleValue();
            }
            longSparseArray = longSparseArray3;
            d10 = d19;
        }
        return d16;
    }
}
