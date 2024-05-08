package com.amap.api.col.p0003l;

import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileOverlaySource;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.ae.gmap.bean.TileSourceProvider;
import com.autonavi.base.ae.gmap.bean.TileSourceReq;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/* compiled from: TerrainTileSourceProvider.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class af implements TileSourceProvider {

    /* renamed from: a, reason: collision with root package name */
    private int f4907a = 256;

    /* renamed from: b, reason: collision with root package name */
    private final TileOverlaySource f4908b;

    /* renamed from: c, reason: collision with root package name */
    private final TileOverlaySource f4909c;

    /* compiled from: TerrainTileSourceProvider.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a extends df {

        /* renamed from: b, reason: collision with root package name */
        private String f4911b;

        /* renamed from: c, reason: collision with root package name */
        private String f4912c;

        public a(int i10, int i11, int i12, String str) {
            this.f4911b = "";
            this.f4912c = "";
            String format = String.format(str, Integer.valueOf(i12), Integer.valueOf(i10), Integer.valueOf(i11));
            if (!format.contains(SymbolValues.QUESTION_EN_SYMBOL)) {
                this.f4911b = format + SymbolValues.QUESTION_EN_SYMBOL;
                return;
            }
            String[] split = format.split("\\?");
            if (split.length > 1) {
                this.f4911b = split[0] + SymbolValues.QUESTION_EN_SYMBOL;
                this.f4912c = split[1];
            }
        }

        @Override // com.amap.api.col.p0003l.df, com.amap.api.col.p0003l.id
        public final Map<String, String> getRequestHead() {
            return super.getRequestHead();
        }

        @Override // com.amap.api.col.p0003l.id
        public final String getURL() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.f4912c);
            stringBuffer.append("&key=");
            stringBuffer.append(fj.f(ab.f4885a));
            stringBuffer.append("&channel=amapapi");
            return this.f4911b + appendTsScode(stringBuffer.toString());
        }
    }

    public af(TileOverlaySource tileOverlaySource, TileOverlaySource tileOverlaySource2) {
        this.f4908b = tileOverlaySource;
        this.f4909c = tileOverlaySource2;
    }

    private Tile a(TileSourceReq tileSourceReq) {
        String str = MapsInitializer.TERRAIN_LOCAL_DEM_SOURCE_PATH;
        try {
            int i10 = tileSourceReq.f9681x;
            if (i10 > 0) {
                i10 /= 10;
            }
            int i11 = tileSourceReq.f9682y;
            if (i11 > 0) {
                i11 /= 10;
            }
            FileInputStream fileInputStream = new FileInputStream(new File(str + tileSourceReq.zoom + "/" + i10 + "/" + i11 + "/" + tileSourceReq.f9681x + "_" + tileSourceReq.f9682y + ".png"));
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            int i12 = this.f4907a;
            Tile tile = new Tile(i12, i12, bArr, true);
            fileInputStream.close();
            return tile;
        } catch (FileNotFoundException unused) {
            int i13 = tileSourceReq.f9681x;
            int i14 = tileSourceReq.zoom;
            int i15 = i13 >> (i14 - 6);
            int i16 = tileSourceReq.f9682y >> (i14 - 6);
            if (i15 >= 51 && i15 <= 53 && i16 >= 28 && i16 <= 31) {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(new File(str + "default.png"));
                    byte[] bArr2 = new byte[fileInputStream2.available()];
                    fileInputStream2.read(bArr2);
                    int i17 = this.f4907a;
                    Tile tile2 = new Tile(i17, i17, bArr2, true);
                    fileInputStream2.close();
                    return tile2;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return TileProvider.NO_TILE;
                }
            }
            return TileProvider.NO_TILE;
        } catch (IOException unused2) {
            return TileProvider.NO_TILE;
        }
    }

    @Override // com.autonavi.base.ae.gmap.bean.TileSourceProvider
    public final void cancel(TileSourceReq tileSourceReq) {
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final Tile getTile(int i10, int i11, int i12) {
        return null;
    }

    @Override // com.autonavi.base.ae.gmap.bean.TileSourceProvider
    public final Tile getTile(TileSourceReq tileSourceReq) {
        String url;
        if (tileSourceReq == null) {
            return TileProvider.NO_TILE;
        }
        Tile tile = TileProvider.NO_TILE;
        try {
            if (tileSourceReq.sourceType == this.f4909c.getId()) {
                url = this.f4909c.getUrl();
            } else {
                url = this.f4908b.getUrl();
            }
            if (url == null) {
                return tile;
            }
            Tile a10 = MapsInitializer.TERRAIN_LOCAL_DEM_SOURCE_PATH != null ? a(tileSourceReq) : tile;
            if (a10 != tile) {
                return a10;
            }
            int i10 = this.f4907a;
            return new Tile(i10, i10, a(tileSourceReq.f9681x, tileSourceReq.f9682y, tileSourceReq.zoom, url), true);
        } catch (Exception e2) {
            Tile tile2 = TileProvider.NO_TILE;
            e2.printStackTrace();
            return tile2;
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileHeight() {
        return this.f4907a;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileWidth() {
        return this.f4907a;
    }

    private byte[] a(int i10, int i11, int i12, String str) {
        try {
            return new a(i10, i11, i12, str).makeHttpRequestWithInterrupted();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
