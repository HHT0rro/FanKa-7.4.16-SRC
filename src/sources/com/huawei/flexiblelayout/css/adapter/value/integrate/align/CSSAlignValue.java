package com.huawei.flexiblelayout.css.adapter.value.integrate.align;

import com.huawei.flexiblelayout.css.adapter.type.CSSValue;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CSSAlignValue extends CSSValue {
    private CSSAlign.Builder cssAlignBuilder;
    private Map<String, Integer> horizontalAlignMap;
    private Map<String, Integer> verticalAlignMap;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface AlignKey {
        public static final String BOTTOM = "bottom";
        public static final String CENTER = "center";
        public static final String LEFT = "left";
        public static final String RIGHT = "right";
        public static final String TOP = "top";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class CSSAlign {
        private Integer horizontalAlign;
        private Integer verticalAlign;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class Builder {
            private Integer verticalAlign = null;
            private Integer horizontalAlign = null;

            public CSSAlign build() {
                return new CSSAlign(this.horizontalAlign, this.verticalAlign);
            }

            public void horizontal(Integer num) {
                this.horizontalAlign = num;
            }

            public void vertical(Integer num) {
                this.verticalAlign = num;
            }
        }

        public Integer getHorizontalAlign() {
            return this.horizontalAlign;
        }

        public Integer getVerticalAlign() {
            return this.verticalAlign;
        }

        public boolean isHorizontalValid() {
            return this.horizontalAlign != null;
        }

        public boolean isValid() {
            return isVerticalValid() || isHorizontalValid();
        }

        public boolean isVerticalValid() {
            return this.verticalAlign != null;
        }

        private CSSAlign() {
            this.verticalAlign = null;
            this.horizontalAlign = null;
        }

        private CSSAlign(Integer num, Integer num2) {
            this.horizontalAlign = num;
            this.verticalAlign = num2;
        }
    }

    public CSSAlignValue() {
        HashMap hashMap = new HashMap();
        this.verticalAlignMap = hashMap;
        hashMap.put("top", 48);
        this.verticalAlignMap.put("bottom", 80);
        this.verticalAlignMap.put(AlignKey.CENTER, 16);
        HashMap hashMap2 = new HashMap();
        this.horizontalAlignMap = hashMap2;
        hashMap2.put("left", 8388611);
        this.horizontalAlignMap.put("right", 8388613);
        this.horizontalAlignMap.put(AlignKey.CENTER, 1);
        this.cssAlignBuilder = new CSSAlign.Builder();
    }

    public CSSAlign getCssAlign() {
        return this.cssAlignBuilder.build();
    }

    public void setHorizontalAlign(String str) {
        Integer num = this.horizontalAlignMap.get(str);
        if (num != null) {
            this.cssAlignBuilder.horizontal(num);
        }
    }

    public void setVerticalAlign(String str) {
        Integer num = this.verticalAlignMap.get(str);
        if (num != null) {
            this.cssAlignBuilder.vertical(num);
        }
    }
}
