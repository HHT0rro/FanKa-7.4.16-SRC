package com.cupidapp.live.appdialog.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: AppDialogModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AgreementModel {

    @NotNull
    private final String title;

    @NotNull
    private final String url;

    public AgreementModel(@NotNull String title, @NotNull String url) {
        s.i(title, "title");
        s.i(url, "url");
        this.title = title;
        this.url = url;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }
}
