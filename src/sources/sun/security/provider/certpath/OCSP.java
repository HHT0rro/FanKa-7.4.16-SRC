package sun.security.provider.certpath;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.security.AccessController;
import java.security.cert.CRLReason;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertificateException;
import java.security.cert.Extension;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import sun.security.action.GetIntegerAction;
import sun.security.util.Debug;
import sun.security.util.ObjectIdentifier;
import sun.security.x509.AccessDescription;
import sun.security.x509.AuthorityInfoAccessExtension;
import sun.security.x509.GeneralName;
import sun.security.x509.URIName;
import sun.security.x509.X509CertImpl;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class OCSP {
    private static final int DEFAULT_CONNECT_TIMEOUT = 15000;
    static final ObjectIdentifier NONCE_EXTENSION_OID = ObjectIdentifier.newInternal(new int[]{1, 3, 6, 1, 5, 5, 7, 48, 1, 2});
    private static final Debug debug = Debug.getInstance("certpath");
    private static final int CONNECT_TIMEOUT = initializeTimeout();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface RevocationStatus {

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public enum CertStatus {
            GOOD,
            REVOKED,
            UNKNOWN
        }

        CertStatus getCertStatus();

        CRLReason getRevocationReason();

        Date getRevocationTime();

        Map<String, Extension> getSingleExtensions();
    }

    private static int initializeTimeout() {
        Integer tmp = (Integer) AccessController.doPrivileged(new GetIntegerAction("com.sun.security.ocsp.timeout"));
        if (tmp == null || tmp.intValue() < 0) {
            return DEFAULT_CONNECT_TIMEOUT;
        }
        return tmp.intValue() * 1000;
    }

    private OCSP() {
    }

    public static RevocationStatus check(X509Certificate cert, X509Certificate issuerCert) throws IOException, CertPathValidatorException {
        try {
            X509CertImpl certImpl = X509CertImpl.toImpl(cert);
            URI responderURI = getResponderURI(certImpl);
            if (responderURI == null) {
                throw new CertPathValidatorException("No OCSP Responder URI in certificate");
            }
            CertId certId = new CertId(issuerCert, certImpl.getSerialNumberObject());
            OCSPResponse ocspResponse = check((List<CertId>) Collections.singletonList(certId), responderURI, issuerCert, (X509Certificate) null, (Date) null, (List<Extension>) Collections.emptyList());
            return ocspResponse.getSingleResponse(certId);
        } catch (IOException | CertificateException e2) {
            throw new CertPathValidatorException("Exception while encoding OCSPRequest", e2);
        }
    }

    public static RevocationStatus check(X509Certificate cert, X509Certificate issuerCert, URI responderURI, X509Certificate responderCert, Date date) throws IOException, CertPathValidatorException {
        return check(cert, issuerCert, responderURI, responderCert, date, (List<Extension>) Collections.emptyList());
    }

    public static RevocationStatus check(X509Certificate cert, X509Certificate issuerCert, URI responderURI, X509Certificate responderCert, Date date, List<Extension> extensions) throws IOException, CertPathValidatorException {
        try {
            X509CertImpl certImpl = X509CertImpl.toImpl(cert);
            CertId certId = new CertId(issuerCert, certImpl.getSerialNumberObject());
            OCSPResponse ocspResponse = check((List<CertId>) Collections.singletonList(certId), responderURI, issuerCert, responderCert, date, extensions);
            return ocspResponse.getSingleResponse(certId);
        } catch (IOException | CertificateException e2) {
            throw new CertPathValidatorException("Exception while encoding OCSPRequest", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OCSPResponse check(List<CertId> certIds, URI responderURI, X509Certificate issuerCert, X509Certificate responderCert, Date date, List<Extension> extensions) throws IOException, CertPathValidatorException {
        IOException ioe;
        try {
            try {
                OCSPRequest request = new OCSPRequest(certIds, extensions);
                byte[] bytes = request.encodeBytes();
                InputStream in = null;
                OutputStream out = null;
                try {
                    try {
                        URL url = responderURI.toURL();
                        Debug debug2 = debug;
                        if (debug2 != null) {
                            debug2.println("connecting to OCSP service at: " + ((Object) url));
                        }
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        int i10 = CONNECT_TIMEOUT;
                        con.setConnectTimeout(i10);
                        con.setReadTimeout(i10);
                        con.setDoOutput(true);
                        con.setDoInput(true);
                        con.setRequestMethod("POST");
                        con.setRequestProperty("Content-type", "application/ocsp-request");
                        con.setRequestProperty("Content-length", String.valueOf(bytes.length));
                        OutputStream out2 = con.getOutputStream();
                        try {
                            out2.write(bytes);
                            out2.flush();
                            if (debug2 != null && con.getResponseCode() != 200) {
                                debug2.println("Received HTTP error: " + con.getResponseCode() + " - " + con.getResponseMessage());
                            }
                            InputStream in2 = con.getInputStream();
                            try {
                                int contentLength = con.getContentLength();
                                if (contentLength == -1) {
                                    contentLength = Integer.MAX_VALUE;
                                }
                                int i11 = 2048;
                                if (contentLength <= 2048) {
                                    i11 = contentLength;
                                }
                                byte[] response = new byte[i11];
                                int total = 0;
                                while (total < contentLength) {
                                    try {
                                        int count = in2.read(response, total, response.length - total);
                                        if (count < 0) {
                                            break;
                                        }
                                        total += count;
                                        if (total >= response.length && total < contentLength) {
                                            response = Arrays.copyOf(response, total * 2);
                                        }
                                    } catch (IOException e2) {
                                        ioe = e2;
                                        throw new CertPathValidatorException("Unable to determine revocation status due to network error", ioe, null, -1, CertPathValidatorException.BasicReason.UNDETERMINED_REVOCATION_STATUS);
                                    } catch (Throwable th) {
                                        ioe = th;
                                        out = out2;
                                        in = in2;
                                        if (in != null) {
                                            try {
                                                in.close();
                                            } catch (IOException ioe2) {
                                                throw ioe2;
                                            }
                                        }
                                        if (out != null) {
                                            try {
                                                out.close();
                                            } catch (IOException ioe3) {
                                                throw ioe3;
                                            }
                                        }
                                        throw ioe;
                                    }
                                }
                                byte[] response2 = Arrays.copyOf(response, total);
                                if (in2 != null) {
                                    try {
                                        in2.close();
                                    } catch (IOException ioe4) {
                                        throw ioe4;
                                    }
                                }
                                if (out2 != null) {
                                    try {
                                        out2.close();
                                    } catch (IOException ioe5) {
                                        throw ioe5;
                                    }
                                }
                                try {
                                    OCSPResponse ocspResponse = new OCSPResponse(response2);
                                    ocspResponse.verify(certIds, issuerCert, responderCert, date, request.getNonce());
                                    return ocspResponse;
                                } catch (IOException ioe6) {
                                    throw new CertPathValidatorException(ioe6);
                                }
                            } catch (IOException e10) {
                                ioe = e10;
                            } catch (Throwable th2) {
                                ioe = th2;
                                out = out2;
                                in = in2;
                            }
                        } catch (IOException e11) {
                            ioe = e11;
                        } catch (Throwable th3) {
                            ioe = th3;
                            out = out2;
                        }
                    } catch (IOException e12) {
                        ioe = e12;
                    }
                } catch (Throwable th4) {
                    ioe = th4;
                }
            } catch (IOException e13) {
                ioe = e13;
                throw new CertPathValidatorException("Exception while encoding OCSPRequest", ioe);
            }
        } catch (IOException e14) {
            ioe = e14;
        }
    }

    public static URI getResponderURI(X509Certificate cert) {
        try {
            return getResponderURI(X509CertImpl.toImpl(cert));
        } catch (CertificateException e2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static URI getResponderURI(X509CertImpl certImpl) {
        AuthorityInfoAccessExtension aia = certImpl.getAuthorityInfoAccessExtension();
        if (aia == null) {
            return null;
        }
        List<AccessDescription> descriptions = aia.getAccessDescriptions();
        for (AccessDescription description : descriptions) {
            if (description.getAccessMethod().equals((Object) AccessDescription.Ad_OCSP_Id)) {
                GeneralName generalName = description.getAccessLocation();
                if (generalName.getType() == 6) {
                    URIName uri = (URIName) generalName.getName();
                    return uri.getURI();
                }
            }
        }
        return null;
    }
}
