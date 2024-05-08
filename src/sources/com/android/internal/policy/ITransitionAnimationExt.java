package com.android.internal.policy;

import android.content.Context;
import android.view.animation.Animation;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface ITransitionAnimationExt {

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface IStaticExt {
        default Animation hookLoadAnimationSafely(Context context, String packageName, int resId, Animation animation) {
            return animation;
        }
    }
}
