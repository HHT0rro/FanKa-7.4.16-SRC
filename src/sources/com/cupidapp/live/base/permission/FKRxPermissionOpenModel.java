package com.cupidapp.live.base.permission;

import com.cupidapp.live.R$string;
import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKRxPermissionAlertDialog.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKRxPermissionOpenModel implements Serializable {

    @Nullable
    private final Function0<p> alertCancel;

    @Nullable
    private final Function0<p> alertToSetting;

    @NotNull
    private final PermissionType firstPermission;

    @Nullable
    private final Function0<p> ignoreClick;

    @Nullable
    private final Integer ignoreContent;
    private boolean isReply;

    @NotNull
    private final List<PermissionType> mustPermission;
    private final boolean overridePermissionCancel;

    @Nullable
    private Function0<p> permissionCancel;

    @Nullable
    private final Function0<p> permissionSucceed;
    private final int requestContent;

    @Nullable
    private final PermissionType secondPermission;

    /* JADX WARN: Multi-variable type inference failed */
    public FKRxPermissionOpenModel(int i10, @NotNull PermissionType firstPermission, @Nullable PermissionType permissionType, @NotNull List<? extends PermissionType> mustPermission, boolean z10, @Nullable Function0<p> function0, @Nullable Function0<p> function02, @Nullable Function0<p> function03, @Nullable Integer num, boolean z11, @Nullable Function0<p> function04, @Nullable Function0<p> function05) {
        s.i(firstPermission, "firstPermission");
        s.i(mustPermission, "mustPermission");
        this.requestContent = i10;
        this.firstPermission = firstPermission;
        this.secondPermission = permissionType;
        this.mustPermission = mustPermission;
        this.isReply = z10;
        this.permissionSucceed = function0;
        this.ignoreClick = function02;
        this.permissionCancel = function03;
        this.ignoreContent = num;
        this.overridePermissionCancel = z11;
        this.alertCancel = function04;
        this.alertToSetting = function05;
    }

    @Nullable
    public final Function0<p> getAlertCancel() {
        return this.alertCancel;
    }

    @Nullable
    public final Function0<p> getAlertToSetting() {
        return this.alertToSetting;
    }

    @NotNull
    public final PermissionType getFirstPermission() {
        return this.firstPermission;
    }

    @Nullable
    public final Function0<p> getIgnoreClick() {
        return this.ignoreClick;
    }

    @Nullable
    public final Integer getIgnoreContent() {
        return this.ignoreContent;
    }

    @NotNull
    public final List<PermissionType> getMustPermission() {
        return this.mustPermission;
    }

    public final boolean getOverridePermissionCancel() {
        return this.overridePermissionCancel;
    }

    @Nullable
    public final Function0<p> getPermissionCancel() {
        return this.permissionCancel;
    }

    @Nullable
    public final Function0<p> getPermissionSucceed() {
        return this.permissionSucceed;
    }

    public final int getRequestContent() {
        return this.requestContent;
    }

    @Nullable
    public final PermissionType getSecondPermission() {
        return this.secondPermission;
    }

    public final boolean isReply() {
        return this.isReply;
    }

    public final void setPermissionCancel(@Nullable Function0<p> function0) {
        this.permissionCancel = function0;
    }

    public final void setReply(boolean z10) {
        this.isReply = z10;
    }

    public /* synthetic */ FKRxPermissionOpenModel(int i10, PermissionType permissionType, PermissionType permissionType2, List list, boolean z10, Function0 function0, Function0 function02, Function0 function03, Integer num, boolean z11, Function0 function04, Function0 function05, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, permissionType, (i11 & 4) != 0 ? null : permissionType2, list, (i11 & 16) != 0 ? false : z10, (i11 & 32) != 0 ? null : function0, (i11 & 64) != 0 ? null : function02, (i11 & 128) != 0 ? null : function03, (i11 & 256) != 0 ? Integer.valueOf(R$string.skip) : num, (i11 & 512) != 0 ? false : z11, (i11 & 1024) != 0 ? null : function04, (i11 & 2048) != 0 ? null : function05);
    }
}
