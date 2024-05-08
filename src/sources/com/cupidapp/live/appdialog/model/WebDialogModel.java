package com.cupidapp.live.appdialog.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AppDialogModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class WebDialogModel extends AppDialogModel {

    @Nullable
    private final ImageModel image;
    private final long webId;

    @NotNull
    private final String webUrl;

    public /* synthetic */ WebDialogModel(String str, String str2, String str3, long j10, ImageModel imageModel, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, j10, imageModel, (i10 & 32) != 0 ? false : z10);
    }

    @Nullable
    public final ImageModel getImage() {
        return this.image;
    }

    public final long getWebId() {
        return this.webId;
    }

    @NotNull
    public final String getWebUrl() {
        return this.webUrl;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebDialogModel(@NotNull String scene, @NotNull String windowType, @NotNull String webUrl, long j10, @Nullable ImageModel imageModel, boolean z10) {
        super(scene, windowType, z10);
        s.i(scene, "scene");
        s.i(windowType, "windowType");
        s.i(webUrl, "webUrl");
        this.webUrl = webUrl;
        this.webId = j10;
        this.image = imageModel;
    }
}
