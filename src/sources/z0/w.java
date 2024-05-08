package z0;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.MediaStore;
import com.alibaba.wireless.security.securitybodysdk.BuildConfig;
import com.android.internal.os.PowerProfile;
import com.huawei.quickcard.base.Attributes;
import java.io.File;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UriExtension.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final w f54826a = new w();

    @NotNull
    public final Uri a(@NotNull File file) {
        kotlin.jvm.internal.s.i(file, "file");
        Uri fromFile = Uri.fromFile(file);
        kotlin.jvm.internal.s.h(fromFile, "fromFile(file)");
        return fromFile;
    }

    @Nullable
    public final Uri b(@Nullable String str) {
        if (str == null) {
            return null;
        }
        int X = StringsKt__StringsKt.X(str, "content://", 0, false, 6, null);
        int X2 = StringsKt__StringsKt.X(str, "file://", 0, false, 6, null);
        if (X != 0 && X2 != 0) {
            File file = new File(str);
            if (file.exists()) {
                return a(file);
            }
            return null;
        }
        return Uri.parse(str);
    }

    @NotNull
    public final Uri c(long j10, @Nullable String str) {
        Uri contentUri;
        if (str == null || str.length() == 0) {
            contentUri = MediaStore.Files.getContentUri(BuildConfig.FLAVOR);
        } else if (kotlin.text.p.F(str, Attributes.Component.IMAGE, false, 2, null)) {
            contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        } else if (kotlin.text.p.F(str, "video", false, 2, null)) {
            contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else {
            contentUri = kotlin.text.p.F(str, PowerProfile.POWER_AUDIO, false, 2, null) ? MediaStore.Audio.Media.EXTERNAL_CONTENT_URI : MediaStore.Files.getContentUri(BuildConfig.FLAVOR);
        }
        Uri withAppendedId = ContentUris.withAppendedId(contentUri, j10);
        kotlin.jvm.internal.s.h(withAppendedId, "withAppendedId(uri, id)");
        return withAppendedId;
    }
}
