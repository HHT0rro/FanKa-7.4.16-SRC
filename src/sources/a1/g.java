package a1;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;

/* compiled from: GlideOptions.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class g extends RequestOptions {
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public g optionalCenterInside() {
        return (g) super.optionalCenterInside();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public g optionalCircleCrop() {
        return (g) super.optionalCircleCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public g optionalFitCenter() {
        return (g) super.optionalFitCenter();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public g optionalTransform(@NonNull Transformation<Bitmap> transformation) {
        return (g) super.optionalTransform(transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public <Y> g optionalTransform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return (g) super.optionalTransform(cls, transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public g override(int i10) {
        return (g) super.override(i10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public g override(int i10, int i11) {
        return (g) super.override(i10, i11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public g placeholder(@DrawableRes int i10) {
        return (g) super.placeholder(i10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public g placeholder(@Nullable Drawable drawable) {
        return (g) super.placeholder(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public g priority(@NonNull Priority priority) {
        return (g) super.priority(priority);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public <Y> g set(@NonNull Option<Y> option, @NonNull Y y10) {
        return (g) super.set(option, y10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public g signature(@NonNull Key key) {
        return (g) super.signature(key);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public g sizeMultiplier(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return (g) super.sizeMultiplier(f10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public g skipMemoryCache(boolean z10) {
        return (g) super.skipMemoryCache(z10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public g theme(@Nullable Resources.Theme theme) {
        return (g) super.theme(theme);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public g timeout(@IntRange(from = 0) int i10) {
        return (g) super.timeout(i10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public g transform(@NonNull Transformation<Bitmap> transformation) {
        return (g) super.transform(transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public <Y> g transform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return (g) super.transform(cls, transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @SafeVarargs
    @CheckResult
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public final g transform(@NonNull Transformation<Bitmap>... transformationArr) {
        return (g) super.transform(transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @Deprecated
    @SafeVarargs
    @CheckResult
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public final g transforms(@NonNull Transformation<Bitmap>... transformationArr) {
        return (g) super.transforms(transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public g useAnimationPool(boolean z10) {
        return (g) super.useAnimationPool(z10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public g useUnlimitedSourceGeneratorsPool(boolean z10) {
        return (g) super.useUnlimitedSourceGeneratorsPool(z10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public g apply(@NonNull BaseRequestOptions<?> baseRequestOptions) {
        return (g) super.apply(baseRequestOptions);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g autoClone() {
        return (g) super.autoClone();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public g centerCrop() {
        return (g) super.centerCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public g centerInside() {
        return (g) super.centerInside();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public g circleCrop() {
        return (g) super.circleCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @CheckResult
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public g mo0clone() {
        return (g) super.mo0clone();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public g decode(@NonNull Class<?> cls) {
        return (g) super.decode(cls);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public g disallowHardwareConfig() {
        return (g) super.disallowHardwareConfig();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public g diskCacheStrategy(@NonNull DiskCacheStrategy diskCacheStrategy) {
        return (g) super.diskCacheStrategy(diskCacheStrategy);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public g dontAnimate() {
        return (g) super.dontAnimate();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public g dontTransform() {
        return (g) super.dontTransform();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public g downsample(@NonNull DownsampleStrategy downsampleStrategy) {
        return (g) super.downsample(downsampleStrategy);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public g encodeFormat(@NonNull Bitmap.CompressFormat compressFormat) {
        return (g) super.encodeFormat(compressFormat);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public g encodeQuality(@IntRange(from = 0, to = 100) int i10) {
        return (g) super.encodeQuality(i10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public g error(@DrawableRes int i10) {
        return (g) super.error(i10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public g error(@Nullable Drawable drawable) {
        return (g) super.error(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public g fallback(@DrawableRes int i10) {
        return (g) super.fallback(i10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public g fallback(@Nullable Drawable drawable) {
        return (g) super.fallback(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public g fitCenter() {
        return (g) super.fitCenter();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public g format(@NonNull DecodeFormat decodeFormat) {
        return (g) super.format(decodeFormat);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public g frame(@IntRange(from = 0) long j10) {
        return (g) super.frame(j10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public g lock() {
        return (g) super.lock();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public g onlyRetrieveFromCache(boolean z10) {
        return (g) super.onlyRetrieveFromCache(z10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public g optionalCenterCrop() {
        return (g) super.optionalCenterCrop();
    }
}
