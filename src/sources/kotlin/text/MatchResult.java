package kotlin.text;

import java.util.List;
import kotlin.jvm.internal.s;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchResult.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface MatchResult {

    /* compiled from: MatchResult.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Destructured {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public final MatchResult f51091a;

        public Destructured(@NotNull MatchResult match) {
            s.i(match, "match");
            this.f51091a = match;
        }
    }

    /* compiled from: MatchResult.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        @NotNull
        public static Destructured a(@NotNull MatchResult matchResult) {
            return new Destructured(matchResult);
        }
    }

    @NotNull
    Destructured getDestructured();

    @NotNull
    List<String> getGroupValues();

    @NotNull
    MatchGroupCollection getGroups();

    @NotNull
    IntRange getRange();

    @NotNull
    String getValue();

    @Nullable
    MatchResult next();
}
