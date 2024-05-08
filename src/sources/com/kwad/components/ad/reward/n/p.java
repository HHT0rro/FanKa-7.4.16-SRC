package com.kwad.components.ad.reward.n;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.model.AdLiveEndResultData;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class p extends s implements View.OnClickListener {
    private com.kwad.components.ad.reward.g qo;
    private ImageView zS;
    private TextView zT;
    private TextView zU;
    private TextView zV;
    private TextView zW;
    private TextView zX;
    private TextView zY;
    private TextView zZ;

    public p(com.kwad.components.ad.reward.g gVar) {
        this.qo = gVar;
    }

    private void b(AdTemplate adTemplate) {
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        KSImageLoader.loadCircleIcon(this.zS, com.kwad.sdk.core.response.b.a.cf(dQ), this.zS.getResources().getDrawable(R.drawable.ksad_ic_default_user_avatar));
        this.zT.setText(com.kwad.sdk.core.response.b.a.cc(dQ));
    }

    private void initView() {
        ViewGroup viewGroup = this.sz;
        if (viewGroup == null) {
            return;
        }
        this.zS = (ImageView) viewGroup.findViewById(R.id.ksad_live_end_page_author_icon);
        this.zT = (TextView) this.sz.findViewById(R.id.ksad_author_name_txt);
        this.zU = (TextView) this.sz.findViewById(R.id.ksad_live_end_detail_watch_person_count);
        this.zV = (TextView) this.sz.findViewById(R.id.ksad_live_end_detail_like_person_count);
        this.zW = (TextView) this.sz.findViewById(R.id.ksad_live_end_detail_watch_time);
        this.zX = (TextView) this.sz.findViewById(R.id.ksad_live_end_bottom_title);
        this.zY = (TextView) this.sz.findViewById(R.id.ksad_live_end_bottom_action_btn);
        this.zZ = (TextView) this.sz.findViewById(R.id.ksad_live_end_bottom_des_btn);
        this.zY.setOnClickListener(this);
        this.zZ.setOnClickListener(this);
    }

    private static String m(long j10) {
        long j11 = j10 / 3600000;
        long j12 = (j10 / 60000) - (j11 * 60);
        long j13 = ((j10 / 1000) - (60 * j12)) - (3600 * j11);
        return j11 > 0 ? String.format("%02d:%02d:%02d", Long.valueOf(j11), Long.valueOf(j12), Long.valueOf(j13)) : String.format("%02d:%02d", Long.valueOf(j12), Long.valueOf(j13));
    }

    public final void T(int i10) {
        TextView textView = this.zX;
        if (textView == null || i10 <= 0) {
            return;
        }
        if (this.qo.oY) {
            String format = String.format("再停留%s秒，即可获得奖励", Integer.valueOf(i10));
            SpannableString spannableString = new SpannableString(format);
            int color = gF().getResources().getColor(R.color.ksad_reward_main_color);
            spannableString.setSpan(new ForegroundColorSpan(color), 3, 6, 18);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
            int length = format.length();
            spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
            this.zX.setText(spannableString);
            return;
        }
        textView.setText("已获得奖励");
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        b(rVar.getAdTemplate());
    }

    public final void h(ViewGroup viewGroup) {
        super.a(viewGroup, R.id.ksad_reward_origin_live_end_page_stub, R.id.ksad_live_end_page_layout_root);
        initView();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        bVar.cT(24);
        if (view.equals(this.zY)) {
            this.qo.a(2, view.getContext(), 38, 1, 0L, false, bVar);
        } else if (view.equals(this.zZ)) {
            this.qo.a(2, view.getContext(), 37, 1, 0L, false, bVar);
        }
    }

    public final void a(com.kwad.components.ad.reward.g gVar, AdLiveEndResultData.AdLivePushEndInfo adLivePushEndInfo, long j10) {
        this.zV.setText(adLivePushEndInfo.mDisplayLikeUserCount);
        this.zW.setText(m(adLivePushEndInfo.mLiveDuration));
        this.zU.setText(adLivePushEndInfo.mDisplayWatchingUserCount);
        if (gVar.oY) {
            String format = String.format("再停留%s秒，即可获得奖励", Integer.valueOf((int) (Math.max(com.kwad.sdk.core.response.b.a.ag(com.kwad.sdk.core.response.b.e.dQ(gVar.mAdTemplate)) - j10, 0L) / 1000)));
            SpannableString spannableString = new SpannableString(format);
            int color = gF().getResources().getColor(R.color.ksad_reward_main_color);
            spannableString.setSpan(new ForegroundColorSpan(color), 3, 6, 18);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
            int length = format.length();
            spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
            this.zX.setText(spannableString);
            return;
        }
        this.zX.setText("内容很精彩，不要错过哦");
    }
}
