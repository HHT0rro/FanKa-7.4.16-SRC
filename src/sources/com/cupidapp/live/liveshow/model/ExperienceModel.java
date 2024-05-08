package com.cupidapp.live.liveshow.model;

import b2.a;
import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ExperienceModel implements Serializable {
    private final long currentExp;

    @NotNull
    private final ImageModel currentLevelIcon;
    private final boolean maxLevel;
    private final long nextLevelNeedExp;

    @NotNull
    private final String nextLevelText;

    public ExperienceModel(@NotNull ImageModel currentLevelIcon, @NotNull String nextLevelText, long j10, long j11, boolean z10) {
        s.i(currentLevelIcon, "currentLevelIcon");
        s.i(nextLevelText, "nextLevelText");
        this.currentLevelIcon = currentLevelIcon;
        this.nextLevelText = nextLevelText;
        this.currentExp = j10;
        this.nextLevelNeedExp = j11;
        this.maxLevel = z10;
    }

    public static /* synthetic */ ExperienceModel copy$default(ExperienceModel experienceModel, ImageModel imageModel, String str, long j10, long j11, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = experienceModel.currentLevelIcon;
        }
        if ((i10 & 2) != 0) {
            str = experienceModel.nextLevelText;
        }
        String str2 = str;
        if ((i10 & 4) != 0) {
            j10 = experienceModel.currentExp;
        }
        long j12 = j10;
        if ((i10 & 8) != 0) {
            j11 = experienceModel.nextLevelNeedExp;
        }
        long j13 = j11;
        if ((i10 & 16) != 0) {
            z10 = experienceModel.maxLevel;
        }
        return experienceModel.copy(imageModel, str2, j12, j13, z10);
    }

    @NotNull
    public final ImageModel component1() {
        return this.currentLevelIcon;
    }

    @NotNull
    public final String component2() {
        return this.nextLevelText;
    }

    public final long component3() {
        return this.currentExp;
    }

    public final long component4() {
        return this.nextLevelNeedExp;
    }

    public final boolean component5() {
        return this.maxLevel;
    }

    @NotNull
    public final ExperienceModel copy(@NotNull ImageModel currentLevelIcon, @NotNull String nextLevelText, long j10, long j11, boolean z10) {
        s.i(currentLevelIcon, "currentLevelIcon");
        s.i(nextLevelText, "nextLevelText");
        return new ExperienceModel(currentLevelIcon, nextLevelText, j10, j11, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExperienceModel)) {
            return false;
        }
        ExperienceModel experienceModel = (ExperienceModel) obj;
        return s.d(this.currentLevelIcon, experienceModel.currentLevelIcon) && s.d(this.nextLevelText, experienceModel.nextLevelText) && this.currentExp == experienceModel.currentExp && this.nextLevelNeedExp == experienceModel.nextLevelNeedExp && this.maxLevel == experienceModel.maxLevel;
    }

    public final long getCurrentExp() {
        return this.currentExp;
    }

    @NotNull
    public final ImageModel getCurrentLevelIcon() {
        return this.currentLevelIcon;
    }

    public final boolean getMaxLevel() {
        return this.maxLevel;
    }

    public final long getNextLevelNeedExp() {
        return this.nextLevelNeedExp;
    }

    @NotNull
    public final String getNextLevelText() {
        return this.nextLevelText;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.currentLevelIcon.hashCode() * 31) + this.nextLevelText.hashCode()) * 31) + a.a(this.currentExp)) * 31) + a.a(this.nextLevelNeedExp)) * 31;
        boolean z10 = this.maxLevel;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.currentLevelIcon;
        return "ExperienceModel(currentLevelIcon=" + ((Object) imageModel) + ", nextLevelText=" + this.nextLevelText + ", currentExp=" + this.currentExp + ", nextLevelNeedExp=" + this.nextLevelNeedExp + ", maxLevel=" + this.maxLevel + ")";
    }
}
