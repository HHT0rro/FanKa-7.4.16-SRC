package com.kwad.components.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;
import com.kwad.sdk.n.l;
import com.kwad.sdk.utils.ay;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class KsAutoCloseView extends LinearLayout implements View.OnClickListener {
    private static String Be = "%s秒后自动关闭";
    private TextView acf;
    private ImageView acg;
    private a ach;
    private boolean aci;
    private boolean acj;
    private int countDown;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void de();

        void df();
    }

    public KsAutoCloseView(Context context) {
        super(context);
        this.countDown = 10;
        this.aci = true;
        this.acj = false;
        P(context);
    }

    private void P(Context context) {
        l.inflate(context, R.layout.ksad_auto_close, this);
        this.acf = (TextView) findViewById(R.id.ksad_auto_close_text);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_auto_close_btn);
        this.acg = imageView;
        imageView.setOnClickListener(this);
    }

    public static /* synthetic */ int e(KsAutoCloseView ksAutoCloseView) {
        int i10 = ksAutoCloseView.countDown;
        ksAutoCloseView.countDown = i10 - 1;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i10) {
        this.acf.setText(String.format(Be, Integer.valueOf(i10)));
    }

    public final void U(int i10) {
        if (i10 <= 0) {
            return;
        }
        this.countDown = i10;
        post(new ay() { // from class: com.kwad.components.core.widget.KsAutoCloseView.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                if (KsAutoCloseView.this.aci) {
                    if (KsAutoCloseView.this.acj) {
                        KsAutoCloseView.this.postDelayed(this, 1000L);
                        return;
                    }
                    if (KsAutoCloseView.this.countDown == 0) {
                        if (KsAutoCloseView.this.ach != null) {
                            KsAutoCloseView.this.ach.de();
                        }
                    } else {
                        KsAutoCloseView ksAutoCloseView = KsAutoCloseView.this;
                        ksAutoCloseView.x(ksAutoCloseView.countDown);
                        KsAutoCloseView.e(KsAutoCloseView.this);
                        KsAutoCloseView.this.postDelayed(this, 1000L);
                    }
                }
            }
        });
    }

    public final void aY(boolean z10) {
        this.aci = z10;
        int i10 = z10 ? 0 : 8;
        TextView textView = this.acf;
        if (textView != null) {
            textView.setVisibility(i10);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ach != null && view.equals(this.acg)) {
            this.ach.df();
        }
    }

    public void setCountDownPaused(boolean z10) {
        this.acj = z10;
    }

    public void setViewListener(a aVar) {
        this.ach = aVar;
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.countDown = 10;
        this.aci = true;
        this.acj = false;
        P(context);
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.countDown = 10;
        this.aci = true;
        this.acj = false;
        P(context);
    }

    @RequiresApi(api = 21)
    public KsAutoCloseView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.countDown = 10;
        this.aci = true;
        this.acj = false;
        P(context);
    }
}
