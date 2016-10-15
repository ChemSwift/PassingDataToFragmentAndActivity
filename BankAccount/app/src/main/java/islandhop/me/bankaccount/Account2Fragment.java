package islandhop.me.bankaccount;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Account2Fragment extends DialogFragment {


    public Account2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.account2_dialog, container, false);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        final Account account2 = ((MainActivity)getActivity()).acc2;

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.account2_dialog, null);

        builder.setView(view)
                .setTitle(R.string.account2_dialog_title)
                .setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText accountValue = (EditText) view.findViewById(R.id.account2ValueId);
                        account2.credit(Double.parseDouble(accountValue.getText().toString()));

                        TextView account2TextView = ((MainActivity)getActivity()).acct2InitialBal;
                        account2TextView.setText(String.format("Account2 balance: $%.2f", account2.getBalance()));
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Account2Fragment.this.getDialog().cancel();
                    }
                });

        return builder.create();
    }

}
