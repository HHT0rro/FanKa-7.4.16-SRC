package com.cupidapp.live.liveshow.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LiveFunctionMenuModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveFunctionMenuResult {

    @NotNull
    private final List<LiveFunctionMenuListModel> sections;

    public LiveFunctionMenuResult(@NotNull List<LiveFunctionMenuListModel> sections) {
        s.i(sections, "sections");
        this.sections = sections;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveFunctionMenuResult copy$default(LiveFunctionMenuResult liveFunctionMenuResult, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = liveFunctionMenuResult.sections;
        }
        return liveFunctionMenuResult.copy(list);
    }

    @NotNull
    public final List<LiveFunctionMenuListModel> component1() {
        return this.sections;
    }

    @NotNull
    public final LiveFunctionMenuResult copy(@NotNull List<LiveFunctionMenuListModel> sections) {
        s.i(sections, "sections");
        return new LiveFunctionMenuResult(sections);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveFunctionMenuResult) && s.d(this.sections, ((LiveFunctionMenuResult) obj).sections);
    }

    @NotNull
    public final List<LiveFunctionMenuListModel> getSections() {
        return this.sections;
    }

    public int hashCode() {
        return this.sections.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveFunctionMenuResult(sections=" + ((Object) this.sections) + ")";
    }
}
