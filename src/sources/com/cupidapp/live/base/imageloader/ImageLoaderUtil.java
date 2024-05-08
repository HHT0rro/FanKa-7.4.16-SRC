package com.cupidapp.live.base.imageloader;

import a1.f;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.Lazy;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImageLoaderUtil.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ImageLoaderUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ImageLoaderUtil f11832a = new ImageLoaderUtil();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Lazy f11833b = kotlin.c.b(new Function0<f>() { // from class: com.cupidapp.live.base.imageloader.ImageLoaderUtil$loader$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final f invoke() {
            return new f();
        }
    });

    public static /* synthetic */ void c(ImageLoaderUtil imageLoaderUtil, Context context, String str, boolean z10, Function1 function1, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        imageLoaderUtil.b(context, str, z10, function1);
    }

    public final void a(@NotNull Context context) {
        s.i(context, "context");
        e().clearMemory(context);
    }

    public final void b(@NotNull Context context, @NotNull String string, boolean z10, @NotNull Function1<? super Bitmap, p> loadFinished) {
        s.i(context, "context");
        s.i(string, "string");
        s.i(loadFinished, "loadFinished");
        e().h(context, string, z10, loadFinished);
    }

    public final void d(@NotNull Context context, @NotNull String string, @NotNull Function1<? super Drawable, p> loadFinished) {
        s.i(context, "context");
        s.i(string, "string");
        s.i(loadFinished, "loadFinished");
        e().e(context, string, loadFinished);
    }

    public final a e() {
        return (a) f11833b.getValue();
    }

    public final void f(@NotNull Context context, @NotNull ImageView view, @NotNull b options, @Nullable c cVar) {
        s.i(context, "context");
        s.i(view, "view");
        s.i(options, "options");
        e().b(context, view, options, cVar);
    }

    public final void g(@Nullable Context context, @NotNull ImageView view, int i10) {
        s.i(view, "view");
        e().c(context, view, i10);
    }

    public final void h(@NotNull Context context, @NotNull String url, @NotNull Function1<? super Drawable, p> readyCallback) {
        s.i(context, "context");
        s.i(url, "url");
        s.i(readyCallback, "readyCallback");
        e().a(context, url, readyCallback);
    }

    public final void i(@NotNull Context context, @NotNull String assetsFileName, @NotNull Function1<? super Drawable, p> readyCallback) {
        s.i(context, "context");
        s.i(assetsFileName, "assetsFileName");
        s.i(readyCallback, "readyCallback");
        e().g(context, assetsFileName, readyCallback);
    }

    public final void j(@NotNull Context context, @NotNull String path, @NotNull Function1<? super Drawable, p> readyCallback) {
        s.i(context, "context");
        s.i(path, "path");
        s.i(readyCallback, "readyCallback");
        e().d(context, path, readyCallback);
    }

    public final void k(@NotNull Context context, int i10) {
        s.i(context, "context");
        e().f(context, i10);
    }
}
