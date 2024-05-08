package kotlin.text;

import java.util.Iterator;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Regex.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class MatcherMatchResult$groups$1 extends AbstractCollection<f> implements MatchGroupCollection {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MatcherMatchResult f51093b;

    public MatcherMatchResult$groups$1(MatcherMatchResult matcherMatchResult) {
        this.f51093b = matcherMatchResult;
    }

    public /* bridge */ boolean b(f fVar) {
        return super.contains(fVar);
    }

    @Nullable
    public f c(int i10) {
        IntRange i11;
        i11 = g.i(this.f51093b.getMatchResult(), i10);
        if (i11.getStart().intValue() < 0) {
            return null;
        }
        String group = this.f51093b.getMatchResult().group(i10);
        s.h(group, "matchResult.group(index)");
        return new f(group, i11);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof f) {
            return b((f) obj);
        }
        return false;
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f51093b.getMatchResult().groupCount() + 1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return false;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    @NotNull
    /* renamed from: iterator */
    public Iterator<f> iterator2() {
        return SequencesKt___SequencesKt.r(CollectionsKt___CollectionsKt.K(kotlin.collections.s.k(this)), new Function1<Integer, f>() { // from class: kotlin.text.MatcherMatchResult$groups$1$iterator$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ f invoke(Integer num) {
                return invoke(num.intValue());
            }

            @Nullable
            public final f invoke(int i10) {
                return MatcherMatchResult$groups$1.this.c(i10);
            }
        }).iterator();
    }
}
