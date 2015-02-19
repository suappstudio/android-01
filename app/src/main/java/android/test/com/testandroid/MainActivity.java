package android.test.com.testandroid;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import it.poste.menulib.nav.adapter.MenuBaseAdapter;
import it.poste.menulib.nav.adapter.MenuNoDescriptionAdapter;
import it.poste.menulib.nav.command.NavigateCommand;
import it.poste.menulib.nav.helper.FlowHelper;
import it.poste.menulib.nav.menuitem.AuthMenuItem;
import it.poste.menulib.nav.menuitem.MenuItemLib;
import it.poste.menulib.nav.mind.ItemActiveNoAuthMind;
import posteitaliane.posteapp.core.contextconnect.auth.PacAuthenticator;


public class MainActivity extends ActionBarActivity {

    private ArrayList<MenuItemLib> items;
    private MenuBaseAdapter adapter;
    private final boolean evolutionAllowed = true;
    private ListView list;
    private GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(android.R.id.list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position < items.size())
                    items.get(position).navigate();

            }
        });

        initMenu();
    }


    public void initMenu() {

        items = new ArrayList<MenuItemLib>();

        // collapse
        NavigateCommand commCollpase  = new NavigateCommand(this, CollapseActivity.class, this.getClass(), null);
        ItemActiveNoAuthMind mindCollapse = new ItemActiveNoAuthMind(this, null, false);
        MenuItemLib itemCollpase = new AuthMenuItem("Collapse", "MinSDK 8", R.drawable.ab_background_textured_poste, commCollpase, this, null, null, mindCollapse);
        items.add(itemCollpase);

        NavigateCommand commFlip = new NavigateCommand(this, FlipActivity.class, this.getClass(), null);
        ItemActiveNoAuthMind mindFlip = new ItemActiveNoAuthMind(this, null, false);
        MenuItemLib itemFlip = new AuthMenuItem("FLip", "MinSDK 11", R.drawable.ab_background_textured_poste, commFlip, this, null, null, mindFlip);
        items.add(itemFlip);

        FlowHelper.getInstance(this).setListMenuItem(items);

        adapter = new MenuBaseAdapter(items, this);
        list.setAdapter(adapter);
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
}
