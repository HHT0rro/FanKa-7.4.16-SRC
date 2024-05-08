package n8;

import android.graphics.Bitmap;
import android.media.Image;
import androidx.annotation.NonNull;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RequiresApi;
import com.google.mlkit.common.MlKitException;
import java.nio.ByteBuffer;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f52167a = new c();

    @RecentlyNonNull
    public static c b() {
        return f52167a;
    }

    @RecentlyNonNull
    public static ByteBuffer c(@RecentlyNonNull ByteBuffer byteBuffer, boolean z10) {
        ByteBuffer allocateDirect;
        int i10;
        byteBuffer.rewind();
        int limit = byteBuffer.limit();
        int i11 = limit / 6;
        if (z10) {
            allocateDirect = ByteBuffer.allocate(limit);
        } else {
            allocateDirect = ByteBuffer.allocateDirect(limit);
        }
        int i12 = 0;
        while (true) {
            i10 = i11 * 4;
            if (i12 >= i10) {
                break;
            }
            allocateDirect.put(i12, byteBuffer.get(i12));
            i12++;
        }
        for (int i13 = 0; i13 < i11 + i11; i13++) {
            allocateDirect.put(i10 + i13, byteBuffer.get(((i13 % 2) * i11) + i10 + (i13 / 2)));
        }
        return allocateDirect;
    }

    @RequiresApi(19)
    public static final ByteBuffer d(Image.Plane[] planeArr, int i10, int i11) {
        int i12 = i10 * i11;
        int i13 = i12 / 4;
        byte[] bArr = new byte[i13 + i13 + i12];
        ByteBuffer buffer = planeArr[1].getBuffer();
        ByteBuffer buffer2 = planeArr[2].getBuffer();
        int position = buffer2.position();
        int limit = buffer.limit();
        buffer2.position(position + 1);
        buffer.limit(limit - 1);
        int i14 = (i12 + i12) / 4;
        boolean z10 = buffer2.remaining() == i14 + (-2) && buffer2.compareTo(buffer) == 0;
        buffer2.position(position);
        buffer.limit(limit);
        if (z10) {
            planeArr[0].getBuffer().get(bArr, 0, i12);
            ByteBuffer buffer3 = planeArr[1].getBuffer();
            planeArr[2].getBuffer().get(bArr, i12, 1);
            buffer3.get(bArr, i12 + 1, i14 - 1);
        } else {
            e(planeArr[0], i10, i11, bArr, 0, 1);
            e(planeArr[1], i10, i11, bArr, i12 + 1, 2);
            e(planeArr[2], i10, i11, bArr, i12, 2);
        }
        return ByteBuffer.wrap(bArr);
    }

    public static final void e(Image.Plane plane, int i10, int i11, byte[] bArr, int i12, int i13) {
        ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        int limit = ((buffer.limit() + plane.getRowStride()) - 1) / plane.getRowStride();
        if (limit == 0) {
            return;
        }
        int i14 = i10 / (i11 / limit);
        int i15 = 0;
        for (int i16 = 0; i16 < limit; i16++) {
            int i17 = i15;
            for (int i18 = 0; i18 < i14; i18++) {
                bArr[i12] = buffer.get(i17);
                i12 += i13;
                i17 += plane.getPixelStride();
            }
            i15 += plane.getRowStride();
        }
    }

    @NonNull
    public ByteBuffer a(@RecentlyNonNull m8.a aVar, boolean z10) throws MlKitException {
        ByteBuffer allocateDirect;
        int d10 = aVar.d();
        if (d10 != -1) {
            if (d10 != 17) {
                if (d10 == 35) {
                    return d((Image.Plane[]) com.google.android.gms.common.internal.h.h(aVar.g()), aVar.i(), aVar.e());
                }
                if (d10 == 842094169) {
                    return c((ByteBuffer) com.google.android.gms.common.internal.h.h(aVar.c()), z10);
                }
                throw new MlKitException("Unsupported image format", 13);
            }
            if (z10) {
                ByteBuffer byteBuffer = (ByteBuffer) com.google.android.gms.common.internal.h.h(aVar.c());
                if (byteBuffer.hasArray()) {
                    return byteBuffer;
                }
                byteBuffer.rewind();
                byte[] bArr = new byte[byteBuffer.limit()];
                byteBuffer.get(bArr);
                return ByteBuffer.wrap(bArr);
            }
            return (ByteBuffer) com.google.android.gms.common.internal.h.h(aVar.c());
        }
        Bitmap bitmap = (Bitmap) com.google.android.gms.common.internal.h.h(aVar.b());
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i10 = width * height;
        int[] iArr = new int[i10];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int ceil = (int) Math.ceil(height / 2.0d);
        int ceil2 = ((ceil + ceil) * ((int) Math.ceil(width / 2.0d))) + i10;
        if (z10) {
            allocateDirect = ByteBuffer.allocate(ceil2);
        } else {
            allocateDirect = ByteBuffer.allocateDirect(ceil2);
        }
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < height; i13++) {
            int i14 = 0;
            while (i14 < width) {
                int i15 = iArr[i11];
                int i16 = (i15 >> 16) & 255;
                int i17 = (i15 >> 8) & 255;
                int i18 = i15 & 255;
                int i19 = (((((i16 * (-38)) - (i17 * 74)) + (i18 * 112)) + 128) >> 8) + 128;
                int i20 = (((((i16 * 112) - (i17 * 94)) - (i18 * 18)) + 128) >> 8) + 128;
                int i21 = i12 + 1;
                allocateDirect.put(i12, (byte) Math.min(255, (((((i16 * 66) + (i17 * 129)) + (i18 * 25)) + 128) >> 8) + 16));
                if (i13 % 2 == 0 && i11 % 2 == 0) {
                    int i22 = i10 + 1;
                    allocateDirect.put(i10, (byte) Math.min(255, i20));
                    i10 = i22 + 1;
                    allocateDirect.put(i22, (byte) Math.min(255, i19));
                }
                i11++;
                i14++;
                i12 = i21;
            }
        }
        return allocateDirect;
    }
}
