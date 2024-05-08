package com.huawei.quickcard.framework.touch;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.quickcard.QuickCardView;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.i1;
import com.huawei.quickcard.j1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class TouchEventMgr implements ITouchEventManager {

    /* renamed from: c, reason: collision with root package name */
    private static final String f33946c = "TouchEventMgr";

    /* renamed from: a, reason: collision with root package name */
    private View.OnTouchListener f33947a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<View, IQuickCardTouchEventListener> f33948b = new HashMap();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private IQuickCardTouchEventListener f33949a;

        /* renamed from: b, reason: collision with root package name */
        private View f33950b;

        private b(IQuickCardTouchEventListener iQuickCardTouchEventListener, View view) {
            this.f33949a = iQuickCardTouchEventListener;
            this.f33950b = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static i1 b(View view, i1 i1Var, View view2) {
            view2.getLocationOnScreen(new int[]{0, 0});
            view.getLocationOnScreen(new int[]{0, 0});
            i1 i1Var2 = new i1(i1Var);
            int size = i1Var2.c().size();
            for (int i10 = 0; i10 < size; i10++) {
                j1 j1Var = i1Var2.c().get(i10);
                j1Var.a(i1Var2.a(i10));
                j1Var.a((j1Var.b() + r9[0]) - r1[0]);
                j1Var.b((j1Var.c() + r9[1]) - r1[1]);
            }
            return i1Var2;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class c implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        private List<b> f33951a;

        private c() {
            this.f33951a = new ArrayList();
        }

        private List<b> a(View view, int i10, int i11, boolean[] zArr) {
            ArrayList arrayList = new ArrayList();
            boolean z10 = true;
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                boolean z11 = false;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt = viewGroup.getChildAt(childCount);
                    if (TouchEventMgr.this.a(i10, i11, childAt)) {
                        boolean[] zArr2 = {false};
                        List<b> a10 = a(childAt, i10, i11, zArr2);
                        z11 = zArr2[0];
                        arrayList.addAll(a10);
                        if (z11) {
                            break;
                        }
                    }
                }
                if ((!TouchEventMgr.this.a(i10, i11, viewGroup) || viewGroup.getBackground() == null) && !z11) {
                    z10 = false;
                }
            } else {
                z10 = TouchEventMgr.this.a(i10, i11, view);
            }
            if (zArr != null) {
                zArr[0] = z10;
            }
            IQuickCardTouchEventListener iQuickCardTouchEventListener = (IQuickCardTouchEventListener) TouchEventMgr.this.f33948b.get(view);
            if (iQuickCardTouchEventListener != null) {
                arrayList.add(new b(iQuickCardTouchEventListener, view));
            }
            return arrayList;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (view == null || motionEvent == null) {
                return false;
            }
            Context context = view.getContext();
            boolean z10 = context instanceof Activity;
            if (z10 && ((Activity) context).isFinishing()) {
                return false;
            }
            i1 i1Var = new i1(motionEvent);
            if (z10 && !((Activity) context).hasWindowFocus()) {
                i1Var.d(3);
            }
            int round = Math.round(i1Var.e());
            int round2 = Math.round(i1Var.f());
            int a10 = i1Var.a();
            if (a10 == 0) {
                this.f33951a.addAll(a(view, round, round2, null));
            }
            boolean z11 = false;
            for (int size = this.f33951a.size() - 1; size >= 0; size--) {
                b bVar = this.f33951a.get(size);
                if (bVar != null && bVar.f33949a != null && bVar.f33950b != null) {
                    z11 = bVar.f33949a.onTouch(view, bVar.f33950b, b.b(view, i1Var, bVar.f33950b)) || z11;
                }
            }
            if (a10 == 1 || a10 == 3) {
                this.f33951a.clear();
            }
            return z11;
        }
    }

    public boolean dispatchTouchEvent(QuickCardView quickCardView, MotionEvent motionEvent) {
        if (this.f33947a != null && !this.f33948b.isEmpty()) {
            try {
                return this.f33947a.onTouch(quickCardView, motionEvent);
            } catch (Throwable th) {
                CardLogUtils.e(f33946c, "dispatchTouchEvent error", th);
            }
        }
        return false;
    }

    @Override // com.huawei.quickcard.framework.touch.ITouchEventManager
    public void registerTouchListener(View view, IQuickCardTouchEventListener iQuickCardTouchEventListener) {
        if (view == null || iQuickCardTouchEventListener == null) {
            return;
        }
        this.f33948b.put(view, iQuickCardTouchEventListener);
        if (this.f33947a == null) {
            this.f33947a = new c();
        }
    }

    public void unRegisterTouchListenerByRoot() {
        this.f33947a = null;
        this.f33948b.clear();
    }

    @Override // com.huawei.quickcard.framework.touch.ITouchEventManager
    public void unRegisterTouchListenerByTarget(View view) {
        this.f33948b.remove(view);
        if (this.f33948b.isEmpty()) {
            this.f33947a = null;
        }
    }

    public boolean a(int i10, int i11, View view) {
        if (view == null || !view.isShown()) {
            return false;
        }
        int[] iArr = {0, 0};
        view.getLocationOnScreen(iArr);
        return i10 >= iArr[0] && i10 <= iArr[0] + view.getWidth() && i11 >= iArr[1] && i11 <= iArr[1] + view.getHeight();
    }
}
