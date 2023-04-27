using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using TMPro;


public class GameManager : MonoBehaviour
{
    public TMP_Text MonedasrarasTxt;
    public TMP_Text VidaTxt;
    public TMP_Text Balas1Txt;
    public int vida;
    public int cantidad;
    public int balas1;

    // Start is called before the first frame update
    void Start()
    {
        cantidad=0;
        vida=3;
        balas1=15;
        Cambiartexto();

    }
    public int Balas1(){
        return balas1;
    }
    public void Menosbalas(int menos){
        balas1-=menos;
        Cambiartexto();
    }

    public int Cantidad(){
        return cantidad;
    }
    public int Vida(){
        return vida;
    }
    public void Perdervida(){
        vida --;
        Cambiartexto();
    }

    public void Ganarmonedas(){


        cantidad ++;
        Cambiartexto(); 

    }
    private void Cambiartexto(){
        MonedasrarasTxt.text="Monedas:" +cantidad;
        VidaTxt.text="Vidas:"+vida;
        Balas1Txt.text="balas: 15/"+ balas1;    
    }
}

    

