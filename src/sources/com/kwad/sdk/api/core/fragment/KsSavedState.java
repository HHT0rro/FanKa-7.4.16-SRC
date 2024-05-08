package com.kwad.sdk.api.core.fragment;

import androidx.fragment.app.Fragment;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class KsSavedState {
    public final Fragment.SavedState mSaveState;

    public KsSavedState(Fragment.SavedState savedState) {
        this.mSaveState = savedState;
    }

    public Fragment.SavedState getBase() {
        return this.mSaveState;
    }
}
