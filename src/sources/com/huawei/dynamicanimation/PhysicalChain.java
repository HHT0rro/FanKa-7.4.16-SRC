package com.huawei.dynamicanimation;

import android.util.SparseArray;
import android.view.Choreographer;
import com.huawei.dynamicanimation.DynamicAnimation;
import com.huawei.dynamicanimation.PhysicalChain;
import com.huawei.dynamicanimation.util.SimplePound;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class PhysicalChain<K extends PhysicalChain, T extends DynamicAnimation> implements DynamicAnimation.OnAnimationUpdateListener, DynamicAnimation.OnAnimationStartListener {
    public static final int DEFAULT_CHAIN_SIZE = 16;
    public static final int INVALID_INDEX = -1;
    public static final int SIZE_MULTIPLE = 2;
    public static final String TAG = "PhysicalChain";
    public SimplePound<T> mAnimationObjPools;
    public SimplePound<PhysicalChain<K, T>.ChainTransferCallback> mCallbackPools;
    public int mMaxChainSize;
    public SparseArray<T> mModelList = new SparseArray<>();
    public int mControlModelIndex = Integer.MIN_VALUE;
    public AtomicBoolean mIsDirty = new AtomicBoolean(true);
    public boolean mIsDelayed = true;
    public long mDelay = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class ChainTransferCallback implements Choreographer.FrameCallback {
        public int index;
        public T obj;
        public float value;
        public float velocity;

        public ChainTransferCallback() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j10) {
            PhysicalChain.this.onChainTransfer(this.obj, this.value, this.velocity, this.index);
            PhysicalChain.this.mCallbackPools.restoreInstance(this);
        }

        public int getIndex() {
            return this.index;
        }

        public PhysicalChain<K, T>.ChainTransferCallback setIndex(int i10) {
            this.index = i10;
            return this;
        }

        public PhysicalChain<K, T>.ChainTransferCallback setModelValue(float f10) {
            return this;
        }

        public PhysicalChain<K, T>.ChainTransferCallback setObj(T t2) {
            this.obj = t2;
            return this;
        }

        public PhysicalChain<K, T>.ChainTransferCallback setValue(float f10) {
            this.value = f10;
            return this;
        }

        public PhysicalChain<K, T>.ChainTransferCallback setVelocity(float f10) {
            this.velocity = f10;
            return this;
        }
    }

    public PhysicalChain(int i10) {
        if (this.mMaxChainSize < 0) {
            this.mMaxChainSize = 16;
        }
        this.mMaxChainSize = i10;
        this.mCallbackPools = new SimplePound<>(i10 * 2);
        this.mAnimationObjPools = new SimplePound<>(i10);
    }

    private boolean isIndexValid(int i10) {
        return this.mModelList.indexOfKey(i10) >= 0;
    }

    private void onTransfer(T t2, float f10, float f11, int i10) {
        if (!this.mIsDelayed) {
            onChainTransfer(t2, f10, f11, i10);
            return;
        }
        PhysicalChain<K, T>.ChainTransferCallback simplePound = this.mCallbackPools.getInstance();
        if (simplePound == null) {
            simplePound = new ChainTransferCallback();
        }
        if (this.mDelay <= 0) {
            Choreographer.getInstance().postFrameCallback(simplePound.setObj(t2).setValue(f10).setVelocity(f11).setIndex(i10));
        } else {
            Choreographer.getInstance().postFrameCallbackDelayed(simplePound.setObj(t2).setValue(f10).setVelocity(f11).setIndex(i10), this.mDelay);
        }
    }

    public K addObject(ChainListener chainListener) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("addObject: listener=");
        sb2.append((Object) chainListener);
        return addObject(-1, chainListener);
    }

    public void cancel() {
        if (isIndexValid(getControlModelIndex())) {
            getModelList().valueAt(getControlModelIndex()).cancel();
        }
    }

    public abstract T createAnimationObj();

    public ParamTransfer diffMember(ParamTransfer paramTransfer, ParamTransfer paramTransfer2) {
        if (paramTransfer == paramTransfer2) {
            return paramTransfer;
        }
        if (paramTransfer != null && paramTransfer.equals(paramTransfer2)) {
            return paramTransfer;
        }
        this.mIsDirty.compareAndSet(false, true);
        return paramTransfer2;
    }

    public int getChainSize() {
        return this.mMaxChainSize;
    }

    public int getControlModelIndex() {
        return this.mControlModelIndex;
    }

    public long getDelay() {
        return this.mDelay;
    }

    public SparseArray<T> getModelList() {
        return this.mModelList;
    }

    public boolean isDelayed() {
        return this.mIsDelayed;
    }

    @Override // com.huawei.dynamicanimation.DynamicAnimation.OnAnimationStartListener
    public void onAnimationStart(DynamicAnimation dynamicAnimation, float f10, float f11) {
        if (this.mModelList.size() > 0 && this.mIsDirty.compareAndSet(true, false)) {
            reParamsTransfer();
        }
    }

    @Override // com.huawei.dynamicanimation.DynamicAnimation.OnAnimationUpdateListener
    public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f10, float f11) {
        int i10;
        int i11;
        int indexOfValue = this.mModelList.indexOfValue(dynamicAnimation);
        int indexOfKey = this.mModelList.indexOfKey(this.mControlModelIndex);
        if (indexOfValue == indexOfKey) {
            i11 = indexOfValue - 1;
            i10 = indexOfValue + 1;
        } else if (indexOfValue < indexOfKey) {
            i11 = indexOfValue - 1;
            i10 = -1;
        } else {
            i10 = indexOfValue + 1;
            i11 = -1;
        }
        if (i10 > -1 && i10 < this.mModelList.size()) {
            onTransfer(this.mModelList.valueAt(i10), f10, f11, i10);
        }
        if (i11 <= -1 || i11 >= this.mModelList.size()) {
            return;
        }
        onTransfer(this.mModelList.valueAt(i11), f10, f11, i11);
    }

    public abstract void onChainTransfer(T t2, float f10, float f11, int i10);

    public void reConfig() {
    }

    public abstract void reConfig(T t2, int i10);

    public void reParamsTransfer() {
        reConfig(this.mModelList.get(this.mControlModelIndex), 0);
        int indexOfKey = this.mModelList.indexOfKey(this.mControlModelIndex);
        int size = this.mModelList.size();
        int i10 = indexOfKey;
        while (true) {
            i10++;
            if (i10 >= size) {
                break;
            }
            reConfig(this.mModelList.valueAt(i10), i10 - indexOfKey);
        }
        int i11 = indexOfKey;
        while (true) {
            i11--;
            if (i11 < 0) {
                return;
            }
            reConfig(this.mModelList.valueAt(i11), indexOfKey - i11);
        }
    }

    public abstract T reUseAnimationObj(T t2);

    public PhysicalChain removeObject(int i10) {
        if (!isIndexValid(i10)) {
            return this;
        }
        int indexOfKey = this.mModelList.indexOfKey(i10);
        T valueAt = this.mModelList.valueAt(indexOfKey);
        this.mModelList.removeAt(indexOfKey);
        this.mAnimationObjPools.restoreInstance(valueAt);
        return this;
    }

    public abstract T resetAnimationObj(T t2);

    public K setChainSize(int i10) {
        this.mMaxChainSize = i10;
        return this;
    }

    public K setControlModelIndex(int i10) {
        int i11;
        if (!isIndexValid(i10) || (i11 = this.mControlModelIndex) == i10) {
            return this;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.mModelList.get(i11).removeStartListener(this);
        }
        this.mControlModelIndex = i10;
        this.mModelList.get(i10).addStartListener(this);
        this.mIsDirty.set(true);
        return this;
    }

    public K setDelay(long j10) {
        this.mDelay = j10;
        return this;
    }

    public K setDelayed(boolean z10) {
        this.mIsDelayed = z10;
        return this;
    }

    public K addObject(int i10, ChainListener chainListener) {
        if (this.mModelList.size() > this.mMaxChainSize - 1) {
            T valueAt = this.mModelList.valueAt(0);
            this.mModelList.removeAt(0);
            resetAnimationObj(valueAt);
            this.mAnimationObjPools.restoreInstance(valueAt);
        }
        T simplePound = this.mAnimationObjPools.getInstance();
        if (simplePound == null) {
            simplePound = createAnimationObj();
        } else {
            reUseAnimationObj(simplePound);
        }
        simplePound.addUpdateListener(chainListener).addUpdateListener(this);
        if (i10 < 0) {
            i10 = this.mModelList.size();
        }
        this.mModelList.append(i10, simplePound);
        reConfig(simplePound, Math.abs(this.mModelList.indexOfKey(i10) - this.mModelList.indexOfKey(this.mControlModelIndex)));
        return this;
    }

    public float diffMember(float f10, float f11) {
        if (Float.compare(f10, f11) == 0) {
            return f10;
        }
        this.mIsDirty.compareAndSet(false, true);
        return f11;
    }
}
