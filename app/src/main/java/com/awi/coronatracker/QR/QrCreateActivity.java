package com.awi.coronatracker.QR;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import com.awi.coronatracker.MainActivity;
import com.awi.coronatracker.R;
import com.github.sumimakito.awesomeqr.AwesomeQrRenderer;
import com.github.sumimakito.awesomeqr.RenderResult;
import com.github.sumimakito.awesomeqr.option.RenderOption;
import com.github.sumimakito.awesomeqr.option.color.Color;


import org.json.JSONObject;

public class QrCreateActivity extends AppCompatActivity {

    int mark = 0;
    int total = 0;
    String id, name;
    private TextView txtMark, txtMessage, txtId, txtName;
    private ImageView imgQr;

   /* public enum Condition {
        SAFE,
        CURE,
        dangerous
    }*/

    private String condition;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_generator);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mark = getIntent().getIntExtra("mark", 0);
        total = getIntent().getIntExtra("total", 0);
        id = getIntent().getStringExtra("id");
        name = getIntent().getStringExtra("name");

        txtMark = findViewById(R.id.txt_mark);
        txtMessage = findViewById(R.id.txt_message);
        txtId = findViewById(R.id.txt_id);
        txtName = findViewById(R.id.txt_name);
        imgQr = findViewById(R.id.img_qr);

        txtName.setText("" + name);
        txtId.setText("Age: " + id);
        txtMark.setText("Your Risk Points : " + mark + " / " + total);

        try {

            /*
            <color name="green">#2B9636</color>
    <color name="yellow">#D38610</color>
    <color name="red">#C9281D</color>
            * */

            Color color = new Color();
            color.setLight(0xFFFFFFFF);
            if (mark >= 10) {
                color.setDark(android.graphics.Color.parseColor("#C9281D")); // for non-blank spaces
                color.setBackground(0xC9281D);
                condition = "dangerous";
                txtMessage.setText(R.string.red_msg);
            } else if (mark >= 5) {
                color.setDark(android.graphics.Color.parseColor("#D38610"));
                color.setBackground(0xD38610);
                condition = "cure";
                txtMessage.setText(R.string.yellow_msg);
            } else {
                color.setDark(android.graphics.Color.parseColor("#2B9636"));
                color.setBackground(0x2B9636);
                condition = "safe";
                txtMessage.setText(R.string.green);
            }



            JSONObject object = new JSONObject();
            object.put("name", name);
            object.put("id", id);
            object.put("mark", mark);
            object.put("condition", condition);

            // for the background (will be overriden by background images, if set)
            color.setAuto(false);

            RenderOption renderOption = new RenderOption();
            renderOption.setContent("" + object.toString()); // content to encode
            renderOption.setSize(800); // size of the final QR code image
            renderOption.setBorderWidth(20); // width of the empty space around the QR code
            //renderOption.setEcl(ErrorCorrectionLevel.M); // (optional) specify an error correction level
            renderOption.setPatternScale(0.35f); // (optional) specify a scale for patterns
            renderOption.setRoundedPatterns(true); // (optional) if true, blocks will be drawn as dots instead
            renderOption.setClearBorder(true); // if set to true, the background will NOT be drawn on the border area

            renderOption.setColor(color); // set a color palette for the QR code
            // renderOption.setBackground();

            RenderResult result = AwesomeQrRenderer.render(renderOption);
            if (result.getBitmap() != null) {
                imgQr.setImageBitmap(result.getBitmap());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}
