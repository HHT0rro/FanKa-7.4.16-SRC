package com.cupidapp.live.base.permission;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.R$style;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x0.a;
import z0.h;
import z0.z;

/* compiled from: FKPermissionInstructionsForUseLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKPermissionInstructionsForUseLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public AlertDialog f12012b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12013c;

    /* compiled from: FKPermissionInstructionsForUseLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12014a;

        static {
            int[] iArr = new int[PermissionType.values().length];
            try {
                iArr[PermissionType.StoragePermission.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PermissionType.LocationPermission.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PermissionType.CameraPermission.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PermissionType.AudioPermission.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f12014a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKPermissionInstructionsForUseLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f12013c = new LinkedHashMap();
        d();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f12013c;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void b(PermissionType permissionType) {
        String string;
        String string2;
        int i10 = a.f12014a[permissionType.ordinal()];
        if (i10 == 1) {
            string = getContext().getString(2131887978);
            s.h(string, "context.getString(R.string.permission_storage)");
            string2 = getContext().getString(R$string.storage_for_use);
            s.h(string2, "context.getString(R.string.storage_for_use)");
        } else if (i10 == 2) {
            string = getContext().getString(2131887974);
            s.h(string, "context.getString(R.string.permission_location)");
            string2 = getContext().getString(R$string.location_for_use);
            s.h(string2, "context.getString(R.string.location_for_use)");
        } else if (i10 == 3) {
            string = getContext().getString(2131887970);
            s.h(string, "context.getString(R.string.permission_camera)");
            string2 = getContext().getString(R$string.camera_for_use);
            s.h(string2, "context.getString(R.string.camera_for_use)");
        } else {
            if (i10 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            string = getContext().getString(R$string.permission_audio);
            s.h(string, "context.getString(R.string.permission_audio)");
            string2 = getContext().getString(R$string.audio_for_use);
            s.h(string2, "context.getString(R.string.audio_for_use)");
        }
        ((TextView) a(R$id.instructionTitle)).setText(getContext().getString(R$string.permission_instructions_for_use, string));
        ((TextView) a(R$id.instructionDescription)).setText(string2);
    }

    public final void c() {
        AlertDialog alertDialog = this.f12012b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.f12012b = null;
    }

    public final void d() {
        z.a(this, R$layout.layout_permission_instructions_for_use, true);
        a.C0834a c0834a = x0.a.f54353h;
        ConstraintLayout instructionLayout = (ConstraintLayout) a(R$id.instructionLayout);
        s.h(instructionLayout, "instructionLayout");
        c0834a.a(instructionLayout, -1, h.c(this, 14.0f), com.cupidapp.live.base.utils.h.a(-16777216, 0.16f), h.c(this, 6.0f), 0.0f, 0.0f);
        ((TextView) a(R$id.instructionTitle)).getPaint().setFakeBoldText(true);
    }

    public final void e(@NotNull PermissionType permissionType) {
        Window window;
        s.i(permissionType, "permissionType");
        b(permissionType);
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f12012b = create;
        if (create != null) {
            create.show();
        }
        AlertDialog alertDialog = this.f12012b;
        if (alertDialog == null || (window = alertDialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(R$style.dialog_top_enter_top_exit_anim);
        window.setLayout(-1, -2);
        window.setGravity(48);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKPermissionInstructionsForUseLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f12013c = new LinkedHashMap();
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKPermissionInstructionsForUseLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f12013c = new LinkedHashMap();
        d();
    }
}
