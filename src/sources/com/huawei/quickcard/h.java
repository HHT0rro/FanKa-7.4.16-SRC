package com.huawei.quickcard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.framework.blur.OnBlurListener;
import com.huawei.quickcard.framework.event.CardEvent;
import com.huawei.quickcard.framework.event.Subscriber;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.utils.YogaUtils;
import com.huawei.quickcard.views.image.view.BitmapHolder;
import com.huawei.quickcard.views.image.view.LayoutHolder;
import com.huawei.uikit.hweffect.engine.HwBlurEngine;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class h {

    /* renamed from: f, reason: collision with root package name */
    private static final String f33995f = "BlurBitmap";

    /* renamed from: g, reason: collision with root package name */
    private static final int f33996g = 855638016;

    /* renamed from: h, reason: collision with root package name */
    private static final float f33997h = 16.0f;

    /* renamed from: i, reason: collision with root package name */
    private static final int f33998i = 15;

    /* renamed from: a, reason: collision with root package name */
    private final View f33999a;

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f34000b;

    /* renamed from: c, reason: collision with root package name */
    private i f34001c;

    /* renamed from: d, reason: collision with root package name */
    private float[] f34002d;

    /* renamed from: e, reason: collision with root package name */
    private OnBlurListener f34003e;

    public h(@NonNull View view) {
        this.f33999a = view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(View view) {
        this.f33999a.setBackgroundColor(f33996g);
        if (view instanceof BitmapHolder) {
            BitmapHolder bitmapHolder = (BitmapHolder) view;
            KeyEvent.Callback callback = this.f33999a;
            bitmapHolder.setOnBitmapAvailable(new BitmapHolder.OnBitmapAvailable() { // from class: com.huawei.quickcard.p2
                @Override // com.huawei.quickcard.views.image.view.BitmapHolder.OnBitmapAvailable
                public final void onAvailable(View view2, Bitmap bitmap) {
                    h.this.a(view2, bitmap);
                }
            }, callback instanceof LayoutHolder ? (LayoutHolder) callback : null);
        }
    }

    private Bitmap c(Bitmap bitmap) {
        if (!a(this.f34002d)) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Path path = new Path();
        path.addRoundRect(new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight()), this.f34002d, Path.Direction.CW);
        Paint paint = new Paint(1);
        paint.setColor(-1);
        canvas.drawPath(path, paint);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public void a(@NonNull final i iVar, @NonNull OnBlurListener onBlurListener) {
        this.f34003e = onBlurListener;
        a(iVar);
        CardContext cardContext = ViewUtils.getCardContext(this.f33999a);
        View viewById = ViewUtils.getViewById(cardContext, iVar.f());
        if (viewById == null) {
            cardContext.eventBus().register(y1.f34750c, new Subscriber() { // from class: com.huawei.quickcard.o2
                @Override // com.huawei.quickcard.framework.event.Subscriber
                public final void onEvent(CardEvent cardEvent) {
                    h.this.a(iVar, cardEvent);
                }
            });
        } else {
            b(viewById);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(i iVar, CardEvent cardEvent) {
        if (cardEvent instanceof y1) {
            y1 y1Var = (y1) cardEvent;
            if (iVar.f().equals(y1Var.b())) {
                b(y1Var.a());
            }
        }
    }

    private Bitmap b(Bitmap bitmap) {
        try {
            Class.forName("com.huawei.uikit.hweffect.engine.HwBlurEngine");
            return HwBlurEngine.blur(bitmap, this.f34001c.a(), 1);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        Bitmap bitmap2 = this.f34000b;
        if (bitmap2 == null || bitmap2 != bitmap) {
            this.f34000b = bitmap;
            a(bitmap, a(view));
        }
    }

    private void a(@NonNull Bitmap bitmap, int[] iArr) {
        try {
            int width = this.f33999a.getWidth();
            int height = this.f33999a.getHeight();
            if (width <= 0) {
                width = (int) YogaUtils.getNodeWidth(this.f33999a);
            }
            if (height <= 0) {
                height = (int) YogaUtils.getNodeHeight(this.f33999a);
            }
            if (width > 0 && height > 0) {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, iArr[0], iArr[1], width, height);
                if (createBitmap == null) {
                    return;
                }
                int round = Math.round(createBitmap.getWidth() / 16.0f);
                int round2 = Math.round(createBitmap.getHeight() / 16.0f);
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, round, round2, false);
                createBitmap.recycle();
                Bitmap b4 = b(createScaledBitmap);
                if (b4 == null) {
                    CardLogUtils.w(f33995f, "blur with hwEngine failed.");
                    b4 = a(this.f33999a.getContext(), createScaledBitmap);
                }
                createScaledBitmap.recycle();
                if (b4 == null) {
                    CardLogUtils.w(f33995f, "blur bitmap failed.");
                    return;
                }
                Matrix matrix = new Matrix();
                matrix.postScale(16.0f, 16.0f);
                Bitmap createBitmap2 = Bitmap.createBitmap(b4, 0, 0, round, round2, matrix, true);
                b4.recycle();
                Bitmap c4 = c(createBitmap2);
                a(c4);
                OnBlurListener onBlurListener = this.f34003e;
                if (onBlurListener != null) {
                    onBlurListener.onBlur(c4);
                    return;
                }
                return;
            }
            CardLogUtils.e(f33995f, "makeBitmap fail cause width or height equals zero");
        } catch (IllegalArgumentException e2) {
            CardLogUtils.w(f33995f, "clip bitmap failed", e2);
        }
    }

    private Bitmap a(Context context, Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap);
        RenderScript create = RenderScript.create(context);
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
        Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
        Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
        create2.setRadius(this.f34001c.a());
        create2.setInput(createFromBitmap);
        create2.forEach(createFromBitmap2);
        createFromBitmap2.copyTo(createBitmap);
        create.destroy();
        return createBitmap;
    }

    private static boolean a(float[] fArr) {
        if (fArr == null) {
            return false;
        }
        for (float f10 : fArr) {
            if (f10 > 0.0f) {
                return true;
            }
        }
        return false;
    }

    private void a(Bitmap bitmap) {
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(1.5f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        Canvas canvas = new Canvas(bitmap);
        canvas.drawBitmap(bitmap, new Matrix(), paint);
        canvas.drawColor(f33996g, PorterDuff.Mode.SRC_ATOP);
    }

    public int[] a(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        this.f33999a.getLocationInWindow(iArr2);
        int i10 = iArr2[0] - iArr[0];
        if (i10 < 0) {
            i10 = 0;
        }
        int i11 = iArr2[1] - iArr[1];
        if (i11 < 0) {
            i11 = 0;
        }
        return new int[]{Math.min(this.f33999a.getLeft(), i10), Math.min(this.f33999a.getTop(), i11)};
    }

    private void a(i iVar) {
        this.f34001c = iVar;
        if (iVar.a() < 3 || iVar.a() > 25) {
            iVar.a(15);
        }
        if (this.f34002d == null) {
            this.f34002d = new float[8];
        }
        float configDensity = ViewUtils.getConfigDensity(this.f33999a.getContext(), ViewUtils.getCardContext(this.f33999a));
        if (iVar.d() > 0.0f) {
            float dip2FloatPx = ViewUtils.dip2FloatPx(configDensity, iVar.d());
            float[] fArr = this.f34002d;
            fArr[0] = dip2FloatPx;
            fArr[1] = dip2FloatPx;
        }
        if (iVar.e() > 0.0f) {
            float dip2FloatPx2 = ViewUtils.dip2FloatPx(configDensity, iVar.e());
            float[] fArr2 = this.f34002d;
            fArr2[2] = dip2FloatPx2;
            fArr2[3] = dip2FloatPx2;
        }
        if (iVar.c() > 0.0f) {
            float dip2FloatPx3 = ViewUtils.dip2FloatPx(configDensity, iVar.c());
            float[] fArr3 = this.f34002d;
            fArr3[4] = dip2FloatPx3;
            fArr3[5] = dip2FloatPx3;
        }
        if (iVar.b() > 0.0f) {
            float dip2FloatPx4 = ViewUtils.dip2FloatPx(configDensity, iVar.b());
            float[] fArr4 = this.f34002d;
            fArr4[6] = dip2FloatPx4;
            fArr4[7] = dip2FloatPx4;
        }
    }
}
