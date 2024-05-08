package a1;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.imageloader.BlurModel;
import com.cupidapp.live.base.imageloader.DiskCacheType;
import com.cupidapp.live.base.imageloader.PriorityType;
import com.cupidapp.live.base.imageloader.RoundCornerModel;
import com.cupidapp.live.base.imageloader.TransformationType;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GlideImageLoader.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class f implements com.cupidapp.live.base.imageloader.a {

    /* compiled from: GlideImageLoader.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f683a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f684b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f685c;

        static {
            int[] iArr = new int[DiskCacheType.values().length];
            try {
                iArr[DiskCacheType.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DiskCacheType.AUTOMATIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DiskCacheType.DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DiskCacheType.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DiskCacheType.RESOURCE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f683a = iArr;
            int[] iArr2 = new int[PriorityType.values().length];
            try {
                iArr2[PriorityType.IMMEDIATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[PriorityType.HIGH.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[PriorityType.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[PriorityType.LOW.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            f684b = iArr2;
            int[] iArr3 = new int[TransformationType.values().length];
            try {
                iArr3[TransformationType.FitCenter.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[TransformationType.CenterCrop.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            f685c = iArr3;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: GlideImageLoader.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b<T> implements RequestListener<T> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.cupidapp.live.base.imageloader.c f686b;

        public b(com.cupidapp.live.base.imageloader.c cVar) {
            this.f686b = cVar;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(@Nullable GlideException glideException, @Nullable Object obj, @Nullable Target<T> target, boolean z10) {
            this.f686b.b();
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bumptech.glide.request.RequestListener
        public boolean onResourceReady(T t2, @Nullable Object obj, @Nullable Target<T> target, @Nullable DataSource dataSource, boolean z10) {
            if (t2 instanceof Drawable) {
                this.f686b.a((Drawable) t2);
                return false;
            }
            if (!(t2 instanceof Bitmap)) {
                return false;
            }
            this.f686b.c((Bitmap) t2);
            return false;
        }
    }

    /* compiled from: GlideImageLoader.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c extends CustomTarget<Bitmap> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<Bitmap, p> f687b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function1<? super Bitmap, p> function1) {
            this.f687b = function1;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
            onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
        }

        public void onResourceReady(@NotNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
            s.i(resource, "resource");
            this.f687b.invoke(resource);
        }
    }

    /* compiled from: GlideImageLoader.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class d extends CustomTarget<Drawable> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<Drawable, p> f688b;

        /* JADX WARN: Multi-variable type inference failed */
        public d(Function1<? super Drawable, p> function1) {
            this.f688b = function1;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
            onResourceReady((Drawable) obj, (Transition<? super Drawable>) transition);
        }

        public void onResourceReady(@NotNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
            s.i(resource, "resource");
            this.f688b.invoke(resource);
        }
    }

    /* compiled from: GlideImageLoader.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class e extends CustomTarget<File> {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f690c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function1<Drawable, p> f691d;

        /* JADX WARN: Multi-variable type inference failed */
        public e(Context context, Function1<? super Drawable, p> function1) {
            this.f690c = context;
            this.f691d = function1;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(@NotNull File resource, @Nullable Transition<? super File> transition) {
            s.i(resource, "resource");
            f.this.n(this.f690c, new FileInputStream(resource), this.f691d);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(@Nullable Drawable drawable) {
        }
    }

    @Override // com.cupidapp.live.base.imageloader.a
    public void a(@NotNull Context context, @NotNull String url, @NotNull Function1<? super Drawable, p> readyCallback) {
        s.i(context, "context");
        s.i(url, "url");
        s.i(readyCallback, "readyCallback");
        if (k(context)) {
            if (url.length() == 0) {
                return;
            }
            a1.e.b(context).asFile().load(url).into((h<File>) new e(context, readyCallback));
        }
    }

    @Override // com.cupidapp.live.base.imageloader.a
    public void b(@NotNull Context context, @NotNull View view, @NotNull com.cupidapp.live.base.imageloader.b options, @Nullable com.cupidapp.live.base.imageloader.c cVar) {
        h m10;
        h placeholder;
        DiskCacheStrategy diskCacheStrategy;
        Priority priority;
        s.i(context, "context");
        s.i(view, "view");
        s.i(options, "options");
        if ((view instanceof ImageView) && k(context)) {
            i b4 = a1.e.b(context);
            s.h(b4, "with(context)");
            if (options.r()) {
                h<Drawable> asDrawable = b4.asDrawable();
                s.h(asDrawable, "requestManager.asDrawable()");
                m10 = m(asDrawable, options);
                if (cVar != null) {
                    m10 = j(m10, cVar);
                }
            } else {
                h<Bitmap> asBitmap = b4.asBitmap();
                s.h(asBitmap, "requestManager.asBitmap()");
                m10 = m(asBitmap, options);
                if (cVar != null) {
                    m10 = j(m10, cVar);
                }
            }
            if (options.i() != null) {
                placeholder = m10.placeholder(options.i());
                s.h(placeholder, "requestBuilder.placehold…options.placeholderImage)");
            } else if (options.j() != 0) {
                placeholder = m10.placeholder(options.j());
                s.h(placeholder, "requestBuilder.placehold…ns.placeholderImageResId)");
            } else {
                RoundCornerModel m11 = options.m();
                if (m11 != null ? m11.getRoundAsCircle() : false) {
                    placeholder = m10.placeholder(R$mipmap.icon_placeholder_circle);
                    s.h(placeholder, "requestBuilder.placehold….icon_placeholder_circle)");
                } else {
                    RoundCornerModel m12 = options.m();
                    if ((m12 != null ? m12.getRadius() : 0) > 0) {
                        placeholder = m10.placeholder(o(context, options));
                        s.h(placeholder, "requestBuilder.placehold…          )\n            )");
                    } else {
                        placeholder = m10.placeholder(new ColorDrawable(options.h()));
                        s.h(placeholder, "requestBuilder.placehold…ptions.placeholderColor))");
                    }
                }
            }
            Transformation<Bitmap>[] l10 = l(options);
            h transform = placeholder.transform((Transformation[]) Arrays.copyOf(l10, l10.length));
            s.h(transform, "requestBuilder.transform…gImageTransform(options))");
            if (options.g() > 0 && options.f() > 0) {
                transform = transform.override(options.g(), options.f());
                s.h(transform, "requestBuilder.override(…, options.overrideHeight)");
            } else if (options.g() < 0 && options.f() < 0) {
                transform = transform.override(Integer.MIN_VALUE, Integer.MIN_VALUE);
                s.h(transform, "requestBuilder.override(…AL, Target.SIZE_ORIGINAL)");
            }
            if (options.n()) {
                transform = transform.skipMemoryCache(true);
                s.h(transform, "requestBuilder.skipMemoryCache(true)");
            }
            int i10 = a.f683a[options.c().ordinal()];
            if (i10 == 1) {
                diskCacheStrategy = DiskCacheStrategy.ALL;
            } else if (i10 == 2) {
                diskCacheStrategy = DiskCacheStrategy.AUTOMATIC;
            } else if (i10 == 3) {
                diskCacheStrategy = DiskCacheStrategy.DATA;
            } else if (i10 == 4) {
                diskCacheStrategy = DiskCacheStrategy.NONE;
            } else {
                if (i10 != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                diskCacheStrategy = DiskCacheStrategy.RESOURCE;
            }
            if (!s.d(diskCacheStrategy, DiskCacheStrategy.AUTOMATIC)) {
                transform = transform.diskCacheStrategy(diskCacheStrategy);
                s.h(transform, "requestBuilder.diskCacheStrategy(strategy)");
            }
            int i11 = a.f684b[options.k().ordinal()];
            if (i11 == 1) {
                priority = Priority.IMMEDIATE;
            } else if (i11 == 2) {
                priority = Priority.HIGH;
            } else if (i11 == 3) {
                priority = Priority.NORMAL;
            } else {
                if (i11 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                priority = Priority.LOW;
            }
            h priority2 = transform.priority(priority);
            s.h(priority2, "requestBuilder.priority(priority)");
            priority2.into((ImageView) view);
        }
    }

    @Override // com.cupidapp.live.base.imageloader.a
    public void c(@Nullable Context context, @NotNull ImageView view, int i10) {
        s.i(view, "view");
        if (context == null || !k(context)) {
            return;
        }
        String a10 = z0.i.f54815a.a(context, i10);
        if (a10 == null || a10.length() == 0) {
            return;
        }
        a1.e.b(context).asDrawable().load(a10).into(view);
    }

    @Override // com.cupidapp.live.base.imageloader.a
    public void clearMemory(@NotNull Context context) {
        s.i(context, "context");
        a1.e.a(context).clearMemory();
    }

    @Override // com.cupidapp.live.base.imageloader.a
    public void d(@NotNull Context context, @NotNull String path, @NotNull Function1<? super Drawable, p> readyCallback) {
        s.i(context, "context");
        s.i(path, "path");
        s.i(readyCallback, "readyCallback");
        if (k(context)) {
            if (path.length() == 0) {
                return;
            }
            n(context, new FileInputStream(new File(path)), readyCallback);
        }
    }

    @Override // com.cupidapp.live.base.imageloader.a
    public void e(@NotNull Context context, @NotNull String string, @NotNull Function1<? super Drawable, p> loadFinished) {
        s.i(context, "context");
        s.i(string, "string");
        s.i(loadFinished, "loadFinished");
        a1.e.b(context).load(string).into((h<Drawable>) new d(loadFinished));
    }

    @Override // com.cupidapp.live.base.imageloader.a
    public void f(@NotNull Context context, int i10) {
        s.i(context, "context");
        a1.e.a(context).trimMemory(i10);
    }

    @Override // com.cupidapp.live.base.imageloader.a
    public void g(@NotNull Context context, @NotNull String assetsFileName, @NotNull Function1<? super Drawable, p> readyCallback) {
        s.i(context, "context");
        s.i(assetsFileName, "assetsFileName");
        s.i(readyCallback, "readyCallback");
        if (k(context)) {
            if (assetsFileName.length() == 0) {
                return;
            }
            InputStream open = context.getAssets().open(assetsFileName);
            s.h(open, "context.assets.open(assetsFileName)");
            n(context, open, readyCallback);
        }
    }

    @Override // com.cupidapp.live.base.imageloader.a
    public void h(@NotNull Context context, @NotNull String string, boolean z10, @NotNull Function1<? super Bitmap, p> loadFinished) {
        s.i(context, "context");
        s.i(string, "string");
        s.i(loadFinished, "loadFinished");
        h<Bitmap> load = a1.e.b(context).asBitmap().load(string);
        s.h(load, "with(context).asBitmap().load(string)");
        if (z10) {
            load = load.apply(RequestOptions.circleCropTransform());
            s.h(load, "request.apply(RequestOpt…ns.circleCropTransform())");
        }
        load.into((h<Bitmap>) new c(loadFinished));
    }

    public final <T> h<T> j(h<T> hVar, com.cupidapp.live.base.imageloader.c cVar) {
        h<T> listener = hVar.listener(new b(cVar));
        s.h(listener, "listener: ImageLoaderPro…\n            }\n        })");
        return listener;
    }

    public final boolean k(Context context) {
        if ((context instanceof Application) || !(context instanceof Activity)) {
            return true;
        }
        Activity activity = (Activity) context;
        return (activity.isDestroyed() || activity.isFinishing()) ? false : true;
    }

    public final Transformation<Bitmap>[] l(com.cupidapp.live.base.imageloader.b bVar) {
        BitmapTransformation fitCenter;
        ArrayList arrayList = new ArrayList();
        int i10 = a.f685c[bVar.o().ordinal()];
        if (i10 == 1) {
            fitCenter = new FitCenter();
        } else {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            fitCenter = new CenterCrop();
        }
        arrayList.add(fitCenter);
        if (bVar.s()) {
            arrayList.add(new j());
        }
        BlurModel b4 = bVar.b();
        if (b4 != null) {
            arrayList.add(new a1.a(b4.getRadius(), b4.getSampling()));
        }
        RoundCornerModel m10 = bVar.m();
        if (m10 != null) {
            if (m10.getRoundAsCircle()) {
                if (m10.getBorderWidth() > 0) {
                    arrayList.add(new a1.c(m10.getBorderWidth(), m10.getBorderColor()));
                } else {
                    arrayList.add(new CircleCrop());
                }
            } else if (m10.getBorderWidth() <= 0 && m10.isAllRoundCorner()) {
                arrayList.add(new RoundedCorners(m10.getRadius()));
            } else if (m10.getBorderWidth() <= 0 && m10.getRadius() <= 0) {
                com.cupidapp.live.base.utils.j.f12332a.a("GlideImageLoader", "not config round corner transform");
            } else {
                arrayList.add(new a1.b(m10.getRadius(), m10.getBorderWidth(), m10.getBorderColor(), m10.getRoundTopLeft(), m10.getRoundTopRight(), m10.getRoundBottomRight(), m10.getRoundBottomLeft()));
            }
        }
        return (Transformation[]) arrayList.toArray(new Transformation[0]);
    }

    public final <T> h<T> m(h<T> hVar, com.cupidapp.live.base.imageloader.b bVar) {
        if (bVar.q() != null) {
            String q10 = bVar.q();
            s.f(q10);
            if (q10.length() > 0) {
                h<T> load = hVar.load(bVar.q());
                s.h(load, "{\n            request.load(options.url)\n        }");
                return load;
            }
        }
        if (bVar.e() != null) {
            h<T> load2 = hVar.load(bVar.e());
            s.h(load2, "{\n            request.load(options.file)\n        }");
            return load2;
        }
        if (bVar.p() != null) {
            h<T> load3 = hVar.load(bVar.p());
            s.h(load3, "{\n            request.load(options.uri)\n        }");
            return load3;
        }
        if (bVar.l() != null && bVar.l().intValue() > 0) {
            h<T> load4 = hVar.load(bVar.l());
            s.h(load4, "{\n            request.lo…ons.resourceId)\n        }");
            return load4;
        }
        if (bVar.d() != null) {
            h<T> load5 = hVar.load(bVar.d());
            s.h(load5, "{\n            request.lo…tions.drawable)\n        }");
            return load5;
        }
        if (bVar.a() != null) {
            h<T> load6 = hVar.load(bVar.a());
            s.h(load6, "{\n            request.lo…options.bitmap)\n        }");
            return load6;
        }
        h<T> load7 = hVar.load("");
        s.h(load7, "{\n            request.load(\"\")\n        }");
        return load7;
    }

    public final void n(Context context, InputStream inputStream, Function1<? super Drawable, p> function1) {
        byte[] ninePatchChunk;
        NinePatchDrawable ninePatchDrawable;
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
        try {
            try {
                ninePatchChunk = decodeStream.getNinePatchChunk();
            } catch (Exception e2) {
                function1.invoke(null);
                e2.printStackTrace();
            }
            if (ninePatchChunk != null && NinePatch.isNinePatchChunk(ninePatchChunk)) {
                b1.a b4 = b1.a.f1235e.b(ninePatchChunk);
                if (b4 == null) {
                    decodeStream.recycle();
                } else {
                    ninePatchDrawable = new NinePatchDrawable(context.getResources(), decodeStream, ninePatchChunk, b4.g(), null);
                    function1.invoke(ninePatchDrawable);
                }
            } else {
                decodeStream.recycle();
            }
            ninePatchDrawable = null;
            function1.invoke(ninePatchDrawable);
        } finally {
            inputStream.close();
        }
    }

    public final Drawable o(Context context, com.cupidapp.live.base.imageloader.b bVar) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        try {
            gradientDrawable.setColor(bVar.h());
        } catch (Resources.NotFoundException e2) {
            gradientDrawable.setColor(ContextCompat.getColor(context, R$color.gray_DCDCDC));
            com.cupidapp.live.base.utils.j.f12332a.c("GlideImageLoader", "here placeholderColor must color id, you might have set mipmap id");
            e2.printStackTrace();
        }
        RoundCornerModel m10 = bVar.m();
        if (m10 != null) {
            gradientDrawable.setCornerRadii(a1.b.f670h.a(m10.getRoundTopLeft(), m10.getRoundTopRight(), m10.getRoundBottomRight(), m10.getRoundBottomLeft(), m10.getRadius()));
        }
        return gradientDrawable;
    }
}
