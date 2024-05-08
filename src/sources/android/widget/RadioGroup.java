package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import com.android.internal.R;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
@RemoteViews.RemoteView
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class RadioGroup extends LinearLayout {
    private static final String LOG_TAG = RadioGroup.class.getSimpleName();
    private int mCheckedId;
    private CompoundButton.OnCheckedChangeListener mChildOnCheckedChangeListener;
    private int mInitialCheckedId;
    private OnCheckedChangeListener mOnCheckedChangeListener;
    private PassThroughHierarchyChangeListener mPassThroughListener;
    private boolean mProtectFromCheckedChange;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface OnCheckedChangeListener {
        void onCheckedChanged(RadioGroup radioGroup, int i10);
    }

    public RadioGroup(Context context) {
        super(context);
        this.mCheckedId = -1;
        this.mProtectFromCheckedChange = false;
        this.mInitialCheckedId = -1;
        setOrientation(1);
        init();
    }

    public RadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mCheckedId = -1;
        this.mProtectFromCheckedChange = false;
        this.mInitialCheckedId = -1;
        if (getImportantForAutofill() == 0) {
            setImportantForAutofill(1);
        }
        setImportantForAccessibility(1);
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.RadioGroup, 16842878, 0);
        saveAttributeDataForStyleable(context, R.styleable.RadioGroup, attrs, attributes, 16842878, 0);
        int value = attributes.getResourceId(1, -1);
        if (value != -1) {
            this.mCheckedId = value;
            this.mInitialCheckedId = value;
        }
        int index = attributes.getInt(0, 1);
        setOrientation(index);
        attributes.recycle();
        init();
    }

    private void init() {
        this.mChildOnCheckedChangeListener = new CheckedStateTracker();
        PassThroughHierarchyChangeListener passThroughHierarchyChangeListener = new PassThroughHierarchyChangeListener();
        this.mPassThroughListener = passThroughHierarchyChangeListener;
        super.setOnHierarchyChangeListener(passThroughHierarchyChangeListener);
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener listener) {
        this.mPassThroughListener.mOnHierarchyChangeListener = listener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i10 = this.mCheckedId;
        if (i10 != -1) {
            this.mProtectFromCheckedChange = true;
            setCheckedStateForView(i10, true);
            this.mProtectFromCheckedChange = false;
            setCheckedId(this.mCheckedId);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (child instanceof RadioButton) {
            RadioButton button = (RadioButton) child;
            if (button.isChecked()) {
                this.mProtectFromCheckedChange = true;
                int i10 = this.mCheckedId;
                if (i10 != -1) {
                    setCheckedStateForView(i10, false);
                }
                this.mProtectFromCheckedChange = false;
                setCheckedId(button.getId());
            }
        }
        super.addView(child, index, params);
    }

    public void check(int id2) {
        if (id2 != -1 && id2 == this.mCheckedId) {
            return;
        }
        int i10 = this.mCheckedId;
        if (i10 != -1) {
            setCheckedStateForView(i10, false);
        }
        if (id2 != -1) {
            setCheckedStateForView(id2, true);
        }
        setCheckedId(id2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(int id2) {
        AutofillManager afm;
        boolean changed = id2 != this.mCheckedId;
        this.mCheckedId = id2;
        OnCheckedChangeListener onCheckedChangeListener = this.mOnCheckedChangeListener;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(this, id2);
        }
        if (changed && (afm = (AutofillManager) this.mContext.getSystemService(AutofillManager.class)) != null) {
            afm.notifyValueChanged(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedStateForView(int viewId, boolean checked) {
        View checkedView = findViewById(viewId);
        if (checkedView != null && (checkedView instanceof RadioButton)) {
            ((RadioButton) checkedView).setChecked(checked);
        }
    }

    public int getCheckedRadioButtonId() {
        return this.mCheckedId;
    }

    public void clearCheck() {
        check(-1);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        this.mOnCheckedChangeListener = listener;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams p10) {
        return p10 instanceof LayoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return RadioGroup.class.getName();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context c4, AttributeSet attrs) {
            super(c4, attrs);
        }

        public LayoutParams(int w3, int h10) {
            super(w3, h10);
        }

        public LayoutParams(int w3, int h10, float initWeight) {
            super(w3, h10, initWeight);
        }

        public LayoutParams(ViewGroup.LayoutParams p10) {
            super(p10);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
        }

        @Override // android.view.ViewGroup.LayoutParams
        protected void setBaseAttributes(TypedArray a10, int widthAttr, int heightAttr) {
            if (a10.hasValue(widthAttr)) {
                this.width = a10.getLayoutDimension(widthAttr, "layout_width");
            } else {
                this.width = -2;
            }
            if (a10.hasValue(heightAttr)) {
                this.height = a10.getLayoutDimension(heightAttr, "layout_height");
            } else {
                this.height = -2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class CheckedStateTracker implements CompoundButton.OnCheckedChangeListener {
        private CheckedStateTracker() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (RadioGroup.this.mProtectFromCheckedChange) {
                return;
            }
            RadioGroup.this.mProtectFromCheckedChange = true;
            if (RadioGroup.this.mCheckedId != -1) {
                RadioGroup radioGroup = RadioGroup.this;
                radioGroup.setCheckedStateForView(radioGroup.mCheckedId, false);
            }
            RadioGroup.this.mProtectFromCheckedChange = false;
            int id2 = buttonView.getId();
            RadioGroup.this.setCheckedId(id2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class PassThroughHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        private ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;

        private PassThroughHierarchyChangeListener() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View parent, View child) {
            if (parent == RadioGroup.this && (child instanceof RadioButton)) {
                int id2 = child.getId();
                if (id2 == -1) {
                    int id3 = View.generateViewId();
                    child.setId(id3);
                }
                ((RadioButton) child).setOnCheckedChangeWidgetListener(RadioGroup.this.mChildOnCheckedChangeListener);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(parent, child);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View parent, View child) {
            if (parent == RadioGroup.this && (child instanceof RadioButton)) {
                ((RadioButton) child).setOnCheckedChangeWidgetListener(null);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(parent, child);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onProvideStructure(ViewStructure structure, int viewFor, int flags) {
        super.onProvideStructure(structure, viewFor, flags);
        if (viewFor == 1) {
            structure.setDataIsSensitive(this.mCheckedId != this.mInitialCheckedId);
        }
    }

    @Override // android.view.View
    public void autofill(AutofillValue value) {
        if (isEnabled()) {
            if (!value.isList()) {
                Log.w(LOG_TAG, ((Object) value) + " could not be autofilled into " + ((Object) this));
                return;
            }
            int index = value.getListValue();
            View child = getChildAt(index);
            if (child == null) {
                Log.w("View", "RadioGroup.autoFill(): no child with index " + index);
            } else {
                check(child.getId());
            }
        }
    }

    @Override // android.view.View
    public int getAutofillType() {
        return isEnabled() ? 3 : 0;
    }

    @Override // android.view.View
    public AutofillValue getAutofillValue() {
        if (!isEnabled()) {
            return null;
        }
        int count = getChildCount();
        for (int i10 = 0; i10 < count; i10++) {
            View child = getChildAt(i10);
            if (child.getId() == this.mCheckedId) {
                return AutofillValue.forList(i10);
            }
        }
        return null;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        if (getOrientation() == 0) {
            info.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, getVisibleChildWithTextCount(), false, 1));
        } else {
            info.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(getVisibleChildWithTextCount(), 1, false, 1));
        }
    }

    private int getVisibleChildWithTextCount() {
        int count = 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            if ((getChildAt(i10) instanceof RadioButton) && isVisibleWithText((RadioButton) getChildAt(i10))) {
                count++;
            }
        }
        return count;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getIndexWithinVisibleButtons(View child) {
        if (!(child instanceof RadioButton)) {
            return -1;
        }
        int index = 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            if (getChildAt(i10) instanceof RadioButton) {
                RadioButton button = (RadioButton) getChildAt(i10);
                if (button == child) {
                    return index;
                }
                if (isVisibleWithText(button)) {
                    index++;
                }
            }
        }
        return -1;
    }

    private boolean isVisibleWithText(RadioButton button) {
        return button.getVisibility() == 0 && !TextUtils.isEmpty(button.getText());
    }
}
