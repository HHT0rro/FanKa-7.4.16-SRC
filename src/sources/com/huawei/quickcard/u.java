package com.huawei.quickcard;

import android.view.ViewGroup;
import com.huawei.quickcard.framework.bean.CardElement;
import com.huawei.quickcard.framework.condition.ConditionalChild;
import com.huawei.quickcard.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private final List<ConditionalChild> f34248a = new ArrayList(4);

    public List<ConditionalChild> a() {
        return this.f34248a;
    }

    public void a(ViewGroup viewGroup, String str, String str2, CardElement cardElement) {
        int childCount = viewGroup.getChildCount();
        if (ViewUtils.getCardContext(viewGroup) == null) {
            return;
        }
        this.f34248a.add(ConditionalChild.createConditionalChild(viewGroup, childCount, str, str2, cardElement));
    }
}
