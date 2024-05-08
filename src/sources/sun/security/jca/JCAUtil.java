package sun.security.jca;

import java.security.SecureRandom;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class JCAUtil {
    private static final int ARRAY_SIZE = 4096;
    private static volatile SecureRandom def = null;

    private JCAUtil() {
    }

    public static int getTempArraySize(int totalSize) {
        return Math.min(4096, totalSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class CachedSecureRandomHolder {
        public static SecureRandom instance = new SecureRandom();

        private CachedSecureRandomHolder() {
        }
    }

    public static SecureRandom getSecureRandom() {
        return CachedSecureRandomHolder.instance;
    }

    static void clearDefSecureRandom() {
        def = null;
    }

    public static SecureRandom getDefSecureRandom() {
        SecureRandom result = def;
        if (result == null) {
            synchronized (JCAUtil.class) {
                result = def;
                if (result == null) {
                    SecureRandom secureRandom = new SecureRandom();
                    result = secureRandom;
                    def = secureRandom;
                }
            }
        }
        return result;
    }
}
