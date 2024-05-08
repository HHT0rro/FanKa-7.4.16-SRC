package x4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: OpusUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class w {
    public static List<byte[]> a(byte[] bArr) {
        long e2 = e(d(bArr));
        long e10 = e(3840L);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(b(e2));
        arrayList.add(b(e10));
        return arrayList;
    }

    public static byte[] b(long j10) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j10).array();
    }

    public static int c(byte[] bArr) {
        return bArr[9] & 255;
    }

    public static int d(byte[] bArr) {
        return (bArr[10] & 255) | ((bArr[11] & 255) << 8);
    }

    public static long e(long j10) {
        return (j10 * 1000000000) / 48000;
    }
}
