using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class CambioP : MonoBehaviour
{
    public GameObject Player;
    public GameObject NinjaHombre;
    GameObject ayuda;
    GameManager gM;
    bool cambio=true;

    // Start is called before the first frame update
    void Start()
    {
         gM = FindObjectOfType<GameManager>();
    }

    // Update is called once per frame
   public  void StartGame()
    {
         if(cambio==false)
    {
           SceneManager.LoadScene(1);
           
}
        else
        {
          SceneManager.LoadScene(1);
        }
       
        
    }
    public void  cambiopersonaje(){
        if(cambio==true){

             GameObject ayuda;
            ayuda = GameObject.Find("Player(Clone)");
            Destroy(ayuda.gameObject);
            var PlayerPosition = new Vector3(0.21f,0.74f,0f);
            var gb = Instantiate(Player, PlayerPosition, Quaternion.identity) as GameObject;
        }
         else
        {
            GameObject ayuda;
            ayuda = GameObject.Find("NinjaHombre(Clone)");
            Destroy(ayuda.gameObject);
            var PlayerPosition = new Vector3(0.21f,0.74f,0f);
            var gb = Instantiate(NinjaHombre, PlayerPosition, Quaternion.identity) as GameObject;
        }
    }
     public void CambioDerecha()
    {
        cambio=! cambio;
        cambiopersonaje();
    }
    public void scena2(){
        if(gM.cantidad>5){
             SceneManager.LoadScene(1);
        }


    }
    public void scena3(){
        if(gM.cantidad>10){
        SceneManager.LoadScene(1);
        }

    }
}
