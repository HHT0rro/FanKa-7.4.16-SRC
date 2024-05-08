package com.android.internal.os;

import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IPowerProfileExt {
    default boolean readPowerValuesFromXml(HashMap<String, Double[]> powerArrayMap, HashMap<String, Double> powerItemMap) {
        return false;
    }
}
