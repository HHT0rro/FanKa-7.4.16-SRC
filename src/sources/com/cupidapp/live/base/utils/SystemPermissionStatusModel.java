package com.cupidapp.live.base.utils;

import com.cupidapp.live.base.sensorslog.SensorsLogUserStatusSwitch;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SensorsSystemPermissionLog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SystemPermissionStatusModel {
    private boolean isFirst;
    private boolean open;

    @NotNull
    private final SensorsLogUserStatusSwitch.SystemPermission permission;

    public SystemPermissionStatusModel(@NotNull SensorsLogUserStatusSwitch.SystemPermission permission, boolean z10, boolean z11) {
        kotlin.jvm.internal.s.i(permission, "permission");
        this.permission = permission;
        this.open = z10;
        this.isFirst = z11;
    }

    public static /* synthetic */ SystemPermissionStatusModel copy$default(SystemPermissionStatusModel systemPermissionStatusModel, SensorsLogUserStatusSwitch.SystemPermission systemPermission, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            systemPermission = systemPermissionStatusModel.permission;
        }
        if ((i10 & 2) != 0) {
            z10 = systemPermissionStatusModel.open;
        }
        if ((i10 & 4) != 0) {
            z11 = systemPermissionStatusModel.isFirst;
        }
        return systemPermissionStatusModel.copy(systemPermission, z10, z11);
    }

    @NotNull
    public final SensorsLogUserStatusSwitch.SystemPermission component1() {
        return this.permission;
    }

    public final boolean component2() {
        return this.open;
    }

    public final boolean component3() {
        return this.isFirst;
    }

    @NotNull
    public final SystemPermissionStatusModel copy(@NotNull SensorsLogUserStatusSwitch.SystemPermission permission, boolean z10, boolean z11) {
        kotlin.jvm.internal.s.i(permission, "permission");
        return new SystemPermissionStatusModel(permission, z10, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SystemPermissionStatusModel)) {
            return false;
        }
        SystemPermissionStatusModel systemPermissionStatusModel = (SystemPermissionStatusModel) obj;
        return this.permission == systemPermissionStatusModel.permission && this.open == systemPermissionStatusModel.open && this.isFirst == systemPermissionStatusModel.isFirst;
    }

    public final boolean getOpen() {
        return this.open;
    }

    @NotNull
    public final SensorsLogUserStatusSwitch.SystemPermission getPermission() {
        return this.permission;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.permission.hashCode() * 31;
        boolean z10 = this.open;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        boolean z11 = this.isFirst;
        return i11 + (z11 ? 1 : z11 ? 1 : 0);
    }

    public final boolean isFirst() {
        return this.isFirst;
    }

    public final void setFirst(boolean z10) {
        this.isFirst = z10;
    }

    public final void setOpen(boolean z10) {
        this.open = z10;
    }

    @NotNull
    public String toString() {
        SensorsLogUserStatusSwitch.SystemPermission systemPermission = this.permission;
        return "SystemPermissionStatusModel(permission=" + ((Object) systemPermission) + ", open=" + this.open + ", isFirst=" + this.isFirst + ")";
    }

    public /* synthetic */ SystemPermissionStatusModel(SensorsLogUserStatusSwitch.SystemPermission systemPermission, boolean z10, boolean z11, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(systemPermission, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? true : z11);
    }
}
