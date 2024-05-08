package com.cupidapp.live.maskparty.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyItemCardModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyItemCardConfigModel implements Serializable {
    private final int defaultIndex;

    @Nullable
    private final String instructionUrl;

    @Nullable
    private final String orderUrl;
    private final int remains;

    public MaskPartyItemCardConfigModel(int i10, int i11, @Nullable String str, @Nullable String str2) {
        this.defaultIndex = i10;
        this.remains = i11;
        this.instructionUrl = str;
        this.orderUrl = str2;
    }

    public static /* synthetic */ MaskPartyItemCardConfigModel copy$default(MaskPartyItemCardConfigModel maskPartyItemCardConfigModel, int i10, int i11, String str, String str2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = maskPartyItemCardConfigModel.defaultIndex;
        }
        if ((i12 & 2) != 0) {
            i11 = maskPartyItemCardConfigModel.remains;
        }
        if ((i12 & 4) != 0) {
            str = maskPartyItemCardConfigModel.instructionUrl;
        }
        if ((i12 & 8) != 0) {
            str2 = maskPartyItemCardConfigModel.orderUrl;
        }
        return maskPartyItemCardConfigModel.copy(i10, i11, str, str2);
    }

    public final int component1() {
        return this.defaultIndex;
    }

    public final int component2() {
        return this.remains;
    }

    @Nullable
    public final String component3() {
        return this.instructionUrl;
    }

    @Nullable
    public final String component4() {
        return this.orderUrl;
    }

    @NotNull
    public final MaskPartyItemCardConfigModel copy(int i10, int i11, @Nullable String str, @Nullable String str2) {
        return new MaskPartyItemCardConfigModel(i10, i11, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MaskPartyItemCardConfigModel)) {
            return false;
        }
        MaskPartyItemCardConfigModel maskPartyItemCardConfigModel = (MaskPartyItemCardConfigModel) obj;
        return this.defaultIndex == maskPartyItemCardConfigModel.defaultIndex && this.remains == maskPartyItemCardConfigModel.remains && s.d(this.instructionUrl, maskPartyItemCardConfigModel.instructionUrl) && s.d(this.orderUrl, maskPartyItemCardConfigModel.orderUrl);
    }

    public final int getDefaultIndex() {
        return this.defaultIndex;
    }

    @Nullable
    public final String getInstructionUrl() {
        return this.instructionUrl;
    }

    @Nullable
    public final String getOrderUrl() {
        return this.orderUrl;
    }

    public final int getRemains() {
        return this.remains;
    }

    public int hashCode() {
        int i10 = ((this.defaultIndex * 31) + this.remains) * 31;
        String str = this.instructionUrl;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.orderUrl;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MaskPartyItemCardConfigModel(defaultIndex=" + this.defaultIndex + ", remains=" + this.remains + ", instructionUrl=" + this.instructionUrl + ", orderUrl=" + this.orderUrl + ")";
    }
}
