package com.coinbase.android.settings;

import com.coinbase.v2.models.paymentMethods.Data;
import rx.functions.Action1;

final /* synthetic */ class AccountSettingsPresenter$$Lambda$13 implements Action1 {
    private final AccountSettingsPresenter arg$1;

    private AccountSettingsPresenter$$Lambda$13(AccountSettingsPresenter accountSettingsPresenter) {
        this.arg$1 = accountSettingsPresenter;
    }

    public static Action1 lambdaFactory$(AccountSettingsPresenter accountSettingsPresenter) {
        return new AccountSettingsPresenter$$Lambda$13(accountSettingsPresenter);
    }

    public void call(Object obj) {
        this.arg$1.routeToVerifyAccount((Data) obj);
    }
}
