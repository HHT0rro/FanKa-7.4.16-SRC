package okhttp3.internal.platform;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.s;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Protocol;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.platform.android.Android10SocketAdapter;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.tls.CertificateChainCleaner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Android10Platform.kt */
@SuppressSignatureCheck
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Android10Platform extends Platform {
    public static final Companion Companion = new Companion(null);
    private static final boolean isSupported;
    private final List<SocketAdapter> socketAdapters;

    /* compiled from: Android10Platform.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final Platform buildIfSupported() {
            if (isSupported()) {
                return new Android10Platform();
            }
            return null;
        }

        public final boolean isSupported() {
            return Android10Platform.isSupported;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        isSupported = Platform.Companion.isAndroid() && Build.VERSION.SDK_INT >= 29;
    }

    public Android10Platform() {
        List n10 = s.n(Android10SocketAdapter.Companion.buildIfSupported(), new DeferredSocketAdapter(AndroidSocketAdapter.Companion.getPlayProviderFactory()), new DeferredSocketAdapter(ConscryptSocketAdapter.Companion.getFactory()), new DeferredSocketAdapter(BouncyCastleSocketAdapter.Companion.getFactory()));
        ArrayList arrayList = new ArrayList();
        for (Object obj : n10) {
            if (((SocketAdapter) obj).isSupported()) {
                arrayList.add(obj);
            }
        }
        this.socketAdapters = arrayList;
    }

    @Override // okhttp3.internal.platform.Platform
    @NotNull
    public CertificateChainCleaner buildCertificateChainCleaner(@NotNull X509TrustManager trustManager) {
        kotlin.jvm.internal.s.i(trustManager, "trustManager");
        AndroidCertificateChainCleaner buildIfSupported = AndroidCertificateChainCleaner.Companion.buildIfSupported(trustManager);
        return buildIfSupported != null ? buildIfSupported : super.buildCertificateChainCleaner(trustManager);
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(@NotNull SSLSocket sslSocket, @Nullable String str, @NotNull List<? extends Protocol> protocols) {
        SocketAdapter socketAdapter;
        kotlin.jvm.internal.s.i(sslSocket, "sslSocket");
        kotlin.jvm.internal.s.i(protocols, "protocols");
        Iterator<SocketAdapter> iterator2 = this.socketAdapters.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                socketAdapter = null;
                break;
            } else {
                socketAdapter = iterator2.next();
                if (socketAdapter.matchesSocket(sslSocket)) {
                    break;
                }
            }
        }
        SocketAdapter socketAdapter2 = socketAdapter;
        if (socketAdapter2 != null) {
            socketAdapter2.configureTlsExtensions(sslSocket, str, protocols);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sslSocket) {
        SocketAdapter socketAdapter;
        kotlin.jvm.internal.s.i(sslSocket, "sslSocket");
        Iterator<SocketAdapter> iterator2 = this.socketAdapters.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                socketAdapter = null;
                break;
            }
            socketAdapter = iterator2.next();
            if (socketAdapter.matchesSocket(sslSocket)) {
                break;
            }
        }
        SocketAdapter socketAdapter2 = socketAdapter;
        if (socketAdapter2 != null) {
            return socketAdapter2.getSelectedProtocol(sslSocket);
        }
        return null;
    }

    @Override // okhttp3.internal.platform.Platform
    public boolean isCleartextTrafficPermitted(@NotNull String hostname) {
        kotlin.jvm.internal.s.i(hostname, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname);
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory sslSocketFactory) {
        SocketAdapter socketAdapter;
        kotlin.jvm.internal.s.i(sslSocketFactory, "sslSocketFactory");
        Iterator<SocketAdapter> iterator2 = this.socketAdapters.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                socketAdapter = null;
                break;
            }
            socketAdapter = iterator2.next();
            if (socketAdapter.matchesSocketFactory(sslSocketFactory)) {
                break;
            }
        }
        SocketAdapter socketAdapter2 = socketAdapter;
        if (socketAdapter2 != null) {
            return socketAdapter2.trustManager(sslSocketFactory);
        }
        return null;
    }
}
