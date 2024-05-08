package com.amap.api.col.p0003l;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.cupidapp.live.R$array;
import java.util.List;

/* compiled from: OfflineListAdapter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class er extends BaseExpandableListAdapter implements ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener {

    /* renamed from: a, reason: collision with root package name */
    private boolean[] f5597a;

    /* renamed from: b, reason: collision with root package name */
    private int f5598b = -1;

    /* renamed from: c, reason: collision with root package name */
    private List<OfflineMapProvince> f5599c;

    /* renamed from: d, reason: collision with root package name */
    private OfflineMapManager f5600d;

    /* renamed from: e, reason: collision with root package name */
    private Context f5601e;

    /* compiled from: OfflineListAdapter.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public final class a {

        /* renamed from: a, reason: collision with root package name */
        public ev f5602a;

        public a() {
        }
    }

    public er(List<OfflineMapProvince> list, OfflineMapManager offlineMapManager, Context context) {
        this.f5599c = list;
        this.f5600d = offlineMapManager;
        this.f5601e = context;
        this.f5597a = new boolean[list.size()];
    }

    private boolean a(int i10) {
        return (i10 == 0 || i10 == getGroupCount() - 1) ? false : true;
    }

    public final void b() {
        this.f5598b = 0;
        notifyDataSetChanged();
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getChild(int i10, int i11) {
        return null;
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
            ev evVar = new ev(this.f5601e, this.f5600d);
            evVar.a(1);
            View a10 = evVar.a();
            aVar.f5602a = evVar;
            a10.setTag(aVar);
            view = a10;
        }
        aVar.f5602a.a(this.f5599c.get(i10).getCityList().get(i11));
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getChildrenCount(int i10) {
        if (a(i10)) {
            return this.f5599c.get(i10).getCityList().size();
        }
        return this.f5599c.get(i10).getCityList().size();
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getGroup(int i10) {
        return this.f5599c.get(i10).getProvinceName();
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getGroupCount() {
        int i10 = this.f5598b;
        return i10 == -1 ? this.f5599c.size() : i10;
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getGroupId(int i10) {
        return i10;
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getGroupView(int i10, boolean z10, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = (RelativeLayout) ez.a(this.f5601e, R$array.phone_area_code);
        }
        TextView textView = (TextView) view.findViewById(2131165201);
        ImageView imageView = (ImageView) view.findViewById(2131165202);
        textView.setText(this.f5599c.get(i10).getProvinceName());
        if (this.f5597a[i10]) {
            imageView.setImageDrawable(ez.a().getDrawable(2130837509));
        } else {
            imageView.setImageDrawable(ez.a().getDrawable(2130837510));
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean isChildSelectable(int i10, int i11) {
        return true;
    }

    @Override // android.widget.ExpandableListView.OnGroupCollapseListener
    public final void onGroupCollapse(int i10) {
        this.f5597a[i10] = false;
    }

    @Override // android.widget.ExpandableListView.OnGroupExpandListener
    public final void onGroupExpand(int i10) {
        this.f5597a[i10] = true;
    }

    public final void a() {
        this.f5598b = -1;
        notifyDataSetChanged();
    }
}
