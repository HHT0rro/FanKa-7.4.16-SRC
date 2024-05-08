package org.apache.commons.lang3.text;

import com.alipay.sdk.util.i;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class StrSubstitutor {
    public static final char DEFAULT_ESCAPE = '$';
    public static final StrMatcher DEFAULT_PREFIX = StrMatcher.stringMatcher("${");
    public static final StrMatcher DEFAULT_SUFFIX = StrMatcher.stringMatcher(i.f4738d);
    public static final StrMatcher DEFAULT_VALUE_DELIMITER = StrMatcher.stringMatcher(":-");
    private boolean enableSubstitutionInVariables;
    private char escapeChar;
    private StrMatcher prefixMatcher;
    private boolean preserveEscapes;
    private StrMatcher suffixMatcher;
    private StrMatcher valueDelimiterMatcher;
    private StrLookup<?> variableResolver;

    public StrSubstitutor() {
        this((StrLookup<?>) null, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    private void checkCyclicSubstitution(String str, List<String> list) {
        if (list.contains(str)) {
            StrBuilder strBuilder = new StrBuilder(256);
            strBuilder.append("Infinite loop in property interpolation of ");
            strBuilder.append(list.remove(0));
            strBuilder.append(": ");
            strBuilder.appendWithSeparators(list, "->");
            throw new IllegalStateException(strBuilder.toString());
        }
    }

    public static <V> String replace(Object obj, Map<String, V> map) {
        return new StrSubstitutor(map).replace(obj);
    }

    public static String replaceSystemProperties(Object obj) {
        return new StrSubstitutor(StrLookup.systemPropertiesLookup()).replace(obj);
    }

    public char getEscapeChar() {
        return this.escapeChar;
    }

    public StrMatcher getValueDelimiterMatcher() {
        return this.valueDelimiterMatcher;
    }

    public StrMatcher getVariablePrefixMatcher() {
        return this.prefixMatcher;
    }

    public StrLookup<?> getVariableResolver() {
        return this.variableResolver;
    }

    public StrMatcher getVariableSuffixMatcher() {
        return this.suffixMatcher;
    }

    public boolean isEnableSubstitutionInVariables() {
        return this.enableSubstitutionInVariables;
    }

    public boolean isPreserveEscapes() {
        return this.preserveEscapes;
    }

    public boolean replaceIn(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return false;
        }
        return replaceIn(stringBuffer, 0, stringBuffer.length());
    }

    public String resolveVariable(String str, StrBuilder strBuilder, int i10, int i11) {
        StrLookup<?> variableResolver = getVariableResolver();
        if (variableResolver == null) {
            return null;
        }
        return variableResolver.lookup(str);
    }

    public void setEnableSubstitutionInVariables(boolean z10) {
        this.enableSubstitutionInVariables = z10;
    }

    public void setEscapeChar(char c4) {
        this.escapeChar = c4;
    }

    public void setPreserveEscapes(boolean z10) {
        this.preserveEscapes = z10;
    }

    public StrSubstitutor setValueDelimiter(char c4) {
        return setValueDelimiterMatcher(StrMatcher.charMatcher(c4));
    }

    public StrSubstitutor setValueDelimiterMatcher(StrMatcher strMatcher) {
        this.valueDelimiterMatcher = strMatcher;
        return this;
    }

    public StrSubstitutor setVariablePrefix(char c4) {
        return setVariablePrefixMatcher(StrMatcher.charMatcher(c4));
    }

    public StrSubstitutor setVariablePrefixMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.prefixMatcher = strMatcher;
            return this;
        }
        throw new IllegalArgumentException("Variable prefix matcher must not be null!");
    }

    public void setVariableResolver(StrLookup<?> strLookup) {
        this.variableResolver = strLookup;
    }

    public StrSubstitutor setVariableSuffix(char c4) {
        return setVariableSuffixMatcher(StrMatcher.charMatcher(c4));
    }

    public StrSubstitutor setVariableSuffixMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.suffixMatcher = strMatcher;
            return this;
        }
        throw new IllegalArgumentException("Variable suffix matcher must not be null!");
    }

    public boolean substitute(StrBuilder strBuilder, int i10, int i11) {
        return substitute(strBuilder, i10, i11, null) > 0;
    }

    public <V> StrSubstitutor(Map<String, V> map) {
        this((StrLookup<?>) StrLookup.mapLookup(map), DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public static <V> String replace(Object obj, Map<String, V> map, String str, String str2) {
        return new StrSubstitutor(map, str, str2).replace(obj);
    }

    private int substitute(StrBuilder strBuilder, int i10, int i11, List<String> list) {
        StrMatcher strMatcher;
        StrMatcher strMatcher2;
        char c4;
        boolean z10;
        String str;
        int isMatch;
        StrMatcher variablePrefixMatcher = getVariablePrefixMatcher();
        StrMatcher variableSuffixMatcher = getVariableSuffixMatcher();
        char escapeChar = getEscapeChar();
        StrMatcher valueDelimiterMatcher = getValueDelimiterMatcher();
        boolean isEnableSubstitutionInVariables = isEnableSubstitutionInVariables();
        boolean z11 = list == null;
        int i12 = i10;
        int i13 = i10 + i11;
        int i14 = 0;
        int i15 = 0;
        char[] cArr = strBuilder.buffer;
        List<String> list2 = list;
        while (i12 < i13) {
            int isMatch2 = variablePrefixMatcher.isMatch(cArr, i12, i10, i13);
            if (isMatch2 != 0) {
                if (i12 > i10) {
                    int i16 = i12 - 1;
                    if (cArr[i16] == escapeChar) {
                        if (this.preserveEscapes) {
                            i12++;
                        } else {
                            strBuilder.deleteCharAt(i16);
                            i14--;
                            i13--;
                            strMatcher = variablePrefixMatcher;
                            strMatcher2 = variableSuffixMatcher;
                            c4 = escapeChar;
                            cArr = strBuilder.buffer;
                            z10 = z11;
                            i15 = 1;
                        }
                    }
                }
                int i17 = i12 + isMatch2;
                int i18 = i17;
                int i19 = 0;
                while (true) {
                    if (i18 >= i13) {
                        strMatcher = variablePrefixMatcher;
                        strMatcher2 = variableSuffixMatcher;
                        c4 = escapeChar;
                        z10 = z11;
                        i12 = i18;
                        break;
                    }
                    if (!isEnableSubstitutionInVariables || (isMatch = variablePrefixMatcher.isMatch(cArr, i18, i10, i13)) == 0) {
                        int isMatch3 = variableSuffixMatcher.isMatch(cArr, i18, i10, i13);
                        if (isMatch3 == 0) {
                            i18++;
                        } else if (i19 == 0) {
                            strMatcher2 = variableSuffixMatcher;
                            c4 = escapeChar;
                            String str2 = new String(cArr, i17, (i18 - i12) - isMatch2);
                            if (isEnableSubstitutionInVariables) {
                                StrBuilder strBuilder2 = new StrBuilder(str2);
                                substitute(strBuilder2, 0, strBuilder2.length());
                                str2 = strBuilder2.toString();
                            }
                            int i20 = i18 + isMatch3;
                            if (valueDelimiterMatcher != null) {
                                char[] charArray = str2.toCharArray();
                                z10 = z11;
                                int i21 = 0;
                                while (i21 < charArray.length && (isEnableSubstitutionInVariables || variablePrefixMatcher.isMatch(charArray, i21, i21, charArray.length) == 0)) {
                                    int isMatch4 = valueDelimiterMatcher.isMatch(charArray, i21);
                                    if (isMatch4 != 0) {
                                        strMatcher = variablePrefixMatcher;
                                        String substring = str2.substring(0, i21);
                                        str = str2.substring(i21 + isMatch4);
                                        str2 = substring;
                                        break;
                                    }
                                    i21++;
                                    variablePrefixMatcher = variablePrefixMatcher;
                                }
                                strMatcher = variablePrefixMatcher;
                            } else {
                                strMatcher = variablePrefixMatcher;
                                z10 = z11;
                            }
                            str = null;
                            if (list2 == null) {
                                list2 = new ArrayList<>();
                                list2.add(new String(cArr, i10, i11));
                            }
                            checkCyclicSubstitution(str2, list2);
                            list2.add(str2);
                            String resolveVariable = resolveVariable(str2, strBuilder, i12, i20);
                            if (resolveVariable != null) {
                                str = resolveVariable;
                            }
                            if (str != null) {
                                int length = str.length();
                                strBuilder.replace(i12, i20, str);
                                int substitute = (substitute(strBuilder, i12, length, list2) + length) - (i20 - i12);
                                i13 += substitute;
                                i14 += substitute;
                                cArr = strBuilder.buffer;
                                i12 = i20 + substitute;
                                i15 = 1;
                            } else {
                                i12 = i20;
                            }
                            list2.remove(list2.size() - 1);
                        } else {
                            i19--;
                            i18 += isMatch3;
                            escapeChar = escapeChar;
                            variablePrefixMatcher = variablePrefixMatcher;
                        }
                    } else {
                        i19++;
                        i18 += isMatch;
                    }
                }
            } else {
                i12++;
                strMatcher = variablePrefixMatcher;
                strMatcher2 = variableSuffixMatcher;
                c4 = escapeChar;
                z10 = z11;
            }
            variableSuffixMatcher = strMatcher2;
            escapeChar = c4;
            z11 = z10;
            variablePrefixMatcher = strMatcher;
        }
        return z11 ? i15 : i14;
    }

    public boolean replaceIn(StringBuffer stringBuffer, int i10, int i11) {
        if (stringBuffer == null) {
            return false;
        }
        StrBuilder append = new StrBuilder(i11).append(stringBuffer, i10, i11);
        if (!substitute(append, 0, i11)) {
            return false;
        }
        stringBuffer.replace(i10, i11 + i10, append.toString());
        return true;
    }

    public StrSubstitutor setValueDelimiter(String str) {
        if (StringUtils.isEmpty(str)) {
            setValueDelimiterMatcher(null);
            return this;
        }
        return setValueDelimiterMatcher(StrMatcher.stringMatcher(str));
    }

    public StrSubstitutor setVariablePrefix(String str) {
        if (str != null) {
            return setVariablePrefixMatcher(StrMatcher.stringMatcher(str));
        }
        throw new IllegalArgumentException("Variable prefix must not be null!");
    }

    public StrSubstitutor setVariableSuffix(String str) {
        if (str != null) {
            return setVariableSuffixMatcher(StrMatcher.stringMatcher(str));
        }
        throw new IllegalArgumentException("Variable suffix must not be null!");
    }

    public <V> StrSubstitutor(Map<String, V> map, String str, String str2) {
        this((StrLookup<?>) StrLookup.mapLookup(map), str, str2, '$');
    }

    public static String replace(Object obj, Properties properties) {
        if (properties == null) {
            return obj.toString();
        }
        HashMap hashMap = new HashMap();
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str = (String) propertyNames.nextElement();
            hashMap.put(str, properties.getProperty(str));
        }
        return replace(obj, hashMap);
    }

    public <V> StrSubstitutor(Map<String, V> map, String str, String str2, char c4) {
        this((StrLookup<?>) StrLookup.mapLookup(map), str, str2, c4);
    }

    public <V> StrSubstitutor(Map<String, V> map, String str, String str2, char c4, String str3) {
        this((StrLookup<?>) StrLookup.mapLookup(map), str, str2, c4, str3);
    }

    public boolean replaceIn(StringBuilder sb2) {
        if (sb2 == null) {
            return false;
        }
        return replaceIn(sb2, 0, sb2.length());
    }

    public StrSubstitutor(StrLookup<?> strLookup) {
        this(strLookup, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public boolean replaceIn(StringBuilder sb2, int i10, int i11) {
        if (sb2 == null) {
            return false;
        }
        StrBuilder append = new StrBuilder(i11).append(sb2, i10, i11);
        if (!substitute(append, 0, i11)) {
            return false;
        }
        sb2.replace(i10, i11 + i10, append.toString());
        return true;
    }

    public StrSubstitutor(StrLookup<?> strLookup, String str, String str2, char c4) {
        this.preserveEscapes = false;
        setVariableResolver(strLookup);
        setVariablePrefix(str);
        setVariableSuffix(str2);
        setEscapeChar(c4);
        setValueDelimiterMatcher(DEFAULT_VALUE_DELIMITER);
    }

    public boolean replaceIn(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return false;
        }
        return substitute(strBuilder, 0, strBuilder.length());
    }

    public boolean replaceIn(StrBuilder strBuilder, int i10, int i11) {
        if (strBuilder == null) {
            return false;
        }
        return substitute(strBuilder, i10, i11);
    }

    public String replace(String str) {
        if (str == null) {
            return null;
        }
        StrBuilder strBuilder = new StrBuilder(str);
        return !substitute(strBuilder, 0, str.length()) ? str : strBuilder.toString();
    }

    public StrSubstitutor(StrLookup<?> strLookup, String str, String str2, char c4, String str3) {
        this.preserveEscapes = false;
        setVariableResolver(strLookup);
        setVariablePrefix(str);
        setVariableSuffix(str2);
        setEscapeChar(c4);
        setValueDelimiter(str3);
    }

    public String replace(String str, int i10, int i11) {
        if (str == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i11).append(str, i10, i11);
        if (!substitute(append, 0, i11)) {
            return str.substring(i10, i11 + i10);
        }
        return append.toString();
    }

    public String replace(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(cArr.length).append(cArr);
        substitute(append, 0, cArr.length);
        return append.toString();
    }

    public StrSubstitutor(StrLookup<?> strLookup, StrMatcher strMatcher, StrMatcher strMatcher2, char c4) {
        this(strLookup, strMatcher, strMatcher2, c4, DEFAULT_VALUE_DELIMITER);
    }

    public String replace(char[] cArr, int i10, int i11) {
        if (cArr == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i11).append(cArr, i10, i11);
        substitute(append, 0, i11);
        return append.toString();
    }

    public StrSubstitutor(StrLookup<?> strLookup, StrMatcher strMatcher, StrMatcher strMatcher2, char c4, StrMatcher strMatcher3) {
        this.preserveEscapes = false;
        setVariableResolver(strLookup);
        setVariablePrefixMatcher(strMatcher);
        setVariableSuffixMatcher(strMatcher2);
        setEscapeChar(c4);
        setValueDelimiterMatcher(strMatcher3);
    }

    public String replace(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(stringBuffer.length()).append(stringBuffer);
        substitute(append, 0, append.length());
        return append.toString();
    }

    public String replace(StringBuffer stringBuffer, int i10, int i11) {
        if (stringBuffer == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i11).append(stringBuffer, i10, i11);
        substitute(append, 0, i11);
        return append.toString();
    }

    public String replace(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        return replace(charSequence, 0, charSequence.length());
    }

    public String replace(CharSequence charSequence, int i10, int i11) {
        if (charSequence == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i11).append(charSequence, i10, i11);
        substitute(append, 0, i11);
        return append.toString();
    }

    public String replace(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(strBuilder.length()).append(strBuilder);
        substitute(append, 0, append.length());
        return append.toString();
    }

    public String replace(StrBuilder strBuilder, int i10, int i11) {
        if (strBuilder == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i11).append(strBuilder, i10, i11);
        substitute(append, 0, i11);
        return append.toString();
    }

    public String replace(Object obj) {
        if (obj == null) {
            return null;
        }
        StrBuilder append = new StrBuilder().append(obj);
        substitute(append, 0, append.length());
        return append.toString();
    }
}
