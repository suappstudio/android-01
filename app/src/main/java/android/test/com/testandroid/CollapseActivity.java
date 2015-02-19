package android.test.com.testandroid;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class CollapseActivity extends ActionBarActivity {

    private LinearLayout mRoot;
    private View mCardEditCartaAssoc, mCardNumCert;
    private TextView mNumPP, mNumPPRiep;
    private TextView mDataScadenza;
    private TextView mCvv2;
    private Button mBtProcediAssocia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_layout);


        mCardEditCartaAssoc = findViewById(R.id.card_edit_carta_assoc);
//        mCardNumCert = findViewById(R.id.card_edit_num_da_cert);
        mNumPP = (TextView) findViewById(R.id.num_pp);
        mNumPP.setText("**** **** **** 1234");
        mDataScadenza = (TextView) findViewById(R.id.data_scadenza);
        mCvv2 = (TextView) findViewById(R.id.cvv2);
        mBtProcediAssocia = (Button) findViewById(R.id.bt_procedi_pp_associa);
        mBtProcediAssocia.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                LinearLayout vg = (LinearLayout)findViewById(R.id.ciaocore);
                vg.removeView(mBtProcediAssocia);
                vg.removeView(mCvv2);
                vg.removeView(mDataScadenza);

                LayoutTransition layoutTransition = vg.getLayoutTransition();
                layoutTransition.enableTransitionType(LayoutTransition.CHANGE_DISAPPEARING);
                layoutTransition.addTransitionListener(new LayoutTransition.TransitionListener(){

                    @Override
                    public void endTransition(LayoutTransition arg0, ViewGroup arg1, View arg2, int arg3) {

                    }

                    @Override
                    public void startTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {
                        if(view.getId() == mDataScadenza.getId()) {

                            Toast.makeText(CollapseActivity.this, view.getId()+"", Toast.LENGTH_SHORT).show();

//                            inflate();

                            anima();
                        }
                    }
                });
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    private void anima() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mCardNumCert.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        mCardNumCert.startAnimation(anim);
    }



    private void inflate() {

        mCardNumCert = LayoutInflater.from(this).inflate(R.layout.hidden_card_layout, null);
        mRoot.addView(mCardNumCert);
    }
}
