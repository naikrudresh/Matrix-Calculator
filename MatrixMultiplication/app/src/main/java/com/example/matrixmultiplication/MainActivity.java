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

    Button singleMatrix, duoMatrix, button2x2, button3x3,  next, submit, resett, next3, submit3;
    ArrayList<ArrayList<Integer>> array1 = new ArrayList<ArrayList<Integer> >();
    ArrayList<ArrayList<Integer>> array2 = new ArrayList<ArrayList<Integer> >();
    ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer> >();

    ConstraintLayout page1, sizee, operation, mat2x2_1, resultMatrix, matrices, mat3x3, result3x3;

    EditText a00,a01,a10,a11, z00, z01,z02, z10, z11, z12, z20, z21, z22;
    TextView matric, result00, result01, result10, result11, matric3, result300, result301, result302, result310, result311, result312, result320, result321, result322, resultMatric3, matric2;

    int row, col;

    public void resett(View view){
        matrices.setVisibility(View.INVISIBLE);
        mat3x3.setVisibility(View.INVISIBLE);
        page1.setVisibility(View.VISIBLE);
        clear();
    }

    public void dispresult(ArrayList<ArrayList<Integer>> arrayList){
        if (row==2 && col==2) {

            matric2.setText("The Sum");
            result00.setText(Integer.toString(arrayList.get(0).get(0)));
            result01.setText(Integer.toString(arrayList.get(0).get(1)));
            result10.setText(Integer.toString(arrayList.get(1).get(0)));
            result11.setText(Integer.toString(arrayList.get(1).get(1)));
        }
        else if(row==3 && col==3){
            resultMatric3.setText("The Sum");
            result300.setText(Integer.toString((arrayList.get(0).get(0))));
            result301.setText(Integer.toString((arrayList.get(0).get(1))));
            result302.setText(Integer.toString((arrayList.get(0).get(2))));
            result310.setText(Integer.toString((arrayList.get(1).get(0))));
            result311.setText(Integer.toString((arrayList.get(1).get(1))));
            result312.setText(Integer.toString((arrayList.get(1).get(2))));
            result320.setText(Integer.toString((arrayList.get(2).get(0))));
            result321.setText(Integer.toString((arrayList.get(2).get(1))));
            result322.setText(Integer.toString((arrayList.get(2).get(2))));
        }
        row = col = 0;
    }

    public void singleMatrix(View view){



    }

    public void helloduo(View view){
        page1.setVisibility(View.INVISIBLE);
        sizee.setVisibility(View.VISIBLE);

    }

    public void mat2x2(View view){

        row = col = 2;
        sizee.setVisibility(View.INVISIBLE);
        matrices.setVisibility(View.VISIBLE);
        mat2x2_1.setVisibility(View.VISIBLE);
        resultMatrix.setVisibility(View.INVISIBLE);
        submit.setVisibility(View.INVISIBLE);
        matric.setText("MATRIX 1");
        mat3x3.setVisibility(View.INVISIBLE);

        a00.setText(null);
        a01.setText(null);
        a10.setText(null);
        a11.setText(null);


    }

    public  void mat3x3(View view){
        row = col = 3;
        matrices.setVisibility(View.VISIBLE);
        sizee.setVisibility(View.INVISIBLE);

        mat2x2_1.setVisibility(View.INVISIBLE);
        resultMatrix.setVisibility(View.INVISIBLE);
        submit3.setVisibility(View.INVISIBLE);

        mat3x3.setVisibility(View.VISIBLE);
        matric3.setText("MATRIX 1");

        z00.setText(null);
        z01.setText(null);
        z02.setText(null);
        z10.setText(null);
        z11.setText(null);
        z12.setText(null);
        z20.setText(null);
        z21.setText(null);
        z22.setText(null);



    }

   public void add(){
       a.clear();
       for(int i =0; i<row;i++){
           a.add(new ArrayList<Integer>());
           for(int j=0;j<col;j++){
               a.get(i).add(j, array1.get(i).get(j)+array2.get(i).get(j));
           }
       }
   }

    public void clear(){
        a11.getText().clear();
        a10.getText().clear();
        a01.getText().clear();
        a00.getText().clear();

        z00.getText().clear();
        z01.getText().clear();
        z02.getText().clear();
        z10.getText().clear();
        z11.getText().clear();
        z12.getText().clear();
        z20.getText().clear();
        z21.getText().clear();
        z22.getText().clear();
    }

    public void addition(View view){

//        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
//        a.clear();
//        for(int i =0; i<2;i++){
//            a.add(new ArrayList<Integer>());
//            for(int j=0;j<2;j++){
//                a.get(i).add(j, array1.get(i).get(j)+array2.get(i).get(j));
//            }
//        }
        add();
        System.out.println(a.toString());

        operation.setVisibility(View.INVISIBLE);
        matrices.setVisibility(View.VISIBLE);

//        mat2x2_1.setVisibility(View.INVISIBLE);
//        mat3x3.setVisibility(View.INVISIBLE);
        if(row==2 && col==2){
            resultMatrix.setVisibility(View.VISIBLE);
        }
        else if (row==3 && col == 3){
            result3x3.setVisibility(View.VISIBLE);
        }
        dispresult(a);


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
        mat2x2_1.setVisibility(View.INVISIBLE);
        mat3x3.setVisibility(View.INVISIBLE);
        operation.setVisibility(View.VISIBLE);

    }

    public void submit3(View view){
        array2.add(new ArrayList<Integer>(Arrays.asList(Integer.parseInt(z00.getText().toString()),Integer.parseInt(z01.getText().toString()), Integer.parseInt(z02.getText().toString()))));
        array2.add(new ArrayList<Integer>(Arrays.asList(Integer.parseInt(z10.getText().toString()),Integer.parseInt(z11.getText().toString()), Integer.parseInt(z12.getText().toString()))));
        array2.add(new ArrayList<Integer>(Arrays.asList(Integer.parseInt(z20.getText().toString()),Integer.parseInt(z21.getText().toString()), Integer.parseInt(z22.getText().toString()))));

        System.out.println(array2.toString());

        matrices.setVisibility(View.INVISIBLE);
        mat2x2_1.setVisibility(View.INVISIBLE);
        mat3x3.setVisibility(View.INVISIBLE);
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

    public  void next3(View view){
        matric3.setText("Matrix 2");

        array1.clear();
        array2.clear();

        array1.add(new ArrayList<Integer>(Arrays.asList(Integer.parseInt(z00.getText().toString()),Integer.parseInt(z01.getText().toString()), Integer.parseInt(z02.getText().toString()))));
        array1.add(new ArrayList<Integer>(Arrays.asList(Integer.parseInt(z10.getText().toString()),Integer.parseInt(z11.getText().toString()), Integer.parseInt(z12.getText().toString()))));
        array1.add(new ArrayList<Integer>(Arrays.asList(Integer.parseInt(z20.getText().toString()),Integer.parseInt(z21.getText().toString()), Integer.parseInt(z22.getText().toString()))));

        System.out.println(array1.toString());

        clear();
        submit3.setVisibility(View.VISIBLE);
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
        mat3x3 = findViewById(R.id.mat3x3);
        result3x3 = findViewById(R.id.result3x3);

//      Buttons
        button2x2 = findViewById(R.id.button2x2);
        button3x3 = findViewById(R.id.button3x3);

        singleMatrix = findViewById(R.id.singleMatrix);
        duoMatrix = findViewById(R.id.duoMatrix);
        next = findViewById(R.id.next);
        submit = findViewById(R.id.submit);
        submit3 = findViewById(R.id.submit3);
        next3 = findViewById(R.id.next3);

//      Set Visibility Invisible
        sizee.setVisibility(View.INVISIBLE);
        operation.setVisibility(View.INVISIBLE);
        matrices.setVisibility(View.INVISIBLE);
        resultMatrix.setVisibility(View.INVISIBLE);
        result3x3.setVisibility(View.INVISIBLE);


//        EditText
        a00 = (EditText) findViewById(R.id.a00);
        a01 = (EditText) findViewById(R.id.a01);
        a10 = (EditText) findViewById(R.id.a10);
        a11 = (EditText) findViewById(R.id.a11);

        z00 = (EditText) findViewById(R.id.z00);
        z01 = (EditText) findViewById(R.id.z01);
        z02 = (EditText) findViewById(R.id.z02);
        z10 = (EditText) findViewById(R.id.z10);
        z11 = (EditText) findViewById(R.id.z11);
        z12 = (EditText) findViewById(R.id.z12);
        z20 = (EditText) findViewById(R.id.z20);
        z21 = (EditText) findViewById(R.id.z21);
        z22 = (EditText) findViewById(R.id.z22);



        resett = findViewById(R.id.reset);
//        resett.setVisibility(View.INVISIBLE);


//      TextView
        result00 = findViewById(R.id.result00);
        result01 = findViewById(R.id.result01);
        result10 = findViewById(R.id.result10);
        result11 = findViewById(R.id.result11);
        matric = findViewById(R.id.matric);

        matric3 = findViewById(R.id.matric3);

        result300 = findViewById(R.id.result300);
        result301 = findViewById(R.id.result301);
        result302 = findViewById(R.id.result302);
        result310 = findViewById(R.id.result310);
        result311 = findViewById(R.id.result311);
        result312 = findViewById(R.id.result312);
        result320 = findViewById(R.id.result320);
        result321 = findViewById(R.id.result321);
        result322 = findViewById(R.id.result322);

        resultMatric3 = findViewById(R.id.resultMatric3);
        matric2 = findViewById(R.id.matric2);


    }
}