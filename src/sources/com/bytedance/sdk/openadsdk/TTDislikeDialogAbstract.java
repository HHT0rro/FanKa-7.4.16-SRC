package com.bytedance.sdk.openadsdk;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class TTDislikeDialogAbstract extends Dialog {

    /* renamed from: m, reason: collision with root package name */
    private View f11072m;

    public TTDislikeDialogAbstract(Context context) {
        super(context);
    }

    public abstract int getLayoutId();

    public abstract ViewGroup.LayoutParams getLayoutParams();

    public abstract int[] getTTDislikeListViewIds();

    public void m() {
        if (this.f11072m == null) {
            return;
        }
        int[] tTDislikeListViewIds = getTTDislikeListViewIds();
        if (tTDislikeListViewIds != null && tTDislikeListViewIds.length > 0) {
            for (int i10 : tTDislikeListViewIds) {
                View findViewById = this.f11072m.findViewById(i10);
                if (findViewById != null) {
                    if (!(findViewById instanceof DislikeListView)) {
                        throw new IllegalArgumentException("getTTDislikeListViewIds找到的view类型异常，请检查");
                    }
                } else {
                    throw new IllegalArgumentException("getTTDislikeListViewIds提供的id找不到view，请检查");
                }
            }
            return;
        }
        throw new IllegalArgumentException("dislike选项列表为空，请设置TTDislikeListView");
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            View inflate = LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) null);
            this.f11072m = inflate;
            if (inflate == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            View view = this.f11072m;
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            setContentView(view, layoutParams);
            m();
        } catch (Exception unused) {
        }
    }

    @Deprecated
    public void setDislikeModel(TTDislikeController tTDislikeController) {
    }

    @Deprecated
    public void startPersonalizePromptActivity() {
    }

    public TTDislikeDialogAbstract(Context context, int i10) {
        super(context, i10);
    }
}
