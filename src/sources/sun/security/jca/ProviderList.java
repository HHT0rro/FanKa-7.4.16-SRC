package sun.security.jca;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.Security;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import sun.security.util.Debug;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class ProviderList {
    static final ProviderList EMPTY;
    private static final ProviderConfig[] PC0;
    private volatile boolean allLoaded;
    private final ProviderConfig[] configs;
    private final List<Provider> userList;
    static final Debug debug = Debug.getInstance("jca", "ProviderList");
    private static final Provider[] P0 = new Provider[0];
    private static final Provider EMPTY_PROVIDER = new Provider("##Empty##", 1.0d, "initialization in progress") { // from class: sun.security.jca.ProviderList.1
        private static final long serialVersionUID = 1151354171352296389L;

        @Override // java.security.Provider
        public Provider.Service getService(String type, String algorithm) {
            return null;
        }
    };

    static {
        ProviderConfig[] providerConfigArr = new ProviderConfig[0];
        PC0 = providerConfigArr;
        EMPTY = new ProviderList(providerConfigArr, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ProviderList fromSecurityProperties() {
        return (ProviderList) AccessController.doPrivileged(new PrivilegedAction<ProviderList>() { // from class: sun.security.jca.ProviderList.2
            @Override // java.security.PrivilegedAction
            public ProviderList run() {
                return new ProviderList();
            }
        });
    }

    public static ProviderList add(ProviderList providerList, Provider p10) {
        return insertAt(providerList, p10, -1);
    }

    public static ProviderList insertAt(ProviderList providerList, Provider p10, int position) {
        if (providerList.getProvider(p10.getName()) != null) {
            return providerList;
        }
        List<ProviderConfig> list = new ArrayList<>(Arrays.asList(providerList.configs));
        int n10 = list.size();
        if (position < 0 || position > n10) {
            position = n10;
        }
        list.add(position, new ProviderConfig(p10));
        return new ProviderList((ProviderConfig[]) list.toArray(PC0), true);
    }

    public static ProviderList remove(ProviderList providerList, String name) {
        if (providerList.getProvider(name) == null) {
            return providerList;
        }
        ProviderConfig[] configs = new ProviderConfig[providerList.size() - 1];
        int j10 = 0;
        for (ProviderConfig config : providerList.configs) {
            if (!config.getProvider().getName().equals(name)) {
                configs[j10] = config;
                j10++;
            }
        }
        return new ProviderList(configs, true);
    }

    public static ProviderList newList(Provider... providers) {
        ProviderConfig[] configs = new ProviderConfig[providers.length];
        for (int i10 = 0; i10 < providers.length; i10++) {
            configs[i10] = new ProviderConfig(providers[i10]);
        }
        return new ProviderList(configs, true);
    }

    private ProviderList(ProviderConfig[] configs, boolean allLoaded) {
        this.userList = new AbstractList<Provider>() { // from class: sun.security.jca.ProviderList.3
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return ProviderList.this.configs.length;
            }

            @Override // java.util.AbstractList, java.util.List
            public Provider get(int index) {
                return ProviderList.this.getProvider(index);
            }
        };
        this.configs = configs;
        this.allLoaded = allLoaded;
    }

    private ProviderList() {
        ProviderConfig config;
        this.userList = new AbstractList<Provider>() { // from class: sun.security.jca.ProviderList.3
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return ProviderList.this.configs.length;
            }

            @Override // java.util.AbstractList, java.util.List
            public Provider get(int index) {
                return ProviderList.this.getProvider(index);
            }
        };
        List<ProviderConfig> configList = new ArrayList<>();
        int i10 = 1;
        while (true) {
            String entry = Security.getProperty("security.provider." + i10);
            if (entry == null) {
                break;
            }
            String entry2 = entry.trim();
            if (entry2.length() == 0) {
                System.err.println("invalid entry for security.provider." + i10);
                break;
            }
            int k10 = entry2.indexOf(32);
            if (k10 == -1) {
                config = new ProviderConfig(entry2);
            } else {
                String className = entry2.substring(0, k10);
                String argument = entry2.substring(k10 + 1).trim();
                config = new ProviderConfig(className, argument);
            }
            if (!configList.contains(config)) {
                configList.add(config);
            }
            i10++;
        }
        this.configs = (ProviderConfig[]) configList.toArray(PC0);
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("provider configuration: " + ((Object) configList));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProviderList getJarList(String[] jarClassNames) {
        List<ProviderConfig> newConfigs = new ArrayList<>();
        for (String className : jarClassNames) {
            ProviderConfig newConfig = new ProviderConfig(className);
            ProviderConfig[] providerConfigArr = this.configs;
            int length = providerConfigArr.length;
            int i10 = 0;
            while (true) {
                if (i10 < length) {
                    ProviderConfig config = providerConfigArr[i10];
                    if (!config.equals(newConfig)) {
                        i10++;
                    } else {
                        newConfig = config;
                        break;
                    }
                }
            }
            newConfigs.add(newConfig);
        }
        ProviderConfig[] configArray = (ProviderConfig[]) newConfigs.toArray(PC0);
        return new ProviderList(configArray, false);
    }

    public int size() {
        return this.configs.length;
    }

    Provider getProvider(int index) {
        Provider p10 = this.configs[index].getProvider();
        return p10 != null ? p10 : EMPTY_PROVIDER;
    }

    public List<Provider> providers() {
        return this.userList;
    }

    private ProviderConfig getProviderConfig(String name) {
        int index = getIndex(name);
        if (index != -1) {
            return this.configs[index];
        }
        return null;
    }

    public Provider getProvider(String name) {
        ProviderConfig config = getProviderConfig(name);
        if (config == null) {
            return null;
        }
        return config.getProvider();
    }

    public int getIndex(String name) {
        for (int i10 = 0; i10 < this.configs.length; i10++) {
            Provider p10 = getProvider(i10);
            if (p10.getName().equals(name)) {
                return i10;
            }
        }
        return -1;
    }

    private int loadAll() {
        ProviderConfig[] providerConfigArr;
        if (this.allLoaded) {
            return this.configs.length;
        }
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("Loading all providers");
            new Exception("Call trace").printStackTrace();
        }
        int n10 = 0;
        int i10 = 0;
        while (true) {
            providerConfigArr = this.configs;
            if (i10 >= providerConfigArr.length) {
                break;
            }
            Provider p10 = providerConfigArr[i10].getProvider();
            if (p10 != null) {
                n10++;
            }
            i10++;
        }
        int i11 = providerConfigArr.length;
        if (n10 == i11) {
            this.allLoaded = true;
        }
        return n10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProviderList removeInvalid() {
        int n10 = loadAll();
        if (n10 == this.configs.length) {
            return this;
        }
        ProviderConfig[] newConfigs = new ProviderConfig[n10];
        int i10 = 0;
        int j10 = 0;
        while (true) {
            ProviderConfig[] providerConfigArr = this.configs;
            if (i10 < providerConfigArr.length) {
                ProviderConfig config = providerConfigArr[i10];
                if (config.isLoaded()) {
                    newConfigs[j10] = config;
                    j10++;
                }
                i10++;
            } else {
                return new ProviderList(newConfigs, true);
            }
        }
    }

    public Provider[] toArray() {
        return (Provider[]) providers().toArray(P0);
    }

    public String toString() {
        return Arrays.asList(this.configs).toString();
    }

    public Provider.Service getService(String type, String name) {
        for (int i10 = 0; i10 < this.configs.length; i10++) {
            Provider p10 = getProvider(i10);
            Provider.Service s2 = p10.getService(type, name);
            if (s2 != null) {
                return s2;
            }
        }
        return null;
    }

    public List<Provider.Service> getServices(String type, String algorithm) {
        return new ServiceList(type, algorithm);
    }

    @Deprecated
    public List<Provider.Service> getServices(String type, List<String> algorithms) {
        List<ServiceId> ids = new ArrayList<>();
        for (String alg : algorithms) {
            ids.add(new ServiceId(type, alg));
        }
        return getServices(ids);
    }

    public List<Provider.Service> getServices(List<ServiceId> ids) {
        return new ServiceList(ids);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public final class ServiceList extends AbstractList<Provider.Service> {
        private final String algorithm;
        private Provider.Service firstService;
        private final List<ServiceId> ids;
        private int providerIndex;
        private List<Provider.Service> services;
        private final String type;

        ServiceList(String type, String algorithm) {
            this.type = type;
            this.algorithm = algorithm;
            this.ids = null;
        }

        ServiceList(List<ServiceId> ids) {
            this.type = null;
            this.algorithm = null;
            this.ids = ids;
        }

        private void addService(Provider.Service s2) {
            if (this.firstService == null) {
                this.firstService = s2;
                return;
            }
            if (this.services == null) {
                ArrayList arrayList = new ArrayList(4);
                this.services = arrayList;
                arrayList.add(this.firstService);
            }
            this.services.add(s2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Provider.Service tryGet(int index) {
            while (true) {
                if (index == 0) {
                    Provider.Service service = this.firstService;
                    if (service != null) {
                        return service;
                    }
                }
                List<Provider.Service> list = this.services;
                if (list != null && list.size() > index) {
                    return this.services.get(index);
                }
                if (this.providerIndex >= ProviderList.this.configs.length) {
                    return null;
                }
                ProviderList providerList = ProviderList.this;
                int i10 = this.providerIndex;
                this.providerIndex = i10 + 1;
                Provider p10 = providerList.getProvider(i10);
                String str = this.type;
                if (str != null) {
                    Provider.Service s2 = p10.getService(str, this.algorithm);
                    if (s2 != null) {
                        addService(s2);
                    }
                } else {
                    for (ServiceId id2 : this.ids) {
                        Provider.Service s10 = p10.getService(id2.type, id2.algorithm);
                        if (s10 != null) {
                            addService(s10);
                        }
                    }
                }
            }
        }

        @Override // java.util.AbstractList, java.util.List
        public Provider.Service get(int index) {
            Provider.Service s2 = tryGet(index);
            if (s2 == null) {
                throw new IndexOutOfBoundsException();
            }
            return s2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int n10;
            List<Provider.Service> list = this.services;
            if (list != null) {
                n10 = list.size();
            } else {
                n10 = this.firstService != null ? 1 : 0;
            }
            while (tryGet(n10) != null) {
                n10++;
            }
            return n10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return tryGet(0) == null;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Provider.Service> iterator2() {
            return new Iterator<Provider.Service>() { // from class: sun.security.jca.ProviderList.ServiceList.1
                int index;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return ServiceList.this.tryGet(this.index) != null;
                }

                @Override // java.util.Iterator
                public Provider.Service next() {
                    Provider.Service s2 = ServiceList.this.tryGet(this.index);
                    if (s2 == null) {
                        throw new NoSuchElementException();
                    }
                    this.index++;
                    return s2;
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }
    }
}
