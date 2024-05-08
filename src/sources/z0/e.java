package z0;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BitmapExtension.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f54814a = new e();

    @Nullable
    public final Bitmap a(@Nullable String str) {
        boolean z10 = true;
        if (str == null || str.length() == 0) {
            return null;
        }
        if (kotlin.text.p.F(str, "data:image/png;base64,", false, 2, null) || kotlin.text.p.F(str, "data:image/jpg;base64,", false, 2, null) || kotlin.text.p.F(str, "data:image/jpeg;base64,", false, 2, null) || kotlin.text.p.F(str, "data:image/*;base64,", false, 2, null)) {
            str = (String) CollectionsKt___CollectionsKt.W(StringsKt__StringsKt.z0(str, new String[]{","}, false, 0, 6, null), 1);
        }
        if (str != null && str.length() != 0) {
            z10 = false;
        }
        if (z10) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
