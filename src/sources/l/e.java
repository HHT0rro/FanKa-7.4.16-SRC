package l;

import android.content.Context;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.network.FileExtension;
import com.airbnb.lottie.network.LottieFetchResult;
import com.airbnb.lottie.o;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* compiled from: NetworkFetcher.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final d f51578a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final c f51579b;

    public e(@Nullable d dVar, @NonNull c cVar) {
        this.f51578a = dVar;
        this.f51579b = cVar;
    }

    @Nullable
    @WorkerThread
    public final LottieComposition a(Context context, @NonNull String str, @Nullable String str2) {
        d dVar;
        Pair<FileExtension, InputStream> a10;
        LottieResult<LottieComposition> o10;
        if (str2 == null || (dVar = this.f51578a) == null || (a10 = dVar.a(str)) == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) a10.first;
        InputStream inputStream = (InputStream) a10.second;
        if (fileExtension == FileExtension.ZIP) {
            o10 = o.y(context, new ZipInputStream(inputStream), str2);
        } else {
            o10 = o.o(inputStream, str2);
        }
        if (o10.getValue() != null) {
            return o10.getValue();
        }
        return null;
    }

    @NonNull
    @WorkerThread
    public final LottieResult<LottieComposition> b(Context context, @NonNull String str, @Nullable String str2) {
        n.d.a("Fetching " + str);
        AutoCloseable autoCloseable = null;
        try {
            try {
                LottieFetchResult a10 = this.f51579b.a(str);
                if (a10.isSuccessful()) {
                    LottieResult<LottieComposition> d10 = d(context, str, a10.bodyByteStream(), a10.contentType(), str2);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Completed fetch from network. Success: ");
                    sb2.append(d10.getValue() != null);
                    n.d.a(sb2.toString());
                    try {
                        a10.close();
                    } catch (IOException e2) {
                        n.d.d("LottieFetchResult close failed ", e2);
                    }
                    return d10;
                }
                LottieResult<LottieComposition> lottieResult = new LottieResult<>(new IllegalArgumentException(a10.error()));
                try {
                    a10.close();
                } catch (IOException e10) {
                    n.d.d("LottieFetchResult close failed ", e10);
                }
                return lottieResult;
            } catch (Exception e11) {
                LottieResult<LottieComposition> lottieResult2 = new LottieResult<>(e11);
                if (0 != 0) {
                    try {
                        autoCloseable.close();
                    } catch (IOException e12) {
                        n.d.d("LottieFetchResult close failed ", e12);
                    }
                }
                return lottieResult2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    autoCloseable.close();
                } catch (IOException e13) {
                    n.d.d("LottieFetchResult close failed ", e13);
                }
            }
            throw th;
        }
    }

    @NonNull
    @WorkerThread
    public LottieResult<LottieComposition> c(Context context, @NonNull String str, @Nullable String str2) {
        LottieComposition a10 = a(context, str, str2);
        if (a10 != null) {
            return new LottieResult<>(a10);
        }
        n.d.a("Animation for " + str + " not found in cache. Fetching from network.");
        return b(context, str, str2);
    }

    @NonNull
    public final LottieResult<LottieComposition> d(Context context, @NonNull String str, @NonNull InputStream inputStream, @Nullable String str2, @Nullable String str3) throws IOException {
        LottieResult<LottieComposition> f10;
        FileExtension fileExtension;
        d dVar;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (!str2.contains("application/zip") && !str2.contains("application/x-zip") && !str2.contains("application/x-zip-compressed") && !str.split("\\?")[0].endsWith(".lottie")) {
            n.d.a("Received json response.");
            fileExtension = FileExtension.JSON;
            f10 = e(str, inputStream, str3);
        } else {
            n.d.a("Handling zip response.");
            FileExtension fileExtension2 = FileExtension.ZIP;
            f10 = f(context, str, inputStream, str3);
            fileExtension = fileExtension2;
        }
        if (str3 != null && f10.getValue() != null && (dVar = this.f51578a) != null) {
            dVar.e(str, fileExtension);
        }
        return f10;
    }

    @NonNull
    public final LottieResult<LottieComposition> e(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        d dVar;
        if (str2 != null && (dVar = this.f51578a) != null) {
            return o.o(new FileInputStream(dVar.f(str, inputStream, FileExtension.JSON).getAbsolutePath()), str);
        }
        return o.o(inputStream, null);
    }

    @NonNull
    public final LottieResult<LottieComposition> f(Context context, @NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        d dVar;
        if (str2 != null && (dVar = this.f51578a) != null) {
            return o.y(context, new ZipInputStream(new FileInputStream(dVar.f(str, inputStream, FileExtension.ZIP))), str);
        }
        return o.y(context, new ZipInputStream(inputStream), null);
    }
}
