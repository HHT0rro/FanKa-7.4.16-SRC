package com.alibaba.security.tools.flexible;

import android.content.Context;
import android.util.DisplayMetrics;
import com.alibaba.security.tools.flexible.component.IFlexibleComp;
import com.alibaba.security.tools.flexible.component.PaddingComp;
import com.alibaba.security.tools.flexible.component.ParameterComp;
import com.alibaba.security.tools.flexible.component.TextSizeComp;
import com.android.internal.logging.nano.MetricsProto;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class FlexibleComponent {
    public static final String COMP_PRESET_GRADIENT_DRAWABLE = "COMP_PRESET_GRADIENT_DRAWABLE";
    public static final String COMP_PRESET_PADDING = "COMP_PRESET_PADDING";
    public static final String COMP_PRESET_PARAMETER = "COMP_PRESET_PARAMETER";
    public static final String COMP_PRESET_TEXT_SIZE = "COMP_PRESET_TEXT_SIZE";
    public static final FlexibleComponent INSTANCE;
    private static final String TAG = "FlexibleComponent";
    private static final LinkedList<IFlexibleComp> components;
    private static final IFlexibleComp presetPaddingComp;
    private static final IFlexibleComp presetParameterComp;
    private static final IFlexibleComp presetTextSizeComp;
    private int designWidth = MetricsProto.MetricsEvent.SETTINGS_LANGUAGE_CATEGORY;
    private float scaledDensity = 1.0f;

    static {
        FlexibleComponent flexibleComponent = new FlexibleComponent();
        INSTANCE = flexibleComponent;
        components = new LinkedList<>();
        PaddingComp paddingComp = new PaddingComp();
        presetPaddingComp = paddingComp;
        ParameterComp parameterComp = new ParameterComp();
        presetParameterComp = parameterComp;
        TextSizeComp textSizeComp = new TextSizeComp();
        presetTextSizeComp = textSizeComp;
        flexibleComponent.add(paddingComp);
        flexibleComponent.add(parameterComp);
        flexibleComponent.add(textSizeComp);
    }

    private FlexibleComponent() {
    }

    public void add(IFlexibleComp iFlexibleComp) {
        components.add(iFlexibleComp);
    }

    public int calculate(BigDecimal bigDecimal, int i10) {
        int intValue = new BigDecimal(i10).multiply(bigDecimal).intValue();
        if (intValue <= 0) {
            return 1;
        }
        return intValue;
    }

    public void clear() {
        components.clear();
    }

    public List<IFlexibleComp> getAllComponents() {
        return components;
    }

    public float getScaledDensity() {
        return this.scaledDensity;
    }

    public int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.scaledDensity = displayMetrics.scaledDensity / displayMetrics.density;
        return displayMetrics.widthPixels;
    }

    public BigDecimal getZoomRate(Context context) {
        int screenWidth = getScreenWidth(context);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getZoomRate screenWidth=");
        sb2.append(screenWidth);
        sb2.append(" designWidth=");
        sb2.append(this.designWidth);
        BigDecimal divide = new BigDecimal(screenWidth).divide(new BigDecimal(this.designWidth), 2, 4);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("getZoomRate end. zoomRate=");
        sb3.append((Object) divide);
        return divide;
    }

    public void remove(IFlexibleComp iFlexibleComp) {
        components.remove(iFlexibleComp);
    }

    public float calculate(BigDecimal bigDecimal, float f10) {
        float floatValue = new BigDecimal(f10).multiply(bigDecimal).floatValue();
        if (floatValue <= 0.0f) {
            return 1.0f;
        }
        return floatValue;
    }

    public int calculate(int i10, int i11, int i12) {
        if (i10 > 0) {
            int i13 = (int) ((i12 * i11) / i10);
            if (i13 <= 0) {
                return 1;
            }
            return i13;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Found design value **");
        sb2.append(i10);
        sb2.append("** is invalid. Have u forgot it?");
        return i12;
    }

    public float calculate(int i10, int i11, float f10) {
        if (i10 > 0) {
            float f11 = (float) ((f10 * i11) / i10);
            if (f11 < 1.0f) {
                return 1.0f;
            }
            return f11;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Found design value **");
        sb2.append(i10);
        sb2.append("** is invalid. Have u forgot it?");
        return f10;
    }
}
