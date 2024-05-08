package com.alimm.tanx.ui.image.glide.load.resource.gifbitmap;

import android.graphics.Bitmap;
import com.alimm.tanx.ui.image.glide.load.ResourceDecoder;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapResource;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable;
import com.alimm.tanx.ui.image.glide.util.ByteArrayPool;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GifBitmapWrapperResourceDecoder implements ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> {
    public static final ImageTypeParser DEFAULT_PARSER = new ImageTypeParser();
    public static final BufferedStreamFactory DEFAULT_STREAM_FACTORY = new BufferedStreamFactory();
    public static final int MARK_LIMIT_BYTES = 2048;
    public final ResourceDecoder<ImageVideoWrapper, Bitmap> bitmapDecoder;
    public final BitmapPool bitmapPool;
    public final ResourceDecoder<InputStream, GifDrawable> gifDecoder;

    /* renamed from: id, reason: collision with root package name */
    public String f4197id;
    public final ImageTypeParser parser;
    public final BufferedStreamFactory streamFactory;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class BufferedStreamFactory {
        public InputStream build(InputStream inputStream, byte[] bArr) {
            return new RecyclableBufferedInputStream(inputStream, bArr);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class ImageTypeParser {
        public ImageHeaderParser.ImageType parse(InputStream inputStream) throws IOException {
            return new ImageHeaderParser(inputStream).getType();
        }
    }

    public GifBitmapWrapperResourceDecoder(ResourceDecoder<ImageVideoWrapper, Bitmap> resourceDecoder, ResourceDecoder<InputStream, GifDrawable> resourceDecoder2, BitmapPool bitmapPool) {
        this(resourceDecoder, resourceDecoder2, bitmapPool, DEFAULT_PARSER, DEFAULT_STREAM_FACTORY);
    }

    private GifBitmapWrapper decodeBitmapWrapper(ImageVideoWrapper imageVideoWrapper, int i10, int i11) throws IOException {
        Resource<Bitmap> decode = this.bitmapDecoder.decode(imageVideoWrapper, i10, i11);
        if (decode != null) {
            return new GifBitmapWrapper(decode, null);
        }
        return null;
    }

    private GifBitmapWrapper decodeGifWrapper(InputStream inputStream, int i10, int i11) throws IOException {
        GifBitmapWrapper gifBitmapWrapper;
        Resource<GifDrawable> decode = this.gifDecoder.decode(inputStream, i10, i11);
        if (decode == null) {
            return null;
        }
        GifDrawable gifDrawable = decode.get();
        if (gifDrawable.getFrameCount() > 1) {
            gifBitmapWrapper = new GifBitmapWrapper(null, decode);
        } else {
            gifBitmapWrapper = new GifBitmapWrapper(new BitmapResource(gifDrawable.getFirstFrame(), this.bitmapPool), null);
        }
        return gifBitmapWrapper;
    }

    private GifBitmapWrapper decodeStream(ImageVideoWrapper imageVideoWrapper, int i10, int i11, byte[] bArr) throws IOException {
        InputStream build = this.streamFactory.build(imageVideoWrapper.getStream(), bArr);
        build.mark(2048);
        ImageHeaderParser.ImageType parse = this.parser.parse(build);
        build.reset();
        GifBitmapWrapper decodeGifWrapper = parse == ImageHeaderParser.ImageType.GIF ? decodeGifWrapper(build, i10, i11) : null;
        return decodeGifWrapper == null ? decodeBitmapWrapper(new ImageVideoWrapper(build, imageVideoWrapper.getFileDescriptor()), i10, i11) : decodeGifWrapper;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public String getId() {
        if (this.f4197id == null) {
            this.f4197id = this.gifDecoder.getId() + this.bitmapDecoder.getId();
        }
        return this.f4197id;
    }

    public GifBitmapWrapperResourceDecoder(ResourceDecoder<ImageVideoWrapper, Bitmap> resourceDecoder, ResourceDecoder<InputStream, GifDrawable> resourceDecoder2, BitmapPool bitmapPool, ImageTypeParser imageTypeParser, BufferedStreamFactory bufferedStreamFactory) {
        this.bitmapDecoder = resourceDecoder;
        this.gifDecoder = resourceDecoder2;
        this.bitmapPool = bitmapPool;
        this.parser = imageTypeParser;
        this.streamFactory = bufferedStreamFactory;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public Resource<GifBitmapWrapper> decode(ImageVideoWrapper imageVideoWrapper, int i10, int i11) throws IOException {
        ByteArrayPool byteArrayPool = ByteArrayPool.get();
        byte[] bytes = byteArrayPool.getBytes();
        try {
            GifBitmapWrapper decode = decode(imageVideoWrapper, i10, i11, bytes);
            if (decode != null) {
                return new GifBitmapWrapperResource(decode);
            }
            return null;
        } finally {
            byteArrayPool.releaseBytes(bytes);
        }
    }

    private GifBitmapWrapper decode(ImageVideoWrapper imageVideoWrapper, int i10, int i11, byte[] bArr) throws IOException {
        if (imageVideoWrapper.getStream() != null) {
            return decodeStream(imageVideoWrapper, i10, i11, bArr);
        }
        return decodeBitmapWrapper(imageVideoWrapper, i10, i11);
    }
}
