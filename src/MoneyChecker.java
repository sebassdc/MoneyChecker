
public class MoneyChecker {

    public static void main(String[] args) {
        int[] array = {1,2,5, 7};
        for (int i = 1; i <= 18; i++) {
            System.out.println(i+"\t"+calculate(array, i)); // Testing para gente pobre
        }
    }
    
    static String calculate(int[] bills,int amount){
        if (calculateInmersion(bills, amount)){
            return "OK";
        } else{
            return "NO OK";
        }
            
    }
    
    static boolean calculateInmersion(int[] bills,int amount){
        //Si conseguimos que el cambio sea 0, devolvemos true
        if (amount == 0){
            return true;
        } else if (bills.length > 0) {
            //Puede que el número sirva, o que no sirva
            // si sirve restamos a la cantidad dicho número y lo quitamos del array (ya está usado en el cambio)
            // si no sirve lo excluimos del array
            return (calculateInmersion(quitarNumero(bills, bills[0]), amount - bills[0]) ||
                    calculateInmersion(quitarNumero(bills, bills[0]), amount)); //Uso de recursion necesaria para comprobar todas las posibilidades
        } else {
            // El criterio de si sirve o no nuestro numero es que:
            // NO SIRVE SI al restarselo al amount resulta menor que cero
            return false;
        }
    }
    
    static int[] quitarNumero(int[] numeros, int numeroParaQuitar){ // Devuelve un array sin el numero que queremos quitar
        int nuevoArray[] = new int[numeros.length -1]; // El array sera un elemento menos largo que el que ingresa
        int index = 0;
        
        boolean quitado = false; // Para solamente quitar una vez la ocurrencia
        
        for (int numero : numeros){
            if (numero != numeroParaQuitar){
                nuevoArray[index] = numero;
                index ++;
                continue;
            }
            if(quitado){
                nuevoArray[index] = numero;
                index++;
            }else {
                quitado = true;
            }
        }
        
        return nuevoArray;
    }
}
