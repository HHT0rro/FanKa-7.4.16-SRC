package com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.alimm.tanx.core.ad.bean.FeedBackItemBean;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.ToastUtil;
import com.wangmai.appsdkdex.R$id;
import com.wangmai.appsdkdex.R$layout;
import com.wangmai.appsdkdex.R$mipmap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class FeedBackDialog extends tanxc_do implements View.OnClickListener, NotConfused {
    public ImageView ivClose;
    public TextView tvMsg1;
    public TextView tvMsg2;
    public TextView tvMsg3;
    public TextView tvMsg4;
    public TextView tvMsg5;
    public TextView tvMsg6;
    public TextView tvMsg7;
    public TextView tvMsg8;

    public FeedBackDialog(@NonNull Context context, int i10) {
        super(context, i10);
        setContentView(R$layout.dialog_feed_back);
        initView();
        initClick();
    }

    private void initClick() {
        this.tvMsg1.setOnClickListener(this);
        this.tvMsg2.setOnClickListener(this);
        this.tvMsg3.setOnClickListener(this);
        this.tvMsg4.setOnClickListener(this);
        this.tvMsg5.setOnClickListener(this);
        this.tvMsg6.setOnClickListener(this);
        this.tvMsg7.setOnClickListener(this);
        this.tvMsg8.setOnClickListener(this);
        this.ivClose.setOnClickListener(this);
    }

    private void initView() {
        this.tvMsg1 = (TextView) findViewById(R$id.tv_msg1);
        this.tvMsg2 = (TextView) findViewById(R$id.tv_msg2);
        this.tvMsg3 = (TextView) findViewById(R$id.tv_msg3);
        this.tvMsg4 = (TextView) findViewById(R$id.tv_msg4);
        this.tvMsg5 = (TextView) findViewById(R$id.tv_msg5);
        this.tvMsg6 = (TextView) findViewById(R$id.tv_msg6);
        this.tvMsg7 = (TextView) findViewById(R$id.tv_msg7);
        this.tvMsg8 = (TextView) findViewById(R$id.tv_msg8);
        this.ivClose = (ImageView) findViewById(R$id.iv_close);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FeedBackItemBean feedBackItemBean = new FeedBackItemBean();
        int id2 = view.getId();
        if (id2 == R$id.tv_msg1) {
            feedBackItemBean.msg = this.tvMsg1.getText().toString();
        } else if (id2 == R$id.tv_msg2) {
            feedBackItemBean.msg = this.tvMsg2.getText().toString();
        } else if (id2 == R$id.tv_msg3) {
            feedBackItemBean.msg = this.tvMsg3.getText().toString();
        } else if (id2 == R$id.tv_msg4) {
            feedBackItemBean.msg = this.tvMsg4.getText().toString();
        } else if (id2 == R$id.tv_msg5) {
            feedBackItemBean.msg = this.tvMsg5.getText().toString();
        } else if (id2 == R$id.tv_msg6) {
            feedBackItemBean.msg = this.tvMsg6.getText().toString();
        } else if (id2 == R$id.tv_msg7) {
            feedBackItemBean.msg = this.tvMsg7.getText().toString();
        } else if (id2 == R$id.tv_msg8) {
            feedBackItemBean.msg = this.tvMsg8.getText().toString();
        }
        ToastUtil.showShortToast(feedBackItemBean.msg);
        ToastUtil.showToastImg("感谢您的反馈", R$mipmap.ic_star);
        dismiss();
    }
}
