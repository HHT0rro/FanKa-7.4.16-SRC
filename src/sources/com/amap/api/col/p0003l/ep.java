package com.amap.api.col.p0003l;

import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BaseOverlay;
import java.lang.ref.WeakReference;

/* compiled from: ContourLineOverlay.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ep extends BaseOverlay {

    /* renamed from: a, reason: collision with root package name */
    private eo f5584a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<IGlOverlayLayer> f5585b;

    public ep(IGlOverlayLayer iGlOverlayLayer, eo eoVar, String str) {
        super(str);
        this.f5585b = new WeakReference<>(iGlOverlayLayer);
        this.f5584a = eoVar;
    }
}
