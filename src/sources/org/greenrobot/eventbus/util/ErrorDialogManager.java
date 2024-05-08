package org.greenrobot.eventbus.util;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import org.greenrobot.eventbus.EventBus;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ErrorDialogManager {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class HoneycombManagerFragment extends Fragment {

        /* renamed from: b, reason: collision with root package name */
        public EventBus f52433b;

        /* renamed from: c, reason: collision with root package name */
        public Object f52434c;

        public void onEventMainThread(ThrowableFailureEvent throwableFailureEvent) {
            if (ErrorDialogManager.c(this.f52434c, throwableFailureEvent)) {
                ErrorDialogManager.b(throwableFailureEvent);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.executePendingTransactions();
                DialogFragment dialogFragment = (DialogFragment) fragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog");
                if (dialogFragment != null) {
                    dialogFragment.dismiss();
                }
                throw null;
            }
        }

        @Override // android.app.Fragment
        public void onPause() {
            this.f52433b.t(this);
            super.onPause();
        }

        @Override // android.app.Fragment
        public void onResume() {
            super.onResume();
            throw null;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class SupportManagerFragment extends androidx.fragment.app.Fragment {

        /* renamed from: b, reason: collision with root package name */
        public EventBus f52435b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f52436c;

        /* renamed from: d, reason: collision with root package name */
        public Object f52437d;

        @Override // androidx.fragment.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            throw null;
        }

        public void onEventMainThread(ThrowableFailureEvent throwableFailureEvent) {
            if (ErrorDialogManager.c(this.f52437d, throwableFailureEvent)) {
                ErrorDialogManager.b(throwableFailureEvent);
                androidx.fragment.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.executePendingTransactions();
                androidx.fragment.app.DialogFragment dialogFragment = (androidx.fragment.app.DialogFragment) fragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog");
                if (dialogFragment != null) {
                    dialogFragment.dismiss();
                }
                throw null;
            }
        }

        @Override // androidx.fragment.app.Fragment
        public void onPause() {
            this.f52435b.t(this);
            super.onPause();
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            super.onResume();
            if (this.f52436c) {
                this.f52436c = false;
                return;
            }
            throw null;
        }
    }

    public static void b(ThrowableFailureEvent throwableFailureEvent) {
        throw null;
    }

    public static boolean c(Object obj, ThrowableFailureEvent throwableFailureEvent) {
        Object executionScope;
        return throwableFailureEvent == null || (executionScope = throwableFailureEvent.getExecutionScope()) == null || executionScope.equals(obj);
    }
}
