package com.cupidapp.live.consult.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultLiveModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultConnectInfoModel implements Serializable {

    @NotNull
    private final ConsultConnectAgreementModel agreement;

    @Nullable
    private final ImageModel banner;
    private final int c2cPrice;
    private final int c2gPrice;

    @NotNull
    private final String notice;

    @NotNull
    private final String tipText;

    public ConsultConnectInfoModel(int i10, int i11, @Nullable ImageModel imageModel, @NotNull String tipText, @NotNull String notice, @NotNull ConsultConnectAgreementModel agreement) {
        s.i(tipText, "tipText");
        s.i(notice, "notice");
        s.i(agreement, "agreement");
        this.c2gPrice = i10;
        this.c2cPrice = i11;
        this.banner = imageModel;
        this.tipText = tipText;
        this.notice = notice;
        this.agreement = agreement;
    }

    public static /* synthetic */ ConsultConnectInfoModel copy$default(ConsultConnectInfoModel consultConnectInfoModel, int i10, int i11, ImageModel imageModel, String str, String str2, ConsultConnectAgreementModel consultConnectAgreementModel, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = consultConnectInfoModel.c2gPrice;
        }
        if ((i12 & 2) != 0) {
            i11 = consultConnectInfoModel.c2cPrice;
        }
        int i13 = i11;
        if ((i12 & 4) != 0) {
            imageModel = consultConnectInfoModel.banner;
        }
        ImageModel imageModel2 = imageModel;
        if ((i12 & 8) != 0) {
            str = consultConnectInfoModel.tipText;
        }
        String str3 = str;
        if ((i12 & 16) != 0) {
            str2 = consultConnectInfoModel.notice;
        }
        String str4 = str2;
        if ((i12 & 32) != 0) {
            consultConnectAgreementModel = consultConnectInfoModel.agreement;
        }
        return consultConnectInfoModel.copy(i10, i13, imageModel2, str3, str4, consultConnectAgreementModel);
    }

    public final int component1() {
        return this.c2gPrice;
    }

    public final int component2() {
        return this.c2cPrice;
    }

    @Nullable
    public final ImageModel component3() {
        return this.banner;
    }

    @NotNull
    public final String component4() {
        return this.tipText;
    }

    @NotNull
    public final String component5() {
        return this.notice;
    }

    @NotNull
    public final ConsultConnectAgreementModel component6() {
        return this.agreement;
    }

    @NotNull
    public final ConsultConnectInfoModel copy(int i10, int i11, @Nullable ImageModel imageModel, @NotNull String tipText, @NotNull String notice, @NotNull ConsultConnectAgreementModel agreement) {
        s.i(tipText, "tipText");
        s.i(notice, "notice");
        s.i(agreement, "agreement");
        return new ConsultConnectInfoModel(i10, i11, imageModel, tipText, notice, agreement);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsultConnectInfoModel)) {
            return false;
        }
        ConsultConnectInfoModel consultConnectInfoModel = (ConsultConnectInfoModel) obj;
        return this.c2gPrice == consultConnectInfoModel.c2gPrice && this.c2cPrice == consultConnectInfoModel.c2cPrice && s.d(this.banner, consultConnectInfoModel.banner) && s.d(this.tipText, consultConnectInfoModel.tipText) && s.d(this.notice, consultConnectInfoModel.notice) && s.d(this.agreement, consultConnectInfoModel.agreement);
    }

    @NotNull
    public final ConsultConnectAgreementModel getAgreement() {
        return this.agreement;
    }

    @Nullable
    public final ImageModel getBanner() {
        return this.banner;
    }

    public final int getC2cPrice() {
        return this.c2cPrice;
    }

    public final int getC2gPrice() {
        return this.c2gPrice;
    }

    @NotNull
    public final String getNotice() {
        return this.notice;
    }

    @NotNull
    public final String getTipText() {
        return this.tipText;
    }

    public int hashCode() {
        int i10 = ((this.c2gPrice * 31) + this.c2cPrice) * 31;
        ImageModel imageModel = this.banner;
        return ((((((i10 + (imageModel == null ? 0 : imageModel.hashCode())) * 31) + this.tipText.hashCode()) * 31) + this.notice.hashCode()) * 31) + this.agreement.hashCode();
    }

    @NotNull
    public String toString() {
        int i10 = this.c2gPrice;
        int i11 = this.c2cPrice;
        ImageModel imageModel = this.banner;
        return "ConsultConnectInfoModel(c2gPrice=" + i10 + ", c2cPrice=" + i11 + ", banner=" + ((Object) imageModel) + ", tipText=" + this.tipText + ", notice=" + this.notice + ", agreement=" + ((Object) this.agreement) + ")";
    }
}
