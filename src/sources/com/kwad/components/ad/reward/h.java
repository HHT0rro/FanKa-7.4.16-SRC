package com.kwad.components.ad.reward;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.ad.reward.widget.RewardTaskStepView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class h extends com.kwad.components.core.proxy.g {
    private static String pQ = "进阶奖励还差 %s 步到手，\n确认放弃吗？";
    private static String pR = "再观看%ss可获得基础奖励，\n确认放弃吗？";
    private AdTemplate mAdTemplate;
    private a pP;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a extends com.kwad.components.core.webview.tachikoma.e.c {
        void fY();

        void g(int i10, int i11);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b implements a {
        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public void F(boolean z10) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public void fR() {
        }

        @Override // com.kwad.components.ad.reward.h.a
        public void fY() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public void fZ() {
        }

        @Override // com.kwad.components.ad.reward.h.a
        public void g(int i10, int i11) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public void ga() {
        }
    }

    public static c a(g gVar, @Nullable String str) {
        int i10;
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        com.kwad.components.ad.reward.l.b.a aVar = gVar.pq;
        com.kwad.components.ad.reward.l.a.a aVar2 = gVar.pr;
        int i11 = gVar.ps;
        boolean i12 = com.kwad.sdk.core.response.b.e.i(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.dQ(adTemplate)));
        int i13 = 0;
        if (i12 || com.kwad.sdk.core.response.b.e.F(adTemplate)) {
            int ad2 = (int) com.kwad.sdk.core.response.b.a.ad(dQ);
            int L = com.kwad.sdk.core.response.b.a.L(dQ);
            if (ad2 > L) {
                ad2 = L;
            }
            long playDuration = gVar.oJ.getPlayDuration();
            if (playDuration < (ad2 * 1000) - 800 && (i10 = (int) (ad2 - ((((float) playDuration) / 1000.0f) + 0.5f))) >= 0) {
                i13 = i10;
            }
        }
        if (i12 && aVar != null) {
            return c.a(aVar, adTemplate, String.valueOf(i13));
        }
        if (com.kwad.sdk.core.response.b.e.F(adTemplate) && aVar2 != null) {
            return c.a(aVar2, adTemplate, String.valueOf(i13));
        }
        if (com.kwad.components.ad.reward.a.b.i(dQ)) {
            return c.h(dQ);
        }
        if (com.kwad.sdk.core.response.b.a.cb(dQ) == 1 && com.kwad.components.ad.reward.a.b.gz() == 1) {
            return c.a(dQ, i11);
        }
        if (adTemplate.isNativeRewardPreview) {
            return c.i(str, i11);
        }
        if (com.kwad.sdk.core.response.b.a.cL(dQ)) {
            return c.b(adTemplate, i11);
        }
        if (com.kwad.sdk.core.response.b.a.cb(adTemplate)) {
            return c.c(adTemplate, i11);
        }
        if (com.kwad.components.ad.reward.a.b.gt() == 1) {
            return c.j(i11);
        }
        return c.y(str);
    }

    private static View b(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        return a(cVar.ge(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar);
    }

    private static View c(final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, final a aVar) {
        View inflate = layoutInflater.inflate(R.layout.ksad_reward_order_dialog, viewGroup, false);
        KSImageLoader.loadImage((KSCornerImageView) inflate.findViewById(R.id.ksad_reward_order_dialog_icon), cVar.f36550qa, adTemplate);
        ((TextView) inflate.findViewById(R.id.ksad_reward_order_dialog_desc)).setText(cVar.getTitle());
        inflate.findViewById(R.id.ksad_reward_order_dialog_btn_close).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.ga();
                }
            }
        });
        inflate.findViewById(R.id.ksad_reward_order_dialog_btn_view_detail).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.fY();
                }
            }
        });
        inflate.findViewById(R.id.ksad_reward_order_dialog_btn_deny).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.F(false);
                }
            }
        });
        return inflate;
    }

    private static SpannableString e(Context context, String str) {
        SpannableString spannableString = new SpannableString("再看" + str + "秒，即可获得奖励");
        int i10 = R.color.ksad_reward_main_color;
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.kwad.sdk.d.a.a.getColor(context, i10));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(com.kwad.sdk.d.a.a.getColor(context, i10));
        StyleSpan styleSpan = new StyleSpan(1);
        int length = spannableString.length();
        spannableString.setSpan(foregroundColorSpan, 2, length - 7, 34);
        spannableString.setSpan(foregroundColorSpan2, length - 2, length, 34);
        spannableString.setSpan(styleSpan, 0, length, 34);
        return spannableString;
    }

    public static c h(String str, int i10) {
        return c.i(str, i10);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        if (window == null) {
            return;
        }
        getDialog().setCanceledOnTouchOutside(false);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        a aVar = this.pP;
        if (aVar != null) {
            aVar.fR();
        }
    }

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class c extends com.kwad.sdk.core.response.a.a {
        public String pW;
        public String pX;
        public String pY;
        public String pZ;
        public com.kwad.components.ad.reward.l.b.a pq;
        public com.kwad.components.ad.reward.l.a.a pr;

        /* renamed from: qa, reason: collision with root package name */
        public String f36550qa;

        /* renamed from: qb, reason: collision with root package name */
        public String f36551qb;

        /* renamed from: qc, reason: collision with root package name */
        public String f36552qc;

        /* renamed from: qd, reason: collision with root package name */
        public String f36553qd;
        public int style;
        public String title;

        private c() {
        }

        private void A(String str) {
            this.f36553qd = str;
        }

        public static c a(com.kwad.components.ad.reward.l.b.a aVar, AdTemplate adTemplate, String str) {
            c cVar = new c();
            cVar.style = 1;
            cVar.pq = aVar;
            cVar.pZ = str;
            cVar.f36550qa = com.kwad.sdk.core.response.b.a.cf(com.kwad.sdk.core.response.b.e.dQ(adTemplate));
            return cVar;
        }

        public static c b(AdTemplate adTemplate, long j10) {
            AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
            c cVar = new c();
            cVar.style = 8;
            cVar.f36550qa = com.kwad.sdk.core.response.b.a.cf(dQ);
            cVar.title = String.format("再看%s秒，可获得奖励", Long.valueOf(j10));
            cVar.f36551qb = com.kwad.sdk.core.response.b.a.cc(dQ);
            cVar.f36552qc = com.kwad.sdk.core.response.b.a.au(dQ);
            cVar.pW = "放弃奖励";
            cVar.pX = "继续观看";
            cVar.pY = com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dQ(adTemplate));
            return cVar;
        }

        public static c c(AdTemplate adTemplate, long j10) {
            AdMatrixInfo.MerchantLiveReservationInfo db2 = com.kwad.sdk.core.response.b.b.db(adTemplate);
            c cVar = new c();
            cVar.style = 8;
            cVar.f36550qa = db2.userHeadUrl;
            cVar.title = String.format("再看%s秒，可获得奖励", Long.valueOf(j10));
            cVar.f36551qb = db2.title;
            cVar.pW = "放弃奖励";
            cVar.pX = "继续观看";
            cVar.pY = com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dQ(adTemplate));
            return cVar;
        }

        public static c h(AdInfo adInfo) {
            c cVar = new c();
            cVar.style = 4;
            AdProductInfo cP = com.kwad.sdk.core.response.b.a.cP(adInfo);
            cVar.title = com.kwad.sdk.core.response.b.a.au(adInfo);
            cVar.f36550qa = cP.getIcon();
            return cVar;
        }

        public static c i(String str, int i10) {
            c cVar = new c();
            cVar.style = 6;
            cVar.title = str;
            cVar.pW = "残忍离开";
            cVar.pX = "留下看看";
            if (i10 > 0) {
                cVar.f36553qd = String.valueOf(i10);
            }
            return cVar;
        }

        public static c j(long j10) {
            c cVar = new c();
            cVar.style = 6;
            cVar.pW = "残忍离开";
            cVar.pX = "留下看看";
            if (j10 > 0) {
                cVar.A(String.valueOf(j10));
            } else {
                cVar.A(null);
            }
            return cVar;
        }

        public static c y(String str) {
            c cVar = new c();
            cVar.style = 0;
            cVar.title = str;
            cVar.pW = "关闭广告";
            cVar.pX = "继续观看";
            return cVar;
        }

        public static c z(String str) {
            c cVar = new c();
            try {
                cVar.parseJson(new JSONObject(str));
            } catch (JSONException unused) {
            }
            return cVar;
        }

        @Override // com.kwad.sdk.core.response.a.a
        public void afterParseJson(@Nullable JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("mLaunchAppTask");
            if (optJSONObject != null) {
                if (this.pq == null) {
                    this.pq = new com.kwad.components.ad.reward.l.b.a();
                }
                this.pq.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("mLandPageOpenTask");
            if (optJSONObject2 != null) {
                if (this.pr == null) {
                    this.pr = new com.kwad.components.ad.reward.l.a.a();
                }
                this.pr.parseJson(optJSONObject2);
            }
        }

        @Override // com.kwad.sdk.core.response.a.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            com.kwad.components.ad.reward.l.b.a aVar = this.pq;
            if (aVar != null) {
                t.a(jSONObject, "mLaunchAppTask", aVar);
            }
            com.kwad.components.ad.reward.l.a.a aVar2 = this.pr;
            if (aVar2 != null) {
                t.a(jSONObject, "mLandPageOpenTask", aVar2);
            }
        }

        public final String gb() {
            return TextUtils.isEmpty(this.pW) ? "关闭广告" : this.pW;
        }

        public final String gc() {
            return TextUtils.isEmpty(this.pX) ? "继续观看" : this.pX;
        }

        public final com.kwad.components.ad.reward.l.b.a gd() {
            return this.pq;
        }

        public final com.kwad.components.ad.reward.l.a.a ge() {
            return this.pr;
        }

        public final int getStyle() {
            return this.style;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String gf() {
            return this.f36550qa;
        }

        public final String gg() {
            return this.f36551qb;
        }

        public final String gh() {
            return this.f36552qc;
        }

        public final String gi() {
            return TextUtils.isEmpty(this.f36553qd) ? "" : String.format("再看%s秒，可获得优惠", this.f36553qd);
        }

        public static c a(com.kwad.components.ad.reward.l.a.a aVar, AdTemplate adTemplate, String str) {
            c cVar = new c();
            cVar.style = 2;
            cVar.pr = aVar;
            cVar.pZ = str;
            cVar.f36550qa = com.kwad.sdk.core.response.b.a.cf(com.kwad.sdk.core.response.b.e.dQ(adTemplate));
            return cVar;
        }

        public static c a(AdInfo adInfo, long j10) {
            c cVar = new c();
            cVar.style = 5;
            AdProductInfo cP = com.kwad.sdk.core.response.b.a.cP(adInfo);
            cVar.f36551qb = com.kwad.sdk.core.response.b.a.au(adInfo);
            String name = cP.getName();
            cVar.title = name;
            if (TextUtils.isEmpty(name)) {
                cVar.title = com.kwad.sdk.core.response.b.a.ax(adInfo);
            }
            cVar.f36550qa = cP.getIcon();
            if (j10 > 0) {
                cVar.A(String.valueOf(j10));
            } else {
                cVar.A(null);
            }
            return cVar;
        }
    }

    public static h a(Activity activity, AdTemplate adTemplate, c cVar, a aVar) {
        h hVar = new h();
        Bundle bundle = new Bundle();
        bundle.putString("key_params_json", cVar.toJson().toString());
        bundle.putString("key_template_json", adTemplate.toJson().toString());
        hVar.setArguments(bundle);
        hVar.a(aVar);
        hVar.show(activity.getFragmentManager(), "videoCloseDialog");
        return hVar;
    }

    private void a(a aVar) {
        this.pP = aVar;
    }

    @Override // com.kwad.components.core.proxy.g
    @Nullable
    public final View a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        View a10;
        Bundle arguments = getArguments();
        String string = arguments.getString("key_params_json");
        try {
            String string2 = arguments.getString("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            this.mAdTemplate = adTemplate;
            adTemplate.parseJson(new JSONObject(string2));
        } catch (Throwable unused) {
        }
        c z10 = c.z(string);
        int style = z10.getStyle();
        if (style == 1) {
            a10 = a(this, layoutInflater, viewGroup, z10, this.mAdTemplate, this.pP);
        } else if (style == 2) {
            a10 = b(this, layoutInflater, viewGroup, z10, this.mAdTemplate, this.pP);
        } else if (style == 4) {
            a10 = c(this, layoutInflater, viewGroup, z10, this.mAdTemplate, this.pP);
            com.kwad.components.core.s.i.a(new com.kwad.components.core.widget.e(), (ViewGroup) a10);
        } else if (style == 5) {
            com.kwad.components.ad.reward.n.j jVar = new com.kwad.components.ad.reward.n.j(this, this.mAdTemplate, layoutInflater, viewGroup, this.pP);
            jVar.a(z10);
            a10 = jVar.gF();
        } else if (style == 6) {
            a10 = a(this, layoutInflater, viewGroup, z10, this.pP);
        } else if (style != 8) {
            a10 = a((DialogFragment) this, layoutInflater, viewGroup, z10, this.pP);
        } else {
            com.kwad.components.ad.reward.n.m mVar = new com.kwad.components.ad.reward.n.m(this, this.mAdTemplate, layoutInflater, viewGroup, this.pP);
            mVar.a(z10);
            a10 = mVar.gF();
        }
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.ad.reward.h.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                return i10 == 4 && keyEvent.getAction() == 0;
            }
        });
        return a10;
    }

    private static View a(final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, final a aVar) {
        View inflate = layoutInflater.inflate(R.layout.ksad_video_close_dialog, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.ksad_title)).setText(cVar.getTitle());
        TextView textView = (TextView) inflate.findViewById(R.id.ksad_close_btn);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_continue_btn);
        textView.setText(cVar.gb());
        textView2.setText(cVar.gc());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.F(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.ga();
                }
            }
        });
        return inflate;
    }

    private View a(final h hVar, LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, c cVar, final a aVar) {
        View inflate = layoutInflater.inflate(R.layout.ksad_video_close_extend_dialog, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.ksad_reward_close_extend_dialog_play_time_tips)).setText(e(inflate.getContext(), cVar.f36553qd));
        TextView textView = (TextView) inflate.findViewById(R.id.ksad_reward_close_extend_dialog_btn_deny);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_reward_close_extend_dialog_btn_continue);
        textView.setText(cVar.gb());
        textView2.setText(cVar.gc());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                hVar.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.F(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                hVar.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.ga();
                }
            }
        });
        return inflate;
    }

    private static View a(com.kwad.components.ad.reward.l.a aVar, final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, final a aVar2) {
        String format;
        int i10;
        View inflate = layoutInflater.inflate(R.layout.ksad_reward_task_launch_app_dialog, viewGroup, false);
        if (aVar instanceof com.kwad.components.ad.reward.l.b.a) {
            com.kwad.components.ad.reward.l.b.a.a((com.kwad.components.ad.reward.l.b.a) aVar, inflate.getContext(), adTemplate);
        }
        ((RewardTaskStepView) inflate.findViewById(R.id.ksad_reward_task_dialog_steps)).a(aVar.jq(), cVar.pZ);
        KSImageLoader.loadAppIcon((ImageView) inflate.findViewById(R.id.ksad_reward_task_dialog_icon), cVar.gf(), adTemplate, 12);
        TextView textView = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_abandon);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_continue);
        TextView textView3 = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_title);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(aVar.jr());
        String sb3 = sb2.toString();
        String str = cVar.pZ;
        boolean equals = "0".equals(str);
        if (equals) {
            format = String.format(pQ, sb3);
        } else {
            format = String.format(pR, str);
        }
        int indexOf = equals ? format.indexOf(sb3) : format.indexOf(str);
        if (indexOf < 0) {
            textView3.setText(format);
        } else {
            if (equals) {
                i10 = indexOf + 1;
            } else {
                i10 = str.length() > 1 ? indexOf + 3 : indexOf + 2;
            }
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(inflate.getContext().getResources().getColor(R.color.ksad_reward_main_color));
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(foregroundColorSpan, indexOf, i10, 17);
            textView3.setText(spannableString);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar3 = aVar2;
                if (aVar3 != null) {
                    aVar3.F(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar3 = aVar2;
                if (aVar3 != null) {
                    aVar3.ga();
                }
            }
        });
        return inflate;
    }

    private static View a(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        return a(cVar.gd(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar);
    }
}
