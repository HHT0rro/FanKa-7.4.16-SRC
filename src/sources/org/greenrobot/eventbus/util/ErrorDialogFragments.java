package org.greenrobot.eventbus.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ErrorDialogFragments {

    /* renamed from: a, reason: collision with root package name */
    public static int f52431a;

    /* renamed from: b, reason: collision with root package name */
    public static Class<?> f52432b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class Honeycomb extends DialogFragment implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            ErrorDialogFragments.b(dialogInterface, i10, getActivity(), getArguments());
        }

        @Override // android.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.a(getActivity(), getArguments(), this);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class Support extends androidx.fragment.app.DialogFragment implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            ErrorDialogFragments.b(dialogInterface, i10, getActivity(), getArguments());
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.a(getActivity(), getArguments(), this);
        }
    }

    public static Dialog a(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(bundle.getString("de.greenrobot.eventbus.errordialog.title"));
        builder.setMessage(bundle.getString("de.greenrobot.eventbus.errordialog.message"));
        int i10 = f52431a;
        if (i10 != 0) {
            builder.setIcon(i10);
        }
        builder.setPositiveButton(17039370, onClickListener);
        return builder.create();
    }

    public static void b(DialogInterface dialogInterface, int i10, Activity activity, Bundle bundle) {
        Class<?> cls = f52432b;
        if (cls == null) {
            if (!bundle.getBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", false) || activity == null) {
                return;
            }
            activity.finish();
            return;
        }
        try {
            cls.newInstance();
            throw null;
        } catch (Exception e2) {
            throw new RuntimeException("Event cannot be constructed", e2);
        }
    }
}
