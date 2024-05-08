package com.android.internal.os;

import android.os.SystemClock;
import android.util.ArraySet;
import android.util.Log;
import android.util.SparseArray;
import com.android.internal.util.HeavyHitterSketch;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class BinderCallHeavyHitterWatcher {
    private static final float EPSILON = 1.0E-5f;
    private static final String TAG = "BinderCallHeavyHitterWatcher";
    private long mBatchStartTimeStamp;
    private HeavyHitterContainer[] mCachedCandidateContainers;
    private int mCachedCandidateContainersIndex;
    private int mCurrentInputSize;
    private boolean mEnabled;
    private HeavyHitterSketch<Integer> mHeavyHitterSketch;
    private int mInputSize;
    private BinderCallHeavyHitterListener mListener;
    private float mThreshold;
    private int mTotalInputSize;
    private static final Object sLock = new Object();
    private static BinderCallHeavyHitterWatcher sInstance = null;
    private final SparseArray<HeavyHitterContainer> mHeavyHitterCandiates = new SparseArray<>();
    private final ArrayList<Integer> mCachedCandidateList = new ArrayList<>();
    private final ArrayList<Float> mCachedCandidateFrequencies = new ArrayList<>();
    private ArraySet<Integer> mCachedCandidateSet = new ArraySet<>();
    private final Object mLock = new Object();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface BinderCallHeavyHitterListener {
        void onHeavyHit(List<HeavyHitterContainer> list, int i10, float f10, long j10);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class HeavyHitterContainer {
        public Class mClass;
        public int mCode;
        public float mFrequency;
        public int mUid;

        public HeavyHitterContainer() {
        }

        public HeavyHitterContainer(HeavyHitterContainer other) {
            this.mUid = other.mUid;
            this.mClass = other.mClass;
            this.mCode = other.mCode;
            this.mFrequency = other.mFrequency;
        }

        public boolean equals(Object other) {
            if (other == null || !(other instanceof HeavyHitterContainer)) {
                return false;
            }
            HeavyHitterContainer o10 = (HeavyHitterContainer) other;
            return this.mUid == o10.mUid && this.mClass == o10.mClass && this.mCode == o10.mCode && Math.abs(this.mFrequency - o10.mFrequency) < 1.0E-5f;
        }

        public int hashCode() {
            return hashCode(this.mUid, this.mClass, this.mCode);
        }

        static int hashCode(int uid, Class clazz, int code) {
            int hash = (uid * 31) + clazz.hashCode();
            return (hash * 31) + code;
        }
    }

    public static BinderCallHeavyHitterWatcher getInstance() {
        BinderCallHeavyHitterWatcher binderCallHeavyHitterWatcher;
        synchronized (sLock) {
            if (sInstance == null) {
                sInstance = new BinderCallHeavyHitterWatcher();
            }
            binderCallHeavyHitterWatcher = sInstance;
        }
        return binderCallHeavyHitterWatcher;
    }

    public void setConfig(boolean enable, int batchSize, float threshold, BinderCallHeavyHitterListener listener) {
        int inputSize;
        synchronized (this.mLock) {
            try {
                try {
                    if (enable) {
                        this.mEnabled = true;
                        if (threshold >= 1.0E-5f && threshold <= 1.0f) {
                            if (batchSize == this.mTotalInputSize && Math.abs(threshold - this.mThreshold) < 1.0E-5f) {
                                this.mListener = listener;
                                return;
                            }
                            int capacity = (int) (1.0f / threshold);
                            HeavyHitterSketch<Integer> sketch = HeavyHitterSketch.newDefault();
                            float validationRatio = sketch.getRequiredValidationInputRatio();
                            if (Float.isNaN(validationRatio)) {
                                inputSize = batchSize;
                            } else {
                                int inputSize2 = (int) (batchSize * (1.0f - validationRatio));
                                inputSize = inputSize2;
                            }
                            try {
                                sketch.setConfig(batchSize, capacity);
                                resetInternalLocked(listener, sketch, inputSize, batchSize, threshold, capacity);
                                return;
                            } catch (IllegalArgumentException e2) {
                                Log.w(TAG, "Invalid parameter to heavy hitter watcher: " + batchSize + ", " + capacity);
                                return;
                            }
                        }
                        return;
                    }
                    if (this.mEnabled) {
                        resetInternalLocked(null, null, 0, 0, 0.0f, 0);
                        this.mEnabled = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    private void resetInternalLocked(BinderCallHeavyHitterListener listener, HeavyHitterSketch<Integer> sketch, int inputSize, int batchSize, float threshold, int capacity) {
        this.mListener = listener;
        this.mHeavyHitterSketch = sketch;
        this.mHeavyHitterCandiates.clear();
        this.mCachedCandidateList.clear();
        this.mCachedCandidateFrequencies.clear();
        this.mCachedCandidateSet.clear();
        this.mInputSize = inputSize;
        this.mTotalInputSize = batchSize;
        this.mCurrentInputSize = 0;
        this.mThreshold = threshold;
        this.mBatchStartTimeStamp = SystemClock.elapsedRealtime();
        initCachedCandidateContainersLocked(capacity);
    }

    private void initCachedCandidateContainersLocked(int capacity) {
        if (capacity > 0) {
            this.mCachedCandidateContainers = new HeavyHitterContainer[capacity];
            int i10 = 0;
            while (true) {
                HeavyHitterContainer[] heavyHitterContainerArr = this.mCachedCandidateContainers;
                if (i10 >= heavyHitterContainerArr.length) {
                    break;
                }
                heavyHitterContainerArr[i10] = new HeavyHitterContainer();
                i10++;
            }
        } else {
            this.mCachedCandidateContainers = null;
        }
        this.mCachedCandidateContainersIndex = 0;
    }

    private HeavyHitterContainer acquireHeavyHitterContainerLocked() {
        HeavyHitterContainer[] heavyHitterContainerArr = this.mCachedCandidateContainers;
        int i10 = this.mCachedCandidateContainersIndex;
        this.mCachedCandidateContainersIndex = i10 + 1;
        return heavyHitterContainerArr[i10];
    }

    private void releaseHeavyHitterContainerLocked(HeavyHitterContainer container) {
        HeavyHitterContainer[] heavyHitterContainerArr = this.mCachedCandidateContainers;
        int i10 = this.mCachedCandidateContainersIndex - 1;
        this.mCachedCandidateContainersIndex = i10;
        heavyHitterContainerArr[i10] = container;
    }

    public void onTransaction(int callerUid, Class clazz, int code) {
        List<Integer> result;
        int size;
        synchronized (this.mLock) {
            try {
                try {
                    if (this.mEnabled) {
                        HeavyHitterSketch<Integer> sketch = this.mHeavyHitterSketch;
                        if (sketch == null) {
                            return;
                        }
                        int hashCode = HeavyHitterContainer.hashCode(callerUid, clazz, code);
                        sketch.add(Integer.valueOf(hashCode));
                        int i10 = this.mCurrentInputSize + 1;
                        this.mCurrentInputSize = i10;
                        int i11 = this.mInputSize;
                        if (i10 == i11) {
                            sketch.getCandidates(this.mCachedCandidateList);
                            this.mCachedCandidateSet.addAll(this.mCachedCandidateList);
                            this.mCachedCandidateList.clear();
                        } else {
                            if (i10 > i11) {
                                try {
                                    if (i10 < this.mTotalInputSize) {
                                        if (this.mCachedCandidateSet.contains(Integer.valueOf(hashCode))) {
                                            int index = this.mHeavyHitterCandiates.indexOfKey(hashCode);
                                            if (index < 0) {
                                                HeavyHitterContainer container = acquireHeavyHitterContainerLocked();
                                                container.mUid = callerUid;
                                                try {
                                                    container.mClass = clazz;
                                                    container.mCode = code;
                                                    this.mHeavyHitterCandiates.put(hashCode, container);
                                                } catch (Throwable th) {
                                                    th = th;
                                                    throw th;
                                                }
                                            }
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    throw th;
                                }
                            }
                            if (i10 == this.mTotalInputSize) {
                                if (this.mListener != null && (result = sketch.getTopHeavyHitters(0, this.mCachedCandidateList, this.mCachedCandidateFrequencies)) != null && (size = result.size()) > 0) {
                                    ArrayList<HeavyHitterContainer> hitters = new ArrayList<>();
                                    for (int i12 = 0; i12 < size; i12++) {
                                        HeavyHitterContainer container2 = this.mHeavyHitterCandiates.get(result.get(i12).intValue());
                                        if (container2 != null) {
                                            HeavyHitterContainer cont = new HeavyHitterContainer(container2);
                                            cont.mFrequency = this.mCachedCandidateFrequencies.get(i12).floatValue();
                                            hitters.add(cont);
                                        }
                                    }
                                    this.mListener.onHeavyHit(hitters, this.mTotalInputSize, this.mThreshold, SystemClock.elapsedRealtime() - this.mBatchStartTimeStamp);
                                }
                                this.mHeavyHitterSketch.reset();
                                this.mHeavyHitterCandiates.clear();
                                this.mCachedCandidateList.clear();
                                this.mCachedCandidateFrequencies.clear();
                                this.mCachedCandidateSet.clear();
                                this.mCachedCandidateContainersIndex = 0;
                                this.mCurrentInputSize = 0;
                                this.mBatchStartTimeStamp = SystemClock.elapsedRealtime();
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }
}
