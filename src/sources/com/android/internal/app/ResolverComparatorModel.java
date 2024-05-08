package com.android.internal.app;

import android.content.pm.ResolveInfo;
import com.android.internal.app.chooser.TargetInfo;
import java.util.Comparator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
interface ResolverComparatorModel {
    Comparator<ResolveInfo> getComparator();

    float getScore(TargetInfo targetInfo);

    void notifyOnTargetSelected(TargetInfo targetInfo);
}
