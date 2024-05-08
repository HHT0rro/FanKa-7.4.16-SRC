package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;
import java.util.ArrayList;
import java.util.List;

@DoNotStrip
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class YogaNode {

    /* renamed from: a, reason: collision with root package name */
    public YogaNode f19190a;

    /* renamed from: b, reason: collision with root package name */
    public List<YogaNode> f19191b;

    /* renamed from: c, reason: collision with root package name */
    public YogaMeasureFunction f19192c;

    /* renamed from: d, reason: collision with root package name */
    public YogaBaselineFunction f19193d;

    /* renamed from: e, reason: collision with root package name */
    public long f19194e;

    /* renamed from: f, reason: collision with root package name */
    public Object f19195f;

    @DoNotStrip
    private int mEdgeSetFlag = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f19196g = false;

    @DoNotStrip
    private float mWidth = Float.NaN;

    @DoNotStrip
    private float mHeight = Float.NaN;

    @DoNotStrip
    private float mTop = Float.NaN;

    @DoNotStrip
    private float mLeft = Float.NaN;

    @DoNotStrip
    private float mMarginLeft = 0.0f;

    @DoNotStrip
    private float mMarginTop = 0.0f;

    @DoNotStrip
    private float mMarginRight = 0.0f;

    @DoNotStrip
    private float mMarginBottom = 0.0f;

    @DoNotStrip
    private float mPaddingLeft = 0.0f;

    @DoNotStrip
    private float mPaddingTop = 0.0f;

    @DoNotStrip
    private float mPaddingRight = 0.0f;

    @DoNotStrip
    private float mPaddingBottom = 0.0f;

    @DoNotStrip
    private float mBorderLeft = 0.0f;

    @DoNotStrip
    private float mBorderTop = 0.0f;

    @DoNotStrip
    private float mBorderRight = 0.0f;

    @DoNotStrip
    private float mBorderBottom = 0.0f;

    @DoNotStrip
    private int mLayoutDirection = 0;

    @DoNotStrip
    private boolean mHasNewLayout = true;

    /* renamed from: com.facebook.yoga.YogaNode$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19197a;

        static {
            int[] iArr = new int[YogaEdge.values().length];
            f19197a = iArr;
            try {
                iArr[YogaEdge.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19197a[YogaEdge.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19197a[YogaEdge.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19197a[YogaEdge.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f19197a[YogaEdge.START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f19197a[YogaEdge.END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static {
        SoLoader.loadLibrary("yoga");
    }

    public YogaNode() {
        long jni_YGNodeNew = jni_YGNodeNew();
        this.f19194e = jni_YGNodeNew;
        if (jni_YGNodeNew == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
    }

    private native void jni_YGNodeCalculateLayout(long j10, float f10, float f11);

    private native void jni_YGNodeCopyStyle(long j10, long j11);

    private native void jni_YGNodeFree(long j10);

    public static native int jni_YGNodeGetInstanceCount();

    private native void jni_YGNodeInsertChild(long j10, long j11, int i10);

    private native boolean jni_YGNodeIsDirty(long j10);

    private native void jni_YGNodeMarkDirty(long j10);

    private native long jni_YGNodeNew();

    private native long jni_YGNodeNewWithConfig(long j10);

    private native void jni_YGNodePrint(long j10);

    private native void jni_YGNodeRemoveChild(long j10, long j11);

    private native void jni_YGNodeReset(long j10);

    private native void jni_YGNodeSetHasBaselineFunc(long j10, boolean z10);

    private native void jni_YGNodeSetHasMeasureFunc(long j10, boolean z10);

    private native int jni_YGNodeStyleGetAlignContent(long j10);

    private native int jni_YGNodeStyleGetAlignItems(long j10);

    private native int jni_YGNodeStyleGetAlignSelf(long j10);

    private native float jni_YGNodeStyleGetAspectRatio(long j10);

    private native float jni_YGNodeStyleGetBorder(long j10, int i10);

    private native int jni_YGNodeStyleGetDirection(long j10);

    private native int jni_YGNodeStyleGetDisplay(long j10);

    private native Object jni_YGNodeStyleGetFlexBasis(long j10);

    private native int jni_YGNodeStyleGetFlexDirection(long j10);

    private native float jni_YGNodeStyleGetFlexGrow(long j10);

    private native float jni_YGNodeStyleGetFlexShrink(long j10);

    private native Object jni_YGNodeStyleGetHeight(long j10);

    private native int jni_YGNodeStyleGetJustifyContent(long j10);

    private native Object jni_YGNodeStyleGetMargin(long j10, int i10);

    private native Object jni_YGNodeStyleGetMaxHeight(long j10);

    private native Object jni_YGNodeStyleGetMaxWidth(long j10);

    private native Object jni_YGNodeStyleGetMinHeight(long j10);

    private native Object jni_YGNodeStyleGetMinWidth(long j10);

    private native int jni_YGNodeStyleGetOverflow(long j10);

    private native Object jni_YGNodeStyleGetPadding(long j10, int i10);

    private native Object jni_YGNodeStyleGetPosition(long j10, int i10);

    private native int jni_YGNodeStyleGetPositionType(long j10);

    private native Object jni_YGNodeStyleGetWidth(long j10);

    private native void jni_YGNodeStyleSetAlignContent(long j10, int i10);

    private native void jni_YGNodeStyleSetAlignItems(long j10, int i10);

    private native void jni_YGNodeStyleSetAlignSelf(long j10, int i10);

    private native void jni_YGNodeStyleSetAspectRatio(long j10, float f10);

    private native void jni_YGNodeStyleSetBorder(long j10, int i10, float f10);

    private native void jni_YGNodeStyleSetDirection(long j10, int i10);

    private native void jni_YGNodeStyleSetDisplay(long j10, int i10);

    private native void jni_YGNodeStyleSetFlex(long j10, float f10);

    private native void jni_YGNodeStyleSetFlexBasis(long j10, float f10);

    private native void jni_YGNodeStyleSetFlexBasisAuto(long j10);

    private native void jni_YGNodeStyleSetFlexBasisPercent(long j10, float f10);

    private native void jni_YGNodeStyleSetFlexDirection(long j10, int i10);

    private native void jni_YGNodeStyleSetFlexGrow(long j10, float f10);

    private native void jni_YGNodeStyleSetFlexShrink(long j10, float f10);

    private native void jni_YGNodeStyleSetFlexWrap(long j10, int i10);

    private native void jni_YGNodeStyleSetHeight(long j10, float f10);

    private native void jni_YGNodeStyleSetHeightAuto(long j10);

    private native void jni_YGNodeStyleSetHeightPercent(long j10, float f10);

    private native void jni_YGNodeStyleSetJustifyContent(long j10, int i10);

    private native void jni_YGNodeStyleSetMargin(long j10, int i10, float f10);

    private native void jni_YGNodeStyleSetMarginAuto(long j10, int i10);

    private native void jni_YGNodeStyleSetMarginPercent(long j10, int i10, float f10);

    private native void jni_YGNodeStyleSetMaxHeight(long j10, float f10);

    private native void jni_YGNodeStyleSetMaxHeightPercent(long j10, float f10);

    private native void jni_YGNodeStyleSetMaxWidth(long j10, float f10);

    private native void jni_YGNodeStyleSetMaxWidthPercent(long j10, float f10);

    private native void jni_YGNodeStyleSetMinHeight(long j10, float f10);

    private native void jni_YGNodeStyleSetMinHeightPercent(long j10, float f10);

    private native void jni_YGNodeStyleSetMinWidth(long j10, float f10);

    private native void jni_YGNodeStyleSetMinWidthPercent(long j10, float f10);

    private native void jni_YGNodeStyleSetOverflow(long j10, int i10);

    private native void jni_YGNodeStyleSetPadding(long j10, int i10, float f10);

    private native void jni_YGNodeStyleSetPaddingPercent(long j10, int i10, float f10);

    private native void jni_YGNodeStyleSetPosition(long j10, int i10, float f10);

    private native void jni_YGNodeStyleSetPositionPercent(long j10, int i10, float f10);

    private native void jni_YGNodeStyleSetPositionType(long j10, int i10);

    private native void jni_YGNodeStyleSetWidth(long j10, float f10);

    private native void jni_YGNodeStyleSetWidthAuto(long j10);

    private native void jni_YGNodeStyleSetWidthPercent(long j10, float f10);

    public void A(YogaDisplay yogaDisplay) {
        jni_YGNodeStyleSetDisplay(this.f19194e, yogaDisplay.intValue());
    }

    public void B(float f10) {
        jni_YGNodeStyleSetFlexBasis(this.f19194e, f10);
    }

    public void C(YogaFlexDirection yogaFlexDirection) {
        jni_YGNodeStyleSetFlexDirection(this.f19194e, yogaFlexDirection.intValue());
    }

    public void D(float f10) {
        jni_YGNodeStyleSetFlexGrow(this.f19194e, f10);
    }

    public void E(float f10) {
        jni_YGNodeStyleSetFlexShrink(this.f19194e, f10);
    }

    public void F(float f10) {
        jni_YGNodeStyleSetHeight(this.f19194e, f10);
    }

    public void G() {
        jni_YGNodeStyleSetHeightAuto(this.f19194e);
    }

    public void H(float f10) {
        jni_YGNodeStyleSetHeightPercent(this.f19194e, f10);
    }

    public void I(YogaJustify yogaJustify) {
        jni_YGNodeStyleSetJustifyContent(this.f19194e, yogaJustify.intValue());
    }

    public void J(YogaEdge yogaEdge, float f10) {
        this.mEdgeSetFlag |= 1;
        jni_YGNodeStyleSetMargin(this.f19194e, yogaEdge.intValue(), f10);
    }

    public void K(float f10) {
        jni_YGNodeStyleSetMaxHeight(this.f19194e, f10);
    }

    public void L(float f10) {
        jni_YGNodeStyleSetMaxHeightPercent(this.f19194e, f10);
    }

    public void M(float f10) {
        jni_YGNodeStyleSetMaxWidth(this.f19194e, f10);
    }

    public void N(float f10) {
        jni_YGNodeStyleSetMaxWidthPercent(this.f19194e, f10);
    }

    public void O(YogaMeasureFunction yogaMeasureFunction) {
        this.f19192c = yogaMeasureFunction;
        jni_YGNodeSetHasMeasureFunc(this.f19194e, yogaMeasureFunction != null);
    }

    public void P(float f10) {
        jni_YGNodeStyleSetMinHeight(this.f19194e, f10);
    }

    public void Q(float f10) {
        jni_YGNodeStyleSetMinHeightPercent(this.f19194e, f10);
    }

    public void R(float f10) {
        jni_YGNodeStyleSetMinWidth(this.f19194e, f10);
    }

    public void S(float f10) {
        jni_YGNodeStyleSetMinWidthPercent(this.f19194e, f10);
    }

    public void T(YogaEdge yogaEdge, float f10) {
        this.mEdgeSetFlag |= 2;
        jni_YGNodeStyleSetPadding(this.f19194e, yogaEdge.intValue(), f10);
    }

    public void U(YogaEdge yogaEdge, float f10) {
        this.f19196g = true;
        jni_YGNodeStyleSetPosition(this.f19194e, yogaEdge.intValue(), f10);
    }

    public void V(YogaPositionType yogaPositionType) {
        jni_YGNodeStyleSetPositionType(this.f19194e, yogaPositionType.intValue());
    }

    public void W(float f10) {
        jni_YGNodeStyleSetWidth(this.f19194e, f10);
    }

    public void X() {
        jni_YGNodeStyleSetWidthAuto(this.f19194e);
    }

    public void Y(float f10) {
        jni_YGNodeStyleSetWidthPercent(this.f19194e, f10);
    }

    public void Z(YogaWrap yogaWrap) {
        jni_YGNodeStyleSetFlexWrap(this.f19194e, yogaWrap.intValue());
    }

    public void a(YogaNode yogaNode, int i10) {
        if (yogaNode.f19190a == null) {
            if (this.f19191b == null) {
                this.f19191b = new ArrayList(4);
            }
            this.f19191b.add(i10, yogaNode);
            yogaNode.f19190a = this;
            jni_YGNodeInsertChild(this.f19194e, yogaNode.f19194e, i10);
            return;
        }
        throw new IllegalStateException("Child already has a parent, it must be removed first.");
    }

    public void b(float f10, float f11) {
        jni_YGNodeCalculateLayout(this.f19194e, f10, f11);
    }

    @DoNotStrip
    public final float baseline(float f10, float f11) {
        return this.f19193d.baseline(this, f10, f11);
    }

    public void c() {
        jni_YGNodeMarkDirty(this.f19194e);
    }

    public YogaAlign d() {
        return YogaAlign.fromInt(jni_YGNodeStyleGetAlignItems(this.f19194e));
    }

    public YogaNode e(int i10) {
        return this.f19191b.get(i10);
    }

    public int f() {
        List<YogaNode> list = this.f19191b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void finalize() throws Throwable {
        try {
            jni_YGNodeFree(this.f19194e);
        } finally {
            super.finalize();
        }
    }

    public Object g() {
        return this.f19195f;
    }

    public YogaFlexDirection h() {
        return YogaFlexDirection.fromInt(jni_YGNodeStyleGetFlexDirection(this.f19194e));
    }

    public float i() {
        return jni_YGNodeStyleGetFlexGrow(this.f19194e);
    }

    public YogaValue j() {
        return (YogaValue) jni_YGNodeStyleGetHeight(this.f19194e);
    }

    public float k() {
        return this.mHeight;
    }

    public float l() {
        return this.mWidth;
    }

    public float m() {
        return this.mLeft;
    }

    @DoNotStrip
    public final long measure(float f10, int i10, float f11, int i11) {
        if (r()) {
            return this.f19192c.measure(this, f10, YogaMeasureMode.fromInt(i10), f11, YogaMeasureMode.fromInt(i11));
        }
        throw new RuntimeException("Measure function isn't defined!");
    }

    public float n() {
        return this.mTop;
    }

    public YogaNode o() {
        return this.f19190a;
    }

    public YogaValue p(YogaEdge yogaEdge) {
        if (!this.f19196g) {
            return YogaValue.f19198c;
        }
        return (YogaValue) jni_YGNodeStyleGetPosition(this.f19194e, yogaEdge.intValue());
    }

    public YogaValue q() {
        return (YogaValue) jni_YGNodeStyleGetWidth(this.f19194e);
    }

    public boolean r() {
        return this.f19192c != null;
    }

    public YogaNode s(int i10) {
        YogaNode remove = this.f19191b.remove(i10);
        remove.f19190a = null;
        jni_YGNodeRemoveChild(this.f19194e, remove.f19194e);
        return remove;
    }

    public void t(YogaAlign yogaAlign) {
        jni_YGNodeStyleSetAlignContent(this.f19194e, yogaAlign.intValue());
    }

    public void u(YogaAlign yogaAlign) {
        jni_YGNodeStyleSetAlignItems(this.f19194e, yogaAlign.intValue());
    }

    public void v(YogaAlign yogaAlign) {
        jni_YGNodeStyleSetAlignSelf(this.f19194e, yogaAlign.intValue());
    }

    public void w(float f10) {
        jni_YGNodeStyleSetAspectRatio(this.f19194e, f10);
    }

    public void x(YogaEdge yogaEdge, float f10) {
        this.mEdgeSetFlag |= 4;
        jni_YGNodeStyleSetBorder(this.f19194e, yogaEdge.intValue(), f10);
    }

    public void y(Object obj) {
        this.f19195f = obj;
    }

    public void z(YogaDirection yogaDirection) {
        jni_YGNodeStyleSetDirection(this.f19194e, yogaDirection.intValue());
    }
}
