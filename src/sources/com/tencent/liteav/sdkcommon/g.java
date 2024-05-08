package com.tencent.liteav.sdkcommon;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    public final Context f43170c;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayAdapter<String> f43172e;

    /* renamed from: f, reason: collision with root package name */
    public WindowManager f43173f;

    /* renamed from: g, reason: collision with root package name */
    public View f43174g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f43175h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f43176i;

    /* renamed from: j, reason: collision with root package name */
    public Spinner f43177j;

    /* renamed from: k, reason: collision with root package name */
    public ScrollView f43178k;

    /* renamed from: l, reason: collision with root package name */
    public String f43179l;

    /* renamed from: o, reason: collision with root package name */
    public final a f43182o;

    /* renamed from: a, reason: collision with root package name */
    public final DisplayMetrics f43168a = new DisplayMetrics();

    /* renamed from: b, reason: collision with root package name */
    public final WindowManager.LayoutParams f43169b = new WindowManager.LayoutParams();

    /* renamed from: p, reason: collision with root package name */
    private final int f43183p = -65536;

    /* renamed from: q, reason: collision with root package name */
    private boolean f43184q = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f43180m = false;

    /* renamed from: n, reason: collision with root package name */
    public int f43181n = 1920;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f43171d = new Handler(Looper.getMainLooper());

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void a(int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class b implements View.OnTouchListener {

        /* renamed from: b, reason: collision with root package name */
        private int f43186b;

        /* renamed from: c, reason: collision with root package name */
        private int f43187c;

        private b() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f43186b = (int) motionEvent.getRawX();
                this.f43187c = (int) motionEvent.getRawY();
            } else if (action == 2) {
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                int i10 = rawX - this.f43186b;
                int i11 = rawY - this.f43187c;
                WindowManager.LayoutParams layoutParams = g.this.f43169b;
                int i12 = layoutParams.f816x + i10;
                layoutParams.f816x = i12;
                layoutParams.f817y += i11;
                this.f43186b = rawX;
                this.f43187c = rawY;
                layoutParams.f816x = Math.max(i12, 0);
                WindowManager.LayoutParams layoutParams2 = g.this.f43169b;
                layoutParams2.f817y = Math.max(layoutParams2.f817y, 0);
                g gVar = g.this;
                WindowManager.LayoutParams layoutParams3 = gVar.f43169b;
                int i13 = layoutParams3.f816x;
                DisplayMetrics displayMetrics = gVar.f43168a;
                int i14 = displayMetrics.widthPixels;
                if (i13 + i14 > i14) {
                    layoutParams3.width = i14 - i13;
                } else {
                    layoutParams3.width = i14;
                }
                int i15 = gVar.f43181n;
                layoutParams3.height = i15;
                if (gVar.f43180m) {
                    layoutParams3.height = i15 / 2;
                }
                int i16 = layoutParams3.f817y;
                int i17 = layoutParams3.height + i16;
                int i18 = displayMetrics.heightPixels;
                if (i17 > i18) {
                    layoutParams3.height = i18 - i16;
                }
                ViewGroup.LayoutParams layoutParams4 = gVar.f43178k.getLayoutParams();
                layoutParams4.height = g.this.b();
                g.this.f43178k.setLayoutParams(layoutParams4);
                g gVar2 = g.this;
                gVar2.f43173f.updateViewLayout(view, gVar2.f43169b);
            }
            view.performClick();
            return false;
        }

        public /* synthetic */ b(g gVar, byte b4) {
            this();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class c implements AdapterView.OnItemSelectedListener {
        private c() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            if (view == null) {
                return;
            }
            ((TextView) view).setTextColor(-65536);
            g gVar = g.this;
            gVar.f43179l = gVar.f43172e.getItem(i10);
            g.this.f43182o.a(i10);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onNothingSelected(AdapterView<?> adapterView) {
        }

        public /* synthetic */ c(g gVar, byte b4) {
            this();
        }
    }

    public g(Context context, a aVar) {
        this.f43170c = context;
        this.f43182o = aVar;
        this.f43172e = new ArrayAdapter<>(context, 17367048);
    }

    public final void a(boolean z10) {
        if (z10 == this.f43184q) {
            return;
        }
        if (z10) {
            this.f43173f.addView(this.f43174g, this.f43169b);
        } else {
            this.f43173f.removeView(this.f43174g);
        }
        this.f43184q = z10;
    }

    public final void b(String str) {
        TextView textView = this.f43175h;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final int b() {
        return Math.max((this.f43169b.height - a(230)) - a(20), 0);
    }

    public final void a(String str) {
        TextView textView = this.f43176i;
        if (textView != null) {
            textView.setText(str);
        }
        this.f43171d.post(h.a(this));
    }

    public final void a() {
        TextView textView;
        Spinner spinner = this.f43177j;
        if (spinner == null || (textView = (TextView) spinner.getChildAt(spinner.getSelectedItemPosition())) == null) {
            return;
        }
        textView.setTextColor(-65536);
    }

    public final int a(int i10) {
        return (int) ((i10 * this.f43170c.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
