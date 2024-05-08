package com.jd.ad.sdk.jad_xi;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.jd.ad.sdk.jad_ep.jad_dq;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_pc implements Handler.Callback {
    public static final jad_bo jad_jt = new jad_an();
    public volatile com.jd.ad.sdk.jad_ep.jad_jw jad_an;

    @VisibleForTesting
    public final Map<FragmentManager, jad_ob> jad_bo = new HashMap();

    @VisibleForTesting
    public final Map<androidx.fragment.app.FragmentManager, jad_uh> jad_cp = new HashMap();
    public final Handler jad_dq;
    public final jad_bo jad_er;
    public final jad_kx jad_fs;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class jad_an implements jad_bo {
        @NonNull
        public com.jd.ad.sdk.jad_ep.jad_jw jad_an(@NonNull com.jd.ad.sdk.jad_ep.jad_cp jad_cpVar, @NonNull jad_ly jad_lyVar, @NonNull jad_qd jad_qdVar, @NonNull Context context) {
            return new com.jd.ad.sdk.jad_ep.jad_jw(jad_cpVar, jad_lyVar, jad_qdVar, new jad_re(), jad_cpVar.jad_bo(), context);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface jad_bo {
    }

    public jad_pc(@Nullable jad_bo jad_boVar, com.jd.ad.sdk.jad_ep.jad_fs jad_fsVar) {
        new ArrayMap();
        new ArrayMap();
        new Bundle();
        this.jad_er = jad_boVar == null ? jad_jt : jad_boVar;
        this.jad_dq = new Handler(Looper.getMainLooper(), this);
        this.jad_fs = jad_an(jad_fsVar);
    }

    @Nullable
    public static Activity jad_an(@NonNull Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return jad_an(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static jad_kx jad_an(com.jd.ad.sdk.jad_ep.jad_fs jad_fsVar) {
        return (com.jd.ad.sdk.jad_rc.jad_na.jad_hu && com.jd.ad.sdk.jad_rc.jad_na.jad_jt) ? jad_fsVar.jad_an.containsKey(jad_dq.jad_er.class) ? new jad_iv() : new jad_jw() : new jad_jt();
    }

    public static void jad_an(@NonNull Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x016c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0158  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean handleMessage(android.os.Message r17) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_xi.jad_pc.handleMessage(android.os.Message):boolean");
    }

    @NonNull
    public com.jd.ad.sdk.jad_ep.jad_jw jad_bo(@NonNull Context context) {
        if (context != null) {
            if (com.jd.ad.sdk.jad_gp.jad_ly.jad_dq() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return jad_an((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    if (com.jd.ad.sdk.jad_gp.jad_ly.jad_cp()) {
                        return jad_bo(activity.getApplicationContext());
                    }
                    if (activity instanceof FragmentActivity) {
                        return jad_an((FragmentActivity) activity);
                    }
                    jad_an(activity);
                    this.jad_fs.jad_an(activity);
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    Activity jad_an2 = jad_an((Context) activity);
                    boolean z10 = jad_an2 == null || !jad_an2.isFinishing();
                    jad_ob jad_an3 = jad_an(fragmentManager, (Fragment) null);
                    com.jd.ad.sdk.jad_ep.jad_jw jad_jwVar = jad_an3.jad_dq;
                    if (jad_jwVar != null) {
                        return jad_jwVar;
                    }
                    com.jd.ad.sdk.jad_ep.jad_jw jad_an4 = ((jad_an) this.jad_er).jad_an(com.jd.ad.sdk.jad_ep.jad_cp.jad_an(activity), jad_an3.jad_an, jad_an3.jad_bo, activity);
                    if (z10) {
                        jad_an4.jad_cp();
                    }
                    jad_an3.jad_dq = jad_an4;
                    return jad_an4;
                }
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return jad_bo(contextWrapper.getBaseContext());
                    }
                }
            }
            if (this.jad_an == null) {
                synchronized (this) {
                    if (this.jad_an == null) {
                        this.jad_an = ((jad_an) this.jad_er).jad_an(com.jd.ad.sdk.jad_ep.jad_cp.jad_an(context.getApplicationContext()), new com.jd.ad.sdk.jad_xi.jad_bo(), new jad_hu(), context.getApplicationContext());
                    }
                }
            }
            return this.jad_an;
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    @NonNull
    public com.jd.ad.sdk.jad_ep.jad_jw jad_an(@NonNull FragmentActivity fragmentActivity) {
        if (com.jd.ad.sdk.jad_gp.jad_ly.jad_cp()) {
            return jad_bo(fragmentActivity.getApplicationContext());
        }
        jad_an((Activity) fragmentActivity);
        this.jad_fs.jad_an(fragmentActivity);
        androidx.fragment.app.FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Activity jad_an2 = jad_an((Context) fragmentActivity);
        boolean z10 = jad_an2 == null || !jad_an2.isFinishing();
        jad_uh jad_an3 = jad_an(supportFragmentManager, (androidx.fragment.app.Fragment) null);
        com.jd.ad.sdk.jad_ep.jad_jw jad_jwVar = jad_an3.jad_er;
        if (jad_jwVar == null) {
            jad_jwVar = ((jad_an) this.jad_er).jad_an(com.jd.ad.sdk.jad_ep.jad_cp.jad_an(fragmentActivity), jad_an3.jad_an, jad_an3.jad_bo, fragmentActivity);
            if (z10) {
                jad_jwVar.jad_cp();
            }
            jad_an3.jad_er = jad_jwVar;
        }
        return jad_jwVar;
    }

    @NonNull
    public final jad_ob jad_an(@NonNull FragmentManager fragmentManager, @Nullable Fragment fragment) {
        jad_ob jad_obVar = this.jad_bo.get(fragmentManager);
        if (jad_obVar != null) {
            return jad_obVar;
        }
        jad_ob jad_obVar2 = (jad_ob) fragmentManager.findFragmentByTag("com.jd.ad.sdk.glide.manager");
        if (jad_obVar2 == null) {
            jad_obVar2 = new jad_ob(new com.jd.ad.sdk.jad_xi.jad_an());
            jad_obVar2.jad_fs = fragment;
            if (fragment != null && fragment.getActivity() != null) {
                jad_obVar2.jad_an(fragment.getActivity());
            }
            this.jad_bo.put(fragmentManager, jad_obVar2);
            fragmentManager.beginTransaction().add(jad_obVar2, "com.jd.ad.sdk.glide.manager").commitAllowingStateLoss();
            this.jad_dq.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return jad_obVar2;
    }

    @NonNull
    public final jad_uh jad_an(@NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable androidx.fragment.app.Fragment fragment) {
        jad_uh jad_uhVar = this.jad_cp.get(fragmentManager);
        if (jad_uhVar != null) {
            return jad_uhVar;
        }
        jad_uh jad_uhVar2 = (jad_uh) fragmentManager.findFragmentByTag("com.jd.ad.sdk.glide.manager");
        if (jad_uhVar2 == null) {
            jad_uhVar2 = new jad_uh(new com.jd.ad.sdk.jad_xi.jad_an());
            jad_uhVar2.jad_fs = fragment;
            if (fragment != null && fragment.getContext() != null) {
                androidx.fragment.app.Fragment fragment2 = fragment;
                while (fragment2.getParentFragment() != null) {
                    fragment2 = fragment2.getParentFragment();
                }
                androidx.fragment.app.FragmentManager fragmentManager2 = fragment2.getFragmentManager();
                if (fragmentManager2 != null) {
                    jad_uhVar2.jad_an(fragment.getContext(), fragmentManager2);
                }
            }
            this.jad_cp.put(fragmentManager, jad_uhVar2);
            fragmentManager.beginTransaction().add(jad_uhVar2, "com.jd.ad.sdk.glide.manager").commitAllowingStateLoss();
            this.jad_dq.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return jad_uhVar2;
    }
}
