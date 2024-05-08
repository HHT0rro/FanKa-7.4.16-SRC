package a1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import java.io.File;
import java.net.URL;
import java.util.List;

/* compiled from: GlideRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class h<TranscodeType> extends RequestBuilder<TranscodeType> {
    public h(@NonNull Class<TranscodeType> cls, @NonNull RequestBuilder<?> requestBuilder) {
        super(cls, requestBuilder);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public h<File> getDownloadOnlyRequest() {
        return new h(File.class, this).apply(RequestBuilder.DOWNLOAD_ONLY_OPTIONS);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> listener(@Nullable RequestListener<TranscodeType> requestListener) {
        return (h) super.listener(requestListener);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> load(@Nullable Bitmap bitmap) {
        return (h) super.load(bitmap);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> load(@Nullable Drawable drawable) {
        return (h) super.load(drawable);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> load(@Nullable Uri uri) {
        return (h) super.load(uri);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> load(@Nullable File file) {
        return (h) super.load(file);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> load(@Nullable @DrawableRes @RawRes Integer num) {
        return (h) super.load(num);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> load(@Nullable Object obj) {
        return (h) super.load(obj);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> load(@Nullable String str) {
        return (h) super.load(str);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @CheckResult
    @Deprecated
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> load(@Nullable URL url) {
        return (h) super.load(url);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> load(@Nullable byte[] bArr) {
        return (h) super.load(bArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> lock() {
        return (h) super.lock();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> onlyRetrieveFromCache(boolean z10) {
        return (h) super.onlyRetrieveFromCache(z10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> optionalCenterCrop() {
        return (h) super.optionalCenterCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> optionalCenterInside() {
        return (h) super.optionalCenterInside();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> optionalCircleCrop() {
        return (h) super.optionalCircleCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> optionalFitCenter() {
        return (h) super.optionalFitCenter();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> optionalTransform(@NonNull Transformation<Bitmap> transformation) {
        return (h) super.optionalTransform(transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public <Y> h<TranscodeType> optionalTransform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return (h) super.optionalTransform(cls, transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> override(int i10) {
        return (h) super.override(i10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> override(int i10, int i11) {
        return (h) super.override(i10, i11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> placeholder(@DrawableRes int i10) {
        return (h) super.placeholder(i10);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> addListener(@Nullable RequestListener<TranscodeType> requestListener) {
        return (h) super.addListener(requestListener);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> placeholder(@Nullable Drawable drawable) {
        return (h) super.placeholder(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> priority(@NonNull Priority priority) {
        return (h) super.priority(priority);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> apply(@NonNull BaseRequestOptions<?> baseRequestOptions) {
        return (h) super.apply(baseRequestOptions);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public <Y> h<TranscodeType> set(@NonNull Option<Y> option, @NonNull Y y10) {
        return (h) super.set(option, y10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> autoClone() {
        return (h) super.autoClone();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> signature(@NonNull Key key) {
        return (h) super.signature(key);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> centerCrop() {
        return (h) super.centerCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> sizeMultiplier(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return (h) super.sizeMultiplier(f10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> skipMemoryCache(boolean z10) {
        return (h) super.skipMemoryCache(z10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> centerInside() {
        return (h) super.centerInside();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> theme(@Nullable Resources.Theme theme) {
        return (h) super.theme(theme);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> circleCrop() {
        return (h) super.circleCrop();
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> thumbnail(float f10) {
        return (h) super.thumbnail(f10);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.request.BaseRequestOptions
    @CheckResult
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> mo0clone() {
        return (h) super.mo0clone();
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> thumbnail(@Nullable RequestBuilder<TranscodeType> requestBuilder) {
        return (h) super.thumbnail(requestBuilder);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> decode(@NonNull Class<?> cls) {
        return (h) super.decode(cls);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> thumbnail(@Nullable List<RequestBuilder<TranscodeType>> list) {
        return (h) super.thumbnail(list);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> disallowHardwareConfig() {
        return (h) super.disallowHardwareConfig();
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @SafeVarargs
    @CheckResult
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public final h<TranscodeType> thumbnail(@Nullable RequestBuilder<TranscodeType>... requestBuilderArr) {
        return (h) super.thumbnail(requestBuilderArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> diskCacheStrategy(@NonNull DiskCacheStrategy diskCacheStrategy) {
        return (h) super.diskCacheStrategy(diskCacheStrategy);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> timeout(@IntRange(from = 0) int i10) {
        return (h) super.timeout(i10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> dontAnimate() {
        return (h) super.dontAnimate();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> transform(@NonNull Transformation<Bitmap> transformation) {
        return (h) super.transform(transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> dontTransform() {
        return (h) super.dontTransform();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public <Y> h<TranscodeType> transform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return (h) super.transform(cls, transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> downsample(@NonNull DownsampleStrategy downsampleStrategy) {
        return (h) super.downsample(downsampleStrategy);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> transform(@NonNull Transformation<Bitmap>... transformationArr) {
        return (h) super.transform(transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> encodeFormat(@NonNull Bitmap.CompressFormat compressFormat) {
        return (h) super.encodeFormat(compressFormat);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    @Deprecated
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> transforms(@NonNull Transformation<Bitmap>... transformationArr) {
        return (h) super.transforms(transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> encodeQuality(@IntRange(from = 0, to = 100) int i10) {
        return (h) super.encodeQuality(i10);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> transition(@NonNull TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        return (h) super.transition(transitionOptions);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> error(@DrawableRes int i10) {
        return (h) super.error(i10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> useAnimationPool(boolean z10) {
        return (h) super.useAnimationPool(z10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> error(@Nullable Drawable drawable) {
        return (h) super.error(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> useUnlimitedSourceGeneratorsPool(boolean z10) {
        return (h) super.useUnlimitedSourceGeneratorsPool(z10);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> error(@Nullable RequestBuilder<TranscodeType> requestBuilder) {
        return (h) super.error((RequestBuilder) requestBuilder);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> error(Object obj) {
        return (h) super.error(obj);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> fallback(@DrawableRes int i10) {
        return (h) super.fallback(i10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> fallback(@Nullable Drawable drawable) {
        return (h) super.fallback(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> fitCenter() {
        return (h) super.fitCenter();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> format(@NonNull DecodeFormat decodeFormat) {
        return (h) super.format(decodeFormat);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> frame(@IntRange(from = 0) long j10) {
        return (h) super.frame(j10);
    }

    public h(@NonNull Glide glide, @NonNull RequestManager requestManager, @NonNull Class<TranscodeType> cls, @NonNull Context context) {
        super(glide, requestManager, cls, context);
    }
}
