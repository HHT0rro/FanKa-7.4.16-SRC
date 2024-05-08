package com.cupidapp.live.base.permission;

import com.kuaishou.weapon.p0.g;
import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: RxPermissionHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum PermissionType {
    StoragePermission(new String[]{g.f36124j, g.f36123i}),
    LocationPermission(new String[]{g.f36122h, g.f36121g}),
    CameraPermission(new String[]{"android.permission.CAMERA"}),
    AudioPermission(new String[]{"android.permission.RECORD_AUDIO"});


    @NotNull
    private final String[] permission;

    PermissionType(String[] strArr) {
        this.permission = strArr;
    }

    @NotNull
    public final String[] getPermission() {
        return this.permission;
    }
}
