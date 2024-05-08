package com.amap.api.maps.model;

import android.graphics.Color;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class HeatMapLayerOptions extends BaseOptions {

    @JBindingExclude
    public static final Gradient DEFAULT_GRADIENT;

    @JBindingExclude
    private static final int[] DEFAULT_GRADIENT_COLORS;

    @JBindingExclude
    private static final float[] DEFAULT_GRADIENT_START_POINTS;

    @JBindingExclude
    public static final double DEFAULT_OPACITY = 0.6d;

    @JBindingExclude
    public static final int DEFAULT_RADIUS = 12;

    @JBindingExclude
    public static final int TYPE_GRID = 1;

    @JBindingExclude
    public static final int TYPE_HEXAGON = 2;

    @JBindingExclude
    public static final int TYPE_NORMAL = 0;
    private int[] mColors;

    @JBindingExclude
    private Collection<WeightedLatLng> mData;
    private double mLatitude;
    private float[] mStartPoints;
    private double[] pointList;

    @JBindingExclude
    private Gradient mGradient = DEFAULT_GRADIENT;
    private float mSize = 2000.0f;
    private float mOpacity = 1.0f;
    private double maxIntensity = ShadowDrawableWrapper.COS_45;
    private float maxZoom = 20.0f;
    private float minZoom = 3.0f;
    private float mGap = 0.0f;
    private int mType = 2;
    private float zIndex = 0.0f;
    private boolean isVisible = true;
    private boolean isPointsUpdated = false;

    static {
        int[] iArr = {Color.rgb(102, 225, 0), Color.rgb(255, 0, 0)};
        DEFAULT_GRADIENT_COLORS = iArr;
        float[] fArr = {0.2f, 1.0f};
        DEFAULT_GRADIENT_START_POINTS = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
    }

    public HeatMapLayerOptions() {
        this.type = "HeatMapLayerOptions";
    }

    private static Collection<WeightedLatLng> a(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<LatLng> iterator2 = collection.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(new WeightedLatLng(iterator2.next()));
        }
        return arrayList;
    }

    public HeatMapLayerOptions data(Collection<LatLng> collection) {
        return weightedData(a(collection));
    }

    public HeatMapLayerOptions gap(float f10) {
        this.mGap = f10;
        return this;
    }

    public Collection<WeightedLatLng> getData() {
        return this.mData;
    }

    public float getGap() {
        return this.mGap;
    }

    public Gradient getGradient() {
        return this.mGradient;
    }

    public double getMaxIntensity() {
        return this.maxIntensity;
    }

    public float getMaxZoom() {
        return this.maxZoom;
    }

    public float getMinZoom() {
        return this.minZoom;
    }

    public float getOpacity() {
        return this.mOpacity;
    }

    public float getSize() {
        return this.mSize;
    }

    public int getType() {
        return this.mType;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public HeatMapLayerOptions gradient(Gradient gradient) {
        this.mGradient = gradient;
        if (gradient != null) {
            this.mColors = gradient.getColors();
            this.mStartPoints = this.mGradient.getStartPoints();
        }
        return this;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public HeatMapLayerOptions maxIntensity(double d10) {
        this.maxIntensity = d10;
        return this;
    }

    public HeatMapLayerOptions maxZoom(float f10) {
        this.maxZoom = f10;
        return this;
    }

    public HeatMapLayerOptions minZoom(float f10) {
        this.minZoom = f10;
        return this;
    }

    public HeatMapLayerOptions opacity(float f10) {
        this.mOpacity = Math.max(0.0f, Math.min(f10, 1.0f));
        return this;
    }

    public HeatMapLayerOptions size(float f10) {
        this.mSize = f10;
        return this;
    }

    public HeatMapLayerOptions type(int i10) {
        this.mType = i10;
        return this;
    }

    public HeatMapLayerOptions visible(boolean z10) {
        this.isVisible = z10;
        return this;
    }

    public HeatMapLayerOptions weightedData(Collection<WeightedLatLng> collection) {
        this.mData = collection;
        this.isPointsUpdated = true;
        a();
        return this;
    }

    public HeatMapLayerOptions zIndex(float f10) {
        this.zIndex = f10;
        return this;
    }

    private void a() {
        Collection<WeightedLatLng> data;
        LatLng latLng;
        if (!this.isPointsUpdated || (data = getData()) == null) {
            return;
        }
        this.pointList = new double[data.size() * 3];
        int i10 = 0;
        double d10 = Double.NaN;
        double d11 = Double.NaN;
        for (WeightedLatLng weightedLatLng : data) {
            if (weightedLatLng != null && (latLng = weightedLatLng.latLng) != null) {
                double[] dArr = this.pointList;
                int i11 = i10 * 3;
                double d12 = latLng.latitude;
                dArr[i11] = d12;
                dArr[i11 + 1] = latLng.longitude;
                dArr[i11 + 2] = weightedLatLng.intensity;
                i10++;
                if (Double.isNaN(d10)) {
                    d10 = d12;
                }
                if (Double.isNaN(d11)) {
                    d11 = d12;
                }
                if (d12 > d11) {
                    d11 = d12;
                }
                if (d12 < d10) {
                    d10 = d12;
                }
            }
        }
        this.mLatitude = (Double.isNaN(d10) || Double.isNaN(d11)) ? ShadowDrawableWrapper.COS_45 : (d10 + d11) / 2.0d;
    }
}
