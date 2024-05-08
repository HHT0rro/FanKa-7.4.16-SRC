package com.huawei.quickcard.framework.processor;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.QuickCardRoot;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.QuickCardValueUtil;
import com.huawei.quickcard.utils.ValueUtils;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.y1;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class IDProcessor<T extends View> implements PropertyProcessor<T> {
    private void a(@NonNull T t2, String str) {
        QuickCardRoot root;
        ViewGroup rootViewGroup;
        PropertyCacheBean obtainPropertyCacheBeanFromView = ValueUtils.obtainPropertyCacheBeanFromView(t2);
        String id2 = obtainPropertyCacheBeanFromView.getId();
        obtainPropertyCacheBeanFromView.setId(str);
        CardContext cardContext = ViewUtils.getCardContext(t2);
        if (cardContext == null || (root = cardContext.getRoot()) == null || (rootViewGroup = root.getRootViewGroup()) == null) {
            return;
        }
        PropertyCacheBean obtainPropertyCacheBeanFromView2 = ValueUtils.obtainPropertyCacheBeanFromView(rootViewGroup);
        if (id2 != null || str != null) {
            if (str == null) {
                obtainPropertyCacheBeanFromView2.removeViewFromIdMap(id2);
            } else {
                obtainPropertyCacheBeanFromView2.putViewIntoIdMap(str, t2);
            }
        }
        cardContext.eventBus().post(new y1(str, t2));
    }

    private void b(@NonNull T t2, String str) {
        if (str == null) {
            t2.setId(-1);
            return;
        }
        int hashCode = str.hashCode();
        if (hashCode == Integer.MIN_VALUE) {
            t2.setId(-1);
        } else {
            t2.setId(Math.abs(hashCode));
        }
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public boolean isImmediate() {
        return true;
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public /* synthetic */ boolean needRefresh() {
        return b.b(this);
    }

    @Override // com.huawei.quickcard.framework.parser.ValueParser
    @NonNull
    public QuickCardValue parseToValue(String str, Object obj) {
        return ParserHelper.parseToString(obj, null);
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        String string = !QuickCardValueUtil.isInvalidValue(quickCardValue) ? quickCardValue.getString() : null;
        b(t2, string);
        a(t2, string);
    }
}
