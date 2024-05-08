package com.huawei.quickcard;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.action.ActionsHelper;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.framework.processor.EventProcessor;
import com.huawei.quickcard.framework.touch.IQuickCardTouchEventListener;
import com.huawei.quickcard.utils.ValueUtils;
import com.huawei.quickcard.utils.ViewUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class w1<T extends View> implements EventProcessor<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f34704a = "TouchEventProcessor";

    /* renamed from: b, reason: collision with root package name */
    private static final String f34705b = "identifier";

    /* renamed from: c, reason: collision with root package name */
    private static final String f34706c = "pageX";

    /* renamed from: d, reason: collision with root package name */
    private static final String f34707d = "pageY";

    /* renamed from: e, reason: collision with root package name */
    private static final String f34708e = "clientX";

    /* renamed from: f, reason: collision with root package name */
    private static final String f34709f = "clientY";

    /* renamed from: g, reason: collision with root package name */
    private static final String f34710g = "offsetX";

    /* renamed from: h, reason: collision with root package name */
    private static final String f34711h = "offsetY";

    /* renamed from: i, reason: collision with root package name */
    private static final String f34712i = "touches";

    /* renamed from: j, reason: collision with root package name */
    private static final String f34713j = "changedTouches";

    /* renamed from: k, reason: collision with root package name */
    private static final SparseArray<String> f34714k;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b implements IQuickCardTouchEventListener {

        /* renamed from: a, reason: collision with root package name */
        private List<JSONObject> f34715a;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public class a implements Comparator<JSONObject> {
            public a() {
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
                if (jSONObject == jSONObject2) {
                    return 0;
                }
                if (jSONObject == null) {
                    return -1;
                }
                if (jSONObject2 == null) {
                    return 1;
                }
                return jSONObject.optInt(w1.f34705b) - jSONObject2.optInt(w1.f34705b);
            }
        }

        private b() {
            this.f34715a = null;
        }

        private boolean a(View view, String str, Map<String, Object> map) {
            ActionsHelper.doAction(view, str, map);
            return true;
        }

        @Override // com.huawei.quickcard.framework.touch.IQuickCardTouchEventListener
        public boolean onTouch(@NonNull View view, @NonNull View view2, @NonNull i1 i1Var) {
            String str = (String) w1.f34714k.get(i1Var.a());
            if (str == null) {
                return false;
            }
            String str2 = ValueUtils.obtainPropertyCacheBeanFromView(view2).getSupportTouchEvent().get(str);
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            int[] iArr = {0, 0};
            view.getLocationInWindow(iArr);
            int[] iArr2 = {0, 0};
            view2.getLocationInWindow(iArr2);
            return a(view2, str2, a(view.getContext(), ViewUtils.getCardContext(view2), new Point(iArr2[0] - iArr[0], iArr2[1] - iArr[1]), i1Var));
        }

        private Map<String, Object> a(@NonNull Context context, CardContext cardContext, Point point, i1 i1Var) {
            HashMap hashMap = new HashMap(2);
            ArrayList arrayList = new ArrayList();
            boolean z10 = false;
            if (i1Var != null) {
                int d10 = i1Var.d();
                for (int i10 = 0; i10 < d10; i10++) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(w1.f34705b, i1Var.a(i10));
                        jSONObject.put(w1.f34708e, a(context, cardContext, i1Var.b(i10) + point.x));
                        jSONObject.put(w1.f34709f, a(context, cardContext, i1Var.c(i10) + point.y));
                        jSONObject.put(w1.f34710g, a(context, cardContext, i1Var.b(i10)));
                        jSONObject.put(w1.f34711h, a(context, cardContext, i1Var.c(i10)));
                        arrayList.add(i10, jSONObject);
                    } catch (JSONException e2) {
                        CardLogUtils.e(w1.f34704a, "joTouch error", e2);
                    }
                }
            }
            if (i1Var != null && (i1Var.a() == 1 || i1Var.a() == 3)) {
                z10 = true;
            }
            if (z10) {
                this.f34715a = arrayList;
                arrayList = new ArrayList();
            }
            hashMap.put(w1.f34712i, arrayList);
            hashMap.put(w1.f34713j, a(this.f34715a, arrayList));
            this.f34715a = arrayList;
            return hashMap;
        }

        private List<JSONObject> a(List<JSONObject> list, List<JSONObject> list2) {
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            if (list == null) {
                list = new ArrayList<>();
            }
            a aVar = new a();
            Collections.sort(list2, aVar);
            Collections.sort(list, aVar);
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            int i11 = 0;
            while (i10 < list2.size() && i11 < list.size()) {
                int optInt = list2.get(i10).optInt(w1.f34705b);
                int optInt2 = list.get(i11).optInt(w1.f34705b);
                if (optInt < optInt2) {
                    arrayList.add(a(list2.get(i10)));
                    i10++;
                } else {
                    if (optInt > optInt2) {
                        arrayList.add(a(list.get(i11)));
                    } else {
                        arrayList.add(a(list2.get(i10)));
                        i10++;
                    }
                    i11++;
                }
            }
            while (i10 < list2.size()) {
                arrayList.add(a(list2.get(i10)));
                i10++;
            }
            while (i11 < list.size()) {
                arrayList.add(a(list.get(i11)));
                i11++;
            }
            return arrayList;
        }

        private JSONObject a(JSONObject jSONObject) {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject != null) {
                try {
                    jSONObject2.put(w1.f34705b, jSONObject.opt(w1.f34705b));
                    jSONObject2.put(w1.f34706c, jSONObject.opt(w1.f34706c));
                    jSONObject2.put(w1.f34707d, jSONObject.opt(w1.f34707d));
                    jSONObject2.put(w1.f34708e, jSONObject.opt(w1.f34708e));
                    jSONObject2.put(w1.f34709f, jSONObject.opt(w1.f34709f));
                    jSONObject2.put(w1.f34710g, jSONObject.opt(w1.f34710g));
                    jSONObject2.put(w1.f34711h, jSONObject.opt(w1.f34711h));
                } catch (JSONException unused) {
                    CardLogUtils.e(w1.f34704a, "clone touch obj error");
                }
            }
            return jSONObject2;
        }

        private float a(@NonNull Context context, CardContext cardContext, float f10) {
            return ViewUtils.px2dip(ViewUtils.getConfigDensity(context, cardContext), f10);
        }
    }

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        f34714k = sparseArray;
        sparseArray.put(0, Attributes.Event.TOUCHSTART);
        sparseArray.put(2, Attributes.Event.TOUCHMOVE);
        sparseArray.put(1, Attributes.Event.TOUCHEND);
        sparseArray.put(3, Attributes.Event.TOUCHCANCEL);
    }

    @Override // com.huawei.quickcard.framework.processor.EventProcessor
    public void applyEvent(@NonNull T t2, String str, String str2) {
        CardContext cardContext = ViewUtils.getCardContext(t2);
        if (cardContext == null) {
            CardLogUtils.e(f34704a, "cardContext is null");
        } else {
            ValueUtils.obtainPropertyCacheBeanFromView(t2).getSupportTouchEvent().put(str, str2);
            cardContext.getRoot().getTouchEventManager().registerTouchListener(t2, new b());
        }
    }

    @Override // com.huawei.quickcard.framework.processor.EventProcessor
    public void cleanEvent(@NonNull T t2, String str) {
        CardContext cardContext;
        Map<String, String> supportTouchEvent = ValueUtils.obtainPropertyCacheBeanFromView(t2).getSupportTouchEvent();
        supportTouchEvent.remove(str);
        if (!supportTouchEvent.isEmpty() || (cardContext = ViewUtils.getCardContext(t2)) == null) {
            return;
        }
        cardContext.getRoot().getTouchEventManager().unRegisterTouchListenerByTarget(t2);
    }
}
