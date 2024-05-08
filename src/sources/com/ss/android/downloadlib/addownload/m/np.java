package com.ss.android.downloadlib.addownload.m;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class np extends Dialog {

    /* renamed from: c, reason: collision with root package name */
    private String f38640c;
    private TextView dk;

    /* renamed from: e, reason: collision with root package name */
    private boolean f38641e;
    private TextView ej;

    /* renamed from: hc, reason: collision with root package name */
    private boolean f38642hc;

    /* renamed from: l, reason: collision with root package name */
    private TextView f38643l;

    /* renamed from: m, reason: collision with root package name */
    private TextView f38644m;

    /* renamed from: n, reason: collision with root package name */
    private ej f38645n;
    private l np;

    /* renamed from: oa, reason: collision with root package name */
    private String f38646oa;
    private String sy;
    private String ve;

    /* renamed from: w, reason: collision with root package name */
    private Activity f38647w;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class m {
        private String dk;

        /* renamed from: e, reason: collision with root package name */
        private ej f38651e;
        private String ej;

        /* renamed from: hc, reason: collision with root package name */
        private l f38652hc;

        /* renamed from: l, reason: collision with root package name */
        private String f38653l;

        /* renamed from: m, reason: collision with root package name */
        private Activity f38654m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f38655n;
        private String np;

        public m(Activity activity) {
            this.f38654m = activity;
        }

        public m dk(String str) {
            this.ej = str;
            return this;
        }

        public m ej(String str) {
            this.f38653l = str;
            return this;
        }

        public m l(String str) {
            this.np = str;
            return this;
        }

        public m m(String str) {
            this.dk = str;
            return this;
        }

        public m m(boolean z10) {
            this.f38655n = z10;
            return this;
        }

        public m m(l lVar) {
            this.f38652hc = lVar;
            return this;
        }

        public m m(ej ejVar) {
            this.f38651e = ejVar;
            return this;
        }

        public np m() {
            return new np(this.f38654m, this.dk, this.ej, this.f38653l, this.np, this.f38655n, this.f38652hc, this.f38651e);
        }
    }

    public np(@NonNull Activity activity, String str, String str2, String str3, String str4, boolean z10, @NonNull l lVar, ej ejVar) {
        super(activity, R.style.ttdownloader_translucent_dialog);
        this.f38647w = activity;
        this.np = lVar;
        this.f38646oa = str;
        this.f38640c = str2;
        this.ve = str3;
        this.sy = str4;
        this.f38645n = ejVar;
        setCanceledOnTouchOutside(z10);
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete() {
        this.f38641e = true;
        dismiss();
    }

    private void l() {
        setContentView(LayoutInflater.from(this.f38647w.getApplicationContext()).inflate(m(), (ViewGroup) null));
        this.f38644m = (TextView) findViewById(dk());
        this.dk = (TextView) findViewById(ej());
        this.ej = (TextView) findViewById(R.id.message_tv);
        this.f38643l = (TextView) findViewById(R.id.delete_tv);
        if (!TextUtils.isEmpty(this.f38640c)) {
            this.f38644m.setText(this.f38640c);
        }
        if (!TextUtils.isEmpty(this.ve)) {
            this.dk.setText(this.ve);
        }
        if (!TextUtils.isEmpty(this.sy)) {
            this.f38643l.setText(this.sy);
        } else {
            this.f38643l.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.f38646oa)) {
            this.ej.setText(this.f38646oa);
        }
        this.f38644m.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.m.np.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                np.this.np();
            }
        });
        this.dk.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.m.np.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                np.this.n();
            }
        });
        this.f38643l.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.m.np.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                np.this.delete();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void np() {
        this.f38642hc = true;
        dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.f38647w.isFinishing()) {
            this.f38647w.finish();
        }
        if (this.f38642hc) {
            this.np.m();
        } else if (this.f38641e) {
            this.f38645n.delete();
        } else {
            this.np.dk();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public int dk() {
        return R.id.confirm_tv;
    }

    public int ej() {
        return R.id.cancel_tv;
    }

    public int m() {
        return R.layout.ttdownloader_dialog_select_operation;
    }
}
