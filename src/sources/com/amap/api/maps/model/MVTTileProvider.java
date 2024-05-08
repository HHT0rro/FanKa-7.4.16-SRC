package com.amap.api.maps.model;

import com.amap.api.col.p0003l.df;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MVTTileProvider implements TileProvider {

    /* renamed from: id, reason: collision with root package name */
    private String f8208id;
    private String key;
    private int tileSize = 256;
    private String url;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class a extends df {

        /* renamed from: a, reason: collision with root package name */
        public String f8209a;

        public a(String str) {
            this.isPostFlag = false;
            this.f8209a = str;
        }

        @Override // com.amap.api.col.p0003l.id
        public final String getURL() {
            return this.f8209a;
        }
    }

    public MVTTileProvider(String str, String str2, String str3) {
        this.url = str;
        this.key = str2;
        this.f8208id = str3;
    }

    private byte[] a(int i10, int i11, int i12) {
        try {
            return new a(a(i10, i11, i12, this.tileSize)).makeHttpRequestWithInterrupted();
        } catch (Exception unused) {
            return null;
        }
    }

    public final String getId() {
        return this.f8208id;
    }

    public final String getKey() {
        return this.key;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final Tile getTile(int i10, int i11, int i12) {
        byte[] a10 = a(i12, i10, i11);
        if (a10 == null) {
            return TileProvider.NO_TILE;
        }
        int i13 = this.tileSize;
        return new Tile(i13, i13, a10, false);
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileHeight() {
        return this.tileSize;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileWidth() {
        return this.tileSize;
    }

    public final String getUrl() {
        return this.url;
    }

    private String a(int i10, int i11, int i12, int i13) {
        return String.format(this.url + "?z=%d&x=%d&y=%d&size=%d&key=" + this.key + "&id=" + this.f8208id, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13));
    }
}
