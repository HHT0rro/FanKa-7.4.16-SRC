package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.DownloadProgressView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;

/* compiled from: OfflineChild.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ev implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    private Context f5625b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f5626c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f5627d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f5628e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f5629f;

    /* renamed from: g, reason: collision with root package name */
    private OfflineMapManager f5630g;

    /* renamed from: h, reason: collision with root package name */
    private OfflineMapCity f5631h;

    /* renamed from: k, reason: collision with root package name */
    private View f5634k;

    /* renamed from: l, reason: collision with root package name */
    private DownloadProgressView f5635l;

    /* renamed from: a, reason: collision with root package name */
    private int f5624a = 0;

    /* renamed from: i, reason: collision with root package name */
    private boolean f5632i = false;

    /* renamed from: j, reason: collision with root package name */
    private Handler f5633j = new Handler() { // from class: com.amap.api.col.3l.ev.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                ev.this.a(message.arg1, message.arg2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    };

    public ev(Context context, OfflineMapManager offlineMapManager) {
        this.f5625b = context;
        b();
        this.f5630g = offlineMapManager;
    }

    private void b() {
        View a10 = ez.a(this.f5625b, 2130903042);
        this.f5634k = a10;
        this.f5635l = (DownloadProgressView) a10.findViewById(2131165200);
        this.f5626c = (TextView) this.f5634k.findViewById(2131165195);
        this.f5627d = (TextView) this.f5634k.findViewById(2131165199);
        this.f5628e = (ImageView) this.f5634k.findViewById(2131165198);
        this.f5629f = (TextView) this.f5634k.findViewById(2131165197);
        this.f5628e.setOnClickListener(this);
    }

    private void c() {
        this.f5629f.setVisibility(8);
        this.f5628e.setVisibility(0);
        this.f5628e.setImageResource(2130837506);
    }

    private void d() {
        this.f5629f.setVisibility(0);
        this.f5628e.setVisibility(0);
        this.f5628e.setImageResource(2130837506);
        this.f5629f.setText("已下载-有更新");
    }

    private void e() {
        if (this.f5624a == 1) {
            this.f5628e.setVisibility(8);
            this.f5629f.setVisibility(0);
            this.f5629f.setText("等待中");
            this.f5629f.setTextColor(Color.parseColor("#4287ff"));
            return;
        }
        this.f5629f.setVisibility(0);
        this.f5628e.setVisibility(8);
        this.f5629f.setTextColor(Color.parseColor("#4287ff"));
        this.f5629f.setText("等待中");
    }

    private void f() {
        this.f5629f.setVisibility(0);
        this.f5628e.setVisibility(8);
        this.f5629f.setTextColor(-65536);
        this.f5629f.setText("下载出现异常");
    }

    private void g() {
        this.f5629f.setVisibility(0);
        this.f5628e.setVisibility(8);
        this.f5629f.setTextColor(-7829368);
        this.f5629f.setText("暂停");
    }

    private void h() {
        this.f5629f.setVisibility(0);
        this.f5628e.setVisibility(8);
        this.f5629f.setText("已下载");
        this.f5629f.setTextColor(Color.parseColor("#898989"));
    }

    private void i() {
        if (this.f5624a == 1) {
            return;
        }
        this.f5629f.setVisibility(0);
        this.f5628e.setVisibility(8);
        this.f5629f.setText("解压中");
        this.f5629f.setTextColor(Color.parseColor("#898989"));
    }

    private void j() {
        if (this.f5631h == null) {
            return;
        }
        this.f5629f.setVisibility(0);
        this.f5629f.setText("下载中");
        this.f5628e.setVisibility(8);
        this.f5629f.setTextColor(Color.parseColor("#4287ff"));
    }

    private synchronized void k() {
        this.f5630g.pause();
        this.f5630g.restart();
    }

    private synchronized boolean l() {
        try {
            this.f5630g.downloadByCityName(this.f5631h.getCity());
        } catch (AMapException e2) {
            e2.printStackTrace();
            Toast.makeText(this.f5625b, e2.getErrorMessage(), 0).show();
            return false;
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            if (!dx.d(this.f5625b)) {
                Toast.makeText(this.f5625b, "无网络连接", 0).show();
                return;
            }
            OfflineMapCity offlineMapCity = this.f5631h;
            if (offlineMapCity != null) {
                int state = offlineMapCity.getState();
                this.f5631h.getcompleteCode();
                if (state == 0) {
                    k();
                    g();
                } else {
                    if (state == 1 || state == 4) {
                        return;
                    }
                    if (l()) {
                        e();
                    } else {
                        f();
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10, int i11) throws Exception {
        if (this.f5624a == 2 && i11 > 3 && i11 < 100) {
            this.f5635l.setVisibility(0);
            this.f5635l.setProgress(i11);
        } else {
            this.f5635l.setVisibility(8);
        }
        if (i10 == -1) {
            f();
            return;
        }
        if (i10 == 0) {
            if (this.f5624a == 1) {
                this.f5628e.setVisibility(8);
                this.f5629f.setText("下载中");
                this.f5629f.setTextColor(Color.parseColor("#4287ff"));
                return;
            }
            j();
            return;
        }
        if (i10 == 1) {
            i();
            return;
        }
        if (i10 == 2) {
            e();
            return;
        }
        if (i10 == 3) {
            g();
            return;
        }
        if (i10 == 4) {
            h();
            return;
        }
        if (i10 == 6) {
            c();
        } else {
            if (i10 != 7) {
                switch (i10) {
                    case 101:
                    case 102:
                    case 103:
                        f();
                        return;
                    default:
                        return;
                }
            }
            d();
        }
    }

    private void b(int i10, int i11) {
        OfflineMapCity offlineMapCity = this.f5631h;
        if (offlineMapCity != null) {
            offlineMapCity.setState(i10);
            this.f5631h.setCompleteCode(i11);
        }
        Message message = new Message();
        message.arg1 = i10;
        message.arg2 = i11;
        this.f5633j.sendMessage(message);
    }

    public final void a(int i10) {
        this.f5624a = i10;
    }

    public final View a() {
        return this.f5634k;
    }

    public final void a(OfflineMapCity offlineMapCity) {
        if (offlineMapCity != null) {
            this.f5631h = offlineMapCity;
            this.f5626c.setText(offlineMapCity.getCity());
            double size = ((int) (((offlineMapCity.getSize() / 1024.0d) / 1024.0d) * 100.0d)) / 100.0d;
            this.f5627d.setText(String.valueOf(size) + " M");
            b(this.f5631h.getState(), this.f5631h.getcompleteCode());
        }
    }
}
