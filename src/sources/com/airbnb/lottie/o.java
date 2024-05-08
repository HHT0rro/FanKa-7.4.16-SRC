package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;

/* compiled from: LottieCompositionFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<String, k0<LottieComposition>> f2065a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final Set<l0> f2066b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f2067c = {80, 75, 3, 4};

    public static boolean A(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static Boolean B(BufferedSource bufferedSource) {
        try {
            BufferedSource peek = bufferedSource.peek();
            for (byte b4 : f2067c) {
                if (peek.readByte() != b4) {
                    return Boolean.FALSE;
                }
            }
            peek.close();
            return Boolean.TRUE;
        } catch (Exception e2) {
            n.d.b("Failed to check zip file header", e2);
            return Boolean.FALSE;
        } catch (NoSuchMethodError unused) {
            return Boolean.FALSE;
        }
    }

    public static /* synthetic */ void C(String str, AtomicBoolean atomicBoolean, Throwable th) {
        Map<String, k0<LottieComposition>> map = f2065a;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            J(true);
        }
    }

    public static /* synthetic */ LottieResult D(LottieComposition lottieComposition) throws Exception {
        return new LottieResult(lottieComposition);
    }

    public static /* synthetic */ void E(String str, AtomicBoolean atomicBoolean, LottieComposition lottieComposition) {
        Map<String, k0<LottieComposition>> map = f2065a;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            J(true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LottieResult H(WeakReference weakReference, Context context, int i10, String str) throws Exception {
        Context context2 = (Context) weakReference.get();
        if (context2 != null) {
            context = context2;
        }
        return v(context, i10, str);
    }

    public static /* synthetic */ LottieResult I(Context context, String str, String str2) throws Exception {
        LottieResult<LottieComposition> c4 = c.e(context).c(context, str, str2);
        if (str2 != null && c4.getValue() != null) {
            h.e.b().c(str2, c4.getValue());
        }
        return c4;
    }

    public static void J(boolean z10) {
        ArrayList arrayList = new ArrayList(f2066b);
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            ((l0) arrayList.get(i10)).a(z10);
        }
    }

    public static String K(Context context, @RawRes int i10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("rawRes");
        sb2.append(A(context) ? "_night_" : "_day_");
        sb2.append(i10);
        return sb2.toString();
    }

    public static k0<LottieComposition> h(@Nullable final String str, Callable<LottieResult<LottieComposition>> callable) {
        final LottieComposition a10 = str == null ? null : h.e.b().a(str);
        if (a10 != null) {
            return new k0<>(new Callable() { // from class: com.airbnb.lottie.l
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    LottieResult D;
                    D = o.D(LottieComposition.this);
                    return D;
                }
            });
        }
        if (str != null) {
            Map<String, k0<LottieComposition>> map = f2065a;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        k0<LottieComposition> k0Var = new k0<>(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            k0Var.d(new f0() { // from class: com.airbnb.lottie.h
                @Override // com.airbnb.lottie.f0
                public final void onResult(Object obj) {
                    o.E(String.this, atomicBoolean, (LottieComposition) obj);
                }
            });
            k0Var.c(new f0() { // from class: com.airbnb.lottie.i
                @Override // com.airbnb.lottie.f0
                public final void onResult(Object obj) {
                    o.C(String.this, atomicBoolean, (Throwable) obj);
                }
            });
            if (!atomicBoolean.get()) {
                Map<String, k0<LottieComposition>> map2 = f2065a;
                map2.put(str, k0Var);
                if (map2.size() == 1) {
                    J(false);
                }
            }
        }
        return k0Var;
    }

    @Nullable
    public static e0 i(LottieComposition lottieComposition, String str) {
        for (e0 e0Var : lottieComposition.j().values()) {
            if (e0Var.b().equals(str)) {
                return e0Var;
            }
        }
        return null;
    }

    public static k0<LottieComposition> j(Context context, String str) {
        return k(context, str, "asset_" + str);
    }

    public static k0<LottieComposition> k(Context context, final String str, @Nullable final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return h(str2, new Callable() { // from class: com.airbnb.lottie.j
            @Override // java.util.concurrent.Callable
            public final Object call() {
                LottieResult m10;
                m10 = o.m(applicationContext, str, str2);
                return m10;
            }
        });
    }

    @WorkerThread
    public static LottieResult<LottieComposition> l(Context context, String str) {
        return m(context, str, "asset_" + str);
    }

    @WorkerThread
    public static LottieResult<LottieComposition> m(Context context, String str, @Nullable String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return o(context.getAssets().open(str), str2);
            }
            return y(context, new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e2) {
            return new LottieResult<>((Throwable) e2);
        }
    }

    public static k0<LottieComposition> n(final InputStream inputStream, @Nullable final String str) {
        return h(str, new Callable() { // from class: com.airbnb.lottie.m
            @Override // java.util.concurrent.Callable
            public final Object call() {
                LottieResult o10;
                o10 = o.o(InputStream.this, str);
                return o10;
            }
        });
    }

    @WorkerThread
    public static LottieResult<LottieComposition> o(InputStream inputStream, @Nullable String str) {
        return p(inputStream, str, true);
    }

    @WorkerThread
    public static LottieResult<LottieComposition> p(InputStream inputStream, @Nullable String str, boolean z10) {
        try {
            return q(JsonReader.u(Okio.buffer(Okio.source(inputStream))), str);
        } finally {
            if (z10) {
                n.h.c(inputStream);
            }
        }
    }

    @WorkerThread
    public static LottieResult<LottieComposition> q(JsonReader jsonReader, @Nullable String str) {
        return r(jsonReader, str, true);
    }

    public static LottieResult<LottieComposition> r(JsonReader jsonReader, @Nullable String str, boolean z10) {
        try {
            try {
                LottieComposition a10 = m.w.a(jsonReader);
                if (str != null) {
                    h.e.b().c(str, a10);
                }
                LottieResult<LottieComposition> lottieResult = new LottieResult<>(a10);
                if (z10) {
                    n.h.c(jsonReader);
                }
                return lottieResult;
            } catch (Exception e2) {
                LottieResult<LottieComposition> lottieResult2 = new LottieResult<>(e2);
                if (z10) {
                    n.h.c(jsonReader);
                }
                return lottieResult2;
            }
        } catch (Throwable th) {
            if (z10) {
                n.h.c(jsonReader);
            }
            throw th;
        }
    }

    public static k0<LottieComposition> s(Context context, @RawRes int i10) {
        return t(context, i10, K(context, i10));
    }

    public static k0<LottieComposition> t(Context context, @RawRes final int i10, @Nullable final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return h(str, new Callable() { // from class: com.airbnb.lottie.n
            @Override // java.util.concurrent.Callable
            public final Object call() {
                LottieResult H;
                H = o.H(WeakReference.this, applicationContext, i10, str);
                return H;
            }
        });
    }

    @WorkerThread
    public static LottieResult<LottieComposition> u(Context context, @RawRes int i10) {
        return v(context, i10, K(context, i10));
    }

    @WorkerThread
    public static LottieResult<LottieComposition> v(Context context, @RawRes int i10, @Nullable String str) {
        try {
            BufferedSource buffer = Okio.buffer(Okio.source(context.getResources().openRawResource(i10)));
            if (B(buffer).booleanValue()) {
                return y(context, new ZipInputStream(buffer.inputStream()), str);
            }
            return o(buffer.inputStream(), str);
        } catch (Resources.NotFoundException e2) {
            return new LottieResult<>((Throwable) e2);
        }
    }

    public static k0<LottieComposition> w(Context context, String str) {
        return x(context, str, "url_" + str);
    }

    public static k0<LottieComposition> x(final Context context, final String str, @Nullable final String str2) {
        return h(str2, new Callable() { // from class: com.airbnb.lottie.k
            @Override // java.util.concurrent.Callable
            public final Object call() {
                LottieResult I;
                I = o.I(context, str, str2);
                return I;
            }
        });
    }

    @WorkerThread
    public static LottieResult<LottieComposition> y(@Nullable Context context, ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return z(context, zipInputStream, str);
        } finally {
            n.h.c(zipInputStream);
        }
    }

    @WorkerThread
    public static LottieResult<LottieComposition> z(Context context, ZipInputStream zipInputStream, @Nullable String str) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            LottieComposition lottieComposition = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    lottieComposition = r(JsonReader.u(Okio.buffer(Okio.source(zipInputStream))), null, false).getValue();
                } else {
                    if (!name.contains(".png") && !name.contains(".webp") && !name.contains(".jpg") && !name.contains(".jpeg")) {
                        if (!name.contains(".ttf") && !name.contains(".otf")) {
                            zipInputStream.closeEntry();
                        }
                        String[] split = name.split("/");
                        String str2 = split[split.length - 1];
                        String str3 = str2.split("\\.")[0];
                        File file = new File(context.getCacheDir(), str2);
                        new FileOutputStream(file);
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            try {
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    int read = zipInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            } catch (Throwable th) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                                break;
                            }
                        } catch (Throwable th3) {
                            n.d.d("Unable to save font " + str3 + " to the temporary file: " + str2 + ". ", th3);
                        }
                        Typeface createFromFile = Typeface.createFromFile(file);
                        if (!file.delete()) {
                            n.d.c("Failed to delete temp font file " + file.getAbsolutePath() + ".");
                        }
                        hashMap2.put(str3, createFromFile);
                    }
                    String[] split2 = name.split("/");
                    hashMap.put(split2[split2.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (lottieComposition == null) {
                return new LottieResult<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                e0 i10 = i(lottieComposition, (String) entry.getKey());
                if (i10 != null) {
                    i10.f(n.h.l((Bitmap) entry.getValue(), i10.e(), i10.c()));
                }
            }
            for (Map.Entry entry2 : hashMap2.entrySet()) {
                boolean z10 = false;
                for (h.a aVar : lottieComposition.g().values()) {
                    if (aVar.a().equals(entry2.getKey())) {
                        aVar.e((Typeface) entry2.getValue());
                        z10 = true;
                    }
                }
                if (!z10) {
                    n.d.c("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
                }
            }
            if (hashMap.isEmpty()) {
                Iterator<Map.Entry<String, e0>> iterator2 = lottieComposition.j().entrySet().iterator2();
                while (iterator2.hasNext()) {
                    e0 value = iterator2.next().getValue();
                    if (value == null) {
                        return null;
                    }
                    String b4 = value.b();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = true;
                    options.inDensity = 160;
                    if (b4.startsWith("data:") && b4.indexOf("base64,") > 0) {
                        try {
                            byte[] decode = Base64.decode(b4.substring(b4.indexOf(44) + 1), 0);
                            value.f(BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
                        } catch (IllegalArgumentException e2) {
                            n.d.d("data URL did not have correct base64 format.", e2);
                            return null;
                        }
                    }
                }
            }
            for (Map.Entry<String, e0> entry3 : lottieComposition.j().entrySet()) {
                if (entry3.getValue().a() == null) {
                    return new LottieResult<>((Throwable) new IllegalStateException("There is no image for " + entry3.getValue().b()));
                }
            }
            if (str != null) {
                h.e.b().c(str, lottieComposition);
            }
            return new LottieResult<>(lottieComposition);
        } catch (IOException e10) {
            return new LottieResult<>((Throwable) e10);
        }
    }
}
