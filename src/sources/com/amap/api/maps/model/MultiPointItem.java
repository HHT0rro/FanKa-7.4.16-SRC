package com.amap.api.maps.model;

import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MultiPointItem {

    @JBindingInclude
    private String customerId = null;
    private IPoint iPoint;

    @JBindingInclude
    private LatLng latLng;
    private Object object;

    @JBindingInclude
    private String snippet;

    @JBindingInclude
    private String title;

    @JBindingInclude
    private MultiPointItem() {
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof MultiPointItem)) {
            return false;
        }
        if (this.customerId != null) {
            MultiPointItem multiPointItem = (MultiPointItem) obj;
            if (multiPointItem.getCustomerId() != null) {
                return this.customerId.equals(multiPointItem.getCustomerId());
            }
        }
        return super.equals(obj);
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public IPoint getIPoint() {
        return this.iPoint;
    }

    public LatLng getLatLng() {
        return this.latLng;
    }

    public Object getObject() {
        return this.object;
    }

    public String getSnippet() {
        return this.snippet;
    }

    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void setCustomerId(String str) {
        this.customerId = str;
    }

    public void setIPoint(IPoint iPoint) {
        this.iPoint = iPoint;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public void setObject(Object obj) {
        this.object = obj;
    }

    public void setSnippet(String str) {
        this.snippet = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public MultiPointItem(LatLng latLng) {
        this.latLng = latLng;
    }
}
