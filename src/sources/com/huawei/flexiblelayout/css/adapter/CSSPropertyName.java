package com.huawei.flexiblelayout.css.adapter;

import com.huawei.flexiblelayout.css.action.impl.ActiveAction;
import com.huawei.flexiblelayout.css.action.impl.VirtualAction;
import com.huawei.flexiblelayout.css.action.impl.focus.FocusAction;
import com.huawei.flexiblelayout.css.action.impl.focus.within.FocusWithInAction;
import com.huawei.flexiblelayout.css.action.value.CSSActionValueFactory;
import com.huawei.flexiblelayout.css.adapter.type.factory.CSSColorFactory;
import com.huawei.flexiblelayout.css.adapter.type.factory.CSSImageFactory;
import com.huawei.flexiblelayout.css.adapter.type.factory.CSSPrimitiveFactory;
import com.huawei.flexiblelayout.css.adapter.value.integrate.align.CSSAlignValue;
import com.huawei.flexiblelayout.css.adapter.value.integrate.dimensions.CSSDimensValue;
import com.huawei.flexiblelayout.css.adapter.value.integrate.space.CSSSpaceValue;
import com.huawei.flexiblelayout.css.adapter.value.wrapper.CSSAlignValueWrapper;
import com.huawei.flexiblelayout.css.adapter.value.wrapper.CSSDimensValueWrapper;
import com.huawei.flexiblelayout.css.adapter.value.wrapper.CSSSpaceValueWrapper;
import com.huawei.flexiblelayout.css.annotation.CSSActionClass;
import com.huawei.flexiblelayout.css.annotation.ValueFactory;
import com.huawei.flexiblelayout.css.annotation.ValueIntegrate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class CSSPropertyName {

    @ValueFactory(CSSActionValueFactory.class)
    @CSSActionClass(ActiveAction.class)
    public static final String ACTIVE_ACTION = ":active";

    @ValueFactory(CSSPrimitiveFactory.class)
    public static final String ALIGN = "align";
    public static final String ALIGN_TAG = "alignTag";

    @ValueFactory(CSSColorFactory.class)
    public static final String BACKGROUND_COLOR = "backgroundColor";

    @ValueFactory(CSSImageFactory.class)
    public static final String BACKGROUND_IMAGE = "backgroundImage";

    @ValueFactory(CSSColorFactory.class)
    public static final String BACKGROUND_TINT = "backgroundTint";

    @ValueFactory(CSSPrimitiveFactory.class)
    public static final String BOTTOM_DOCKING_DISTANCE = "bottomDockingDistance";

    @ValueFactory(CSSPrimitiveFactory.class)
    public static final String CLIP_CHILDREN = "clipChildren";

    @ValueFactory(CSSPrimitiveFactory.class)
    public static final String CLIP_PADDING = "clipToPadding";

    @ValueIntegrate(methodName = "setHeight", propertyTag = FL_DIMENS, valueClass = CSSDimensValue.class, valueWrapper = CSSDimensValueWrapper.class)
    public static final String FIXED_HEIGHT = "height";

    @ValueIntegrate(methodName = "setWidth", propertyTag = FL_DIMENS, valueClass = CSSDimensValue.class, valueWrapper = CSSDimensValueWrapper.class)
    public static final String FIXED_WIDTH = "width";
    public static final String FL_DIMENS = "flDimens";
    public static final String FL_MARGIN = "margin_tag";
    public static final String FL_PADDING = "padding_tag";

    @ValueFactory(CSSActionValueFactory.class)
    @CSSActionClass(FocusAction.class)
    public static final String FOCUS_ACTION = ":focus";

    @ValueFactory(CSSActionValueFactory.class)
    @CSSActionClass(FocusWithInAction.class)
    public static final String FOCUS_WITHIN_ACTION = ":focus-within";

    @ValueFactory(CSSColorFactory.class)
    public static final String FONT_COLOR = "fontColor";

    @ValueFactory(CSSPrimitiveFactory.class)
    public static final String FONT_SIZE = "fontSize";

    @ValueFactory(CSSPrimitiveFactory.class)
    public static final String FULL_SPAN = "fullSpan";

    @ValueIntegrate(methodName = "setHorizontalAlign", propertyTag = ALIGN_TAG, valueClass = CSSAlignValue.class, valueWrapper = CSSAlignValueWrapper.class)
    public static final String HORIZONTAL_ALIGN = "horizontalAlign";

    @ValueIntegrate(methodName = "setSpace", propertyTag = FL_MARGIN, valueClass = CSSSpaceValue.class, valueWrapper = CSSSpaceValueWrapper.class)
    public static final String MARGIN = "margin";

    @ValueIntegrate(methodName = "setBottomSpace", propertyTag = FL_MARGIN, valueClass = CSSSpaceValue.class, valueWrapper = CSSSpaceValueWrapper.class)
    public static final String MARGIN_BOTTOM = "marginBottom";

    @ValueIntegrate(methodName = "setLeftSpace", propertyTag = FL_MARGIN, valueClass = CSSSpaceValue.class, valueWrapper = CSSSpaceValueWrapper.class)
    public static final String MARGIN_LEFT = "marginLeft";

    @ValueIntegrate(methodName = "setRightSpace", propertyTag = FL_MARGIN, valueClass = CSSSpaceValue.class, valueWrapper = CSSSpaceValueWrapper.class)
    public static final String MARGIN_RIGHT = "marginRight";

    @ValueIntegrate(methodName = "setTopSpace", propertyTag = FL_MARGIN, valueClass = CSSSpaceValue.class, valueWrapper = CSSSpaceValueWrapper.class)
    public static final String MARGIN_TOP = "marginTop";

    @ValueIntegrate(methodName = "setSpace", propertyTag = FL_PADDING, valueClass = CSSSpaceValue.class, valueWrapper = CSSSpaceValueWrapper.class)
    public static final String PADDING = "padding";

    @ValueIntegrate(methodName = "setBottomSpace", propertyTag = FL_PADDING, valueClass = CSSSpaceValue.class, valueWrapper = CSSSpaceValueWrapper.class)
    public static final String PADDING_BOTTOM = "paddingBottom";

    @ValueIntegrate(methodName = "setLeftSpace", propertyTag = FL_PADDING, valueClass = CSSSpaceValue.class, valueWrapper = CSSSpaceValueWrapper.class)
    public static final String PADDING_LEFT = "paddingLeft";

    @ValueIntegrate(methodName = "setRightSpace", propertyTag = FL_PADDING, valueClass = CSSSpaceValue.class, valueWrapper = CSSSpaceValueWrapper.class)
    public static final String PADDING_RIGHT = "paddingRight";

    @ValueIntegrate(methodName = "setTopSpace", propertyTag = FL_PADDING, valueClass = CSSSpaceValue.class, valueWrapper = CSSSpaceValueWrapper.class)
    public static final String PADDING_TOP = "paddingTop";

    @ValueFactory(CSSPrimitiveFactory.class)
    public static final String TOP_DOCKING_DISTANCE = "topDockingDistance";

    @ValueIntegrate(methodName = "setVerticalAlign", propertyTag = ALIGN_TAG, valueClass = CSSAlignValue.class, valueWrapper = CSSAlignValueWrapper.class)
    public static final String VERTICAL_ALIGN = "verticalAlign";

    @CSSActionClass(VirtualAction.class)
    public static final String VIRTUAL_ACTION = ":virtual";

    @ValueFactory(CSSPrimitiveFactory.class)
    public static final String VISIBILITY = "visibility";

    private CSSPropertyName() {
    }
}
