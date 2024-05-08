package java.util;

import java.io.Serializable;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* compiled from: D8$$SyntheticClass */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final /* synthetic */ class Map$Entry$$ExternalSyntheticLambda1 implements Comparator, Serializable {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int compareTo;
        compareTo = ((Comparable) ((Map.Entry) obj).getValue()).compareTo(((Map.Entry) obj2).getValue());
        return compareTo;
    }
}
