package com.android.internal.app;

import android.app.ActivityManager;
import android.app.AppGlobals;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.Log;
import com.android.internal.app.AbstractResolverComparator;
import com.android.internal.app.ResolverActivity;
import com.android.internal.app.chooser.DisplayResolveInfo;
import com.android.internal.app.chooser.TargetInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.CountDownLatch;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ResolverListController {
    private static final boolean DEBUG = false;
    private static final String TAG = "ResolverListController";
    private boolean isComputed;
    private final Context mContext;
    private final int mLaunchedFromUid;
    private final UserHandle mQueryIntentsAsUser;
    private final String mReferrerPackage;
    private AbstractResolverComparator mResolverComparator;
    private final Intent mTargetIntent;
    private final UserHandle mUserHandle;
    private final PackageManager mpm;

    public ResolverListController(Context context, PackageManager pm, Intent targetIntent, String referrerPackage, int launchedFromUid, UserHandle userHandle, UserHandle queryIntentsAsUser) {
        this(context, pm, targetIntent, referrerPackage, launchedFromUid, userHandle, new ResolverRankerServiceResolverComparator(context, targetIntent, referrerPackage, (AbstractResolverComparator.AfterCompute) null, (ChooserActivityLogger) null, userHandle), queryIntentsAsUser);
    }

    public ResolverListController(Context context, PackageManager pm, Intent targetIntent, String referrerPackage, int launchedFromUid, UserHandle userHandle, AbstractResolverComparator resolverComparator, UserHandle queryIntentsAsUser) {
        this.isComputed = false;
        this.mContext = context;
        this.mpm = pm;
        this.mLaunchedFromUid = launchedFromUid;
        this.mTargetIntent = targetIntent;
        this.mReferrerPackage = referrerPackage;
        this.mUserHandle = userHandle;
        this.mResolverComparator = resolverComparator;
        this.mQueryIntentsAsUser = queryIntentsAsUser;
    }

    public ResolveInfo getLastChosen() throws RemoteException {
        IPackageManager packageManager = AppGlobals.getPackageManager();
        Intent intent = this.mTargetIntent;
        return packageManager.getLastChosenActivity(intent, intent.resolveTypeIfNeeded(this.mContext.getContentResolver()), 65536);
    }

    public void setLastChosen(Intent intent, IntentFilter filter, int match) throws RemoteException {
        AppGlobals.getPackageManager().setLastChosenActivity(intent, intent.resolveType(this.mContext.getContentResolver()), 65536, filter, match, intent.getComponent());
    }

    public List<ResolverActivity.ResolvedComponentInfo> getResolversForIntent(boolean shouldGetResolvedFilter, boolean shouldGetActivityMetadata, boolean shouldGetOnlyDefaultActivities, List<Intent> intents) {
        return getResolversForIntentAsUser(shouldGetResolvedFilter, shouldGetActivityMetadata, shouldGetOnlyDefaultActivities, intents, this.mQueryIntentsAsUser);
    }

    public List<ResolverActivity.ResolvedComponentInfo> getResolversForIntentAsUser(boolean shouldGetResolvedFilter, boolean shouldGetActivityMetadata, boolean shouldGetOnlyDefaultActivities, List<Intent> intents, UserHandle userHandle) {
        int baseFlags = (shouldGetActivityMetadata ? 128 : 0) | (shouldGetOnlyDefaultActivities ? 65536 : 0) | 524288 | 262144 | (shouldGetResolvedFilter ? 64 : 0) | 536870912;
        return getResolversForIntentAsUserInternal(intents, userHandle, baseFlags);
    }

    private List<ResolverActivity.ResolvedComponentInfo> getResolversForIntentAsUserInternal(List<Intent> intents, UserHandle userHandle, int baseFlags) {
        List<ResolverActivity.ResolvedComponentInfo> resolvedComponents = null;
        int N = intents.size();
        for (int i10 = 0; i10 < N; i10++) {
            Intent intent = intents.get(i10);
            int flags = baseFlags;
            if (intent.isWebIntent() || (intent.getFlags() & 2048) != 0) {
                flags |= 8388608;
            }
            Intent intent2 = intent.getClass() == Intent.class ? intent : new Intent(intent);
            List infos = this.mpm.queryIntentActivitiesAsUser(intent2, flags, userHandle);
            if (infos != null) {
                if (resolvedComponents == null) {
                    resolvedComponents = new ArrayList<>();
                }
                addResolveListDedupe(resolvedComponents, intent2, infos);
            }
        }
        return resolvedComponents;
    }

    public UserHandle getUserHandle() {
        return this.mUserHandle;
    }

    public void addResolveListDedupe(List<ResolverActivity.ResolvedComponentInfo> into, Intent intent, List<ResolveInfo> from) {
        int fromCount = from.size();
        int intoCount = into.size();
        for (int i10 = 0; i10 < fromCount; i10++) {
            ResolveInfo newInfo = from.get(i10);
            if (newInfo.userHandle == null) {
                Log.w(TAG, "Skipping ResolveInfo with no userHandle: " + ((Object) newInfo));
            } else {
                boolean found = false;
                int j10 = 0;
                while (true) {
                    if (j10 >= intoCount) {
                        break;
                    }
                    ResolverActivity.ResolvedComponentInfo rci = into.get(j10);
                    if (!isSameResolvedComponent(newInfo, rci)) {
                        j10++;
                    } else {
                        found = true;
                        rci.add(intent, newInfo);
                        break;
                    }
                }
                if (!found) {
                    ComponentName name = new ComponentName(newInfo.activityInfo.packageName, newInfo.activityInfo.name);
                    ResolverActivity.ResolvedComponentInfo rci2 = new ResolverActivity.ResolvedComponentInfo(name, intent, newInfo);
                    rci2.setPinned(isComponentPinned(name));
                    rci2.setFixedAtTop(isFixedAtTop(name));
                    into.add(rci2);
                }
            }
        }
    }

    public boolean isComponentPinned(ComponentName name) {
        return false;
    }

    public boolean isFixedAtTop(ComponentName name) {
        return false;
    }

    public ArrayList<ResolverActivity.ResolvedComponentInfo> filterIneligibleActivities(List<ResolverActivity.ResolvedComponentInfo> inputList, boolean returnCopyOfOriginalListIfModified) {
        ArrayList<ResolverActivity.ResolvedComponentInfo> listToReturn = null;
        for (int i10 = inputList.size() - 1; i10 >= 0; i10--) {
            ActivityInfo ai = inputList.get(i10).getResolveInfoAt(0).activityInfo;
            int granted = ActivityManager.checkComponentPermission(ai.permission, this.mLaunchedFromUid, ai.applicationInfo.uid, ai.exported);
            int grantForStartAnyActivity = ActivityManager.checkComponentPermission("android.permission.START_ANY_ACTIVITY", this.mLaunchedFromUid, -1, true);
            if ((grantForStartAnyActivity != 0 && granted != 0) || isComponentFiltered(ai.getComponentName())) {
                if (returnCopyOfOriginalListIfModified && listToReturn == null) {
                    listToReturn = new ArrayList<>(inputList);
                }
                inputList.remove(i10);
            }
        }
        return listToReturn;
    }

    public ArrayList<ResolverActivity.ResolvedComponentInfo> filterLowPriority(List<ResolverActivity.ResolvedComponentInfo> inputList, boolean returnCopyOfOriginalListIfModified) {
        ArrayList<ResolverActivity.ResolvedComponentInfo> listToReturn = null;
        ResolverActivity.ResolvedComponentInfo rci0 = inputList.get(0);
        ResolveInfo r02 = rci0.getResolveInfoAt(0);
        int N = inputList.size();
        for (int i10 = 1; i10 < N; i10++) {
            ResolveInfo ri = inputList.get(i10).getResolveInfoAt(0);
            if (r02.priority != ri.priority || r02.isDefault != ri.isDefault) {
                while (i10 < N) {
                    if (returnCopyOfOriginalListIfModified && listToReturn == null) {
                        listToReturn = new ArrayList<>(inputList);
                    }
                    inputList.remove(i10);
                    N--;
                }
            }
        }
        return listToReturn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class ComputeCallback implements AbstractResolverComparator.AfterCompute {
        private CountDownLatch mFinishComputeSignal;

        public ComputeCallback(CountDownLatch finishComputeSignal) {
            this.mFinishComputeSignal = finishComputeSignal;
        }

        @Override // com.android.internal.app.AbstractResolverComparator.AfterCompute
        public void afterCompute() {
            this.mFinishComputeSignal.countDown();
        }
    }

    private void compute(List<ResolverActivity.ResolvedComponentInfo> inputList) throws InterruptedException {
        if (this.mResolverComparator == null) {
            Log.d(TAG, "Comparator has already been destroyed; skipped.");
            return;
        }
        CountDownLatch finishComputeSignal = new CountDownLatch(1);
        ComputeCallback callback = new ComputeCallback(finishComputeSignal);
        this.mResolverComparator.setCallBack(callback);
        this.mResolverComparator.compute(inputList);
        finishComputeSignal.await();
        this.isComputed = true;
    }

    public void sort(List<ResolverActivity.ResolvedComponentInfo> inputList) {
        try {
            System.currentTimeMillis();
            if (!this.isComputed) {
                compute(inputList);
            }
            Collections.sort(inputList, this.mResolverComparator);
            System.currentTimeMillis();
        } catch (InterruptedException e2) {
            Log.e(TAG, "Compute & Sort was interrupted: " + ((Object) e2));
        }
    }

    public void topK(List<ResolverActivity.ResolvedComponentInfo> inputList, int k10) {
        if (inputList == null || inputList.isEmpty() || k10 <= 0) {
            return;
        }
        if (inputList.size() <= k10) {
            sort(inputList);
            return;
        }
        try {
            System.currentTimeMillis();
            if (!this.isComputed) {
                compute(inputList);
            }
            PriorityQueue<ResolverActivity.ResolvedComponentInfo> minHeap = new PriorityQueue<>(k10, new Comparator() { // from class: com.android.internal.app.ResolverListController$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int lambda$topK$0;
                    lambda$topK$0 = ResolverListController.this.lambda$topK$0((ResolverActivity.ResolvedComponentInfo) obj, (ResolverActivity.ResolvedComponentInfo) obj2);
                    return lambda$topK$0;
                }
            });
            int size = inputList.size();
            int pointer = size - 1;
            minHeap.addAll(inputList.subList(size - k10, size));
            for (int i10 = (size - k10) - 1; i10 >= 0; i10--) {
                ResolverActivity.ResolvedComponentInfo ci = inputList.get(i10);
                if ((-this.mResolverComparator.compare(ci, minHeap.peek())) > 0) {
                    inputList.set(pointer, minHeap.poll());
                    minHeap.add(ci);
                    pointer--;
                } else {
                    inputList.set(pointer, ci);
                    pointer--;
                }
            }
            while (!minHeap.isEmpty()) {
                inputList.set(pointer, minHeap.poll());
                pointer--;
            }
            System.currentTimeMillis();
        } catch (InterruptedException e2) {
            Log.e(TAG, "Compute & greatestOf was interrupted: " + ((Object) e2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$topK$0(ResolverActivity.ResolvedComponentInfo o12, ResolverActivity.ResolvedComponentInfo o22) {
        return -this.mResolverComparator.compare(o12, o22);
    }

    private static boolean isSameResolvedComponent(ResolveInfo a10, ResolverActivity.ResolvedComponentInfo b4) {
        ActivityInfo ai = a10.activityInfo;
        return ai.packageName.equals(b4.name.getPackageName()) && ai.name.equals(b4.name.getClassName());
    }

    boolean isComponentFiltered(ComponentName componentName) {
        return false;
    }

    public float getScore(DisplayResolveInfo target) {
        return this.mResolverComparator.getScore(target);
    }

    public float getScore(TargetInfo targetInfo) {
        return this.mResolverComparator.getScore(targetInfo);
    }

    public void updateModel(TargetInfo targetInfo) {
        this.mResolverComparator.updateModel(targetInfo);
    }

    public void updateChooserCounts(String packageName, UserHandle user, String action) {
        this.mResolverComparator.updateChooserCounts(packageName, user, action);
    }

    public void destroy() {
        this.mResolverComparator.destroy();
    }
}
