package androidx.window.embedding;

import android.app.Activity;
import android.content.Intent;
import android.util.Pair;
import android.view.WindowMetrics;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.extensions.embedding.ActivityRule;
import androidx.window.extensions.embedding.SplitPairRule;
import androidx.window.extensions.embedding.SplitPlaceholderRule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.t;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: EmbeddingAdapter.kt */
@ExperimentalWindowApi
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class EmbeddingAdapter {
    private final <F, S> F component1(Pair<F, S> pair) {
        s.i(pair, "<this>");
        return (F) pair.first;
    }

    private final <F, S> S component2(Pair<F, S> pair) {
        s.i(pair, "<this>");
        return (S) pair.second;
    }

    private final SplitInfo translate(androidx.window.extensions.embedding.SplitInfo splitInfo) {
        boolean z10;
        androidx.window.extensions.embedding.ActivityStack primaryActivityStack = splitInfo.getPrimaryActivityStack();
        s.h(primaryActivityStack, "splitInfo.primaryActivityStack");
        boolean z11 = false;
        try {
            z10 = primaryActivityStack.isEmpty();
        } catch (NoSuchMethodError unused) {
            z10 = false;
        }
        List activities = primaryActivityStack.getActivities();
        s.h(activities, "primaryActivityStack.activities");
        ActivityStack activityStack = new ActivityStack(activities, z10);
        androidx.window.extensions.embedding.ActivityStack secondaryActivityStack = splitInfo.getSecondaryActivityStack();
        s.h(secondaryActivityStack, "splitInfo.secondaryActivityStack");
        try {
            z11 = secondaryActivityStack.isEmpty();
        } catch (NoSuchMethodError unused2) {
        }
        List activities2 = secondaryActivityStack.getActivities();
        s.h(activities2, "secondaryActivityStack.activities");
        return new SplitInfo(activityStack, new ActivityStack(activities2, z11), splitInfo.getSplitRatio());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: translateActivityIntentPredicates$lambda-3, reason: not valid java name */
    public static final boolean m1755translateActivityIntentPredicates$lambda3(EmbeddingAdapter this$0, Set splitPairFilters, Pair pair) {
        s.i(this$0, "this$0");
        s.i(splitPairFilters, "$splitPairFilters");
        s.h(pair, "(first, second)");
        Activity activity = (Activity) this$0.component1(pair);
        Intent intent = (Intent) this$0.component2(pair);
        if ((splitPairFilters instanceof Collection) && splitPairFilters.isEmpty()) {
            return false;
        }
        Iterator<E> iterator2 = splitPairFilters.iterator2();
        while (iterator2.hasNext()) {
            if (((SplitPairFilter) iterator2.next()).matchesActivityIntentPair(activity, intent)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: translateActivityPairPredicates$lambda-1, reason: not valid java name */
    public static final boolean m1756translateActivityPairPredicates$lambda1(EmbeddingAdapter this$0, Set splitPairFilters, Pair pair) {
        s.i(this$0, "this$0");
        s.i(splitPairFilters, "$splitPairFilters");
        s.h(pair, "(first, second)");
        Activity activity = (Activity) this$0.component1(pair);
        Activity activity2 = (Activity) this$0.component2(pair);
        if ((splitPairFilters instanceof Collection) && splitPairFilters.isEmpty()) {
            return false;
        }
        Iterator<E> iterator2 = splitPairFilters.iterator2();
        while (iterator2.hasNext()) {
            if (((SplitPairFilter) iterator2.next()).matchesActivityPair(activity, activity2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: translateActivityPredicates$lambda-6, reason: not valid java name */
    public static final boolean m1757translateActivityPredicates$lambda6(Set activityFilters, Activity activity) {
        s.i(activityFilters, "$activityFilters");
        if ((activityFilters instanceof Collection) && activityFilters.isEmpty()) {
            return false;
        }
        Iterator<E> iterator2 = activityFilters.iterator2();
        while (iterator2.hasNext()) {
            ActivityFilter activityFilter = (ActivityFilter) iterator2.next();
            s.h(activity, "activity");
            if (activityFilter.matchesActivity(activity)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: translateIntentPredicates$lambda-8, reason: not valid java name */
    public static final boolean m1758translateIntentPredicates$lambda8(Set activityFilters, Intent intent) {
        s.i(activityFilters, "$activityFilters");
        if ((activityFilters instanceof Collection) && activityFilters.isEmpty()) {
            return false;
        }
        Iterator<E> iterator2 = activityFilters.iterator2();
        while (iterator2.hasNext()) {
            ActivityFilter activityFilter = (ActivityFilter) iterator2.next();
            s.h(intent, "intent");
            if (activityFilter.matchesIntent(intent)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: translateParentMetricsPredicate$lambda-4, reason: not valid java name */
    public static final boolean m1759translateParentMetricsPredicate$lambda4(SplitRule splitRule, WindowMetrics windowMetrics) {
        s.i(splitRule, "$splitRule");
        s.h(windowMetrics, "windowMetrics");
        return splitRule.checkParentMetrics(windowMetrics);
    }

    @NotNull
    public final Predicate<Pair<Activity, Intent>> translateActivityIntentPredicates(@NotNull final Set<SplitPairFilter> splitPairFilters) {
        s.i(splitPairFilters, "splitPairFilters");
        return new Predicate() { // from class: androidx.window.embedding.b
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean m1755translateActivityIntentPredicates$lambda3;
                m1755translateActivityIntentPredicates$lambda3 = EmbeddingAdapter.m1755translateActivityIntentPredicates$lambda3(EmbeddingAdapter.this, splitPairFilters, (Pair) obj);
                return m1755translateActivityIntentPredicates$lambda3;
            }
        };
    }

    @NotNull
    public final Predicate<Pair<Activity, Activity>> translateActivityPairPredicates(@NotNull final Set<SplitPairFilter> splitPairFilters) {
        s.i(splitPairFilters, "splitPairFilters");
        return new Predicate() { // from class: androidx.window.embedding.c
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean m1756translateActivityPairPredicates$lambda1;
                m1756translateActivityPairPredicates$lambda1 = EmbeddingAdapter.m1756translateActivityPairPredicates$lambda1(EmbeddingAdapter.this, splitPairFilters, (Pair) obj);
                return m1756translateActivityPairPredicates$lambda1;
            }
        };
    }

    @NotNull
    public final Predicate<Activity> translateActivityPredicates(@NotNull final Set<ActivityFilter> activityFilters) {
        s.i(activityFilters, "activityFilters");
        return new Predicate() { // from class: androidx.window.embedding.e
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean m1757translateActivityPredicates$lambda6;
                m1757translateActivityPredicates$lambda6 = EmbeddingAdapter.m1757translateActivityPredicates$lambda6(Set.this, (Activity) obj);
                return m1757translateActivityPredicates$lambda6;
            }
        };
    }

    @NotNull
    public final Predicate<Intent> translateIntentPredicates(@NotNull final Set<ActivityFilter> activityFilters) {
        s.i(activityFilters, "activityFilters");
        return new Predicate() { // from class: androidx.window.embedding.f
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean m1758translateIntentPredicates$lambda8;
                m1758translateIntentPredicates$lambda8 = EmbeddingAdapter.m1758translateIntentPredicates$lambda8(Set.this, (Intent) obj);
                return m1758translateIntentPredicates$lambda8;
            }
        };
    }

    @NotNull
    public final Predicate<WindowMetrics> translateParentMetricsPredicate(@NotNull final SplitRule splitRule) {
        s.i(splitRule, "splitRule");
        return new Predicate() { // from class: androidx.window.embedding.d
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean m1759translateParentMetricsPredicate$lambda4;
                m1759translateParentMetricsPredicate$lambda4 = EmbeddingAdapter.m1759translateParentMetricsPredicate$lambda4(SplitRule.this, (WindowMetrics) obj);
                return m1759translateParentMetricsPredicate$lambda4;
            }
        };
    }

    @NotNull
    public final List<SplitInfo> translate(@NotNull List<? extends androidx.window.extensions.embedding.SplitInfo> splitInfoList) {
        s.i(splitInfoList, "splitInfoList");
        ArrayList arrayList = new ArrayList(t.t(splitInfoList, 10));
        Iterator<? extends androidx.window.extensions.embedding.SplitInfo> iterator2 = splitInfoList.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(translate(iterator2.next()));
        }
        return arrayList;
    }

    @NotNull
    public final Set<androidx.window.extensions.embedding.EmbeddingRule> translate(@NotNull Set<? extends EmbeddingRule> rules) {
        androidx.window.extensions.embedding.SplitPairRule build;
        s.i(rules, "rules");
        ArrayList arrayList = new ArrayList(t.t(rules, 10));
        for (EmbeddingRule embeddingRule : rules) {
            if (embeddingRule instanceof SplitPairRule) {
                SplitPairRule splitPairRule = (SplitPairRule) embeddingRule;
                build = new SplitPairRule.Builder(translateActivityPairPredicates(splitPairRule.getFilters()), translateActivityIntentPredicates(splitPairRule.getFilters()), translateParentMetricsPredicate((SplitRule) embeddingRule)).setSplitRatio(splitPairRule.getSplitRatio()).setLayoutDirection(splitPairRule.getLayoutDirection()).setShouldFinishPrimaryWithSecondary(splitPairRule.getFinishPrimaryWithSecondary()).setShouldFinishSecondaryWithPrimary(splitPairRule.getFinishSecondaryWithPrimary()).setShouldClearTop(splitPairRule.getClearTop()).build();
                s.h(build, "SplitPairRuleBuilder(\n  …                 .build()");
            } else if (embeddingRule instanceof SplitPlaceholderRule) {
                SplitPlaceholderRule splitPlaceholderRule = (SplitPlaceholderRule) embeddingRule;
                build = new SplitPlaceholderRule.Builder(splitPlaceholderRule.getPlaceholderIntent(), translateActivityPredicates(splitPlaceholderRule.getFilters()), translateIntentPredicates(splitPlaceholderRule.getFilters()), translateParentMetricsPredicate((SplitRule) embeddingRule)).setSplitRatio(splitPlaceholderRule.getSplitRatio()).setLayoutDirection(splitPlaceholderRule.getLayoutDirection()).build();
                s.h(build, "SplitPlaceholderRuleBuil…                 .build()");
            } else if (embeddingRule instanceof ActivityRule) {
                ActivityRule activityRule = (ActivityRule) embeddingRule;
                build = new ActivityRule.Builder(translateActivityPredicates(activityRule.getFilters()), translateIntentPredicates(activityRule.getFilters())).setShouldAlwaysExpand(activityRule.getAlwaysExpand()).build();
                s.h(build, "ActivityRuleBuilder(\n   …                 .build()");
            } else {
                throw new IllegalArgumentException("Unsupported rule type");
            }
            arrayList.add((androidx.window.extensions.embedding.EmbeddingRule) build);
        }
        return CollectionsKt___CollectionsKt.A0(arrayList);
    }
}
