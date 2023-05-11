using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using TMPro;
using System.IO;
using System.Runtime.Serialization.Formatters.Binary; 


public class GameManager : MonoBehaviour
{
    public TMP_Text MonedasrarasTxt;
    public TMP_Text VidaTxt;
    public TMP_Text Balas1Txt;
    public TMP_Text LlaveTxt;
    public int vida;
    public int cantidad;
    public int balas1;
    public int llave;

    // Start is called before the first frame update
    void Start()
    {
        cantidad=0;
        vida=3;
        balas1=15;
        llave=0;
        Cambiartexto();

    }
    public void LLave(){

        llave++;
        LlaveTxt.text="Monedas:" +llave;
       
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


       cantidad++;
        Cambiartexto(); 

    }
     public void SaveGame(){
        var filePath = Application.persistentDataPath + "/game1.dat";
        
        FileStream file;
         
        if (File.Exists(filePath))
            file = File.OpenWrite(filePath);
        else
            file = File.Create(filePath);

        GameData data = new GameData();
        data.cantidad = cantidad;
        //data.Moneda = m2;
        BinaryFormatter bf = new BinaryFormatter();
        bf.Serialize(file, data);
        file.Close();  
    }
    private void Cambiartexto(){
        MonedasrarasTxt.text="puntos:"+ cantidad;
        //LlaveTxt.text="llave:" +cantidad;
        VidaTxt.text="Vidas:"+vida;
        Balas1Txt.text="balas: 15/"+ balas1;    
    }
}

    

