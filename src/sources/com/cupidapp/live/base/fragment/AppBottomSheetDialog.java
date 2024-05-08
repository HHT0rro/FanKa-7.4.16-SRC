package com.cupidapp.live.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: BaseBottomSheetDialogFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AppBottomSheetDialog extends BottomSheetDialog {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppBottomSheetDialog(@NotNull Context context, int i10) {
        super(context, i10);
        s.i(context, "context");
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, h.k(this));
        }
    }
}
