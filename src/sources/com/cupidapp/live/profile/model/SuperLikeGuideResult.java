package com.cupidapp.live.profile.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SuperLikeGuideResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperLikeGuideResult {

    @Nullable
    private final String guideText;

    @Nullable
    private final String remainNums;

    public SuperLikeGuideResult(@Nullable String str, @Nullable String str2) {
        this.remainNums = str;
        this.guideText = str2;
    }

    public static /* synthetic */ SuperLikeGuideResult copy$default(SuperLikeGuideResult superLikeGuideResult, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = superLikeGuideResult.remainNums;
        }
        if ((i10 & 2) != 0) {
            str2 = superLikeGuideResult.guideText;
        }
        return superLikeGuideResult.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.remainNums;
    }

    @Nullable
    public final String component2() {
        return this.guideText;
    }

    @NotNull
    public final SuperLikeGuideResult copy(@Nullable String str, @Nullable String str2) {
        return new SuperLikeGuideResult(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuperLikeGuideResult)) {
            return false;
        }
        SuperLikeGuideResult superLikeGuideResult = (SuperLikeGuideResult) obj;
        return s.d(this.remainNums, superLikeGuideResult.remainNums) && s.d(this.guideText, superLikeGuideResult.guideText);
    }

    @Nullable
    public final String getGuideText() {
        return this.guideText;
    }

    @Nullable
    public final String getRemainNums() {
        return this.remainNums;
    }

    public int hashCode() {
        String str = this.remainNums;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.guideText;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "SuperLikeGuideResult(remainNums=" + this.remainNums + ", guideText=" + this.guideText + ")";
    }
}
