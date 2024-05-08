package com.huawei.quickcard;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class g1 extends View.AccessibilityDelegate {

    /* renamed from: b, reason: collision with root package name */
    public static final int f33990b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static final int f33991c = 1;

    /* renamed from: d, reason: collision with root package name */
    public static final int f33992d = 2;

    /* renamed from: e, reason: collision with root package name */
    public static final int f33993e = 3;

    /* renamed from: a, reason: collision with root package name */
    private int f33994a;

    private void b(@NonNull AccessibilityNodeInfo accessibilityNodeInfo, boolean z10) {
        accessibilityNodeInfo.setLongClickable(z10);
        if (z10) {
            accessibilityNodeInfo.addAction(32);
        } else {
            accessibilityNodeInfo.removeAction(32);
        }
    }

    public void a(@IntRange(from = 0, to = 3) int i10) {
        this.f33994a = i10;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        int i10 = this.f33994a;
        if (i10 == 1) {
            a(accessibilityNodeInfo, false);
            return;
        }
        if (i10 == 2) {
            b(accessibilityNodeInfo, false);
        } else if (i10 == 3) {
            a(accessibilityNodeInfo, false);
            b(accessibilityNodeInfo, false);
        } else {
            a(accessibilityNodeInfo, true);
            b(accessibilityNodeInfo, true);
        }
    }

    private void a(@NonNull AccessibilityNodeInfo accessibilityNodeInfo, boolean z10) {
        accessibilityNodeInfo.setClickable(z10);
        if (z10) {
            accessibilityNodeInfo.addAction(16);
        } else {
            accessibilityNodeInfo.removeAction(16);
        }
    }
}
