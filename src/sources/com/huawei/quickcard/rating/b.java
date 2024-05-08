package com.huawei.quickcard.rating;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.log.CardLogUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f34199a = "RatingDrawableHelper";

    public static Bitmap a(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static Drawable a(View view, @NonNull String str) {
        Bitmap a10;
        if (!str.trim().startsWith("data:image/") || (a10 = a(str)) == null || view.getContext() == null) {
            return null;
        }
        return new BitmapDrawable(view.getContext().getResources(), a10);
    }

    public static Bitmap a(String str) {
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
            CardLogUtils.e(f34199a, "translate to bitmap fail");
            return null;
        } catch (OutOfMemoryError unused2) {
            CardLogUtils.e(f34199a, "translateToBitmap decodeByteArray OutOfMemoryError");
            return null;
        }
    }
}
