package com.example.nikola.lecturethreeclassworkcalculator;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    protected String txt;
    protected double operand1, operand2;
    protected byte op = 0;
    protected boolean eqMode = false;
    protected TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView);
        operand1=Integer.MIN_VALUE;
        operand2=Integer.MIN_VALUE;
        txt = "";
        Typeface calculatorFont = Typeface.createFromAsset(getAssets(),"digital7.ttf");
        tv.setTypeface(calculatorFont);
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
    protected void redraw(){
        tv.setText(txt);
    }

    public void operation (View v){
        if(operand1==Integer.MIN_VALUE && operand2==Integer.MIN_VALUE){
            operand1 = Float.parseFloat(txt);
            txt = "";
            redraw();
        }
        switch(v.getId()){
            case R.id.bplus:
                op=1;
                break;
            case R.id.bminus:
                op=2;
                break;
            case R.id.bmulti:
                op=3;
                break;
            case R.id.bdiv:
                op=4;
                break;
        }
    }

    public void equals(View v){
            operand2 = Float.parseFloat(txt);
            if (Math.abs(operand2) < 0.00000001 && op == 4) {
                Toast.makeText(this, "Nan", Toast.LENGTH_LONG).show();
                delete(new View(this));
            } else {
                switch (op) {
                    case 1:
                        txt = "" + ((double) operand1 + operand2);
                        redraw();
                        break;
                    case 2:
                        txt = "" + ((double) operand1 - operand2);
                        redraw();
                        break;
                    case 3:
                        txt = "" + ((double) operand1 * operand2);
                        redraw();
                        break;
                    case 4:
                        txt = "" + ((double) operand1 / operand2);
                        redraw();
                        break;
                }
                operand1 = Float.parseFloat(txt);
                operand2 = Integer.MIN_VALUE;
                txt = "";
            }
    }

    public void number(View v){
        switch(v.getId()){
            case R.id.bone:
                txt=txt+"1";
                redraw();
                break;
            case R.id.btwo:
                txt=txt+"2";
                redraw();
                break;
            case R.id.bthree:
                txt=txt+"3";
                redraw();
                break;
            case R.id.bfour:
                txt=txt+"4";
                redraw();
                break;
            case R.id.bfive:
                txt=txt+"5";
                redraw();
                break;
            case R.id.bsix:
                txt=txt+"6";
                redraw();
                break;
            case R.id.bseven:
                txt=txt+"7";
                redraw();
                break;
            case R.id.beight:
                txt=txt+"8";
                redraw();
                break;
            case R.id.bnine:
                txt=txt+"9";
                redraw();
                break;
            case R.id.bzero:
                txt = txt+"0";
                redraw();
                break;

        }
    }


    public void delete(View view) {
        operand1=Integer.MIN_VALUE;
        operand2=Integer.MIN_VALUE;
        txt="";
        redraw();
    }

    public void addX(View view) {
        txt = txt+"x";
        redraw();
        eqMode=true;
    }

    public void eqadd(View v){
        txt = txt+"+";
        redraw();
        eqMode=true;
    }
    public void eqmin(View v){
        txt = txt+"-";
        eqMode=true;
        redraw();
    }
    public void eqmult(View v){
        txt = txt+"*";
        eqMode=true;
        redraw();
    }
    public void eqdev(View v){
        txt = txt+"+";
        eqMode=true;
        redraw();
    }
    public void eqequals(View v){
        txt=txt+"=";
        eqMode=true;
        redraw();
    }

    public void getCos(View view) {
        double result = Math.cos(Float.parseFloat(txt));
        delete(new View(this));
        tv.setText(""+result);
    }

    public void getSin(View view) {
        double result = Math.sin(Float.parseFloat(txt));
        delete(new View(this));
        tv.setText(""+result);
    }
}

