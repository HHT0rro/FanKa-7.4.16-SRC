package com.alimm.tanx.ui.image.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.alimm.tanx.ui.image.glide.load.DecodeFormat;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache;
import com.alimm.tanx.ui.image.glide.load.engine.prefill.PreFillType;
import com.alimm.tanx.ui.image.glide.util.Util;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class BitmapPreFiller {
    public final BitmapPool bitmapPool;
    public BitmapPreFillRunner current;
    public final DecodeFormat defaultFormat;
    public final Handler handler = new Handler(Looper.getMainLooper());
    public final MemoryCache memoryCache;

    public BitmapPreFiller(MemoryCache memoryCache, BitmapPool bitmapPool, DecodeFormat decodeFormat) {
        this.memoryCache = memoryCache;
        this.bitmapPool = bitmapPool;
        this.defaultFormat = decodeFormat;
    }

    public static int getSizeInBytes(PreFillType preFillType) {
        return Util.getBitmapByteSize(preFillType.getWidth(), preFillType.getHeight(), preFillType.getConfig());
    }

    public PreFillQueue generateAllocationOrder(PreFillType[] preFillTypeArr) {
        int maxSize = this.bitmapPool.getMaxSize() + (this.memoryCache.getMaxSize() - this.memoryCache.getCurrentSize());
        int i10 = 0;
        for (PreFillType preFillType : preFillTypeArr) {
            i10 += preFillType.getWeight();
        }
        float f10 = maxSize / i10;
        HashMap hashMap = new HashMap();
        for (PreFillType preFillType2 : preFillTypeArr) {
            hashMap.put(preFillType2, Integer.valueOf(Math.round(preFillType2.getWeight() * f10) / Util.getBitmapByteSize(preFillType2.getWidth(), preFillType2.getHeight(), preFillType2.getConfig())));
        }
        return new PreFillQueue(hashMap);
    }

    public void preFill(PreFillType.Builder... builderArr) {
        BitmapPreFillRunner bitmapPreFillRunner = this.current;
        if (bitmapPreFillRunner != null) {
            bitmapPreFillRunner.cancel();
        }
        PreFillType[] preFillTypeArr = new PreFillType[builderArr.length];
        for (int i10 = 0; i10 < builderArr.length; i10++) {
            PreFillType.Builder builder = builderArr[i10];
            if (builder.getConfig() == null) {
                DecodeFormat decodeFormat = this.defaultFormat;
                builder.setConfig((decodeFormat == DecodeFormat.ALWAYS_ARGB_8888 || decodeFormat == DecodeFormat.PREFER_ARGB_8888) ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            }
            preFillTypeArr[i10] = builder.build();
        }
        BitmapPreFillRunner bitmapPreFillRunner2 = new BitmapPreFillRunner(this.bitmapPool, this.memoryCache, generateAllocationOrder(preFillTypeArr));
        this.current = bitmapPreFillRunner2;
        this.handler.post(bitmapPreFillRunner2);
    }
}
