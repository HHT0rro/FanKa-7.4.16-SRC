package com.cupidapp.live.profile.model;

import com.cupidapp.live.R$mipmap;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: User.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserVipDetailModel {
    private final boolean annualSsvip;
    private final boolean annualSvip;
    private final boolean annualVip;
    private final boolean sVip;
    private final boolean ssvip;
    private final boolean vip;
    private final boolean vipIconHide;

    public UserVipDetailModel() {
        this(false, false, false, false, false, false, false, 127, null);
    }

    public UserVipDetailModel(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        this.vip = z10;
        this.annualVip = z11;
        this.sVip = z12;
        this.annualSvip = z13;
        this.ssvip = z14;
        this.annualSsvip = z15;
        this.vipIconHide = z16;
    }

    public static /* synthetic */ UserVipDetailModel copy$default(UserVipDetailModel userVipDetailModel, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = userVipDetailModel.vip;
        }
        if ((i10 & 2) != 0) {
            z11 = userVipDetailModel.annualVip;
        }
        boolean z17 = z11;
        if ((i10 & 4) != 0) {
            z12 = userVipDetailModel.sVip;
        }
        boolean z18 = z12;
        if ((i10 & 8) != 0) {
            z13 = userVipDetailModel.annualSvip;
        }
        boolean z19 = z13;
        if ((i10 & 16) != 0) {
            z14 = userVipDetailModel.ssvip;
        }
        boolean z20 = z14;
        if ((i10 & 32) != 0) {
            z15 = userVipDetailModel.annualSsvip;
        }
        boolean z21 = z15;
        if ((i10 & 64) != 0) {
            z16 = userVipDetailModel.vipIconHide;
        }
        return userVipDetailModel.copy(z10, z17, z18, z19, z20, z21, z16);
    }

    private final Integer getBigVipImageView() {
        if (this.annualSsvip) {
            return Integer.valueOf(R$mipmap.rainbow_aplus_annual_logo_big);
        }
        if (this.ssvip) {
            return Integer.valueOf(R$mipmap.rainbow_aplus_logo_big);
        }
        if (this.annualSvip) {
            return Integer.valueOf(R$mipmap.super_aplus_annual_logo_big);
        }
        if (this.sVip) {
            return Integer.valueOf(R$mipmap.super_aplus_logo_big);
        }
        if (this.annualVip) {
            return Integer.valueOf(R$mipmap.annual_aplus_logo_big);
        }
        if (this.vip) {
            return Integer.valueOf(R$mipmap.aplus_logo_big);
        }
        return null;
    }

    private final Integer getNormalVipImageView() {
        if (this.annualSsvip) {
            return Integer.valueOf(R$mipmap.rainbow_aplus_annual_logo);
        }
        if (this.ssvip) {
            return Integer.valueOf(R$mipmap.rainbow_aplus_logo);
        }
        if (this.annualSvip) {
            return Integer.valueOf(R$mipmap.super_aplus_annual_logo);
        }
        if (this.sVip) {
            return Integer.valueOf(R$mipmap.super_aplus_logo);
        }
        if (this.annualVip) {
            return Integer.valueOf(R$mipmap.annual_aplus_logo);
        }
        if (this.vip) {
            return Integer.valueOf(R$mipmap.aplus_logo);
        }
        return null;
    }

    public final boolean component1() {
        return this.vip;
    }

    public final boolean component2() {
        return this.annualVip;
    }

    public final boolean component3() {
        return this.sVip;
    }

    public final boolean component4() {
        return this.annualSvip;
    }

    public final boolean component5() {
        return this.ssvip;
    }

    public final boolean component6() {
        return this.annualSsvip;
    }

    public final boolean component7() {
        return this.vipIconHide;
    }

    @NotNull
    public final UserVipDetailModel copy(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        return new UserVipDetailModel(z10, z11, z12, z13, z14, z15, z16);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserVipDetailModel)) {
            return false;
        }
        UserVipDetailModel userVipDetailModel = (UserVipDetailModel) obj;
        return this.vip == userVipDetailModel.vip && this.annualVip == userVipDetailModel.annualVip && this.sVip == userVipDetailModel.sVip && this.annualSvip == userVipDetailModel.annualSvip && this.ssvip == userVipDetailModel.ssvip && this.annualSsvip == userVipDetailModel.annualSsvip && this.vipIconHide == userVipDetailModel.vipIconHide;
    }

    public final boolean getAnnualSsvip() {
        return this.annualSsvip;
    }

    public final boolean getAnnualSvip() {
        return this.annualSvip;
    }

    public final boolean getAnnualVip() {
        return this.annualVip;
    }

    public final boolean getSVip() {
        return this.sVip;
    }

    public final boolean getSsvip() {
        return this.ssvip;
    }

    public final boolean getVip() {
        return this.vip;
    }

    @Nullable
    public final Integer getVipIcon(@NotNull VipIconSize size) {
        s.i(size, "size");
        if (this.vipIconHide) {
            return null;
        }
        if (size == VipIconSize.BIG) {
            return getBigVipImageView();
        }
        return getNormalVipImageView();
    }

    public final boolean getVipIconHide() {
        return this.vipIconHide;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v8, types: [boolean] */
    public int hashCode() {
        boolean z10 = this.vip;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        ?? r22 = this.annualVip;
        int i11 = r22;
        if (r22 != 0) {
            i11 = 1;
        }
        int i12 = (i10 + i11) * 31;
        ?? r23 = this.sVip;
        int i13 = r23;
        if (r23 != 0) {
            i13 = 1;
        }
        int i14 = (i12 + i13) * 31;
        ?? r24 = this.annualSvip;
        int i15 = r24;
        if (r24 != 0) {
            i15 = 1;
        }
        int i16 = (i14 + i15) * 31;
        ?? r25 = this.ssvip;
        int i17 = r25;
        if (r25 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        ?? r26 = this.annualSsvip;
        int i19 = r26;
        if (r26 != 0) {
            i19 = 1;
        }
        int i20 = (i18 + i19) * 31;
        boolean z11 = this.vipIconHide;
        return i20 + (z11 ? 1 : z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "UserVipDetailModel(vip=" + this.vip + ", annualVip=" + this.annualVip + ", sVip=" + this.sVip + ", annualSvip=" + this.annualSvip + ", ssvip=" + this.ssvip + ", annualSsvip=" + this.annualSsvip + ", vipIconHide=" + this.vipIconHide + ")";
    }

    public /* synthetic */ UserVipDetailModel(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? false : z11, (i10 & 4) != 0 ? false : z12, (i10 & 8) != 0 ? false : z13, (i10 & 16) != 0 ? false : z14, (i10 & 32) != 0 ? false : z15, (i10 & 64) != 0 ? false : z16);
    }
}
