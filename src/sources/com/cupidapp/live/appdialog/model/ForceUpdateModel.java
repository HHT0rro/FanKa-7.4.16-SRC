package com.cupidapp.live.appdialog.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: AppDialogModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ForceUpdateModel extends AppDialogModel {

    @NotNull
    private final String btnText;

    @NotNull
    private final String content;
    private final long ruleId;

    @NotNull
    private final String showType;

    @NotNull
    private final String title;

    @NotNull
    private final String url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForceUpdateModel(@NotNull String scene, @NotNull String windowType, long j10, @NotNull String title, @NotNull String content, @NotNull String btnText, @NotNull String url, @NotNull String showType) {
        super(scene, windowType, false, 4, null);
        s.i(scene, "scene");
        s.i(windowType, "windowType");
        s.i(title, "title");
        s.i(content, "content");
        s.i(btnText, "btnText");
        s.i(url, "url");
        s.i(showType, "showType");
        this.ruleId = j10;
        this.title = title;
        this.content = content;
        this.btnText = btnText;
        this.url = url;
        this.showType = showType;
    }

    @NotNull
    public final String getBtnText() {
        return this.btnText;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final long getRuleId() {
        return this.ruleId;
    }

    @NotNull
    public final String getShowType() {
        return this.showType;
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
