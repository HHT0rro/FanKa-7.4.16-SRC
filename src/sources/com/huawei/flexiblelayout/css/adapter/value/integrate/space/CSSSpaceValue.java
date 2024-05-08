package com.huawei.flexiblelayout.css.adapter.value.integrate.space;

import com.huawei.flexiblelayout.css.adapter.type.CSSValue;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.t;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CSSSpaceValue extends CSSValue {
    private static final String TAG = "CSSSpaceValue";
    private SpaceValue mSpaceValue = new SpaceValue();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SpaceValue {
        private int mBottomSpace;
        private int mLeftSpace;
        private int mRightSpace;
        private int mTopSpace;

        private SpaceValue() {
        }

        public int getBottomSpace() {
            return this.mBottomSpace;
        }

        public int getLeftSpace() {
            return this.mLeftSpace;
        }

        public int getRightSpace() {
            return this.mRightSpace;
        }

        public int getTopSpace() {
            return this.mTopSpace;
        }

        public void setBottomSpace(int i10) {
            this.mBottomSpace = i10;
        }

        public void setLeftSpace(int i10) {
            this.mLeftSpace = i10;
        }

        public void setRightSpace(int i10) {
            this.mRightSpace = i10;
        }

        public void setTopSpace(int i10) {
            this.mTopSpace = i10;
        }
    }

    private Integer getFunctionResult(String str) {
        return t.a(str);
    }

    private int getSpaceValue(String str) {
        Integer functionResult = getFunctionResult(str);
        if (functionResult != null) {
            return functionResult.intValue();
        }
        return Integer.parseInt(str);
    }

    public int getBottomSpace() {
        SpaceValue spaceValue = this.mSpaceValue;
        if (spaceValue == null) {
            return 0;
        }
        return spaceValue.getBottomSpace();
    }

    public int getLeftSpace() {
        SpaceValue spaceValue = this.mSpaceValue;
        if (spaceValue == null) {
            return 0;
        }
        return spaceValue.getLeftSpace();
    }

    public int getRightSpace() {
        SpaceValue spaceValue = this.mSpaceValue;
        if (spaceValue == null) {
            return 0;
        }
        return spaceValue.getRightSpace();
    }

    public int getTopSpace() {
        SpaceValue spaceValue = this.mSpaceValue;
        if (spaceValue == null) {
            return 0;
        }
        return spaceValue.getTopSpace();
    }

    public void setBottomSpace(String str) {
        try {
            this.mSpaceValue.setBottomSpace(getSpaceValue(str));
        } catch (Exception e2) {
            Log.w(TAG, "setBottomSpace, e: " + e2.getMessage());
        }
    }

    public void setLeftSpace(String str) {
        try {
            this.mSpaceValue.setLeftSpace(getSpaceValue(str));
        } catch (Exception e2) {
            Log.w(TAG, "setLeftSpace, e: " + e2.getMessage());
        }
    }

    public void setRightSpace(String str) {
        try {
            this.mSpaceValue.setRightSpace(getSpaceValue(str));
        } catch (Exception e2) {
            Log.w(TAG, "setRightSpace, e: " + e2.getMessage());
        }
    }

    public void setSpace(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            this.mSpaceValue.setTopSpace(parseInt);
            this.mSpaceValue.setBottomSpace(parseInt);
            this.mSpaceValue.setLeftSpace(parseInt);
            this.mSpaceValue.setRightSpace(parseInt);
        } catch (Exception e2) {
            Log.w(TAG, "setSpace, e: " + e2.getMessage());
        }
    }

    public void setTopSpace(String str) {
        try {
            this.mSpaceValue.setTopSpace(getSpaceValue(str));
        } catch (Exception e2) {
            Log.w(TAG, "setTopSpace, e: " + e2.getMessage());
        }
    }
}
