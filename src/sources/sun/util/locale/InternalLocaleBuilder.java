package sun.util.locale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class InternalLocaleBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final CaseInsensitiveChar PRIVATEUSE_KEY = new CaseInsensitiveChar(LanguageTag.PRIVATEUSE);
    private Map<CaseInsensitiveChar, String> extensions;
    private Set<CaseInsensitiveString> uattributes;
    private Map<CaseInsensitiveString, String> ukeywords;
    private String language = "";
    private String script = "";
    private String region = "";
    private String variant = "";

    public InternalLocaleBuilder setLanguage(String language) throws LocaleSyntaxException {
        if (LocaleUtils.isEmpty(language)) {
            this.language = "";
        } else {
            if (!LanguageTag.isLanguage(language)) {
                throw new LocaleSyntaxException("Ill-formed language: " + language, 0);
            }
            this.language = language;
        }
        return this;
    }

    public InternalLocaleBuilder setScript(String script) throws LocaleSyntaxException {
        if (LocaleUtils.isEmpty(script)) {
            this.script = "";
        } else {
            if (!LanguageTag.isScript(script)) {
                throw new LocaleSyntaxException("Ill-formed script: " + script, 0);
            }
            this.script = script;
        }
        return this;
    }

    public InternalLocaleBuilder setRegion(String region) throws LocaleSyntaxException {
        if (LocaleUtils.isEmpty(region)) {
            this.region = "";
        } else {
            if (!LanguageTag.isRegion(region)) {
                throw new LocaleSyntaxException("Ill-formed region: " + region, 0);
            }
            this.region = region;
        }
        return this;
    }

    public InternalLocaleBuilder setVariant(String variant) throws LocaleSyntaxException {
        if (LocaleUtils.isEmpty(variant)) {
            this.variant = "";
        } else {
            String var = variant.replaceAll("-", "_");
            int errIdx = checkVariants(var, "_");
            if (errIdx != -1) {
                throw new LocaleSyntaxException("Ill-formed variant: " + variant, errIdx);
            }
            this.variant = var;
        }
        return this;
    }

    public InternalLocaleBuilder addUnicodeLocaleAttribute(String attribute) throws LocaleSyntaxException {
        if (!UnicodeLocaleExtension.isAttribute(attribute)) {
            throw new LocaleSyntaxException("Ill-formed Unicode locale attribute: " + attribute);
        }
        if (this.uattributes == null) {
            this.uattributes = new HashSet(4);
        }
        this.uattributes.add(new CaseInsensitiveString(attribute));
        return this;
    }

    public InternalLocaleBuilder removeUnicodeLocaleAttribute(String attribute) throws LocaleSyntaxException {
        if (attribute == null || !UnicodeLocaleExtension.isAttribute(attribute)) {
            throw new LocaleSyntaxException("Ill-formed Unicode locale attribute: " + attribute);
        }
        Set<CaseInsensitiveString> set = this.uattributes;
        if (set != null) {
            set.remove(new CaseInsensitiveString(attribute));
        }
        return this;
    }

    public InternalLocaleBuilder setUnicodeLocaleKeyword(String key, String type) throws LocaleSyntaxException {
        if (!UnicodeLocaleExtension.isKey(key)) {
            throw new LocaleSyntaxException("Ill-formed Unicode locale keyword key: " + key);
        }
        CaseInsensitiveString cikey = new CaseInsensitiveString(key);
        if (type == null) {
            Map<CaseInsensitiveString, String> map = this.ukeywords;
            if (map != null) {
                map.remove(cikey);
            }
        } else {
            if (type.length() != 0) {
                String tp = type.replaceAll("_", "-");
                StringTokenIterator itr = new StringTokenIterator(tp, "-");
                while (!itr.isDone()) {
                    String s2 = itr.current();
                    if (!UnicodeLocaleExtension.isTypeSubtag(s2)) {
                        throw new LocaleSyntaxException("Ill-formed Unicode locale keyword type: " + type, itr.currentStart());
                    }
                    itr.next();
                }
            }
            if (this.ukeywords == null) {
                this.ukeywords = new HashMap(4);
            }
            this.ukeywords.put(cikey, type);
        }
        return this;
    }

    public InternalLocaleBuilder setExtension(char singleton, String value) throws LocaleSyntaxException {
        boolean validSubtag;
        boolean isBcpPrivateuse = LanguageTag.isPrivateusePrefixChar(singleton);
        if (!isBcpPrivateuse && !LanguageTag.isExtensionSingletonChar(singleton)) {
            throw new LocaleSyntaxException("Ill-formed extension key: " + singleton);
        }
        boolean remove = LocaleUtils.isEmpty(value);
        CaseInsensitiveChar key = new CaseInsensitiveChar(singleton);
        if (remove) {
            if (UnicodeLocaleExtension.isSingletonChar(key.value())) {
                Set<CaseInsensitiveString> set = this.uattributes;
                if (set != null) {
                    set.clear();
                }
                Map<CaseInsensitiveString, String> map = this.ukeywords;
                if (map != null) {
                    map.clear();
                }
            } else {
                Map<CaseInsensitiveChar, String> map2 = this.extensions;
                if (map2 != null && map2.containsKey(key)) {
                    this.extensions.remove(key);
                }
            }
        } else {
            String val = value.replaceAll("_", "-");
            StringTokenIterator itr = new StringTokenIterator(val, "-");
            while (!itr.isDone()) {
                String s2 = itr.current();
                if (isBcpPrivateuse) {
                    validSubtag = LanguageTag.isPrivateuseSubtag(s2);
                } else {
                    validSubtag = LanguageTag.isExtensionSubtag(s2);
                }
                if (!validSubtag) {
                    throw new LocaleSyntaxException("Ill-formed extension value: " + s2, itr.currentStart());
                }
                itr.next();
            }
            if (UnicodeLocaleExtension.isSingletonChar(key.value())) {
                setUnicodeLocaleExtension(val);
            } else {
                if (this.extensions == null) {
                    this.extensions = new HashMap(4);
                }
                this.extensions.put(key, val);
            }
        }
        return this;
    }

    public InternalLocaleBuilder setExtensions(String subtags) throws LocaleSyntaxException {
        if (LocaleUtils.isEmpty(subtags)) {
            clearExtensions();
            return this;
        }
        String subtags2 = subtags.replaceAll("_", "-");
        StringTokenIterator itr = new StringTokenIterator(subtags2, "-");
        List<String> extensions = null;
        String privateuse = null;
        int parsed = 0;
        while (!itr.isDone()) {
            String s2 = itr.current();
            if (!LanguageTag.isExtensionSingleton(s2)) {
                break;
            }
            int start = itr.currentStart();
            StringBuilder sb2 = new StringBuilder(s2);
            itr.next();
            while (!itr.isDone()) {
                String s10 = itr.current();
                if (!LanguageTag.isExtensionSubtag(s10)) {
                    break;
                }
                sb2.append("-").append(s10);
                parsed = itr.currentEnd();
                itr.next();
            }
            if (parsed < start) {
                throw new LocaleSyntaxException("Incomplete extension '" + s2 + "'", start);
            }
            if (extensions == null) {
                extensions = new ArrayList<>(4);
            }
            extensions.add(sb2.toString());
        }
        if (!itr.isDone()) {
            String s11 = itr.current();
            if (LanguageTag.isPrivateusePrefix(s11)) {
                int start2 = itr.currentStart();
                StringBuilder sb3 = new StringBuilder(s11);
                itr.next();
                while (!itr.isDone()) {
                    String s12 = itr.current();
                    if (!LanguageTag.isPrivateuseSubtag(s12)) {
                        break;
                    }
                    sb3.append("-").append(s12);
                    parsed = itr.currentEnd();
                    itr.next();
                }
                if (parsed <= start2) {
                    throw new LocaleSyntaxException("Incomplete privateuse:" + subtags2.substring(start2), start2);
                }
                privateuse = sb3.toString();
            }
        }
        if (!itr.isDone()) {
            throw new LocaleSyntaxException("Ill-formed extension subtags:" + subtags2.substring(itr.currentStart()), itr.currentStart());
        }
        return setExtensions(extensions, privateuse);
    }

    private InternalLocaleBuilder setExtensions(List<String> bcpExtensions, String privateuse) {
        clearExtensions();
        if (!LocaleUtils.isEmpty(bcpExtensions)) {
            Set<CaseInsensitiveChar> done = new HashSet<>(bcpExtensions.size());
            for (String bcpExt : bcpExtensions) {
                CaseInsensitiveChar key = new CaseInsensitiveChar(bcpExt);
                if (!done.contains(key)) {
                    if (UnicodeLocaleExtension.isSingletonChar(key.value())) {
                        setUnicodeLocaleExtension(bcpExt.substring(2));
                    } else {
                        if (this.extensions == null) {
                            this.extensions = new HashMap(4);
                        }
                        this.extensions.put(key, bcpExt.substring(2));
                    }
                }
                done.add(key);
            }
        }
        if (privateuse != null && !privateuse.isEmpty()) {
            if (this.extensions == null) {
                this.extensions = new HashMap(1);
            }
            this.extensions.put(new CaseInsensitiveChar(privateuse), privateuse.substring(2));
        }
        return this;
    }

    public InternalLocaleBuilder setLanguageTag(LanguageTag langtag) {
        clear();
        if (!langtag.getExtlangs().isEmpty()) {
            this.language = langtag.getExtlangs().get(0);
        } else {
            String lang = langtag.getLanguage();
            if (!lang.equals(LanguageTag.UNDETERMINED)) {
                this.language = lang;
            }
        }
        this.script = langtag.getScript();
        this.region = langtag.getRegion();
        List<String> bcpVariants = langtag.getVariants();
        if (!bcpVariants.isEmpty()) {
            StringBuilder var = new StringBuilder(bcpVariants.get(0));
            int size = bcpVariants.size();
            for (int i10 = 1; i10 < size; i10++) {
                var.append("_").append(bcpVariants.get(i10));
            }
            this.variant = var.toString();
        }
        setExtensions(langtag.getExtensions(), langtag.getPrivateuse());
        return this;
    }

    public InternalLocaleBuilder setLocale(BaseLocale base, LocaleExtensions localeExtensions) throws LocaleSyntaxException {
        int errIdx;
        String language = base.getLanguage();
        String script = base.getScript();
        String region = base.getRegion();
        String variant = base.getVariant();
        if (language.equals("ja") && region.equals("JP") && variant.equals("JP")) {
            variant = "";
        } else if (language.equals("th") && region.equals("TH") && variant.equals("TH")) {
            variant = "";
        } else if (language.equals("no") && region.equals("NO") && variant.equals("NY")) {
            language = "nn";
            variant = "";
        }
        if (!language.isEmpty() && !LanguageTag.isLanguage(language)) {
            throw new LocaleSyntaxException("Ill-formed language: " + language);
        }
        if (!script.isEmpty() && !LanguageTag.isScript(script)) {
            throw new LocaleSyntaxException("Ill-formed script: " + script);
        }
        if (!region.isEmpty() && !LanguageTag.isRegion(region)) {
            throw new LocaleSyntaxException("Ill-formed region: " + region);
        }
        if (!variant.isEmpty() && (errIdx = checkVariants((variant = variant.replaceAll("-", "_")), "_")) != -1) {
            throw new LocaleSyntaxException("Ill-formed variant: " + variant, errIdx);
        }
        this.language = language;
        this.script = script;
        this.region = region;
        this.variant = variant;
        clearExtensions();
        Set<Character> extKeys = localeExtensions == null ? null : localeExtensions.getKeys();
        if (extKeys != null) {
            for (Character key : extKeys) {
                Extension e2 = localeExtensions.getExtension(key);
                int i10 = 4;
                if (e2 instanceof UnicodeLocaleExtension) {
                    UnicodeLocaleExtension ue = (UnicodeLocaleExtension) e2;
                    for (String uatr : ue.getUnicodeLocaleAttributes()) {
                        if (this.uattributes == null) {
                            this.uattributes = new HashSet(4);
                        }
                        this.uattributes.add(new CaseInsensitiveString(uatr));
                    }
                    for (String ukey : ue.getUnicodeLocaleKeys()) {
                        if (this.ukeywords == null) {
                            this.ukeywords = new HashMap(i10);
                        }
                        this.ukeywords.put(new CaseInsensitiveString(ukey), ue.getUnicodeLocaleType(ukey));
                        i10 = 4;
                    }
                } else {
                    if (this.extensions == null) {
                        this.extensions = new HashMap(4);
                    }
                    this.extensions.put(new CaseInsensitiveChar(key.charValue()), e2.getValue());
                }
            }
        }
        return this;
    }

    public InternalLocaleBuilder clear() {
        this.language = "";
        this.script = "";
        this.region = "";
        this.variant = "";
        clearExtensions();
        return this;
    }

    public InternalLocaleBuilder clearExtensions() {
        Map<CaseInsensitiveChar, String> map = this.extensions;
        if (map != null) {
            map.clear();
        }
        Set<CaseInsensitiveString> set = this.uattributes;
        if (set != null) {
            set.clear();
        }
        Map<CaseInsensitiveString, String> map2 = this.ukeywords;
        if (map2 != null) {
            map2.clear();
        }
        return this;
    }

    public BaseLocale getBaseLocale() {
        String privuse;
        String language = this.language;
        String script = this.script;
        String region = this.region;
        String variant = this.variant;
        Map<CaseInsensitiveChar, String> map = this.extensions;
        if (map != null && (privuse = map.get(PRIVATEUSE_KEY)) != null) {
            StringTokenIterator itr = new StringTokenIterator(privuse, "-");
            boolean sawPrefix = false;
            int privVarStart = -1;
            while (true) {
                if (itr.isDone()) {
                    break;
                }
                if (sawPrefix) {
                    privVarStart = itr.currentStart();
                    break;
                }
                if (LocaleUtils.caseIgnoreMatch(itr.current(), LanguageTag.PRIVUSE_VARIANT_PREFIX)) {
                    sawPrefix = true;
                }
                itr.next();
            }
            if (privVarStart != -1) {
                StringBuilder sb2 = new StringBuilder(variant);
                if (sb2.length() != 0) {
                    sb2.append("_");
                }
                sb2.append(privuse.substring(privVarStart).replaceAll("-", "_"));
                variant = sb2.toString();
            }
        }
        return BaseLocale.getInstance(language, script, region, variant);
    }

    public LocaleExtensions getLocaleExtensions() {
        if (LocaleUtils.isEmpty(this.extensions) && LocaleUtils.isEmpty(this.uattributes) && LocaleUtils.isEmpty(this.ukeywords)) {
            return null;
        }
        LocaleExtensions lext = new LocaleExtensions(this.extensions, this.uattributes, this.ukeywords);
        if (lext.isEmpty()) {
            return null;
        }
        return lext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String removePrivateuseVariant(String privuseVal) {
        StringTokenIterator itr = new StringTokenIterator(privuseVal, "-");
        int prefixStart = -1;
        boolean sawPrivuseVar = false;
        while (true) {
            if (itr.isDone()) {
                break;
            }
            if (prefixStart != -1) {
                sawPrivuseVar = true;
                break;
            }
            if (LocaleUtils.caseIgnoreMatch(itr.current(), LanguageTag.PRIVUSE_VARIANT_PREFIX)) {
                prefixStart = itr.currentStart();
            }
            itr.next();
        }
        if (!sawPrivuseVar) {
            return privuseVal;
        }
        if (prefixStart == 0) {
            return null;
        }
        return privuseVal.substring(0, prefixStart - 1);
    }

    private int checkVariants(String variants, String sep) {
        StringTokenIterator itr = new StringTokenIterator(variants, sep);
        while (!itr.isDone()) {
            String s2 = itr.current();
            if (!LanguageTag.isVariant(s2)) {
                return itr.currentStart();
            }
            itr.next();
        }
        return -1;
    }

    private void setUnicodeLocaleExtension(String subtags) {
        Set<CaseInsensitiveString> set = this.uattributes;
        if (set != null) {
            set.clear();
        }
        Map<CaseInsensitiveString, String> map = this.ukeywords;
        if (map != null) {
            map.clear();
        }
        StringTokenIterator itr = new StringTokenIterator(subtags, "-");
        while (!itr.isDone() && UnicodeLocaleExtension.isAttribute(itr.current())) {
            if (this.uattributes == null) {
                this.uattributes = new HashSet(4);
            }
            this.uattributes.add(new CaseInsensitiveString(itr.current()));
            itr.next();
        }
        CaseInsensitiveString key = null;
        int typeStart = -1;
        int typeEnd = -1;
        while (!itr.isDone()) {
            if (key != null) {
                if (UnicodeLocaleExtension.isKey(itr.current())) {
                    String type = typeStart == -1 ? "" : subtags.substring(typeStart, typeEnd);
                    if (this.ukeywords == null) {
                        this.ukeywords = new HashMap(4);
                    }
                    this.ukeywords.put(key, type);
                    CaseInsensitiveString tmpKey = new CaseInsensitiveString(itr.current());
                    key = this.ukeywords.containsKey(tmpKey) ? null : tmpKey;
                    typeEnd = -1;
                    typeStart = -1;
                } else {
                    if (typeStart == -1) {
                        typeStart = itr.currentStart();
                    }
                    typeEnd = itr.currentEnd();
                }
            } else if (UnicodeLocaleExtension.isKey(itr.current())) {
                key = new CaseInsensitiveString(itr.current());
                Map<CaseInsensitiveString, String> map2 = this.ukeywords;
                if (map2 != null && map2.containsKey(key)) {
                    key = null;
                }
            }
            if (!itr.hasNext()) {
                if (key != null) {
                    String type2 = typeStart != -1 ? subtags.substring(typeStart, typeEnd) : "";
                    if (this.ukeywords == null) {
                        this.ukeywords = new HashMap(4);
                    }
                    this.ukeywords.put(key, type2);
                    return;
                }
                return;
            }
            itr.next();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class CaseInsensitiveString {
        private final String lowerStr;
        private final String str;

        CaseInsensitiveString(String s2) {
            this.str = s2;
            this.lowerStr = LocaleUtils.toLowerString(s2);
        }

        public String value() {
            return this.str;
        }

        public int hashCode() {
            return this.lowerStr.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CaseInsensitiveString)) {
                return false;
            }
            return this.lowerStr.equals(((CaseInsensitiveString) obj).lowerStr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class CaseInsensitiveChar {
        private final char ch;
        private final char lowerCh;

        private CaseInsensitiveChar(String s2) {
            this(s2.charAt(0));
        }

        CaseInsensitiveChar(char c4) {
            this.ch = c4;
            this.lowerCh = LocaleUtils.toLower(c4);
        }

        public char value() {
            return this.ch;
        }

        public int hashCode() {
            return this.lowerCh;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CaseInsensitiveChar) && this.lowerCh == ((CaseInsensitiveChar) obj).lowerCh;
        }
    }
}
