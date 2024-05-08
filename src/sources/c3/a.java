package c3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.mediapicker.model.Location;
import java.util.ArrayList;
import java.util.List;

/* compiled from: LocationForFeedAdapter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a extends BaseAdapter {

    /* renamed from: b, reason: collision with root package name */
    public List<Location> f1510b;

    /* renamed from: c, reason: collision with root package name */
    public Context f1511c;

    /* compiled from: LocationForFeedAdapter.java */
    /* renamed from: c3.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class C0026a {

        /* renamed from: a, reason: collision with root package name */
        public TextView f1512a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f1513b;

        public C0026a(View view) {
            this.f1512a = (TextView) view.findViewById(R$id.location_address_name);
            this.f1513b = (TextView) view.findViewById(R$id.location_address);
        }
    }

    public a(Context context, List<Location> list) {
        if (list != null) {
            this.f1510b = list;
        } else {
            this.f1510b = new ArrayList();
        }
        this.f1511c = context;
    }

    public void a(List<Location> list) {
        if (list != null) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                Location location = list.get(i10);
                if (!this.f1510b.contains(location)) {
                    this.f1510b.add(location);
                }
            }
            super.notifyDataSetChanged();
        }
    }

    public void b(List<Location> list) {
        if (list != null) {
            this.f1510b = list;
            super.notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f1510b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f1510b.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        C0026a c0026a;
        if (view == null) {
            view = LayoutInflater.from(this.f1511c).inflate(R$layout.item_location_for_feed, (ViewGroup) null);
            c0026a = new C0026a(view);
            view.setTag(c0026a);
        } else {
            c0026a = (C0026a) view.getTag();
        }
        Location location = (Location) getItem(i10);
        c0026a.f1513b.setText(location.getAddress());
        c0026a.f1512a.setText(location.getName());
        return view;
    }
}
