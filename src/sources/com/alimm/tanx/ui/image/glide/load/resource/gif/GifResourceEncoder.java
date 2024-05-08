package com.alimm.tanx.ui.image.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.util.Log;
import com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder;
import com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader;
import com.alimm.tanx.ui.image.glide.gifdecoder.GifHeaderParser;
import com.alimm.tanx.ui.image.glide.gifencoder.AnimatedGifEncoder;
import com.alimm.tanx.ui.image.glide.load.ResourceEncoder;
import com.alimm.tanx.ui.image.glide.load.Transformation;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.load.resource.UnitTransformation;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapResource;
import com.alimm.tanx.ui.image.glide.util.LogTime;
import java.io.IOException;
import java.io.OutputStream;
import nd.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GifResourceEncoder implements ResourceEncoder<GifDrawable> {
    public static final Factory FACTORY = new Factory();
    public static final String TAG = "GifEncoder";
    public final BitmapPool bitmapPool;
    public final Factory factory;
    public final GifDecoder.BitmapProvider provider;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Factory {
        public GifDecoder buildDecoder(GifDecoder.BitmapProvider bitmapProvider) {
            return new GifDecoder(bitmapProvider);
        }

        public AnimatedGifEncoder buildEncoder() {
            return new AnimatedGifEncoder();
        }

        public Resource<Bitmap> buildFrameResource(Bitmap bitmap, BitmapPool bitmapPool) {
            return new BitmapResource(bitmap, bitmapPool);
        }

        public GifHeaderParser buildParser() {
            return new GifHeaderParser();
        }
    }

    public GifResourceEncoder(BitmapPool bitmapPool) {
        this(bitmapPool, FACTORY);
    }

    private GifDecoder decodeHeaders(byte[] bArr) {
        GifHeaderParser buildParser = this.factory.buildParser();
        buildParser.setData(bArr);
        GifHeader parseHeader = buildParser.parseHeader();
        GifDecoder buildDecoder = this.factory.buildDecoder(this.provider);
        buildDecoder.setData(parseHeader, bArr);
        buildDecoder.advance();
        return buildDecoder;
    }

    private Resource<Bitmap> getTransformedFrame(Bitmap bitmap, Transformation<Bitmap> transformation, GifDrawable gifDrawable) {
        Resource<Bitmap> buildFrameResource = this.factory.buildFrameResource(bitmap, this.bitmapPool);
        Resource<Bitmap> transform = transformation.transform(buildFrameResource, gifDrawable.getIntrinsicWidth(), gifDrawable.getIntrinsicHeight());
        if (!buildFrameResource.equals(transform)) {
            buildFrameResource.recycle();
        }
        return transform;
    }

    private boolean writeDataDirect(byte[] bArr, OutputStream outputStream) {
        try {
            outputStream.write(bArr);
            return true;
        } catch (IOException unused) {
            Log.isLoggable(TAG, 3);
            return false;
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public String getId() {
        return "";
    }

    public GifResourceEncoder(BitmapPool bitmapPool, Factory factory) {
        this.bitmapPool = bitmapPool;
        this.provider = new GifBitmapProvider(bitmapPool);
        this.factory = factory;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public boolean encode(Resource<GifDrawable> resource, OutputStream outputStream) {
        long logTime = LogTime.getLogTime();
        GifDrawable gifDrawable = resource.get();
        Transformation<Bitmap> frameTransformation = gifDrawable.getFrameTransformation();
        if (frameTransformation instanceof UnitTransformation) {
            return writeDataDirect(gifDrawable.getData(), outputStream);
        }
        GifDecoder decodeHeaders = decodeHeaders(gifDrawable.getData());
        AnimatedGifEncoder buildEncoder = this.factory.buildEncoder();
        if (!buildEncoder.start(outputStream)) {
            return false;
        }
        for (int i10 = 0; i10 < decodeHeaders.getFrameCount(); i10++) {
            Resource<Bitmap> transformedFrame = getTransformedFrame(decodeHeaders.getNextFrame(), frameTransformation, gifDrawable);
            try {
                if (!buildEncoder.addFrame(transformedFrame.get())) {
                    return false;
                }
                buildEncoder.setDelay(decodeHeaders.getDelay(decodeHeaders.getCurrentFrameIndex()));
                decodeHeaders.advance();
                transformedFrame.recycle();
            } finally {
                transformedFrame.recycle();
            }
        }
        boolean finish = buildEncoder.finish();
        if (Log.isLoggable(TAG, 2)) {
            StringBuilder a10 = a.a("Encoded gif with ");
            a10.append(decodeHeaders.getFrameCount());
            a10.append(" frames and ");
            a10.append(gifDrawable.getData().length);
            a10.append(" bytes in ");
            a10.append(LogTime.getElapsedMillis(logTime));
            a10.append(" ms");
        }
        return finish;
    }
}
