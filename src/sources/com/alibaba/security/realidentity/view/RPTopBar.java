package com.alibaba.security.realidentity.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.security.common.utils.UIUtils;
import com.alibaba.security.realidentity.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RPTopBar extends RelativeLayout {

    /* renamed from: n, reason: collision with root package name */
    private static final int f4056n = 20;

    /* renamed from: a, reason: collision with root package name */
    private View f4057a;

    /* renamed from: b, reason: collision with root package name */
    private View f4058b;

    /* renamed from: c, reason: collision with root package name */
    private ViewGroup f4059c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f4060d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f4061e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f4062f;

    /* renamed from: g, reason: collision with root package name */
    private ViewGroup f4063g;

    /* renamed from: h, reason: collision with root package name */
    private TextView f4064h;

    /* renamed from: i, reason: collision with root package name */
    private ViewGroup f4065i;

    /* renamed from: j, reason: collision with root package name */
    private ImageView f4066j;

    /* renamed from: k, reason: collision with root package name */
    private View f4067k;

    /* renamed from: l, reason: collision with root package name */
    private Context f4068l;

    /* renamed from: m, reason: collision with root package name */
    private int f4069m;

    /* renamed from: o, reason: collision with root package name */
    private View f4070o;

    /* renamed from: p, reason: collision with root package name */
    private int f4071p;

    public RPTopBar(Context context) {
        this(context, null);
    }

    private void a() {
        this.f4057a = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.rp_alrealidentity_top_bar, (ViewGroup) null);
        addView(this.f4057a, new LinearLayout.LayoutParams(-1, -1));
        this.f4058b = this.f4057a.findViewById(R.id.status_bar);
        this.f4059c = (ViewGroup) this.f4057a.findViewById(R.id.iv_left_parent);
        this.f4060d = (ImageView) this.f4057a.findViewById(R.id.iv_left);
        this.f4061e = (TextView) this.f4057a.findViewById(R.id.tv_left_back);
        this.f4062f = (TextView) this.f4057a.findViewById(R.id.tv_title);
        this.f4063g = (ViewGroup) this.f4057a.findViewById(R.id.tv_right_search_parent);
        this.f4065i = (ViewGroup) this.f4057a.findViewById(R.id.iv_right_parent);
        this.f4067k = this.f4057a.findViewById(R.id.topbar_line);
        setClickable(true);
    }

    private void b() {
        ViewGroup.LayoutParams layoutParams = this.f4058b.getLayoutParams();
        layoutParams.height = UIUtils.getStatusBarHeight(getContext());
        this.f4058b.setLayoutParams(layoutParams);
        this.f4058b.setVisibility(0);
        this.f4058b.requestLayout();
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        layoutParams2.height = UIUtils.getStatusBarHeight(getContext()) + UIUtils.dip2px(getContext(), 50.0f);
        setLayoutParams(layoutParams2);
        requestLayout();
    }

    private void c() {
        ViewGroup.LayoutParams layoutParams = this.f4058b.getLayoutParams();
        layoutParams.height = 0;
        this.f4058b.setLayoutParams(layoutParams);
        this.f4058b.setVisibility(8);
        this.f4058b.requestLayout();
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        layoutParams2.height = UIUtils.dip2px(getContext(), 50.0f);
        setLayoutParams(layoutParams2);
        requestLayout();
    }

    private void d() {
        this.f4070o.setVisibility(0);
    }

    private void e() {
        this.f4070o.setVisibility(8);
    }

    private void f() {
        int max = Math.max(((LinearLayout) findViewById(R.id.left)).getMeasuredWidth(), ((LinearLayout) findViewById(R.id.right)).getMeasuredWidth());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f4062f.getLayoutParams();
        layoutParams.leftMargin = max;
        int screenWidth = (int) (UIUtils.getScreenWidth(this.f4068l) - (max * 2));
        layoutParams.width = screenWidth > 0 ? screenWidth : 0;
        if (this.f4071p != screenWidth) {
            this.f4071p = screenWidth;
            this.f4062f.requestLayout();
        }
    }

    public ImageView getIvLeft() {
        return this.f4060d;
    }

    public ViewGroup getIvLeftParent() {
        return this.f4059c;
    }

    public ImageView getIvRight() {
        return this.f4066j;
    }

    public ViewGroup getIvRightParent() {
        return this.f4065i;
    }

    public boolean[] getTopBarItemVisible() {
        boolean[] zArr = new boolean[2];
        zArr[0] = this.f4059c.getVisibility() == 0;
        zArr[1] = this.f4065i.getVisibility() == 0;
        return zArr;
    }

    public TextView getTvLeftBack() {
        return this.f4061e;
    }

    public TextView getTvRightSearch() {
        return this.f4064h;
    }

    public ViewGroup getTvRightSearchParent() {
        return this.f4063g;
    }

    public TextView getTvTitle() {
        return this.f4062f;
    }

    public View getmRootView() {
        return this.f4057a;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        f();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        this.f4057a.setBackgroundColor(i10);
    }

    public void setItemVisible(boolean z10) {
        int i10 = z10 ? 0 : 4;
        ViewGroup[] viewGroupArr = {this.f4059c, this.f4065i};
        for (int i11 = 0; i11 < 2; i11++) {
            ViewGroup viewGroup = viewGroupArr[i11];
            if (viewGroup.getVisibility() != 8) {
                viewGroup.setVisibility(i10);
            }
        }
    }

    public void setTitle(String str) {
        this.f4062f.setText(str);
        f();
    }

    public void setTopbarLineVisibility(int i10) {
        this.f4067k.setVisibility(i10);
    }

    public void setTvRightSearch(TextView textView) {
        this.f4064h = textView;
    }

    public void setTvRightSearchParent(ViewGroup viewGroup) {
        this.f4063g = viewGroup;
    }

    public RPTopBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RPTopBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f4069m = 0;
        this.f4068l = context;
        this.f4057a = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.rp_alrealidentity_top_bar, (ViewGroup) null);
        addView(this.f4057a, new LinearLayout.LayoutParams(-1, -1));
        this.f4058b = this.f4057a.findViewById(R.id.status_bar);
        this.f4059c = (ViewGroup) this.f4057a.findViewById(R.id.iv_left_parent);
        this.f4060d = (ImageView) this.f4057a.findViewById(R.id.iv_left);
        this.f4061e = (TextView) this.f4057a.findViewById(R.id.tv_left_back);
        this.f4062f = (TextView) this.f4057a.findViewById(R.id.tv_title);
        this.f4063g = (ViewGroup) this.f4057a.findViewById(R.id.tv_right_search_parent);
        this.f4065i = (ViewGroup) this.f4057a.findViewById(R.id.iv_right_parent);
        this.f4067k = this.f4057a.findViewById(R.id.topbar_line);
        setClickable(true);
    }

    private void a(boolean z10, boolean z11) {
        if (z10) {
            this.f4059c.setVisibility(0);
        } else {
            this.f4059c.setVisibility(8);
        }
        if (z11) {
            this.f4065i.setVisibility(0);
        } else {
            this.f4065i.setVisibility(8);
        }
    }

    private void a(boolean z10) {
        if (this.f4061e.getVisibility() == 0 && z10) {
            return;
        }
        this.f4061e.setVisibility(z10 ? 0 : 8);
    }
}
