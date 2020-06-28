/*
Author Eric Mason
Sabado, 27 de junio de 2020
Estudiantes

-nombre
-cedula
-notas

+asignarNotas()
+calcularNF()
+mejorEs()
+menoresA60()
+mayoresA71()
+traerNombre()
+traerCed()
+traerN()
*/
import java.util.Arrays;
class Estudiantes{
    private String nombre;
    private String cedula;
    private int notas[];
        
        Estudiantes(String nombre, String cedula, int cantNot){
            this.nombre = nombre;
            this.cedula = cedula;
            notas = new int[cantNot];
        }
        
    public void asignarNotas(int notas, int pos){
        this.notas[pos] = notas;
    }
    
    /*private int[] NotasAltas(){
        int notasA[]=new int[5];
        Arrays.sort(notas)
        for(int i = 0; notasA.length;i++){
            notasA[0] = notas[9-i];
        }
        return notasA;
    }*/
    
    public double calcularNF(){
        Arrays.sort(notas);//Ordenamiento de forma ascendente
        int sum=0;
        double conversion = (double)Math.ceil(notas.length/2);//Se le da el tamaño medio del arreglo, ejemplo: si es 10, entoces converison sera 5 y asi con cualquier otro tamaño
        int tamanio = notas.length - 1;//Como el tamaño lo tengo que puede variar y el arreglo esta ordenado de forma ascendente cree una forma que obterner los valores del mas grandre al mas pequenio
        //Acumulacion de notas altas
        for(int i = 0; i<conversion;i++){
            sum+=notas[tamanio-i];
        }
        
        return sum/conversion;
    }
    
    public static int mejorEs(Estudiantes estudiante[]){
        double mayor=estudiante[0].calcularNF();
        int pos = 0;
        for(int i = 1; i<estudiante.length; i++){
            if(mayor<estudiante[i].calcularNF()){
                mayor = estudiante[i].calcularNF();
                pos = i;
            }
        }
        //Retorno de la posicion del estudiante con mejor nota final
        return pos;
    }
    
    public static int menoresA60(Estudiantes estudiante[]){
        int cont = 0;
        for(int i=0 ; i <estudiante.length; i++){
            if(estudiante[i].calcularNF()<60)
                cont++;
        }//Cuenta la cantidad de estudiantes con nota final menor a 60
        return cont;
    }
    
    public static int mayoresA71(Estudiantes estudiante[]){
        int cont = 0;
        for(int i=0 ; i <estudiante.length; i++){
            if(estudiante[i].calcularNF()>71)
                cont++;
        }
        //Cuenta la cantidad de estudiantes con nota final mayor a 71
        return cont;
    }
    
    public String traerNombre(){
        return nombre;
    }
    
    public String traerCed(){
        return cedula;
    }
    
    public int traerN(int pos){
    	int tamanio = notas.length - 1;
        return notas[tamanio-pos];
    }
    
}

class Main{
    public static void main(String args[]){
        final int SALON = 2;//Canitdad de estudiantes
        final int CANT_NOTAS = 2;//canitdad de notas
        Estudiantes estud[] = new Estudiantes[SALON];
        Leer leamos = new Leer();
        int i, j, calif,pos;
        System.out.println("Bienvenido a su sistema de estado de sus estudiantes");
        
        for(i =0; i<estud.length; i++){
            estud[i] = new Estudiantes(leamos.DatosCad(), leamos.DatosCadCedula(), CANT_NOTAS);
            System.out.println("Notas del estudiante: "+ estud[i].traerNombre());
            for(j=0; j<CANT_NOTAS; j++){
                System.out.print((j+1)+". ");
                estud[i].asignarNotas(leamos.DatosE(), j);
            }
        }
         
        pos = Estudiantes.mejorEs(estud);
        System.out.println("Estudiante con mejor calificacion: "+estud[pos].traerCed());
        System.out.println("Con nota final de : "+estud[pos].calcularNF());
        System.out.println("Sus notas fueron: ");
        for(i = 0; i<CANT_NOTAS; i++){
            System.out.println("\t\t" + estud[pos].traerN(i));
        }  
        
        System.out.println("Hay " + Estudiantes.menoresA60(estud) + " por debajo de 60");
        System.out.println("Hay " + Estudiantes.mayoresA71(estud) + " por arriba de 71");
    }
}