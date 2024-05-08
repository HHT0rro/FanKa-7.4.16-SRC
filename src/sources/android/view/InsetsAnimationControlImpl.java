package android.view;

import android.content.res.CompatibilityInfo;
import android.graphics.Insets;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.ArraySet;
import android.util.EventLog;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.SparseSetArray;
import android.util.proto.ProtoOutputStream;
import android.view.SyncRtSurfaceTransactionApplier;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.animation.Interpolator;
import android.view.inputmethod.ImeTracker;
import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Consumer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class InsetsAnimationControlImpl implements InternalInsetsAnimationController, InsetsAnimationControlRunner {
    private static final int OPLUS_NAV_GESTURE_BAR_HEIGHT = 54;
    private static final String TAG = "InsetsAnimationCtrlImpl";
    private final WindowInsetsAnimation mAnimation;
    private final int mAnimationType;
    private boolean mCancelled;
    private final InsetsAnimationControlCallbacks mController;
    private int mControllingTypes;
    private final SparseArray<InsetsSourceControl> mControls;
    private float mCurrentAlpha;
    private Insets mCurrentInsets;
    private boolean mFinished;
    private final boolean mHasZeroInsetsIme;
    private final Insets mHiddenInsets;
    private final InsetsState mInitialInsetsState;
    private final int mLayoutInsetsDuringAnimation;
    private final WindowInsetsAnimationControlListener mListener;
    private float mPendingAlpha;
    private float mPendingFraction;
    private Insets mPendingInsets;
    private Boolean mPerceptible;
    private boolean mReadyDispatched;
    private final Insets mShownInsets;
    private boolean mShownOnFinish;
    private final SparseSetArray<InsetsSourceControl> mSideControlsMap;
    private final ImeTracker.Token mStatsToken;
    private final Rect mTmpFrame = new Rect();
    private final Matrix mTmpMatrix;
    private final CompatibilityInfo.Translator mTranslator;
    private final int mTypes;

    public InsetsAnimationControlImpl(SparseArray<InsetsSourceControl> controls, Rect frame, InsetsState state, WindowInsetsAnimationControlListener listener, int types, InsetsAnimationControlCallbacks controller, long durationMs, Interpolator interpolator, int animationType, int layoutInsetsDuringAnimation, CompatibilityInfo.Translator translator, ImeTracker.Token statsToken) {
        char c4;
        SparseIntArray idSideMap;
        SparseSetArray<InsetsSourceControl> sparseSetArray = new SparseSetArray<>();
        this.mSideControlsMap = sparseSetArray;
        this.mTmpMatrix = new Matrix();
        this.mCurrentAlpha = 1.0f;
        this.mPendingAlpha = 1.0f;
        this.mControls = controls;
        this.mListener = listener;
        this.mTypes = types;
        this.mControllingTypes = types;
        this.mController = controller;
        InsetsState insetsState = new InsetsState(state, true);
        this.mInitialInsetsState = insetsState;
        if (frame == null) {
            this.mCurrentInsets = calculateInsets(insetsState, controls, true);
            c4 = 0;
            this.mHiddenInsets = calculateInsets(null, controls, false);
            Insets calculateInsets = calculateInsets(null, controls, true);
            this.mShownInsets = calculateInsets;
            this.mHasZeroInsetsIme = calculateInsets.bottom == 0 && controlsType(WindowInsets.Type.ime());
            buildSideControlsMap(sparseSetArray, controls);
        } else {
            SparseIntArray idSideMap2 = new SparseIntArray();
            this.mCurrentInsets = getInsetsFromState(insetsState, frame, null);
            this.mHiddenInsets = calculateInsets(insetsState, frame, controls, false, null);
            Insets calculateInsets2 = calculateInsets(insetsState, frame, controls, true, idSideMap2);
            this.mShownInsets = calculateInsets2;
            boolean z10 = calculateInsets2.bottom == 0 && controlsType(WindowInsets.Type.ime());
            this.mHasZeroInsetsIme = z10;
            if (z10) {
                idSideMap = idSideMap2;
                idSideMap.put(InsetsSource.ID_IME, 3);
            } else {
                idSideMap = idSideMap2;
            }
            buildSideControlsMap(idSideMap, sparseSetArray, controls);
            c4 = 0;
        }
        this.mPendingInsets = this.mCurrentInsets;
        WindowInsetsAnimation windowInsetsAnimation = new WindowInsetsAnimation(types, interpolator, durationMs);
        this.mAnimation = windowInsetsAnimation;
        windowInsetsAnimation.setAlpha(getCurrentAlpha());
        this.mAnimationType = animationType;
        this.mLayoutInsetsDuringAnimation = layoutInsetsDuringAnimation;
        this.mTranslator = translator;
        this.mStatsToken = statsToken;
        if (ImeTracker.DEBUG_IME_VISIBILITY && (types & WindowInsets.Type.ime()) != 0) {
            Object[] objArr = new Object[6];
            objArr[c4] = statsToken != null ? statsToken.getTag() : ImeTracker.TOKEN_NONE;
            objArr[1] = Integer.valueOf(animationType);
            objArr[2] = Float.valueOf(this.mCurrentAlpha);
            objArr[3] = "Current:" + ((Object) this.mCurrentInsets);
            objArr[4] = "Shown:" + ((Object) this.mShownInsets);
            objArr[5] = "Hidden:" + ((Object) this.mHiddenInsets);
            EventLog.writeEvent(EventLogTags.IMF_IME_ANIM_START, objArr);
        }
        controller.startAnimation(this, listener, types, windowInsetsAnimation, new WindowInsetsAnimation.Bounds(this.mHiddenInsets, this.mShownInsets));
    }

    private boolean calculatePerceptible(Insets currentInsets, float currentAlpha) {
        return currentInsets.left * 100 >= (this.mShownInsets.left - this.mHiddenInsets.left) * 5 && currentInsets.top * 100 >= (this.mShownInsets.top - this.mHiddenInsets.top) * 5 && currentInsets.right * 100 >= (this.mShownInsets.right - this.mHiddenInsets.right) * 5 && currentInsets.bottom * 100 >= (this.mShownInsets.bottom - this.mHiddenInsets.bottom) * 5 && currentAlpha >= 0.5f;
    }

    @Override // android.view.WindowInsetsAnimationController
    public boolean hasZeroInsetsIme() {
        return this.mHasZeroInsetsIme;
    }

    @Override // android.view.InternalInsetsAnimationController
    public void setReadyDispatched(boolean dispatched) {
        this.mReadyDispatched = dispatched;
    }

    @Override // android.view.WindowInsetsAnimationController
    public Insets getHiddenStateInsets() {
        return this.mHiddenInsets;
    }

    @Override // android.view.WindowInsetsAnimationController
    public Insets getShownStateInsets() {
        return this.mShownInsets;
    }

    @Override // android.view.WindowInsetsAnimationController
    public Insets getCurrentInsets() {
        return this.mCurrentInsets;
    }

    @Override // android.view.WindowInsetsAnimationController
    public float getCurrentAlpha() {
        return this.mCurrentAlpha;
    }

    @Override // android.view.WindowInsetsAnimationController, android.view.InsetsAnimationControlRunner
    public int getTypes() {
        return this.mTypes;
    }

    @Override // android.view.InsetsAnimationControlRunner
    public int getControllingTypes() {
        return this.mControllingTypes;
    }

    @Override // android.view.InsetsAnimationControlRunner
    public void notifyControlRevoked(int types) {
        this.mControllingTypes &= ~types;
    }

    @Override // android.view.InsetsAnimationControlRunner
    public void updateSurfacePosition(SparseArray<InsetsSourceControl> controls) {
        for (int i10 = controls.size() - 1; i10 >= 0; i10--) {
            InsetsSourceControl control = controls.valueAt(i10);
            InsetsSourceControl c4 = this.mControls.get(control.getId());
            if (c4 != null) {
                Point position = control.getSurfacePosition();
                c4.setSurfacePosition(position.x, position.y);
            }
        }
    }

    @Override // android.view.InsetsAnimationControlRunner
    public int getAnimationType() {
        return this.mAnimationType;
    }

    @Override // android.view.InsetsAnimationControlRunner
    public ImeTracker.Token getStatsToken() {
        return this.mStatsToken;
    }

    @Override // android.view.WindowInsetsAnimationController
    public void setInsetsAndAlpha(Insets insets, float alpha, float fraction) {
        setInsetsAndAlpha(insets, alpha, fraction, false);
    }

    private void setInsetsAndAlpha(Insets insets, float alpha, float fraction, boolean allowWhenFinished) {
        if (!allowWhenFinished && this.mFinished) {
            throw new IllegalStateException("Can't change insets on an animation that is finished.");
        }
        if (this.mCancelled) {
            throw new IllegalStateException("Can't change insets on an animation that is cancelled.");
        }
        this.mPendingFraction = sanitize(fraction);
        this.mPendingInsets = sanitize(insets);
        this.mPendingAlpha = sanitize(alpha);
        this.mController.scheduleApplyChangeInsets(this);
        boolean perceptible = calculatePerceptible(this.mPendingInsets, this.mPendingAlpha);
        Boolean bool = this.mPerceptible;
        if (bool == null || perceptible != bool.booleanValue()) {
            this.mController.reportPerceptible(this.mTypes, perceptible);
            this.mPerceptible = Boolean.valueOf(perceptible);
        }
    }

    @Override // android.view.InternalInsetsAnimationController
    public boolean applyChangeInsets(InsetsState outState) {
        if (this.mCancelled) {
            if (InsetsController.DEBUG) {
                Log.d(TAG, "applyChangeInsets canceled");
                return false;
            }
            return false;
        }
        Insets offset = Insets.subtract(this.mShownInsets, this.mPendingInsets);
        if (InsetsController.DEBUG_PANIC && this.mTypes == 2) {
            Log.d(TAG, "applyChangeInsets, mShownInsets: " + ((Object) this.mShownInsets) + ", mPendingInsets: " + ((Object) this.mPendingInsets) + ", offset: " + ((Object) offset) + ", mTypes: " + this.mTypes);
        }
        ArrayList<SyncRtSurfaceTransactionApplier.SurfaceParams> params = new ArrayList<>();
        updateLeashesForSide(0, offset.left, this.mPendingInsets.left, params, outState, this.mPendingAlpha);
        updateLeashesForSide(1, offset.top, this.mPendingInsets.top, params, outState, this.mPendingAlpha);
        updateLeashesForSide(2, offset.right, this.mPendingInsets.right, params, outState, this.mPendingAlpha);
        updateLeashesForSide(3, offset.bottom, this.mPendingInsets.bottom, params, outState, this.mPendingAlpha);
        this.mController.applySurfaceParams((SyncRtSurfaceTransactionApplier.SurfaceParams[]) params.toArray(new SyncRtSurfaceTransactionApplier.SurfaceParams[params.size()]));
        this.mCurrentInsets = this.mPendingInsets;
        this.mAnimation.setFraction(this.mPendingFraction);
        float f10 = this.mPendingAlpha;
        this.mCurrentAlpha = f10;
        this.mAnimation.setAlpha(f10);
        if (this.mFinished) {
            if (InsetsController.DEBUG) {
                Log.d(TAG, String.format("notifyFinished shown: %s, currentAlpha: %f, currentInsets: %s", Boolean.valueOf(this.mShownOnFinish), Float.valueOf(this.mCurrentAlpha), this.mCurrentInsets));
            }
            this.mController.notifyFinished(this, this.mShownOnFinish);
            releaseLeashes();
            if (InsetsController.DEBUG) {
                Log.d(TAG, "Animation finished abruptly.");
            }
        }
        return this.mFinished;
    }

    private void releaseLeashes() {
        for (int i10 = this.mControls.size() - 1; i10 >= 0; i10--) {
            InsetsSourceControl c4 = this.mControls.valueAt(i10);
            if (c4 != null) {
                final InsetsAnimationControlCallbacks insetsAnimationControlCallbacks = this.mController;
                Objects.requireNonNull(insetsAnimationControlCallbacks);
                c4.release(new Consumer() { // from class: android.view.InsetsAnimationControlImpl$$ExternalSyntheticLambda0
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        InsetsAnimationControlCallbacks.this.releaseSurfaceControlFromRt((SurfaceControl) obj);
                    }
                });
            }
        }
    }

    @Override // android.view.WindowInsetsAnimationController
    public void finish(boolean z10) {
        if (this.mCancelled || this.mFinished) {
            if (InsetsController.DEBUG) {
                Log.d(TAG, "Animation already canceled or finished, not notifying.");
                return;
            }
            return;
        }
        this.mShownOnFinish = z10;
        this.mFinished = true;
        Insets insets = z10 ? this.mShownInsets : this.mHiddenInsets;
        setInsetsAndAlpha(insets, this.mPendingAlpha, 1.0f, true);
        if (InsetsController.DEBUG) {
            Log.d(TAG, "notify control request finished for types: " + this.mTypes);
        }
        this.mListener.onFinished(this);
        if (ImeTracker.DEBUG_IME_VISIBILITY && (this.mTypes & WindowInsets.Type.ime()) != 0) {
            Object[] objArr = new Object[5];
            ImeTracker.Token token = this.mStatsToken;
            objArr[0] = token != null ? token.getTag() : ImeTracker.TOKEN_NONE;
            objArr[1] = Integer.valueOf(this.mAnimationType);
            objArr[2] = Float.valueOf(this.mCurrentAlpha);
            objArr[3] = Integer.valueOf(z10 ? 1 : 0);
            objArr[4] = Objects.toString(insets);
            EventLog.writeEvent(EventLogTags.IMF_IME_ANIM_FINISH, objArr);
        }
    }

    @Override // android.view.WindowInsetsAnimationController
    public float getCurrentFraction() {
        return this.mAnimation.getFraction();
    }

    @Override // android.view.InsetsAnimationControlRunner
    public void cancel() {
        if (this.mFinished) {
            return;
        }
        this.mPendingInsets = this.mLayoutInsetsDuringAnimation == 0 ? this.mShownInsets : this.mHiddenInsets;
        this.mPendingAlpha = 1.0f;
        applyChangeInsets(null);
        this.mCancelled = true;
        this.mListener.onCancelled(this.mReadyDispatched ? this : null);
        if (InsetsController.DEBUG) {
            Log.d(TAG, "notify Control request cancelled for types: " + this.mTypes);
        }
        if (ImeTracker.DEBUG_IME_VISIBILITY && (this.mTypes & WindowInsets.Type.ime()) != 0) {
            Object[] objArr = new Object[3];
            ImeTracker.Token token = this.mStatsToken;
            objArr[0] = token != null ? token.getTag() : ImeTracker.TOKEN_NONE;
            objArr[1] = Integer.valueOf(this.mAnimationType);
            objArr[2] = Objects.toString(this.mPendingInsets);
            EventLog.writeEvent(EventLogTags.IMF_IME_ANIM_CANCEL, objArr);
        }
        releaseLeashes();
    }

    @Override // android.view.WindowInsetsAnimationController
    public boolean isFinished() {
        return this.mFinished;
    }

    @Override // android.view.WindowInsetsAnimationController
    public boolean isCancelled() {
        return this.mCancelled;
    }

    @Override // android.view.InsetsAnimationControlRunner
    public WindowInsetsAnimation getAnimation() {
        return this.mAnimation;
    }

    @Override // android.view.InsetsAnimationControlRunner
    public void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        proto.write(1133871366145L, this.mCancelled);
        proto.write(1133871366146L, this.mFinished);
        proto.write(1138166333443L, Objects.toString(this.mTmpMatrix));
        proto.write(1138166333444L, Objects.toString(this.mPendingInsets));
        proto.write(InsetsAnimationControlImplProto.PENDING_FRACTION, this.mPendingFraction);
        proto.write(1133871366150L, this.mShownOnFinish);
        proto.write(1108101562375L, this.mCurrentAlpha);
        proto.write(InsetsAnimationControlImplProto.PENDING_ALPHA, this.mPendingAlpha);
        proto.end(token);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SparseArray<InsetsSourceControl> getControls() {
        return this.mControls;
    }

    private Insets getInsetsFromState(InsetsState state, Rect frame, SparseIntArray idSideMap) {
        return state.calculateInsets(frame, null, false, false, 16, 0, 0, 2, 0, idSideMap).getInsets(this.mTypes);
    }

    private Insets calculateInsets(InsetsState state, Rect frame, SparseArray<InsetsSourceControl> controls, boolean shown, SparseIntArray idSideMap) {
        for (int i10 = controls.size() - 1; i10 >= 0; i10--) {
            InsetsSourceControl control = controls.valueAt(i10);
            if (control != null) {
                state.setSourceVisible(control.getId(), shown);
            }
        }
        return getInsetsFromState(state, frame, idSideMap);
    }

    private Insets calculateInsets(InsetsState state, SparseArray<InsetsSourceControl> controls, boolean shownOrCurrent) {
        Insets insets = Insets.NONE;
        if (!shownOrCurrent) {
            return insets;
        }
        for (int i10 = controls.size() - 1; i10 >= 0; i10--) {
            InsetsSourceControl control = controls.valueAt(i10);
            if (control != null && (state == null || state.isSourceOrDefaultVisible(control.getId(), control.getType()))) {
                insets = Insets.max(insets, control.getInsetsHint());
                if (control.getType() == WindowInsets.Type.navigationBars() && insets.equals(Insets.NONE)) {
                    insets = Insets.of(0, 0, 0, 54);
                }
            }
        }
        return insets;
    }

    private Insets sanitize(Insets insets) {
        if (insets == null) {
            insets = getCurrentInsets();
        }
        if (hasZeroInsetsIme()) {
            return insets;
        }
        return Insets.max(Insets.min(insets, this.mShownInsets), this.mHiddenInsets);
    }

    private static float sanitize(float alpha) {
        if (alpha >= 1.0f) {
            return 1.0f;
        }
        if (alpha <= 0.0f) {
            return 0.0f;
        }
        return alpha;
    }

    private void updateLeashesForSide(int side, int offset, int inset, ArrayList<SyncRtSurfaceTransactionApplier.SurfaceParams> surfaceParams, InsetsState outState, float alpha) {
        ArraySet<InsetsSourceControl> controls = this.mSideControlsMap.get(side);
        if (controls == null) {
            return;
        }
        for (int i10 = controls.size() - 1; i10 >= 0; i10--) {
            InsetsSourceControl control = controls.valueAt(i10);
            InsetsSource source = this.mInitialInsetsState.peekSource(control.getId());
            SurfaceControl leash = control.getLeash();
            this.mTmpMatrix.setTranslate(control.getSurfacePosition().x, control.getSurfacePosition().y);
            if (source != null) {
                this.mTmpFrame.set(source.getFrame());
            }
            addTranslationToMatrix(side, offset, this.mTmpMatrix, this.mTmpFrame);
            boolean z10 = false;
            if (this.mHasZeroInsetsIme && side == 3) {
                if (this.mAnimationType == 0 || !this.mFinished) {
                    z10 = true;
                }
            } else if (inset != 0) {
                z10 = true;
            }
            boolean visible = z10;
            if (outState != null && source != null) {
                outState.addSource(new InsetsSource(source).setVisible(visible).setFrame(this.mTmpFrame));
            }
            if (InsetsController.DEBUG_PANIC && this.mTypes == 2) {
                Log.d(TAG, "updateLeashesForSide, side: " + side + ", mTmpMatrix: " + ((Object) this.mTmpMatrix) + ", the control: " + control.toString() + ", the source: " + (source != null ? source.toString() : null));
            }
            if (leash != null) {
                SyncRtSurfaceTransactionApplier.SurfaceParams params = new SyncRtSurfaceTransactionApplier.SurfaceParams.Builder(leash).withAlpha(alpha).withMatrix(this.mTmpMatrix).withVisibility(visible).build();
                surfaceParams.add(params);
            }
        }
    }

    private void addTranslationToMatrix(int side, int offset, Matrix m10, Rect frame) {
        CompatibilityInfo.Translator translator = this.mTranslator;
        float surfaceOffset = translator != null ? translator.translateLengthInAppWindowToScreen(offset) : offset;
        switch (side) {
            case 0:
                m10.postTranslate(-surfaceOffset, 0.0f);
                frame.offset(-offset, 0);
                return;
            case 1:
                m10.postTranslate(0.0f, -surfaceOffset);
                frame.offset(0, -offset);
                return;
            case 2:
                m10.postTranslate(surfaceOffset, 0.0f);
                frame.offset(offset, 0);
                return;
            case 3:
                m10.postTranslate(0.0f, surfaceOffset);
                frame.offset(0, offset);
                return;
            default:
                return;
        }
    }

    private static void buildSideControlsMap(SparseIntArray idSideMap, SparseSetArray<InsetsSourceControl> sideControlsMap, SparseArray<InsetsSourceControl> controls) {
        for (int i10 = idSideMap.size() - 1; i10 >= 0; i10--) {
            int type = idSideMap.keyAt(i10);
            int side = idSideMap.valueAt(i10);
            InsetsSourceControl control = controls.get(type);
            if (control != null) {
                sideControlsMap.add(side, control);
            }
        }
    }

    private static void buildSideControlsMap(SparseSetArray<InsetsSourceControl> sideControlsMap, SparseArray<InsetsSourceControl> controls) {
        for (int i10 = controls.size() - 1; i10 >= 0; i10--) {
            InsetsSourceControl control = controls.valueAt(i10);
            if (control != null) {
                Insets insets = control.getInsetsHint();
                if (control.getType() == WindowInsets.Type.navigationBars() && insets.equals(Insets.NONE)) {
                    insets = Insets.of(0, 0, 0, 54);
                }
                int side = InsetsState.getInsetSide(insets);
                if (side == 4 && control.getType() == WindowInsets.Type.ime()) {
                    side = 3;
                }
                sideControlsMap.add(side, control);
            }
        }
    }
}
