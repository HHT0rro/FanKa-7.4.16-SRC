package com.alimm.tanx.ui.image.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import com.alimm.tanx.ui.image.glide.Glide;
import com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder;
import com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader;
import com.alimm.tanx.ui.image.glide.gifdecoder.GifHeaderParser;
import com.alimm.tanx.ui.image.glide.load.ResourceDecoder;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.load.resource.UnitTransformation;
import com.alimm.tanx.ui.image.glide.util.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GifResourceDecoder implements ResourceDecoder<InputStream, GifDrawable> {
    public static final String TAG = "GifResourceDecoder";
    public final BitmapPool bitmapPool;
    public final Context context;
    public final GifDecoderPool decoderPool;
    public final GifHeaderParserPool parserPool;
    public final GifBitmapProvider provider;
    public static final GifHeaderParserPool PARSER_POOL = new GifHeaderParserPool();
    public static final GifDecoderPool DECODER_POOL = new GifDecoderPool();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class GifDecoderPool {
        public final Queue<GifDecoder> pool = Util.createQueue(0);

        public synchronized GifDecoder obtain(GifDecoder.BitmapProvider bitmapProvider) {
            GifDecoder poll;
            poll = this.pool.poll();
            if (poll == null) {
                poll = new GifDecoder(bitmapProvider);
            }
            return poll;
        }

        public synchronized void release(GifDecoder gifDecoder) {
            gifDecoder.clear();
            this.pool.offer(gifDecoder);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class GifHeaderParserPool {
        public final Queue<GifHeaderParser> pool = Util.createQueue(0);

        public synchronized GifHeaderParser obtain(byte[] bArr) {
            GifHeaderParser poll;
            poll = this.pool.poll();
            if (poll == null) {
                poll = new GifHeaderParser();
            }
            return poll.setData(bArr);
        }

        public synchronized void release(GifHeaderParser gifHeaderParser) {
            gifHeaderParser.clear();
            this.pool.offer(gifHeaderParser);
        }
    }

    public GifResourceDecoder(Context context) {
        this(context, Glide.get(context).getBitmapPool());
    }

    private Bitmap decodeFirstFrame(GifDecoder gifDecoder, GifHeader gifHeader, byte[] bArr) {
        gifDecoder.setData(gifHeader, bArr);
        gifDecoder.advance();
        return gifDecoder.getNextFrame();
    }

    public static byte[] inputStreamToBytes(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.flush();
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public String getId() {
        return "";
    }

    public GifResourceDecoder(Context context, BitmapPool bitmapPool) {
        this(context, bitmapPool, PARSER_POOL, DECODER_POOL);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public GifDrawableResource decode(InputStream inputStream, int i10, int i11) {
        byte[] inputStreamToBytes = inputStreamToBytes(inputStream);
        GifHeaderParser obtain = this.parserPool.obtain(inputStreamToBytes);
        GifDecoder obtain2 = this.decoderPool.obtain(this.provider);
        try {
            return decode(inputStreamToBytes, i10, i11, obtain, obtain2);
        } finally {
            this.parserPool.release(obtain);
            this.decoderPool.release(obtain2);
        }
    }

    public GifResourceDecoder(Context context, BitmapPool bitmapPool, GifHeaderParserPool gifHeaderParserPool, GifDecoderPool gifDecoderPool) {
        this.context = context.getApplicationContext();
        this.bitmapPool = bitmapPool;
        this.decoderPool = gifDecoderPool;
        this.provider = new GifBitmapProvider(bitmapPool);
        this.parserPool = gifHeaderParserPool;
    }

    private GifDrawableResource decode(byte[] bArr, int i10, int i11, GifHeaderParser gifHeaderParser, GifDecoder gifDecoder) {
        GifHeader parseHeader = gifHeaderParser.parseHeader();
        if (parseHeader.getNumFrames() <= 0 || parseHeader.getStatus() != 0) {
            return null;
        }
        gifDecoder.setData(parseHeader, bArr);
        gifDecoder.advance();
        Bitmap nextFrame = gifDecoder.getNextFrame();
        if (nextFrame == null) {
            return null;
        }
        return new GifDrawableResource(new GifDrawable(this.context, this.provider, this.bitmapPool, UnitTransformation.get(), i10, i11, parseHeader, bArr, nextFrame));
    }
}
