package sun.util.locale;

import com.huawei.flexiblelayout.u0;
import java.lang.ref.SoftReference;
import java.util.StringJoiner;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class BaseLocale {
    private static final Cache CACHE = new Cache();
    public static final String SEP = "_";
    private volatile int hash;
    private final String language;
    private final String region;
    private final String script;
    private final String variant;

    private BaseLocale(String language, String script, String region, String variant, boolean normalize) {
        if (normalize) {
            this.language = LocaleUtils.toLowerString(language).intern();
            this.script = LocaleUtils.toTitleString(script).intern();
            this.region = LocaleUtils.toUpperString(region).intern();
            this.variant = variant.intern();
            return;
        }
        this.language = language;
        this.script = script;
        this.region = region;
        this.variant = variant;
    }

    public static BaseLocale createInstance(String language, String region) {
        BaseLocale base = new BaseLocale(language, "", region, "", false);
        CACHE.put(new Key(), base);
        return base;
    }

    public static BaseLocale getInstance(String language, String script, String region, String variant) {
        if (language != null) {
            if (LocaleUtils.caseIgnoreMatch(language, "he")) {
                language = "iw";
            } else if (LocaleUtils.caseIgnoreMatch(language, "yi")) {
                language = "ji";
            } else if (LocaleUtils.caseIgnoreMatch(language, "id")) {
                language = u0.f28637e;
            }
        }
        Key key = new Key(language, script, region, variant, false);
        BaseLocale baseLocale = CACHE.get(key);
        return baseLocale;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getScript() {
        return this.script;
    }

    public String getRegion() {
        return this.region;
    }

    public String getVariant() {
        return this.variant;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseLocale)) {
            return false;
        }
        BaseLocale other = (BaseLocale) obj;
        return this.language == other.language && this.script == other.script && this.region == other.region && this.variant == other.variant;
    }

    public String toString() {
        StringJoiner sj = new StringJoiner(", ");
        if (!this.language.isEmpty()) {
            sj.add("language=" + this.language);
        }
        if (!this.script.isEmpty()) {
            sj.add("script=" + this.script);
        }
        if (!this.region.isEmpty()) {
            sj.add("region=" + this.region);
        }
        if (!this.variant.isEmpty()) {
            sj.add("variant=" + this.variant);
        }
        return sj.toString();
    }

    public int hashCode() {
        int h10 = this.hash;
        if (h10 == 0 && (h10 = (((((this.language.hashCode() * 31) + this.script.hashCode()) * 31) + this.region.hashCode()) * 31) + this.variant.hashCode()) != 0) {
            this.hash = h10;
        }
        return h10;
    }

    public static void cleanCache() {
        CACHE.cleanStaleEntries();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Key {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final int hash;
        private final BaseLocale holder;
        private final SoftReference<BaseLocale> holderRef;
        private final boolean normalized;

        private Key(BaseLocale locale) {
            this.holder = locale;
            this.holderRef = null;
            this.normalized = true;
            String language = locale.getLanguage();
            String region = locale.getRegion();
            int h10 = language.hashCode();
            if (region != "") {
                int len = region.length();
                for (int i10 = 0; i10 < len; i10++) {
                    h10 = (h10 * 31) + LocaleUtils.toLower(region.charAt(i10));
                }
            }
            this.hash = h10;
        }

        private Key(String language, String script, String region, String variant, boolean normalize) {
            BaseLocale locale = new BaseLocale(language == null ? "" : language, script == null ? "" : script, region == null ? "" : region, variant == null ? "" : variant, normalize);
            this.normalized = normalize;
            if (normalize) {
                this.holderRef = new SoftReference<>(locale);
                this.holder = null;
            } else {
                this.holderRef = null;
                this.holder = locale;
            }
            this.hash = hashCode(locale);
        }

        public int hashCode() {
            return this.hash;
        }

        private int hashCode(BaseLocale locale) {
            int h10 = 0;
            String lang = locale.getLanguage();
            int len = lang.length();
            for (int i10 = 0; i10 < len; i10++) {
                h10 = (h10 * 31) + LocaleUtils.toLower(lang.charAt(i10));
            }
            String scrt = locale.getScript();
            int len2 = scrt.length();
            for (int i11 = 0; i11 < len2; i11++) {
                h10 = (h10 * 31) + LocaleUtils.toLower(scrt.charAt(i11));
            }
            String regn = locale.getRegion();
            int len3 = regn.length();
            for (int i12 = 0; i12 < len3; i12++) {
                h10 = (h10 * 31) + LocaleUtils.toLower(regn.charAt(i12));
            }
            String vart = locale.getVariant();
            int len4 = vart.length();
            for (int i13 = 0; i13 < len4; i13++) {
                h10 = (h10 * 31) + vart.charAt(i13);
            }
            return h10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public BaseLocale getBaseLocale() {
            BaseLocale baseLocale = this.holder;
            return baseLocale == null ? this.holderRef.get() : baseLocale;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Key) && this.hash == ((Key) obj).hash) {
                BaseLocale other = ((Key) obj).getBaseLocale();
                BaseLocale locale = getBaseLocale();
                if (other != null && locale != null && LocaleUtils.caseIgnoreMatch(other.getLanguage(), locale.getLanguage()) && LocaleUtils.caseIgnoreMatch(other.getScript(), locale.getScript()) && LocaleUtils.caseIgnoreMatch(other.getRegion(), locale.getRegion()) && other.getVariant().equals(locale.getVariant())) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public static Key normalize(Key key) {
            if (key.normalized) {
                return key;
            }
            BaseLocale locale = key.holder;
            return new Key(locale.getLanguage(), locale.getScript(), locale.getRegion(), locale.getVariant(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Cache extends LocaleObjectCache<Key, BaseLocale> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // sun.util.locale.LocaleObjectCache
        public Key normalizeKey(Key key) {
            return Key.normalize(key);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // sun.util.locale.LocaleObjectCache
        public BaseLocale createObject(Key key) {
            return Key.normalize(key).getBaseLocale();
        }
    }
}
