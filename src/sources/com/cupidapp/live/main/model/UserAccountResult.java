package com.cupidapp.live.main.model;

import com.cupidapp.live.setting.model.OrderManagementResult;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserAccountResult {
    private final boolean accountLimited;

    @Nullable
    private final PassportModel facebook;
    private final boolean passwordNeedReset;

    @Nullable
    private final PassportModel phone;

    @Nullable
    private final String primaryNumber;
    private final boolean primaryPhone;

    @Nullable
    private final List<OrderManagementResult> subscriptionInfoList;
    private final boolean useQuickLogin;

    @Nullable
    private final PassportModel weibo;

    @Nullable
    private final PassportModel weixin;
    private final boolean zhimaAuthPass;

    public UserAccountResult(@Nullable String str, boolean z10, boolean z11, boolean z12, @Nullable PassportModel passportModel, @Nullable PassportModel passportModel2, @Nullable PassportModel passportModel3, @Nullable PassportModel passportModel4, @Nullable List<OrderManagementResult> list, boolean z13, boolean z14) {
        this.primaryNumber = str;
        this.accountLimited = z10;
        this.passwordNeedReset = z11;
        this.zhimaAuthPass = z12;
        this.facebook = passportModel;
        this.weibo = passportModel2;
        this.weixin = passportModel3;
        this.phone = passportModel4;
        this.subscriptionInfoList = list;
        this.primaryPhone = z13;
        this.useQuickLogin = z14;
    }

    public final boolean getAccountLimited() {
        return this.accountLimited;
    }

    @Nullable
    public final PassportModel getFacebook() {
        return this.facebook;
    }

    public final boolean getPasswordNeedReset() {
        return this.passwordNeedReset;
    }

    @Nullable
    public final PassportModel getPhone() {
        return this.phone;
    }

    @Nullable
    public final String getPrimaryNumber() {
        return this.primaryNumber;
    }

    public final boolean getPrimaryPhone() {
        return this.primaryPhone;
    }

    @Nullable
    public final List<OrderManagementResult> getSubscriptionInfoList() {
        return this.subscriptionInfoList;
    }

    public final boolean getUseQuickLogin() {
        return this.useQuickLogin;
    }

    @Nullable
    public final PassportModel getWeibo() {
        return this.weibo;
    }

    @Nullable
    public final PassportModel getWeixin() {
        return this.weixin;
    }

    public final boolean getZhimaAuthPass() {
        return this.zhimaAuthPass;
    }

    public /* synthetic */ UserAccountResult(String str, boolean z10, boolean z11, boolean z12, PassportModel passportModel, PassportModel passportModel2, PassportModel passportModel3, PassportModel passportModel4, List list, boolean z13, boolean z14, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? false : z11, (i10 & 8) != 0 ? false : z12, passportModel, passportModel2, passportModel3, passportModel4, list, (i10 & 512) != 0 ? false : z13, z14);
    }
}
