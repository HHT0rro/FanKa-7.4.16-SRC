package z0;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import com.huawei.openalliance.ad.constant.bb;
import com.huawei.quickcard.base.Attributes;
import com.wangmai.okhttp.db.DBHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DecimalFormat;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.k;

/* compiled from: FileExtension.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class k {

    /* renamed from: a */
    @NotNull
    public static final a f54819a = new a(null);

    /* compiled from: FileExtension.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Uri H(a aVar, Context context, File file, String str, String str2, int i10, Object obj) {
            if ((i10 & 8) != 0) {
                str2 = bb.V;
            }
            return aVar.G(context, file, str, str2);
        }

        public static final void m(String str, Activity activity, n callback) {
            kotlin.jvm.internal.s.i(callback, "$callback");
            try {
                if (str.length() > 0) {
                    InputStream openStream = new URL(str).openStream();
                    Bitmap mBitmap = BitmapFactory.decodeStream(openStream);
                    openStream.close();
                    a aVar = k.f54819a;
                    File i10 = aVar.i(activity, System.currentTimeMillis() + "_download.jpg");
                    if (i10 != null) {
                        kotlin.jvm.internal.s.h(mBitmap, "mBitmap");
                        f.g(mBitmap, i10, 0, 2, null);
                        Uri H = H(aVar, activity, i10, System.currentTimeMillis() + "_download.jpg", null, 8, null);
                        if (H != null) {
                            callback.a(H);
                        } else {
                            callback.error("downLoadImage saveImageToCameraDir uri is null");
                        }
                    } else {
                        callback.error("downLoadImage createFileInHideImage imageFile is null");
                    }
                }
            } catch (Exception e2) {
                callback.error(e2.getMessage());
                com.cupidapp.live.base.utils.j.f12332a.a("downloadImageFile", e2.getMessage() + " " + ((Object) e2.getCause()));
            }
        }

        @Nullable
        public final File A(@Nullable Context context) {
            if (context != null) {
                return context.getExternalFilesDir(".snap_message");
            }
            return null;
        }

        @Nullable
        public final File B(@Nullable Context context) {
            if (context != null) {
                return context.getExternalFilesDir(".video");
            }
            return null;
        }

        @Nullable
        public final File C(@Nullable Context context) {
            if (context != null) {
                return context.getExternalFilesDir(".video_temp");
            }
            return null;
        }

        public final boolean D(@Nullable Context context, @NotNull Uri uri) {
            kotlin.jvm.internal.s.i(uri, "uri");
            if (context == null) {
                return false;
            }
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, com.kuaishou.weapon.p0.t.f36226k);
                r0 = openFileDescriptor != null;
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
            return r0;
        }

        @Nullable
        public final Uri E(@NotNull Context context, @NotNull File sourceFile, @NotNull String saveFileName, @NotNull String mimeType) {
            kotlin.jvm.internal.s.i(context, "context");
            kotlin.jvm.internal.s.i(sourceFile, "sourceFile");
            kotlin.jvm.internal.s.i(saveFileName, "saveFileName");
            kotlin.jvm.internal.s.i(mimeType, "mimeType");
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", saveFileName);
            contentValues.put("mime_type", mimeType);
            if (Build.VERSION.SDK_INT >= 29) {
                contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("relative_path", Environment.DIRECTORY_MUSIC);
            }
            Uri EXTERNAL_CONTENT_URI = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            kotlin.jvm.internal.s.h(EXTERNAL_CONTENT_URI, "EXTERNAL_CONTENT_URI");
            return F(context, sourceFile, EXTERNAL_CONTENT_URI, contentValues);
        }

        /* JADX WARN: Code restructure failed: missing block: B:44:0x007d, code lost:
        
            if (r8 != null) goto L108;
         */
        /* JADX WARN: Removed duplicated region for block: B:52:0x008d A[Catch: IOException -> 0x0089, TRY_LEAVE, TryCatch #0 {IOException -> 0x0089, blocks: (B:62:0x0085, B:52:0x008d), top: B:61:0x0085 }] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0096  */
        /* JADX WARN: Removed duplicated region for block: B:60:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final android.net.Uri F(android.content.Context r7, java.io.File r8, android.net.Uri r9, android.content.ContentValues r10) {
            /*
                r6 = this;
                android.content.ContentResolver r7 = r7.getContentResolver()
                android.net.Uri r9 = r7.insert(r9, r10)
                r0 = 0
                if (r9 != 0) goto Lc
                return r0
            Lc:
                java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L62
                r1.<init>(r8)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L62
                java.lang.String r8 = "w"
                android.os.ParcelFileDescriptor r8 = r7.openFileDescriptor(r9, r8)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
                if (r8 != 0) goto L22
                r1.close()     // Catch: java.io.IOException -> L1d
                goto L21
            L1d:
                r7 = move-exception
                r7.printStackTrace()
            L21:
                return r0
            L22:
                java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
                java.io.FileDescriptor r3 = r8.getFileDescriptor()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
                r2.<init>(r3)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
                r3 = 4096(0x1000, float:5.74E-42)
                byte[] r3 = new byte[r3]     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L81
            L2f:
                int r4 = r1.read(r3)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L81
                r5 = -1
                if (r4 != r5) goto L4b
                r2.flush()     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L81
                r7.update(r9, r10, r0, r0)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L81
                r2.close()     // Catch: java.io.IOException -> L43
                r1.close()     // Catch: java.io.IOException -> L43
                goto L47
            L43:
                r7 = move-exception
                r7.printStackTrace()
            L47:
                r8.close()
                goto L80
            L4b:
                r5 = 0
                r2.write(r3, r5, r4)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L81
                goto L2f
            L50:
                r10 = move-exception
                goto L66
            L52:
                r7 = move-exception
                goto L83
            L54:
                r10 = move-exception
                r2 = r0
                goto L66
            L57:
                r7 = move-exception
                r8 = r0
                goto L83
            L5a:
                r10 = move-exception
                r8 = r0
                r2 = r8
                goto L66
            L5e:
                r7 = move-exception
                r8 = r0
                r1 = r8
                goto L83
            L62:
                r10 = move-exception
                r8 = r0
                r1 = r8
                r2 = r1
            L66:
                r10.printStackTrace()     // Catch: java.lang.Throwable -> L81
                r7.delete(r9, r0, r0)     // Catch: java.lang.Throwable -> L81
                if (r2 == 0) goto L74
                r2.close()     // Catch: java.io.IOException -> L72
                goto L74
            L72:
                r7 = move-exception
                goto L7a
            L74:
                if (r1 == 0) goto L7d
                r1.close()     // Catch: java.io.IOException -> L72
                goto L7d
            L7a:
                r7.printStackTrace()
            L7d:
                if (r8 == 0) goto L80
                goto L47
            L80:
                return r9
            L81:
                r7 = move-exception
                r0 = r2
            L83:
                if (r0 == 0) goto L8b
                r0.close()     // Catch: java.io.IOException -> L89
                goto L8b
            L89:
                r9 = move-exception
                goto L91
            L8b:
                if (r1 == 0) goto L94
                r1.close()     // Catch: java.io.IOException -> L89
                goto L94
            L91:
                r9.printStackTrace()
            L94:
                if (r8 == 0) goto L99
                r8.close()
            L99:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: z0.k.a.F(android.content.Context, java.io.File, android.net.Uri, android.content.ContentValues):android.net.Uri");
        }

        @Nullable
        public final Uri G(@NotNull Context context, @NotNull File sourceFile, @NotNull String saveFileName, @NotNull String mimeType) {
            kotlin.jvm.internal.s.i(context, "context");
            kotlin.jvm.internal.s.i(sourceFile, "sourceFile");
            kotlin.jvm.internal.s.i(saveFileName, "saveFileName");
            kotlin.jvm.internal.s.i(mimeType, "mimeType");
            ContentValues contentValues = new ContentValues();
            contentValues.put("description", "This is a image");
            contentValues.put("_display_name", saveFileName);
            contentValues.put("mime_type", mimeType);
            if (Build.VERSION.SDK_INT >= 29) {
                contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("relative_path", Environment.DIRECTORY_PICTURES);
            }
            Uri EXTERNAL_CONTENT_URI = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            kotlin.jvm.internal.s.h(EXTERNAL_CONTENT_URI, "EXTERNAL_CONTENT_URI");
            return F(context, sourceFile, EXTERNAL_CONTENT_URI, contentValues);
        }

        public final void b(@Nullable Context context) {
            File[] listFiles;
            File o10 = o(context);
            if (o10 == null || (listFiles = o10.listFiles()) == null) {
                return;
            }
            for (File it : listFiles) {
                kotlin.jvm.internal.s.h(it, "it");
                FilesKt__UtilsKt.k(it);
            }
        }

        public final void c(@Nullable Context context) {
            d(context);
            e(context);
            b(context);
        }

        public final void d(Context context) {
            File[] listFiles;
            File w3 = w(context);
            if (w3 == null || (listFiles = w3.listFiles()) == null) {
                return;
            }
            for (File it : listFiles) {
                kotlin.jvm.internal.s.h(it, "it");
                FilesKt__UtilsKt.k(it);
            }
        }

        public final void e(Context context) {
            File[] listFiles;
            File[] listFiles2;
            File C = C(context);
            if (C != null && (listFiles2 = C.listFiles()) != null) {
                for (File it : listFiles2) {
                    kotlin.jvm.internal.s.h(it, "it");
                    FilesKt__UtilsKt.k(it);
                }
            }
            File B = B(context);
            if (B == null || (listFiles = B.listFiles()) == null) {
                return;
            }
            for (File it2 : listFiles) {
                kotlin.jvm.internal.s.h(it2, "it");
                FilesKt__UtilsKt.k(it2);
            }
        }

        @Nullable
        public final File f(@Nullable File file, @NotNull String fileName) {
            kotlin.jvm.internal.s.i(fileName, "fileName");
            if (file == null) {
                return null;
            }
            file.mkdirs();
            File file2 = new File(file.getAbsolutePath() + File.separator + fileName);
            if (file2.exists()) {
                file2.delete();
            }
            try {
                file2.createNewFile();
                return file2;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        @Nullable
        public final File g(@Nullable Context context, @NotNull String fileName) {
            kotlin.jvm.internal.s.i(fileName, "fileName");
            return f(p(context), fileName);
        }

        @Nullable
        public final File h(@Nullable Context context, @NotNull String fileName) {
            kotlin.jvm.internal.s.i(fileName, "fileName");
            return f(q(context), fileName);
        }

        @Nullable
        public final File i(@Nullable Context context, @NotNull String fileName) {
            kotlin.jvm.internal.s.i(fileName, "fileName");
            return f(w(context), fileName);
        }

        @Nullable
        public final File j(@Nullable Context context, @NotNull String fileName) {
            kotlin.jvm.internal.s.i(fileName, "fileName");
            return f(C(context), fileName);
        }

        @Nullable
        public final File k(@Nullable Context context, @NotNull String fileName) {
            kotlin.jvm.internal.s.i(fileName, "fileName");
            return f(y(context), fileName);
        }

        public final void l(@Nullable final Activity activity, @Nullable final String str, @NotNull final n callback) {
            kotlin.jvm.internal.s.i(callback, "callback");
            if (activity == null || str == null) {
                return;
            }
            new Thread(new Runnable() { // from class: z0.j
                @Override // java.lang.Runnable
                public final void run() {
                    k.a.m(String.this, activity, callback);
                }
            }).start();
        }

        @NotNull
        public final String n(long j10) {
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            if (j10 < 1024) {
                return decimalFormat.format(j10) + "B";
            }
            if (j10 < 1048576) {
                return decimalFormat.format(((float) j10) / 1024.0f) + "KB";
            }
            if (j10 < 1073741824) {
                return decimalFormat.format(j10 / 1048576.0d) + "MB";
            }
            return decimalFormat.format(((float) j10) / 1.07374182E9f) + "GB";
        }

        @Nullable
        public final File o(@Nullable Context context) {
            if (context != null) {
                return context.getExternalFilesDir("apk");
            }
            return null;
        }

        public final File p(Context context) {
            if (context != null) {
                return context.getExternalFilesDir(null);
            }
            return null;
        }

        @Nullable
        public final File q(@Nullable Context context) {
            if (context != null) {
                return context.getExternalFilesDir(Attributes.Component.IMAGE);
            }
            return null;
        }

        @Nullable
        public final File r(@Nullable Context context) {
            if (context != null) {
                return context.getExternalFilesDir(".advert");
            }
            return null;
        }

        @Nullable
        public final File s(@Nullable Context context) {
            if (context != null) {
                return context.getExternalFilesDir(".beauty");
            }
            return null;
        }

        @Nullable
        public final File t(@Nullable Context context) {
            if (context != null) {
                return context.getExternalFilesDir(".beauty_temp");
            }
            return null;
        }

        @Nullable
        public final File u(@Nullable Context context) {
            if (context != null) {
                return context.getExternalFilesDir(".chat_bubble");
            }
            return null;
        }

        @Nullable
        public final File v(@Nullable Context context) {
            if (context != null) {
                return context.getExternalFilesDir(".download_temp");
            }
            return null;
        }

        @Nullable
        public final File w(@Nullable Context context) {
            if (context != null) {
                return context.getExternalFilesDir(".image");
            }
            return null;
        }

        @Nullable
        public final File x(@Nullable Context context) {
            File w3 = w(context);
            if (w3 == null) {
                return null;
            }
            File file = new File(w3, "resize");
            if (file.exists()) {
                return file;
            }
            file.mkdirs();
            return file;
        }

        @Nullable
        public final File y(@Nullable Context context) {
            File w3 = w(context);
            if (w3 == null) {
                return null;
            }
            File file = new File(w3, DBHelper.TABLE_UPLOAD);
            if (file.exists()) {
                return file;
            }
            file.mkdirs();
            return file;
        }

        @Nullable
        public final File z(@Nullable Context context) {
            if (context != null) {
                return context.getExternalFilesDir(".extra_resources");
            }
            return null;
        }
    }
}
