package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.SparseArray;
import com.huawei.hms.api.HuaweiApiClient;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AutoLifecycleFragment extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private final SparseArray<a> f29678a = new SparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    private boolean f29679b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final HuaweiApiClient f29680a;

        /* renamed from: b, reason: collision with root package name */
        public final int f29681b;

        public a(int i10, HuaweiApiClient huaweiApiClient) {
            this.f29680a = huaweiApiClient;
            this.f29681b = i10;
        }

        public void a() {
            this.f29680a.disconnect();
        }
    }

    public static AutoLifecycleFragment getInstance(Activity activity) {
        Preconditions.checkMainThread("Must be called on the main thread");
        try {
            AutoLifecycleFragment autoLifecycleFragment = (AutoLifecycleFragment) activity.getFragmentManager().findFragmentByTag("HmsAutoLifecycleFrag");
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (autoLifecycleFragment != null) {
                return autoLifecycleFragment;
            }
            AutoLifecycleFragment autoLifecycleFragment2 = new AutoLifecycleFragment();
            fragmentManager.beginTransaction().add(autoLifecycleFragment2, "HmsAutoLifecycleFrag").commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
            return autoLifecycleFragment2;
        } catch (ClassCastException e2) {
            throw new IllegalStateException("Fragment with tag HmsAutoLifecycleFrag is not a AutoLifecycleFragment", e2);
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f29679b = true;
        for (int i10 = 0; i10 < this.f29678a.size(); i10++) {
            this.f29678a.valueAt(i10).f29680a.connect((Activity) null);
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f29679b = false;
        for (int i10 = 0; i10 < this.f29678a.size(); i10++) {
            this.f29678a.valueAt(i10).f29680a.disconnect();
        }
    }

    public void startAutoMange(int i10, HuaweiApiClient huaweiApiClient) {
        Preconditions.checkNotNull(huaweiApiClient, "HuaweiApiClient instance cannot be null");
        Preconditions.checkState(this.f29678a.indexOfKey(i10) < 0, "Already managing a HuaweiApiClient with this clientId: " + i10);
        this.f29678a.put(i10, new a(i10, huaweiApiClient));
        if (this.f29679b) {
            huaweiApiClient.connect((Activity) null);
        }
    }

    public void stopAutoManage(int i10) {
        a aVar = this.f29678a.get(i10);
        this.f29678a.remove(i10);
        if (aVar != null) {
            aVar.a();
        }
    }
}
