package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapManager;

/* compiled from: BottomDialog.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class et extends eu implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private OfflineMapManager f5615a;

    /* renamed from: b, reason: collision with root package name */
    private View f5616b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f5617c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f5618d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f5619e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f5620f;

    /* renamed from: g, reason: collision with root package name */
    private int f5621g;

    /* renamed from: h, reason: collision with root package name */
    private String f5622h;

    public et(Context context, OfflineMapManager offlineMapManager) {
        super(context);
        this.f5615a = offlineMapManager;
    }

    @Override // com.amap.api.col.p0003l.eu
    public final void a() {
        View a10 = ez.a(getContext(), 2130903041);
        this.f5616b = a10;
        setContentView(a10);
        this.f5616b.setOnClickListener(new View.OnClickListener() { // from class: com.amap.api.col.3l.et.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                et.this.dismiss();
            }
        });
        this.f5617c = (TextView) this.f5616b.findViewById(2131165191);
        TextView textView = (TextView) this.f5616b.findViewById(2131165192);
        this.f5618d = textView;
        textView.setText("暂停下载");
        this.f5619e = (TextView) this.f5616b.findViewById(2131165193);
        this.f5620f = (TextView) this.f5616b.findViewById(2131165194);
        this.f5618d.setOnClickListener(this);
        this.f5619e.setOnClickListener(this);
        this.f5620f.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            int id2 = view.getId();
            if (id2 != 2131165192) {
                if (id2 != 2131165193) {
                    if (id2 == 2131165194) {
                        dismiss();
                        return;
                    }
                    return;
                } else {
                    if (TextUtils.isEmpty(this.f5622h)) {
                        return;
                    }
                    this.f5615a.remove(this.f5622h);
                    dismiss();
                    return;
                }
            }
            int i10 = this.f5621g;
            if (i10 == 0) {
                this.f5618d.setText("继续下载");
                this.f5615a.pauseByName(this.f5622h);
            } else if (i10 == 3 || i10 == -1 || i10 == 101 || i10 == 102 || i10 == 103) {
                this.f5618d.setText("暂停下载");
                this.f5615a.downloadByCityName(this.f5622h);
            }
            dismiss();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(int i10, String str) {
        this.f5617c.setText(str);
        if (i10 == 0) {
            this.f5618d.setText("暂停下载");
            this.f5618d.setVisibility(0);
            this.f5619e.setText("取消下载");
        }
        if (i10 == 2) {
            this.f5618d.setVisibility(8);
            this.f5619e.setText("取消下载");
        } else if (i10 == -1 || i10 == 101 || i10 == 102 || i10 == 103) {
            this.f5618d.setText("继续下载");
            this.f5618d.setVisibility(0);
        } else if (i10 == 3) {
            this.f5618d.setVisibility(0);
            this.f5618d.setText("继续下载");
            this.f5619e.setText("取消下载");
        } else if (i10 == 4) {
            this.f5619e.setText("删除");
            this.f5618d.setVisibility(8);
        }
        this.f5621g = i10;
        this.f5622h = str;
    }
}
