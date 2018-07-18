package com.coinbase.android.deposits.fiat;

import com.coinbase.android.confirmation.ConfirmationDetailListAdapter.ConfirmationDetail;
import com.coinbase.android.ui.ActionBarController;
import java.util.List;

interface WithdrawFiatConfirmationScreen {
    void disableConfirmButton();

    void displayFeeHelpUrl(String str);

    void enableConfirmButton();

    ActionBarController getController();

    void hideProgressDialog();

    void hideWorldPayInfo();

    void setButtonText(String str);

    void setDetailList(List<ConfirmationDetail> list);

    void setWithdrawalAmount(String str);

    void showProgressDialog(String str);

    void showWorldPayInfo();
}
