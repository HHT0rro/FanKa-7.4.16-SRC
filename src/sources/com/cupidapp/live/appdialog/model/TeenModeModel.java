package com.cupidapp.live.appdialog.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: AppDialogModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class TeenModeModel extends AppDialogModel {

    @NotNull
    private final String url;

    public /* synthetic */ TeenModeModel(String str, String str2, String str3, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i10 & 8) != 0 ? false : z10);
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TeenModeModel(@NotNull String scene, @NotNull String windowType, @NotNull String url, boolean z10) {
        super(scene, windowType, z10);
        s.i(scene, "scene");
        s.i(windowType, "windowType");
        s.i(url, "url");
        this.url = url;
    }
}
