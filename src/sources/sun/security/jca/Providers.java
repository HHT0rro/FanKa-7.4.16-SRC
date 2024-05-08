package sun.security.jca;

import dalvik.system.VMRuntime;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Providers {
    private static final String BACKUP_PROVIDER_CLASSNAME = "sun.security.provider.VerificationProvider";
    public static final int DEFAULT_MAXIMUM_ALLOWABLE_TARGET_API_LEVEL_FOR_BC_DEPRECATION = 27;
    private static final Set<String> DEPRECATED_ALGORITHMS;
    private static volatile Provider SYSTEM_BOUNCY_CASTLE_PROVIDER;
    private static final String[] jarVerificationProviders;
    private static int maximumAllowableApiLevelForBcDeprecation;
    private static volatile ProviderList providerList;
    private static final ThreadLocal<ProviderList> threadLists = new InheritableThreadLocal();
    private static volatile int threadListsUsed;

    static {
        providerList = ProviderList.EMPTY;
        providerList = ProviderList.fromSecurityProperties();
        int numConfiguredProviders = providerList.size();
        providerList = providerList.removeInvalid();
        if (numConfiguredProviders != providerList.size()) {
            throw new AssertionError((Object) "Unable to configure default providers");
        }
        SYSTEM_BOUNCY_CASTLE_PROVIDER = providerList.getProvider("BC");
        jarVerificationProviders = new String[]{"com.android.org.conscrypt.OpenSSLProvider", "com.android.org.bouncycastle.jce.provider.BouncyCastleProvider", "com.android.org.conscrypt.JSSEProvider", BACKUP_PROVIDER_CLASSNAME};
        maximumAllowableApiLevelForBcDeprecation = 27;
        HashSet hashSet = new HashSet();
        DEPRECATED_ALGORITHMS = hashSet;
        hashSet.addAll(Arrays.asList("KEYFACTORY.RSA"));
    }

    private Providers() {
    }

    public static Provider getSunProvider() {
        try {
            Class<?> clazz = Class.forName(jarVerificationProviders[0]);
            return (Provider) clazz.newInstance();
        } catch (Exception e2) {
            try {
                Class<?> clazz2 = Class.forName(BACKUP_PROVIDER_CLASSNAME);
                return (Provider) clazz2.newInstance();
            } catch (Exception e10) {
                throw new RuntimeException("Sun provider not found", e2);
            }
        }
    }

    public static Object startJarVerification() {
        ProviderList currentList = getProviderList();
        ProviderList jarList = currentList.getJarList(jarVerificationProviders);
        return beginThreadProviderList(jarList);
    }

    public static void stopJarVerification(Object obj) {
        endThreadProviderList((ProviderList) obj);
    }

    public static ProviderList getProviderList() {
        ProviderList list = getThreadProviderList();
        if (list == null) {
            return getSystemProviderList();
        }
        return list;
    }

    public static void setProviderList(ProviderList newList) {
        if (getThreadProviderList() == null) {
            setSystemProviderList(newList);
        } else {
            changeThreadProviderList(newList);
        }
    }

    public static ProviderList getFullProviderList() {
        synchronized (Providers.class) {
            ProviderList list = getThreadProviderList();
            if (list != null) {
                ProviderList newList = list.removeInvalid();
                if (newList != list) {
                    changeThreadProviderList(newList);
                    list = newList;
                }
                return list;
            }
            ProviderList list2 = getSystemProviderList();
            ProviderList newList2 = list2.removeInvalid();
            if (newList2 != list2) {
                setSystemProviderList(newList2);
                return newList2;
            }
            return list2;
        }
    }

    private static ProviderList getSystemProviderList() {
        return providerList;
    }

    private static void setSystemProviderList(ProviderList list) {
        providerList = list;
    }

    public static ProviderList getThreadProviderList() {
        if (threadListsUsed == 0) {
            return null;
        }
        return threadLists.get();
    }

    private static void changeThreadProviderList(ProviderList list) {
        threadLists.set(list);
    }

    public static synchronized ProviderList beginThreadProviderList(ProviderList list) {
        ProviderList oldList;
        synchronized (Providers.class) {
            if (ProviderList.debug != null) {
                ProviderList.debug.println("ThreadLocal providers: " + ((Object) list));
            }
            ThreadLocal<ProviderList> threadLocal = threadLists;
            oldList = threadLocal.get();
            threadListsUsed++;
            threadLocal.set(list);
        }
        return oldList;
    }

    public static synchronized void endThreadProviderList(ProviderList list) {
        synchronized (Providers.class) {
            if (list == null) {
                if (ProviderList.debug != null) {
                    ProviderList.debug.println("Disabling ThreadLocal providers");
                }
                threadLists.remove();
            } else {
                if (ProviderList.debug != null) {
                    ProviderList.debug.println("Restoring previous ThreadLocal providers: " + ((Object) list));
                }
                threadLists.set(list);
            }
            threadListsUsed--;
        }
    }

    public static void setMaximumAllowableApiLevelForBcDeprecation(int targetApiLevel) {
        maximumAllowableApiLevelForBcDeprecation = targetApiLevel;
    }

    public static int getMaximumAllowableApiLevelForBcDeprecation() {
        return maximumAllowableApiLevelForBcDeprecation;
    }

    public static synchronized void checkBouncyCastleDeprecation(String provider, String service, String algorithm) throws NoSuchAlgorithmException {
        synchronized (Providers.class) {
            if ("BC".equals(provider) && providerList.getProvider(provider) == SYSTEM_BOUNCY_CASTLE_PROVIDER) {
                checkBouncyCastleDeprecation(service, algorithm);
            }
        }
    }

    public static synchronized void checkBouncyCastleDeprecation(Provider provider, String service, String algorithm) throws NoSuchAlgorithmException {
        synchronized (Providers.class) {
            if (provider == SYSTEM_BOUNCY_CASTLE_PROVIDER) {
                checkBouncyCastleDeprecation(service, algorithm);
            }
        }
    }

    private static void checkBouncyCastleDeprecation(String service, String algorithm) throws NoSuchAlgorithmException {
        String key = service + "." + algorithm;
        if (DEPRECATED_ALGORITHMS.contains(key.toUpperCase(Locale.US))) {
            if (VMRuntime.getRuntime().getTargetSdkVersion() <= maximumAllowableApiLevelForBcDeprecation) {
                System.logE(" ******** DEPRECATED FUNCTIONALITY ********");
                System.logE(" * The implementation of the " + key + " algorithm from");
                System.logE(" * the BC provider is deprecated in this version of Android.");
                System.logE(" * It will be removed in a future version of Android and your");
                System.logE(" * application will no longer be able to request it.  Please see");
                System.logE(" * https://android-developers.googleblog.com/2018/03/cryptography-changes-in-android-p.html");
                System.logE(" * for more details.");
                return;
            }
            throw new NoSuchAlgorithmException("The BC provider no longer provides an implementation for " + key + ".  Please see https://android-developers.googleblog.com/2018/03/cryptography-changes-in-android-p.html for more details.");
        }
    }
}
