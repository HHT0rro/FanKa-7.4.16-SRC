package androidx.databinding.adapters;

import android.widget.SeekBar;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethod;
import androidx.databinding.InverseBindingMethods;

@InverseBindingMethods({@InverseBindingMethod(attribute = "android:progress", type = SeekBar.class)})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SeekBarBindingAdapter {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface OnProgressChanged {
        void onProgressChanged(SeekBar seekBar, int i10, boolean z10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface OnStartTrackingTouch {
        void onStartTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface OnStopTrackingTouch {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    @BindingAdapter(requireAll = false, value = {"android:onStartTrackingTouch", "android:onStopTrackingTouch", "android:onProgressChanged", "android:progressAttrChanged"})
    public static void setOnSeekBarChangeListener(SeekBar seekBar, final OnStartTrackingTouch onStartTrackingTouch, final OnStopTrackingTouch onStopTrackingTouch, final OnProgressChanged onProgressChanged, final InverseBindingListener inverseBindingListener) {
        if (onStartTrackingTouch == null && onStopTrackingTouch == null && onProgressChanged == null && inverseBindingListener == null) {
            seekBar.setOnSeekBarChangeListener(null);
        } else {
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: androidx.databinding.adapters.SeekBarBindingAdapter.1
                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onProgressChanged(SeekBar seekBar2, int i10, boolean z10) {
                    OnProgressChanged onProgressChanged2 = OnProgressChanged.this;
                    if (onProgressChanged2 != null) {
                        onProgressChanged2.onProgressChanged(seekBar2, i10, z10);
                    }
                    InverseBindingListener inverseBindingListener2 = inverseBindingListener;
                    if (inverseBindingListener2 != null) {
                        inverseBindingListener2.onChange();
                    }
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStartTrackingTouch(SeekBar seekBar2) {
                    OnStartTrackingTouch onStartTrackingTouch2 = onStartTrackingTouch;
                    if (onStartTrackingTouch2 != null) {
                        onStartTrackingTouch2.onStartTrackingTouch(seekBar2);
                    }
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStopTrackingTouch(SeekBar seekBar2) {
                    OnStopTrackingTouch onStopTrackingTouch2 = onStopTrackingTouch;
                    if (onStopTrackingTouch2 != null) {
                        onStopTrackingTouch2.onStopTrackingTouch(seekBar2);
                    }
                }
            });
        }
    }

    @BindingAdapter({"android:progress"})
    public static void setProgress(SeekBar seekBar, int i10) {
        if (i10 != seekBar.getProgress()) {
            seekBar.setProgress(i10);
        }
    }
}
