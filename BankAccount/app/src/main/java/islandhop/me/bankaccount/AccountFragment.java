package islandhop.me.bankaccount;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class AccountFragment extends DialogFragment {


    public AccountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.account_dialog, container, false);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        // Pass account1 value to AccountFragment
        final Account account1 = ((MainActivity)getActivity()).acc1;


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.account_dialog, null);

        builder.setView(view)
                .setTitle(R.string.account1_dialog_title)
                .setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText accountValue = (EditText) view.findViewById(R.id.account1ValueId);

                        account1.credit(Double.parseDouble(accountValue.getText().toString()));

                        // Pass account balance back to activity and update the account1 label
                        TextView account1TextView = ((MainActivity)getActivity()).acc1InitialBal;
                        account1TextView.setText(String.format("Account1 balance: $%.02f", account1.getBalance()));
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AccountFragment.this.getDialog().cancel();
                    }
                });

        return builder.create();
    }


}
