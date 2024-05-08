package org.apache.commons.io;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class IOCase implements Serializable {
    private static final long serialVersionUID = -6343169151696340687L;
    private final String name;
    private final transient boolean sensitive;
    public static final IOCase SENSITIVE = new IOCase("Sensitive", true);
    public static final IOCase INSENSITIVE = new IOCase("Insensitive", false);
    public static final IOCase SYSTEM = new IOCase("System", !FilenameUtils.isSystemWindows());

    private IOCase(String str, boolean z10) {
        this.name = str;
        this.sensitive = z10;
    }

    public static IOCase forName(String str) {
        IOCase iOCase = SENSITIVE;
        if (iOCase.name.equals(str)) {
            return iOCase;
        }
        IOCase iOCase2 = INSENSITIVE;
        if (iOCase2.name.equals(str)) {
            return iOCase2;
        }
        IOCase iOCase3 = SYSTEM;
        if (iOCase3.name.equals(str)) {
            return iOCase3;
        }
        throw new IllegalArgumentException("Invalid IOCase name: " + str);
    }

    private Object readResolve() {
        return forName(this.name);
    }

    public int checkCompareTo(String str, String str2) {
        if (str == null || str2 == null) {
            throw new NullPointerException("The strings must not be null");
        }
        return this.sensitive ? str.compareTo(str2) : str.compareToIgnoreCase(str2);
    }

    public boolean checkEndsWith(String str, String str2) {
        int length = str2.length();
        return str.regionMatches(!this.sensitive, str.length() - length, str2, 0, length);
    }

    public boolean checkEquals(String str, String str2) {
        if (str == null || str2 == null) {
            throw new NullPointerException("The strings must not be null");
        }
        return this.sensitive ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public int checkIndexOf(String str, int i10, String str2) {
        int length = str.length() - str2.length();
        if (length < i10) {
            return -1;
        }
        while (i10 <= length) {
            if (checkRegionMatches(str, i10, str2)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public boolean checkRegionMatches(String str, int i10, String str2) {
        return str.regionMatches(!this.sensitive, i10, str2, 0, str2.length());
    }

    public boolean checkStartsWith(String str, String str2) {
        return str.regionMatches(!this.sensitive, 0, str2, 0, str2.length());
    }

    public String getName() {
        return this.name;
    }

    public boolean isCaseSensitive() {
        return this.sensitive;
    }

    public String toString() {
        return this.name;
    }
}
