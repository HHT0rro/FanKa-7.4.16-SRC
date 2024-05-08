package com.cupidapp.live.base.fragment;

import android.content.Context;
import com.cupidapp.live.R$style;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: BaseBottomSheetDialogFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class EditInputBottomSheetDialog extends BottomSheetDialog implements d {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11786b;

    public /* synthetic */ EditInputBottomSheetDialog(Context context, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? false : z10);
    }

    @Override // com.cupidapp.live.base.fragment.d
    public void L() {
        try {
            dismiss();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f11786b) {
            b.f11807a.a(this);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        if (this.f11786b) {
            b.f11807a.d(this);
        }
        super.onDetachedFromWindow();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditInputBottomSheetDialog(@NotNull Context context, boolean z10) {
        super(context, R$style.edit_dialog);
        s.i(context, "context");
        this.f11786b = z10;
    }
}
