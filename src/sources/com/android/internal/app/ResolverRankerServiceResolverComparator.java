package com.android.internal.app;

import android.app.usage.UsageStats;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.metrics.LogMaker;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.UserHandle;
import android.service.resolver.IResolverRankerResult;
import android.service.resolver.IResolverRankerService;
import android.service.resolver.ResolverTarget;
import android.util.ArrayMap;
import android.util.Log;
import com.android.internal.app.AbstractResolverComparator;
import com.android.internal.app.ResolverActivity;
import com.android.internal.app.ResolverRankerServiceResolverComparator;
import com.android.internal.app.chooser.TargetInfo;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.collect.Lists;
import java.lang.ref.WeakReference;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ResolverRankerServiceResolverComparator extends AbstractResolverComparator {
    private static final int CONNECTION_COST_TIMEOUT_MILLIS = 200;
    private static final boolean DEBUG = false;
    private static final float RECENCY_MULTIPLIER = 2.0f;
    private static final long RECENCY_TIME_PERIOD = 43200000;
    private static final String TAG = "RRSResolverComparator";
    private static final long USAGE_STATS_PERIOD = 604800000;
    private String mAction;
    private final Collator mCollator;
    private ResolverRankerServiceComparatorModel mComparatorModel;
    private CountDownLatch mConnectSignal;
    private ResolverRankerServiceConnection mConnection;
    private Context mContext;
    private final long mCurrentTime;
    private final Object mLock;
    private IResolverRankerService mRanker;
    private ComponentName mRankerServiceName;
    private final String mReferrerPackage;
    private ComponentName mResolvedRankerName;
    private final long mSinceTime;
    private final Map<UserHandle, Map<String, UsageStats>> mStatsPerUser;
    private ArrayList<ResolverTarget> mTargets;
    private final Map<UserHandle, LinkedHashMap<ComponentName, ResolverTarget>> mTargetsDictPerUser;

    public ResolverRankerServiceResolverComparator(Context launchedFromContext, Intent intent, String referrerPackage, AbstractResolverComparator.AfterCompute afterCompute, ChooserActivityLogger chooserActivityLogger, UserHandle targetUserSpace) {
        this(launchedFromContext, intent, referrerPackage, afterCompute, chooserActivityLogger, Lists.newArrayList(new UserHandle[]{targetUserSpace}));
    }

    public ResolverRankerServiceResolverComparator(Context launchedFromContext, Intent intent, String referrerPackage, AbstractResolverComparator.AfterCompute afterCompute, ChooserActivityLogger chooserActivityLogger, List<UserHandle> targetUserSpaceList) {
        super(launchedFromContext, intent, targetUserSpaceList);
        this.mLock = new Object();
        this.mCollator = Collator.getInstance(launchedFromContext.getResources().getConfiguration().locale);
        this.mReferrerPackage = referrerPackage;
        this.mContext = launchedFromContext;
        long currentTimeMillis = System.currentTimeMillis();
        this.mCurrentTime = currentTimeMillis;
        this.mSinceTime = currentTimeMillis - 604800000;
        this.mStatsPerUser = new HashMap();
        this.mTargetsDictPerUser = new HashMap();
        for (UserHandle user : targetUserSpaceList) {
            this.mStatsPerUser.put(user, this.mUsmMap.get(user).queryAndAggregateUsageStats(this.mSinceTime, this.mCurrentTime));
            this.mTargetsDictPerUser.put(user, new LinkedHashMap<>());
        }
        this.mAction = intent.getAction();
        this.mRankerServiceName = new ComponentName(this.mContext, getClass());
        setCallBack(afterCompute);
        setChooserActivityLogger(chooserActivityLogger);
        this.mComparatorModel = buildUpdatedModel();
    }

    @Override // com.android.internal.app.AbstractResolverComparator
    public void handleResultMessage(Message msg) {
        if (msg.what != 0) {
            return;
        }
        if (msg.obj == null) {
            Log.e(TAG, "Receiving null prediction results.");
            return;
        }
        List<ResolverTarget> receivedTargets = (List) msg.obj;
        if (receivedTargets != null && this.mTargets != null && receivedTargets.size() == this.mTargets.size()) {
            int size = this.mTargets.size();
            boolean isUpdated = false;
            for (int i10 = 0; i10 < size; i10++) {
                float predictedProb = receivedTargets.get(i10).getSelectProbability();
                if (predictedProb != this.mTargets.get(i10).getSelectProbability()) {
                    this.mTargets.get(i10).setSelectProbability(predictedProb);
                    isUpdated = true;
                }
            }
            if (isUpdated) {
                this.mRankerServiceName = this.mResolvedRankerName;
                this.mComparatorModel = buildUpdatedModel();
                return;
            }
            return;
        }
        Log.e(TAG, "Sizes of sent and received ResolverTargets diff.");
    }

    @Override // com.android.internal.app.AbstractResolverComparator
    public void doCompute(List<ResolverActivity.ResolvedComponentInfo> targets) {
        Iterator<ResolverActivity.ResolvedComponentInfo> it;
        long recentSinceTime = this.mCurrentTime - RECENCY_TIME_PERIOD;
        Iterator<ResolverActivity.ResolvedComponentInfo> iterator2 = targets.iterator2();
        float mostRecencyScore = 1.0f;
        float mostTimeSpentScore = 1.0f;
        float mostLaunchScore = 1.0f;
        float mostChooserScore = 1.0f;
        while (iterator2.hasNext()) {
            ResolverActivity.ResolvedComponentInfo target = iterator2.next();
            ResolverTarget resolverTarget = new ResolverTarget();
            LinkedHashMap<ComponentName, ResolverTarget> targetsDict = this.mTargetsDictPerUser.get(target.getResolveInfoAt(0).userHandle);
            Map<String, UsageStats> stats = this.mStatsPerUser.get(target.getResolveInfoAt(0).userHandle);
            if (targetsDict == null || stats == null) {
                it = iterator2;
            } else {
                targetsDict.put(target.name, resolverTarget);
                UsageStats pkStats = stats.get(target.name.getPackageName());
                if (pkStats != null) {
                    if (target.name.getPackageName().equals(this.mReferrerPackage)) {
                        it = iterator2;
                    } else if (isPersistentProcess(target)) {
                        it = iterator2;
                    } else {
                        it = iterator2;
                        float recencyScore = (float) Math.max(pkStats.getLastTimeUsed() - recentSinceTime, 0L);
                        resolverTarget.setRecencyScore(recencyScore);
                        if (recencyScore > mostRecencyScore) {
                            mostRecencyScore = recencyScore;
                        }
                    }
                    float timeSpentScore = (float) pkStats.getTotalTimeInForeground();
                    resolverTarget.setTimeSpentScore(timeSpentScore);
                    if (timeSpentScore > mostTimeSpentScore) {
                        mostTimeSpentScore = timeSpentScore;
                    }
                    float launchScore = pkStats.mLaunchCount;
                    resolverTarget.setLaunchScore(launchScore);
                    if (launchScore > mostLaunchScore) {
                        mostLaunchScore = launchScore;
                    }
                    float chooserScore = 0.0f;
                    if (pkStats.mChooserCounts != null && this.mAction != null) {
                        if (pkStats.mChooserCounts.get(this.mAction) != null) {
                            chooserScore = ((Integer) ((ArrayMap) pkStats.mChooserCounts.get(this.mAction)).getOrDefault(this.mContentType, 0)).intValue();
                            if (this.mAnnotations != null) {
                                int size = this.mAnnotations.length;
                                int i10 = 0;
                                while (i10 < size) {
                                    chooserScore += ((Integer) ((ArrayMap) pkStats.mChooserCounts.get(this.mAction)).getOrDefault(this.mAnnotations[i10], 0)).intValue();
                                    i10++;
                                    size = size;
                                    timeSpentScore = timeSpentScore;
                                }
                            }
                        }
                    }
                    resolverTarget.setChooserScore(chooserScore);
                    if (chooserScore > mostChooserScore) {
                        mostChooserScore = chooserScore;
                    }
                } else {
                    it = iterator2;
                }
            }
            iterator2 = it;
        }
        this.mTargets = new ArrayList<>();
        for (UserHandle u10 : this.mTargetsDictPerUser.h()) {
            this.mTargets.addAll(this.mTargetsDictPerUser.get(u10).values());
        }
        Iterator<ResolverTarget> iterator22 = this.mTargets.iterator2();
        while (iterator22.hasNext()) {
            ResolverTarget target2 = iterator22.next();
            float recency = target2.getRecencyScore() / mostRecencyScore;
            setFeatures(target2, recency * recency * 2.0f, target2.getLaunchScore() / mostLaunchScore, target2.getTimeSpentScore() / mostTimeSpentScore, target2.getChooserScore() / mostChooserScore);
            addDefaultSelectProbability(target2);
        }
        predictSelectProbabilities(this.mTargets);
        this.mComparatorModel = buildUpdatedModel();
    }

    @Override // com.android.internal.app.AbstractResolverComparator
    public int compare(ResolveInfo lhs, ResolveInfo rhs) {
        return this.mComparatorModel.getComparator().compare(lhs, rhs);
    }

    @Override // com.android.internal.app.AbstractResolverComparator
    public float getScore(TargetInfo targetInfo) {
        return this.mComparatorModel.getScore(targetInfo);
    }

    @Override // com.android.internal.app.AbstractResolverComparator
    public void updateModel(TargetInfo targetInfo) {
        synchronized (this.mLock) {
            this.mComparatorModel.notifyOnTargetSelected(targetInfo);
        }
    }

    @Override // com.android.internal.app.AbstractResolverComparator
    public void destroy() {
        this.mHandler.removeMessages(0);
        this.mHandler.removeMessages(1);
        ResolverRankerServiceConnection resolverRankerServiceConnection = this.mConnection;
        if (resolverRankerServiceConnection != null) {
            this.mContext.unbindService(resolverRankerServiceConnection);
            this.mConnection.destroy();
        }
        afterCompute();
    }

    private void initRanker(Context context) {
        synchronized (this.mLock) {
            if (this.mConnection == null || this.mRanker == null) {
                Intent intent = resolveRankerService();
                if (intent == null) {
                    return;
                }
                CountDownLatch countDownLatch = new CountDownLatch(1);
                this.mConnectSignal = countDownLatch;
                ResolverRankerServiceConnection resolverRankerServiceConnection = new ResolverRankerServiceConnection(countDownLatch);
                this.mConnection = resolverRankerServiceConnection;
                context.bindServiceAsUser(intent, resolverRankerServiceConnection, 1, UserHandle.SYSTEM);
            }
        }
    }

    private Intent resolveRankerService() {
        Intent intent = new Intent("android.service.resolver.ResolverRankerService");
        List<ResolveInfo> resolveInfos = this.mContext.getPackageManager().queryIntentServices(intent, 0);
        for (ResolveInfo resolveInfo : resolveInfos) {
            if (resolveInfo != null && resolveInfo.serviceInfo != null && resolveInfo.serviceInfo.applicationInfo != null) {
                ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.applicationInfo.packageName, resolveInfo.serviceInfo.name);
                try {
                    String perm = this.mContext.getPackageManager().getServiceInfo(componentName, 0).permission;
                    if (!"android.permission.BIND_RESOLVER_RANKER_SERVICE".equals(perm)) {
                        Log.w(TAG, "ResolverRankerService " + ((Object) componentName) + " does not require permission android.permission.BIND_RESOLVER_RANKER_SERVICE - this service will not be queried for ResolverRankerServiceResolverComparator. add android:permission=\"android.permission.BIND_RESOLVER_RANKER_SERVICE\" to the <service> tag for " + ((Object) componentName) + " in the manifest.");
                    } else if (this.mContext.getPackageManager().checkPermission("android.permission.PROVIDE_RESOLVER_RANKER_SERVICE", resolveInfo.serviceInfo.packageName) != 0) {
                        Log.w(TAG, "ResolverRankerService " + ((Object) componentName) + " does not hold permission android.permission.PROVIDE_RESOLVER_RANKER_SERVICE - this service will not be queried for ResolverRankerServiceResolverComparator.");
                    } else {
                        this.mResolvedRankerName = componentName;
                        intent.setComponent(componentName);
                        return intent;
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.e(TAG, "Could not look up service " + ((Object) componentName) + "; component name not found");
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class ResolverRankerServiceConnection implements ServiceConnection {
        private final CountDownLatch mConnectSignal;
        public final IResolverRankerResult resolverRankerResult;

        public ResolverRankerServiceConnection(CountDownLatch connectSignal) {
            this.resolverRankerResult = new ResolverRankerResult(ResolverRankerServiceResolverComparator.this);
            this.mConnectSignal = connectSignal;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            synchronized (ResolverRankerServiceResolverComparator.this.mLock) {
                ResolverRankerServiceResolverComparator.this.mRanker = IResolverRankerService.Stub.asInterface(service);
                ResolverRankerServiceResolverComparator resolverRankerServiceResolverComparator = ResolverRankerServiceResolverComparator.this;
                resolverRankerServiceResolverComparator.mComparatorModel = resolverRankerServiceResolverComparator.buildUpdatedModel();
                this.mConnectSignal.countDown();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            synchronized (ResolverRankerServiceResolverComparator.this.mLock) {
                destroy();
            }
        }

        public void destroy() {
            synchronized (ResolverRankerServiceResolverComparator.this.mLock) {
                ResolverRankerServiceResolverComparator.this.mRanker = null;
                ResolverRankerServiceResolverComparator resolverRankerServiceResolverComparator = ResolverRankerServiceResolverComparator.this;
                resolverRankerServiceResolverComparator.mComparatorModel = resolverRankerServiceResolverComparator.buildUpdatedModel();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private static class ResolverRankerResult extends IResolverRankerResult.Stub {
        private WeakReference<ResolverRankerServiceResolverComparator> mWeakReference;

        ResolverRankerResult(ResolverRankerServiceResolverComparator comparator) {
            this.mWeakReference = new WeakReference<>(comparator);
        }

        public void sendResult(List<ResolverTarget> targets) throws RemoteException {
            ResolverRankerServiceResolverComparator comparator = this.mWeakReference.get();
            if (comparator == null) {
                return;
            }
            synchronized (comparator.mLock) {
                Message msg = Message.obtain();
                msg.what = 0;
                msg.obj = targets;
                comparator.mHandler.sendMessage(msg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.app.AbstractResolverComparator
    public void beforeCompute() {
        super.beforeCompute();
        for (UserHandle userHandle : this.mTargetsDictPerUser.h()) {
            this.mTargetsDictPerUser.get(userHandle).clear();
        }
        this.mTargets = null;
        this.mRankerServiceName = new ComponentName(this.mContext, getClass());
        this.mComparatorModel = buildUpdatedModel();
        this.mResolvedRankerName = null;
        initRanker(this.mContext);
    }

    private void predictSelectProbabilities(List<ResolverTarget> targets) {
        if (this.mConnection != null) {
            try {
                this.mConnectSignal.await(200L, TimeUnit.MILLISECONDS);
                synchronized (this.mLock) {
                    IResolverRankerService iResolverRankerService = this.mRanker;
                    if (iResolverRankerService != null) {
                        iResolverRankerService.predict(targets, this.mConnection.resolverRankerResult);
                        return;
                    }
                }
            } catch (RemoteException e2) {
                Log.e(TAG, "Error in Predict: " + ((Object) e2));
            } catch (InterruptedException e10) {
                Log.e(TAG, "Error in Wait for Service Connection.");
            }
        }
        afterCompute();
    }

    private void addDefaultSelectProbability(ResolverTarget target) {
        float sum = (target.getLaunchScore() * 2.5543f) + (target.getTimeSpentScore() * 2.8412f) + (target.getRecencyScore() * 0.269f) + (target.getChooserScore() * 4.2222f);
        target.setSelectProbability((float) (1.0d / (Math.exp(1.6568f - sum) + 1.0d)));
    }

    private void setFeatures(ResolverTarget target, float recencyScore, float launchScore, float timeSpentScore, float chooserScore) {
        target.setRecencyScore(recencyScore);
        target.setLaunchScore(launchScore);
        target.setTimeSpentScore(timeSpentScore);
        target.setChooserScore(chooserScore);
    }

    static boolean isPersistentProcess(ResolverActivity.ResolvedComponentInfo rci) {
        return (rci == null || rci.getCount() <= 0 || (rci.getResolveInfoAt(0).activityInfo.applicationInfo.flags & 8) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResolverRankerServiceComparatorModel buildUpdatedModel() {
        return new ResolverRankerServiceComparatorModel(this.mStatsPerUser, this.mTargetsDictPerUser, this.mTargets, this.mCollator, this.mRanker, this.mRankerServiceName, this.mAnnotations != null, this.mPmMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class ResolverRankerServiceComparatorModel implements ResolverComparatorModel {
        private final boolean mAnnotationsUsed;
        private final Collator mCollator;
        private final Map<UserHandle, PackageManager> mPmMap;
        private final IResolverRankerService mRanker;
        private final ComponentName mRankerServiceName;
        private final Map<UserHandle, Map<String, UsageStats>> mStatsPerUser;
        private final List<ResolverTarget> mTargets;
        private final Map<UserHandle, LinkedHashMap<ComponentName, ResolverTarget>> mTargetsDictPerUser;

        ResolverRankerServiceComparatorModel(Map<UserHandle, Map<String, UsageStats>> statsPerUser, Map<UserHandle, LinkedHashMap<ComponentName, ResolverTarget>> targetsDictPerUser, List<ResolverTarget> targets, Collator collator, IResolverRankerService ranker, ComponentName rankerServiceName, boolean annotationsUsed, Map<UserHandle, PackageManager> pmMap) {
            this.mStatsPerUser = statsPerUser;
            this.mTargetsDictPerUser = targetsDictPerUser;
            this.mTargets = targets;
            this.mCollator = collator;
            this.mRanker = ranker;
            this.mRankerServiceName = rankerServiceName;
            this.mAnnotationsUsed = annotationsUsed;
            this.mPmMap = pmMap;
        }

        @Override // com.android.internal.app.ResolverComparatorModel
        public Comparator<ResolveInfo> getComparator() {
            return new Comparator() { // from class: com.android.internal.app.ResolverRankerServiceResolverComparator$ResolverRankerServiceComparatorModel$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int lambda$getComparator$0;
                    lambda$getComparator$0 = ResolverRankerServiceResolverComparator.ResolverRankerServiceComparatorModel.this.lambda$getComparator$0((ResolveInfo) obj, (ResolveInfo) obj2);
                    return lambda$getComparator$0;
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ int lambda$getComparator$0(ResolveInfo lhs, ResolveInfo rhs) {
            int selectProbabilityDiff;
            ResolverTarget lhsTarget = getActivityResolverTargetForUser(lhs.activityInfo, lhs.userHandle);
            ResolverTarget rhsTarget = getActivityResolverTargetForUser(rhs.activityInfo, rhs.userHandle);
            if (lhsTarget != null && rhsTarget != null && (selectProbabilityDiff = Float.compare(rhsTarget.getSelectProbability(), lhsTarget.getSelectProbability())) != 0) {
                return selectProbabilityDiff > 0 ? 1 : -1;
            }
            CharSequence sa2 = null;
            if (this.mPmMap.containsKey(lhs.userHandle)) {
                sa2 = lhs.loadLabel(this.mPmMap.get(lhs.userHandle));
            }
            if (sa2 == null) {
                sa2 = lhs.activityInfo.name;
            }
            CharSequence sb2 = null;
            if (this.mPmMap.containsKey(rhs.userHandle)) {
                sb2 = rhs.loadLabel(this.mPmMap.get(rhs.userHandle));
            }
            if (sb2 == null) {
                sb2 = rhs.activityInfo.name;
            }
            return this.mCollator.compare(sa2.toString().trim(), sb2.toString().trim());
        }

        @Override // com.android.internal.app.ResolverComparatorModel
        public float getScore(TargetInfo targetInfo) {
            if (this.mTargetsDictPerUser.containsKey(targetInfo.getResolveInfo().userHandle) && this.mTargetsDictPerUser.get(targetInfo.getResolveInfo().userHandle).get(targetInfo.getResolvedComponentName()) != null) {
                return this.mTargetsDictPerUser.get(targetInfo.getResolveInfo().userHandle).get(targetInfo.getResolvedComponentName()).getSelectProbability();
            }
            return 0.0f;
        }

        @Override // com.android.internal.app.ResolverComparatorModel
        public void notifyOnTargetSelected(TargetInfo targetInfo) {
            if (this.mRanker != null) {
                int selectedPos = -1;
                try {
                    if (this.mTargetsDictPerUser.containsKey(targetInfo.getResolveInfo().userHandle)) {
                        selectedPos = new ArrayList(this.mTargetsDictPerUser.get(targetInfo.getResolveInfo().userHandle).h()).indexOf(targetInfo.getResolvedComponentName());
                    }
                    if (selectedPos >= 0 && this.mTargets != null) {
                        float selectedProbability = getScore(targetInfo);
                        int order = 0;
                        for (ResolverTarget target : this.mTargets) {
                            if (target.getSelectProbability() > selectedProbability) {
                                order++;
                            }
                        }
                        logMetrics(order);
                        this.mRanker.train(this.mTargets, selectedPos);
                    }
                } catch (RemoteException e2) {
                    Log.e(ResolverRankerServiceResolverComparator.TAG, "Error in Train: " + ((Object) e2));
                }
            }
        }

        private void logMetrics(int i10) {
            if (this.mRankerServiceName != null) {
                MetricsLogger metricsLogger = new MetricsLogger();
                LogMaker logMaker = new LogMaker(MetricsProto.MetricsEvent.ACTION_TARGET_SELECTED);
                logMaker.setComponentName(this.mRankerServiceName);
                logMaker.addTaggedData(MetricsProto.MetricsEvent.FIELD_IS_CATEGORY_USED, Integer.valueOf(this.mAnnotationsUsed ? 1 : 0));
                logMaker.addTaggedData(MetricsProto.MetricsEvent.FIELD_RANKED_POSITION, Integer.valueOf(i10));
                metricsLogger.write(logMaker);
            }
        }

        private ResolverTarget getActivityResolverTargetForUser(ActivityInfo activity, UserHandle user) {
            if (this.mStatsPerUser == null || !this.mTargetsDictPerUser.containsKey(user)) {
                return null;
            }
            return this.mTargetsDictPerUser.get(user).get(new ComponentName(activity.packageName, activity.name));
        }
    }
}
