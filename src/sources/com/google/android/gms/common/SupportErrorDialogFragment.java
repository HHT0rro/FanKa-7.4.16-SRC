package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class SupportErrorDialogFragment extends DialogFragment {

    /* renamed from: b, reason: collision with root package name */
    public Dialog f23365b;

    /* renamed from: c, reason: collision with root package name */
    public DialogInterface.OnCancelListener f23366c;

    @NonNull
    public static SupportErrorDialogFragment N0(@RecentlyNonNull Dialog dialog, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
        Dialog dialog2 = (Dialog) com.google.android.gms.common.internal.h.i(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        supportErrorDialogFragment.f23365b = dialog2;
        if (onCancelListener != null) {
            supportErrorDialogFragment.f23366c = onCancelListener;
        }
        return supportErrorDialogFragment;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@RecentlyNonNull DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f23366c;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        if (this.f23365b == null) {
            setShowsDialog(false);
        }
        return this.f23365b;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(@RecentlyNonNull FragmentManager fragmentManager, @Nullable String str) {
        super.show(fragmentManager, str);
    }
}
