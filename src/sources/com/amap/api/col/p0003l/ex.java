package com.amap.api.col.p0003l;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AutoCompleteTextView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.amap.api.maps.offlinemap.DownLoadExpandListView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.amap.api.offlineservice.a;
import com.cupidapp.live.R$array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: OfflineMapPage.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ex extends a implements TextWatcher, View.OnTouchListener, AbsListView.OnScrollListener, OfflineMapManager.OfflineLoadedListener, OfflineMapManager.OfflineMapDownloadListener {

    /* renamed from: b, reason: collision with root package name */
    private ImageView f5639b;

    /* renamed from: c, reason: collision with root package name */
    private RelativeLayout f5640c;

    /* renamed from: d, reason: collision with root package name */
    private DownLoadExpandListView f5641d;

    /* renamed from: e, reason: collision with root package name */
    private ListView f5642e;

    /* renamed from: f, reason: collision with root package name */
    private ExpandableListView f5643f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f5644g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f5645h;

    /* renamed from: i, reason: collision with root package name */
    private AutoCompleteTextView f5646i;

    /* renamed from: j, reason: collision with root package name */
    private RelativeLayout f5647j;

    /* renamed from: k, reason: collision with root package name */
    private RelativeLayout f5648k;

    /* renamed from: l, reason: collision with root package name */
    private ImageView f5649l;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f5650m;

    /* renamed from: n, reason: collision with root package name */
    private RelativeLayout f5651n;

    /* renamed from: p, reason: collision with root package name */
    private er f5653p;

    /* renamed from: r, reason: collision with root package name */
    private eq f5655r;

    /* renamed from: s, reason: collision with root package name */
    private es f5656s;

    /* renamed from: x, reason: collision with root package name */
    private et f5661x;

    /* renamed from: o, reason: collision with root package name */
    private List<OfflineMapProvince> f5652o = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    private OfflineMapManager f5654q = null;

    /* renamed from: t, reason: collision with root package name */
    private boolean f5657t = true;

    /* renamed from: u, reason: collision with root package name */
    private boolean f5658u = true;

    /* renamed from: v, reason: collision with root package name */
    private int f5659v = -1;

    /* renamed from: w, reason: collision with root package name */
    private long f5660w = 0;

    /* renamed from: y, reason: collision with root package name */
    private boolean f5662y = true;

    private void f() {
        try {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f5650m.getLayoutParams();
            layoutParams.leftMargin = a(18.0f);
            this.f5650m.setLayoutParams(layoutParams);
            this.f5646i.setPadding(a(30.0f), 0, 0, 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void g() {
        i();
        es esVar = new es(this.f5654q, this.f8328a);
        this.f5656s = esVar;
        this.f5642e.setAdapter((ListAdapter) esVar);
    }

    private void h() {
        eq eqVar = new eq(this.f8328a, this, this.f5654q, this.f5652o);
        this.f5655r = eqVar;
        this.f5641d.setAdapter(eqVar);
        this.f5655r.notifyDataSetChanged();
    }

    private void i() {
        ArrayList<OfflineMapProvince> offlineMapProvinceList = this.f5654q.getOfflineMapProvinceList();
        this.f5652o.clear();
        this.f5652o.add(null);
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        ArrayList<OfflineMapCity> arrayList2 = new ArrayList<>();
        ArrayList<OfflineMapCity> arrayList3 = new ArrayList<>();
        for (int i10 = 0; i10 < offlineMapProvinceList.size(); i10++) {
            OfflineMapProvince offlineMapProvince = offlineMapProvinceList.get(i10);
            if (offlineMapProvince.getCityList().size() != 1) {
                this.f5652o.add(i10 + 1, offlineMapProvince);
            } else {
                String provinceName = offlineMapProvince.getProvinceName();
                if (provinceName.contains("香港")) {
                    arrayList2.addAll(offlineMapProvince.getCityList());
                } else if (provinceName.contains("澳门")) {
                    arrayList2.addAll(offlineMapProvince.getCityList());
                } else if (provinceName.contains("全国概要图")) {
                    arrayList3.addAll(0, offlineMapProvince.getCityList());
                } else {
                    arrayList3.addAll(offlineMapProvince.getCityList());
                }
            }
        }
        OfflineMapProvince offlineMapProvince2 = new OfflineMapProvince();
        offlineMapProvince2.setProvinceName("基本功能包+直辖市");
        offlineMapProvince2.setCityList(arrayList3);
        this.f5652o.set(0, offlineMapProvince2);
        OfflineMapProvince offlineMapProvince3 = new OfflineMapProvince();
        offlineMapProvince3.setProvinceName("直辖市");
        offlineMapProvince3.setCityList(arrayList);
        OfflineMapProvince offlineMapProvince4 = new OfflineMapProvince();
        offlineMapProvince4.setProvinceName("港澳");
        offlineMapProvince4.setCityList(arrayList2);
        this.f5652o.add(offlineMapProvince4);
    }

    private void j() {
        AutoCompleteTextView autoCompleteTextView = this.f5646i;
        if (autoCompleteTextView == null || !autoCompleteTextView.isFocused()) {
            return;
        }
        this.f5646i.clearFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) this.f8328a.getSystemService("input_method");
        if (inputMethodManager != null ? inputMethodManager.isActive() : false) {
            inputMethodManager.hideSoftInputFromWindow(this.f5646i.getWindowToken(), 2);
        }
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    @Override // com.amap.api.offlineservice.a
    public final RelativeLayout d() {
        if (this.f5640c == null) {
            this.f5640c = (RelativeLayout) ez.a(this.f8328a, R$array.phone_area_code_name);
        }
        return this.f5640c;
    }

    @Override // com.amap.api.offlineservice.a
    public final void e() {
        this.f5654q.destroy();
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public final void onCheckUpdate(boolean z10, String str) {
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public final void onDownload(int i10, int i11, String str) {
        if (i10 == 101) {
            try {
                Toast.makeText(this.f8328a, "网络异常", 0).show();
                this.f5654q.pause();
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (i10 == 2) {
            this.f5655r.a();
        }
        if (this.f5659v == i10) {
            if (System.currentTimeMillis() - this.f5660w > 1200) {
                if (this.f5662y) {
                    this.f5655r.notifyDataSetChanged();
                }
                this.f5660w = System.currentTimeMillis();
                return;
            }
            return;
        }
        er erVar = this.f5653p;
        if (erVar != null) {
            erVar.notifyDataSetChanged();
        }
        eq eqVar = this.f5655r;
        if (eqVar != null) {
            eqVar.notifyDataSetChanged();
        }
        es esVar = this.f5656s;
        if (esVar != null) {
            esVar.notifyDataSetChanged();
        }
        this.f5659v = i10;
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public final void onRemove(boolean z10, String str, String str2) {
        eq eqVar = this.f5655r;
        if (eqVar != null) {
            eqVar.b();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i10, int i11, int i12) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i10) {
        if (i10 == 2) {
            this.f5662y = false;
        } else {
            this.f5662y = true;
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        if (TextUtils.isEmpty(charSequence)) {
            a(false);
            this.f5649l.setVisibility(8);
            return;
        }
        this.f5649l.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        List<OfflineMapProvince> list = this.f5652o;
        if (list != null && list.size() > 0) {
            ArrayList<OfflineMapCity> arrayList2 = new ArrayList();
            Iterator<OfflineMapProvince> iterator2 = this.f5652o.iterator2();
            while (iterator2.hasNext()) {
                arrayList2.addAll(iterator2.next().getCityList());
            }
            for (OfflineMapCity offlineMapCity : arrayList2) {
                String city = offlineMapCity.getCity();
                String pinyin = offlineMapCity.getPinyin();
                String jianpin = offlineMapCity.getJianpin();
                if (charSequence.length() == 1) {
                    if (jianpin.startsWith(String.valueOf(charSequence))) {
                        arrayList.add(offlineMapCity);
                    }
                } else if (jianpin.startsWith(String.valueOf(charSequence)) || pinyin.startsWith(String.valueOf(charSequence)) || city.startsWith(String.valueOf(charSequence))) {
                    arrayList.add(offlineMapCity);
                }
            }
        }
        if (arrayList.size() > 0) {
            a(true);
            Collections.sort(arrayList, new Comparator<OfflineMapCity>() { // from class: com.amap.api.col.3l.ex.2
                private static int a(OfflineMapCity offlineMapCity2, OfflineMapCity offlineMapCity3) {
                    char[] charArray = offlineMapCity2.getJianpin().toCharArray();
                    char[] charArray2 = offlineMapCity3.getJianpin().toCharArray();
                    return (charArray[0] >= charArray2[0] && charArray[1] >= charArray2[1]) ? 0 : 1;
                }

                @Override // java.util.Comparator
                public final /* synthetic */ int compare(OfflineMapCity offlineMapCity2, OfflineMapCity offlineMapCity3) {
                    return a(offlineMapCity2, offlineMapCity3);
                }
            });
            es esVar = this.f5656s;
            if (esVar != null) {
                esVar.a(arrayList);
                this.f5656s.notifyDataSetChanged();
                return;
            }
            return;
        }
        Toast.makeText(this.f8328a, "未找到相关城市", 0).show();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        j();
        if (view.getId() != 2131165208) {
            return false;
        }
        f();
        return false;
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineLoadedListener
    public final void onVerifyComplete() {
        g();
        h();
    }

    @Override // com.amap.api.offlineservice.a
    public final void a(View view) {
        try {
            int id2 = view.getId();
            if (id2 == 2131165205) {
                this.f8328a.closeScr();
                return;
            }
            if (id2 == 2131165184) {
                if (this.f5658u) {
                    this.f5641d.setVisibility(8);
                    this.f5644g.setBackgroundResource(2130837508);
                    this.f5658u = false;
                    return;
                } else {
                    this.f5641d.setVisibility(0);
                    this.f5644g.setBackgroundResource(2130837504);
                    this.f5658u = true;
                    return;
                }
            }
            if (id2 == 2131165189) {
                if (this.f5657t) {
                    this.f5653p.b();
                    this.f5645h.setBackgroundResource(2130837508);
                    this.f5657t = false;
                } else {
                    this.f5653p.a();
                    this.f5645h.setBackgroundResource(2130837504);
                    this.f5657t = true;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.amap.api.offlineservice.a
    public final void b() {
        View a10 = ez.a(this.f8328a, R$array.emoji_face);
        DownLoadExpandListView downLoadExpandListView = (DownLoadExpandListView) a10.findViewById(2131165187);
        this.f5641d = downLoadExpandListView;
        downLoadExpandListView.setOnTouchListener(this);
        this.f5647j = (RelativeLayout) a10.findViewById(2131165184);
        this.f5644g = (ImageView) a10.findViewById(2131165186);
        this.f5647j.setOnClickListener(this.f8328a);
        this.f5648k = (RelativeLayout) a10.findViewById(2131165189);
        this.f5645h = (ImageView) a10.findViewById(2131165190);
        this.f5648k.setOnClickListener(this.f8328a);
        this.f5651n = (RelativeLayout) a10.findViewById(2131165188);
        ImageView imageView = (ImageView) this.f5640c.findViewById(2131165205);
        this.f5639b = imageView;
        imageView.setOnClickListener(this.f8328a);
        this.f5650m = (ImageView) this.f5640c.findViewById(2131165207);
        ImageView imageView2 = (ImageView) this.f5640c.findViewById(2131165209);
        this.f5649l = imageView2;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.amap.api.col.3l.ex.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    ex.this.f5646i.setText("");
                    ex.this.f5649l.setVisibility(8);
                    ex.this.a(false);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ex.this.f5650m.getLayoutParams();
                    layoutParams.leftMargin = ex.this.a(95.0f);
                    ex.this.f5650m.setLayoutParams(layoutParams);
                    ex.this.f5646i.setPadding(ex.this.a(105.0f), 0, 0, 0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        this.f5640c.findViewById(2131165210).setOnTouchListener(this);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.f5640c.findViewById(2131165208);
        this.f5646i = autoCompleteTextView;
        autoCompleteTextView.addTextChangedListener(this);
        this.f5646i.setOnTouchListener(this);
        this.f5642e = (ListView) this.f5640c.findViewById(2131165212);
        ExpandableListView expandableListView = (ExpandableListView) this.f5640c.findViewById(2131165211);
        this.f5643f = expandableListView;
        expandableListView.addHeaderView(a10);
        this.f5643f.setOnTouchListener(this);
        this.f5643f.setOnScrollListener(this);
        try {
            OfflineMapManager offlineMapManager = new OfflineMapManager(this.f8328a, this);
            this.f5654q = offlineMapManager;
            offlineMapManager.setOnOfflineLoadedListener(this);
        } catch (Exception e2) {
            "e=".concat(String.valueOf(e2));
        }
        i();
        er erVar = new er(this.f5652o, this.f5654q, this.f8328a);
        this.f5653p = erVar;
        this.f5643f.setAdapter(erVar);
        this.f5643f.setOnGroupCollapseListener(this.f5653p);
        this.f5643f.setOnGroupExpandListener(this.f5653p);
        this.f5643f.setGroupIndicator(null);
        if (this.f5657t) {
            this.f5645h.setBackgroundResource(2130837504);
            this.f5643f.setVisibility(0);
        } else {
            this.f5645h.setBackgroundResource(2130837508);
            this.f5643f.setVisibility(8);
        }
        if (this.f5658u) {
            this.f5644g.setBackgroundResource(2130837504);
            this.f5641d.setVisibility(0);
        } else {
            this.f5644g.setBackgroundResource(2130837508);
            this.f5641d.setVisibility(8);
        }
    }

    @Override // com.amap.api.offlineservice.a
    public final boolean c() {
        try {
            if (this.f5642e.getVisibility() == 0) {
                this.f5646i.setText("");
                this.f5649l.setVisibility(8);
                a(false);
                return false;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return super.c();
    }

    public final void a(OfflineMapCity offlineMapCity) {
        try {
            if (this.f5661x == null) {
                this.f5661x = new et(this.f8328a, this.f5654q);
            }
            this.f5661x.a(offlineMapCity.getState(), offlineMapCity.getCity());
            this.f5661x.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(boolean z10) {
        if (z10) {
            this.f5647j.setVisibility(8);
            this.f5648k.setVisibility(8);
            this.f5641d.setVisibility(8);
            this.f5643f.setVisibility(8);
            this.f5651n.setVisibility(8);
            this.f5642e.setVisibility(0);
            return;
        }
        this.f5647j.setVisibility(0);
        this.f5648k.setVisibility(0);
        this.f5651n.setVisibility(0);
        this.f5641d.setVisibility(this.f5658u ? 0 : 8);
        this.f5643f.setVisibility(this.f5657t ? 0 : 8);
        this.f5642e.setVisibility(8);
    }
}
