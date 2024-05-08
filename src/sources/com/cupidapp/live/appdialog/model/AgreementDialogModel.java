package com.cupidapp.live.appdialog.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: AppDialogModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AgreementDialogModel extends AppDialogModel {

    @NotNull
    private final String agreement;

    @NotNull
    private final String callbackIds;

    @NotNull
    private final List<AgreementModel> replaceTexts;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgreementDialogModel(@NotNull String scene, @NotNull String windowType, @NotNull String agreement, @NotNull List<AgreementModel> replaceTexts, @NotNull String callbackIds) {
        super(scene, windowType, false, 4, null);
        s.i(scene, "scene");
        s.i(windowType, "windowType");
        s.i(agreement, "agreement");
        s.i(replaceTexts, "replaceTexts");
        s.i(callbackIds, "callbackIds");
        this.agreement = agreement;
        this.replaceTexts = replaceTexts;
        this.callbackIds = callbackIds;
    }

    @NotNull
    public final String getAgreement() {
        return this.agreement;
    }

    @NotNull
    public final String getCallbackIds() {
        return this.callbackIds;
    }

    @NotNull
    public final List<AgreementModel> getReplaceTexts() {
        return this.replaceTexts;
    }
}
