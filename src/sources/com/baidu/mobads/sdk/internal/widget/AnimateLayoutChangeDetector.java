package com.baidu.mobads.sdk.internal.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AnimateLayoutChangeDetector {

    /* renamed from: a, reason: collision with root package name */
    private static final ViewGroup.MarginLayoutParams f10311a;

    /* renamed from: b, reason: collision with root package name */
    private LinearLayoutManager f10312b;

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f10311a = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    public AnimateLayoutChangeDetector(@NonNull LinearLayoutManager linearLayoutManager) {
        this.f10312b = linearLayoutManager;
    }

    private boolean b() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int top;
        int i10;
        int bottom;
        int i11;
        int childCount = this.f10312b.getChildCount();
        if (childCount == 0) {
            return true;
        }
        boolean z10 = this.f10312b.getOrientation() == 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, childCount, 2);
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = this.f10312b.getChildAt(i12);
            if (childAt != null) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                } else {
                    marginLayoutParams = f10311a;
                }
                int[] iArr2 = iArr[i12];
                if (z10) {
                    top = childAt.getLeft();
                    i10 = marginLayoutParams.leftMargin;
                } else {
                    top = childAt.getTop();
                    i10 = marginLayoutParams.topMargin;
                }
                iArr2[0] = top - i10;
                int[] iArr3 = iArr[i12];
                if (z10) {
                    bottom = childAt.getRight();
                    i11 = marginLayoutParams.rightMargin;
                } else {
                    bottom = childAt.getBottom();
                    i11 = marginLayoutParams.bottomMargin;
                }
                iArr3[1] = bottom + i11;
            } else {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
        }
        Arrays.sort(iArr, new Comparator<int[]>() { // from class: com.baidu.mobads.sdk.internal.widget.AnimateLayoutChangeDetector.1
            @Override // java.util.Comparator
            public int compare(int[] iArr4, int[] iArr5) {
                return iArr4[0] - iArr5[0];
            }
        });
        for (int i13 = 1; i13 < childCount; i13++) {
            if (iArr[i13 - 1][1] != iArr[i13][0]) {
                return false;
            }
        }
        return iArr[0][0] <= 0 && iArr[childCount - 1][1] >= iArr[0][1] - iArr[0][0];
    }

    private boolean c() {
        int childCount = this.f10312b.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (a(this.f10312b.getChildAt(i10))) {
                return true;
            }
        }
        return false;
    }

    public boolean a() {
        return (!b() || this.f10312b.getChildCount() <= 1) && c();
    }

    private static boolean a(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (a(viewGroup.getChildAt(i10))) {
                    return true;
                }
            }
        }
        return false;
    }
}
