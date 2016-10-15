package islandhop.me.bankaccount;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Account acc1;
    Account acc2;

    TextView acc1InitialBal;
    TextView acct2InitialBal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        acc1 = new Account(100.00);
        acc2 = new Account(0.00);

        acc1InitialBal = (TextView) findViewById(R.id.account1BalId);
        String acc1Bal = String.format("Account1 balance: $%.2f", acc1.getBalance());
        acc1InitialBal.setText(acc1Bal);

        acct2InitialBal = (TextView) findViewById(R.id.account2BalId);
        String acc2Bal = String.format("Account2 balance: $%.2f", acc2.getBalance());
        acct2InitialBal.setText(acc2Bal);
    }

    public void account1DepositBtn(View view){
        AccountFragment accountFragment = new AccountFragment();
        accountFragment.show(getSupportFragmentManager(), "account_dialog");
    }

    public void account2DepositBtn(View view){
        Account2Fragment account2Fragment = new Account2Fragment();
        account2Fragment.show(getSupportFragmentManager(), "account2_dialog");
    }
}
