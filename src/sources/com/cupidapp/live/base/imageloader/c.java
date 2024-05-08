package com.cupidapp.live.base.imageloader;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ILoader.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface c {

    /* compiled from: ILoader.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public static void a(@NotNull c cVar, @NotNull Bitmap bitmap) {
            s.i(bitmap, "bitmap");
        }

        public static void b(@NotNull c cVar, @NotNull Drawable drawable) {
            s.i(drawable, "drawable");
        }

        public static void c(@NotNull c cVar) {
        }
    }

    void a(@NotNull Drawable drawable);

    void b();

    void c(@NotNull Bitmap bitmap);
}
