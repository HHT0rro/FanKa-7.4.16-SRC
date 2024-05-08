package kotlin.text;

import java.util.List;
import java.util.regex.Matcher;
import kotlin.jvm.internal.s;
import kotlin.ranges.IntRange;
import kotlin.text.MatchResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Regex.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class MatcherMatchResult implements MatchResult {

    @Nullable
    private List<String> groupValues_;

    @NotNull
    private final MatchGroupCollection groups;

    @NotNull
    private final CharSequence input;

    @NotNull
    private final Matcher matcher;

    /* compiled from: Regex.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a extends kotlin.collections.b<String> {
        public a() {
        }

        public /* bridge */ boolean b(String str) {
            return super.contains(str);
        }

        @Override // kotlin.collections.b, java.util.List
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public String get(int i10) {
            String group = MatcherMatchResult.this.getMatchResult().group(i10);
            return group == null ? "" : group;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return b((String) obj);
            }
            return false;
        }

        public /* bridge */ int f(String str) {
            return super.indexOf(str);
        }

        public /* bridge */ int g(String str) {
            return super.lastIndexOf(str);
        }

        @Override // kotlin.collections.b, kotlin.collections.AbstractCollection
        public int getSize() {
            return MatcherMatchResult.this.getMatchResult().groupCount() + 1;
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return f((String) obj);
            }
            return -1;
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return g((String) obj);
            }
            return -1;
        }
    }

    public MatcherMatchResult(@NotNull Matcher matcher, @NotNull CharSequence input) {
        s.i(matcher, "matcher");
        s.i(input, "input");
        this.matcher = matcher;
        this.input = input;
        this.groups = new MatcherMatchResult$groups$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final java.util.regex.MatchResult getMatchResult() {
        return this.matcher;
    }

    @Override // kotlin.text.MatchResult
    @NotNull
    public MatchResult.Destructured getDestructured() {
        return MatchResult.a.a(this);
    }

    @Override // kotlin.text.MatchResult
    @NotNull
    public List<String> getGroupValues() {
        if (this.groupValues_ == null) {
            this.groupValues_ = new a();
        }
        List<String> list = this.groupValues_;
        s.f(list);
        return list;
    }

    @Override // kotlin.text.MatchResult
    @NotNull
    public MatchGroupCollection getGroups() {
        return this.groups;
    }

    @Override // kotlin.text.MatchResult
    @NotNull
    public IntRange getRange() {
        IntRange h10;
        h10 = g.h(getMatchResult());
        return h10;
    }

    @Override // kotlin.text.MatchResult
    @NotNull
    public String getValue() {
        String group = getMatchResult().group();
        s.h(group, "matchResult.group()");
        return group;
    }

    @Override // kotlin.text.MatchResult
    @Nullable
    public MatchResult next() {
        MatchResult f10;
        int end = getMatchResult().end() + (getMatchResult().end() == getMatchResult().start() ? 1 : 0);
        if (end > this.input.length()) {
            return null;
        }
        Matcher matcher = this.matcher.pattern().matcher(this.input);
        s.h(matcher, "matcher.pattern().matcher(input)");
        f10 = g.f(matcher, end, this.input);
        return f10;
    }
}
