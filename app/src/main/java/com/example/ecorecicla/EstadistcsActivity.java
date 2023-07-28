package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.ecorecicla.modelos.Aluminum;
import com.example.ecorecicla.modelos.Cardboard;
import com.example.ecorecicla.modelos.Paper;
import com.example.ecorecicla.modelos.Plastic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class EstadistcsActivity extends AppCompatActivity {

     ImageView home;

     TableLayout table;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadistcs);
        home=findViewById(R.id.ivHome);
        table=findViewById(R.id.tableEstadistic);

        Intent homeSection= new Intent(this, HomeActivity.class);

        //Cargar datos a los txt (File)
        File recyclingFile= new File(getFilesDir(), "plastic.txt");
        File paperFile= new File(getFilesDir(), "paper.txt");
        File cardFile= new File(getFilesDir(),"card.txt");
        File aluminumFile= new File (getFilesDir(), "aluminum.txt");

        //Llamado de funciones

        List<Plastic> plasticList = readFile(recyclingFile);
        addElementData(plasticList);
        List<Paper> paperList= readFilePaper(paperFile);
        addPaperData(paperList);
        List <Cardboard> cardList=readFileCard(cardFile);
        addCardData(cardList);
        List <Aluminum> aluminumList=readFileAluminum(aluminumFile);
        addAlumData(aluminumList);



        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(homeSection);
            }
        });
    }


    //Función para inclusión de modelo ( lectura de datos)

    public static List<Plastic> readFile(File file)

    {  //se debe retornar una lista de datos de plástico
        List<Plastic> plasticList= new ArrayList<>();
        //TryCha para defnefir elementos (lectura)
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line; //varible de almaceniamiento

            //Recorrido linea a línea
            while((line= br.readLine())!=null){
                String[] data= line.split(",");
                float kg =Float.parseFloat(data[0]);
                float price=Float.parseFloat(data[1]);
                String month=data[2];
                Plastic plasticObj= new Plastic(kg,price,month);
                plasticList.add(plasticObj);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  plasticList;
    }


    //Función para añadir campos a un tabla.

    public void addElementData(List <Plastic> plasticList){

        //Sección de iteración

        for (Plastic i:plasticList){
            TableRow  row = new TableRow(this);

            TextView cell1= new TextView(this);
            cell1.setText(i.getMonth());
            cell1.setWidth(80);
            cell1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell1.setBackgroundResource(R.color.white);
            TextView cell2= new TextView(this);
            cell2.setText("Plástico");
            cell2.setWidth(90);
            cell2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell2.setBackgroundResource(R.color.white);
            TextView cell3= new TextView(this);
            cell3.setText(String.valueOf(i.getKg()));
            cell3.setWidth(90);
            cell3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell3.setBackgroundResource(R.color.white);
            TextView cell4= new TextView(this);
            cell4.setText(String.valueOf(i.getPrice()));
            cell4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell4.setWidth(70);
            cell4.setBackgroundResource(R.color.white);


            row.addView(cell1);
            row.addView(cell2);
            row.addView(cell3);
            row.addView(cell4);


            table.addView(row);
        }

    }


    //Section paper list

    public static List <Paper> readFilePaper(File file){
        List <Paper> paperList= new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while((line= br.readLine())!=null){
                String[] data= line.split(",");
                float kg =Float.parseFloat(data[0]);
                float price=Float.parseFloat(data[1]);
                String month=data[2];
                Paper paperObj= new Paper(kg,price,month);
                paperList.add(paperObj);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return paperList;
    }

    public void addCardData(List <Cardboard> cardboardList){


        for (Cardboard i:cardboardList){
            TableRow  row = new TableRow(this);

            TextView cell1= new TextView(this);
            cell1.setText(i.getMonth());
            cell1.setWidth(80);
            cell1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell1.setBackgroundResource(R.color.white);
            TextView cell2= new TextView(this);
            cell2.setText("Cartón");
            cell2.setWidth(90);
            cell2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell2.setBackgroundResource(R.color.white);
            TextView cell3= new TextView(this);
            cell3.setText(String.valueOf(i.getKg()));
            cell3.setWidth(90);
            cell3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell3.setBackgroundResource(R.color.white);
            TextView cell4= new TextView(this);
            cell4.setText(String.valueOf(i.getPrice()));
            cell4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell4.setWidth(70);
            cell4.setBackgroundResource(R.color.white);


            row.addView(cell1);
            row.addView(cell2);
            row.addView(cell3);
            row.addView(cell4);


            table.addView(row);
        }

    }

    // Section Cardborad

    public static List <Cardboard> readFileCard (File file){
        List <Cardboard> cardboardList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while ((line= br.readLine()) != null){
                String[] data= line.split(",");
                float volume= Float.parseFloat(data[0]);
                float price= Float.parseFloat(data[1]);
                String month= data[2];
                Cardboard cardObj= new Cardboard(volume,price,month);
                cardboardList.add(cardObj);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return cardboardList;

    }

    public void addPaperData(List <Paper> paperList){


        for (Paper i:paperList){
            TableRow  row = new TableRow(this);

            TextView cell1= new TextView(this);
            cell1.setText(i.getMonth());
            cell1.setWidth(80);
            cell1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell1.setBackgroundResource(R.color.white);
            TextView cell2= new TextView(this);
            cell2.setText("Papel");
            cell2.setWidth(90);
            cell2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell2.setBackgroundResource(R.color.white);
            TextView cell3= new TextView(this);
            cell3.setText(String.valueOf(i.getKg()));
            cell3.setWidth(90);
            cell3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell3.setBackgroundResource(R.color.white);
            TextView cell4= new TextView(this);
            cell4.setText(String.valueOf(i.getPrice()));
            cell4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell4.setWidth(70);
            cell4.setBackgroundResource(R.color.white);


            row.addView(cell1);
            row.addView(cell2);
            row.addView(cell3);
            row.addView(cell4);


            table.addView(row);
        }

    }

    //Section aluminum

    public static  List<Aluminum> readFileAluminum (File file){
        List <Aluminum> aluminumList= new ArrayList<>();
        try (BufferedReader br= new BufferedReader(new FileReader(file))){
            String line;
            while ((line= br.readLine()) != null){
                String[] data= line.split(",");
                float volume= Float.parseFloat(data[0]);
                float price= Float.parseFloat(data[1]);
                String month= data[2];
                Aluminum waterObj= new Aluminum(volume,price,month);
                aluminumList.add(waterObj);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return aluminumList;
    }

    public void addAlumData(List <Aluminum> aluminumList){


        for (Aluminum i:aluminumList){
            TableRow  row = new TableRow(this);

            TextView cell1= new TextView(this);
            cell1.setText(i.getMonth());
            cell1.setWidth(80);
            cell1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell1.setBackgroundResource(R.color.white);
            TextView cell2= new TextView(this);
            cell2.setText("Aluminio");
            cell2.setWidth(90);
            cell2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell2.setBackgroundResource(R.color.white);
            TextView cell3= new TextView(this);
            cell3.setText(String.valueOf(i.getKg()));
            cell3.setWidth(90);
            cell3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell3.setBackgroundResource(R.color.white);
            TextView cell4= new TextView(this);
            cell4.setText(String.valueOf(i.getPrice()));
            cell4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell4.setWidth(70);
            cell4.setBackgroundResource(R.color.white);


            row.addView(cell1);
            row.addView(cell2);
            row.addView(cell3);
            row.addView(cell4);


            table.addView(row);
        }

    }


}