package com.kwad.sdk.core.imageloader.core.decode;

import android.graphics.Bitmap;
import com.kwad.sdk.glide.framesequence.FrameSequence;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DecodedResult {
    public Bitmap mBitmap;
    public FrameSequence mFrameSequence;

    public int getByteSize() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            return bitmap.getRowBytes() * this.mBitmap.getHeight();
        }
        return 0;
    }

    public boolean isDecoded() {
        Bitmap bitmap = this.mBitmap;
        return (bitmap != null && !bitmap.isRecycled()) || (this.mFrameSequence != null);
    }
}
