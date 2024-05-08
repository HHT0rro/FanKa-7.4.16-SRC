package com.amap.api.maps.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class UrlTileProvider implements TileProvider {
    private final int height;
    private final int width;

    public UrlTileProvider(int i10, int i11) {
        this.width = i10;
        this.height = i11;
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final Tile getTile(int i10, int i11, int i12) {
        URL tileUrl = getTileUrl(i10, i11, i12);
        if (tileUrl == null) {
            return TileProvider.NO_TILE;
        }
        try {
            return Tile.obtain(this.width, this.height, a(tileUrl.openStream()));
        } catch (IOException e2) {
            Tile tile = TileProvider.NO_TILE;
            e2.printStackTrace();
            return tile;
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileHeight() {
        return this.height;
    }

    public abstract URL getTileUrl(int i10, int i11, int i12);

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileWidth() {
        return this.width;
    }

    private static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j10 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j10;
            }
            outputStream.write(bArr, 0, read);
            j10 += read;
        }
    }
}
