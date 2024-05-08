package pb;

import com.kwad.sdk.core.imageloader.utils.IoUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: IoUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {

    /* compiled from: IoUtils.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        boolean onBytesCopied(int i10, int i11);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static boolean b(InputStream inputStream, OutputStream outputStream, a aVar, int i10) throws IOException {
        int available = inputStream.available();
        if (available <= 0) {
            available = IoUtils.DEFAULT_IMAGE_TOTAL_SIZE;
        }
        byte[] bArr = new byte[i10];
        if (d(aVar, 0, available)) {
            return false;
        }
        int i11 = 0;
        do {
            int read = inputStream.read(bArr, 0, i10);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                i11 += read;
            } else {
                outputStream.flush();
                return true;
            }
        } while (!d(aVar, i11, available));
        return false;
    }

    public static void c(InputStream inputStream) {
        do {
            try {
            } catch (IOException unused) {
            } catch (Throwable th) {
                a(inputStream);
                throw th;
            }
        } while (inputStream.read(new byte[32768], 0, 32768) != -1);
        a(inputStream);
    }

    public static boolean d(a aVar, int i10, int i11) {
        return (aVar == null || aVar.onBytesCopied(i10, i11) || (i10 * 100) / i11 >= 75) ? false : true;
    }
}
