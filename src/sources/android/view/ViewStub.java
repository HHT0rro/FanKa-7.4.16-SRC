package android.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import com.android.internal.R;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
@RemoteViews.RemoteView
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class ViewStub extends View {
    private OnInflateListener mInflateListener;
    private int mInflatedId;
    private WeakReference<View> mInflatedViewRef;
    private LayoutInflater mInflater;
    private int mLayoutResource;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface OnInflateListener {
        void onInflate(ViewStub viewStub, View view);
    }

    public ViewStub(Context context) {
        this(context, 0);
    }

    public ViewStub(Context context, int layoutResource) {
        this(context, (AttributeSet) null);
        this.mLayoutResource = layoutResource;
    }

    public ViewStub(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewStub(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public ViewStub(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context);
        TypedArray a10 = context.obtainStyledAttributes(attrs, R.styleable.ViewStub, defStyleAttr, defStyleRes);
        saveAttributeDataForStyleable(context, R.styleable.ViewStub, attrs, a10, defStyleAttr, defStyleRes);
        this.mInflatedId = a10.getResourceId(2, -1);
        this.mLayoutResource = a10.getResourceId(1, 0);
        this.mID = a10.getResourceId(0, -1);
        a10.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public int getInflatedId() {
        return this.mInflatedId;
    }

    @RemotableViewMethod(asyncImpl = "setInflatedIdAsync")
    public void setInflatedId(int inflatedId) {
        this.mInflatedId = inflatedId;
    }

    public Runnable setInflatedIdAsync(int inflatedId) {
        this.mInflatedId = inflatedId;
        return null;
    }

    public int getLayoutResource() {
        return this.mLayoutResource;
    }

    @RemotableViewMethod(asyncImpl = "setLayoutResourceAsync")
    public void setLayoutResource(int layoutResource) {
        this.mLayoutResource = layoutResource;
    }

    public Runnable setLayoutResourceAsync(int layoutResource) {
        this.mLayoutResource = layoutResource;
        return null;
    }

    public void setLayoutInflater(LayoutInflater inflater) {
        this.mInflater = inflater;
    }

    public LayoutInflater getLayoutInflater() {
        return this.mInflater;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    @RemotableViewMethod(asyncImpl = "setVisibilityAsync")
    public void setVisibility(int visibility) {
        WeakReference<View> weakReference = this.mInflatedViewRef;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view != null) {
                view.setVisibility(visibility);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(visibility);
        if (visibility == 0 || visibility == 4) {
            inflate();
        }
    }

    public Runnable setVisibilityAsync(int visibility) {
        if (visibility == 0 || visibility == 4) {
            ViewGroup parent = (ViewGroup) getParent();
            return new ViewReplaceRunnable(inflateViewNoAdd(parent));
        }
        return null;
    }

    private View inflateViewNoAdd(ViewGroup parent) {
        LayoutInflater factory;
        if (this.mInflater != null) {
            factory = this.mInflater;
        } else {
            factory = LayoutInflater.from(this.mContext);
        }
        View view = factory.inflate(this.mLayoutResource, parent, false);
        int i10 = this.mInflatedId;
        if (i10 != -1) {
            view.setId(i10);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceSelfWithView(View view, ViewGroup parent) {
        int index = parent.indexOfChild(this);
        parent.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            parent.addView(view, index, layoutParams);
        } else {
            parent.addView(view, index);
        }
    }

    public View inflate() {
        ViewParent viewParent = getParent();
        if (viewParent != null && (viewParent instanceof ViewGroup)) {
            if (this.mLayoutResource != 0) {
                ViewGroup parent = (ViewGroup) viewParent;
                View view = inflateViewNoAdd(parent);
                replaceSelfWithView(view, parent);
                this.mInflatedViewRef = new WeakReference<>(view);
                OnInflateListener onInflateListener = this.mInflateListener;
                if (onInflateListener != null) {
                    onInflateListener.onInflate(this, view);
                }
                return view;
            }
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    public void setOnInflateListener(OnInflateListener inflateListener) {
        this.mInflateListener = inflateListener;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class ViewReplaceRunnable implements Runnable {
        public final View view;

        ViewReplaceRunnable(View view) {
            this.view = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewStub viewStub = ViewStub.this;
            viewStub.replaceSelfWithView(this.view, (ViewGroup) viewStub.getParent());
        }
    }
}
