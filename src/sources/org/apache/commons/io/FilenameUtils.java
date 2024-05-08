package org.apache.commons.io;

import com.huawei.appgallery.agd.common.constant.SymbolValues;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FilenameUtils {
    public static final char EXTENSION_SEPARATOR = '.';
    private static final char OTHER_SEPARATOR;
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';
    public static final String EXTENSION_SEPARATOR_STR = Character.toString('.');
    private static final char SYSTEM_SEPARATOR = File.separatorChar;

    static {
        if (isSystemWindows()) {
            OTHER_SEPARATOR = '/';
        } else {
            OTHER_SEPARATOR = '\\';
        }
    }

    public static String concat(String str, String str2) {
        int prefixLength = getPrefixLength(str2);
        if (prefixLength < 0) {
            return null;
        }
        if (prefixLength > 0) {
            return normalize(str2);
        }
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return normalize(str2);
        }
        if (isSeparator(str.charAt(length - 1))) {
            return normalize(str + str2);
        }
        return normalize(str + '/' + str2);
    }

    public static boolean directoryContains(String str, String str2) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("Directory must not be null");
        }
        if (str2 == null) {
            return false;
        }
        IOCase iOCase = IOCase.SYSTEM;
        if (iOCase.checkEquals(str, str2)) {
            return false;
        }
        return iOCase.checkStartsWith(str2, str);
    }

    private static String doGetFullPath(String str, boolean z10) {
        int prefixLength;
        if (str == null || (prefixLength = getPrefixLength(str)) < 0) {
            return null;
        }
        if (prefixLength >= str.length()) {
            return z10 ? getPrefix(str) : str;
        }
        int indexOfLastSeparator = indexOfLastSeparator(str);
        if (indexOfLastSeparator < 0) {
            return str.substring(0, prefixLength);
        }
        int i10 = indexOfLastSeparator + (z10 ? 1 : 0);
        if (i10 == 0) {
            i10++;
        }
        return str.substring(0, i10);
    }

    private static String doGetPath(String str, int i10) {
        int prefixLength;
        if (str == null || (prefixLength = getPrefixLength(str)) < 0) {
            return null;
        }
        int indexOfLastSeparator = indexOfLastSeparator(str);
        int i11 = i10 + indexOfLastSeparator;
        return (prefixLength >= str.length() || indexOfLastSeparator < 0 || prefixLength >= i11) ? "" : str.substring(prefixLength, i11);
    }

    private static String doNormalize(String str, char c4, boolean z10) {
        boolean z11;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return str;
        }
        int prefixLength = getPrefixLength(str);
        if (prefixLength < 0) {
            return null;
        }
        int i10 = length + 2;
        char[] cArr = new char[i10];
        str.getChars(0, str.length(), cArr, 0);
        char c10 = SYSTEM_SEPARATOR;
        if (c4 == c10) {
            c10 = OTHER_SEPARATOR;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            if (cArr[i11] == c10) {
                cArr[i11] = c4;
            }
        }
        if (cArr[length - 1] != c4) {
            cArr[length] = c4;
            length++;
            z11 = false;
        } else {
            z11 = true;
        }
        int i12 = prefixLength + 1;
        int i13 = i12;
        while (i13 < length) {
            if (cArr[i13] == c4) {
                int i14 = i13 - 1;
                if (cArr[i14] == c4) {
                    System.arraycopy((Object) cArr, i13, (Object) cArr, i14, length - i13);
                    length--;
                    i13--;
                }
            }
            i13++;
        }
        int i15 = i12;
        while (i15 < length) {
            if (cArr[i15] == c4) {
                int i16 = i15 - 1;
                if (cArr[i16] == '.' && (i15 == i12 || cArr[i15 - 2] == c4)) {
                    if (i15 == length - 1) {
                        z11 = true;
                    }
                    System.arraycopy((Object) cArr, i15 + 1, (Object) cArr, i16, length - i15);
                    length -= 2;
                    i15--;
                }
            }
            i15++;
        }
        int i17 = prefixLength + 2;
        int i18 = i17;
        while (i18 < length) {
            if (cArr[i18] == c4 && cArr[i18 - 1] == '.' && cArr[i18 - 2] == '.' && (i18 == i17 || cArr[i18 - 3] == c4)) {
                if (i18 == i17) {
                    return null;
                }
                if (i18 == length - 1) {
                    z11 = true;
                }
                int i19 = i18 - 4;
                while (true) {
                    if (i19 >= prefixLength) {
                        if (cArr[i19] == c4) {
                            int i20 = i19 + 1;
                            System.arraycopy((Object) cArr, i18 + 1, (Object) cArr, i20, length - i18);
                            length -= i18 - i19;
                            i18 = i20;
                            break;
                        }
                        i19--;
                    } else {
                        int i21 = i18 + 1;
                        System.arraycopy((Object) cArr, i21, (Object) cArr, prefixLength, length - i18);
                        length -= i21 - prefixLength;
                        i18 = i12;
                        break;
                    }
                }
            }
            i18++;
        }
        if (length <= 0) {
            return "";
        }
        if (length <= prefixLength) {
            return new String(cArr, 0, length);
        }
        if (z11 && z10) {
            return new String(cArr, 0, length);
        }
        return new String(cArr, 0, length - 1);
    }

    public static boolean equals(String str, String str2) {
        return equals(str, str2, false, IOCase.SENSITIVE);
    }

    public static boolean equalsNormalized(String str, String str2) {
        return equals(str, str2, true, IOCase.SENSITIVE);
    }

    public static boolean equalsNormalizedOnSystem(String str, String str2) {
        return equals(str, str2, true, IOCase.SYSTEM);
    }

    public static boolean equalsOnSystem(String str, String str2) {
        return equals(str, str2, false, IOCase.SYSTEM);
    }

    public static String getBaseName(String str) {
        return removeExtension(getName(str));
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        int indexOfExtension = indexOfExtension(str);
        return indexOfExtension == -1 ? "" : str.substring(indexOfExtension + 1);
    }

    public static String getFullPath(String str) {
        return doGetFullPath(str, true);
    }

    public static String getFullPathNoEndSeparator(String str) {
        return doGetFullPath(str, false);
    }

    public static String getName(String str) {
        if (str == null) {
            return null;
        }
        return str.substring(indexOfLastSeparator(str) + 1);
    }

    public static String getPath(String str) {
        return doGetPath(str, 1);
    }

    public static String getPathNoEndSeparator(String str) {
        return doGetPath(str, 0);
    }

    public static String getPrefix(String str) {
        int prefixLength;
        if (str == null || (prefixLength = getPrefixLength(str)) < 0) {
            return null;
        }
        if (prefixLength > str.length()) {
            return str + '/';
        }
        return str.substring(0, prefixLength);
    }

    public static int getPrefixLength(String str) {
        int min;
        if (str == null) {
            return -1;
        }
        int length = str.length();
        if (length == 0) {
            return 0;
        }
        char charAt = str.charAt(0);
        if (charAt == ':') {
            return -1;
        }
        if (length == 1) {
            if (charAt == '~') {
                return 2;
            }
            return isSeparator(charAt) ? 1 : 0;
        }
        if (charAt == '~') {
            int indexOf = str.indexOf(47, 1);
            int indexOf2 = str.indexOf(92, 1);
            if (indexOf == -1 && indexOf2 == -1) {
                return length + 1;
            }
            if (indexOf == -1) {
                indexOf = indexOf2;
            }
            if (indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            min = Math.min(indexOf, indexOf2);
        } else {
            char charAt2 = str.charAt(1);
            if (charAt2 == ':') {
                char upperCase = Character.toUpperCase(charAt);
                if (upperCase < 'A' || upperCase > 'Z') {
                    return -1;
                }
                return (length == 2 || !isSeparator(str.charAt(2))) ? 2 : 3;
            }
            if (!isSeparator(charAt) || !isSeparator(charAt2)) {
                return isSeparator(charAt) ? 1 : 0;
            }
            int indexOf3 = str.indexOf(47, 2);
            int indexOf4 = str.indexOf(92, 2);
            if ((indexOf3 == -1 && indexOf4 == -1) || indexOf3 == 2 || indexOf4 == 2) {
                return -1;
            }
            if (indexOf3 == -1) {
                indexOf3 = indexOf4;
            }
            if (indexOf4 == -1) {
                indexOf4 = indexOf3;
            }
            min = Math.min(indexOf3, indexOf4);
        }
        return min + 1;
    }

    public static int indexOfExtension(String str) {
        int lastIndexOf;
        if (str != null && indexOfLastSeparator(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    public static int indexOfLastSeparator(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static boolean isExtension(String str, String str2) {
        if (str == null) {
            return false;
        }
        if (str2 == null || str2.length() == 0) {
            return indexOfExtension(str) == -1;
        }
        return getExtension(str).equals(str2);
    }

    private static boolean isSeparator(char c4) {
        return c4 == '/' || c4 == '\\';
    }

    public static boolean isSystemWindows() {
        return SYSTEM_SEPARATOR == '\\';
    }

    public static String normalize(String str) {
        return doNormalize(str, SYSTEM_SEPARATOR, true);
    }

    public static String normalizeNoEndSeparator(String str) {
        return doNormalize(str, SYSTEM_SEPARATOR, false);
    }

    public static String removeExtension(String str) {
        if (str == null) {
            return null;
        }
        int indexOfExtension = indexOfExtension(str);
        return indexOfExtension == -1 ? str : str.substring(0, indexOfExtension);
    }

    public static String separatorsToSystem(String str) {
        if (str == null) {
            return null;
        }
        if (isSystemWindows()) {
            return separatorsToWindows(str);
        }
        return separatorsToUnix(str);
    }

    public static String separatorsToUnix(String str) {
        return (str == null || str.indexOf(92) == -1) ? str : str.replace('\\', '/');
    }

    public static String separatorsToWindows(String str) {
        return (str == null || str.indexOf(47) == -1) ? str : str.replace('/', '\\');
    }

    public static String[] splitOnTokens(String str) {
        if (str.indexOf(63) == -1 && str.indexOf(42) == -1) {
            return new String[]{str};
        }
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < charArray.length; i10++) {
            if (charArray[i10] != '?' && charArray[i10] != '*') {
                sb2.append(charArray[i10]);
            } else {
                if (sb2.length() != 0) {
                    arrayList.add(sb2.toString());
                    sb2.setLength(0);
                }
                if (charArray[i10] == '?') {
                    arrayList.add(SymbolValues.QUESTION_EN_SYMBOL);
                } else if (arrayList.isEmpty() || (i10 > 0 && !((String) arrayList.get(arrayList.size() - 1)).equals(StringUtils.NO_PRINT_CODE))) {
                    arrayList.add(StringUtils.NO_PRINT_CODE);
                }
            }
        }
        if (sb2.length() != 0) {
            arrayList.add(sb2.toString());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean wildcardMatch(String str, String str2) {
        return wildcardMatch(str, str2, IOCase.SENSITIVE);
    }

    public static boolean wildcardMatchOnSystem(String str, String str2) {
        return wildcardMatch(str, str2, IOCase.SYSTEM);
    }

    public static boolean equals(String str, String str2, boolean z10, IOCase iOCase) {
        if (str == null || str2 == null) {
            return str == null && str2 == null;
        }
        if (z10) {
            str = normalize(str);
            str2 = normalize(str2);
            if (str == null || str2 == null) {
                throw new NullPointerException("Error normalizing one or both of the file names");
            }
        }
        if (iOCase == null) {
            iOCase = IOCase.SENSITIVE;
        }
        return iOCase.checkEquals(str, str2);
    }

    public static String normalize(String str, boolean z10) {
        return doNormalize(str, z10 ? '/' : '\\', true);
    }

    public static String normalizeNoEndSeparator(String str, boolean z10) {
        return doNormalize(str, z10 ? '/' : '\\', false);
    }

    public static boolean wildcardMatch(String str, String str2, IOCase iOCase) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str != null && str2 != null) {
            if (iOCase == null) {
                iOCase = IOCase.SENSITIVE;
            }
            String[] splitOnTokens = splitOnTokens(str2);
            Stack stack = new Stack();
            boolean z10 = false;
            int i10 = 0;
            int i11 = 0;
            do {
                if (stack.size() > 0) {
                    int[] iArr = (int[]) stack.pop();
                    i11 = iArr[0];
                    i10 = iArr[1];
                    z10 = true;
                }
                while (i11 < splitOnTokens.length) {
                    if (splitOnTokens[i11].equals(SymbolValues.QUESTION_EN_SYMBOL)) {
                        i10++;
                        if (i10 > str.length()) {
                            break;
                        }
                        z10 = false;
                        i11++;
                    } else if (splitOnTokens[i11].equals(StringUtils.NO_PRINT_CODE)) {
                        if (i11 == splitOnTokens.length - 1) {
                            i10 = str.length();
                        }
                        z10 = true;
                        i11++;
                    } else {
                        if (z10) {
                            i10 = iOCase.checkIndexOf(str, i10, splitOnTokens[i11]);
                            if (i10 == -1) {
                                break;
                            }
                            int checkIndexOf = iOCase.checkIndexOf(str, i10 + 1, splitOnTokens[i11]);
                            if (checkIndexOf >= 0) {
                                stack.push(new int[]{i11, checkIndexOf});
                            }
                            i10 += splitOnTokens[i11].length();
                            z10 = false;
                        } else {
                            if (!iOCase.checkRegionMatches(str, i10, splitOnTokens[i11])) {
                                break;
                            }
                            i10 += splitOnTokens[i11].length();
                            z10 = false;
                        }
                        i11++;
                    }
                }
                if (i11 == splitOnTokens.length && i10 == str.length()) {
                    return true;
                }
            } while (stack.size() > 0);
        }
        return false;
    }

    public static boolean isExtension(String str, String[] strArr) {
        if (str == null) {
            return false;
        }
        if (strArr == null || strArr.length == 0) {
            return indexOfExtension(str) == -1;
        }
        String extension = getExtension(str);
        for (String str2 : strArr) {
            if (extension.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isExtension(String str, Collection<String> collection) {
        if (str == null) {
            return false;
        }
        if (collection == null || collection.isEmpty()) {
            return indexOfExtension(str) == -1;
        }
        String extension = getExtension(str);
        Iterator<String> iterator2 = collection.iterator2();
        while (iterator2.hasNext()) {
            if (extension.equals(iterator2.next())) {
                return true;
            }
        }
        return false;
    }
}
