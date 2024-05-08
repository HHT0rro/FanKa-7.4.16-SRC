package android.view.autofill;

import android.content.ComponentName;
import android.content.Context;
import android.view.autofill.AutofillManager;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IAutofillManagerExt {
    default boolean hookSaveOnFinish(ComponentName componentName, boolean saveOnFinish) {
        return saveOnFinish;
    }

    default int hookActivityFinishingCommitReason(int commitReason, boolean saveOnFinish) {
        return commitReason;
    }

    default boolean hookShouldStartSession(Context context, AutofillManager.AutofillClient client, int flag) {
        return true;
    }
}
