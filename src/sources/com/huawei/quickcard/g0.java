package com.huawei.quickcard;

import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.action.ActionsHelper;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.framework.processor.EventProcessor;
import com.huawei.quickcard.utils.ValueUtils;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class g0<T extends View> implements EventProcessor<T> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements View.OnFocusChangeListener {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<View> f33988a;

        public a(View view) {
            this.f33988a = new WeakReference<>(view);
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            View.OnFocusChangeListener onFocusChangeListener;
            View view2 = this.f33988a.get();
            if (view2 == null) {
                return;
            }
            Map<String, View.OnFocusChangeListener> focusChangeListeners = ValueUtils.obtainPropertyCacheBeanFromView(view2).getFocusChangeListeners();
            if (z10) {
                onFocusChangeListener = focusChangeListeners.get(Attributes.Event.FOCUS);
            } else {
                onFocusChangeListener = focusChangeListeners.get("blur");
            }
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(view, z10);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b implements View.OnFocusChangeListener {

        /* renamed from: a, reason: collision with root package name */
        private final String f33989a;

        public b(String str) {
            this.f33989a = str;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(final View view, boolean z10) {
            ActionsHelper.doAction(view, this.f33989a, null);
            Objects.requireNonNull(view);
            view.post(new Runnable() { // from class: com.huawei.quickcard.n2
                @Override // java.lang.Runnable
                public final void run() {
                    View.this.requestLayout();
                }
            });
        }
    }

    @Override // com.huawei.quickcard.framework.processor.EventProcessor
    public void applyEvent(@NonNull T t2, String str, String str2) {
        Map<String, View.OnFocusChangeListener> focusChangeListeners = ValueUtils.obtainPropertyCacheBeanFromView(t2).getFocusChangeListeners();
        if (focusChangeListeners.isEmpty()) {
            t2.setOnFocusChangeListener(new a(t2));
        }
        focusChangeListeners.put(str, new b(str2));
    }

    @Override // com.huawei.quickcard.framework.processor.EventProcessor
    public void cleanEvent(@NonNull T t2, String str) {
        Map<String, View.OnFocusChangeListener> focusChangeListeners = ValueUtils.obtainPropertyCacheBeanFromView(t2).getFocusChangeListeners();
        focusChangeListeners.remove(str);
        if (focusChangeListeners.isEmpty()) {
            t2.setOnFocusChangeListener(null);
        }
    }
}
