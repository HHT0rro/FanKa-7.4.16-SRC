package java.util.regex;

import android.compat.Compatibility;
import com.alipay.sdk.util.i;
import com.android.icu.util.regex.MatcherNative;
import dalvik.system.VMRuntime;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.apache.commons.io.IOUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Matcher implements MatchResult {
    public static final long DISALLOW_INVALID_GROUP_REFERENCE = 247079863;
    int from;
    int[] groups;
    private boolean matchFound;
    int modCount;
    private MatcherNative nativeMatcher;
    private CharSequence originalInput;
    private Pattern parentPattern;
    String text;
    int to;
    int appendPos = 0;
    boolean transparentBounds = false;
    boolean anchoringBounds = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matcher(Pattern parent, CharSequence text) {
        usePattern(parent);
        reset(text);
    }

    public Pattern pattern() {
        return this.parentPattern;
    }

    public MatchResult toMatchResult() {
        ensureMatch();
        return toMatchResult(this.text.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MatchResult toMatchResult(String text) {
        return new ImmutableMatchResult(this.matchFound ? start() : -1, this.matchFound ? end() : -1, groupCount(), (int[]) this.groups.clone(), text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ImmutableMatchResult implements MatchResult {
        private final int first;
        private final int groupCount;
        private final int[] groups;
        private final int last;
        private final String text;

        ImmutableMatchResult(int first, int last, int groupCount, int[] groups, String text) {
            this.first = first;
            this.last = last;
            this.groupCount = groupCount;
            this.groups = groups;
            this.text = text;
        }

        @Override // java.util.regex.MatchResult
        public int start() {
            checkMatch();
            return this.first;
        }

        @Override // java.util.regex.MatchResult
        public int start(int group) {
            checkMatch();
            if (group < 0 || group > this.groupCount) {
                throw new IndexOutOfBoundsException("No group " + group);
            }
            return this.groups[group * 2];
        }

        @Override // java.util.regex.MatchResult
        public int end() {
            checkMatch();
            return this.last;
        }

        @Override // java.util.regex.MatchResult
        public int end(int group) {
            checkMatch();
            if (group < 0 || group > this.groupCount) {
                throw new IndexOutOfBoundsException("No group " + group);
            }
            return this.groups[(group * 2) + 1];
        }

        @Override // java.util.regex.MatchResult
        public int groupCount() {
            return this.groupCount;
        }

        @Override // java.util.regex.MatchResult
        public String group() {
            checkMatch();
            return group(0);
        }

        @Override // java.util.regex.MatchResult
        public String group(int group) {
            checkMatch();
            if (group < 0 || group > this.groupCount) {
                throw new IndexOutOfBoundsException("No group " + group);
            }
            int[] iArr = this.groups;
            if (iArr[group * 2] == -1 || iArr[(group * 2) + 1] == -1) {
                return null;
            }
            return this.text.subSequence(iArr[group * 2], iArr[(group * 2) + 1]).toString();
        }

        private void checkMatch() {
            if (this.first < 0) {
                throw new IllegalStateException("No match found");
            }
        }
    }

    public Matcher usePattern(Pattern newPattern) {
        if (newPattern == null) {
            throw new IllegalArgumentException("Pattern cannot be null");
        }
        synchronized (this) {
            this.nativeMatcher = MatcherNative.create(newPattern.nativePattern);
        }
        this.parentPattern = newPattern;
        if (this.text != null) {
            resetForInput();
        }
        this.groups = new int[(groupCount() + 1) * 2];
        this.matchFound = false;
        this.modCount++;
        return this;
    }

    public Matcher reset() {
        CharSequence charSequence = this.originalInput;
        Matcher matcher = reset(charSequence, 0, charSequence.length());
        this.modCount++;
        return matcher;
    }

    public Matcher reset(CharSequence input) {
        return reset(input, 0, input.length());
    }

    @Override // java.util.regex.MatchResult
    public int start() {
        return start(0);
    }

    @Override // java.util.regex.MatchResult
    public int start(int group) {
        ensureMatch();
        if (group < 0 || group > groupCount()) {
            throw new IndexOutOfBoundsException("No group " + group);
        }
        return this.groups[group * 2];
    }

    public int start(String name) {
        return this.groups[getMatchedGroupIndex(name) * 2];
    }

    @Override // java.util.regex.MatchResult
    public int end() {
        return end(0);
    }

    @Override // java.util.regex.MatchResult
    public int end(int group) {
        ensureMatch();
        if (group < 0 || group > groupCount()) {
            throw new IndexOutOfBoundsException("No group " + group);
        }
        return this.groups[(group * 2) + 1];
    }

    public int end(String name) {
        return this.groups[(getMatchedGroupIndex(name) * 2) + 1];
    }

    @Override // java.util.regex.MatchResult
    public String group() {
        return group(0);
    }

    @Override // java.util.regex.MatchResult
    public String group(int group) {
        ensureMatch();
        if (group < 0 || group > groupCount()) {
            throw new IndexOutOfBoundsException("No group " + group);
        }
        int[] iArr = this.groups;
        if (iArr[group * 2] == -1 || iArr[(group * 2) + 1] == -1) {
            return null;
        }
        return getSubSequence(iArr[group * 2], iArr[(group * 2) + 1]).toString();
    }

    public String group(String name) {
        int group = getMatchedGroupIndex(name);
        int[] iArr = this.groups;
        if (iArr[group * 2] == -1 || iArr[(group * 2) + 1] == -1) {
            return null;
        }
        return getSubSequence(iArr[group * 2], iArr[(group * 2) + 1]).toString();
    }

    @Override // java.util.regex.MatchResult
    public int groupCount() {
        int groupCount;
        synchronized (this) {
            groupCount = this.nativeMatcher.groupCount();
        }
        return groupCount;
    }

    public boolean matches() {
        boolean matches;
        synchronized (this) {
            matches = this.nativeMatcher.matches(this.groups);
            this.matchFound = matches;
        }
        this.modCount++;
        return matches;
    }

    public boolean find() {
        boolean findNext;
        synchronized (this) {
            findNext = this.nativeMatcher.findNext(this.groups);
            this.matchFound = findNext;
        }
        this.modCount++;
        return findNext;
    }

    public boolean find(int start) {
        boolean find;
        int limit = getTextLength();
        if (start < 0 || start > limit) {
            throw new IndexOutOfBoundsException("Illegal start index");
        }
        reset();
        synchronized (this) {
            find = this.nativeMatcher.find(start, this.groups);
            this.matchFound = find;
        }
        this.modCount++;
        return find;
    }

    public boolean lookingAt() {
        boolean lookingAt;
        synchronized (this) {
            lookingAt = this.nativeMatcher.lookingAt(this.groups);
            this.matchFound = lookingAt;
        }
        this.modCount++;
        return lookingAt;
    }

    public static String quoteReplacement(String s2) {
        if (s2.indexOf(92) == -1 && s2.indexOf(36) == -1) {
            return s2;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < s2.length(); i10++) {
            char c4 = s2.charAt(i10);
            if (c4 == '\\' || c4 == '$') {
                sb2.append(IOUtils.DIR_SEPARATOR_WINDOWS);
            }
            sb2.append(c4);
        }
        return sb2.toString();
    }

    public Matcher appendReplacement(StringBuffer sb2, String replacement) {
        StringBuilder result = new StringBuilder();
        appendReplacementInternal(result, replacement);
        sb2.append((CharSequence) this.text, this.appendPos, start());
        sb2.append((CharSequence) result);
        this.appendPos = end();
        this.modCount++;
        return this;
    }

    private void appendReplacementInternal(StringBuilder sb2, String replacement) {
        if (VMRuntime.getSdkVersion() >= 34 && Compatibility.isChangeEnabled(DISALLOW_INVALID_GROUP_REFERENCE)) {
            appendExpandedReplacement(replacement, sb2);
        } else {
            appendEvaluated(sb2, replacement);
        }
    }

    public void appendEvaluated(StringBuilder buffer, String s2) {
        boolean escape = false;
        boolean dollar = false;
        boolean escapeNamedGroup = false;
        int escapeNamedGroupStart = -1;
        for (int i10 = 0; i10 < s2.length(); i10++) {
            char c4 = s2.charAt(i10);
            if (c4 == '\\' && !escape) {
                escape = true;
            } else if (c4 == '$' && !escape) {
                dollar = true;
            } else if (c4 >= '0' && c4 <= '9' && dollar && !escapeNamedGroup) {
                String groupValue = group(c4 - '0');
                if (groupValue != null) {
                    buffer.append(groupValue);
                }
                dollar = false;
            } else if (c4 == '{' && dollar) {
                escapeNamedGroup = true;
                escapeNamedGroupStart = i10;
            } else if (c4 != '}' || !dollar || !escapeNamedGroup) {
                if (c4 == '}' || !dollar || !escapeNamedGroup) {
                    buffer.append(c4);
                    dollar = false;
                    escape = false;
                    escapeNamedGroup = false;
                }
            } else {
                String groupValue2 = group(s2.substring(escapeNamedGroupStart + 1, i10));
                if (groupValue2 != null) {
                    buffer.append(groupValue2);
                }
                dollar = false;
                escapeNamedGroup = false;
            }
        }
        if (escape) {
            throw new IllegalArgumentException("character to be escaped is missing");
        }
        if (dollar) {
            throw new IllegalArgumentException("Illegal group reference: group index is missing");
        }
        if (escapeNamedGroup) {
            throw new IllegalArgumentException("Missing ending brace '}' from replacement string");
        }
    }

    public Matcher appendReplacement(StringBuilder sb2, String replacement) {
        ensureMatch();
        StringBuilder result = new StringBuilder();
        appendReplacementInternal(result, replacement);
        sb2.append((CharSequence) this.text, this.appendPos, start());
        sb2.append((CharSequence) result);
        this.appendPos = end();
        this.modCount++;
        return this;
    }

    public StringBuilder appendExpandedReplacement(String replacement, StringBuilder result) {
        int refNum;
        int cursor = 0;
        while (cursor < replacement.length()) {
            char nextChar = replacement.charAt(cursor);
            if (nextChar == '\\') {
                int cursor2 = cursor + 1;
                if (cursor2 == replacement.length()) {
                    throw new IllegalArgumentException("character to be escaped is missing");
                }
                result.append(replacement.charAt(cursor2));
                cursor = cursor2 + 1;
            } else if (nextChar == '$') {
                int cursor3 = cursor + 1;
                if (cursor3 == replacement.length()) {
                    throw new IllegalArgumentException("Illegal group reference: group index is missing");
                }
                char nextChar2 = replacement.charAt(cursor3);
                if (nextChar2 == '{') {
                    int cursor4 = cursor3 + 1;
                    StringBuilder gsb = new StringBuilder();
                    while (cursor4 < replacement.length()) {
                        nextChar2 = replacement.charAt(cursor4);
                        if (!ASCII.isLower(nextChar2) && !ASCII.isUpper(nextChar2) && !ASCII.isDigit(nextChar2)) {
                            break;
                        }
                        gsb.append(nextChar2);
                        cursor4++;
                    }
                    if (gsb.length() == 0) {
                        throw new IllegalArgumentException("named capturing group has 0 length name");
                    }
                    if (nextChar2 != '}') {
                        throw new IllegalArgumentException("named capturing group is missing trailing '}'");
                    }
                    String gname = gsb.toString();
                    if (ASCII.isDigit(gname.charAt(0))) {
                        throw new IllegalArgumentException("capturing group name {" + gname + "} starts with digit character");
                    }
                    int groupIndex = this.nativeMatcher.getMatchedGroupIndex(gname);
                    if (groupIndex < 0) {
                        throw new IllegalArgumentException("No group with name {" + gname + i.f4738d);
                    }
                    refNum = groupIndex;
                    cursor = cursor4 + 1;
                } else {
                    refNum = nextChar2 - '0';
                    if (refNum < 0 || refNum > 9) {
                        throw new IllegalArgumentException("Illegal group reference");
                    }
                    cursor = cursor3 + 1;
                    boolean done = false;
                    while (!done && cursor < replacement.length()) {
                        int nextDigit = replacement.charAt(cursor) - '0';
                        if (nextDigit < 0 || nextDigit > 9) {
                            break;
                        }
                        int newRefNum = (refNum * 10) + nextDigit;
                        if (groupCount() < newRefNum) {
                            done = true;
                        } else {
                            refNum = newRefNum;
                            cursor++;
                        }
                    }
                }
                if (start(refNum) != -1 && end(refNum) != -1) {
                    result.append((CharSequence) this.text, start(refNum), end(refNum));
                }
            } else {
                result.append(nextChar);
                cursor++;
            }
        }
        return result;
    }

    public StringBuffer appendTail(StringBuffer sb2) {
        int i10 = this.appendPos;
        int i11 = this.to;
        if (i10 < i11) {
            sb2.append(this.text.substring(i10, i11));
        }
        return sb2;
    }

    public StringBuilder appendTail(StringBuilder sb2) {
        int i10 = this.appendPos;
        int i11 = this.to;
        if (i10 < i11) {
            sb2.append(this.text.substring(i10, i11));
        }
        return sb2;
    }

    public String replaceAll(String replacement) {
        boolean result;
        reset();
        boolean result2 = find();
        if (result2) {
            StringBuilder sb2 = new StringBuilder();
            do {
                appendReplacement(sb2, replacement);
                result = find();
            } while (result);
            appendTail(sb2);
            return sb2.toString();
        }
        return this.text.toString();
    }

    public String replaceAll(Function<MatchResult, String> replacer) {
        boolean result;
        Objects.requireNonNull(replacer);
        reset();
        boolean result2 = find();
        if (result2) {
            StringBuilder sb2 = new StringBuilder();
            do {
                int ec2 = this.modCount;
                String replacement = replacer.apply(this);
                if (ec2 != this.modCount) {
                    throw new ConcurrentModificationException();
                }
                appendReplacement(sb2, replacement);
                result = find();
            } while (result);
            appendTail(sb2);
            return sb2.toString();
        }
        return this.text.toString();
    }

    public Stream<MatchResult> results() {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(new Iterator<MatchResult>() { // from class: java.util.regex.Matcher.1MatchResultIterator
            String textAsString;
            int state = -1;
            int expectedCount = -1;

            @Override // java.util.Iterator
            public MatchResult next() {
                int i10 = this.expectedCount;
                if (i10 >= 0 && i10 != Matcher.this.modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.state = -1;
                return Matcher.this.toMatchResult(this.textAsString);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                int i10 = this.state;
                if (i10 >= 0) {
                    return i10 == 1;
                }
                int i11 = this.expectedCount;
                if (i11 >= 0 && i11 != Matcher.this.modCount) {
                    return true;
                }
                boolean find = Matcher.this.find();
                if (find && this.state < 0) {
                    this.textAsString = Matcher.this.text.toString();
                }
                this.state = find ? 1 : 0;
                this.expectedCount = Matcher.this.modCount;
                return find;
            }

            @Override // java.util.Iterator
            public void forEachRemaining(Consumer<? super MatchResult> action) {
                int i10 = this.expectedCount;
                if (i10 >= 0 && i10 != Matcher.this.modCount) {
                    throw new ConcurrentModificationException();
                }
                int s2 = this.state;
                if (s2 == 0) {
                    return;
                }
                this.state = 0;
                this.expectedCount = -1;
                if (s2 < 0 && !Matcher.this.find()) {
                    return;
                }
                this.textAsString = Matcher.this.text.toString();
                do {
                    int ec2 = Matcher.this.modCount;
                    action.accept(Matcher.this.toMatchResult(this.textAsString));
                    if (ec2 != Matcher.this.modCount) {
                        throw new ConcurrentModificationException();
                    }
                } while (Matcher.this.find());
            }
        }, 272), false);
    }

    public String replaceFirst(String replacement) {
        if (replacement == null) {
            throw new NullPointerException("replacement");
        }
        reset();
        if (!find()) {
            return this.text.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        appendReplacement(sb2, replacement);
        appendTail(sb2);
        return sb2.toString();
    }

    public String replaceFirst(Function<MatchResult, String> replacer) {
        Objects.requireNonNull(replacer);
        reset();
        if (!find()) {
            return this.text.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        int ec2 = this.modCount;
        String replacement = replacer.apply(this);
        if (ec2 != this.modCount) {
            throw new ConcurrentModificationException();
        }
        appendReplacement(sb2, replacement);
        appendTail(sb2);
        return sb2.toString();
    }

    public Matcher region(int start, int end) {
        return reset(this.originalInput, start, end);
    }

    public int regionStart() {
        return this.from;
    }

    public int regionEnd() {
        return this.to;
    }

    public boolean hasTransparentBounds() {
        return this.transparentBounds;
    }

    public Matcher useTransparentBounds(boolean b4) {
        synchronized (this) {
            this.transparentBounds = b4;
            this.nativeMatcher.useTransparentBounds(b4);
        }
        return this;
    }

    public boolean hasAnchoringBounds() {
        return this.anchoringBounds;
    }

    public Matcher useAnchoringBounds(boolean b4) {
        synchronized (this) {
            this.anchoringBounds = b4;
            this.nativeMatcher.useAnchoringBounds(b4);
        }
        return this;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("java.util.regex.Matcher").append("[pattern=").append((Object) pattern()).append(" region=").append(regionStart()).append(',').append(regionEnd()).append(" lastmatch=");
        if (this.matchFound && group() != null) {
            sb2.append(group());
        }
        sb2.append(']');
        return sb2.toString();
    }

    public boolean hitEnd() {
        boolean hitEnd;
        synchronized (this) {
            hitEnd = this.nativeMatcher.hitEnd();
        }
        return hitEnd;
    }

    public boolean requireEnd() {
        boolean requireEnd;
        synchronized (this) {
            requireEnd = this.nativeMatcher.requireEnd();
        }
        return requireEnd;
    }

    int getTextLength() {
        return this.text.length();
    }

    CharSequence getSubSequence(int beginIndex, int endIndex) {
        return this.text.subSequence(beginIndex, endIndex);
    }

    private Matcher reset(CharSequence input, int start, int end) {
        if (input == null) {
            throw new IllegalArgumentException("input == null");
        }
        if (start < 0 || end < 0 || start > input.length() || end > input.length() || start > end) {
            throw new IndexOutOfBoundsException();
        }
        this.originalInput = input;
        this.text = input.toString();
        this.from = start;
        this.to = end;
        resetForInput();
        this.matchFound = false;
        this.appendPos = 0;
        this.modCount++;
        return this;
    }

    private void resetForInput() {
        synchronized (this) {
            this.nativeMatcher.setInput(this.text, this.from, this.to);
            this.nativeMatcher.useAnchoringBounds(this.anchoringBounds);
            this.nativeMatcher.useTransparentBounds(this.transparentBounds);
        }
    }

    private void ensureMatch() {
        if (!this.matchFound) {
            throw new IllegalStateException("No successful match so far");
        }
    }

    private int getMatchedGroupIndex(String name) {
        ensureMatch();
        int result = this.nativeMatcher.getMatchedGroupIndex(name);
        if (result < 0) {
            throw new IllegalArgumentException("No capturing group in the pattern with the name " + name);
        }
        return result;
    }
}
