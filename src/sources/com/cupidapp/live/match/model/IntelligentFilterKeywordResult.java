package com.cupidapp.live.match.model;

import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FilterModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class IntelligentFilterKeywordResult {

    @Nullable
    private final Map<String, List<String>> matchKeywords;

    @NotNull
    private final List<SVipKeywordOptionModel> svipKeyWordOptions;

    /* JADX WARN: Multi-variable type inference failed */
    public IntelligentFilterKeywordResult(@Nullable Map<String, ? extends List<String>> map, @NotNull List<SVipKeywordOptionModel> svipKeyWordOptions) {
        s.i(svipKeyWordOptions, "svipKeyWordOptions");
        this.matchKeywords = map;
        this.svipKeyWordOptions = svipKeyWordOptions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IntelligentFilterKeywordResult copy$default(IntelligentFilterKeywordResult intelligentFilterKeywordResult, Map map, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            map = intelligentFilterKeywordResult.matchKeywords;
        }
        if ((i10 & 2) != 0) {
            list = intelligentFilterKeywordResult.svipKeyWordOptions;
        }
        return intelligentFilterKeywordResult.copy(map, list);
    }

    @Nullable
    public final Map<String, List<String>> component1() {
        return this.matchKeywords;
    }

    @NotNull
    public final List<SVipKeywordOptionModel> component2() {
        return this.svipKeyWordOptions;
    }

    @NotNull
    public final IntelligentFilterKeywordResult copy(@Nullable Map<String, ? extends List<String>> map, @NotNull List<SVipKeywordOptionModel> svipKeyWordOptions) {
        s.i(svipKeyWordOptions, "svipKeyWordOptions");
        return new IntelligentFilterKeywordResult(map, svipKeyWordOptions);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntelligentFilterKeywordResult)) {
            return false;
        }
        IntelligentFilterKeywordResult intelligentFilterKeywordResult = (IntelligentFilterKeywordResult) obj;
        return s.d(this.matchKeywords, intelligentFilterKeywordResult.matchKeywords) && s.d(this.svipKeyWordOptions, intelligentFilterKeywordResult.svipKeyWordOptions);
    }

    @Nullable
    public final Map<String, List<String>> getMatchKeywords() {
        return this.matchKeywords;
    }

    @NotNull
    public final List<SVipKeywordOptionModel> getSvipKeyWordOptions() {
        return this.svipKeyWordOptions;
    }

    public int hashCode() {
        Map<String, List<String>> map = this.matchKeywords;
        return ((map == null ? 0 : map.hashCode()) * 31) + this.svipKeyWordOptions.hashCode();
    }

    @NotNull
    public String toString() {
        return "IntelligentFilterKeywordResult(matchKeywords=" + ((Object) this.matchKeywords) + ", svipKeyWordOptions=" + ((Object) this.svipKeyWordOptions) + ")";
    }
}
