using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SalidaController : MonoBehaviour
{
 public GameObject zombie;
    float tiempo=0;

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        tiempo+=Time.deltaTime;
        if(tiempo>=5 && tiempo <=6){
            Generacion();
            tiempo=0;

        }
        
    }
    private void Generacion(){
        var portalPosition=transform.position+new  Vector3(-3,0,0);
        var gb= Instantiate(zombie,portalPosition,Quaternion.identity) as GameObject;
        var controller=gb.GetComponent<SalidaController>();
    }
}
