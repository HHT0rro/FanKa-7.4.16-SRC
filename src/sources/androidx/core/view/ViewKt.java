package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.sequences.SequencesKt__SequencesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: View.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ViewKt {
    public static final void doOnAttach(@NotNull final View view, @NotNull final Function1<? super View, p> action) {
        s.i(view, "<this>");
        s.i(action, "action");
        if (ViewCompat.isAttachedToWindow(view)) {
            action.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.core.view.ViewKt$doOnAttach$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@NotNull View view2) {
                    s.i(view2, "view");
                    View.this.removeOnAttachStateChangeListener(this);
                    action.invoke(view2);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(@NotNull View view2) {
                    s.i(view2, "view");
                }
            });
        }
    }

    public static final void doOnDetach(@NotNull final View view, @NotNull final Function1<? super View, p> action) {
        s.i(view, "<this>");
        s.i(action, "action");
        if (!ViewCompat.isAttachedToWindow(view)) {
            action.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.core.view.ViewKt$doOnDetach$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@NotNull View view2) {
                    s.i(view2, "view");
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(@NotNull View view2) {
                    s.i(view2, "view");
                    View.this.removeOnAttachStateChangeListener(this);
                    action.invoke(view2);
                }
            });
        }
    }

    public static final void doOnLayout(@NotNull View view, @NotNull final Function1<? super View, p> action) {
        s.i(view, "<this>");
        s.i(action, "action");
        if (ViewCompat.isLaidOut(view) && !view.isLayoutRequested()) {
            action.invoke(view);
        } else {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt$doOnLayout$$inlined$doOnNextLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(@NotNull View view2, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                    s.i(view2, "view");
                    view2.removeOnLayoutChangeListener(this);
                    Function1.this.invoke(view2);
                }
            });
        }
    }

    public static final void doOnNextLayout(@NotNull View view, @NotNull final Function1<? super View, p> action) {
        s.i(view, "<this>");
        s.i(action, "action");
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt$doOnNextLayout$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(@NotNull View view2, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                s.i(view2, "view");
                view2.removeOnLayoutChangeListener(this);
                action.invoke(view2);
            }
        });
    }

    @NotNull
    public static final OneShotPreDrawListener doOnPreDraw(@NotNull final View view, @NotNull final Function1<? super View, p> action) {
        s.i(view, "<this>");
        s.i(action, "action");
        OneShotPreDrawListener add = OneShotPreDrawListener.add(view, new Runnable() { // from class: androidx.core.view.ViewKt$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                action.invoke(view);
            }
        });
        s.h(add, "View.doOnPreDraw(\n    cr…dd(this) { action(this) }");
        return add;
    }

    @NotNull
    public static final Bitmap drawToBitmap(@NotNull View view, @NotNull Bitmap.Config config) {
        s.i(view, "<this>");
        s.i(config, "config");
        if (ViewCompat.isLaidOut(view)) {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), config);
            s.h(createBitmap, "createBitmap(width, height, config)");
            Canvas canvas = new Canvas(createBitmap);
            canvas.translate(-view.getScrollX(), -view.getScrollY());
            view.draw(canvas);
            return createBitmap;
        }
        throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View view, Bitmap.Config config, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return drawToBitmap(view, config);
    }

    @NotNull
    public static final kotlin.sequences.g<View> getAllViews(@NotNull View view) {
        s.i(view, "<this>");
        return kotlin.sequences.j.b(new ViewKt$allViews$1(view, null));
    }

    @NotNull
    public static final kotlin.sequences.g<ViewParent> getAncestors(@NotNull View view) {
        s.i(view, "<this>");
        return SequencesKt__SequencesKt.e(view.getParent(), ViewKt$ancestors$1.INSTANCE);
    }

    public static final int getMarginBottom(@NotNull View view) {
        s.i(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.bottomMargin;
        }
        return 0;
    }

    public static final int getMarginEnd(@NotNull View view) {
        s.i(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int getMarginLeft(@NotNull View view) {
        s.i(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.leftMargin;
        }
        return 0;
    }

    public static final int getMarginRight(@NotNull View view) {
        s.i(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.rightMargin;
        }
        return 0;
    }

    public static final int getMarginStart(@NotNull View view) {
        s.i(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int getMarginTop(@NotNull View view) {
        s.i(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.topMargin;
        }
        return 0;
    }

    public static final boolean isGone(@NotNull View view) {
        s.i(view, "<this>");
        return view.getVisibility() == 8;
    }

    public static final boolean isInvisible(@NotNull View view) {
        s.i(view, "<this>");
        return view.getVisibility() == 4;
    }

    public static final boolean isVisible(@NotNull View view) {
        s.i(view, "<this>");
        return view.getVisibility() == 0;
    }

    @NotNull
    public static final Runnable postDelayed(@NotNull View view, long j10, @NotNull final Function0<p> action) {
        s.i(view, "<this>");
        s.i(action, "action");
        Runnable runnable = new Runnable() { // from class: androidx.core.view.ViewKt$postDelayed$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                action.invoke();
            }
        };
        view.postDelayed(runnable, j10);
        return runnable;
    }

    @RequiresApi(16)
    @NotNull
    public static final Runnable postOnAnimationDelayed(@NotNull View view, long j10, @NotNull final Function0<p> action) {
        s.i(view, "<this>");
        s.i(action, "action");
        Runnable runnable = new Runnable() { // from class: androidx.core.view.i
            @Override // java.lang.Runnable
            public final void run() {
                ViewKt.postOnAnimationDelayed$lambda$1(Function0.this);
            }
        };
        Api16Impl.postOnAnimationDelayed(view, runnable, j10);
        return runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postOnAnimationDelayed$lambda$1(Function0 action) {
        s.i(action, "$action");
        action.invoke();
    }

    public static final void setGone(@NotNull View view, boolean z10) {
        s.i(view, "<this>");
        view.setVisibility(z10 ? 8 : 0);
    }

    public static final void setInvisible(@NotNull View view, boolean z10) {
        s.i(view, "<this>");
        view.setVisibility(z10 ? 4 : 0);
    }

    public static final void setPadding(@NotNull View view, @Px int i10) {
        s.i(view, "<this>");
        view.setPadding(i10, i10, i10, i10);
    }

    public static final void setVisible(@NotNull View view, boolean z10) {
        s.i(view, "<this>");
        view.setVisibility(z10 ? 0 : 8);
    }

    public static final void updateLayoutParams(@NotNull View view, @NotNull Function1<? super ViewGroup.LayoutParams, p> block) {
        s.i(view, "<this>");
        s.i(block, "block");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        block.invoke(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    public static final /* synthetic */ <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(View view, Function1<? super T, p> block) {
        s.i(view, "<this>");
        s.i(block, "block");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        s.o(1, ExifInterface.GPS_DIRECTION_TRUE);
        block.invoke(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    public static final void updatePadding(@NotNull View view, @Px int i10, @Px int i11, @Px int i12, @Px int i13) {
        s.i(view, "<this>");
        view.setPadding(i10, i11, i12, i13);
    }

    public static /* synthetic */ void updatePadding$default(View view, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = view.getPaddingLeft();
        }
        if ((i14 & 2) != 0) {
            i11 = view.getPaddingTop();
        }
        if ((i14 & 4) != 0) {
            i12 = view.getPaddingRight();
        }
        if ((i14 & 8) != 0) {
            i13 = view.getPaddingBottom();
        }
        s.i(view, "<this>");
        view.setPadding(i10, i11, i12, i13);
    }

    @RequiresApi(17)
    public static final void updatePaddingRelative(@NotNull View view, @Px int i10, @Px int i11, @Px int i12, @Px int i13) {
        s.i(view, "<this>");
        view.setPaddingRelative(i10, i11, i12, i13);
    }

    public static /* synthetic */ void updatePaddingRelative$default(View view, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = view.getPaddingStart();
        }
        if ((i14 & 2) != 0) {
            i11 = view.getPaddingTop();
        }
        if ((i14 & 4) != 0) {
            i12 = view.getPaddingEnd();
        }
        if ((i14 & 8) != 0) {
            i13 = view.getPaddingBottom();
        }
        s.i(view, "<this>");
        view.setPaddingRelative(i10, i11, i12, i13);
    }
}
