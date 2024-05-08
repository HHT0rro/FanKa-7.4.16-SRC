package z7;

import java.util.Set;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class a implements d {
    @Override // z7.d
    public <T> Set<T> b(Class<T> cls) {
        return a(cls).get();
    }

    @Override // z7.d
    public <T> T get(Class<T> cls) {
        e8.a<T> c4 = c(cls);
        if (c4 == null) {
            return null;
        }
        return c4.get();
    }
}
