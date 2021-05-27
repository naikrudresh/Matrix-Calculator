package com.example.matrixmultiplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button singleMatrix, duoMatrix, button2x2, button3x3, button4x4, next, submit, resett;
    ArrayList<ArrayList<Integer>> array1 = new ArrayList<ArrayList<Integer> >();
    ArrayList<ArrayList<Integer>> array2 = new ArrayList<ArrayList<Integer> >();

    ConstraintLayout page1, sizee, operation, mat2x2_1, resultMatrix, matrices;

    EditText a00,a01,a10,a11;
    TextView matric, result00, result01, result10, result11;

    public void resett(View view){
        matrices.setVisibility(View.INVISIBLE);
        page1.setVisibility(View.VISIBLE);
        clear();
    }

    public void dispresult(ArrayList<ArrayList<Integer>> arrayList){
        result00.setText(Integer.toString(arrayList.get(0).get(0)));
        result01.setText(Integer.toString(arrayList.get(0).get(1)));
        result10.setText(Integer.toString(arrayList.get(1).get(0)));
        result11.setText(Integer.toString(arrayList.get(1).get(1)));
    }

    public void singleMatrix(View view){



    }

    public void helloduo(View view){
        page1.setVisibility(View.INVISIBLE);
        sizee.setVisibility(View.VISIBLE);

    }

    public void mat2x2(View view){
        sizee.setVisibility(View.INVISIBLE);
        matrices.setVisibility(View.VISIBLE);
        mat2x2_1.setVisibility(View.VISIBLE);
        resultMatrix.setVisibility(View.INVISIBLE);
        submit.setVisibility(View.INVISIBLE);
        matric.setText("MATRIX 1");




        a00.setText(null);
        a01.setText(null);
        a10.setText(null);
        a11.setText(null);


    }

    public  void mat3x3(View view){

    }

    public  void mat4x4(View view){

    }

    public  void mat5x5(View view){

    }

    public void clear(){
        a11.getText().clear();
        a10.getText().clear();
        a01.getText().clear();
        a00.getText().clear();
    }

    public void addition(View view){

        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        for(int i =0; i<2;i++){
            a.add(new ArrayList<Integer>());
            for(int j=0;j<2;j++){
                a.get(i).add(j, array1.get(i).get(j)+array2.get(i).get(j));
            }
        }
        System.out.println(a.toString());

        operation.setVisibility(View.INVISIBLE);
        matrices.setVisibility(View.VISIBLE);

        mat2x2_1.setVisibility(View.INVISIBLE);
        resultMatrix.setVisibility(View.VISIBLE);

        dispresult(a);
        a.clear();

    }

    public void subtract(View view){
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();

        for(int i =0; i<2;i++){
            a.add(new ArrayList<Integer>());
            for(int j=0;j<2;j++){
                a.get(i).add(j, array1.get(i).get(j)-array2.get(i).get(j));
            }
        }
        System.out.println(a.toString());

        operation.setVisibility(View.INVISIBLE);
        matrices.setVisibility(View.VISIBLE);

        mat2x2_1.setVisibility(View.INVISIBLE);
        resultMatrix.setVisibility(View.VISIBLE);

        dispresult(a);

    }

    public void multiply(View view){
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        int [][]b = {{0,0},{0,0}} ;

        for (int i = 0; i < 2; i++) {
            a.add(new ArrayList<Integer>());
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    b[i][j] += array1.get(i).get(k)*array2.get(k).get(j);
                }
                System.out.println(b[i][j]);
                a.get(i).add(j, b[i][j]);
            }

        }

        System.out.println(a.toString());

        operation.setVisibility(View.INVISIBLE);
        matrices.setVisibility(View.VISIBLE);

        mat2x2_1.setVisibility(View.INVISIBLE);
        resultMatrix.setVisibility(View.VISIBLE);

        dispresult(a);
        a.clear();

    }

    public void submit(View view){
        array2.add(new ArrayList<Integer>(Arrays.asList(Integer.parseInt(a00.getText().toString()),Integer.parseInt(a01.getText().toString()))));
        array2.add(new ArrayList<Integer>(Arrays.asList(Integer.parseInt(a10.getText().toString()),Integer.parseInt(a11.getText().toString()))));

        System.out.println(array2.toString());

        matrices.setVisibility(View.INVISIBLE);
        operation.setVisibility(View.VISIBLE);

    }

    public void next(View view){

        matric.setText("MATRIX 2");

        array1.clear();
        array2.clear();

        array1.add(new ArrayList<Integer>(Arrays.asList(Integer.parseInt(a00.getText().toString()),Integer.parseInt(a01.getText().toString()))));
        array1.add(new ArrayList<Integer>(Arrays.asList(Integer.parseInt(a10.getText().toString()),Integer.parseInt(a11.getText().toString()))));

        System.out.println(array1.toString());

        clear();
        submit.setVisibility(View.VISIBLE);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//      Layouts
        page1 = findViewById(R.id.page1);
        sizee = findViewById(R.id.sizee);
        operation = findViewById(R.id.operation);
        mat2x2_1 = findViewById(R.id.mat2x2_1);
        resultMatrix = findViewById(R.id.resultMatrix);
        matrices = findViewById(R.id.matrices);

//      Buttons
        button2x2 = findViewById(R.id.button2x2);
        button3x3 = findViewById(R.id.button3x3);
        button4x4 = findViewById(R.id.button4x4);
        singleMatrix = findViewById(R.id.singleMatrix);
        duoMatrix = findViewById(R.id.duoMatrix);
        next = findViewById(R.id.next);
        submit = findViewById(R.id.submit);


        sizee.setVisibility(View.INVISIBLE);
        operation.setVisibility(View.INVISIBLE);
        matrices.setVisibility(View.INVISIBLE);
        resultMatrix.setVisibility(View.INVISIBLE);

//        EditText
        a00 = (EditText) findViewById(R.id.a00);
        a01 = (EditText) findViewById(R.id.a01);
        a10 = (EditText) findViewById(R.id.a10);
        a11 = (EditText) findViewById(R.id.a11);

        result00 = findViewById(R.id.result00);
        result01 = findViewById(R.id.result01);
        result10 = findViewById(R.id.result10);
        result11 = findViewById(R.id.result11);

        resett = findViewById(R.id.reset);
//        resett.setVisibility(View.INVISIBLE);


//      TextView
        matric = findViewById(R.id.matric);

    }
}