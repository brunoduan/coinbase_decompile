package com.coinbase.android.gdpr;

import rx.functions.Action1;

final /* synthetic */ class GdprPrivacyPolicyPresenter$$Lambda$2 implements Action1 {
    private final GdprPrivacyPolicyPresenter arg$1;

    private GdprPrivacyPolicyPresenter$$Lambda$2(GdprPrivacyPolicyPresenter gdprPrivacyPolicyPresenter) {
        this.arg$1 = gdprPrivacyPolicyPresenter;
    }

    public static Action1 lambdaFactory$(GdprPrivacyPolicyPresenter gdprPrivacyPolicyPresenter) {
        return new GdprPrivacyPolicyPresenter$$Lambda$2(gdprPrivacyPolicyPresenter);
    }

    public void call(Object obj) {
        GdprPrivacyPolicyPresenter.lambda$onAcknowledgeClicked$1(this.arg$1, (Throwable) obj);
    }
}
