package o4;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;

/* compiled from: CreationContext.java */
@AutoValue
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class f {
    public static f a(Context context, u4.a aVar, u4.a aVar2, String str) {
        return new b(context, aVar, aVar2, str);
    }

    public abstract Context b();

    @NonNull
    public abstract String c();

    public abstract u4.a d();

    public abstract u4.a e();
}
