package java.security;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import sun.security.jca.GetInstance;
import sun.security.jca.ProviderList;
import sun.security.jca.Providers;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Security {
    private static final Properties props;
    private static final Map<String, Class<?>> spiMap;
    private static final AtomicInteger version = new AtomicInteger();

    static {
        Properties properties = new Properties();
        props = properties;
        boolean loadedProps = false;
        InputStream is = null;
        try {
            try {
                InputStream propStream = Security.class.getResourceAsStream("security.properties");
                if (propStream == null) {
                    System.logE("Could not find 'security.properties'.");
                } else {
                    is = new BufferedInputStream(propStream);
                    properties.load(is);
                    loadedProps = true;
                }
            } catch (IOException ex) {
                System.logE("Could not load 'security.properties'", ex);
                if (0 != 0) {
                    is.close();
                }
            }
            if (is != null) {
                is.close();
            }
            if (!loadedProps) {
                initializeStatic();
            }
            spiMap = new ConcurrentHashMap();
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    is.close();
                } catch (IOException e2) {
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ProviderProperty {
        String className;
        Provider provider;

        private ProviderProperty() {
        }
    }

    private static void initializeStatic() {
        Properties properties = props;
        properties.put("security.provider.1", "com.android.org.conscrypt.OpenSSLProvider");
        properties.put("security.provider.2", "sun.security.provider.CertPathProvider");
        properties.put("security.provider.3", "com.android.org.bouncycastle.jce.provider.BouncyCastleProvider");
        properties.put("security.provider.4", "com.android.org.conscrypt.JSSEProvider");
    }

    private Security() {
    }

    private static ProviderProperty getProviderProperty(String key) {
        List<Provider> providers = Providers.getProviderList().providers();
        for (int i10 = 0; i10 < providers.size(); i10++) {
            Provider prov = providers.get(i10);
            String prop = prov.getProperty(key);
            if (prop == null) {
                Enumeration<Object> e2 = prov.keys();
                while (true) {
                    if (!e2.hasMoreElements() || prop != null) {
                        break;
                    }
                    String matchKey = (String) e2.nextElement();
                    if (key.equalsIgnoreCase(matchKey)) {
                        prop = prov.getProperty(matchKey);
                        break;
                    }
                }
            }
            if (prop != null) {
                ProviderProperty newEntry = new ProviderProperty();
                newEntry.className = prop;
                newEntry.provider = prov;
                return newEntry;
            }
        }
        return null;
    }

    private static String getProviderProperty(String key, Provider provider) {
        String prop = provider.getProperty(key);
        if (prop == null) {
            Enumeration<Object> e2 = provider.keys();
            while (e2.hasMoreElements() && prop == null) {
                String matchKey = (String) e2.nextElement();
                if (key.equalsIgnoreCase(matchKey)) {
                    return provider.getProperty(matchKey);
                }
            }
            return prop;
        }
        return prop;
    }

    @Deprecated
    public static String getAlgorithmProperty(String algName, String propName) {
        ProviderProperty entry = getProviderProperty("Alg." + propName + "." + algName);
        if (entry != null) {
            return entry.className;
        }
        return null;
    }

    public static synchronized int insertProviderAt(Provider provider, int position) {
        synchronized (Security.class) {
            String providerName = provider.getName();
            ProviderList list = Providers.getFullProviderList();
            ProviderList newList = ProviderList.insertAt(list, provider, position - 1);
            if (list == newList) {
                return -1;
            }
            increaseVersion();
            Providers.setProviderList(newList);
            return newList.getIndex(providerName) + 1;
        }
    }

    public static int addProvider(Provider provider) {
        return insertProviderAt(provider, 0);
    }

    public static synchronized void removeProvider(String name) {
        synchronized (Security.class) {
            ProviderList list = Providers.getFullProviderList();
            ProviderList newList = ProviderList.remove(list, name);
            Providers.setProviderList(newList);
            increaseVersion();
        }
    }

    public static Provider[] getProviders() {
        return Providers.getFullProviderList().toArray();
    }

    public static Provider getProvider(String name) {
        return Providers.getProviderList().getProvider(name);
    }

    public static Provider[] getProviders(String filter) {
        String key;
        String value;
        int index = filter.indexOf(58);
        if (index == -1) {
            key = filter;
            value = "";
        } else {
            key = filter.substring(0, index);
            value = filter.substring(index + 1);
        }
        Hashtable<String, String> hashtableFilter = new Hashtable<>(1);
        hashtableFilter.put(key, value);
        return getProviders(hashtableFilter);
    }

    public static Provider[] getProviders(Map<String, String> filter) {
        Provider[] allProviders = getProviders();
        Set<String> keySet = filter.h();
        LinkedHashSet<Provider> candidates = new LinkedHashSet<>(5);
        if (keySet == null || allProviders == null) {
            return allProviders;
        }
        boolean firstSearch = true;
        for (String key : keySet) {
            String value = filter.get(key);
            LinkedHashSet<Provider> newCandidates = getAllQualifyingCandidates(key, value, allProviders);
            if (firstSearch) {
                candidates = newCandidates;
                firstSearch = false;
            }
            if (newCandidates != null && !newCandidates.isEmpty()) {
                Iterator<Provider> cansIte = candidates.iterator2();
                while (cansIte.hasNext()) {
                    Provider prov = cansIte.next();
                    if (!newCandidates.contains(prov)) {
                        cansIte.remove();
                    }
                }
            } else {
                candidates = null;
                break;
            }
        }
        if (candidates == null || candidates.isEmpty()) {
            return null;
        }
        Object[] candidatesArray = candidates.toArray();
        Provider[] result = new Provider[candidatesArray.length];
        for (int i10 = 0; i10 < result.length; i10++) {
            result[i10] = (Provider) candidatesArray[i10];
        }
        return result;
    }

    private static Class<?> getSpiClass(String type) {
        Map<String, Class<?>> map = spiMap;
        Class<?> clazz = map.get(type);
        if (clazz != null) {
            return clazz;
        }
        try {
            Class<?> clazz2 = Class.forName("java.security." + type + "Spi");
            map.put(type, clazz2);
            return clazz2;
        } catch (ClassNotFoundException e2) {
            throw new AssertionError("Spi class not found", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] getImpl(String algorithm, String type, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (provider == null) {
            return GetInstance.getInstance(type, getSpiClass(type), algorithm).toArray();
        }
        return GetInstance.getInstance(type, getSpiClass(type), algorithm, provider).toArray();
    }

    static Object[] getImpl(String algorithm, String type, String provider, Object params) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        if (provider == null) {
            return GetInstance.getInstance(type, getSpiClass(type), algorithm, params).toArray();
        }
        return GetInstance.getInstance(type, getSpiClass(type), algorithm, params, provider).toArray();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] getImpl(String algorithm, String type, Provider provider) throws NoSuchAlgorithmException {
        return GetInstance.getInstance(type, getSpiClass(type), algorithm, provider).toArray();
    }

    static Object[] getImpl(String algorithm, String type, Provider provider, Object params) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        return GetInstance.getInstance(type, getSpiClass(type), algorithm, params, provider).toArray();
    }

    public static String getProperty(String key) {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new SecurityPermission("getProperty." + key));
        }
        String name = props.getProperty(key);
        if (name != null) {
            return name.trim();
        }
        return name;
    }

    public static void setProperty(String key, String datum) {
        props.put(key, datum);
        increaseVersion();
        invalidateSMCache(key);
    }

    private static void invalidateSMCache(String key) {
        final boolean pa2 = key.equals("package.access");
        boolean pd2 = key.equals("package.definition");
        if (pa2 || pd2) {
            AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: java.security.Security.1
                @Override // java.security.PrivilegedAction
                public Void run() {
                    boolean isAccessible;
                    Field field;
                    try {
                        Class<?> cls = Class.forName("java.lang.SecurityManager", false, null);
                        if (pa2) {
                            Field declaredField = cls.getDeclaredField("packageAccessValid");
                            isAccessible = declaredField.isAccessible();
                            declaredField.setAccessible(true);
                            field = declaredField;
                        } else {
                            Field declaredField2 = cls.getDeclaredField("packageDefinitionValid");
                            isAccessible = declaredField2.isAccessible();
                            declaredField2.setAccessible(true);
                            field = declaredField2;
                        }
                        field.setBoolean(field, false);
                        field.setAccessible(isAccessible);
                    } catch (Exception e2) {
                    }
                    return null;
                }
            });
        }
    }

    private static LinkedHashSet<Provider> getAllQualifyingCandidates(String filterKey, String filterValue, Provider[] allProviders) {
        String[] filterComponents = getFilterComponents(filterKey, filterValue);
        String serviceName = filterComponents[0];
        String algName = filterComponents[1];
        String attrName = filterComponents[2];
        return getProvidersNotUsingCache(serviceName, algName, attrName, filterValue, allProviders);
    }

    private static LinkedHashSet<Provider> getProvidersNotUsingCache(String serviceName, String algName, String attrName, String filterValue, Provider[] allProviders) {
        LinkedHashSet<Provider> candidates = new LinkedHashSet<>(5);
        for (int i10 = 0; i10 < allProviders.length; i10++) {
            if (isCriterionSatisfied(allProviders[i10], serviceName, algName, attrName, filterValue)) {
                candidates.add(allProviders[i10]);
            }
        }
        return candidates;
    }

    private static boolean isCriterionSatisfied(Provider prov, String serviceName, String algName, String attrName, String filterValue) {
        String key = serviceName + '.' + algName;
        if (attrName != null) {
            key = key + ' ' + attrName;
        }
        String propValue = getProviderProperty(key, prov);
        if (propValue == null) {
            String standardName = getProviderProperty("Alg.Alias." + serviceName + "." + algName, prov);
            if (standardName != null) {
                String key2 = serviceName + "." + standardName;
                if (attrName != null) {
                    key2 = key2 + ' ' + attrName;
                }
                propValue = getProviderProperty(key2, prov);
            }
            if (propValue == null) {
                return false;
            }
        }
        if (attrName == null) {
            return true;
        }
        if (isStandardAttr(attrName)) {
            return isConstraintSatisfied(attrName, filterValue, propValue);
        }
        return filterValue.equalsIgnoreCase(propValue);
    }

    private static boolean isStandardAttr(String attribute) {
        return attribute.equalsIgnoreCase("KeySize") || attribute.equalsIgnoreCase("ImplementedIn");
    }

    private static boolean isConstraintSatisfied(String attribute, String value, String prop) {
        if (attribute.equalsIgnoreCase("KeySize")) {
            int requestedSize = Integer.parseInt(value);
            int maxSize = Integer.parseInt(prop);
            return requestedSize <= maxSize;
        }
        if (attribute.equalsIgnoreCase("ImplementedIn")) {
            return value.equalsIgnoreCase(prop);
        }
        return false;
    }

    static String[] getFilterComponents(String filterKey, String filterValue) {
        String algName;
        int algIndex = filterKey.indexOf(46);
        if (algIndex < 0) {
            throw new InvalidParameterException("Invalid filter");
        }
        String serviceName = filterKey.substring(0, algIndex);
        String attrName = null;
        if (filterValue.length() == 0) {
            algName = filterKey.substring(algIndex + 1).trim();
            if (algName.length() == 0) {
                throw new InvalidParameterException("Invalid filter");
            }
        } else {
            int attrIndex = filterKey.indexOf(32);
            if (attrIndex == -1) {
                throw new InvalidParameterException("Invalid filter");
            }
            attrName = filterKey.substring(attrIndex + 1).trim();
            if (attrName.length() == 0) {
                throw new InvalidParameterException("Invalid filter");
            }
            if (attrIndex < algIndex || algIndex == attrIndex - 1) {
                throw new InvalidParameterException("Invalid filter");
            }
            algName = filterKey.substring(algIndex + 1, attrIndex);
        }
        String[] result = {serviceName, algName, attrName};
        return result;
    }

    public static Set<String> getAlgorithms(String serviceName) {
        if (serviceName == null || serviceName.length() == 0 || serviceName.endsWith(".")) {
            return Collections.emptySet();
        }
        HashSet<String> result = new HashSet<>();
        Provider[] providers = getProviders();
        for (Provider provider : providers) {
            Enumeration<Object> e2 = provider.keys();
            while (e2.hasMoreElements()) {
                String currentKey = ((String) e2.nextElement()).toUpperCase(Locale.ENGLISH);
                if (currentKey.startsWith(serviceName.toUpperCase(Locale.ENGLISH)) && currentKey.indexOf(" ") < 0) {
                    result.add(currentKey.substring(serviceName.length() + 1));
                }
            }
        }
        return Collections.unmodifiableSet(result);
    }

    public static void increaseVersion() {
        version.incrementAndGet();
    }

    public static int getVersion() {
        return version.get();
    }
}
