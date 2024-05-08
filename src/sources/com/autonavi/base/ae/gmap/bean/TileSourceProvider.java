package com.autonavi.base.ae.gmap.bean;

import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface TileSourceProvider extends TileProvider {
    @JBindingInclude
    void cancel(TileSourceReq tileSourceReq);

    @JBindingInclude
    Tile getTile(TileSourceReq tileSourceReq);
}
