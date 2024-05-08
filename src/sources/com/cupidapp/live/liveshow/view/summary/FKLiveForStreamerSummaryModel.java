package com.cupidapp.live.liveshow.view.summary;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveForStreamerSummaryLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveForStreamerSummaryModel {

    @NotNull
    private final String title;

    @NotNull
    private final String value;

    public FKLiveForStreamerSummaryModel(@NotNull String title, @NotNull String value) {
        s.i(title, "title");
        s.i(value, "value");
        this.title = title;
        this.value = value;
    }

    public static /* synthetic */ FKLiveForStreamerSummaryModel copy$default(FKLiveForStreamerSummaryModel fKLiveForStreamerSummaryModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = fKLiveForStreamerSummaryModel.title;
        }
        if ((i10 & 2) != 0) {
            str2 = fKLiveForStreamerSummaryModel.value;
        }
        return fKLiveForStreamerSummaryModel.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.value;
    }

    @NotNull
    public final FKLiveForStreamerSummaryModel copy(@NotNull String title, @NotNull String value) {
        s.i(title, "title");
        s.i(value, "value");
        return new FKLiveForStreamerSummaryModel(title, value);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKLiveForStreamerSummaryModel)) {
            return false;
        }
        FKLiveForStreamerSummaryModel fKLiveForStreamerSummaryModel = (FKLiveForStreamerSummaryModel) obj;
        return s.d(this.title, fKLiveForStreamerSummaryModel.title) && s.d(this.value, fKLiveForStreamerSummaryModel.value);
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.value.hashCode();
    }

    @NotNull
    public String toString() {
        return "FKLiveForStreamerSummaryModel(title=" + this.title + ", value=" + this.value + ")";
    }
}
