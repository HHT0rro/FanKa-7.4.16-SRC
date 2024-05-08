package com.cupidapp.live.match.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchFilterUiModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class IntelligentFilterUiModel {

    @Nullable
    private List<String> matchKeywords;

    @Nullable
    private List<String> recommendWords;

    public IntelligentFilterUiModel(@Nullable List<String> list, @Nullable List<String> list2) {
        this.matchKeywords = list;
        this.recommendWords = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IntelligentFilterUiModel copy$default(IntelligentFilterUiModel intelligentFilterUiModel, List list, List list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = intelligentFilterUiModel.matchKeywords;
        }
        if ((i10 & 2) != 0) {
            list2 = intelligentFilterUiModel.recommendWords;
        }
        return intelligentFilterUiModel.copy(list, list2);
    }

    @Nullable
    public final List<String> component1() {
        return this.matchKeywords;
    }

    @Nullable
    public final List<String> component2() {
        return this.recommendWords;
    }

    @NotNull
    public final IntelligentFilterUiModel copy(@Nullable List<String> list, @Nullable List<String> list2) {
        return new IntelligentFilterUiModel(list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntelligentFilterUiModel)) {
            return false;
        }
        IntelligentFilterUiModel intelligentFilterUiModel = (IntelligentFilterUiModel) obj;
        return s.d(this.matchKeywords, intelligentFilterUiModel.matchKeywords) && s.d(this.recommendWords, intelligentFilterUiModel.recommendWords);
    }

    @Nullable
    public final List<String> getMatchKeywords() {
        return this.matchKeywords;
    }

    @Nullable
    public final List<String> getRecommendWords() {
        return this.recommendWords;
    }

    public int hashCode() {
        List<String> list = this.matchKeywords;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<String> list2 = this.recommendWords;
        return hashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setMatchKeywords(@Nullable List<String> list) {
        this.matchKeywords = list;
    }

    public final void setRecommendWords(@Nullable List<String> list) {
        this.recommendWords = list;
    }

    @NotNull
    public String toString() {
        return "IntelligentFilterUiModel(matchKeywords=" + ((Object) this.matchKeywords) + ", recommendWords=" + ((Object) this.recommendWords) + ")";
    }
}
