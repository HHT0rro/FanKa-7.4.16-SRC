package com.cupidapp.live.club.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubWelcomeTipModel {

    @Nullable
    private final String bottomMsg;

    @Nullable
    private final String title;

    public ClubWelcomeTipModel(@Nullable String str, @Nullable String str2) {
        this.title = str;
        this.bottomMsg = str2;
    }

    public static /* synthetic */ ClubWelcomeTipModel copy$default(ClubWelcomeTipModel clubWelcomeTipModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = clubWelcomeTipModel.title;
        }
        if ((i10 & 2) != 0) {
            str2 = clubWelcomeTipModel.bottomMsg;
        }
        return clubWelcomeTipModel.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.bottomMsg;
    }

    @NotNull
    public final ClubWelcomeTipModel copy(@Nullable String str, @Nullable String str2) {
        return new ClubWelcomeTipModel(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClubWelcomeTipModel)) {
            return false;
        }
        ClubWelcomeTipModel clubWelcomeTipModel = (ClubWelcomeTipModel) obj;
        return s.d(this.title, clubWelcomeTipModel.title) && s.d(this.bottomMsg, clubWelcomeTipModel.bottomMsg);
    }

    @Nullable
    public final String getBottomMsg() {
        return this.bottomMsg;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.bottomMsg;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ClubWelcomeTipModel(title=" + this.title + ", bottomMsg=" + this.bottomMsg + ")";
    }
}
