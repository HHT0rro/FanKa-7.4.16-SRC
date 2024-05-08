package java.time.format;

import android.icu.text.TimeZoneNames;
import android.icu.util.TimeZone;
import android.icu.util.ULocale;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class ZoneName {
    ZoneName() {
    }

    public static String toZid(String zid, Locale locale) {
        TimeZoneNames tzNames = TimeZoneNames.getInstance(locale);
        if (tzNames.getAvailableMetaZoneIDs().contains(zid)) {
            ULocale uLocale = ULocale.forLocale(locale);
            String region = uLocale.getCountry();
            if (region.length() == 0) {
                region = ULocale.addLikelySubtags(uLocale).getCountry();
            }
            zid = tzNames.getReferenceZoneID(zid, region);
        }
        return toZid(zid);
    }

    public static String toZid(String zid) {
        String canonicalCldrId = getSystemCanonicalID(zid);
        if (canonicalCldrId != null) {
            return canonicalCldrId;
        }
        return zid;
    }

    public static String getSystemCanonicalID(String zid) {
        if ("Etc/Unknown".equals(zid)) {
            return zid;
        }
        boolean[] isSystemID = {false};
        String canonicalID = TimeZone.getCanonicalID(zid, isSystemID);
        if (canonicalID == null || !isSystemID[0]) {
            return null;
        }
        return canonicalID;
    }
}
