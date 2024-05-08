package java.util;

import com.android.icu.util.LocaleNative;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.appgallery.agd.common.support.global.HomeCountryUtils;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.huawei.flexiblelayout.u0;
import com.huawei.quickcard.framework.bean.QuickCardBean;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import libcore.icu.ICU;
import sun.util.locale.BaseLocale;
import sun.util.locale.InternalLocaleBuilder;
import sun.util.locale.LanguageTag;
import sun.util.locale.LocaleExtensions;
import sun.util.locale.LocaleMatcher;
import sun.util.locale.LocaleObjectCache;
import sun.util.locale.LocaleSyntaxException;
import sun.util.locale.LocaleUtils;
import sun.util.locale.ParseStatus;
import wseemann.media.FFmpegMediaMetadataRetriever;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Locale implements Cloneable, Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Locale CANADA;
    public static final Locale CANADA_FRENCH;
    public static final Locale CHINA;
    private static final int DISPLAY_COUNTRY = 1;
    private static final int DISPLAY_LANGUAGE = 0;
    private static final int DISPLAY_SCRIPT = 3;
    private static final int DISPLAY_UEXT_KEY = 4;
    private static final int DISPLAY_UEXT_TYPE = 5;
    private static final int DISPLAY_VARIANT = 2;
    public static final Locale FRANCE;
    public static final Locale GERMANY;
    public static final Locale ITALY;
    public static final Locale JAPAN;
    public static final Locale KOREA;
    public static final Locale PRC;
    public static final char PRIVATE_USE_EXTENSION = 'x';
    public static final Locale ROOT;
    public static final Locale SIMPLIFIED_CHINESE;
    public static final Locale TAIWAN;
    public static final Locale TRADITIONAL_CHINESE;
    public static final Locale UK;
    private static final String UNDETERMINED_LANGUAGE = "und";
    public static final char UNICODE_LOCALE_EXTENSION = 'u';
    public static final Locale US;
    private static volatile Locale defaultDisplayLocale = null;
    private static volatile Locale defaultFormatLocale = null;
    private static volatile String[] isoCountries = null;
    private static volatile String[] isoLanguages = null;
    private static final ObjectStreamField[] serialPersistentFields;
    static final long serialVersionUID = 9149081749638150636L;
    private transient BaseLocale baseLocale;
    private volatile transient int hashCodeValue;
    private volatile transient String languageTag;
    private transient LocaleExtensions localeExtensions;
    private static final Cache LOCALECACHE = new Cache();
    public static final Locale ENGLISH = createConstant("en", "");
    public static final Locale FRENCH = createConstant("fr", "");
    public static final Locale GERMAN = createConstant("de", "");
    public static final Locale ITALIAN = createConstant("it", "");
    public static final Locale JAPANESE = createConstant("ja", "");
    public static final Locale KOREAN = createConstant("ko", "");
    public static final Locale CHINESE = createConstant("zh", "");

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum FilteringMode {
        AUTOSELECT_FILTERING,
        EXTENDED_FILTERING,
        IGNORE_EXTENDED_RANGES,
        MAP_EXTENDED_RANGES,
        REJECT_EXTENDED_RANGES
    }

    static {
        Locale createConstant = createConstant("zh", "CN");
        SIMPLIFIED_CHINESE = createConstant;
        Locale createConstant2 = createConstant("zh", HomeCountryUtils.HomeCountry.CHINA_TAIWAN);
        TRADITIONAL_CHINESE = createConstant2;
        FRANCE = createConstant("fr", "FR");
        GERMANY = createConstant("de", "DE");
        ITALY = createConstant("it", "IT");
        JAPAN = createConstant("ja", "JP");
        KOREA = createConstant("ko", "KR");
        CHINA = createConstant;
        PRC = createConstant;
        TAIWAN = createConstant2;
        UK = createConstant("en", "GB");
        US = createConstant("en", "US");
        CANADA = createConstant("en", "CA");
        CANADA_FRENCH = createConstant("fr", "CA");
        ROOT = createConstant("", "");
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField(FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE, String.class), new ObjectStreamField("country", String.class), new ObjectStreamField("variant", String.class), new ObjectStreamField("hashcode", Integer.TYPE), new ObjectStreamField(QuickCardBean.Field.SCRIPT, String.class), new ObjectStreamField("extensions", String.class)};
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class IsoCountryCode {
        public static final IsoCountryCode PART1_ALPHA2 = new AnonymousClass1("PART1_ALPHA2", 0);
        public static final IsoCountryCode PART1_ALPHA3 = new AnonymousClass2("PART1_ALPHA3", 1);
        public static final IsoCountryCode PART3 = new AnonymousClass3("PART3", 2);
        private static final /* synthetic */ IsoCountryCode[] $VALUES = $values();
        private static Map<IsoCountryCode, Set<String>> iso3166CodesMap = new ConcurrentHashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Set<String> createCountryCodeSet();

        private static /* synthetic */ IsoCountryCode[] $values() {
            return new IsoCountryCode[]{PART1_ALPHA2, PART1_ALPHA3, PART3};
        }

        private IsoCountryCode(String str, int i10) {
        }

        public static IsoCountryCode valueOf(String name) {
            return (IsoCountryCode) Enum.valueOf(IsoCountryCode.class, name);
        }

        public static IsoCountryCode[] values() {
            return (IsoCountryCode[]) $VALUES.clone();
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* renamed from: java.util.Locale$IsoCountryCode$1, reason: invalid class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        enum AnonymousClass1 extends IsoCountryCode {
            private AnonymousClass1(String str, int i10) {
                super(str, i10);
            }

            @Override // java.util.Locale.IsoCountryCode
            Set<String> createCountryCodeSet() {
                return Set.of((Object[]) Locale.getISOCountries());
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* renamed from: java.util.Locale$IsoCountryCode$2, reason: invalid class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        enum AnonymousClass2 extends IsoCountryCode {
            private AnonymousClass2(String str, int i10) {
                super(str, i10);
            }

            @Override // java.util.Locale.IsoCountryCode
            Set<String> createCountryCodeSet() {
                return LocaleISOData.computeISO3166_1Alpha3Countries();
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* renamed from: java.util.Locale$IsoCountryCode$3, reason: invalid class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        enum AnonymousClass3 extends IsoCountryCode {
            private AnonymousClass3(String str, int i10) {
                super(str, i10);
            }

            @Override // java.util.Locale.IsoCountryCode
            Set<String> createCountryCodeSet() {
                return Set.of((Object[]) LocaleISOData.ISO3166_3);
            }
        }

        static Set<String> retrieveISOCountryCodes(IsoCountryCode type) {
            return iso3166CodesMap.computeIfAbsent(type, new Function() { // from class: java.util.Locale$IsoCountryCode$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((Locale.IsoCountryCode) obj).createCountryCodeSet();
                }
            });
        }
    }

    private Locale(BaseLocale baseLocale, LocaleExtensions extensions) {
        this.baseLocale = baseLocale;
        this.localeExtensions = extensions;
    }

    public Locale(String language, String country, String variant) {
        if (language == null || country == null || variant == null) {
            throw new NullPointerException();
        }
        this.baseLocale = BaseLocale.getInstance(convertOldISOCodes(language), "", country, variant);
        this.localeExtensions = getCompatibilityExtensions(language, "", country, variant);
    }

    public Locale(String language, String country) {
        this(language, country, "");
    }

    public Locale(String language) {
        this(language, "", "");
    }

    private static Locale createConstant(String lang, String country) {
        BaseLocale base = BaseLocale.createInstance(lang, country);
        return getInstance(base, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Locale getInstance(String language, String country, String variant) {
        return getInstance(language, "", country, variant, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Locale getInstance(String language, String script, String country, String variant, LocaleExtensions extensions) {
        if (language == null || script == null || country == null || variant == null) {
            throw new NullPointerException();
        }
        if (extensions == null) {
            extensions = getCompatibilityExtensions(language, script, country, variant);
        }
        BaseLocale baseloc = BaseLocale.getInstance(language, script, country, variant);
        return getInstance(baseloc, extensions);
    }

    static Locale getInstance(BaseLocale baseloc, LocaleExtensions extensions) {
        if (extensions == null) {
            return LOCALECACHE.get(baseloc);
        }
        LocaleKey key = new LocaleKey(baseloc, extensions);
        return LOCALECACHE.get(key);
    }

    public static void cleanCache() {
        LOCALECACHE.cleanStaleEntries();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Cache extends LocaleObjectCache<Object, Locale> {
        private Cache() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // sun.util.locale.LocaleObjectCache
        public Locale createObject(Object obj) {
            LocaleExtensions localeExtensions = null;
            byte b4 = 0;
            byte b10 = 0;
            if (obj instanceof BaseLocale) {
                return new Locale((BaseLocale) obj, localeExtensions);
            }
            LocaleKey localeKey = (LocaleKey) obj;
            return new Locale(localeKey.base, localeKey.exts);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class LocaleKey {
        private final BaseLocale base;
        private final LocaleExtensions exts;
        private final int hash;

        private LocaleKey(BaseLocale baseLocale, LocaleExtensions extensions) {
            this.base = baseLocale;
            this.exts = extensions;
            int h10 = baseLocale.hashCode();
            this.hash = extensions != null ? h10 ^ extensions.hashCode() : h10;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocaleKey)) {
                return false;
            }
            LocaleKey other = (LocaleKey) obj;
            if (this.hash != other.hash || !this.base.equals(other.base)) {
                return false;
            }
            LocaleExtensions localeExtensions = this.exts;
            if (localeExtensions == null) {
                return other.exts == null;
            }
            return localeExtensions.equals(other.exts);
        }

        public int hashCode() {
            return this.hash;
        }
    }

    public static Locale getDefault() {
        return NoImagePreloadHolder.defaultLocale;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.Locale$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$util$Locale$Category;

        static {
            int[] iArr = new int[Category.values().length];
            $SwitchMap$java$util$Locale$Category = iArr;
            try {
                iArr[Category.DISPLAY.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$util$Locale$Category[Category.FORMAT.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    public static Locale getDefault(Category category) {
        switch (AnonymousClass1.$SwitchMap$java$util$Locale$Category[category.ordinal()]) {
            case 1:
                if (defaultDisplayLocale == null) {
                    synchronized (Locale.class) {
                        if (defaultDisplayLocale == null) {
                            defaultDisplayLocale = initDefault(category);
                        }
                    }
                }
                return defaultDisplayLocale;
            case 2:
                if (defaultFormatLocale == null) {
                    synchronized (Locale.class) {
                        if (defaultFormatLocale == null) {
                            defaultFormatLocale = initDefault(category);
                        }
                    }
                }
                return defaultFormatLocale;
            default:
                return getDefault();
        }
    }

    public static Locale initDefault() {
        String script;
        String country;
        String variant;
        String languageTag = System.getProperty("user.locale", "");
        if (!languageTag.isEmpty()) {
            return forLanguageTag(languageTag);
        }
        String language = System.getProperty("user.language", "en");
        String region = System.getProperty("user.region");
        if (region != null) {
            int i10 = region.indexOf(95);
            if (i10 >= 0) {
                country = region.substring(0, i10);
                variant = region.substring(i10 + 1);
            } else {
                country = region;
                variant = "";
            }
            script = "";
        } else {
            script = System.getProperty("user.script", "");
            country = System.getProperty("user.country", "");
            variant = System.getProperty("user.variant", "");
        }
        LocaleExtensions extension = getDefaultExtensions(System.getProperty("user.extensions", "")).orElse(null);
        return getInstance(language, script, country, variant, extension);
    }

    private static Locale initDefault(Category category) {
        Locale defaultLocale = NoImagePreloadHolder.defaultLocale;
        return getInstance(System.getProperty(category.languageKey, defaultLocale.getLanguage()), System.getProperty(category.scriptKey, defaultLocale.getScript()), System.getProperty(category.countryKey, defaultLocale.getCountry()), System.getProperty(category.variantKey, defaultLocale.getVariant()), null);
    }

    private static Optional<LocaleExtensions> getDefaultExtensions(String extensionsProp) {
        LocaleExtensions exts = null;
        try {
            exts = new InternalLocaleBuilder().setExtensions(extensionsProp).getLocaleExtensions();
        } catch (LocaleSyntaxException e2) {
        }
        return Optional.ofNullable(exts);
    }

    public static synchronized void setDefault(Locale newLocale) {
        synchronized (Locale.class) {
            setDefault(Category.DISPLAY, newLocale);
            setDefault(Category.FORMAT, newLocale);
            NoImagePreloadHolder.defaultLocale = newLocale;
            ICU.setDefaultLocale(newLocale.toLanguageTag());
        }
    }

    public static synchronized void setDefault(Category category, Locale newLocale) {
        synchronized (Locale.class) {
            if (category == null) {
                throw new NullPointerException("Category cannot be NULL");
            }
            if (newLocale == null) {
                throw new NullPointerException("Can't set default locale to NULL");
            }
            SecurityManager sm = System.getSecurityManager();
            if (sm != null) {
                sm.checkPermission(new PropertyPermission("user.language", "write"));
            }
            switch (AnonymousClass1.$SwitchMap$java$util$Locale$Category[category.ordinal()]) {
                case 1:
                    defaultDisplayLocale = newLocale;
                    break;
                case 2:
                    defaultFormatLocale = newLocale;
                    break;
            }
        }
    }

    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableLocales();
    }

    public static String[] getISOCountries() {
        return ICU.getISOCountries();
    }

    public static Set<String> getISOCountries(IsoCountryCode type) {
        Objects.requireNonNull(type);
        return IsoCountryCode.retrieveISOCountryCodes(type);
    }

    public static String[] getISOLanguages() {
        return ICU.getISOLanguages();
    }

    public String getLanguage() {
        return this.baseLocale.getLanguage();
    }

    public String getScript() {
        return this.baseLocale.getScript();
    }

    public String getCountry() {
        return this.baseLocale.getRegion();
    }

    public String getVariant() {
        return this.baseLocale.getVariant();
    }

    public boolean hasExtensions() {
        return this.localeExtensions != null;
    }

    public Locale stripExtensions() {
        return hasExtensions() ? getInstance(this.baseLocale, null) : this;
    }

    public String getExtension(char key) {
        if (!LocaleExtensions.isValidKey(key)) {
            throw new IllegalArgumentException("Ill-formed extension key: " + key);
        }
        if (hasExtensions()) {
            return this.localeExtensions.getExtensionValue(Character.valueOf(key));
        }
        return null;
    }

    public Set<Character> getExtensionKeys() {
        if (!hasExtensions()) {
            return Collections.emptySet();
        }
        return this.localeExtensions.getKeys();
    }

    public Set<String> getUnicodeLocaleAttributes() {
        if (!hasExtensions()) {
            return Collections.emptySet();
        }
        return this.localeExtensions.getUnicodeLocaleAttributes();
    }

    public String getUnicodeLocaleType(String key) {
        if (!isUnicodeExtensionKey(key)) {
            throw new IllegalArgumentException("Ill-formed Unicode locale key: " + key);
        }
        if (hasExtensions()) {
            return this.localeExtensions.getUnicodeLocaleType(key);
        }
        return null;
    }

    public Set<String> getUnicodeLocaleKeys() {
        LocaleExtensions localeExtensions = this.localeExtensions;
        if (localeExtensions == null) {
            return Collections.emptySet();
        }
        return localeExtensions.getUnicodeLocaleKeys();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseLocale getBaseLocale() {
        return this.baseLocale;
    }

    LocaleExtensions getLocaleExtensions() {
        return this.localeExtensions;
    }

    public final String toString() {
        boolean l10 = !this.baseLocale.getLanguage().isEmpty();
        boolean s2 = !this.baseLocale.getScript().isEmpty();
        boolean r10 = !this.baseLocale.getRegion().isEmpty();
        boolean v2 = !this.baseLocale.getVariant().isEmpty();
        LocaleExtensions localeExtensions = this.localeExtensions;
        boolean e2 = (localeExtensions == null || localeExtensions.getID().isEmpty()) ? false : true;
        StringBuilder result = new StringBuilder(this.baseLocale.getLanguage());
        if (r10 || (l10 && (v2 || s2 || e2))) {
            result.append('_').append(this.baseLocale.getRegion());
        }
        if (v2 && (l10 || r10)) {
            result.append('_').append(this.baseLocale.getVariant());
        }
        if (s2 && (l10 || r10)) {
            result.append("_#").append(this.baseLocale.getScript());
        }
        if (e2 && (l10 || r10)) {
            result.append('_');
            if (!s2) {
                result.append('#');
            }
            result.append(this.localeExtensions.getID());
        }
        return result.toString();
    }

    public String toLanguageTag() {
        if (this.languageTag != null) {
            return this.languageTag;
        }
        LanguageTag tag = LanguageTag.parseLocale(this.baseLocale, this.localeExtensions);
        StringBuilder buf = new StringBuilder();
        String subtag = tag.getLanguage();
        if (!subtag.isEmpty()) {
            buf.append(LanguageTag.canonicalizeLanguage(subtag));
        }
        String subtag2 = tag.getScript();
        if (!subtag2.isEmpty()) {
            buf.append("-");
            buf.append(LanguageTag.canonicalizeScript(subtag2));
        }
        String subtag3 = tag.getRegion();
        if (!subtag3.isEmpty()) {
            buf.append("-");
            buf.append(LanguageTag.canonicalizeRegion(subtag3));
        }
        List<String> subtags = tag.getVariants();
        for (String s2 : subtags) {
            buf.append("-");
            buf.append(s2);
        }
        List<String> subtags2 = tag.getExtensions();
        for (String s10 : subtags2) {
            buf.append("-");
            buf.append(LanguageTag.canonicalizeExtension(s10));
        }
        String subtag4 = tag.getPrivateuse();
        if (!subtag4.isEmpty()) {
            if (buf.length() > 0) {
                buf.append("-");
            }
            buf.append(LanguageTag.PRIVATEUSE).append("-");
            buf.append(subtag4);
        }
        String langTag = buf.toString();
        synchronized (this) {
            if (this.languageTag == null) {
                this.languageTag = langTag;
            }
        }
        return this.languageTag;
    }

    public static Locale forLanguageTag(String languageTag) {
        LanguageTag tag = LanguageTag.parse(languageTag, null);
        InternalLocaleBuilder bldr = new InternalLocaleBuilder();
        bldr.setLanguageTag(tag);
        BaseLocale base = bldr.getBaseLocale();
        LocaleExtensions exts = bldr.getLocaleExtensions();
        if (exts == null && !base.getVariant().isEmpty()) {
            exts = getCompatibilityExtensions(base.getLanguage(), base.getScript(), base.getRegion(), base.getVariant());
        }
        return getInstance(base, exts);
    }

    public String getISO3Language() throws MissingResourceException {
        String lang = this.baseLocale.getLanguage();
        if (lang.length() == 3) {
            return lang;
        }
        if (lang.isEmpty()) {
            return "";
        }
        String language3 = ICU.getISO3Language(lang);
        if (!lang.isEmpty() && language3.isEmpty()) {
            throw new MissingResourceException("Couldn't find 3-letter language code for " + lang, "FormatData_" + toString(), "ShortLanguage");
        }
        return language3;
    }

    public String getISO3Country() throws MissingResourceException {
        String region = this.baseLocale.getRegion();
        if (region.length() == 3) {
            return this.baseLocale.getRegion();
        }
        if (region.isEmpty()) {
            return "";
        }
        String country3 = ICU.getISO3Country("en-" + region);
        if (!region.isEmpty() && country3.isEmpty()) {
            throw new MissingResourceException("Couldn't find 3-letter country code for " + this.baseLocale.getRegion(), "FormatData_" + toString(), "ShortCountry");
        }
        return country3;
    }

    public final String getDisplayLanguage() {
        return getDisplayLanguage(getDefault(Category.DISPLAY));
    }

    public String getDisplayLanguage(Locale locale) {
        String languageCode = this.baseLocale.getLanguage();
        if (languageCode.isEmpty()) {
            return "";
        }
        String normalizedLanguage = normalizeAndValidateLanguage(languageCode, false);
        if ("und".equals(normalizedLanguage)) {
            return languageCode;
        }
        String result = LocaleNative.getDisplayLanguage(this, locale);
        if (result == null) {
            return LocaleNative.getDisplayLanguage(this, getDefault());
        }
        return result;
    }

    private static String normalizeAndValidateLanguage(String language, boolean strict) {
        if (language == null || language.isEmpty()) {
            return "";
        }
        String lowercaseLanguage = language.toLowerCase(ROOT);
        if (!isValidBcp47Alpha(lowercaseLanguage, 2, 3)) {
            if (strict) {
                throw new IllformedLocaleException("Invalid language: " + language);
            }
            return "und";
        }
        return lowercaseLanguage;
    }

    private static boolean isAsciiAlphaNum(String string) {
        for (int i10 = 0; i10 < string.length(); i10++) {
            char character = string.charAt(i10);
            if ((character < 'a' || character > 'z') && ((character < 'A' || character > 'Z') && (character < '0' || character > '9'))) {
                return false;
            }
        }
        return true;
    }

    public String getDisplayScript() {
        return getDisplayScript(getDefault(Category.DISPLAY));
    }

    public String getDisplayScript(Locale inLocale) {
        String scriptCode = this.baseLocale.getScript();
        if (scriptCode.isEmpty()) {
            return "";
        }
        String result = LocaleNative.getDisplayScript(this, inLocale);
        if (result == null) {
            return LocaleNative.getDisplayScript(this, getDefault(Category.DISPLAY));
        }
        return result;
    }

    public final String getDisplayCountry() {
        return getDisplayCountry(getDefault(Category.DISPLAY));
    }

    public String getDisplayCountry(Locale locale) {
        String countryCode = this.baseLocale.getRegion();
        if (countryCode.isEmpty()) {
            return "";
        }
        String normalizedRegion = normalizeAndValidateRegion(countryCode, false);
        if (normalizedRegion.isEmpty()) {
            return countryCode;
        }
        String result = LocaleNative.getDisplayCountry(this, locale);
        if (result == null) {
            return LocaleNative.getDisplayCountry(this, getDefault());
        }
        return result;
    }

    private static String normalizeAndValidateRegion(String region, boolean strict) {
        if (region == null || region.isEmpty()) {
            return "";
        }
        String uppercaseRegion = region.toUpperCase(ROOT);
        if (!isValidBcp47Alpha(uppercaseRegion, 2, 2) && !isUnM49AreaCode(uppercaseRegion)) {
            if (!strict) {
                return "";
            }
            throw new IllformedLocaleException("Invalid region: " + region);
        }
        return uppercaseRegion;
    }

    private static boolean isValidBcp47Alpha(String string, int lowerBound, int upperBound) {
        int length = string.length();
        if (length < lowerBound || length > upperBound) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            char character = string.charAt(i10);
            if ((character < 'a' || character > 'z') && (character < 'A' || character > 'Z')) {
                return false;
            }
        }
        return true;
    }

    private static boolean isUnM49AreaCode(String code) {
        if (code.length() != 3) {
            return false;
        }
        for (int i10 = 0; i10 < 3; i10++) {
            char character = code.charAt(i10);
            if (character < '0' || character > '9') {
                return false;
            }
        }
        return true;
    }

    public final String getDisplayVariant() {
        return getDisplayVariant(getDefault(Category.DISPLAY));
    }

    public String getDisplayVariant(Locale inLocale) {
        String variantCode = this.baseLocale.getVariant();
        if (variantCode.isEmpty()) {
            return "";
        }
        try {
            normalizeAndValidateVariant(variantCode);
            String result = LocaleNative.getDisplayVariant(this, inLocale);
            if (result == null) {
                result = LocaleNative.getDisplayVariant(this, getDefault());
            }
            if (result.isEmpty()) {
                return variantCode;
            }
            return result;
        } catch (IllformedLocaleException e2) {
            return variantCode;
        }
    }

    private static String normalizeAndValidateVariant(String variant) {
        if (variant == null || variant.isEmpty()) {
            return "";
        }
        String normalizedVariant = variant.replace('-', '_');
        String[] subTags = normalizedVariant.split("_");
        for (String subTag : subTags) {
            if (!isValidVariantSubtag(subTag)) {
                throw new IllformedLocaleException("Invalid variant: " + variant);
            }
        }
        return normalizedVariant;
    }

    private static boolean isValidVariantSubtag(String subTag) {
        char firstChar;
        if (subTag.length() >= 5 && subTag.length() <= 8) {
            if (isAsciiAlphaNum(subTag)) {
                return true;
            }
        } else if (subTag.length() == 4 && (firstChar = subTag.charAt(0)) >= '0' && firstChar <= '9' && isAsciiAlphaNum(subTag)) {
            return true;
        }
        return false;
    }

    public final String getDisplayName() {
        return getDisplayName(getDefault(Category.DISPLAY));
    }

    public String getDisplayName(Locale locale) {
        int count = 0;
        StringBuilder buffer = new StringBuilder();
        String languageCode = this.baseLocale.getLanguage();
        if (!languageCode.isEmpty()) {
            String displayLanguage = getDisplayLanguage(locale);
            buffer.append(displayLanguage.isEmpty() ? languageCode : displayLanguage);
            count = 0 + 1;
        }
        String scriptCode = this.baseLocale.getScript();
        if (!scriptCode.isEmpty()) {
            if (count == 1) {
                buffer.append(" (");
            }
            String displayScript = getDisplayScript(locale);
            buffer.append(displayScript.isEmpty() ? scriptCode : displayScript);
            count++;
        }
        String countryCode = this.baseLocale.getRegion();
        if (!countryCode.isEmpty()) {
            if (count == 1) {
                buffer.append(" (");
            } else if (count == 2) {
                buffer.append(",");
            }
            String displayCountry = getDisplayCountry(locale);
            buffer.append(displayCountry.isEmpty() ? countryCode : displayCountry);
            count++;
        }
        String variantCode = this.baseLocale.getVariant();
        if (!variantCode.isEmpty()) {
            if (count == 1) {
                buffer.append(" (");
            } else if (count == 2 || count == 3) {
                buffer.append(",");
            }
            String displayVariant = getDisplayVariant(locale);
            buffer.append(displayVariant.isEmpty() ? variantCode : displayVariant);
            count++;
        }
        if (count > 1) {
            buffer.append(")");
        }
        return buffer.toString();
    }

    public Object clone() {
        try {
            Locale that = (Locale) super.clone();
            return that;
        } catch (CloneNotSupportedException e2) {
            throw new InternalError(e2);
        }
    }

    public int hashCode() {
        int hc2 = this.hashCodeValue;
        if (hc2 == 0) {
            hc2 = this.baseLocale.hashCode();
            LocaleExtensions localeExtensions = this.localeExtensions;
            if (localeExtensions != null) {
                hc2 ^= localeExtensions.hashCode();
            }
            this.hashCodeValue = hc2;
        }
        return hc2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Locale)) {
            return false;
        }
        BaseLocale otherBase = ((Locale) obj).baseLocale;
        if (!this.baseLocale.equals(otherBase)) {
            return false;
        }
        LocaleExtensions localeExtensions = this.localeExtensions;
        if (localeExtensions == null) {
            return ((Locale) obj).localeExtensions == null;
        }
        return localeExtensions.equals(((Locale) obj).localeExtensions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class NoImagePreloadHolder {
        public static volatile Locale defaultLocale = Locale.initDefault();

        private NoImagePreloadHolder() {
        }
    }

    private static String formatList(String[] stringList, final String pattern) {
        if (pattern == null) {
            return (String) Arrays.stream(stringList).collect(Collectors.joining(","));
        }
        switch (stringList.length) {
            case 0:
                return "";
            case 1:
                return stringList[0];
            default:
                return (String) Arrays.stream(stringList).reduce("", new BinaryOperator() { // from class: java.util.Locale$$ExternalSyntheticLambda0
                    @Override // java.util.function.BiFunction
                    public final Object apply(Object obj, Object obj2) {
                        return Locale.lambda$formatList$0(String.this, (String) obj, (String) obj2);
                    }
                });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String lambda$formatList$0(String pattern, String s12, String s2) {
        if (s12.equals("")) {
            return s2;
        }
        if (s2.equals("")) {
            return s12;
        }
        return MessageFormat.format(pattern, s12, s2);
    }

    private static boolean isUnicodeExtensionKey(String s2) {
        return s2.length() == 2 && LocaleUtils.isAlphaNumericString(s2);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        ObjectOutputStream.PutField fields = out.putFields();
        fields.put(FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE, this.baseLocale.getLanguage());
        fields.put(QuickCardBean.Field.SCRIPT, this.baseLocale.getScript());
        fields.put("country", this.baseLocale.getRegion());
        fields.put("variant", this.baseLocale.getVariant());
        LocaleExtensions localeExtensions = this.localeExtensions;
        fields.put("extensions", localeExtensions == null ? "" : localeExtensions.getID());
        fields.put("hashcode", -1);
        out.writeFields();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = in.readFields();
        String language = (String) fields.get(FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE, "");
        String script = (String) fields.get(QuickCardBean.Field.SCRIPT, "");
        String country = (String) fields.get("country", "");
        String variant = (String) fields.get("variant", "");
        String extStr = (String) fields.get("extensions", "");
        this.baseLocale = BaseLocale.getInstance(convertOldISOCodes(language), script, country, variant);
        if (extStr != null && !extStr.isEmpty()) {
            try {
                InternalLocaleBuilder bldr = new InternalLocaleBuilder();
                bldr.setExtensions(extStr);
                this.localeExtensions = bldr.getLocaleExtensions();
                return;
            } catch (LocaleSyntaxException e2) {
                throw new IllformedLocaleException(e2.getMessage());
            }
        }
        this.localeExtensions = null;
    }

    private Object readResolve() throws ObjectStreamException {
        return getInstance(this.baseLocale.getLanguage(), this.baseLocale.getScript(), this.baseLocale.getRegion(), this.baseLocale.getVariant(), this.localeExtensions);
    }

    private static String convertOldISOCodes(String language) {
        String language2 = LocaleUtils.toLowerString(language).intern();
        if (language2 == "he") {
            return "iw";
        }
        if (language2 == "yi") {
            return "ji";
        }
        if (language2 == "id") {
            return u0.f28637e;
        }
        return language2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LocaleExtensions getCompatibilityExtensions(String language, String script, String country, String variant) {
        if (LocaleUtils.caseIgnoreMatch(language, "ja") && script.isEmpty() && LocaleUtils.caseIgnoreMatch(country, "jp") && "JP".equals(variant)) {
            LocaleExtensions extensions = LocaleExtensions.CALENDAR_JAPANESE;
            return extensions;
        }
        if (!LocaleUtils.caseIgnoreMatch(language, "th") || !script.isEmpty() || !LocaleUtils.caseIgnoreMatch(country, "th") || !"TH".equals(variant)) {
            return null;
        }
        LocaleExtensions extensions2 = LocaleExtensions.NUMBER_THAI;
        return extensions2;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum Category {
        DISPLAY("user.language.display", "user.script.display", "user.country.display", "user.variant.display", "user.extensions.display"),
        FORMAT("user.language.format", "user.script.format", "user.country.format", "user.variant.format", "user.extensions.format");

        final String countryKey;
        final String extensionsKey;
        final String languageKey;
        final String scriptKey;
        final String variantKey;

        Category(String languageKey, String scriptKey, String countryKey, String variantKey, String extensionsKey) {
            this.languageKey = languageKey;
            this.scriptKey = scriptKey;
            this.countryKey = countryKey;
            this.variantKey = variantKey;
            this.extensionsKey = extensionsKey;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Builder {
        private final InternalLocaleBuilder localeBuilder = new InternalLocaleBuilder();

        public Builder setLocale(Locale locale) {
            try {
                this.localeBuilder.setLocale(locale.baseLocale, locale.localeExtensions);
                return this;
            } catch (LocaleSyntaxException e2) {
                throw new IllformedLocaleException(e2.getMessage(), e2.getErrorIndex());
            }
        }

        public Builder setLanguageTag(String languageTag) {
            ParseStatus sts = new ParseStatus();
            LanguageTag tag = LanguageTag.parse(languageTag, sts);
            if (sts.isError()) {
                throw new IllformedLocaleException(sts.getErrorMessage(), sts.getErrorIndex());
            }
            this.localeBuilder.setLanguageTag(tag);
            return this;
        }

        public Builder setLanguage(String language) {
            try {
                this.localeBuilder.setLanguage(language);
                return this;
            } catch (LocaleSyntaxException e2) {
                throw new IllformedLocaleException(e2.getMessage(), e2.getErrorIndex());
            }
        }

        public Builder setScript(String script) {
            try {
                this.localeBuilder.setScript(script);
                return this;
            } catch (LocaleSyntaxException e2) {
                throw new IllformedLocaleException(e2.getMessage(), e2.getErrorIndex());
            }
        }

        public Builder setRegion(String region) {
            try {
                this.localeBuilder.setRegion(region);
                return this;
            } catch (LocaleSyntaxException e2) {
                throw new IllformedLocaleException(e2.getMessage(), e2.getErrorIndex());
            }
        }

        public Builder setVariant(String variant) {
            try {
                this.localeBuilder.setVariant(variant);
                return this;
            } catch (LocaleSyntaxException e2) {
                throw new IllformedLocaleException(e2.getMessage(), e2.getErrorIndex());
            }
        }

        public Builder setExtension(char key, String value) {
            try {
                this.localeBuilder.setExtension(key, value);
                return this;
            } catch (LocaleSyntaxException e2) {
                throw new IllformedLocaleException(e2.getMessage(), e2.getErrorIndex());
            }
        }

        public Builder setUnicodeLocaleKeyword(String key, String type) {
            try {
                this.localeBuilder.setUnicodeLocaleKeyword(key, type);
                return this;
            } catch (LocaleSyntaxException e2) {
                throw new IllformedLocaleException(e2.getMessage(), e2.getErrorIndex());
            }
        }

        public Builder addUnicodeLocaleAttribute(String attribute) {
            try {
                this.localeBuilder.addUnicodeLocaleAttribute(attribute);
                return this;
            } catch (LocaleSyntaxException e2) {
                throw new IllformedLocaleException(e2.getMessage(), e2.getErrorIndex());
            }
        }

        public Builder removeUnicodeLocaleAttribute(String attribute) {
            Objects.requireNonNull(attribute);
            try {
                this.localeBuilder.removeUnicodeLocaleAttribute(attribute);
                return this;
            } catch (LocaleSyntaxException e2) {
                throw new IllformedLocaleException(e2.getMessage(), e2.getErrorIndex());
            }
        }

        public Builder clear() {
            this.localeBuilder.clear();
            return this;
        }

        public Builder clearExtensions() {
            this.localeBuilder.clearExtensions();
            return this;
        }

        public Locale build() {
            BaseLocale baseloc = this.localeBuilder.getBaseLocale();
            LocaleExtensions extensions = this.localeBuilder.getLocaleExtensions();
            if (extensions == null && !baseloc.getVariant().isEmpty()) {
                extensions = Locale.getCompatibilityExtensions(baseloc.getLanguage(), baseloc.getScript(), baseloc.getRegion(), baseloc.getVariant());
            }
            return Locale.getInstance(baseloc, extensions);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class LanguageRange {
        public static final double MAX_WEIGHT = 1.0d;
        public static final double MIN_WEIGHT = 0.0d;
        private volatile int hash;
        private final String range;
        private final double weight;

        public LanguageRange(String range) {
            this(range, 1.0d);
        }

        public LanguageRange(String range, double weight) {
            if (range == null) {
                throw new NullPointerException();
            }
            if (weight < ShadowDrawableWrapper.COS_45 || weight > 1.0d) {
                throw new IllegalArgumentException("weight=" + weight);
            }
            String range2 = range.toLowerCase(Locale.ROOT);
            boolean isIllFormed = false;
            String[] subtags = range2.split("-");
            if (isSubtagIllFormed(subtags[0], true) || range2.endsWith("-")) {
                isIllFormed = true;
            } else {
                int i10 = 1;
                while (true) {
                    if (i10 >= subtags.length) {
                        break;
                    }
                    if (!isSubtagIllFormed(subtags[i10], false)) {
                        i10++;
                    } else {
                        isIllFormed = true;
                        break;
                    }
                }
            }
            if (isIllFormed) {
                throw new IllegalArgumentException("range=" + range2);
            }
            this.range = range2;
            this.weight = weight;
        }

        private static boolean isSubtagIllFormed(String subtag, boolean isFirstSubtag) {
            if (subtag.equals("") || subtag.length() > 8) {
                return true;
            }
            if (subtag.equals(StringUtils.NO_PRINT_CODE)) {
                return false;
            }
            char[] charArray = subtag.toCharArray();
            if (isFirstSubtag) {
                for (char c4 : charArray) {
                    if (c4 < 'a' || c4 > 'z') {
                        return true;
                    }
                }
            } else {
                for (char c10 : charArray) {
                    if (c10 < '0' || ((c10 > '9' && c10 < 'a') || c10 > 'z')) {
                        return true;
                    }
                }
            }
            return false;
        }

        public String getRange() {
            return this.range;
        }

        public double getWeight() {
            return this.weight;
        }

        public static List<LanguageRange> parse(String ranges) {
            return LocaleMatcher.parse(ranges);
        }

        public static List<LanguageRange> parse(String ranges, Map<String, List<String>> map) {
            return mapEquivalents(parse(ranges), map);
        }

        public static List<LanguageRange> mapEquivalents(List<LanguageRange> priorityList, Map<String, List<String>> map) {
            return LocaleMatcher.mapEquivalents(priorityList, map);
        }

        public int hashCode() {
            int h10 = this.hash;
            if (h10 == 0) {
                int h11 = (17 * 37) + this.range.hashCode();
                long bitsWeight = Double.doubleToLongBits(this.weight);
                h10 = (h11 * 37) + ((int) ((bitsWeight >>> 32) ^ bitsWeight));
                if (h10 != 0) {
                    this.hash = h10;
                }
            }
            return h10;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LanguageRange)) {
                return false;
            }
            LanguageRange other = (LanguageRange) obj;
            return this.hash == other.hash && this.range.equals(other.range) && this.weight == other.weight;
        }

        public String toString() {
            return this.weight == 1.0d ? this.range : this.range + ";q=" + this.weight;
        }
    }

    public static List<Locale> filter(List<LanguageRange> priorityList, Collection<Locale> locales, FilteringMode mode) {
        return LocaleMatcher.filter(priorityList, locales, mode);
    }

    public static List<Locale> filter(List<LanguageRange> priorityList, Collection<Locale> locales) {
        return filter(priorityList, locales, FilteringMode.AUTOSELECT_FILTERING);
    }

    public static List<String> filterTags(List<LanguageRange> priorityList, Collection<String> tags, FilteringMode mode) {
        return LocaleMatcher.filterTags(priorityList, tags, mode);
    }

    public static List<String> filterTags(List<LanguageRange> priorityList, Collection<String> tags) {
        return filterTags(priorityList, tags, FilteringMode.AUTOSELECT_FILTERING);
    }

    public static Locale lookup(List<LanguageRange> priorityList, Collection<Locale> locales) {
        return LocaleMatcher.lookup(priorityList, locales);
    }

    public static String lookupTag(List<LanguageRange> priorityList, Collection<String> tags) {
        return LocaleMatcher.lookupTag(priorityList, tags);
    }
}
