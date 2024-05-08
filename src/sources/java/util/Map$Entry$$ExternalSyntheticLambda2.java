package java.util;

import java.io.Serializable;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* compiled from: D8$$SyntheticClass */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final /* synthetic */ class Map$Entry$$ExternalSyntheticLambda2 implements Comparator, Serializable {
    public final /* synthetic */ Comparator f$0;

    public /* synthetic */ Map$Entry$$ExternalSyntheticLambda2(Comparator comparator) {
        this.f$0 = comparator;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int compare;
        compare = this.f$0.compare(((Map.Entry) obj).getKey(), ((Map.Entry) obj2).getKey());
        return compare;
    }
}
