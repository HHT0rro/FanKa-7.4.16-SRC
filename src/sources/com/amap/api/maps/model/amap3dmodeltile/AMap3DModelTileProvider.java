package com.amap.api.maps.model.amap3dmodeltile;

import com.amap.api.col.p0003l.ab;
import com.amap.api.col.p0003l.df;
import com.amap.api.col.p0003l.fj;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;
import com.huawei.appgallery.agd.common.constant.SymbolValues;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AMap3DModelTileProvider implements TileProvider {
    private static final String DEFAULT_URL = "https://lbs-3dtiles-service.amap.com/basemap/tiles/staging?compose=building@1669011850923&compose=tree@1668678765481&z=%d&x=%d&y=%d";
    private int tileSize = 256;
    private String url;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class AMap3DModelRequest extends df {
        private String baseQueryStr;
        private String baseUrl;

        public AMap3DModelRequest(String str) {
            this.baseUrl = "";
            this.baseQueryStr = "";
            this.isPostFlag = false;
            if (!str.contains(SymbolValues.QUESTION_EN_SYMBOL)) {
                this.baseUrl = str + SymbolValues.QUESTION_EN_SYMBOL;
                return;
            }
            String[] split = str.split("\\?");
            if (split.length > 1) {
                this.baseUrl = split[0] + SymbolValues.QUESTION_EN_SYMBOL;
                this.baseQueryStr = split[1];
            }
        }

        @Override // com.amap.api.col.p0003l.id
        public String getURL() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.baseQueryStr);
            stringBuffer.append("&key=");
            stringBuffer.append(fj.f(ab.f4885a));
            return this.baseUrl + appendTsScode(stringBuffer.toString());
        }
    }

    private byte[] a(int i10, int i11, int i12) {
        try {
            return new AMap3DModelRequest(b(i10, i11, i12)).makeHttpRequestWithInterrupted();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private String b(int i10, int i11, int i12) {
        String str = this.url;
        if (str == null) {
            str = DEFAULT_URL;
        }
        return String.format(str, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
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

    public final void setUrl(String str) {
        this.url = str;
    }
}
