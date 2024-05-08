package com.huawei.uikit.hwcommon.anim;

import android.animation.Animator;
import android.content.res.ColorStateList;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.huawei.uikit.hwcommon.anim.HwGradientAnimatorMgr;

@RequiresApi(api = 21)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwFocusColorGradientAnimListener implements HwGradientAnimatorMgr.OnAnimatorListener {
    public static final String KEY_ICON_COLOR = "icon_color";
    public static final String KEY_TEXT_COLOR = "text_color";

    /* renamed from: a, reason: collision with root package name */
    public static final String f34891a = "background_color";

    /* renamed from: b, reason: collision with root package name */
    public View f34892b;

    /* renamed from: c, reason: collision with root package name */
    public UpdateColorCallback f34893c;

    /* renamed from: f, reason: collision with root package name */
    public ColorStateList f34896f;

    /* renamed from: g, reason: collision with root package name */
    public UpdateColorCallback f34897g;

    /* renamed from: i, reason: collision with root package name */
    public ColorStateList f34899i;

    /* renamed from: j, reason: collision with root package name */
    public UpdateColorCallback f34900j;

    /* renamed from: d, reason: collision with root package name */
    public boolean f34894d = true;

    /* renamed from: e, reason: collision with root package name */
    public boolean f34895e = true;

    /* renamed from: h, reason: collision with root package name */
    public boolean f34898h = true;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface UpdateColorCallback {
        void onEnd(@NonNull ColorStateList colorStateList);

        void onStart();

        void onUpdate(int i10);
    }

    public HwFocusColorGradientAnimListener(@NonNull View view, UpdateColorCallback updateColorCallback) {
        this.f34892b = view;
        this.f34893c = updateColorCallback;
    }

    private int a(int[] iArr, ColorStateList colorStateList) {
        if (colorStateList != null) {
            return colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        }
        return 0;
    }

    @Nullable
    public UpdateColorCallback getExtraColorCallback(@NonNull String str) {
        if (KEY_ICON_COLOR.equals(str)) {
            return this.f34897g;
        }
        if (KEY_TEXT_COLOR.equals(str)) {
            return this.f34900j;
        }
        return null;
    }

    @Nullable
    public ColorStateList getExtraColorStateList(@NonNull String str) {
        if (KEY_ICON_COLOR.equals(str)) {
            return this.f34896f;
        }
        if (KEY_TEXT_COLOR.equals(str)) {
            return this.f34899i;
        }
        return null;
    }

    public boolean isEnabled() {
        return this.f34894d;
    }

    public boolean isExtraColorAnimEnabled(@NonNull String str) {
        if (KEY_ICON_COLOR.equals(str)) {
            return this.f34895e;
        }
        if (KEY_TEXT_COLOR.equals(str)) {
            return this.f34898h;
        }
        return false;
    }

    @Override // com.huawei.uikit.hwcommon.anim.HwGradientAnimatorMgr.OnAnimatorListener
    public void onAnimationCancel(@NonNull Animator animator, @NonNull String str) {
        onAnimationEnd(animator, str);
    }

    @Override // com.huawei.uikit.hwcommon.anim.HwGradientAnimatorMgr.OnAnimatorListener
    public void onAnimationEnd(@NonNull Animator animator, @NonNull String str) {
        UpdateColorCallback updateColorCallback;
        ColorStateList colorStateList;
        UpdateColorCallback updateColorCallback2;
        ColorStateList colorStateList2;
        if (this.f34895e && KEY_ICON_COLOR.equals(str) && (updateColorCallback2 = this.f34897g) != null && (colorStateList2 = this.f34896f) != null) {
            updateColorCallback2.onEnd(colorStateList2);
        }
        if (this.f34898h && KEY_TEXT_COLOR.equals(str) && (updateColorCallback = this.f34900j) != null && (colorStateList = this.f34899i) != null) {
            updateColorCallback.onEnd(colorStateList);
        }
        if (f34891a.equals(str)) {
            ColorStateList backgroundTintList = this.f34892b.getBackgroundTintList();
            UpdateColorCallback updateColorCallback3 = this.f34893c;
            if (updateColorCallback3 == null || backgroundTintList == null) {
                return;
            }
            updateColorCallback3.onEnd(backgroundTintList);
        }
    }

    @Override // com.huawei.uikit.hwcommon.anim.HwGradientAnimatorMgr.OnAnimatorListener
    public void onAnimationStart(@NonNull Animator animator, @NonNull String str) {
        UpdateColorCallback updateColorCallback;
        UpdateColorCallback updateColorCallback2;
        UpdateColorCallback updateColorCallback3;
        if (this.f34895e && KEY_ICON_COLOR.equals(str) && (updateColorCallback3 = this.f34897g) != null && this.f34896f != null) {
            updateColorCallback3.onStart();
        }
        if (this.f34898h && KEY_TEXT_COLOR.equals(str) && (updateColorCallback2 = this.f34900j) != null && this.f34899i != null) {
            updateColorCallback2.onStart();
        }
        if (!f34891a.equals(str) || (updateColorCallback = this.f34893c) == null) {
            return;
        }
        updateColorCallback.onStart();
    }

    @Override // com.huawei.uikit.hwcommon.anim.HwGradientAnimatorMgr.OnAnimatorListener
    public void onAnimationUpdate(@NonNull Animator animator, @NonNull String str, int i10) {
        UpdateColorCallback updateColorCallback;
        UpdateColorCallback updateColorCallback2;
        if (this.f34895e && KEY_ICON_COLOR.equals(str) && (updateColorCallback2 = this.f34897g) != null && this.f34896f != null) {
            updateColorCallback2.onUpdate(i10);
        }
        if (this.f34898h && KEY_TEXT_COLOR.equals(str) && (updateColorCallback = this.f34900j) != null && this.f34899i != null) {
            updateColorCallback.onUpdate(i10);
        }
        if (f34891a.equals(str)) {
            a(i10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0061 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006f  */
    @Override // com.huawei.uikit.hwcommon.anim.HwGradientAnimatorMgr.OnAnimatorListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onPrepareAnimation(@androidx.annotation.NonNull int[] r9, @androidx.annotation.NonNull int[] r10, int r11, int r12, @androidx.annotation.NonNull java.util.Map<java.lang.String, android.util.Pair<java.lang.Integer, java.lang.Integer>> r13) {
        /*
            r8 = this;
            boolean r0 = r8.f34894d
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r8.a(r10)
            boolean r2 = r8.a(r9)
            r3 = 1
            if (r0 == 0) goto L13
            if (r2 == 0) goto L17
        L13:
            if (r0 != 0) goto L19
            if (r2 == 0) goto L19
        L17:
            r0 = 1
            goto L1a
        L19:
            r0 = 0
        L1a:
            if (r0 != 0) goto L20
            r8.a(r11)
            return r1
        L20:
            if (r11 == r12) goto L24
            r0 = 1
            goto L25
        L24:
            r0 = 0
        L25:
            boolean r2 = r8.f34895e
            if (r2 == 0) goto L3f
            android.content.res.ColorStateList r2 = r8.f34896f
            if (r2 == 0) goto L3f
            com.huawei.uikit.hwcommon.anim.HwFocusColorGradientAnimListener$UpdateColorCallback r4 = r8.f34897g
            if (r4 == 0) goto L3f
            int r2 = r8.a(r10, r2)
            android.content.res.ColorStateList r4 = r8.f34896f
            int r4 = r8.a(r9, r4)
            if (r2 == r4) goto L41
            r5 = 1
            goto L42
        L3f:
            r2 = 0
            r4 = 0
        L41:
            r5 = 0
        L42:
            boolean r6 = r8.f34898h
            if (r6 == 0) goto L5c
            android.content.res.ColorStateList r6 = r8.f34899i
            if (r6 == 0) goto L5c
            com.huawei.uikit.hwcommon.anim.HwFocusColorGradientAnimListener$UpdateColorCallback r7 = r8.f34900j
            if (r7 == 0) goto L5c
            int r10 = r8.a(r10, r6)
            android.content.res.ColorStateList r6 = r8.f34899i
            int r9 = r8.a(r9, r6)
            if (r10 == r9) goto L5e
            r6 = 1
            goto L5f
        L5c:
            r9 = 0
            r10 = 0
        L5e:
            r6 = 0
        L5f:
            if (r0 != 0) goto L68
            if (r5 != 0) goto L68
            if (r6 == 0) goto L66
            goto L68
        L66:
            r7 = 0
            goto L69
        L68:
            r7 = 1
        L69:
            if (r7 != 0) goto L6f
            r8.a(r11)
            return r1
        L6f:
            if (r0 == 0) goto L83
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r0.<init>(r12, r11)
            java.lang.String r11 = "background_color"
            r13.put(r11, r0)
        L83:
            if (r5 == 0) goto L97
            android.util.Pair r11 = new android.util.Pair
            java.lang.Integer r12 = java.lang.Integer.valueOf(r2)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            r11.<init>(r12, r0)
            java.lang.String r12 = "icon_color"
            r13.put(r12, r11)
        L97:
            if (r6 == 0) goto Lab
            android.util.Pair r11 = new android.util.Pair
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r11.<init>(r10, r9)
            java.lang.String r9 = "text_color"
            r13.put(r9, r11)
        Lab:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwcommon.anim.HwFocusColorGradientAnimListener.onPrepareAnimation(int[], int[], int, int, java.util.Map):boolean");
    }

    public void setEnabled(boolean z10) {
        this.f34894d = z10;
    }

    public void setExtraColorAnimEnabled(@NonNull String str, boolean z10) {
        if (KEY_ICON_COLOR.equals(str)) {
            this.f34895e = z10;
        }
        if (KEY_TEXT_COLOR.equals(str)) {
            this.f34898h = z10;
        }
    }

    public void setExtraColorStateList(@NonNull String str, ColorStateList colorStateList, UpdateColorCallback updateColorCallback) {
        if (KEY_ICON_COLOR.equals(str)) {
            this.f34896f = colorStateList;
            this.f34897g = updateColorCallback;
        }
        if (KEY_TEXT_COLOR.equals(str)) {
            this.f34899i = colorStateList;
            this.f34900j = updateColorCallback;
        }
    }

    private boolean a(int[] iArr) {
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 : iArr) {
            if (i10 == 16842908) {
                z10 = true;
            }
            if (i10 == 16842909) {
                z11 = true;
            }
        }
        return z10 && z11;
    }

    private void a(int i10) {
        UpdateColorCallback updateColorCallback = this.f34893c;
        if (updateColorCallback == null) {
            this.f34892b.getBackground().setTint(i10);
        } else {
            updateColorCallback.onUpdate(i10);
        }
        this.f34892b.invalidate();
    }
}
