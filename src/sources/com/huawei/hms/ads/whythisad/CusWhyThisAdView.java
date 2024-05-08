package com.huawei.hms.ads.whythisad;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.utils.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CusWhyThisAdView extends RelativeLayout {
    private HorizontalScrollView B;
    private ScrollView C;
    private c D;
    private LinearLayout F;
    private RelativeLayout I;
    private RelativeLayout L;
    private LinearLayout S;
    private RelativeLayout V;

    /* renamed from: a, reason: collision with root package name */
    private HorizontalScrollView f29531a;

    /* renamed from: b, reason: collision with root package name */
    private ScrollView f29532b;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout f29533c;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f29534d;

    /* renamed from: e, reason: collision with root package name */
    private c f29535e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f29536f;

    /* renamed from: g, reason: collision with root package name */
    private b f29537g;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum a {
        NONE,
        INIT,
        SHOWN,
        DISLIKED
    }

    public CusWhyThisAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context, attributeSet);
    }

    public CusWhyThisAdView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Code(context, attributeSet);
    }

    public CusWhyThisAdView(Context context, RelativeLayout relativeLayout) {
        super(context);
        this.V = relativeLayout;
        Code(context, null);
    }

    private void Code(Context context, AttributeSet attributeSet) {
        RelativeLayout.inflate(context, R.layout.hiad_choices_whythisad_root, this);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.hiad_whythisad_wrapper);
        this.I = relativeLayout;
        relativeLayout.setVisibility(8);
        this.f29531a = (HorizontalScrollView) findViewById(R.id.hiad_whythisad_horizontal_List);
        this.f29533c = (LinearLayout) findViewById(R.id.hiad_whythisad_horizional_ll_wrapper);
        this.f29531a.setVisibility(8);
        this.f29532b = (ScrollView) findViewById(R.id.hiad_whythisad_vertical_feedback_List);
        this.f29534d = (LinearLayout) findViewById(R.id.hiad_whythisad_vertical_ll_wrapper);
        this.f29532b.setVisibility(8);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.hiad_feedback_wrapper);
        this.L = relativeLayout2;
        relativeLayout2.setVisibility(8);
        this.B = (HorizontalScrollView) findViewById(R.id.hiad_feedback_horizontal_List);
        this.S = (LinearLayout) findViewById(R.id.hiad_feedback_horizional_ll_wrapper);
        this.B.setVisibility(8);
        this.C = (ScrollView) findViewById(R.id.hiad_feedback_vertical_feedback_List);
        this.F = (LinearLayout) findViewById(R.id.hiad_feedback_vertical_ll_wrapper);
        this.C.setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.hiad_closed_hint);
        this.f29536f = textView;
        textView.setVisibility(8);
    }

    public void B() {
        Z();
    }

    public void Code() {
        this.I.setVisibility(8);
        this.f29531a.setVisibility(8);
        this.f29532b.setVisibility(8);
        this.B.setVisibility(8);
        this.C.setVisibility(8);
        this.L.setVisibility(8);
        this.f29536f.setVisibility(8);
    }

    public void Code(String str) {
        HorizontalScrollView horizontalScrollView = this.B;
        if (horizontalScrollView != null) {
            horizontalScrollView.setVisibility(8);
        }
        ScrollView scrollView = this.C;
        if (scrollView != null) {
            scrollView.setVisibility(8);
        }
        HorizontalScrollView horizontalScrollView2 = this.f29531a;
        if (horizontalScrollView2 != null) {
            horizontalScrollView2.setVisibility(8);
        }
        ScrollView scrollView2 = this.f29532b;
        if (scrollView2 != null) {
            scrollView2.setVisibility(8);
        }
        RelativeLayout relativeLayout = this.L;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        TextView textView = this.f29536f;
        if (textView != null) {
            textView.setVisibility(0);
        }
        this.f29537g.Code(str);
        gl.Code("CusWhyView", "SDK processCloseEvent");
    }

    public void I() {
        b bVar = this.f29537g;
        if (bVar != null) {
            bVar.V();
        }
    }

    public void V() {
        RelativeLayout relativeLayout = this.L;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        boolean z10 = false;
        this.I.setVisibility(0);
        d dVar = new d(getContext().getString(R.string.hiad_choices_hide), com.huawei.hms.ads.whythisad.a.HIDE_AD);
        d dVar2 = new d(getContext().getString(R.string.hiad_choices_whythisad), com.huawei.hms.ads.whythisad.a.WHY_THIS_AD);
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar);
        arrayList.add(dVar2);
        if (this.V.getWidth() > this.V.getHeight()) {
            this.f29535e = new c(getContext(), this, this.f29533c);
            this.f29531a.setVisibility(0);
            this.f29532b.setVisibility(8);
            z10 = true;
        } else {
            this.f29535e = new c(getContext(), this, this.f29534d);
            this.f29531a.setVisibility(8);
            this.f29532b.setVisibility(0);
        }
        this.f29535e.Code(arrayList, z10);
        gl.Code("CusWhyView", "SDK showWhyThisAd end");
    }

    public void Z() {
        b bVar = this.f29537g;
        if (bVar != null) {
            bVar.Code();
        }
        TextView textView = this.f29536f;
        if (textView != null) {
            textView.setVisibility(8);
        }
        RelativeLayout relativeLayout = this.I;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        RelativeLayout relativeLayout2 = this.L;
        boolean z10 = false;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(0);
        }
        HorizontalScrollView horizontalScrollView = this.B;
        if (horizontalScrollView != null) {
            horizontalScrollView.setVisibility(0);
        }
        List<String> arrayList = new ArrayList<>();
        b bVar2 = this.f29537g;
        if (bVar2 != null) {
            arrayList = bVar2.I();
        }
        ArrayList arrayList2 = new ArrayList();
        if (aa.Code(arrayList)) {
            Code(null);
            return;
        }
        arrayList2.add(new d(getContext().getString(R.string.hiad_choices_ad_no_interest), com.huawei.hms.ads.whythisad.a.NOT_INTEREST));
        Iterator<String> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            arrayList2.add(new d(iterator2.next(), com.huawei.hms.ads.whythisad.a.CLOSE_AD));
        }
        if (this.V.getWidth() > this.V.getHeight()) {
            this.D = new c(getContext(), this, this.S);
            this.B.setVisibility(0);
            this.C.setVisibility(8);
            z10 = true;
        } else {
            this.D = new c(getContext(), this, this.F);
            this.B.setVisibility(8);
            this.C.setVisibility(0);
        }
        this.D.Code(arrayList2, z10);
        gl.Code("CusWhyView", "SDK showFeedBackList end");
    }

    public void setOnCloseCallBack(b bVar) {
        this.f29537g = bVar;
    }
}
