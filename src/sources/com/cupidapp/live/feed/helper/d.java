package com.cupidapp.live.feed.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.Window;
import java.io.File;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ConvertViewToImageHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f14312a = new d();

    /* compiled from: ConvertViewToImageHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {
        void a();

        void b(@NotNull File file);
    }

    public final void a(@NotNull Context context, @NotNull Window window, @NotNull View view, @NotNull String fileTag, @NotNull a listener) {
        s.i(context, "context");
        s.i(window, "window");
        s.i(view, "view");
        s.i(fileTag, "fileTag");
        s.i(listener, "listener");
        b(context, view, fileTag, listener);
    }

    public final void b(Context context, View view, String str, a aVar) {
        view.setDrawingCacheEnabled(true);
        view.setDrawingCacheQuality(1048576);
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache != null && !drawingCache.isRecycled()) {
            Bitmap bitmap = Bitmap.createBitmap(drawingCache);
            File k10 = z0.k.f54819a.k(context, System.currentTimeMillis() + "_" + str + ".jpg");
            if (k10 == null) {
                com.cupidapp.live.base.view.h.f12779a.m(context, "生成图片出错_2001");
                aVar.a();
            } else {
                s.h(bitmap, "bitmap");
                z0.f.g(bitmap, k10, 0, 2, null);
                aVar.b(k10);
            }
        } else {
            com.cupidapp.live.base.view.h.f12779a.m(context, "生成图片出错_2002");
            aVar.a();
        }
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
    }
}
