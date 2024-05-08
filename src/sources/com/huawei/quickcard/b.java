package com.huawei.quickcard;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.Key;
import com.facebook.yoga.YogaNode;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.base.utils.ResourceUtils;
import com.huawei.quickcard.core.R;
import com.huawei.quickcard.framework.animation.QAnimatorSet;
import com.huawei.quickcard.framework.background.DrawableUtils;
import com.huawei.quickcard.framework.background.IBorderRadiusDrawable;
import com.huawei.quickcard.framework.border.Border;
import com.huawei.quickcard.utils.ValueUtils;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.utils.YogaUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import wseemann.media.FFmpegMediaMetadataRetriever;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33271a = "AnimationHelper";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f33272a;

        public a(View view) {
            this.f33272a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Integer) {
                Drawable background = this.f33272a.getBackground();
                if (background instanceof LayerDrawable) {
                    com.huawei.quickcard.d parseToColorDrawable = DrawableUtils.parseToColorDrawable(this.f33272a, ((Integer) animatedValue).intValue());
                    Border border = ValueUtils.obtainPropertyCacheBeanFromView(this.f33272a).getBorder();
                    if (parseToColorDrawable instanceof IBorderRadiusDrawable) {
                        parseToColorDrawable.setBorder(border);
                    }
                    LayerDrawable layerDrawable = (LayerDrawable) background;
                    layerDrawable.setDrawableByLayerId(R.id.quick_card_background_color, parseToColorDrawable);
                    layerDrawable.invalidateSelf();
                    return;
                }
                this.f33272a.setBackgroundColor(((Integer) animatedValue).intValue());
            }
        }
    }

    /* renamed from: com.huawei.quickcard.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class C0342b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f33273a;

        public C0342b(View view) {
            this.f33273a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Integer) {
                int intValue = ((Integer) animatedValue).intValue();
                ViewGroup.LayoutParams layoutParams = this.f33273a.getLayoutParams();
                layoutParams.width = intValue;
                this.f33273a.setLayoutParams(layoutParams);
                YogaNode yogaNode = YogaUtils.getYogaNode(this.f33273a);
                if (yogaNode != null) {
                    yogaNode.W(intValue);
                    yogaNode.c();
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f33274a;

        public c(View view) {
            this.f33274a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Integer) {
                int intValue = ((Integer) animatedValue).intValue();
                ViewGroup.LayoutParams layoutParams = this.f33274a.getLayoutParams();
                layoutParams.height = intValue;
                this.f33274a.setLayoutParams(layoutParams);
                YogaNode yogaNode = YogaUtils.getYogaNode(this.f33274a);
                if (yogaNode != null) {
                    yogaNode.F(intValue);
                    yogaNode.c();
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private Map<String, List<Keyframe>> f33275a;

        public d(Map<String, List<Keyframe>> map) {
            this.f33275a = map;
        }
    }

    public static long a(String str) {
        long j10 = 0;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        String trim = str.trim();
        boolean z10 = false;
        if (trim.endsWith("ms")) {
            trim = trim.substring(0, trim.indexOf("ms"));
        } else if (trim.endsWith(com.kuaishou.weapon.p0.t.f36222g)) {
            trim = trim.substring(0, trim.indexOf(com.kuaishou.weapon.p0.t.f36222g));
            z10 = true;
        }
        try {
            j10 = Long.parseLong(trim);
        } catch (NumberFormatException unused) {
            CardLogUtils.e(f33271a, "format error, get animation time failed.");
        }
        return z10 ? j10 * 1000 : j10;
    }

    public static Float b(String str) {
        Float parseFloat;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.endsWith("deg")) {
            return ValueUtils.parseFloat(str.substring(0, str.length() - 3));
        }
        if (!str.endsWith("rad") || (parseFloat = ValueUtils.parseFloat(str.substring(0, str.length() - 3))) == null) {
            return null;
        }
        return Float.valueOf((float) Math.toDegrees(parseFloat.floatValue()));
    }

    private static void c(QAnimatorSet qAnimatorSet, PropertyValuesHolder propertyValuesHolder, View view) {
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(propertyValuesHolder);
        ofPropertyValuesHolder.addUpdateListener(new c(view));
        qAnimatorSet.a(new Animator[]{ofPropertyValuesHolder});
    }

    private static void d(QAnimatorSet qAnimatorSet, PropertyValuesHolder propertyValuesHolder, View view) {
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(propertyValuesHolder);
        ofPropertyValuesHolder.addUpdateListener(new C0342b(view));
        qAnimatorSet.a(new Animator[]{ofPropertyValuesHolder});
    }

    public static void a(@NonNull QAnimatorSet qAnimatorSet, JSONArray jSONArray, View view) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            HashMap hashMap = new HashMap();
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                if (jSONObject.keys().hasNext()) {
                    try {
                        a(jSONObject.getJSONArray(jSONObject.keys().next()), hashMap, view);
                        arrayList.add(new d(hashMap));
                    } catch (JSONException unused) {
                        CardLogUtils.w(f33271a, "get animator keyframe array failed");
                    }
                }
            } catch (JSONException unused2) {
                CardLogUtils.w(f33271a, "get animator json object failed");
            }
        }
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            for (Map.Entry entry : ((d) arrayList.get(i11)).f33275a.entrySet()) {
                String str = (String) entry.getKey();
                List list = (List) entry.getValue();
                if (list.size() >= 2) {
                    qAnimatorSet.a(true);
                    a(str, PropertyValuesHolder.ofKeyframe(str, (Keyframe[]) list.toArray(new Keyframe[list.size()])), view, qAnimatorSet);
                }
            }
        }
    }

    private static void b(QAnimatorSet qAnimatorSet, PropertyValuesHolder propertyValuesHolder, View view) {
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(propertyValuesHolder);
        ofPropertyValuesHolder.setEvaluator(new ArgbEvaluator());
        ofPropertyValuesHolder.addUpdateListener(new a(view));
        qAnimatorSet.a(new Animator[]{ofPropertyValuesHolder});
    }

    private static void a(JSONArray jSONArray, Map<String, List<Keyframe>> map, View view) {
        JSONObject a10;
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                float parseToFloat = ValueUtils.parseToFloat(jSONObject.opt("time"), 0.0f) / 100.0f;
                float parseToFloat2 = ValueUtils.parseToFloat(jSONObject.opt(Attributes.Style.OPACITY), Float.NaN);
                if (!Float.isNaN(parseToFloat2)) {
                    if (!map.containsKey(Key.ALPHA)) {
                        map.put(Key.ALPHA, new ArrayList());
                    }
                    map.get(Key.ALPHA).add(Keyframe.ofFloat(parseToFloat, parseToFloat2));
                }
                String optString = jSONObject.optString("backgroundColor");
                if (!TextUtils.isEmpty(optString)) {
                    if (!map.containsKey("backgroundColor")) {
                        map.put("backgroundColor", new ArrayList());
                    }
                    map.get("backgroundColor").add(Keyframe.ofInt(parseToFloat, ResourceUtils.getColor(optString)));
                }
                a(map, jSONObject, parseToFloat, "width", view);
                a(map, jSONObject, parseToFloat, "height", view);
                Object obj = null;
                try {
                    obj = jSONObject.get("transform");
                } catch (JSONException unused) {
                    CardLogUtils.w(f33271a, "get value from json object failed");
                }
                if (obj != null && (a10 = f1.a(obj)) != null) {
                    a(map, a10, parseToFloat, FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, Key.ROTATION);
                    a(map, a10, parseToFloat, "rotateX", Key.ROTATION_X);
                    a(map, a10, parseToFloat, "rotateY", Key.ROTATION_Y);
                    a(map, a10, parseToFloat, "scaleX");
                    a(map, a10, parseToFloat, "scaleY");
                    a(map, a10, parseToFloat, "translateX", view, Key.TRANSLATION_X);
                    a(map, a10, parseToFloat, "translateY", view, Key.TRANSLATION_Y);
                }
            } catch (JSONException unused2) {
                CardLogUtils.w(f33271a, "get json object failed");
            }
        }
    }

    private static void a(Map<String, List<Keyframe>> map, JSONObject jSONObject, float f10, String str, View view) {
        int parseInt;
        String a10 = a(jSONObject, str);
        if (a10 == null) {
            return;
        }
        int i10 = -1;
        try {
            if (!TextUtils.isEmpty(a10)) {
                if (a10.endsWith(com.kuaishou.weapon.p0.t.f36232q)) {
                    parseInt = ViewUtils.dip2IntPx(view, Float.parseFloat(a10.substring(0, a10.indexOf(com.kuaishou.weapon.p0.t.f36232q))));
                } else if (a10.endsWith("%")) {
                    i10 = (int) (view.getWidth() * Float.parseFloat(a10.substring(0, a10.indexOf("%"))));
                } else {
                    parseInt = Integer.parseInt(a10);
                }
                i10 = parseInt;
            }
        } catch (NumberFormatException unused) {
            CardLogUtils.w(f33271a, "parse dp or % value to int value failed");
        }
        if (i10 >= 0) {
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList());
            }
            map.get(str).add(Keyframe.ofInt(f10, i10));
        }
    }

    private static void a(Map<String, List<Keyframe>> map, JSONObject jSONObject, float f10, String str, String str2) {
        Float b4;
        String a10 = a(jSONObject, str);
        if (a10 == null || (b4 = b(a10)) == null) {
            return;
        }
        if (!map.containsKey(str2)) {
            map.put(str2, new ArrayList());
        }
        map.get(str2).add(Keyframe.ofFloat(f10, b4.floatValue()));
    }

    private static void a(Map<String, List<Keyframe>> map, JSONObject jSONObject, float f10, String str) {
        Float parseFloat;
        String a10 = a(jSONObject, str);
        if (a10 == null || (parseFloat = ValueUtils.parseFloat(a10, null)) == null) {
            return;
        }
        if (!map.containsKey(str)) {
            map.put(str, new ArrayList());
        }
        map.get(str).add(Keyframe.ofFloat(f10, parseFloat.floatValue()));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.util.Map<java.lang.String, java.util.List<android.animation.Keyframe>> r3, org.json.JSONObject r4, float r5, java.lang.String r6, android.view.View r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "%"
            java.lang.String r1 = "dp"
            java.lang.String r4 = a(r4, r6)
            if (r4 != 0) goto Lb
            return
        Lb:
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.NumberFormatException -> L64
            if (r6 != 0) goto L63
            boolean r6 = r4.endsWith(r1)     // Catch: java.lang.NumberFormatException -> L64
            r2 = 0
            if (r6 == 0) goto L29
            int r6 = r4.indexOf(r1)     // Catch: java.lang.NumberFormatException -> L64
            java.lang.String r4 = r4.substring(r2, r6)     // Catch: java.lang.NumberFormatException -> L64
            float r4 = java.lang.Float.parseFloat(r4)     // Catch: java.lang.NumberFormatException -> L64
            float r4 = com.huawei.quickcard.utils.ViewUtils.dip2FloatPx(r7, r4)     // Catch: java.lang.NumberFormatException -> L64
            goto L47
        L29:
            boolean r6 = r4.endsWith(r0)     // Catch: java.lang.NumberFormatException -> L64
            if (r6 == 0) goto L43
            int r6 = r7.getWidth()     // Catch: java.lang.NumberFormatException -> L64
            float r6 = (float) r6     // Catch: java.lang.NumberFormatException -> L64
            int r7 = r4.indexOf(r0)     // Catch: java.lang.NumberFormatException -> L64
            java.lang.String r4 = r4.substring(r2, r7)     // Catch: java.lang.NumberFormatException -> L64
            float r4 = java.lang.Float.parseFloat(r4)     // Catch: java.lang.NumberFormatException -> L64
            float r6 = r6 * r4
            goto L48
        L43:
            float r4 = java.lang.Float.parseFloat(r4)     // Catch: java.lang.NumberFormatException -> L64
        L47:
            r6 = r4
        L48:
            boolean r4 = r3.containsKey(r8)
            if (r4 != 0) goto L56
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r3.put(r8, r4)
        L56:
            java.lang.Object r3 = r3.get(r8)
            java.util.List r3 = (java.util.List) r3
            android.animation.Keyframe r4 = android.animation.Keyframe.ofFloat(r5, r6)
            r3.add(r4)
        L63:
            return
        L64:
            java.lang.String r3 = "AnimationHelper"
            java.lang.String r4 = "parse dp or % value to int value failed"
            com.huawei.quickcard.base.log.CardLogUtils.w(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.quickcard.b.a(java.util.Map, org.json.JSONObject, float, java.lang.String, android.view.View, java.lang.String):void");
    }

    private static String a(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            CardLogUtils.w(f33271a, "get value failed");
            return null;
        }
    }

    private static void a(String str, PropertyValuesHolder propertyValuesHolder, View view, QAnimatorSet qAnimatorSet) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals(Key.ROTATION_X)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals(Key.ROTATION_Y)) {
                    c4 = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals(Key.TRANSLATION_X)) {
                    c4 = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals(Key.TRANSLATION_Y)) {
                    c4 = 3;
                    break;
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    c4 = 4;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c4 = 5;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c4 = 6;
                    break;
                }
                break;
            case -40300674:
                if (str.equals(Key.ROTATION)) {
                    c4 = 7;
                    break;
                }
                break;
            case 92909918:
                if (str.equals(Key.ALPHA)) {
                    c4 = '\b';
                    break;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    c4 = '\t';
                    break;
                }
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    c4 = '\n';
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
            case '\b':
                a(qAnimatorSet, propertyValuesHolder, view);
                return;
            case 4:
                c(qAnimatorSet, propertyValuesHolder, view);
                return;
            case '\t':
                d(qAnimatorSet, propertyValuesHolder, view);
                return;
            case '\n':
                b(qAnimatorSet, propertyValuesHolder, view);
                return;
            default:
                return;
        }
    }

    private static void a(QAnimatorSet qAnimatorSet, PropertyValuesHolder propertyValuesHolder, View view) {
        qAnimatorSet.a(new Animator[]{ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolder)});
    }
}
