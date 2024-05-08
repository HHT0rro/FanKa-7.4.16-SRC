package com.cupidapp.live.appdialog.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AppDialogModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AppRatingModel extends AppDialogModel {

    @NotNull
    private final String inviteText;
    private final long rateRule;

    @Nullable
    private final String rateUrl;

    @NotNull
    private final String supportUrl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppRatingModel(@NotNull String scene, @NotNull String windowType, @Nullable String str, @NotNull String supportUrl, @NotNull String inviteText, long j10) {
        super(scene, windowType, false, 4, null);
        s.i(scene, "scene");
        s.i(windowType, "windowType");
        s.i(supportUrl, "supportUrl");
        s.i(inviteText, "inviteText");
        this.rateUrl = str;
        this.supportUrl = supportUrl;
        this.inviteText = inviteText;
        this.rateRule = j10;
    }

    @NotNull
    public final String getInviteText() {
        return this.inviteText;
    }

    public final long getRateRule() {
        return this.rateRule;
    }

    @Nullable
    public final String getRateUrl() {
        return this.rateUrl;
    }

    @NotNull
    public final String getSupportUrl() {
        return this.supportUrl;
    }

    public final boolean isInternalRating() {
        String str = this.rateUrl;
        return !(str == null || str.length() == 0);
    }
}
