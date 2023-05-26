package com.example.posibleexamen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.posibleexamen.Adapters.AnimeAdapter;
import com.example.posibleexamen.animexd. anime;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnimeAdapter adapter= new AnimeAdapter(data());
        RecyclerView mvLista=findViewById(R.id.listaq);
        mvLista.setLayoutManager(new LinearLayoutManager(this));
        mvLista.setAdapter(adapter);



    }
    List<anime> data(){
        List<anime> usuar= new ArrayList<>();
        anime x1=new  anime("Dragon Ball z"," Un guerrero saiyajin, experto en artes marciales que en su infancia inicia sus viajes y aventuras en las que pone a prueba y mejora sus habilidades de pelea.","https://logos-world.net/wp-content/uploads/2021/02/Dragon-Ball-Logo.png",false);
        anime x2=new  anime("Pokemon","Joven entrenador llamado Ash Ketchum, y de Pikachu, su compañero Pokémon, mientras viajan por el mundo Pokémon visitando destinos exóticos, conociendo a montones de personas y Pokémon. ","https://www.pngmart.com/files/5/Anime-Pokemon-PNG-Transparent-Picture.png",false);
        anime x3=new  anime("Bakugan","La historia se centra en las vidas de unas criaturas llamadas Bakugan y los peleadores que las dominan. aventura, fantasía.","https://cf.geekdo-images.com/avLK2knG-arzTBc-2ucozA__imagepage/img/zP5AKth-MAQiHPfZpo9IS4CWmSg=/fit-in/900x600/filters:no_upscale():strip_icc()/pic5380436.png",false);
        anime x4=new  anime("Dorameon","Doraemon es un gato robot cósmico que viene del futuro, es amigo de Novita, un niño muy despistado y algo torpe, al cual ayudara con sus grandiosos inventos futuristas los cuales saca de su bolsillo mágico.","https://w7.pngwing.com/pngs/937/772/png-transparent-doraemon.png",false);
        anime x5=new  anime("Super campeones","Historia tiene como tema central el fútbol, narra las intrépidas aventuras de Tsubasa Ozora.","https://cdn.blog.psafe.com/es/blog/wp-content/uploads/2016/08/psafe-blog-confirmado-los-supercampeones-regresan.png",false);

        usuar.add(x1);
        usuar.add(x2);
        usuar.add(x3);
        usuar.add(x4);
        usuar.add(x5);


        return usuar;

    }
}