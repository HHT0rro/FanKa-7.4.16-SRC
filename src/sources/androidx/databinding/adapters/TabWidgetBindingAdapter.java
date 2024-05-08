package androidx.databinding.adapters;

import android.widget.TabWidget;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;

@BindingMethods({@BindingMethod(attribute = "android:divider", method = "setDividerDrawable", type = TabWidget.class), @BindingMethod(attribute = "android:tabStripEnabled", method = "setStripEnabled", type = TabWidget.class), @BindingMethod(attribute = "android:tabStripLeft", method = "setLeftStripDrawable", type = TabWidget.class), @BindingMethod(attribute = "android:tabStripRight", method = "setRightStripDrawable", type = TabWidget.class)})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TabWidgetBindingAdapter {
}
