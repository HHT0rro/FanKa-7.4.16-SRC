package fb;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import org.apache.commons.lang3.CharEncoding;

/* compiled from: Util.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f49287a = Charset.forName(CharEncoding.US_ASCII);

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f49288b = Charset.forName("UTF-8");

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void b(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    b(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete file: " + ((Object) file2));
                }
            }
            return;
        }
        throw new IOException("not a readable directory: " + ((Object) file));
    }
}
