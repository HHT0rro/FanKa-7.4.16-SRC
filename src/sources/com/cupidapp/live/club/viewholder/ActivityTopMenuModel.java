package com.cupidapp.live.club.viewholder;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ActivityTopMenuViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ActivityTopMenuModel {

    @Nullable
    private final String medalListUrl;

    @Nullable
    private final String myCoinUrl;
    private boolean newOrder;

    @Nullable
    private final String payOrderListUrl;

    public ActivityTopMenuModel(boolean z10, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.newOrder = z10;
        this.payOrderListUrl = str;
        this.medalListUrl = str2;
        this.myCoinUrl = str3;
    }

    public static /* synthetic */ ActivityTopMenuModel copy$default(ActivityTopMenuModel activityTopMenuModel, boolean z10, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = activityTopMenuModel.newOrder;
        }
        if ((i10 & 2) != 0) {
            str = activityTopMenuModel.payOrderListUrl;
        }
        if ((i10 & 4) != 0) {
            str2 = activityTopMenuModel.medalListUrl;
        }
        if ((i10 & 8) != 0) {
            str3 = activityTopMenuModel.myCoinUrl;
        }
        return activityTopMenuModel.copy(z10, str, str2, str3);
    }

    public final boolean component1() {
        return this.newOrder;
    }

    @Nullable
    public final String component2() {
        return this.payOrderListUrl;
    }

    @Nullable
    public final String component3() {
        return this.medalListUrl;
    }

    @Nullable
    public final String component4() {
        return this.myCoinUrl;
    }

    @NotNull
    public final ActivityTopMenuModel copy(boolean z10, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        return new ActivityTopMenuModel(z10, str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTopMenuModel)) {
            return false;
        }
        ActivityTopMenuModel activityTopMenuModel = (ActivityTopMenuModel) obj;
        return this.newOrder == activityTopMenuModel.newOrder && s.d(this.payOrderListUrl, activityTopMenuModel.payOrderListUrl) && s.d(this.medalListUrl, activityTopMenuModel.medalListUrl) && s.d(this.myCoinUrl, activityTopMenuModel.myCoinUrl);
    }

    @Nullable
    public final String getMedalListUrl() {
        return this.medalListUrl;
    }

    @Nullable
    public final String getMyCoinUrl() {
        return this.myCoinUrl;
    }

    public final boolean getNewOrder() {
        return this.newOrder;
    }

    @Nullable
    public final String getPayOrderListUrl() {
        return this.payOrderListUrl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z10 = this.newOrder;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        String str = this.payOrderListUrl;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.medalListUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.myCoinUrl;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setNewOrder(boolean z10) {
        this.newOrder = z10;
    }

    @NotNull
    public String toString() {
        return "ActivityTopMenuModel(newOrder=" + this.newOrder + ", payOrderListUrl=" + this.payOrderListUrl + ", medalListUrl=" + this.medalListUrl + ", myCoinUrl=" + this.myCoinUrl + ")";
    }
}
