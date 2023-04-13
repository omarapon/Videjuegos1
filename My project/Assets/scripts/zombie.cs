using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class zombie : MonoBehaviour
{
    Rigidbody2D rb;
    const int velocidad = 1;


    // Start is called before the first frame update
    void Start()
    {
        rb = GetComponent<Rigidbody2D>();


    }

    // Update is called once per frame
    void Update()
    {

        rb.velocity = new Vector2(-velocidad, rb.velocity.y);

    }
}
   

