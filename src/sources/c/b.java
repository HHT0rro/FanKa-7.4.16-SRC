package c;

import ar.com.hjg.pngj.PngjException;
import ar.com.hjg.pngj.chunks.PngBadCharsetException;
import ar.com.hjg.pngj.chunks.PngChunk;
import ar.com.hjg.pngj.o;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/* compiled from: ChunkHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f1487a = h("IHDR");

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f1488b = h("PLTE");

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f1489c = h("IDAT");

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f1490d = h("IEND");

    /* renamed from: e, reason: collision with root package name */
    public static byte[] f1491e = new byte[4096];

    public static byte[] a(byte[] bArr, int i10, int i11, boolean z10) {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i10, i11);
            if (!z10) {
                byteArrayInputStream = new InflaterInputStream(byteArrayInputStream);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStream deflaterOutputStream = z10 ? new DeflaterOutputStream(byteArrayOutputStream) : byteArrayOutputStream;
            g(byteArrayInputStream, deflaterOutputStream);
            byteArrayInputStream.close();
            deflaterOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            throw new PngjException(e2);
        }
    }

    public static List<PngChunk> b(List<PngChunk> list, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (PngChunk pngChunk : list) {
            if (cVar.a(pngChunk)) {
                arrayList.add(pngChunk);
            }
        }
        return arrayList;
    }

    public static boolean c(String str) {
        return Character.isUpperCase(str.charAt(0));
    }

    public static boolean d(String str) {
        return Character.isUpperCase(str.charAt(1));
    }

    public static boolean e(String str) {
        return !Character.isUpperCase(str.charAt(3));
    }

    public static int f(byte[] bArr) {
        for (int i10 = 0; i10 < bArr.length; i10++) {
            if (bArr[i10] == 0) {
                return i10;
            }
        }
        return -1;
    }

    public static void g(InputStream inputStream, OutputStream outputStream) throws IOException {
        synchronized (f1491e) {
            while (true) {
                int read = inputStream.read(f1491e);
                if (read > 0) {
                    outputStream.write(f1491e, 0, read);
                }
            }
        }
    }

    public static byte[] h(String str) {
        try {
            return str.getBytes(o.f1197b);
        } catch (UnsupportedEncodingException e2) {
            throw new PngBadCharsetException(e2);
        }
    }

    public static String i(byte[] bArr) {
        try {
            return new String(bArr, o.f1197b);
        } catch (UnsupportedEncodingException e2) {
            throw new PngBadCharsetException(e2);
        }
    }

    public static String j(byte[] bArr, int i10, int i11) {
        try {
            return new String(bArr, i10, i11, o.f1197b);
        } catch (UnsupportedEncodingException e2) {
            throw new PngBadCharsetException(e2);
        }
    }

    public static String k(byte[] bArr) {
        try {
            return new String(bArr, o.f1199d);
        } catch (UnsupportedEncodingException e2) {
            throw new PngBadCharsetException(e2);
        }
    }

    public static String l(byte[] bArr, int i10, int i11) {
        try {
            return new String(bArr, i10, i11, o.f1199d);
        } catch (UnsupportedEncodingException e2) {
            throw new PngBadCharsetException(e2);
        }
    }
}
