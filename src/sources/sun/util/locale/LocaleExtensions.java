package sun.util.locale;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import sun.util.locale.InternalLocaleBuilder;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class LocaleExtensions {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final LocaleExtensions CALENDAR_JAPANESE = new LocaleExtensions("u-ca-japanese", (Character) 'u', (Extension) UnicodeLocaleExtension.CA_JAPANESE);
    public static final LocaleExtensions NUMBER_THAI = new LocaleExtensions("u-nu-thai", (Character) 'u', (Extension) UnicodeLocaleExtension.NU_THAI);
    private final Map<Character, Extension> extensionMap;

    /* renamed from: id, reason: collision with root package name */
    private final String f53750id;

    private LocaleExtensions(String id2, Character key, Extension value) {
        this.f53750id = id2;
        this.extensionMap = Collections.singletonMap(key, value);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocaleExtensions(Map<InternalLocaleBuilder.CaseInsensitiveChar, String> extensions, Set<InternalLocaleBuilder.CaseInsensitiveString> uattributes, Map<InternalLocaleBuilder.CaseInsensitiveString, String> ukeywords) {
        boolean hasExtension = !LocaleUtils.isEmpty(extensions);
        boolean hasUAttributes = !LocaleUtils.isEmpty(uattributes);
        boolean hasUKeywords = !LocaleUtils.isEmpty(ukeywords);
        if (!hasExtension && !hasUAttributes && !hasUKeywords) {
            this.f53750id = "";
            this.extensionMap = Collections.emptyMap();
            return;
        }
        SortedMap<Character, Extension> map = new TreeMap<>();
        if (hasExtension) {
            for (Map.Entry<InternalLocaleBuilder.CaseInsensitiveChar, String> ext : extensions.entrySet()) {
                char key = LocaleUtils.toLower(ext.getKey().value());
                String value = ext.getValue();
                if (!LanguageTag.isPrivateusePrefixChar(key) || (value = InternalLocaleBuilder.removePrivateuseVariant(value)) != null) {
                    map.put(Character.valueOf(key), new Extension(key, LocaleUtils.toLowerString(value)));
                }
            }
        }
        if (hasUAttributes || hasUKeywords) {
            SortedSet<String> uaset = null;
            SortedMap<String, String> ukmap = null;
            if (hasUAttributes) {
                uaset = new TreeSet<>();
                for (InternalLocaleBuilder.CaseInsensitiveString cis : uattributes) {
                    uaset.add(LocaleUtils.toLowerString(cis.value()));
                }
            }
            if (hasUKeywords) {
                ukmap = new TreeMap<>();
                for (Map.Entry<InternalLocaleBuilder.CaseInsensitiveString, String> kwd : ukeywords.entrySet()) {
                    String key2 = LocaleUtils.toLowerString(kwd.getKey().value());
                    String type = LocaleUtils.toLowerString(kwd.getValue());
                    ukmap.put(key2, type);
                }
            }
            UnicodeLocaleExtension ule = new UnicodeLocaleExtension(uaset, ukmap);
            map.put('u', ule);
        }
        if (map.isEmpty()) {
            this.f53750id = "";
            this.extensionMap = Collections.emptyMap();
        } else {
            this.f53750id = toID(map);
            this.extensionMap = map;
        }
    }

    public Set<Character> getKeys() {
        if (this.extensionMap.isEmpty()) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(this.extensionMap.h());
    }

    public Extension getExtension(Character key) {
        return this.extensionMap.get(Character.valueOf(LocaleUtils.toLower(key.charValue())));
    }

    public String getExtensionValue(Character key) {
        Extension ext = this.extensionMap.get(Character.valueOf(LocaleUtils.toLower(key.charValue())));
        if (ext == null) {
            return null;
        }
        return ext.getValue();
    }

    public Set<String> getUnicodeLocaleAttributes() {
        Extension ext = this.extensionMap.get('u');
        if (ext == null) {
            return Collections.emptySet();
        }
        return ((UnicodeLocaleExtension) ext).getUnicodeLocaleAttributes();
    }

    public Set<String> getUnicodeLocaleKeys() {
        Extension ext = this.extensionMap.get('u');
        if (ext == null) {
            return Collections.emptySet();
        }
        return ((UnicodeLocaleExtension) ext).getUnicodeLocaleKeys();
    }

    public String getUnicodeLocaleType(String unicodeLocaleKey) {
        Extension ext = this.extensionMap.get('u');
        if (ext == null) {
            return null;
        }
        return ((UnicodeLocaleExtension) ext).getUnicodeLocaleType(LocaleUtils.toLowerString(unicodeLocaleKey));
    }

    public boolean isEmpty() {
        return this.extensionMap.isEmpty();
    }

    public static boolean isValidKey(char c4) {
        return LanguageTag.isExtensionSingletonChar(c4) || LanguageTag.isPrivateusePrefixChar(c4);
    }

    public static boolean isValidUnicodeLocaleKey(String ukey) {
        return UnicodeLocaleExtension.isKey(ukey);
    }

    private static String toID(SortedMap<Character, Extension> map) {
        StringBuilder buf = new StringBuilder();
        Extension privuse = null;
        for (Map.Entry<Character, Extension> entry : map.entrySet()) {
            char singleton = entry.getKey().charValue();
            Extension extension = entry.getValue();
            if (LanguageTag.isPrivateusePrefixChar(singleton)) {
                privuse = extension;
            } else {
                if (buf.length() > 0) {
                    buf.append("-");
                }
                buf.append((Object) extension);
            }
        }
        if (privuse != null) {
            if (buf.length() > 0) {
                buf.append("-");
            }
            buf.append((Object) privuse);
        }
        return buf.toString();
    }

    public String toString() {
        return this.f53750id;
    }

    public String getID() {
        return this.f53750id;
    }

    public int hashCode() {
        return this.f53750id.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocaleExtensions)) {
            return false;
        }
        return this.f53750id.equals(((LocaleExtensions) other).f53750id);
    }
}
