El siguiente proyecto interactúa con la API de conversión de divisas (en este caso, ExchangeRate_Api).
Permite a los usuarios seleccionar ciertos datos y realizar consultas de conversión de divisas. Estas conversiones se muestran en pantalla y se almacenan en formato json en archivos para su uso posterior.

Fue desarrollado con java en el IDE de Apache NetBeans IDE 19 y usando la dependencia Gson.jar.

Ejecucion del proyecto, menu de inicio para realizar las conversiones:

![image](https://github.com/Pachanico99/Conversor_Moneda/assets/156742223/b3829009-fbd5-49dc-8dfa-ad7bf0971e01)

Partes del menu de conversiones:

Selectores de divisas:

![image](https://github.com/Pachanico99/Conversor_Moneda/assets/156742223/77076ecc-69ad-498b-b679-185e882016ee)

Botones:
- [Convertir] Realiza la conversion entre las divisas y el importe.
- [Historial] Abre la ventana de historial de conversiones realizadas.

![image](https://github.com/Pachanico99/Conversor_Moneda/assets/156742223/36c3f2cb-ff29-4517-8a58-0ba1780efdbc)

Salida de texto, que muestra la conversion realizada:

![image](https://github.com/Pachanico99/Conversor_Moneda/assets/156742223/d38efd9b-2188-4298-b963-30c69141981a)

Contiene otra interfaz grafica para manejar las conversiones realizadas anteriormente.

![image](https://github.com/Pachanico99/Conversor_Moneda/assets/156742223/97d34831-edca-4c99-b535-0cba7c23e0c4)

La ventana de historial muestra la conversion con informacion reducida, permite extraer las divisas y el importe utilizado en estas, solo tienes que seleccionar que conversion quieres y apretar el boton ingresar.

![image](https://github.com/Pachanico99/Conversor_Moneda/assets/156742223/ad66a525-dbd5-4d7a-8917-1f5cc1b49643)

Si seleccionamos una conversion y apretamos el boton ingresar, se abrira la venta del menu de conversiones y se cargaran los datos que se utilizaron en dicha conversion.

![image](https://github.com/Pachanico99/Conversor_Moneda/assets/156742223/91578c18-2d2a-4c50-8716-afd39e1b4d9e)

Almacenamiento de conversion y divisas admitidas. Estas se guardan en formato json y se utilizar la dependencia Gson para leerlos y guardarlos:
Ej:

![image](https://github.com/Pachanico99/Conversor_Moneda/assets/156742223/03e540c7-7a0a-4cc9-950c-45b62b032ebc)


// *** Proximamente *** //
- Me gustaria implementar el uso de un selector de consultar a api. Para asi elegir que api usar. 


