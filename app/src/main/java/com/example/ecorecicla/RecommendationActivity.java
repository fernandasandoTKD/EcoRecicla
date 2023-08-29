package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.example.ecorecicla.modelos.Aluminum;
import com.example.ecorecicla.modelos.Cardboard;
import com.example.ecorecicla.modelos.Paper;
import com.example.ecorecicla.modelos.Plastic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecommendationActivity extends AppCompatActivity {

    ImageView home;
    TableLayout tableRecommendation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);

        home=findViewById(R.id.ivHome);
        tableRecommendation=findViewById(R.id.TableRecommendation);

        File fileAluminum=new File(getFilesDir(), "aluminum.txt");
        File fileCardboard= new File(getFilesDir(), "card.txt");
        File filePaper= new File (getFilesDir(),"paper.txt");
        File filePlastic = new File(getFilesDir(),"plastic.txt");

        //Llegado de listados
            List<Aluminum> aluminumList= new ArrayList<>();
            aluminumList=getAluminum(fileAluminum);

            List<Cardboard> cardboardList=new ArrayList<>();
            cardboardList=getCardboard(fileCardboard);

            List<Plastic> plasticList= new ArrayList<>();
            plasticList= getPlastic(filePlastic);

            List<Paper>paperList = new ArrayList<>();
            paperList=getPaper(filePaper);

            //Anexo de listado a la tabla
        inflateTable(aluminumList,cardboardList,paperList,plasticList);




        Intent homeSection= new Intent(this, HomeActivity.class);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(homeSection);
            }
        });
    }

    public List<Aluminum> getAluminum(File aluminum){
        List<Aluminum> aluminumList= new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(aluminum))){

            //Definición de datos y almacenamiento de estos

            String data;
            //lectura línea a línea del archivo plano que se entrega
            while((data=br.readLine()) !=null){
                //Definiar un arraglo tipo String para relizar el recorrido

                String [] aluminumArray =data.split(",");
                float kg =Float.parseFloat(aluminumArray[0]);
                float price=Float.parseFloat(aluminumArray[1]);
                String month=aluminumArray[2];

                //Creación de objeto de tipo alum y anexo al listado

                Aluminum obj = new Aluminum(kg,price,month);
                aluminumList.add(obj);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return  aluminumList;
    }

    public List<Cardboard> getCardboard(File cardboard){
        List<Cardboard> cardboardList= new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(cardboard))){

            //Definición de datos y almacenamiento de estos

            String data;
            //lectura línea a línea del archivo plano que se entrega
            while((data=br.readLine()) !=null){
                //Definiar un arraglo tipo String para relizar el recorrido

                String [] cardboardArray =data.split(",");
                float kg =Float.parseFloat(cardboardArray[0]);
                float price=Float.parseFloat(cardboardArray[1]);
                String month=cardboardArray[2];

                //Creación de objeto de tipo alum y anexo al listado

                Cardboard obj = new Cardboard(kg,price,month);
                cardboardList.add(obj);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return  cardboardList;

    }

    public List<Paper> getPaper(File paper){
        List<Paper> paperList= new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(paper))){

            //Definición de datos y almacenamiento de estos

            String data;
            //lectura línea a línea del archivo plano que se entrega
            while((data=br.readLine()) !=null){
                //Definiar un arraglo tipo String para relizar el recorrido

                String [] paperArray =data.split(",");
                float kg =Float.parseFloat(paperArray[0]);
                float price=Float.parseFloat(paperArray[1]);
                String month=paperArray[2];

                //Creación de objeto de tipo alum y anexo al listado

                Paper obj = new Paper(kg,price,month);
                paperList.add(obj);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return  paperList;

    }


    public List<Plastic> getPlastic (File plastic){
        List<Plastic> plasticList= new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(plastic))){

            //Definición de datos y almacenamiento de estos

            String data;
            //lectura línea a línea del archivo plano que se entrega
            while((data=br.readLine()) !=null){
                //Definiar un arraglo tipo String para relizar el recorrido

                String [] PlasticArray =data.split(",");
                float kg =Float.parseFloat(PlasticArray[0]);
                float price=Float.parseFloat(PlasticArray[1]);
                String month=PlasticArray[2];

                //Creación de objeto de tipo alum y anexo al listado

                Plastic obj = new Plastic(kg,price,month);
                plasticList.add(obj);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return  plasticList;
    }

    public void inflateTable(List<Aluminum> aluminum, List <Cardboard> cardboard, List <Paper> paper, List <Plastic> plastic){
        //Promedio consumo mensual
        //Promedio consumo anual
        //Consejos de reciclaje
        //Incrememento de precio en KG

        float avarageAluminum=avarageAluminum(aluminum);
        float avarageCardboard=avarageCardboard(cardboard);
        float avaragePaper=avaragePaper(paper);
        float avaragePlastic=avaragePlastic(plastic);

    }

    public float avarageAluminum(List<Aluminum> aluminum){
        float sum = 0;
        //Recorrido del objeto aluminio
        for(Aluminum i: aluminum){
            sum+=i.getKg();
        }
        return sum/aluminum.size();

    }

    public float avarageCardboard(List<Cardboard> cardboard){
        //Recorrido del objeto cartón
        float sum = 0;
        //Recorrido del objeto alum
        for(Cardboard i: cardboard){
            sum+=i.getKg();
        }
        return sum/cardboard.size();
    }

    public float avaragePaper (List<Paper> paper){
        float sum = 0;
        //Recorrido del objeto alum
        for(Paper i: paper){
            sum+=i.getKg();
        }
        return sum/paper.size();
    }
    public float avaragePlastic (List<Plastic> plastic){
        float sum = 0;
        //Recorrido del objeto alum
        for(Plastic i: plastic){
            sum+=i.getKg();
        }
        return sum/plastic.size();
    }


}