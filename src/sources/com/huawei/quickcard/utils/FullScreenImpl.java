package com.huawei.quickcard.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.IFullScreenHelper;
import com.huawei.quickcard.QuickCardRoot;
import com.huawei.quickcard.framework.FullScreenRegistry;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FullScreenImpl {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, IFullScreenHelper> f34271a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private String f34272b;

    public static FullScreenImpl getFullScreenImpl(View view) {
        QuickCardRoot root;
        ViewGroup rootViewGroup;
        CardContext cardContext = ViewUtils.getCardContext(view);
        if (cardContext == null || (root = cardContext.getRoot()) == null || (rootViewGroup = root.getRootViewGroup()) == null) {
            return null;
        }
        return ValueUtils.obtainPropertyCacheBeanFromView(rootViewGroup).getFullScreenImpl();
    }

    public boolean enterFullScreen(String str, Context context, @NonNull View view, int i10) {
        IFullScreenHelper iFullScreenHelper;
        if (TextUtils.isEmpty(str) || !TextUtils.isEmpty(this.f34272b) || (iFullScreenHelper = this.f34271a.get(str)) == null) {
            return false;
        }
        boolean enterFullScreen = iFullScreenHelper.enterFullScreen(context, view, i10, new Object[0]);
        if (enterFullScreen) {
            this.f34272b = str;
            FullScreenController.setFullScreenImpl(this);
            FullScreenController.callNotifyEnterEvent();
        }
        return enterFullScreen;
    }

    public void exitFullScreen(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f34272b) || !str.equals(this.f34272b)) {
            return;
        }
        exitFullScreen();
    }

    public IFullScreenHelper getFullScreenHelper(String str) {
        return this.f34271a.get(str);
    }

    public boolean isFullScreen() {
        return !TextUtils.isEmpty(this.f34272b);
    }

    public void registerFullScreenHelper(String str, IFullScreenHelper iFullScreenHelper) {
        IFullScreenHelper fullScreenHelper = FullScreenRegistry.getFullScreenHelper(str);
        Map<String, IFullScreenHelper> map = this.f34271a;
        if (fullScreenHelper != null) {
            iFullScreenHelper = fullScreenHelper;
        }
        map.put(str, iFullScreenHelper);
    }

    public void exitFullScreen() {
        IFullScreenHelper iFullScreenHelper;
        if (TextUtils.isEmpty(this.f34272b) || (iFullScreenHelper = this.f34271a.get(this.f34272b)) == null || !iFullScreenHelper.exitFullScreen()) {
            return;
        }
        this.f34272b = null;
        FullScreenController.setFullScreenImpl(null);
        FullScreenController.callNotifyExitEvent();
    }
}
