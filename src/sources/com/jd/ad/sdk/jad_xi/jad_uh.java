package com.jd.ad.sdk.jad_xi;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.alimm.tanx.ui.image.glide.manager.SupportRequestManagerFragment;
import com.alipay.sdk.util.i;
import com.jd.ad.sdk.logger.Logger;
import java.util.HashSet;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_uh extends Fragment {
    public final com.jd.ad.sdk.jad_xi.jad_an jad_an;
    public final jad_qd jad_bo;
    public final Set<jad_uh> jad_cp;

    @Nullable
    public jad_uh jad_dq;

    @Nullable
    public com.jd.ad.sdk.jad_ep.jad_jw jad_er;

    @Nullable
    public Fragment jad_fs;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class jad_an implements jad_qd {
        public jad_an() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + ((Object) jad_uh.this) + i.f4738d;
        }
    }

    public jad_uh() {
        this(new com.jd.ad.sdk.jad_xi.jad_an());
    }

    @VisibleForTesting
    public jad_uh(@NonNull com.jd.ad.sdk.jad_xi.jad_an jad_anVar) {
        this.jad_bo = new jad_an();
        this.jad_cp = new HashSet();
        this.jad_an = jad_anVar;
    }

    @Nullable
    public final Fragment jad_an() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.jad_fs;
    }

    public final void jad_an(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        jad_bo();
        jad_uh jad_an2 = com.jd.ad.sdk.jad_ep.jad_cp.jad_an(context).jad_fs.jad_an(fragmentManager, (Fragment) null);
        this.jad_dq = jad_an2;
        if (equals(jad_an2)) {
            return;
        }
        this.jad_dq.jad_cp.add(this);
    }

    public final void jad_bo() {
        jad_uh jad_uhVar = this.jad_dq;
        if (jad_uhVar != null) {
            jad_uhVar.jad_cp.remove(this);
            this.jad_dq = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        Fragment fragment = this;
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager == null) {
            if (Log.isLoggable(SupportRequestManagerFragment.TAG, 5)) {
                Logger.w(SupportRequestManagerFragment.TAG, "Unable to register fragment with root, ancestor detached");
            }
        } else {
            try {
                jad_an(getContext(), fragmentManager);
            } catch (IllegalStateException e2) {
                if (Log.isLoggable(SupportRequestManagerFragment.TAG, 5)) {
                    Logger.w(SupportRequestManagerFragment.TAG, "Unable to register fragment with root", e2);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.jad_an.jad_an();
        jad_bo();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.jad_fs = null;
        jad_bo();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.jad_an.jad_bo();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.jad_an.jad_cp();
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + ((Object) jad_an()) + i.f4738d;
    }
}
