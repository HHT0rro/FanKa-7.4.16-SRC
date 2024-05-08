package com.cupidapp.live.liveshow.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveSummaryDataResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ExperienceInfoModel implements Serializable {
    private final int currentLevel;
    private final double diffExperience;
    private final double expPercent;
    private final boolean fullLevel;

    @NotNull
    private final String liveIncome;
    private final int nextLevel;

    public ExperienceInfoModel(int i10, int i11, double d10, double d11, boolean z10, @NotNull String liveIncome) {
        s.i(liveIncome, "liveIncome");
        this.currentLevel = i10;
        this.nextLevel = i11;
        this.diffExperience = d10;
        this.expPercent = d11;
        this.fullLevel = z10;
        this.liveIncome = liveIncome;
    }

    public final int component1() {
        return this.currentLevel;
    }

    public final int component2() {
        return this.nextLevel;
    }

    public final double component3() {
        return this.diffExperience;
    }

    public final double component4() {
        return this.expPercent;
    }

    public final boolean component5() {
        return this.fullLevel;
    }

    @NotNull
    public final String component6() {
        return this.liveIncome;
    }

    @NotNull
    public final ExperienceInfoModel copy(int i10, int i11, double d10, double d11, boolean z10, @NotNull String liveIncome) {
        s.i(liveIncome, "liveIncome");
        return new ExperienceInfoModel(i10, i11, d10, d11, z10, liveIncome);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExperienceInfoModel)) {
            return false;
        }
        ExperienceInfoModel experienceInfoModel = (ExperienceInfoModel) obj;
        return this.currentLevel == experienceInfoModel.currentLevel && this.nextLevel == experienceInfoModel.nextLevel && Double.compare(this.diffExperience, experienceInfoModel.diffExperience) == 0 && Double.compare(this.expPercent, experienceInfoModel.expPercent) == 0 && this.fullLevel == experienceInfoModel.fullLevel && s.d(this.liveIncome, experienceInfoModel.liveIncome);
    }

    public final int getCurrentLevel() {
        return this.currentLevel;
    }

    public final double getDiffExperience() {
        return this.diffExperience;
    }

    public final double getExpPercent() {
        return this.expPercent;
    }

    public final boolean getFullLevel() {
        return this.fullLevel;
    }

    @NotNull
    public final String getLiveIncome() {
        return this.liveIncome;
    }

    public final int getNextLevel() {
        return this.nextLevel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a10 = ((((((this.currentLevel * 31) + this.nextLevel) * 31) + ce.d.a(this.diffExperience)) * 31) + ce.d.a(this.expPercent)) * 31;
        boolean z10 = this.fullLevel;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return ((a10 + i10) * 31) + this.liveIncome.hashCode();
    }

    @NotNull
    public String toString() {
        return "ExperienceInfoModel(currentLevel=" + this.currentLevel + ", nextLevel=" + this.nextLevel + ", diffExperience=" + this.diffExperience + ", expPercent=" + this.expPercent + ", fullLevel=" + this.fullLevel + ", liveIncome=" + this.liveIncome + ")";
    }
}
