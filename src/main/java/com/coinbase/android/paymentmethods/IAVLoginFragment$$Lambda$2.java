package com.coinbase.android.paymentmethods;

import android.view.View;
import android.view.View.OnClickListener;

final /* synthetic */ class IAVLoginFragment$$Lambda$2 implements OnClickListener {
    private final IAVLoginFragment arg$1;

    private IAVLoginFragment$$Lambda$2(IAVLoginFragment iAVLoginFragment) {
        this.arg$1 = iAVLoginFragment;
    }

    public static OnClickListener lambdaFactory$(IAVLoginFragment iAVLoginFragment) {
        return new IAVLoginFragment$$Lambda$2(iAVLoginFragment);
    }

    public void onClick(View view) {
        this.arg$1.mPresenter.onIAVTypeFormSubmit();
    }
}
