package java.text;

import java.util.Comparator;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Collator implements Comparator<Object>, Cloneable {
    public static final int CANONICAL_DECOMPOSITION = 1;
    public static final int FULL_DECOMPOSITION = 2;
    public static final int IDENTICAL = 3;
    public static final int NO_DECOMPOSITION = 0;
    public static final int PRIMARY = 0;
    public static final int SECONDARY = 1;
    public static final int TERTIARY = 2;
    android.icu.text.Collator icuColl;

    public abstract int compare(String str, String str2);

    public abstract CollationKey getCollationKey(String str);

    public abstract int hashCode();

    public static synchronized Collator getInstance() {
        Collator collator;
        synchronized (Collator.class) {
            collator = getInstance(Locale.getDefault());
        }
        return collator;
    }

    public static Collator getInstance(Locale desiredLocale) {
        RuleBasedCollator ruleBasedCollator;
        synchronized (Collator.class) {
            try {
                if (desiredLocale == null) {
                    throw new NullPointerException("locale == null");
                }
                ruleBasedCollator = new RuleBasedCollator((android.icu.text.RuleBasedCollator) android.icu.text.Collator.getInstance(desiredLocale));
            } catch (Throwable th) {
                throw th;
            }
        }
        return ruleBasedCollator;
    }

    @Override // java.util.Comparator
    public int compare(Object o12, Object o22) {
        return compare((String) o12, (String) o22);
    }

    public boolean equals(String source, String target) {
        return compare(source, target) == 0;
    }

    public synchronized int getStrength() {
        int value;
        value = this.icuColl.getStrength();
        return value == 15 ? 3 : value;
    }

    public synchronized void setStrength(int newStrength) {
        if (newStrength == 3) {
            newStrength = 15;
        }
        this.icuColl.setStrength(newStrength);
    }

    public synchronized int getDecomposition() {
        return decompositionMode_ICU_Java(this.icuColl.getDecomposition());
    }

    public synchronized void setDecomposition(int decompositionMode) {
        this.icuColl.setDecomposition(decompositionMode_Java_ICU(decompositionMode));
    }

    public static synchronized Locale[] getAvailableLocales() {
        Locale[] availableLocales;
        synchronized (Collator.class) {
            availableLocales = android.icu.text.Collator.getAvailableLocales();
        }
        return availableLocales;
    }

    private int decompositionMode_Java_ICU(int mode) {
        switch (mode) {
            case 0:
                return 16;
            case 1:
                return 17;
            default:
                throw new IllegalArgumentException("Bad mode: " + mode);
        }
    }

    private int decompositionMode_ICU_Java(int mode) {
        switch (mode) {
            case 16:
                return 0;
            case 17:
                return 1;
            default:
                return mode;
        }
    }

    public Object clone() {
        try {
            Collator clone = (Collator) super.clone();
            clone.icuColl = (android.icu.text.Collator) this.icuColl.clone();
            return clone;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // java.util.Comparator
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null || getClass() != that.getClass()) {
            return false;
        }
        Collator other = (Collator) that;
        android.icu.text.Collator collator = this.icuColl;
        if (collator != null) {
            return collator.equals(other.icuColl);
        }
        if (other.icuColl == null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Collator() {
        this.icuColl = android.icu.text.RuleBasedCollator.getInstance(Locale.getDefault());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collator(android.icu.text.Collator icuColl) {
        this.icuColl = icuColl;
    }
}
