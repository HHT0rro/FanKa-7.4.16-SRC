package com.amap.api.col.p0003l;

import android.os.RemoteException;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* compiled from: NativeBaseTileOverlay.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class cm {

    /* renamed from: a, reason: collision with root package name */
    private final IAMapDelegate f5213a;

    /* renamed from: b, reason: collision with root package name */
    private TileOverlay f5214b;

    /* renamed from: c, reason: collision with root package name */
    private TileOverlay f5215c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5216d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f5217e = false;

    public cm(IAMapDelegate iAMapDelegate) {
        this.f5213a = iAMapDelegate;
    }

    private void b() {
        if (this.f5214b == null) {
            TileOverlayOptions tileProvider = new TileOverlayOptions().tileProvider(new de(this.f5213a.getMapConfig()));
            tileProvider.memCacheSize(10485760);
            tileProvider.diskCacheSize(20480);
            tileProvider.visible(this.f5216d);
            try {
                this.f5214b = this.f5213a.addTileOverlay(tileProvider);
                this.f5215c = this.f5213a.addTileOverlay(tileProvider);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void c() {
        boolean e2 = e();
        if (e2) {
            b();
        }
        if (this.f5216d != e2) {
            this.f5216d = e2;
            TileOverlay tileOverlay = this.f5214b;
            if (tileOverlay != null) {
                tileOverlay.setVisible(e2);
            }
        }
    }

    private void d() {
        boolean f10 = f();
        if (f10) {
            b();
        }
        if (this.f5217e != f10) {
            this.f5217e = f10;
            TileOverlay tileOverlay = this.f5215c;
            if (tileOverlay != null) {
                tileOverlay.setVisible(f10);
            }
        }
    }

    private boolean e() {
        IAMapDelegate iAMapDelegate = this.f5213a;
        if (iAMapDelegate == null) {
            return false;
        }
        return iAMapDelegate.getMapConfig().getMapLanguage().equals("en");
    }

    private static boolean f() {
        return MapsInitializer.isLoadWorldGridMap();
    }

    public final void a() {
        c();
        d();
    }
}
