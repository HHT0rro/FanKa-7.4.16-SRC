package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.openadsdk.R;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AppDetailInfoActivity extends Activity {
    private TextView dk;
    private LinearLayout ej;

    /* renamed from: hc, reason: collision with root package name */
    private List<Pair<String, String>> f38494hc;

    /* renamed from: l, reason: collision with root package name */
    private RecyclerView f38495l;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f38496m;

    /* renamed from: n, reason: collision with root package name */
    private long f38497n;
    private long np;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class m extends RecyclerView.Adapter<Object> {
        private m() {
        }
    }

    private void dk() {
        this.f38496m = (ImageView) findViewById(R.id.iv_detail_back);
        this.dk = (TextView) findViewById(R.id.tv_empty);
        this.f38495l = (RecyclerView) findViewById(R.id.permission_list);
        this.ej = (LinearLayout) findViewById(R.id.ll_download);
        if (this.f38494hc.isEmpty()) {
            this.f38495l.setVisibility(8);
            this.dk.setVisibility(0);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(1);
            this.f38495l.setLayoutManager(linearLayoutManager);
            this.f38495l.setAdapter(new m());
        }
        this.f38496m.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                hc.m("lp_app_detail_click_close", AppDetailInfoActivity.this.f38497n);
                AppDetailInfoActivity.this.finish();
            }
        });
        this.ej.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                hc.m("lp_app_detail_click_download", AppDetailInfoActivity.this.f38497n);
                dk.m().dk(AppDetailInfoActivity.this.f38497n);
                com.ss.android.socialbase.appdownloader.ej.m((Activity) AppDetailInfoActivity.this);
                com.ss.android.socialbase.appdownloader.ej.m(dk.m().dk());
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        hc.m("lp_app_detail_click_close", this.f38497n);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ttdownloader_activity_app_detail_info);
        if (m()) {
            dk();
        } else {
            com.ss.android.socialbase.appdownloader.ej.m((Activity) this);
        }
    }

    public static void m(Activity activity, long j10) {
        Intent intent = new Intent(activity, (Class<?>) AppDetailInfoActivity.class);
        intent.putExtra("app_info_id", j10);
        activity.startActivity(intent);
    }

    private boolean m() {
        this.np = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.dk.dk m10 = ej.m().m(this.np);
        if (m10 == null) {
            return false;
        }
        this.f38497n = m10.dk;
        this.f38494hc = m10.f38558e;
        return true;
    }
}
