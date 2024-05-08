package z0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.cupidapp.live.base.extension.ImageAttributeModel;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BitmapExtension.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class f {
    @Nullable
    public static final Bitmap a(@NotNull Bitmap bitmap, int i10, int i11, @NotNull RectF dstRect) {
        kotlin.jvm.internal.s.i(bitmap, "<this>");
        kotlin.jvm.internal.s.i(dstRect, "dstRect");
        if (i10 <= 0 || i11 <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawARGB(0, 0, 0, 0);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-1);
        canvas.drawBitmap(bitmap, (Rect) null, dstRect, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        canvas.drawRect(0.0f, 0.0f, i10, i11, paint);
        return createBitmap;
    }

    @Nullable
    public static final Bitmap b(@Nullable Context context, @NotNull String pathOrUriString, float f10, float f11, float f12, float f13) {
        int o10;
        BitmapFactory.Options n10;
        BitmapRegionDecoder newInstance;
        Bitmap d10;
        kotlin.jvm.internal.s.i(pathOrUriString, "pathOrUriString");
        InputStream q10 = q(context, pathOrUriString);
        Bitmap bitmap = null;
        try {
            if (q10 != null) {
                try {
                    o10 = o(context, pathOrUriString);
                    n10 = n(context, pathOrUriString);
                    newInstance = BitmapRegionDecoder.newInstance(q10, false);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (o10 != 6 && o10 != 8) {
                    int i10 = n10.outWidth;
                    int i11 = n10.outHeight;
                    Rect rect = new Rect((int) (i10 * f10), (int) (i11 * f11), (int) (i10 * f12), (int) (i11 * f13));
                    if (newInstance != null) {
                        d10 = newInstance.decodeRegion(rect, n10);
                    }
                } else {
                    int i12 = n10.outWidth;
                    int i13 = n10.outHeight;
                    d10 = d(newInstance != null ? newInstance.decodeRegion(new Rect((int) (i12 * f11), (int) (i13 * f10), (int) (i12 * f13), (int) (i13 * f12)), n10) : null, context, pathOrUriString);
                }
                bitmap = d10;
            }
            return bitmap;
        } finally {
            e(q10);
        }
    }

    @NotNull
    public static final byte[] c(@NotNull Bitmap bitmap, int i10) {
        int height;
        int height2;
        kotlin.jvm.internal.s.i(bitmap, "<this>");
        if (bitmap.getHeight() > bitmap.getWidth()) {
            height = bitmap.getWidth();
            height2 = bitmap.getWidth();
        } else {
            height = bitmap.getHeight();
            height2 = bitmap.getHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(height, height2, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        while (true) {
            canvas.drawBitmap(bitmap, new Rect(0, 0, height, height2), new Rect(0, 0, height, height2), (Paint) null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(Bitmap.CompressFormat.JPEG, i10, byteArrayOutputStream);
            createBitmap.recycle();
            byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                kotlin.jvm.internal.s.h(arrayOfByte, "arrayOfByte");
                return arrayOfByte;
            } catch (Exception e2) {
                e2.printStackTrace();
                height = bitmap.getHeight();
                height2 = bitmap.getHeight();
            }
        }
    }

    @Nullable
    public static final Bitmap d(@Nullable Bitmap bitmap, @Nullable Context context, @NotNull String pathOrUriString) {
        kotlin.jvm.internal.s.i(pathOrUriString, "pathOrUriString");
        if (bitmap == null) {
            return null;
        }
        try {
            float p10 = p(context, pathOrUriString);
            if (!(p10 == 0.0f)) {
                Matrix matrix = new Matrix();
                matrix.preRotate(p10);
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            }
            return bitmap;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static final void e(@Nullable InputStream inputStream) {
        if (inputStream == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @NotNull
    public static final File f(@NotNull Bitmap bitmap, @NotNull File file, int i10) {
        kotlin.jvm.internal.s.i(bitmap, "<this>");
        kotlin.jvm.internal.s.i(file, "file");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        bitmap.compress(Bitmap.CompressFormat.JPEG, i10, fileOutputStream);
        fileOutputStream.close();
        bitmap.recycle();
        return file;
    }

    public static /* synthetic */ File g(Bitmap bitmap, File file, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 90;
        }
        return f(bitmap, file, i10);
    }

    @Nullable
    public static final byte[] h(@NotNull Bitmap bitmap, int i10) {
        ByteArrayOutputStream byteArrayOutputStream;
        kotlin.jvm.internal.s.i(bitmap, "<this>");
        byte[] bArr = null;
        bArr = null;
        bArr = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i10, byteArrayOutputStream);
                    bArr = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } catch (Exception unused) {
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return bArr;
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return bArr;
    }

    public static /* synthetic */ byte[] i(Bitmap bitmap, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 90;
        }
        return h(bitmap, i10);
    }

    @Nullable
    public static final Bitmap j(@Nullable Context context, @Nullable String str, int i10) {
        Bitmap bitmap;
        if (context != null) {
            boolean z10 = true;
            if (!(str == null || str.length() == 0)) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                InputStream q10 = q(context, str);
                if (q10 == null) {
                    return null;
                }
                try {
                    try {
                        bitmap = BitmapFactory.decodeStream(q10, null, options);
                    } catch (IllegalArgumentException e2) {
                        e2.printStackTrace();
                        e(q10);
                        bitmap = null;
                    }
                    int i11 = options.outWidth;
                    options.inSampleSize = i11 > i10 ? i11 / i10 : 1;
                    options.inJustDecodeBounds = false;
                    while (z10) {
                        q10 = q(context, str);
                        if (q10 == null) {
                            return null;
                        }
                        try {
                            bitmap = BitmapFactory.decodeStream(q10, null, options);
                            e(q10);
                            z10 = false;
                        } catch (Exception unused) {
                            return null;
                        } catch (OutOfMemoryError unused2) {
                        } finally {
                        }
                    }
                    return bitmap;
                } finally {
                }
            }
        }
        return null;
    }

    @Nullable
    public static final Bitmap k(@NotNull Context context, @NotNull String pathOrUriString, boolean z10, int i10) {
        int o10;
        Bitmap decodeStream;
        float f10;
        int width;
        float f11;
        kotlin.jvm.internal.s.i(context, "context");
        kotlin.jvm.internal.s.i(pathOrUriString, "pathOrUriString");
        InputStream q10 = q(context, pathOrUriString);
        Bitmap bitmap = null;
        if (q10 != null) {
            try {
                try {
                    o10 = o(context, pathOrUriString);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = false;
                    decodeStream = BitmapFactory.decodeStream(q10, null, options);
                } finally {
                    e(q10);
                }
            } catch (Exception e2) {
                e = e2;
            }
            if (decodeStream != null) {
                try {
                    if (z10) {
                        if (o10 != 6 && o10 != 8) {
                            f10 = i10;
                            width = decodeStream.getWidth();
                        } else {
                            f10 = i10;
                            width = decodeStream.getHeight();
                        }
                    } else if (o10 != 6 && o10 != 8) {
                        f10 = i10;
                        width = decodeStream.getHeight();
                    } else {
                        f10 = i10;
                        width = decodeStream.getWidth();
                    }
                    f11 = f10 / width;
                } catch (Exception e10) {
                    e = e10;
                    bitmap = decodeStream;
                    e.printStackTrace();
                    return bitmap;
                }
                if (f11 < 1.0f) {
                    bitmap = u(decodeStream, f11);
                }
            }
            bitmap = decodeStream;
        }
        return bitmap;
    }

    @NotNull
    public static final ImageAttributeModel l(@Nullable Context context, @Nullable String str) {
        BitmapFactory.Options n10 = n(context, str);
        int o10 = o(context, str);
        int i10 = n10.outWidth;
        int i11 = n10.outHeight;
        if (o10 == 6 || o10 == 8) {
            i11 = i10;
            i10 = i11;
        }
        return new ImageAttributeModel(i10, i11, i10 < i11, o10);
    }

    @NotNull
    public static final BitmapFactory.Options m(@Nullable Context context, int i10) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context != null ? context.getResources() : null, i10, options);
        return options;
    }

    @NotNull
    public static final BitmapFactory.Options n(@Nullable Context context, @Nullable String str) {
        InputStream q10 = q(context, str);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        if (q10 != null) {
            try {
                try {
                    BitmapFactory.decodeStream(q10, null, options);
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                }
            } finally {
                e(q10);
            }
        }
        return options;
    }

    public static final int o(@Nullable Context context, @Nullable String str) {
        InputStream q10 = q(context, str);
        int i10 = 0;
        if (q10 != null) {
            try {
                try {
                    i10 = new ExifInterface(q10).getAttributeInt(ExifInterface.TAG_ORIENTATION, 0);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } finally {
                e(q10);
            }
        }
        return i10;
    }

    public static final float p(@Nullable Context context, @NotNull String pathOrUriString) {
        kotlin.jvm.internal.s.i(pathOrUriString, "pathOrUriString");
        int o10 = o(context, pathOrUriString);
        if (o10 == 3) {
            return 180.0f;
        }
        if (o10 != 6) {
            return o10 != 8 ? 0.0f : 270.0f;
        }
        return 90.0f;
    }

    @Nullable
    public static final InputStream q(@Nullable Context context, @Nullable String str) {
        Uri b4;
        if (context == null) {
            return null;
        }
        if ((str == null || str.length() == 0) || (b4 = w.f54826a.b(str)) == null) {
            return null;
        }
        try {
            return context.getContentResolver().openInputStream(b4);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Nullable
    public static final Bitmap r(@NotNull Context context, @NotNull String pathOrUriString) {
        kotlin.jvm.internal.s.i(context, "context");
        kotlin.jvm.internal.s.i(pathOrUriString, "pathOrUriString");
        InputStream q10 = q(context, pathOrUriString);
        Bitmap bitmap = null;
        if (q10 != null) {
            try {
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = false;
                    bitmap = BitmapFactory.decodeStream(q10, null, options);
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                }
            } finally {
                e(q10);
            }
        }
        return bitmap;
    }

    @Nullable
    public static final Bitmap s(@NotNull Bitmap bitmap, @NotNull Context context, @NotNull String pathOrUriString) {
        kotlin.jvm.internal.s.i(bitmap, "<this>");
        kotlin.jvm.internal.s.i(context, "context");
        kotlin.jvm.internal.s.i(pathOrUriString, "pathOrUriString");
        InputStream q10 = q(context, pathOrUriString);
        if (q10 == null) {
            return null;
        }
        int attributeInt = new ExifInterface(q10).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        float f10 = attributeInt != 3 ? attributeInt != 6 ? attributeInt != 8 ? 0.0f : 270.0f : 90.0f : 180.0f;
        Matrix matrix = new Matrix();
        matrix.setRotate(f10);
        e(q10);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    @Nullable
    public static final Bitmap t(@NotNull Bitmap bitmap, float f10) {
        kotlin.jvm.internal.s.i(bitmap, "<this>");
        if (f10 == 0.0f) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(f10);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    @NotNull
    public static final Bitmap u(@NotNull Bitmap bitmap, float f10) {
        kotlin.jvm.internal.s.i(bitmap, "<this>");
        Matrix matrix = new Matrix();
        matrix.setScale(f10, f10);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        kotlin.jvm.internal.s.h(createBitmap, "createBitmap(this, 0, 0,…his.height, matrix, true)");
        return createBitmap;
    }
}
