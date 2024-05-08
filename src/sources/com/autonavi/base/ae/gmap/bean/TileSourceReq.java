package com.autonavi.base.ae.gmap.bean;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class TileSourceReq {
    public int sourceType;

    /* renamed from: x, reason: collision with root package name */
    public int f9681x;

    /* renamed from: y, reason: collision with root package name */
    public int f9682y;
    public int zoom;

    @JBindingExclude
    public String toString() {
        return "TileSourceReq{x=" + this.f9681x + ", y=" + this.f9682y + ", zoom=" + this.zoom + ", sourceId=" + this.sourceType + '}';
    }
}
