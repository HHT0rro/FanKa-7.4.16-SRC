package com.huawei.quickcard.framework.background;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.core.R;
import com.huawei.quickcard.d;
import com.huawei.quickcard.f;
import com.huawei.quickcard.framework.border.Border;
import com.huawei.quickcard.framework.unit.LengthUnit;
import com.huawei.quickcard.framework.unit.LengthValue;
import com.huawei.quickcard.k;
import com.huawei.quickcard.utils.ViewUtils;
import com.kuaishou.weapon.p0.t;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DrawableUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33783a = "DrawableUtils";

    private static b a(View view, Bitmap bitmap, @NonNull String str, @NonNull String str2) {
        float width = view.getWidth();
        float height = view.getHeight();
        float width2 = (bitmap.getWidth() * 1.0f) / bitmap.getHeight();
        if (str.endsWith("%")) {
            width *= a(str);
            height = a(view, str2, height, width, width2);
        }
        if (str.endsWith(t.f36232q)) {
            width = a(view, str, width);
            height = a(view, str2, height, width, width2);
        }
        return new b(width, height);
    }

    private static b b(View view, Bitmap bitmap) {
        int height = view.getHeight();
        float width = (bitmap.getWidth() * 1.0f) / bitmap.getHeight();
        float width2 = view.getWidth();
        float f10 = height;
        boolean z10 = width <= (1.0f * width2) / f10;
        float f11 = z10 ? width2 : f10 * width;
        if (z10) {
            f10 = width2 / width;
        }
        return new b(f11, f10);
    }

    public static Point calculatePosition(View view, b bVar, @NonNull f fVar) {
        float width = view.getWidth();
        float height = view.getHeight();
        float f10 = bVar.f33786a;
        float f11 = bVar.f33787b;
        Point point = new Point(0, 0);
        point.x = a(width, f10, fVar.c(), fVar.b(), view);
        point.y = a(height, f11, fVar.e(), fVar.d(), view);
        return point;
    }

    public static a calculateRepeat(f fVar) {
        String f10 = fVar.f();
        boolean z10 = true;
        if (f10 == null) {
            return new a(true, true);
        }
        char c4 = 65535;
        boolean z11 = false;
        switch (f10.hashCode()) {
            case -724648153:
                if (f10.equals("no-repeat")) {
                    c4 = 0;
                    break;
                }
                break;
            case -436782906:
                if (f10.equals("repeat-x")) {
                    c4 = 1;
                    break;
                }
                break;
            case -436782905:
                if (f10.equals("repeat-y")) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                z10 = false;
                break;
            case 1:
                break;
            case 2:
                z10 = false;
            default:
                z11 = true;
                break;
        }
        return new a(z10, z11);
    }

    public static b calculateSize(@NonNull View view, @NonNull Bitmap bitmap, @NonNull f fVar) {
        String g3 = fVar.g();
        String a10 = fVar.a();
        g3.hashCode();
        char c4 = 65535;
        switch (g3.hashCode()) {
            case 3005871:
                if (g3.equals(Attributes.LayoutDirection.AUTO)) {
                    c4 = 0;
                    break;
                }
                break;
            case 94852023:
                if (g3.equals(Attributes.ImageMode.COVER)) {
                    c4 = 1;
                    break;
                }
                break;
            case 951526612:
                if (g3.equals("contain")) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return a(view, bitmap, a10);
            case 1:
                return b(view, bitmap);
            case 2:
                return a(view, bitmap);
            default:
                return a(view, bitmap, g3, a10);
        }
    }

    public static LayerDrawable createLayerDrawable(Context context) {
        d dVar = new d(context, 0);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{dVar, dVar, dVar, dVar});
        layerDrawable.setId(0, R.id.quick_card_background_color);
        layerDrawable.setId(1, R.id.quick_card_background_image);
        layerDrawable.setId(2, R.id.quick_card_background_linear);
        layerDrawable.setId(3, R.id.quick_card_background_border);
        return layerDrawable;
    }

    public static k parseToBorderDrawable(View view, Border border) {
        return new k(view.getContext(), border);
    }

    public static d parseToColorDrawable(View view, int i10) {
        return new d(view.getContext(), i10);
    }

    public static c parseToImageDrawable(View view, @NonNull Bitmap bitmap) {
        if (view.getContext() != null) {
            return new c(view, bitmap);
        }
        return null;
    }

    public static Bitmap translateToBitmap(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(",");
        if (split.length < 2) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(split[1], 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception unused) {
            CardLogUtils.e(f33783a, "translate to bitmap fail");
            return null;
        } catch (OutOfMemoryError unused2) {
            CardLogUtils.e(f33783a, "translateToBitmap decodeByteArray OutOfMemoryError");
            return null;
        }
    }

    private static float a(View view, String str, float f10, float f11, float f12) {
        if (str.endsWith("%")) {
            f10 *= a(str);
        }
        if (str.endsWith(t.f36232q)) {
            f10 = a(view, str, f10);
        }
        return Attributes.LayoutDirection.AUTO.equals(str) ? f11 / f12 : f10;
    }

    private static b a(View view, Bitmap bitmap, @NonNull String str) {
        float height = bitmap.getHeight();
        float width = bitmap.getWidth();
        if (!Attributes.LayoutDirection.AUTO.equals(str)) {
            float width2 = (bitmap.getWidth() * 1.0f) / bitmap.getHeight();
            if (str.endsWith("%")) {
                height = a(str) * view.getHeight();
                width = height * width2;
            }
            if (str.endsWith(t.f36232q)) {
                height = a(view, str, height);
                width = height * width2;
            }
        }
        return new b(width, height);
    }

    private static float a(String str) {
        float f10;
        try {
            f10 = Float.parseFloat(str.substring(0, str.indexOf("%"))) / 100.0f;
        } catch (NumberFormatException unused) {
            CardLogUtils.e(f33783a, "parse percent value fail!");
            f10 = 1.0f;
        }
        if (f10 < 0.0f) {
            return 1.0f;
        }
        return f10;
    }

    private static float a(View view, String str, float f10) {
        float f11;
        try {
            f11 = ViewUtils.dip2FloatPx(view, Float.parseFloat(str.substring(0, str.indexOf(t.f36232q))));
        } catch (NumberFormatException unused) {
            CardLogUtils.e(f33783a, "parse dp value fail!");
            f11 = f10;
        }
        return f11 < 0.0f ? f10 : f11;
    }

    private static b a(View view, Bitmap bitmap) {
        int height = view.getHeight();
        float width = (bitmap.getWidth() * 1.0f) / bitmap.getHeight();
        float width2 = view.getWidth();
        float f10 = height;
        float f11 = (1.0f * width2) / f10;
        float f12 = width <= f11 ? f10 * width : width2;
        if (width > f11) {
            f10 = width2 / width;
        }
        return new b(f12, f10);
    }

    private static int a(float f10, float f11, LengthValue lengthValue, int i10, View view) {
        if (lengthValue.unit == LengthUnit.DP) {
            if (i10 == -1) {
                return ViewUtils.dip2IntPx(view, lengthValue.value);
            }
            if (i10 == 0) {
                return (int) ((f10 - f11) / 2.0f);
            }
            if (i10 != 1) {
                return 0;
            }
            return (int) ((f10 - f11) - ViewUtils.dip2IntPx(view, lengthValue.value));
        }
        if (i10 == -1) {
            return (int) (lengthValue.value * (f10 - f11));
        }
        if (i10 == 0) {
            return (int) ((f10 - f11) / 2.0f);
        }
        if (i10 != 1) {
            return 0;
        }
        return (int) ((f10 - f11) * (1.0f - lengthValue.value));
    }
}
