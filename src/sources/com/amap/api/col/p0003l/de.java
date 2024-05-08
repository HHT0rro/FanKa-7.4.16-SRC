package com.amap.api.col.p0003l;

import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;

/* compiled from: BaseTileProvider.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class de implements TileProvider {

    /* renamed from: c, reason: collision with root package name */
    private MapConfig f5329c;

    /* renamed from: a, reason: collision with root package name */
    private final int f5327a = 256;

    /* renamed from: b, reason: collision with root package name */
    private final int f5328b = 256;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f5330d = false;

    /* compiled from: BaseTileProvider.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a extends df {

        /* renamed from: a, reason: collision with root package name */
        public Random f5331a = new Random();

        /* renamed from: c, reason: collision with root package name */
        private int f5333c;

        /* renamed from: d, reason: collision with root package name */
        private int f5334d;

        /* renamed from: e, reason: collision with root package name */
        private int f5335e;

        /* renamed from: f, reason: collision with root package name */
        private String f5336f;

        /* renamed from: g, reason: collision with root package name */
        private String f5337g;

        public a(int i10, int i11, int i12, String str) {
            this.f5337g = "";
            this.f5333c = i10;
            this.f5334d = i11;
            this.f5335e = i12;
            this.f5336f = str;
            this.f5337g = c();
        }

        private String c() {
            if (!dq.a(this.f5333c, this.f5334d, this.f5335e) && this.f5335e >= 6) {
                if (MapsInitializer.isLoadWorldGridMap()) {
                    return "http://restsdk.amap.com/v4/gridmap?";
                }
                return null;
            }
            return String.format(Locale.US, "http://wprd0%d.is.autonavi.com/appmaptile?", Integer.valueOf((this.f5331a.nextInt(100000) % 4) + 1));
        }

        @Override // com.amap.api.col.p0003l.id
        public final String getURL() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=");
            stringBuffer.append(fj.f(ab.f4885a));
            stringBuffer.append("&channel=amapapi");
            if (!dq.a(this.f5333c, this.f5334d, this.f5335e) && this.f5335e >= 6) {
                if (MapsInitializer.isLoadWorldGridMap()) {
                    stringBuffer.append("&x=");
                    stringBuffer.append(this.f5333c);
                    stringBuffer.append("&y=");
                    stringBuffer.append(this.f5334d);
                    stringBuffer.append("&z=");
                    stringBuffer.append(this.f5335e);
                    stringBuffer.append("&ds=0");
                    stringBuffer.append("&dpitype=webrd");
                    stringBuffer.append("&lang=");
                    stringBuffer.append(this.f5336f);
                    stringBuffer.append("&scale=2");
                }
            } else {
                stringBuffer.append("&z=");
                stringBuffer.append(this.f5335e);
                stringBuffer.append("&x=");
                stringBuffer.append(this.f5333c);
                stringBuffer.append("&y=");
                stringBuffer.append(this.f5334d);
                stringBuffer.append("&lang=en&size=1&scale=1&style=7");
            }
            return this.f5337g + appendTsScode(stringBuffer.toString());
        }
    }

    public de(MapConfig mapConfig) {
        this.f5329c = mapConfig;
    }

    private byte[] a(int i10, int i11, int i12, String str) throws IOException {
        try {
            return new a(i10, i11, i12, str).makeHttpRequestWithInterrupted();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final Tile getTile(int i10, int i11, int i12) {
        try {
            if (!this.f5330d) {
                if (this.f5329c.getMapLanguage().equals("zh_cn")) {
                    if (!MapsInitializer.isLoadWorldGridMap()) {
                        return TileProvider.NO_TILE;
                    }
                    if (i12 < 6 || dq.a(i10, i11, i12)) {
                        return TileProvider.NO_TILE;
                    }
                } else if (!MapsInitializer.isLoadWorldGridMap() && i12 >= 6 && !dq.a(i10, i11, i12)) {
                    return TileProvider.NO_TILE;
                }
            }
            MapConfig mapConfig = this.f5329c;
            byte[] a10 = a(i10, i11, i12, mapConfig != null ? mapConfig.getMapLanguage() : "zh_cn");
            if (a10 == null) {
                return TileProvider.NO_TILE;
            }
            return Tile.obtain(this.f5327a, this.f5328b, a10);
        } catch (IOException unused) {
            return TileProvider.NO_TILE;
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileHeight() {
        return this.f5328b;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileWidth() {
        return this.f5327a;
    }
}
