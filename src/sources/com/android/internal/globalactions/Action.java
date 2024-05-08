package com.android.internal.globalactions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface Action {
    View create(Context context, View view, ViewGroup viewGroup, LayoutInflater layoutInflater);

    CharSequence getLabelForAccessibility(Context context);

    boolean isEnabled();

    void onPress();

    boolean showBeforeProvisioning();

    boolean showDuringKeyguard();
}
