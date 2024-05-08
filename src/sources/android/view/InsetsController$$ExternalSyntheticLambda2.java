package android.view;

import android.app.ActivityThread;
import android.content.Context;
import android.view.inputmethod.ImeTracker;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* compiled from: D8$$SyntheticClass */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final /* synthetic */ class InsetsController$$ExternalSyntheticLambda2 implements ImeTracker.InputMethodLatencyContext {
    @Override // android.view.inputmethod.ImeTracker.InputMethodLatencyContext
    public final Context getAppContext() {
        return ActivityThread.currentApplication();
    }
}
