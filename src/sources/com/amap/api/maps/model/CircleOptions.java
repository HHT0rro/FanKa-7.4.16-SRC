package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0003l.dx;
import com.amap.api.maps.model.BaseOptions;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class CircleOptions extends BaseOptions implements Parcelable, Cloneable {

    @JBindingExclude
    public static final CircleOptionsCreator CREATOR = new CircleOptionsCreator();

    /* renamed from: a, reason: collision with root package name */
    @JBindingExclude
    public String f8201a;
    private LatLng point = null;
    private double radius = ShadowDrawableWrapper.COS_45;
    private float strokeWidth = 10.0f;
    private int strokeColor = -16777216;
    private int fillColor = 0;
    private float zIndex = 0.0f;
    private boolean isVisible = true;
    private int dottedLineType = -1;
    private boolean isUsePolylineStroke = true;
    private CircleUpdateFlags updateFlags = new CircleUpdateFlags();
    private List<BaseHoleOptions> holeOptions = new ArrayList();

    @JBindingInclude
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class CircleUpdateFlags extends BaseOptions.BaseUpdateFlags {
        public boolean isCenterUpdated = false;
        public boolean isRadiusUpdated = false;
        public boolean isHoleOptionsUpdated = false;

        @Override // com.amap.api.maps.model.BaseOptions.BaseUpdateFlags
        public void reset() {
            super.reset();
            this.isCenterUpdated = false;
            this.isRadiusUpdated = false;
            this.isHoleOptionsUpdated = false;
        }
    }

    public CircleOptions() {
        this.type = "CircleOptions";
    }

    private void a() {
        if (this.holeOptions != null) {
            ArrayList arrayList = new ArrayList();
            List<BaseHoleOptions> list = this.holeOptions;
            for (int i10 = 0; i10 < list.size(); i10++) {
                BaseHoleOptions baseHoleOptions = list.get(i10);
                if (baseHoleOptions instanceof PolygonHoleOptions) {
                    PolygonHoleOptions polygonHoleOptions = (PolygonHoleOptions) baseHoleOptions;
                    if (dx.a(getRadius(), getCenter(), arrayList, polygonHoleOptions) && !dx.a(arrayList, polygonHoleOptions)) {
                        arrayList.add(polygonHoleOptions);
                    }
                } else if (baseHoleOptions instanceof CircleHoleOptions) {
                    CircleHoleOptions circleHoleOptions = (CircleHoleOptions) baseHoleOptions;
                    if (dx.a(getRadius(), getCenter(), circleHoleOptions) && !dx.a(arrayList, circleHoleOptions)) {
                        arrayList.add(circleHoleOptions);
                    }
                }
            }
            this.holeOptions.clear();
            this.holeOptions.addAll(arrayList);
            this.updateFlags.isHoleOptionsUpdated = true;
        }
    }

    public final CircleOptions addHoles(BaseHoleOptions... baseHoleOptionsArr) {
        if (baseHoleOptionsArr != null) {
            try {
                this.holeOptions.addAll(Arrays.asList(baseHoleOptionsArr));
                a();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public final CircleOptions center(LatLng latLng) {
        this.point = latLng;
        this.updateFlags.isCenterUpdated = true;
        a();
        return this;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final CircleOptions fillColor(int i10) {
        this.fillColor = i10;
        return this;
    }

    public final LatLng getCenter() {
        return this.point;
    }

    public final int getFillColor() {
        return this.fillColor;
    }

    public final List<BaseHoleOptions> getHoleOptions() {
        return this.holeOptions;
    }

    public final double getRadius() {
        return this.radius;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final int getStrokeDottedLineType() {
        return this.dottedLineType;
    }

    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final boolean isUsePolylineStroke() {
        return this.isUsePolylineStroke;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final CircleOptions radius(double d10) {
        this.radius = d10;
        this.updateFlags.isRadiusUpdated = true;
        a();
        return this;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public final void resetUpdateFlags() {
        this.updateFlags.reset();
    }

    public final CircleOptions setStrokeDottedLineType(int i10) {
        this.dottedLineType = i10;
        return this;
    }

    public final CircleOptions strokeColor(int i10) {
        this.strokeColor = i10;
        return this;
    }

    public final CircleOptions strokeWidth(float f10) {
        this.strokeWidth = f10;
        return this;
    }

    public final CircleOptions usePolylineStroke(boolean z10) {
        this.isUsePolylineStroke = z10;
        return this;
    }

    public final CircleOptions visible(boolean z10) {
        this.isVisible = z10;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        Bundle bundle = new Bundle();
        LatLng latLng = this.point;
        if (latLng != null) {
            bundle.putDouble("lat", latLng.latitude);
            bundle.putDouble("lng", this.point.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.radius);
        parcel.writeFloat(this.strokeWidth);
        parcel.writeInt(this.strokeColor);
        parcel.writeInt(this.fillColor);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f8201a);
        parcel.writeList(this.holeOptions);
        parcel.writeInt(this.dottedLineType);
        parcel.writeByte(this.isUsePolylineStroke ? (byte) 1 : (byte) 0);
    }

    public final CircleOptions zIndex(float f10) {
        if (this.zIndex != f10) {
            this.updateFlags.zIndexUpdate = true;
        }
        this.zIndex = f10;
        return this;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final CircleOptions m1961clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
        }
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.f8201a = this.f8201a;
        circleOptions.point = this.point;
        circleOptions.radius = this.radius;
        circleOptions.strokeWidth = this.strokeWidth;
        circleOptions.strokeColor = this.strokeColor;
        circleOptions.fillColor = this.fillColor;
        circleOptions.zIndex = this.zIndex;
        circleOptions.isVisible = this.isVisible;
        circleOptions.holeOptions = this.holeOptions;
        circleOptions.dottedLineType = this.dottedLineType;
        circleOptions.isUsePolylineStroke = this.isUsePolylineStroke;
        circleOptions.updateFlags = this.updateFlags;
        return circleOptions;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public final CircleUpdateFlags getUpdateFlags() {
        return this.updateFlags;
    }

    public final CircleOptions addHoles(Iterable<BaseHoleOptions> iterable) {
        if (iterable != null) {
            try {
                Iterator<BaseHoleOptions> iterator2 = iterable.iterator2();
                while (iterator2.hasNext()) {
                    this.holeOptions.add(iterator2.next());
                }
                a();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }
}
