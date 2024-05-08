package sun.util.locale;

import com.huawei.flexiblelayout.u0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class LanguageTag {
    private static final Map<String, String[]> LEGACY = new HashMap();
    public static final String PRIVATEUSE = "x";
    public static final String PRIVUSE_VARIANT_PREFIX = "lvariant";
    public static final String SEP = "-";
    public static final String UNDETERMINED = "und";
    private String language = "";
    private String script = "";
    private String region = "";
    private String privateuse = "";
    private List<String> extlangs = Collections.emptyList();
    private List<String> variants = Collections.emptyList();
    private List<String> extensions = Collections.emptyList();

    static {
        String[][] entries = {new String[]{"art-lojban", "jbo"}, new String[]{"cel-gaulish", "xtg-x-cel-gaulish"}, new String[]{"en-GB-oed", "en-GB-x-oed"}, new String[]{"i-ami", "ami"}, new String[]{"i-bnn", "bnn"}, new String[]{"i-default", "en-x-i-default"}, new String[]{"i-enochian", "und-x-i-enochian"}, new String[]{"i-hak", "hak"}, new String[]{"i-klingon", "tlh"}, new String[]{"i-lux", "lb"}, new String[]{"i-mingo", "see-x-i-mingo"}, new String[]{"i-navajo", "nv"}, new String[]{"i-pwn", "pwn"}, new String[]{"i-tao", "tao"}, new String[]{"i-tay", "tay"}, new String[]{"i-tsu", "tsu"}, new String[]{"no-bok", "nb"}, new String[]{"no-nyn", "nn"}, new String[]{"sgn-BE-FR", "sfb"}, new String[]{"sgn-BE-NL", "vgt"}, new String[]{"sgn-CH-DE", "sgg"}, new String[]{"zh-guoyu", "cmn"}, new String[]{"zh-hakka", "hak"}, new String[]{"zh-min", "nan-x-zh-min"}, new String[]{"zh-min-nan", "nan"}, new String[]{"zh-xiang", "hsn"}};
        for (String[] e2 : entries) {
            LEGACY.put(LocaleUtils.toLowerString(e2[0]), e2);
        }
    }

    private LanguageTag() {
    }

    public static LanguageTag parse(String languageTag, ParseStatus sts) {
        StringTokenIterator itr;
        if (sts == null) {
            sts = new ParseStatus();
        } else {
            sts.reset();
        }
        String[] gfmap = LEGACY.get(LocaleUtils.toLowerString(languageTag));
        if (gfmap != null) {
            itr = new StringTokenIterator(gfmap[1], "-");
        } else {
            itr = new StringTokenIterator(languageTag, "-");
        }
        LanguageTag tag = new LanguageTag();
        if (tag.parseLanguage(itr, sts)) {
            tag.parseExtlangs(itr, sts);
            tag.parseScript(itr, sts);
            tag.parseRegion(itr, sts);
            tag.parseVariants(itr, sts);
            tag.parseExtensions(itr, sts);
        }
        tag.parsePrivateuse(itr, sts);
        if (!itr.isDone() && !sts.isError()) {
            String s2 = itr.current();
            sts.errorIndex = itr.currentStart();
            if (s2.isEmpty()) {
                sts.errorMsg = "Empty subtag";
            } else {
                sts.errorMsg = "Invalid subtag: " + s2;
            }
        }
        return tag;
    }

    private boolean parseLanguage(StringTokenIterator itr, ParseStatus sts) {
        if (itr.isDone() || sts.isError()) {
            return false;
        }
        String s2 = itr.current();
        if (!isLanguage(s2)) {
            return false;
        }
        this.language = s2;
        sts.parseLength = itr.currentEnd();
        itr.next();
        return true;
    }

    private boolean parseExtlangs(StringTokenIterator itr, ParseStatus sts) {
        if (itr.isDone() || sts.isError()) {
            return false;
        }
        boolean found = false;
        while (!itr.isDone()) {
            String s2 = itr.current();
            if (!isExtlang(s2)) {
                break;
            }
            found = true;
            if (this.extlangs.isEmpty()) {
                this.extlangs = new ArrayList(3);
            }
            this.extlangs.add(s2);
            sts.parseLength = itr.currentEnd();
            itr.next();
            if (this.extlangs.size() == 3) {
                break;
            }
        }
        return found;
    }

    private boolean parseScript(StringTokenIterator itr, ParseStatus sts) {
        if (itr.isDone() || sts.isError()) {
            return false;
        }
        String s2 = itr.current();
        if (!isScript(s2)) {
            return false;
        }
        this.script = s2;
        sts.parseLength = itr.currentEnd();
        itr.next();
        return true;
    }

    private boolean parseRegion(StringTokenIterator itr, ParseStatus sts) {
        if (itr.isDone() || sts.isError()) {
            return false;
        }
        String s2 = itr.current();
        if (!isRegion(s2)) {
            return false;
        }
        this.region = s2;
        sts.parseLength = itr.currentEnd();
        itr.next();
        return true;
    }

    private boolean parseVariants(StringTokenIterator itr, ParseStatus sts) {
        if (itr.isDone() || sts.isError()) {
            return false;
        }
        boolean found = false;
        while (!itr.isDone()) {
            String s2 = itr.current();
            if (!isVariant(s2)) {
                break;
            }
            found = true;
            if (this.variants.isEmpty()) {
                this.variants = new ArrayList(3);
            }
            this.variants.add(s2);
            sts.parseLength = itr.currentEnd();
            itr.next();
        }
        return found;
    }

    private boolean parseExtensions(StringTokenIterator itr, ParseStatus sts) {
        if (itr.isDone() || sts.isError()) {
            return false;
        }
        boolean found = false;
        while (true) {
            if (!itr.isDone()) {
                String s2 = itr.current();
                if (!isExtensionSingleton(s2)) {
                    break;
                }
                int start = itr.currentStart();
                StringBuilder sb2 = new StringBuilder(s2);
                itr.next();
                while (!itr.isDone()) {
                    String s10 = itr.current();
                    if (!isExtensionSubtag(s10)) {
                        break;
                    }
                    sb2.append("-").append(s10);
                    sts.parseLength = itr.currentEnd();
                    itr.next();
                }
                if (sts.parseLength <= start) {
                    sts.errorIndex = start;
                    sts.errorMsg = "Incomplete extension '" + s2 + "'";
                    break;
                }
                if (this.extensions.isEmpty()) {
                    this.extensions = new ArrayList(4);
                }
                this.extensions.add(sb2.toString());
                found = true;
            } else {
                break;
            }
        }
        return found;
    }

    private boolean parsePrivateuse(StringTokenIterator itr, ParseStatus sts) {
        if (itr.isDone() || sts.isError()) {
            return false;
        }
        String s2 = itr.current();
        if (!isPrivateusePrefix(s2)) {
            return false;
        }
        int start = itr.currentStart();
        StringBuilder sb2 = new StringBuilder(s2);
        itr.next();
        while (!itr.isDone()) {
            String s10 = itr.current();
            if (!isPrivateuseSubtag(s10)) {
                break;
            }
            sb2.append("-").append(s10);
            sts.parseLength = itr.currentEnd();
            itr.next();
        }
        if (sts.parseLength <= start) {
            sts.errorIndex = start;
            sts.errorMsg = "Incomplete privateuse";
            return false;
        }
        this.privateuse = sb2.toString();
        return true;
    }

    public static LanguageTag parseLocale(BaseLocale baseLocale, LocaleExtensions localeExtensions) {
        String language;
        LocaleExtensions localeExtensions2 = localeExtensions;
        LanguageTag tag = new LanguageTag();
        String language2 = baseLocale.getLanguage();
        String script = baseLocale.getScript();
        String region = baseLocale.getRegion();
        String variant = baseLocale.getVariant();
        boolean hasSubtag = false;
        String privuseVar = null;
        if (isLanguage(language2)) {
            if (language2.equals("iw")) {
                language2 = "he";
            } else if (language2.equals("ji")) {
                language2 = "yi";
            } else if (language2.equals(u0.f28637e)) {
                language2 = "id";
            }
            tag.language = language2;
        }
        if (isScript(script)) {
            tag.script = canonicalizeScript(script);
            hasSubtag = true;
        }
        if (isRegion(region)) {
            tag.region = canonicalizeRegion(region);
            hasSubtag = true;
        }
        if (tag.language.equals("no") && tag.region.equals("NO") && variant.equals("NY")) {
            tag.language = "nn";
            variant = "";
        }
        if (!variant.isEmpty()) {
            List<String> variants = null;
            StringTokenIterator varitr = new StringTokenIterator(variant, "_");
            while (!varitr.isDone()) {
                String var = varitr.current();
                if (!isVariant(var)) {
                    break;
                }
                if (variants == null) {
                    variants = new ArrayList<>();
                }
                variants.add(var);
                varitr.next();
            }
            if (variants != null) {
                tag.variants = variants;
                hasSubtag = true;
            }
            if (!varitr.isDone()) {
                StringJoiner sj = new StringJoiner("-");
                while (!varitr.isDone()) {
                    String prvv = varitr.current();
                    if (!isPrivateuseSubtag(prvv)) {
                        break;
                    }
                    sj.add(prvv);
                    varitr.next();
                }
                if (sj.length() > 0) {
                    privuseVar = sj.toString();
                }
            }
        }
        List<String> extensions = null;
        String privateuse = null;
        if (localeExtensions2 != null) {
            Set<Character> locextKeys = localeExtensions.getKeys();
            for (Character locextKey : locextKeys) {
                Extension ext = localeExtensions2.getExtension(locextKey);
                if (isPrivateusePrefixChar(locextKey.charValue())) {
                    privateuse = ext.getValue();
                    language = language2;
                } else {
                    if (extensions == null) {
                        extensions = new ArrayList<>();
                    }
                    language = language2;
                    extensions.add(locextKey.toString() + "-" + ext.getValue());
                }
                localeExtensions2 = localeExtensions;
                language2 = language;
            }
        }
        if (extensions != null) {
            tag.extensions = extensions;
            hasSubtag = true;
        }
        if (privuseVar != null) {
            if (privateuse == null) {
                privateuse = "lvariant-" + privuseVar;
            } else {
                privateuse = privateuse + "-" + PRIVUSE_VARIANT_PREFIX + "-" + privuseVar.replace("_", "-");
            }
        }
        if (privateuse != null) {
            tag.privateuse = privateuse;
        }
        if (tag.language.isEmpty() && (hasSubtag || privateuse == null)) {
            tag.language = UNDETERMINED;
        }
        return tag;
    }

    public String getLanguage() {
        return this.language;
    }

    public List<String> getExtlangs() {
        if (this.extlangs.isEmpty()) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(this.extlangs);
    }

    public String getScript() {
        return this.script;
    }

    public String getRegion() {
        return this.region;
    }

    public List<String> getVariants() {
        if (this.variants.isEmpty()) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(this.variants);
    }

    public List<String> getExtensions() {
        if (this.extensions.isEmpty()) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(this.extensions);
    }

    public String getPrivateuse() {
        return this.privateuse;
    }

    public static boolean isLanguage(String s2) {
        int len = s2.length();
        return len >= 2 && len <= 8 && LocaleUtils.isAlphaString(s2);
    }

    public static boolean isExtlang(String s2) {
        return s2.length() == 3 && LocaleUtils.isAlphaString(s2);
    }

    public static boolean isScript(String s2) {
        return s2.length() == 4 && LocaleUtils.isAlphaString(s2);
    }

    public static boolean isRegion(String s2) {
        return (s2.length() == 2 && LocaleUtils.isAlphaString(s2)) || (s2.length() == 3 && LocaleUtils.isNumericString(s2));
    }

    public static boolean isVariant(String s2) {
        int len = s2.length();
        if (len < 5 || len > 8) {
            return len == 4 && LocaleUtils.isNumeric(s2.charAt(0)) && LocaleUtils.isAlphaNumeric(s2.charAt(1)) && LocaleUtils.isAlphaNumeric(s2.charAt(2)) && LocaleUtils.isAlphaNumeric(s2.charAt(3));
        }
        return LocaleUtils.isAlphaNumericString(s2);
    }

    public static boolean isExtensionSingleton(String s2) {
        return s2.length() == 1 && LocaleUtils.isAlphaString(s2) && !LocaleUtils.caseIgnoreMatch(PRIVATEUSE, s2);
    }

    public static boolean isExtensionSingletonChar(char c4) {
        return isExtensionSingleton(String.valueOf(c4));
    }

    public static boolean isExtensionSubtag(String s2) {
        int len = s2.length();
        return len >= 2 && len <= 8 && LocaleUtils.isAlphaNumericString(s2);
    }

    public static boolean isPrivateusePrefix(String s2) {
        return s2.length() == 1 && LocaleUtils.caseIgnoreMatch(PRIVATEUSE, s2);
    }

    public static boolean isPrivateusePrefixChar(char c4) {
        return LocaleUtils.caseIgnoreMatch(PRIVATEUSE, String.valueOf(c4));
    }

    public static boolean isPrivateuseSubtag(String s2) {
        int len = s2.length();
        return len >= 1 && len <= 8 && LocaleUtils.isAlphaNumericString(s2);
    }

    public static String canonicalizeLanguage(String s2) {
        return LocaleUtils.toLowerString(s2);
    }

    public static String canonicalizeExtlang(String s2) {
        return LocaleUtils.toLowerString(s2);
    }

    public static String canonicalizeScript(String s2) {
        return LocaleUtils.toTitleString(s2);
    }

    public static String canonicalizeRegion(String s2) {
        return LocaleUtils.toUpperString(s2);
    }

    public static String canonicalizeVariant(String s2) {
        return LocaleUtils.toLowerString(s2);
    }

    public static String canonicalizeExtension(String s2) {
        return LocaleUtils.toLowerString(s2);
    }

    public static String canonicalizeExtensionSingleton(String s2) {
        return LocaleUtils.toLowerString(s2);
    }

    public static String canonicalizeExtensionSubtag(String s2) {
        return LocaleUtils.toLowerString(s2);
    }

    public static String canonicalizePrivateuse(String s2) {
        return LocaleUtils.toLowerString(s2);
    }

    public static String canonicalizePrivateuseSubtag(String s2) {
        return LocaleUtils.toLowerString(s2);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (!this.language.isEmpty()) {
            sb2.append(this.language);
            for (String extlang : this.extlangs) {
                sb2.append("-").append(extlang);
            }
            if (!this.script.isEmpty()) {
                sb2.append("-").append(this.script);
            }
            if (!this.region.isEmpty()) {
                sb2.append("-").append(this.region);
            }
            for (String variant : this.variants) {
                sb2.append("-").append(variant);
            }
            for (String extension : this.extensions) {
                sb2.append("-").append(extension);
            }
        }
        if (!this.privateuse.isEmpty()) {
            if (sb2.length() > 0) {
                sb2.append("-");
            }
            sb2.append(this.privateuse);
        }
        return sb2.toString();
    }
}
