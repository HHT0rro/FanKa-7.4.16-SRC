package com.android.internal.org.bouncycastle.crypto.digests;

import com.android.internal.org.bouncycastle.crypto.Digest;
import java.security.Security;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class AndroidDigestFactory {
    private static final AndroidDigestFactoryInterface BC = new AndroidDigestFactoryBouncyCastle();
    private static final AndroidDigestFactoryInterface CONSCRYPT;

    static {
        if (Security.getProvider("AndroidOpenSSL") != null) {
            CONSCRYPT = new AndroidDigestFactoryOpenSSL();
        } else {
            if (System.getProperty("java.vendor", "").toLowerCase(Locale.US).contains("android")) {
                throw new AssertionError((Object) "Provider AndroidOpenSSL must exist");
            }
            CONSCRYPT = null;
        }
    }

    public static Digest getMD5() {
        AndroidDigestFactoryInterface androidDigestFactoryInterface = CONSCRYPT;
        if (androidDigestFactoryInterface != null) {
            try {
                return androidDigestFactoryInterface.getMD5();
            } catch (Exception e2) {
            }
        }
        return BC.getMD5();
    }

    public static Digest getSHA1() {
        AndroidDigestFactoryInterface androidDigestFactoryInterface = CONSCRYPT;
        if (androidDigestFactoryInterface != null) {
            try {
                return androidDigestFactoryInterface.getSHA1();
            } catch (Exception e2) {
            }
        }
        return BC.getSHA1();
    }

    public static Digest getSHA224() {
        AndroidDigestFactoryInterface androidDigestFactoryInterface = CONSCRYPT;
        if (androidDigestFactoryInterface != null) {
            try {
                return androidDigestFactoryInterface.getSHA224();
            } catch (Exception e2) {
            }
        }
        return BC.getSHA224();
    }

    public static Digest getSHA256() {
        AndroidDigestFactoryInterface androidDigestFactoryInterface = CONSCRYPT;
        if (androidDigestFactoryInterface != null) {
            try {
                return androidDigestFactoryInterface.getSHA256();
            } catch (Exception e2) {
            }
        }
        return BC.getSHA256();
    }

    public static Digest getSHA384() {
        AndroidDigestFactoryInterface androidDigestFactoryInterface = CONSCRYPT;
        if (androidDigestFactoryInterface != null) {
            try {
                return androidDigestFactoryInterface.getSHA384();
            } catch (Exception e2) {
            }
        }
        return BC.getSHA384();
    }

    public static Digest getSHA512() {
        AndroidDigestFactoryInterface androidDigestFactoryInterface = CONSCRYPT;
        if (androidDigestFactoryInterface != null) {
            try {
                return androidDigestFactoryInterface.getSHA512();
            } catch (Exception e2) {
            }
        }
        return BC.getSHA512();
    }
}
