package com.android.internal.location.altitude;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import com.android.internal.location.altitude.nano.MapParamsProto;
import com.android.internal.location.altitude.nano.S2TileProto;
import com.android.internal.util.Preconditions;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class GeoidHeightMap {
    private static final Object sLock = new Object();
    private static MapParamsProto sParams;
    private final LruCache<Long, S2TileProto> mCacheTiles = new LruCache<>(4);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface TileFunction {
        S2TileProto getTile(long j10);
    }

    public static MapParamsProto getParams(Context context) throws IOException {
        MapParamsProto mapParamsProto;
        synchronized (sLock) {
            if (sParams == null) {
                InputStream is = context.getApplicationContext().getAssets().open("geoid_height_map/map-params.pb");
                try {
                    sParams = MapParamsProto.parseFrom(is.readAllBytes());
                    if (is != null) {
                        is.close();
                    }
                } finally {
                }
            }
            mapParamsProto = sParams;
        }
        return mapParamsProto;
    }

    public static MapParamsProto getParams() {
        MapParamsProto mapParamsProto;
        synchronized (sLock) {
            mapParamsProto = sParams;
        }
        return mapParamsProto;
    }

    private static long getCacheKey(MapParamsProto params, long s2CellId) {
        return S2CellIdUtils.getParent(s2CellId, params.cacheTileS2Level);
    }

    private static String getDiskToken(MapParamsProto params, long s2CellId) {
        return S2CellIdUtils.getToken(S2CellIdUtils.getParent(s2CellId, params.diskTileS2Level));
    }

    private static boolean getUnitIntervalValues(MapParamsProto params, TileFunction tileFunction, long[] s2CellIds, double[] values) {
        int len = s2CellIds.length;
        S2TileProto[] tiles = new S2TileProto[len];
        for (int i10 = 0; i10 < len; i10++) {
            if (s2CellIds[i10] != 0) {
                long cacheKey = getCacheKey(params, s2CellIds[i10]);
                tiles[i10] = tileFunction.getTile(cacheKey);
            }
            values[i10] = Double.NaN;
        }
        for (int i11 = 0; i11 < len; i11++) {
            if (tiles[i11] != null && Double.isNaN(values[i11])) {
                mergeByteBufferValues(params, s2CellIds, tiles, i11, values);
                mergeByteJpegValues(params, s2CellIds, tiles, i11, values);
                mergeBytePngValues(params, s2CellIds, tiles, i11, values);
            }
        }
        boolean allFound = true;
        for (int i12 = 0; i12 < len; i12++) {
            if (s2CellIds[i12] != 0) {
                if (Double.isNaN(values[i12])) {
                    allFound = false;
                } else {
                    values[i12] = (((int) values[i12]) & 255) / 255.0d;
                }
            }
        }
        return allFound;
    }

    private static void mergeByteBufferValues(MapParamsProto params, long[] s2CellIds, S2TileProto[] tiles, int tileIndex, double[] values) {
        byte[] bytes = tiles[tileIndex].byteBuffer;
        if (bytes == null || bytes.length == 0) {
            return;
        }
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes).asReadOnlyBuffer();
        int tileS2Level = params.mapS2Level - (Integer.numberOfTrailingZeros(byteBuffer.limit()) / 2);
        int numBitsLeftOfTile = (tileS2Level * 2) + 3;
        for (int i10 = tileIndex; i10 < tiles.length; i10++) {
            if (tiles[i10] == tiles[tileIndex]) {
                long maskedS2CellId = s2CellIds[i10] & ((-1) >>> numBitsLeftOfTile);
                int numBitsRightOfMap = ((30 - params.mapS2Level) * 2) + 1;
                int bufferIndex = (int) (maskedS2CellId >>> numBitsRightOfMap);
                values[i10] = Double.isNaN(values[i10]) ? ShadowDrawableWrapper.COS_45 : values[i10];
                values[i10] = values[i10] + (byteBuffer.get(bufferIndex) & 255);
            }
        }
    }

    private static void mergeByteJpegValues(MapParamsProto params, long[] s2CellIds, S2TileProto[] tiles, int tileIndex, double[] values) {
        mergeByteImageValues(params, tiles[tileIndex].byteJpeg, s2CellIds, tiles, tileIndex, values);
    }

    private static void mergeBytePngValues(MapParamsProto params, long[] s2CellIds, S2TileProto[] tiles, int tileIndex, double[] values) {
        mergeByteImageValues(params, tiles[tileIndex].bytePng, s2CellIds, tiles, tileIndex, values);
    }

    private static void mergeByteImageValues(MapParamsProto params, byte[] bytes, long[] s2CellIds, S2TileProto[] tiles, int tileIndex, double[] values) {
        Bitmap bitmap;
        if (bytes == null || bytes.length == 0 || (bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length)) == null) {
            return;
        }
        for (int i10 = tileIndex; i10 < tiles.length; i10++) {
            if (s2CellIds[i10] != 0 && tiles[i10] == tiles[tileIndex]) {
                values[i10] = Double.isNaN(values[i10]) ? ShadowDrawableWrapper.COS_45 : values[i10];
                values[i10] = values[i10] + (bitmap.getPixel(getIndexX(params, s2CellIds[i10], bitmap.getWidth()), getIndexY(params, s2CellIds[i10], bitmap.getHeight())) & 255);
            }
        }
    }

    private static int getIndexX(MapParamsProto params, long s2CellId, int width) {
        return getIndexXOrY(params, S2CellIdUtils.getI(s2CellId), width);
    }

    private static int getIndexY(MapParamsProto params, long s2CellId, int height) {
        return getIndexXOrY(params, S2CellIdUtils.getJ(s2CellId), height);
    }

    private static int getIndexXOrY(MapParamsProto params, int iOrJ, int widthOrHeight) {
        return (iOrJ >> (30 - params.mapS2Level)) % widthOrHeight;
    }

    private static void validate(MapParamsProto params, long[] s2CellIds) {
        Preconditions.checkArgument(s2CellIds.length == 4);
        int length = s2CellIds.length;
        for (int i10 = 0; i10 < length; i10++) {
            long s2CellId = s2CellIds[i10];
            Preconditions.checkArgument(s2CellId == 0 || S2CellIdUtils.getLevel(s2CellId) == params.mapS2Level);
        }
    }

    public double[] readGeoidHeights(MapParamsProto params, Context context, long[] s2CellIds) throws IOException {
        validate(params, s2CellIds);
        double[] heightsMeters = new double[s2CellIds.length];
        LruCache<Long, S2TileProto> lruCache = this.mCacheTiles;
        Objects.requireNonNull(lruCache);
        if (getGeoidHeights(params, new GeoidHeightMap$$ExternalSyntheticLambda0(lruCache), s2CellIds, heightsMeters)) {
            return heightsMeters;
        }
        TileFunction loadedTiles = loadFromCacheAndDisk(params, context, s2CellIds);
        if (getGeoidHeights(params, loadedTiles, s2CellIds, heightsMeters)) {
            return heightsMeters;
        }
        throw new IOException("Unable to calculate geoid heights from raw assets.");
    }

    public double[] readGeoidHeights(MapParamsProto params, long[] s2CellIds) {
        validate(params, s2CellIds);
        double[] heightsMeters = new double[s2CellIds.length];
        LruCache<Long, S2TileProto> lruCache = this.mCacheTiles;
        Objects.requireNonNull(lruCache);
        if (getGeoidHeights(params, new GeoidHeightMap$$ExternalSyntheticLambda0(lruCache), s2CellIds, heightsMeters)) {
            return heightsMeters;
        }
        return null;
    }

    private boolean getGeoidHeights(MapParamsProto params, TileFunction tileFunction, long[] s2CellIds, double[] heightsMeters) {
        boolean allFound = getUnitIntervalValues(params, tileFunction, s2CellIds, heightsMeters);
        for (int i10 = 0; i10 < heightsMeters.length; i10++) {
            heightsMeters[i10] = heightsMeters[i10] * params.modelAMeters;
            heightsMeters[i10] = heightsMeters[i10] + params.modelBMeters;
        }
        return allFound;
    }

    private TileFunction loadFromCacheAndDisk(MapParamsProto params, Context context, long[] s2CellIds) throws IOException {
        int i10;
        int len = s2CellIds.length;
        final long[] cacheKeys = new long[len];
        for (int i11 = 0; i11 < len; i11++) {
            if (s2CellIds[i11] != 0) {
                cacheKeys[i11] = getCacheKey(params, s2CellIds[i11]);
            }
        }
        final S2TileProto[] loadedTiles = new S2TileProto[len];
        String[] diskTokens = new String[len];
        for (int i12 = 0; i12 < len; i12++) {
            if (s2CellIds[i12] != 0 && diskTokens[i12] == null) {
                loadedTiles[i12] = this.mCacheTiles.get(Long.valueOf(cacheKeys[i12]));
                diskTokens[i12] = getDiskToken(params, cacheKeys[i12]);
                for (int j10 = i12 + 1; j10 < len; j10++) {
                    if (cacheKeys[j10] == cacheKeys[i12]) {
                        loadedTiles[j10] = loadedTiles[i12];
                        diskTokens[j10] = diskTokens[i12];
                    }
                }
            }
        }
        int i13 = 0;
        while (i13 < len) {
            if (s2CellIds[i13] == 0) {
                i10 = i13;
            } else if (loadedTiles[i13] != null) {
                i10 = i13;
            } else {
                InputStream is = context.getApplicationContext().getAssets().open("geoid_height_map/tile-" + diskTokens[i13] + ".pb");
                try {
                    S2TileProto tile = S2TileProto.parseFrom(is.readAllBytes());
                    if (is != null) {
                        is.close();
                    }
                    i10 = i13;
                    mergeFromDiskTile(params, tile, cacheKeys, diskTokens, i13, loadedTiles);
                } finally {
                }
            }
            i13 = i10 + 1;
        }
        return new TileFunction() { // from class: com.android.internal.location.altitude.GeoidHeightMap$$ExternalSyntheticLambda1
            @Override // com.android.internal.location.altitude.GeoidHeightMap.TileFunction
            public final S2TileProto getTile(long j11) {
                return GeoidHeightMap.lambda$loadFromCacheAndDisk$0(cacheKeys, loadedTiles, j11);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ S2TileProto lambda$loadFromCacheAndDisk$0(long[] cacheKeys, S2TileProto[] loadedTiles, long cacheKey) {
        for (int i10 = 0; i10 < cacheKeys.length; i10++) {
            if (cacheKeys[i10] == cacheKey) {
                return loadedTiles[i10];
            }
        }
        return null;
    }

    private void mergeFromDiskTile(MapParamsProto params, final S2TileProto diskTile, long[] cacheKeys, String[] diskTokens, int diskTokenIndex, S2TileProto[] loadedTiles) throws IOException {
        int len = cacheKeys.length;
        int numMapCellsPerCacheTile = 1 << ((params.mapS2Level - params.cacheTileS2Level) * 2);
        long[] s2CellIds = new long[numMapCellsPerCacheTile];
        double[] values = new double[numMapCellsPerCacheTile];
        TileFunction diskTileFunction = new TileFunction() { // from class: com.android.internal.location.altitude.GeoidHeightMap$$ExternalSyntheticLambda2
            @Override // com.android.internal.location.altitude.GeoidHeightMap.TileFunction
            public final S2TileProto getTile(long j10) {
                return GeoidHeightMap.lambda$mergeFromDiskTile$1(S2TileProto.this, j10);
            }
        };
        for (int i10 = diskTokenIndex; i10 < len; i10++) {
            if (Objects.equals(diskTokens[i10], diskTokens[diskTokenIndex]) && loadedTiles[i10] == null) {
                long s2CellId = S2CellIdUtils.getTraversalStart(cacheKeys[i10], params.mapS2Level);
                for (int j10 = 0; j10 < numMapCellsPerCacheTile; j10++) {
                    s2CellIds[j10] = s2CellId;
                    s2CellId = S2CellIdUtils.getTraversalNext(s2CellId);
                }
                if (!getUnitIntervalValues(params, diskTileFunction, s2CellIds, values)) {
                    throw new IOException("Corrupted disk tile of disk token: " + diskTokens[i10]);
                }
                loadedTiles[i10] = new S2TileProto();
                loadedTiles[i10].byteBuffer = new byte[numMapCellsPerCacheTile];
                for (int j11 = 0; j11 < numMapCellsPerCacheTile; j11++) {
                    loadedTiles[i10].byteBuffer[j11] = (byte) Math.round(values[j11] * 255.0d);
                }
                for (int j12 = i10 + 1; j12 < len; j12++) {
                    if (cacheKeys[j12] == cacheKeys[i10]) {
                        loadedTiles[j12] = loadedTiles[i10];
                    }
                }
                this.mCacheTiles.put(Long.valueOf(cacheKeys[i10]), loadedTiles[i10]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ S2TileProto lambda$mergeFromDiskTile$1(S2TileProto diskTile, long cacheKey) {
        return diskTile;
    }
}
