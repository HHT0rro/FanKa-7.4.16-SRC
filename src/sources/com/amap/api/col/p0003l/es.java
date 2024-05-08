package com.amap.api.col.p0003l;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapActivity;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SearchListAdapter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class es extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private List<OfflineMapCity> f5604a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private OfflineMapManager f5605b;

    /* renamed from: c, reason: collision with root package name */
    private Activity f5606c;

    /* compiled from: SearchListAdapter.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public final class a {

        /* renamed from: a, reason: collision with root package name */
        public TextView f5610a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f5611b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f5612c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f5613d;

        public a() {
        }
    }

    public es(OfflineMapManager offlineMapManager, OfflineMapActivity offlineMapActivity) {
        this.f5605b = offlineMapManager;
        this.f5606c = offlineMapActivity;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f5604a.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i10) {
        return this.f5604a.get(i10);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public final View getView(int i10, View view, ViewGroup viewGroup) {
        final a aVar;
        int state;
        try {
            final OfflineMapCity offlineMapCity = this.f5604a.get(i10);
            if (view == null) {
                aVar = new a();
                view = ez.a(this.f5606c, 2130903042);
                aVar.f5610a = (TextView) view.findViewById(2131165195);
                aVar.f5611b = (TextView) view.findViewById(2131165199);
                aVar.f5612c = (TextView) view.findViewById(2131165197);
                aVar.f5613d = (ImageView) view.findViewById(2131165198);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            aVar.f5613d.setOnClickListener(new View.OnClickListener() { // from class: com.amap.api.col.3l.es.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    aVar.f5613d.setVisibility(8);
                    aVar.f5612c.setVisibility(0);
                    aVar.f5612c.setText("下载中");
                    try {
                        es.this.f5605b.downloadByCityName(offlineMapCity.getCity());
                    } catch (AMapException e2) {
                        e2.printStackTrace();
                    }
                }
            });
            aVar.f5612c.setVisibility(0);
            aVar.f5610a.setText(offlineMapCity.getCity());
            TextView textView = aVar.f5611b;
            textView.setText(String.valueOf(((int) (((offlineMapCity.getSize() / 1024.0d) / 1024.0d) * 100.0d)) / 100.0d) + " M");
            state = offlineMapCity.getState();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (state != -1) {
            if (state == 0 || state == 1) {
                aVar.f5613d.setVisibility(8);
                aVar.f5612c.setText("下载中");
            } else if (state == 2) {
                aVar.f5613d.setVisibility(8);
                aVar.f5612c.setText("等待下载");
            } else if (state == 3) {
                aVar.f5613d.setVisibility(8);
                aVar.f5612c.setText("暂停中");
            } else if (state == 4) {
                aVar.f5613d.setVisibility(8);
                aVar.f5612c.setText("已下载");
            } else if (state != 6) {
                switch (state) {
                }
            } else {
                aVar.f5613d.setVisibility(0);
                aVar.f5612c.setVisibility(8);
            }
            return view;
        }
        aVar.f5613d.setVisibility(8);
        aVar.f5612c.setText("下载失败");
        return view;
    }

    public final void a(List<OfflineMapCity> list) {
        this.f5604a = list;
    }
}
