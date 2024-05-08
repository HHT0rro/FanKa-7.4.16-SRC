package com.cupidapp.live.appdialog.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AppDialogModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveTabIconModel extends AppDialogModel {

    @Nullable
    private final Integer expires;

    @Nullable
    private final String jumpUrl;

    @Nullable
    private final String liveRuleId;

    @Nullable
    private final String text;

    public /* synthetic */ LiveTabIconModel(String str, String str2, String str3, Integer num, String str4, String str5, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? 5 : num, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? null : str5);
    }

    @Nullable
    public final Integer getExpires() {
        return this.expires;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @Nullable
    public final String getLiveRuleId() {
        return this.liveRuleId;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveTabIconModel(@NotNull String scene, @NotNull String windowType, @Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3) {
        super(scene, windowType, false, 4, null);
        s.i(scene, "scene");
        s.i(windowType, "windowType");
        this.text = str;
        this.expires = num;
        this.jumpUrl = str2;
        this.liveRuleId = str3;
    }
}
