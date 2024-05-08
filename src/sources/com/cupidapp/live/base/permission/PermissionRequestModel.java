package com.cupidapp.live.base.permission;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RxPermissionHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PermissionRequestModel {

    @NotNull
    private final List<PermissionType> permissionList;

    public PermissionRequestModel(@NotNull List<PermissionType> permissionList) {
        s.i(permissionList, "permissionList");
        this.permissionList = permissionList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PermissionRequestModel copy$default(PermissionRequestModel permissionRequestModel, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = permissionRequestModel.permissionList;
        }
        return permissionRequestModel.copy(list);
    }

    @NotNull
    public final List<PermissionType> component1() {
        return this.permissionList;
    }

    @NotNull
    public final PermissionRequestModel copy(@NotNull List<PermissionType> permissionList) {
        s.i(permissionList, "permissionList");
        return new PermissionRequestModel(permissionList);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PermissionRequestModel) && s.d(this.permissionList, ((PermissionRequestModel) obj).permissionList);
    }

    @NotNull
    public final List<PermissionType> getPermissionList() {
        return this.permissionList;
    }

    public int hashCode() {
        return this.permissionList.hashCode();
    }

    @NotNull
    public String toString() {
        return "PermissionRequestModel(permissionList=" + ((Object) this.permissionList) + ")";
    }
}
