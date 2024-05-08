package java.time.zone;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class ZoneRulesProvider {
    private static final CopyOnWriteArrayList<ZoneRulesProvider> PROVIDERS = new CopyOnWriteArrayList<>();
    private static final ConcurrentMap<String, ZoneRulesProvider> ZONES = new ConcurrentHashMap(512, 0.75f, 2);
    private static volatile Set<String> ZONE_IDS;

    protected abstract ZoneRules provideRules(String str, boolean z10);

    protected abstract NavigableMap<String, ZoneRules> provideVersions(String str);

    protected abstract Set<String> provideZoneIds();

    static {
        ZoneRulesProvider provider = new IcuZoneRulesProvider();
        registerProvider(provider);
    }

    public static Set<String> getAvailableZoneIds() {
        return ZONE_IDS;
    }

    public static ZoneRules getRules(String zoneId, boolean forCaching) {
        Objects.requireNonNull(zoneId, "zoneId");
        return getProvider(zoneId).provideRules(zoneId, forCaching);
    }

    public static NavigableMap<String, ZoneRules> getVersions(String zoneId) {
        Objects.requireNonNull(zoneId, "zoneId");
        return getProvider(zoneId).provideVersions(zoneId);
    }

    private static ZoneRulesProvider getProvider(String zoneId) {
        ConcurrentMap<String, ZoneRulesProvider> concurrentMap = ZONES;
        ZoneRulesProvider provider = concurrentMap.get(zoneId);
        if (provider == null) {
            if (concurrentMap.isEmpty()) {
                throw new ZoneRulesException("No time-zone data files registered");
            }
            throw new ZoneRulesException("Unknown time-zone ID: " + zoneId);
        }
        return provider;
    }

    public static void registerProvider(ZoneRulesProvider provider) {
        Objects.requireNonNull(provider, "provider");
        registerProvider0(provider);
        PROVIDERS.add(provider);
    }

    private static synchronized void registerProvider0(ZoneRulesProvider provider) {
        synchronized (ZoneRulesProvider.class) {
            for (String zoneId : provider.provideZoneIds()) {
                Objects.requireNonNull(zoneId, "zoneId");
                ZoneRulesProvider old = ZONES.putIfAbsent(zoneId, provider);
                if (old != null) {
                    throw new ZoneRulesException("Unable to register zone as one already registered with that ID: " + zoneId + ", currently loading from provider: " + ((Object) provider));
                }
            }
            Set<String> combinedSet = new HashSet<>(ZONES.h());
            ZONE_IDS = Collections.unmodifiableSet(combinedSet);
        }
    }

    public static boolean refresh() {
        boolean changed = false;
        Iterator<ZoneRulesProvider> iterator2 = PROVIDERS.iterator2();
        while (iterator2.hasNext()) {
            ZoneRulesProvider provider = iterator2.next();
            changed |= provider.provideRefresh();
        }
        return changed;
    }

    protected boolean provideRefresh() {
        return false;
    }
}
