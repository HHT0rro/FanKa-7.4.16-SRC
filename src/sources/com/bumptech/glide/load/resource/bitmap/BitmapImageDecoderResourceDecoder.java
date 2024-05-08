package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.resource.ImageDecoderResourceDecoder;
import java.io.IOException;
import sun.util.locale.LanguageTag;

@RequiresApi(api = 28)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class BitmapImageDecoderResourceDecoder extends ImageDecoderResourceDecoder<Bitmap> {
    private static final String TAG = "BitmapImageDecoder";
    private final BitmapPool bitmapPool = new BitmapPoolAdapter();

    @Override // com.bumptech.glide.load.resource.ImageDecoderResourceDecoder
    public Resource<Bitmap> decode(ImageDecoder.Source source, int i10, int i11, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException {
        Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, onHeaderDecodedListener);
        if (Log.isLoggable(TAG, 2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Decoded [");
            sb2.append(decodeBitmap.getWidth());
            sb2.append(LanguageTag.PRIVATEUSE);
            sb2.append(decodeBitmap.getHeight());
            sb2.append("] for [");
            sb2.append(i10);
            sb2.append(LanguageTag.PRIVATEUSE);
            sb2.append(i11);
            sb2.append("]");
        }
        return new BitmapResource(decodeBitmap, this.bitmapPool);
    }
}
