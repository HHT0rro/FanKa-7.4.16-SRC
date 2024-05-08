package sun.security.jca;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class GetInstance {
    private GetInstance() {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Instance {
        public final Object impl;
        public final Provider provider;

        private Instance(Provider provider, Object impl) {
            this.provider = provider;
            this.impl = impl;
        }

        public Object[] toArray() {
            return new Object[]{this.impl, this.provider};
        }
    }

    public static Provider.Service getService(String type, String algorithm) throws NoSuchAlgorithmException {
        ProviderList list = Providers.getProviderList();
        Provider.Service s2 = list.getService(type, algorithm);
        if (s2 == null) {
            throw new NoSuchAlgorithmException(algorithm + " " + type + " not available");
        }
        return s2;
    }

    public static Provider.Service getService(String type, String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (provider == null || provider.isEmpty()) {
            throw new IllegalArgumentException("missing provider");
        }
        Provider p10 = Providers.getProviderList().getProvider(provider);
        if (p10 == null) {
            throw new NoSuchProviderException("no such provider: " + provider);
        }
        Provider.Service s2 = p10.getService(type, algorithm);
        if (s2 == null) {
            throw new NoSuchAlgorithmException("no such algorithm: " + algorithm + " for provider " + provider);
        }
        return s2;
    }

    public static Provider.Service getService(String type, String algorithm, Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("missing provider");
        }
        Provider.Service s2 = provider.getService(type, algorithm);
        if (s2 == null) {
            throw new NoSuchAlgorithmException("no such algorithm: " + algorithm + " for provider " + provider.getName());
        }
        return s2;
    }

    public static List<Provider.Service> getServices(String type, String algorithm) {
        ProviderList list = Providers.getProviderList();
        return list.getServices(type, algorithm);
    }

    @Deprecated
    public static List<Provider.Service> getServices(String type, List<String> algorithms) {
        ProviderList list = Providers.getProviderList();
        return list.getServices(type, algorithms);
    }

    public static List<Provider.Service> getServices(List<ServiceId> ids) {
        ProviderList list = Providers.getProviderList();
        return list.getServices(ids);
    }

    public static Instance getInstance(String type, Class<?> clazz, String algorithm) throws NoSuchAlgorithmException {
        ProviderList list = Providers.getProviderList();
        Provider.Service firstService = list.getService(type, algorithm);
        if (firstService == null) {
            throw new NoSuchAlgorithmException(algorithm + " " + type + " not available");
        }
        try {
            return getInstance(firstService, clazz);
        } catch (NoSuchAlgorithmException e2) {
            failure = e2;
            Iterator<Provider.Service> iterator2 = list.getServices(type, algorithm).iterator2();
            while (iterator2.hasNext()) {
                Provider.Service s2 = iterator2.next();
                if (s2 != firstService) {
                    try {
                        return getInstance(s2, clazz);
                    } catch (NoSuchAlgorithmException e10) {
                        failure = e10;
                    }
                }
            }
            throw failure;
        }
    }

    public static Instance getInstance(String type, Class<?> clazz, String algorithm, Object param) throws NoSuchAlgorithmException {
        List<Provider.Service> services = getServices(type, algorithm);
        NoSuchAlgorithmException failure = null;
        Iterator<Provider.Service> iterator2 = services.iterator2();
        while (iterator2.hasNext()) {
            Provider.Service s2 = iterator2.next();
            try {
                return getInstance(s2, clazz, param);
            } catch (NoSuchAlgorithmException e2) {
                failure = e2;
            }
        }
        if (failure != null) {
            throw failure;
        }
        throw new NoSuchAlgorithmException(algorithm + " " + type + " not available");
    }

    public static Instance getInstance(String type, Class<?> clazz, String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        return getInstance(getService(type, algorithm, provider), clazz);
    }

    public static Instance getInstance(String type, Class<?> clazz, String algorithm, Object param, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        return getInstance(getService(type, algorithm, provider), clazz, param);
    }

    public static Instance getInstance(String type, Class<?> clazz, String algorithm, Provider provider) throws NoSuchAlgorithmException {
        return getInstance(getService(type, algorithm, provider), clazz);
    }

    public static Instance getInstance(String type, Class<?> clazz, String algorithm, Object param, Provider provider) throws NoSuchAlgorithmException {
        return getInstance(getService(type, algorithm, provider), clazz, param);
    }

    public static Instance getInstance(Provider.Service s2, Class<?> clazz) throws NoSuchAlgorithmException {
        Object instance = s2.newInstance(null);
        checkSuperClass(s2, instance.getClass(), clazz);
        return new Instance(s2.getProvider(), instance);
    }

    public static Instance getInstance(Provider.Service s2, Class<?> clazz, Object param) throws NoSuchAlgorithmException {
        Object instance = s2.newInstance(param);
        checkSuperClass(s2, instance.getClass(), clazz);
        return new Instance(s2.getProvider(), instance);
    }

    public static void checkSuperClass(Provider.Service s2, Class<?> subClass, Class<?> superClass) throws NoSuchAlgorithmException {
        if (superClass != null && !superClass.isAssignableFrom(subClass)) {
            throw new NoSuchAlgorithmException("class configured for " + s2.getType() + ": " + s2.getClassName() + " not a " + s2.getType());
        }
    }
}
