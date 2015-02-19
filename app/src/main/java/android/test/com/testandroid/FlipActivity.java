package android.test.com.testandroid;

import android.animation.AnimatorInflater;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;



public class FlipActivity extends ActionBarActivity {

    private View mCardEditCartaAssoc, mCardRiepCartaAssoc, mCardNumCert;
    private Button mBtProcediAssocia;
    private Animation animation1, animation2;

    private boolean isBackOfCardShowing = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_layout);

        mCardEditCartaAssoc = findViewById(R.id.card_edit_carta_assoc);
        mCardRiepCartaAssoc = findViewById(R.id.card_riep_carta_assoc);
        mCardNumCert = findViewById(R.id.card_edit_num_da_cert);

        mBtProcediAssocia = (Button) findViewById(R.id.bt_procedi_pp_associa);
        mBtProcediAssocia.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(FlipActivity.this, R.animator.flipping);
                anim.setTarget(mCardEditCartaAssoc);
                anim.setDuration(1000);
                anim.start();



















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

    }
}
