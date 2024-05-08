package java.time.zone;

import android.icu.util.TimeZone;
import com.android.icu.util.ExtendedTimeZone;
import java.util.Collections;
import java.util.HashSet;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;
import libcore.util.BasicLruCache;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class IcuZoneRulesProvider extends ZoneRulesProvider {
    private final BasicLruCache<String, ZoneRules> cache = new ZoneRulesCache(8);

    @Override // java.time.zone.ZoneRulesProvider
    protected Set<String> provideZoneIds() {
        Set<String> zoneIds = new HashSet<>(TimeZone.getAvailableIDs(TimeZone.SystemTimeZoneType.ANY, null, null));
        zoneIds.remove("GMT+0");
        zoneIds.remove("GMT-0");
        return zoneIds;
    }

    @Override // java.time.zone.ZoneRulesProvider
    protected ZoneRules provideRules(String zoneId, boolean forCaching) {
        return (ZoneRules) this.cache.get(zoneId);
    }

    @Override // java.time.zone.ZoneRulesProvider
    protected NavigableMap<String, ZoneRules> provideVersions(String zoneId) {
        return new TreeMap(Collections.singletonMap(TimeZone.getTZDataVersion(), provideRules(zoneId, false)));
    }

    static ZoneRules generateZoneRules(String zoneId) {
        return ExtendedTimeZone.getInstance(zoneId).createZoneRules();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class ZoneRulesCache extends BasicLruCache<String, ZoneRules> {
        ZoneRulesCache(int maxSize) {
            super(maxSize);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public ZoneRules create(String zoneId) {
            String canonicalId = TimeZone.getCanonicalID(zoneId);
            if (!canonicalId.equals(zoneId)) {
                return (ZoneRules) get(canonicalId);
            }
            return IcuZoneRulesProvider.generateZoneRules(zoneId);
        }
    }
}
