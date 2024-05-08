package aa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b {
    @Nullable
    public static <T> T a(@NonNull Class<T> cls) {
        T t2 = (T) c.a(cls);
        if (t2 == null || !cls.isAssignableFrom(t2.getClass())) {
            return null;
        }
        return t2;
    }
}
