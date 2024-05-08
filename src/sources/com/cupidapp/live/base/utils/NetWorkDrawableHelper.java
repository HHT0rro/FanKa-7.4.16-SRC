package com.cupidapp.live.base.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.network.model.ImageModel;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: NetWorkDrawableHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class NetWorkDrawableHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final NetWorkDrawableHelper f12282a = new NetWorkDrawableHelper();

    public static final List e(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    public static /* synthetic */ Flowable g(NetWorkDrawableHelper netWorkDrawableHelper, Context context, List list, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        return netWorkDrawableHelper.f(context, list, z10);
    }

    public static final List h(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    public static /* synthetic */ Drawable j(NetWorkDrawableHelper netWorkDrawableHelper, Context context, ImageSizeModel imageSizeModel, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        return netWorkDrawableHelper.i(context, imageSizeModel, z10);
    }

    @NotNull
    public final Flowable<List<com.cupidapp.live.base.view.a>> d(@NotNull final Context context, @NotNull List<? extends ImageSizeModel> imageList) {
        kotlin.jvm.internal.s.i(context, "context");
        kotlin.jvm.internal.s.i(imageList, "imageList");
        Flowable subscribeOn = Flowable.just(imageList).onBackpressureLatest().subscribeOn(Schedulers.io());
        final Function1<List<? extends ImageSizeModel>, List<? extends com.cupidapp.live.base.view.a>> function1 = new Function1<List<? extends ImageSizeModel>, List<? extends com.cupidapp.live.base.view.a>>() { // from class: com.cupidapp.live.base.utils.NetWorkDrawableHelper$fetchDrawableFromNetWork$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final List<com.cupidapp.live.base.view.a> invoke(@NotNull List<? extends ImageSizeModel> it) {
                com.cupidapp.live.base.view.a aVar;
                kotlin.jvm.internal.s.i(it, "it");
                Context context2 = context;
                ArrayList arrayList = new ArrayList(kotlin.collections.t.t(it, 10));
                for (ImageSizeModel imageSizeModel : it) {
                    if (imageSizeModel instanceof LocalImageModel) {
                        aVar = new com.cupidapp.live.base.view.a(context2, ((LocalImageModel) imageSizeModel).getResource());
                    } else {
                        Drawable j10 = NetWorkDrawableHelper.j(NetWorkDrawableHelper.f12282a, context2, imageSizeModel, false, 4, null);
                        aVar = j10 != null ? new com.cupidapp.live.base.view.a(j10) : null;
                    }
                    arrayList.add(aVar);
                }
                return arrayList;
            }
        };
        Flowable<List<com.cupidapp.live.base.view.a>> map = subscribeOn.map(new Function() { // from class: com.cupidapp.live.base.utils.f0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List e2;
                e2 = NetWorkDrawableHelper.e(Function1.this, obj);
                return e2;
            }
        });
        kotlin.jvm.internal.s.h(map, "context: Context,\n      …          }\n            }");
        return map;
    }

    @NotNull
    public final Flowable<List<Drawable>> f(@NotNull final Context context, @NotNull List<? extends ImageSizeModel> imageList, final boolean z10) {
        kotlin.jvm.internal.s.i(context, "context");
        kotlin.jvm.internal.s.i(imageList, "imageList");
        Flowable subscribeOn = Flowable.just(imageList).onBackpressureLatest().subscribeOn(Schedulers.io());
        final Function1<List<? extends ImageSizeModel>, List<? extends Drawable>> function1 = new Function1<List<? extends ImageSizeModel>, List<? extends Drawable>>() { // from class: com.cupidapp.live.base.utils.NetWorkDrawableHelper$fetchImageDrawableFromNetWork$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final List<Drawable> invoke(@NotNull List<? extends ImageSizeModel> it) {
                Drawable i10;
                kotlin.jvm.internal.s.i(it, "it");
                Context context2 = context;
                boolean z11 = z10;
                ArrayList arrayList = new ArrayList(kotlin.collections.t.t(it, 10));
                Iterator<? extends ImageSizeModel> iterator2 = it.iterator2();
                while (iterator2.hasNext()) {
                    i10 = NetWorkDrawableHelper.f12282a.i(context2, iterator2.next(), z11);
                    arrayList.add(i10);
                }
                return arrayList;
            }
        };
        Flowable<List<Drawable>> map = subscribeOn.map(new Function() { // from class: com.cupidapp.live.base.utils.g0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List h10;
                h10 = NetWorkDrawableHelper.h(Function1.this, obj);
                return h10;
            }
        });
        kotlin.jvm.internal.s.h(map, "context: Context,\n      …          }\n            }");
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Drawable i(Context context, ImageSizeModel imageSizeModel, boolean z10) {
        ImageModel imageModel;
        int i10;
        int i11;
        Drawable drawable = ContextCompat.getDrawable(context, R$mipmap.img_placeholder);
        if (imageSizeModel instanceof ImageWithWidthModel) {
            ImageWithWidthModel imageWithWidthModel = (ImageWithWidthModel) imageSizeModel;
            imageModel = imageWithWidthModel.getImageModel();
            i10 = imageWithWidthModel.getWidth();
            i11 = imageModel.getScaleHeightByWidth(i10);
        } else if (imageSizeModel instanceof ImageWithHeightModel) {
            ImageWithHeightModel imageWithHeightModel = (ImageWithHeightModel) imageSizeModel;
            imageModel = imageWithHeightModel.getImageModel();
            i11 = imageWithHeightModel.getHeight();
            i10 = imageModel.getScaleWidthByHeight(i11);
        } else {
            imageModel = null;
            i10 = 0;
            i11 = 0;
        }
        try {
            RequestBuilder<Drawable> load = Glide.with(context).load(imageModel != null ? imageModel.getUrl(i10) : null);
            kotlin.jvm.internal.s.h(load, "with(context).load(imageModel?.getUrl(width))");
            if (!z10) {
                Cloneable skipMemoryCache = load.diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true);
                kotlin.jvm.internal.s.h(skipMemoryCache, "builder\n                …   .skipMemoryCache(true)");
                load = (RequestBuilder) skipMemoryCache;
            }
            drawable = (Drawable) load.override(i10, i11).fitCenter().submit().get();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, i10, i11);
        }
        return drawable;
    }
}
