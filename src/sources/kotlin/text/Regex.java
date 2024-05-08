package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.x;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.sequences.SequencesKt__SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Regex.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Regex implements Serializable {

    @NotNull
    public static final a Companion = new a(null);

    @Nullable
    private Set<? extends RegexOption> _options;

    @NotNull
    private final Pattern nativePattern;

    /* compiled from: Regex.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Serialized implements Serializable {

        @NotNull
        public static final a Companion = new a(null);
        private static final long serialVersionUID = 0;
        private final int flags;

        @NotNull
        private final String pattern;

        /* compiled from: Regex.kt */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Serialized(@NotNull String pattern, int i10) {
            s.i(pattern, "pattern");
            this.pattern = pattern;
            this.flags = i10;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            s.h(compile, "compile(pattern, flags)");
            return new Regex(compile);
        }

        public final int getFlags() {
            return this.flags;
        }

        @NotNull
        public final String getPattern() {
            return this.pattern;
        }
    }

    /* compiled from: Regex.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int b(int i10) {
            return (i10 & 2) != 0 ? i10 | 64 : i10;
        }
    }

    public Regex(@NotNull Pattern nativePattern) {
        s.i(nativePattern, "nativePattern");
        this.nativePattern = nativePattern;
    }

    public static /* synthetic */ MatchResult find$default(Regex regex, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return regex.find(charSequence, i10);
    }

    public static /* synthetic */ kotlin.sequences.g findAll$default(Regex regex, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return regex.findAll(charSequence, i10);
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return regex.split(charSequence, i10);
    }

    public static /* synthetic */ kotlin.sequences.g splitToSequence$default(Regex regex, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return regex.splitToSequence(charSequence, i10);
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        s.h(pattern, "nativePattern.pattern()");
        return new Serialized(pattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(@NotNull CharSequence input) {
        s.i(input, "input");
        return this.nativePattern.matcher(input).find();
    }

    @Nullable
    public final MatchResult find(@NotNull CharSequence input, int i10) {
        MatchResult f10;
        s.i(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        s.h(matcher, "nativePattern.matcher(input)");
        f10 = g.f(matcher, i10, input);
        return f10;
    }

    @NotNull
    public final kotlin.sequences.g<MatchResult> findAll(@NotNull final CharSequence input, final int i10) {
        s.i(input, "input");
        if (i10 >= 0 && i10 <= input.length()) {
            return SequencesKt__SequencesKt.f(new Function0<MatchResult>() { // from class: kotlin.text.Regex$findAll$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final MatchResult invoke() {
                    return Regex.this.find(input, i10);
                }
            }, Regex$findAll$2.INSTANCE);
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + i10 + ", input length: " + input.length());
    }

    @NotNull
    public final Set<RegexOption> getOptions() {
        Set set = this._options;
        if (set != null) {
            return set;
        }
        final int flags = this.nativePattern.flags();
        EnumSet fromInt$lambda$1 = EnumSet.allOf(RegexOption.class);
        s.h(fromInt$lambda$1, "fromInt$lambda$1");
        x.D(fromInt$lambda$1, new Function1<RegexOption, Boolean>() { // from class: kotlin.text.Regex$special$$inlined$fromInt$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(RegexOption regexOption) {
                RegexOption regexOption2 = regexOption;
                return Boolean.valueOf((flags & regexOption2.getMask()) == regexOption2.getValue());
            }
        });
        Set<RegexOption> unmodifiableSet = Collections.unmodifiableSet(fromInt$lambda$1);
        s.h(unmodifiableSet, "unmodifiableSet(EnumSet.…mask == it.value }\n    })");
        this._options = unmodifiableSet;
        return unmodifiableSet;
    }

    @NotNull
    public final String getPattern() {
        String pattern = this.nativePattern.pattern();
        s.h(pattern, "nativePattern.pattern()");
        return pattern;
    }

    @Nullable
    public final MatchResult matchAt(@NotNull CharSequence input, int i10) {
        s.i(input, "input");
        Matcher region = this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i10, input.length());
        if (!region.lookingAt()) {
            return null;
        }
        s.h(region, "this");
        return new MatcherMatchResult(region, input);
    }

    @Nullable
    public final MatchResult matchEntire(@NotNull CharSequence input) {
        MatchResult g3;
        s.i(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        s.h(matcher, "nativePattern.matcher(input)");
        g3 = g.g(matcher, input);
        return g3;
    }

    public final boolean matches(@NotNull CharSequence input) {
        s.i(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    public final boolean matchesAt(@NotNull CharSequence input, int i10) {
        s.i(input, "input");
        return this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i10, input.length()).lookingAt();
    }

    @NotNull
    public final String replace(@NotNull CharSequence input, @NotNull String replacement) {
        s.i(input, "input");
        s.i(replacement, "replacement");
        String replaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        s.h(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    @NotNull
    public final String replaceFirst(@NotNull CharSequence input, @NotNull String replacement) {
        s.i(input, "input");
        s.i(replacement, "replacement");
        String replaceFirst = this.nativePattern.matcher(input).replaceFirst(replacement);
        s.h(replaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return replaceFirst;
    }

    @NotNull
    public final List<String> split(@NotNull CharSequence input, int i10) {
        s.i(input, "input");
        StringsKt__StringsKt.u0(i10);
        Matcher matcher = this.nativePattern.matcher(input);
        if (i10 != 1 && matcher.find()) {
            ArrayList arrayList = new ArrayList(i10 > 0 ? ce.n.d(i10, 10) : 10);
            int i11 = 0;
            int i12 = i10 - 1;
            do {
                arrayList.add(input.subSequence(i11, matcher.start()).toString());
                i11 = matcher.end();
                if (i12 >= 0 && arrayList.size() == i12) {
                    break;
                }
            } while (matcher.find());
            arrayList.add(input.subSequence(i11, input.length()).toString());
            return arrayList;
        }
        return kotlin.collections.r.e(input.toString());
    }

    @NotNull
    public final kotlin.sequences.g<String> splitToSequence(@NotNull CharSequence input, int i10) {
        s.i(input, "input");
        StringsKt__StringsKt.u0(i10);
        return kotlin.sequences.j.b(new Regex$splitToSequence$1(this, input, i10, null));
    }

    @NotNull
    public final Pattern toPattern() {
        return this.nativePattern;
    }

    @NotNull
    public String toString() {
        String pattern = this.nativePattern.toString();
        s.h(pattern, "nativePattern.toString()");
        return pattern;
    }

    @NotNull
    public final String replace(@NotNull CharSequence input, @NotNull Function1<? super MatchResult, ? extends CharSequence> transform) {
        s.i(input, "input");
        s.i(transform, "transform");
        int i10 = 0;
        MatchResult find$default = find$default(this, input, 0, 2, null);
        if (find$default == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb2 = new StringBuilder(length);
        do {
            sb2.append(input, i10, find$default.getRange().getStart().intValue());
            sb2.append(transform.invoke(find$default));
            i10 = find$default.getRange().getEndInclusive().intValue() + 1;
            find$default = find$default.next();
            if (i10 >= length) {
                break;
            }
        } while (find$default != null);
        if (i10 < length) {
            sb2.append(input, i10, length);
        }
        String sb3 = sb2.toString();
        s.h(sb3, "sb.toString()");
        return sb3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Regex(@org.jetbrains.annotations.NotNull java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.s.i(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "compile(pattern)"
            kotlin.jvm.internal.s.h(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Regex(@org.jetbrains.annotations.NotNull java.lang.String r2, @org.jetbrains.annotations.NotNull kotlin.text.RegexOption r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.s.i(r2, r0)
            java.lang.String r0 = "option"
            kotlin.jvm.internal.s.i(r3, r0)
            kotlin.text.Regex$a r0 = kotlin.text.Regex.Companion
            int r3 = r3.getValue()
            int r3 = kotlin.text.Regex.a.a(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "compile(pattern, ensureUnicodeCase(option.value))"
            kotlin.jvm.internal.s.h(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, kotlin.text.RegexOption):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Regex(@org.jetbrains.annotations.NotNull java.lang.String r2, @org.jetbrains.annotations.NotNull java.util.Set<? extends kotlin.text.RegexOption> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.s.i(r2, r0)
            java.lang.String r0 = "options"
            kotlin.jvm.internal.s.i(r3, r0)
            kotlin.text.Regex$a r0 = kotlin.text.Regex.Companion
            int r3 = kotlin.text.g.e(r3)
            int r3 = kotlin.text.Regex.a.a(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "compile(pattern, ensureU…odeCase(options.toInt()))"
            kotlin.jvm.internal.s.h(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, java.util.Set):void");
    }
}
