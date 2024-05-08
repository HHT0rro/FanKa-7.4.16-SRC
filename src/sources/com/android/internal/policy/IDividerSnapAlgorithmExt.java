package com.android.internal.policy;

import android.content.res.Resources;
import android.graphics.Rect;
import com.android.internal.policy.DividerSnapAlgorithm;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IDividerSnapAlgorithmExt {
    default boolean hasLargeScreenFeature() {
        return false;
    }

    default int getSnapMode(Resources res, boolean isMinimizedMode) {
        return 0;
    }

    default boolean getFreeSnapMode(Resources res) {
        return false;
    }

    default boolean addRatioTargets(Resources res, ArrayList<DividerSnapAlgorithm.SnapTarget> targets, int dividerMax, int dividerSize, boolean isHorizontalDivision, Rect insets) {
        return false;
    }

    default boolean addMinimizedTarget(ArrayList<DividerSnapAlgorithm.SnapTarget> targets, int dockedSide, int dividerSize, int taskHeightInMinimized, Rect insets, int displayWidth, int displayHeight) {
        return false;
    }

    default boolean addMiddleTarget(ArrayList<DividerSnapAlgorithm.SnapTarget> targets, boolean isHorizontalDivision, int displayWidth, int displayHeight, int dividerSize) {
        return false;
    }
}
