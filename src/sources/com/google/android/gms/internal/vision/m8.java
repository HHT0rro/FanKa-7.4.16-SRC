package com.google.android.gms.internal.vision;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class m8 {
    public static ByteBuffer a(Bitmap bitmap, boolean z10) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i10 = width * height;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(((((width + 1) / 2) * ((height + 1) / 2)) << 1) + i10);
        int i11 = i10;
        for (int i12 = 0; i12 < i10; i12++) {
            int i13 = i12 % width;
            int i14 = i12 / width;
            int pixel = bitmap.getPixel(i13, i14);
            float red = Color.red(pixel);
            float green = Color.green(pixel);
            float blue = Color.blue(pixel);
            allocateDirect.put(i12, (byte) ((0.299f * red) + (0.587f * green) + (0.114f * blue)));
            if (i14 % 2 == 0 && i13 % 2 == 0) {
                int i15 = i11 + 1;
                allocateDirect.put(i11, (byte) (((-0.169f) * red) + ((-0.331f) * green) + (blue * 0.5f) + 128.0f));
                i11 = i15 + 1;
                allocateDirect.put(i15, (byte) ((red * 0.5f) + (green * (-0.419f)) + (blue * (-0.081f)) + 128.0f));
            }
        }
        return allocateDirect;
    }
}
