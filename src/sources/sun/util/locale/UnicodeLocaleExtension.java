package sun.util.locale;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.StringJoiner;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class UnicodeLocaleExtension extends Extension {
    public static final UnicodeLocaleExtension CA_JAPANESE = new UnicodeLocaleExtension("ca", "japanese");
    public static final UnicodeLocaleExtension NU_THAI = new UnicodeLocaleExtension("nu", "thai");
    public static final char SINGLETON = 'u';
    private final Set<String> attributes;
    private final Map<String, String> keywords;

    @Override // sun.util.locale.Extension
    public /* bridge */ /* synthetic */ String getID() {
        return super.getID();
    }

    @Override // sun.util.locale.Extension
    public /* bridge */ /* synthetic */ char getKey() {
        return super.getKey();
    }

    @Override // sun.util.locale.Extension
    public /* bridge */ /* synthetic */ String getValue() {
        return super.getValue();
    }

    @Override // sun.util.locale.Extension
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    private UnicodeLocaleExtension(String key, String value) {
        super('u', key + "-" + value);
        this.attributes = Collections.emptySet();
        this.keywords = Collections.singletonMap(key, value);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnicodeLocaleExtension(SortedSet<String> attributes, SortedMap<String, String> keywords) {
        super('u');
        if (attributes != null) {
            this.attributes = attributes;
        } else {
            this.attributes = Collections.emptySet();
        }
        if (keywords != null) {
            this.keywords = keywords;
        } else {
            this.keywords = Collections.emptyMap();
        }
        if (!this.attributes.isEmpty() || !this.keywords.isEmpty()) {
            StringJoiner sj = new StringJoiner("-");
            for (String attribute : this.attributes) {
                sj.add(attribute);
            }
            for (Map.Entry<String, String> keyword : this.keywords.entrySet()) {
                String key = keyword.getKey();
                String value = keyword.getValue();
                sj.add(key);
                if (!value.isEmpty()) {
                    sj.add(value);
                }
            }
            setValue(sj.toString());
        }
    }

    public Set<String> getUnicodeLocaleAttributes() {
        if (this.attributes == Collections.EMPTY_SET) {
            return this.attributes;
        }
        return Collections.unmodifiableSet(this.attributes);
    }

    public Set<String> getUnicodeLocaleKeys() {
        if (this.keywords == Collections.EMPTY_MAP) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(this.keywords.h());
    }

    public String getUnicodeLocaleType(String unicodeLocaleKey) {
        return this.keywords.get(unicodeLocaleKey);
    }

    public static boolean isSingletonChar(char c4) {
        return 'u' == LocaleUtils.toLower(c4);
    }

    public static boolean isAttribute(String s2) {
        int len = s2.length();
        return len >= 3 && len <= 8 && LocaleUtils.isAlphaNumericString(s2);
    }

    public static boolean isKey(String s2) {
        return s2.length() == 2 && LocaleUtils.isAlphaNumericString(s2);
    }

    public static boolean isTypeSubtag(String s2) {
        int len = s2.length();
        return len >= 3 && len <= 8 && LocaleUtils.isAlphaNumericString(s2);
    }
}
