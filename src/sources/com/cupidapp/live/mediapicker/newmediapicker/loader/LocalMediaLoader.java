package com.cupidapp.live.mediapicker.newmediapicker.loader;

import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Size;
import com.alibaba.wireless.security.securitybodysdk.BuildConfig;
import com.cupidapp.live.mediapicker.newmediapicker.model.LocalMedia;
import com.cupidapp.live.mediapicker.newmediapicker.model.LocalMediaFolder;
import com.cupidapp.live.mediapicker.newmediapicker.model.MediaType;
import com.cupidapp.live.mediapicker.newmediapicker.model.MimeType;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.collections.l;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.w;

/* compiled from: LocalMediaLoader.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LocalMediaLoader {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LocalMediaLoader f17323a = new LocalMediaLoader();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Uri f17324b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final String[] f17325c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final String[] f17326d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final String[] f17327e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f17328f;

    /* compiled from: LocalMediaLoader.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17329a;

        static {
            int[] iArr = new int[MediaType.values().length];
            try {
                iArr[MediaType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f17329a = iArr;
        }
    }

    /* compiled from: Comparisons.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t2, T t10) {
            return qd.a.a(Integer.valueOf(((LocalMediaFolder) t10).c()), Integer.valueOf(((LocalMediaFolder) t2).c()));
        }
    }

    static {
        Uri contentUri = MediaStore.Files.getContentUri(BuildConfig.FLAVOR);
        s.h(contentUri, "getContentUri(\"external\")");
        f17324b = contentUri;
        f17325c = new String[]{"_id", "bucket_id", "bucket_display_name", "mime_type"};
        f17326d = new String[]{"_id", "_data", "bucket_id", "bucket_display_name", "mime_type", "COUNT(*) AS count"};
        f17327e = new String[]{"_id", "_data", "mime_type", "duration", "width", "height", "_size", "_display_name"};
        f17328f = 60;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x020d, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x020a, code lost:
    
        if (r3.isClosed() != false) goto L65;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.util.List o(com.cupidapp.live.mediapicker.newmediapicker.model.MediaType r27, android.content.Context r28) {
        /*
            Method dump skipped, instructions count: 537
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.mediapicker.newmediapicker.loader.LocalMediaLoader.o(com.cupidapp.live.mediapicker.newmediapicker.model.MediaType, android.content.Context):java.util.List");
    }

    public static final List p(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x01c2, code lost:
    
        if (r4.isClosed() != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x01c4, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0202, code lost:
    
        if (r4.isClosed() == false) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01c8 A[LOOP:0: B:19:0x00dc->B:26:0x01c8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01be A[EDGE_INSN: B:27:0x01be->B:28:0x01be BREAK  A[LOOP:0: B:19:0x00dc->B:26:0x01c8], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010f A[Catch: Exception -> 0x01d3, all -> 0x01e4, TryCatch #0 {all -> 0x01e4, blocks: (B:3:0x000f, B:5:0x002b, B:6:0x0037, B:8:0x0046, B:10:0x0052, B:12:0x0058, B:15:0x009b, B:18:0x00a3, B:19:0x00dc, B:24:0x01b8, B:41:0x00ff, B:43:0x010f, B:46:0x0122, B:48:0x014d, B:49:0x0157, B:54:0x0190, B:56:0x0194, B:57:0x017b, B:58:0x01a7, B:61:0x01b5, B:35:0x01e8, B:75:0x0065, B:78:0x008a, B:80:0x0090, B:81:0x002e), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x014d A[Catch: Exception -> 0x01d3, all -> 0x01e4, TryCatch #0 {all -> 0x01e4, blocks: (B:3:0x000f, B:5:0x002b, B:6:0x0037, B:8:0x0046, B:10:0x0052, B:12:0x0058, B:15:0x009b, B:18:0x00a3, B:19:0x00dc, B:24:0x01b8, B:41:0x00ff, B:43:0x010f, B:46:0x0122, B:48:0x014d, B:49:0x0157, B:54:0x0190, B:56:0x0194, B:57:0x017b, B:58:0x01a7, B:61:0x01b5, B:35:0x01e8, B:75:0x0065, B:78:0x008a, B:80:0x0090, B:81:0x002e), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01da A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.util.List r(com.cupidapp.live.mediapicker.newmediapicker.model.MediaType r33, long r34, int r36, android.content.Context r37) {
        /*
            Method dump skipped, instructions count: 530
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.mediapicker.newmediapicker.loader.LocalMediaLoader.r(com.cupidapp.live.mediapicker.newmediapicker.model.MediaType, long, int, android.content.Context):java.util.List");
    }

    public static final List s(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    public static final Size t(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            return new Size(options.outWidth, options.outHeight);
        } catch (Exception unused) {
            return new Size(0, 0);
        }
    }

    public final Bundle e(String str, String[] strArr, int i10) {
        Bundle bundle = new Bundle();
        e3.a aVar = e3.a.f48859a;
        if (aVar.a()) {
            bundle.putString("android:query-arg-sql-selection", str);
            bundle.putStringArray("android:query-arg-sql-selection-args", strArr);
            bundle.putString("android:query-arg-sql-sort-order", "_id DESC");
            if (aVar.c()) {
                bundle.putString("android:query-arg-sql-limit", f17328f + " offset " + i10);
            }
        }
        return bundle;
    }

    public final String f(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("mime_type");
        if (columnIndex == -1) {
            return null;
        }
        return cursor.getString(columnIndex);
    }

    public final String g(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex("mime_type");
        if (columnIndex == -1 || columnIndex2 == -1) {
            return null;
        }
        return w.f54826a.c(cursor.getLong(columnIndex), cursor.getString(columnIndex2)).toString();
    }

    public final String h(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("_data");
        if (columnIndex == -1) {
            return null;
        }
        return cursor.getString(columnIndex);
    }

    public final String i(int i10, int i11, long j10) {
        StringBuilder m10 = m(i10, i11);
        if (j10 == -1) {
            String sb2 = m10.toString();
            s.h(sb2, "{\n            stringBuilder.toString()\n        }");
            return sb2;
        }
        m10.append(" AND ");
        m10.append("bucket_id");
        m10.append("=?");
        String sb3 = m10.toString();
        s.h(sb3, "{\n            stringBuil…=?\").toString()\n        }");
        return sb3;
    }

    public final String j(int i10, int i11) {
        StringBuilder m10 = m(i10, i11);
        if (e3.a.f48859a.b()) {
            String sb2 = m10.toString();
            s.h(sb2, "{\n            stringBuilder.toString()\n        }");
            return sb2;
        }
        m10.append(")");
        m10.append(" GROUP BY (bucket_id");
        String sb3 = m10.toString();
        s.h(sb3, "{\n            stringBuil…_ID).toString()\n        }");
        return sb3;
    }

    public final String[] k(MediaType mediaType) {
        int i10 = a.f17329a[mediaType.ordinal()];
        if (i10 == 1) {
            return new String[]{"1"};
        }
        if (i10 != 2) {
            return new String[]{"1", "3"};
        }
        return new String[]{"3"};
    }

    public final String[] l(MediaType mediaType) {
        String[] strArr = {MimeType.JPEG.getMMimeTypeName(), MimeType.JPG.getMMimeTypeName(), MimeType.HEIF.getMMimeTypeName(), MimeType.HEIC.getMMimeTypeName(), MimeType.PNG.getMMimeTypeName()};
        String[] strArr2 = {MimeType.MP4.getMMimeTypeName()};
        int i10 = a.f17329a[mediaType.ordinal()];
        return i10 != 1 ? i10 != 2 ? (String[]) l.o(strArr, strArr2) : strArr2 : strArr;
    }

    public final StringBuilder m(int i10, int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        for (int i12 = 0; i12 < i10; i12++) {
            if (i12 > 0) {
                sb2.append(" OR ");
            }
            sb2.append("media_type");
            sb2.append("=?");
        }
        sb2.append(")");
        sb2.append(" AND ");
        sb2.append("(");
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 > 0) {
                sb2.append(" OR ");
            }
            sb2.append("mime_type");
            sb2.append("=?");
        }
        sb2.append(")");
        sb2.append(" AND ");
        sb2.append("_size");
        sb2.append(">0");
        return sb2;
    }

    @NotNull
    public final Observable<List<LocalMediaFolder>> n(@Nullable final Context context, @NotNull final MediaType mediaType) {
        s.i(mediaType, "mediaType");
        Observable observeOn = Observable.fromCallable(new Callable() { // from class: com.cupidapp.live.mediapicker.newmediapicker.loader.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List o10;
                o10 = LocalMediaLoader.o(MediaType.this, context);
                return o10;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final LocalMediaLoader$loadAllLocalMediaFolders$2 localMediaLoader$loadAllLocalMediaFolders$2 = new Function1<Throwable, List<LocalMediaFolder>>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.loader.LocalMediaLoader$loadAllLocalMediaFolders$2
            @Override // kotlin.jvm.functions.Function1
            public final List<LocalMediaFolder> invoke(@NotNull Throwable it) {
                s.i(it, "it");
                return new ArrayList();
            }
        };
        Observable<List<LocalMediaFolder>> onErrorReturn = observeOn.onErrorReturn(new Function() { // from class: com.cupidapp.live.mediapicker.newmediapicker.loader.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List p10;
                p10 = LocalMediaLoader.p(Function1.this, obj);
                return p10;
            }
        });
        s.h(onErrorReturn, "fromCallable {\n         …eturn { mutableListOf() }");
        return onErrorReturn;
    }

    @NotNull
    public final Observable<List<LocalMedia>> q(@Nullable final Context context, @NotNull final MediaType mediaType, final long j10, final int i10) {
        s.i(mediaType, "mediaType");
        Observable observeOn = Observable.fromCallable(new Callable() { // from class: com.cupidapp.live.mediapicker.newmediapicker.loader.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List r10;
                r10 = LocalMediaLoader.r(MediaType.this, j10, i10, context);
                return r10;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final LocalMediaLoader$loadPageLocalMedia$2 localMediaLoader$loadPageLocalMedia$2 = new Function1<Throwable, List<LocalMedia>>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.loader.LocalMediaLoader$loadPageLocalMedia$2
            @Override // kotlin.jvm.functions.Function1
            public final List<LocalMedia> invoke(@NotNull Throwable it) {
                s.i(it, "it");
                return new ArrayList();
            }
        };
        Observable<List<LocalMedia>> onErrorReturn = observeOn.onErrorReturn(new Function() { // from class: com.cupidapp.live.mediapicker.newmediapicker.loader.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List s2;
                s2 = LocalMediaLoader.s(Function1.this, obj);
                return s2;
            }
        });
        s.h(onErrorReturn, "fromCallable {\n         …eturn { mutableListOf() }");
        return onErrorReturn;
    }
}
