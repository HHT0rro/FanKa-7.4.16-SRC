package com.huawei.quickcard;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.css.adapter.value.integrate.align.CSSAlignValue;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.framework.unit.LengthUnit;
import com.huawei.quickcard.framework.unit.LengthValue;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.QuickCardValueUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33587a = "auto";

    /* renamed from: b, reason: collision with root package name */
    private static final String f33588b = "0dp";

    /* renamed from: c, reason: collision with root package name */
    private static final String f33589c = "repeat";

    /* renamed from: d, reason: collision with root package name */
    public static final int f33590d = -1;

    /* renamed from: e, reason: collision with root package name */
    public static final int f33591e = 1;

    /* renamed from: f, reason: collision with root package name */
    public static final int f33592f = 0;

    public static String[] a(QuickCardValue quickCardValue) {
        if (QuickCardValueUtil.isInvalidValue(quickCardValue)) {
            return new String[0];
        }
        String string = quickCardValue.getString();
        if (TextUtils.isEmpty(string)) {
            return new String[0];
        }
        String[] split = string.toLowerCase(Locale.ENGLISH).trim().split(" ");
        int length = split.length;
        if (length > 4 || length <= 0) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList(4);
        int i10 = 0;
        while (arrayList.size() < 4) {
            if (i10 >= length) {
                a(arrayList);
            } else {
                if (!d(split[i10]) && !j(split[i10])) {
                    return new String[0];
                }
                if (d(split[i10])) {
                    a(arrayList, split[i10], length);
                }
                if (j(split[i10])) {
                    b(arrayList, split[i10], length);
                }
                i10++;
            }
        }
        if (i10 < length) {
            return new String[0];
        }
        String[] strArr = new String[4];
        if (!k((String) arrayList.get(0)) && !e((String) arrayList.get(2))) {
            strArr[0] = (String) arrayList.get(0);
            strArr[1] = (String) arrayList.get(1);
            strArr[2] = (String) arrayList.get(2);
            strArr[3] = (String) arrayList.get(3);
        } else {
            strArr[0] = (String) arrayList.get(2);
            strArr[1] = (String) arrayList.get(3);
            strArr[2] = (String) arrayList.get(0);
            strArr[3] = (String) arrayList.get(1);
        }
        return (k(strArr[0]) || e(strArr[2])) ? new String[0] : strArr;
    }

    public static String[] b(QuickCardValue quickCardValue) {
        if (QuickCardValueUtil.isInvalidValue(quickCardValue)) {
            return new String[0];
        }
        String string = quickCardValue.getString();
        return TextUtils.isEmpty(string) ? new String[0] : string.split(" ");
    }

    private static boolean c(String str) {
        return str.endsWith(com.kuaishou.weapon.p0.t.f36232q);
    }

    private static boolean d(String str) {
        return e(str) || k(str) || b(str);
    }

    private static boolean e(String str) {
        return f(str) || h(str);
    }

    private static boolean f(String str) {
        return "left".equals(str);
    }

    private static boolean g(String str) {
        return str.endsWith("%");
    }

    private static boolean h(String str) {
        return "right".equals(str);
    }

    private static boolean i(String str) {
        return "top".equals(str);
    }

    private static boolean j(@NonNull String str) {
        return c(str) || g(str);
    }

    private static boolean k(String str) {
        return i(str) || a(str);
    }

    private static void c(f fVar, String str) {
        if (c(str)) {
            fVar.b(new LengthValue(Attributes.getFloat(str, 0.0f), LengthUnit.DP));
        } else if (g(str)) {
            fVar.b(new LengthValue(Attributes.getPercent(str, 0.0f), LengthUnit.PERCENT));
        } else {
            fVar.b(new LengthValue(0.0f, LengthUnit.DP));
        }
    }

    private static void d(f fVar, String str) {
        if (b(str)) {
            fVar.b(0);
        } else if (a(str)) {
            fVar.b(1);
        } else {
            fVar.b(-1);
        }
    }

    public static void b(String[] strArr, f fVar) {
        if (strArr.length == 0) {
            fVar.c("auto");
            fVar.a("auto");
        }
        if (strArr.length == 1) {
            fVar.c(strArr[0]);
            fVar.a("auto");
        }
        if (strArr.length == 2) {
            fVar.c(strArr[0]);
            fVar.a(strArr[1]);
        }
    }

    private static void b(List<String> list, String str, int i10) {
        if (i10 == 2) {
            list.add(list.size() < 2 ? "left" : "top");
            list.add(str);
        } else if (list.size() == 0) {
            list.add("left");
            list.add(str);
        } else if (j(list.get(list.size() - 1))) {
            list.add("top");
            list.add(str);
        } else {
            list.add(str);
        }
    }

    private static boolean b(String str) {
        return CSSAlignValue.AlignKey.CENTER.equals(str);
    }

    private static void a(List<String> list, String str, int i10) {
        if (i10 == 2) {
            list.add(str);
            list.add(f33588b);
        } else {
            if (list.size() != 0 && !j(list.get(list.size() - 1))) {
                list.add(f33588b);
            }
            list.add(str);
        }
    }

    private static void b(f fVar, String str) {
        if (b(str)) {
            fVar.a(0);
        } else if (h(str)) {
            fVar.a(1);
        } else {
            fVar.a(-1);
        }
    }

    private static void a(List<String> list) {
        if (list.size() == 0) {
            list.add("left");
        } else if (d(list.get(list.size() - 1))) {
            list.add(f33588b);
        } else {
            list.add(CSSAlignValue.AlignKey.CENTER);
        }
    }

    private static boolean a(String str) {
        return "bottom".equals(str);
    }

    public static void a(String[] strArr, f fVar) {
        if (strArr.length > 0 && strArr.length <= 4) {
            b(fVar, strArr[0]);
            a(fVar, strArr[1]);
            d(fVar, strArr[2]);
            c(fVar, strArr[3]);
            return;
        }
        LengthValue lengthValue = new LengthValue(0.0f, LengthUnit.DP);
        fVar.a(lengthValue);
        fVar.b(lengthValue);
    }

    private static void a(f fVar, String str) {
        if (c(str)) {
            fVar.a(new LengthValue(Attributes.getFloat(str, 0.0f), LengthUnit.DP));
        } else if (g(str)) {
            fVar.a(new LengthValue(Attributes.getPercent(str, 0.0f), LengthUnit.PERCENT));
        } else {
            fVar.a(new LengthValue(0.0f, LengthUnit.DP));
        }
    }

    public static com.huawei.quickcard.framework.background.c a(View view) {
        Drawable background = view.getBackground();
        if (!(background instanceof LayerDrawable)) {
            return null;
        }
        Drawable drawable = ((LayerDrawable) background).getDrawable(1);
        if (drawable instanceof com.huawei.quickcard.framework.background.c) {
            return (com.huawei.quickcard.framework.background.c) drawable;
        }
        return null;
    }
}
