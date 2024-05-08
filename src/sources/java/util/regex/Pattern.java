package java.util.regex;

import android.compat.Compatibility;
import com.android.icu.util.regex.PatternNative;
import dalvik.system.VMRuntime;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterators;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import jdk.internal.util.ArraysSupport;
import libcore.util.EmptyArray;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Pattern implements Serializable {
    private static final int ALL_FLAGS = 127;
    public static final int CANON_EQ = 128;
    public static final int CASE_INSENSITIVE = 2;
    public static final int COMMENTS = 4;
    public static final int DOTALL = 32;
    private static final String FASTSPLIT_METACHARACTERS = "\\?*+[](){}^$.|";
    public static final int LITERAL = 16;
    public static final int MULTILINE = 8;
    public static final long SPLIT_AS_STREAM_RETURNS_SINGLE_EMPTY_STRING = 288845345;
    public static final int UNICODE_CASE = 64;
    public static final int UNICODE_CHARACTER_CLASS = 256;
    public static final int UNIX_LINES = 1;
    private static final long serialVersionUID = 5073258162644648461L;
    private final int flags;
    transient PatternNative nativePattern;
    private final String pattern;

    public static Pattern compile(String regex) {
        return new Pattern(regex, 0);
    }

    public static Pattern compile(String regex, int flags) {
        return new Pattern(regex, flags);
    }

    public String pattern() {
        return this.pattern;
    }

    public String toString() {
        return this.pattern;
    }

    public Matcher matcher(CharSequence input) {
        Matcher m10 = new Matcher(this, input);
        return m10;
    }

    public int flags() {
        return this.flags;
    }

    public static boolean matches(String regex, CharSequence input) {
        Pattern p10 = compile(regex);
        Matcher m10 = p10.matcher(input);
        return m10.matches();
    }

    public String[] split(CharSequence input, int limit) {
        String[] fast = fastSplit(this.pattern, input.toString(), limit);
        if (fast != null) {
            return fast;
        }
        int index = 0;
        boolean matchLimited = limit > 0;
        ArrayList<String> matchList = new ArrayList<>();
        Matcher m10 = matcher(input);
        while (m10.find()) {
            if (!matchLimited || matchList.size() < limit - 1) {
                if (index == 0 && index == m10.start() && m10.start() == m10.end()) {
                    int targetSdkVersion = VMRuntime.getRuntime().getTargetSdkVersion();
                    if (targetSdkVersion > 28) {
                    }
                }
                int targetSdkVersion2 = m10.start();
                String match = input.subSequence(index, targetSdkVersion2).toString();
                matchList.add(match);
                index = m10.end();
            } else if (matchList.size() == limit - 1) {
                String match2 = input.subSequence(index, input.length()).toString();
                matchList.add(match2);
                index = m10.end();
            }
        }
        if (index == 0) {
            return new String[]{input.toString()};
        }
        if (!matchLimited || matchList.size() < limit) {
            matchList.add(input.subSequence(index, input.length()).toString());
        }
        int resultSize = matchList.size();
        if (limit == 0) {
            while (resultSize > 0 && matchList.get(resultSize - 1).isEmpty()) {
                resultSize--;
            }
        }
        String[] result = new String[resultSize];
        return (String[]) matchList.subList(0, resultSize).toArray(result);
    }

    public static String[] fastSplit(String re, String input, int limit) {
        int end;
        int len = re.length();
        if (len == 0) {
            return null;
        }
        char ch = re.charAt(0);
        if (len == 1) {
            if (Character.isSurrogate(ch) || FASTSPLIT_METACHARACTERS.indexOf(ch) != -1) {
                return null;
            }
        } else {
            if (len != 2 || ch != '\\') {
                return null;
            }
            ch = re.charAt(1);
            if (FASTSPLIT_METACHARACTERS.indexOf(ch) == -1) {
                return null;
            }
        }
        if (input.isEmpty()) {
            return new String[]{""};
        }
        int separatorCount = 0;
        int begin = 0;
        while (separatorCount + 1 != limit && (end = input.indexOf(ch, begin)) != -1) {
            separatorCount++;
            begin = end + 1;
        }
        int lastPartEnd = input.length();
        if (limit == 0 && begin == lastPartEnd) {
            if (separatorCount == lastPartEnd) {
                return EmptyArray.STRING;
            }
            do {
                begin--;
            } while (input.charAt(begin - 1) == ch);
            separatorCount -= input.length() - begin;
            lastPartEnd = begin;
        }
        String[] result = new String[separatorCount + 1];
        int begin2 = 0;
        for (int i10 = 0; i10 != separatorCount; i10++) {
            int end2 = input.indexOf(ch, begin2);
            result[i10] = input.substring(begin2, end2);
            begin2 = end2 + 1;
        }
        result[separatorCount] = input.substring(begin2, lastPartEnd);
        return result;
    }

    public String[] split(CharSequence input) {
        return split(input, 0);
    }

    public static String quote(String s2) {
        int indexOf;
        int slashEIndex = s2.indexOf("\\E");
        if (slashEIndex == -1) {
            return "\\Q" + s2 + "\\E";
        }
        int lenHint = s2.length();
        int lenHint2 = ArraysSupport.SOFT_MAX_ARRAY_LENGTH;
        if (lenHint < ArraysSupport.SOFT_MAX_ARRAY_LENGTH - lenHint) {
            lenHint2 = lenHint << 1;
        }
        StringBuilder sb2 = new StringBuilder(lenHint2);
        sb2.append("\\Q");
        int current = 0;
        do {
            sb2.append((CharSequence) s2, current, slashEIndex).append("\\E\\\\E\\Q");
            current = slashEIndex + 2;
            indexOf = s2.indexOf("\\E", current);
            slashEIndex = indexOf;
        } while (indexOf != -1);
        return sb2.append((CharSequence) s2, current, s2.length()).append("\\E").toString();
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        s2.defaultReadObject();
        compile();
    }

    private Pattern(String p10, int f10) {
        if ((f10 & 128) != 0) {
            throw new IllegalArgumentException("CANON_EQ flag isn't supported");
        }
        if ((f10 & 256) != 0) {
            throw new IllegalArgumentException("UNICODE_CHARACTER_CLASS flag not supported");
        }
        if ((f10 & (-128)) != 0) {
            throw new IllegalArgumentException("Unknown flag 0x" + Integer.toHexString(f10));
        }
        this.pattern = p10;
        this.flags = f10;
        compile();
    }

    private void compile() throws PatternSyntaxException {
        String str = this.pattern;
        if (str == null) {
            throw new NullPointerException("pattern == null");
        }
        String icuPattern = this.pattern;
        if ((this.flags & 16) != 0) {
            icuPattern = quote(str);
        }
        int icuFlags = this.flags & 47;
        this.nativePattern = PatternNative.create(icuPattern, icuFlags);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$asPredicate$0(String s2) {
        return matcher(s2).find();
    }

    public Predicate<String> asPredicate() {
        return new Predicate() { // from class: java.util.regex.Pattern$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean lambda$asPredicate$0;
                lambda$asPredicate$0 = Pattern.this.lambda$asPredicate$0((String) obj);
                return lambda$asPredicate$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$asMatchPredicate$1(String s2) {
        return matcher(s2).matches();
    }

    public Predicate<String> asMatchPredicate() {
        return new Predicate() { // from class: java.util.regex.Pattern$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean lambda$asMatchPredicate$1;
                lambda$asMatchPredicate$1 = Pattern.this.lambda$asMatchPredicate$1((String) obj);
                return lambda$asMatchPredicate$1;
            }
        };
    }

    public Stream<String> splitAsStream(final CharSequence input) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(new Iterator<String>() { // from class: java.util.regex.Pattern.1MatcherIterator
            private int current;
            private int emptyElementCount;
            private Matcher matcher;
            private String nextElement;

            @Override // java.util.Iterator
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int i10 = this.emptyElementCount;
                if (i10 == 0) {
                    String n10 = this.nextElement;
                    this.nextElement = null;
                    return n10;
                }
                this.emptyElementCount = i10 - 1;
                return "";
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.matcher == null) {
                    this.matcher = Pattern.this.matcher(input);
                    if (input.length() == 0 && VMRuntime.getSdkVersion() >= 34 && Compatibility.isChangeEnabled(Pattern.SPLIT_AS_STREAM_RETURNS_SINGLE_EMPTY_STRING)) {
                        this.emptyElementCount = 1;
                    } else {
                        this.emptyElementCount = 0;
                    }
                }
                if (this.nextElement != null || this.emptyElementCount > 0) {
                    return true;
                }
                if (this.current == input.length()) {
                    return false;
                }
                while (this.matcher.find()) {
                    this.nextElement = input.subSequence(this.current, this.matcher.start()).toString();
                    this.current = this.matcher.end();
                    if (!this.nextElement.isEmpty()) {
                        return true;
                    }
                    if (this.current > 0) {
                        this.emptyElementCount++;
                    }
                }
                CharSequence charSequence = input;
                this.nextElement = charSequence.subSequence(this.current, charSequence.length()).toString();
                this.current = input.length();
                if (!this.nextElement.isEmpty()) {
                    return true;
                }
                this.emptyElementCount = 0;
                this.nextElement = null;
                return false;
            }
        }, 272), false);
    }
}
