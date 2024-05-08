package xa;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Objects;
import za.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String f54604a = "SecureX509SingleInstance";

    /* renamed from: b, reason: collision with root package name */
    public static volatile e f54605b;

    public static e a(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        long currentTimeMillis = System.currentTimeMillis();
        Objects.requireNonNull(context, "context is null");
        za.b.b(context);
        if (f54605b == null) {
            synchronized (d.class) {
                if (f54605b == null) {
                    InputStream inputStream = null;
                    try {
                        inputStream = za.a.n(context);
                    } catch (RuntimeException unused) {
                        f.d(f54604a, "get files bks error");
                    }
                    if (inputStream == null) {
                        f.e(f54604a, "get assets bks");
                        inputStream = context.getAssets().open("hmsrootcas.bks");
                    } else {
                        f.e(f54604a, "get files bks");
                    }
                    f54605b = new e(inputStream, "");
                }
            }
        }
        f.b(f54604a, "SecureX509TrustManager getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return f54605b;
    }
}
