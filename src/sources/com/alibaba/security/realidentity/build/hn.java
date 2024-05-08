package com.alibaba.security.realidentity.build;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.alibaba.security.realidentity.R;

/* compiled from: RPAlertDialog.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class hn {

    /* renamed from: a, reason: collision with root package name */
    private Dialog f3851a;

    /* compiled from: RPAlertDialog.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Context f3858a;

        /* renamed from: b, reason: collision with root package name */
        public String f3859b;

        /* renamed from: c, reason: collision with root package name */
        public String f3860c;

        /* renamed from: d, reason: collision with root package name */
        public String f3861d;

        /* renamed from: e, reason: collision with root package name */
        public int f3862e;

        /* renamed from: f, reason: collision with root package name */
        public int f3863f;

        /* renamed from: g, reason: collision with root package name */
        public int f3864g;

        /* renamed from: k, reason: collision with root package name */
        public int f3868k;

        /* renamed from: m, reason: collision with root package name */
        public int f3870m;

        /* renamed from: h, reason: collision with root package name */
        public boolean f3865h = true;

        /* renamed from: i, reason: collision with root package name */
        public boolean f3866i = false;

        /* renamed from: j, reason: collision with root package name */
        public String f3867j = "";

        /* renamed from: n, reason: collision with root package name */
        private c f3871n = new c() { // from class: com.alibaba.security.realidentity.build.hn.a.1
            @Override // com.alibaba.security.realidentity.build.hn.c
            public final void a() {
            }
        };

        /* renamed from: l, reason: collision with root package name */
        public String f3869l = "";

        /* renamed from: o, reason: collision with root package name */
        private b f3872o = new b() { // from class: com.alibaba.security.realidentity.build.hn.a.2
            @Override // com.alibaba.security.realidentity.build.hn.b
            public final void a() {
            }
        };

        private a(Context context) {
            this.f3858a = context;
            int i10 = R.color.rpsdk_common_text;
            this.f3862e = ContextCompat.getColor(context, i10);
            int i11 = R.color.rpsdk_gray_light;
            this.f3863f = ContextCompat.getColor(context, i11);
            this.f3864g = ContextCompat.getColor(context, i10);
            this.f3868k = ContextCompat.getColor(context, R.color.rpsdk_identity_primary);
            this.f3870m = ContextCompat.getColor(context, i11);
        }

        private hn a() {
            return new hn(this);
        }

        private a b(String str) {
            this.f3860c = str;
            return this;
        }

        private a c(String str) {
            this.f3861d = str;
            return this;
        }

        private a a(String str) {
            this.f3859b = str;
            return this;
        }

        private a a(boolean z10, boolean z11) {
            this.f3865h = z10;
            this.f3866i = z11;
            return this;
        }

        private a a(String str, c cVar) {
            this.f3867j = str;
            this.f3871n = cVar;
            return this;
        }

        private a a(String str, b bVar) {
            this.f3869l = str;
            this.f3872o = bVar;
            return this;
        }

        private a a(int i10, int i11, int i12, int i13, int i14) {
            this.f3862e = i10;
            this.f3863f = i11;
            this.f3864g = i12;
            this.f3868k = i13;
            this.f3870m = i14;
            return this;
        }
    }

    /* compiled from: RPAlertDialog.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface b {
        void a();
    }

    /* compiled from: RPAlertDialog.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface c {
        void a();
    }

    public hn(final a aVar) {
        Dialog dialog = new Dialog(aVar.f3858a);
        this.f3851a = dialog;
        dialog.requestWindowFeature(1);
        View inflate = LayoutInflater.from(aVar.f3858a).inflate(R.layout.rp_alrealidentity_alert_dialog, (ViewGroup) null);
        this.f3851a.setContentView(inflate);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(this.f3851a.getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 17;
        this.f3851a.getWindow().setAttributes(layoutParams);
        TextView textView = (TextView) inflate.findViewById(R.id.rp_dialog_title_text);
        TextView textView2 = (TextView) inflate.findViewById(R.id.rp_dialog_subtitle_text);
        TextView textView3 = (TextView) inflate.findViewById(R.id.rp_dialog_content_text);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.rp_dialog_close_btn);
        Button button = (Button) inflate.findViewById(R.id.rp_dialog_positive_btn);
        Button button2 = (Button) inflate.findViewById(R.id.rp_dialog_negative_btn);
        textView.setTextColor(aVar.f3862e);
        textView2.setTextColor(aVar.f3863f);
        textView3.setTextColor(aVar.f3864g);
        button.setTextColor(aVar.f3868k);
        button2.setTextColor(aVar.f3870m);
        if (TextUtils.isEmpty(aVar.f3859b)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(aVar.f3859b);
        }
        if (TextUtils.isEmpty(aVar.f3860c)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(aVar.f3860c);
        }
        if (TextUtils.isEmpty(aVar.f3861d)) {
            textView3.setVisibility(8);
        } else {
            textView3.setVisibility(0);
            textView3.setText(aVar.f3861d);
        }
        if (TextUtils.isEmpty(aVar.f3867j)) {
            button.setVisibility(8);
        } else {
            button.setVisibility(0);
            button.setText(aVar.f3867j);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.realidentity.build.hn.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                }
            });
        }
        if (TextUtils.isEmpty(aVar.f3869l)) {
            button2.setVisibility(8);
        } else {
            button2.setVisibility(0);
            button2.setText(aVar.f3869l);
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.realidentity.build.hn.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                }
            });
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.realidentity.build.hn.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
            }
        });
        this.f3851a.setCancelable(aVar.f3865h);
        this.f3851a.setCanceledOnTouchOutside(aVar.f3866i);
        this.f3851a.show();
    }

    private void a() {
        Dialog dialog = this.f3851a;
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
