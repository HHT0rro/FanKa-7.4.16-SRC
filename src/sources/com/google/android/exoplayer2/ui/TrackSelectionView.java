package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class TrackSelectionView extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    public final int f22567b;

    /* renamed from: c, reason: collision with root package name */
    public final LayoutInflater f22568c;

    /* renamed from: d, reason: collision with root package name */
    public final CheckedTextView f22569d;

    /* renamed from: e, reason: collision with root package name */
    public final CheckedTextView f22570e;

    /* renamed from: f, reason: collision with root package name */
    public final b f22571f;

    /* renamed from: g, reason: collision with root package name */
    public final SparseArray<DefaultTrackSelector.SelectionOverride> f22572g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f22573h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f22574i;

    /* renamed from: j, reason: collision with root package name */
    public n0 f22575j;

    /* renamed from: k, reason: collision with root package name */
    public CheckedTextView[][] f22576k;

    /* renamed from: l, reason: collision with root package name */
    public b.a f22577l;

    /* renamed from: m, reason: collision with root package name */
    public int f22578m;

    /* renamed from: n, reason: collision with root package name */
    public TrackGroupArray f22579n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f22580o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public Comparator<c> f22581p;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public d f22582q;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TrackSelectionView.this.onClick(view);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f22584a;

        /* renamed from: b, reason: collision with root package name */
        public final int f22585b;

        /* renamed from: c, reason: collision with root package name */
        public final Format f22586c;

        public c(int i10, int i11, Format format) {
            this.f22584a = i10;
            this.f22585b = i11;
            this.f22586c = format;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface d {
        void a(boolean z10, List<DefaultTrackSelector.SelectionOverride> list);
    }

    public TrackSelectionView(Context context) {
        this(context, null);
    }

    public static int[] b(int[] iArr, int i10) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length + 1);
        copyOf[copyOf.length - 1] = i10;
        return copyOf;
    }

    public static int[] c(int[] iArr, int i10) {
        int[] iArr2 = new int[iArr.length - 1];
        int i11 = 0;
        for (int i12 : iArr) {
            if (i12 != i10) {
                iArr2[i11] = i12;
                i11++;
            }
        }
        return iArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClick(View view) {
        if (view == this.f22569d) {
            e();
        } else if (view == this.f22570e) {
            d();
        } else {
            f(view);
        }
        i();
        d dVar = this.f22582q;
        if (dVar != null) {
            dVar.a(getIsDisabled(), getOverrides());
        }
    }

    public final void d() {
        this.f22580o = false;
        this.f22572g.clear();
    }

    public final void e() {
        this.f22580o = true;
        this.f22572g.clear();
    }

    public final void f(View view) {
        this.f22580o = false;
        c cVar = (c) com.google.android.exoplayer2.util.a.e(view.getTag());
        int i10 = cVar.f22584a;
        int i11 = cVar.f22585b;
        DefaultTrackSelector.SelectionOverride selectionOverride = this.f22572g.get(i10);
        com.google.android.exoplayer2.util.a.e(this.f22577l);
        if (selectionOverride == null) {
            if (!this.f22574i && this.f22572g.size() > 0) {
                this.f22572g.clear();
            }
            this.f22572g.put(i10, new DefaultTrackSelector.SelectionOverride(i10, i11));
            return;
        }
        int i12 = selectionOverride.f22231d;
        int[] iArr = selectionOverride.f22230c;
        boolean isChecked = ((CheckedTextView) view).isChecked();
        boolean g3 = g(i10);
        boolean z10 = g3 || h();
        if (isChecked && z10) {
            if (i12 == 1) {
                this.f22572g.remove(i10);
                return;
            } else {
                this.f22572g.put(i10, new DefaultTrackSelector.SelectionOverride(i10, c(iArr, i11)));
                return;
            }
        }
        if (isChecked) {
            return;
        }
        if (g3) {
            this.f22572g.put(i10, new DefaultTrackSelector.SelectionOverride(i10, b(iArr, i11)));
        } else {
            this.f22572g.put(i10, new DefaultTrackSelector.SelectionOverride(i10, i11));
        }
    }

    public final boolean g(int i10) {
        return this.f22573h && this.f22579n.a(i10).f21168b > 1 && this.f22577l.a(this.f22578m, i10, false) != 0;
    }

    public boolean getIsDisabled() {
        return this.f22580o;
    }

    public List<DefaultTrackSelector.SelectionOverride> getOverrides() {
        ArrayList arrayList = new ArrayList(this.f22572g.size());
        for (int i10 = 0; i10 < this.f22572g.size(); i10++) {
            arrayList.add(this.f22572g.valueAt(i10));
        }
        return arrayList;
    }

    public final boolean h() {
        return this.f22574i && this.f22579n.f21172b > 1;
    }

    public final void i() {
        this.f22569d.setChecked(this.f22580o);
        this.f22570e.setChecked(!this.f22580o && this.f22572g.size() == 0);
        for (int i10 = 0; i10 < this.f22576k.length; i10++) {
            DefaultTrackSelector.SelectionOverride selectionOverride = this.f22572g.get(i10);
            int i11 = 0;
            while (true) {
                CheckedTextView[][] checkedTextViewArr = this.f22576k;
                if (i11 < checkedTextViewArr[i10].length) {
                    if (selectionOverride != null) {
                        this.f22576k[i10][i11].setChecked(selectionOverride.a(((c) com.google.android.exoplayer2.util.a.e(checkedTextViewArr[i10][i11].getTag())).f22585b));
                    } else {
                        checkedTextViewArr[i10][i11].setChecked(false);
                    }
                    i11++;
                }
            }
        }
    }

    public final void j() {
        for (int childCount = getChildCount() - 1; childCount >= 3; childCount--) {
            removeViewAt(childCount);
        }
        if (this.f22577l == null) {
            this.f22569d.setEnabled(false);
            this.f22570e.setEnabled(false);
            return;
        }
        this.f22569d.setEnabled(true);
        this.f22570e.setEnabled(true);
        TrackGroupArray e2 = this.f22577l.e(this.f22578m);
        this.f22579n = e2;
        this.f22576k = new CheckedTextView[e2.f21172b];
        boolean h10 = h();
        int i10 = 0;
        while (true) {
            TrackGroupArray trackGroupArray = this.f22579n;
            if (i10 < trackGroupArray.f21172b) {
                TrackGroup a10 = trackGroupArray.a(i10);
                boolean g3 = g(i10);
                CheckedTextView[][] checkedTextViewArr = this.f22576k;
                int i11 = a10.f21168b;
                checkedTextViewArr[i10] = new CheckedTextView[i11];
                c[] cVarArr = new c[i11];
                for (int i12 = 0; i12 < a10.f21168b; i12++) {
                    cVarArr[i12] = new c(i10, i12, a10.a(i12));
                }
                Comparator<c> comparator = this.f22581p;
                if (comparator != null) {
                    Arrays.sort(cVarArr, comparator);
                }
                for (int i13 = 0; i13 < i11; i13++) {
                    if (i13 == 0) {
                        addView(this.f22568c.inflate(R$layout.exo_list_divider, (ViewGroup) this, false));
                    }
                    CheckedTextView checkedTextView = (CheckedTextView) this.f22568c.inflate((g3 || h10) ? 17367056 : 17367055, (ViewGroup) this, false);
                    checkedTextView.setBackgroundResource(this.f22567b);
                    checkedTextView.setText(this.f22575j.a(cVarArr[i13].f22586c));
                    checkedTextView.setTag(cVarArr[i13]);
                    if (this.f22577l.f(this.f22578m, i10, i13) == 4) {
                        checkedTextView.setFocusable(true);
                        checkedTextView.setOnClickListener(this.f22571f);
                    } else {
                        checkedTextView.setFocusable(false);
                        checkedTextView.setEnabled(false);
                    }
                    this.f22576k[i10][i13] = checkedTextView;
                    addView(checkedTextView);
                }
                i10++;
            } else {
                i();
                return;
            }
        }
    }

    public void setAllowAdaptiveSelections(boolean z10) {
        if (this.f22573h != z10) {
            this.f22573h = z10;
            j();
        }
    }

    public void setAllowMultipleOverrides(boolean z10) {
        if (this.f22574i != z10) {
            this.f22574i = z10;
            if (!z10 && this.f22572g.size() > 1) {
                for (int size = this.f22572g.size() - 1; size > 0; size--) {
                    this.f22572g.remove(size);
                }
            }
            j();
        }
    }

    public void setShowDisableOption(boolean z10) {
        this.f22569d.setVisibility(z10 ? 0 : 8);
    }

    public void setTrackNameProvider(n0 n0Var) {
        this.f22575j = (n0) com.google.android.exoplayer2.util.a.e(n0Var);
        j();
    }

    public TrackSelectionView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TrackSelectionView(Context context, @Nullable AttributeSet attributeSet, @AttrRes int i10) {
        super(context, attributeSet, i10);
        setOrientation(1);
        this.f22572g = new SparseArray<>();
        setSaveFromParentEnabled(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16843534});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        this.f22567b = resourceId;
        obtainStyledAttributes.recycle();
        LayoutInflater from = LayoutInflater.from(context);
        this.f22568c = from;
        b bVar = new b();
        this.f22571f = bVar;
        this.f22575j = new f(getResources());
        this.f22579n = TrackGroupArray.f21171e;
        CheckedTextView checkedTextView = (CheckedTextView) from.inflate(17367055, (ViewGroup) this, false);
        this.f22569d = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(R$string.exo_track_selection_none);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(bVar);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(from.inflate(R$layout.exo_list_divider, (ViewGroup) this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) from.inflate(17367055, (ViewGroup) this, false);
        this.f22570e = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(R$string.exo_track_selection_auto);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(bVar);
        addView(checkedTextView2);
    }
}
