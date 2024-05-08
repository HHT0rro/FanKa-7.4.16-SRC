package com.alibaba.security.biometrics.build;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.skin.RPSkinManager;
import com.alibaba.security.biometrics.skin.model.DialogSkinData;

/* compiled from: ABAlertDialog.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class v {

    /* renamed from: b, reason: collision with root package name */
    private static final String f2394b = "ABAlertDialog";

    /* renamed from: a, reason: collision with root package name */
    public Dialog f2395a;

    /* renamed from: c, reason: collision with root package name */
    private RPSkinManager f2396c = RPSkinManager.getInstance();

    /* compiled from: ABAlertDialog.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Context f2401a;

        /* renamed from: b, reason: collision with root package name */
        public String f2402b;

        /* renamed from: c, reason: collision with root package name */
        public int f2403c;

        /* renamed from: g, reason: collision with root package name */
        public int f2407g;

        /* renamed from: j, reason: collision with root package name */
        public int f2410j;

        /* renamed from: d, reason: collision with root package name */
        public boolean f2404d = true;

        /* renamed from: e, reason: collision with root package name */
        public boolean f2405e = false;

        /* renamed from: f, reason: collision with root package name */
        public String f2406f = "";

        /* renamed from: h, reason: collision with root package name */
        public c f2408h = new c() { // from class: com.alibaba.security.biometrics.build.v.a.1
            @Override // com.alibaba.security.biometrics.build.v.c
            public final void a(Dialog dialog) {
            }
        };

        /* renamed from: i, reason: collision with root package name */
        public String f2409i = "";

        /* renamed from: k, reason: collision with root package name */
        public b f2411k = new b() { // from class: com.alibaba.security.biometrics.build.v.a.2
            @Override // com.alibaba.security.biometrics.build.v.b
            public final void a(Dialog dialog) {
            }
        };

        public a(Context context) {
            this.f2401a = context;
            this.f2403c = ContextCompat.getColor(context, R.color.rpsdk_color_333333);
            this.f2407g = ContextCompat.getColor(context, R.color.rpsdk_ab_face_dialog_positive);
            this.f2410j = ContextCompat.getColor(context, R.color.rpsdk_ab_face_dialog_negative);
        }

        private v a() {
            return new v(this);
        }

        private a b() {
            this.f2404d = true;
            this.f2405e = false;
            return this;
        }

        private a a(String str) {
            this.f2402b = str;
            return this;
        }

        private a a(String str, c cVar) {
            this.f2406f = str;
            this.f2408h = cVar;
            return this;
        }

        private a a(String str, b bVar) {
            this.f2409i = str;
            this.f2411k = bVar;
            return this;
        }

        private a a(int i10, int i11, int i12) {
            this.f2403c = i10;
            this.f2407g = i11;
            this.f2410j = i12;
            return this;
        }
    }

    /* compiled from: ABAlertDialog.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface b {
        void a(Dialog dialog);
    }

    /* compiled from: ABAlertDialog.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface c {
        void a(Dialog dialog);
    }

    public v(final a aVar) {
        Dialog dialog = new Dialog(aVar.f2401a, R.style.RP_Dialog);
        this.f2395a = dialog;
        dialog.requestWindowFeature(1);
        View inflate = LayoutInflater.from(aVar.f2401a).inflate(R.layout.rp_face_dialog, (ViewGroup) null);
        this.f2395a.setContentView(inflate);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(this.f2395a.getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 17;
        this.f2395a.getWindow().setAttributes(layoutParams);
        TextView textView = (TextView) inflate.findViewById(R.id.abfl_dialog_content_text);
        TextView textView2 = (TextView) inflate.findViewById(R.id.abfl_dialog_positive_btn);
        TextView textView3 = (TextView) inflate.findViewById(R.id.abfl_dialog_negative_btn);
        textView.setTextColor(aVar.f2403c);
        textView2.setTextColor(aVar.f2407g);
        textView3.setTextColor(aVar.f2410j);
        if (TextUtils.isEmpty(aVar.f2402b)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(aVar.f2402b);
        }
        if (TextUtils.isEmpty(aVar.f2406f)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(aVar.f2406f);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.biometrics.build.v.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    aVar.f2408h.a(v.this.f2395a);
                }
            });
        }
        if (TextUtils.isEmpty(aVar.f2409i)) {
            textView3.setVisibility(8);
        } else {
            textView3.setVisibility(0);
            textView3.setText(aVar.f2409i);
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.biometrics.build.v.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    aVar.f2411k.a(v.this.f2395a);
                }
            });
        }
        DialogSkinData dialogSkinData = (DialogSkinData) this.f2396c.getGlobalSkinData("alertDialog", DialogSkinData.class);
        if (dialogSkinData != null) {
            w.a(textView2, dialogSkinData.getPositiveText());
            w.a(textView3, dialogSkinData.getNegativeText());
            w.a(textView, dialogSkinData.getTitleText());
        }
        this.f2395a.setCancelable(aVar.f2404d);
        this.f2395a.setCanceledOnTouchOutside(aVar.f2405e);
    }

    private void c() {
        Dialog dialog = this.f2395a;
        if (dialog == null || dialog.isShowing()) {
            return;
        }
        this.f2395a.show();
    }

    private DialogSkinData d() {
        return (DialogSkinData) this.f2396c.getGlobalSkinData("alertDialog", DialogSkinData.class);
    }

    public final boolean b() {
        Dialog dialog = this.f2395a;
        return dialog != null && dialog.isShowing();
    }

    public final void a() {
        Dialog dialog = this.f2395a;
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
