using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class NinjaController : MonoBehaviour
{
    public AudioClip JumpSound;
    public AudioClip BulletSound;
    public AudioClip MonedaSound;
    public AudioClip MuertoSound;

    AudioSource audioSource;
    GameManager gM;
    Rigidbody2D rb;
    Animator animator;
    SpriteRenderer sr;
    Collider2D cl;

    const int ANIMATION_QUIETO = 0;
    const int ANIMATION_CORRER = 1;
    const int ANIMATION_THROW = 2;
    const int ANIMATION_ATTACK = 3;
    const int ANIMATION_SLIDE = 4;
    const int ANIMATION_MORIR = 5;

    public GameObject bala;
    bool portalxd =false;
    bool estado = true;
    bool aire = false;
    int velocity = 8;
    int velocitySlide = 2;
    float VelocityJump = 10;
    int cont = 0;

    void Start()
    {
        Debug.Log("Iniciando juego");
        rb = GetComponent<Rigidbody2D>();
        animator = GetComponent<Animator>();
        sr = GetComponent<SpriteRenderer>();
        cl = GetComponent<Collider2D>();
        gM = FindObjectOfType<GameManager>();
        audioSource = GetComponent<AudioSource>();

    }

    void Update()
    {
        if (estado == true)
        {
            if (Input.GetKey(KeyCode.RightArrow))
            {
                Caminarderecha();
                ChangeAnimation(ANIMATION_CORRER);

            }
            else if (Input.GetKey(KeyCode.LeftArrow))
            {
                caminarizquierda();
                ChangeAnimation(ANIMATION_CORRER);
            }
               }
           else  if (Input.GetKeyDown(KeyCode.Space))
            {
                Saltar();
                 animator.SetFloat("VelocityJump", rb.velocity.y);

            }
             if (Input.GetKeyUp(KeyCode.M))
        {
             Disparar();
        }
            
       



     
        //SaltarDoble();
        //CheckGround();
        //GirarAnimacion();
        //Throw();
        //Ataque();
        //Deslizar();
    }
    public void Caminarderecha()
    {
        sr.flipX = false;
        rb.velocity = new Vector2(velocity, rb.velocity.y);
        ChangeAnimation(ANIMATION_CORRER);
    }
    public void caminarizquierda()
    {
        sr.flipX = true;
        rb.velocity = new Vector2(-velocity, rb.velocity.y);
        ChangeAnimation(ANIMATION_CORRER);
    }
    public void quietoctmre(){
        if(estado == true){
  
        
            rb.velocity = new Vector2(0, rb.velocity.y);
           ChangeAnimation(ANIMATION_QUIETO);
        }
        
    }
    public void portal(){
         if( gM.llave == 1 && gM.cantidad == 3 && portalxd)//cambiar escena
        {
            SceneManager.LoadScene(1);
        }
    }
   

    private void Throw()
    {
        if (Input.GetKey(KeyCode.B))
            ChangeAnimation(ANIMATION_THROW);
    }

    private void Ataque()
    {
        if (Input.GetKey(KeyCode.C))
            ChangeAnimation(ANIMATION_ATTACK);

    }
    public void Disparar()
    {
       
            if (sr.flipX == true)
            {//disparar hacia la izquierda
                var BalasPosition = transform.position + new Vector3(-3, 0, 0);
                var gb = Instantiate(bala, BalasPosition, Quaternion.identity) as GameObject;
                //llamar bala, posicion bala , direcion bala
                var controller = gb.GetComponent<Bala>();
                controller.SetLeftDirection();
                audioSource.PlayOneShot(BulletSound);
            }

            if (sr.flipX == false)
            {//disparar hacia la derecha
                var BalasPosition = transform.position + new Vector3(3, 0, 0);
                var gb = Instantiate(bala, BalasPosition, Quaternion.identity) as GameObject;
                //llamar bala, posicion bala , direcion bala
                var controller = gb.GetComponent<Bala>();
                controller.SetRightDirection();
                audioSource.PlayOneShot(BulletSound);


            }
            gM.Menosbalas(1);
        

    }

    private void Deslizar()
    {
        if (Input.GetKey(KeyCode.RightArrow) && Input.GetKey(KeyCode.Z))
        {
            rb.velocity = new Vector2(velocitySlide, rb.velocity.y);
            ChangeAnimation(ANIMATION_SLIDE);
        }
        else if (Input.GetKey(KeyCode.LeftArrow) && Input.GetKey(KeyCode.Z))
        {
            rb.velocity = new Vector2(-velocitySlide, rb.velocity.y);
            ChangeAnimation(ANIMATION_SLIDE);
        }
    }

    private void Morir()
    {
        estado = false;
        ChangeAnimation(ANIMATION_MORIR);
        
    }

    public void Saltar()
    {

        if (!cl.IsTouchingLayers(LayerMask.GetMask("Plataforma"))) { return; }
        // if (Input.GetKeyDown(KeyCode.Space))
        // {
        rb.velocity = new Vector2(rb.velocity.x, VelocityJump);
        audioSource.PlayOneShot(JumpSound);
        animator.SetFloat("VelocityJump", rb.velocity.y);
        //}
    }

    public void SaltarDoble()
    {
        if (aire)
        {
            Debug.Log(cont);
            if (!cl.IsTouchingLayers(LayerMask.GetMask("Plataforma")))
            {
                if (Input.GetKeyDown(KeyCode.V) && cont > 0)
                {
                    rb.velocity = new Vector2(rb.velocity.x, VelocityJump + 4);
                    cont--;
                }
            }
        }
    }
    private void OnCollisionEnter2D(Collision2D other)
    {
        if (other.gameObject.tag == "Enemy")
        {

            gM.Perdervida();
            if (gM.Vida() == 0)
            {
                Debug.Log("Parar todo");
                Morir();
                audioSource.PlayOneShot(MuertoSound);
            }

        }
        if (other.gameObject.tag == "llave")
        {
            Destroy(other.gameObject);
            gM.LLave();
            audioSource.PlayOneShot(MonedaSound);
        }

    }


    private void OnTriggerEnter2D(Collider2D other)
    {
        if (other.gameObject.tag == "salto1") ;
        {
            velocity = velocity + 3;
            Debug.Log(velocity);
        }
        if (other.gameObject.tag == "Enemy")
        {
            Destroy(other.gameObject);
           
        }
        

    }
    private void OnTriggerStay2D(Collider2D other){
      portalxd=true;


    }
 private void OnTriggerExit2D(Collider2D other){
      portalxd=false;
      
    }
    private void CheckGround()
    {
        if (cl.IsTouchingLayers(LayerMask.GetMask("Plataforma")))
        {
            animator.SetBool("isGround", true);
        }
        else
        {
            animator.SetBool("isGround", false);
            aire = true;
        }
    }

    private void ChangeAnimation(int animation)
    {
        animator.SetInteger("Estado", animation);
    }

    private void GirarAnimacion()
    {
        if (rb.velocity.x < 0)
        {
            sr.flipX = true;
        }
        else if (rb.velocity.x > 0)
        {
            sr.flipX = false;
        }
    }
}

