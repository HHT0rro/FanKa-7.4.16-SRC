package a1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import java.io.File;
import java.net.URL;

/* compiled from: GlideRequests.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class i extends RequestManager {
    public i(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
        super(glide, lifecycle, requestManagerTreeNode, context);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public i addDefaultRequestListener(RequestListener<Object> requestListener) {
        return (i) super.addDefaultRequestListener(requestListener);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public synchronized i applyDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        return (i) super.applyDefaultRequestOptions(requestOptions);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public <ResourceType> h<ResourceType> as(@NonNull Class<ResourceType> cls) {
        return new h<>(this.glide, this, cls, this.context);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public h<Bitmap> asBitmap() {
        return (h) super.asBitmap();
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public h<Drawable> asDrawable() {
        return (h) super.asDrawable();
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public h<File> asFile() {
        return (h) super.asFile();
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public h<GifDrawable> asGif() {
        return (h) super.asGif();
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public h<File> download(@Nullable Object obj) {
        return (h) super.download(obj);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public h<File> downloadOnly() {
        return (h) super.downloadOnly();
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public h<Drawable> load(@Nullable Bitmap bitmap) {
        return (h) super.load(bitmap);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public h<Drawable> load(@Nullable Drawable drawable) {
        return (h) super.load(drawable);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public h<Drawable> load(@Nullable Uri uri) {
        return (h) super.load(uri);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public h<Drawable> load(@Nullable File file) {
        return (h) super.load(file);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public h<Drawable> load(@Nullable @DrawableRes @RawRes Integer num) {
        return (h) super.load(num);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public h<Drawable> load(@Nullable Object obj) {
        return (h) super.load(obj);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public h<Drawable> load(@Nullable String str) {
        return (h) super.load(str);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @CheckResult
    @Deprecated
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public h<Drawable> load(@Nullable URL url) {
        return (h) super.load(url);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public h<Drawable> load(@Nullable byte[] bArr) {
        return (h) super.load(bArr);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public synchronized i setDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        return (i) super.setDefaultRequestOptions(requestOptions);
    }

    @Override // com.bumptech.glide.RequestManager
    public void setRequestOptions(@NonNull RequestOptions requestOptions) {
        if (requestOptions instanceof g) {
            super.setRequestOptions(requestOptions);
        } else {
            super.setRequestOptions(new g().apply(requestOptions));
        }
    }
}
