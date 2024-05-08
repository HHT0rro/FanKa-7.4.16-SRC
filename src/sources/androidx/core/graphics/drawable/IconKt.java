package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Icon.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class IconKt {
    @RequiresApi(26)
    @NotNull
    public static final Icon toAdaptiveIcon(@NotNull Bitmap bitmap) {
        s.i(bitmap, "<this>");
        Icon createWithAdaptiveBitmap = Icon.createWithAdaptiveBitmap(bitmap);
        s.h(createWithAdaptiveBitmap, "createWithAdaptiveBitmap(this)");
        return createWithAdaptiveBitmap;
    }

    @RequiresApi(26)
    @NotNull
    public static final Icon toIcon(@NotNull Bitmap bitmap) {
        s.i(bitmap, "<this>");
        Icon createWithBitmap = Icon.createWithBitmap(bitmap);
        s.h(createWithBitmap, "createWithBitmap(this)");
        return createWithBitmap;
    }

    @RequiresApi(26)
    @NotNull
    public static final Icon toIcon(@NotNull Uri uri) {
        s.i(uri, "<this>");
        Icon createWithContentUri = Icon.createWithContentUri(uri);
        s.h(createWithContentUri, "createWithContentUri(this)");
        return createWithContentUri;
    }

    @RequiresApi(26)
    @NotNull
    public static final Icon toIcon(@NotNull byte[] bArr) {
        s.i(bArr, "<this>");
        Icon createWithData = Icon.createWithData(bArr, 0, bArr.length);
        s.h(createWithData, "createWithData(this, 0, size)");
        return createWithData;
    }
}
