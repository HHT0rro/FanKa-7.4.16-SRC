package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class r0 {
    public static boolean a(Set<?> set, Iterator<?> it) {
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= set.remove(it.next());
        }
        return true == z10;
    }

    public static boolean b(Set<?> set, Collection<?> collection) {
        Objects.requireNonNull(collection);
        if (collection instanceof n0) {
            collection = ((n0) collection).zza();
        }
        if ((collection instanceof Set) && collection.size() > set.size()) {
            Iterator<?> iterator2 = set.iterator2();
            boolean z10 = false;
            while (iterator2.hasNext()) {
                if (collection.contains(iterator2.next())) {
                    iterator2.remove();
                    z10 = true;
                }
            }
            return z10;
        }
        return a(set, collection.iterator2());
    }
}
