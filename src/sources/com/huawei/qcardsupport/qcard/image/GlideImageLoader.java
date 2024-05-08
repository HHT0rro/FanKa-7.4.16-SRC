package com.huawei.qcardsupport.qcard.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.services.imageloader.ImageLoader;
import com.huawei.flexiblelayout.services.imageloader.ImageOptions;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.qcardsupport.c;
import com.huawei.qcardsupport.e;
import com.huawei.quickcard.image.loader.GlideLoadUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class GlideImageLoader implements ImageLoader {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33232a = "GlideImageLoader";

    private void a(@NonNull String str, @NonNull ImageView imageView, @Nullable RequestOptions requestOptions) {
        try {
            RequestBuilder<Drawable> addListener = Glide.with(imageView).load(str).addListener(new c());
            if (requestOptions != null) {
                addListener.apply((BaseRequestOptions<?>) requestOptions).into(imageView);
            } else {
                addListener.into(imageView);
            }
        } catch (Exception e2) {
            Log.w(f33232a, "Exception when loading image.", e2);
        }
    }

    @Override // com.huawei.flexiblelayout.services.imageloader.ImageLoader
    public void load(@NonNull View view, @NonNull ImageOptions imageOptions) {
        e eVar;
        if (TextUtils.isEmpty(imageOptions.getUrl())) {
            Log.w(f33232a, "Empty image url for View.");
            return;
        }
        if (imageOptions instanceof e) {
            eVar = (e) imageOptions;
        } else {
            eVar = new e(imageOptions);
        }
        a(imageOptions.getUrl(), view, GlideLoadUtils.createGlideOptions(eVar.a()));
    }

    private void a(@NonNull String str, @NonNull View view, @Nullable RequestOptions requestOptions) {
        try {
            RequestBuilder<Drawable> addListener = Glide.with(view).load(str).addListener(new c());
            if (requestOptions != null) {
                addListener.apply((BaseRequestOptions<?>) requestOptions).into((RequestBuilder<Drawable>) a(view));
            } else {
                addListener.into((RequestBuilder<Drawable>) a(view));
            }
        } catch (Exception e2) {
            Log.w(f33232a, "Exception when loading image.", e2);
        }
    }

    @Override // com.huawei.flexiblelayout.services.imageloader.ImageLoader
    public void load(@NonNull ImageView imageView, @NonNull ImageOptions imageOptions) {
        e eVar;
        if (TextUtils.isEmpty(imageOptions.getUrl())) {
            Log.w(f33232a, "Empty image url for ImageView.");
            return;
        }
        if (imageOptions instanceof e) {
            eVar = (e) imageOptions;
        } else {
            eVar = new e(imageOptions);
        }
        GlideLoadUtils.applyFitMode(eVar.a(), imageView);
        a(imageOptions.getUrl(), imageView, GlideLoadUtils.createGlideOptions(eVar.a()));
    }

    private static CustomViewTarget<View, Drawable> a(@NonNull View view) {
        return new CustomViewTarget<View, Drawable>(view) { // from class: com.huawei.qcardsupport.qcard.image.GlideImageLoader.2
            @Override // com.bumptech.glide.request.target.Target
            public void onLoadFailed(@Nullable Drawable drawable) {
            }

            @Override // com.bumptech.glide.request.target.CustomViewTarget
            public void onResourceCleared(@Nullable Drawable drawable) {
            }

            @Override // com.bumptech.glide.request.target.Target
            public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object obj, Transition transition) {
                onResourceReady((Drawable) obj, (Transition<? super Drawable>) transition);
            }

            public void onResourceReady(@NonNull Drawable drawable, Transition<? super Drawable> transition) {
                this.view.setBackground(drawable);
            }
        };
    }

    @Override // com.huawei.flexiblelayout.services.imageloader.ImageLoader
    public Task<Drawable> load(@NonNull Context context, @NonNull ImageOptions imageOptions) {
        e eVar;
        if (TextUtils.isEmpty(imageOptions.getUrl())) {
            Log.w(f33232a, "load url is empty.");
            return Tasks.fromException(new Exception("load url is empty"));
        }
        if (imageOptions instanceof e) {
            eVar = (e) imageOptions;
        } else {
            eVar = new e(imageOptions);
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        RequestOptions createGlideOptions = GlideLoadUtils.createGlideOptions(eVar.a());
        RequestBuilder<Drawable> addListener = Glide.with(context).asDrawable().load(imageOptions.getUrl()).addListener(new c());
        if (createGlideOptions != null) {
            addListener.apply((BaseRequestOptions<?>) createGlideOptions);
        }
        addListener.into((RequestBuilder<Drawable>) new CustomTarget<Drawable>() { // from class: com.huawei.qcardsupport.qcard.image.GlideImageLoader.1
            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(@Nullable Drawable drawable) {
                taskCompletionSource.setResult(drawable);
            }

            @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
            public void onLoadFailed(@Nullable Drawable drawable) {
                taskCompletionSource.setException(new Exception("load failed"));
            }

            @Override // com.bumptech.glide.request.target.Target
            public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object obj, @Nullable Transition transition) {
                onResourceReady((Drawable) obj, (Transition<? super Drawable>) transition);
            }

            public void onResourceReady(@NonNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
                taskCompletionSource.setResult(drawable);
            }
        });
        return taskCompletionSource.getTask();
    }
}
