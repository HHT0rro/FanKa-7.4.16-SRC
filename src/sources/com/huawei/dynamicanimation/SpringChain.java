package com.huawei.dynamicanimation;

import android.util.SparseArray;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class SpringChain extends PhysicalChain<SpringChain, HWSpringAnimation> {
    public static final int DEFAULT_DAMPING = 30;
    public static final int DEFAULT_STIFFNESS = 228;
    public static final float DEFAULT_TRANSFER_K = 0.18f;
    public float mControlDamping;
    public float mControlStiffness;
    public ParamsTransferImpl mDampingTransfer;
    public ParamsTransferImpl mStiffnessTransfer;
    public float mTransferDampingK;
    public float mTransferStiffnessK;

    public SpringChain(int i10) {
        super(i10);
        this.mControlStiffness = 228.0f;
        this.mControlDamping = 30.0f;
        this.mTransferStiffnessK = 0.18f;
        this.mTransferDampingK = 0.18f;
        this.mStiffnessTransfer = new ParamsTransferImpl(0.18f);
        this.mDampingTransfer = new ParamsTransferImpl(this.mTransferDampingK);
    }

    public static SpringChain create(int i10, float f10, float f11) {
        return create(i10).setControlStiffness(f10).setControlDamping(f11);
    }

    public SparseArray<HWSpringAnimation> getAllSpringAnimation() {
        return this.mModelList;
    }

    public float getControlDamping() {
        return this.mControlDamping;
    }

    public HWSpringAnimation getControlSpring() {
        int i10;
        if (this.mModelList.size() != 0 && (i10 = this.mControlModelIndex) >= 0 && i10 < this.mModelList.size()) {
            return (HWSpringAnimation) this.mModelList.get(this.mControlModelIndex);
        }
        return null;
    }

    public float getControlStiffness() {
        return this.mControlStiffness;
    }

    public float getTransferDampingK() {
        return this.mTransferDampingK;
    }

    public float getTransferStiffnessK() {
        return this.mTransferStiffnessK;
    }

    public SpringChain setControlDamping(float f10) {
        this.mControlDamping = diffMember(this.mControlDamping, f10);
        return this;
    }

    public SpringChain setControlSpringIndex(int i10) {
        super.setControlModelIndex(i10);
        return this;
    }

    public SpringChain setControlStiffness(float f10) {
        this.mControlStiffness = diffMember(this.mControlStiffness, f10);
        return this;
    }

    public SpringChain setTransferDampingK(float f10) {
        float diffMember = diffMember(this.mTransferDampingK, f10);
        this.mTransferDampingK = diffMember;
        this.mDampingTransfer.setK(diffMember);
        return this;
    }

    public SpringChain setTransferStiffnessK(float f10) {
        float diffMember = diffMember(this.mTransferStiffnessK, f10);
        this.mTransferStiffnessK = diffMember;
        this.mStiffnessTransfer.setK(diffMember);
        return this;
    }

    public static SpringChain create(int i10) {
        return new SpringChain(i10);
    }

    @Override // com.huawei.dynamicanimation.PhysicalChain
    public HWSpringAnimation createAnimationObj() {
        return new HWSpringAnimation(new FloatValueHolder(0.0f), this.mControlStiffness, this.mControlDamping, 1.0f, 0.0f);
    }

    @Override // com.huawei.dynamicanimation.PhysicalChain
    public void onChainTransfer(HWSpringAnimation hWSpringAnimation, float f10, float f11, int i10) {
        if (this.mModelList.indexOfValue(hWSpringAnimation) == this.mControlModelIndex || hWSpringAnimation == null) {
            return;
        }
        hWSpringAnimation.endToPosition(f10, f11);
    }

    @Override // com.huawei.dynamicanimation.PhysicalChain
    public void reConfig(HWSpringAnimation hWSpringAnimation, int i10) {
        if (hWSpringAnimation == null) {
            return;
        }
        hWSpringAnimation.getSpringModel().setStiffness(this.mStiffnessTransfer.transfer(Float.valueOf(getControlStiffness()), i10).floatValue()).setDamping(this.mDampingTransfer.transfer(Float.valueOf(getControlDamping()), i10).floatValue());
    }

    @Override // com.huawei.dynamicanimation.PhysicalChain
    public HWSpringAnimation reUseAnimationObj(HWSpringAnimation hWSpringAnimation) {
        return hWSpringAnimation.setObj(null, null, this.mControlStiffness, this.mControlDamping, 1.0f, 0.0f);
    }

    @Override // com.huawei.dynamicanimation.PhysicalChain
    public HWSpringAnimation resetAnimationObj(HWSpringAnimation hWSpringAnimation) {
        return hWSpringAnimation.reset();
    }
}
