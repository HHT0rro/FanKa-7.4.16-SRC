package com.autonavi.base.ae.gmap.bean;

import android.text.TextUtils;
import com.amap.api.col.p0003l.dv;
import com.amap.api.col.p0003l.je;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileOverlaySource;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class TileProviderInner {

    @JBindingExclude
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;

    @JBindingInclude
    private List<TileOverlaySource> mTileSource;

    @JBindingExclude
    private String overlayName;

    @JBindingExclude
    private final HashMap<String, je> reqTaskHandleHashMap = new HashMap<>();

    @JBindingExclude
    private final TileProvider tileProvider;

    @JBindingExclude
    public TileProviderInner(TileProvider tileProvider) {
        this.tileProvider = tileProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JBindingExclude
    public Object callNativeFunction(String str, Object[] objArr) {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return null;
            }
            return iGlOverlayLayer.getNativeProperties(this.overlayName, str, objArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @JBindingExclude
    private String createKey(int i10, int i11, int i12, long j10) {
        return i10 + " " + i11 + " " + i12 + "-" + j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishDownload(final Tile tile, final TileReqTaskHandle tileReqTaskHandle, final String str) {
        IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
        if (iGlOverlayLayer == null) {
            return;
        }
        iGlOverlayLayer.getMap().queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.bean.TileProviderInner.2
            @Override // java.lang.Runnable
            public void run() {
                boolean z10;
                synchronized (TileProviderInner.this.reqTaskHandleHashMap) {
                    if (TileProviderInner.this.reqTaskHandleHashMap.containsKey(str)) {
                        if (TileProviderInner.this.reqTaskHandleHashMap.containsKey(str)) {
                            TileProviderInner.this.reqTaskHandleHashMap.remove(str);
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (z10) {
                            tileReqTaskHandle.finish(tile);
                            TileProviderInner.this.callNativeFunction("finishTileReqTask", new Object[]{tileReqTaskHandle});
                        }
                    }
                }
            }
        });
    }

    @JBindingInclude
    public void cancelTile(TileSourceReq tileSourceReq, TileReqTaskHandle tileReqTaskHandle) {
        String createKey = createKey(tileSourceReq.f9681x, tileSourceReq.f9682y, tileSourceReq.zoom, tileReqTaskHandle.nativeObj);
        synchronized (this.reqTaskHandleHashMap) {
            if (this.reqTaskHandleHashMap.containsKey(createKey)) {
                je jeVar = this.reqTaskHandleHashMap.get(createKey);
                if (jeVar != null) {
                    dv.a();
                    dv.b(jeVar);
                }
                tileReqTaskHandle.status = 1;
                finishDownload(TileProvider.NO_TILE, tileReqTaskHandle, createKey);
                try {
                    TileProvider tileProvider = this.tileProvider;
                    if (tileProvider instanceof TileSourceProvider) {
                        ((TileSourceProvider) tileProvider).cancel(tileSourceReq);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    @JBindingInclude
    public void getTile(final TileSourceReq tileSourceReq, final TileReqTaskHandle tileReqTaskHandle) {
        final String createKey = createKey(tileSourceReq.f9681x, tileSourceReq.f9682y, tileSourceReq.zoom, tileReqTaskHandle.nativeObj);
        je jeVar = new je() { // from class: com.autonavi.base.ae.gmap.bean.TileProviderInner.1
            @Override // com.amap.api.col.p0003l.je
            public void runTask() {
                try {
                    synchronized (TileProviderInner.this.reqTaskHandleHashMap) {
                        if (TileProviderInner.this.reqTaskHandleHashMap.containsKey(createKey)) {
                            if (TileProviderInner.this.tileProvider != null) {
                                Tile tile = TileProvider.NO_TILE;
                                try {
                                    if (TileProviderInner.this.tileProvider instanceof TileSourceProvider) {
                                        tile = ((TileSourceProvider) TileProviderInner.this.tileProvider).getTile(tileSourceReq);
                                    } else {
                                        TileProvider tileProvider = TileProviderInner.this.tileProvider;
                                        TileSourceReq tileSourceReq2 = tileSourceReq;
                                        tile = tileProvider.getTile(tileSourceReq2.f9681x, tileSourceReq2.f9682y, tileSourceReq2.zoom);
                                    }
                                } catch (Throwable unused) {
                                }
                                TileProviderInner.this.finishDownload(tile, tileReqTaskHandle, createKey);
                            }
                        }
                    }
                } catch (Throwable th) {
                    TileProviderInner.this.finishDownload(TileProvider.NO_TILE, tileReqTaskHandle, createKey);
                    th.printStackTrace();
                }
            }
        };
        synchronized (this.reqTaskHandleHashMap) {
            if (this.reqTaskHandleHashMap.containsKey(createKey)) {
                return;
            }
            this.reqTaskHandleHashMap.put(createKey, jeVar);
            dv.a().a(jeVar);
        }
    }

    @JBindingInclude
    public int getTileHeight() {
        TileProvider tileProvider = this.tileProvider;
        if (tileProvider != null) {
            return tileProvider.getTileHeight();
        }
        return 0;
    }

    @JBindingInclude
    public int getTileWidth() {
        TileProvider tileProvider = this.tileProvider;
        if (tileProvider != null) {
            return tileProvider.getTileWidth();
        }
        return 0;
    }

    @JBindingExclude
    public void init(IGlOverlayLayer iGlOverlayLayer, String str) {
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.overlayName = str;
    }

    public void setTileSource(List<TileOverlaySource> list) {
        this.mTileSource = list;
    }
}
