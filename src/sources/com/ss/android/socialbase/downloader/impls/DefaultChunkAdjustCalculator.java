package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator;
import com.ss.android.socialbase.downloader.network.NetworkQuality;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DefaultChunkAdjustCalculator implements IChunkAdjustCalculator {
    @Override // com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator
    public int calculateChunkCount(int i10, NetworkQuality networkQuality) {
        if (networkQuality.ordinal() <= NetworkQuality.MODERATE.ordinal()) {
            return 1;
        }
        return networkQuality == NetworkQuality.GOOD ? i10 - 1 : i10;
    }
}
