package io.grpc.util;

import io.grpc.ExperimentalApi;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedTrustManager;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/8024")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class AdvancedTlsX509TrustManager extends X509ExtendedTrustManager {
    private static final Logger log = Logger.getLogger(AdvancedTlsX509TrustManager.class.getName());
    private volatile X509ExtendedTrustManager delegateManager;
    private final SslSocketAndEnginePeerVerifier socketAndEnginePeerVerifier;
    private final Verification verification;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Builder {
        private SslSocketAndEnginePeerVerifier socketAndEnginePeerVerifier;
        private Verification verification;

        public AdvancedTlsX509TrustManager build() throws CertificateException {
            return new AdvancedTlsX509TrustManager(this.verification, this.socketAndEnginePeerVerifier);
        }

        public Builder setSslSocketAndEnginePeerVerifier(SslSocketAndEnginePeerVerifier sslSocketAndEnginePeerVerifier) {
            this.socketAndEnginePeerVerifier = sslSocketAndEnginePeerVerifier;
            return this;
        }

        public Builder setVerification(Verification verification) {
            this.verification = verification;
            return this;
        }

        private Builder() {
            this.verification = Verification.CERTIFICATE_AND_HOST_NAME_VERIFICATION;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface Closeable extends java.io.Closeable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        void close();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class LoadFilePathExecution implements Runnable {
        public long currentTime = 0;
        public File file;

        public LoadFilePathExecution(File file) {
            this.file = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.currentTime = AdvancedTlsX509TrustManager.this.readAndUpdate(this.file, this.currentTime);
            } catch (IOException | GeneralSecurityException e2) {
                AdvancedTlsX509TrustManager.log.log(Level.SEVERE, "Failed refreshing trust CAs from file. Using previous CAs", e2);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface SslSocketAndEnginePeerVerifier {
        void verifyPeerCertificate(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException;

        void verifyPeerCertificate(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum Verification {
        CERTIFICATE_AND_HOST_NAME_VERIFICATION,
        CERTIFICATE_ONLY_VERIFICATION,
        INSECURELY_SKIP_ALL_VERIFICATION
    }

    private void checkTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine, Socket socket, boolean z10) throws CertificateException {
        if (x509CertificateArr == null || x509CertificateArr.length == 0) {
            throw new IllegalArgumentException("Want certificate verification but got null or empty certificates");
        }
        if (sSLEngine == null && socket == null) {
            throw new CertificateException("Not enough information to validate peer. SSLEngine or Socket required.");
        }
        if (this.verification != Verification.INSECURELY_SKIP_ALL_VERIFICATION) {
            X509ExtendedTrustManager x509ExtendedTrustManager = this.delegateManager;
            if (x509ExtendedTrustManager == null) {
                throw new CertificateException("No trust roots configured");
            }
            if (z10) {
                String str2 = this.verification == Verification.CERTIFICATE_AND_HOST_NAME_VERIFICATION ? "HTTPS" : "";
                if (sSLEngine != null) {
                    SSLParameters sSLParameters = sSLEngine.getSSLParameters();
                    sSLParameters.setEndpointIdentificationAlgorithm(str2);
                    sSLEngine.setSSLParameters(sSLParameters);
                    x509ExtendedTrustManager.checkServerTrusted(x509CertificateArr, str, sSLEngine);
                } else if (socket instanceof SSLSocket) {
                    SSLSocket sSLSocket = (SSLSocket) socket;
                    SSLParameters sSLParameters2 = sSLSocket.getSSLParameters();
                    sSLParameters2.setEndpointIdentificationAlgorithm(str2);
                    sSLSocket.setSSLParameters(sSLParameters2);
                    x509ExtendedTrustManager.checkServerTrusted(x509CertificateArr, str, sSLSocket);
                } else {
                    throw new CertificateException("socket is not a type of SSLSocket");
                }
            } else {
                x509ExtendedTrustManager.checkClientTrusted(x509CertificateArr, str, sSLEngine);
            }
        }
        SslSocketAndEnginePeerVerifier sslSocketAndEnginePeerVerifier = this.socketAndEnginePeerVerifier;
        if (sslSocketAndEnginePeerVerifier != null) {
            if (sSLEngine != null) {
                sslSocketAndEnginePeerVerifier.verifyPeerCertificate(x509CertificateArr, str, sSLEngine);
            } else {
                sslSocketAndEnginePeerVerifier.verifyPeerCertificate(x509CertificateArr, str, socket);
            }
        }
    }

    private static X509ExtendedTrustManager createDelegateTrustManager(KeyStore keyStore) throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        X509ExtendedTrustManager x509ExtendedTrustManager;
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        int i10 = 0;
        while (true) {
            if (i10 >= trustManagers.length) {
                x509ExtendedTrustManager = null;
                break;
            }
            if (trustManagers[i10] instanceof X509ExtendedTrustManager) {
                x509ExtendedTrustManager = (X509ExtendedTrustManager) trustManagers[i10];
                break;
            }
            i10++;
        }
        if (x509ExtendedTrustManager != null) {
            return x509ExtendedTrustManager;
        }
        throw new CertificateException("Failed to find X509ExtendedTrustManager with default TrustManager algorithm " + TrustManagerFactory.getDefaultAlgorithm());
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long readAndUpdate(File file, long j10) throws IOException, GeneralSecurityException {
        long lastModified = file.lastModified();
        if (lastModified == j10) {
            return j10;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            updateTrustCredentials(CertificateUtils.getX509Certificates(fileInputStream));
            return lastModified;
        } finally {
            fileInputStream.close();
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        throw new CertificateException("Not enough information to validate peer. SSLEngine or Socket required.");
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        checkTrusted(x509CertificateArr, str, sSLEngine, null, true);
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return this.delegateManager == null ? new X509Certificate[0] : this.delegateManager.getAcceptedIssuers();
    }

    public void updateTrustCredentials(X509Certificate[] x509CertificateArr) throws IOException, GeneralSecurityException {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, null);
        int i10 = 1;
        for (X509Certificate x509Certificate : x509CertificateArr) {
            keyStore.setCertificateEntry(Integer.toString(i10), x509Certificate);
            i10++;
        }
        this.delegateManager = createDelegateTrustManager(keyStore);
    }

    public Closeable updateTrustCredentialsFromFile(File file, long j10, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) throws IOException, GeneralSecurityException {
        if (readAndUpdate(file, 0L) != 0) {
            final ScheduledFuture<?> scheduleWithFixedDelay = scheduledExecutorService.scheduleWithFixedDelay(new LoadFilePathExecution(file), j10, j10, timeUnit);
            return new Closeable() { // from class: io.grpc.util.AdvancedTlsX509TrustManager.1
                @Override // io.grpc.util.AdvancedTlsX509TrustManager.Closeable, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    scheduleWithFixedDelay.cancel(false);
                }
            };
        }
        throw new GeneralSecurityException("Files were unmodified before their initial update. Probably a bug.");
    }

    public void useSystemDefaultTrustCerts() throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        this.delegateManager = createDelegateTrustManager(null);
    }

    private AdvancedTlsX509TrustManager(Verification verification, SslSocketAndEnginePeerVerifier sslSocketAndEnginePeerVerifier) throws CertificateException {
        this.delegateManager = null;
        this.verification = verification;
        this.socketAndEnginePeerVerifier = sslSocketAndEnginePeerVerifier;
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        checkTrusted(x509CertificateArr, str, null, socket, false);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        throw new CertificateException("Not enough information to validate peer. SSLEngine or Socket required.");
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        checkTrusted(x509CertificateArr, str, sSLEngine, null, false);
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        checkTrusted(x509CertificateArr, str, null, socket, true);
    }

    public void updateTrustCredentialsFromFile(File file) throws IOException, GeneralSecurityException {
        if (readAndUpdate(file, 0L) == 0) {
            throw new GeneralSecurityException("Files were unmodified before their initial update. Probably a bug.");
        }
    }
}
