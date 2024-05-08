package com.cupidapp.live.base.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ILoader.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface a {
    void a(@NotNull Context context, @NotNull String str, @NotNull Function1<? super Drawable, p> function1);

    void b(@NotNull Context context, @NotNull View view, @NotNull b bVar, @Nullable c cVar);

    void c(@Nullable Context context, @NotNull ImageView imageView, int i10);

    void clearMemory(@NotNull Context context);

    void d(@NotNull Context context, @NotNull String str, @NotNull Function1<? super Drawable, p> function1);

    void e(@NotNull Context context, @NotNull String str, @NotNull Function1<? super Drawable, p> function1);

    void f(@NotNull Context context, int i10);

    void g(@NotNull Context context, @NotNull String str, @NotNull Function1<? super Drawable, p> function1);

    void h(@NotNull Context context, @NotNull String str, boolean z10, @NotNull Function1<? super Bitmap, p> function1);
}
