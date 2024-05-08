package java.security;

import com.alibaba.security.realidentity.build.cg;
import com.huawei.openalliance.ad.constant.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.apache.commons.io.IOUtils;
import sun.security.pkcs.PKCS9Attribute;
import sun.security.util.Debug;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Provider extends Properties {
    private static final String ALIAS_PREFIX_LOWER = "alg.alias.";
    private static volatile ServiceKey previousKey = null;
    static final long serialVersionUID = -4298000515446427739L;
    private String info;
    private transient boolean initialized;
    private transient boolean legacyChanged;
    private transient Map<ServiceKey, Service> legacyMap;
    private transient Map<String, String> legacyStrings;
    private String name;
    private transient Map<ServiceKey, Service> serviceMap;
    private transient Set<Service> serviceSet;
    private transient boolean servicesChanged;
    private double version;
    private static final Debug debug = Debug.getInstance("provider", "Provider");
    private static final String ALIAS_PREFIX = "Alg.Alias.";
    private static final int ALIAS_LENGTH = ALIAS_PREFIX.length();
    private static final Map<String, EngineDescription> knownEngines = new HashMap();
    private volatile boolean registered = false;
    private transient Set<Map.Entry<Object, Object>> entrySet = null;
    private transient int entrySetCallCount = 0;

    static {
        String str = "";
        previousKey = new ServiceKey(str, str, false);
        addEngine("AlgorithmParameterGenerator", false, null);
        addEngine("AlgorithmParameters", false, null);
        addEngine("KeyFactory", false, null);
        addEngine("KeyPairGenerator", false, null);
        addEngine("KeyStore", false, null);
        addEngine(PKCS9Attribute.MESSAGE_DIGEST_STR, false, null);
        addEngine("SecureRandom", false, null);
        addEngine(cg.f3335y, true, null);
        addEngine("CertificateFactory", false, null);
        addEngine("CertPathBuilder", false, null);
        addEngine("CertPathValidator", false, null);
        addEngine("CertStore", false, "java.security.cert.CertStoreParameters");
        addEngine("Cipher", true, null);
        addEngine("ExemptionMechanism", false, null);
        addEngine("Mac", true, null);
        addEngine("KeyAgreement", true, null);
        addEngine("KeyGenerator", false, null);
        addEngine("SecretKeyFactory", false, null);
        addEngine("KeyManagerFactory", false, null);
        addEngine("SSLContext", false, null);
        addEngine("TrustManagerFactory", false, null);
        addEngine("GssApiMechanism", false, null);
        addEngine("SaslClientFactory", false, null);
        addEngine("SaslServerFactory", false, null);
        addEngine("Policy", false, "java.security.Policy$Parameters");
        addEngine("Configuration", false, "javax.security.auth.login.Configuration$Parameters");
        addEngine("XMLSignatureFactory", false, null);
        addEngine("KeyInfoFactory", false, null);
        addEngine("TransformService", false, null);
        addEngine("TerminalFactory", false, "java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Provider(String name, double version, String info) {
        this.name = name;
        this.version = version;
        this.info = info;
        putId();
        this.initialized = true;
    }

    public String getName() {
        return this.name;
    }

    public double getVersion() {
        return this.version;
    }

    public String getInfo() {
        return this.info;
    }

    @Override // java.util.Hashtable
    public String toString() {
        return this.name + " version " + this.version;
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized void clear() {
        check("clearProviderProperties." + this.name);
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("Remove " + this.name + " provider properties");
        }
        implClear();
    }

    @Override // java.util.Properties
    public synchronized void load(InputStream inStream) throws IOException {
        check("putProviderProperty." + this.name);
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("Load " + this.name + " provider properties");
        }
        Properties tempProperties = new Properties();
        tempProperties.load(inStream);
        implPutAll(tempProperties);
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized void putAll(Map<?, ?> t2) {
        check("putProviderProperty." + this.name);
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("Put all " + this.name + " provider properties");
        }
        implPutAll(t2);
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized Set<Map.Entry<Object, Object>> entrySet() {
        checkInitialized();
        if (this.entrySet == null) {
            int i10 = this.entrySetCallCount;
            this.entrySetCallCount = i10 + 1;
            if (i10 == 0) {
                this.entrySet = Collections.unmodifiableMap(this).entrySet();
            } else {
                return super.entrySet();
            }
        }
        if (this.entrySetCallCount != 2) {
            throw new RuntimeException("Internal error.");
        }
        return this.entrySet;
    }

    @Override // java.util.Hashtable, java.util.Map
    /* renamed from: keySet */
    public Set<Object> h() {
        checkInitialized();
        return Collections.unmodifiableSet(super.h());
    }

    @Override // java.util.Hashtable, java.util.Map
    public Collection<Object> values() {
        checkInitialized();
        return Collections.unmodifiableCollection(super.values());
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public synchronized Object put(Object key, Object value) {
        check("putProviderProperty." + this.name);
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("Set " + this.name + " provider property [" + key + "/" + value + "]");
        }
        return implPut(key, value);
    }

    @Override // java.util.Hashtable, java.util.Map, java.util.concurrent.ConcurrentMap
    public synchronized Object putIfAbsent(Object key, Object value) {
        check("putProviderProperty." + this.name);
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("Set " + this.name + " provider property [" + key + "/" + value + "]");
        }
        return implPutIfAbsent(key, value);
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public synchronized Object remove(Object key) {
        check("removeProviderProperty." + this.name);
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("Remove " + this.name + " provider property " + key);
        }
        return implRemove(key);
    }

    @Override // java.util.Hashtable, java.util.Map, java.util.concurrent.ConcurrentMap
    public synchronized boolean remove(Object key, Object value) {
        check("removeProviderProperty." + this.name);
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("Remove " + this.name + " provider property " + key);
        }
        return implRemove(key, value);
    }

    @Override // java.util.Hashtable, java.util.Map, java.util.concurrent.ConcurrentMap
    public synchronized boolean replace(Object key, Object oldValue, Object newValue) {
        check("putProviderProperty." + this.name);
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("Replace " + this.name + " provider property " + key);
        }
        return implReplace(key, oldValue, newValue);
    }

    @Override // java.util.Hashtable, java.util.Map, java.util.concurrent.ConcurrentMap
    public synchronized Object replace(Object key, Object value) {
        check("putProviderProperty." + this.name);
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("Replace " + this.name + " provider property " + key);
        }
        return implReplace(key, value);
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized void replaceAll(BiFunction<? super Object, ? super Object, ? extends Object> function) {
        check("putProviderProperty." + this.name);
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("ReplaceAll " + this.name + " provider property ");
        }
        implReplaceAll(function);
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized Object compute(Object key, BiFunction<? super Object, ? super Object, ? extends Object> remappingFunction) {
        check("putProviderProperty." + this.name);
        check("removeProviderProperty" + this.name);
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("Compute " + this.name + " provider property " + key);
        }
        return implCompute(key, remappingFunction);
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized Object computeIfAbsent(Object key, Function<? super Object, ? extends Object> mappingFunction) {
        check("putProviderProperty." + this.name);
        check("removeProviderProperty" + this.name);
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("ComputeIfAbsent " + this.name + " provider property " + key);
        }
        return implComputeIfAbsent(key, mappingFunction);
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized Object computeIfPresent(Object key, BiFunction<? super Object, ? super Object, ? extends Object> remappingFunction) {
        check("putProviderProperty." + this.name);
        check("removeProviderProperty" + this.name);
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("ComputeIfPresent " + this.name + " provider property " + key);
        }
        return implComputeIfPresent(key, remappingFunction);
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized Object merge(Object key, Object value, BiFunction<? super Object, ? super Object, ? extends Object> remappingFunction) {
        check("putProviderProperty." + this.name);
        check("removeProviderProperty" + this.name);
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("Merge " + this.name + " provider property " + key);
        }
        return implMerge(key, value, remappingFunction);
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public Object get(Object key) {
        checkInitialized();
        return super.get(key);
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized Object getOrDefault(Object key, Object defaultValue) {
        checkInitialized();
        return super.getOrDefault(key, defaultValue);
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized void forEach(BiConsumer<? super Object, ? super Object> action) {
        checkInitialized();
        super.forEach(action);
    }

    @Override // java.util.Hashtable, java.util.Dictionary
    public Enumeration<Object> keys() {
        checkInitialized();
        return super.keys();
    }

    @Override // java.util.Hashtable, java.util.Dictionary
    public Enumeration<Object> elements() {
        checkInitialized();
        return super.elements();
    }

    @Override // java.util.Properties
    public String getProperty(String key) {
        checkInitialized();
        return super.getProperty(key);
    }

    private void checkInitialized() {
        if (!this.initialized) {
            throw new IllegalStateException();
        }
    }

    private void check(String directive) {
        checkInitialized();
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkSecurityAccess(directive);
        }
    }

    private void putId() {
        super.put("Provider.id name", String.valueOf(this.name));
        super.put("Provider.id version", String.valueOf(this.version));
        super.put("Provider.id info", String.valueOf(this.info));
        super.put("Provider.id className", getClass().getName());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.registered = false;
        Map<Object, Object> copy = new HashMap<>();
        for (Map.Entry<Object, Object> entry : super.entrySet()) {
            copy.put(entry.getKey(), entry.getValue());
        }
        this.defaults = null;
        in.defaultReadObject();
        implClear();
        this.initialized = true;
        putAll(copy);
    }

    private boolean checkLegacy(Object key) {
        if (this.registered) {
            Security.increaseVersion();
        }
        String keyString = (String) key;
        if (keyString.startsWith("Provider.")) {
            return false;
        }
        this.legacyChanged = true;
        if (this.legacyStrings == null) {
            this.legacyStrings = new LinkedHashMap();
        }
        return true;
    }

    private void implPutAll(Map<?, ?> t2) {
        for (Map.Entry<?, ?> e2 : t2.entrySet()) {
            implPut(e2.getKey(), e2.getValue());
        }
        if (this.registered) {
            Security.increaseVersion();
        }
    }

    private Object implRemove(Object key) {
        if (key instanceof String) {
            if (!checkLegacy(key)) {
                return null;
            }
            this.legacyStrings.remove((String) key);
        }
        return super.remove(key);
    }

    private boolean implRemove(Object key, Object value) {
        if ((key instanceof String) && (value instanceof String)) {
            if (!checkLegacy(key)) {
                return false;
            }
            this.legacyStrings.remove((String) key, value);
        }
        return super.remove(key, value);
    }

    private boolean implReplace(Object key, Object oldValue, Object newValue) {
        if ((key instanceof String) && (oldValue instanceof String) && (newValue instanceof String)) {
            if (!checkLegacy(key)) {
                return false;
            }
            this.legacyStrings.replace((String) key, (String) oldValue, (String) newValue);
        }
        return super.replace(key, oldValue, newValue);
    }

    private Object implReplace(Object key, Object value) {
        if ((key instanceof String) && (value instanceof String)) {
            if (!checkLegacy(key)) {
                return null;
            }
            this.legacyStrings.replace((String) key, (String) value);
        }
        return super.replace(key, value);
    }

    private void implReplaceAll(BiFunction<? super Object, ? super Object, ? extends Object> function) {
        this.legacyChanged = true;
        Map<String, String> map = this.legacyStrings;
        if (map == null) {
            this.legacyStrings = new LinkedHashMap();
        } else {
            map.replaceAll(function);
        }
        super.replaceAll(function);
    }

    private Object implMerge(Object key, Object value, BiFunction<? super Object, ? super Object, ? extends Object> remappingFunction) {
        if ((key instanceof String) && (value instanceof String)) {
            if (!checkLegacy(key)) {
                return null;
            }
            this.legacyStrings.merge((String) key, (String) value, remappingFunction);
        }
        return super.merge(key, value, remappingFunction);
    }

    private Object implCompute(Object key, BiFunction<? super Object, ? super Object, ? extends Object> remappingFunction) {
        if (key instanceof String) {
            if (!checkLegacy(key)) {
                return null;
            }
            this.legacyStrings.compute((String) key, remappingFunction);
        }
        return super.compute(key, remappingFunction);
    }

    private Object implComputeIfAbsent(Object key, Function<? super Object, ? extends Object> mappingFunction) {
        if (key instanceof String) {
            if (!checkLegacy(key)) {
                return null;
            }
            this.legacyStrings.computeIfAbsent((String) key, mappingFunction);
        }
        return super.computeIfAbsent(key, mappingFunction);
    }

    private Object implComputeIfPresent(Object key, BiFunction<? super Object, ? super Object, ? extends Object> remappingFunction) {
        if (key instanceof String) {
            if (!checkLegacy(key)) {
                return null;
            }
            this.legacyStrings.computeIfPresent((String) key, remappingFunction);
        }
        return super.computeIfPresent(key, remappingFunction);
    }

    private Object implPut(Object key, Object value) {
        if ((key instanceof String) && (value instanceof String)) {
            if (!checkLegacy(key)) {
                return null;
            }
            this.legacyStrings.put((String) key, (String) value);
        }
        return super.put(key, value);
    }

    private Object implPutIfAbsent(Object key, Object value) {
        if ((key instanceof String) && (value instanceof String)) {
            if (!checkLegacy(key)) {
                return null;
            }
            this.legacyStrings.putIfAbsent((String) key, (String) value);
        }
        return super.putIfAbsent(key, value);
    }

    private void implClear() {
        Map<String, String> map = this.legacyStrings;
        if (map != null) {
            map.clear();
        }
        Map<ServiceKey, Service> map2 = this.legacyMap;
        if (map2 != null) {
            map2.clear();
        }
        Map<ServiceKey, Service> map3 = this.serviceMap;
        if (map3 != null) {
            map3.clear();
        }
        this.legacyChanged = false;
        this.servicesChanged = false;
        this.serviceSet = null;
        super.clear();
        putId();
        if (this.registered) {
            Security.increaseVersion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ServiceKey {
        private final String algorithm;
        private final String originalAlgorithm;
        private final String type;

        private ServiceKey(String type, String algorithm, boolean intern) {
            this.type = type;
            this.originalAlgorithm = algorithm;
            String algorithm2 = algorithm.toUpperCase(Locale.ENGLISH);
            this.algorithm = intern ? algorithm2.intern() : algorithm2;
        }

        public int hashCode() {
            return this.type.hashCode() + this.algorithm.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ServiceKey)) {
                return false;
            }
            ServiceKey other = (ServiceKey) obj;
            return this.type.equals(other.type) && this.algorithm.equals(other.algorithm);
        }

        boolean matches(String type, String algorithm) {
            return this.type == type && this.originalAlgorithm == algorithm;
        }
    }

    private void ensureLegacyParsed() {
        if (!this.legacyChanged || this.legacyStrings == null) {
            return;
        }
        this.serviceSet = null;
        Map<ServiceKey, Service> map = this.legacyMap;
        if (map == null) {
            this.legacyMap = new LinkedHashMap();
        } else {
            map.clear();
        }
        for (Map.Entry<String, String> entry : this.legacyStrings.entrySet()) {
            parseLegacyPut(entry.getKey(), entry.getValue());
        }
        removeInvalidServices(this.legacyMap);
        this.legacyChanged = false;
    }

    private void removeInvalidServices(Map<ServiceKey, Service> map) {
        Iterator<Map.Entry<ServiceKey, Service>> t2 = map.entrySet().iterator2();
        while (t2.hasNext()) {
            Service s2 = t2.next().getValue();
            if (!s2.isValid()) {
                t2.remove();
            }
        }
    }

    private String[] getTypeAndAlgorithm(String key) {
        int i10 = key.indexOf(".");
        if (i10 < 1) {
            Debug debug2 = debug;
            if (debug2 != null) {
                debug2.println("Ignoring invalid entry in provider " + this.name + u.bD + key);
                return null;
            }
            return null;
        }
        String type = key.substring(0, i10);
        String alg = key.substring(i10 + 1);
        return new String[]{type, alg};
    }

    private void parseLegacyPut(String str, String str2) {
        byte b4 = 0;
        byte b10 = 0;
        byte b11 = 0;
        byte b12 = 0;
        byte b13 = 0;
        byte b14 = 0;
        boolean z10 = true;
        if (str.toLowerCase(Locale.ENGLISH).startsWith(ALIAS_PREFIX_LOWER)) {
            String[] typeAndAlgorithm = getTypeAndAlgorithm(str.substring(ALIAS_LENGTH));
            if (typeAndAlgorithm == null) {
                return;
            }
            String engineName = getEngineName(typeAndAlgorithm[0]);
            String intern = typeAndAlgorithm[1].intern();
            ServiceKey serviceKey = new ServiceKey(engineName, str2, z10);
            Service service = this.legacyMap.get(serviceKey);
            if (service == null) {
                service = new Service();
                service.type = engineName;
                service.algorithm = str2;
                this.legacyMap.put(serviceKey, service);
            }
            this.legacyMap.put(new ServiceKey(engineName, intern, z10), service);
            service.addAlias(intern);
            return;
        }
        String[] typeAndAlgorithm2 = getTypeAndAlgorithm(str);
        if (typeAndAlgorithm2 == null) {
            return;
        }
        int indexOf = typeAndAlgorithm2[1].indexOf(32);
        if (indexOf == -1) {
            String engineName2 = getEngineName(typeAndAlgorithm2[0]);
            String intern2 = typeAndAlgorithm2[1].intern();
            ServiceKey serviceKey2 = new ServiceKey(engineName2, intern2, z10);
            Service service2 = this.legacyMap.get(serviceKey2);
            if (service2 == null) {
                service2 = new Service();
                service2.type = engineName2;
                service2.algorithm = intern2;
                this.legacyMap.put(serviceKey2, service2);
            }
            service2.className = str2;
            return;
        }
        String engineName3 = getEngineName(typeAndAlgorithm2[0]);
        String str3 = typeAndAlgorithm2[1];
        String intern3 = str3.substring(0, indexOf).intern();
        String substring = str3.substring(indexOf + 1);
        while (substring.startsWith(" ")) {
            substring = substring.substring(1);
        }
        String intern4 = substring.intern();
        ServiceKey serviceKey3 = new ServiceKey(engineName3, intern3, z10);
        Service service3 = this.legacyMap.get(serviceKey3);
        if (service3 == null) {
            service3 = new Service();
            service3.type = engineName3;
            service3.algorithm = intern3;
            this.legacyMap.put(serviceKey3, service3);
        }
        service3.addAttribute(intern4, str2);
    }

    public synchronized Service getService(String str, String str2) {
        Service service;
        checkInitialized();
        ServiceKey serviceKey = previousKey;
        byte b4 = 0;
        if (!serviceKey.matches(str, str2)) {
            serviceKey = new ServiceKey(str, str2, false);
            previousKey = serviceKey;
        }
        Map<ServiceKey, Service> map = this.serviceMap;
        if (map != null && (service = map.get(serviceKey)) != null) {
            return service;
        }
        ensureLegacyParsed();
        Map<ServiceKey, Service> map2 = this.legacyMap;
        return map2 != null ? map2.get(serviceKey) : null;
    }

    public synchronized Set<Service> getServices() {
        checkInitialized();
        if (this.legacyChanged || this.servicesChanged) {
            this.serviceSet = null;
        }
        if (this.serviceSet == null) {
            ensureLegacyParsed();
            Set<Service> set = new LinkedHashSet<>();
            Map<ServiceKey, Service> map = this.serviceMap;
            if (map != null) {
                set.addAll(map.values());
            }
            Map<ServiceKey, Service> map2 = this.legacyMap;
            if (map2 != null) {
                set.addAll(map2.values());
            }
            this.serviceSet = Collections.unmodifiableSet(set);
            this.servicesChanged = false;
        }
        return this.serviceSet;
    }

    protected synchronized void putService(Service s2) {
        check("putProviderProperty." + this.name);
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println(this.name + ".putService(): " + ((Object) s2));
        }
        if (s2 == null) {
            throw new NullPointerException();
        }
        if (s2.getProvider() != this) {
            throw new IllegalArgumentException("service.getProvider() must match this Provider object");
        }
        if (this.serviceMap == null) {
            this.serviceMap = new LinkedHashMap();
        }
        boolean z10 = true;
        this.servicesChanged = true;
        String type = s2.getType();
        String algorithm = s2.getAlgorithm();
        ServiceKey key = new ServiceKey(type, algorithm, z10);
        implRemoveService(this.serviceMap.get(key));
        this.serviceMap.put(key, s2);
        for (String alias : s2.getAliases()) {
            this.serviceMap.put(new ServiceKey(type, alias, z10), s2);
        }
        putPropertyStrings(s2);
    }

    private void putPropertyStrings(Service s2) {
        String type = s2.getType();
        String algorithm = s2.getAlgorithm();
        super.put(type + "." + algorithm, s2.getClassName());
        for (String alias : s2.getAliases()) {
            super.put(ALIAS_PREFIX + type + "." + alias, algorithm);
        }
        for (Map.Entry<UString, String> entry : s2.attributes.entrySet()) {
            String key = type + "." + algorithm + " " + ((Object) entry.getKey());
            super.put(key, entry.getValue());
        }
        if (this.registered) {
            Security.increaseVersion();
        }
    }

    private void removePropertyStrings(Service s2) {
        String type = s2.getType();
        String algorithm = s2.getAlgorithm();
        super.remove(type + "." + algorithm);
        for (String alias : s2.getAliases()) {
            super.remove(ALIAS_PREFIX + type + "." + alias);
        }
        for (Map.Entry<UString, String> entry : s2.attributes.entrySet()) {
            String key = type + "." + algorithm + " " + ((Object) entry.getKey());
            super.remove(key);
        }
        if (this.registered) {
            Security.increaseVersion();
        }
    }

    protected synchronized void removeService(Service s2) {
        check("removeProviderProperty." + this.name);
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println(this.name + ".removeService(): " + ((Object) s2));
        }
        if (s2 == null) {
            throw new NullPointerException();
        }
        implRemoveService(s2);
    }

    private void implRemoveService(Service s2) {
        if (s2 == null || this.serviceMap == null) {
            return;
        }
        String type = s2.getType();
        String algorithm = s2.getAlgorithm();
        boolean z10 = false;
        ServiceKey key = new ServiceKey(type, algorithm, z10);
        Service oldService = this.serviceMap.get(key);
        if (s2 != oldService) {
            return;
        }
        this.servicesChanged = true;
        this.serviceMap.remove(key);
        for (String alias : s2.getAliases()) {
            this.serviceMap.remove(new ServiceKey(type, alias, z10));
        }
        removePropertyStrings(s2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class UString {
        final String lowerString;
        final String string;

        UString(String s2) {
            this.string = s2;
            this.lowerString = s2.toLowerCase(Locale.ENGLISH);
        }

        public int hashCode() {
            return this.lowerString.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UString)) {
                return false;
            }
            UString other = (UString) obj;
            return this.lowerString.equals(other.lowerString);
        }

        public String toString() {
            return this.string;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class EngineDescription {
        private volatile Class<?> constructorParameterClass;
        final String constructorParameterClassName;
        final String name;
        final boolean supportsParameter;

        EngineDescription(String name, boolean sp, String paramName) {
            this.name = name;
            this.supportsParameter = sp;
            this.constructorParameterClassName = paramName;
        }

        Class<?> getConstructorParameterClass() throws ClassNotFoundException {
            Class<?> clazz = this.constructorParameterClass;
            if (clazz == null) {
                Class<?> clazz2 = Class.forName(this.constructorParameterClassName);
                this.constructorParameterClass = clazz2;
                return clazz2;
            }
            return clazz;
        }
    }

    private static void addEngine(String name, boolean sp, String paramName) {
        EngineDescription ed2 = new EngineDescription(name, sp, paramName);
        Map<String, EngineDescription> map = knownEngines;
        map.put(name.toLowerCase(Locale.ENGLISH), ed2);
        map.put(name, ed2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getEngineName(String s2) {
        Map<String, EngineDescription> map = knownEngines;
        EngineDescription e2 = map.get(s2);
        if (e2 == null) {
            e2 = map.get(s2.toLowerCase(Locale.ENGLISH));
        }
        return e2 == null ? s2 : e2.name;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Service {
        private static final Class<?>[] CLASS0 = new Class[0];
        private String algorithm;
        private List<String> aliases;
        private Map<UString, String> attributes;
        private String className;
        private volatile Reference<Class<?>> classRef;
        private volatile Boolean hasKeyAttributes;
        private final Provider provider;
        private boolean registered;
        private Class[] supportedClasses;
        private String[] supportedFormats;
        private String type;

        private Service(Provider provider) {
            this.provider = provider;
            this.aliases = Collections.emptyList();
            this.attributes = Collections.emptyMap();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isValid() {
            return (this.type == null || this.algorithm == null || this.className == null) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAlias(String alias) {
            if (this.aliases.isEmpty()) {
                this.aliases = new ArrayList(2);
            }
            this.aliases.add(alias);
        }

        void addAttribute(String type, String value) {
            if (this.attributes.isEmpty()) {
                this.attributes = new HashMap(8);
            }
            this.attributes.put(new UString(type), value);
        }

        public Service(Provider provider, String type, String algorithm, String className, List<String> aliases, Map<String, String> attributes) {
            if (provider == null || type == null || algorithm == null || className == null) {
                throw new NullPointerException();
            }
            this.provider = provider;
            this.type = Provider.getEngineName(type);
            this.algorithm = algorithm;
            this.className = className;
            if (aliases == null) {
                this.aliases = Collections.emptyList();
            } else {
                this.aliases = new ArrayList(aliases);
            }
            if (attributes == null) {
                this.attributes = Collections.emptyMap();
                return;
            }
            this.attributes = new HashMap();
            for (Map.Entry<String, String> entry : attributes.entrySet()) {
                this.attributes.put(new UString(entry.getKey()), entry.getValue());
            }
        }

        public final String getType() {
            return this.type;
        }

        public final String getAlgorithm() {
            return this.algorithm;
        }

        public final Provider getProvider() {
            return this.provider;
        }

        public final String getClassName() {
            return this.className;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<String> getAliases() {
            return this.aliases;
        }

        public final String getAttribute(String name) {
            if (name == null) {
                throw new NullPointerException();
            }
            return this.attributes.get(new UString(name));
        }

        public Object newInstance(Object constructorParameter) throws NoSuchAlgorithmException {
            if (!this.registered) {
                if (this.provider.getService(this.type, this.algorithm) != this) {
                    throw new NoSuchAlgorithmException("Service not registered with Provider " + this.provider.getName() + ": " + ((Object) this));
                }
                this.registered = true;
            }
            try {
                EngineDescription cap = (EngineDescription) Provider.knownEngines.get(this.type);
                if (cap == null) {
                    return newInstanceGeneric(constructorParameter);
                }
                if (cap.constructorParameterClassName == null) {
                    if (constructorParameter != null) {
                        throw new InvalidParameterException("constructorParameter not used with " + this.type + " engines");
                    }
                    Class<?> clazz = getImplClass();
                    Class<?>[] empty = new Class[0];
                    Constructor<?> con = clazz.getConstructor(empty);
                    return con.newInstance(new Object[0]);
                }
                Class<?> paramClass = cap.getConstructorParameterClass();
                if (constructorParameter != null) {
                    Class<?> argClass = constructorParameter.getClass();
                    if (!paramClass.isAssignableFrom(argClass)) {
                        throw new InvalidParameterException("constructorParameter must be instanceof " + cap.constructorParameterClassName.replace('$', '.') + " for engine type " + this.type);
                    }
                }
                Class<?> clazz2 = getImplClass();
                Constructor<?> cons = clazz2.getConstructor(paramClass);
                return cons.newInstance(constructorParameter);
            } catch (InvocationTargetException e2) {
                throw new NoSuchAlgorithmException("Error constructing implementation (algorithm: " + this.algorithm + ", provider: " + this.provider.getName() + ", class: " + this.className + ")", e2.getCause());
            } catch (NoSuchAlgorithmException e10) {
                throw e10;
            } catch (Exception e11) {
                throw new NoSuchAlgorithmException("Error constructing implementation (algorithm: " + this.algorithm + ", provider: " + this.provider.getName() + ", class: " + this.className + ")", e11);
            }
        }

        private Class<?> getImplClass() throws NoSuchAlgorithmException {
            try {
                Reference<Class<?>> ref = this.classRef;
                Class<?> clazz = ref == null ? null : ref.get();
                if (clazz == null) {
                    ClassLoader cl = this.provider.getClass().getClassLoader();
                    if (cl == null) {
                        clazz = Class.forName(this.className);
                    } else {
                        clazz = cl.loadClass(this.className);
                    }
                    if (!Modifier.isPublic(clazz.getModifiers())) {
                        throw new NoSuchAlgorithmException("class configured for " + this.type + " (provider: " + this.provider.getName() + ") is not public.");
                    }
                    this.classRef = new WeakReference(clazz);
                }
                return clazz;
            } catch (ClassNotFoundException e2) {
                throw new NoSuchAlgorithmException("class configured for " + this.type + " (provider: " + this.provider.getName() + ") cannot be found.", e2);
            }
        }

        private Object newInstanceGeneric(Object constructorParameter) throws Exception {
            Class<?> clazz = getImplClass();
            if (constructorParameter == null) {
                try {
                    Class<?>[] empty = new Class[0];
                    return clazz.getConstructor(empty).newInstance(new Object[0]);
                } catch (NoSuchMethodException e2) {
                    throw new NoSuchAlgorithmException("No public no-arg constructor found in class " + this.className);
                }
            }
            Class<?> argClass = constructorParameter.getClass();
            Constructor<?>[] cons = clazz.getConstructors();
            for (Constructor<?> con : cons) {
                Class<?>[] paramTypes = con.getParameterTypes();
                if (paramTypes.length == 1 && paramTypes[0].isAssignableFrom(argClass)) {
                    return con.newInstance(constructorParameter);
                }
            }
            throw new NoSuchAlgorithmException("No public constructor matching " + argClass.getName() + " found in class " + this.className);
        }

        public boolean supportsParameter(Object parameter) {
            EngineDescription cap = (EngineDescription) Provider.knownEngines.get(this.type);
            if (cap == null) {
                return true;
            }
            if (!cap.supportsParameter) {
                throw new InvalidParameterException("supportsParameter() not used with " + this.type + " engines");
            }
            if (parameter != null && !(parameter instanceof Key)) {
                throw new InvalidParameterException("Parameter must be instanceof Key for engine " + this.type);
            }
            if (!hasKeyAttributes()) {
                return true;
            }
            if (parameter == null) {
                return false;
            }
            Key key = (Key) parameter;
            if (supportsKeyFormat(key) || supportsKeyClass(key)) {
                return true;
            }
            return false;
        }

        private boolean hasKeyAttributes() {
            Boolean b4 = this.hasKeyAttributes;
            if (b4 == null) {
                synchronized (this) {
                    String s2 = getAttribute("SupportedKeyFormats");
                    if (s2 != null) {
                        this.supportedFormats = s2.split("\\|");
                    }
                    String s10 = getAttribute("SupportedKeyClasses");
                    if (s10 != null) {
                        String[] classNames = s10.split("\\|");
                        List<Class<?>> classList = new ArrayList<>(classNames.length);
                        for (String className : classNames) {
                            Class<?> clazz = getKeyClass(className);
                            if (clazz != null) {
                                classList.add(clazz);
                            }
                        }
                        this.supportedClasses = (Class[]) classList.toArray(CLASS0);
                    }
                    boolean bool = (this.supportedFormats == null && this.supportedClasses == null) ? false : true;
                    b4 = Boolean.valueOf(bool);
                    this.hasKeyAttributes = b4;
                }
            }
            return b4.booleanValue();
        }

        private Class<?> getKeyClass(String name) {
            try {
                return Class.forName(name);
            } catch (ClassNotFoundException e2) {
                try {
                    ClassLoader cl = this.provider.getClass().getClassLoader();
                    if (cl != null) {
                        return cl.loadClass(name);
                    }
                    return null;
                } catch (ClassNotFoundException e10) {
                    return null;
                }
            }
        }

        private boolean supportsKeyFormat(Key key) {
            String format;
            if (this.supportedFormats == null || (format = key.getFormat()) == null) {
                return false;
            }
            for (String supportedFormat : this.supportedFormats) {
                if (format.equals(supportedFormat)) {
                    return true;
                }
            }
            return false;
        }

        private boolean supportsKeyClass(Key key) {
            if (this.supportedClasses == null) {
                return false;
            }
            Class<?> keyClass = key.getClass();
            for (Class<?> clazz : this.supportedClasses) {
                if (clazz.isAssignableFrom(keyClass)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            String aString = this.aliases.isEmpty() ? "" : "\r\n  aliases: " + this.aliases.toString();
            String attrs = this.attributes.isEmpty() ? "" : "\r\n  attributes: " + this.attributes.toString();
            return this.provider.getName() + ": " + this.type + "." + this.algorithm + " -> " + this.className + aString + attrs + IOUtils.LINE_SEPARATOR_WINDOWS;
        }
    }

    public void setRegistered() {
        this.registered = true;
    }

    public void setUnregistered() {
        this.registered = false;
    }

    public boolean isRegistered() {
        return this.registered;
    }

    public synchronized void warmUpServiceProvision() {
        checkInitialized();
        ensureLegacyParsed();
        getServices();
    }
}
