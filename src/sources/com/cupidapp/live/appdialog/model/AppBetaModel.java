package com.cupidapp.live.appdialog.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AppDialogModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AppBetaModel extends AppDialogModel {

    @Nullable
    private final String btnText;

    @Nullable
    private final String content;

    @Nullable
    private final Long testVersionId;

    @Nullable
    private final String title;

    @Nullable
    private final String url;

    public /* synthetic */ AppBetaModel(String str, String str2, String str3, String str4, String str5, String str6, Long l10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, (i10 & 32) != 0 ? null : str6, l10);
    }

    @Nullable
    public final String getBtnText() {
        return this.btnText;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final Long getTestVersionId() {
        return this.testVersionId;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppBetaModel(@NotNull String scene, @NotNull String windowType, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Long l10) {
        super(scene, windowType, false, 4, null);
        s.i(scene, "scene");
        s.i(windowType, "windowType");
        this.title = str;
        this.content = str2;
        this.url = str3;
        this.btnText = str4;
        this.testVersionId = l10;
    }
}
