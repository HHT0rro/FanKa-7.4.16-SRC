package com.android.internal.location.altitude;

import android.util.LruCache;
import com.android.internal.location.altitude.GeoidHeightMap;
import com.android.internal.location.altitude.nano.S2TileProto;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* compiled from: D8$$SyntheticClass */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final /* synthetic */ class GeoidHeightMap$$ExternalSyntheticLambda0 implements GeoidHeightMap.TileFunction {
    public final /* synthetic */ LruCache f$0;

    @Override // com.android.internal.location.altitude.GeoidHeightMap.TileFunction
    public final S2TileProto getTile(long j10) {
        return (S2TileProto) this.f$0.get(Long.valueOf(j10));
    }
}
