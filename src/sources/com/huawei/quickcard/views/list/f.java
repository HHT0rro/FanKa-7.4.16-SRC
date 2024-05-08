package com.huawei.quickcard.views.list;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.views.list.QRecyclerView;
import com.huawei.quickcard.views.list.layoutmanager.QGridLayoutManager;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class f extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    private int f34612a;

    /* renamed from: b, reason: collision with root package name */
    private QRecyclerView.c f34613b = QRecyclerView.c.NONE;

    /* renamed from: c, reason: collision with root package name */
    private QRecyclerView f34614c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34615a;

        static {
            int[] iArr = new int[QRecyclerView.c.values().length];
            f34615a = iArr;
            try {
                iArr[QRecyclerView.c.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34615a[QRecyclerView.c.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34615a[QRecyclerView.c.UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34615a[QRecyclerView.c.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public f(@NonNull QRecyclerView qRecyclerView) {
        this.f34614c = qRecyclerView;
    }

    private boolean a(QRecyclerView qRecyclerView) {
        RecyclerView.LayoutManager layoutManager = this.f34614c.f34583f;
        if (!(layoutManager instanceof QGridLayoutManager)) {
            return false;
        }
        QGridLayoutManager qGridLayoutManager = (QGridLayoutManager) layoutManager;
        int max = Math.max(qGridLayoutManager.findLastCompletelyVisibleItemPosition(), qGridLayoutManager.findLastVisibleItemPosition());
        return max != -1 && max >= a() - 1;
    }

    private boolean b(boolean z10) {
        if (!this.f34614c.isScrollTop()) {
            return false;
        }
        int i10 = a.f34615a[this.f34613b.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    QRecyclerView qRecyclerView = this.f34614c;
                    if (qRecyclerView.f34584g != 1 || !qRecyclerView.f34585h) {
                        return false;
                    }
                } else {
                    if (i10 != 4) {
                        return false;
                    }
                    QRecyclerView qRecyclerView2 = this.f34614c;
                    if (qRecyclerView2.f34584g == 1 && qRecyclerView2.f34585h) {
                        return false;
                    }
                }
            } else if (z10) {
                QRecyclerView qRecyclerView3 = this.f34614c;
                if (qRecyclerView3.f34584g != 0 || !qRecyclerView3.f34585h) {
                    return false;
                }
            } else {
                QRecyclerView qRecyclerView4 = this.f34614c;
                if (qRecyclerView4.f34584g == 0 && qRecyclerView4.f34585h) {
                    return false;
                }
            }
        } else if (z10) {
            QRecyclerView qRecyclerView5 = this.f34614c;
            if (qRecyclerView5.f34584g == 0 && qRecyclerView5.f34585h) {
                return false;
            }
        } else {
            QRecyclerView qRecyclerView6 = this.f34614c;
            if (qRecyclerView6.f34584g != 0 || !qRecyclerView6.f34585h) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
        super.onScrollStateChanged(recyclerView, i10);
        this.f34612a = i10;
        if (i10 == 2) {
            k kVar = this.f34614c.f34582e;
            if (kVar != null) {
                kVar.a();
                return;
            }
            return;
        }
        if (i10 == 0) {
            if (this.f34614c.f34580c != null) {
                a(0, 0);
            }
            h hVar = this.f34614c.f34579b;
            if (hVar != null) {
                hVar.a();
            }
            QRecyclerView qRecyclerView = this.f34614c;
            if (qRecyclerView.f34578a != null) {
                if (a(qRecyclerView.isRTL())) {
                    this.f34614c.f34578a.a();
                    this.f34613b = QRecyclerView.c.NONE;
                } else if (a(this.f34614c)) {
                    this.f34614c.f34578a.a();
                }
            }
            QRecyclerView qRecyclerView2 = this.f34614c;
            if (qRecyclerView2.f34581d != null && b(qRecyclerView2.isRTL())) {
                this.f34614c.f34581d.a();
                this.f34613b = QRecyclerView.c.NONE;
            }
            this.f34614c.g();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
        super.onScrolled(recyclerView, i10, i11);
        if (i10 > 0) {
            this.f34613b = QRecyclerView.c.LEFT;
        } else if (i10 < 0) {
            this.f34613b = QRecyclerView.c.RIGHT;
        } else if (i11 > 0) {
            this.f34613b = QRecyclerView.c.UP;
        } else if (i11 < 0) {
            this.f34613b = QRecyclerView.c.DOWN;
        } else {
            this.f34613b = QRecyclerView.c.NONE;
        }
        if (this.f34614c.f34580c != null) {
            a(i10, i11);
        }
    }

    private int a() {
        RecyclerView.Adapter adapter = this.f34614c.getAdapter();
        if (adapter != null) {
            return adapter.getItemCount();
        }
        return 0;
    }

    private boolean a(boolean z10) {
        if (!this.f34614c.isScrollBottom()) {
            return false;
        }
        int i10 = a.f34615a[this.f34613b.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    QRecyclerView qRecyclerView = this.f34614c;
                    if (qRecyclerView.f34584g == 1 && qRecyclerView.f34585h) {
                        return false;
                    }
                } else {
                    if (i10 != 4) {
                        return false;
                    }
                    QRecyclerView qRecyclerView2 = this.f34614c;
                    if (qRecyclerView2.f34584g != 1 || !qRecyclerView2.f34585h) {
                        return false;
                    }
                }
            } else if (z10) {
                QRecyclerView qRecyclerView3 = this.f34614c;
                if (qRecyclerView3.f34584g == 0 && qRecyclerView3.f34585h) {
                    return false;
                }
            } else {
                QRecyclerView qRecyclerView4 = this.f34614c;
                if (qRecyclerView4.f34584g != 0 || !qRecyclerView4.f34585h) {
                    return false;
                }
            }
        } else if (z10) {
            QRecyclerView qRecyclerView5 = this.f34614c;
            if (qRecyclerView5.f34584g != 0 || !qRecyclerView5.f34585h) {
                return false;
            }
        } else {
            QRecyclerView qRecyclerView6 = this.f34614c;
            if (qRecyclerView6.f34584g == 0 && qRecyclerView6.f34585h) {
                return false;
            }
        }
        return true;
    }

    private void a(int i10, int i11) {
        int width = this.f34614c.getWidth();
        int height = this.f34614c.getHeight();
        int computeHorizontalScrollOffset = this.f34614c.computeHorizontalScrollOffset();
        int computeHorizontalScrollExtent = this.f34614c.computeHorizontalScrollExtent();
        int computeHorizontalScrollRange = this.f34614c.computeHorizontalScrollRange();
        int computeVerticalScrollOffset = this.f34614c.computeVerticalScrollOffset();
        int computeVerticalScrollExtent = this.f34614c.computeVerticalScrollExtent();
        int computeVerticalScrollRange = this.f34614c.computeVerticalScrollRange();
        float configDensity = ViewUtils.getConfigDensity(this.f34614c.getContext(), ViewUtils.getCardContext(this.f34614c));
        HashMap hashMap = new HashMap();
        hashMap.put("listWidth", Float.valueOf(ViewUtils.pxInt2dip(configDensity, width)));
        hashMap.put("listHeight", Float.valueOf(ViewUtils.pxInt2dip(configDensity, height)));
        hashMap.put("scrollOffestX", Float.valueOf(ViewUtils.pxInt2dip(configDensity, computeHorizontalScrollOffset)));
        hashMap.put("scrollExtentX", Float.valueOf(ViewUtils.pxInt2dip(configDensity, computeHorizontalScrollExtent)));
        hashMap.put("scrollRangeX", Float.valueOf(ViewUtils.pxInt2dip(configDensity, computeHorizontalScrollRange)));
        hashMap.put("scrollOffestY", Float.valueOf(ViewUtils.pxInt2dip(configDensity, computeVerticalScrollOffset)));
        hashMap.put("scrollExtentY", Float.valueOf(ViewUtils.pxInt2dip(configDensity, computeVerticalScrollExtent)));
        hashMap.put("scrollRangeY", Float.valueOf(ViewUtils.pxInt2dip(configDensity, computeVerticalScrollRange)));
        hashMap.put("scrollX", Float.valueOf(ViewUtils.pxInt2dip(configDensity, i10)));
        hashMap.put("scrollY", Float.valueOf(ViewUtils.pxInt2dip(configDensity, i11)));
        hashMap.put("scrollState", Integer.valueOf(this.f34612a));
        this.f34614c.f34580c.a(hashMap);
    }
}
