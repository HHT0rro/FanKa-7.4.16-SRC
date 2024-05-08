package com.huawei.quickcard;

import android.os.SystemClock;
import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.action.ActionsHelper;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.framework.processor.EventProcessor;
import com.huawei.quickcard.framework.processor.PropertyCacheBean;
import com.huawei.quickcard.utils.ValueUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class s<T extends View> implements EventProcessor<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f34218a = "ClickEventProcessor";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private final String f34219a;

        public a(String str) {
            this.f34219a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CardLogUtils.d(s.f34218a, "clicked view, eventStr:" + this.f34219a);
            PropertyCacheBean obtainPropertyCacheBeanFromView = ValueUtils.obtainPropertyCacheBeanFromView(view);
            if (obtainPropertyCacheBeanFromView.getFoolProofingTime() > 0) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime - obtainPropertyCacheBeanFromView.getLastClickTime() < obtainPropertyCacheBeanFromView.getFoolProofingTime()) {
                    CardLogUtils.d(s.f34218a, "click too fast");
                    return;
                }
                obtainPropertyCacheBeanFromView.setLastClickTime(elapsedRealtime);
            }
            ActionsHelper.doAction(view, this.f34219a, null);
        }
    }

    @Override // com.huawei.quickcard.framework.processor.EventProcessor
    public void applyEvent(@NonNull T t2, String str, String str2) {
        t2.setOnClickListener(new a(str2));
    }

    @Override // com.huawei.quickcard.framework.processor.EventProcessor
    public void cleanEvent(@NonNull T t2, String str) {
        t2.setOnClickListener(null);
    }
}
