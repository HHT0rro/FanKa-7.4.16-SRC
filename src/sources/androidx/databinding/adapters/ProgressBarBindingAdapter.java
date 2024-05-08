package androidx.databinding.adapters;

import android.widget.ProgressBar;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;

@BindingMethods({@BindingMethod(attribute = "android:indeterminateTint", method = "setIndeterminateTintList", type = ProgressBar.class), @BindingMethod(attribute = "android:progressTint", method = "setProgressTintList", type = ProgressBar.class), @BindingMethod(attribute = "android:secondaryProgressTint", method = "setSecondaryProgressTintList", type = ProgressBar.class)})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ProgressBarBindingAdapter {
}
