package java.util;

import com.ss.android.socialbase.downloader.segment.Segment;
import java.io.Serializable;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import libcore.icu.ICU;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Currency implements Serializable {
    private static HashSet<Currency> available = null;
    private static ConcurrentMap<String, Currency> instances = new ConcurrentHashMap(7);
    private static final long serialVersionUID = -158308464356906721L;
    private final String currencyCode;
    private final transient android.icu.util.Currency icuCurrency;

    private Currency(android.icu.util.Currency icuCurrency) {
        this.icuCurrency = icuCurrency;
        this.currencyCode = icuCurrency.getCurrencyCode();
    }

    public static Currency getInstance(String currencyCode) {
        Currency instance = instances.get(currencyCode);
        if (instance != null) {
            return instance;
        }
        android.icu.util.Currency icuInstance = android.icu.util.Currency.getInstance(currencyCode);
        if (icuInstance == null) {
            return null;
        }
        Currency currencyVal = new Currency(icuInstance);
        Currency instance2 = instances.putIfAbsent(currencyCode, currencyVal);
        return instance2 != null ? instance2 : currencyVal;
    }

    public static Currency getInstance(Locale locale) {
        String override = locale.getUnicodeLocaleType(Segment.JsonKey.CURRENT);
        if (override != null) {
            try {
                return getInstance(override.toUpperCase(Locale.ROOT));
            } catch (IllegalArgumentException e2) {
            }
        }
        String country = locale.getCountry();
        android.icu.util.Currency icuInstance = android.icu.util.Currency.getInstance(locale);
        String variant = locale.getVariant();
        if (!variant.isEmpty() && (variant.equals("EURO") || variant.equals("HK") || variant.equals("PREEURO"))) {
            country = country + "_" + variant;
        }
        if (!ICU.isIsoCountry(country)) {
            throw new IllegalArgumentException("Unsupported ISO 3166 country: " + ((Object) locale));
        }
        String currencyCode = ICU.getCurrencyCode(country);
        if (currencyCode == null || icuInstance == null || icuInstance.getCurrencyCode().equals("XXX")) {
            return null;
        }
        return getInstance(currencyCode);
    }

    public static Set<Currency> getAvailableCurrencies() {
        synchronized (Currency.class) {
            if (available == null) {
                available = new HashSet<>();
                Set<android.icu.util.Currency> icuAvailableCurrencies = android.icu.util.Currency.getAvailableCurrencies();
                for (android.icu.util.Currency icuCurrency : icuAvailableCurrencies) {
                    Currency currency = getInstance(icuCurrency.getCurrencyCode());
                    if (currency == null) {
                        currency = new Currency(icuCurrency);
                        instances.put(currency.currencyCode, currency);
                    }
                    available.add(currency);
                }
            }
        }
        Set<Currency> result = (Set) available.clone();
        return result;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public String getSymbol() {
        return getSymbol(Locale.getDefault(Locale.Category.DISPLAY));
    }

    public String getSymbol(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("locale == null");
        }
        return this.icuCurrency.getSymbol(locale);
    }

    public int getDefaultFractionDigits() {
        if (this.icuCurrency.getCurrencyCode().equals("XXX")) {
            return -1;
        }
        return this.icuCurrency.getDefaultFractionDigits();
    }

    public int getNumericCode() {
        return this.icuCurrency.getNumericCode();
    }

    public String getNumericCodeAsString() {
        int numericCode = getNumericCode();
        if (numericCode < 100) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('0');
            if (numericCode < 10) {
                sb2.append('0');
            }
            return sb2.append(numericCode).toString();
        }
        return String.valueOf(numericCode);
    }

    public String getDisplayName() {
        return getDisplayName(Locale.getDefault(Locale.Category.DISPLAY));
    }

    public String getDisplayName(Locale locale) {
        return this.icuCurrency.getDisplayName((Locale) Objects.requireNonNull(locale));
    }

    public String toString() {
        return this.icuCurrency.toString();
    }

    private Object readResolve() {
        return getInstance(this.currencyCode);
    }
}
