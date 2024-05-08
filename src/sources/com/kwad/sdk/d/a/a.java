package com.kwad.sdk.d.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.kwad.sdk.utils.s;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private static int anx;
    private static long any;

    public static boolean Au() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (Math.abs(uptimeMillis - any) < 500) {
            any = uptimeMillis;
            return true;
        }
        any = uptimeMillis;
        return false;
    }

    public static boolean C(View view) {
        return (view.getSystemUiVisibility() & 1024) == 1024;
    }

    public static void D(View view) {
        if (view == null || ((View) view.getParent()) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        view.setLayoutParams(layoutParams);
    }

    @Nullable
    public static int[] E(View view) {
        if (view == null) {
            return null;
        }
        view.getLocationInWindow(r1);
        int[] iArr = {iArr[0] + (view.getWidth() / 2), iArr[1] + (view.getHeight() / 2)};
        return iArr;
    }

    public static int F(View view) {
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return ((FrameLayout.LayoutParams) layoutParams).gravity;
        }
        return 0;
    }

    public static int a(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Deprecated
    public static int aI(@Nullable Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static float aJ(@NonNull Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static boolean b(Activity activity) {
        return b(activity.getWindow());
    }

    private static View c(@NonNull Activity activity) {
        return c(activity.getWindow());
    }

    public static int d(@NonNull Activity activity) {
        return c(activity).getWidth();
    }

    public static int e(@NonNull Activity activity) {
        return c(activity).getHeight();
    }

    public static void f(View view, int i10, int i11) {
        View view2;
        if (view == null || i10 == 0 || i11 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (width > height && i10 <= i11) {
            layoutParams.width = (int) ((i10 / (i11 * 1.0f)) * height);
            layoutParams.height = height;
        } else {
            layoutParams.width = width;
            layoutParams.height = (int) ((i11 / (i10 * 1.0f)) * width);
        }
        view.setLayoutParams(layoutParams);
    }

    public static int g(Context context, int i10) {
        return context.getResources().getDimensionPixelSize(i10);
    }

    @ColorInt
    public static int getColor(Context context, @ColorRes int i10) {
        return context.getResources().getColor(i10);
    }

    @Deprecated
    public static int getScreenHeight(@Nullable Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    @Deprecated
    public static int getScreenWidth(@Nullable Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getStatusBarHeight(@Nullable Context context) {
        int i10 = anx;
        if (i10 > 0 || context == null) {
            return i10;
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            anx = context.getResources().getDimensionPixelSize(identifier);
        } else {
            try {
                anx = context.getResources().getDimensionPixelSize(((Integer) s.getField("com.android.internal.R$dimen", "status_bar_height")).intValue());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (anx <= 0) {
            anx = a(context, 25.0f);
        }
        return anx;
    }

    public static void m(View view, int i10) {
        if (view == null || i10 == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i10;
        view.setLayoutParams(layoutParams);
    }

    public static void n(View view, int i10) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i10;
        }
    }

    public static int px2dip(Context context, float f10) {
        return (int) ((f10 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void a(View.OnClickListener onClickListener, View... viewArr) {
        for (View view : viewArr) {
            view.setOnClickListener(onClickListener);
        }
    }

    private static boolean b(Window window) {
        return (window.getAttributes().flags & 1024) == 1024;
    }

    private static View c(@NonNull Window window) {
        return window.getDecorView().findViewById(16908290);
    }

    public static void d(View view, int i10, int i11) {
        View view2;
        if (view == null || i10 == 0 || i11 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (width > height) {
            if (i10 > i11) {
                layoutParams.width = -1;
                layoutParams.height = -1;
            } else {
                layoutParams.width = (int) ((i10 / (i11 * 1.0f)) * height);
                layoutParams.height = height;
            }
        } else if (i11 > i10) {
            layoutParams.width = -1;
            layoutParams.height = -1;
        } else {
            layoutParams.width = width;
            layoutParams.height = (int) ((i11 / (i10 * 1.0f)) * width);
        }
        view.setLayoutParams(layoutParams);
    }

    public static void e(View view, int i10, int i11) {
        View view2;
        if (view == null || i10 == 0 || i11 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i10 > i11) {
            layoutParams.width = width;
            layoutParams.height = (int) ((i11 / (i10 * 1.0f)) * width);
        } else {
            layoutParams.width = (int) ((i10 / (i11 * 1.0f)) * height);
            layoutParams.height = height;
        }
        view.setLayoutParams(layoutParams);
    }

    public static void b(View view, int i10, int i11, int i12, int i13) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMargins(i10, i11, i12, 0);
            view.requestLayout();
        }
    }

    public static View a(ViewGroup viewGroup, int i10, boolean z10) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(i10, viewGroup, true);
    }

    public static void a(TextView textView, String str, Bitmap bitmap) {
        String str2 = str + " ";
        TextPaint paint = textView.getPaint();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        int ceil = ((int) Math.ceil(fontMetrics.descent - fontMetrics.top)) + 2;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(textView.getContext().getResources(), bitmap);
        int intrinsicWidth = (bitmapDrawable.getIntrinsicWidth() * ceil) / bitmapDrawable.getIntrinsicHeight();
        bitmapDrawable.setBounds(0, a(textView.getContext(), 1.0f), intrinsicWidth, ceil);
        float width = textView.getWidth();
        if (paint.measureText(str2) > width) {
            int i10 = 0;
            int i11 = 1;
            int i12 = 1;
            boolean z10 = false;
            while (true) {
                float measureText = paint.measureText(str2.substring(i10, i11));
                if (measureText < width) {
                    if (i12 == textView.getMaxLines()) {
                        float f10 = measureText + intrinsicWidth;
                        if (paint.measureText(" ") + f10 < width && f10 + paint.measureText("...") + paint.measureText(" ") < width) {
                            if (z10) {
                                str2 = str2.substring(0, i11) + "... ";
                                break;
                            }
                        } else {
                            i11--;
                            z10 = true;
                        }
                    }
                    i11++;
                } else {
                    i10 = i11 - 1;
                    i12++;
                }
                if (i11 > str2.length() || i12 > textView.getMaxLines()) {
                    break;
                }
            }
        }
        String str3 = str2 + StringUtils.NO_PRINT_CODE;
        SpannableString spannableString = new SpannableString(str3);
        spannableString.setSpan(new com.kwad.sdk.core.view.a(textView.getContext(), bitmap), str3.length() - 1, str3.length(), 33);
        textView.setText(spannableString);
    }
}
