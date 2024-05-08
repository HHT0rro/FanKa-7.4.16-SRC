package com.cupidapp.live.match.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class GuideModel {

    @Nullable
    private final String guideContent;

    public GuideModel(@Nullable String str) {
        this.guideContent = str;
    }

    public static /* synthetic */ GuideModel copy$default(GuideModel guideModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = guideModel.guideContent;
        }
        return guideModel.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.guideContent;
    }

    @NotNull
    public final GuideModel copy(@Nullable String str) {
        return new GuideModel(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GuideModel) && s.d(this.guideContent, ((GuideModel) obj).guideContent);
    }

    @Nullable
    public final String getGuideContent() {
        return this.guideContent;
    }

    public int hashCode() {
        String str = this.guideContent;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuideModel(guideContent=" + this.guideContent + ")";
    }
}
