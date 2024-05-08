package com.cupidapp.live.mediapicker.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.poisearch.PoiResultV2;
import com.amap.api.services.poisearch.PoiSearchV2;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.utils.CoordinateModel;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.mediapicker.model.Location;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.p;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class LocationForFeedAct extends FKBaseActivity implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, TextWatcher {
    public String A;
    public ProgressDialog D;
    public InputMethodManager E;
    public List<Location> F;

    /* renamed from: q, reason: collision with root package name */
    public ListView f17105q;

    /* renamed from: r, reason: collision with root package name */
    public FKTitleBarLayout f17106r;

    /* renamed from: s, reason: collision with root package name */
    public EditText f17107s;

    /* renamed from: t, reason: collision with root package name */
    public ImageView f17108t;

    /* renamed from: u, reason: collision with root package name */
    public TextView f17109u;

    /* renamed from: v, reason: collision with root package name */
    public FrameLayout f17110v;

    /* renamed from: w, reason: collision with root package name */
    public c3.a f17111w;

    /* renamed from: x, reason: collision with root package name */
    public Integer f17112x = 20;

    /* renamed from: y, reason: collision with root package name */
    public int f17113y = 0;

    /* renamed from: z, reason: collision with root package name */
    public boolean f17114z = true;
    public Integer B = 10000;
    public Integer C = 10001;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            LocationForFeedAct.this.p1();
            LocationForFeedAct.this.f17107s.setText("");
            LocationForFeedAct.this.s1();
            LocationForFeedAct.this.f17110v.setVisibility(8);
            return true;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LocationForFeedAct.this.f17107s.setFocusable(true);
            LocationForFeedAct.this.f17107s.setFocusableInTouchMode(true);
            LocationForFeedAct.this.f17107s.requestFocus();
            LocationForFeedAct.this.z1();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LocationForFeedAct.this.p1();
            LocationForFeedAct.this.f17107s.setText("");
            LocationForFeedAct.this.s1();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LocationForFeedAct.this.p1();
            LocationForFeedAct.this.f17107s.setText("");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class e implements View.OnFocusChangeListener {
        public e() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            if (z10) {
                if (TextUtils.isEmpty(LocationForFeedAct.this.f17107s.getText().toString())) {
                    LocationForFeedAct.this.f17110v.setVisibility(0);
                } else {
                    LocationForFeedAct.this.f17110v.setVisibility(8);
                }
                LocationForFeedAct.this.f17109u.setVisibility(0);
                return;
            }
            LocationForFeedAct.this.f17110v.setVisibility(8);
            LocationForFeedAct.this.f17109u.setVisibility(8);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class f implements TextView.OnEditorActionListener {
        public f() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
            if (i10 != 3) {
                return true;
            }
            LocationForFeedAct.this.E.hideSoftInputFromWindow(LocationForFeedAct.this.f17107s.getWindowToken(), 0);
            return true;
        }
    }

    public static void A1(Activity activity, int i10) {
        activity.startActivityForResult(new Intent(activity, (Class<?>) LocationForFeedAct.class), i10);
        activity.overridePendingTransition(R$anim.anim_activity_bottom_to_top, R$anim.anmi_stop);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ArrayList v1(String str, Integer num) throws Exception {
        CoordinateModel j10 = LocationUtils.f12270h.a().j();
        PoiSearchV2.Query query = new PoiSearchV2.Query(str, "");
        query.setPageSize(this.f17112x.intValue());
        query.setPageNum(this.f17113y);
        PoiSearchV2 poiSearchV2 = new PoiSearchV2(this, query);
        poiSearchV2.setBound(new PoiSearchV2.SearchBound(new LatLonPoint(j10.getLatitude(), j10.getLongitude()), 3000, true));
        PoiResultV2 searchPOI = poiSearchV2.searchPOI();
        ArrayList arrayList = new ArrayList();
        if (searchPOI != null && searchPOI.getQuery() != null) {
            ArrayList<PoiItemV2> pois = searchPOI.getPois();
            for (int i10 = 0; i10 < pois.size(); i10++) {
                PoiItemV2 poiItemV2 = pois.get(i10);
                arrayList.add(new Location(poiItemV2.getPoiId(), poiItemV2.getSnippet(), poiItemV2.getTitle(), Double.valueOf(poiItemV2.getLatLonPoint().getLatitude()), Double.valueOf(poiItemV2.getLatLonPoint().getLongitude()), poiItemV2.getCityName()));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w1(Integer num, ArrayList arrayList) throws Exception {
        if (this.f17111w == null) {
            c3.a aVar = new c3.a(this, arrayList);
            this.f17111w = aVar;
            this.f17105q.setAdapter((ListAdapter) aVar);
        } else if (num.equals(this.B)) {
            this.f17111w.a(arrayList);
        } else if (num.equals(this.C)) {
            this.f17111w.b(arrayList);
        }
        if (this.F == null) {
            this.F = arrayList;
        }
        if (arrayList.size() > 0) {
            this.f17113y++;
        } else {
            this.f17113y = -1;
        }
        r1();
        this.f17114z = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x1(Throwable th) throws Exception {
        this.f17114z = true;
        com.cupidapp.live.base.view.h.f12779a.r(this, R$string.network_error);
        r1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ p y1(View view) {
        onBackPressed();
        return null;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String obj = editable.toString();
        this.A = obj;
        this.f17113y = 0;
        if (TextUtils.isEmpty(obj)) {
            this.f17108t.setVisibility(8);
            p1();
            this.f17110v.setVisibility(0);
        } else {
            this.f17108t.setVisibility(0);
            this.f17105q.setSelection(0);
            this.f17110v.setVisibility(8);
        }
        q1(this.A, this.C);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.act_location_for_feed);
        this.f17105q = (ListView) findViewById(R$id.location_list);
        this.f17106r = (FKTitleBarLayout) findViewById(R$id.locationForFeedTitleLayout);
        this.f17107s = (EditText) findViewById(R$id.location_search);
        this.f17108t = (ImageView) findViewById(R$id.location_delete_edit);
        this.f17109u = (TextView) findViewById(R$id.location_canceled);
        this.f17110v = (FrameLayout) findViewById(R$id.location_list_cover);
        this.f17105q.setOnScrollListener(this);
        this.f17105q.setOnItemClickListener(this);
        this.f17107s.addTextChangedListener(this);
        this.f17107s.setFocusable(false);
        this.E = (InputMethodManager) getSystemService("input_method");
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.D = progressDialog;
        progressDialog.setProgressStyle(0);
        this.D.setIndeterminate(false);
        this.D.setCancelable(true);
        this.D.setMessage(getString(R$string.loading));
        this.D.show();
        this.f17110v.setOnTouchListener(new a());
        u1();
        d1(R$anim.anmi_stop, Integer.valueOf(R$anim.anim_activity_top_to_bottom));
        this.f17106r.setLeftImageClickEvent(new Function1() { // from class: com.cupidapp.live.mediapicker.activity.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                p y1;
                y1 = LocationForFeedAct.this.y1((View) obj);
                return y1;
            }
        });
        t1();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        Intent intent = new Intent();
        intent.putExtra("location", (Location) this.f17105q.getItemAtPosition(i10));
        setResult(-1, intent);
        onBackPressed();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        if (i10 + i11 + 10 == i12 && this.f17114z) {
            q1(this.f17107s.getText().toString(), this.B);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i10) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public final void p1() {
        this.f17113y = 0;
        c3.a aVar = this.f17111w;
        if (aVar != null) {
            aVar.b(this.F);
        }
    }

    public final void q1(final String str, final Integer num) {
        this.f17114z = false;
        int i10 = this.f17113y;
        if (i10 == -1) {
            r1();
            this.f17114z = true;
        } else {
            Observable.just(Integer.valueOf(i10)).observeOn(Schedulers.io()).map(new Function() { // from class: com.cupidapp.live.mediapicker.activity.l
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ArrayList v12;
                    v12 = LocationForFeedAct.this.v1(str, (Integer) obj);
                    return v12;
                }
            }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.cupidapp.live.mediapicker.activity.k
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    LocationForFeedAct.this.w1(num, (ArrayList) obj);
                }
            }, new Consumer() { // from class: com.cupidapp.live.mediapicker.activity.j
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    LocationForFeedAct.this.x1((Throwable) obj);
                }
            });
        }
    }

    public final void r1() {
        ProgressDialog progressDialog = this.D;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        this.D.dismiss();
    }

    public void s1() {
        ListView listView;
        if (this.E == null || this.f17107s == null || (listView = this.f17105q) == null) {
            return;
        }
        listView.setFocusable(true);
        this.f17105q.setFocusableInTouchMode(true);
        this.f17105q.requestFocus();
        this.E.hideSoftInputFromWindow(this.f17107s.getWindowToken(), 0);
    }

    public final void t1() {
        this.f17107s.setOnClickListener(new b());
        this.f17109u.setOnClickListener(new c());
        this.f17108t.setOnClickListener(new d());
        this.f17107s.setOnFocusChangeListener(new e());
        this.f17107s.setOnEditorActionListener(new f());
    }

    public final void u1() {
        com.cupidapp.live.base.utils.j.b("LOCATION_SERVICE_TEST", "initLocation");
        q1(null, this.B);
    }

    public void z1() {
        EditText editText;
        InputMethodManager inputMethodManager = this.E;
        if (inputMethodManager == null || (editText = this.f17107s) == null) {
            return;
        }
        inputMethodManager.showSoftInput(editText, 0);
    }
}
