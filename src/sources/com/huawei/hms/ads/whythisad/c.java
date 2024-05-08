package com.huawei.hms.ads.whythisad;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.nativead.R;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c {
    public LinearLayout Code;
    private CusWhyThisAdView I;
    private Context Z;

    public c(Context context, CusWhyThisAdView cusWhyThisAdView, LinearLayout linearLayout) {
        this.Z = context;
        this.I = cusWhyThisAdView;
        this.Code = linearLayout;
    }

    public void Code(List<d> list, boolean z10) {
        int i10;
        int i11;
        gl.Code("ScrollAdapter", "setData and isHorizontal = %s", Boolean.valueOf(z10));
        this.Code.removeAllViews();
        Resources resources = this.Z.getResources();
        for (int i12 = 0; i12 < list.size(); i12++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.Z).inflate(R.layout.hiad_choices_item, (ViewGroup) null);
            TextView textView = (TextView) relativeLayout.findViewById(R.id.scroll_view_text_view);
            if (!z10) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
                textView.setLayoutParams(layoutParams);
            }
            textView.setText(list.get(i12).Code());
            textView.setTag(list.get(i12).V());
            if (list.get(i12).V() == a.HIDE_AD) {
                textView.setBackgroundResource(R.drawable.hiad_choices_feedback_focus);
                i11 = R.color.hiad_whythisad_btn_hide_text_color;
            } else if (list.get(i12).V() == a.WHY_THIS_AD) {
                textView.setBackgroundResource(R.drawable.hiad_choices_feedback_normal);
                i11 = R.color.hiad_whythisad_btn_why_text_color;
            } else {
                if (list.get(i12).V() == a.CLOSE_AD) {
                    i10 = R.drawable.hiad_choices_feedback_normal;
                } else if (list.get(i12).V() == a.NOT_INTEREST) {
                    i10 = R.drawable.hiad_choices_feedback_special;
                } else {
                    textView.setTextColor(resources.getColor(R.color.hiad_whythisad_btn_fb_text_color));
                    gl.Code("ScrollAdapter", "SDK-banner do-nothing settings.");
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.hms.ads.whythisad.c.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (view.getTag() == a.HIDE_AD) {
                                gl.Code("ScrollAdapter", "SDK-banner tag is HIDE_AD");
                                c.this.I.B();
                                return;
                            }
                            if (view.getTag() == a.WHY_THIS_AD) {
                                c.this.I.I();
                                return;
                            }
                            if (view.getTag() == a.CLOSE_AD) {
                                c.this.I.Code(((TextView) view).getText().toString());
                            } else if (view.getTag() == a.NOT_INTEREST) {
                                c.this.I.Code("");
                            } else {
                                gl.Code("ScrollAdapter", "sdk onclick do-nothing");
                            }
                        }
                    });
                    this.Code.addView(relativeLayout);
                }
                textView.setBackgroundResource(i10);
                i11 = R.color.hiad_whythisad_btn_fb_text_color;
            }
            textView.setTextColor(resources.getColor(i11));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.hms.ads.whythisad.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view.getTag() == a.HIDE_AD) {
                        gl.Code("ScrollAdapter", "SDK-banner tag is HIDE_AD");
                        c.this.I.B();
                        return;
                    }
                    if (view.getTag() == a.WHY_THIS_AD) {
                        c.this.I.I();
                        return;
                    }
                    if (view.getTag() == a.CLOSE_AD) {
                        c.this.I.Code(((TextView) view).getText().toString());
                    } else if (view.getTag() == a.NOT_INTEREST) {
                        c.this.I.Code("");
                    } else {
                        gl.Code("ScrollAdapter", "sdk onclick do-nothing");
                    }
                }
            });
            this.Code.addView(relativeLayout);
        }
    }
}
