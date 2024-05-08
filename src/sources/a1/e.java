package a1;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;

/* compiled from: GlideApp.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class e {
    @NonNull
    public static Glide a(@NonNull Context context) {
        return Glide.get(context);
    }

    @NonNull
    public static i b(@NonNull Context context) {
        return (i) Glide.with(context);
    }
}
