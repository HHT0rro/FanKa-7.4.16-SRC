package com.cupidapp.live.liveshow.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class StarChallengeLvlUpgradeModel {

    @Nullable
    private final String text;

    public StarChallengeLvlUpgradeModel(@Nullable String str) {
        this.text = str;
    }

    public static /* synthetic */ StarChallengeLvlUpgradeModel copy$default(StarChallengeLvlUpgradeModel starChallengeLvlUpgradeModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = starChallengeLvlUpgradeModel.text;
        }
        return starChallengeLvlUpgradeModel.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.text;
    }

    @NotNull
    public final StarChallengeLvlUpgradeModel copy(@Nullable String str) {
        return new StarChallengeLvlUpgradeModel(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StarChallengeLvlUpgradeModel) && s.d(this.text, ((StarChallengeLvlUpgradeModel) obj).text);
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.text;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "StarChallengeLvlUpgradeModel(text=" + this.text + ")";
    }
}
