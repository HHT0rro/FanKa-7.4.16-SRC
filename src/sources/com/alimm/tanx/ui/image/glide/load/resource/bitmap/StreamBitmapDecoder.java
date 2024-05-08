package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.alimm.tanx.ui.image.glide.Glide;
import com.alimm.tanx.ui.image.glide.load.DecodeFormat;
import com.alimm.tanx.ui.image.glide.load.ResourceDecoder;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.InputStream;
import nd.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class StreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {
    public static final String ID = "StreamBitmapDecoder.com.alimm.tanx.ui.image.glide.load.resource.bitmap";
    public BitmapPool bitmapPool;
    public DecodeFormat decodeFormat;
    public final Downsampler downsampler;

    /* renamed from: id, reason: collision with root package name */
    public String f4196id;

    public StreamBitmapDecoder(Context context) {
        this(Glide.get(context).getBitmapPool());
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public String getId() {
        if (this.f4196id == null) {
            StringBuilder a10 = a.a(ID);
            a10.append(this.downsampler.getId());
            a10.append(this.decodeFormat.name());
            this.f4196id = a10.toString();
        }
        return this.f4196id;
    }

    public StreamBitmapDecoder(BitmapPool bitmapPool) {
        this(bitmapPool, DecodeFormat.DEFAULT);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public Resource<Bitmap> decode(InputStream inputStream, int i10, int i11) {
        return BitmapResource.obtain(this.downsampler.decode(inputStream, this.bitmapPool, i10, i11, this.decodeFormat), this.bitmapPool);
    }

    public StreamBitmapDecoder(Context context, DecodeFormat decodeFormat) {
        this(Glide.get(context).getBitmapPool(), decodeFormat);
    }

    public StreamBitmapDecoder(BitmapPool bitmapPool, DecodeFormat decodeFormat) {
        this(Downsampler.AT_LEAST, bitmapPool, decodeFormat);
    }

    public StreamBitmapDecoder(Downsampler downsampler, BitmapPool bitmapPool, DecodeFormat decodeFormat) {
        this.downsampler = downsampler;
        this.bitmapPool = bitmapPool;
        this.decodeFormat = decodeFormat;
    }
}
