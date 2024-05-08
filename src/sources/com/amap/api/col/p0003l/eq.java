package com.amap.api.col.p0003l;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.cupidapp.live.R$array;
import java.util.ArrayList;
import java.util.List;

/* compiled from: OfflineDownloadedAdapter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class eq extends BaseExpandableListAdapter implements ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener {

    /* renamed from: b, reason: collision with root package name */
    private boolean[] f5587b;

    /* renamed from: c, reason: collision with root package name */
    private Context f5588c;

    /* renamed from: d, reason: collision with root package name */
    private ev f5589d;

    /* renamed from: f, reason: collision with root package name */
    private ex f5591f;

    /* renamed from: g, reason: collision with root package name */
    private OfflineMapManager f5592g;

    /* renamed from: e, reason: collision with root package name */
    private List<OfflineMapProvince> f5590e = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public List<OfflineMapProvince> f5586a = new ArrayList();

    /* compiled from: OfflineDownloadedAdapter.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public final class a {

        /* renamed from: a, reason: collision with root package name */
        public ev f5595a;

        public a() {
        }
    }

    public eq(Context context, ex exVar, OfflineMapManager offlineMapManager, List<OfflineMapProvince> list) {
        this.f5588c = context;
        this.f5591f = exVar;
        this.f5592g = offlineMapManager;
        if (list != null && list.size() > 0) {
            this.f5590e.clear();
            this.f5590e.addAll(list);
            for (OfflineMapProvince offlineMapProvince : this.f5590e) {
                if (offlineMapProvince != null && offlineMapProvince.getDownloadedCityList().size() > 0) {
                    this.f5586a.add(offlineMapProvince);
                }
            }
        }
        this.f5587b = new boolean[this.f5586a.size()];
    }

    public final void b() {
        try {
            for (int size = this.f5586a.size(); size > 0; size--) {
                OfflineMapProvince offlineMapProvince = this.f5586a.get(size - 1);
                if (offlineMapProvince.getDownloadedCityList().size() == 0) {
                    this.f5586a.remove(offlineMapProvince);
                }
            }
            this.f5587b = new boolean[this.f5586a.size()];
            notifyDataSetChanged();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getChild(int i10, int i11) {
        return this.f5586a.get(i10).getDownloadedCityList().get(i11);
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getChildId(int i10, int i11) {
        return i11;
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getChildView(int i10, int i11, boolean z10, View view, ViewGroup viewGroup) {
        a aVar;
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            aVar = new a();
            ev evVar = new ev(this.f5588c, this.f5592g);
            this.f5589d = evVar;
            evVar.a(2);
            view = this.f5589d.a();
            aVar.f5595a = this.f5589d;
            view.setTag(aVar);
        }
        OfflineMapProvince offlineMapProvince = this.f5586a.get(i10);
        if (i11 < offlineMapProvince.getDownloadedCityList().size()) {
            final OfflineMapCity offlineMapCity = offlineMapProvince.getDownloadedCityList().get(i11);
            aVar.f5595a.a(offlineMapCity);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.amap.api.col.3l.eq.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    eq.this.f5591f.a(offlineMapCity);
                }
            });
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getChildrenCount(int i10) {
        return this.f5586a.get(i10).getDownloadedCityList().size();
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getGroup(int i10) {
        return this.f5586a.get(i10).getProvinceName();
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getGroupCount() {
        return this.f5586a.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getGroupId(int i10) {
        return i10;
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getGroupView(int i10, boolean z10, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = (RelativeLayout) ez.a(this.f5588c, R$array.phone_area_code);
        }
        TextView textView = (TextView) view.findViewById(2131165201);
        ImageView imageView = (ImageView) view.findViewById(2131165202);
        textView.setText(this.f5586a.get(i10).getProvinceName());
        if (this.f5587b[i10]) {
            imageView.setImageDrawable(ez.a().getDrawable(2130837509));
        } else {
            imageView.setImageDrawable(ez.a().getDrawable(2130837510));
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean isChildSelectable(int i10, int i11) {
        return true;
    }

    @Override // android.widget.ExpandableListView.OnGroupCollapseListener
    public final void onGroupCollapse(int i10) {
        this.f5587b[i10] = false;
    }

    @Override // android.widget.ExpandableListView.OnGroupExpandListener
    public final void onGroupExpand(int i10) {
        this.f5587b[i10] = true;
    }

    public final void a() {
        for (OfflineMapProvince offlineMapProvince : this.f5590e) {
            if (offlineMapProvince.getDownloadedCityList().size() > 0 && !this.f5586a.contains(offlineMapProvince)) {
                this.f5586a.add(offlineMapProvince);
            }
        }
        this.f5587b = new boolean[this.f5586a.size()];
        notifyDataSetChanged();
    }
}
