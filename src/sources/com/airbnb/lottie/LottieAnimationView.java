package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class LottieAnimationView extends AppCompatImageView {

    /* renamed from: p, reason: collision with root package name */
    public static final String f1808p = LottieAnimationView.class.getSimpleName();

    /* renamed from: q, reason: collision with root package name */
    public static final f0<Throwable> f1809q = new f0() { // from class: com.airbnb.lottie.e
        @Override // com.airbnb.lottie.f0
        public final void onResult(Object obj) {
            LottieAnimationView.t((Throwable) obj);
        }
    };

    /* renamed from: b, reason: collision with root package name */
    public final f0<LottieComposition> f1810b;

    /* renamed from: c, reason: collision with root package name */
    public final f0<Throwable> f1811c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public f0<Throwable> f1812d;

    /* renamed from: e, reason: collision with root package name */
    @DrawableRes
    public int f1813e;

    /* renamed from: f, reason: collision with root package name */
    public final LottieDrawable f1814f;

    /* renamed from: g, reason: collision with root package name */
    public String f1815g;

    /* renamed from: h, reason: collision with root package name */
    @RawRes
    public int f1816h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1817i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1818j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1819k;

    /* renamed from: l, reason: collision with root package name */
    public final Set<UserActionTaken> f1820l;

    /* renamed from: m, reason: collision with root package name */
    public final Set<h0> f1821m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public k0<LottieComposition> f1822n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public LottieComposition f1823o;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: b, reason: collision with root package name */
        public String f1824b;

        /* renamed from: c, reason: collision with root package name */
        public int f1825c;

        /* renamed from: d, reason: collision with root package name */
        public float f1826d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f1827e;

        /* renamed from: f, reason: collision with root package name */
        public String f1828f;

        /* renamed from: g, reason: collision with root package name */
        public int f1829g;

        /* renamed from: h, reason: collision with root package name */
        public int f1830h;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f1824b);
            parcel.writeFloat(this.f1826d);
            parcel.writeInt(this.f1827e ? 1 : 0);
            parcel.writeString(this.f1828f);
            parcel.writeInt(this.f1829g);
            parcel.writeInt(this.f1830h);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1824b = parcel.readString();
            this.f1826d = parcel.readFloat();
            this.f1827e = parcel.readInt() == 1;
            this.f1828f = parcel.readString();
            this.f1829g = parcel.readInt();
            this.f1830h = parcel.readInt();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum UserActionTaken {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a implements f0<Throwable> {
        public a() {
        }

        @Override // com.airbnb.lottie.f0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th) {
            if (LottieAnimationView.this.f1813e != 0) {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.f1813e);
            }
            (LottieAnimationView.this.f1812d == null ? LottieAnimationView.f1809q : LottieAnimationView.this.f1812d).onResult(th);
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.f1810b = new f0() { // from class: com.airbnb.lottie.d
            @Override // com.airbnb.lottie.f0
            public final void onResult(Object obj) {
                LottieAnimationView.this.setComposition((LottieComposition) obj);
            }
        };
        this.f1811c = new a();
        this.f1813e = 0;
        this.f1814f = new LottieDrawable();
        this.f1817i = false;
        this.f1818j = false;
        this.f1819k = true;
        this.f1820l = new HashSet();
        this.f1821m = new HashSet();
        p(null, R$attr.lottieAnimationViewStyle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ LottieResult r(String str) throws Exception {
        return this.f1819k ? o.l(getContext(), str) : o.m(getContext(), str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ LottieResult s(int i10) throws Exception {
        return this.f1819k ? o.u(getContext(), i10) : o.v(getContext(), i10, null);
    }

    private void setCompositionTask(k0<LottieComposition> k0Var) {
        this.f1820l.add(UserActionTaken.SET_ANIMATION);
        l();
        k();
        this.f1822n = k0Var.d(this.f1810b).c(this.f1811c);
    }

    public static /* synthetic */ void t(Throwable th) {
        if (n.h.k(th)) {
            n.d.d("Unable to load composition.", th);
            return;
        }
        throw new IllegalStateException("Unable to parse composition", th);
    }

    public final void A(@FloatRange(from = 0.0d, to = 1.0d) float f10, boolean z10) {
        if (z10) {
            this.f1820l.add(UserActionTaken.SET_PROGRESS);
        }
        this.f1814f.Z0(f10);
    }

    @Nullable
    public Bitmap B(String str, @Nullable Bitmap bitmap) {
        return this.f1814f.i1(str, bitmap);
    }

    public void g(Animator.AnimatorListener animatorListener) {
        this.f1814f.r(animatorListener);
    }

    public boolean getClipToCompositionBounds() {
        return this.f1814f.I();
    }

    @Nullable
    public LottieComposition getComposition() {
        return this.f1823o;
    }

    public long getDuration() {
        if (this.f1823o != null) {
            return r0.d();
        }
        return 0L;
    }

    public int getFrame() {
        return this.f1814f.M();
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.f1814f.O();
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.f1814f.Q();
    }

    public float getMaxFrame() {
        return this.f1814f.R();
    }

    public float getMinFrame() {
        return this.f1814f.S();
    }

    @Nullable
    public m0 getPerformanceTracker() {
        return this.f1814f.T();
    }

    @FloatRange(from = ShadowDrawableWrapper.COS_45, to = 1.0d)
    public float getProgress() {
        return this.f1814f.U();
    }

    public RenderMode getRenderMode() {
        return this.f1814f.V();
    }

    public int getRepeatCount() {
        return this.f1814f.W();
    }

    public int getRepeatMode() {
        return this.f1814f.X();
    }

    public float getSpeed() {
        return this.f1814f.Y();
    }

    public void h(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f1814f.s(animatorUpdateListener);
    }

    public <T> void i(h.c cVar, T t2, o.c<T> cVar2) {
        this.f1814f.t(cVar, t2, cVar2);
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof LottieDrawable) && ((LottieDrawable) drawable).V() == RenderMode.SOFTWARE) {
            this.f1814f.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        LottieDrawable lottieDrawable = this.f1814f;
        if (drawable2 == lottieDrawable) {
            super.invalidateDrawable(lottieDrawable);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @MainThread
    public void j() {
        this.f1820l.add(UserActionTaken.PLAY_OPTION);
        this.f1814f.w();
    }

    public final void k() {
        k0<LottieComposition> k0Var = this.f1822n;
        if (k0Var != null) {
            k0Var.j(this.f1810b);
            this.f1822n.i(this.f1811c);
        }
    }

    public final void l() {
        this.f1823o = null;
        this.f1814f.x();
    }

    public void m(boolean z10) {
        this.f1814f.C(z10);
    }

    public final k0<LottieComposition> n(final String str) {
        if (isInEditMode()) {
            return new k0<>(new Callable() { // from class: com.airbnb.lottie.g
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    LottieResult r10;
                    r10 = LottieAnimationView.this.r(str);
                    return r10;
                }
            }, true);
        }
        return this.f1819k ? o.j(getContext(), str) : o.k(getContext(), str, null);
    }

    public final k0<LottieComposition> o(@RawRes final int i10) {
        if (isInEditMode()) {
            return new k0<>(new Callable() { // from class: com.airbnb.lottie.f
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    LottieResult s2;
                    s2 = LottieAnimationView.this.s(i10);
                    return s2;
                }
            }, true);
        }
        return this.f1819k ? o.s(getContext(), i10) : o.t(getContext(), i10, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode() || !this.f1818j) {
            return;
        }
        this.f1814f.v0();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i10;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f1815g = savedState.f1824b;
        Set<UserActionTaken> set = this.f1820l;
        UserActionTaken userActionTaken = UserActionTaken.SET_ANIMATION;
        if (!set.contains(userActionTaken) && !TextUtils.isEmpty(this.f1815g)) {
            setAnimation(this.f1815g);
        }
        this.f1816h = savedState.f1825c;
        if (!this.f1820l.contains(userActionTaken) && (i10 = this.f1816h) != 0) {
            setAnimation(i10);
        }
        if (!this.f1820l.contains(UserActionTaken.SET_PROGRESS)) {
            A(savedState.f1826d, false);
        }
        if (!this.f1820l.contains(UserActionTaken.PLAY_OPTION) && savedState.f1827e) {
            v();
        }
        if (!this.f1820l.contains(UserActionTaken.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(savedState.f1828f);
        }
        if (!this.f1820l.contains(UserActionTaken.SET_REPEAT_MODE)) {
            setRepeatMode(savedState.f1829g);
        }
        if (this.f1820l.contains(UserActionTaken.SET_REPEAT_COUNT)) {
            return;
        }
        setRepeatCount(savedState.f1830h);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1824b = this.f1815g;
        savedState.f1825c = this.f1816h;
        savedState.f1826d = this.f1814f.U();
        savedState.f1827e = this.f1814f.d0();
        savedState.f1828f = this.f1814f.O();
        savedState.f1829g = this.f1814f.X();
        savedState.f1830h = this.f1814f.W();
        return savedState;
    }

    public final void p(@Nullable AttributeSet attributeSet, @AttrRes int i10) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.LottieAnimationView, i10, 0);
        this.f1819k = obtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_cacheComposition, true);
        int i11 = R$styleable.LottieAnimationView_lottie_rawRes;
        boolean hasValue = obtainStyledAttributes.hasValue(i11);
        int i12 = R$styleable.LottieAnimationView_lottie_fileName;
        boolean hasValue2 = obtainStyledAttributes.hasValue(i12);
        int i13 = R$styleable.LottieAnimationView_lottie_url;
        boolean hasValue3 = obtainStyledAttributes.hasValue(i13);
        if (hasValue && hasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (hasValue) {
            int resourceId = obtainStyledAttributes.getResourceId(i11, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (hasValue2) {
            String string2 = obtainStyledAttributes.getString(i12);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (hasValue3 && (string = obtainStyledAttributes.getString(i13)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(obtainStyledAttributes.getResourceId(R$styleable.LottieAnimationView_lottie_fallbackRes, 0));
        if (obtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.f1818j = true;
        }
        if (obtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_loop, false)) {
            this.f1814f.b1(-1);
        }
        int i14 = R$styleable.LottieAnimationView_lottie_repeatMode;
        if (obtainStyledAttributes.hasValue(i14)) {
            setRepeatMode(obtainStyledAttributes.getInt(i14, 1));
        }
        int i15 = R$styleable.LottieAnimationView_lottie_repeatCount;
        if (obtainStyledAttributes.hasValue(i15)) {
            setRepeatCount(obtainStyledAttributes.getInt(i15, -1));
        }
        int i16 = R$styleable.LottieAnimationView_lottie_speed;
        if (obtainStyledAttributes.hasValue(i16)) {
            setSpeed(obtainStyledAttributes.getFloat(i16, 1.0f));
        }
        int i17 = R$styleable.LottieAnimationView_lottie_clipToCompositionBounds;
        if (obtainStyledAttributes.hasValue(i17)) {
            setClipToCompositionBounds(obtainStyledAttributes.getBoolean(i17, true));
        }
        int i18 = R$styleable.LottieAnimationView_lottie_defaultFontFileExtension;
        if (obtainStyledAttributes.hasValue(i18)) {
            setDefaultFontFileExtension(obtainStyledAttributes.getString(i18));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(R$styleable.LottieAnimationView_lottie_imageAssetsFolder));
        int i19 = R$styleable.LottieAnimationView_lottie_progress;
        A(obtainStyledAttributes.getFloat(i19, 0.0f), obtainStyledAttributes.hasValue(i19));
        m(obtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        int i20 = R$styleable.LottieAnimationView_lottie_colorFilter;
        if (obtainStyledAttributes.hasValue(i20)) {
            i(new h.c("**"), i0.K, new o.c(new n0(AppCompatResources.getColorStateList(getContext(), obtainStyledAttributes.getResourceId(i20, -1)).getDefaultColor())));
        }
        int i21 = R$styleable.LottieAnimationView_lottie_renderMode;
        if (obtainStyledAttributes.hasValue(i21)) {
            RenderMode renderMode = RenderMode.AUTOMATIC;
            int i22 = obtainStyledAttributes.getInt(i21, renderMode.ordinal());
            if (i22 >= RenderMode.values().length) {
                i22 = renderMode.ordinal();
            }
            setRenderMode(RenderMode.values()[i22]);
        }
        setIgnoreDisabledSystemAnimations(obtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_ignoreDisabledSystemAnimations, false));
        int i23 = R$styleable.LottieAnimationView_lottie_useCompositionFrameRate;
        if (obtainStyledAttributes.hasValue(i23)) {
            setUseCompositionFrameRate(obtainStyledAttributes.getBoolean(i23, false));
        }
        obtainStyledAttributes.recycle();
        this.f1814f.f1(Boolean.valueOf(n.h.f(getContext()) != 0.0f));
    }

    public boolean q() {
        return this.f1814f.c0();
    }

    public void setAnimation(@RawRes int i10) {
        this.f1816h = i10;
        this.f1815g = null;
        setCompositionTask(o(i10));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.f1819k ? o.w(getContext(), str) : o.x(getContext(), str, null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z10) {
        this.f1814f.C0(z10);
    }

    public void setCacheComposition(boolean z10) {
        this.f1819k = z10;
    }

    public void setClipToCompositionBounds(boolean z10) {
        this.f1814f.D0(z10);
    }

    public void setComposition(@NonNull LottieComposition lottieComposition) {
        if (c.f1878a) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Set Composition \n");
            sb2.append((Object) lottieComposition);
        }
        this.f1814f.setCallback(this);
        this.f1823o = lottieComposition;
        this.f1817i = true;
        boolean E0 = this.f1814f.E0(lottieComposition);
        this.f1817i = false;
        if (getDrawable() != this.f1814f || E0) {
            if (!E0) {
                z();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<h0> iterator2 = this.f1821m.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().a(lottieComposition);
            }
        }
    }

    public void setDefaultFontFileExtension(String str) {
        this.f1814f.F0(str);
    }

    public void setFailureListener(@Nullable f0<Throwable> f0Var) {
        this.f1812d = f0Var;
    }

    public void setFallbackResource(@DrawableRes int i10) {
        this.f1813e = i10;
    }

    public void setFontAssetDelegate(com.airbnb.lottie.a aVar) {
        this.f1814f.G0(aVar);
    }

    public void setFontMap(@Nullable Map<String, Typeface> map) {
        this.f1814f.H0(map);
    }

    public void setFrame(int i10) {
        this.f1814f.I0(i10);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z10) {
        this.f1814f.J0(z10);
    }

    public void setImageAssetDelegate(b bVar) {
        this.f1814f.K0(bVar);
    }

    public void setImageAssetsFolder(String str) {
        this.f1814f.L0(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        k();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        k();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i10) {
        k();
        super.setImageResource(i10);
    }

    public void setMaintainOriginalImageBounds(boolean z10) {
        this.f1814f.M0(z10);
    }

    public void setMaxFrame(int i10) {
        this.f1814f.N0(i10);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        this.f1814f.P0(f10);
    }

    public void setMinAndMaxFrame(String str) {
        this.f1814f.R0(str);
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f10, @FloatRange(from = 0.0d, to = 1.0d) float f11) {
        this.f1814f.T0(f10, f11);
    }

    public void setMinFrame(int i10) {
        this.f1814f.U0(i10);
    }

    public void setMinProgress(float f10) {
        this.f1814f.W0(f10);
    }

    public void setOutlineMasksAndMattes(boolean z10) {
        this.f1814f.X0(z10);
    }

    public void setPerformanceTrackingEnabled(boolean z10) {
        this.f1814f.Y0(z10);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        A(f10, true);
    }

    public void setRenderMode(RenderMode renderMode) {
        this.f1814f.a1(renderMode);
    }

    public void setRepeatCount(int i10) {
        this.f1820l.add(UserActionTaken.SET_REPEAT_COUNT);
        this.f1814f.b1(i10);
    }

    public void setRepeatMode(int i10) {
        this.f1820l.add(UserActionTaken.SET_REPEAT_MODE);
        this.f1814f.c1(i10);
    }

    public void setSafeMode(boolean z10) {
        this.f1814f.d1(z10);
    }

    public void setSpeed(float f10) {
        this.f1814f.e1(f10);
    }

    public void setTextDelegate(o0 o0Var) {
        this.f1814f.g1(o0Var);
    }

    public void setUseCompositionFrameRate(boolean z10) {
        this.f1814f.h1(z10);
    }

    @MainThread
    public void u() {
        this.f1818j = false;
        this.f1814f.u0();
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        LottieDrawable lottieDrawable;
        if (!this.f1817i && drawable == (lottieDrawable = this.f1814f) && lottieDrawable.c0()) {
            u();
        } else if (!this.f1817i && (drawable instanceof LottieDrawable)) {
            LottieDrawable lottieDrawable2 = (LottieDrawable) drawable;
            if (lottieDrawable2.c0()) {
                lottieDrawable2.u0();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    @MainThread
    public void v() {
        this.f1820l.add(UserActionTaken.PLAY_OPTION);
        this.f1814f.v0();
    }

    public void w() {
        this.f1814f.w0();
    }

    public void x() {
        this.f1814f.x0();
    }

    @MainThread
    public void y() {
        this.f1820l.add(UserActionTaken.PLAY_OPTION);
        this.f1814f.A0();
    }

    public final void z() {
        boolean q10 = q();
        setImageDrawable(null);
        setImageDrawable(this.f1814f);
        if (q10) {
            this.f1814f.A0();
        }
    }

    public void setAnimationFromJson(String str, @Nullable String str2) {
        setAnimation(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setMaxFrame(String str) {
        this.f1814f.O0(str);
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z10) {
        this.f1814f.S0(str, str2, z10);
    }

    public void setMinFrame(String str) {
        this.f1814f.V0(str);
    }

    public void setMinAndMaxFrame(int i10, int i11) {
        this.f1814f.Q0(i10, i11);
    }

    public void setAnimation(String str) {
        this.f1815g = str;
        this.f1816h = 0;
        setCompositionTask(n(str));
    }

    public void setAnimationFromUrl(String str, @Nullable String str2) {
        setCompositionTask(o.x(getContext(), str, str2));
    }

    public void setAnimation(InputStream inputStream, @Nullable String str) {
        setCompositionTask(o.n(inputStream, str));
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1810b = new f0() { // from class: com.airbnb.lottie.d
            @Override // com.airbnb.lottie.f0
            public final void onResult(Object obj) {
                LottieAnimationView.this.setComposition((LottieComposition) obj);
            }
        };
        this.f1811c = new a();
        this.f1813e = 0;
        this.f1814f = new LottieDrawable();
        this.f1817i = false;
        this.f1818j = false;
        this.f1819k = true;
        this.f1820l = new HashSet();
        this.f1821m = new HashSet();
        p(attributeSet, R$attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1810b = new f0() { // from class: com.airbnb.lottie.d
            @Override // com.airbnb.lottie.f0
            public final void onResult(Object obj) {
                LottieAnimationView.this.setComposition((LottieComposition) obj);
            }
        };
        this.f1811c = new a();
        this.f1813e = 0;
        this.f1814f = new LottieDrawable();
        this.f1817i = false;
        this.f1818j = false;
        this.f1819k = true;
        this.f1820l = new HashSet();
        this.f1821m = new HashSet();
        p(attributeSet, i10);
    }
}
