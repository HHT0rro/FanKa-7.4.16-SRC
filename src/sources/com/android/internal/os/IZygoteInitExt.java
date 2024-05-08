package com.android.internal.os;

import android.content.res.Resources;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IZygoteInitExt {
    default void hookPreloadResources(Resources resources, String tag) {
    }

    default void beginHookPreload() {
    }

    default void endHookPreload() {
    }

    default void beginHookGcAndFinalize(boolean enableLazyPreload) {
    }

    default void endHookGcAndFinalize(boolean enableLazyPreload) {
    }

    default void addBootEvent(String bootevent) {
    }
}
