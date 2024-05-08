package com.amap.api.maps.model;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ColorLatLng {
    private int color;
    private List<LatLng> latLngs;

    public ColorLatLng(List<LatLng> list, int i10) {
        ArrayList arrayList = new ArrayList();
        this.latLngs = arrayList;
        arrayList.clear();
        this.latLngs.addAll(list);
        this.color = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ColorLatLng colorLatLng = (ColorLatLng) obj;
            if (this.color == colorLatLng.color && Objects.equals(this.latLngs, colorLatLng.latLngs)) {
                return true;
            }
        }
        return false;
    }

    public int getColor() {
        return this.color;
    }

    public List<LatLng> getLatLngs() {
        return this.latLngs;
    }

    public int hashCode() {
        return Objects.hash(this.latLngs, Integer.valueOf(this.color));
    }

    public String toString() {
        return "ColorLatLng{latLngs=" + ((Object) this.latLngs) + ", color=" + this.color + '}';
    }
}
