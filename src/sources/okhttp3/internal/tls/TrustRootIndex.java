package okhttp3.internal.tls;

import java.security.cert.X509Certificate;
import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TrustRootIndex.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface TrustRootIndex {
    @Nullable
    X509Certificate findByIssuerAndSignature(@NotNull X509Certificate x509Certificate);
}
