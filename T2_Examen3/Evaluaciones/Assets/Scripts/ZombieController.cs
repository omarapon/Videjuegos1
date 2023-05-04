using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ZombieController : MonoBehaviour
{
    float velocity = 3;
    Rigidbody2D rb;
    Animator animator;
    GameManager gM;
    SpriteRenderer sr;
    public int vida=2;
    bool estado = true;
    const int ANIMATION_QUIETO = 1;
    const int ANIMATION_CORRER = 0;

    void Start()
    {
        rb = GetComponent<Rigidbody2D>();
        sr = GetComponent<SpriteRenderer>();
        animator = GetComponent<Animator>();
        gM = FindObjectOfType<GameManager>();
    }


    void Update()
    {
        if(estado == true)
        {
            rb.velocity = new Vector2(-velocity, rb.velocity.y);
            GirarAnimacion();
        }
    }

    private void GirarAnimacion()
    {
        if(rb.velocity.x < 0)
        {
            sr.flipX = false;
        }
        else if(rb.velocity.x > 0)
        {
            sr.flipX = true;
        }
    }

    private void Morir()
    {
        estado = false;
        rb.velocity = new Vector2(0, rb.velocity.y);
        ChangeAnimation(ANIMATION_QUIETO);
    }


     private void OnCollisionEnter2D(Collision2D other) 
    {
        if(other.gameObject.name == "Player")
        {
            Debug.Log("Parar enemigo");
            Morir();
        }
         if(other.gameObject.tag == "kunai")

        {
            Destroy(other.gameObject);
            vida-=1;
            if(vida ==0){
            Destroy(this.gameObject);
            gM.Ganarmonedas();
            
            }
        }
    } 
    private void ChangeAnimation(int animation)
    {
        animator.SetInteger("Estado", animation);
    }
}
