package z0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DrawableExtension.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f54815a = new a(null);

    /* compiled from: DrawableExtension.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final String a(@Nullable Context context, int i10) {
            if (context == null) {
                return null;
            }
            try {
                return "android.resource://" + context.getResources().getResourcePackageName(i10) + "/" + context.getResources().getResourceTypeName(i10) + "/" + context.getResources().getResourceEntryName(i10);
            } catch (Resources.NotFoundException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        @Nullable
        public final Drawable b(@Nullable Drawable drawable, int i10) {
            if (drawable == null) {
                return null;
            }
            ColorStateList valueOf = ColorStateList.valueOf(i10);
            kotlin.jvm.internal.s.h(valueOf, "valueOf(color)");
            return c(drawable, valueOf);
        }

        @NotNull
        public final Drawable c(@NotNull Drawable drawable, @NotNull ColorStateList colors) {
            kotlin.jvm.internal.s.i(drawable, "drawable");
            kotlin.jvm.internal.s.i(colors, "colors");
            Drawable wrap = DrawableCompat.wrap(drawable.mutate());
            kotlin.jvm.internal.s.h(wrap, "wrap(drawable.mutate())");
            DrawableCompat.setTintList(wrap, colors);
            return wrap;
        }
    }
}
