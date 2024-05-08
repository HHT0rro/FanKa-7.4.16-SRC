package com.google.android.material.resources;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class TextAppearanceFontCallback {
    public abstract void onFontRetrievalFailed(int i10);

    public abstract void onFontRetrieved(Typeface typeface, boolean z10);
}
