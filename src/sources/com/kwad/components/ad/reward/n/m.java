package com.kwad.components.ad.reward.n;

import android.app.DialogFragment;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.h;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class m extends d implements View.OnClickListener {
    private ImageView fq;
    private TextView hz;
    private h.a pP;

    /* renamed from: zb, reason: collision with root package name */
    private DialogFragment f36573zb;
    private View ze;
    private ViewGroup zt;
    private View zu;
    private TextView zv;
    private TextView zw;
    private TextView zx;
    private View zy;

    public m(DialogFragment dialogFragment, AdTemplate adTemplate, LayoutInflater layoutInflater, ViewGroup viewGroup, h.a aVar) {
        this.f36573zb = dialogFragment;
        this.pP = aVar;
        if (com.kwad.sdk.core.response.b.a.cL(com.kwad.sdk.core.response.b.e.dQ(adTemplate))) {
            this.zt = (ViewGroup) layoutInflater.inflate(R.layout.ksad_live_origin_dialog, viewGroup, false);
            s(true);
        } else {
            this.zt = (ViewGroup) layoutInflater.inflate(R.layout.ksad_live_subscribe_dialog, viewGroup, false);
            s(false);
        }
    }

    private void s(boolean z10) {
        this.zu = this.zt.findViewById(R.id.ksad_live_subscribe_dialog_btn_close);
        this.hz = (TextView) this.zt.findViewById(R.id.ksad_live_subscribe_dialog_title);
        this.fq = (ImageView) this.zt.findViewById(R.id.ksad_live_subscribe_dialog_icon);
        this.zw = (TextView) this.zt.findViewById(R.id.ksad_live_subscribe_dialog_content_txt);
        this.zv = (TextView) this.zt.findViewById(R.id.ksad_live_subscribe_dialog_content);
        this.ze = this.zt.findViewById(R.id.ksad_live_subscribe_dialog_btn_continue);
        this.zy = this.zt.findViewById(R.id.ksad_live_subscribe_dialog_btn_deny);
        this.zx = (TextView) this.zt.findViewById(R.id.ksad_live_subscribe_dialog_vide_detail);
        if (z10) {
            this.zu.setVisibility(8);
        }
        this.zu.setOnClickListener(this);
        this.ze.setOnClickListener(this);
        this.zy.setOnClickListener(this);
        this.zx.setOnClickListener(this);
    }

    public final void a(h.c cVar) {
        KSImageLoader.loadCircleIcon(this.fq, cVar.gf(), this.zt.getContext().getResources().getDrawable(R.drawable.ksad_ic_default_user_avatar));
        String title = cVar.getTitle();
        if (this.hz != null && title != null) {
            SpannableString spannableString = new SpannableString(title);
            int color = gF().getResources().getColor(R.color.ksad_reward_main_color);
            spannableString.setSpan(new ForegroundColorSpan(color), 2, 4, 18);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
            int length = title.length();
            spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
            this.hz.setText(spannableString);
        }
        this.zv.setText(cVar.gg());
        this.zw.setText(cVar.gh());
        this.zx.setText(String.format("%s", cVar.pY));
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup gF() {
        return this.zt;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        h.a aVar;
        if (view.equals(this.zu)) {
            this.f36573zb.dismiss();
            h.a aVar2 = this.pP;
            if (aVar2 != null) {
                aVar2.ga();
                return;
            }
            return;
        }
        if (view.equals(this.ze)) {
            this.f36573zb.dismiss();
            h.a aVar3 = this.pP;
            if (aVar3 != null) {
                aVar3.ga();
                return;
            }
            return;
        }
        if (view.equals(this.zy)) {
            this.f36573zb.dismiss();
            h.a aVar4 = this.pP;
            if (aVar4 != null) {
                aVar4.F(false);
                return;
            }
            return;
        }
        if (!view.equals(this.zx) || (aVar = this.pP) == null) {
            return;
        }
        aVar.g(131, 2);
    }
}
