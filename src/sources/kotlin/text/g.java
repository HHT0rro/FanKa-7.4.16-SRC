package kotlin.text;

import java.util.Iterator;
import java.util.regex.Matcher;
import kotlin.ranges.IntRange;

/* compiled from: Regex.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class g {
    public static final MatchResult f(Matcher matcher, int i10, CharSequence charSequence) {
        if (matcher.find(i10)) {
            return new MatcherMatchResult(matcher, charSequence);
        }
        return null;
    }

    public static final MatchResult g(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new MatcherMatchResult(matcher, charSequence);
        }
        return null;
    }

    public static final IntRange h(java.util.regex.MatchResult matchResult) {
        return ce.n.i(matchResult.start(), matchResult.end());
    }

    public static final IntRange i(java.util.regex.MatchResult matchResult, int i10) {
        return ce.n.i(matchResult.start(i10), matchResult.end(i10));
    }

    public static final int j(Iterable<? extends e> iterable) {
        Iterator<? extends e> iterator2 = iterable.iterator2();
        int i10 = 0;
        while (iterator2.hasNext()) {
            i10 |= iterator2.next().getValue();
        }
        return i10;
    }
}
