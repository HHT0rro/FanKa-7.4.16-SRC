package com.huawei.quickcard;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.action.ActionsHelper;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.framework.processor.EventProcessor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class w0<T extends View> implements EventProcessor<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f34702a = "LongClickEventProcessor";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements View.OnLongClickListener {

        /* renamed from: a, reason: collision with root package name */
        private final String f34703a;

        public a(String str) {
            this.f34703a = str;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            CardLogUtils.d(w0.f34702a, "LongClicked view, eventStr:" + this.f34703a);
            if (TextUtils.isEmpty(this.f34703a)) {
                return false;
            }
            ActionsHelper.doAction(view, this.f34703a, null);
            return true;
        }
    }

    @Override // com.huawei.quickcard.framework.processor.EventProcessor
    public void applyEvent(@NonNull T t2, String str, String str2) {
        t2.setOnLongClickListener(new a(str2));
    }

    @Override // com.huawei.quickcard.framework.processor.EventProcessor
    public void cleanEvent(@NonNull T t2, String str) {
        t2.setOnLongClickListener(null);
    }
}
