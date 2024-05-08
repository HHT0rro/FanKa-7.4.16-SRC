package com.cupidapp.live.setting.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PrivacySettingDataResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FootMarkResult {
    private int footmarkDelCount;
    private int footmarkDelPerMonth;
    private boolean hiddenFootmark;

    @NotNull
    private String introduction;

    public FootMarkResult(boolean z10, int i10, int i11, @NotNull String introduction) {
        s.i(introduction, "introduction");
        this.hiddenFootmark = z10;
        this.footmarkDelCount = i10;
        this.footmarkDelPerMonth = i11;
        this.introduction = introduction;
    }

    public static /* synthetic */ FootMarkResult copy$default(FootMarkResult footMarkResult, boolean z10, int i10, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            z10 = footMarkResult.hiddenFootmark;
        }
        if ((i12 & 2) != 0) {
            i10 = footMarkResult.footmarkDelCount;
        }
        if ((i12 & 4) != 0) {
            i11 = footMarkResult.footmarkDelPerMonth;
        }
        if ((i12 & 8) != 0) {
            str = footMarkResult.introduction;
        }
        return footMarkResult.copy(z10, i10, i11, str);
    }

    public final boolean component1() {
        return this.hiddenFootmark;
    }

    public final int component2() {
        return this.footmarkDelCount;
    }

    public final int component3() {
        return this.footmarkDelPerMonth;
    }

    @NotNull
    public final String component4() {
        return this.introduction;
    }

    @NotNull
    public final FootMarkResult copy(boolean z10, int i10, int i11, @NotNull String introduction) {
        s.i(introduction, "introduction");
        return new FootMarkResult(z10, i10, i11, introduction);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FootMarkResult)) {
            return false;
        }
        FootMarkResult footMarkResult = (FootMarkResult) obj;
        return this.hiddenFootmark == footMarkResult.hiddenFootmark && this.footmarkDelCount == footMarkResult.footmarkDelCount && this.footmarkDelPerMonth == footMarkResult.footmarkDelPerMonth && s.d(this.introduction, footMarkResult.introduction);
    }

    public final int getFootmarkDelCount() {
        return this.footmarkDelCount;
    }

    public final int getFootmarkDelPerMonth() {
        return this.footmarkDelPerMonth;
    }

    public final boolean getHiddenFootmark() {
        return this.hiddenFootmark;
    }

    @NotNull
    public final String getIntroduction() {
        return this.introduction;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z10 = this.hiddenFootmark;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        return (((((r02 * 31) + this.footmarkDelCount) * 31) + this.footmarkDelPerMonth) * 31) + this.introduction.hashCode();
    }

    public final void setFootmarkDelCount(int i10) {
        this.footmarkDelCount = i10;
    }

    public final void setFootmarkDelPerMonth(int i10) {
        this.footmarkDelPerMonth = i10;
    }

    public final void setHiddenFootmark(boolean z10) {
        this.hiddenFootmark = z10;
    }

    public final void setIntroduction(@NotNull String str) {
        s.i(str, "<set-?>");
        this.introduction = str;
    }

    @NotNull
    public String toString() {
        return "FootMarkResult(hiddenFootmark=" + this.hiddenFootmark + ", footmarkDelCount=" + this.footmarkDelCount + ", footmarkDelPerMonth=" + this.footmarkDelPerMonth + ", introduction=" + this.introduction + ")";
    }

    public /* synthetic */ FootMarkResult(boolean z10, int i10, int i11, String str, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? false : z10, i10, i11, str);
    }
}
