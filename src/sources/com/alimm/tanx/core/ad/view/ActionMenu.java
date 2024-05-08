package com.alimm.tanx.core.ad.view;

import com.alimm.tanx.core.utils.NotConfused;
import com.wangmai.appsdkdex.R$drawable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public enum ActionMenu implements NotConfused {
    more(1011, R$drawable.tanx_browser_actionbar_more_selector, "更多"),
    refresh(1012, R$drawable.tanx_browser_topbar_more_refresh, "刷新"),
    copy(1016, R$drawable.tanx_browser_topbar_more_copy, "复制"),
    gotoweb(1013, R$drawable.tanx_browser_topbar_more_brower, "浏览器");

    public static final int ID_COPY = 1016;
    public static final int ID_GOTOWEB = 1013;
    public static final int ID_MORE = 1011;
    public static final int ID_REFRESH = 1012;
    public static final int ID_SHARE = 1015;
    public final int drawable;

    /* renamed from: id, reason: collision with root package name */
    public final int f4181id;
    public String name;

    ActionMenu(int i10, int i11, String str) {
        this.f4181id = i10;
        this.drawable = i11;
        this.name = str;
    }
}
