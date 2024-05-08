package com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.alimm.tanx.core.utils.SysUtils;
import com.wangmai.appsdkdex.R$id;
import com.wangmai.appsdkdex.R$layout;
import com.wangmai.appsdkdex.R$style;

/* compiled from: ErrorPopupWindow.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxc_if {
    public final int tanxc_byte = 60;
    public final Context tanxc_do;
    public final LinearLayout tanxc_for;
    public PopupWindow tanxc_if;
    public final View tanxc_int;
    public final View tanxc_new;
    public View.OnClickListener tanxc_try;

    public tanxc_if(Context context) {
        this.tanxc_do = context;
        View inflate = LayoutInflater.from(context).inflate(R$layout.error_popup, (ViewGroup) null);
        this.tanxc_int = inflate;
        this.tanxc_for = (LinearLayout) inflate.findViewById(R$id.ll_ad_close);
        this.tanxc_new = inflate.findViewById(R$id.view_line);
    }

    public void tanxc_do(View view, View.OnClickListener onClickListener) {
        if (tanxc_do()) {
            return;
        }
        this.tanxc_try = onClickListener;
        this.tanxc_for.setOnClickListener(onClickListener);
        PopupWindow popupWindow = new PopupWindow(this.tanxc_do, (AttributeSet) null, R$style.Transparent_Dialog);
        this.tanxc_if = popupWindow;
        popupWindow.setFocusable(false);
        this.tanxc_if.setOutsideTouchable(false);
        this.tanxc_if.setContentView(this.tanxc_int);
        int screenWidth = (SysUtils.getScreenWidth(this.tanxc_int.getContext()) / 4) * 3;
        this.tanxc_if.setWidth(screenWidth);
        this.tanxc_if.setHeight((int) (screenWidth / 1.7d));
        view.getLocationOnScreen(new int[2]);
        this.tanxc_if.showAtLocation(view, 17, 0, 0);
    }

    public void tanxc_if() {
        PopupWindow popupWindow = this.tanxc_if;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public boolean tanxc_do() {
        PopupWindow popupWindow = this.tanxc_if;
        if (popupWindow != null) {
            return popupWindow.isShowing();
        }
        return false;
    }
}