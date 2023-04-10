using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class NinjaController : MonoBehaviour
{
    public float xVelocity= 10f;
    public float JumpForce=400f;
    Rigidbody2D rb;
    Animator animator;
    SpriteRenderer sr;
    const int ANIMATION_QUIETO = 0;
    const int ANIMATION_CORRER = 6;
    const int ANIMATION_THROW = 4;
    const int ANIMATION_ATTACK = 3;
    const int ANIMATION_SLIDE = 1;
    const int ANIMATION_MORIR = 5;
    const int ANIMATION_SALTAR=2;
     bool estado = true;


    // Start is called before the first frame update
    void Start()
    {
         Debug.Log("Iniciando juego");
        rb = GetComponent<Rigidbody2D>();
        animator = GetComponent<Animator>();
        sr = GetComponent<SpriteRenderer>();

    }

    // Update is called once per frame
    void Update()
    {
         if(estado == true)
        {
            Caminar();
            //GirarAnimacion();
            
            Ataque();
            Throw();
            Deslizar();
            Morir();

            
        }
    
        if(Input.GetKeyUp(KeyCode.Space))
        rb.AddForce(transform.up * JumpForce);
    }
    private void Caminar()
    {
        if(Input.GetKey(KeyCode.RightArrow))
        {
            rb.velocity = new Vector2(3, rb.velocity.y);
            ChangeAnimation(ANIMATION_CORRER);
            sr.flipX = false;
        }
        else if(Input.GetKey(KeyCode.LeftArrow))
        {
            rb.velocity = new Vector2(-3, rb.velocity.y);
            ChangeAnimation(ANIMATION_CORRER);
            sr.flipX = true;

        }
        else 
        {
            rb.velocity = new Vector2(0, rb.velocity.y);
            ChangeAnimation(ANIMATION_QUIETO);
        }
        Morir();
    }

    private void Throw()
    {
        if(Input.GetKey(KeyCode.Z))
            ChangeAnimation(ANIMATION_THROW);
    }

    private void Ataque()
    {
        if(Input.GetKey(KeyCode.X))
            ChangeAnimation(ANIMATION_ATTACK);
    }
    
    private void Deslizar()
    {
        if(Input.GetKey(KeyCode.RightArrow) && Input.GetKey(KeyCode.B))
        {
            rb.velocity = new Vector2(4, rb.velocity.y);
            ChangeAnimation(ANIMATION_SLIDE);
        }
        else if(Input.GetKey(KeyCode.LeftArrow) && Input.GetKey(KeyCode.B))
        {
            rb.velocity = new Vector2(-4, rb.velocity.y);
            ChangeAnimation(ANIMATION_SLIDE);
        }
    }

   

    private void Morir()
    {
        if(Input.GetKey(KeyCode.P))
        {
            estado = false;
            ChangeAnimation(ANIMATION_MORIR);
        }
            
    }

    private void ChangeAnimation(int animation)
    {
        animator.SetInteger("Estado", animation);
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
}