package com.huawei.hmf.services.ui;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ActivityResultFragment extends Fragment {
    private static final String REPORT_FRAGMENT_TAG = "com.huawei.hmf.report_fragment_tag";
    private static final String TAG = "ActivityResultFragment";
    public Set<Integer> mTobeReleaseRequestCode = new HashSet();

    private static Fragment awaitCreateAndAddFragment(final FragmentManager fragmentManager) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicReference atomicReference = new AtomicReference();
        try {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.huawei.hmf.services.ui.ActivityResultFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    Fragment findFragmentByTag = fragmentManager.findFragmentByTag(ActivityResultFragment.REPORT_FRAGMENT_TAG);
                    if (findFragmentByTag == null) {
                        findFragmentByTag = ActivityResultFragment.createAndAddFragment(fragmentManager);
                    }
                    atomicReference.set(findFragmentByTag);
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
        return (Fragment) atomicReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Fragment createAndAddFragment(FragmentManager fragmentManager) {
        ActivityResultFragment activityResultFragment = null;
        try {
            ActivityResultFragment activityResultFragment2 = new ActivityResultFragment();
            try {
                fragmentManager.beginTransaction().add(activityResultFragment2, REPORT_FRAGMENT_TAG).commitAllowingStateLoss();
                fragmentManager.executePendingTransactions();
                return activityResultFragment2;
            } catch (Exception e2) {
                e = e2;
                activityResultFragment = activityResultFragment2;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("create fragment failed.");
                sb2.append(e.getMessage());
                return activityResultFragment;
            }
        } catch (Exception e10) {
            e = e10;
        }
    }

    public static Fragment injectIfNeededIn(Activity activity, int i10) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(REPORT_FRAGMENT_TAG);
        if (findFragmentByTag == null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                findFragmentByTag = awaitCreateAndAddFragment(fragmentManager);
            } else {
                findFragmentByTag = createAndAddFragment(fragmentManager);
            }
        }
        if (findFragmentByTag instanceof ActivityResultFragment) {
            ((ActivityResultFragment) findFragmentByTag).mTobeReleaseRequestCode.add(Integer.valueOf(i10));
        }
        return findFragmentByTag;
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        this.mTobeReleaseRequestCode.remove(Integer.valueOf(i10));
        Launcher.getLauncher().onActivityResult(getActivity(), i10, i11, intent);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (getActivity() == null || !getActivity().isFinishing()) {
            return;
        }
        Iterator<Integer> iterator2 = this.mTobeReleaseRequestCode.iterator2();
        while (iterator2.hasNext()) {
            Launcher.getLauncher().removeActivityCallback(iterator2.next().intValue());
        }
        this.mTobeReleaseRequestCode.clear();
    }
}
