package learning.shinesdev.mylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ShioAdapter mAdapter;

    String dataShioName [];
    String dataShioDesc [];
    TypedArray dataShioImage;
    ArrayList<ShioModel> mShio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listView = findViewById(R.id.lv_list);
        mAdapter = new ShioAdapter(this);
        listView.setAdapter(mAdapter);

        init();
        addDataItem();


    }

    private void init() {
        dataShioName = getResources().getStringArray(R.array.shio_data_name);
        dataShioDesc = getResources().getStringArray(R.array.shio_data_description);
        dataShioImage =getResources().obtainTypedArray(R.array.shio_data_photo);
    }

    private void addDataItem() {
        mShio = new ArrayList<>();
        for (int i = 0; i < dataShioName.length; i++) {
            ShioModel shio = new ShioModel();
            shio.setImage(dataShioImage.getResourceId(i, -1));
            shio.setName(dataShioName[i]);
            shio.setDesc(dataShioDesc[i]);
            mShio.add(shio);
        }
        mAdapter.setShio(mShio);
    }
}
