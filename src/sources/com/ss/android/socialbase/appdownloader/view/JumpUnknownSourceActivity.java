package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.card.FLPNode;
import com.ss.android.socialbase.appdownloader.dk;
import com.ss.android.socialbase.appdownloader.e;
import com.ss.android.socialbase.appdownloader.ej;
import com.ss.android.socialbase.appdownloader.ej.c;
import com.ss.android.socialbase.appdownloader.ej.ve;
import com.ss.android.socialbase.appdownloader.l;
import com.ss.android.socialbase.appdownloader.w;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class JumpUnknownSourceActivity extends Activity {
    private Intent dk;

    @Nullable
    private Intent ej;

    /* renamed from: l, reason: collision with root package name */
    private int f38969l;

    /* renamed from: m, reason: collision with root package name */
    private c f38970m;
    private JSONObject np;

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        m();
        e.m().m(this);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        e.m().m(this);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        Intent intent = getIntent();
        this.dk = intent;
        if (intent != null) {
            this.ej = (Intent) intent.getParcelableExtra("intent");
            this.f38969l = intent.getIntExtra("id", -1);
            try {
                this.np = new JSONObject(intent.getStringExtra(FLPNode.KEY_CONFIG));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (this.np == null) {
            ej.m((Activity) this);
            return;
        }
        dk();
        c cVar = this.f38970m;
        if (cVar != null && !cVar.dk()) {
            this.f38970m.m();
        } else if (this.f38970m == null) {
            finish();
        }
    }

    private void dk() {
        if (this.f38970m != null || this.dk == null) {
            return;
        }
        try {
            com.ss.android.socialbase.appdownloader.ej.ej m10 = l.oa().m();
            ve m11 = m10 != null ? m10.m(this) : null;
            if (m11 == null) {
                m11 = new com.ss.android.socialbase.appdownloader.l.m(this);
            }
            int m12 = w.m(this, "tt_appdownloader_tip");
            int m13 = w.m(this, "tt_appdownloader_label_ok");
            int m14 = w.m(this, "tt_appdownloader_label_cancel");
            String optString = this.np.optString(DownloadSettingKeys.AhPlans.KEY_JUMP_UNKNOWN_SOURCE_TIPS);
            if (TextUtils.isEmpty(optString)) {
                optString = getString(w.m(this, "tt_appdownloader_jump_unknown_source_tips"));
            }
            m11.m(m12).m(optString).m(m13, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                    if (dk.m(jumpUnknownSourceActivity, jumpUnknownSourceActivity.ej, JumpUnknownSourceActivity.this.f38969l, JumpUnknownSourceActivity.this.np)) {
                        dk.ej(JumpUnknownSourceActivity.this.f38969l, JumpUnknownSourceActivity.this.np);
                    } else {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity2 = JumpUnknownSourceActivity.this;
                        dk.m((Context) jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.ej, true);
                    }
                    dk.m(JumpUnknownSourceActivity.this.f38969l, JumpUnknownSourceActivity.this.np);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).dk(m14, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    if (JumpUnknownSourceActivity.this.ej != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        dk.m((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.ej, true);
                    }
                    dk.dk(JumpUnknownSourceActivity.this.f38969l, JumpUnknownSourceActivity.this.np);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).m(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (JumpUnknownSourceActivity.this.ej != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        dk.m((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.ej, true);
                    }
                    dk.dk(JumpUnknownSourceActivity.this.f38969l, JumpUnknownSourceActivity.this.np);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).m(false);
            this.f38970m = m11.m();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void m() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }
}
