package com.huawei.quickcard.action;

import android.text.TextUtils;
import android.view.View;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.utils.StrUtils;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.video.VideoAttributes;
import java.util.HashMap;
import java.util.Map;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ActionsHelper {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33261a = "ActionsHelper";

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, Class<? extends AbsQuickCardAction>> f33262b = new HashMap();

    static {
        registerActionTypes("deeplink", DeeplinkAction.class);
        registerActionTypes(VideoAttributes.Event.NETWORK_CHANGED, NetworkChangedAction.class);
    }

    public static void doAction(View view, String str, Map<String, Object> map) {
        CardContext cardContext = ViewUtils.getCardContext(view);
        if (cardContext != null && !TextUtils.isEmpty(str)) {
            CardLogUtils.d(f33261a, "execute action script on view:" + StrUtils.objDesc(view));
            cardContext.doActions(ViewUtils.composeForItemScript(view, str, false), view, map);
            return;
        }
        CardLogUtils.e(f33261a, "execute action script fail with no actionContent or cardContext:" + StrUtils.objDesc(view));
    }

    public static Map<String, Class<? extends AbsQuickCardAction>> getInnerActions() {
        return f33262b;
    }

    public static void registerActionTypes(String str, Class<? extends AbsQuickCardAction> cls) {
        f33262b.put(str, cls);
    }
}
