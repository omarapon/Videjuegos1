using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Bala : MonoBehaviour
{
    public float velocity = 15;
    Rigidbody2D rb;
    SpriteRenderer sr;
    GameManager gM;
    float realVelocity;

    public void SetRightDirection()
    {
        realVelocity = velocity;
    }

    public void SetLeftDirection()
    {
        realVelocity = -velocity;
    }

    void Start()
    {
        rb = GetComponent<Rigidbody2D>();
        sr = GetComponent<SpriteRenderer>();
        gM = FindObjectOfType<GameManager>();
        Destroy(this.gameObject, 2);//eliminacion del objeto
    }


    void Update()
    {
        rb.velocity = new Vector2(realVelocity, 0); 
        GirarAnimacion();
    }

    private void GirarAnimacion()
    {
        if(rb.velocity.x < 0)
        {
            sr.flipX = true;
        }
        else if (rb.velocity.x > 0)
        {
            sr.flipX = false;
        }
    }
    public void OnCollisionEnter2D(Collision2D other){
        Destroy(this.gameObject);
        if(other.gameObject.tag=="Enemy"){
            Destroy(other.gameObject);
            Debug.Log("tocando");
            gM.Ganarmonedas();
        }
    }
}
