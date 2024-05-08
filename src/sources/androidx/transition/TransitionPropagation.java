package androidx.transition;

import android.view.ViewGroup;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class TransitionPropagation {
    public abstract void captureValues(TransitionValues transitionValues);

    public abstract String[] getPropagationProperties();

    public abstract long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2);
}
