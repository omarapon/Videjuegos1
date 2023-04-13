using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CamaraController : MonoBehaviour
{
    public Transform target;
    public Vector3 offset;
    [Range (1,10)]
    public float smootherFactor;


    // Update is called once per frame
    void Update()
    {
        var targetPosition = target.position + offset;
        var smootherPosition = Vector3.Lerp(transform.position, targetPosition, smootherFactor * Time.fixedDeltaTime);
        transform.position = smootherPosition;
    }
}
