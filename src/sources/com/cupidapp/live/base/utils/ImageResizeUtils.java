package com.cupidapp.live.base.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.Size;
import com.cupidapp.live.mediapicker.model.FrameAspectRatio;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImageResizeUtils.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ImageResizeUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ImageResizeUtils f12268a = new ImageResizeUtils();

    /* compiled from: ImageResizeUtils.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum CropPosition {
        START,
        CENTER
    }

    /* compiled from: ImageResizeUtils.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12269a;

        static {
            int[] iArr = new int[CropPosition.values().length];
            try {
                iArr[CropPosition.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CropPosition.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f12269a = iArr;
        }
    }

    public static final Map j(Context context, List sourceUriList, FrameAspectRatio frameAspectRatio) {
        kotlin.jvm.internal.s.i(context, "$context");
        kotlin.jvm.internal.s.i(sourceUriList, "$sourceUriList");
        kotlin.jvm.internal.s.i(frameAspectRatio, "$frameAspectRatio");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        File y10 = z0.k.f54819a.y(context);
        if (y10 == null) {
            return linkedHashMap;
        }
        int size = sourceUriList.size();
        for (int i10 = 0; i10 < size; i10++) {
            String str = (String) sourceUriList.get(i10);
            String e2 = l1.a.e(str + "_" + frameAspectRatio.getRatio());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(e2);
            sb2.append(".jpg");
            File file = new File(y10, sb2.toString());
            if (!file.exists()) {
                Bitmap r10 = z0.f.r(context, str);
                if (r10 == null) {
                    return linkedHashMap;
                }
                ImageResizeUtils imageResizeUtils = f12268a;
                imageResizeUtils.s(imageResizeUtils.g(r10, frameAspectRatio), file);
            }
            String absolutePath = file.getAbsolutePath();
            kotlin.jvm.internal.s.h(absolutePath, "targetFile.absolutePath");
            linkedHashMap.put(str, absolutePath);
        }
        return linkedHashMap;
    }

    public static final void k(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void l(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final Map o(Function2 function2, Context context, List sourceUriList, FrameAspectRatio frameAspectRatio) {
        Bitmap g3;
        kotlin.jvm.internal.s.i(context, "$context");
        kotlin.jvm.internal.s.i(sourceUriList, "$sourceUriList");
        if (function2 != null) {
            function2.mo1743invoke(0, 1);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        File x10 = z0.k.f54819a.x(context);
        if (x10 == null) {
            return linkedHashMap;
        }
        int size = sourceUriList.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (function2 != null) {
                function2.mo1743invoke(Integer.valueOf(i10), 2);
            }
            String str = (String) sourceUriList.get(i10);
            File file = new File(x10, l1.a.e(str) + ".jpg");
            if (!file.exists()) {
                if (function2 != null) {
                    function2.mo1743invoke(Integer.valueOf(i10), 3);
                }
                Bitmap r10 = z0.f.r(context, str);
                if (r10 == null) {
                    return linkedHashMap;
                }
                if (function2 != null) {
                    function2.mo1743invoke(Integer.valueOf(i10), 4);
                }
                int o10 = z0.f.o(context, str);
                if (function2 != null) {
                    function2.mo1743invoke(Integer.valueOf(i10), 5);
                }
                ImageResizeUtils imageResizeUtils = f12268a;
                Bitmap t2 = imageResizeUtils.t(r10);
                if (function2 != null) {
                    function2.mo1743invoke(Integer.valueOf(i10), 6);
                }
                Bitmap r11 = imageResizeUtils.r(t2, o10);
                if (function2 != null) {
                    function2.mo1743invoke(Integer.valueOf(i10), 7);
                }
                if (frameAspectRatio == null) {
                    g3 = imageResizeUtils.h(r11);
                } else {
                    g3 = imageResizeUtils.g(r11, frameAspectRatio);
                }
                if (function2 != null) {
                    function2.mo1743invoke(Integer.valueOf(i10), 8);
                }
                imageResizeUtils.s(g3, file);
            }
            if (function2 != null) {
                function2.mo1743invoke(Integer.valueOf(i10), 9);
            }
            String absolutePath = file.getAbsolutePath();
            kotlin.jvm.internal.s.h(absolutePath, "targetFile.absolutePath");
            linkedHashMap.put(str, absolutePath);
        }
        return linkedHashMap;
    }

    public static final void p(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void q(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final Bitmap g(Bitmap bitmap, FrameAspectRatio frameAspectRatio) {
        Bitmap tempBitmap;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f10 = width;
        float f11 = height;
        float f12 = (1.0f * f10) / f11;
        if (f12 < frameAspectRatio.getRatio()) {
            tempBitmap = Bitmap.createBitmap(bitmap, 0, (int) ((height - r10) * 0.5f), width, (int) (f10 / frameAspectRatio.getRatio()));
        } else if (f12 > frameAspectRatio.getRatio()) {
            tempBitmap = Bitmap.createBitmap(bitmap, (int) ((width - r10) * 0.5f), 0, (int) (f11 * frameAspectRatio.getRatio()), height);
        } else {
            tempBitmap = bitmap;
        }
        if (!kotlin.jvm.internal.s.d(tempBitmap, bitmap)) {
            bitmap.recycle();
        }
        kotlin.jvm.internal.s.h(tempBitmap, "tempBitmap");
        return tempBitmap;
    }

    public final Bitmap h(Bitmap bitmap) {
        CropPosition cropPosition;
        Bitmap croppedBitmap;
        if ((Math.max(bitmap.getHeight(), bitmap.getWidth()) * 1.0f) / Math.min(bitmap.getHeight(), bitmap.getWidth()) > 2.2222223f) {
            Size size = new Size(bitmap.getWidth(), bitmap.getHeight());
            if (size.getWidth() < size.getHeight()) {
                cropPosition = CropPosition.START;
            } else {
                cropPosition = CropPosition.CENTER;
            }
            try {
                int i10 = a.f12269a[cropPosition.ordinal()];
                if (i10 == 1) {
                    croppedBitmap = Bitmap.createBitmap(bitmap, 0, 0, size.getWidth(), (int) (size.getWidth() * 2.2222223f));
                } else {
                    if (i10 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    int height = (int) (size.getHeight() * 2.2222223f);
                    int width = (size.getWidth() - height) / 2;
                    if (width < 0) {
                        width = 0;
                    }
                    croppedBitmap = Bitmap.createBitmap(bitmap, width, 0, height, size.getHeight());
                }
                bitmap.recycle();
                kotlin.jvm.internal.s.h(croppedBitmap, "croppedBitmap");
                return croppedBitmap;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return bitmap;
    }

    public final void i(@NotNull final Context context, @Nullable com.cupidapp.live.base.network.g gVar, @NotNull final FrameAspectRatio frameAspectRatio, @NotNull final List<String> sourceUriList, @NotNull final Function1<? super Map<String, String>, kotlin.p> resizeFinished) {
        kotlin.jvm.internal.s.i(context, "context");
        kotlin.jvm.internal.s.i(frameAspectRatio, "frameAspectRatio");
        kotlin.jvm.internal.s.i(sourceUriList, "sourceUriList");
        kotlin.jvm.internal.s.i(resizeFinished, "resizeFinished");
        Observable observeOn = Observable.fromCallable(new Callable() { // from class: com.cupidapp.live.base.utils.y
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Map j10;
                j10 = ImageResizeUtils.j(context, sourceUriList, frameAspectRatio);
                return j10;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<Map<String, String>, kotlin.p> function1 = new Function1<Map<String, String>, kotlin.p>() { // from class: com.cupidapp.live.base.utils.ImageResizeUtils$generateUploadImageFile$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Map<String, String> map) {
                invoke2(map);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Map<String, String> map) {
                resizeFinished.invoke(map);
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.base.utils.u
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ImageResizeUtils.k(Function1.this, obj);
            }
        };
        final Function1<Throwable, kotlin.p> function12 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.base.utils.ImageResizeUtils$generateUploadImageFile$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                resizeFinished.invoke(null);
            }
        };
        Disposable it = observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.base.utils.v
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ImageResizeUtils.l(Function1.this, obj);
            }
        });
        if (gVar != null) {
            kotlin.jvm.internal.s.h(it, "it");
            gVar.H(it);
        }
    }

    public final void m(@NotNull final Context context, @Nullable com.cupidapp.live.base.network.g gVar, @NotNull final List<String> sourceUriList, @NotNull final Function1<? super Map<String, String>, kotlin.p> resizeFinished, @Nullable final Function2<? super Integer, ? super Integer, kotlin.p> function2, @Nullable final FrameAspectRatio frameAspectRatio) {
        kotlin.jvm.internal.s.i(context, "context");
        kotlin.jvm.internal.s.i(sourceUriList, "sourceUriList");
        kotlin.jvm.internal.s.i(resizeFinished, "resizeFinished");
        Observable observeOn = Observable.fromCallable(new Callable() { // from class: com.cupidapp.live.base.utils.z
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Map o10;
                o10 = ImageResizeUtils.o(Function2.this, context, sourceUriList, frameAspectRatio);
                return o10;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<Map<String, String>, kotlin.p> function1 = new Function1<Map<String, String>, kotlin.p>() { // from class: com.cupidapp.live.base.utils.ImageResizeUtils$imageResize$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Map<String, String> map) {
                invoke2(map);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Map<String, String> map) {
                resizeFinished.invoke(map);
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.base.utils.x
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ImageResizeUtils.p(Function1.this, obj);
            }
        };
        final Function1<Throwable, kotlin.p> function12 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.base.utils.ImageResizeUtils$imageResize$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                resizeFinished.invoke(null);
            }
        };
        Disposable it = observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.base.utils.w
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ImageResizeUtils.q(Function1.this, obj);
            }
        });
        if (gVar != null) {
            kotlin.jvm.internal.s.h(it, "it");
            gVar.H(it);
        }
    }

    public final Bitmap r(Bitmap bitmap, int i10) {
        Matrix matrix = new Matrix();
        switch (i10) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
            default:
                return bitmap;
        }
        try {
            Bitmap rotatedBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
            bitmap.recycle();
            kotlin.jvm.internal.s.h(rotatedBitmap, "rotatedBitmap");
            return rotatedBitmap;
        } catch (Throwable th) {
            th.printStackTrace();
            return bitmap;
        }
    }

    public final boolean s(Bitmap bitmap, File file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, fileOutputStream);
            fileOutputStream.close();
            bitmap.recycle();
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final Bitmap t(Bitmap bitmap) {
        int min = Math.min(bitmap.getHeight(), bitmap.getWidth());
        if (min > 1800) {
            float f10 = 1800.0f / min;
            Matrix matrix = new Matrix();
            matrix.setScale(f10, f10);
            try {
                Bitmap scaledBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
                bitmap.recycle();
                kotlin.jvm.internal.s.h(scaledBitmap, "scaledBitmap");
                return scaledBitmap;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return bitmap;
    }
}
