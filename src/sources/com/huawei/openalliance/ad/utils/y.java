package com.huawei.openalliance.ad.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bumptech.glide.Registry;
import com.huawei.hms.ads.eo;
import com.huawei.hms.ads.fi;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class y {
    private static final String Code = "ImageUtil";
    private static final byte[] V = new byte[0];
    private static final Map<String, Set<aj>> I = new HashMap();

    private static Set<aj> B(String str) {
        return I.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void C(String str) {
        synchronized (V) {
            Set<aj> B = B(str);
            if (B != null) {
                Iterator<aj> iterator2 = B.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().Code();
                }
            }
            Z(str);
        }
    }

    private static int Code(InputStream inputStream) {
        try {
            String Code2 = p.Code(inputStream);
            if (com.huawei.openalliance.ad.constant.u.an.equals(Code2)) {
                return 4;
            }
            return Code2 != null ? 2 : 100;
        } catch (Resources.NotFoundException unused) {
            gl.Z(Code, "resId is not found");
            return 100;
        }
    }

    public static Bitmap Code(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            gl.V(Code, Registry.BUCKET_BITMAP_DRAWABLE);
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight <= 0) {
            intrinsicHeight = 1;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth > 0 ? intrinsicWidth : 1, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Code(drawable, createBitmap);
        return createBitmap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r7v12, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r7v15, types: [android.graphics.drawable.Drawable] */
    private static Pair<Drawable, String> Code(Context context, String str) {
        Object obj;
        Object obj2;
        String str2 = "OOM read image";
        BitmapFactory.Options options = new BitmapFactory.Options();
        Object obj3 = null;
        try {
            options.inJustDecodeBounds = false;
            try {
            } catch (OutOfMemoryError unused) {
                obj3 = str;
                gl.I(Code, "OOM read image");
                obj = obj3;
                return new Pair<>(obj, str2);
            } catch (Throwable th) {
                th = th;
                obj3 = str;
                String str3 = "loadImageFromDisk " + th.getClass().getSimpleName();
                gl.I(Code, "loadImageFromDisk " + th.getClass().getSimpleName());
                str2 = str3;
                obj = obj3;
                return new Pair<>(obj, str2);
            }
        } catch (OutOfMemoryError unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
        if (str.startsWith(bq.RES.toString())) {
            Pair<Drawable, String> I2 = I(options, str, context);
            ?? r72 = (Drawable) I2.first;
            obj2 = I2.second;
            str = r72;
        } else if (str.startsWith(bq.ASSET.toString())) {
            Pair<Drawable, String> V2 = V(options, str, context);
            ?? r73 = (Drawable) V2.first;
            obj2 = V2.second;
            str = r73;
        } else {
            if (!str.startsWith(bq.CONTENT.toString())) {
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                if (decodeFile == null) {
                    gl.V(Code, "Image decode fail");
                    am.Code(context).V((Integer) 0);
                }
                obj = new BitmapDrawable(context.getResources(), decodeFile);
                str2 = null;
                return new Pair<>(obj, str2);
            }
            Pair<Drawable, String> Code2 = Code(options, str, context);
            ?? r74 = (Drawable) Code2.first;
            obj2 = Code2.second;
            str = r74;
        }
        str2 = (String) obj2;
        obj = str;
        return new Pair<>(obj, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.io.Closeable] */
    private static Pair<Drawable, String> Code(BitmapFactory.Options options, String str, Context context) {
        ?? r92;
        InputStream inputStream;
        InputStream inputStream2;
        String str2;
        String str3;
        InputStream inputStream3 = null;
        try {
            try {
                Uri parse = Uri.parse(str);
                ContentResolver contentResolver = context.getContentResolver();
                inputStream2 = contentResolver.openInputStream(parse);
                try {
                    if (Code(inputStream2) == 4) {
                        Pair<Drawable, String> pair = new Pair<>(new fi(context, str), null);
                        at.Code((Closeable) inputStream2);
                        at.Code((Closeable) null);
                        return pair;
                    }
                    inputStream = contentResolver.openInputStream(parse);
                    try {
                        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                        if (decodeStream == null) {
                            gl.V(Code, "Image decode fail");
                            am.Code(context).V((Integer) 0);
                        }
                        Pair<Drawable, String> pair2 = new Pair<>(new BitmapDrawable(context.getResources(), decodeStream), null);
                        at.Code((Closeable) inputStream2);
                        at.Code((Closeable) inputStream);
                        return pair2;
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        str2 = "loadFromProvider FileNotFoundException";
                        str3 = "lfP " + e.getClass().getSimpleName();
                        gl.I(Code, str3);
                        at.Code((Closeable) inputStream2);
                        at.Code((Closeable) inputStream);
                        return new Pair<>(null, str2);
                    } catch (Exception e10) {
                        e = e10;
                        str2 = "loadFromProvider " + e.getClass().getSimpleName();
                        str3 = "lfP " + e.getClass().getSimpleName();
                        gl.I(Code, str3);
                        at.Code((Closeable) inputStream2);
                        at.Code((Closeable) inputStream);
                        return new Pair<>(null, str2);
                    }
                } catch (FileNotFoundException e11) {
                    e = e11;
                    inputStream = null;
                } catch (Exception e12) {
                    e = e12;
                    inputStream = null;
                } catch (Throwable th) {
                    th = th;
                    str = null;
                    inputStream3 = inputStream2;
                    r92 = str;
                    at.Code((Closeable) inputStream3);
                    at.Code((Closeable) r92);
                    throw th;
                }
            } catch (FileNotFoundException e13) {
                e = e13;
                inputStream = null;
                inputStream2 = null;
            } catch (Exception e14) {
                e = e14;
                inputStream = null;
                inputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                r92 = 0;
                at.Code((Closeable) inputStream3);
                at.Code((Closeable) r92);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void Code(Context context, SourceParam sourceParam, aj ajVar) {
        Code(context.getApplicationContext(), sourceParam, (String) null, ajVar);
    }

    public static void Code(final Context context, final SourceParam sourceParam, final String str, final aj ajVar) {
        if (sourceParam == null || sourceParam.B() == null) {
            ajVar.Code();
            V(context, 1, sourceParam, "url is null");
            return;
        }
        gl.V(Code, "load: " + bc.Code(sourceParam.B()));
        f.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.y.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (y.V) {
                    String B = SourceParam.this.B();
                    if (y.I(B)) {
                        y.V(B, ajVar);
                        return;
                    }
                    y.V(B, ajVar);
                    if (y.V(context, SourceParam.this.B(), SourceParam.this.B(), SourceParam.this)) {
                        return;
                    }
                    f.V(new Runnable() { // from class: com.huawei.openalliance.ad.utils.y.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            y.V(context, SourceParam.this, str);
                        }
                    });
                }
            }
        });
    }

    private static void Code(Drawable drawable, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
    }

    private static void Code(String str, Drawable drawable) {
        synchronized (V) {
            Set<aj> B = B(str);
            if (B != null) {
                Iterator<aj> iterator2 = B.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().Code(str, drawable);
                }
            }
            Z(str);
        }
    }

    private static Pair<Drawable, String> I(BitmapFactory.Options options, String str, Context context) {
        String str2;
        BitmapDrawable bitmapDrawable = null;
        try {
            Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), Integer.parseInt(str.substring(bq.RES.toString().length())), options);
            if (decodeResource == null) {
                gl.V(Code, "Image decode fail");
                am.Code(context).V((Integer) 0);
            }
            BitmapDrawable bitmapDrawable2 = new BitmapDrawable(context.getResources(), decodeResource);
            str2 = null;
            bitmapDrawable = bitmapDrawable2;
        } catch (Resources.NotFoundException e2) {
            gl.I(Code, "loadImage " + e2.getClass().getSimpleName());
            str2 = "loadResImg Resources.NotFoundException";
        } catch (NumberFormatException e10) {
            gl.I(Code, "loadImage " + e10.getClass().getSimpleName());
            str2 = "loadResImg NumberFormatException";
        }
        return new Pair<>(bitmapDrawable, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean I(String str) {
        boolean containsKey;
        synchronized (V) {
            containsKey = I.containsKey(str);
        }
        return containsKey;
    }

    private static Drawable S(String str) {
        return x.Code().Code(aq.Code(str));
    }

    public static Bitmap V(Drawable drawable) {
        Bitmap Code2;
        if (drawable == null || (Code2 = Code(drawable)) == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(-1.0f, 1.0f);
        return Bitmap.createBitmap(Code2, 0, 0, Code2.getWidth(), Code2.getHeight(), matrix, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v5 */
    private static Pair<Drawable, String> V(BitmapFactory.Options options, String str, Context context) {
        InputStream inputStream;
        String str2;
        String substring = str.substring(bq.ASSET.toString().length());
        ?? r12 = 0;
        BitmapDrawable bitmapDrawable = null;
        try {
            try {
                inputStream = context.getAssets().open(substring);
            } catch (IOException e2) {
                e = e2;
                inputStream = null;
            } catch (Throwable th) {
                th = th;
                at.Code((Closeable) r12);
                throw th;
            }
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                if (decodeStream == null) {
                    gl.V(Code, "Image decode fail");
                    am.Code(context).V((Integer) 0);
                }
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(context.getResources(), decodeStream);
                at.Code((Closeable) inputStream);
                str2 = null;
                bitmapDrawable = bitmapDrawable2;
            } catch (IOException e10) {
                e = e10;
                str2 = "loadAssetImg " + e.getClass().getSimpleName();
                gl.I(Code, "lAI " + e.getClass().getSimpleName());
                at.Code((Closeable) inputStream);
                return new Pair<>(bitmapDrawable, str2);
            }
            return new Pair<>(bitmapDrawable, str2);
        } catch (Throwable th2) {
            th = th2;
            r12 = substring;
            at.Code((Closeable) r12);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(Context context, int i10, SourceParam sourceParam, String str) {
        if (sourceParam == null || sourceParam.F() == null) {
            return;
        }
        eo.Code(context, i10, str, sourceParam.F());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(final Context context, final SourceParam sourceParam, String str) {
        if (!au.B(sourceParam.B())) {
            C(sourceParam.B());
            V(context, 2, sourceParam, "fromNet url is not http | " + sourceParam.D());
            return;
        }
        gl.V(Code, "loadImageFromNet");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content_id", str);
            jSONObject.put("content", z.V(sourceParam));
            com.huawei.openalliance.ad.ipc.g.V(context).Code(com.huawei.openalliance.ad.constant.q.L, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.utils.y.2
                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str2, CallResult<String> callResult) {
                    Context applicationContext;
                    int i10;
                    SourceParam sourceParam2;
                    String str3;
                    String data = callResult.getData();
                    gl.V(y.Code, "get drawable from net, errorCode: %s filePath: %s", Integer.valueOf(callResult.getCode()), bc.Code(data));
                    if (data == null) {
                        y.C(SourceParam.this.B());
                        applicationContext = context.getApplicationContext();
                        i10 = 3;
                        sourceParam2 = SourceParam.this;
                        str3 = "filepath is null";
                    } else {
                        if (y.V(context.getApplicationContext(), SourceParam.this.B(), data, SourceParam.this)) {
                            return;
                        }
                        y.C(SourceParam.this.B());
                        applicationContext = context.getApplicationContext();
                        i10 = 4;
                        sourceParam2 = SourceParam.this;
                        str3 = "image not download";
                    }
                    y.V(applicationContext, i10, sourceParam2, str3);
                }
            }, String.class);
        } catch (JSONException unused) {
            gl.I(Code, "loadImageInfo jsonex");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(String str, aj ajVar) {
        if (ajVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (V) {
            Map<String, Set<aj>> map = I;
            Set<aj> set = map.get(str);
            if (set == null) {
                set = new HashSet<>();
                map.put(str, set);
            }
            set.add(ajVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean V(Context context, String str, String str2, SourceParam sourceParam) {
        Integer c4 = am.Code(context).c();
        if (c4 != null) {
            sourceParam.V(c4.intValue());
        }
        Drawable S = S(str);
        if (S != null) {
            gl.V(Code, "get drawable from cache");
            Code(str, S);
            return true;
        }
        if (au.B(str2)) {
            return false;
        }
        Pair<Drawable, String> Code2 = Code(context, str2);
        Drawable drawable = (Drawable) Code2.first;
        sourceParam.Z((String) Code2.second);
        if (drawable == null) {
            return false;
        }
        gl.V(Code, "get drawable from disk");
        x.Code().Code(aq.Code(str), drawable);
        Code(str, drawable);
        return true;
    }

    private static void Z(String str) {
        synchronized (V) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            I.remove(str);
        }
    }
}
