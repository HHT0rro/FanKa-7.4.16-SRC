package com.android.internal.app;

import android.content.Intent;
import android.view.ViewGroup;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IChooserActivityWrapper {
    default ViewGroup getCreateContentPreviewView(ViewGroup parent) {
        return null;
    }

    default void hideStickyContentPreview() {
    }

    default Object getNearbySharingTarget(Intent originalIntent) {
        return null;
    }

    default boolean shouldNearbyShareBeFirstInRankedRow() {
        return false;
    }
}
