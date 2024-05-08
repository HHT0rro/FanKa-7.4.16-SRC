package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.util.Log;
import com.alimm.tanx.ui.image.glide.load.ResourceEncoder;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import com.alimm.tanx.ui.image.glide.util.LogTime;
import com.alimm.tanx.ui.image.glide.util.Util;
import java.io.OutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class BitmapEncoder implements ResourceEncoder<Bitmap> {
    public static final int DEFAULT_COMPRESSION_QUALITY = 90;
    public static final String TAG = "BitmapEncoder";
    public Bitmap.CompressFormat compressFormat;
    public int quality;

    public BitmapEncoder() {
        this(null, 90);
    }

    private Bitmap.CompressFormat getFormat(Bitmap bitmap) {
        Bitmap.CompressFormat compressFormat = this.compressFormat;
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public String getId() {
        return "BitmapEncoder.com.alimm.tanx.ui.image.glide.load.resource.bitmap";
    }

    public BitmapEncoder(Bitmap.CompressFormat compressFormat, int i10) {
        this.compressFormat = compressFormat;
        this.quality = i10;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public boolean encode(Resource<Bitmap> resource, OutputStream outputStream) {
        Bitmap bitmap = resource.get();
        long logTime = LogTime.getLogTime();
        Bitmap.CompressFormat format = getFormat(bitmap);
        bitmap.compress(format, this.quality, outputStream);
        if (!Log.isLoggable(TAG, 2)) {
            return true;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Compressed with type: ");
        sb2.append((Object) format);
        sb2.append(" of size ");
        sb2.append(Util.getBitmapByteSize(bitmap));
        sb2.append(" in ");
        sb2.append(LogTime.getElapsedMillis(logTime));
        return true;
    }
}
