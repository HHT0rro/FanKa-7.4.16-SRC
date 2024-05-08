package com.cupidapp.live.consult.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultCloseLiveFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultAnchorCloseLiveResult {

    @NotNull
    private final ConsultAnchorCloseLiveModel summary;

    @Nullable
    private final String tips;

    public ConsultAnchorCloseLiveResult(@NotNull ConsultAnchorCloseLiveModel summary, @Nullable String str) {
        s.i(summary, "summary");
        this.summary = summary;
        this.tips = str;
    }

    public static /* synthetic */ ConsultAnchorCloseLiveResult copy$default(ConsultAnchorCloseLiveResult consultAnchorCloseLiveResult, ConsultAnchorCloseLiveModel consultAnchorCloseLiveModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            consultAnchorCloseLiveModel = consultAnchorCloseLiveResult.summary;
        }
        if ((i10 & 2) != 0) {
            str = consultAnchorCloseLiveResult.tips;
        }
        return consultAnchorCloseLiveResult.copy(consultAnchorCloseLiveModel, str);
    }

    @NotNull
    public final ConsultAnchorCloseLiveModel component1() {
        return this.summary;
    }

    @Nullable
    public final String component2() {
        return this.tips;
    }

    @NotNull
    public final ConsultAnchorCloseLiveResult copy(@NotNull ConsultAnchorCloseLiveModel summary, @Nullable String str) {
        s.i(summary, "summary");
        return new ConsultAnchorCloseLiveResult(summary, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsultAnchorCloseLiveResult)) {
            return false;
        }
        ConsultAnchorCloseLiveResult consultAnchorCloseLiveResult = (ConsultAnchorCloseLiveResult) obj;
        return s.d(this.summary, consultAnchorCloseLiveResult.summary) && s.d(this.tips, consultAnchorCloseLiveResult.tips);
    }

    @NotNull
    public final ConsultAnchorCloseLiveModel getSummary() {
        return this.summary;
    }

    @Nullable
    public final String getTips() {
        return this.tips;
    }

    public int hashCode() {
        int hashCode = this.summary.hashCode() * 31;
        String str = this.tips;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        ConsultAnchorCloseLiveModel consultAnchorCloseLiveModel = this.summary;
        return "ConsultAnchorCloseLiveResult(summary=" + ((Object) consultAnchorCloseLiveModel) + ", tips=" + this.tips + ")";
    }
}
