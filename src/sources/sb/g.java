package sb;

import android.graphics.Matrix;
import androidx.constraintlayout.motion.widget.Key;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.opensource.svgaplayer.entities.SVGAVideoShapeEntity;
import com.opensource.svgaplayer.proto.FrameEntity;
import com.opensource.svgaplayer.proto.Layout;
import com.opensource.svgaplayer.proto.ShapeEntity;
import com.opensource.svgaplayer.proto.Transform;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.t;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import sun.util.locale.LanguageTag;

/* compiled from: SVGAVideoSpriteFrameEntity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public double f53705a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public tb.d f53706b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Matrix f53707c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public b f53708d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public List<SVGAVideoShapeEntity> f53709e;

    public g(@NotNull JSONObject obj) {
        boolean z10;
        g gVar = this;
        s.j(obj, "obj");
        gVar.f53706b = new tb.d(ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45);
        gVar.f53707c = new Matrix();
        gVar.f53709e = kotlin.collections.s.j();
        gVar.f53705a = obj.optDouble(Key.ALPHA, ShadowDrawableWrapper.COS_45);
        JSONObject optJSONObject = obj.optJSONObject("layout");
        if (optJSONObject != null) {
            gVar.f53706b = new tb.d(optJSONObject.optDouble(LanguageTag.PRIVATEUSE, ShadowDrawableWrapper.COS_45), optJSONObject.optDouble("y", ShadowDrawableWrapper.COS_45), optJSONObject.optDouble("width", ShadowDrawableWrapper.COS_45), optJSONObject.optDouble("height", ShadowDrawableWrapper.COS_45));
        }
        JSONObject optJSONObject2 = obj.optJSONObject("transform");
        if (optJSONObject2 != null) {
            double optDouble = optJSONObject2.optDouble("a", 1.0d);
            double optDouble2 = optJSONObject2.optDouble("b", ShadowDrawableWrapper.COS_45);
            double optDouble3 = optJSONObject2.optDouble("c", ShadowDrawableWrapper.COS_45);
            double optDouble4 = optJSONObject2.optDouble("d", 1.0d);
            double optDouble5 = optJSONObject2.optDouble("tx", ShadowDrawableWrapper.COS_45);
            double optDouble6 = optJSONObject2.optDouble(com.alipay.sdk.sys.a.f4666g, ShadowDrawableWrapper.COS_45);
            float f10 = (float) optDouble3;
            z10 = true;
            float f11 = (float) ShadowDrawableWrapper.COS_45;
            float[] fArr = {(float) optDouble, f10, (float) optDouble5, (float) optDouble2, (float) optDouble4, (float) optDouble6, f11, f11, (float) 1.0d};
            gVar = this;
            gVar.f53707c.setValues(fArr);
        } else {
            z10 = true;
        }
        String optString = obj.optString("clipPath");
        if (optString != null) {
            if (optString.length() <= 0 ? false : z10) {
                gVar.f53708d = new b(optString);
            }
        }
        JSONArray optJSONArray = obj.optJSONArray("shapes");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject optJSONObject3 = optJSONArray.optJSONObject(i10);
                if (optJSONObject3 != null) {
                    arrayList.add(new SVGAVideoShapeEntity(optJSONObject3));
                }
            }
            gVar.f53709e = CollectionsKt___CollectionsKt.x0(arrayList);
        }
    }

    public final double a() {
        return this.f53705a;
    }

    @NotNull
    public final tb.d b() {
        return this.f53706b;
    }

    @Nullable
    public final b c() {
        return this.f53708d;
    }

    @NotNull
    public final List<SVGAVideoShapeEntity> d() {
        return this.f53709e;
    }

    @NotNull
    public final Matrix e() {
        return this.f53707c;
    }

    public final void f(@NotNull List<SVGAVideoShapeEntity> list) {
        s.j(list, "<set-?>");
        this.f53709e = list;
    }

    public g(@NotNull FrameEntity obj) {
        s.j(obj, "obj");
        this.f53706b = new tb.d(ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45);
        this.f53707c = new Matrix();
        this.f53709e = kotlin.collections.s.j();
        this.f53705a = obj.alpha != null ? r0.floatValue() : 0.0f;
        Layout layout = obj.layout;
        if (layout != null) {
            Float f10 = layout.f38010x;
            double floatValue = f10 != null ? f10.floatValue() : 0.0f;
            Float f11 = layout.f38011y;
            double floatValue2 = f11 != null ? f11.floatValue() : 0.0f;
            Float f12 = layout.width;
            this.f53706b = new tb.d(floatValue, floatValue2, f12 != null ? f12.floatValue() : 0.0f, layout.height != null ? r0.floatValue() : 0.0f);
        }
        Transform transform = obj.transform;
        if (transform != null) {
            float[] fArr = new float[9];
            Float f13 = transform.f38032a;
            float floatValue3 = f13 != null ? f13.floatValue() : 1.0f;
            Float f14 = transform.f38033b;
            float floatValue4 = f14 != null ? f14.floatValue() : 0.0f;
            Float f15 = transform.f38034c;
            float floatValue5 = f15 != null ? f15.floatValue() : 0.0f;
            Float f16 = transform.f38035d;
            float floatValue6 = f16 != null ? f16.floatValue() : 1.0f;
            Float f17 = transform.tx;
            float floatValue7 = f17 != null ? f17.floatValue() : 0.0f;
            Float f18 = transform.ty;
            float floatValue8 = f18 != null ? f18.floatValue() : 0.0f;
            fArr[0] = floatValue3;
            fArr[1] = floatValue5;
            fArr[2] = floatValue7;
            fArr[3] = floatValue4;
            fArr[4] = floatValue6;
            fArr[5] = floatValue8;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
            this.f53707c.setValues(fArr);
        }
        String str = obj.clipPath;
        if (str != null) {
            str = str.length() > 0 ? str : null;
            if (str != null) {
                this.f53708d = new b(str);
            }
        }
        List<ShapeEntity> list = obj.shapes;
        s.e(list, "obj.shapes");
        ArrayList arrayList = new ArrayList(t.t(list, 10));
        for (ShapeEntity it : list) {
            s.e(it, "it");
            arrayList.add(new SVGAVideoShapeEntity(it));
        }
        this.f53709e = arrayList;
    }
}
