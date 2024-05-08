package com.android.internal.app;

import android.icu.text.CaseMap;
import android.icu.text.ListFormatter;
import android.icu.text.NumberingSystem;
import android.icu.util.ULocale;
import android.os.LocaleList;
import android.text.TextUtils;
import com.android.internal.app.LocaleStore;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class LocaleHelper {
    public static String toSentenceCase(String str, Locale locale) {
        return CaseMap.toTitle().wholeString().noLowercase().apply(locale, null, str);
    }

    public static String normalizeForSearch(String str, Locale locale) {
        return str.toUpperCase();
    }

    private static boolean shouldUseDialectName(Locale locale) {
        String lang = locale.getLanguage();
        return "fa".equals(lang) || "ro".equals(lang) || "zh".equals(lang);
    }

    public static String getDisplayName(Locale locale, Locale displayLocale, boolean sentenceCase) {
        String result;
        ULocale displayULocale = ULocale.forLocale(displayLocale);
        if (shouldUseDialectName(locale)) {
            result = ULocale.getDisplayNameWithDialect(locale.toLanguageTag(), displayULocale);
        } else {
            result = ULocale.getDisplayName(locale.toLanguageTag(), displayULocale);
        }
        return sentenceCase ? toSentenceCase(result, displayLocale) : result;
    }

    public static String getDisplayName(Locale locale, boolean sentenceCase) {
        return getDisplayName(locale, Locale.getDefault(), sentenceCase);
    }

    public static String getDisplayCountry(Locale locale, Locale displayLocale) {
        String languageTag = locale.toLanguageTag();
        ULocale uDisplayLocale = ULocale.forLocale(displayLocale);
        String country = ULocale.getDisplayCountry(languageTag, uDisplayLocale);
        String numberingSystem = locale.getUnicodeLocaleType("nu");
        if (numberingSystem != null) {
            return String.format("%s (%s)", country, ULocale.getDisplayKeywordValue(languageTag, "numbers", uDisplayLocale));
        }
        return country;
    }

    public static String getDisplayCountry(Locale locale) {
        return ULocale.getDisplayCountry(locale.toLanguageTag(), ULocale.getDefault());
    }

    public static String getDisplayLocaleList(LocaleList locales, Locale displayLocale, int maxLocales) {
        int localeCount;
        int localeCount2;
        Locale dispLocale = displayLocale == null ? Locale.getDefault() : displayLocale;
        boolean ellipsisNeeded = locales.size() > maxLocales;
        if (ellipsisNeeded) {
            localeCount2 = maxLocales;
            localeCount = maxLocales + 1;
        } else {
            localeCount = locales.size();
            localeCount2 = localeCount;
        }
        String[] localeNames = new String[localeCount];
        for (int i10 = 0; i10 < localeCount2; i10++) {
            localeNames[i10] = getDisplayName(locales.get(i10), dispLocale, false);
        }
        if (ellipsisNeeded) {
            localeNames[maxLocales] = TextUtils.getEllipsisString(TextUtils.TruncateAt.END);
        }
        ListFormatter lfn = ListFormatter.getInstance(dispLocale);
        return lfn.format(localeNames);
    }

    public static String getDisplayNumberingSystemKeyValue(Locale locale, Locale displayLocale) {
        ULocale uLocale = new ULocale.Builder().setUnicodeLocaleKeyword("nu", NumberingSystem.getInstance(locale).getName()).build();
        return uLocale.getDisplayKeywordValue("numbers", ULocale.forLocale(displayLocale));
    }

    public static Locale addLikelySubtags(Locale locale) {
        return ULocale.addLikelySubtags(ULocale.forLocale(locale)).toLocale();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class LocaleInfoComparator implements Comparator<LocaleStore.LocaleInfo> {
        private static final String PREFIX_ARABIC = "ال";
        private final Collator mCollator;
        private final boolean mCountryMode;

        public LocaleInfoComparator(Locale sortLocale, boolean countryMode) {
            this.mCollator = Collator.getInstance(sortLocale);
            this.mCountryMode = countryMode;
        }

        private String removePrefixForCompare(Locale locale, String str) {
            if ("ar".equals(locale.getLanguage()) && str.startsWith(PREFIX_ARABIC)) {
                return str.substring(PREFIX_ARABIC.length());
            }
            return str;
        }

        @Override // java.util.Comparator
        public int compare(LocaleStore.LocaleInfo lhs, LocaleStore.LocaleInfo rhs) {
            if (lhs.isAppCurrentLocale() || rhs.isAppCurrentLocale()) {
                return lhs.isAppCurrentLocale() ? -1 : 1;
            }
            if (lhs.isSystemLocale() || rhs.isSystemLocale()) {
                return lhs.isSystemLocale() ? -1 : 1;
            }
            if (lhs.isSuggested() == rhs.isSuggested()) {
                return this.mCollator.compare(removePrefixForCompare(lhs.getLocale(), lhs.getLabel(this.mCountryMode)), removePrefixForCompare(rhs.getLocale(), rhs.getLabel(this.mCountryMode)));
            }
            return lhs.isSuggested() ? -1 : 1;
        }
    }
}
