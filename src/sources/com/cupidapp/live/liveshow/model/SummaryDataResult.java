package com.cupidapp.live.liveshow.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveSummaryDataResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SummaryDataResult {

    @NotNull
    private final SummaryModel summary;

    public SummaryDataResult(@NotNull SummaryModel summary) {
        s.i(summary, "summary");
        this.summary = summary;
    }

    public static /* synthetic */ SummaryDataResult copy$default(SummaryDataResult summaryDataResult, SummaryModel summaryModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            summaryModel = summaryDataResult.summary;
        }
        return summaryDataResult.copy(summaryModel);
    }

    @NotNull
    public final SummaryModel component1() {
        return this.summary;
    }

    @NotNull
    public final SummaryDataResult copy(@NotNull SummaryModel summary) {
        s.i(summary, "summary");
        return new SummaryDataResult(summary);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SummaryDataResult) && s.d(this.summary, ((SummaryDataResult) obj).summary);
    }

    @NotNull
    public final SummaryModel getSummary() {
        return this.summary;
    }

    public int hashCode() {
        return this.summary.hashCode();
    }

    @NotNull
    public String toString() {
        return "SummaryDataResult(summary=" + ((Object) this.summary) + ")";
    }
}
